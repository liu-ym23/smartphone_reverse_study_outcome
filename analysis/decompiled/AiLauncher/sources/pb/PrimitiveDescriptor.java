package pb;

import com.autonavi.aps.amapapi.config.Const;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import nb.AbstractC4952e;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0096\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000bH\u0016¢\u0006\u0004\b!\u0010\"R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b$\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\"¨\u0006+"}, d2 = {"Lpb/P0;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "serialName", "Lnb/e;", "kind", "<init>", "(Ljava/lang/String;Lnb/e;)V", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Void;", "", "index", "e", "(I)Ljava/lang/String;", "name", "c", "(Ljava/lang/String;)I", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "", "f", "(I)Ljava/util/List;", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_PKGNAME, "Lnb/e;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lnb/e;", Const.INTENT_KEY_UMID, "elementsCount", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.P0, reason: from toString */
/* loaded from: classes5.dex */
public final class PrimitiveDescriptor implements SerialDescriptor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String serialName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final AbstractC4952e kind;

    public PrimitiveDescriptor(String serialName, AbstractC4952e kind) {
        kotlin.jvm.internal.p.i(serialName, "serialName");
        kotlin.jvm.internal.p.i(kind, "kind");
        this.serialName = serialName;
        this.kind = kind;
    }

    private final Void a() {
        throw new IllegalStateException("Primitive descriptor " + getSerialName() + " does not have elements");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return super.b();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        a();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    /* renamed from: d */
    public int getElementsCount() {
        return 0;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String e(int index) {
        a();
        throw new KotlinNothingValueException();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrimitiveDescriptor)) {
            return false;
        }
        PrimitiveDescriptor primitiveDescriptor = (PrimitiveDescriptor) other;
        return kotlin.jvm.internal.p.d(getSerialName(), primitiveDescriptor.getSerialName()) && kotlin.jvm.internal.p.d(getKind(), primitiveDescriptor.getKind());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> f(int index) {
        a();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor g(int index) {
        a();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getAnnotations() {
        return super.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    /* renamed from: h, reason: from getter */
    public String getSerialName() {
        return this.serialName;
    }

    public int hashCode() {
        return getSerialName().hashCode() + (getKind().hashCode() * 31);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean i(int index) {
        a();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return super.isInline();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    /* renamed from: j, reason: from getter */
    public AbstractC4952e getKind() {
        return this.kind;
    }

    public String toString() {
        return "PrimitiveDescriptor(" + getSerialName() + ')';
    }
}
