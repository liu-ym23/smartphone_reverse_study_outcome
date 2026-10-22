package kotlinx.serialization.internal;

import c5.m;
import com.stepos.stepclaw.SecurePrefs;
import java.util.Arrays;
import java.util.Iterator;
import k4.v;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialKind;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001aO\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0080\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a!\u0010\f\u001a\u00020\r*\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0080\u0080\u0004¢\u0006\u0002\u0010\u0010\u001a\u000e\u0010\u0011\u001a\u00020\u0012*\u00020\u0003H\u0080\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"equalsImpl", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "SD", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "typeParamsAreEqual", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "otherDescriptor", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "hashCodeImpl", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "typeParams", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "(Lkotlinx/serialization/descriptors/SerialDescriptor;[Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "toStringImpl", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PluginGeneratedSerialDescriptorKt {
    public static final /* synthetic */ <SD extends SerialDescriptor> boolean equalsImpl(SD sd, Object obj, l typeParamsAreEqual) {
        p.e(sd, "<this>");
        p.e(typeParamsAreEqual, "typeParamsAreEqual");
        if (sd == obj) {
            return true;
        }
        p.i();
        throw null;
    }

    public static final int hashCodeImpl(SerialDescriptor serialDescriptor, SerialDescriptor[] typeParams) {
        p.e(serialDescriptor, "<this>");
        p.e(typeParams, "typeParams");
        int iHashCode = (serialDescriptor.getSerialName().hashCode() * 31) + Arrays.hashCode(typeParams);
        Iterable<SerialDescriptor> elementDescriptors = SerialDescriptorKt.getElementDescriptors(serialDescriptor);
        Iterator<SerialDescriptor> it = elementDescriptors.iterator();
        int iHashCode2 = 1;
        int i8 = 1;
        while (true) {
            int iHashCode3 = 0;
            if (!it.hasNext()) {
                break;
            }
            int i9 = i8 * 31;
            String serialName = it.next().getSerialName();
            if (serialName != null) {
                iHashCode3 = serialName.hashCode();
            }
            i8 = i9 + iHashCode3;
        }
        Iterator<SerialDescriptor> it2 = elementDescriptors.iterator();
        while (it2.hasNext()) {
            int i10 = iHashCode2 * 31;
            SerialKind kind = it2.next().getKind();
            iHashCode2 = i10 + (kind != null ? kind.hashCode() : 0);
        }
        return (((iHashCode * 31) + i8) * 31) + iHashCode2;
    }

    public static final String toStringImpl(SerialDescriptor serialDescriptor) {
        p.e(serialDescriptor, "<this>");
        return m.A0(v.r0(0, serialDescriptor.getElementsCount()), ", ", serialDescriptor.getSerialName() + '(', ")", new c5.a(11, serialDescriptor), 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toStringImpl$lambda$0(SerialDescriptor serialDescriptor, int i8) {
        return serialDescriptor.getElementName(i8) + ": " + serialDescriptor.getElementDescriptor(i8).getSerialName();
    }
}
