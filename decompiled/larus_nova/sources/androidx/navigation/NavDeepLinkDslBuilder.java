package androidx.navigation;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@NavDeepLinkDsl
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/navigation/NavDeepLinkDslBuilder;", "", "()V", "p", "", "action", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "builder", "Landroidx/navigation/NavDeepLink$Builder;", DBDefinition.MIME_TYPE, "getMimeType", "setMimeType", "uriPattern", "getUriPattern", "setUriPattern", "build", "Landroidx/navigation/NavDeepLink;", "build$navigation_common_release", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavDeepLinkDslBuilder {
    private String action;
    private final NavDeepLink.Builder builder;
    private String mimeType;
    private String uriPattern;

    public final NavDeepLink build$navigation_common_release() {
        NavDeepLink.Builder r100 = this.builder;
        if (getUriPattern() == null) goto L5;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L27;
        String r102 = getUriPattern();
        if (r102 == null) goto L16;
        r100.setUriPattern(r102);
    L16:
        String r103 = getAction();
        if (r103 == null) goto L20;
        r100.setAction(r103);
    L20:
        String r104 = getMimeType();
        if (r104 == null) goto L25;
        r100.setMimeType(r104);
    L25:
        return r100.build();
    L27:
        throw new IllegalStateException("The NavDeepLink must have an uri, action, and/or mimeType.".toString());
    L5:
        if (getAction() != null) goto L10;
        if (getMimeType() != null) goto L10;
        r101 = false;
        goto L11
    }

    public NavDeepLinkDslBuilder() {
        this.builder = new NavDeepLink.Builder();
    }

    public final String getAction() {
        return this.action;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getUriPattern() {
        return this.uriPattern;
    }

    public final void setAction(String r100) {
        if (r100 != null) goto L4;
    L11:
        this.action = r100;
        return;
    L4:
        if (r100.length() != 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L11;
        throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
    L6:
        r101 = false;
        goto L7
    }

    public final void setMimeType(String r100) {
        this.mimeType = r100;
    }

    public final void setUriPattern(String r100) {
        this.uriPattern = r100;
    }
}
