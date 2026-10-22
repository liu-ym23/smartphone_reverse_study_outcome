package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ByteString;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g extends ByteString.a {

    /* renamed from: a, reason: collision with root package name */
    public int f1812a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f1813b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteString f1814c;

    public g(ByteString byteString) {
        this.f1814c = byteString;
        this.f1813b = byteString.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1812a < this.f1813b;
    }
}
