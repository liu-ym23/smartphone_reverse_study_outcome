package b36;

import android.content.Intent;
import android.webkit.WebChromeClient;

/* JADX INFO: loaded from: classes19.dex */
public final class n implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebChromeClient.FileChooserParams f17189a;

    @Override // b36.a
    public final Intent a() {
        return this.f17189a.createIntent();
    }

    @Override // b36.a
    public final CharSequence b() {
        return this.f17189a.getFilenameHint();
    }

    @Override // b36.a
    public final boolean c() {
        return this.f17189a.isCaptureEnabled();
    }

    @Override // b36.a
    public final String[] d() {
        return this.f17189a.getAcceptTypes();
    }

    public final boolean e() {
        if (this.f17189a.getMode() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // b36.a
    public final int getMode() {
        return this.f17189a.getMode();
    }

    @Override // b36.a
    public final CharSequence getTitle() {
        return this.f17189a.getTitle();
    }

    public n(WebChromeClient.FileChooserParams r100) {
        this.f17189a = r100;
    }
}
