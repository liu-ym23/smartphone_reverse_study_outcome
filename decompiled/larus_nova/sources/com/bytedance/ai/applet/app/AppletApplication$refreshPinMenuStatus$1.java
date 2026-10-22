package com.bytedance.ai.applet.app;

import com.larksuite.component.card.plugin.FetchCardPlugin;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.AppletApplication", f = "AppletApplication.kt", i = {0}, l = {FetchCardPlugin.SERVER_ERROR}, m = "refreshPinMenuStatus", n = {PerfLog.PARAM_KEY_CONTEXT_ID}, s = {"L$0"})
public final class AppletApplication$refreshPinMenuStatus$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletApplication this$0;

    public AppletApplication$refreshPinMenuStatus$1(AppletApplication r100, Continuation<? super AppletApplication$refreshPinMenuStatus$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        AppletApplication r101 = this.this$0;
        int r102 = AppletApplication.f34081o;
        return r101.E(null, false, this);
    }
}
