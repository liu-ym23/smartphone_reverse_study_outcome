package kotlinx.serialization.internal;

import c5.m;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\bF¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u0002*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0084\u0080\u0004J\u0012\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0084\u0080\u0004J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0094\u0080\u0004J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0094\u0080\u0004J\n\u0010\u0010\u001a\u00020\u0002H\u0084\u0080\u0004¨\u0006\u0011"}, d2 = {"Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/internal/TaggedDecoder;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "getTag", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "nested", "nestedName", "elementName", "descriptor", "composeName", "parentName", "childName", "renderTagStack", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@InternalSerializationApi
/* loaded from: classes.dex */
public abstract class NamedValueDecoder extends TaggedDecoder<String> {
    public String composeName(String parentName, String childName) {
        p.e(parentName, "parentName");
        p.e(childName, "childName");
        if (parentName.length() == 0) {
            return childName;
        }
        return parentName + '.' + childName;
    }

    public String elementName(SerialDescriptor descriptor, int index) {
        p.e(descriptor, "descriptor");
        return descriptor.getElementName(index);
    }

    public final String nested(String nestedName) {
        p.e(nestedName, "nestedName");
        String currentTagOrNull = getCurrentTagOrNull();
        if (currentTagOrNull == null) {
            currentTagOrNull = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        return composeName(currentTagOrNull, nestedName);
    }

    public final String renderTagStack() {
        return getTagStack$kotlinx_serialization_core().isEmpty() ? "$" : m.A0(getTagStack$kotlinx_serialization_core(), ".", "$.", null, null, 60);
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final String getTag(SerialDescriptor serialDescriptor, int i8) {
        p.e(serialDescriptor, "<this>");
        return nested(elementName(serialDescriptor, i8));
    }
}
