package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0244e;
import H8.C0243d;
import H8.C0245f;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* loaded from: classes4.dex */
public final class ProtoBuf$VersionRequirement extends GeneratedMessageLite {
    public static final ProtoBuf$VersionRequirement k;
    public static final B8.a l = new B8.a(18);

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0244e f5079a;
    public int b;
    public int c;
    public int d;
    public Level e;
    public int f;
    public int g;
    public VersionKind h;
    public byte i;

    /* renamed from: j, reason: collision with root package name */
    public int f5080j;

    public enum Level implements H8.m {
        WARNING(0),
        ERROR(1),
        HIDDEN(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f5081a;

        Level(int i) {
            this.f5081a = i;
        }

        @Override // H8.m
        public final int getNumber() {
            return this.f5081a;
        }
    }

    public enum VersionKind implements H8.m {
        LANGUAGE_VERSION(0),
        COMPILER_VERSION(1),
        API_VERSION(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f5082a;

        VersionKind(int i) {
            this.f5082a = i;
        }

        @Override // H8.m
        public final int getNumber() {
            return this.f5082a;
        }
    }

    static {
        ProtoBuf$VersionRequirement protoBuf$VersionRequirement = new ProtoBuf$VersionRequirement();
        k = protoBuf$VersionRequirement;
        protoBuf$VersionRequirement.c = 0;
        protoBuf$VersionRequirement.d = 0;
        protoBuf$VersionRequirement.e = Level.ERROR;
        protoBuf$VersionRequirement.f = 0;
        protoBuf$VersionRequirement.g = 0;
        protoBuf$VersionRequirement.h = VersionKind.LANGUAGE_VERSION;
    }

    public ProtoBuf$VersionRequirement(o oVar) {
        this.i = (byte) -1;
        this.f5080j = -1;
        this.f5079a = oVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.f5080j;
        if (i != -1) {
            return i;
        }
        int iF = (this.b & 1) == 1 ? A0.d.f(1, this.c) : 0;
        if ((this.b & 2) == 2) {
            iF += A0.d.f(2, this.d);
        }
        if ((this.b & 4) == 4) {
            iF += A0.d.e(3, this.e.f5081a);
        }
        if ((this.b & 8) == 8) {
            iF += A0.d.f(4, this.f);
        }
        if ((this.b & 16) == 16) {
            iF += A0.d.f(5, this.g);
        }
        if ((this.b & 32) == 32) {
            iF += A0.d.e(6, this.h.f5082a);
        }
        int size = this.f5079a.size() + iF;
        this.f5080j = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        return o.e();
    }

    @Override // H8.AbstractC0241b
    public final H8.j c() {
        o oVarE = o.e();
        oVarE.f(this);
        return oVarE;
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
            dVar.p(3, this.e.f5081a);
        }
        if ((this.b & 8) == 8) {
            dVar.q(4, this.f);
        }
        if ((this.b & 16) == 16) {
            dVar.q(5, this.g);
        }
        if ((this.b & 32) == 32) {
            dVar.p(6, this.h.f5082a);
        }
        dVar.v(this.f5079a);
    }

    @Override // H8.s
    public final boolean isInitialized() {
        byte b = this.i;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.i = (byte) 1;
        return true;
    }

    public ProtoBuf$VersionRequirement() {
        this.i = (byte) -1;
        this.f5080j = -1;
        this.f5079a = AbstractC0244e.f769a;
    }

    public ProtoBuf$VersionRequirement(C0245f c0245f) {
        this.i = (byte) -1;
        this.f5080j = -1;
        boolean z10 = false;
        this.c = 0;
        this.d = 0;
        Level level = Level.ERROR;
        this.e = level;
        this.f = 0;
        this.g = 0;
        VersionKind versionKind = VersionKind.LANGUAGE_VERSION;
        this.h = versionKind;
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
                        } else if (iN != 16) {
                            VersionKind versionKind2 = null;
                            Level level2 = null;
                            if (iN == 24) {
                                int iK = c0245f.k();
                                if (iK == 0) {
                                    level2 = Level.WARNING;
                                } else if (iK == 1) {
                                    level2 = level;
                                } else if (iK == 2) {
                                    level2 = Level.HIDDEN;
                                }
                                if (level2 == null) {
                                    dVarN.z(iN);
                                    dVarN.z(iK);
                                } else {
                                    this.b |= 4;
                                    this.e = level2;
                                }
                            } else if (iN == 32) {
                                this.b |= 8;
                                this.f = c0245f.k();
                            } else if (iN == 40) {
                                this.b |= 16;
                                this.g = c0245f.k();
                            } else if (iN != 48) {
                                if (!c0245f.q(iN, dVarN)) {
                                }
                            } else {
                                int iK2 = c0245f.k();
                                if (iK2 == 0) {
                                    versionKind2 = versionKind;
                                } else if (iK2 == 1) {
                                    versionKind2 = VersionKind.COMPILER_VERSION;
                                } else if (iK2 == 2) {
                                    versionKind2 = VersionKind.API_VERSION;
                                }
                                if (versionKind2 == null) {
                                    dVarN.z(iN);
                                    dVarN.z(iK2);
                                } else {
                                    this.b |= 32;
                                    this.h = versionKind2;
                                }
                            }
                        } else {
                            this.b |= 2;
                            this.d = c0245f.k();
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
                    this.f5079a = c0243d.f();
                    throw th2;
                }
                this.f5079a = c0243d.f();
                throw th;
            }
        }
        try {
            dVarN.m();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f5079a = c0243d.f();
            throw th3;
        }
        this.f5079a = c0243d.f();
    }
}
