package kotlin.reflect.jvm.internal;

import E9.O;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.p;
import w9.InterfaceC5749h;
import z9.C6422j0;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0012B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR \u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/jvm/internal/j;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/r;", "Lw9/h;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "LE9/O;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "LY8/h;", "Lkotlin/reflect/jvm/internal/j$a;", "q", "LY8/h;", "_setter", "v0", "()Lkotlin/reflect/jvm/internal/j$a;", "setter", Const.INTENT_KEY_APIKEY, "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class j<V> extends r<V> implements InterfaceC5749h<V> {

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<a<V>> _setter;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/j$a;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/p$d;", "Lkotlin/reflect/jvm/internal/j;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/j;)V", "k", "Lkotlin/reflect/jvm/internal/j;", "m0", "()Lkotlin/reflect/jvm/internal/j;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<V> extends p.d<V> {

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public final j<V> property;

        public a(j<V> property) {
            kotlin.jvm.internal.p.i(property, "property");
            this.property = property;
        }

        @Override // w9.InterfaceC5752k.a
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public j<V> l() {
            return this.property;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(KDeclarationContainerImpl container, O descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        this._setter = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new C6422j0(this));
    }

    public static final a t0(j jVar) {
        return new a(jVar);
    }

    @Override // w9.InterfaceC5749h
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public a<V> getSetter() {
        return this._setter.getValue();
    }
}
