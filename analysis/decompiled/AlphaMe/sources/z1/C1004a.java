package z1;

import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.stepos.alphame.utils.Property;

/* renamed from: z1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1004a extends C.b {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f16412e;

    /* renamed from: f, reason: collision with root package name */
    public final SideSheetBehavior f16413f;

    public /* synthetic */ C1004a(SideSheetBehavior sideSheetBehavior, int i4) {
        this.f16412e = i4;
        this.f16413f = sideSheetBehavior;
    }

    public final float j(int i4) {
        switch (this.f16412e) {
            case 0:
                float fL = l();
                return (i4 - fL) / (k() - fL);
            default:
                float fL2 = l();
                return (fL2 - i4) / (fL2 - k());
        }
    }

    public final int k() {
        int i4 = this.f16412e;
        SideSheetBehavior sideSheetBehavior = this.f16413f;
        switch (i4) {
            case 0:
                return Math.max(0, sideSheetBehavior.f10891n + sideSheetBehavior.f10892o);
            default:
                return Math.max(0, (l() - sideSheetBehavior.f10889l) - sideSheetBehavior.f10892o);
        }
    }

    public final int l() {
        int i4 = this.f16412e;
        SideSheetBehavior sideSheetBehavior = this.f16413f;
        switch (i4) {
            case 0:
                return (-sideSheetBehavior.f10889l) - sideSheetBehavior.f10892o;
            default:
                return sideSheetBehavior.f10890m;
        }
    }

    public final boolean m(float f4) {
        switch (this.f16412e) {
            case 0:
                if (f4 > Property.DEFAULT_FLOAT_VALUE) {
                    break;
                }
                break;
            default:
                if (f4 < Property.DEFAULT_FLOAT_VALUE) {
                    break;
                }
                break;
        }
        return true;
    }

    public final boolean n(View view) {
        switch (this.f16412e) {
            case 0:
                if (view.getRight() < (k() - l()) / 2) {
                    break;
                }
                break;
            default:
                if (view.getLeft() > (k() + l()) / 2) {
                    break;
                }
                break;
        }
        return true;
    }

    public final boolean o(float f4, float f5) {
        int i4 = this.f16412e;
        SideSheetBehavior sideSheetBehavior = this.f16413f;
        switch (i4) {
            case 0:
                if (Math.abs(f4) > Math.abs(f5)) {
                    float fAbs = Math.abs(f4);
                    sideSheetBehavior.getClass();
                    if (fAbs > 500) {
                        break;
                    }
                }
                break;
            default:
                if (Math.abs(f4) > Math.abs(f5)) {
                    float fAbs2 = Math.abs(f4);
                    sideSheetBehavior.getClass();
                    if (fAbs2 > 500) {
                        break;
                    }
                }
                break;
        }
        return true;
    }

    public final boolean p(View view, float f4) {
        int i4 = this.f16412e;
        SideSheetBehavior sideSheetBehavior = this.f16413f;
        switch (i4) {
            case 0:
                if (Math.abs((f4 * sideSheetBehavior.f10888k) + view.getLeft()) > 0.5f) {
                    break;
                }
                break;
            default:
                if (Math.abs((f4 * sideSheetBehavior.f10888k) + view.getRight()) > 0.5f) {
                    break;
                }
                break;
        }
        return true;
    }
}
