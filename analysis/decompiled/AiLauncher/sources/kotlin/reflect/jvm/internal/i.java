package kotlin.reflect.jvm.internal;

import E9.O;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.internal.p;
import w9.InterfaceC5749h;
import w9.InterfaceC5752k;
import z9.C6420i0;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00042\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005:\u0001\u001aB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R,\u0010\u0016\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R&\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lkotlin/reflect/jvm/internal/i;", "D", ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/o;", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "LE9/O;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "receiver1", "receiver2", UxipConstants.f30680s, "LY8/t;", "z0", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "LY8/h;", "Lkotlin/reflect/jvm/internal/i$a;", "r", "LY8/h;", "_setter", "y0", "()Lkotlin/reflect/jvm/internal/i$a;", "setter", Const.INTENT_KEY_APIKEY, "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class i<D, E, V> extends o<D, E, V> implements InterfaceC5752k, p9.p, InterfaceC5749h {

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<a<D, E, V>> _setter;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u0002*\u0004\b\u0005\u0010\u00032\b\u0012\u0004\u0012\u00028\u00050\u00042\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0005B!\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0006¢\u0006\u0004\b\b\u0010\tJ(\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00028\u00032\u0006\u0010\u000b\u001a\u00028\u00042\u0006\u0010\f\u001a\u00028\u0005H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fR,\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlin/reflect/jvm/internal/i$a;", "D", ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/p$d;", "", "Lkotlin/reflect/jvm/internal/i;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/i;)V", "receiver1", "receiver2", UxipConstants.f30680s, "LY8/t;", "n0", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "k", "Lkotlin/reflect/jvm/internal/i;", "m0", "()Lkotlin/reflect/jvm/internal/i;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<D, E, V> extends p.d<V> implements InterfaceC5749h.a, p9.q {

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public final i<D, E, V> property;

        public a(i<D, E, V> property) {
            kotlin.jvm.internal.p.i(property, "property");
            this.property = property;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p9.q
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) throws IllegalCallableAccessException {
            n0(obj, obj2, obj3);
            return Y8.t.f7040a;
        }

        @Override // w9.InterfaceC5752k.a
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public i<D, E, V> l() {
            return this.property;
        }

        public void n0(D receiver1, E receiver2, V value) throws IllegalCallableAccessException {
            l().z0(receiver1, receiver2, value);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(KDeclarationContainerImpl container, O descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        this._setter = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new C6420i0(this));
    }

    public static final a w0(i iVar) {
        return new a(iVar);
    }

    @Override // w9.InterfaceC5749h
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public a<D, E, V> getSetter() {
        return this._setter.getValue();
    }

    public void z0(D receiver1, E receiver2, V value) throws IllegalCallableAccessException {
        getSetter().call(receiver1, receiver2, value);
    }
}
