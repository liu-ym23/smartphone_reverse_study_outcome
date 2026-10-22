package pb;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import nb.AbstractC4959l;
import nb.AbstractC4960m;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010%\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u001bR\u0014\u0010)\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(\u0082\u0001\u0005*+,-.¨\u0006/"}, d2 = {"Lpb/f0;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementDescriptor", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "index", "", "e", "(I)Ljava/lang/String;", "name", "c", "(Ljava/lang/String;)I", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Z", "", "", "f", "(I)Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", Const.INTENT_KEY_PKGNAME, "I", Const.INTENT_KEY_UMID, "elementsCount", "Lnb/l;", "getKind", "()Lnb/l;", "kind", "Lpb/d;", "Lpb/e;", "Lpb/P;", "Lpb/d0;", "Lpb/N0;", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.f0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5095f0 implements SerialDescriptor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final SerialDescriptor elementDescriptor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int elementsCount;

    public /* synthetic */ AbstractC5095f0(SerialDescriptor serialDescriptor, kotlin.jvm.internal.i iVar) {
        this(serialDescriptor);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return super.b();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        Integer numW = La.C.w(name);
        if (numW != null) {
            return numW.intValue();
        }
        throw new IllegalArgumentException(name + " is not a valid list index");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    /* renamed from: d, reason: from getter */
    public int getElementsCount() {
        return this.elementsCount;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String e(int index) {
        return String.valueOf(index);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbstractC5095f0)) {
            return false;
        }
        AbstractC5095f0 abstractC5095f0 = (AbstractC5095f0) other;
        return kotlin.jvm.internal.p.d(this.elementDescriptor, abstractC5095f0.elementDescriptor) && kotlin.jvm.internal.p.d(getSerialName(), abstractC5095f0.getSerialName());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> f(int index) {
        if (index >= 0) {
            return C1173v.m();
        }
        throw new IllegalArgumentException(("Illegal index " + index + ", " + getSerialName() + " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor g(int index) {
        if (index >= 0) {
            return this.elementDescriptor;
        }
        throw new IllegalArgumentException(("Illegal index " + index + ", " + getSerialName() + " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getAnnotations() {
        return super.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public AbstractC4959l getKind() {
        return AbstractC4960m.b.f37294a;
    }

    public int hashCode() {
        return (this.elementDescriptor.hashCode() * 31) + getSerialName().hashCode();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean i(int index) {
        if (index >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + index + ", " + getSerialName() + " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return super.isInline();
    }

    public String toString() {
        return getSerialName() + '(' + this.elementDescriptor + ')';
    }

    public AbstractC5095f0(SerialDescriptor serialDescriptor) {
        this.elementDescriptor = serialDescriptor;
        this.elementsCount = 1;
    }
}
