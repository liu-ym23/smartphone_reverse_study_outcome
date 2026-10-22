package androidx.webkit.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes17.dex */
public class AssetHelper {
    public static final String DEFAULT_MIME_TYPE = "text/plain";
    private Context mContext;

    public AssetHelper(Context r100) {
        this.mContext = r100;
    }

    public static String getCanonicalDirPath(File r100) throws IOException {
        String r101 = r100.getCanonicalPath();
        if (r101.endsWith(HTTP.URL_DEFAULT) == false) goto L5;
        return r101;
    L5:
        return r101.concat(HTTP.URL_DEFAULT);
    }

    public static File getDataDir(Context r100) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return ApiHelperForN.getDataDir(r100);
    L7:
        return r100.getCacheDir().getParentFile();
    }

    private int getValueType(int r100) {
        TypedValue r101 = new TypedValue();
        this.mContext.getResources().getValue(r100, r101, true);
        return r101.type;
    }

    public static String guessMimeType(String r100) {
        String r101 = URLConnection.guessContentTypeFromName(r100);
        if (r101 != null) goto L6;
        return "text/plain";
    L6:
        return r101;
    }

    public static InputStream openFile(File r100) throws FileNotFoundException, IOException {
        FileInputStream r101 = new FileInputStream(r100);
        return handleSvgzStream(r100.getPath(), r101);
    }

    private static String removeLeadingSlash(String r100) {
        if (r100.length() > 1) goto L5;
        return r100;
    L5:
        if (r100.charAt(0) == '/') goto L7;
        return r100;
    L7:
        return r100.substring(1);
    }

    public InputStream openAsset(String r100) throws IOException {
        String r101 = removeLeadingSlash(r100);
        return handleSvgzStream(r101, this.mContext.getAssets().open(r101, 2));
    }

    public InputStream openResource(String r100) throws Resources.NotFoundException, IOException {
        String r101 = removeLeadingSlash(r100);
        String[] r102 = r101.split(HTTP.URL_DEFAULT, -1);
        if (r102.length != 2) goto L14;
        String r103 = r102[0];
        String r104 = r102[1];
        int r105 = r104.lastIndexOf(46);
        if (r105 == (-1)) goto L7;
        r104 = r104.substring(0, r105);
    L7:
        int r106 = getFieldId(r103, r104);
        int r107 = getValueType(r106);
        if (r107 != 3) goto L12;
        return handleSvgzStream(r101, this.mContext.getResources().openRawResource(r106));
    L12:
        throw new IOException(String.format("Expected %s resource to be of TYPE_STRING but was %d", new Object[]{r101, Integer.valueOf(r107)}));
    L14:
        throw new IllegalArgumentException("Incorrect resource path: ".concat(r101));
    }

    public static File getCanonicalFileIfChild(File r100, String r101) throws IOException {
        String r102 = getCanonicalDirPath(r100);
        String r103 = new File(r100, r101).getCanonicalPath();
        if (r103.startsWith(r102) == true) goto L5;
        return null;
    L5:
        return new File(r103);
    }

    private int getFieldId(String r100, String r101) {
        String r102 = this.mContext.getPackageName();
        return this.mContext.getResources().getIdentifier(r101, r100, r102);
    }

    private static InputStream handleSvgzStream(String r100, InputStream r101) throws IOException {
        if (r100.endsWith(".svgz") == true) goto L5;
        return r101;
    L5:
        return new GZIPInputStream(r101);
    }
}
