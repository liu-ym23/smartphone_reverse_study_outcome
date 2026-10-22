package com.baidu.mapauto.auth.org.spongycastle.asn1;

import com.stepos.alphame.awareness.AwarenessDataItem;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import kotlin.UByte;

/* loaded from: classes.dex */
public final class k0 extends a {
    public k0(boolean z4, int i4, byte[] bArr) {
        super(z4, i4, bArr);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.a, com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        int i4 = this.f7689a ? 96 : 64;
        int i5 = this.f7690b;
        byte[] bArr = this.f7691c;
        pVar.a(i4, i5);
        pVar.b(bArr.length);
        pVar.f7749a.write(bArr);
    }

    public final String toString() throws IOException {
        StringBuffer stringBuffer = new StringBuffer("[");
        if (this.f7689a) {
            stringBuffer.append("CONSTRUCTED ");
        }
        stringBuffer.append("APPLICATION ");
        stringBuffer.append(Integer.toString(this.f7690b));
        stringBuffer.append("]");
        if (this.f7691c != null) {
            stringBuffer.append(" #");
            byte[] bArr = this.f7691c;
            com.baidu.mapauto.auth.org.spongycastle.util.encoders.e eVar = com.baidu.mapauto.auth.org.spongycastle.util.encoders.d.f7800a;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                eVar.getClass();
                for (byte b4 : bArr) {
                    byteArrayOutputStream.write(eVar.f7801a[(b4 & UByte.MAX_VALUE) >>> 4]);
                    byteArrayOutputStream.write(eVar.f7801a[b4 & 15]);
                }
                stringBuffer.append(com.baidu.mapauto.auth.org.spongycastle.util.d.a(byteArrayOutputStream.toByteArray()));
            } catch (Exception e4) {
                StringBuilder sbA = com.baidu.mapauto.auth.a.a("exception encoding Hex string: ");
                sbA.append(e4.getMessage());
                throw new com.baidu.mapauto.auth.org.spongycastle.util.encoders.c(sbA.toString(), e4);
            }
        } else {
            stringBuffer.append(" #null");
        }
        stringBuffer.append(AwarenessDataItem.PERMISSION_SPLITTER);
        return stringBuffer.toString();
    }
}
