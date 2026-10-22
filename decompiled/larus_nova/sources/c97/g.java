package c97;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.oat.Dex2OatHelper;
import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.exception.PatchParseException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: classes21.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.reparo.core.g f22874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f22875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f22876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f22877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PolarisFileWrapper f22878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PolarisFileWrapper f22879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, j> f22880g;

    public final void a() {
        List<k.a> r100 = k.a(this.f22878e);
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() == 0) goto L38;
        Iterator<k.a> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L39;
        k.a r102 = r101.next();
        Iterator r103 = ((HashMap) this.f22880g).keySet().iterator();
    L12:
        if (r103.hasNext() == false) goto L9;
        String r104 = (String) r103.next();
        j r105 = (j) ((HashMap) this.f22880g).get(r104);
        if (r105 == null) goto L12;
        Iterator r106 = ((ArrayList) r105.f22901a).iterator();
    L18:
        if (r106.hasNext() == false) goto L22;
        Object r107 = r106.next();
        if (TextUtils.equals(((i) r107).f22896b, r102.f22904a) == false) goto L18;
    L23:
        i r108 = (i) r107;
        if (r108 == null) goto L12;
        r108.f22899e = r102.f22905b;
        goto L12
    L22:
        r107 = null;
        goto L23
    L39:
        return;
    }

    public final void b() {
        PolarisZipFileWrapper r100 = new PolarisZipFileWrapper(this.f22875b);     // Catch: IOException -> L11
        Enumeration<? extends ZipEntry> r101 = r100.entries();     // Catch: IOException -> L11
    L4:
        if (r101.hasMoreElements() == false) goto L9;
        ZipEntry r102 = r101.nextElement();     // Catch: IOException -> L11
        if (r102.getName().contains(DownloadConstants.VULNERABILITY_PATH) == true) goto L4;
        c(r100, r102);     // Catch: IOException -> L11
        goto L4
    L9:
        r100.close();     // Catch: IOException -> L11
        a();     // Catch: IOException -> L11
        return;
    L11:
        e = move-exception;
        throw new PatchParseException(e.getMessage(), e, 400);
    }

    public final void c(PolarisZipFileWrapper r100, ZipEntry r101) {
        this.f22874a.getClass();
        if (r101.getName().endsWith(".so") == false) goto L22;
        String r102 = ((b) this.f22876c).b();
        String r103 = r101.getName();
        int r104 = j.f22900c;
        String r105 = r103.substring(r103.lastIndexOf(HTTP.URL_DEFAULT) + 1);
        i r106 = new i();
        r106.f22896b = r105;
        r106.f22897c = r103;
        r106.f22895a = r103.split(HTTP.URL_DEFAULT)[1];
        r101.getCrc();
    L18:
        e = move-exception;
        throw new PatchParseException("parse patch so entry failed. ", e, 403);
    L6:
        if (TextUtils.equals(r102, r106.f22895a) == false) goto L8;
        InputStream r107 = r100.getInputStream(r101);     // Catch: IOException -> L18
        PolarisFileWrapper r108 = new PolarisFileWrapper(this.f22877d, r101.getName());     // Catch: IOException -> L18
        w87.b.i(r107, r108);     // Catch: IOException -> L18
        r106.f22898d = r108;     // Catch: IOException -> L18
    L8:
        j r109 = (j) ((HashMap) this.f22880g).get(r106.f22895a);     // Catch: IOException -> L18
        if (r109 != null) goto L12;
        r109 = new j(r106.f22895a);     // Catch: IOException -> L18
        ((HashMap) this.f22880g).put(r106.f22895a, r109);     // Catch: IOException -> L18
    L12:
        if (((ArrayList) r109.f22901a).contains(r106) == true) goto L50;
        ((ArrayList) r109.f22901a).add(r106);     // Catch: IOException -> L18
        if (WandTrick.i(r106.f22896b) == true) goto L51;
        r109.f22902b = true;     // Catch: IOException -> L18
        return;
    L51:
        return;
    L50:
        return;
    L22:
        if (TextUtils.equals(r101.getName(), "so-info.txt") == false) goto L29;
        w87.b.i(r100.getInputStream(r101), this.f22878e);     // Catch: IOException -> L25
        return;
    L25:
        e = move-exception;
        throw new PatchParseException("parse so-info.txt failed. ", e, 401);
    L29:
        if (TextUtils.equals(r101.getName(), "patch_classes_methods.txt") == true) goto L37;
        if (TextUtils.equals(r101.getName(), "added_classes.txt") == true) goto L37;
        if (r101.getName().startsWith("deoptimize_methods") == true) goto L37;
        if (r101.getName().endsWith(Dex2OatHelper.DEX_SUFFIX) == true) goto L37;
        return;
    L37:
        if (r101.getSize() <= 0) goto L53;
        w87.b.i(r100.getInputStream(r101), new PolarisFileWrapper(this.f22879f, r101.getName()));     // Catch: IOException -> L41
        return;
    L41:
        e = move-exception;
        throw new PatchParseException("parse " + r101.getName() + " failed.", e, 402);
    }

    public g(File r100, a r101, File r102, com.bytedance.reparo.core.g r103) {
        this.f22880g = new HashMap();
        this.f22875b = r100;
        this.f22876c = r101;
        this.f22877d = r102;
        this.f22874a = r103;
        this.f22878e = new PolarisFileWrapper(r102, "so-info.txt");
        this.f22879f = new PolarisFileWrapper(r102, "java");
    }
}
