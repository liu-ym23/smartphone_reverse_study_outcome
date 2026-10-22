package ba;

import ea.C4019c;
import ua.InterfaceC5640z;

/* loaded from: classes5.dex */
public interface p extends InterfaceC5640z {

    public static abstract class a {

        /* renamed from: ba.p$a$a, reason: collision with other inner class name */
        public static final class C0191a extends a {

            /* renamed from: a, reason: collision with root package name */
            public final byte[] f15358a;

            public final byte[] b() {
                return this.f15358a;
            }
        }

        public static final class b extends a {

            /* renamed from: a, reason: collision with root package name */
            public final kotlin.reflect.jvm.internal.impl.load.kotlin.f f15359a;

            /* renamed from: b, reason: collision with root package name */
            public final byte[] f15360b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(kotlin.reflect.jvm.internal.impl.load.kotlin.f kotlinJvmBinaryClass, byte[] bArr) {
                super(null);
                kotlin.jvm.internal.p.i(kotlinJvmBinaryClass, "kotlinJvmBinaryClass");
                this.f15359a = kotlinJvmBinaryClass;
                this.f15360b = bArr;
            }

            public final kotlin.reflect.jvm.internal.impl.load.kotlin.f b() {
                return this.f15359a;
            }

            public /* synthetic */ b(kotlin.reflect.jvm.internal.impl.load.kotlin.f fVar, byte[] bArr, int i10, kotlin.jvm.internal.i iVar) {
                this(fVar, (i10 & 2) != 0 ? null : bArr);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final kotlin.reflect.jvm.internal.impl.load.kotlin.f a() {
            b bVar = this instanceof b ? (b) this : null;
            if (bVar != null) {
                return bVar.b();
            }
            return null;
        }

        public a() {
        }
    }

    a a(ga.b bVar, C4019c c4019c);

    a c(Z9.g gVar, C4019c c4019c);
}
