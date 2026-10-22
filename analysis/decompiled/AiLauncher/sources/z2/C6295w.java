package z2;

import com.google.android.gms.internal.mlkit_vision_barcode.zzcn;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: z2.w, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C6295w extends AbstractC6305x {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f45129a = new Object[4];

    /* renamed from: b, reason: collision with root package name */
    public int f45130b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f45131c;

    public C6295w(int i10) {
    }

    public final C6295w b(Object obj) {
        obj.getClass();
        d(this.f45130b + 1);
        Object[] objArr = this.f45129a;
        int i10 = this.f45130b;
        this.f45130b = i10 + 1;
        objArr[i10] = obj;
        return this;
    }

    public final AbstractC6305x c(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            d(this.f45130b + collection.size());
            if (collection instanceof zzcn) {
                this.f45130b = ((zzcn) collection).b(this.f45129a, this.f45130b);
                return this;
            }
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        return this;
    }

    public final void d(int i10) {
        Object[] objArr = this.f45129a;
        int length = objArr.length;
        if (length >= i10) {
            if (this.f45131c) {
                this.f45129a = (Object[]) objArr.clone();
                this.f45131c = false;
                return;
            }
            return;
        }
        int i11 = length + (length >> 1) + 1;
        if (i11 < i10) {
            int iHighestOneBit = Integer.highestOneBit(i10 - 1);
            i11 = iHighestOneBit + iHighestOneBit;
        }
        if (i11 < 0) {
            i11 = Integer.MAX_VALUE;
        }
        this.f45129a = Arrays.copyOf(objArr, i11);
        this.f45131c = false;
    }
}
