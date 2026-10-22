package Ua;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"LUa/d0;", "LUa/q0;", "", "isActive", "<init>", "(Z)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Z", Const.INTENT_KEY_PKGNAME, "()Z", "LUa/B0;", "getList", "()LUa/B0;", "list", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Ua.d0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1051d0 implements InterfaceC1077q0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean isActive;

    public C1051d0(boolean z10) {
        this.isActive = z10;
    }

    @Override // Ua.InterfaceC1077q0
    /* renamed from: b, reason: from getter */
    public boolean getIsActive() {
        return this.isActive;
    }

    @Override // Ua.InterfaceC1077q0
    public B0 getList() {
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Empty{");
        sb2.append(getIsActive() ? "Active" : "New");
        sb2.append('}');
        return sb2.toString();
    }
}
