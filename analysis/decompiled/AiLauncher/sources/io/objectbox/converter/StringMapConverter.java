package io.objectbox.converter;

import io.objectbox.flatbuffers.FlexBuffers;
import io.objectbox.flatbuffers.a;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public class StringMapConverter implements PropertyConverter<Map<String, String>, byte[]> {
    private static final AtomicReference<a> cachedBuilder = new AtomicReference<>();

    @Override // io.objectbox.converter.PropertyConverter
    public byte[] convertToDatabaseValue(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        a andSet = cachedBuilder.getAndSet(null);
        if (andSet == null) {
            andSet = new a(new S8.a(512), 3);
        }
        int iZ = andSet.z();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new IllegalArgumentException("Map keys or values must not be null");
            }
            andSet.y(entry.getKey(), entry.getValue());
        }
        andSet.f(null, iZ);
        ByteBuffer byteBufferH = andSet.h();
        byte[] bArr = new byte[byteBufferH.limit()];
        byteBufferH.get(bArr);
        if (byteBufferH.limit() <= 262144) {
            andSet.c();
            cachedBuilder.getAndSet(andSet);
        }
        return bArr;
    }

    @Override // io.objectbox.converter.PropertyConverter
    public Map<String, String> convertToEntityProperty(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        FlexBuffers.d dVarH = FlexBuffers.g(new S8.a(bArr, bArr.length)).h();
        int iB = dVarH.b();
        FlexBuffers.c cVarF = dVarH.f();
        FlexBuffers.j jVarG = dVarH.g();
        HashMap map = new HashMap((int) ((iB / 0.75d) + 1.0d));
        for (int i10 = 0; i10 < iB; i10++) {
            map.put(cVarF.a(i10).toString(), jVarG.d(i10).i());
        }
        return map;
    }
}
