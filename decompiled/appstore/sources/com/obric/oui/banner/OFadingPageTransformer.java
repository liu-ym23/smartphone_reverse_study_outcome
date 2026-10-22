package com.obric.oui.banner;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.obric.common.oui.R$color;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class OFadingPageTransformer implements ViewPager.PageTransformer, ViewPager2.PageTransformer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f12440b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12441a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f12440b = new a(null);
    }

    public OFadingPageTransformer(int r10) {
        this.f12441a = r10;
    }

    public final void a(Function0 r10, Function0 r11) {
        r10.invoke();
    }

    public final int b() {
        return this.f12441a;
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer, androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(final View r10, float r11) {
        q.g(r10, "view");
        a(new AnonymousClass1(r10, this), AnonymousClass2.INSTANCE);
        if (r11 >= (-1.0f)) goto L6;
        a(new AnonymousClass3(r10), new AnonymousClass4(r10));
        return;
    L6:
        if (r11 > 1.0f) goto L8;
        final float r12 = Math.max(0.5f, 1 - Math.abs(r11));
        a(new AnonymousClass5(r10, r12), new AnonymousClass6(r10, r12));
        return;
    L8:
        a(new AnonymousClass7(r10), new AnonymousClass8(r10));
    }

    public /* synthetic */ OFadingPageTransformer(int r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = R$color.Transparent;
    L5:
        this(r10);
    }
}
