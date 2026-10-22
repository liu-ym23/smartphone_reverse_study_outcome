package stepos.support.v7.widget;

import android.view.View;
import androidx.core.view.N;

/* loaded from: classes5.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public final View f41778a;

    /* renamed from: b, reason: collision with root package name */
    public int f41779b;

    /* renamed from: c, reason: collision with root package name */
    public int f41780c;

    /* renamed from: d, reason: collision with root package name */
    public int f41781d;

    /* renamed from: e, reason: collision with root package name */
    public int f41782e;

    public x(View view) {
        this.f41778a = view;
    }

    public void a() {
        View view = this.f41778a;
        N.T(view, this.f41781d - (view.getTop() - this.f41779b));
        View view2 = this.f41778a;
        N.S(view2, this.f41782e - (view2.getLeft() - this.f41780c));
    }

    public int b() {
        return this.f41779b;
    }

    public void c() {
        this.f41779b = this.f41778a.getTop();
        this.f41780c = this.f41778a.getLeft();
    }

    public boolean d(int i10) {
        if (this.f41781d == i10) {
            return false;
        }
        this.f41781d = i10;
        a();
        return true;
    }
}
