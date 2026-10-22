package com.obric.oui.dialog.alert;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ImageStyleController.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ImageStyleController implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35031a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f35032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f35033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable f35034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f35035e;
    private com.obric.oui.dialog.alert.view.a f;
    private b.a g;
    private Integer h;
    private Integer i;
    private boolean j;
    private int k;
    private View l;

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
        f35031a = new a(null);
    }

    @Override // com.obric.oui.dialog.alert.d
    public void a(OAlertDialog r1) {
        o.e(r1, "dialog");
    }

    public ImageStyleController(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        this.f35032b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f35033c = r4;
    }

    public final void a(Drawable r2) {
        o.e(r2, "drawable");
        this.f35034d = r2;
    }

    public final void a(String r2) {
        o.e(r2, "url");
        this.f35035e = r2;
    }

    public final void a(com.obric.oui.dialog.alert.view.a r3) {
        com.obric.oui.dialog.alert.view.a r4 = (com.obric.oui.dialog.alert.view.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.dialog.alert.view.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "delegate");
        this.f = r4;
    }

    public final void a(b.a r3) {
        b.a r4 = (b.a) ZeusTransformUtils.wrapperContextForParams(r3, b.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "loader");
        this.g = r4;
    }

    public final void a(Integer r1, Integer r2) {
        this.i = r1;
        this.h = r2;
        this.j = true;
    }

    @Override // com.obric.oui.dialog.alert.d
    public void a(Context r3, FrameLayout r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "parent");
        if (this.f35033c != 0) goto L5;
        b(r5, r4);
        return;
    L5:
        c(r5, r4);
    }

    private final void b(Context r6, FrameLayout r7) {
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
        r0.topMargin = g.a(r8, 28);
        r7.addView(a(), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r4 = -2;
        goto L6
    }

    private final void c(Context r6, FrameLayout r7) {
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
        View r0 = this.l;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ImageView r1 = new ImageView(this.f35032b);
        r1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable r2 = this.f35034d;
        int r3 = this.k;
        String r4 = this.f35035e;
        b.a r5 = this.g;
        if (r5 == null) goto L10;
        if (r5 == null) goto L27;
        r5.a(r1);
    L27:
        return (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin");
    L10:
        if (r2 == null) goto L12;
        r1.setImageDrawable(r2);
        goto L27
    L12:
        if (r3 == 0) goto L14;
        r1.setImageResource(r3);
        goto L27
    L14:
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L17;
    L20:
        boolean r7 = true;
    L21:
        if (r7 == true) goto L27;
        com.obric.oui.dialog.alert.view.a r8 = this.f;
        if (r8 == null) goto L27;
        r8.a(r1, r4);
        goto L27
    L17:
        if (r6.length() == 0) goto L20;
        r7 = false;
        goto L21
    }
}
