package kotlin.reflect.jvm.internal.impl.metadata;

import ia.AbstractC4182b;
import ia.InterfaceC4187g;
import ia.InterfaceC4188h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.c;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* loaded from: classes5.dex */
public final class ProtoBuf$EnumEntry extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$EnumEntry> implements InterfaceC4187g {

    /* renamed from: i, reason: collision with root package name */
    public static final ProtoBuf$EnumEntry f35393i;

    /* renamed from: j, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$EnumEntry> f35394j = new a();

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC4182b f35395c;

    /* renamed from: d, reason: collision with root package name */
    public int f35396d;

    /* renamed from: e, reason: collision with root package name */
    public int f35397e;

    /* renamed from: f, reason: collision with root package name */
    public List<ProtoBuf$Annotation> f35398f;

    /* renamed from: g, reason: collision with root package name */
    public byte f35399g;

    /* renamed from: h, reason: collision with root package name */
    public int f35400h;

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$EnumEntry> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$EnumEntry c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$EnumEntry(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.c<ProtoBuf$EnumEntry, b> implements InterfaceC4187g {

        /* renamed from: d, reason: collision with root package name */
        public int f35401d;

        /* renamed from: e, reason: collision with root package name */
        public int f35402e;

        /* renamed from: f, reason: collision with root package name */
        public List<ProtoBuf$Annotation> f35403f = Collections.EMPTY_LIST;

        public b() {
            w();
        }

        public static b u() {
            return new b();
        }

        private void v() {
            if ((this.f35401d & 2) != 2) {
                this.f35403f = new ArrayList(this.f35403f);
                this.f35401d |= 2;
            }
        }

        private void w() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$EnumEntry build() {
            ProtoBuf$EnumEntry protoBuf$EnumEntryS = s();
            if (protoBuf$EnumEntryS.isInitialized()) {
                return protoBuf$EnumEntryS;
            }
            throw a.AbstractC0449a.f(protoBuf$EnumEntryS);
        }

        public ProtoBuf$EnumEntry s() {
            ProtoBuf$EnumEntry protoBuf$EnumEntry = new ProtoBuf$EnumEntry(this);
            int i10 = (this.f35401d & 1) != 1 ? 0 : 1;
            protoBuf$EnumEntry.f35397e = this.f35402e;
            if ((this.f35401d & 2) == 2) {
                this.f35403f = Collections.unmodifiableList(this.f35403f);
                this.f35401d &= -3;
            }
            protoBuf$EnumEntry.f35398f = this.f35403f;
            protoBuf$EnumEntry.f35396d = i10;
            return protoBuf$EnumEntry;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b g() {
            return u().i(s());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$EnumEntry protoBuf$EnumEntry) {
            if (protoBuf$EnumEntry == ProtoBuf$EnumEntry.H()) {
                return this;
            }
            if (protoBuf$EnumEntry.L()) {
                z(protoBuf$EnumEntry.K());
            }
            if (!protoBuf$EnumEntry.f35398f.isEmpty()) {
                if (this.f35403f.isEmpty()) {
                    this.f35403f = protoBuf$EnumEntry.f35398f;
                    this.f35401d &= -3;
                } else {
                    v();
                    this.f35403f.addAll(protoBuf$EnumEntry.f35398f);
                }
            }
            p(protoBuf$EnumEntry);
            j(h().c(protoBuf$EnumEntry.f35395c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry.f35394j     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                if (r3 == 0) goto Le
                r2.i(r3)
            Le:
                return r2
            Lf:
                r3 = move-exception
                goto L1b
            L11:
                r3 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.h r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry) r4     // Catch: java.lang.Throwable -> Lf
                throw r3     // Catch: java.lang.Throwable -> L19
            L19:
                r3 = move-exception
                r0 = r4
            L1b:
                if (r0 == 0) goto L20
                r2.i(r0)
            L20:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry$b");
        }

        public b z(int i10) {
            this.f35401d |= 1;
            this.f35402e = i10;
            return this;
        }
    }

    static {
        ProtoBuf$EnumEntry protoBuf$EnumEntry = new ProtoBuf$EnumEntry(true);
        f35393i = protoBuf$EnumEntry;
        protoBuf$EnumEntry.M();
    }

    public static ProtoBuf$EnumEntry H() {
        return f35393i;
    }

    private void M() {
        this.f35397e = 0;
        this.f35398f = Collections.EMPTY_LIST;
    }

    public static b N() {
        return b.u();
    }

    public static b O(ProtoBuf$EnumEntry protoBuf$EnumEntry) {
        return N().i(protoBuf$EnumEntry);
    }

    public ProtoBuf$Annotation E(int i10) {
        return this.f35398f.get(i10);
    }

    public int F() {
        return this.f35398f.size();
    }

    public List<ProtoBuf$Annotation> G() {
        return this.f35398f;
    }

    @Override // ia.InterfaceC4187g
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public ProtoBuf$EnumEntry getDefaultInstanceForType() {
        return f35393i;
    }

    public int K() {
        return this.f35397e;
    }

    public boolean L() {
        return (this.f35396d & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return N();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return O(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.a aVarW = w();
        if ((this.f35396d & 1) == 1) {
            codedOutputStream.a0(1, this.f35397e);
        }
        for (int i10 = 0; i10 < this.f35398f.size(); i10++) {
            codedOutputStream.d0(2, this.f35398f.get(i10));
        }
        aVarW.a(200, codedOutputStream);
        codedOutputStream.i0(this.f35395c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$EnumEntry> getParserForType() {
        return f35394j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35400h;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f35396d & 1) == 1 ? CodedOutputStream.o(1, this.f35397e) : 0;
        for (int i11 = 0; i11 < this.f35398f.size(); i11++) {
            iO += CodedOutputStream.s(2, this.f35398f.get(i11));
        }
        int iQ = iO + q() + this.f35395c.size();
        this.f35400h = iQ;
        return iQ;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35399g;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < F(); i10++) {
            if (!E(i10).isInitialized()) {
                this.f35399g = (byte) 0;
                return false;
            }
        }
        if (n()) {
            this.f35399g = (byte) 1;
            return true;
        }
        this.f35399g = (byte) 0;
        return false;
    }

    public ProtoBuf$EnumEntry(GeneratedMessageLite.c<ProtoBuf$EnumEntry, ?> cVar) {
        super(cVar);
        this.f35399g = (byte) -1;
        this.f35400h = -1;
        this.f35395c = cVar.h();
    }

    public ProtoBuf$EnumEntry(boolean z10) {
        this.f35399g = (byte) -1;
        this.f35400h = -1;
        this.f35395c = AbstractC4182b.f33086a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBuf$EnumEntry(c cVar, d dVar) throws InvalidProtocolBufferException {
        this.f35399g = (byte) -1;
        this.f35400h = -1;
        M();
        AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
        boolean z10 = false;
        char c10 = 0;
        while (!z10) {
            try {
                try {
                    int iK = cVar.K();
                    if (iK != 0) {
                        if (iK == 8) {
                            this.f35396d |= 1;
                            this.f35397e = cVar.s();
                        } else if (iK != 18) {
                            if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                            }
                        } else {
                            if ((c10 & 2) != 2) {
                                this.f35398f = new ArrayList();
                                c10 = 2;
                            }
                            this.f35398f.add(cVar.u(ProtoBuf$Annotation.f35233i, dVar));
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if ((c10 & 2) == 2) {
                        this.f35398f = Collections.unmodifiableList(this.f35398f);
                    }
                    try {
                        codedOutputStreamJ.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f35395c = c0409bT.l();
                        throw th2;
                    }
                    this.f35395c = c0409bT.l();
                    g();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e10) {
                throw e10.i(this);
            } catch (IOException e11) {
                throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
            }
        }
        if ((c10 & 2) == 2) {
            this.f35398f = Collections.unmodifiableList(this.f35398f);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f35395c = c0409bT.l();
            throw th3;
        }
        this.f35395c = c0409bT.l();
        g();
    }
}
