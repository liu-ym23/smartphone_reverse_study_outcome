package u1;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;
import k4.v;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5616a;

    /* renamed from: b, reason: collision with root package name */
    public final SideSheetBehavior f5617b;

    public /* synthetic */ a(SideSheetBehavior sideSheetBehavior, int i8) {
        this.f5616a = i8;
        this.f5617b = sideSheetBehavior;
    }

    @Override // k4.v
    public final int G() {
        switch (this.f5616a) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.f5617b;
                return Math.max(0, sideSheetBehavior.f1337n + sideSheetBehavior.f1338o);
            default:
                SideSheetBehavior sideSheetBehavior2 = this.f5617b;
                return Math.max(0, (sideSheetBehavior2.f1336m - sideSheetBehavior2.f1335l) - sideSheetBehavior2.f1338o);
        }
    }

    @Override // k4.v
    public final int H() {
        switch (this.f5616a) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.f5617b;
                return (-sideSheetBehavior.f1335l) - sideSheetBehavior.f1338o;
            default:
                return this.f5617b.f1336m;
        }
    }

    @Override // k4.v
    public final int L() {
        switch (this.f5616a) {
            case 0:
                return this.f5617b.f1338o;
            default:
                return this.f5617b.f1336m;
        }
    }

    @Override // k4.v
    public final int M() {
        switch (this.f5616a) {
            case 0:
                return -this.f5617b.f1335l;
            default:
                return G();
        }
    }

    @Override // k4.v
    public final int N(View view) {
        switch (this.f5616a) {
            case 0:
                return view.getRight() + this.f5617b.f1338o;
            default:
                return view.getLeft() - this.f5617b.f1338o;
        }
    }

    @Override // k4.v
    public final int O(CoordinatorLayout coordinatorLayout) {
        switch (this.f5616a) {
            case 0:
                return coordinatorLayout.getLeft();
            default:
                return coordinatorLayout.getRight();
        }
    }

    @Override // k4.v
    public final int Q() {
        switch (this.f5616a) {
            case 0:
                return 1;
            default:
                return 0;
        }
    }

    @Override // k4.v
    public final boolean V(float f3) {
        switch (this.f5616a) {
            case 0:
                if (f3 > 0.0f) {
                }
                break;
            default:
                if (f3 < 0.0f) {
                }
                break;
        }
        return false;
    }

    @Override // k4.v
    public final boolean Y(View view) {
        switch (this.f5616a) {
            case 0:
                if (view.getRight() < (G() - H()) / 2) {
                }
                break;
            default:
                if (view.getLeft() > (G() + this.f5617b.f1336m) / 2) {
                }
                break;
        }
        return false;
    }

    @Override // k4.v
    public final boolean Z(float f3, float f7) {
        switch (this.f5616a) {
            case 0:
                if (Math.abs(f3) <= Math.abs(f7) || Math.abs(f3) <= 500) {
                }
                break;
            default:
                if (Math.abs(f3) <= Math.abs(f7) || Math.abs(f3) <= 500) {
                }
                break;
        }
        return false;
    }

    @Override // k4.v
    public final int f(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.f5616a) {
            case 0:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // k4.v
    public final float g(int i8) {
        switch (this.f5616a) {
            case 0:
                float fH = H();
                return (i8 - fH) / (G() - fH);
            default:
                float f3 = this.f5617b.f1336m;
                return (f3 - i8) / (f3 - G());
        }
    }

    @Override // k4.v
    public final boolean m0(View view, float f3) {
        switch (this.f5616a) {
            case 0:
                float left = view.getLeft();
                SideSheetBehavior sideSheetBehavior = this.f5617b;
                float fAbs = Math.abs((f3 * sideSheetBehavior.f1334k) + left);
                sideSheetBehavior.getClass();
                if (fAbs > 0.5f) {
                }
                break;
            default:
                float right = view.getRight();
                SideSheetBehavior sideSheetBehavior2 = this.f5617b;
                float fAbs2 = Math.abs((f3 * sideSheetBehavior2.f1334k) + right);
                sideSheetBehavior2.getClass();
                if (fAbs2 > 0.5f) {
                }
                break;
        }
        return false;
    }

    @Override // k4.v
    public final void s0(ViewGroup.MarginLayoutParams marginLayoutParams, int i8, int i9) {
        switch (this.f5616a) {
            case 0:
                if (i8 <= this.f5617b.f1336m) {
                    marginLayoutParams.leftMargin = i9;
                    break;
                }
                break;
            default:
                int i10 = this.f5617b.f1336m;
                if (i8 <= i10) {
                    marginLayoutParams.rightMargin = i10 - i8;
                    break;
                }
                break;
        }
    }
}
