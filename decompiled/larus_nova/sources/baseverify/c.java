package baseverify;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.dtf.face.config.DeviceSetting;
import com.dtf.face.log.RecordService;
import com.dtf.face.utils.ClientConfigUtil;
import com.obric.miniapp.alarm.AccountType;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f18479a;

    public class a implements Comparator<Camera.Size> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f18480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f18481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f18482c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f18483d;

        @Override // java.util.Comparator
        public int compare(Camera.Size r110, Camera.Size r111) {
            Camera.Size r112 = r110;
            Camera.Size r113 = r111;
            int r100 = r113.width;
            if (r100 == this.f18482c) goto L5;
        L7:
            int r101 = r112.width;
            int r102 = r112.height;
            if (r101 == r102) goto L10;
            int r103 = r113.height;
            if (r100 != r103) goto L16;
        L15:
            return -1;
        L16:
            float r104 = this.f18480a;
            if (r104 == 0.0f) goto L36;
            if (r104 != 0.0f) goto L20;
            float r105 = 0.0f;
        L22:
            if (r112.width <= r113.width) goto L24;
            int r114 = -1;
        L26:
            if (Math.abs(r105) < 0.01d) goto L49;
            if (r105 < 0.0f) goto L15;
            if (r105 <= 0.0f) goto L49;
            return 1;
        L49:
            return r114;
        L24:
            r114 = 1;
            goto L26
        L20:
            r105 = Math.abs((r101 / r102) - r104) - Math.abs((r113.width / r113.height) - this.f18480a);
            goto L22
        L36:
            if ((this.f18481b % 180.0f) == 0.0f) goto L40;
            Integer r106 = a(r102, r101, r103, r100);
            if (r106 != null) goto L50;
        L43:
            int r107 = r112.width;
            int r108 = r113.width;
            if (r107 == r108) goto L52;
            if (r107 <= r108) goto L15;
            return 1;
        L52:
            return r112.height - r113.height;
        L50:
            return r106.intValue();
        L40:
            Integer r109 = a(r101, r102, r100, r103);
            if (r109 == null) goto L43;
            return r109.intValue();
        L10:
            if (r100 == r113.height) goto L47;
            return 1;
        L47:
            return r101 - r100;
        L5:
            if (r113.height != this.f18483d) goto L7;
            return 1;
        }

        public a(c r100, float r101, int r102) {
            this.f18482c = 0;
            this.f18483d = 0;
            this.f18480a = r101;
            this.f18481b = r102;
        }

        public a(c r100, int r101, int r102, int r103) {
            this.f18480a = 0.0f;
            this.f18481b = r101;
            this.f18482c = r102;
            this.f18483d = r103;
        }

        public final Integer a(int r100, int r101, int r102, int r103) {
            if (r100 > r101) goto L4;
            return null;
        L4:
            if (r102 < r103) goto L6;
            float r104 = (r101 / r100) - (r103 / r102);
            if (r104 <= 0.0f) goto L12;
            return -1;
        L12:
            if (r104 < 0.0f) goto L14;
            return null;
        L14:
            return 1;
        L6:
            return 1;
        }
    }

    public static synchronized c a() {
        monitor-enter(c.class);
        c r100 = f18479a;     // Catch: Throwable -> L11
        if (r100 != null) goto L9;
        c r101 = new c();     // Catch: Throwable -> L11
        f18479a = r101;     // Catch: Throwable -> L11
        monitor-exit(c.class);
        return r101;
    L9:
        monitor-exit(c.class);
        return r100;
    L11:
        th = move-exception;
        throw th;
    }

    public c() {
    }

    public static int a(int r100) {
    L7:
        th = move-exception;
        RecordService.getInstance().recordException(th);
    L9:
        int r101 = -1;
    L10:
        if (r101 > 0) goto L22;
        Context r102 = hs7.a.h().getContext();     // Catch: Throwable -> L19
        if (r102 == null) goto L22;
        CameraManager r103 = (CameraManager) r102.getSystemService("camera");     // Catch: Throwable -> L19
        if (r103 == null) goto L22;
        String[] r104 = r103.getCameraIdList();     // Catch: Throwable -> L19
        if (r104 == null) goto L22;
        r101 = r104.length;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        RecordService.getInstance().recordException(th);
    L22:
        if (r101 != 0) goto L24;
        RecordService.getInstance().recordEvent(2, "noCamera", new String[0]);
    L24:
        StringBuilder r105 = new StringBuilder();
        int r106 = 0;
    L25:
        if (r106 >= r101) goto L32;
        Camera.CameraInfo r107 = new Camera.CameraInfo();     // Catch: Throwable -> L29
        Camera.getCameraInfo(r106, r107);     // Catch: Throwable -> L29
        r105.append(JSON.toJSON(r107));     // Catch: Throwable -> L29
        if (r107.facing != r100) goto L31;
    L33:
        if (r106 != (-1)) goto L35;
        RecordService.getInstance().recordEvent(4, "CameraInfos", new String[]{"CameraInfo", r105.toString(), "numberOfCameras", String.valueOf(r101)});
    L35:
        return r106;
    L31:
        r106 = r106 + 1;
    L29:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        goto L31
    L32:
        r106 = -1;
        goto L33
    L4:
        if (Integer.parseInt(Build.VERSION.SDK) <= 8) goto L9;
        r101 = Camera.getNumberOfCameras();     // Catch: Throwable -> L7
        goto L10
    }

    public Camera.Size a(List<Camera.Size> r100, float r101, int r102, int r103) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.size() == 0) goto L30;
        Collections.sort(r100, new a(this, r101, r103));
        Iterator<Camera.Size> r104 = r100.iterator();
        int r105 = 0;
        int r106 = 0;
    L8:
        if (r104.hasNext() == false) goto L16;
        Camera.Size r107 = r104.next();
        int r108 = r107.width;
        if (r108 >= r102) goto L16;
        if (r108 == r107.height) goto L14;
        r106 = r106 + 1;
        goto L8
    L14:
        r106 = -1;
    L16:
        if (r106 != (-1)) goto L20;
        return a(r100, r102, 0, r103);
    L20:
        if (r106 == r100.size()) goto L24;
        r105 = r106;
    L24:
        return (Camera.Size) ListProtector.get(r100, r105);
    L30:
        return null;
    }

    public Camera.Size a(List<Camera.Size> r110, int r111, int r112, int r210, DeviceSetting r211, int r212, Camera.CameraInfo r213) {
        Camera.Size r100 = null;
        if (r110 != null) goto L5;
    L70:
        RecordService r101 = RecordService.getInstance();
        String[] r102 = new String[2];
        r102[0] = "errMsg";
        if (r110 != null) goto L73;
        String r103 = "null";
    L74:
        r102[1] = "list is ".concat(r103);
        r101.recordEvent(2, "previewSize", r102);
        return null;
    L73:
        r103 = "empty";
        goto L74
    L5:
        if (r110.size() == 0) goto L70;
        String r113 = ClientConfigUtil.c("NEED_SPECIAL_PREVIEW");     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r113) == true) goto L17;
        JSONObject r114 = JSON.parseObject(r113);     // Catch: Throwable -> L15
        if (r114.containsKey(AccountType.ALL) == false) goto L13;
        JSONObject r104 = r114.getJSONObject(AccountType.ALL);     // Catch: Throwable -> L15
    L18:
        if (r104 == null) goto L33;
        int r115 = 640;
        int r116 = 480;
    L31:
        th = move-exception;
        RecordService.getInstance().recordException(th);
    L34:
        Collections.sort(r110, new a(this, r210, r115, r116));
        Iterator<Camera.Size> r105 = r110.iterator();
    L36:
        if (r105.hasNext() == false) goto L76;
        Camera.Size r117 = r105.next();
        int r118 = r117.width;
        if (r118 < r111) goto L44;
        if (r117.height < r112) goto L44;
        r100 = r117;
    L44:
        if (r117.height == r118) goto L76;
        r100 = r117;
    L76:
        StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L67
        Iterator<Camera.Size> r107 = r110.iterator();     // Catch: Throwable -> L67
    L50:
        if (r107.hasNext() == false) goto L52;
        Camera.Size r119 = r107.next();     // Catch: Throwable -> L67
        r106.append(r119.width);     // Catch: Throwable -> L67
        r106.append(",");     // Catch: Throwable -> L67
        r106.append(r119.height);     // Catch: Throwable -> L67
        r106.append(com.alipay.sdk.m.u.i.f25853b);     // Catch: Throwable -> L67
        goto L50
    L52:
        r106.append("suitableSize:");     // Catch: Throwable -> L67
        r106.append(r100.width);     // Catch: Throwable -> L67
        r106.append(",");     // Catch: Throwable -> L67
        r106.append(r100.height);     // Catch: Throwable -> L67
        r106.append(".");     // Catch: Throwable -> L67
        RecordService r108 = RecordService.getInstance();     // Catch: Throwable -> L67
        String[] r120 = new String[12];     // Catch: Throwable -> L67
        r120[0] = "sizeList";     // Catch: Throwable -> L67
        r120[1] = r106.toString();     // Catch: Throwable -> L67
        r120[2] = "angle";     // Catch: Throwable -> L67
        r120[3] = String.valueOf(r210);     // Catch: Throwable -> L67
        r120[4] = "displayAngle";     // Catch: Throwable -> L67
        String r109 = "deviceSetting is NULL";
        if (r211 != null) goto L56;
        String r121 = "deviceSetting is NULL";
    L57:
        r120[5] = r121;     // Catch: Throwable -> L67
        r120[6] = "displayAuto";     // Catch: Throwable -> L67
        if (r211 == null) goto L61;
        r109 = String.valueOf(r211.isDisplayAuto());     // Catch: Throwable -> L67
    L61:
        r120[7] = r109;     // Catch: Throwable -> L67
        r120[8] = "rotation";     // Catch: Throwable -> L67
        r120[9] = String.valueOf(r212);     // Catch: Throwable -> L67
        r120[10] = "orientation";     // Catch: Throwable -> L67
        if (r213 != null) goto L64;
        String r122 = "cameraInfo is NULL";
    L65:
        r120[11] = r122;     // Catch: Throwable -> L67
        r108.recordEvent(2, "previewSize", r120);     // Catch: Throwable -> L67
    L69:
        return r100;
    L64:
        r122 = String.valueOf(r213.orientation);     // Catch: Throwable -> L67
        goto L65
    L56:
        r121 = String.valueOf(r211.getDisplayAngle());     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        goto L69
    L22:
        if (r104.containsKey("w") == false) goto L25;
        r115 = r104.getInteger("w").intValue();     // Catch: Throwable -> L31
    L25:
        if (r104.containsKey("h") == false) goto L29;
        r116 = r104.getInteger("h").intValue();     // Catch: Throwable -> L31
    L29:
        RecordService.getInstance().recordEvent(2, "aimSize", new String[]{"aimW", String.valueOf(r115), "aimH", String.valueOf(r116)});     // Catch: Throwable -> L31
        goto L34
    L33:
        r115 = 0;
        r116 = 0;
        goto L34
    L13:
        r104 = r114.getJSONObject(Build.MODEL);     // Catch: Throwable -> L15
        goto L18
    L82:
        r104 = null;
    L15:
        th = move-exception;
        RecordService.getInstance().recordException(th);
    L17:
        r104 = null;
        goto L18
    }
}
