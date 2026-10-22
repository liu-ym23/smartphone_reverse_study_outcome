package com.obric.autoaction.app.launcherpage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.utils.g;
import com.obric.autogui.common.api.assistant.LaunchMethodClient;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.api.IEventTaskExecutionApi;
import com.obric.eventkit.task.model.EventTask;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: PinShortCutActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PinShortCutActivity extends AppCompatActivity {
    public static final a Companion = null;
    private static final String KEY_FROM_PINNED = "key_from_pinned";
    private static final String KEY_TASK_ID = "key_task_id";
    private static final String TAG = "PinShortCutActivity";
    private static final String VALUE_SHORTCUT_DESKTOP = "shortcut_desktop";

    /* JADX INFO: compiled from: PinShortCutActivity.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final Intent a(Context r2, String r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "ctx");
            o.e(r3, DBDefinition.TASK_ID);
            Intent r4 = new Intent();
            r4.setClassName(r1.getPackageName(), "com.obric.autoaction.app.launcherpage.PinShortCutStubActivity");
            r4.setAction("android.intent.action.VIEW");
            r4.setFlags(335577088);
            r4.putExtra(PinShortCutActivity.KEY_FROM_PINNED, true);
            r4.putExtra(PinShortCutActivity.KEY_TASK_ID, r3);
            return r4;
        }
    }

    /* JADX INFO: compiled from: PinShortCutActivity.kt */
    @f(b = "PinShortCutActivity.kt", c = {69, 75}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.PinShortCutActivity$checkPinned$1")
    static final class b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f22645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PinShortCutActivity f22646c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f22647d;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.PinShortCutActivity$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: PinShortCutActivity.kt */
        @f(b = "PinShortCutActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.PinShortCutActivity$checkPinned$1$1")
        static final class AnonymousClass1 extends l implements m<am, d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f22648a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ PinShortCutActivity f22649b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f22650c;

            AnonymousClass1(PinShortCutActivity r3, String r4, d<? super AnonymousClass1> r5) {
                PinShortCutActivity r6 = (PinShortCutActivity) ZeusTransformUtils.wrapperContextForParams(r3, PinShortCutActivity.class, "com.obric.aiagent.plugin");
                d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
                this.f22649b = r6;
                this.f22650c = r4;
                super(2, r7);
            }

            public final Object a(am r3, d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d<x> create(Object r3, d<?> r4) {
                d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f22649b, this.f22650c, r5), d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                d.c.a.b.a();
                if (this.f22648a != 0) goto L7;
                d.o.a(r5);
                g.f24481a.b((Context) ZeusTransformUtils.preCheckCast(this.f22649b, Context.class, "com.obric.aiagent.plugin"), this.f22650c);
                Toast.makeText((Context) ZeusTransformUtils.preCheckCast(this.f22649b, Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(this.f22649b.getString(ZeusTransformUtils.mapRes(R.string.main_event_task_delete_tip_for_pin_shortcut, WsChannelMultiProcessSharedProvider.STRING_TYPE, "main_event_task_delete_tip_for_pin_shortcut")), CharSequence.class, "com.obric.aiagent.plugin"), 1).show();
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.PinShortCutActivity$b$2, reason: invalid class name */
        /* JADX INFO: compiled from: PinShortCutActivity.kt */
        @f(b = "PinShortCutActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.PinShortCutActivity$checkPinned$1$2")
        static final class AnonymousClass2 extends l implements m<am, d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f22651a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ PinShortCutActivity f22652b;

            AnonymousClass2(PinShortCutActivity r3, d<? super AnonymousClass2> r4) {
                PinShortCutActivity r5 = (PinShortCutActivity) ZeusTransformUtils.wrapperContextForParams(r3, PinShortCutActivity.class, "com.obric.aiagent.plugin");
                d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                this.f22652b = r5;
                super(2, r6);
            }

            public final Object a(am r3, d<? super x> r4) {
                return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d<x> create(Object r2, d<?> r3) {
                d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
                return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f22652b, r4), d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                d.c.a.b.a();
                if (this.f22651a != 0) goto L7;
                d.o.a(r2);
                this.f22652b.finish();
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        b(String r3, PinShortCutActivity r4, d<? super b> r5) {
            PinShortCutActivity r6 = (PinShortCutActivity) ZeusTransformUtils.wrapperContextForParams(r4, PinShortCutActivity.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.f22645b = r3;
            this.f22646c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r4, d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f22645b, this.f22646c, r6);
            r0.f22647d = r4;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22644a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            am r2 = (am) ZeusTransformUtils.preCheckCast(this.f22647d, am.class, "com.obric.aiagent.plugin");
            d.o.a(r14);
        L25:
            am r6 = r2;
        L27:
            i.a(r6, (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f22646c, null), m.class, "com.obric.aiagent.plugin"), 2, null);
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            am r3 = (am) ZeusTransformUtils.preCheckCast(this.f22647d, am.class, "com.obric.aiagent.plugin");
            d.o.a(r14);
        L17:
            if (r14 != null) goto L19;
            am r7 = r3;
            i.a(r7, (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f22646c, this.f22645b, null), m.class, "com.obric.aiagent.plugin"), 2, null);
        L26:
            r6 = r3;
            goto L27
        L19:
            IEventTaskExecutionApi r15 = (IEventTaskExecutionApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskExecutionApi.class), IEventTaskExecutionApi.class, "com.obric.aiagent.plugin");
            if (r15 == null) goto L26;
            String r4 = this.f22645b;
            d<? super x> r8 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f22647d = r3;
            this.f22644a = 2;
            if (r15.scheduleShortcutTask(r4, PinShortCutActivity.VALUE_SHORTCUT_DESKTOP, r8) != r0) goto L24;
            return r0;
        L24:
            r2 = r3;
            goto L25
        L10:
            d.o.a(r14);
            am r16 = (am) ZeusTransformUtils.preCheckCast(this.f22647d, am.class, "com.obric.aiagent.plugin");
            IEventTaskApi r5 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L13;
            ILogDepend.Companion.e(PinShortCutActivity.TAG, "checkPinned failed, IEventTaskApi is unavailable");
            r6 = r16;
            goto L27
        L13:
            String r9 = this.f22645b;
            d<? super EventTask> r10 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f22647d = r16;
            this.f22644a = 1;
            Object r11 = r5.getEventTask(r9, r10);
            if (r11 != r0) goto L16;
            return r0;
        L16:
            r3 = r16;
            r14 = r11;
            goto L17
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ void lambda$TvvoiGVpecNrew9QUlrEPSshMdo(PinShortCutActivity r0) {
        onCreate$lambda$0(r0);
    }

    public PinShortCutActivity() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        View r4 = new View((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        setContentView(r4);
        r4.post(new $$Lambda$PinShortCutActivity$TvvoiGVpecNrew9QUlrEPSshMdo(this));
    }

    private static final void onCreate$lambda$0(PinShortCutActivity r2) {
        PinShortCutActivity r3 = (PinShortCutActivity) ZeusTransformUtils.wrapperContextForParams(r2, PinShortCutActivity.class, "com.obric.aiagent.plugin");
        r3.checkPinned(r3.getIntent());
    }

    private final void checkPinned(Intent r11) {
        if (r11 != null) goto L6;
        finish();
        return;
    L6:
        if (r11.getBooleanExtra(KEY_FROM_PINNED, false) == true) goto L9;
        finish();
        return;
    L9:
        LaunchMethodClient.INSTANCE.setLaunchMethod((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), LaunchMethodClient.LAUNCH_METHOD_CLICK_PINNED_DESKTOP_ICON);
        r11.removeExtra(KEY_FROM_PINNED);
        String r12 = r11.getStringExtra(KEY_TASK_ID);
        if (r12 != null) goto L18;
        finish();
        return;
    L18:
        i.a((am) ZeusTransformUtils.preCheckCast(q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new b(r12, this, null), m.class, "com.obric.aiagent.plugin"), 2, null);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "checkPinned failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
