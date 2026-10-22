package v0;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class t extends a2.g {
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(b0 b0Var, int i8) {
        super(b0Var);
        this.d = i8;
    }

    @Override // a2.g
    public final int d(View view) {
        int right;
        int i8;
        switch (this.d) {
            case 0:
                c0 c0Var = (c0) view.getLayoutParams();
                ((b0) this.f88b).getClass();
                right = view.getRight() + ((c0) view.getLayoutParams()).f5804a.right;
                i8 = ((ViewGroup.MarginLayoutParams) c0Var).rightMargin;
                break;
            default:
                c0 c0Var2 = (c0) view.getLayoutParams();
                ((b0) this.f88b).getClass();
                right = view.getBottom() + ((c0) view.getLayoutParams()).f5804a.bottom;
                i8 = ((ViewGroup.MarginLayoutParams) c0Var2).bottomMargin;
                break;
        }
        return right + i8;
    }

    @Override // a2.g
    public final int e(View view) {
        int iV;
        int i8;
        switch (this.d) {
            case 0:
                c0 c0Var = (c0) view.getLayoutParams();
                ((b0) this.f88b).getClass();
                iV = b0.v(view) + ((ViewGroup.MarginLayoutParams) c0Var).leftMargin;
                i8 = ((ViewGroup.MarginLayoutParams) c0Var).rightMargin;
                break;
            default:
                c0 c0Var2 = (c0) view.getLayoutParams();
                ((b0) this.f88b).getClass();
                iV = b0.u(view) + ((ViewGroup.MarginLayoutParams) c0Var2).topMargin;
                i8 = ((ViewGroup.MarginLayoutParams) c0Var2).bottomMargin;
                break;
        }
        return iV + i8;
    }

    @Override // a2.g
    public final int f(View view) {
        int iU;
        int i8;
        switch (this.d) {
            case 0:
                c0 c0Var = (c0) view.getLayoutParams();
                ((b0) this.f88b).getClass();
                iU = b0.u(view) + ((ViewGroup.MarginLayoutParams) c0Var).topMargin;
                i8 = ((ViewGroup.MarginLayoutParams) c0Var).bottomMargin;
                break;
            default:
                c0 c0Var2 = (c0) view.getLayoutParams();
                ((b0) this.f88b).getClass();
                iU = b0.v(view) + ((ViewGroup.MarginLayoutParams) c0Var2).leftMargin;
                i8 = ((ViewGroup.MarginLayoutParams) c0Var2).rightMargin;
                break;
        }
        return iU + i8;
    }

    @Override // a2.g
    public final int g(View view) {
        int left;
        int i8;
        switch (this.d) {
            case 0:
                c0 c0Var = (c0) view.getLayoutParams();
                ((b0) this.f88b).getClass();
                left = view.getLeft() - ((c0) view.getLayoutParams()).f5804a.left;
                i8 = ((ViewGroup.MarginLayoutParams) c0Var).leftMargin;
                break;
            default:
                c0 c0Var2 = (c0) view.getLayoutParams();
                ((b0) this.f88b).getClass();
                left = view.getTop() - ((c0) view.getLayoutParams()).f5804a.top;
                i8 = ((ViewGroup.MarginLayoutParams) c0Var2).topMargin;
                break;
        }
        return left - i8;
    }

    @Override // a2.g
    public final int h() {
        switch (this.d) {
            case 0:
                return ((b0) this.f88b).f5799i;
            default:
                return ((b0) this.f88b).f5800j;
        }
    }

    @Override // a2.g
    public final int i() {
        int i8;
        int iY;
        switch (this.d) {
            case 0:
                b0 b0Var = (b0) this.f88b;
                i8 = b0Var.f5799i;
                iY = b0Var.y();
                break;
            default:
                b0 b0Var2 = (b0) this.f88b;
                i8 = b0Var2.f5800j;
                iY = b0Var2.w();
                break;
        }
        return i8 - iY;
    }

    @Override // a2.g
    public final int j() {
        switch (this.d) {
            case 0:
                return ((b0) this.f88b).y();
            default:
                return ((b0) this.f88b).w();
        }
    }

    @Override // a2.g
    public final int k() {
        switch (this.d) {
            case 0:
                return ((b0) this.f88b).f5797g;
            default:
                return ((b0) this.f88b).f5798h;
        }
    }

    @Override // a2.g
    public final int l() {
        switch (this.d) {
            case 0:
                return ((b0) this.f88b).f5798h;
            default:
                return ((b0) this.f88b).f5797g;
        }
    }

    @Override // a2.g
    public final int m() {
        switch (this.d) {
            case 0:
                return ((b0) this.f88b).x();
            default:
                return ((b0) this.f88b).z();
        }
    }

    @Override // a2.g
    public final int n() {
        int iX;
        int iY;
        switch (this.d) {
            case 0:
                b0 b0Var = (b0) this.f88b;
                iX = b0Var.f5799i - b0Var.x();
                iY = b0Var.y();
                break;
            default:
                b0 b0Var2 = (b0) this.f88b;
                iX = b0Var2.f5800j - b0Var2.z();
                iY = b0Var2.w();
                break;
        }
        return iX - iY;
    }

    @Override // a2.g
    public final int o(View view) {
        switch (this.d) {
            case 0:
                b0 b0Var = (b0) this.f88b;
                Rect rect = (Rect) this.f89c;
                b0Var.D(view, rect);
                return rect.right;
            default:
                b0 b0Var2 = (b0) this.f88b;
                Rect rect2 = (Rect) this.f89c;
                b0Var2.D(view, rect2);
                return rect2.bottom;
        }
    }

    @Override // a2.g
    public final int p(View view) {
        switch (this.d) {
            case 0:
                b0 b0Var = (b0) this.f88b;
                Rect rect = (Rect) this.f89c;
                b0Var.D(view, rect);
                return rect.left;
            default:
                b0 b0Var2 = (b0) this.f88b;
                Rect rect2 = (Rect) this.f89c;
                b0Var2.D(view, rect2);
                return rect2.top;
        }
    }

    @Override // a2.g
    public final void s(int i8) {
        switch (this.d) {
            case 0:
                ((b0) this.f88b).H(i8);
                break;
            default:
                ((b0) this.f88b).I(i8);
                break;
        }
    }
}
