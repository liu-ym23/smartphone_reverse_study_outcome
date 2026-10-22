package com.bytedance.android.livesdk.widget.ui.ogc;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.model.ExpressionSection;
import com.bytedance.android.livesdk.model.h;
import com.bytedance.android.livesdk.widget.board.k;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f162190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.api.quickcomment.c f162191b;

    @Override // com.bytedance.android.livesdk.model.h
    public final void getPageCount() {
    }

    @Override // com.bytedance.android.livesdk.model.h
    public final String getPageName() {
        return "unknown";
    }

    @Override // com.bytedance.android.livesdk.model.h
    public final ExpressionSection b() {
        return this.f162190a;
    }

    public b(com.bytedance.android.livesdk.interactivity.api.quickcomment.c r100) {
        this.f162191b = r100;
        this.f162190a = new c();
    }

    @Override // com.bytedance.android.livesdk.model.h
    public final View a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        OGCFixedSelectPanel r101 = new OGCFixedSelectPanel(r100);
        r101.setOgcFixedChatInfo(this.f162191b);
        return r101;
    }

    @Override // com.bytedance.android.livesdk.model.h
    public final k c(Context r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageView");
        return new a(r101, true);
    }
}
