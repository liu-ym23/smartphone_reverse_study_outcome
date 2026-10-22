package com.google.protobuf;

/* renamed from: com.google.protobuf.n2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0971n2 implements U1 {

    /* renamed from: a, reason: collision with root package name */
    public final X1 f2932a;
    public final String b;
    public final Object[] c;
    public final int d;

    public C0971n2(X1 x12, String str, Object[] objArr) {
        this.f2932a = x12;
        this.b = str;
        this.c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i6 = 13;
        int i10 = 1;
        while (true) {
            int i11 = i10 + 1;
            char cCharAt2 = str.charAt(i10);
            if (cCharAt2 < 55296) {
                this.d = i | (cCharAt2 << i6);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i6;
                i6 += 13;
                i10 = i11;
            }
        }
    }

    @Override // com.google.protobuf.U1
    public final X1 getDefaultInstance() {
        return this.f2932a;
    }

    @Override // com.google.protobuf.U1
    public final ProtoSyntax getSyntax() {
        int i = this.d;
        return (i & 1) != 0 ? ProtoSyntax.f2865a : (i & 4) == 4 ? ProtoSyntax.c : ProtoSyntax.b;
    }

    @Override // com.google.protobuf.U1
    public final boolean isMessageSetWireFormat() {
        return (this.d & 2) == 2;
    }
}
