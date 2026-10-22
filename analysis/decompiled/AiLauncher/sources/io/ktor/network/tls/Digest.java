package io.ktor.network.tls;

import Y8.t;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import fb.s;
import fb.v;
import io.ktor.network.util.PoolsKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.ByteReadPacketExtensions_jvmKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0081@\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u001c\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\"\u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b$\u0010%\u0088\u0001\u0004\u0092\u0001\u00020\u0003¨\u0006&"}, d2 = {"Lio/ktor/network/tls/Digest;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Lfb/s;", VoiceWakeupReceiver.EXTRA_STATE, "constructor-impl", "(Lfb/s;)Lfb/s;", "Lfb/v;", "packet", "LY8/t;", "update-impl", "(Lfb/s;Lfb/v;)V", com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, "", "hashName", "", "doHash-impl", "(Lfb/s;Ljava/lang/String;)[B", "doHash", "close-impl", "(Lfb/s;)V", "close", "toString-impl", "(Lfb/s;)Ljava/lang/String;", "toString", "", "hashCode-impl", "(Lfb/s;)I", "hashCode", "", "other", "", "equals-impl", "(Lfb/s;Ljava/lang/Object;)Z", "equals", "Lfb/s;", "getState", "()Lfb/s;", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Digest implements Closeable {
    private final s state;

    private /* synthetic */ Digest(s sVar) {
        this.state = sVar;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Digest m158boximpl(s sVar) {
        return new Digest(sVar);
    }

    /* renamed from: close-impl, reason: not valid java name */
    public static void m159closeimpl(s sVar) {
        sVar.close();
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static s m160constructorimpl(s state) {
        p.i(state, "state");
        return state;
    }

    /* renamed from: doHash-impl, reason: not valid java name */
    public static final byte[] m161doHashimpl(s sVar, final String hashName) {
        byte[] bArr;
        p.i(hashName, "hashName");
        synchronized (sVar) {
            bArr = (byte[]) ByteReadPacketKt.preview(sVar, new InterfaceC5074l() { // from class: io.ktor.network.tls.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Digest.doHash_impl$lambda$2$lambda$1(hashName, (v) obj);
                }
            });
        }
        p.h(bArr, "synchronized(...)");
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] doHash_impl$lambda$2$lambda$1(String str, v handshakes) throws NoSuchAlgorithmException {
        p.i(handshakes, "handshakes");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        p.f(messageDigest);
        ByteBuffer byteBufferBorrow = PoolsKt.getDefaultByteBufferPool().borrow();
        while (!handshakes.k() && ByteReadPacketExtensions_jvmKt.readAvailable(handshakes, byteBufferBorrow) != -1) {
            try {
                byteBufferBorrow.flip();
                messageDigest.update(byteBufferBorrow);
                byteBufferBorrow.clear();
            } catch (Throwable th) {
                PoolsKt.getDefaultByteBufferPool().recycle(byteBufferBorrow);
                throw th;
            }
        }
        byte[] bArrDigest = messageDigest.digest();
        PoolsKt.getDefaultByteBufferPool().recycle(byteBufferBorrow);
        return bArrDigest;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m162equalsimpl(s sVar, Object obj) {
        return (obj instanceof Digest) && p.d(sVar, ((Digest) obj).m167unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m163equalsimpl0(s sVar, s sVar2) {
        return p.d(sVar, sVar2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m164hashCodeimpl(s sVar) {
        return sVar.hashCode();
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m165toStringimpl(s sVar) {
        return "Digest(state=" + sVar + ')';
    }

    /* renamed from: update-impl, reason: not valid java name */
    public static final void m166updateimpl(s sVar, v packet) {
        p.i(packet, "packet");
        synchronized (sVar) {
            if (packet.k()) {
                return;
            }
            BytePacketBuilderKt.writePacket(sVar, ByteReadPacketKt.copy(packet));
            t tVar = t.f7040a;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m159closeimpl(this.state);
    }

    public boolean equals(Object obj) {
        return m162equalsimpl(this.state, obj);
    }

    public final s getState() {
        return this.state;
    }

    public int hashCode() {
        return m164hashCodeimpl(this.state);
    }

    public String toString() {
        return m165toStringimpl(this.state);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ s m167unboximpl() {
        return this.state;
    }
}
