package io.ktor.network.tls.cipher;

import Y8.t;
import fb.C4074a;
import fb.s;
import fb.v;
import io.ktor.network.util.PoolsKt;
import io.ktor.utils.io.core.BytePacketBuilderExtensions_jvmKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.ByteReadPacketExtensions_jvmKt;
import io.ktor.utils.io.pool.ByteBufferPool;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a1\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0000¢\u0006\u0004\b\u0007\u0010\b\" \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lfb/v;", "Ljavax/crypto/Cipher;", "cipher", "Lkotlin/Function1;", "Lfb/s;", "LY8/t;", "header", "cipherLoop", "(Lfb/v;Ljavax/crypto/Cipher;Lp9/l;)Lfb/v;", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "CryptoBufferPool", "Lio/ktor/utils/io/pool/ObjectPool;", "getCryptoBufferPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "ktor-network-tls"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CipherUtilsKt {
    private static final ObjectPool<ByteBuffer> CryptoBufferPool = new ByteBufferPool(128, 65536);

    public static final v cipherLoop(v vVar, Cipher cipher, InterfaceC5074l<? super s, t> header) {
        p.i(vVar, "<this>");
        p.i(cipher, "cipher");
        p.i(header, "header");
        ByteBuffer byteBufferBorrow = PoolsKt.getDefaultByteBufferPool().borrow();
        ByteBuffer byteBufferBorrow2 = CryptoBufferPool.borrow();
        boolean z10 = true;
        try {
            C4074a c4074a = new C4074a();
            byteBufferBorrow.clear();
            header.invoke(c4074a);
            while (true) {
                int available = byteBufferBorrow.hasRemaining() ? ByteReadPacketExtensions_jvmKt.readAvailable(vVar, byteBufferBorrow) : 0;
                byteBufferBorrow.flip();
                if (!byteBufferBorrow.hasRemaining() && (available == -1 || vVar.k())) {
                    break;
                }
                byteBufferBorrow2.clear();
                if (cipher.getOutputSize(byteBufferBorrow.remaining()) > byteBufferBorrow2.remaining()) {
                    if (z10) {
                        CryptoBufferPool.recycle(byteBufferBorrow2);
                    }
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(cipher.getOutputSize(byteBufferBorrow.remaining()));
                    p.h(byteBufferAllocate, "allocate(...)");
                    byteBufferBorrow2 = byteBufferAllocate;
                    z10 = false;
                }
                cipher.update(byteBufferBorrow, byteBufferBorrow2);
                byteBufferBorrow2.flip();
                BytePacketBuilderExtensions_jvmKt.writeFully(c4074a, byteBufferBorrow2);
                byteBufferBorrow.compact();
            }
            byteBufferBorrow.hasRemaining();
            byteBufferBorrow2.hasRemaining();
            int outputSize = cipher.getOutputSize(0);
            if (outputSize != 0) {
                if (outputSize > byteBufferBorrow2.capacity()) {
                    byte[] bArrDoFinal = cipher.doFinal();
                    p.h(bArrDoFinal, "doFinal(...)");
                    BytePacketBuilderKt.writeFully$default(c4074a, bArrDoFinal, 0, 0, 6, null);
                } else {
                    byteBufferBorrow2.clear();
                    cipher.doFinal(CipherKt.getEmptyByteBuffer(), byteBufferBorrow2);
                    byteBufferBorrow2.flip();
                    if (byteBufferBorrow2.hasRemaining()) {
                        BytePacketBuilderExtensions_jvmKt.writeFully(c4074a, byteBufferBorrow2);
                    } else {
                        byte[] bArrDoFinal2 = cipher.doFinal();
                        p.h(bArrDoFinal2, "doFinal(...)");
                        BytePacketBuilderKt.writeFully$default(c4074a, bArrDoFinal2, 0, 0, 6, null);
                    }
                }
            }
            PoolsKt.getDefaultByteBufferPool().recycle(byteBufferBorrow);
            if (z10) {
                CryptoBufferPool.recycle(byteBufferBorrow2);
            }
            return c4074a;
        } finally {
        }
    }

    public static /* synthetic */ v cipherLoop$default(v vVar, Cipher cipher, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.network.tls.cipher.b
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return CipherUtilsKt.cipherLoop$lambda$0((s) obj2);
                }
            };
        }
        return cipherLoop(vVar, cipher, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t cipherLoop$lambda$0(s sVar) {
        p.i(sVar, "<this>");
        return t.f7040a;
    }

    public static final ObjectPool<ByteBuffer> getCryptoBufferPool() {
        return CryptoBufferPool;
    }
}
