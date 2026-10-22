package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import A0.d;
import H8.AbstractC0241b;
import H8.AbstractC0244e;
import H8.C0243d;
import H8.C0245f;
import H8.h;
import H8.j;
import H8.m;
import H8.r;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* loaded from: classes4.dex */
public final class JvmProtoBuf$StringTableTypes extends GeneratedMessageLite {
    public static final JvmProtoBuf$StringTableTypes g;
    public static final B8.a h = new B8.a(23);

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0244e f5090a;
    public List b;
    public List c;
    public int d;
    public byte e;
    public int f;

    static {
        JvmProtoBuf$StringTableTypes jvmProtoBuf$StringTableTypes = new JvmProtoBuf$StringTableTypes();
        g = jvmProtoBuf$StringTableTypes;
        List list = Collections.EMPTY_LIST;
        jvmProtoBuf$StringTableTypes.b = list;
        jvmProtoBuf$StringTableTypes.c = list;
    }

    public JvmProtoBuf$StringTableTypes(a aVar) {
        this.d = -1;
        this.e = (byte) -1;
        this.f = -1;
        this.f5090a = aVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int iH = 0;
        for (int i6 = 0; i6 < this.b.size(); i6++) {
            iH += d.h(1, (AbstractC0241b) this.b.get(i6));
        }
        int iG = 0;
        for (int i10 = 0; i10 < this.c.size(); i10++) {
            iG += d.g(((Integer) this.c.get(i10)).intValue());
        }
        int iG2 = iH + iG;
        if (!this.c.isEmpty()) {
            iG2 = iG2 + 1 + d.g(iG);
        }
        this.d = iG;
        int size = this.f5090a.size() + iG2;
        this.f = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final j b() {
        a aVar = new a();
        List list = Collections.EMPTY_LIST;
        aVar.c = list;
        aVar.d = list;
        return aVar;
    }

    @Override // H8.AbstractC0241b
    public final j c() {
        a aVar = new a();
        List list = Collections.EMPTY_LIST;
        aVar.c = list;
        aVar.d = list;
        aVar.e(this);
        return aVar;
    }

    @Override // H8.AbstractC0241b
    public final void d(d dVar) throws IOException {
        a();
        for (int i = 0; i < this.b.size(); i++) {
            dVar.s(1, (AbstractC0241b) this.b.get(i));
        }
        if (this.c.size() > 0) {
            dVar.z(42);
            dVar.z(this.d);
        }
        for (int i6 = 0; i6 < this.c.size(); i6++) {
            dVar.r(((Integer) this.c.get(i6)).intValue());
        }
        dVar.v(this.f5090a);
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
        this.e = (byte) 1;
        return true;
    }

    public static final class Record extends GeneratedMessageLite {
        public static final Record m;
        public static final b n = new b();

        /* renamed from: a, reason: collision with root package name */
        public final AbstractC0244e f5091a;
        public int b;
        public int c;
        public int d;
        public Object e;
        public Operation f;
        public List g;
        public int h;
        public List i;

        /* renamed from: j, reason: collision with root package name */
        public int f5092j;
        public byte k;
        public int l;

        public enum Operation implements m {
            NONE(0),
            INTERNAL_TO_CLASS_ID(1),
            DESC_TO_CLASS_ID(2);


            /* renamed from: a, reason: collision with root package name */
            public final int f5093a;

            Operation(int i) {
                this.f5093a = i;
            }

            @Override // H8.m
            public final int getNumber() {
                return this.f5093a;
            }
        }

        static {
            Record record = new Record();
            m = record;
            record.c = 1;
            record.d = 0;
            record.e = "";
            record.f = Operation.NONE;
            List list = Collections.EMPTY_LIST;
            record.g = list;
            record.i = list;
        }

        public Record(c cVar) {
            this.h = -1;
            this.f5092j = -1;
            this.k = (byte) -1;
            this.l = -1;
            this.f5091a = cVar.f774a;
        }

        @Override // H8.AbstractC0241b
        public final int a() {
            AbstractC0244e rVar;
            int i = this.l;
            if (i != -1) {
                return i;
            }
            int iF = (this.b & 1) == 1 ? d.f(1, this.c) : 0;
            if ((this.b & 2) == 2) {
                iF += d.f(2, this.d);
            }
            if ((this.b & 8) == 8) {
                iF += d.e(3, this.f.f5093a);
            }
            int iG = 0;
            for (int i6 = 0; i6 < this.g.size(); i6++) {
                iG += d.g(((Integer) this.g.get(i6)).intValue());
            }
            int iG2 = iF + iG;
            if (!this.g.isEmpty()) {
                iG2 = iG2 + 1 + d.g(iG);
            }
            this.h = iG;
            int iG3 = 0;
            for (int i10 = 0; i10 < this.i.size(); i10++) {
                iG3 += d.g(((Integer) this.i.get(i10)).intValue());
            }
            int size = iG2 + iG3;
            if (!this.i.isEmpty()) {
                size = size + 1 + d.g(iG3);
            }
            this.f5092j = iG3;
            if ((this.b & 4) == 4) {
                Object obj = this.e;
                if (obj instanceof String) {
                    try {
                        rVar = new r(((String) obj).getBytes("UTF-8"));
                        this.e = rVar;
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException("UTF-8 not supported?", e);
                    }
                } else {
                    rVar = (AbstractC0244e) obj;
                }
                size += rVar.size() + d.j(rVar.size()) + d.l(6);
            }
            int size2 = this.f5091a.size() + size;
            this.l = size2;
            return size2;
        }

        @Override // H8.AbstractC0241b
        public final j b() {
            return c.e();
        }

        @Override // H8.AbstractC0241b
        public final j c() {
            c cVarE = c.e();
            cVarE.f(this);
            return cVarE;
        }

        @Override // H8.AbstractC0241b
        public final void d(d dVar) throws IOException {
            AbstractC0244e rVar;
            a();
            if ((this.b & 1) == 1) {
                dVar.q(1, this.c);
            }
            if ((this.b & 2) == 2) {
                dVar.q(2, this.d);
            }
            if ((this.b & 8) == 8) {
                dVar.p(3, this.f.f5093a);
            }
            if (this.g.size() > 0) {
                dVar.z(34);
                dVar.z(this.h);
            }
            for (int i = 0; i < this.g.size(); i++) {
                dVar.r(((Integer) this.g.get(i)).intValue());
            }
            if (this.i.size() > 0) {
                dVar.z(42);
                dVar.z(this.f5092j);
            }
            for (int i6 = 0; i6 < this.i.size(); i6++) {
                dVar.r(((Integer) this.i.get(i6)).intValue());
            }
            if ((this.b & 4) == 4) {
                Object obj = this.e;
                if (obj instanceof String) {
                    try {
                        rVar = new r(((String) obj).getBytes("UTF-8"));
                        this.e = rVar;
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException("UTF-8 not supported?", e);
                    }
                } else {
                    rVar = (AbstractC0244e) obj;
                }
                dVar.B(6, 2);
                dVar.z(rVar.size());
                dVar.v(rVar);
            }
            dVar.v(this.f5091a);
        }

        @Override // H8.s
        public final boolean isInitialized() {
            byte b = this.k;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.k = (byte) 1;
            return true;
        }

        public Record() {
            this.h = -1;
            this.f5092j = -1;
            this.k = (byte) -1;
            this.l = -1;
            this.f5091a = AbstractC0244e.f769a;
        }

        public Record(C0245f c0245f) {
            Operation operation;
            this.h = -1;
            this.f5092j = -1;
            this.k = (byte) -1;
            this.l = -1;
            this.c = 1;
            boolean z10 = false;
            this.d = 0;
            this.e = "";
            Operation operation2 = Operation.NONE;
            this.f = operation2;
            List list = Collections.EMPTY_LIST;
            this.g = list;
            this.i = list;
            C0243d c0243d = new C0243d();
            d dVarN = d.n(c0243d, 1);
            int i = 0;
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
                            } else if (iN == 24) {
                                int iK = c0245f.k();
                                if (iK == 0) {
                                    operation = operation2;
                                } else if (iK != 1) {
                                    operation = iK != 2 ? null : Operation.DESC_TO_CLASS_ID;
                                } else {
                                    operation = Operation.INTERNAL_TO_CLASS_ID;
                                }
                                if (operation == null) {
                                    dVarN.z(iN);
                                    dVarN.z(iK);
                                } else {
                                    this.b |= 8;
                                    this.f = operation;
                                }
                            } else if (iN == 32) {
                                if ((i & 16) != 16) {
                                    this.g = new ArrayList();
                                    i |= 16;
                                }
                                this.g.add(Integer.valueOf(c0245f.k()));
                            } else if (iN == 34) {
                                int iD = c0245f.d(c0245f.k());
                                if ((i & 16) != 16 && c0245f.b() > 0) {
                                    this.g = new ArrayList();
                                    i |= 16;
                                }
                                while (c0245f.b() > 0) {
                                    this.g.add(Integer.valueOf(c0245f.k()));
                                }
                                c0245f.c(iD);
                            } else if (iN == 40) {
                                if ((i & 32) != 32) {
                                    this.i = new ArrayList();
                                    i |= 32;
                                }
                                this.i.add(Integer.valueOf(c0245f.k()));
                            } else if (iN == 42) {
                                int iD2 = c0245f.d(c0245f.k());
                                if ((i & 32) != 32 && c0245f.b() > 0) {
                                    this.i = new ArrayList();
                                    i |= 32;
                                }
                                while (c0245f.b() > 0) {
                                    this.i.add(Integer.valueOf(c0245f.k()));
                                }
                                c0245f.c(iD2);
                            } else if (iN != 50) {
                                if (!c0245f.q(iN, dVarN)) {
                                }
                            } else {
                                r rVarE = c0245f.e();
                                this.b |= 4;
                                this.e = rVarE;
                            }
                        }
                        z10 = true;
                    } catch (Throwable th) {
                        if ((i & 16) == 16) {
                            this.g = Collections.unmodifiableList(this.g);
                        }
                        if ((i & 32) == 32) {
                            this.i = Collections.unmodifiableList(this.i);
                        }
                        try {
                            dVarN.m();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.f5091a = c0243d.f();
                            throw th2;
                        }
                        this.f5091a = c0243d.f();
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
            }
            if ((i & 16) == 16) {
                this.g = Collections.unmodifiableList(this.g);
            }
            if ((i & 32) == 32) {
                this.i = Collections.unmodifiableList(this.i);
            }
            try {
                dVarN.m();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f5091a = c0243d.f();
                throw th3;
            }
            this.f5091a = c0243d.f();
        }
    }

    public JvmProtoBuf$StringTableTypes() {
        this.d = -1;
        this.e = (byte) -1;
        this.f = -1;
        this.f5090a = AbstractC0244e.f769a;
    }

    public JvmProtoBuf$StringTableTypes(C0245f c0245f, h hVar) {
        this.d = -1;
        this.e = (byte) -1;
        this.f = -1;
        List list = Collections.EMPTY_LIST;
        this.b = list;
        this.c = list;
        C0243d c0243d = new C0243d();
        d dVarN = d.n(c0243d, 1);
        boolean z10 = false;
        int i = 0;
        while (!z10) {
            try {
                try {
                    try {
                        int iN = c0245f.n();
                        if (iN != 0) {
                            if (iN == 10) {
                                if ((i & 1) != 1) {
                                    this.b = new ArrayList();
                                    i |= 1;
                                }
                                this.b.add(c0245f.g(Record.n, hVar));
                            } else if (iN == 40) {
                                if ((i & 2) != 2) {
                                    this.c = new ArrayList();
                                    i |= 2;
                                }
                                this.c.add(Integer.valueOf(c0245f.k()));
                            } else if (iN != 42) {
                                if (!c0245f.q(iN, dVarN)) {
                                }
                            } else {
                                int iD = c0245f.d(c0245f.k());
                                if ((i & 2) != 2 && c0245f.b() > 0) {
                                    this.c = new ArrayList();
                                    i |= 2;
                                }
                                while (c0245f.b() > 0) {
                                    this.c.add(Integer.valueOf(c0245f.k()));
                                }
                                c0245f.c(iD);
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
                if ((i & 1) == 1) {
                    this.b = Collections.unmodifiableList(this.b);
                }
                if ((i & 2) == 2) {
                    this.c = Collections.unmodifiableList(this.c);
                }
                try {
                    dVarN.m();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f5090a = c0243d.f();
                    throw th2;
                }
                this.f5090a = c0243d.f();
                throw th;
            }
        }
        if ((i & 1) == 1) {
            this.b = Collections.unmodifiableList(this.b);
        }
        if ((i & 2) == 2) {
            this.c = Collections.unmodifiableList(this.c);
        }
        try {
            dVarN.m();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f5090a = c0243d.f();
            throw th3;
        }
        this.f5090a = c0243d.f();
    }
}
