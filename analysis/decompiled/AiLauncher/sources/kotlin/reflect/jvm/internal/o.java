package kotlin.reflect.jvm.internal;

import E9.O;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Member;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.p;
import w9.InterfaceC5752k;
import z9.C6450x0;
import z9.C6452y0;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0006\b\u0002\u0010\u0003 \u00012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00042\b\u0012\u0004\u0012\u00028\u00020\u0005:\u0001\u001cB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00028\u00022\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0010\u001a\u00028\u00022\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u000fR,\u0010\u0015\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R&\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/o;", "D", ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Lkotlin/reflect/jvm/internal/p;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "LE9/O;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "receiver1", "receiver2", "u0", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "invoke", "LY8/h;", "Lkotlin/reflect/jvm/internal/o$a;", "p", "LY8/h;", "_getter", "Ljava/lang/reflect/Member;", "q", "delegateSource", "v0", "()Lkotlin/reflect/jvm/internal/o$a;", "getter", Const.INTENT_KEY_APIKEY, "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class o<D, E, V> extends p<V> implements InterfaceC5752k, p9.p {

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<a<D, E, V>> _getter;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<Member> delegateSource;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u0002*\u0006\b\u0005\u0010\u0003 \u00012\b\u0012\u0004\u0012\u00028\u00050\u00042\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0005B!\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0006¢\u0006\u0004\b\b\u0010\tJ \u0010\f\u001a\u00028\u00052\u0006\u0010\n\u001a\u00028\u00032\u0006\u0010\u000b\u001a\u00028\u0004H\u0096\u0002¢\u0006\u0004\b\f\u0010\rR,\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkotlin/reflect/jvm/internal/o$a;", "D", ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/p$c;", "", "Lkotlin/reflect/jvm/internal/o;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/o;)V", "receiver1", "receiver2", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "k", "Lkotlin/reflect/jvm/internal/o;", "m0", "()Lkotlin/reflect/jvm/internal/o;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<D, E, V> extends p.c<V> implements InterfaceC5752k.b, p9.p {

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public final o<D, E, V> property;

        /* JADX WARN: Multi-variable type inference failed */
        public a(o<D, E, ? extends V> property) {
            kotlin.jvm.internal.p.i(property, "property");
            this.property = property;
        }

        @Override // p9.p
        public V invoke(D receiver1, E receiver2) {
            return l().u0(receiver1, receiver2);
        }

        @Override // w9.InterfaceC5752k.a
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public o<D, E, V> l() {
            return this.property;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(KDeclarationContainerImpl container, O descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this._getter = C4848b.a(lazyThreadSafetyMode, new C6450x0(this));
        this.delegateSource = C4848b.a(lazyThreadSafetyMode, new C6452y0(this));
    }

    public static final a q0(o oVar) {
        return new a(oVar);
    }

    public static final Member t0(o oVar) {
        return oVar.j0();
    }

    @Override // p9.p
    public V invoke(D receiver1, E receiver2) {
        return u0(receiver1, receiver2);
    }

    public V u0(D receiver1, E receiver2) {
        return n0().call(receiver1, receiver2);
    }

    @Override // kotlin.reflect.jvm.internal.p
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public a<D, E, V> n0() {
        return this._getter.getValue();
    }
}
