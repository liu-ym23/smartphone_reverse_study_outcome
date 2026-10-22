package q0;

import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import o0.C0888a;

/* renamed from: q0.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0968o implements U, p0.t {

    /* renamed from: a, reason: collision with root package name */
    public static final C0968o f19867a = new C0968o();

    /* renamed from: q0.o$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f19868a;

        /* renamed from: b, reason: collision with root package name */
        public int f19869b;

        /* renamed from: c, reason: collision with root package name */
        public int f19870c;

        public ByteBuffer a() {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.f19868a);
            byteBufferWrap.limit(this.f19869b);
            byteBufferWrap.position(this.f19870c);
            return byteBufferWrap;
        }
    }

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        byte[] bArrArray = byteBuffer.array();
        e0 e0Var = c0946i.f19676k;
        e0Var.write(123);
        e0Var.D("array");
        e0Var.x(bArrArray);
        e0Var.I(',', "limit", byteBuffer.limit());
        e0Var.I(',', "position", byteBuffer.position());
        e0Var.write(125);
    }

    @Override // p0.t
    public int d() {
        return 14;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        return (T) ((a) c0888a.h0(a.class)).a();
    }
}
