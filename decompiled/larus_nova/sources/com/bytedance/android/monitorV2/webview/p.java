package com.bytedance.android.monitorV2.webview;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f163375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f163376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f163377c;

    public p() {
        this(0);
    }

    public final LinkedBlockingDeque<String> b() {
        return (LinkedBlockingDeque) this.f163375a.getValue();
    }

    public p(int r100) {
        this.f163375a = LazyKt.lazy(WebViewRootManager$weiViewStack$2.INSTANCE);
        this.f163376b = "navigationStart";
        this.f163377c = "res_loader_perf";
    }

    public final void a(wz2.a r100, String r101, NavigationDataManager r102) {
        r100.f561908b = "web";
        Uri.Builder r103 = UriProtector.parse(r101).buildUpon();
        r103.clearQuery();
        r100.f561909c = r103.build().toString();
        r100.f561910d = r101;
        String r104 = null;
        if (b().size() < 1) goto L5;
        String r105 = b().getFirst();
    L6:
        r100.f561911e = r105;
        if (b().size() <= 1) goto L9;
        r104 = (String) CollectionsKt.elementAt(b(), b().size() - 2);
    L9:
        r100.f561912f = r104;
        if (r102 == null) goto L13;
        r100.navigationId = r102.f163265g.navigationId;
        return;
    L13:
        return;
    L5:
        r105 = null;
        goto L6
    }
}
