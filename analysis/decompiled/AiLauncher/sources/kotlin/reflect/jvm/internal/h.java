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
import w9.InterfaceC5751j;
import z9.C6418h0;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001\u001eB\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R&\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lkotlin/reflect/jvm/internal/h;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/n;", "Lw9/j;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "LE9/O;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", "name", "signature", "", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "receiver", UxipConstants.f30680s, "LY8/t;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "LY8/h;", "Lkotlin/reflect/jvm/internal/h$a;", "r", "LY8/h;", "_setter", "x0", "()Lkotlin/reflect/jvm/internal/h$a;", "setter", Const.INTENT_KEY_APIKEY, "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class h<T, V> extends n<T, V> implements InterfaceC5751j<T, V> {

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<a<T, V>> _setter;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\b\u0012\u0004\u0012\u00028\u00030\u00032\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00028\u00022\u0006\u0010\n\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0004\b\f\u0010\rR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkotlin/reflect/jvm/internal/h$a;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/p$d;", "Lw9/j$a;", "Lkotlin/reflect/jvm/internal/h;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/h;)V", "receiver", UxipConstants.f30680s, "LY8/t;", "n0", "(Ljava/lang/Object;Ljava/lang/Object;)V", "k", "Lkotlin/reflect/jvm/internal/h;", "m0", "()Lkotlin/reflect/jvm/internal/h;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<T, V> extends p.d<V> implements InterfaceC5751j.a<T, V> {

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public final h<T, V> property;

        public a(h<T, V> property) {
            kotlin.jvm.internal.p.i(property, "property");
            this.property = property;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p9.p
        public /* bridge */ /* synthetic */ Y8.t invoke(Object obj, Object obj2) throws IllegalCallableAccessException {
            n0(obj, obj2);
            return Y8.t.f7040a;
        }

        @Override // w9.InterfaceC5752k.a
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public h<T, V> l() {
            return this.property;
        }

        public void n0(T receiver, V value) throws IllegalCallableAccessException {
            l().set(receiver, value);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(KDeclarationContainerImpl container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(signature, "signature");
        this._setter = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new C6418h0(this));
    }

    public static final a v0(h hVar) {
        return new a(hVar);
    }

    @Override // w9.InterfaceC5751j
    public void set(T receiver, V value) throws IllegalCallableAccessException {
        getSetter().call(receiver, value);
    }

    @Override // w9.InterfaceC5751j, w9.InterfaceC5749h
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public a<T, V> getSetter() {
        return this._setter.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(KDeclarationContainerImpl container, O descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        this._setter = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new C6418h0(this));
    }
}
