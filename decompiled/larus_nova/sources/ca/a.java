package ca;

import android.app.Activity;
import android.view.ViewParent;
import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements b {
    public a() {
    }

    @Override // ca.b
    public final boolean G1(ViewParent r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return false;
    }

    @Override // ca.b
    public final void m0(Activity r100, WebView r101, String r102, String r103, String r104, String r105, long r106) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "webView");
    }
}
