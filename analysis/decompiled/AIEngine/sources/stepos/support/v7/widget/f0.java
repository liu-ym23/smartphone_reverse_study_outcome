package stepos.support.v7.widget;

import android.view.View;
import java.util.WeakHashMap;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final View f12789a;

    /* renamed from: b, reason: collision with root package name */
    public int f12790b;

    /* renamed from: c, reason: collision with root package name */
    public int f12791c;

    /* renamed from: d, reason: collision with root package name */
    public int f12792d;

    public f0(View view) {
        this.f12789a = view;
    }

    public final void a() {
        int i10 = this.f12792d;
        View view = this.f12789a;
        int top = i10 - (view.getTop() - this.f12790b);
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        view.offsetTopAndBottom(top);
        view.offsetLeftAndRight(0 - (view.getLeft() - this.f12791c));
    }
}
