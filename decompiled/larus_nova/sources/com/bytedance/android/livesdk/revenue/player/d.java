package com.bytedance.android.livesdk.revenue.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.profit.dress.config.TextAlignType;
import com.bytedance.android.live.profit.player.s;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextRenderUtils f157247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f157248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f157249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f157250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f157251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ TextAlignType f157252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ a5 f157253g;

    public d(TextRenderUtils r100, boolean r101, Context r102, int r103, int r104, TextAlignType r105, a5 r106) {
        this.f157247a = r100;
        this.f157248b = r101;
        this.f157249c = r102;
        this.f157250d = r103;
        this.f157251e = r104;
        this.f157252f = r105;
        this.f157253g = r106;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        s r101 = (s) r100;
        Intrinsics.checkNotNullParameter(r101, "res");
        SpannableString r102 = (SpannableString) r101.b();
        if (r102 != null) goto L6;
        int r103 = s.f88364a;
        return s.a.a(new Error("convert text to spannable failed: " + r101.a()));
    L6:
        if (this.f157248b == false) goto L13;
        TextRenderUtils r104 = this.f157247a;
        Context r105 = this.f157249c;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "spannable");
        TextView r106 = new TextView(r105);
        r106.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        r106.setMaxLines(1);
        r106.setText(r102);
        r106.measure(0, 0);
        int r107 = r106.getMeasuredWidth();
        int r108 = r106.getMeasuredHeight();
        if (r107 == 0) goto L12;
        if (r108 == 0) goto L12;
        r106.layout(0, 0, r107, r108);
        Bitmap r109 = Bitmap.createBitmap(r107, r108, Bitmap.Config.ARGB_8888);
        r106.draw(new Canvas(r109));
    L14:
        if (r109 != null) goto L16;
        int r110 = s.f88364a;
        return s.a.a(new Error("text render failed: text=" + this.f157253g));
    L16:
        int r111 = s.f88364a;
        return new s.c(r109);
    L12:
        r109 = null;
        goto L14
    L13:
        TextRenderUtils r112 = this.f157247a;
        Context r113 = this.f157249c;
        int r114 = this.f157250d;
        int r115 = this.f157251e;
        TextAlignType r116 = this.f157252f;
        r112.getClass();
        r109 = TextRenderUtils.e(r113, r102, r114, r115, r116);
        goto L14
    }
}
