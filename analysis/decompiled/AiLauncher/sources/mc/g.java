package mc;

import java.nio.ByteBuffer;
import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidDataException;

/* loaded from: classes5.dex */
public abstract class g implements f {

    /* renamed from: b, reason: collision with root package name */
    public Opcode f37213b;

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer f37214c = pc.b.a();

    /* renamed from: a, reason: collision with root package name */
    public boolean f37212a = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f37215d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f37216e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f37217f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f37218g = false;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37219a;

        static {
            int[] iArr = new int[Opcode.values().length];
            f37219a = iArr;
            try {
                iArr[Opcode.PING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37219a[Opcode.PONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37219a[Opcode.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37219a[Opcode.BINARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37219a[Opcode.CLOSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f37219a[Opcode.CONTINUOUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public g(Opcode opcode) {
        this.f37213b = opcode;
    }

    public static g g(Opcode opcode) {
        if (opcode == null) {
            throw new IllegalArgumentException("Supplied opcode cannot be null");
        }
        switch (a.f37219a[opcode.ordinal()]) {
            case 1:
                return new h();
            case 2:
                return new i();
            case 3:
                return new j();
            case 4:
                return new mc.a();
            case 5:
                return new b();
            case 6:
                return new c();
            default:
                throw new IllegalArgumentException("Supplied opcode is invalid");
        }
    }

    @Override // mc.f
    public boolean a() {
        return this.f37216e;
    }

    @Override // mc.f
    public boolean b() {
        return this.f37217f;
    }

    @Override // mc.f
    public Opcode c() {
        return this.f37213b;
    }

    @Override // mc.f
    public boolean d() {
        return this.f37218g;
    }

    @Override // mc.f
    public boolean e() {
        return this.f37212a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            g gVar = (g) obj;
            if (this.f37212a != gVar.f37212a || this.f37215d != gVar.f37215d || this.f37216e != gVar.f37216e || this.f37217f != gVar.f37217f || this.f37218g != gVar.f37218g || this.f37213b != gVar.f37213b) {
                return false;
            }
            ByteBuffer byteBuffer = this.f37214c;
            if (byteBuffer != null) {
                return byteBuffer.equals(gVar.f37214c);
            }
            if (gVar.f37214c == null) {
                return true;
            }
        }
        return false;
    }

    @Override // mc.f
    public ByteBuffer f() {
        return this.f37214c;
    }

    public abstract void h() throws InvalidDataException;

    public int hashCode() {
        int iHashCode = (((this.f37212a ? 1 : 0) * 31) + this.f37213b.hashCode()) * 31;
        ByteBuffer byteBuffer = this.f37214c;
        return ((((((((iHashCode + (byteBuffer != null ? byteBuffer.hashCode() : 0)) * 31) + (this.f37215d ? 1 : 0)) * 31) + (this.f37216e ? 1 : 0)) * 31) + (this.f37217f ? 1 : 0)) * 31) + (this.f37218g ? 1 : 0);
    }

    public void i(boolean z10) {
        this.f37212a = z10;
    }

    public void j(ByteBuffer byteBuffer) {
        this.f37214c = byteBuffer;
    }

    public void k(boolean z10) {
        this.f37216e = z10;
    }

    public void l(boolean z10) {
        this.f37217f = z10;
    }

    public void m(boolean z10) {
        this.f37218g = z10;
    }

    public void n(boolean z10) {
        this.f37215d = z10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Framedata{ opcode:");
        sb2.append(c());
        sb2.append(", fin:");
        sb2.append(e());
        sb2.append(", rsv1:");
        sb2.append(a());
        sb2.append(", rsv2:");
        sb2.append(b());
        sb2.append(", rsv3:");
        sb2.append(d());
        sb2.append(", payload length:[pos:");
        sb2.append(this.f37214c.position());
        sb2.append(", len:");
        sb2.append(this.f37214c.remaining());
        sb2.append("], payload:");
        sb2.append(this.f37214c.remaining() > 1000 ? "(too big to display)" : new String(this.f37214c.array()));
        sb2.append('}');
        return sb2.toString();
    }
}
