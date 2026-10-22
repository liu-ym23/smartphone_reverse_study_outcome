package com.obric.oui.dialog.alert;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.common.primitives.Ints;
import com.obric.oui.dialog.alert.view.IOImageLoadDelegate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageStyleController implements StyleController {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f14282l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f14285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IOImageLoadDelegate f14287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OAlertDialogBuilder.IImageLoader f14288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f14289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f14290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f14291i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14292j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f14293k;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0014¨\u0006\n"}, d2 = {"Lcom/obric/oui/dialog/alert/ImageStyleController$FixRatioLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FixRatioLayout extends FrameLayout {
        public FixRatioLayout(@NotNull Context r10) {
            q.g(r10, "context");
            super(r10);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int r10, int r11) {
            super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r10) / 2, Ints.MAX_POWER_OF_TWO));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/dialog/alert/ImageStyleController$ImageStyle;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ImageStyle {
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f14282l = new a(null);
    }

    public ImageStyleController(Context r10, int r11) {
        q.g(r10, "context");
        this.f14283a = r10;
        this.f14284b = r11;
    }

    public final void a(Context r10, FrameLayout r11) {
        Integer r12 = this.f14290h;
        if (r12 == null) goto L5;
        q.d(r12);
        int r13 = r12.intValue();
    L6:
        Integer r14 = this.f14289g;
        if (r14 == null) goto L9;
        q.d(r14);
        int r15 = r14.intValue();
    L10:
        ViewGroup.LayoutParams r16 = new FrameLayout.LayoutParams(r13, r15);
        if (this.f14291i == false) goto L13;
        FrameLayout r17 = new FrameLayout(r10);
    L14:
        r17.addView(c(), new FrameLayout.LayoutParams(-1, -1));
        r11.addView(r17, r16);
        return;
    L13:
        r17 = new FixRatioLayout(r10);
        goto L14
    L9:
        r15 = -2;
        goto L10
    L5:
        r13 = -1;
        goto L6
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public void attachToDialog(OAlertDialog r10) {
        q.g(r10, "dialog");
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public void attachToParent(Context r10, FrameLayout r11) {
        q.g(r10, "context");
        q.g(r11, "parent");
        if (this.f14284b != 0) goto L5;
        b(r10, r11);
        return;
    L5:
        a(r10, r11);
    }

    public final void b(Context r10, FrameLayout r11) {
        Integer r12 = this.f14290h;
        int r13 = -2;
        if (r12 == null) goto L5;
        q.d(r12);
        int r14 = r12.intValue();
    L6:
        Integer r15 = this.f14289g;
        if (r15 == null) goto L9;
        q.d(r15);
        r13 = r15.intValue();
    L9:
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(r14, r13);
        r16.gravity = 1;
        r16.topMargin = tc.f.b(r10, 28);
        r11.addView(c(), r16);
        return;
    L5:
        r14 = -2;
        goto L6
    }

    public final View c() {
        View r10 = this.f14293k;
        if (r10 == null) goto L5;
        return r10;
    L5:
        ImageView r11 = new ImageView(this.f14283a);
        r11.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable r12 = this.f14285c;
        int r13 = this.f14292j;
        String r14 = this.f14286d;
        OAlertDialogBuilder.IImageLoader r15 = this.f14288f;
        if (r15 == null) goto L10;
        if (r15 == null) goto L22;
        r15.loadTopImg(r11);
    L22:
        return r11;
    L10:
        if (r12 == null) goto L12;
        r11.setImageDrawable(r12);
        goto L22
    L12:
        if (r13 == 0) goto L14;
        r11.setImageResource(r13);
        goto L22
    L14:
        if (r14 == null) goto L22;
        if (r14.length() == 0) goto L22;
        IOImageLoadDelegate r16 = this.f14287e;
        if (r16 == null) goto L22;
        r16.load(r11, r14);
        goto L22
    }

    public final void d(Drawable r10) {
        q.g(r10, "drawable");
        this.f14285c = r10;
    }

    public final void e(String r10) {
        q.g(r10, "url");
        this.f14286d = r10;
    }

    public final void f(IOImageLoadDelegate r10) {
        q.g(r10, "delegate");
        this.f14287e = r10;
    }

    public final void g(Integer r10, Integer r11) {
        this.f14290h = r10;
        this.f14289g = r11;
        this.f14291i = true;
    }

    public final void h(OAlertDialogBuilder.IImageLoader r10) {
        q.g(r10, "loader");
        this.f14288f = r10;
    }
}
