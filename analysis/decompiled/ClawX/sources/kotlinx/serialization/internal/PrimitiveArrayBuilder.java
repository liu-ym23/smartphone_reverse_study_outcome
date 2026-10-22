package kotlinx.serialization.internal;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b!\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\b@¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0006H \u0080\u0004¢\u0006\u0002\b\fJ\u0011\u0010\r\u001a\u00028\u0000H \u0080\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u00020\u0006X \u0084\b¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Array", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "position", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getPosition$kotlinx_serialization_core", "()I", "ensureCapacity", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "requiredCapacity", "ensureCapacity$kotlinx_serialization_core", "build", "build$kotlinx_serialization_core", "()Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PrimitiveArrayBuilder<Array> {
    public static /* synthetic */ void ensureCapacity$kotlinx_serialization_core$default(PrimitiveArrayBuilder primitiveArrayBuilder, int i8, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureCapacity");
        }
        if ((i9 & 1) != 0) {
            i8 = primitiveArrayBuilder.getPosition$kotlinx_serialization_core() + 1;
        }
        primitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core(i8);
    }

    public abstract Array build$kotlinx_serialization_core();

    public abstract void ensureCapacity$kotlinx_serialization_core(int requiredCapacity);

    public abstract int getPosition$kotlinx_serialization_core();
}
