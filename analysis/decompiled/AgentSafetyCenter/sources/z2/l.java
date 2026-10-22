package z2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: n, reason: collision with root package name */
    public static final SparseIntArray f16312n;

    /* renamed from: a, reason: collision with root package name */
    public float f16313a;

    /* renamed from: b, reason: collision with root package name */
    public float f16314b;

    /* renamed from: c, reason: collision with root package name */
    public float f16315c;

    /* renamed from: d, reason: collision with root package name */
    public float f16316d;

    /* renamed from: e, reason: collision with root package name */
    public float f16317e;

    /* renamed from: f, reason: collision with root package name */
    public float f16318f;

    /* renamed from: g, reason: collision with root package name */
    public float f16319g;

    /* renamed from: h, reason: collision with root package name */
    public int f16320h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public float f16321j;

    /* renamed from: k, reason: collision with root package name */
    public float f16322k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f16323l;

    /* renamed from: m, reason: collision with root package name */
    public float f16324m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16312n = sparseIntArray;
        sparseIntArray.append(6, 1);
        sparseIntArray.append(7, 2);
        sparseIntArray.append(8, 3);
        sparseIntArray.append(4, 4);
        sparseIntArray.append(5, 5);
        sparseIntArray.append(0, 6);
        sparseIntArray.append(1, 7);
        sparseIntArray.append(2, 8);
        sparseIntArray.append(3, 9);
        sparseIntArray.append(9, 10);
        sparseIntArray.append(10, 11);
        sparseIntArray.append(11, 12);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.i);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            switch (f16312n.get(index)) {
                case 1:
                    this.f16313a = typedArrayObtainStyledAttributes.getFloat(index, this.f16313a);
                    break;
                case 2:
                    this.f16314b = typedArrayObtainStyledAttributes.getFloat(index, this.f16314b);
                    break;
                case 3:
                    this.f16315c = typedArrayObtainStyledAttributes.getFloat(index, this.f16315c);
                    break;
                case 4:
                    this.f16316d = typedArrayObtainStyledAttributes.getFloat(index, this.f16316d);
                    break;
                case 5:
                    this.f16317e = typedArrayObtainStyledAttributes.getFloat(index, this.f16317e);
                    break;
                case 6:
                    this.f16318f = typedArrayObtainStyledAttributes.getDimension(index, this.f16318f);
                    break;
                case 7:
                    this.f16319g = typedArrayObtainStyledAttributes.getDimension(index, this.f16319g);
                    break;
                case 8:
                    this.i = typedArrayObtainStyledAttributes.getDimension(index, this.i);
                    break;
                case 9:
                    this.f16321j = typedArrayObtainStyledAttributes.getDimension(index, this.f16321j);
                    break;
                case 10:
                    this.f16322k = typedArrayObtainStyledAttributes.getDimension(index, this.f16322k);
                    break;
                case 11:
                    this.f16323l = true;
                    this.f16324m = typedArrayObtainStyledAttributes.getDimension(index, this.f16324m);
                    break;
                case 12:
                    this.f16320h = m.e(typedArrayObtainStyledAttributes, index, this.f16320h);
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
