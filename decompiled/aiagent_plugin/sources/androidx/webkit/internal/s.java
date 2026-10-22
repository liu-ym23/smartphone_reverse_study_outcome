package androidx.webkit.internal;

import android.webkit.WebView;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: compiled from: WebViewProviderFactory.java */
/* JADX INFO: loaded from: classes.dex */
public interface s {
    WebViewProviderBoundaryInterface a(WebView r1);

    WebkitToCompatConverterBoundaryInterface a();

    StaticsBoundaryInterface b();

    String[] c();

    DropDataContentProviderBoundaryInterface d();

    ProfileStoreBoundaryInterface e();
}
