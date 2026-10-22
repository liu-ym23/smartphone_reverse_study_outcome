package a5;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends d {

    /* renamed from: f, reason: collision with root package name */
    public final int f123f;

    public c() {
        super(2048);
        this.f123f = 4098;
    }

    @Override // a5.d
    public final Object a(Object obj) {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        byteBuffer.clear();
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        return byteBuffer;
    }

    @Override // a5.d
    public final Object b() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.f123f);
        p.b(byteBufferAllocate);
        return byteBufferAllocate;
    }

    @Override // a5.d
    public final void g(Object obj) {
        ByteBuffer instance = (ByteBuffer) obj;
        p.e(instance, "instance");
        if (instance.capacity() != this.f123f) {
            throw new IllegalStateException("Check failed.");
        }
        if (instance.isDirect()) {
            throw new IllegalStateException("Check failed.");
        }
    }
}
