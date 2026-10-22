package com.bytedance.android.shopping.new_cart.components;

import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f extends com.bytedance.android.shopping.new_cart.components.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Function1<Integer, Unit>> f178828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f178829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f178830d;

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f178831a;

        public a(f r100) {
            this.f178831a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            int r109 = r104 - r102;
            int r110 = com.bytedance.android.shopping.extensions.b.b(200);
            boolean r111 = true;
            if (CartSettingUtils.a() == false) goto L11;
            if (r109 == 0) goto L6;
        L7:
            if (1 > r109) goto L15;
            if (r110 < r109) goto L15;
        L16:
            if (r111 == false) goto L23;
            f r112 = this.f178831a;
            if (r109 == r112.f178829c) goto L25;
            r112.f178829c = r109;
            Iterator r113 = ((ArrayList) r112.f178828b).iterator();
        L21:
            if (r113.hasNext() == false) goto L26;
            ((Function1) r113.next()).invoke(Integer.valueOf(r109));
            goto L21
        L26:
            return;
        L25:
            return;
        L23:
            return;
        L15:
            r111 = false;
            goto L16
        L6:
            if (this.f178831a.f178829c > 0) goto L16;
        L11:
            if (1 > r109) goto L15;
            if (r110 < r109) goto L15;
            goto L15
        }
    }

    public final int n() {
        LinearLayout r100 = this.f178830d;     // Catch: Throwable -> L13
        if (r100 == null) goto L17;
        View r101 = r100.getChildAt(r100.getChildCount() - 1);     // Catch: Throwable -> L13
        if (r101 == null) goto L8;
        Integer r102 = Integer.valueOf(r101.getMeasuredHeight());     // Catch: Throwable -> L13
    L9:
        if (r102 == null) goto L17;
        return r102.intValue();
    L8:
        r102 = null;
    L17:
        return com.bytedance.android.shopping.extensions.b.b(64);
    L14:
        return com.bytedance.android.shopping.extensions.b.b(64);
    }

    public f(CartObjectContainer r100, LinearLayout r101) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        super(r100);
        this.f178830d = r101;
        this.f178828b = new ArrayList();
        if (r101 == null) goto L6;
        r101.addOnLayoutChangeListener(new a(this));
        return;
    }
}
