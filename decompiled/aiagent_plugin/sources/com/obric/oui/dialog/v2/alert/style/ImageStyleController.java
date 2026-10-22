package com.obric.oui.dialog.v2.alert.style;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.obric.oui.common.util.g;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.image.OImageAppIcon;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ImageStyleController.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ImageStyleController implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35134a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f35135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f35136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable f35137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f35138e;
    private com.obric.oui.dialog.v2.common.b f;
    private com.obric.oui.dialog.v2.common.a g;
    private Integer h;
    private Integer i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private View n;

    /* JADX INFO: compiled from: ImageStyleController.kt */
    public static final class FixRatioLayout extends FrameLayout {
        public FixRatioLayout(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r4, "context");
            super(r4);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int r2, int r3) {
            super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r2) / 2, 1073741824));
        }
    }

    /* JADX INFO: compiled from: ImageStyleController.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f35134a = new a(null);
    }

    public ImageStyleController(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        this.f35135b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f35136c = r4;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.e
    public void a(AbstractDialog r3) {
        e.a.a((e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin"), r3);
    }

    public final void a(Drawable r2) {
        o.e(r2, "drawable");
        this.f35137d = r2;
    }

    public final void a(String r2) {
        o.e(r2, "url");
        this.f35138e = r2;
    }

    public final void a(com.obric.oui.dialog.v2.common.b r3) {
        com.obric.oui.dialog.v2.common.b r4 = (com.obric.oui.dialog.v2.common.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.dialog.v2.common.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "delegate");
        this.f = r4;
    }

    public final void a(com.obric.oui.dialog.v2.common.a r3) {
        com.obric.oui.dialog.v2.common.a r4 = (com.obric.oui.dialog.v2.common.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.dialog.v2.common.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "loader");
        this.g = r4;
    }

    public final void a(Integer r1, Integer r2) {
        this.i = r1;
        this.h = r2;
        this.j = true;
    }

    public final void a(boolean r1) {
        this.k = r1;
    }

    public final void b(boolean r1) {
        this.l = r1;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.e
    public void a(Context r3, c r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r6, "dialogContainer");
        int r0 = this.f35136c;
        if (r0 != 0) goto L5;
        FrameLayout r7 = r6.getIconSlot();
    L10:
        r7.setVisibility(0);
        if (this.f35136c != 0) goto L13;
        a(r5, r7);
        return;
    L13:
        b(r5, r7);
        return;
    L5:
        if (r0 != 1) goto L8;
        r7 = r6.getBannerSlot();
        goto L10
    L8:
        throw new IllegalArgumentException(o.a("Unsupported style: ", Integer.valueOf(this.f35136c)));
    }

    private final void a(Context r6, FrameLayout r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        Integer r2 = this.i;
        int r3 = -2;
        if (r2 == null) goto L5;
        o.a(r2);
        int r4 = r2.intValue();
    L6:
        Integer r5 = this.h;
        if (r5 == null) goto L9;
        o.a(r5);
        r3 = r5.intValue();
    L9:
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(r4, r3);
        r0.gravity = 1;
        r0.topMargin = g.a(r8, 4);
        r0.bottomMargin = g.a(r8, 16);
        r7.addView(a(), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r4 = -2;
        goto L6
    }

    private final void b(Context r6, FrameLayout r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        Integer r2 = this.i;
        if (r2 == null) goto L5;
        o.a(r2);
        int r3 = r2.intValue();
    L6:
        Integer r4 = this.h;
        if (r4 == null) goto L9;
        o.a(r4);
        int r5 = r4.intValue();
    L10:
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(r3, r5);
        if (this.j == false) goto L13;
        FrameLayout r9 = new FrameLayout(r8);
    L14:
        r9.addView(a(), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r7.addView((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L13:
        r9 = (FrameLayout) ZeusTransformUtils.preCheckCast(new FixRatioLayout(r8), FrameLayout.class, "com.obric.aiagent.plugin");
        goto L14
    L9:
        r5 = -2;
        goto L10
    L5:
        r3 = -1;
        goto L6
    }

    private final View a() {
        View r0 = this.n;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.f35136c == 0) goto L8;
    L10:
        ImageView r1 = new ImageView(this.f35135b);
    L11:
        r1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable r2 = this.f35137d;
        int r3 = this.m;
        String r4 = this.f35138e;
        com.obric.oui.dialog.v2.common.a r5 = this.g;
        if (r5 == null) goto L16;
        if (r5 == null) goto L33;
        r5.a(r1);
    L33:
        return (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin");
    L16:
        if (r2 == null) goto L18;
        r1.setImageDrawable(r2);
        goto L33
    L18:
        if (r3 == 0) goto L20;
        r1.setImageResource(r3);
        goto L33
    L20:
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L23;
    L26:
        boolean r7 = true;
    L27:
        if (r7 == true) goto L33;
        com.obric.oui.dialog.v2.common.b r8 = this.f;
        if (r8 == null) goto L33;
        r8.a(r1, r4);
        goto L33
    L23:
        if (r6.length() == 0) goto L26;
        r7 = false;
        goto L27
    L8:
        if (this.k == false) goto L10;
        OImageAppIcon r9 = new OImageAppIcon(this.f35135b, null, 0, 6, null);
        r9.setClipToMask(this.l);
        r1 = (ImageView) ZeusTransformUtils.preCheckCast(r9, ImageView.class, "com.obric.aiagent.plugin");
        goto L11
    }

    @Override // com.obric.oui.dialog.v2.alert.style.e
    public void a(AlertDialogHost r3) {
        AlertDialogHost r4 = (AlertDialogHost) ZeusTransformUtils.wrapperContextForParams(r3, AlertDialogHost.class, "com.obric.aiagent.plugin");
        o.e(r4, "host");
        e.a.a((e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin"), r4);
    }
}
