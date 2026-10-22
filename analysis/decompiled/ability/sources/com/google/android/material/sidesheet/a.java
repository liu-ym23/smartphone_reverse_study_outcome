package com.google.android.material.sidesheet;

import Z6.k;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes3.dex */
public final class a extends k {
    public final /* synthetic */ int h;
    public final SideSheetBehavior i;

    public /* synthetic */ a(SideSheetBehavior sideSheetBehavior, int i) {
        this.h = i;
        this.i = sideSheetBehavior;
    }

    @Override // Z6.k
    public final int A() {
        switch (this.h) {
            case 0:
                return -this.i.l;
            default:
                return x();
        }
    }

    @Override // Z6.k
    public final int B(View view) {
        switch (this.h) {
            case 0:
                return view.getRight() + this.i.o;
            default:
                return view.getLeft() - this.i.o;
        }
    }

    @Override // Z6.k
    public final int C(CoordinatorLayout coordinatorLayout) {
        switch (this.h) {
            case 0:
                return coordinatorLayout.getLeft();
            default:
                return coordinatorLayout.getRight();
        }
    }

    @Override // Z6.k
    public final int E() {
        switch (this.h) {
            case 0:
                return 1;
            default:
                return 0;
        }
    }

    @Override // Z6.k
    public final boolean F(float f) {
        switch (this.h) {
            case 0:
                if (f > 0.0f) {
                }
                break;
            default:
                if (f < 0.0f) {
                }
                break;
        }
        return false;
    }

    @Override // Z6.k
    public final boolean G(View view) {
        switch (this.h) {
            case 0:
                if (view.getRight() < (x() - y()) / 2) {
                }
                break;
            default:
                if (view.getLeft() > (x() + this.i.m) / 2) {
                }
                break;
        }
        return false;
    }

    @Override // Z6.k
    public final boolean H(float f, float f7) {
        switch (this.h) {
            case 0:
                if (Math.abs(f) <= Math.abs(f7) || Math.abs(f) <= 500) {
                }
                break;
            default:
                if (Math.abs(f) <= Math.abs(f7) || Math.abs(f) <= 500) {
                }
                break;
        }
        return false;
    }

    @Override // Z6.k
    public final boolean N(View view, float f) {
        switch (this.h) {
            case 0:
                float left = view.getLeft();
                SideSheetBehavior sideSheetBehavior = this.i;
                float fAbs = Math.abs((f * sideSheetBehavior.k) + left);
                sideSheetBehavior.getClass();
                if (fAbs > 0.5f) {
                }
                break;
            default:
                float right = view.getRight();
                SideSheetBehavior sideSheetBehavior2 = this.i;
                float fAbs2 = Math.abs((f * sideSheetBehavior2.k) + right);
                sideSheetBehavior2.getClass();
                if (fAbs2 > 0.5f) {
                }
                break;
        }
        return false;
    }

    @Override // Z6.k
    public final void P(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i6) {
        switch (this.h) {
            case 0:
                if (i <= this.i.m) {
                    marginLayoutParams.leftMargin = i6;
                    break;
                }
                break;
            default:
                int i10 = this.i.m;
                if (i <= i10) {
                    marginLayoutParams.rightMargin = i10 - i;
                    break;
                }
                break;
        }
    }

    @Override // Z6.k
    public final int k(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.h) {
            case 0:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // Z6.k
    public final float l(int i) {
        switch (this.h) {
            case 0:
                float fY = y();
                return (i - fY) / (x() - fY);
            default:
                float f = this.i.m;
                return (f - i) / (f - x());
        }
    }

    @Override // Z6.k
    public final int x() {
        switch (this.h) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.i;
                return Math.max(0, sideSheetBehavior.n + sideSheetBehavior.o);
            default:
                SideSheetBehavior sideSheetBehavior2 = this.i;
                return Math.max(0, (sideSheetBehavior2.m - sideSheetBehavior2.l) - sideSheetBehavior2.o);
        }
    }

    @Override // Z6.k
    public final int y() {
        switch (this.h) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.i;
                return (-sideSheetBehavior.l) - sideSheetBehavior.o;
            default:
                return this.i.m;
        }
    }

    @Override // Z6.k
    public final int z() {
        switch (this.h) {
            case 0:
                return this.i.o;
            default:
                return this.i.m;
        }
    }
}
