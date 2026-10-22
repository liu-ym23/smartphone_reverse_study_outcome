package lb;

import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import kotlinx.serialization.descriptors.SerialDescriptor;
import mb.C4931a;
import nb.AbstractC4951d;
import nb.AbstractC4959l;
import nb.C4948a;
import nb.C4949b;
import nb.C4958k;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import pb.AbstractC5086b;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Llb/e;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lpb/b;", "Lw9/d;", "baseClass", "<init>", "(Lw9/d;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Lw9/d;", "f", "()Lw9/d;", "", "", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", "_annotations", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "c", "LY8/h;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class e<T> extends AbstractC5086b<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5745d<T> baseClass;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public List<? extends Annotation> _annotations;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Y8.h descriptor;

    public e(InterfaceC5745d<T> baseClass) {
        kotlin.jvm.internal.p.i(baseClass, "baseClass");
        this.baseClass = baseClass;
        this._annotations = C1173v.m();
        this.descriptor = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: lb.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return e.i(this.f37005a);
            }
        });
    }

    public static final SerialDescriptor i(final e eVar) {
        return C4949b.c(C4958k.g("kotlinx.serialization.Polymorphic", AbstractC4951d.a.f37261a, new SerialDescriptor[0], new InterfaceC5074l() { // from class: lb.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return e.j(this.f37006a, (C4948a) obj);
            }
        }), eVar.f());
    }

    public static final Y8.t j(e eVar, C4948a buildSerialDescriptor) {
        kotlin.jvm.internal.p.i(buildSerialDescriptor, "$this$buildSerialDescriptor");
        C4948a.b(buildSerialDescriptor, "type", C4931a.H(y.f34840a).getDescriptor(), null, false, 12, null);
        C4948a.b(buildSerialDescriptor, UxipConstants.f30680s, C4958k.h("kotlinx.serialization.Polymorphic<" + eVar.f().t() + '>', AbstractC4959l.a.f37291a, new SerialDescriptor[0], null, 8, null), null, false, 12, null);
        buildSerialDescriptor.h(eVar._annotations);
        return Y8.t.f7040a;
    }

    @Override // pb.AbstractC5086b
    public InterfaceC5745d<T> f() {
        return this.baseClass;
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + f() + ')';
    }
}
