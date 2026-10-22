package com.fasterxml.jackson.databind.node;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class NodeSerialization implements Serializable, Externalizable {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f4281a;

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) throws IOException {
        int i10 = objectInput.readInt();
        byte[] bArr = new byte[i10];
        this.f4281a = bArr;
        objectInput.readFully(bArr, 0, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x012d A[Catch: IOException -> 0x01cb, TryCatch #0 {IOException -> 0x01cb, blocks: (B:3:0x0002, B:5:0x0008, B:80:0x0129, B:82:0x012d, B:84:0x0135, B:96:0x01b2, B:85:0x0165, B:91:0x017b, B:95:0x0198, B:92:0x0185, B:93:0x018a, B:94:0x018b, B:10:0x003b, B:73:0x0115, B:74:0x0118, B:75:0x011b, B:76:0x0120, B:78:0x0123, B:79:0x0126, B:13:0x004d, B:20:0x0062, B:28:0x0093, B:35:0x00ab, B:38:0x00b9, B:41:0x00c0, B:45:0x00ca, B:47:0x00d0, B:49:0x00d6, B:52:0x00de, B:57:0x00ea, B:58:0x00ed, B:59:0x00ee, B:60:0x00f1, B:61:0x00f2, B:62:0x00f5, B:98:0x01bc, B:99:0x01bf, B:100:0x01c0, B:101:0x01ca), top: B:105:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0165 A[Catch: IOException -> 0x01cb, TryCatch #0 {IOException -> 0x01cb, blocks: (B:3:0x0002, B:5:0x0008, B:80:0x0129, B:82:0x012d, B:84:0x0135, B:96:0x01b2, B:85:0x0165, B:91:0x017b, B:95:0x0198, B:92:0x0185, B:93:0x018a, B:94:0x018b, B:10:0x003b, B:73:0x0115, B:74:0x0118, B:75:0x011b, B:76:0x0120, B:78:0x0123, B:79:0x0126, B:13:0x004d, B:20:0x0062, B:28:0x0093, B:35:0x00ab, B:38:0x00b9, B:41:0x00c0, B:45:0x00ca, B:47:0x00d0, B:49:0x00d6, B:52:0x00de, B:57:0x00ea, B:58:0x00ed, B:59:0x00ee, B:60:0x00f1, B:61:0x00f2, B:62:0x00f5, B:98:0x01bc, B:99:0x01bf, B:100:0x01c0, B:101:0x01ca), top: B:105:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x018b A[Catch: IOException -> 0x01cb, TryCatch #0 {IOException -> 0x01cb, blocks: (B:3:0x0002, B:5:0x0008, B:80:0x0129, B:82:0x012d, B:84:0x0135, B:96:0x01b2, B:85:0x0165, B:91:0x017b, B:95:0x0198, B:92:0x0185, B:93:0x018a, B:94:0x018b, B:10:0x003b, B:73:0x0115, B:74:0x0118, B:75:0x011b, B:76:0x0120, B:78:0x0123, B:79:0x0126, B:13:0x004d, B:20:0x0062, B:28:0x0093, B:35:0x00ab, B:38:0x00b9, B:41:0x00c0, B:45:0x00ca, B:47:0x00d0, B:49:0x00d6, B:52:0x00de, B:57:0x00ea, B:58:0x00ed, B:59:0x00ee, B:60:0x00f1, B:61:0x00f2, B:62:0x00f5, B:98:0x01bc, B:99:0x01bf, B:100:0x01c0, B:101:0x01ca), top: B:105:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object readResolve() {
        /*
            Method dump skipped, instructions count: 484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.node.NodeSerialization.readResolve():java.lang.Object");
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(this.f4281a.length);
        objectOutput.write(this.f4281a);
    }
}
