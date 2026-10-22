package kotlinx.serialization.json.internal;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.D;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017¨\u0006\u0019"}, d2 = {"Lkotlinx/serialization/json/internal/JsonElementMarker;", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "index", "LY8/t;", "c", "(I)V", Const.INTENT_KEY_UMID, "()I", "", "e", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "Lpb/D;", Const.INTENT_KEY_APIKEY, "Lpb/D;", "origin", UxipConstants.f30680s, Const.INTENT_KEY_PKGNAME, "Z", "()Z", "isUnmarkedNull", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JsonElementMarker {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final D origin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean isUnmarkedNull;

    public JsonElementMarker(SerialDescriptor descriptor) {
        p.i(descriptor, "descriptor");
        this.origin = new D(descriptor, new JsonElementMarker$origin$1(this));
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsUnmarkedNull() {
        return this.isUnmarkedNull;
    }

    public final void c(int index) {
        this.origin.a(index);
    }

    public final int d() {
        return this.origin.d();
    }

    public final boolean e(SerialDescriptor descriptor, int index) {
        boolean z10 = !descriptor.i(index) && descriptor.g(index).b();
        this.isUnmarkedNull = z10;
        return z10;
    }
}
