package a0b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.m;
import com.ss.android.lark.camera.startor.SystemCameraActivity;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CameraParam f1348c;

    public g(Context r100) {
        this.f1347b = r100;
    }

    public final Intent a(boolean r100) throws IOException {
        Intent r101 = new Intent("android.media.action.IMAGE_CAPTURE");
        if (r101.resolveActivity(this.f1347b.getPackageManager()) == null) goto L16;
        String r102 = "JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.ENGLISH).format(new Date()) + ".jpg";
        File r103 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (r103.exists() == false) goto L7;
    L11:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103, r102);
        this.f1346a = r104.getAbsolutePath();
        Uri r105 = m.a(this.f1347b, r104);
        if (r105 == null) goto L16;
        if (r100 == false) goto L15;
        r101.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
        r101.putExtra("android.intent.extras.CAMERA_FACING", 1);
        r101.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
    L15:
        r101.putExtra(BdpAppEventConstant.PARAMS_OUTPUT, r105);
        goto L16
    L7:
        if (r103.mkdir() == true) goto L11;
        Log.e("SCREEN_TAG", "Throwing Errors....");
        throw new IOException();
    L16:
        return r101;
    }

    public final Intent b(boolean r100) throws IOException {
        Intent r101 = new Intent("android.media.action.VIDEO_CAPTURE");
        if (r101.resolveActivity(this.f1347b.getPackageManager()) == null) goto L19;
        String r102 = "MP4_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.ENGLISH).format(new Date()) + ".mp4";
        File r103 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
        if (r103.exists() == false) goto L7;
    L11:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103, r102);
        this.f1346a = r104.getAbsolutePath();
        Uri r105 = m.a(this.f1347b, r104);
        if (r105 == null) goto L19;
        if (r100 == false) goto L16;
        r101.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
        r101.putExtra("android.intent.extras.CAMERA_FACING", 1);
        r101.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
    L16:
        r101.putExtra(BdpAppEventConstant.PARAMS_OUTPUT, r105);
        r101.putExtra("android.intent.extra.videoQuality", 1);
        CameraParam r106 = this.f1348c;
        if (r106 == null) goto L19;
        r101.putExtra("android.intent.extra.durationLimit", r106.getMaxDuration() / 1000);
        goto L19
    L7:
        if (r103.mkdir() == true) goto L11;
        Log.e("SCREEN_TAG", "Throwing Errors....");
        throw new IOException();
    L19:
        return r101;
    }

    public g(SystemCameraActivity r100, CameraParam r101) {
        this.f1347b = r100;
        this.f1348c = r101;
    }
}
