package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import ia.AbstractC4182b;
import ia.InterfaceC4187g;
import ia.InterfaceC4188h;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.c;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.f;

/* loaded from: classes5.dex */
public final class JvmProtoBuf {

    /* renamed from: a, reason: collision with root package name */
    public static final GeneratedMessageLite.e<ProtoBuf$Constructor, JvmMethodSignature> f35738a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageLite.e<ProtoBuf$Function, JvmMethodSignature> f35739b;

    /* renamed from: c, reason: collision with root package name */
    public static final GeneratedMessageLite.e<ProtoBuf$Function, Integer> f35740c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageLite.e<ProtoBuf$Property, JvmPropertySignature> f35741d;

    /* renamed from: e, reason: collision with root package name */
    public static final GeneratedMessageLite.e<ProtoBuf$Property, Integer> f35742e;

    /* renamed from: f, reason: collision with root package name */
    public static final GeneratedMessageLite.e<ProtoBuf$Type, List<ProtoBuf$Annotation>> f35743f;

    /* renamed from: g, reason: collision with root package name */
    public static final GeneratedMessageLite.e<ProtoBuf$Type, Boolean> f35744g;

    /* renamed from: h, reason: collision with root package name */
    public static final GeneratedMessageLite.e<ProtoBuf$TypeParameter, List<ProtoBuf$Annotation>> f35745h;

    /* renamed from: i, reason: collision with root package name */
    public static final GeneratedMessageLite.e<ProtoBuf$Class, Integer> f35746i;

    /* renamed from: j, reason: collision with root package name */
    public static final GeneratedMessageLite.e<ProtoBuf$Class, List<ProtoBuf$Property>> f35747j;

    /* renamed from: k, reason: collision with root package name */
    public static final GeneratedMessageLite.e<ProtoBuf$Class, Integer> f35748k;

    /* renamed from: l, reason: collision with root package name */
    public static final GeneratedMessageLite.e<ProtoBuf$Class, Integer> f35749l;

    /* renamed from: m, reason: collision with root package name */
    public static final GeneratedMessageLite.e<ProtoBuf$Package, Integer> f35750m;

    /* renamed from: n, reason: collision with root package name */
    public static final GeneratedMessageLite.e<ProtoBuf$Package, List<ProtoBuf$Property>> f35751n;

    public static final class StringTableTypes extends GeneratedMessageLite implements InterfaceC4187g {

        /* renamed from: h, reason: collision with root package name */
        public static final StringTableTypes f35791h;

        /* renamed from: i, reason: collision with root package name */
        public static InterfaceC4188h<StringTableTypes> f35792i = new a();

        /* renamed from: b, reason: collision with root package name */
        public final AbstractC4182b f35793b;

        /* renamed from: c, reason: collision with root package name */
        public List<Record> f35794c;

        /* renamed from: d, reason: collision with root package name */
        public List<Integer> f35795d;

        /* renamed from: e, reason: collision with root package name */
        public int f35796e;

        /* renamed from: f, reason: collision with root package name */
        public byte f35797f;

        /* renamed from: g, reason: collision with root package name */
        public int f35798g;

        public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<StringTableTypes> {
            @Override // ia.InterfaceC4188h
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public StringTableTypes c(c cVar, d dVar) throws InvalidProtocolBufferException {
                return new StringTableTypes(cVar, dVar);
            }
        }

        public static final class b extends GeneratedMessageLite.b<StringTableTypes, b> implements InterfaceC4187g {

            /* renamed from: b, reason: collision with root package name */
            public int f35820b;

            /* renamed from: c, reason: collision with root package name */
            public List<Record> f35821c;

            /* renamed from: d, reason: collision with root package name */
            public List<Integer> f35822d;

            public b() {
                List list = Collections.EMPTY_LIST;
                this.f35821c = list;
                this.f35822d = list;
                t();
            }

            public static b q() {
                return new b();
            }

            private void t() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public StringTableTypes build() {
                StringTableTypes stringTableTypesO = o();
                if (stringTableTypesO.isInitialized()) {
                    return stringTableTypesO;
                }
                throw a.AbstractC0449a.f(stringTableTypesO);
            }

            public StringTableTypes o() {
                StringTableTypes stringTableTypes = new StringTableTypes(this);
                if ((this.f35820b & 1) == 1) {
                    this.f35821c = Collections.unmodifiableList(this.f35821c);
                    this.f35820b &= -2;
                }
                stringTableTypes.f35794c = this.f35821c;
                if ((this.f35820b & 2) == 2) {
                    this.f35822d = Collections.unmodifiableList(this.f35822d);
                    this.f35820b &= -3;
                }
                stringTableTypes.f35795d = this.f35822d;
                return stringTableTypes;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public b g() {
                return q().i(o());
            }

            public final void r() {
                if ((this.f35820b & 2) != 2) {
                    this.f35822d = new ArrayList(this.f35822d);
                    this.f35820b |= 2;
                }
            }

            public final void s() {
                if ((this.f35820b & 1) != 1) {
                    this.f35821c = new ArrayList(this.f35821c);
                    this.f35820b |= 1;
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public b i(StringTableTypes stringTableTypes) {
                if (stringTableTypes == StringTableTypes.u()) {
                    return this;
                }
                if (!stringTableTypes.f35794c.isEmpty()) {
                    if (this.f35821c.isEmpty()) {
                        this.f35821c = stringTableTypes.f35794c;
                        this.f35820b &= -2;
                    } else {
                        s();
                        this.f35821c.addAll(stringTableTypes.f35794c);
                    }
                }
                if (!stringTableTypes.f35795d.isEmpty()) {
                    if (this.f35822d.isEmpty()) {
                        this.f35822d = stringTableTypes.f35795d;
                        this.f35820b &= -3;
                    } else {
                        r();
                        this.f35822d.addAll(stringTableTypes.f35795d);
                    }
                }
                j(h().c(stringTableTypes.f35793b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    ia.h<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.f35792i     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$b");
            }
        }

        static {
            StringTableTypes stringTableTypes = new StringTableTypes(true);
            f35791h = stringTableTypes;
            stringTableTypes.x();
        }

        public static StringTableTypes C(InputStream inputStream, d dVar) throws IOException {
            return f35792i.d(inputStream, dVar);
        }

        public static StringTableTypes u() {
            return f35791h;
        }

        private void x() {
            List list = Collections.EMPTY_LIST;
            this.f35794c = list;
            this.f35795d = list;
        }

        public static b y() {
            return b.q();
        }

        public static b z(StringTableTypes stringTableTypes) {
            return y().i(stringTableTypes);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return y();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            return z(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i10 = 0; i10 < this.f35794c.size(); i10++) {
                codedOutputStream.d0(1, this.f35794c.get(i10));
            }
            if (v().size() > 0) {
                codedOutputStream.o0(42);
                codedOutputStream.o0(this.f35796e);
            }
            for (int i11 = 0; i11 < this.f35795d.size(); i11++) {
                codedOutputStream.b0(this.f35795d.get(i11).intValue());
            }
            codedOutputStream.i0(this.f35793b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
        public InterfaceC4188h<StringTableTypes> getParserForType() {
            return f35792i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int getSerializedSize() {
            int i10 = this.f35798g;
            if (i10 != -1) {
                return i10;
            }
            int iS = 0;
            for (int i11 = 0; i11 < this.f35794c.size(); i11++) {
                iS += CodedOutputStream.s(1, this.f35794c.get(i11));
            }
            int iP = 0;
            for (int i12 = 0; i12 < this.f35795d.size(); i12++) {
                iP += CodedOutputStream.p(this.f35795d.get(i12).intValue());
            }
            int iP2 = iS + iP;
            if (!v().isEmpty()) {
                iP2 = iP2 + 1 + CodedOutputStream.p(iP);
            }
            this.f35796e = iP;
            int size = iP2 + this.f35793b.size();
            this.f35798g = size;
            return size;
        }

        @Override // ia.InterfaceC4187g
        public final boolean isInitialized() {
            byte b10 = this.f35797f;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.f35797f = (byte) 1;
            return true;
        }

        public List<Integer> v() {
            return this.f35795d;
        }

        public List<Record> w() {
            return this.f35794c;
        }

        public static final class Record extends GeneratedMessageLite implements InterfaceC4187g {

            /* renamed from: n, reason: collision with root package name */
            public static final Record f35799n;

            /* renamed from: o, reason: collision with root package name */
            public static InterfaceC4188h<Record> f35800o = new a();

            /* renamed from: b, reason: collision with root package name */
            public final AbstractC4182b f35801b;

            /* renamed from: c, reason: collision with root package name */
            public int f35802c;

            /* renamed from: d, reason: collision with root package name */
            public int f35803d;

            /* renamed from: e, reason: collision with root package name */
            public int f35804e;

            /* renamed from: f, reason: collision with root package name */
            public Object f35805f;

            /* renamed from: g, reason: collision with root package name */
            public Operation f35806g;

            /* renamed from: h, reason: collision with root package name */
            public List<Integer> f35807h;

            /* renamed from: i, reason: collision with root package name */
            public int f35808i;

            /* renamed from: j, reason: collision with root package name */
            public List<Integer> f35809j;

            /* renamed from: k, reason: collision with root package name */
            public int f35810k;

            /* renamed from: l, reason: collision with root package name */
            public byte f35811l;

            /* renamed from: m, reason: collision with root package name */
            public int f35812m;

            public enum Operation implements f.a {
                NONE(0, 0),
                INTERNAL_TO_CLASS_ID(1, 1),
                DESC_TO_CLASS_ID(2, 2);

                private static f.b<Operation> internalValueMap = new a();
                private final int value;

                public static class a implements f.b<Operation> {
                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.b
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Operation findValueByNumber(int i10) {
                        return Operation.valueOf(i10);
                    }
                }

                Operation(int i10, int i11) {
                    this.value = i11;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.a
                public final int getNumber() {
                    return this.value;
                }

                public static Operation valueOf(int i10) {
                    if (i10 == 0) {
                        return NONE;
                    }
                    if (i10 == 1) {
                        return INTERNAL_TO_CLASS_ID;
                    }
                    if (i10 != 2) {
                        return null;
                    }
                    return DESC_TO_CLASS_ID;
                }
            }

            public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Record> {
                @Override // ia.InterfaceC4188h
                /* renamed from: m, reason: merged with bridge method [inline-methods] */
                public Record c(c cVar, d dVar) throws InvalidProtocolBufferException {
                    return new Record(cVar, dVar);
                }
            }

            public static final class b extends GeneratedMessageLite.b<Record, b> implements InterfaceC4187g {

                /* renamed from: b, reason: collision with root package name */
                public int f35813b;

                /* renamed from: d, reason: collision with root package name */
                public int f35815d;

                /* renamed from: g, reason: collision with root package name */
                public List<Integer> f35818g;

                /* renamed from: h, reason: collision with root package name */
                public List<Integer> f35819h;

                /* renamed from: c, reason: collision with root package name */
                public int f35814c = 1;

                /* renamed from: e, reason: collision with root package name */
                public Object f35816e = "";

                /* renamed from: f, reason: collision with root package name */
                public Operation f35817f = Operation.NONE;

                public b() {
                    List<Integer> list = Collections.EMPTY_LIST;
                    this.f35818g = list;
                    this.f35819h = list;
                    t();
                }

                public static b q() {
                    return new b();
                }

                private void t() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public Record build() {
                    Record recordO = o();
                    if (recordO.isInitialized()) {
                        return recordO;
                    }
                    throw a.AbstractC0449a.f(recordO);
                }

                public Record o() {
                    Record record = new Record(this);
                    int i10 = this.f35813b;
                    int i11 = (i10 & 1) != 1 ? 0 : 1;
                    record.f35803d = this.f35814c;
                    if ((i10 & 2) == 2) {
                        i11 |= 2;
                    }
                    record.f35804e = this.f35815d;
                    if ((i10 & 4) == 4) {
                        i11 |= 4;
                    }
                    record.f35805f = this.f35816e;
                    if ((i10 & 8) == 8) {
                        i11 |= 8;
                    }
                    record.f35806g = this.f35817f;
                    if ((this.f35813b & 16) == 16) {
                        this.f35818g = Collections.unmodifiableList(this.f35818g);
                        this.f35813b &= -17;
                    }
                    record.f35807h = this.f35818g;
                    if ((this.f35813b & 32) == 32) {
                        this.f35819h = Collections.unmodifiableList(this.f35819h);
                        this.f35813b &= -33;
                    }
                    record.f35809j = this.f35819h;
                    record.f35802c = i11;
                    return record;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: p, reason: merged with bridge method [inline-methods] */
                public b g() {
                    return q().i(o());
                }

                public final void r() {
                    if ((this.f35813b & 32) != 32) {
                        this.f35819h = new ArrayList(this.f35819h);
                        this.f35813b |= 32;
                    }
                }

                public final void s() {
                    if ((this.f35813b & 16) != 16) {
                        this.f35818g = new ArrayList(this.f35818g);
                        this.f35813b |= 16;
                    }
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: u, reason: merged with bridge method [inline-methods] */
                public b i(Record record) {
                    if (record == Record.A()) {
                        return this;
                    }
                    if (record.O()) {
                        y(record.E());
                    }
                    if (record.N()) {
                        x(record.D());
                    }
                    if (record.P()) {
                        this.f35813b |= 4;
                        this.f35816e = record.f35805f;
                    }
                    if (record.M()) {
                        w(record.C());
                    }
                    if (!record.f35807h.isEmpty()) {
                        if (this.f35818g.isEmpty()) {
                            this.f35818g = record.f35807h;
                            this.f35813b &= -17;
                        } else {
                            s();
                            this.f35818g.addAll(record.f35807h);
                        }
                    }
                    if (!record.f35809j.isEmpty()) {
                        if (this.f35819h.isEmpty()) {
                            this.f35819h = record.f35809j;
                            this.f35813b &= -33;
                        } else {
                            r();
                            this.f35819h.addAll(record.f35809j);
                        }
                    }
                    j(h().c(record.f35801b));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
                /* renamed from: v, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
                    /*
                        r2 = this;
                        r0 = 0
                        ia.h<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.f35800o     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record) r4     // Catch: java.lang.Throwable -> Lf
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
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record$b");
                }

                public b w(Operation operation) {
                    operation.getClass();
                    this.f35813b |= 8;
                    this.f35817f = operation;
                    return this;
                }

                public b x(int i10) {
                    this.f35813b |= 2;
                    this.f35815d = i10;
                    return this;
                }

                public b y(int i10) {
                    this.f35813b |= 1;
                    this.f35814c = i10;
                    return this;
                }
            }

            static {
                Record record = new Record(true);
                f35799n = record;
                record.Q();
            }

            public static Record A() {
                return f35799n;
            }

            private void Q() {
                this.f35803d = 1;
                this.f35804e = 0;
                this.f35805f = "";
                this.f35806g = Operation.NONE;
                List<Integer> list = Collections.EMPTY_LIST;
                this.f35807h = list;
                this.f35809j = list;
            }

            public static b R() {
                return b.q();
            }

            public static b S(Record record) {
                return R().i(record);
            }

            public Operation C() {
                return this.f35806g;
            }

            public int D() {
                return this.f35804e;
            }

            public int E() {
                return this.f35803d;
            }

            public int F() {
                return this.f35809j.size();
            }

            public List<Integer> G() {
                return this.f35809j;
            }

            public String H() {
                Object obj = this.f35805f;
                if (obj instanceof String) {
                    return (String) obj;
                }
                AbstractC4182b abstractC4182b = (AbstractC4182b) obj;
                String strA = abstractC4182b.A();
                if (abstractC4182b.o()) {
                    this.f35805f = strA;
                }
                return strA;
            }

            public AbstractC4182b J() {
                Object obj = this.f35805f;
                if (!(obj instanceof String)) {
                    return (AbstractC4182b) obj;
                }
                AbstractC4182b abstractC4182bJ = AbstractC4182b.j((String) obj);
                this.f35805f = abstractC4182bJ;
                return abstractC4182bJ;
            }

            public int K() {
                return this.f35807h.size();
            }

            public List<Integer> L() {
                return this.f35807h;
            }

            public boolean M() {
                return (this.f35802c & 8) == 8;
            }

            public boolean N() {
                return (this.f35802c & 2) == 2;
            }

            public boolean O() {
                return (this.f35802c & 1) == 1;
            }

            public boolean P() {
                return (this.f35802c & 4) == 4;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
            /* renamed from: T, reason: merged with bridge method [inline-methods] */
            public b newBuilderForType() {
                return R();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
            /* renamed from: U, reason: merged with bridge method [inline-methods] */
            public b toBuilder() {
                return S(this);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
            public void a(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.f35802c & 1) == 1) {
                    codedOutputStream.a0(1, this.f35803d);
                }
                if ((this.f35802c & 2) == 2) {
                    codedOutputStream.a0(2, this.f35804e);
                }
                if ((this.f35802c & 8) == 8) {
                    codedOutputStream.S(3, this.f35806g.getNumber());
                }
                if (L().size() > 0) {
                    codedOutputStream.o0(34);
                    codedOutputStream.o0(this.f35808i);
                }
                for (int i10 = 0; i10 < this.f35807h.size(); i10++) {
                    codedOutputStream.b0(this.f35807h.get(i10).intValue());
                }
                if (G().size() > 0) {
                    codedOutputStream.o0(42);
                    codedOutputStream.o0(this.f35810k);
                }
                for (int i11 = 0; i11 < this.f35809j.size(); i11++) {
                    codedOutputStream.b0(this.f35809j.get(i11).intValue());
                }
                if ((this.f35802c & 4) == 4) {
                    codedOutputStream.O(6, J());
                }
                codedOutputStream.i0(this.f35801b);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
            public InterfaceC4188h<Record> getParserForType() {
                return f35800o;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
            public int getSerializedSize() {
                int i10 = this.f35812m;
                if (i10 != -1) {
                    return i10;
                }
                int iO = (this.f35802c & 1) == 1 ? CodedOutputStream.o(1, this.f35803d) : 0;
                if ((this.f35802c & 2) == 2) {
                    iO += CodedOutputStream.o(2, this.f35804e);
                }
                if ((this.f35802c & 8) == 8) {
                    iO += CodedOutputStream.h(3, this.f35806g.getNumber());
                }
                int iP = 0;
                for (int i11 = 0; i11 < this.f35807h.size(); i11++) {
                    iP += CodedOutputStream.p(this.f35807h.get(i11).intValue());
                }
                int iP2 = iO + iP;
                if (!L().isEmpty()) {
                    iP2 = iP2 + 1 + CodedOutputStream.p(iP);
                }
                this.f35808i = iP;
                int iP3 = 0;
                for (int i12 = 0; i12 < this.f35809j.size(); i12++) {
                    iP3 += CodedOutputStream.p(this.f35809j.get(i12).intValue());
                }
                int iD = iP2 + iP3;
                if (!G().isEmpty()) {
                    iD = iD + 1 + CodedOutputStream.p(iP3);
                }
                this.f35810k = iP3;
                if ((this.f35802c & 4) == 4) {
                    iD += CodedOutputStream.d(6, J());
                }
                int size = iD + this.f35801b.size();
                this.f35812m = size;
                return size;
            }

            @Override // ia.InterfaceC4187g
            public final boolean isInitialized() {
                byte b10 = this.f35811l;
                if (b10 == 1) {
                    return true;
                }
                if (b10 == 0) {
                    return false;
                }
                this.f35811l = (byte) 1;
                return true;
            }

            public Record(GeneratedMessageLite.b bVar) {
                super(bVar);
                this.f35808i = -1;
                this.f35810k = -1;
                this.f35811l = (byte) -1;
                this.f35812m = -1;
                this.f35801b = bVar.h();
            }

            public Record(boolean z10) {
                this.f35808i = -1;
                this.f35810k = -1;
                this.f35811l = (byte) -1;
                this.f35812m = -1;
                this.f35801b = AbstractC4182b.f33086a;
            }

            public Record(c cVar, d dVar) throws InvalidProtocolBufferException {
                this.f35808i = -1;
                this.f35810k = -1;
                this.f35811l = (byte) -1;
                this.f35812m = -1;
                Q();
                AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
                CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
                boolean z10 = false;
                int i10 = 0;
                while (!z10) {
                    try {
                        try {
                            int iK = cVar.K();
                            if (iK != 0) {
                                if (iK == 8) {
                                    this.f35802c |= 1;
                                    this.f35803d = cVar.s();
                                } else if (iK == 16) {
                                    this.f35802c |= 2;
                                    this.f35804e = cVar.s();
                                } else if (iK == 24) {
                                    int iN = cVar.n();
                                    Operation operationValueOf = Operation.valueOf(iN);
                                    if (operationValueOf == null) {
                                        codedOutputStreamJ.o0(iK);
                                        codedOutputStreamJ.o0(iN);
                                    } else {
                                        this.f35802c |= 8;
                                        this.f35806g = operationValueOf;
                                    }
                                } else if (iK == 32) {
                                    if ((i10 & 16) != 16) {
                                        this.f35807h = new ArrayList();
                                        i10 |= 16;
                                    }
                                    this.f35807h.add(Integer.valueOf(cVar.s()));
                                } else if (iK == 34) {
                                    int iJ = cVar.j(cVar.A());
                                    if ((i10 & 16) != 16 && cVar.e() > 0) {
                                        this.f35807h = new ArrayList();
                                        i10 |= 16;
                                    }
                                    while (cVar.e() > 0) {
                                        this.f35807h.add(Integer.valueOf(cVar.s()));
                                    }
                                    cVar.i(iJ);
                                } else if (iK == 40) {
                                    if ((i10 & 32) != 32) {
                                        this.f35809j = new ArrayList();
                                        i10 |= 32;
                                    }
                                    this.f35809j.add(Integer.valueOf(cVar.s()));
                                } else if (iK == 42) {
                                    int iJ2 = cVar.j(cVar.A());
                                    if ((i10 & 32) != 32 && cVar.e() > 0) {
                                        this.f35809j = new ArrayList();
                                        i10 |= 32;
                                    }
                                    while (cVar.e() > 0) {
                                        this.f35809j.add(Integer.valueOf(cVar.s()));
                                    }
                                    cVar.i(iJ2);
                                } else if (iK != 50) {
                                    if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                                    }
                                } else {
                                    AbstractC4182b abstractC4182bL = cVar.l();
                                    this.f35802c |= 4;
                                    this.f35805f = abstractC4182bL;
                                }
                            }
                            z10 = true;
                        } catch (Throwable th) {
                            if ((i10 & 16) == 16) {
                                this.f35807h = Collections.unmodifiableList(this.f35807h);
                            }
                            if ((i10 & 32) == 32) {
                                this.f35809j = Collections.unmodifiableList(this.f35809j);
                            }
                            try {
                                codedOutputStreamJ.I();
                            } catch (IOException unused) {
                            } catch (Throwable th2) {
                                this.f35801b = c0409bT.l();
                                throw th2;
                            }
                            this.f35801b = c0409bT.l();
                            g();
                            throw th;
                        }
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.i(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
                    }
                }
                if ((i10 & 16) == 16) {
                    this.f35807h = Collections.unmodifiableList(this.f35807h);
                }
                if ((i10 & 32) == 32) {
                    this.f35809j = Collections.unmodifiableList(this.f35809j);
                }
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.f35801b = c0409bT.l();
                    throw th3;
                }
                this.f35801b = c0409bT.l();
                g();
            }
        }

        public StringTableTypes(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.f35796e = -1;
            this.f35797f = (byte) -1;
            this.f35798g = -1;
            this.f35793b = bVar.h();
        }

        public StringTableTypes(boolean z10) {
            this.f35796e = -1;
            this.f35797f = (byte) -1;
            this.f35798g = -1;
            this.f35793b = AbstractC4182b.f33086a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public StringTableTypes(c cVar, d dVar) throws InvalidProtocolBufferException {
            this.f35796e = -1;
            this.f35797f = (byte) -1;
            this.f35798g = -1;
            x();
            AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
            CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
            boolean z10 = false;
            int i10 = 0;
            while (!z10) {
                try {
                    try {
                        int iK = cVar.K();
                        if (iK != 0) {
                            if (iK == 10) {
                                if ((i10 & 1) != 1) {
                                    this.f35794c = new ArrayList();
                                    i10 |= 1;
                                }
                                this.f35794c.add(cVar.u(Record.f35800o, dVar));
                            } else if (iK == 40) {
                                if ((i10 & 2) != 2) {
                                    this.f35795d = new ArrayList();
                                    i10 |= 2;
                                }
                                this.f35795d.add(Integer.valueOf(cVar.s()));
                            } else if (iK != 42) {
                                if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                                }
                            } else {
                                int iJ = cVar.j(cVar.A());
                                if ((i10 & 2) != 2 && cVar.e() > 0) {
                                    this.f35795d = new ArrayList();
                                    i10 |= 2;
                                }
                                while (cVar.e() > 0) {
                                    this.f35795d.add(Integer.valueOf(cVar.s()));
                                }
                                cVar.i(iJ);
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.i(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
                    }
                } catch (Throwable th) {
                    if ((i10 & 1) == 1) {
                        this.f35794c = Collections.unmodifiableList(this.f35794c);
                    }
                    if ((i10 & 2) == 2) {
                        this.f35795d = Collections.unmodifiableList(this.f35795d);
                    }
                    try {
                        codedOutputStreamJ.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f35793b = c0409bT.l();
                        throw th2;
                    }
                    this.f35793b = c0409bT.l();
                    g();
                    throw th;
                }
            }
            if ((i10 & 1) == 1) {
                this.f35794c = Collections.unmodifiableList(this.f35794c);
            }
            if ((i10 & 2) == 2) {
                this.f35795d = Collections.unmodifiableList(this.f35795d);
            }
            try {
                codedOutputStreamJ.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f35793b = c0409bT.l();
                throw th3;
            }
            this.f35793b = c0409bT.l();
            g();
        }
    }

    static {
        ProtoBuf$Constructor protoBuf$ConstructorQ = ProtoBuf$Constructor.Q();
        JvmMethodSignature jvmMethodSignatureT = JvmMethodSignature.t();
        JvmMethodSignature jvmMethodSignatureT2 = JvmMethodSignature.t();
        WireFormat.FieldType fieldType = WireFormat.FieldType.MESSAGE;
        f35738a = GeneratedMessageLite.i(protoBuf$ConstructorQ, jvmMethodSignatureT, jvmMethodSignatureT2, null, 100, fieldType, JvmMethodSignature.class);
        f35739b = GeneratedMessageLite.i(ProtoBuf$Function.q0(), JvmMethodSignature.t(), JvmMethodSignature.t(), null, 100, fieldType, JvmMethodSignature.class);
        ProtoBuf$Function protoBuf$FunctionQ0 = ProtoBuf$Function.q0();
        WireFormat.FieldType fieldType2 = WireFormat.FieldType.INT32;
        f35740c = GeneratedMessageLite.i(protoBuf$FunctionQ0, 0, null, null, 101, fieldType2, Integer.class);
        f35741d = GeneratedMessageLite.i(ProtoBuf$Property.z0(), JvmPropertySignature.w(), JvmPropertySignature.w(), null, 100, fieldType, JvmPropertySignature.class);
        f35742e = GeneratedMessageLite.i(ProtoBuf$Property.z0(), 0, null, null, 101, fieldType2, Integer.class);
        f35743f = GeneratedMessageLite.h(ProtoBuf$Type.X(), ProtoBuf$Annotation.x(), null, 100, fieldType, false, ProtoBuf$Annotation.class);
        f35744g = GeneratedMessageLite.i(ProtoBuf$Type.X(), Boolean.FALSE, null, null, 101, WireFormat.FieldType.BOOL, Boolean.class);
        f35745h = GeneratedMessageLite.h(ProtoBuf$TypeParameter.K(), ProtoBuf$Annotation.x(), null, 100, fieldType, false, ProtoBuf$Annotation.class);
        f35746i = GeneratedMessageLite.i(ProtoBuf$Class.B0(), 0, null, null, 101, fieldType2, Integer.class);
        f35747j = GeneratedMessageLite.h(ProtoBuf$Class.B0(), ProtoBuf$Property.z0(), null, 102, fieldType, false, ProtoBuf$Property.class);
        f35748k = GeneratedMessageLite.i(ProtoBuf$Class.B0(), 0, null, null, 103, fieldType2, Integer.class);
        f35749l = GeneratedMessageLite.i(ProtoBuf$Class.B0(), 0, null, null, 104, fieldType2, Integer.class);
        f35750m = GeneratedMessageLite.i(ProtoBuf$Package.K(), 0, null, null, 101, fieldType2, Integer.class);
        f35751n = GeneratedMessageLite.h(ProtoBuf$Package.K(), ProtoBuf$Property.z0(), null, 102, fieldType, false, ProtoBuf$Property.class);
    }

    public static void a(d dVar) {
        dVar.a(f35738a);
        dVar.a(f35739b);
        dVar.a(f35740c);
        dVar.a(f35741d);
        dVar.a(f35742e);
        dVar.a(f35743f);
        dVar.a(f35744g);
        dVar.a(f35745h);
        dVar.a(f35746i);
        dVar.a(f35747j);
        dVar.a(f35748k);
        dVar.a(f35749l);
        dVar.a(f35750m);
        dVar.a(f35751n);
    }

    public static final class JvmFieldSignature extends GeneratedMessageLite implements InterfaceC4187g {

        /* renamed from: h, reason: collision with root package name */
        public static final JvmFieldSignature f35752h;

        /* renamed from: i, reason: collision with root package name */
        public static InterfaceC4188h<JvmFieldSignature> f35753i = new a();

        /* renamed from: b, reason: collision with root package name */
        public final AbstractC4182b f35754b;

        /* renamed from: c, reason: collision with root package name */
        public int f35755c;

        /* renamed from: d, reason: collision with root package name */
        public int f35756d;

        /* renamed from: e, reason: collision with root package name */
        public int f35757e;

        /* renamed from: f, reason: collision with root package name */
        public byte f35758f;

        /* renamed from: g, reason: collision with root package name */
        public int f35759g;

        public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<JvmFieldSignature> {
            @Override // ia.InterfaceC4188h
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public JvmFieldSignature c(c cVar, d dVar) throws InvalidProtocolBufferException {
                return new JvmFieldSignature(cVar, dVar);
            }
        }

        public static final class b extends GeneratedMessageLite.b<JvmFieldSignature, b> implements InterfaceC4187g {

            /* renamed from: b, reason: collision with root package name */
            public int f35760b;

            /* renamed from: c, reason: collision with root package name */
            public int f35761c;

            /* renamed from: d, reason: collision with root package name */
            public int f35762d;

            public b() {
                r();
            }

            public static b q() {
                return new b();
            }

            private void r() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public JvmFieldSignature build() {
                JvmFieldSignature jvmFieldSignatureO = o();
                if (jvmFieldSignatureO.isInitialized()) {
                    return jvmFieldSignatureO;
                }
                throw a.AbstractC0449a.f(jvmFieldSignatureO);
            }

            public JvmFieldSignature o() {
                JvmFieldSignature jvmFieldSignature = new JvmFieldSignature(this);
                int i10 = this.f35760b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                jvmFieldSignature.f35756d = this.f35761c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                jvmFieldSignature.f35757e = this.f35762d;
                jvmFieldSignature.f35755c = i11;
                return jvmFieldSignature;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public b g() {
                return q().i(o());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b i(JvmFieldSignature jvmFieldSignature) {
                if (jvmFieldSignature == JvmFieldSignature.t()) {
                    return this;
                }
                if (jvmFieldSignature.x()) {
                    v(jvmFieldSignature.v());
                }
                if (jvmFieldSignature.w()) {
                    u(jvmFieldSignature.u());
                }
                j(h().c(jvmFieldSignature.f35754b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    ia.h<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature.f35753i     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature$b");
            }

            public b u(int i10) {
                this.f35760b |= 2;
                this.f35762d = i10;
                return this;
            }

            public b v(int i10) {
                this.f35760b |= 1;
                this.f35761c = i10;
                return this;
            }
        }

        static {
            JvmFieldSignature jvmFieldSignature = new JvmFieldSignature(true);
            f35752h = jvmFieldSignature;
            jvmFieldSignature.y();
        }

        public static b A(JvmFieldSignature jvmFieldSignature) {
            return z().i(jvmFieldSignature);
        }

        public static JvmFieldSignature t() {
            return f35752h;
        }

        private void y() {
            this.f35756d = 0;
            this.f35757e = 0;
        }

        public static b z() {
            return b.q();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return z();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            return A(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f35755c & 1) == 1) {
                codedOutputStream.a0(1, this.f35756d);
            }
            if ((this.f35755c & 2) == 2) {
                codedOutputStream.a0(2, this.f35757e);
            }
            codedOutputStream.i0(this.f35754b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
        public InterfaceC4188h<JvmFieldSignature> getParserForType() {
            return f35753i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int getSerializedSize() {
            int i10 = this.f35759g;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.f35755c & 1) == 1 ? CodedOutputStream.o(1, this.f35756d) : 0;
            if ((this.f35755c & 2) == 2) {
                iO += CodedOutputStream.o(2, this.f35757e);
            }
            int size = iO + this.f35754b.size();
            this.f35759g = size;
            return size;
        }

        @Override // ia.InterfaceC4187g
        public final boolean isInitialized() {
            byte b10 = this.f35758f;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.f35758f = (byte) 1;
            return true;
        }

        public int u() {
            return this.f35757e;
        }

        public int v() {
            return this.f35756d;
        }

        public boolean w() {
            return (this.f35755c & 2) == 2;
        }

        public boolean x() {
            return (this.f35755c & 1) == 1;
        }

        public JvmFieldSignature(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.f35758f = (byte) -1;
            this.f35759g = -1;
            this.f35754b = bVar.h();
        }

        public JvmFieldSignature(boolean z10) {
            this.f35758f = (byte) -1;
            this.f35759g = -1;
            this.f35754b = AbstractC4182b.f33086a;
        }

        public JvmFieldSignature(c cVar, d dVar) throws InvalidProtocolBufferException {
            this.f35758f = (byte) -1;
            this.f35759g = -1;
            y();
            AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
            CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int iK = cVar.K();
                        if (iK != 0) {
                            if (iK == 8) {
                                this.f35755c |= 1;
                                this.f35756d = cVar.s();
                            } else if (iK != 16) {
                                if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                                }
                            } else {
                                this.f35755c |= 2;
                                this.f35757e = cVar.s();
                            }
                        }
                        z10 = true;
                    } catch (Throwable th) {
                        try {
                            codedOutputStreamJ.I();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.f35754b = c0409bT.l();
                            throw th2;
                        }
                        this.f35754b = c0409bT.l();
                        g();
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
                }
            }
            try {
                codedOutputStreamJ.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f35754b = c0409bT.l();
                throw th3;
            }
            this.f35754b = c0409bT.l();
            g();
        }
    }

    public static final class JvmMethodSignature extends GeneratedMessageLite implements InterfaceC4187g {

        /* renamed from: h, reason: collision with root package name */
        public static final JvmMethodSignature f35763h;

        /* renamed from: i, reason: collision with root package name */
        public static InterfaceC4188h<JvmMethodSignature> f35764i = new a();

        /* renamed from: b, reason: collision with root package name */
        public final AbstractC4182b f35765b;

        /* renamed from: c, reason: collision with root package name */
        public int f35766c;

        /* renamed from: d, reason: collision with root package name */
        public int f35767d;

        /* renamed from: e, reason: collision with root package name */
        public int f35768e;

        /* renamed from: f, reason: collision with root package name */
        public byte f35769f;

        /* renamed from: g, reason: collision with root package name */
        public int f35770g;

        public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<JvmMethodSignature> {
            @Override // ia.InterfaceC4188h
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public JvmMethodSignature c(c cVar, d dVar) throws InvalidProtocolBufferException {
                return new JvmMethodSignature(cVar, dVar);
            }
        }

        public static final class b extends GeneratedMessageLite.b<JvmMethodSignature, b> implements InterfaceC4187g {

            /* renamed from: b, reason: collision with root package name */
            public int f35771b;

            /* renamed from: c, reason: collision with root package name */
            public int f35772c;

            /* renamed from: d, reason: collision with root package name */
            public int f35773d;

            public b() {
                r();
            }

            public static b q() {
                return new b();
            }

            private void r() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public JvmMethodSignature build() {
                JvmMethodSignature jvmMethodSignatureO = o();
                if (jvmMethodSignatureO.isInitialized()) {
                    return jvmMethodSignatureO;
                }
                throw a.AbstractC0449a.f(jvmMethodSignatureO);
            }

            public JvmMethodSignature o() {
                JvmMethodSignature jvmMethodSignature = new JvmMethodSignature(this);
                int i10 = this.f35771b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                jvmMethodSignature.f35767d = this.f35772c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                jvmMethodSignature.f35768e = this.f35773d;
                jvmMethodSignature.f35766c = i11;
                return jvmMethodSignature;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public b g() {
                return q().i(o());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b i(JvmMethodSignature jvmMethodSignature) {
                if (jvmMethodSignature == JvmMethodSignature.t()) {
                    return this;
                }
                if (jvmMethodSignature.x()) {
                    v(jvmMethodSignature.v());
                }
                if (jvmMethodSignature.w()) {
                    u(jvmMethodSignature.u());
                }
                j(h().c(jvmMethodSignature.f35765b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    ia.h<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.f35764i     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$b");
            }

            public b u(int i10) {
                this.f35771b |= 2;
                this.f35773d = i10;
                return this;
            }

            public b v(int i10) {
                this.f35771b |= 1;
                this.f35772c = i10;
                return this;
            }
        }

        static {
            JvmMethodSignature jvmMethodSignature = new JvmMethodSignature(true);
            f35763h = jvmMethodSignature;
            jvmMethodSignature.y();
        }

        public static b A(JvmMethodSignature jvmMethodSignature) {
            return z().i(jvmMethodSignature);
        }

        public static JvmMethodSignature t() {
            return f35763h;
        }

        private void y() {
            this.f35767d = 0;
            this.f35768e = 0;
        }

        public static b z() {
            return b.q();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return z();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            return A(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f35766c & 1) == 1) {
                codedOutputStream.a0(1, this.f35767d);
            }
            if ((this.f35766c & 2) == 2) {
                codedOutputStream.a0(2, this.f35768e);
            }
            codedOutputStream.i0(this.f35765b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
        public InterfaceC4188h<JvmMethodSignature> getParserForType() {
            return f35764i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int getSerializedSize() {
            int i10 = this.f35770g;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.f35766c & 1) == 1 ? CodedOutputStream.o(1, this.f35767d) : 0;
            if ((this.f35766c & 2) == 2) {
                iO += CodedOutputStream.o(2, this.f35768e);
            }
            int size = iO + this.f35765b.size();
            this.f35770g = size;
            return size;
        }

        @Override // ia.InterfaceC4187g
        public final boolean isInitialized() {
            byte b10 = this.f35769f;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.f35769f = (byte) 1;
            return true;
        }

        public int u() {
            return this.f35768e;
        }

        public int v() {
            return this.f35767d;
        }

        public boolean w() {
            return (this.f35766c & 2) == 2;
        }

        public boolean x() {
            return (this.f35766c & 1) == 1;
        }

        public JvmMethodSignature(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.f35769f = (byte) -1;
            this.f35770g = -1;
            this.f35765b = bVar.h();
        }

        public JvmMethodSignature(boolean z10) {
            this.f35769f = (byte) -1;
            this.f35770g = -1;
            this.f35765b = AbstractC4182b.f33086a;
        }

        public JvmMethodSignature(c cVar, d dVar) throws InvalidProtocolBufferException {
            this.f35769f = (byte) -1;
            this.f35770g = -1;
            y();
            AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
            CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int iK = cVar.K();
                        if (iK != 0) {
                            if (iK == 8) {
                                this.f35766c |= 1;
                                this.f35767d = cVar.s();
                            } else if (iK != 16) {
                                if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                                }
                            } else {
                                this.f35766c |= 2;
                                this.f35768e = cVar.s();
                            }
                        }
                        z10 = true;
                    } catch (Throwable th) {
                        try {
                            codedOutputStreamJ.I();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.f35765b = c0409bT.l();
                            throw th2;
                        }
                        this.f35765b = c0409bT.l();
                        g();
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
                }
            }
            try {
                codedOutputStreamJ.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f35765b = c0409bT.l();
                throw th3;
            }
            this.f35765b = c0409bT.l();
            g();
        }
    }

    public static final class JvmPropertySignature extends GeneratedMessageLite implements InterfaceC4187g {

        /* renamed from: k, reason: collision with root package name */
        public static final JvmPropertySignature f35774k;

        /* renamed from: l, reason: collision with root package name */
        public static InterfaceC4188h<JvmPropertySignature> f35775l = new a();

        /* renamed from: b, reason: collision with root package name */
        public final AbstractC4182b f35776b;

        /* renamed from: c, reason: collision with root package name */
        public int f35777c;

        /* renamed from: d, reason: collision with root package name */
        public JvmFieldSignature f35778d;

        /* renamed from: e, reason: collision with root package name */
        public JvmMethodSignature f35779e;

        /* renamed from: f, reason: collision with root package name */
        public JvmMethodSignature f35780f;

        /* renamed from: g, reason: collision with root package name */
        public JvmMethodSignature f35781g;

        /* renamed from: h, reason: collision with root package name */
        public JvmMethodSignature f35782h;

        /* renamed from: i, reason: collision with root package name */
        public byte f35783i;

        /* renamed from: j, reason: collision with root package name */
        public int f35784j;

        public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<JvmPropertySignature> {
            @Override // ia.InterfaceC4188h
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public JvmPropertySignature c(c cVar, d dVar) throws InvalidProtocolBufferException {
                return new JvmPropertySignature(cVar, dVar);
            }
        }

        public static final class b extends GeneratedMessageLite.b<JvmPropertySignature, b> implements InterfaceC4187g {

            /* renamed from: b, reason: collision with root package name */
            public int f35785b;

            /* renamed from: c, reason: collision with root package name */
            public JvmFieldSignature f35786c = JvmFieldSignature.t();

            /* renamed from: d, reason: collision with root package name */
            public JvmMethodSignature f35787d = JvmMethodSignature.t();

            /* renamed from: e, reason: collision with root package name */
            public JvmMethodSignature f35788e = JvmMethodSignature.t();

            /* renamed from: f, reason: collision with root package name */
            public JvmMethodSignature f35789f = JvmMethodSignature.t();

            /* renamed from: g, reason: collision with root package name */
            public JvmMethodSignature f35790g = JvmMethodSignature.t();

            public b() {
                r();
            }

            public static b q() {
                return new b();
            }

            private void r() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public JvmPropertySignature build() {
                JvmPropertySignature jvmPropertySignatureO = o();
                if (jvmPropertySignatureO.isInitialized()) {
                    return jvmPropertySignatureO;
                }
                throw a.AbstractC0449a.f(jvmPropertySignatureO);
            }

            public JvmPropertySignature o() {
                JvmPropertySignature jvmPropertySignature = new JvmPropertySignature(this);
                int i10 = this.f35785b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                jvmPropertySignature.f35778d = this.f35786c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                jvmPropertySignature.f35779e = this.f35787d;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                jvmPropertySignature.f35780f = this.f35788e;
                if ((i10 & 8) == 8) {
                    i11 |= 8;
                }
                jvmPropertySignature.f35781g = this.f35789f;
                if ((i10 & 16) == 16) {
                    i11 |= 16;
                }
                jvmPropertySignature.f35782h = this.f35790g;
                jvmPropertySignature.f35777c = i11;
                return jvmPropertySignature;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public b g() {
                return q().i(o());
            }

            public b s(JvmMethodSignature jvmMethodSignature) {
                if ((this.f35785b & 16) != 16 || this.f35790g == JvmMethodSignature.t()) {
                    this.f35790g = jvmMethodSignature;
                } else {
                    this.f35790g = JvmMethodSignature.A(this.f35790g).i(jvmMethodSignature).o();
                }
                this.f35785b |= 16;
                return this;
            }

            public b t(JvmFieldSignature jvmFieldSignature) {
                if ((this.f35785b & 1) != 1 || this.f35786c == JvmFieldSignature.t()) {
                    this.f35786c = jvmFieldSignature;
                } else {
                    this.f35786c = JvmFieldSignature.A(this.f35786c).i(jvmFieldSignature).o();
                }
                this.f35785b |= 1;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public b i(JvmPropertySignature jvmPropertySignature) {
                if (jvmPropertySignature == JvmPropertySignature.w()) {
                    return this;
                }
                if (jvmPropertySignature.E()) {
                    t(jvmPropertySignature.y());
                }
                if (jvmPropertySignature.H()) {
                    y(jvmPropertySignature.C());
                }
                if (jvmPropertySignature.F()) {
                    w(jvmPropertySignature.z());
                }
                if (jvmPropertySignature.G()) {
                    x(jvmPropertySignature.A());
                }
                if (jvmPropertySignature.D()) {
                    s(jvmPropertySignature.x());
                }
                j(h().c(jvmPropertySignature.f35776b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    ia.h<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature.f35775l     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature$b");
            }

            public b w(JvmMethodSignature jvmMethodSignature) {
                if ((this.f35785b & 4) != 4 || this.f35788e == JvmMethodSignature.t()) {
                    this.f35788e = jvmMethodSignature;
                } else {
                    this.f35788e = JvmMethodSignature.A(this.f35788e).i(jvmMethodSignature).o();
                }
                this.f35785b |= 4;
                return this;
            }

            public b x(JvmMethodSignature jvmMethodSignature) {
                if ((this.f35785b & 8) != 8 || this.f35789f == JvmMethodSignature.t()) {
                    this.f35789f = jvmMethodSignature;
                } else {
                    this.f35789f = JvmMethodSignature.A(this.f35789f).i(jvmMethodSignature).o();
                }
                this.f35785b |= 8;
                return this;
            }

            public b y(JvmMethodSignature jvmMethodSignature) {
                if ((this.f35785b & 2) != 2 || this.f35787d == JvmMethodSignature.t()) {
                    this.f35787d = jvmMethodSignature;
                } else {
                    this.f35787d = JvmMethodSignature.A(this.f35787d).i(jvmMethodSignature).o();
                }
                this.f35785b |= 2;
                return this;
            }
        }

        static {
            JvmPropertySignature jvmPropertySignature = new JvmPropertySignature(true);
            f35774k = jvmPropertySignature;
            jvmPropertySignature.J();
        }

        private void J() {
            this.f35778d = JvmFieldSignature.t();
            this.f35779e = JvmMethodSignature.t();
            this.f35780f = JvmMethodSignature.t();
            this.f35781g = JvmMethodSignature.t();
            this.f35782h = JvmMethodSignature.t();
        }

        public static b K() {
            return b.q();
        }

        public static b L(JvmPropertySignature jvmPropertySignature) {
            return K().i(jvmPropertySignature);
        }

        public static JvmPropertySignature w() {
            return f35774k;
        }

        public JvmMethodSignature A() {
            return this.f35781g;
        }

        public JvmMethodSignature C() {
            return this.f35779e;
        }

        public boolean D() {
            return (this.f35777c & 16) == 16;
        }

        public boolean E() {
            return (this.f35777c & 1) == 1;
        }

        public boolean F() {
            return (this.f35777c & 4) == 4;
        }

        public boolean G() {
            return (this.f35777c & 8) == 8;
        }

        public boolean H() {
            return (this.f35777c & 2) == 2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        /* renamed from: M, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return K();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        /* renamed from: N, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            return L(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f35777c & 1) == 1) {
                codedOutputStream.d0(1, this.f35778d);
            }
            if ((this.f35777c & 2) == 2) {
                codedOutputStream.d0(2, this.f35779e);
            }
            if ((this.f35777c & 4) == 4) {
                codedOutputStream.d0(3, this.f35780f);
            }
            if ((this.f35777c & 8) == 8) {
                codedOutputStream.d0(4, this.f35781g);
            }
            if ((this.f35777c & 16) == 16) {
                codedOutputStream.d0(5, this.f35782h);
            }
            codedOutputStream.i0(this.f35776b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
        public InterfaceC4188h<JvmPropertySignature> getParserForType() {
            return f35775l;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int getSerializedSize() {
            int i10 = this.f35784j;
            if (i10 != -1) {
                return i10;
            }
            int iS = (this.f35777c & 1) == 1 ? CodedOutputStream.s(1, this.f35778d) : 0;
            if ((this.f35777c & 2) == 2) {
                iS += CodedOutputStream.s(2, this.f35779e);
            }
            if ((this.f35777c & 4) == 4) {
                iS += CodedOutputStream.s(3, this.f35780f);
            }
            if ((this.f35777c & 8) == 8) {
                iS += CodedOutputStream.s(4, this.f35781g);
            }
            if ((this.f35777c & 16) == 16) {
                iS += CodedOutputStream.s(5, this.f35782h);
            }
            int size = iS + this.f35776b.size();
            this.f35784j = size;
            return size;
        }

        @Override // ia.InterfaceC4187g
        public final boolean isInitialized() {
            byte b10 = this.f35783i;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.f35783i = (byte) 1;
            return true;
        }

        public JvmMethodSignature x() {
            return this.f35782h;
        }

        public JvmFieldSignature y() {
            return this.f35778d;
        }

        public JvmMethodSignature z() {
            return this.f35780f;
        }

        public JvmPropertySignature(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.f35783i = (byte) -1;
            this.f35784j = -1;
            this.f35776b = bVar.h();
        }

        public JvmPropertySignature(boolean z10) {
            this.f35783i = (byte) -1;
            this.f35784j = -1;
            this.f35776b = AbstractC4182b.f33086a;
        }

        public JvmPropertySignature(c cVar, d dVar) throws InvalidProtocolBufferException {
            this.f35783i = (byte) -1;
            this.f35784j = -1;
            J();
            AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
            CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int iK = cVar.K();
                        if (iK != 0) {
                            if (iK == 10) {
                                JvmFieldSignature.b builder = (this.f35777c & 1) == 1 ? this.f35778d.toBuilder() : null;
                                JvmFieldSignature jvmFieldSignature = (JvmFieldSignature) cVar.u(JvmFieldSignature.f35753i, dVar);
                                this.f35778d = jvmFieldSignature;
                                if (builder != null) {
                                    builder.i(jvmFieldSignature);
                                    this.f35778d = builder.o();
                                }
                                this.f35777c |= 1;
                            } else if (iK == 18) {
                                JvmMethodSignature.b builder2 = (this.f35777c & 2) == 2 ? this.f35779e.toBuilder() : null;
                                JvmMethodSignature jvmMethodSignature = (JvmMethodSignature) cVar.u(JvmMethodSignature.f35764i, dVar);
                                this.f35779e = jvmMethodSignature;
                                if (builder2 != null) {
                                    builder2.i(jvmMethodSignature);
                                    this.f35779e = builder2.o();
                                }
                                this.f35777c |= 2;
                            } else if (iK == 26) {
                                JvmMethodSignature.b builder3 = (this.f35777c & 4) == 4 ? this.f35780f.toBuilder() : null;
                                JvmMethodSignature jvmMethodSignature2 = (JvmMethodSignature) cVar.u(JvmMethodSignature.f35764i, dVar);
                                this.f35780f = jvmMethodSignature2;
                                if (builder3 != null) {
                                    builder3.i(jvmMethodSignature2);
                                    this.f35780f = builder3.o();
                                }
                                this.f35777c |= 4;
                            } else if (iK == 34) {
                                JvmMethodSignature.b builder4 = (this.f35777c & 8) == 8 ? this.f35781g.toBuilder() : null;
                                JvmMethodSignature jvmMethodSignature3 = (JvmMethodSignature) cVar.u(JvmMethodSignature.f35764i, dVar);
                                this.f35781g = jvmMethodSignature3;
                                if (builder4 != null) {
                                    builder4.i(jvmMethodSignature3);
                                    this.f35781g = builder4.o();
                                }
                                this.f35777c |= 8;
                            } else if (iK != 42) {
                                if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                                }
                            } else {
                                JvmMethodSignature.b builder5 = (this.f35777c & 16) == 16 ? this.f35782h.toBuilder() : null;
                                JvmMethodSignature jvmMethodSignature4 = (JvmMethodSignature) cVar.u(JvmMethodSignature.f35764i, dVar);
                                this.f35782h = jvmMethodSignature4;
                                if (builder5 != null) {
                                    builder5.i(jvmMethodSignature4);
                                    this.f35782h = builder5.o();
                                }
                                this.f35777c |= 16;
                            }
                        }
                        z10 = true;
                    } catch (Throwable th) {
                        try {
                            codedOutputStreamJ.I();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.f35776b = c0409bT.l();
                            throw th2;
                        }
                        this.f35776b = c0409bT.l();
                        g();
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
                }
            }
            try {
                codedOutputStreamJ.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f35776b = c0409bT.l();
                throw th3;
            }
            this.f35776b = c0409bT.l();
            g();
        }
    }
}
