package bj9;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Set;

/* JADX INFO: loaded from: classes30.dex */
public final class a extends de1.a.AbstractC5660a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19253a = null;

    static {
        f19253a = new a();
    }

    public a() {
    }

    @Override // de1.a.AbstractC5660a
    public final Boolean a(Uri r100) {
        if (r100 == null) goto L8;
        Set<String> r101 = UriProtector.getQueryParameterNames(r100);
        if (r101 == null) goto L8;
        boolean r102 = true;
        if (r101.contains("doubao_live_router_source_7f3a9c2d") != true) goto L8;
    L10:
        return Boolean.valueOf(r102);
    L8:
        r102 = false;
        goto L10
    }
}
