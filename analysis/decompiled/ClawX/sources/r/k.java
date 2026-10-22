package r;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: j, reason: collision with root package name */
    public static final SparseIntArray f5020j;

    /* renamed from: a, reason: collision with root package name */
    public int f5021a;

    /* renamed from: b, reason: collision with root package name */
    public int f5022b;

    /* renamed from: c, reason: collision with root package name */
    public int f5023c;
    public float d;

    /* renamed from: e, reason: collision with root package name */
    public float f5024e;

    /* renamed from: f, reason: collision with root package name */
    public float f5025f;

    /* renamed from: g, reason: collision with root package name */
    public int f5026g;

    /* renamed from: h, reason: collision with root package name */
    public String f5027h;

    /* renamed from: i, reason: collision with root package name */
    public int f5028i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f5020j = sparseIntArray;
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
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f5054f);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i8 = 0; i8 < indexCount; i8++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i8);
            switch (f5020j.get(index)) {
                case 1:
                    this.f5024e = typedArrayObtainStyledAttributes.getFloat(index, this.f5024e);
                    break;
                case 2:
                    this.f5023c = typedArrayObtainStyledAttributes.getInt(index, this.f5023c);
                    break;
                case 3:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        typedArrayObtainStyledAttributes.getString(index);
                        break;
                    } else {
                        String str = n.a.f3935a[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        break;
                    }
                case 4:
                    typedArrayObtainStyledAttributes.getInt(index, 0);
                    break;
                case 5:
                    this.f5021a = n.f(typedArrayObtainStyledAttributes, index, this.f5021a);
                    break;
                case 6:
                    this.f5022b = typedArrayObtainStyledAttributes.getInteger(index, this.f5022b);
                    break;
                case 7:
                    this.d = typedArrayObtainStyledAttributes.getFloat(index, this.d);
                    break;
                case 8:
                    this.f5026g = typedArrayObtainStyledAttributes.getInteger(index, this.f5026g);
                    break;
                case 9:
                    this.f5025f = typedArrayObtainStyledAttributes.getFloat(index, this.f5025f);
                    break;
                case 10:
                    int i9 = typedArrayObtainStyledAttributes.peekValue(index).type;
                    if (i9 == 1) {
                        this.f5028i = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        break;
                    } else if (i9 == 3) {
                        String string = typedArrayObtainStyledAttributes.getString(index);
                        this.f5027h = string;
                        if (string.indexOf("/") > 0) {
                            this.f5028i = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        typedArrayObtainStyledAttributes.getInteger(index, this.f5028i);
                        break;
                    }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
