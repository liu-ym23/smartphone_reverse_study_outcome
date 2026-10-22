package com.bytedance.android.livesdk.interactivity.common.combinedtext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.amap.api.col.s.ce;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/ClipImageView;", "Lcom/bytedance/android/live/core/widget/HSImageView;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "getClipOffset", "()F", "setClipOffset", "(F)V", "clipOffset", "", "b", "Z", "getRound", "()Z", "setRound", "(Z)V", "round", "c", "getRadius", "setRadius", "radius", "Landroid/graphics/drawable/Drawable;", ce.f26391f, "Landroid/graphics/drawable/Drawable;", "getBorderDrawable", "()Landroid/graphics/drawable/Drawable;", "setBorderDrawable", "(Landroid/graphics/drawable/Drawable;)V", "borderDrawable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClipImageView extends HSImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f136445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f136446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f136447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Path f136448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f136449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f136450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f136451g;

    public ClipImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ClipImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final Drawable getBorderDrawable() {
        return this.f136451g;
    }

    public final float getClipOffset() {
        return this.f136445a;
    }

    public final float getRadius() {
        return this.f136447c;
    }

    public final boolean getRound() {
        return this.f136446b;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
    L14:
        e = move-exception;
        ALogger.i("ClipImageView", String.valueOf(e.getMessage()));
        return;
    L4:
        if (this.f136446b == false) goto L7;
        r100.save();     // Catch: Exception -> L14
        r100.clipPath(this.f136449e);     // Catch: Exception -> L14
        super.onDraw(r100);     // Catch: Exception -> L14
        r100.restore();     // Catch: Exception -> L14
    L10:
        Drawable r101 = this.f136451g;     // Catch: Exception -> L14
        if (r101 == null) goto L19;
        r101.draw(r100);     // Catch: Exception -> L14
        return;
    L19:
        return;
    L7:
        if (this.f136447c <= 0.0f) goto L9;
        r100.save();     // Catch: Exception -> L14
        r100.clipPath(this.f136450f);     // Catch: Exception -> L14
        super.onDraw(r100);     // Catch: Exception -> L14
        r100.restore();     // Catch: Exception -> L14
        goto L10
    L9:
        super.onDraw(r100);     // Catch: Exception -> L14
        goto L10
    }

    public final void setBorderDrawable(Drawable r100) {
        this.f136451g = r100;
    }

    public final void setClipOffset(float r100) {
        this.f136445a = r100;
    }

    public final void setRadius(float r100) {
        this.f136447c = r100;
    }

    public final void setRound(boolean r100) {
        this.f136446b = r100;
    }

    public ClipImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f136448d = new Path();
        this.f136449e = new Path();
        this.f136450f = new Path();
    }

    public /* synthetic */ ClipImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r110, int r111, int r112) {
        super.onSizeChanged(r100, r110, r111, r112);
        this.f136448d.reset();
        Path r113 = this.f136448d;
        float r101 = r100;
        float r102 = 2;
        float r114 = ((-r101) / r102) + this.f136445a;
        float r103 = r110;
        float r104 = r103 / r102;
        float r105 = r101 / r102;
        r113.addCircle(r114, r104, r105, Path.Direction.CCW);
        this.f136449e.reset();
        this.f136449e.addCircle(r105, r104, r105, Path.Direction.CCW);
        if (this.f136447c <= 0.0f) goto L5;
        this.f136450f.reset();
        Path r106 = this.f136450f;
        float r107 = this.f136447c;
        r106.addRoundRect(0.0f, 0.0f, r101, r103, r107, r107, Path.Direction.CCW);
    L5:
        Drawable r115 = this.f136451g;
        if (r115 == null) goto L9;
        if (r115 == null) goto L9;
        r115.setBounds(0, 0, r100, r110);
    L9:
        this.f136449e.op(this.f136448d, Path.Op.DIFFERENCE);
    }
}
