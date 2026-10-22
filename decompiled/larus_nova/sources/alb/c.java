package alb;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.image.uploader.config.ConfigManager;
import com.ss.android.lark.image.uploader.config.d;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f4217a = 0;

    static {
    }

    public static a b(ImageUploadTask r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        flb.a r101 = r100.f426378d;
        ArrayList<com.ss.android.lark.image.uploader.entity.b> r102 = r100.f426376b;
        d r103 = ConfigManager.a().getFileTypeConfig();
        if (r103 != null) goto L7;
        r103 = ConfigManager.f426370b.getFileTypeConfig();
        if (r103 != null) goto L7;
        boolean r104 = true;
    L10:
        if (r101 == null) goto L12;
        boolean r105 = r101.f477762b;
    L14:
        if (r104 == false) goto L26;
        if (r105 == true) goto L26;
        Iterator<com.ss.android.lark.image.uploader.entity.b> r106 = r102.iterator();
    L19:
        if (r106.hasNext() == false) goto L25;
        com.ss.android.lark.image.uploader.entity.b r107 = r106.next();
        int r108 = a(r107, r101);
        int r109 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("FileTypeChecker", "checkValid, image:" + r107 + ", ret:" + r108);
        if (r108 == 0) goto L19;
        return new a(r108, r107, 28);
    L25:
        return new a(0, null, 30);
    L26:
        int r110 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("FileTypeChecker", "FileTypeCheckConfig close, config:" + r104 + ", setting:" + r105 + ",  skip");
        return new a(0, null, 30);
    L12:
        r105 = false;
    L7:
        r104 = r103.a();
        goto L10
    }

    public static int a(com.ss.android.lark.image.uploader.entity.b r110, flb.a r111) {
        Intrinsics.checkNotNullParameter(r110, "uploadImage");
        PolarisFileWrapper r100 = new PolarisFileWrapper(r110.f426387a);
        if (r100.exists() == true) goto L6;
        int r112 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.b("FileTypeChecker", "checkValidFailed, file not exist:" + r110, null, false);
        return -10002;
    L6:
        ImageInfo r101 = r110.f426397k;
        if (r101 == null) goto L10;
        String r102 = r101.f426425e;
        if (r102 == null) goto L10;
    L11:
        int r103 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("FileTypeChecker", "checkValid, mimeType:" + r102 + ", image:" + r110);
        ImageInfo r104 = r110.f426397k;
        if (r104 != null) goto L14;
        r104 = com.ss.android.lark.image.uploader.utils.b.d(r110.f426387a, true, false);
        r110.f426397k = r104;
    L14:
        if (r104 != null) goto L16;
    L20:
        boolean r105 = false;
    L21:
        if (r105 == true) goto L24;
        com.ss.android.lark.image.uploader.utils.c.b("FileTypeChecker", "can't decode, image:" + r110, null, false);
        return -10004;
    L24:
        if (r111 == null) goto L26;
        boolean r113 = r111.f477761a;
    L27:
        Lazy r114 = ConfigManager.f426369a;
        if (r113 == false) goto L32;
        d r115 = ConfigManager.a().getFileTypeConfig();
        if (r115 == null) goto L35;
        ArrayList<String> r116 = r115.b();
    L36:
        if (r116 == null) goto L38;
        List r117 = CollectionsKt.filterNotNull(r116);
    L39:
        if (r117 != null) goto L41;
        r117 = CollectionsKt.emptyList();
    L41:
        Intrinsics.checkNotNull(r102);
        if (TextUtils.isEmpty(r102) == false) goto L45;
        boolean r118 = false;
    L48:
        if (r118 == false) goto L50;
        return 0;
    L50:
        if (TextUtils.equals(r102, "*/*") == true) goto L55;
        return -10005;
    L55:
        return 0;
    L45:
        if (StringsKt.contains$default(r102, HTTP.URL_DEFAULT, false, 2, null) == true) goto L47;
        r118 = r117.contains(r102.toLowerCase());
        goto L48
    L47:
        String r119 = r102.substring(Math.min(r102.length() - 1, StringsKt.lastIndexOf$default(r102, '/', 0, false, 6, null) + 1));
        com.ss.android.lark.image.uploader.utils.c.c("FileTypeChecker", "image subType:" + r119);
        r118 = r117.contains(r119.toLowerCase());
        goto L48
    L38:
        r117 = null;
    L35:
        r116 = null;
        goto L36
    L32:
        d r120 = ConfigManager.a().getFileTypeConfig();
        if (r120 == null) goto L35;
        r116 = r120.c();
        goto L36
    L26:
        r113 = false;
        goto L27
    L16:
        if (r104.f426421a <= 0) goto L20;
        if (r104.f426422b <= 0) goto L20;
        r105 = true;
    L10:
        String[] r106 = FileUtils.f285888a;
        r102 = FileUtils.p(r100.getPath());
        goto L11
    }
}
