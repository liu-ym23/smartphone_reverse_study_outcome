package blb;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f19525a = 0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f19527b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f19528c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ IGetDataCallback<String> f19529d;

        public a(String r100, boolean r101, Context r102, IGetDataCallback<String> r103) {
            this.f19526a = r100;
            this.f19527b = r101;
            this.f19528c = r102;
            this.f19529d = r103;
        }

        public final void a() {
            com.ss.android.lark.image.uploader.entity.b.a r100 = new com.ss.android.lark.image.uploader.entity.b.a();
            r100.c(this.f19526a);
            r100.f426409i = this.f19527b;
            com.ss.android.lark.image.uploader.entity.b r101 = r100.b();
            ImageInfo r102 = com.ss.android.lark.image.uploader.utils.b.d(this.f19526a, true, false);
            int r103 = c.f19525a;
            String r104 = c.b(this.f19528c, this.f19526a, r102, r101, null);
            String r105 = com.ss.android.lark.vfs.d.a().G(r104, true).getAbsolutePath();
            if (TextUtils.isEmpty(r105) == false) goto L5;
        L8:
            this.f19529d.onError(new ErrorResult("compress failed"));
            return;
        L5:
            if (new PolarisFileWrapper(r105).exists() == false) goto L8;
            this.f19529d.onSuccess(r105);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static void c(com.ss.android.lark.image.uploader.entity.b r100, ImageUploadTask r101) {
        Intrinsics.checkNotNullParameter(r100, "uploadImage");
        Intrinsics.checkNotNullParameter(r101, "imageUploadTask");
        String r102 = r100.f426387a;
        ImageInfo r103 = r100.f426397k;
        if (r103 != null) goto L5;
        r103 = com.ss.android.lark.image.uploader.utils.b.d(r102, true, false);
    L5:
        String r104 = b(r101.getContext(), r102, r103, r100, r101.f426379e);
        if (TextUtils.isEmpty(r104) == false) goto L9;
        return;
    L9:
        if (new PolarisFileWrapper(r104).exists() == false) goto L11;
        ImageInfo r105 = com.ss.android.lark.image.uploader.utils.b.d(r104, true, true);
        String r106 = com.ss.android.lark.vfs.d.a().G(r104, true).getAbsolutePath();
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r100.f426387a = r106;
        r100.f426397k = r105;
        int r107 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "compress success, before compress:" + r100.f426397k + ", after compress:" + r105);
        return;
    L11:
        com.ss.android.lark.image.uploader.utils.c.b("ImageCompressManager", "failed to compress", null, false);
    }

    public static com.ss.android.lark.image.uploader.entity.a a(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "originPath");
        Intrinsics.checkNotNullParameter(r101, "compressPath");
        if (TextUtils.equals(r101, r100) == false) goto L5;
    L13:
        return null;
    L5:
        if (new PolarisFileWrapper(r100).exists() == false) goto L13;
        if (new PolarisFileWrapper(r101).exists() == false) goto L13;
        long r103 = System.currentTimeMillis() - r102;
        long r104 = new PolarisFileWrapper(r100).length();
        long r105 = new PolarisFileWrapper(r101).length();
        float r106 = 1.0f;
        if (r104 == 0) goto L15;
        r106 = (r105 * 1.0f) / r104;
    L15:
        return new com.ss.android.lark.image.uploader.entity.a(r106, "native", (int) r103);
    }

    public static void d(Context r100, String r101, boolean r102, IGetDataCallback r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "imagePath");
        Intrinsics.checkNotNullParameter(r103, "callback");
        int r104 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "preCompress, filePath:" + r101);
        RxScheduledExecutor.justInIO(new a(r101, r102, r100, r103));
    }

    public static String b(Context r110, String r111, ImageInfo r112, com.ss.android.lark.image.uploader.entity.b r113, flb.b r114) {
        if (r112 != null) goto L7;
        int r115 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.b("ImageCompressManager", "failed to get imageInfo, uploadImage:" + r113 + ", skip compress", null, false);
        return "";
    L7:
        if (r113.f426388b == false) goto L9;
    L12:
        boolean r100 = true;
    L14:
        if (r100 == false) goto L17;
        int r116 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "uploadImage:" + r113 + ", skip compress");
        return "";
    L17:
        int[] r101 = blb.a.a(r112, r114);
        int r102 = r101[0];
        int r103 = r101[1];
        if (r102 >= Math.min(r112.f426421a, r112.f426422b)) goto L20;
    L24:
        boolean r104 = false;
    L25:
        if (r104 == false) goto L28;
        int r117 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "uploadImage:" + r113 + ", cal no need compress, skip compress");
        return "";
    L28:
        zkb.a r105 = zkb.a.f572738a;
        String r106 = zkb.a.a(r110, r111, r101[0], r101[1]);
        if (new PolarisFileWrapper(r106).exists() == false) goto L31;
        int r118 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "uploadImage:" + r113 + ", compress cache exist:" + r106);
    L34:
        return r106;
    L31:
        String r107 = r105.b(r106);
        b r108 = d.a(e.a(r111, r112, r101[0]), r113, r112, r101[1], r107);
        if (r108 == null) goto L36;
        int r119 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "compress finish, outputPath:" + r108.f19524a);
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "rename ret:" + r105.c(r107, r106) + ", tempPath:" + r107 + ", finalPath:" + r106);
        goto L34
    L36:
        if (r113.f426395i == false) goto L42;
        com.ss.android.lark.image.uploader.utils.c.b("ImageCompressManager", "compress webp failed, fallback", null, false);
        r113.f426395i = false;
        if (new PolarisFileWrapper(r107).exists() == false) goto L41;
        com.ss.android.lark.image.uploader.utils.c.b("ImageCompressManager", "delete last file", null, false);
        new PolarisFileWrapper(r107).delete();
    L41:
        return b(r110, r111, r112, r113, r114);
    L42:
        return "";
    L20:
        if (r103 < r112.f426424d) goto L24;
        if (r112.f426428h != ImageUtils.ImageType.TYPE_JPG) goto L24;
        r104 = true;
        goto L25
    L9:
        if (r112.f426429i == true) goto L12;
        r100 = false;
        goto L14
    }
}
