package ci8;

import com.larus.common.apphost.AppHost;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class b {
    public static final a a() {
        AppHost.Companion r100 = AppHost.f326268a;
        if ((CollectionsKt.last(r100.a().g()) instanceof a) == false) goto L8;
        Object r101 = CollectionsKt.last(r100.a().g());
        if ((r101 instanceof a) == true) goto L7;
        return null;
    L7:
        return (a) r101;
    L8:
        return null;
    }
}
