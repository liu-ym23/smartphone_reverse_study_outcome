package kotlinx.serialization.internal;

import com.stepos.stepclaw.SecurePrefs;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0087\u0080\u0004\u001a\"\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0087\u0080\u0004¨\u0006\u000b"}, d2 = {"throwMissingFieldException", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "goldenMask", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "throwArrayMissingFieldException", "seenArray", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "goldenMaskArray", "kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PluginExceptionsKt {
    @InternalSerializationApi
    public static final void throwArrayMissingFieldException(int[] seenArray, int[] goldenMaskArray, SerialDescriptor descriptor) {
        p.e(seenArray, "seenArray");
        p.e(goldenMaskArray, "goldenMaskArray");
        p.e(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int length = goldenMaskArray.length;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = goldenMaskArray[i8] & (~seenArray[i8]);
            if (i9 != 0) {
                for (int i10 = 0; i10 < 32; i10++) {
                    if ((i9 & 1) != 0) {
                        arrayList.add(descriptor.getElementName((i8 * 32) + i10));
                    }
                    i9 >>>= 1;
                }
            }
        }
        throw new MissingFieldException(arrayList, descriptor.getSerialName());
    }

    @InternalSerializationApi
    public static final void throwMissingFieldException(int i8, int i9, SerialDescriptor descriptor) {
        p.e(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i10 = (~i8) & i9;
        for (int i11 = 0; i11 < 32; i11++) {
            if ((i10 & 1) != 0) {
                arrayList.add(descriptor.getElementName(i11));
            }
            i10 >>>= 1;
        }
        throw new MissingFieldException(arrayList, descriptor.getSerialName());
    }
}
