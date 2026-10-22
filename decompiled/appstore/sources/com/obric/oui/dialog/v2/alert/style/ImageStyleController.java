package com.obric.oui.dialog.v2.alert.style;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.common.primitives.Ints;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.v2.common.IImageLoader;
import com.obric.oui.dialog.v2.common.IOImageLoadDelegate;
import com.obric.oui.image.OImageAppIcon;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageStyleController implements StyleController {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f14473n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f14476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IOImageLoadDelegate f14478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IImageLoader f14479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f14480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f14481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f14482i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f14483j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f14484k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14485l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f14486m;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0014¨\u0006\n"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ImageStyleController$FixRatioLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ImageStyleController$ImageStyle;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
        f14473n = new a(null);
    }

    public ImageStyleController(Context r10, int r11) {
        q.g(r10, "context");
        this.f14474a = r10;
        this.f14475b = r11;
    }

    public final void a(Context r10, FrameLayout r11) {
        Integer r12 = this.f14481h;
        if (r12 == null) goto L5;
        q.d(r12);
        int r13 = r12.intValue();
    L6:
        Integer r14 = this.f14480g;
        if (r14 == null) goto L9;
        q.d(r14);
        int r15 = r14.intValue();
    L10:
        ViewGroup.LayoutParams r16 = new FrameLayout.LayoutParams(r13, r15);
        if (this.f14482i == false) goto L13;
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

    @Override // com.obric.oui.dialog.v2.alert.style.StyleController
    public void attachToDialog(AbstractDialog r10) {
        StyleController.a.a(this, r10);
    }

    @Override // com.obric.oui.dialog.v2.alert.style.StyleController
    public void attachToHost(AlertDialogHost r10) {
        q.g(r10, "host");
        StyleController.a.b(this, r10);
    }

    @Override // com.obric.oui.dialog.v2.alert.style.StyleController
    public void attachToParent(Context r10, DialogContainer r11) {
        q.g(r10, "context");
        q.g(r11, "dialogContainer");
        int r12 = this.f14475b;
        if (r12 != 0) goto L5;
        FrameLayout r13 = r11.getIconSlot();
    L10:
        r13.setVisibility(0);
        if (this.f14475b != 0) goto L13;
        b(r10, r13);
        return;
    L13:
        a(r10, r13);
        return;
    L5:
        if (r12 != 1) goto L8;
        r13 = r11.getBannerSlot();
        goto L10
    L8:
        throw new IllegalArgumentException(q.p("Unsupported style: ", Integer.valueOf(this.f14475b)));
    }

    public final void b(Context r10, FrameLayout r11) {
        Integer r12 = this.f14481h;
        int r13 = -2;
        if (r12 == null) goto L5;
        q.d(r12);
        int r14 = r12.intValue();
    L6:
        Integer r15 = this.f14480g;
        if (r15 == null) goto L9;
        q.d(r15);
        r13 = r15.intValue();
    L9:
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(r14, r13);
        r16.gravity = 1;
        r16.topMargin = f.b(r10, 4);
        r16.bottomMargin = f.b(r10, 16);
        r11.addView(c(), r16);
        return;
    L5:
        r14 = -2;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final View c() {
        View r10 = this.f14486m;
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (this.f14475b == 0) goto L8;
    L10:
        ImageView r11 = new ImageView(this.f14474a);
    L11:
        r11.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable r12 = this.f14476c;
        int r13 = this.f14485l;
        String r14 = this.f14477d;
        IImageLoader r15 = this.f14479f;
        if (r15 == null) goto L16;
        if (r15 == null) goto L28;
        r15.loadTopImg(r11);
    L28:
        return r11;
    L16:
        if (r12 == null) goto L18;
        r11.setImageDrawable(r12);
        goto L28
    L18:
        if (r13 == 0) goto L20;
        r11.setImageResource(r13);
        goto L28
    L20:
        if (r14 == null) goto L28;
        if (r14.length() == 0) goto L28;
        IOImageLoadDelegate r16 = this.f14478e;
        if (r16 == null) goto L28;
        r16.load(r11, r14);
        goto L28
    L8:
        if (this.f14483j == false) goto L10;
        AttributeSet r17 = null;
        int r18 = 0;
        OImageAppIcon r19 = new OImageAppIcon(this.f14474a, r17, r18, 6, null);
        r19.setClipToMask(this.f14484k);
        r11 = r19;
        goto L11
    }

    public final void d(boolean r10) {
        this.f14484k = r10;
    }

    public final void e(boolean r10) {
        this.f14483j = r10;
    }

    public final void f(Drawable r10) {
        q.g(r10, "drawable");
        this.f14476c = r10;
    }

    public final void g(String r10) {
        q.g(r10, "url");
        this.f14477d = r10;
    }

    public final void h(IOImageLoadDelegate r10) {
        q.g(r10, "delegate");
        this.f14478e = r10;
    }

    public final void i(Integer r10, Integer r11) {
        this.f14481h = r10;
        this.f14480g = r11;
        this.f14482i = true;
    }

    public final void j(IImageLoader r10) {
        q.g(r10, "loader");
        this.f14479f = r10;
    }
}
