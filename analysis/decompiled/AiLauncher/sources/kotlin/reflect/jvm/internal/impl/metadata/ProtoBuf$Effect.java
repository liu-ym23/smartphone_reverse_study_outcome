package kotlin.reflect.jvm.internal.impl.metadata;

import ia.AbstractC4182b;
import ia.InterfaceC4187g;
import ia.InterfaceC4188h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.c;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.f;

/* loaded from: classes5.dex */
public final class ProtoBuf$Effect extends GeneratedMessageLite implements InterfaceC4187g {

    /* renamed from: k, reason: collision with root package name */
    public static final ProtoBuf$Effect f35376k;

    /* renamed from: l, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$Effect> f35377l = new a();

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC4182b f35378b;

    /* renamed from: c, reason: collision with root package name */
    public int f35379c;

    /* renamed from: d, reason: collision with root package name */
    public EffectType f35380d;

    /* renamed from: e, reason: collision with root package name */
    public List<ProtoBuf$Expression> f35381e;

    /* renamed from: f, reason: collision with root package name */
    public ProtoBuf$Expression f35382f;

    /* renamed from: g, reason: collision with root package name */
    public InvocationKind f35383g;

    /* renamed from: h, reason: collision with root package name */
    public EffectConditionKind f35384h;

    /* renamed from: i, reason: collision with root package name */
    public byte f35385i;

    /* renamed from: j, reason: collision with root package name */
    public int f35386j;

    public enum EffectConditionKind implements f.a {
        CONCLUSION_CONDITION(0, 0),
        RETURNS_CONDITION(1, 1),
        HOLDSIN_CONDITION(2, 2);

        private static f.b<EffectConditionKind> internalValueMap = new a();
        private final int value;

        public static class a implements f.b<EffectConditionKind> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public EffectConditionKind findValueByNumber(int i10) {
                return EffectConditionKind.valueOf(i10);
            }
        }

        EffectConditionKind(int i10, int i11) {
            this.value = i11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.a
        public final int getNumber() {
            return this.value;
        }

        public static EffectConditionKind valueOf(int i10) {
            if (i10 == 0) {
                return CONCLUSION_CONDITION;
            }
            if (i10 == 1) {
                return RETURNS_CONDITION;
            }
            if (i10 != 2) {
                return null;
            }
            return HOLDSIN_CONDITION;
        }
    }

    public enum EffectType implements f.a {
        RETURNS_CONSTANT(0, 0),
        CALLS(1, 1),
        RETURNS_NOT_NULL(2, 2);

        private static f.b<EffectType> internalValueMap = new a();
        private final int value;

        public static class a implements f.b<EffectType> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public EffectType findValueByNumber(int i10) {
                return EffectType.valueOf(i10);
            }
        }

        EffectType(int i10, int i11) {
            this.value = i11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.a
        public final int getNumber() {
            return this.value;
        }

        public static EffectType valueOf(int i10) {
            if (i10 == 0) {
                return RETURNS_CONSTANT;
            }
            if (i10 == 1) {
                return CALLS;
            }
            if (i10 != 2) {
                return null;
            }
            return RETURNS_NOT_NULL;
        }
    }

    public enum InvocationKind implements f.a {
        AT_MOST_ONCE(0, 0),
        EXACTLY_ONCE(1, 1),
        AT_LEAST_ONCE(2, 2);

        private static f.b<InvocationKind> internalValueMap = new a();
        private final int value;

        public static class a implements f.b<InvocationKind> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public InvocationKind findValueByNumber(int i10) {
                return InvocationKind.valueOf(i10);
            }
        }

        InvocationKind(int i10, int i11) {
            this.value = i11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.a
        public final int getNumber() {
            return this.value;
        }

        public static InvocationKind valueOf(int i10) {
            if (i10 == 0) {
                return AT_MOST_ONCE;
            }
            if (i10 == 1) {
                return EXACTLY_ONCE;
            }
            if (i10 != 2) {
                return null;
            }
            return AT_LEAST_ONCE;
        }
    }

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$Effect> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Effect c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$Effect(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.b<ProtoBuf$Effect, b> implements InterfaceC4187g {

        /* renamed from: b, reason: collision with root package name */
        public int f35387b;

        /* renamed from: c, reason: collision with root package name */
        public EffectType f35388c = EffectType.RETURNS_CONSTANT;

        /* renamed from: d, reason: collision with root package name */
        public List<ProtoBuf$Expression> f35389d = Collections.EMPTY_LIST;

        /* renamed from: e, reason: collision with root package name */
        public ProtoBuf$Expression f35390e = ProtoBuf$Expression.F();

        /* renamed from: f, reason: collision with root package name */
        public InvocationKind f35391f = InvocationKind.AT_MOST_ONCE;

        /* renamed from: g, reason: collision with root package name */
        public EffectConditionKind f35392g = EffectConditionKind.CONCLUSION_CONDITION;

        public b() {
            s();
        }

        public static b q() {
            return new b();
        }

        private void s() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Effect build() {
            ProtoBuf$Effect protoBuf$EffectO = o();
            if (protoBuf$EffectO.isInitialized()) {
                return protoBuf$EffectO;
            }
            throw a.AbstractC0449a.f(protoBuf$EffectO);
        }

        public ProtoBuf$Effect o() {
            ProtoBuf$Effect protoBuf$Effect = new ProtoBuf$Effect(this);
            int i10 = this.f35387b;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            protoBuf$Effect.f35380d = this.f35388c;
            if ((this.f35387b & 2) == 2) {
                this.f35389d = Collections.unmodifiableList(this.f35389d);
                this.f35387b &= -3;
            }
            protoBuf$Effect.f35381e = this.f35389d;
            if ((i10 & 4) == 4) {
                i11 |= 2;
            }
            protoBuf$Effect.f35382f = this.f35390e;
            if ((i10 & 8) == 8) {
                i11 |= 4;
            }
            protoBuf$Effect.f35383g = this.f35391f;
            if ((i10 & 16) == 16) {
                i11 |= 8;
            }
            protoBuf$Effect.f35384h = this.f35392g;
            protoBuf$Effect.f35379c = i11;
            return protoBuf$Effect;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b g() {
            return q().i(o());
        }

        public final void r() {
            if ((this.f35387b & 2) != 2) {
                this.f35389d = new ArrayList(this.f35389d);
                this.f35387b |= 2;
            }
        }

        public b t(ProtoBuf$Expression protoBuf$Expression) {
            if ((this.f35387b & 4) != 4 || this.f35390e == ProtoBuf$Expression.F()) {
                this.f35390e = protoBuf$Expression;
            } else {
                this.f35390e = ProtoBuf$Expression.V(this.f35390e).i(protoBuf$Expression).o();
            }
            this.f35387b |= 4;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$Effect protoBuf$Effect) {
            if (protoBuf$Effect == ProtoBuf$Effect.z()) {
                return this;
            }
            if (protoBuf$Effect.J()) {
                x(protoBuf$Effect.E());
            }
            if (!protoBuf$Effect.f35381e.isEmpty()) {
                if (this.f35389d.isEmpty()) {
                    this.f35389d = protoBuf$Effect.f35381e;
                    this.f35387b &= -3;
                } else {
                    r();
                    this.f35389d.addAll(protoBuf$Effect.f35381e);
                }
            }
            if (protoBuf$Effect.G()) {
                t(protoBuf$Effect.x());
            }
            if (protoBuf$Effect.K()) {
                y(protoBuf$Effect.F());
            }
            if (protoBuf$Effect.H()) {
                w(protoBuf$Effect.y());
            }
            j(h().c(protoBuf$Effect.f35378b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect.f35377l     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect$b");
        }

        public b w(EffectConditionKind effectConditionKind) {
            effectConditionKind.getClass();
            this.f35387b |= 16;
            this.f35392g = effectConditionKind;
            return this;
        }

        public b x(EffectType effectType) {
            effectType.getClass();
            this.f35387b |= 1;
            this.f35388c = effectType;
            return this;
        }

        public b y(InvocationKind invocationKind) {
            invocationKind.getClass();
            this.f35387b |= 8;
            this.f35391f = invocationKind;
            return this;
        }
    }

    static {
        ProtoBuf$Effect protoBuf$Effect = new ProtoBuf$Effect(true);
        f35376k = protoBuf$Effect;
        protoBuf$Effect.L();
    }

    private void L() {
        this.f35380d = EffectType.RETURNS_CONSTANT;
        this.f35381e = Collections.EMPTY_LIST;
        this.f35382f = ProtoBuf$Expression.F();
        this.f35383g = InvocationKind.AT_MOST_ONCE;
        this.f35384h = EffectConditionKind.CONCLUSION_CONDITION;
    }

    public static b M() {
        return b.q();
    }

    public static b N(ProtoBuf$Effect protoBuf$Effect) {
        return M().i(protoBuf$Effect);
    }

    public static ProtoBuf$Effect z() {
        return f35376k;
    }

    public ProtoBuf$Expression A(int i10) {
        return this.f35381e.get(i10);
    }

    public int C() {
        return this.f35381e.size();
    }

    public List<ProtoBuf$Expression> D() {
        return this.f35381e;
    }

    public EffectType E() {
        return this.f35380d;
    }

    public InvocationKind F() {
        return this.f35383g;
    }

    public boolean G() {
        return (this.f35379c & 2) == 2;
    }

    public boolean H() {
        return (this.f35379c & 8) == 8;
    }

    public boolean J() {
        return (this.f35379c & 1) == 1;
    }

    public boolean K() {
        return (this.f35379c & 4) == 4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return M();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return N(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f35379c & 1) == 1) {
            codedOutputStream.S(1, this.f35380d.getNumber());
        }
        for (int i10 = 0; i10 < this.f35381e.size(); i10++) {
            codedOutputStream.d0(2, this.f35381e.get(i10));
        }
        if ((this.f35379c & 2) == 2) {
            codedOutputStream.d0(3, this.f35382f);
        }
        if ((this.f35379c & 4) == 4) {
            codedOutputStream.S(4, this.f35383g.getNumber());
        }
        if ((this.f35379c & 8) == 8) {
            codedOutputStream.S(5, this.f35384h.getNumber());
        }
        codedOutputStream.i0(this.f35378b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$Effect> getParserForType() {
        return f35377l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35386j;
        if (i10 != -1) {
            return i10;
        }
        int iH = (this.f35379c & 1) == 1 ? CodedOutputStream.h(1, this.f35380d.getNumber()) : 0;
        for (int i11 = 0; i11 < this.f35381e.size(); i11++) {
            iH += CodedOutputStream.s(2, this.f35381e.get(i11));
        }
        if ((this.f35379c & 2) == 2) {
            iH += CodedOutputStream.s(3, this.f35382f);
        }
        if ((this.f35379c & 4) == 4) {
            iH += CodedOutputStream.h(4, this.f35383g.getNumber());
        }
        if ((this.f35379c & 8) == 8) {
            iH += CodedOutputStream.h(5, this.f35384h.getNumber());
        }
        int size = iH + this.f35378b.size();
        this.f35386j = size;
        return size;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35385i;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < C(); i10++) {
            if (!A(i10).isInitialized()) {
                this.f35385i = (byte) 0;
                return false;
            }
        }
        if (!G() || x().isInitialized()) {
            this.f35385i = (byte) 1;
            return true;
        }
        this.f35385i = (byte) 0;
        return false;
    }

    public ProtoBuf$Expression x() {
        return this.f35382f;
    }

    public EffectConditionKind y() {
        return this.f35384h;
    }

    public ProtoBuf$Effect(GeneratedMessageLite.b bVar) {
        super(bVar);
        this.f35385i = (byte) -1;
        this.f35386j = -1;
        this.f35378b = bVar.h();
    }

    public ProtoBuf$Effect(boolean z10) {
        this.f35385i = (byte) -1;
        this.f35386j = -1;
        this.f35378b = AbstractC4182b.f33086a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBuf$Effect(c cVar, d dVar) throws InvalidProtocolBufferException {
        this.f35385i = (byte) -1;
        this.f35386j = -1;
        L();
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
                            int iN = cVar.n();
                            EffectType effectTypeValueOf = EffectType.valueOf(iN);
                            if (effectTypeValueOf == null) {
                                codedOutputStreamJ.o0(iK);
                                codedOutputStreamJ.o0(iN);
                            } else {
                                this.f35379c |= 1;
                                this.f35380d = effectTypeValueOf;
                            }
                        } else if (iK == 18) {
                            if ((c10 & 2) != 2) {
                                this.f35381e = new ArrayList();
                                c10 = 2;
                            }
                            this.f35381e.add(cVar.u(ProtoBuf$Expression.f35405n, dVar));
                        } else if (iK == 26) {
                            ProtoBuf$Expression.b builder = (this.f35379c & 2) == 2 ? this.f35382f.toBuilder() : null;
                            ProtoBuf$Expression protoBuf$Expression = (ProtoBuf$Expression) cVar.u(ProtoBuf$Expression.f35405n, dVar);
                            this.f35382f = protoBuf$Expression;
                            if (builder != null) {
                                builder.i(protoBuf$Expression);
                                this.f35382f = builder.o();
                            }
                            this.f35379c |= 2;
                        } else if (iK == 32) {
                            int iN2 = cVar.n();
                            InvocationKind invocationKindValueOf = InvocationKind.valueOf(iN2);
                            if (invocationKindValueOf == null) {
                                codedOutputStreamJ.o0(iK);
                                codedOutputStreamJ.o0(iN2);
                            } else {
                                this.f35379c |= 4;
                                this.f35383g = invocationKindValueOf;
                            }
                        } else if (iK != 40) {
                            if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                            }
                        } else {
                            int iN3 = cVar.n();
                            EffectConditionKind effectConditionKindValueOf = EffectConditionKind.valueOf(iN3);
                            if (effectConditionKindValueOf == null) {
                                codedOutputStreamJ.o0(iK);
                                codedOutputStreamJ.o0(iN3);
                            } else {
                                this.f35379c |= 8;
                                this.f35384h = effectConditionKindValueOf;
                            }
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if ((c10 & 2) == 2) {
                        this.f35381e = Collections.unmodifiableList(this.f35381e);
                    }
                    try {
                        codedOutputStreamJ.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f35378b = c0409bT.l();
                        throw th2;
                    }
                    this.f35378b = c0409bT.l();
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
            this.f35381e = Collections.unmodifiableList(this.f35381e);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f35378b = c0409bT.l();
            throw th3;
        }
        this.f35378b = c0409bT.l();
        g();
    }
}
