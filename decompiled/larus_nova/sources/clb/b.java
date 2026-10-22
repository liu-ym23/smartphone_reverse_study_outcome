package clb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.image.uploader.upload.AvatarUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.BackgroundUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.EncryptImageUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.ProfileCoverUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.StickerUploader$batchUploadImage$1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements clb.a {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // clb.a
    public final boolean c() {
        Intrinsics.checkNotNullParameter("lark.image.jpeg.tool.safe.read.disable", "key");
        return false;
    }

    @Override // clb.a
    public final void e(String r100, ProfileCoverUploader$uploadImage$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "callback");
    }

    @Override // clb.a
    public final void g(List r100, StickerUploader$batchUploadImage$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "pathList");
        Intrinsics.checkNotNullParameter(r101, "callback");
    }

    @Override // clb.a
    public final void h(String r100, BackgroundUploader$uploadImage$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "callback");
    }

    @Override // clb.a
    public final void i(String r100, AvatarUploader$uploadImage$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "callback");
    }

    @Override // clb.a
    public final void d(PolarisFileWrapper r100, int r101, int r102, boolean r103, EncryptImageUploader$uploadImage$1 r104) {
        Intrinsics.checkNotNullParameter(r100, "file");
        Intrinsics.checkNotNullParameter(r104, "callback");
        int r105 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("MockImageUploadDependency", "uploadEncryptImage");
        CoreThreadPool.getBackgroundHandler().postDelayed(new c(r104), 1000);
    }

    @Override // clb.a
    public final int[] f(long r100, int r101, int r102, int r103, int r104, int r105) {
        int r106 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("MockImageUploadDependency", "getImageCompressParams");
        return new int[]{r101, r103};
    }
}
