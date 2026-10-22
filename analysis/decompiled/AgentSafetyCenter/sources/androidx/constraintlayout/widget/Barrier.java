package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.HashMap;
import w2.a;
import w2.e;
import z2.b;
import z2.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class Barrier extends b {

    /* renamed from: l, reason: collision with root package name */
    public int f992l;

    /* renamed from: m, reason: collision with root package name */
    public int f993m;

    /* renamed from: n, reason: collision with root package name */
    public a f994n;

    public Barrier(Context context) {
        super(context);
        this.f16184c = new int[32];
        this.f16189k = new HashMap();
        this.f16186g = context;
        f(null);
        super.setVisibility(8);
    }

    public final void f(AttributeSet attributeSet) {
        int[] iArr = q.f16333b;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, iArr);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == 35) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.i = string;
                    setIds(string);
                } else if (index == 36) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f16188j = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        a aVar = new a();
        aVar.f15128p0 = new e[4];
        aVar.f15129q0 = 0;
        aVar.f15130r0 = 0;
        aVar.f15131s0 = true;
        aVar.f15132t0 = 0;
        aVar.f15133u0 = false;
        this.f994n = aVar;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(attributeSet, iArr);
            int indexCount2 = typedArrayObtainStyledAttributes2.getIndexCount();
            for (int i3 = 0; i3 < indexCount2; i3++) {
                int index2 = typedArrayObtainStyledAttributes2.getIndex(i3);
                if (index2 == 26) {
                    setType(typedArrayObtainStyledAttributes2.getInt(index2, 0));
                } else if (index2 == 25) {
                    this.f994n.f15131s0 = typedArrayObtainStyledAttributes2.getBoolean(index2, true);
                } else if (index2 == 27) {
                    this.f994n.f15132t0 = typedArrayObtainStyledAttributes2.getDimensionPixelSize(index2, 0);
                }
            }
            typedArrayObtainStyledAttributes2.recycle();
        }
        this.f16187h = this.f994n;
        e();
    }

    public boolean getAllowsGoneWidget() {
        return this.f994n.f15131s0;
    }

    public int getMargin() {
        return this.f994n.f15132t0;
    }

    public int getType() {
        return this.f992l;
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.f994n.f15131s0 = z10;
    }

    public void setDpMargin(int i) {
        this.f994n.f15132t0 = (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i) {
        this.f994n.f15132t0 = i;
    }

    public void setType(int i) {
        this.f992l = i;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16184c = new int[32];
        this.f16189k = new HashMap();
        this.f16186g = context;
        f(attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16184c = new int[32];
        this.f16189k = new HashMap();
        this.f16186g = context;
        f(attributeSet);
        super.setVisibility(8);
    }
}
