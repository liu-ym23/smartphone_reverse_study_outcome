package a0b;

import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.camera_export.CameraParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Token f1342a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Token f1343b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Token f1344c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Token f1345d = null;

    static {
        f1342a = new Token("LARK-PSDA-android_lark_common_camera_permission_token");
        f1343b = new Token("LARK-PSDA-android_lark_common_camera_storage_token");
        f1344c = new Token("LARK-PSDA-android_lark_common_camera_audio_permission_token");
        new Token("LARK-PSDA-messenger_camera_create_media_uri");
        f1345d = new Token("LARK-PSDA-messenger_camera_notify_system_scan_file");
    }

    public static boolean a(CameraParam r100) {
        if (Intrinsics.areEqual(r100.getMode(), CameraParam.MODE_ONLY_VIDEO) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100.getMode(), CameraParam.MODE_PHOTO_VIDEO_BOTH) == true) goto L8;
        return false;
    }
}
