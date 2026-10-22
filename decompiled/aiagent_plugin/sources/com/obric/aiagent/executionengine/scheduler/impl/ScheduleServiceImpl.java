package com.obric.aiagent.executionengine.scheduler.impl;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.util.Log;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.JsonObject;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.executionengine.scheduler.impl.job.d;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.capabilitykit.common.AppAction;
import com.obric.capabilitykit.common.ICapabilityFeedbackReceiver;
import com.obric.capabilitykit.common.ICapabilitySchedule;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IQueryAppIntentsCallback;
import com.obric.capabilitykit.common.ToolType;
import com.obric.capabilitykit.corecommon.JsonParserExt;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.m;
import d.n;
import d.o;
import d.s;
import d.x;
import java.util.HashMap;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ScheduleServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ScheduleServiceImpl extends PluginService {
    public static final a Companion = null;
    public static final String TAG = "ScheduleServiceImpl";
    private static final int VERSION = 1;
    private final ScheduleBinder binder;

    /* JADX INFO: compiled from: ScheduleServiceImpl.kt */
    public final class ScheduleBinder extends ICapabilitySchedule.Stub {
        private HashMap<String, b> redirectionPkgMap;
        final /* synthetic */ ScheduleServiceImpl this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public ScheduleBinder(ScheduleServiceImpl r5) {
            this.this$0 = (ScheduleServiceImpl) ZeusTransformUtils.wrapperContextForParams(r5, ScheduleServiceImpl.class, "com.obric.aiagent.plugin");
            int r3 = 2;
            this.redirectionPkgMap = ao.c(new m[]{s.a("com.android.settings", new b("com.obric.settings", null, r3, 0 == true ? 1 : 0)), s.a("com.android.calendar", new b("com.obric.calendar", 0 == true ? 1 : 0, r3, 0 == true ? 1 : 0)), s.a("com.android.deskclock", new b("com.obric.clock", 0 == true ? 1 : 0, r3, 0 == true ? 1 : 0))});
        }

        @Override // com.obric.capabilitykit.common.ICapabilitySchedule
        public void dispatchServerActions(String r8, boolean r9) {
            if (checkTrustedCaller("dispatchServerActions") == true) goto L5;
            return;
        L5:
            ISecureLogDepend.Companion.i(ScheduleServiceImpl.TAG, "dispatchServerActions " + r8 + ' ' + r9);
            IMAppAction r10 = preProcessAction(r8);     // Catch: Exception -> L8
        L7:
            IMAppAction r1 = r10;
            if (r1 == null) goto L15;
            d.a(d.f18489a, r1, true, false, com.obric.aiagent.executionengine.utils.b.f18566a.a((Context) ZeusTransformUtils.preCheckCast(this.this$0, Context.class, "com.obric.aiagent.plugin")), 4, null);
            return;
        L15:
            return;
        L8:
            e = move-exception;
            e.printStackTrace();
            ILogDepend.Companion.i(ScheduleServiceImpl.TAG, "dispatchServerActions; e = " + e);
            r10 = null;
            goto L7
        }

        @Override // com.obric.capabilitykit.common.ICapabilitySchedule
        public void queryAppIntents(String r3, IQueryAppIntentsCallback r4) {
            IQueryAppIntentsCallback r5 = (IQueryAppIntentsCallback) ZeusTransformUtils.wrapperContextForParams(r4, IQueryAppIntentsCallback.class, "com.obric.aiagent.plugin");
            if (checkTrustedCaller("queryAppIntents") == false) goto L17;
            d.f18489a.a(r3, r5);
            return;
        L17:
            n.a r6 = n.f38560a;     // Catch: Throwable -> L9
            ScheduleBinder r2 = (ScheduleBinder) ZeusTransformUtils.preCheckCast(this, ScheduleBinder.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            x r7 = null;
            if (r5 == null) goto L7;
            r5.onResult(null);     // Catch: Throwable -> L9
            r7 = x.f38692a;     // Catch: Throwable -> L9
        L7:
            Object r8 = n.f(r7);     // Catch: Throwable -> L9
        L11:
            Throwable r9 = n.c(r8);
            if (r9 == null) goto L19;
            ILogDepend.Companion.w(ScheduleServiceImpl.TAG, "queryAppIntents unauthorized callback failed", r9);
            return;
        L19:
            return;
        L9:
            th = move-exception;
            n.a r10 = n.f38560a;
            r8 = n.f(o.a(th));
            goto L11
        }

        @Override // com.obric.capabilitykit.common.ICapabilitySchedule
        public void registerActionsResultReceiver(ICapabilityFeedbackReceiver r4) {
            ICapabilityFeedbackReceiver r5 = (ICapabilityFeedbackReceiver) ZeusTransformUtils.wrapperContextForParams(r4, ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin");
            if (checkTrustedCaller("registerActionsResultReceiver") == true) goto L5;
            return;
        L5:
            String r3 = com.obric.aiagent.executionengine.utils.b.f18566a.a((Context) ZeusTransformUtils.preCheckCast(this.this$0, Context.class, "com.obric.aiagent.plugin"));
            ILogDepend.Companion.i(ScheduleServiceImpl.TAG, "registerActionsResultReceiver " + r3);
            if (r5 == null) goto L9;
            d.f18489a.a(r5, r3);
            return;
        }

        private final IMAppAction preProcessAction(String r27) {
            IMAppAction r2 = (IMAppAction) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r27, IMAppAction.class), IMAppAction.class, "com.obric.aiagent.plugin");
            r2.setActionId(r2.getId());
            if (r2.getVersionInfo().getVersion() < 2) goto L6;
            r2.setVersion(r2.getVersionInfo().getVersion());
            return r2;
        L6:
            String r3 = null;
            if (r2 == null) goto L69;
            AppAction r6 = r2.getAction();
            String r7 = r6.getPackageName();
            String r8 = r6.getAction();
            boolean r14 = true;
            if (this.redirectionPkgMap.get(r7) == null) goto L17;
            b r9 = this.redirectionPkgMap.get(r7);
            d.h.b.o.a(r9);
            if (((b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin")).b() != null) goto L13;
            PackageManager r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager();
            com.obric.aiagent.executionengine.scheduler.impl.a.d r11 = com.obric.aiagent.executionengine.scheduler.impl.a.d.f18035a;
            d.h.b.o.a(r10);
            List<String> r12 = r11.a(r10);
            b r13 = this.redirectionPkgMap.get(r7);
            d.h.b.o.a(r13);
            ((b) ZeusTransformUtils.preCheckCast(r13, b.class, "com.obric.aiagent.plugin")).a(Boolean.valueOf(!r12.contains(r7)));
        L13:
            b r15 = this.redirectionPkgMap.get(r7);
            d.h.b.o.a(r15);
            if (d.h.b.o.a(((b) ZeusTransformUtils.preCheckCast(r15, b.class, "com.obric.aiagent.plugin")).b(), true) == false) goto L17;
            b r0 = this.redirectionPkgMap.get(r7);
            d.h.b.o.a(r0);
            r7 = ((b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin")).a();
        L17:
            if (d.o.o.b(r8, "sc_", false, 2, null) == false) goto L19;
        L22:
            boolean r16 = true;
        L24:
            if (r6.getType() != ToolType.INTENT.ordinal()) goto L26;
            boolean r17 = true;
        L27:
            if (r17 == false) goto L30;
            String r18 = "IntentAction";
        L29:
            String r19 = r18;
        L33:
            if (r16 == false) goto L48;
            CharSequence r20 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.getAction().getShortcutId(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r20 != null) goto L37;
        L40:
            boolean r21 = true;
        L41:
            if (r21 == true) goto L45;
            String r1 = r2.getAction().getShortcutId();
        L43:
            r3 = r1;
            goto L48
        L45:
            if (d.o.o.b(r6.getAction(), "sc_", false, 2, null) == false) goto L47;
            r1 = d.o.o.a(r8, "sc_", "", false, 4, null);
            goto L43
        L47:
            r3 = r8;
            goto L48
        L37:
            if (r20.length() == 0) goto L40;
            r21 = false;
        L48:
            ILogDepend.Companion.i(ScheduleServiceImpl.TAG, r7);
            JsonObject r4 = new JsonObject();
            String r22 = r6.getParams();     // Catch: Exception -> L58
            CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L58
            if (r5 != null) goto L52;
        L55:
            if (r14 == true) goto L60;
            r4 = JsonParserExt.INSTANCE.parseString(r22).getAsJsonObject();     // Catch: Exception -> L58
            d.h.b.o.c(r4, "getAsJsonObject(...)");     // Catch: Exception -> L58
        L60:
            if (r6.getIntent() == null) goto L62;
            r4.addProperty(MemorySourceLinkType.INTENT, r6.getIntent());
        L62:
            if (r3 == null) goto L64;
            r4.addProperty(DbHelper.COL_ID, r3);
        L64:
            if (r16 == true) goto L66;
            if (r17 == true) goto L66;
        L67:
            String r23 = r4.toString();
            d.h.b.o.c(r23, "toString(...)");
            String r110 = r7;
            String r111 = r19;
            String r24 = r3;
            r2.setContent(com.obric.capabilitykit.common.a.a().toJson(new AppAction(r110, r111, r23, r6.getIntent(), r6.getType(), r24, r6.getInterfaceName(), r6.getTargetPkgName(), r6.getLogPb(), r6.getImplClassName())));
            return new IMAppAction(r2.getId(), r2.getMessageId(), r2.getLocalMessageId(), r2.getReplyId(), r2.getQuestionId(), r2.getCreateTime(), r2.getContent(), r2.getMessageType(), r2.getActionId(), r2.getJobId(), r2.getVersion(), r2.getExt());
        L66:
            ILogDepend.Companion.i(ScheduleServiceImpl.TAG, "Shortcut or Intent, set packageName");
            r4.addProperty("packageName", r6.getPackageName());
            goto L67
        L52:
            if (r5.length() == 0) goto L55;
            r14 = false;
        L58:
            r4 = JsonParserExt.INSTANCE.parseString("{}").getAsJsonObject();
            d.h.b.o.c(r4, "getAsJsonObject(...)");
            goto L60
        L30:
            if (r16 == false) goto L32;
            r18 = "ShortcutAction";
            goto L29
        L32:
            r19 = r8;
            goto L33
        L26:
            r17 = false;
            goto L27
        L19:
            if (r6.getType() == ToolType.SHORTCUT.ordinal()) goto L22;
            r16 = false;
            goto L24
        L69:
            return null;
        }

        private final boolean checkTrustedCaller(String r4) {
            com.obric.aiagent.utils.c.b.a r3 = com.obric.aiagent.utils.c.b.f22336a.a((Context) ZeusTransformUtils.preCheckCast(this.this$0, Context.class, "com.obric.aiagent.plugin"), "ScheduleService." + r4);
            if (r3.a() == true) goto L6;
            ILogDepend.Companion.w(ScheduleServiceImpl.TAG, "unauthorized ScheduleService." + r4 + ", reason=" + r3.d());
        L6:
            return r3.a();
        }
    }

    /* JADX INFO: compiled from: ScheduleServiceImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ScheduleServiceImpl.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f17965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Boolean f17966b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f17965a, r6.f17965a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f17966b, r6.f17966b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f17965a.hashCode() * 31;
            Boolean r1 = this.f17966b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "RedirectionInfo(packageName=" + this.f17965a + ", needredirction=" + this.f17966b + ')';
        }

        public b(String r2, Boolean r3) {
            d.h.b.o.e(r2, "packageName");
            this.f17965a = r2;
            this.f17966b = r3;
        }

        public /* synthetic */ b(String r1, Boolean r2, int r3, h r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }

        public final String a() {
            return this.f17965a;
        }

        public final void a(Boolean r1) {
            this.f17966b = r1;
        }

        public final Boolean b() {
            return this.f17966b;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public ScheduleServiceImpl() {
        this.binder = new ScheduleBinder(this);
    }

    public IBinder onBind(Intent r3) {
        ILogDepend.Companion.i(TAG, "onBind");
        return (IBinder) ZeusTransformUtils.preCheckCast(this.binder, IBinder.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*android.app.Service*/.onDestroy();
        ILogDepend.Companion.i(TAG, "onDestroy");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        ILogDepend.Companion.i(TAG, "onCreate");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int onStartCommand(Intent r1, int r2, int r3) {
        INVOKESTATIC_com_obric_aiagent_executionengine_scheduler_impl_ScheduleServiceImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "onStartCommand result: " + super/*android.app.Service*/.onStartCommand(r1, r2, r3));
        return 2;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aiagent_executionengine_scheduler_impl_ScheduleServiceImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
