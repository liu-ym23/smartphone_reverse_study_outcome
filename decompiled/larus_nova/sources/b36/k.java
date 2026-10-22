package b36;

import android.net.Uri;
import android.os.Build;
import android.webkit.WebResourceRequest;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class k implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebResourceRequest f17186a;

    @Override // b36.g
    public final boolean a() {
        return this.f17186a.hasGesture();
    }

    @Override // b36.g
    public final CharSequence getMethod() {
        return this.f17186a.getMethod();
    }

    @Override // b36.g
    public final Map<String, String> getRequestHeaders() {
        Map<String, String> r100 = this.f17186a.getRequestHeaders();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return MapsKt.emptyMap();
    }

    @Override // b36.g
    public final Uri getUrl() {
        return this.f17186a.getUrl();
    }

    @Override // b36.g
    public final boolean isForMainFrame() {
        return this.f17186a.isForMainFrame();
    }

    @Override // b36.g
    public final boolean isRedirect() {
        if (Build.VERSION.SDK_INT >= 24) goto L7;
        return false;
    L7:
        return this.f17186a.isRedirect();
    }

    public k(WebResourceRequest r100) {
        this.f17186a = r100;
    }
}
