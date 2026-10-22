package r;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import org.bouncycastle.asn1.BERTags;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: n, reason: collision with root package name */
    public static final SparseIntArray f5032n;

    /* renamed from: a, reason: collision with root package name */
    public float f5033a;

    /* renamed from: b, reason: collision with root package name */
    public float f5034b;

    /* renamed from: c, reason: collision with root package name */
    public float f5035c;
    public float d;

    /* renamed from: e, reason: collision with root package name */
    public float f5036e;

    /* renamed from: f, reason: collision with root package name */
    public float f5037f;

    /* renamed from: g, reason: collision with root package name */
    public float f5038g;

    /* renamed from: h, reason: collision with root package name */
    public int f5039h;

    /* renamed from: i, reason: collision with root package name */
    public float f5040i;

    /* renamed from: j, reason: collision with root package name */
    public float f5041j;

    /* renamed from: k, reason: collision with root package name */
    public float f5042k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5043l;

    /* renamed from: m, reason: collision with root package name */
    public float f5044m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f5032n = sparseIntArray;
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
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f5057i);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i8 = 0; i8 < indexCount; i8++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i8);
            switch (f5032n.get(index)) {
                case 1:
                    this.f5033a = typedArrayObtainStyledAttributes.getFloat(index, this.f5033a);
                    break;
                case 2:
                    this.f5034b = typedArrayObtainStyledAttributes.getFloat(index, this.f5034b);
                    break;
                case 3:
                    this.f5035c = typedArrayObtainStyledAttributes.getFloat(index, this.f5035c);
                    break;
                case 4:
                    this.d = typedArrayObtainStyledAttributes.getFloat(index, this.d);
                    break;
                case 5:
                    this.f5036e = typedArrayObtainStyledAttributes.getFloat(index, this.f5036e);
                    break;
                case 6:
                    this.f5037f = typedArrayObtainStyledAttributes.getDimension(index, this.f5037f);
                    break;
                case 7:
                    this.f5038g = typedArrayObtainStyledAttributes.getDimension(index, this.f5038g);
                    break;
                case 8:
                    this.f5040i = typedArrayObtainStyledAttributes.getDimension(index, this.f5040i);
                    break;
                case 9:
                    this.f5041j = typedArrayObtainStyledAttributes.getDimension(index, this.f5041j);
                    break;
                case 10:
                    this.f5042k = typedArrayObtainStyledAttributes.getDimension(index, this.f5042k);
                    break;
                case BERTags.EMBEDDED_PDV /* 11 */:
                    this.f5043l = true;
                    this.f5044m = typedArrayObtainStyledAttributes.getDimension(index, this.f5044m);
                    break;
                case 12:
                    this.f5039h = n.f(typedArrayObtainStyledAttributes, index, this.f5039h);
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
