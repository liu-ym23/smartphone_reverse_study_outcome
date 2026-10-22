package pb;

import java.util.Arrays;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\r8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lpb/S;", "Lpb/I0;", "", "name", "Lpb/M;", "generatedSerializer", "<init>", "(Ljava/lang/String;Lpb/M;)V", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "m", "Z", "isInline", "()Z", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class S extends I0 {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final boolean isInline;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(String name, M<?> generatedSerializer) {
        super(name, generatedSerializer, 1);
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(generatedSerializer, "generatedSerializer");
        this.isInline = true;
    }

    @Override // pb.I0
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof S)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) other;
        if (!kotlin.jvm.internal.p.d(getSerialName(), serialDescriptor.getSerialName())) {
            return false;
        }
        S s10 = (S) other;
        if (!s10.getIsInline() || !Arrays.equals(s(), s10.s()) || getElementsCount() != serialDescriptor.getElementsCount()) {
            return false;
        }
        int elementsCount = getElementsCount();
        for (int i10 = 0; i10 < elementsCount; i10++) {
            if (!kotlin.jvm.internal.p.d(g(i10).getSerialName(), serialDescriptor.g(i10).getSerialName()) || !kotlin.jvm.internal.p.d(g(i10).getKind(), serialDescriptor.g(i10).getKind())) {
                return false;
            }
        }
        return true;
    }

    @Override // pb.I0
    public int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // pb.I0, kotlinx.serialization.descriptors.SerialDescriptor
    /* renamed from: isInline, reason: from getter */
    public boolean getIsInline() {
        return this.isInline;
    }
}
