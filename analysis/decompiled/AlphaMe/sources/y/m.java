package y;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: n, reason: collision with root package name */
    public static final SparseIntArray f16130n;

    /* renamed from: a, reason: collision with root package name */
    public float f16131a;

    /* renamed from: b, reason: collision with root package name */
    public float f16132b;

    /* renamed from: c, reason: collision with root package name */
    public float f16133c;

    /* renamed from: d, reason: collision with root package name */
    public float f16134d;

    /* renamed from: e, reason: collision with root package name */
    public float f16135e;

    /* renamed from: f, reason: collision with root package name */
    public float f16136f;

    /* renamed from: g, reason: collision with root package name */
    public float f16137g;

    /* renamed from: h, reason: collision with root package name */
    public int f16138h;

    /* renamed from: i, reason: collision with root package name */
    public float f16139i;

    /* renamed from: j, reason: collision with root package name */
    public float f16140j;

    /* renamed from: k, reason: collision with root package name */
    public float f16141k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f16142l;

    /* renamed from: m, reason: collision with root package name */
    public float f16143m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16130n = sparseIntArray;
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
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f16159i);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i4);
            switch (f16130n.get(index)) {
                case 1:
                    this.f16131a = typedArrayObtainStyledAttributes.getFloat(index, this.f16131a);
                    break;
                case 2:
                    this.f16132b = typedArrayObtainStyledAttributes.getFloat(index, this.f16132b);
                    break;
                case 3:
                    this.f16133c = typedArrayObtainStyledAttributes.getFloat(index, this.f16133c);
                    break;
                case 4:
                    this.f16134d = typedArrayObtainStyledAttributes.getFloat(index, this.f16134d);
                    break;
                case 5:
                    this.f16135e = typedArrayObtainStyledAttributes.getFloat(index, this.f16135e);
                    break;
                case 6:
                    this.f16136f = typedArrayObtainStyledAttributes.getDimension(index, this.f16136f);
                    break;
                case 7:
                    this.f16137g = typedArrayObtainStyledAttributes.getDimension(index, this.f16137g);
                    break;
                case 8:
                    this.f16139i = typedArrayObtainStyledAttributes.getDimension(index, this.f16139i);
                    break;
                case 9:
                    this.f16140j = typedArrayObtainStyledAttributes.getDimension(index, this.f16140j);
                    break;
                case 10:
                    this.f16141k = typedArrayObtainStyledAttributes.getDimension(index, this.f16141k);
                    break;
                case 11:
                    this.f16142l = true;
                    this.f16143m = typedArrayObtainStyledAttributes.getDimension(index, this.f16143m);
                    break;
                case 12:
                    this.f16138h = n.f(typedArrayObtainStyledAttributes, index, this.f16138h);
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
