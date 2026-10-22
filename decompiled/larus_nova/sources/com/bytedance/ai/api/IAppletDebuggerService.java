package com.bytedance.ai.api;

import android.content.Context;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.view.screenmenu.l0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J6\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J \u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0019\u001a\u00020\u001aH&¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/api/IAppletDebuggerService;", "", "entryState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/platform/api/AppletDebuggerEntryState;", "refreshEntryState", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAndOpenSession", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "entryFrom", "", "mode", "Lcom/bytedance/ai/api/DebuggerMode;", RemoteMessageConst.MessageBody.MSG_CONTENT, "(Landroid/content/Context;Ljava/lang/String;Lcom/bytedance/ai/api/DebuggerMode;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDebuggerMessageMenuItems", "Lcom/larus/platform/api/creation/IBaseMenuItem;", "messageContext", "Lcom/larus/platform/api/AppletDebuggerMessageContext;", "onDebuggerMessageMenuClick", "androidContext", "action", "getAppletDebugBigProfileAvatarDrawableId", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAppletDebuggerService {

    public static final class a {
        public static /* synthetic */ Object a(IAppletDebuggerService r100, Context r101, String r102, DebuggerMode r103, ContinuationImpl r110, int r111) {
            if ((r111 & 2) == 0) goto L5;
            r102 = "settings";
        L5:
            String r104 = r102;
            if ((r111 & 4) == 0) goto L9;
            r103 = DebuggerMode.ONLINE_PREVIEW;
        L9:
            return r100.d(r101, r104, r103, null, r110);
        }
    }

    void a();

    Object b(Continuation<? super Unit> r100);

    boolean c(Context r100, String r101, com.larus.platform.api.e r102);

    Object d(Context r100, String r101, DebuggerMode r102, String r103, Continuation<? super Boolean> r104);

    l0 e(com.larus.platform.api.e r100);

    StateFlowImpl f();
}
