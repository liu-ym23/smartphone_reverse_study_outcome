package kotlinx.serialization.json.internal;

import c5.l;
import com.stepos.stepclaw.SecurePrefs;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001bB\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0080\u0004J\u0012\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\nH\u0086\u0080\u0004J\u0014\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0086\u0080\u0004J\n\u0010\u0013\u001a\u00020\fH\u0086\u0080\u0004J\n\u0010\u0014\u001a\u00020\fH\u0086\u0080\u0004J\n\u0010\u0015\u001a\u00020\u0016H\u0086\u0080\u0004J\u0014\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0082\u0080\u0004J\n\u0010\u0019\u001a\u00020\fH\u0082\u0080\u0004J\n\u0010\u001a\u001a\u00020\u0016H\u0096\u0080\u0004R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\u0006R\u000f\u0010\u0007\u001a\u00020\bX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\t\u001a\u00020\nX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlinx/serialization/json/internal/JsonPath;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "currentObjectPath", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "[Ljava/lang/Object;", "indicies", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "currentDepth", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "pushDescriptor", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "sd", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "updateDescriptorIndex", "index", "updateCurrentMapKey", "key", "resetCurrentMapKey", "popDescriptor", "getPath", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "prettyString", "it", "resize", "toString", "Tombstone", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JsonPath {
    private int currentDepth;
    private Object[] currentObjectPath = new Object[8];
    private int[] indicies;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/serialization/json/internal/JsonPath$Tombstone;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Tombstone {
        public static final Tombstone INSTANCE = new Tombstone();

        private Tombstone() {
        }
    }

    public JsonPath() {
        int[] iArr = new int[8];
        for (int i8 = 0; i8 < 8; i8++) {
            iArr[i8] = -1;
        }
        this.indicies = iArr;
        this.currentDepth = -1;
    }

    private final String prettyString(Object it) {
        String serialName;
        SerialDescriptor serialDescriptor = it instanceof SerialDescriptor ? (SerialDescriptor) it : null;
        return (serialDescriptor == null || (serialName = serialDescriptor.getSerialName()) == null) ? String.valueOf(it) : serialName;
    }

    private final void resize() {
        int i8 = this.currentDepth * 2;
        Object[] objArrCopyOf = Arrays.copyOf(this.currentObjectPath, i8);
        p.d(objArrCopyOf, "copyOf(...)");
        this.currentObjectPath = objArrCopyOf;
        int[] iArr = new int[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            iArr[i9] = -1;
        }
        l.X(0, 14, this.indicies, iArr);
        this.indicies = iArr;
    }

    public final String getPath() {
        StringBuilder sb = new StringBuilder("$");
        int i8 = this.currentDepth + 1;
        for (int i9 = 0; i9 < i8; i9++) {
            Object obj = this.currentObjectPath[i9];
            if (obj instanceof SerialDescriptor) {
                SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
                if (!p.a(serialDescriptor.getKind(), StructureKind.LIST.INSTANCE)) {
                    int i10 = this.indicies[i9];
                    if (i10 >= 0) {
                        sb.append(".");
                        sb.append(serialDescriptor.getElementName(i10));
                    }
                } else if (this.indicies[i9] != -1) {
                    sb.append("[");
                    sb.append(this.indicies[i9]);
                    sb.append("]");
                }
            } else if (obj != Tombstone.INSTANCE) {
                sb.append("['");
                sb.append(obj);
                sb.append("']");
            }
        }
        return sb.toString();
    }

    public final void popDescriptor() {
        int i8 = this.currentDepth;
        int[] iArr = this.indicies;
        if (iArr[i8] == -2) {
            iArr[i8] = -1;
            this.currentDepth = i8 - 1;
        }
        int i9 = this.currentDepth;
        if (i9 != -1) {
            this.currentDepth = i9 - 1;
        }
    }

    public final void pushDescriptor(SerialDescriptor sd) {
        p.e(sd, "sd");
        int i8 = this.currentDepth + 1;
        this.currentDepth = i8;
        if (i8 == this.currentObjectPath.length) {
            resize();
        }
        this.currentObjectPath[i8] = sd;
    }

    public final void resetCurrentMapKey() {
        int[] iArr = this.indicies;
        int i8 = this.currentDepth;
        if (iArr[i8] == -2) {
            this.currentObjectPath[i8] = Tombstone.INSTANCE;
        }
    }

    public String toString() {
        return getPath();
    }

    public final void updateCurrentMapKey(Object key) {
        int[] iArr = this.indicies;
        int i8 = this.currentDepth;
        if (iArr[i8] != -2) {
            int i9 = i8 + 1;
            this.currentDepth = i9;
            if (i9 == this.currentObjectPath.length) {
                resize();
            }
        }
        Object[] objArr = this.currentObjectPath;
        int i10 = this.currentDepth;
        objArr[i10] = key;
        this.indicies[i10] = -2;
    }

    public final void updateDescriptorIndex(int index) {
        this.indicies[this.currentDepth] = index;
    }
}
