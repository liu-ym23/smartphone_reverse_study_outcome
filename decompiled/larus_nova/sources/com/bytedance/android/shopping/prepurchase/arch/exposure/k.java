package com.bytedance.android.shopping.prepurchase.arch.exposure;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.baidu.platform.comapi.map.MapController;
import com.ttnet.org.chromium.base.BaseSwitches;
import faceverify.q;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class k implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f180900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f180901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f180902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f180903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f180904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<String, View> f180905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<View, c> f180906g;

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f180907a;

        public a(k r100) {
            this.f180907a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f180907a.f180901b = true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f180907a.f180901b = false;
        }
    }

    public final void b() {
        View r100 = this.f180900a.get();
        if (r100 == null) goto L5;
        r100.removeOnAttachStateChangeListener(this.f180903d);
    L5:
        Function0<Unit> r101 = this.f180902c;
        if (r101 == null) goto L9;
        Unit r102 = r101.invoke();
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.exposure.h
    public final c a(l r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        View r101 = this.f180900a.get();
        if (r101 != null) goto L6;
        return null;
    L6:
        if (this.f180901b == true) goto L9;
        return null;
    L9:
        if (r100.f180909b.length() <= 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        r101 = this.f180905f.invoke(r100.f180909b);
    L14:
        if (r101 != null) goto L17;
        return null;
    L17:
        return this.f180906g.invoke(r101);
    L11:
        r102 = false;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(View r100, String r101, Function1<? super String, ? extends View> r102, Function1<? super View, c> r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "viewId");
        Intrinsics.checkNotNullParameter(r102, "childViewFinder");
        Intrinsics.checkNotNullParameter(r103, q.KEY_ALGORITHM_CONFIG);
        this.f180904e = r101;
        this.f180905f = r102;
        this.f180906g = r103;
        this.f180900a = new WeakReference(r100);
        a r104 = new a(this);
        this.f180903d = r104;
        r100.addOnAttachStateChangeListener(r104);
        this.f180901b = ViewCompat.isAttachedToWindow(r100);
    }
}
