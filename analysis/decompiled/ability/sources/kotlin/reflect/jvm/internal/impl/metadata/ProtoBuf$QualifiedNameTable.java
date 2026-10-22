package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import H8.AbstractC0244e;
import H8.C0243d;
import H8.C0245f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* loaded from: classes4.dex */
public final class ProtoBuf$QualifiedNameTable extends GeneratedMessageLite {
    public static final ProtoBuf$QualifiedNameTable e;
    public static final B8.a f = new B8.a(11);

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0244e f5063a;
    public List b;
    public byte c;
    public int d;

    static {
        ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable = new ProtoBuf$QualifiedNameTable();
        e = protoBuf$QualifiedNameTable;
        protoBuf$QualifiedNameTable.b = Collections.EMPTY_LIST;
    }

    public ProtoBuf$QualifiedNameTable(h hVar) {
        this.c = (byte) -1;
        this.d = -1;
        this.f5063a = hVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iH = 0;
        for (int i6 = 0; i6 < this.b.size(); i6++) {
            iH += A0.d.h(1, (AbstractC0241b) this.b.get(i6));
        }
        int size = this.f5063a.size() + iH;
        this.d = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        h hVar = new h();
        hVar.c = Collections.EMPTY_LIST;
        return hVar;
    }

    @Override // H8.AbstractC0241b
    public final H8.j c() {
        h hVar = new h();
        hVar.c = Collections.EMPTY_LIST;
        hVar.e(this);
        return hVar;
    }

    @Override // H8.AbstractC0241b
    public final void d(A0.d dVar) throws IOException {
        a();
        for (int i = 0; i < this.b.size(); i++) {
            dVar.s(1, (AbstractC0241b) this.b.get(i));
        }
        dVar.v(this.f5063a);
    }

    @Override // H8.s
    public final boolean isInitialized() {
        byte b = this.c;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        for (int i = 0; i < this.b.size(); i++) {
            if (!((QualifiedName) this.b.get(i)).isInitialized()) {
                this.c = (byte) 0;
                return false;
            }
        }
        this.c = (byte) 1;
        return true;
    }

    public static final class QualifiedName extends GeneratedMessageLite {
        public static final QualifiedName h;
        public static final i i = new i();

        /* renamed from: a, reason: collision with root package name */
        public final AbstractC0244e f5064a;
        public int b;
        public int c;
        public int d;
        public Kind e;
        public byte f;
        public int g;

        public enum Kind implements H8.m {
            CLASS(0),
            PACKAGE(1),
            LOCAL(2);


            /* renamed from: a, reason: collision with root package name */
            public final int f5065a;

            Kind(int i) {
                this.f5065a = i;
            }

            @Override // H8.m
            public final int getNumber() {
                return this.f5065a;
            }
        }

        static {
            QualifiedName qualifiedName = new QualifiedName();
            h = qualifiedName;
            qualifiedName.c = -1;
            qualifiedName.d = 0;
            qualifiedName.e = Kind.PACKAGE;
        }

        public QualifiedName(j jVar) {
            this.f = (byte) -1;
            this.g = -1;
            this.f5064a = jVar.f774a;
        }

        @Override // H8.AbstractC0241b
        public final int a() {
            int i6 = this.g;
            if (i6 != -1) {
                return i6;
            }
            int iF = (this.b & 1) == 1 ? A0.d.f(1, this.c) : 0;
            if ((this.b & 2) == 2) {
                iF += A0.d.f(2, this.d);
            }
            if ((this.b & 4) == 4) {
                iF += A0.d.e(3, this.e.f5065a);
            }
            int size = this.f5064a.size() + iF;
            this.g = size;
            return size;
        }

        @Override // H8.AbstractC0241b
        public final H8.j b() {
            return j.e();
        }

        @Override // H8.AbstractC0241b
        public final H8.j c() {
            j jVarE = j.e();
            jVarE.f(this);
            return jVarE;
        }

        @Override // H8.AbstractC0241b
        public final void d(A0.d dVar) throws IOException {
            a();
            if ((this.b & 1) == 1) {
                dVar.q(1, this.c);
            }
            if ((this.b & 2) == 2) {
                dVar.q(2, this.d);
            }
            if ((this.b & 4) == 4) {
                dVar.p(3, this.e.f5065a);
            }
            dVar.v(this.f5064a);
        }

        @Override // H8.s
        public final boolean isInitialized() {
            byte b = this.f;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if ((this.b & 2) == 2) {
                this.f = (byte) 1;
                return true;
            }
            this.f = (byte) 0;
            return false;
        }

        public QualifiedName() {
            this.f = (byte) -1;
            this.g = -1;
            this.f5064a = AbstractC0244e.f769a;
        }

        public QualifiedName(C0245f c0245f) {
            Kind kind;
            this.f = (byte) -1;
            this.g = -1;
            this.c = -1;
            boolean z10 = false;
            this.d = 0;
            Kind kind2 = Kind.PACKAGE;
            this.e = kind2;
            C0243d c0243d = new C0243d();
            A0.d dVarN = A0.d.n(c0243d, 1);
            while (!z10) {
                try {
                    try {
                        int iN = c0245f.n();
                        if (iN != 0) {
                            if (iN == 8) {
                                this.b |= 1;
                                this.c = c0245f.k();
                            } else if (iN == 16) {
                                this.b |= 2;
                                this.d = c0245f.k();
                            } else if (iN != 24) {
                                if (!c0245f.q(iN, dVarN)) {
                                }
                            } else {
                                int iK = c0245f.k();
                                if (iK == 0) {
                                    kind = Kind.CLASS;
                                } else if (iK != 1) {
                                    kind = iK != 2 ? null : Kind.LOCAL;
                                } else {
                                    kind = kind2;
                                }
                                if (kind == null) {
                                    dVarN.z(iN);
                                    dVarN.z(iK);
                                } else {
                                    this.b |= 4;
                                    this.e = kind;
                                }
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
                    try {
                        dVarN.m();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f5064a = c0243d.f();
                        throw th2;
                    }
                    this.f5064a = c0243d.f();
                    throw th;
                }
            }
            try {
                dVarN.m();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f5064a = c0243d.f();
                throw th3;
            }
            this.f5064a = c0243d.f();
        }
    }

    public ProtoBuf$QualifiedNameTable() {
        this.c = (byte) -1;
        this.d = -1;
        this.f5063a = AbstractC0244e.f769a;
    }

    public ProtoBuf$QualifiedNameTable(C0245f c0245f, H8.h hVar) {
        this.c = (byte) -1;
        this.d = -1;
        this.b = Collections.EMPTY_LIST;
        C0243d c0243d = new C0243d();
        A0.d dVarN = A0.d.n(c0243d, 1);
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    int iN = c0245f.n();
                    if (iN != 0) {
                        if (iN != 10) {
                            if (!c0245f.q(iN, dVarN)) {
                            }
                        } else {
                            if (!z11) {
                                this.b = new ArrayList();
                                z11 = true;
                            }
                            this.b.add(c0245f.g(QualifiedName.i, hVar));
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if (z11) {
                        this.b = Collections.unmodifiableList(this.b);
                    }
                    try {
                        dVarN.m();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f5063a = c0243d.f();
                        throw th2;
                    }
                    this.f5063a = c0243d.f();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e6) {
                e6.f5100a = this;
                throw e6;
            } catch (IOException e9) {
                InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e9.getMessage());
                invalidProtocolBufferException.f5100a = this;
                throw invalidProtocolBufferException;
            }
        }
        if (z11) {
            this.b = Collections.unmodifiableList(this.b);
        }
        try {
            dVarN.m();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f5063a = c0243d.f();
            throw th3;
        }
        this.f5063a = c0243d.f();
    }
}
