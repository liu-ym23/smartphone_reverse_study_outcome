package pb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lpb/N0;", "Lpb/f0;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "primitive", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "c", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/lang/String;", "serialName", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class N0 extends AbstractC5095f0 {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String serialName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N0(SerialDescriptor primitive) {
        super(primitive, null);
        kotlin.jvm.internal.p.i(primitive, "primitive");
        this.serialName = primitive.getSerialName() + "Array";
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    /* renamed from: h, reason: from getter */
    public String getSerialName() {
        return this.serialName;
    }
}
