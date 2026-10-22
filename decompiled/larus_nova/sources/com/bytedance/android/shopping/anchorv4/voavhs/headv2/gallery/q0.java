package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class q0 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f169376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f169377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f169378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f169379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearGradient f169380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearGradient f169381f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f169382g;

    public static final class a {
    }

    public static final class b extends ECDraweeView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q0 f169383a;

        @Override // android.view.View
        public final void dispatchDraw(Canvas r110) {
            Intrinsics.checkNotNullParameter(r110, "canvas");
            super.dispatchDraw(r110);
            if (this.f169383a.f169378c.getVisibility() != 0) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == false) goto L12;
            this.f169383a.f169377b.set(0.0f, 0.0f, getWidth(), com.bytedance.android.ec.core.utils.q.a(18));
            q0 r101 = this.f169383a;
            Paint r102 = r101.f169376a;
            LinearGradient r103 = r101.f169380e;
            if (r103 != null) goto L10;
            r103 = new LinearGradient(0.0f, 0.2f * com.bytedance.android.ec.core.utils.q.a(18), 0.0f, com.bytedance.android.ec.core.utils.q.a(18), (int) 2367035427L, 437655587, Shader.TileMode.CLAMP);
            r101.f169380e = r103;
        L10:
            r102.setShader(r103);
            this.f169383a.f169376a.setStyle(Paint.Style.FILL);
            q0 r104 = this.f169383a;
            r110.drawRect(r104.f169377b, r104.f169376a);
            this.f169383a.f169376a.setShader(null);
            return;
        L12:
            return;
        L5:
            r100 = false;
            goto L6
        }

        public b(q0 r100, Context r101) {
            this.f169383a = r100;
            super(r101, null, 0, 6, null);
            GenericDraweeHierarchy r102 = getHierarchy();
            if (r102 == null) goto L6;
            r102.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            return;
        }
    }

    static {
    }

    public q0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f169376a = new Paint(1);
        this.f169377b = new RectF();
        TextView r101 = new TextView(r100);
        r101.setTextSize(1, 10.0f);
        r101.setTextColor(-1);
        r101.setGravity(17);
        Unit r102 = Unit.INSTANCE;
        this.f169378c = r101;
        b r103 = new b(this, r100);
        this.f169379d = r103;
        int r104 = com.bytedance.android.shopping.extensions.b.a(56);
        addView(r103, new FrameLayout.LayoutParams(r104, r104));
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.a(18));
        r105.gravity = 1;
        addView(r101, r105);
        ViewExtensionsKt.g(this, 12.0f, 12.0f, 12.0f, 12.0f);
        setBackgroundColor(-1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.dispatchDraw(r110);
        float r100 = com.bytedance.android.ec.core.utils.q.a(Float.valueOf(12.0f));
        this.f169377b.set(0.0f, 0.0f, getWidth(), getHeight());
        Paint r101 = this.f169376a;
        int r102 = getHeight();
        LinearGradient r103 = this.f169381f;
        if (r103 != null) goto L5;
    L12:
        r103 = new LinearGradient(0.0f, 0.0f, 0.0f, r102, 218103808, 855638016, Shader.TileMode.CLAMP);
        this.f169381f = r103;
        this.f169382g = r102;
    L13:
        r101.setShader(r103);
        this.f169376a.setStyle(Paint.Style.FILL);
        r110.drawRoundRect(this.f169377b, r100, r100, this.f169376a);
        this.f169376a.setShader(null);
        if (isSelected() == false) goto L17;
        float r104 = com.bytedance.android.ec.core.utils.q.a(Float.valueOf(2.0f));
        float r105 = r104 / 2.0f;
        this.f169377b.inset(r105, r105);
        this.f169376a.setColor(-1);
        this.f169376a.setStrokeWidth(r104);
        this.f169376a.setStyle(Paint.Style.STROKE);
        r110.drawRoundRect(this.f169377b, r100, r100, this.f169376a);
        return;
    L17:
        return;
    L5:
        if (this.f169382g != r102) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == true) goto L11;
        r103 = null;
    L11:
        if (r103 != null) goto L13;
    L7:
        r106 = false;
        goto L8
    }
}
