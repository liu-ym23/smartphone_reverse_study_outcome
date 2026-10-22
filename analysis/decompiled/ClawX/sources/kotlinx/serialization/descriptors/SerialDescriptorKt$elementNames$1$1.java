package kotlinx.serialization.descriptors;

import com.stepos.stepclaw.SecurePrefs;
import java.util.Iterator;
import kotlin.Metadata;
import q5.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0005\u001a\u00020\u0006H\u0096\u0082\u0004J\n\u0010\u0007\u001a\u00020\u0002H\u0096\u0082\u0004R\u000f\u0010\u0003\u001a\u00020\u0004X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"kotlinx/serialization/descriptors/SerialDescriptorKt$elementNames$1$1", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "elementsLeft", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hasNext", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "next", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SerialDescriptorKt$elementNames$1$1 implements Iterator<String>, a {
    final /* synthetic */ SerialDescriptor $this_elementNames;
    private int elementsLeft;

    public SerialDescriptorKt$elementNames$1$1(SerialDescriptor serialDescriptor) {
        this.$this_elementNames = serialDescriptor;
        this.elementsLeft = serialDescriptor.getElementsCount();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.elementsLeft > 0;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public String next() {
        SerialDescriptor serialDescriptor = this.$this_elementNames;
        int elementsCount = serialDescriptor.getElementsCount();
        int i8 = this.elementsLeft;
        this.elementsLeft = i8 - 1;
        return serialDescriptor.getElementName(elementsCount - i8);
    }
}
