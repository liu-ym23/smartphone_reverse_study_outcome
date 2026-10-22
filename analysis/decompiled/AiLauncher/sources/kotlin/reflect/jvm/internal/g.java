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
import w9.InterfaceC5750i;
import z9.C6416g0;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u001cB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB+\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R \u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/g;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/m;", "Lw9/i;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "LE9/O;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", "name", "signature", "", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", UxipConstants.f30680s, "LY8/t;", "y0", "(Ljava/lang/Object;)V", "LY8/h;", "Lkotlin/reflect/jvm/internal/g$a;", "r", "LY8/h;", "_setter", "x0", "()Lkotlin/reflect/jvm/internal/g$a;", "setter", Const.INTENT_KEY_APIKEY, "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class g<V> extends m<V> implements InterfaceC5750i<V> {

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<a<V>> _setter;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/g$a;", "R", "Lkotlin/reflect/jvm/internal/p$d;", "Lw9/i$a;", "Lkotlin/reflect/jvm/internal/g;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/g;)V", UxipConstants.f30680s, "LY8/t;", "n0", "(Ljava/lang/Object;)V", "k", "Lkotlin/reflect/jvm/internal/g;", "m0", "()Lkotlin/reflect/jvm/internal/g;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<R> extends p.d<R> implements InterfaceC5750i.a<R> {

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public final g<R> property;

        public a(g<R> property) {
            kotlin.jvm.internal.p.i(property, "property");
            this.property = property;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Y8.t invoke(Object obj) throws IllegalCallableAccessException {
            n0(obj);
            return Y8.t.f7040a;
        }

        @Override // w9.InterfaceC5752k.a
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public g<R> l() {
            return this.property;
        }

        public void n0(R value) throws IllegalCallableAccessException {
            l().y0(value);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(KDeclarationContainerImpl container, O descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        this._setter = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new C6416g0(this));
    }

    public static final a v0(g gVar) {
        return new a(gVar);
    }

    @Override // w9.InterfaceC5750i, w9.InterfaceC5749h
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public a<V> getSetter() {
        return this._setter.getValue();
    }

    public void y0(V value) throws IllegalCallableAccessException {
        getSetter().call(value);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(KDeclarationContainerImpl container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(signature, "signature");
        this._setter = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new C6416g0(this));
    }
}
