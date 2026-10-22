package y;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import u.AbstractC0935a;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: j, reason: collision with root package name */
    public static final SparseIntArray f16116j;

    /* renamed from: a, reason: collision with root package name */
    public int f16117a;

    /* renamed from: b, reason: collision with root package name */
    public int f16118b;

    /* renamed from: c, reason: collision with root package name */
    public int f16119c;

    /* renamed from: d, reason: collision with root package name */
    public float f16120d;

    /* renamed from: e, reason: collision with root package name */
    public float f16121e;

    /* renamed from: f, reason: collision with root package name */
    public float f16122f;

    /* renamed from: g, reason: collision with root package name */
    public int f16123g;

    /* renamed from: h, reason: collision with root package name */
    public String f16124h;

    /* renamed from: i, reason: collision with root package name */
    public int f16125i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16116j = sparseIntArray;
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
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f16156f);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i4);
            switch (f16116j.get(index)) {
                case 1:
                    this.f16121e = typedArrayObtainStyledAttributes.getFloat(index, this.f16121e);
                    break;
                case 2:
                    this.f16119c = typedArrayObtainStyledAttributes.getInt(index, this.f16119c);
                    break;
                case 3:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        typedArrayObtainStyledAttributes.getString(index);
                        break;
                    } else {
                        String str = AbstractC0935a.f15448a[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        break;
                    }
                case 4:
                    typedArrayObtainStyledAttributes.getInt(index, 0);
                    break;
                case 5:
                    this.f16117a = n.f(typedArrayObtainStyledAttributes, index, this.f16117a);
                    break;
                case 6:
                    this.f16118b = typedArrayObtainStyledAttributes.getInteger(index, this.f16118b);
                    break;
                case 7:
                    this.f16120d = typedArrayObtainStyledAttributes.getFloat(index, this.f16120d);
                    break;
                case 8:
                    this.f16123g = typedArrayObtainStyledAttributes.getInteger(index, this.f16123g);
                    break;
                case 9:
                    this.f16122f = typedArrayObtainStyledAttributes.getFloat(index, this.f16122f);
                    break;
                case 10:
                    int i5 = typedArrayObtainStyledAttributes.peekValue(index).type;
                    if (i5 == 1) {
                        this.f16125i = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        break;
                    } else if (i5 == 3) {
                        String string = typedArrayObtainStyledAttributes.getString(index);
                        this.f16124h = string;
                        if (string.indexOf("/") > 0) {
                            this.f16125i = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        typedArrayObtainStyledAttributes.getInteger(index, this.f16125i);
                        break;
                    }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
