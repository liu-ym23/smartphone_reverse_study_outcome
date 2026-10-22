package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j implements h1 {

    /* renamed from: a, reason: collision with root package name */
    public final CodedOutputStream f1844a;

    public j(CodedOutputStream codedOutputStream) {
        u.a(codedOutputStream, "output");
        this.f1844a = codedOutputStream;
        codedOutputStream.f1723b = this;
    }

    public final void a(int i10, ByteString byteString) {
        this.f1844a.A(i10, byteString);
    }

    public final void b(int i10, Object obj, w0 w0Var) {
        CodedOutputStream codedOutputStream = this.f1844a;
        codedOutputStream.O(i10, 3);
        w0Var.h((i0) obj, codedOutputStream.f1723b);
        codedOutputStream.O(i10, 4);
    }
}
