package kotlinx.serialization.internal;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0082\u0004J\n\u0010\u0016\u001a\u00020\tH\u0096\u0080\u0004J\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004J\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u0018H\u0096\u0081\u0004J\u0012\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0018H\u0096\u0081\u0004J\u0012\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\tH\u0096\u0081\u0004J\u0012\u0010 \u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0018H\u0096\u0081\u0004J\u0012\u0010!\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0018H\u0096\u0081\u0004R\u0015\u0010\u0003\u001a\u00020\u0001X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\b\u001a\u00020\tX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u00020\u00118VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u001b\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8VX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0013\u0010%\u001a\u00020\u0018X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0015\u0010(\u001a\u00020\u00118VX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b(\u0010\u0012R\u0013\u0010)\u001a\u00020*X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lkotlinx/serialization/internal/SerialDescriptorForNullable;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "original", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getOriginal$kotlinx_serialization_core", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getSerialName", "()Ljava/lang/String;", "serialNames", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getSerialNames", "()Ljava/util/Set;", "isNullable", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "()Z", "equals", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getElementAnnotations", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "annotations", "getAnnotations", "()Ljava/util/List;", "elementsCount", "getElementsCount", "()I", "isInline", ExtensionCallContract.KIND, "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SerialDescriptorForNullable implements SerialDescriptor, CachedNames {
    private final SerialDescriptor original;
    private final String serialName;
    private final Set<String> serialNames;

    public SerialDescriptorForNullable(SerialDescriptor original) {
        p.e(original, "original");
        this.original = original;
        this.serialName = original.getSerialName() + '?';
        this.serialNames = Platform_commonKt.cachedSerialNames(original);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SerialDescriptorForNullable) && p.a(this.original, ((SerialDescriptorForNullable) other).original);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getAnnotations() {
        return this.original.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getElementAnnotations(int index) {
        return this.original.getElementAnnotations(index);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor getElementDescriptor(int index) {
        return this.original.getElementDescriptor(index);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementIndex(String name) {
        p.e(name, "name");
        return this.original.getElementIndex(name);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getElementName(int index) {
        return this.original.getElementName(index);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementsCount() {
        return this.original.getElementsCount();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind getKind() {
        return this.original.getKind();
    }

    /* renamed from: getOriginal$kotlinx_serialization_core, reason: from getter */
    public final SerialDescriptor getOriginal() {
        return this.original;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getSerialName() {
        return this.serialName;
    }

    @Override // kotlinx.serialization.internal.CachedNames
    public Set<String> getSerialNames() {
        return this.serialNames;
    }

    public int hashCode() {
        return this.original.hashCode() * 31;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isElementOptional(int index) {
        return this.original.isElementOptional(index);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return this.original.isInline();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isNullable() {
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.original);
        sb.append('?');
        return sb.toString();
    }
}
