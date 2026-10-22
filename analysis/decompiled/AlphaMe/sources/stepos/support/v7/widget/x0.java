package stepos.support.v7.widget;

import android.view.View;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    public final View f15224a;

    /* renamed from: b, reason: collision with root package name */
    public int f15225b;

    /* renamed from: c, reason: collision with root package name */
    public int f15226c;

    /* renamed from: d, reason: collision with root package name */
    public int f15227d;

    public x0(View view) {
        this.f15224a = view;
    }

    public final void a() {
        int i4 = this.f15227d;
        View view = this.f15224a;
        int top = i4 - (view.getTop() - this.f15225b);
        WeakHashMap weakHashMap = K.S.f939a;
        view.offsetTopAndBottom(top);
        view.offsetLeftAndRight(0 - (view.getLeft() - this.f15226c));
    }
}
