package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import H8.AbstractC0244e;
import H8.C0243d;
import H8.C0245f;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import org.java_websocket.WebSocketImpl;

/* loaded from: classes4.dex */
public final class ProtoBuf$Annotation extends GeneratedMessageLite {
    public static final ProtoBuf$Annotation g;
    public static final B8.a h = new B8.a(0);

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0244e f5011a;
    public int b;
    public int c;
    public List d;
    public byte e;
    public int f;

    static {
        ProtoBuf$Annotation protoBuf$Annotation = new ProtoBuf$Annotation();
        g = protoBuf$Annotation;
        protoBuf$Annotation.c = 0;
        protoBuf$Annotation.d = Collections.EMPTY_LIST;
    }

    public ProtoBuf$Annotation(e eVar) {
        this.e = (byte) -1;
        this.f = -1;
        this.f5011a = eVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int iF = (this.b & 1) == 1 ? A0.d.f(1, this.c) : 0;
        for (int i6 = 0; i6 < this.d.size(); i6++) {
            iF += A0.d.h(2, (AbstractC0241b) this.d.get(i6));
        }
        int size = this.f5011a.size() + iF;
        this.f = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        e eVar = new e();
        eVar.d = Collections.EMPTY_LIST;
        return eVar;
    }

    @Override // H8.AbstractC0241b
    public final H8.j c() {
        e eVar = new e();
        eVar.d = Collections.EMPTY_LIST;
        eVar.e(this);
        return eVar;
    }

    @Override // H8.AbstractC0241b
    public final void d(A0.d dVar) throws IOException {
        a();
        if ((this.b & 1) == 1) {
            dVar.q(1, this.c);
        }
        for (int i = 0; i < this.d.size(); i++) {
            dVar.s(2, (AbstractC0241b) this.d.get(i));
        }
        dVar.v(this.f5011a);
    }

    @Override // H8.s
    public final boolean isInitialized() {
        byte b = this.e;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if ((this.b & 1) != 1) {
            this.e = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.d.size(); i++) {
            if (!((Argument) this.d.get(i)).isInitialized()) {
                this.e = (byte) 0;
                return false;
            }
        }
        this.e = (byte) 1;
        return true;
    }

    public static final class Argument extends GeneratedMessageLite {
        public static final Argument g;
        public static final a h = new a();

        /* renamed from: a, reason: collision with root package name */
        public final AbstractC0244e f5012a;
        public int b;
        public int c;
        public Value d;
        public byte e;
        public int f;

        static {
            Argument argument = new Argument();
            g = argument;
            argument.c = 0;
            argument.d = Value.p;
        }

        public Argument(b bVar) {
            this.e = (byte) -1;
            this.f = -1;
            this.f5012a = bVar.f774a;
        }

        @Override // H8.AbstractC0241b
        public final int a() {
            int i = this.f;
            if (i != -1) {
                return i;
            }
            int iF = (this.b & 1) == 1 ? A0.d.f(1, this.c) : 0;
            if ((this.b & 2) == 2) {
                iF += A0.d.h(2, this.d);
            }
            int size = this.f5012a.size() + iF;
            this.f = size;
            return size;
        }

        @Override // H8.AbstractC0241b
        public final H8.j b() {
            b bVar = new b();
            bVar.d = Value.p;
            return bVar;
        }

        @Override // H8.AbstractC0241b
        public final H8.j c() {
            b bVar = new b();
            bVar.d = Value.p;
            bVar.e(this);
            return bVar;
        }

        @Override // H8.AbstractC0241b
        public final void d(A0.d dVar) throws IOException {
            a();
            if ((this.b & 1) == 1) {
                dVar.q(1, this.c);
            }
            if ((this.b & 2) == 2) {
                dVar.s(2, this.d);
            }
            dVar.v(this.f5012a);
        }

        @Override // H8.s
        public final boolean isInitialized() {
            byte b = this.e;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            int i = this.b;
            if ((i & 1) != 1) {
                this.e = (byte) 0;
                return false;
            }
            if ((i & 2) != 2) {
                this.e = (byte) 0;
                return false;
            }
            if (this.d.isInitialized()) {
                this.e = (byte) 1;
                return true;
            }
            this.e = (byte) 0;
            return false;
        }

        public static final class Value extends GeneratedMessageLite {
            public static final Value p;

            /* renamed from: q, reason: collision with root package name */
            public static final c f5013q = new c();

            /* renamed from: a, reason: collision with root package name */
            public final AbstractC0244e f5014a;
            public int b;
            public Type c;
            public long d;
            public float e;
            public double f;
            public int g;
            public int h;
            public int i;

            /* renamed from: j, reason: collision with root package name */
            public ProtoBuf$Annotation f5015j;
            public List k;
            public int l;
            public int m;
            public byte n;
            public int o;

            public enum Type implements H8.m {
                BYTE(0),
                CHAR(1),
                SHORT(2),
                INT(3),
                LONG(4),
                FLOAT(5),
                DOUBLE(6),
                BOOLEAN(7),
                STRING(8),
                CLASS(9),
                ENUM(10),
                ANNOTATION(11),
                ARRAY(12);


                /* renamed from: a, reason: collision with root package name */
                public final int f5017a;

                Type(int i) {
                    this.f5017a = i;
                }

                public static Type a(int i) {
                    switch (i) {
                        case 0:
                            return BYTE;
                        case 1:
                            return CHAR;
                        case 2:
                            return SHORT;
                        case 3:
                            return INT;
                        case 4:
                            return LONG;
                        case 5:
                            return FLOAT;
                        case 6:
                            return DOUBLE;
                        case 7:
                            return BOOLEAN;
                        case 8:
                            return STRING;
                        case 9:
                            return CLASS;
                        case 10:
                            return ENUM;
                        case 11:
                            return ANNOTATION;
                        case 12:
                            return ARRAY;
                        default:
                            return null;
                    }
                }

                @Override // H8.m
                public final int getNumber() {
                    return this.f5017a;
                }
            }

            static {
                Value value = new Value();
                p = value;
                value.g();
            }

            public Value(d dVar) {
                this.n = (byte) -1;
                this.o = -1;
                this.f5014a = dVar.f774a;
            }

            @Override // H8.AbstractC0241b
            public final int a() {
                int i = this.o;
                if (i != -1) {
                    return i;
                }
                int iE = (this.b & 1) == 1 ? A0.d.e(1, this.c.f5017a) : 0;
                if ((this.b & 2) == 2) {
                    long j5 = this.d;
                    iE += A0.d.k((j5 >> 63) ^ (j5 << 1)) + A0.d.l(2);
                }
                if ((this.b & 4) == 4) {
                    iE += A0.d.l(3) + 4;
                }
                if ((this.b & 8) == 8) {
                    iE += A0.d.l(4) + 8;
                }
                if ((this.b & 16) == 16) {
                    iE += A0.d.f(5, this.g);
                }
                if ((this.b & 32) == 32) {
                    iE += A0.d.f(6, this.h);
                }
                if ((this.b & 64) == 64) {
                    iE += A0.d.f(7, this.i);
                }
                if ((this.b & 128) == 128) {
                    iE += A0.d.h(8, this.f5015j);
                }
                for (int i6 = 0; i6 < this.k.size(); i6++) {
                    iE += A0.d.h(9, (AbstractC0241b) this.k.get(i6));
                }
                if ((this.b & 512) == 512) {
                    iE += A0.d.f(10, this.m);
                }
                if ((this.b & 256) == 256) {
                    iE += A0.d.f(11, this.l);
                }
                int size = this.f5014a.size() + iE;
                this.o = size;
                return size;
            }

            @Override // H8.AbstractC0241b
            public final H8.j b() {
                return d.e();
            }

            @Override // H8.AbstractC0241b
            public final H8.j c() {
                d dVarE = d.e();
                dVarE.f(this);
                return dVarE;
            }

            @Override // H8.AbstractC0241b
            public final void d(A0.d dVar) throws IOException {
                a();
                if ((this.b & 1) == 1) {
                    dVar.p(1, this.c.f5017a);
                }
                if ((this.b & 2) == 2) {
                    long j5 = this.d;
                    dVar.B(2, 0);
                    dVar.A((j5 >> 63) ^ (j5 << 1));
                }
                if ((this.b & 4) == 4) {
                    float f = this.e;
                    dVar.B(3, 5);
                    dVar.x(Float.floatToRawIntBits(f));
                }
                if ((this.b & 8) == 8) {
                    double d = this.f;
                    dVar.B(4, 1);
                    dVar.y(Double.doubleToRawLongBits(d));
                }
                if ((this.b & 16) == 16) {
                    dVar.q(5, this.g);
                }
                if ((this.b & 32) == 32) {
                    dVar.q(6, this.h);
                }
                if ((this.b & 64) == 64) {
                    dVar.q(7, this.i);
                }
                if ((this.b & 128) == 128) {
                    dVar.s(8, this.f5015j);
                }
                for (int i = 0; i < this.k.size(); i++) {
                    dVar.s(9, (AbstractC0241b) this.k.get(i));
                }
                if ((this.b & 512) == 512) {
                    dVar.q(10, this.m);
                }
                if ((this.b & 256) == 256) {
                    dVar.q(11, this.l);
                }
                dVar.v(this.f5014a);
            }

            public final void g() {
                this.c = Type.BYTE;
                this.d = 0L;
                this.e = 0.0f;
                this.f = 0.0d;
                this.g = 0;
                this.h = 0;
                this.i = 0;
                this.f5015j = ProtoBuf$Annotation.g;
                this.k = Collections.EMPTY_LIST;
                this.l = 0;
                this.m = 0;
            }

            @Override // H8.s
            public final boolean isInitialized() {
                byte b = this.n;
                if (b == 1) {
                    return true;
                }
                if (b == 0) {
                    return false;
                }
                if ((this.b & 128) == 128 && !this.f5015j.isInitialized()) {
                    this.n = (byte) 0;
                    return false;
                }
                for (int i = 0; i < this.k.size(); i++) {
                    if (!((Value) this.k.get(i)).isInitialized()) {
                        this.n = (byte) 0;
                        return false;
                    }
                }
                this.n = (byte) 1;
                return true;
            }

            public Value() {
                this.n = (byte) -1;
                this.o = -1;
                this.f5014a = AbstractC0244e.f769a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v0 */
            /* JADX WARN: Type inference failed for: r5v1 */
            /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
            public Value(C0245f c0245f, H8.h hVar) {
                e eVar;
                this.n = (byte) -1;
                this.o = -1;
                g();
                C0243d c0243d = new C0243d();
                A0.d dVarN = A0.d.n(c0243d, 1);
                boolean z10 = false;
                char c = 0;
                while (true) {
                    ?? Q6 = 256;
                    if (!z10) {
                        try {
                            try {
                                int iN = c0245f.n();
                                switch (iN) {
                                    case 0:
                                        z10 = true;
                                    case 8:
                                        int iK = c0245f.k();
                                        Type typeA = Type.a(iK);
                                        if (typeA == null) {
                                            dVarN.z(iN);
                                            dVarN.z(iK);
                                        } else {
                                            this.b |= 1;
                                            this.c = typeA;
                                        }
                                    case 16:
                                        this.b |= 2;
                                        long jL = c0245f.l();
                                        this.d = (-(jL & 1)) ^ (jL >>> 1);
                                    case 29:
                                        this.b |= 4;
                                        this.e = Float.intBitsToFloat(c0245f.i());
                                    case 33:
                                        this.b |= 8;
                                        this.f = Double.longBitsToDouble(c0245f.j());
                                    case 40:
                                        this.b |= 16;
                                        this.g = c0245f.k();
                                    case 48:
                                        this.b |= 32;
                                        this.h = c0245f.k();
                                    case 56:
                                        this.b |= 64;
                                        this.i = c0245f.k();
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                        if ((this.b & 128) == 128) {
                                            ProtoBuf$Annotation protoBuf$Annotation = this.f5015j;
                                            protoBuf$Annotation.getClass();
                                            eVar = new e();
                                            eVar.d = Collections.EMPTY_LIST;
                                            eVar.e(protoBuf$Annotation);
                                        } else {
                                            eVar = null;
                                        }
                                        ProtoBuf$Annotation protoBuf$Annotation2 = (ProtoBuf$Annotation) c0245f.g(ProtoBuf$Annotation.h, hVar);
                                        this.f5015j = protoBuf$Annotation2;
                                        if (eVar != null) {
                                            eVar.e(protoBuf$Annotation2);
                                            this.f5015j = eVar.d();
                                        }
                                        this.b |= 128;
                                    case 74:
                                        if ((c & 256) != 256) {
                                            this.k = new ArrayList();
                                            c = 256;
                                        }
                                        this.k.add(c0245f.g(f5013q, hVar));
                                    case WebSocketImpl.DEFAULT_PORT /* 80 */:
                                        this.b |= 512;
                                        this.m = c0245f.k();
                                    case 88:
                                        this.b |= 256;
                                        this.l = c0245f.k();
                                    default:
                                        Q6 = c0245f.q(iN, dVarN);
                                        if (Q6 == 0) {
                                            z10 = true;
                                        }
                                }
                            } catch (Throwable th) {
                                if ((c & 256) == Q6) {
                                    this.k = Collections.unmodifiableList(this.k);
                                }
                                try {
                                    dVarN.m();
                                } catch (IOException unused) {
                                } catch (Throwable th2) {
                                    this.f5014a = c0243d.f();
                                    throw th2;
                                }
                                this.f5014a = c0243d.f();
                                throw th;
                            }
                        } catch (InvalidProtocolBufferException e) {
                            e.f5100a = this;
                            throw e;
                        } catch (IOException e6) {
                            InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e6.getMessage());
                            invalidProtocolBufferException.f5100a = this;
                            throw invalidProtocolBufferException;
                        }
                    } else {
                        if ((c & 256) == 256) {
                            this.k = Collections.unmodifiableList(this.k);
                        }
                        try {
                            dVarN.m();
                        } catch (IOException unused2) {
                        } catch (Throwable th3) {
                            this.f5014a = c0243d.f();
                            throw th3;
                        }
                        this.f5014a = c0243d.f();
                        return;
                    }
                }
            }
        }

        public Argument() {
            this.e = (byte) -1;
            this.f = -1;
            this.f5012a = AbstractC0244e.f769a;
        }

        public Argument(C0245f c0245f, H8.h hVar) {
            d dVarE;
            this.e = (byte) -1;
            this.f = -1;
            boolean z10 = false;
            this.c = 0;
            this.d = Value.p;
            C0243d c0243d = new C0243d();
            A0.d dVarN = A0.d.n(c0243d, 1);
            while (!z10) {
                try {
                    try {
                        try {
                            int iN = c0245f.n();
                            if (iN != 0) {
                                if (iN == 8) {
                                    this.b |= 1;
                                    this.c = c0245f.k();
                                } else if (iN != 18) {
                                    if (!c0245f.q(iN, dVarN)) {
                                    }
                                } else {
                                    if ((this.b & 2) == 2) {
                                        Value value = this.d;
                                        value.getClass();
                                        dVarE = d.e();
                                        dVarE.f(value);
                                    } else {
                                        dVarE = null;
                                    }
                                    Value value2 = (Value) c0245f.g(Value.f5013q, hVar);
                                    this.d = value2;
                                    if (dVarE != null) {
                                        dVarE.f(value2);
                                        this.d = dVarE.d();
                                    }
                                    this.b |= 2;
                                }
                            }
                            z10 = true;
                        } catch (InvalidProtocolBufferException e) {
                            e.f5100a = this;
                            throw e;
                        }
                    } catch (IOException e6) {
                        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e6.getMessage());
                        invalidProtocolBufferException.f5100a = this;
                        throw invalidProtocolBufferException;
                    }
                } catch (Throwable th) {
                    try {
                        dVarN.m();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f5012a = c0243d.f();
                        throw th2;
                    }
                    this.f5012a = c0243d.f();
                    throw th;
                }
            }
            try {
                dVarN.m();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f5012a = c0243d.f();
                throw th3;
            }
            this.f5012a = c0243d.f();
        }
    }

    public ProtoBuf$Annotation() {
        this.e = (byte) -1;
        this.f = -1;
        this.f5011a = AbstractC0244e.f769a;
    }

    public ProtoBuf$Annotation(C0245f c0245f, H8.h hVar) {
        this.e = (byte) -1;
        this.f = -1;
        boolean z10 = false;
        this.c = 0;
        this.d = Collections.EMPTY_LIST;
        C0243d c0243d = new C0243d();
        A0.d dVarN = A0.d.n(c0243d, 1);
        char c = 0;
        while (!z10) {
            try {
                try {
                    int iN = c0245f.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.b |= 1;
                            this.c = c0245f.k();
                        } else if (iN != 18) {
                            if (!c0245f.q(iN, dVarN)) {
                            }
                        } else {
                            if ((c & 2) != 2) {
                                this.d = new ArrayList();
                                c = 2;
                            }
                            this.d.add(c0245f.g(Argument.h, hVar));
                        }
                    }
                    z10 = true;
                } catch (InvalidProtocolBufferException e) {
                    e.f5100a = this;
                    throw e;
                } catch (IOException e6) {
                    InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e6.getMessage());
                    invalidProtocolBufferException.f5100a = this;
                    throw invalidProtocolBufferException;
                }
            } catch (Throwable th) {
                if ((c & 2) == 2) {
                    this.d = Collections.unmodifiableList(this.d);
                }
                try {
                    dVarN.m();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f5011a = c0243d.f();
                    throw th2;
                }
                this.f5011a = c0243d.f();
                throw th;
            }
        }
        if ((c & 2) == 2) {
            this.d = Collections.unmodifiableList(this.d);
        }
        try {
            dVarN.m();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f5011a = c0243d.f();
            throw th3;
        }
        this.f5011a = c0243d.f();
    }
}
