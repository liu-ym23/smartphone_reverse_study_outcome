package L0;

import A0.e;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class a implements e<ByteBuffer> {

    /* renamed from: a, reason: collision with root package name */
    private final ByteBuffer f3804a;

    /* renamed from: L0.a$a, reason: collision with other inner class name */
    public static class C0056a implements e.a<ByteBuffer> {
        @Override // A0.e.a
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // A0.e.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public e<ByteBuffer> b(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f3804a = byteBuffer;
    }

    @Override // A0.e
    public void b() {
    }

    @Override // A0.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ByteBuffer a() {
        this.f3804a.position(0);
        return this.f3804a;
    }
}
