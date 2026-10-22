package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import v.C1177a;

/* loaded from: classes.dex */
public class Barrier extends b {

    /* renamed from: j, reason: collision with root package name */
    private int f8772j;

    /* renamed from: k, reason: collision with root package name */
    private int f8773k;

    /* renamed from: l, reason: collision with root package name */
    private C1177a f8774l;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void t(v.e eVar, int i5, boolean z5) {
        this.f8773k = i5;
        if (z5) {
            int i6 = this.f8772j;
            if (i6 == 5) {
                this.f8773k = 1;
            } else if (i6 == 6) {
                this.f8773k = 0;
            }
        } else {
            int i7 = this.f8772j;
            if (i7 == 5) {
                this.f8773k = 0;
            } else if (i7 == 6) {
                this.f8773k = 1;
            }
        }
        if (eVar instanceof C1177a) {
            ((C1177a) eVar).A1(this.f8773k);
        }
    }

    public boolean getAllowsGoneWidget() {
        return this.f8774l.u1();
    }

    public int getMargin() {
        return this.f8774l.w1();
    }

    public int getType() {
        return this.f8772j;
    }

    @Override // androidx.constraintlayout.widget.b
    protected void m(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.m(attributeSet);
        this.f8774l = new C1177a();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.f9319n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i5);
                if (index == i.f9098D1) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == i.f9092C1) {
                    this.f8774l.z1(typedArrayObtainStyledAttributes.getBoolean(index, true));
                } else if (index == i.f9104E1) {
                    this.f8774l.B1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f8906d = this.f8774l;
        s();
    }

    @Override // androidx.constraintlayout.widget.b
    public void n(v.e eVar, boolean z5) {
        t(eVar, this.f8772j, z5);
    }

    public void setAllowsGoneWidget(boolean z5) {
        this.f8774l.z1(z5);
    }

    public void setDpMargin(int i5) {
        this.f8774l.B1((int) ((i5 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i5) {
        this.f8774l.B1(i5);
    }

    public void setType(int i5) {
        this.f8772j = i5;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
