package alb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.image.uploader.config.ConfigManager;
import com.ss.android.lark.image.uploader.config.OriginalModeFormat;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f4216a = 0;

    static {
    }

    public static int a(com.ss.android.lark.image.uploader.entity.b r110) {
        Intrinsics.checkNotNullParameter(r110, "uploadImage");
        String r100 = r110.f426387a;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        OriginalModeFormat r102 = null;
        if (r101.exists() == true) goto L6;
        int r103 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.b("FileSizeChecker", "checkValidFailed, file not exist:" + r110, null, false);
        return -10002;
    L6:
        String[] r104 = FileUtils.f285888a;
        long r105 = r101.length();
        ImageInfo r106 = r110.f426397k;
        if (r106 != null) goto L9;
        r106 = com.ss.android.lark.image.uploader.utils.b.d(r100, true, false);
        r110.f426397k = r106;
    L9:
        long r107 = ConfigManager.c(r110);
        if (r105 <= r107) goto L13;
        int r111 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.b("FileSizeChecker", "checkValidFailed, file size over limit, file size:" + r105 + ", fileSizeLimit:" + r107, null, false);
        return -10001;
    L13:
        if (r106 == null) goto L18;
        int r108 = r106.f426421a * r106.f426422b;
        Intrinsics.checkNotNullParameter(r110, "uploadImage");
        int r109 = ConfigManager.e(r110) * ConfigManager.d(r110);
        if (r108 <= r109) goto L19;
        int r112 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.b("FileSizeChecker", "checkValidFailed, file resolution over limit, file resolution:" + r108 + ", fileResolutionLimit:" + r109, null, false);
        return -10003;
    L19:
        if (r106 != null) goto L21;
    L29:
        return 0;
    L21:
        if (r110.f426388b == false) goto L29;
        com.ss.android.lark.image.uploader.config.c r113 = ConfigManager.a().getFileSizeConfig();
        if (r113 == null) goto L26;
        r102 = r113.a(r106.f426425e).c();
    L26:
        if (r102 != OriginalModeFormat.FILE) goto L29;
        return -10006;
    L18:
        int r114 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.b("FileSizeChecker", "checkValidFailed, failed to get bitmapInfo. UploadImage:" + r110, null, false);
        goto L19
    }

    public static a b(ImageUploadTask r110) {
        Intrinsics.checkNotNullParameter(r110, "task");
        flb.a r100 = r110.f426378d;
        ArrayList<com.ss.android.lark.image.uploader.entity.b> r111 = r110.f426376b;
        com.ss.android.lark.image.uploader.config.c r101 = ConfigManager.a().getFileSizeConfig();
        if (r101 != null) goto L7;
        r101 = ConfigManager.f426370b.getFileSizeConfig();
        if (r101 != null) goto L7;
        boolean r102 = true;
    L10:
        if (r100 == null) goto L12;
        boolean r103 = r100.f477762b;
    L14:
        if (r102 == false) goto L33;
        if (r103 == true) goto L33;
        Iterator<com.ss.android.lark.image.uploader.entity.b> r112 = r111.iterator();
    L19:
        if (r112.hasNext() == false) goto L32;
        com.ss.android.lark.image.uploader.entity.b r104 = r112.next();
        int r105 = a(r104);
        int r106 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("FileSizeChecker", "checkValid, image:" + r104 + ", ret:" + r105);
        if (r105 == 0) goto L19;
        if (r105 != (-10003)) goto L25;
        Lazy r113 = ConfigManager.f426369a;
        Intrinsics.checkNotNullParameter(r104, "uploadImage");
        long r107 = ConfigManager.e(r104) * ConfigManager.d(r104);
    L30:
        return new a(r105, r104, r107, ConfigManager.e(r104), ConfigManager.d(r104));
    L25:
        if (r105 == (-10001)) goto L27;
        r107 = 0;
        goto L30
    L27:
        r107 = ConfigManager.c(r104) / ((long) 1048576);
        goto L30
    L32:
        return new a(0, null, 30);
    L33:
        int r114 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("FileSizeChecker", "FileSizeCheckConfig close, config:" + r102 + ", setting:" + r103 + ",  skip");
        return new a(0, null, 30);
    L12:
        r103 = false;
    L7:
        r102 = r101.c();
        goto L10
    }
}
