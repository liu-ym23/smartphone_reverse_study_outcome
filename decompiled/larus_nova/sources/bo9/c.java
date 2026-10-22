package bo9;

import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager$buildUploadCallback$1;
import fub.d;
import fub.e;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class c implements y79.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fub.b f19878a;

    public c(MmMinutesFileUploadSessionManager$buildUploadCallback$1 r100) {
        this.f19878a = r100;
    }

    @Override // y79.a
    public final void b(long r110, long r111) {
        if (r111 <= 0) goto L5;
        int r100 = RangesKt.coerceIn((int) ((((long) 100) * r110) / r111), 0, 100);
    L6:
        this.f19878a.a(new d(r110, r111, r100));
        return;
    L5:
        r100 = 0;
        goto L6
    }

    @Override // y79.a
    public final void onFailed(String r100, int r101) {
        FLogger.f375446a.e("RecordingDriveServiceImpl", "onFailed, taskKey=" + r100 + ", errorCode=" + r101);
        this.f19878a.onError(r101, "upload_failed");
    }

    @Override // y79.a
    public final void a(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "fileToken");
        if (r101.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L9;
        FLogger.f375446a.e("RecordingDriveServiceImpl", "onSuccess but fileToken empty, taskKey=" + r100);
        this.f19878a.onError(-1, "empty_file_token");
        return;
    L9:
        Map r106 = MapsKt.createMapBuilder();
        if (r103 == null) goto L12;
        String r107 = (String) r106.put(DrivePreviewOpenItem.EXTRA_MOUNT_NODE_TOKEN, r103);
    L12:
        if (r104 == null) goto L14;
        r106.put(DrivePreviewOpenItem.EXTRA_MOUNT_POINT, r104);
    L14:
        this.f19878a.b(new e(r101, r102, MapsKt.build(r106)));
        return;
    L5:
        r105 = false;
        goto L6
    }
}
