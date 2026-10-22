package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import android.view.View;
import android.view.ViewGroup;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class PdpBottomOverlayPaddingDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, Integer> f181184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IdentityHashMap<View, a> f181185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<View> f181186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<List<View>> f181187d;

    public static final class a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int f181188f = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f181189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f181190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f181191c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f181192d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f181193e;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.PdpBottomOverlayPaddingDelegate$a$a, reason: collision with other inner class name */
        public static final class C2697a {
            public static a a(View r100) {
                Intrinsics.checkNotNullParameter(r100, "view");
                int r101 = r100.getPaddingLeft();
                int r102 = r100.getPaddingTop();
                int r103 = r100.getPaddingRight();
                int r104 = r100.getPaddingBottom();
                ViewGroup.LayoutParams r105 = r100.getLayoutParams();
                if ((r105 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
                r105 = null;
            L5:
                ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
                if (r106 == null) goto L8;
                int r107 = r106.bottomMargin;
            L10:
                return new a(r101, r102, r103, r104, r107);
            L8:
                r107 = 0;
                goto L10
            }
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L16;
            a r101 = (a) r100;
            if (this.f181189a == r101.f181189a) goto L8;
            return false;
        L8:
            if (this.f181190b == r101.f181190b) goto L10;
            return false;
        L10:
            if (this.f181191c == r101.f181191c) goto L12;
            return false;
        L12:
            if (this.f181192d == r101.f181192d) goto L14;
            return false;
        L14:
            if (this.f181193e == r101.f181193e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            return (((((((this.f181189a * 31) + this.f181190b) * 31) + this.f181191c) * 31) + this.f181192d) * 31) + this.f181193e;
        }

        public final String toString() {
            return "InitialState(paddingLeft=" + this.f181189a + ", paddingTop=" + this.f181190b + ", paddingRight=" + this.f181191c + ", paddingBottom=" + this.f181192d + ", marginBottom=" + this.f181193e + ")";
        }

        public a(int r100, int r101, int r102, int r103, int r104) {
            this.f181189a = r100;
            this.f181190b = r101;
            this.f181191c = r102;
            this.f181192d = r103;
            this.f181193e = r104;
        }
    }

    public final void a() {
        int r100 = CollectionsKt.sumOfInt(this.f181184a.values());
        View r101 = this.f181186c.invoke();
        if (r101 == null) goto L8;
        IdentityHashMap<View, a> r102 = this.f181185b;
        a r103 = r102.get(r101);
        if (r103 != null) goto L7;
        int r104 = a.f181188f;
        r103 = a.C2697a.a(r101);
        r102.put(r101, r103);
    L7:
        a r105 = r103;
        r101.setPadding(r105.f181189a, r105.f181190b, r105.f181191c, r105.f181192d + r100);
    L8:
        Iterator<T> r106 = this.f181187d.invoke().iterator();
    L10:
        if (r106.hasNext() == false) goto L21;
        View r107 = (View) r106.next();
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == true) goto L14;
        r108 = null;
    L14:
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        if (r109 == null) goto L10;
        IdentityHashMap<View, a> r110 = this.f181185b;
        a r111 = r110.get(r107);
        if (r111 != null) goto L20;
        int r112 = a.f181188f;
        r111 = a.C2697a.a(r107);
        r110.put(r107, r111);
    L20:
        r109.bottomMargin = r111.f181193e + r100;
        r107.setLayoutParams(r109);
        goto L10
    }

    public /* synthetic */ PdpBottomOverlayPaddingDelegate(Function0 r100) {
        this(r100, AnonymousClass1.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PdpBottomOverlayPaddingDelegate(Function0<? extends View> r100, Function0<? extends List<? extends View>> r101) {
        Intrinsics.checkNotNullParameter(r100, "paddingTargetProvider");
        Intrinsics.checkNotNullParameter(r101, "marginTargetProvider");
        this.f181186c = r100;
        this.f181187d = r101;
        this.f181184a = new LinkedHashMap();
        this.f181185b = new IdentityHashMap();
    }

    public final void b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if (r101 > 0) goto L6;
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f181184a.remove(r100);
        a();
        return;
    L6:
        this.f181184a.put(r100, Integer.valueOf(r101));
        a();
    }
}
