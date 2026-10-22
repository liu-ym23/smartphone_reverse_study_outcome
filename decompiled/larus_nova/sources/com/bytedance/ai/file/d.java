package com.bytedance.ai.file;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f36593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f36594b;

    public static List c(String r100) {
        List r101 = StringsKt.split$default(r100, new char[]{File.separatorChar}, false, 0, 6, null);
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if (((String) r104).length() <= 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        r105 = false;
        goto L9
    L11:
        return r102;
    }

    public final File a(a r210) {
        Intrinsics.checkNotNullParameter(r210, "file");
        if (r210.c() == false) goto L6;
        File r100 = this.f36593a;
        int r101 = e.f36595a;
        Uri r102 = r210.f36591a;
        Intrinsics.checkNotNullParameter(r102, "uri");
        Pair r103 = TuplesKt.to(r100, r102.getEncodedPath());
    L8:
        File r104 = (File) r103.component1();
        String r105 = (String) r103.component2();
        String r106 = "";
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        String r107 = StringsKt.removeSuffix(StringsKt.removePrefix(r105, HTTP.URL_DEFAULT), HTTP.URL_DEFAULT);
        boolean r110 = false;
        if (r107.length() != 0) goto L14;
        boolean r108 = true;
    L15:
        if (r108 == true) goto L52;
        List r109 = StringsKt.split$default(r107, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
        ArrayList r111 = new ArrayList(r109.size());
        Iterator r112 = r109.iterator();
    L19:
        if (r112.hasNext() == false) goto L50;
        String r113 = (String) r112.next();
        if (r113.length() != 0) goto L23;
        boolean r114 = true;
    L24:
        if (r114 == true) goto L49;
        if (StringsKt.contains(r113, "%2F", true) == true) goto L47;
        String r115 = Uri.decode(r113);
        if (r115 == null) goto L45;
        if (StringsKt.contains$default(r115, '\\', false, 2, null) == true) goto L43;
        if (StringsKt.contains$default(r115, 0, false, 2, null) == true) goto L41;
        if (Intrinsics.areEqual(r115, ".") == true) goto L39;
        if (Intrinsics.areEqual(r115, DownloadConstants.VULNERABILITY_PATH) == true) goto L39;
        r111.add(r115);
    L39:
        throw AppletFileError.InvalidUri.INSTANCE;
    L41:
        throw AppletFileError.InvalidUri.INSTANCE;
    L43:
        throw AppletFileError.InvalidUri.INSTANCE;
    L45:
        throw AppletFileError.InvalidUri.INSTANCE;
    L47:
        throw AppletFileError.InvalidUri.INSTANCE;
    L49:
        throw AppletFileError.InvalidUri.INSTANCE;
    L23:
        r114 = false;
        goto L24
    L50:
        r106 = CollectionsKt.joinToString$default(r111, File.separator, null, null, 0, null, null, 62, null);
    L52:
        if (r106.length() != 0) goto L54;
        r110 = true;
    L54:
        if (r110 == false) goto L56;
        File r116 = r104;
    L74:
        File r117 = r116.getCanonicalFile();     // Catch: Throwable -> L67
        File r118 = r104.getCanonicalFile();     // Catch: Throwable -> L64
        Intrinsics.checkNotNull(r117);
        Intrinsics.checkNotNull(r118);
        if (d(r117, r118) == false) goto L63;
        return r117;
    L63:
        throw AppletFileError.PathEscape.INSTANCE;
    L64:
        th = move-exception;
        throw new AppletFileError.IoError(th);
    L67:
        th = move-exception;
        throw new AppletFileError.IoError(th);
    L56:
        r116 = new PolarisFileWrapper(r104, r106);
        goto L74
    L14:
        r108 = false;
        goto L15
    L6:
        if (r210.b() == false) goto L71;
        File r119 = this.f36594b;
        int r120 = e.f36595a;
        Uri r121 = r210.f36591a;
        Intrinsics.checkNotNullParameter(r121, "uri");
        r103 = TuplesKt.to(r119, r121.getEncodedPath());
        goto L8
    L71:
        throw AppletFileError.InvalidUri.INSTANCE;
    }

    public d(PolarisFileWrapper r100, PolarisFileWrapper r101) {
        Intrinsics.checkNotNullParameter(r100, "userRoot");
        Intrinsics.checkNotNullParameter(r101, "tempRoot");
        this.f36593a = r100;
        this.f36594b = r101;
    }

    public static String b(File r100, File r110) {
        List r101 = c(r100.getPath());
        List r111 = c(r110.getPath());
        ArrayList r102 = (ArrayList) r101;
        ArrayList r112 = (ArrayList) r111;
        if (r102.size() != r112.size()) goto L7;
        return "";
    L7:
        return CollectionsKt.joinToString$default(r102.subList(r112.size(), r102.size()), File.separator, null, null, 0, null, null, 62, null);
    }

    public static boolean d(File r100, File r101) {
        List r102 = c(r100.getPath());
        List r103 = c(r101.getPath());
        ArrayList r104 = (ArrayList) r103;
        if (((ArrayList) r102).size() >= r104.size()) goto L5;
        return false;
    L5:
        int r105 = r104.size();
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L11;
        if (Intrinsics.areEqual(ListProtector.get(r102, r106), ListProtector.get(r103, r106)) == false) goto L9;
        r106 = r106 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }
}
