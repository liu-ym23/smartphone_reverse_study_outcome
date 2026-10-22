package androidx.webkit;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import androidx.core.util.Pair;
import androidx.webkit.internal.AssetHelper;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public final class WebViewAssetLoader {
    public static final String DEFAULT_DOMAIN = "appassets.androidplatform.net";
    private static final String TAG = "WebViewAssetLoader";
    private final List<PathMatcher> mMatchers;

    public static final class AssetsPathHandler implements PathHandler {
        private AssetHelper mAssetHelper;

        public AssetsPathHandler(Context r100) {
            this.mAssetHelper = new AssetHelper(r100);
        }

        @Override // androidx.webkit.WebViewAssetLoader.PathHandler
        public WebResourceResponse handle(String r100) {
            InputStream r101 = this.mAssetHelper.openAsset(r100);     // Catch: IOException -> L5
            return new WebResourceResponse(AssetHelper.guessMimeType(r100), null, r101);
        L6:
            return new WebResourceResponse(null, null, null);
        }

        public AssetsPathHandler(AssetHelper r100) {
            this.mAssetHelper = r100;
        }
    }

    public static final class Builder {
        private String mDomain;
        private final List<Pair<String, PathHandler>> mHandlerList;
        private boolean mHttpAllowed;

        public WebViewAssetLoader build() {
            ArrayList r100 = new ArrayList();
            Iterator<Pair<String, PathHandler>> r101 = this.mHandlerList.iterator();
        L4:
            if (r101.hasNext() == false) goto L7;
            Pair<String, PathHandler> r102 = r101.next();
            String r103 = r102.first;
            PathHandler r104 = r102.second;
            r100.add(new PathMatcher(this.mDomain, r103, this.mHttpAllowed, r104));
            goto L4
        L7:
            return new WebViewAssetLoader(r100);
        }

        public Builder() {
            this.mDomain = WebViewAssetLoader.DEFAULT_DOMAIN;
            this.mHandlerList = new ArrayList();
        }

        public Builder setDomain(String r100) {
            this.mDomain = r100;
            return this;
        }

        public Builder setHttpAllowed(boolean r100) {
            this.mHttpAllowed = r100;
            return this;
        }

        public Builder addPathHandler(String r100, PathHandler r101) {
            this.mHandlerList.add(Pair.create(r100, r101));
            return this;
        }
    }

    public static final class InternalStoragePathHandler implements PathHandler {
        private static final String[] FORBIDDEN_DATA_DIRS = null;
        private final File mDirectory;

        static {
            FORBIDDEN_DATA_DIRS = new String[]{"app_webview/", "databases/", "lib/", "shared_prefs/", "code_cache/"};
        }

        private boolean isAllowedInternalStorageDir(Context r100) throws IOException {
            String r101 = AssetHelper.getCanonicalDirPath(this.mDirectory);
            String r102 = AssetHelper.getCanonicalDirPath(r100.getCacheDir());
            String r103 = AssetHelper.getCanonicalDirPath(AssetHelper.getDataDir(r100));
            if (r101.startsWith(r102) == true) goto L8;
            if (r101.startsWith(r103) == true) goto L8;
            return false;
        L8:
            if (r101.equals(r102) == false) goto L10;
        L20:
            return false;
        L10:
            if (r101.equals(r103) == true) goto L20;
            String[] r104 = FORBIDDEN_DATA_DIRS;
            int r105 = r104.length;
            int r106 = 0;
        L13:
            if (r106 >= r105) goto L18;
            if (r101.startsWith(r103 + r104[r106]) == true) goto L16;
            r106 = r106 + 1;
            goto L13
        L16:
            return false;
        L18:
            return true;
        }

        @Override // androidx.webkit.WebViewAssetLoader.PathHandler
        public WebResourceResponse handle(String r100) {
            File r101 = AssetHelper.getCanonicalFileIfChild(this.mDirectory, r100);     // Catch: IOException -> L9
            if (r101 != null) goto L6;
            String.format("The requested file: %s is outside the mounted directory: %s", new Object[]{r100, this.mDirectory});     // Catch: IOException -> L9
            goto L11
        L6:
            return new WebResourceResponse(AssetHelper.guessMimeType(r100), null, AssetHelper.openFile(r101));
        L11:
            return new WebResourceResponse(null, null, null);
        }

        public InternalStoragePathHandler(Context r100, File r101) {
            this.mDirectory = new File(AssetHelper.getCanonicalDirPath(r101));     // Catch: IOException -> L8
            if (isAllowedInternalStorageDir(r100) == false) goto L7;
            return;
        L7:
            throw new IllegalArgumentException("The given directory \"" + r101 + "\" doesn't exist under an allowed app internal storage directory");     // Catch: IOException -> L8
        L8:
            e = move-exception;
            throw new IllegalArgumentException("Failed to resolve the canonical path for the given directory: " + r101.getPath(), e);
        }
    }

    public interface PathHandler {
        WebResourceResponse handle(String r100);
    }

    public static class PathMatcher {
        static final String HTTPS_SCHEME = "https";
        static final String HTTP_SCHEME = "http";
        final String mAuthority;
        final PathHandler mHandler;
        final boolean mHttpEnabled;
        final String mPath;

        public String getSuffixPath(String r100) {
            return r100.replaceFirst(this.mPath, "");
        }

        public PathHandler match(Uri r100) {
            if (r100.getScheme().equals("http") == false) goto L8;
            if (this.mHttpEnabled == true) goto L8;
            return null;
        L8:
            if (r100.getScheme().equals("http") == true) goto L13;
            if (r100.getScheme().equals("https") == true) goto L13;
            return null;
        L13:
            if (r100.getAuthority().equals(this.mAuthority) == true) goto L16;
            return null;
        L16:
            if (r100.getPath().startsWith(this.mPath) == true) goto L19;
            return null;
        L19:
            return this.mHandler;
        }

        public PathMatcher(String r100, String r101, boolean r102, PathHandler r103) {
            if (r101.isEmpty() == true) goto L13;
            if (r101.charAt(0) != '/') goto L13;
            if (r101.endsWith(HTTP.URL_DEFAULT) == false) goto L11;
            this.mAuthority = r100;
            this.mPath = r101;
            this.mHttpEnabled = r102;
            this.mHandler = r103;
            return;
        L11:
            throw new IllegalArgumentException("Path should end with a slash '/'");
        L13:
            throw new IllegalArgumentException("Path should start with a slash '/'.");
        }
    }

    public static final class ResourcesPathHandler implements PathHandler {
        private AssetHelper mAssetHelper;

        public ResourcesPathHandler(Context r100) {
            this.mAssetHelper = new AssetHelper(r100);
        }

        @Override // androidx.webkit.WebViewAssetLoader.PathHandler
        public WebResourceResponse handle(String r100) {
            InputStream r101 = this.mAssetHelper.openResource(r100);     // Catch: IOException -> L5 Resources.NotFoundException -> L6
            return new WebResourceResponse(AssetHelper.guessMimeType(r100), null, r101);
        L8:
            return new WebResourceResponse(null, null, null);
        }

        public ResourcesPathHandler(AssetHelper r100) {
            this.mAssetHelper = r100;
        }
    }

    public WebViewAssetLoader(List<PathMatcher> r100) {
        this.mMatchers = r100;
    }

    public WebResourceResponse shouldInterceptRequest(Uri r100) {
        Iterator<PathMatcher> r101 = this.mMatchers.iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        PathMatcher r102 = r101.next();
        PathHandler r103 = r102.match(r100);
        if (r103 == null) goto L4;
        WebResourceResponse r104 = r103.handle(r102.getSuffixPath(r100.getPath()));
        if (r104 == null) goto L4;
        return r104;
    L12:
        return null;
    }
}
