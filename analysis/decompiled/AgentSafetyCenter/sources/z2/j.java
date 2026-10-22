package z2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: j, reason: collision with root package name */
    public static final SparseIntArray f16299j;

    /* renamed from: a, reason: collision with root package name */
    public int f16300a;

    /* renamed from: b, reason: collision with root package name */
    public int f16301b;

    /* renamed from: c, reason: collision with root package name */
    public int f16302c;

    /* renamed from: d, reason: collision with root package name */
    public float f16303d;

    /* renamed from: e, reason: collision with root package name */
    public float f16304e;

    /* renamed from: f, reason: collision with root package name */
    public float f16305f;

    /* renamed from: g, reason: collision with root package name */
    public int f16306g;

    /* renamed from: h, reason: collision with root package name */
    public String f16307h;
    public int i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16299j = sparseIntArray;
        sparseIntArray.append(3, 1);
        sparseIntArray.append(5, 2);
        sparseIntArray.append(9, 3);
        sparseIntArray.append(2, 4);
        sparseIntArray.append(1, 5);
        sparseIntArray.append(0, 6);
        sparseIntArray.append(4, 7);
        sparseIntArray.append(8, 8);
        sparseIntArray.append(7, 9);
        sparseIntArray.append(6, 10);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.f16337f);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            switch (f16299j.get(index)) {
                case 1:
                    this.f16304e = typedArrayObtainStyledAttributes.getFloat(index, this.f16304e);
                    break;
                case 2:
                    this.f16302c = typedArrayObtainStyledAttributes.getInt(index, this.f16302c);
                    break;
                case 3:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        typedArrayObtainStyledAttributes.getString(index);
                        break;
                    } else {
                        String str = v2.a.f14603a[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        break;
                    }
                case 4:
                    typedArrayObtainStyledAttributes.getInt(index, 0);
                    break;
                case 5:
                    this.f16300a = m.e(typedArrayObtainStyledAttributes, index, this.f16300a);
                    break;
                case 6:
                    this.f16301b = typedArrayObtainStyledAttributes.getInteger(index, this.f16301b);
                    break;
                case 7:
                    this.f16303d = typedArrayObtainStyledAttributes.getFloat(index, this.f16303d);
                    break;
                case 8:
                    this.f16306g = typedArrayObtainStyledAttributes.getInteger(index, this.f16306g);
                    break;
                case 9:
                    this.f16305f = typedArrayObtainStyledAttributes.getFloat(index, this.f16305f);
                    break;
                case 10:
                    int i3 = typedArrayObtainStyledAttributes.peekValue(index).type;
                    if (i3 == 1) {
                        this.i = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        break;
                    } else if (i3 == 3) {
                        String string = typedArrayObtainStyledAttributes.getString(index);
                        this.f16307h = string;
                        if (string.indexOf("/") > 0) {
                            this.i = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        typedArrayObtainStyledAttributes.getInteger(index, this.i);
                        break;
                    }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
