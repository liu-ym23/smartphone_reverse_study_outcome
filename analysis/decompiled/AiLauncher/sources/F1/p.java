package F1;

import B1.Size;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\f¨\u0006\r"}, d2 = {"LF1/p;", "LF1/n;", "", "allowHardware", "<init>", "(Z)V", "LB1/g;", ContentDisposition.Parameters.Size, Const.INTENT_KEY_PKGNAME, "(LB1/g;)Z", Const.INTENT_KEY_APIKEY, "()Z", "Z", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class p implements n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean allowHardware;

    public p(boolean z10) {
        this.allowHardware = z10;
    }

    @Override // F1.n
    /* renamed from: a, reason: from getter */
    public boolean getAllowHardware() {
        return this.allowHardware;
    }

    @Override // F1.n
    public boolean b(Size size) {
        return this.allowHardware;
    }
}
