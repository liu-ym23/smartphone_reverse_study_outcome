package c2c;

import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.vesdk.algorithm.VEBachQRCodeResult;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: c2c.a$a, reason: collision with other inner class name */
    public static final class C0396a {
    }

    static {
    }

    public a() {
    }

    public static void b(long r100, VEBachQRCodeResult r101) {
        Intrinsics.checkNotNullParameter(CameraParam.TYPE_VE_CAMERA, "type");
        Intrinsics.checkNotNullParameter("album", "scanSource");
        Statistics.sendEvent("qrcode_success_scan", new JSONObject().put("ve_scan_type", CameraParam.TYPE_VE_CAMERA).put("use_enigma_detect", false).put("time_consuming", r100).put("algo_duration", Float.valueOf(r101.getAvgTimeForQRCodeMs())).put("scan_source", "album").put("imageWidth", Integer.valueOf(r101.getCurrentFrameWidth())).put("imageHeight", Integer.valueOf(r101.getCurrentFrameHeight())).put("vesdk_enabled", "true"));
    }

    public static void a(String r100, boolean r101, String r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r102, "reason");
        Statistics.sendEvent("qrcode_exit_dev", new JSONObject().put("ve_scan_type", r100).put("use_enigma_detect", r101).put("reason", r102).put("time_consuming", r103).put("vesdk_enabled", "true"));
    }
}
