package g7;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.sidesheet.SideSheetBehavior;
import id.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends k {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4351c;

    /* renamed from: d, reason: collision with root package name */
    public SideSheetBehavior f4352d;

    public /* synthetic */ a(int i) {
        this.f4351c = i;
    }

    @Override // id.k
    public final int A() {
        switch (this.f4351c) {
            case 0:
                return -this.f4352d.f2453l;
            default:
                return w();
        }
    }

    @Override // id.k
    public final int B(View view) {
        switch (this.f4351c) {
            case 0:
                return view.getRight() + this.f4352d.f2456o;
            default:
                return view.getLeft() - this.f4352d.f2456o;
        }
    }

    @Override // id.k
    public final int C(androidx.coordinatorlayout.widget.a aVar) {
        switch (this.f4351c) {
            case 0:
                return aVar.getLeft();
            default:
                return aVar.getRight();
        }
    }

    @Override // id.k
    public final int E() {
        switch (this.f4351c) {
            case 0:
                return 1;
            default:
                return 0;
        }
    }

    @Override // id.k
    public final boolean F(float f5) {
        switch (this.f4351c) {
            case 0:
                if (f5 > 0.0f) {
                }
                break;
            default:
                if (f5 < 0.0f) {
                }
                break;
        }
        return false;
    }

    @Override // id.k
    public final boolean H(View view) {
        switch (this.f4351c) {
            case 0:
                if (view.getRight() < (w() - x()) / 2) {
                }
                break;
            default:
                if (view.getLeft() > (w() + this.f4352d.f2454m) / 2) {
                }
                break;
        }
        return false;
    }

    @Override // id.k
    public final boolean I(float f5, float f10) {
        switch (this.f4351c) {
            case 0:
                if (Math.abs(f5) <= Math.abs(f10) || Math.abs(f5) <= 500) {
                }
                break;
            default:
                if (Math.abs(f5) <= Math.abs(f10) || Math.abs(f5) <= 500) {
                }
                break;
        }
        return false;
    }

    @Override // id.k
    public final boolean T(View view, float f5) {
        switch (this.f4351c) {
            case 0:
                if (Math.abs((f5 * this.f4352d.f2452k) + view.getLeft()) > 0.5f) {
                }
                break;
            default:
                if (Math.abs((f5 * this.f4352d.f2452k) + view.getRight()) > 0.5f) {
                }
                break;
        }
        return false;
    }

    @Override // id.k
    public final void V(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i3) {
        switch (this.f4351c) {
            case 0:
                if (i <= this.f4352d.f2454m) {
                    marginLayoutParams.leftMargin = i3;
                    break;
                }
                break;
            default:
                int i10 = this.f4352d.f2454m;
                if (i <= i10) {
                    marginLayoutParams.rightMargin = i10 - i;
                    break;
                }
                break;
        }
    }

    @Override // id.k
    public final int g(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.f4351c) {
            case 0:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // id.k
    public final float h(int i) {
        switch (this.f4351c) {
            case 0:
                float fX = x();
                return (i - fX) / (w() - fX);
            default:
                float f5 = this.f4352d.f2454m;
                return (f5 - i) / (f5 - w());
        }
    }

    @Override // id.k
    public final int w() {
        switch (this.f4351c) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.f4352d;
                return Math.max(0, sideSheetBehavior.f2455n + sideSheetBehavior.f2456o);
            default:
                SideSheetBehavior sideSheetBehavior2 = this.f4352d;
                return Math.max(0, (sideSheetBehavior2.f2454m - sideSheetBehavior2.f2453l) - sideSheetBehavior2.f2456o);
        }
    }

    @Override // id.k
    public final int x() {
        switch (this.f4351c) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.f4352d;
                return (-sideSheetBehavior.f2453l) - sideSheetBehavior.f2456o;
            default:
                return this.f4352d.f2454m;
        }
    }

    @Override // id.k
    public final int z() {
        switch (this.f4351c) {
            case 0:
                return this.f4352d.f2456o;
            default:
                return this.f4352d.f2454m;
        }
    }
}
