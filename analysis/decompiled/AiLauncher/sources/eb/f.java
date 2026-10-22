package eb;

import Za.C;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sla.G;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006\"\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0006¨\u0006\n"}, d2 = {"", G.LOCK_LOCKED, "Leb/a;", Const.INTENT_KEY_APIKEY, "(Z)Leb/a;", "LZa/C;", "LZa/C;", "NO_OWNER", Const.INTENT_KEY_PKGNAME, "ON_LOCK_ALREADY_LOCKED_BY_OWNER", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final C f32434a = new C("NO_OWNER");

    /* renamed from: b, reason: collision with root package name */
    public static final C f32435b = new C("ALREADY_LOCKED_BY_OWNER");

    public static final InterfaceC4021a a(boolean z10) {
        return new kotlinx.coroutines.sync.a(z10);
    }

    public static /* synthetic */ InterfaceC4021a b(boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return a(z10);
    }
}
