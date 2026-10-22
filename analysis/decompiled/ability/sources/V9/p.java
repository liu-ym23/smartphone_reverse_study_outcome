package V9;

import D7.AbstractC0214f;
import java.util.RandomAccess;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class p extends AbstractC0214f implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final ByteString[] f1423a;
    public final int[] b;

    public p(ByteString[] byteStringArr, int[] iArr) {
        this.f1423a = byteStringArr;
        this.b = iArr;
    }

    @Override // D7.AbstractC0209a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return super.contains((ByteString) obj);
        }
        return false;
    }

    @Override // D7.AbstractC0214f, java.util.List
    public final Object get(int i) {
        return this.f1423a[i];
    }

    @Override // D7.AbstractC0214f, D7.AbstractC0209a
    /* renamed from: getSize */
    public final int get_size() {
        return this.f1423a.length;
    }

    @Override // D7.AbstractC0214f, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return super.indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // D7.AbstractC0214f, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return super.lastIndexOf((ByteString) obj);
        }
        return -1;
    }
}
