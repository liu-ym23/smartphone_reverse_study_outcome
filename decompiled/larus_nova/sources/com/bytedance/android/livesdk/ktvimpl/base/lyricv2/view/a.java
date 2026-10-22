package com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.ktvapi.config.ScrollLyricConfigV2;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f143258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f143259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f143260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScrollLyricConfigV2 f143261d;

    public final ScrollLyricConfigV2 getConfig() {
        return this.f143261d;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = (r100.getWidth() / 2) - this.f143258a;
        int r102 = r100.getHeight();
        int r103 = this.f143259b;
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r105 >= r103) goto L6;
        float r106 = r102 / 2.0f;
        r100.drawCircle((this.f143258a * r105) + r101, r106, r106, this.f143261d.f142316c);
        r105 = r105 + 1;
        goto L4
    L6:
        int r107 = this.f143260c;
    L7:
        if (r104 >= r107) goto L9;
        float r108 = r102 / 2.0f;
        r100.drawCircle((this.f143258a * r104) + r101, r108, r108, this.f143261d.f142315b);
        r104 = r104 + 1;
        goto L7
    }

    public a(Context r100, ScrollLyricConfigV2 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        super(r100, null);
        this.f143261d = r101;
        this.f143258a = UtilityKotlinExtentionsKt.h(10);
        this.f143259b = 3;
    }
}
