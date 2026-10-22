package com.bytedance.android.live.profit.player;

import com.bytedance.android.live.profit.player.jsb.DressPlayFinishResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxAlphaPlayerWidget f88325a;

    public static final class a extends tu0.b<tu0.d, DressPlayFinishResultModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f88326a;

        public a(f r100) {
            this.f88326a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.f
        public final void invoke(Object r100, CallContext r101) {
            tu0.d r102 = (tu0.d) r100;
            Intrinsics.checkNotNullParameter(r102, "params");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (Intrinsics.areEqual(r102.b(), Boolean.TRUE) == false) goto L5;
            LynxAlphaPlayerWidget r103 = this.f88326a.f88325a;
            int r104 = LynxAlphaPlayerWidget.f88278i;
            r103.zq(true, null);
            return;
        L5:
            LynxAlphaPlayerWidget r105 = this.f88326a.f88325a;
            String r106 = r102.a();
            int r107 = LynxAlphaPlayerWidget.f88278i;
            r105.zq(false, r106);
        }
    }

    public f(LynxAlphaPlayerWidget r100) {
        this.f88325a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new a(this);
    }
}
