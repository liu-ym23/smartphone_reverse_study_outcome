package d5;

import com.stepos.core.data.ContentParams;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;

/* loaded from: classes3.dex */
public final class c {
    public static ContentParams a(byte[] bytes) {
        l fVar;
        kotlin.jvm.internal.k.f(bytes, "bytes");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = byteBufferOrder.getInt();
        for (int i6 = 0; i6 < i; i6++) {
            byte b = byteBufferOrder.get();
            byte[] bArr = new byte[byteBufferOrder.getShort()];
            byteBufferOrder.get(bArr);
            Charset UTF_8 = StandardCharsets.UTF_8;
            kotlin.jvm.internal.k.e(UTF_8, "UTF_8");
            String str = new String(bArr, UTF_8);
            if (b == 0) {
                fVar = new i(byteBufferOrder.getInt());
            } else if (b == 1) {
                fVar = new j(byteBufferOrder.getLong());
            } else if (b == 2) {
                fVar = new g(byteBufferOrder.getFloat());
            } else if (b == 3) {
                fVar = new e(byteBufferOrder.getDouble());
            } else if (b == 4) {
                fVar = new d(byteBufferOrder.get() != 0);
            } else if (b == 5) {
                byte[] bArr2 = new byte[byteBufferOrder.getInt()];
                byteBufferOrder.get(bArr2);
                fVar = new k(new String(bArr2, UTF_8));
            } else if (b == 6) {
                int i10 = byteBufferOrder.getInt();
                int[] iArr = new int[i10];
                for (int i11 = 0; i11 < i10; i11++) {
                    iArr[i11] = byteBufferOrder.getInt();
                }
                fVar = new h(iArr);
            } else {
                if (b != 7) {
                    throw new IllegalArgumentException(B7.a.h(b, "Unknown param type: "));
                }
                int i12 = byteBufferOrder.getInt();
                float[] fArr = new float[i12];
                for (int i13 = 0; i13 < i12; i13++) {
                    fArr[i13] = byteBufferOrder.getFloat();
                }
                fVar = new f(fArr);
            }
            linkedHashMap.put(str, fVar);
        }
        return new ContentParams(linkedHashMap, null);
    }
}
