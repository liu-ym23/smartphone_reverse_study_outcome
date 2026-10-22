package kotlinx.serialization.descriptors;

import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.ExperimentalSerializationApi;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b@\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u001d2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010'\u001a\u00020\tH\u0086\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R%\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u008e\b¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0087\u008e\b¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0018X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R!\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0018X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u001b\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u0018X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u0006("}, d2 = {"Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "serialName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;)V", "getSerialName", "()Ljava/lang/String;", "isNullable", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isNullable$annotations", "()V", "()Z", "setNullable", "(Z)V", "annotations", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getAnnotations$annotations", "getAnnotations", "()Ljava/util/List;", "setAnnotations", "(Ljava/util/List;)V", "elementNames", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getElementNames$kotlinx_serialization_core", "uniqueNames", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "elementDescriptors", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptors$kotlinx_serialization_core", "elementAnnotations", "getElementAnnotations$kotlinx_serialization_core", "elementOptionality", "getElementOptionality$kotlinx_serialization_core", "element", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "elementName", "descriptor", "isOptional", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ClassSerialDescriptorBuilder {
    private List<? extends Annotation> annotations;
    private final List<List<Annotation>> elementAnnotations;
    private final List<SerialDescriptor> elementDescriptors;
    private final List<String> elementNames;
    private final List<Boolean> elementOptionality;
    private boolean isNullable;
    private final String serialName;
    private final Set<String> uniqueNames;

    public ClassSerialDescriptorBuilder(String serialName) {
        p.e(serialName, "serialName");
        this.serialName = serialName;
        this.annotations = s.f1092a;
        this.elementNames = new ArrayList();
        this.uniqueNames = new HashSet();
        this.elementDescriptors = new ArrayList();
        this.elementAnnotations = new ArrayList();
        this.elementOptionality = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void element$default(ClassSerialDescriptorBuilder classSerialDescriptorBuilder, String str, SerialDescriptor serialDescriptor, List list, boolean z, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            list = s.f1092a;
        }
        if ((i8 & 8) != 0) {
            z = false;
        }
        classSerialDescriptorBuilder.element(str, serialDescriptor, list, z);
    }

    public final void element(String elementName, SerialDescriptor descriptor, List<? extends Annotation> annotations, boolean isOptional) {
        p.e(elementName, "elementName");
        p.e(descriptor, "descriptor");
        p.e(annotations, "annotations");
        if (this.uniqueNames.add(elementName)) {
            this.elementNames.add(elementName);
            this.elementDescriptors.add(descriptor);
            this.elementAnnotations.add(annotations);
            this.elementOptionality.add(Boolean.valueOf(isOptional));
            return;
        }
        throw new IllegalArgumentException(("Element with name '" + elementName + "' is already registered in " + this.serialName).toString());
    }

    public final List<Annotation> getAnnotations() {
        return this.annotations;
    }

    public final List<List<Annotation>> getElementAnnotations$kotlinx_serialization_core() {
        return this.elementAnnotations;
    }

    public final List<SerialDescriptor> getElementDescriptors$kotlinx_serialization_core() {
        return this.elementDescriptors;
    }

    public final List<String> getElementNames$kotlinx_serialization_core() {
        return this.elementNames;
    }

    public final List<Boolean> getElementOptionality$kotlinx_serialization_core() {
        return this.elementOptionality;
    }

    public final String getSerialName() {
        return this.serialName;
    }

    /* renamed from: isNullable, reason: from getter */
    public final boolean getIsNullable() {
        return this.isNullable;
    }

    public final void setAnnotations(List<? extends Annotation> list) {
        p.e(list, "<set-?>");
        this.annotations = list;
    }

    public final void setNullable(boolean z) {
        this.isNullable = z;
    }

    @ExperimentalSerializationApi
    public static /* synthetic */ void getAnnotations$annotations() {
    }

    @ExperimentalSerializationApi
    public static /* synthetic */ void isNullable$annotations() {
    }
}
