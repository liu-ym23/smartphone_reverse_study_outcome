package com.bytedance.android.live.soloktv.timeline.resource;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.soloktv.view.FakeViewRoot;
import com.bytedance.android.live.soloktv.view.SegmentSelectResult;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.config.ScrollLyricConfigV2;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import fd2.a0;
import fd2.l;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements ojc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f101506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f101507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap f101508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f101509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f101510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f101511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f101512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f101513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final rjc.b f101514i;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f101515a;

        public a(b r100) {
            this.f101515a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f101515a;     // Catch: Throwable -> L6
            l r101 = r100.f101506a;     // Catch: Throwable -> L6
            if (r101 == null) goto L9;
            r101.k(new a0(r100.f101512g, r100.f101511f, r100.f101513h, null, null, null));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.soloktv.timeline.resource.b$b, reason: collision with other inner class name */
    public static final class C1543b {
    }

    static {
    }

    public b(FakeViewRoot r100, String r101, long r102, String r103, int r104, rjc.b r105, SegmentSelectResult r110) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r105, "size");
        this.f101511f = r102;
        this.f101512g = r103;
        this.f101513h = r104;
        this.f101514i = r105;
        this.f101509d = new Object();
        new Matrix();
        Paint r106 = new Paint();
        TextPaint r107 = new TextPaint();
        s1.B(R.string.ttlive_ktv_component_no_lyric_hint_text);
        UtilityKotlinExtentionsKt.h(24);
        this.f101510e = "ScrollLyricsViewResource";
        ScrollLyricConfigV2 r108 = new ScrollLyricConfigV2();
        r108.f142306l = 8;
        l r109 = ((IKtvService) k.n(IKtvService.class)).createLyricService(r100.getContext(), 1, r108);
        this.f101506a = r109;
        if (r110 == null) goto L7;
        if (r109 == null) goto L7;
        r109.m(r110.c(), r110.a());
    L7:
        if ((!TextUtils.isEmpty(r101)) == false) goto L18;
        if (r109 == null) goto L10;
        View r111 = r109.getRenderView();
    L11:
        this.f101507b = r111;
        if (r111 == null) goto L14;
        r111.setId(ViewCompat.generateViewId());
    L14:
        ConstraintLayout.LayoutParams r112 = new ConstraintLayout.LayoutParams((int) r105.f538231a, (int) r105.f538232b);
        r112.leftToLeft = 0;
        r112.topToBottom = 0;
        if (r111 == null) goto L17;
        r111.post(new a(this));
    L17:
        r100.addView(r111, r112);
        goto L18
    L10:
        r111 = null;
    L18:
        r106.setAntiAlias(true);
        r106.setDither(true);
        r106.setFilterBitmap(true);
        r107.setAntiAlias(true);
        r107.setColor(ColorProtector.parseColor("#E8ffffff"));
        r107.setTextSize(s1.e(20.0f));
        r107.setTypeface(Typeface.defaultFromStyle(1));
        r107.setTextAlign(Paint.Align.CENTER);
        r107.getFontMetrics();
    }
}
