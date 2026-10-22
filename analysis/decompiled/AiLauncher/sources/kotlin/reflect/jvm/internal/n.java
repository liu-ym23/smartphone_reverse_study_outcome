package kotlin.reflect.jvm.internal;

import E9.O;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Member;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.p;
import w9.InterfaceC5754m;
import z9.C6446v0;
import z9.C6448w0;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004:\u0001!B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u0010J\u0017\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0018\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0013R&\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R \u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lkotlin/reflect/jvm/internal/n;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lw9/m;", "Lkotlin/reflect/jvm/internal/p;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "LE9/O;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", "name", "signature", "", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "receiver", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "invoke", "LY8/h;", "Lkotlin/reflect/jvm/internal/n$a;", "p", "LY8/h;", "_getter", "Ljava/lang/reflect/Member;", "q", "delegateSource", "u0", "()Lkotlin/reflect/jvm/internal/n$a;", "getter", Const.INTENT_KEY_APIKEY, "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class n<T, V> extends p<V> implements InterfaceC5754m<T, V> {

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<a<T, V>> _getter;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<Member> delegateSource;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0006\b\u0003\u0010\u0002 \u00012\b\u0012\u0004\u0012\u00028\u00030\u00032\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\u00028\u00032\u0006\u0010\t\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/n$a;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/p$c;", "Lw9/m$a;", "Lkotlin/reflect/jvm/internal/n;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/n;)V", "receiver", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "k", "Lkotlin/reflect/jvm/internal/n;", "m0", "()Lkotlin/reflect/jvm/internal/n;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<T, V> extends p.c<V> implements InterfaceC5754m.a<T, V> {

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public final n<T, V> property;

        /* JADX WARN: Multi-variable type inference failed */
        public a(n<T, ? extends V> property) {
            kotlin.jvm.internal.p.i(property, "property");
            this.property = property;
        }

        @Override // p9.InterfaceC5074l
        public V invoke(T receiver) {
            return l().get(receiver);
        }

        @Override // w9.InterfaceC5752k.a
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public n<T, V> l() {
            return this.property;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(KDeclarationContainerImpl container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(signature, "signature");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this._getter = C4848b.a(lazyThreadSafetyMode, new C6446v0(this));
        this.delegateSource = C4848b.a(lazyThreadSafetyMode, new C6448w0(this));
    }

    public static final a q0(n nVar) {
        return new a(nVar);
    }

    public static final Member t0(n nVar) {
        return nVar.j0();
    }

    @Override // w9.InterfaceC5754m
    public V get(T receiver) {
        return n0().call(receiver);
    }

    @Override // w9.InterfaceC5754m
    public Object getDelegate(T receiver) {
        return l0(this.delegateSource.getValue(), receiver, null);
    }

    @Override // p9.InterfaceC5074l
    public V invoke(T receiver) {
        return get(receiver);
    }

    @Override // kotlin.reflect.jvm.internal.p
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public a<T, V> n0() {
        return this._getter.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(KDeclarationContainerImpl container, O descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this._getter = C4848b.a(lazyThreadSafetyMode, new C6446v0(this));
        this.delegateSource = C4848b.a(lazyThreadSafetyMode, new C6448w0(this));
    }
}
