package clb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.image.uploader.upload.AvatarUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.BackgroundUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.EncryptImageUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.ProfileCoverUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.StickerUploader$batchUploadImage$1;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public interface a {
    boolean c();

    void d(PolarisFileWrapper r100, int r101, int r102, boolean r103, EncryptImageUploader$uploadImage$1 r104);

    void e(String r100, ProfileCoverUploader$uploadImage$1 r101);

    int[] f(long r100, int r101, int r102, int r103, int r104, int r105);

    void g(List r100, StickerUploader$batchUploadImage$1 r101);

    void h(String r100, BackgroundUploader$uploadImage$1 r101);

    void i(String r100, AvatarUploader$uploadImage$1 r101);
}
