package A2;

import android.view.View;
import y2.AbstractC1325f;

/* loaded from: classes.dex */
public class q extends AbstractC0266e {

    /* renamed from: c, reason: collision with root package name */
    protected boolean f146c;

    /* renamed from: d, reason: collision with root package name */
    private int f147d;

    /* renamed from: e, reason: collision with root package name */
    private int f148e;

    public q(int i5, int i6, boolean z5, int i7) {
        super(i5, i6);
        this.f146c = z5;
        this.f147d = i7;
    }

    @Override // y2.j
    public int[] a(AbstractC1325f abstractC1325f, y2.g[] gVarArr, int i5, int i6) {
        float f5;
        float f6;
        int i7;
        int size = View.MeasureSpec.getSize(i5);
        int mode = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i6);
        m[] mVarArr = gVarArr instanceof m[] ? (m[]) gVarArr : null;
        if (mVarArr == null) {
            return new int[]{-1, -1};
        }
        int length = mVarArr.length;
        int iD = d();
        int iC = c();
        float f7 = 0.0f;
        if (mode == Integer.MIN_VALUE) {
            int i8 = this.f147d;
            if (i8 > 0) {
                size = Math.min((length * 2 * i8) + (length * iD), size);
            } else {
                float f8 = size - (iD * length);
                f5 = length;
                f6 = (f8 / f5) / 2.0f;
                i7 = (int) f6;
                this.f147d = i7;
                f7 = (f6 - i7) * f5 * 2.0f;
            }
        } else if (mode == 1073741824) {
            float f9 = size - (iD * length);
            f5 = length;
            f6 = (f9 / f5) / 2.0f;
            i7 = (int) f6;
            this.f147d = i7;
            f7 = (f6 - i7) * f5 * 2.0f;
        } else {
            if (this.f147d <= 0) {
                this.f147d = iD / 2;
            }
            size = (length * 2 * this.f147d) + (length * iD);
        }
        if (mode2 == Integer.MIN_VALUE || mode == 1073741824) {
            iC = Math.min(iC, size2);
        }
        this.f148e = ((int) f7) / 2;
        return new int[]{size, iC};
    }

    @Override // y2.j
    public void b(AbstractC1325f abstractC1325f, int i5, int i6, int i7, int i8, y2.g[] gVarArr) {
        int iD = d();
        m[] mVarArr = gVarArr instanceof m[] ? (m[]) gVarArr : null;
        if (abstractC1325f == null || mVarArr == null) {
            return;
        }
        int iC = i8 - c();
        int i9 = 0;
        for (m mVar : mVarArr) {
            if (mVar != null) {
                int i10 = (((i9 * 2) + 1) * this.f147d) + i5 + (i9 * iD) + 1;
                mVar.e(i10, iC, i10 + iD, i8);
                i9++;
            }
        }
    }

    public int e() {
        return this.f148e;
    }

    public boolean f() {
        return this.f146c;
    }
}
