package androidx.navigation;

import android.content.Intent;
import android.net.Uri;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0011B%\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007B\u000f\b\u0017\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/navigation/NavDeepLinkRequest;", "", "uri", "Landroid/net/Uri;", "action", "", DBDefinition.MIME_TYPE, "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)V", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "getAction", "()Ljava/lang/String;", "getMimeType", "getUri", "()Landroid/net/Uri;", "toString", "Builder", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NavDeepLinkRequest {
    private final String action;
    private final String mimeType;
    private final Uri uri;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/navigation/NavDeepLinkRequest$Builder;", "", "()V", "action", "", DBDefinition.MIME_TYPE, "uri", "Landroid/net/Uri;", "build", "Landroidx/navigation/NavDeepLinkRequest;", "setAction", "setMimeType", "setUri", "Companion", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        public static final Companion Companion = null;
        private String action;
        private String mimeType;
        private Uri uri;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Landroidx/navigation/NavDeepLinkRequest$Builder$Companion;", "", "()V", "fromAction", "Landroidx/navigation/NavDeepLinkRequest$Builder;", "action", "", "fromMimeType", DBDefinition.MIME_TYPE, "fromUri", "uri", "Landroid/net/Uri;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            @JvmStatic
            public final Builder fromAction(String r100) {
                Intrinsics.checkNotNullParameter(r100, "action");
                if (r100.length() <= 0) goto L5;
                boolean r101 = true;
            L6:
                if (r101 == false) goto L10;
                Builder r102 = new Builder(null);
                r102.setAction(r100);
                return r102;
            L10:
                throw new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.".toString());
            L5:
                r101 = false;
                goto L6
            }

            @JvmStatic
            public final Builder fromMimeType(String r100) {
                Intrinsics.checkNotNullParameter(r100, DBDefinition.MIME_TYPE);
                Builder r101 = new Builder(null);
                r101.setMimeType(r100);
                return r101;
            }

            @JvmStatic
            public final Builder fromUri(Uri r100) {
                Intrinsics.checkNotNullParameter(r100, "uri");
                Builder r101 = new Builder(null);
                r101.setUri(r100);
                return r101;
            }
        }

        static {
            Companion = new Companion(null);
        }

        private Builder() {
        }

        public /* synthetic */ Builder(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public static final Builder fromAction(String r100) {
            return Companion.fromAction(r100);
        }

        @JvmStatic
        public static final Builder fromMimeType(String r100) {
            return Companion.fromMimeType(r100);
        }

        @JvmStatic
        public static final Builder fromUri(Uri r100) {
            return Companion.fromUri(r100);
        }

        public final NavDeepLinkRequest build() {
            return new NavDeepLinkRequest(this.uri, this.action, this.mimeType);
        }

        public final Builder setAction(String r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            if (r100.length() <= 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L10;
            this.action = r100;
            return this;
        L10:
            throw new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.".toString());
        L5:
            r101 = false;
            goto L6
        }

        public final Builder setMimeType(String r100) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.MIME_TYPE);
            if (new Regex("^[-\\w*.]+/[-\\w+*.]+$").matches(r100) == false) goto L7;
            this.mimeType = r100;
            return this;
        L7:
            throw new IllegalArgumentException(("The given mimeType " + r100 + " does not match to required \"type/subtype\" format").toString());
        }

        public final Builder setUri(Uri r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            this.uri = r100;
            return this;
        }
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("NavDeepLinkRequest{");
        if (getUri() == null) goto L6;
        r100.append(" uri=");
        r100.append(String.valueOf(getUri()));
    L6:
        if (getAction() == null) goto L9;
        r100.append(" action=");
        r100.append(getAction());
    L9:
        if (getMimeType() == null) goto L11;
        r100.append(" mimetype=");
        r100.append(getMimeType());
    L11:
        r100.append(" }");
        return r100.toString();
    }

    public String getAction() {
        return this.action;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Uri getUri() {
        return this.uri;
    }

    public NavDeepLinkRequest(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        this(r100.getData(), r100.getAction(), r100.getType());
    }

    public NavDeepLinkRequest(Uri r100, String r101, String r102) {
        this.uri = r100;
        this.action = r101;
        this.mimeType = r102;
    }
}
