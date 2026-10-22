package com.bytedance.applet.debugger;

import android.content.ClipData;
import android.content.Context;
import com.bytedance.ai.api.DebuggerMode;
import com.bytedance.ai.api.DebuggerOpenArgs;
import com.bytedance.ai.api.IAppletDebuggerService;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.debug.NativeDebugPanelType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.home.impl.sdk.i1;
import com.larus.im.FlowRuntime;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u000e\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ0\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0096@¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/applet/debugger/AppletDebuggerServiceImpl;", "Lcom/bytedance/ai/api/IAppletDebuggerService;", "<init>", "()V", "entryStateController", "Lcom/bytedance/applet/debugger/AppletDebuggerEntryStateController;", "conversationCreator", "Lcom/bytedance/applet/debugger/DebuggerConversationCreator;", "entryState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/platform/api/AppletDebuggerEntryState;", "refreshEntryState", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAndOpenSession", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "entryFrom", "", "mode", "Lcom/bytedance/ai/api/DebuggerMode;", RemoteMessageConst.MessageBody.MSG_CONTENT, "(Landroid/content/Context;Ljava/lang/String;Lcom/bytedance/ai/api/DebuggerMode;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDebuggerMessageMenuItems", "Lcom/larus/platform/api/creation/IBaseMenuItem;", "messageContext", "Lcom/larus/platform/api/AppletDebuggerMessageContext;", "onDebuggerMessageMenuClick", "androidContext", "action", "getAppletDebugBigProfileAvatarDrawableId", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletDebuggerServiceImpl implements IAppletDebuggerService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppletDebuggerEntryStateController f191721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DebuggerConversationCreator f191722b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.api.IAppletDebuggerService
    public final void a() {
    }

    @Override // com.bytedance.ai.api.IAppletDebuggerService
    public final StateFlowImpl f() {
        return this.f191721a.f191696c;
    }

    public AppletDebuggerServiceImpl() {
        this.f191721a = new AppletDebuggerEntryStateController(0);
        this.f191722b = new DebuggerConversationCreator();
    }

    @Override // com.bytedance.ai.api.IAppletDebuggerService
    public final Object b(Continuation<? super Unit> r100) {
        Object r101 = this.f191721a.b(r100);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.ai.api.IAppletDebuggerService
    public final l0 e(com.larus.platform.api.e r410) {
        Intrinsics.checkNotNullParameter(r410, "messageContext");
        String r100 = r410.f365095a;
        if (Intrinsics.areEqual(r100, "agent_trace") == false) goto L30;
        String r101 = r410.f365099e;
        boolean r102 = true;
        if (r101 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L33;
        String r104 = r410.f365100f;
        if (r104 != null) goto L15;
    L18:
        boolean r105 = true;
    L19:
        if (r105 == true) goto L34;
        String r106 = r410.f365097c;
        if (r106 != null) goto L23;
    L26:
        if (r102 == true) goto L37;
        int r107 = b.f191737a;
        return new l0(R.string.applet_debugger_agent_trace, R.string.applet_debugger_agent_trace, FlowRuntime.a().getApplication().getString(R.string.applet_debugger_agent_trace), null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(R.attr.larus_icon_setting_debug, null, R.drawable.larus_icon_setting_debug)), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4104, 127);
    L37:
        return null;
    L23:
        if (StringsKt.isBlank(r106) == true) goto L26;
        r102 = false;
        goto L26
    L34:
        return null;
    L15:
        if (StringsKt.isBlank(r104) == true) goto L18;
        r105 = false;
        goto L19
    L33:
        return null;
    L7:
        if (StringsKt.isBlank(r101) == true) goto L10;
        r103 = false;
        goto L11
    L30:
        if (Intrinsics.areEqual(r100, "copy_logid") == false) goto L36;
        int r108 = d.f191739a;
        return new l0(R.string.applet_debugger_copy_log_id, R.string.applet_debugger_copy_log_id, FlowRuntime.a().getApplication().getString(R.string.applet_debugger_copy_log_id), null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(R.attr.larus_ic_screen_menu_copy, null, R.drawable.larus_ic_screen_menu_copy)), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4104, 127);
    L36:
        return null;
    }

    @Override // com.bytedance.ai.api.IAppletDebuggerService
    public final boolean c(Context r110, String r111, com.larus.platform.api.e r210) {
        Intrinsics.checkNotNullParameter(r110, "androidContext");
        Intrinsics.checkNotNullParameter(r111, "action");
        Intrinsics.checkNotNullParameter(r210, "messageContext");
        String r100 = null;
        boolean r101 = true;
        if (Intrinsics.areEqual(r111, "copy_logid") == false) goto L16;
        int r102 = c.f191738a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "messageContext");
        String r103 = r210.f365099e;
        if (r103 != null) goto L7;
    L57:
        r101 = false;
    L59:
        return r101;
    L7:
        if ((!StringsKt.isBlank(r103)) == false) goto L9;
        r100 = r103;
    L9:
        if (r100 == null) goto L57;
        IFlowSdkDepend r104 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r104 == null) goto L14;
        r104.d0();
        i1.f346188a.i(r110, ClipData.newPlainText(CronetDataStorageAccess.LOGID, r100), "bpea-applet-debugger-copy-logid");
    L14:
        t19.s.f544207a.getClass();
        t19.s.o(r110, R.string.larus_text_copied_tip, false);
        goto L59
    L16:
        if (Intrinsics.areEqual(r111, "agent_trace") == false) goto L62;
        CoroutineScope r105 = com.bytedance.applet.debugger.a.f191726a;
        Intrinsics.checkNotNullParameter(r210, "messageContext");
        FLogger r106 = FLogger.f375446a;
        r106.i("AppletDebugAgentTraceHandler", "agent trace clicked");
        String r107 = r210.f365099e;
        if (r107 == null) goto L57;
        if ((!StringsKt.isBlank(r107)) == true) goto L23;
        r107 = null;
    L23:
        if (r107 == null) goto L57;
        String r108 = r210.f365100f;
        if (r108 == null) goto L57;
        if ((!StringsKt.isBlank(r108)) == true) goto L31;
        r108 = null;
    L31:
        if (r108 == null) goto L57;
        String r109 = r210.f365097c;
        if (r109 == null) goto L57;
        if ((!StringsKt.isBlank(r109)) == true) goto L39;
        r109 = null;
    L39:
        if (r109 == null) goto L57;
        Object r112 = com.bytedance.applet.debugger.a.f191729d;
        monitor-enter(r112);
        com.bytedance.applet.debugger.a.f191730e++;     // Catch: Throwable -> L54
        Job r113 = com.bytedance.applet.debugger.a.f191731f;     // Catch: Throwable -> L54
        if (r113 == null) goto L46;
        Job.DefaultImpls.cancel$default(r113, null, 1, null);     // Catch: Throwable -> L54
    L46:
        com.bytedance.applet.debugger.a.f191731f = null;     // Catch: Throwable -> L54
        com.bytedance.applet.debugger.a.f191732g = null;     // Catch: Throwable -> L54
        long r114 = com.bytedance.applet.debugger.a.f191730e;     // Catch: Throwable -> L54
        monitor-exit(r112);
        boolean r115 = IAISDKDebugService.f36186a.t(NativeDebugPanelType.AGENT_TRACE, GsonProtectorUtils.toJson(com.bytedance.applet.debugger.a.f191728c, new AgentTracePanelStateData(0, r109, r108, r107, "loading", 1, null)), com.bytedance.applet.debugger.a.f191733h, null);
        if (r115 == true) goto L51;
        r106.w("AppletDebugAgentTraceHandler", "show agent trace panel rejected");
    L51:
        if (r115 == true) goto L53;
        com.bytedance.applet.debugger.a.e(r114);
        goto L59
    L53:
        com.bytedance.applet.debugger.a.c(r114, BuildersKt.launch$default(com.bytedance.applet.debugger.a.f191726a, null, CoroutineStart.LAZY, new AppletDebugAgentTraceHandler$handle$requestJob$1(r107, r108, r109, r114, null), 1, null));
    L54:
        th = move-exception;
        throw th;
    L62:
        return false;
    }

    @Override // com.bytedance.ai.api.IAppletDebuggerService
    public final Object d(Context r210, String r211, DebuggerMode r212, String r213, Continuation<? super Boolean> r214) {
        if ((r214 instanceof AppletDebuggerServiceImpl$createAndOpenSession$1) == false) goto L7;
        AppletDebuggerServiceImpl$createAndOpenSession$1 r100 = (AppletDebuggerServiceImpl$createAndOpenSession$1) r214;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L23;
        if (r104 == 1) goto L22;
        if (r104 == 2) goto L17;
        if (r104 != 3) goto L16;
        ResultKt.throwOnFailure(r102);
    L57:
        return Boxing.boxBoolean(false);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        x r105 = (x) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L20
    L45:
        FLogger.f375446a.i("AppletDebuggerService", "Debugger Activity opened");     // Catch: Throwable -> L20
        Object r106 = Result.m9449constructorimpl(Boxing.boxBoolean(true));     // Catch: Throwable -> L20
    L50:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L64;
        FLogger.f375446a.e("AppletDebuggerService", "open Debugger Activity failed", r107);
        DebuggerConversationCreator r108 = this.f191722b;
        x.b r109 = (x.b) r105;
        String r110 = r109.f191764a;
        String r111 = r109.f191765b;
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 3;
        if (r108.a(r110, r111, r100) != r103) goto L57;
        return r103;
    L64:
        return r106;
    L20:
        th = th;
    L49:
        Result.Companion r112 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L50
    L22:
        String r113 = (String) r100.L$1;
        Context r114 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r115 = r113;
    L32:
        Pair r116 = (Pair) r102;
        if (r116 != null) goto L36;
        FLogger.f375446a.i("AppletDebuggerService", "create session failed: main conversation unavailable");
        return Boxing.boxBoolean(false);
    L36:
        w r117 = (w) r116.component1();
        x r118 = (x) r116.component2();
        if ((r118 instanceof x.b) == true) goto L40;
        FLogger.f375446a.i("AppletDebuggerService", "create session failed: remote conversation unavailable");
        return Boxing.boxBoolean(false);
    L40:
        x.b r119 = (x.b) r118;
        DebuggerOpenArgs r120 = new DebuggerOpenArgs(r119.f191764a, r119.f191765b, r117.f191759b, r117.f191760c, r117.f191761d, r115);
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L47
        MainCoroutineDispatcher r122 = Dispatchers.getMain();     // Catch: Throwable -> L47
        AppletDebuggerServiceImpl$createAndOpenSession$3$1 r123 = new AppletDebuggerServiceImpl$createAndOpenSession$3$1(r114, r120, null);     // Catch: Throwable -> L47
        r100.L$0 = r118;     // Catch: Throwable -> L47
        r100.L$1 = null;     // Catch: Throwable -> L47
        r100.label = 2;     // Catch: Throwable -> L47
        if (BuildersKt.withContext(r122, r123, r100) != r103) goto L44;
        return r103;
    L44:
        r105 = r118;
    L47:
        th = th;
        r105 = r118;
        goto L49
    L23:
        ResultKt.throwOnFailure(r102);
        AccountService r124 = AccountService.f365697a;
        if (r124.isLogin().booleanValue() == true) goto L26;
    L58:
        FLogger.f375446a.i("AppletDebuggerService", "create session skipped: account unavailable");
        return Boxing.boxBoolean(false);
    L26:
        if (StringsKt.isBlank(r124.getUserId()) == true) goto L58;
        DebuggerConversationCreator r125 = this.f191722b;
        r100.L$0 = r210;
        r100.L$1 = r213;
        r100.label = 1;
        r102 = r125.c(r211, r212, r100);
        if (r102 != r103) goto L31;
        return r103;
    L31:
        r115 = r213;
        r114 = r210;
    L7:
        r100 = new AppletDebuggerServiceImpl$createAndOpenSession$1(this, r214);
        goto L8
    }
}
