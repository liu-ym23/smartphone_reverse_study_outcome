package kotlinx.serialization.internal;

import com.stepos.stepclaw.SecurePrefs;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b@\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0090\u0080\u0004¢\u0006\u0002\b\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\bH\u0080\u0080\u0004¢\u0006\u0002\b\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0090\u0080\u0004¢\u0006\u0002\b\u0014R\u000f\u0010\u0006\u001a\u00020\u0002X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@RX\u0090\u008e\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkotlinx/serialization/internal/IntArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "bufferWithData", "<init>", "([I)V", "buffer", "value", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "position", "getPosition$kotlinx_serialization_core", "()I", "ensureCapacity", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "requiredCapacity", "ensureCapacity$kotlinx_serialization_core", "append", "c", "append$kotlinx_serialization_core", "build", "build$kotlinx_serialization_core", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IntArrayBuilder extends PrimitiveArrayBuilder<int[]> {
    private int[] buffer;
    private int position;

    public IntArrayBuilder(int[] bufferWithData) {
        p.e(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.position = bufferWithData.length;
        ensureCapacity$kotlinx_serialization_core(10);
    }

    public final void append$kotlinx_serialization_core(int c3) {
        PrimitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core$default(this, 0, 1, null);
        int[] iArr = this.buffer;
        int position = getPosition();
        this.position = position + 1;
        iArr[position] = c3;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void ensureCapacity$kotlinx_serialization_core(int requiredCapacity) {
        int[] iArr = this.buffer;
        if (iArr.length < requiredCapacity) {
            int length = iArr.length * 2;
            if (requiredCapacity < length) {
                requiredCapacity = length;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, requiredCapacity);
            p.d(iArrCopyOf, "copyOf(...)");
            this.buffer = iArrCopyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    /* renamed from: getPosition$kotlinx_serialization_core, reason: from getter */
    public int getPosition() {
        return this.position;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int[] build$kotlinx_serialization_core() {
        int[] iArrCopyOf = Arrays.copyOf(this.buffer, getPosition());
        p.d(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }
}
