package com.obric.oui.banner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.x;

/* JADX INFO: compiled from: OFadingPageTransformer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g implements ViewPager.f, ViewPager2.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f34048a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f34049b;

    /* JADX INFO: compiled from: OFadingPageTransformer.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OFadingPageTransformer.kt */
    static final class b extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f34050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f34051b;

        b(View r1, g r2) {
            this.f34050a = r1;
            this.f34051b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            if (this.f34050a.getForeground() != null) goto L6;
            View r0 = this.f34050a;
            GradientDrawable r1 = new GradientDrawable();
            View r2 = this.f34050a;
            g r5 = this.f34051b;
            r1.setAlpha(0);
            r1.setColor(androidx.core.content.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5.a()));
            r0.setForeground((Drawable) ZeusTransformUtils.preCheckCast(r1, Drawable.class, "com.obric.aiagent.plugin"));
            return;
        }
    }

    /* JADX INFO: compiled from: OFadingPageTransformer.kt */
    static final class c extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f34052a = null;

        static {
            f34052a = new c();
        }

        c() {
            super(0);
        }

        public final void a() {
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: OFadingPageTransformer.kt */
    static final class d extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f34053a;

        d(View r1) {
            this.f34053a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            Drawable r1 = this.f34053a.getForeground();
            if (r1 == null) goto L7;
            r1.setAlpha(0);
            return;
        }
    }

    /* JADX INFO: compiled from: OFadingPageTransformer.kt */
    static final class e extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f34054a;

        e(View r1) {
            this.f34054a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            this.f34054a.setAlpha(0.0f);
        }
    }

    /* JADX INFO: compiled from: OFadingPageTransformer.kt */
    static final class f extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f34055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f34056b;

        f(View r1, float r2) {
            this.f34055a = r1;
            this.f34056b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            this.f34055a.getForeground().setAlpha((int) ((1 - this.f34056b) * 255));
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.banner.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OFadingPageTransformer.kt */
    static final class C0926g extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f34057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f34058b;

        C0926g(View r1, float r2) {
            this.f34057a = r1;
            this.f34058b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            this.f34057a.setAlpha(this.f34058b);
        }
    }

    /* JADX INFO: compiled from: OFadingPageTransformer.kt */
    static final class h extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f34059a;

        h(View r1) {
            this.f34059a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            Drawable r1 = this.f34059a.getForeground();
            if (r1 == null) goto L7;
            r1.setAlpha(0);
            return;
        }
    }

    /* JADX INFO: compiled from: OFadingPageTransformer.kt */
    static final class i extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f34060a;

        i(View r1) {
            this.f34060a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            this.f34060a.setAlpha(0.0f);
        }
    }

    static {
        f34048a = new a(null);
    }

    public g() {
        this(0, 1, null);
    }

    public g(int r1) {
        this.f34049b = r1;
    }

    public /* synthetic */ g(int r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = ZeusTransformUtils.mapRes(R.color.Transparent, "color", "Transparent");
    L5:
        this(r1);
    }

    public final int a() {
        return this.f34049b;
    }

    private final void a(d.h.a.a<x> r2, d.h.a.a<x> r3) {
        d.h.a.a r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r1.invoke();
        return;
    L5:
        r4.invoke();
    }

    @Override // androidx.viewpager.widget.ViewPager.f, androidx.viewpager2.widget.ViewPager2.g
    public void a(View r5, float r6) {
        o.e(r5, "view");
        a((d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r5, this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(c.f34052a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        if (r6 >= (-1.0f)) goto L6;
        a((d.h.a.a) ZeusTransformUtils.preCheckCast(new d(r5), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new e(r5), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        if (r6 > 1.0f) goto L8;
        float r7 = Math.max(0.5f, 1 - Math.abs(r6));
        a((d.h.a.a) ZeusTransformUtils.preCheckCast(new f(r5, r7), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new C0926g(r5, r7), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        a((d.h.a.a) ZeusTransformUtils.preCheckCast(new h(r5), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new i(r5), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }
}
