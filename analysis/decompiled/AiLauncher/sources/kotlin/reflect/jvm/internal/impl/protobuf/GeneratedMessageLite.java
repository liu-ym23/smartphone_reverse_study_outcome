package kotlin.reflect.jvm.internal.impl.protobuf;

import ia.AbstractC4182b;
import ia.InterfaceC4187g;
import ia.InterfaceC4188h;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.e;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* loaded from: classes5.dex */
public abstract class GeneratedMessageLite extends kotlin.reflect.jvm.internal.impl.protobuf.a implements Serializable {

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35834a;

        static {
            int[] iArr = new int[WireFormat.JavaType.values().length];
            f35834a = iArr;
            try {
                iArr[WireFormat.JavaType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35834a[WireFormat.JavaType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static abstract class b<MessageType extends GeneratedMessageLite, BuilderType extends b> extends a.AbstractC0449a<BuilderType> {

        /* renamed from: a, reason: collision with root package name */
        public AbstractC4182b f35835a = AbstractC4182b.f33086a;

        @Override // 
        public BuilderType g() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public final AbstractC4182b h() {
            return this.f35835a;
        }

        public abstract BuilderType i(MessageType messagetype);

        public final BuilderType j(AbstractC4182b abstractC4182b) {
            this.f35835a = abstractC4182b;
            return this;
        }
    }

    public static abstract class c<MessageType extends ExtendableMessage<MessageType>, BuilderType extends c<MessageType, BuilderType>> extends b<MessageType, BuilderType> implements InterfaceC4187g {

        /* renamed from: b, reason: collision with root package name */
        public kotlin.reflect.jvm.internal.impl.protobuf.e<d> f35836b = kotlin.reflect.jvm.internal.impl.protobuf.e.g();

        /* renamed from: c, reason: collision with root package name */
        public boolean f35837c;

        public final kotlin.reflect.jvm.internal.impl.protobuf.e<d> n() {
            this.f35836b.q();
            this.f35837c = false;
            return this.f35836b;
        }

        public final void o() {
            if (this.f35837c) {
                return;
            }
            this.f35836b = this.f35836b.clone();
            this.f35837c = true;
        }

        public final void p(MessageType messagetype) {
            o();
            this.f35836b.r(messagetype.f35829b);
        }
    }

    public static final class d implements e.b<d> {

        /* renamed from: a, reason: collision with root package name */
        public final f.b<?> f35838a;

        /* renamed from: b, reason: collision with root package name */
        public final int f35839b;

        /* renamed from: c, reason: collision with root package name */
        public final WireFormat.FieldType f35840c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f35841d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f35842e;

        public d(f.b<?> bVar, int i10, WireFormat.FieldType fieldType, boolean z10, boolean z11) {
            this.f35838a = bVar;
            this.f35839b = i10;
            this.f35840c = fieldType;
            this.f35841d = z10;
            this.f35842e = z11;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return this.f35839b - dVar.f35839b;
        }

        public f.b<?> b() {
            return this.f35838a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.e.b
        public h.a f(h.a aVar, h hVar) {
            return ((b) aVar).i((GeneratedMessageLite) hVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.e.b
        public WireFormat.JavaType getLiteJavaType() {
            return this.f35840c.getJavaType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.e.b
        public WireFormat.FieldType getLiteType() {
            return this.f35840c;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.e.b
        public int getNumber() {
            return this.f35839b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.e.b
        public boolean isPacked() {
            return this.f35842e;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.e.b
        public boolean isRepeated() {
            return this.f35841d;
        }
    }

    public static class e<ContainingType extends h, Type> {

        /* renamed from: a, reason: collision with root package name */
        public final ContainingType f35843a;

        /* renamed from: b, reason: collision with root package name */
        public final Type f35844b;

        /* renamed from: c, reason: collision with root package name */
        public final h f35845c;

        /* renamed from: d, reason: collision with root package name */
        public final d f35846d;

        /* renamed from: e, reason: collision with root package name */
        public final Class f35847e;

        /* renamed from: f, reason: collision with root package name */
        public final Method f35848f;

        public e(ContainingType containingtype, Type type, h hVar, d dVar, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (dVar.getLiteType() == WireFormat.FieldType.MESSAGE && hVar == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.f35843a = containingtype;
            this.f35844b = type;
            this.f35845c = hVar;
            this.f35846d = dVar;
            this.f35847e = cls;
            if (f.a.class.isAssignableFrom(cls)) {
                this.f35848f = GeneratedMessageLite.e(cls, "valueOf", Integer.TYPE);
            } else {
                this.f35848f = null;
            }
        }

        public Object a(Object obj) {
            if (!this.f35846d.isRepeated()) {
                return e(obj);
            }
            if (this.f35846d.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(e(it.next()));
            }
            return arrayList;
        }

        public ContainingType b() {
            return this.f35843a;
        }

        public h c() {
            return this.f35845c;
        }

        public int d() {
            return this.f35846d.getNumber();
        }

        public Object e(Object obj) {
            return this.f35846d.getLiteJavaType() == WireFormat.JavaType.ENUM ? GeneratedMessageLite.f(this.f35848f, null, (Integer) obj) : obj;
        }

        public Object f(Object obj) {
            return this.f35846d.getLiteJavaType() == WireFormat.JavaType.ENUM ? Integer.valueOf(((f.a) obj).getNumber()) : obj;
        }
    }

    public GeneratedMessageLite() {
    }

    public static Method e(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e10) {
            String name = cls.getName();
            String strValueOf = String.valueOf(str);
            StringBuilder sb2 = new StringBuilder(name.length() + 45 + strValueOf.length());
            sb2.append("Generated message class \"");
            sb2.append(name);
            sb2.append("\" missing method \"");
            sb2.append(strValueOf);
            sb2.append("\".");
            throw new RuntimeException(sb2.toString(), e10);
        }
    }

    public static Object f(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static <ContainingType extends h, Type> e<ContainingType, Type> h(ContainingType containingtype, h hVar, f.b<?> bVar, int i10, WireFormat.FieldType fieldType, boolean z10, Class cls) {
        return new e<>(containingtype, Collections.EMPTY_LIST, hVar, new d(bVar, i10, fieldType, true, z10), cls);
    }

    public static <ContainingType extends h, Type> e<ContainingType, Type> i(ContainingType containingtype, Type type, h hVar, f.b<?> bVar, int i10, WireFormat.FieldType fieldType, Class cls) {
        return new e<>(containingtype, type, hVar, new d(bVar, i10, fieldType, false, false), cls);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <MessageType extends kotlin.reflect.jvm.internal.impl.protobuf.h> boolean k(kotlin.reflect.jvm.internal.impl.protobuf.e<kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.d> r5, MessageType r6, kotlin.reflect.jvm.internal.impl.protobuf.c r7, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r8, kotlin.reflect.jvm.internal.impl.protobuf.d r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.k(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.d, int):boolean");
    }

    public void g() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<? extends h> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public boolean j(kotlin.reflect.jvm.internal.impl.protobuf.c cVar, CodedOutputStream codedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.d dVar, int i10) throws IOException {
        return cVar.P(i10, codedOutputStream);
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements InterfaceC4187g {

        /* renamed from: b, reason: collision with root package name */
        public final kotlin.reflect.jvm.internal.impl.protobuf.e<d> f35829b;

        public class a {

            /* renamed from: a, reason: collision with root package name */
            public final Iterator<Map.Entry<d, Object>> f35830a;

            /* renamed from: b, reason: collision with root package name */
            public Map.Entry<d, Object> f35831b;

            /* renamed from: c, reason: collision with root package name */
            public final boolean f35832c;

            public /* synthetic */ a(ExtendableMessage extendableMessage, boolean z10, a aVar) {
                this(z10);
            }

            public void a(int i10, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<d, Object> entry = this.f35831b;
                    if (entry == null || entry.getKey().getNumber() >= i10) {
                        return;
                    }
                    d key = this.f35831b.getKey();
                    if (this.f35832c && key.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !key.isRepeated()) {
                        codedOutputStream.f0(key.getNumber(), (h) this.f35831b.getValue());
                    } else {
                        kotlin.reflect.jvm.internal.impl.protobuf.e.z(key, this.f35831b.getValue(), codedOutputStream);
                    }
                    if (this.f35830a.hasNext()) {
                        this.f35831b = this.f35830a.next();
                    } else {
                        this.f35831b = null;
                    }
                }
            }

            public a(boolean z10) {
                Iterator<Map.Entry<d, Object>> itP = ExtendableMessage.this.f35829b.p();
                this.f35830a = itP;
                if (itP.hasNext()) {
                    this.f35831b = itP.next();
                }
                this.f35832c = z10;
            }
        }

        public ExtendableMessage() {
            this.f35829b = kotlin.reflect.jvm.internal.impl.protobuf.e.t();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public void g() {
            this.f35829b.q();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public boolean j(kotlin.reflect.jvm.internal.impl.protobuf.c cVar, CodedOutputStream codedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.d dVar, int i10) throws IOException {
            return GeneratedMessageLite.k(this.f35829b, getDefaultInstanceForType(), cVar, codedOutputStream, dVar, i10);
        }

        public boolean n() {
            return this.f35829b.n();
        }

        public int q() {
            return this.f35829b.k();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type s(e<MessageType, Type> eVar) {
            x(eVar);
            Object objH = this.f35829b.h(eVar.f35846d);
            return objH == null ? eVar.f35844b : (Type) eVar.a(objH);
        }

        public final <Type> Type t(e<MessageType, List<Type>> eVar, int i10) {
            x(eVar);
            return (Type) eVar.e(this.f35829b.i(eVar.f35846d, i10));
        }

        public final <Type> int u(e<MessageType, List<Type>> eVar) {
            x(eVar);
            return this.f35829b.j(eVar.f35846d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean v(e<MessageType, Type> eVar) {
            x(eVar);
            return this.f35829b.m(eVar.f35846d);
        }

        public ExtendableMessage<MessageType>.a w() {
            return new a(this, false, null);
        }

        public final void x(e<MessageType, ?> eVar) {
            if (eVar.b() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public ExtendableMessage(c<MessageType, ?> cVar) {
            this.f35829b = cVar.n();
        }
    }

    public GeneratedMessageLite(b bVar) {
    }
}
