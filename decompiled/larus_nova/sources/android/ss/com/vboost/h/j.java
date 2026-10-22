package android.ss.com.vboost.h;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.ss.com.vboost.utils.LogUtil;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TimerTask;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4674a = "j";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Vibrator f4675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f4676c;

    public static class a extends TimerTask {
        public a() {
        }

        public void android_ss_com_vboost_h_j$a__run$___twin___() {
            j.a().cancel();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            android_ss_com_vboost_h_j$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void android_ss_com_vboost_h_j$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.android_ss_com_vboost_h_j$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class b extends TimerTask {
        public b() {
        }

        public void android_ss_com_vboost_h_j$b__run$___twin___() {
            j.a().cancel();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            android_ss_com_vboost_h_j$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void android_ss_com_vboost_h_j$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
            r100.android_ss_com_vboost_h_j$b__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class c extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f4677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f4678b;

        public c(float r100, float r101) {
            this.f4677a = r100;
            this.f4678b = r101;
        }

        public void android_ss_com_vboost_h_j$c__run$___twin___() {
            if (j.b() == true) goto L6;
            j.a(this.f4677a, this.f4678b);
            return;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            android_ss_com_vboost_h_j$c_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void android_ss_com_vboost_h_j$c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
            r100.android_ss_com_vboost_h_j$c__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class d extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f4679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f4680b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f4681c;

        public d(float r100, float r101, float r102) {
            this.f4679a = r100;
            this.f4680b = r101;
            this.f4681c = r102;
        }

        public void android_ss_com_vboost_h_j$d__run$___twin___() {
            if (j.b() == true) goto L6;
            j.a(this.f4679a, this.f4680b, this.f4681c);
            return;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            android_ss_com_vboost_h_j$d_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void android_ss_com_vboost_h_j$d_com_larus_apm_impl_protector_RunnableLancet_run(d r100) {
            r100.android_ss_com_vboost_h_j$d__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static /* synthetic */ Vibrator a() {
        return f4675b;
    }

    public static void a(float r100, float r101) {
        if (f4675b != null) goto L6;
        LogUtil.error(f4674a, "Vibrator is null !");
        return;
    L6:
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 26) goto L16;
        int r103 = (int) (255.0f * r100);
        long r104 = (long) (r100 * 300.0f);
        if (r103 >= 1) goto L12;
        return;
    L12:
        if (r103 <= 255) goto L14;
        r103 = 255;
    L14:
        f4675b.vibrate(VibrationEffect.createOneShot(r104, r103));
        return;
    L16:
        if (r102 < 24) goto L20;
        long r105 = (long) (r100 * 90.0f);
        f4675b.vibrate(new long[]{5, r105, 5, r105}, 2);
        new PthreadTimer("om/vboost/h/j").schedule(new a(), 300);
        return;
    }

    public static void a(float r100, float r101, float r102) {
        if (f4675b != null) goto L6;
        LogUtil.error(f4674a, "Vibrator is null  !");
        return;
    L6:
        int r103 = (int) r102;
        int r104 = Build.VERSION.SDK_INT;
        if (r104 < 26) goto L16;
        int r105 = (int) (r100 * 255.0f);
        if (r105 >= 1) goto L12;
        return;
    L12:
        if (r105 <= 255) goto L14;
        r105 = 255;
    L14:
        f4675b.vibrate(VibrationEffect.createOneShot(r103, r105));
        return;
    L16:
        if (r104 < 24) goto L20;
        long r106 = (long) (r100 * 90.0f);
        f4675b.vibrate(new long[]{5, r106, 5, r106}, 2);
        new PthreadTimer("om/vboost/h/j").schedule(new b(), r103);
        return;
    }

    public static void a(String r110) {
        String r100 = f4674a;
        LogUtil.debug(r100, "play a Json file Pattern");
        if (f4675b != null) goto L58;
        LogUtil.error(r100, "not register yet !");
        return;
    L58:
        String r111 = b(r110);     // Catch: JSONException -> L55
        if (r111 == null) goto L53;
        LogUtil.debug(r100, "start to parse json file");     // Catch: JSONException -> L55
        JSONArray r112 = JSONObjectProtectorUtils.getJSONArray(new JSONObject(r111), "Pattern");     // Catch: JSONException -> L55
        f4676c = false;     // Catch: JSONException -> L55
        int r101 = 0;
    L10:
        if (r101 >= r112.length()) goto L69;
        if (JSONArrayProtectorUtils.getJSONObject(r112, r101).optString("Event").equals("") == true) goto L52;
        long r102 = (long) (JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(JSONArrayProtectorUtils.getJSONObject(r112, r101), "Event"), "Time") * 1000.0d);     // Catch: JSONException -> L55
        JSONArray r103 = JSONObjectProtectorUtils.getJSONArray(JSONObjectProtectorUtils.getJSONObject(JSONArrayProtectorUtils.getJSONObject(r112, r101), "Event"), "EventParameters");     // Catch: JSONException -> L55
        float r104 = 0.0f;
        float r105 = 0.0f;
        int r106 = 0;
    L15:
        byte r113 = -1;
        if (r106 >= r103.length()) goto L35;
        String r107 = JSONObjectProtectorUtils.getString(JSONArrayProtectorUtils.getJSONObject(r103, r106), "ParameterID");     // Catch: JSONException -> L55
        int r114 = r107.hashCode();     // Catch: JSONException -> L55
        if (r114 == (-805677252)) goto L26;
        if (r114 == 1418859594) goto L23;
    L29:
        if (r113 == 0) goto L33;
        if (r113 != 1) goto L34;
        r104 = (float) JSONObjectProtectorUtils.getDouble(JSONArrayProtectorUtils.getJSONObject(r103, r106), "ParameterValue");     // Catch: JSONException -> L55
    L34:
        r106 = r106 + 1;     // Catch: JSONException -> L55
        goto L15
    L33:
        r105 = (float) JSONObjectProtectorUtils.getDouble(JSONArrayProtectorUtils.getJSONObject(r103, r106), "ParameterValue");     // Catch: JSONException -> L55
        goto L34
    L23:
        if (r107.equals("HapticSharpness") == false) goto L29;
        r113 = 0;
        goto L29
    L26:
        if (r107.equals("HapticIntensity") == false) goto L29;
        r113 = 1;
        goto L29
    L35:
        String r108 = JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(JSONArrayProtectorUtils.getJSONObject(r112, r101), "Event"), "EventType");     // Catch: JSONException -> L55
        int r109 = r108.hashCode();     // Catch: JSONException -> L55
        if (r109 == (-1421249242)) goto L44;
        if (r109 == (-252255853)) goto L41;
    L47:
        if (r113 == 0) goto L51;
        if (r113 != 1) goto L52;
        double r115 = JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(JSONArrayProtectorUtils.getJSONObject(r112, r101), "Event"), "EventDuration");     // Catch: JSONException -> L55
        new PthreadTimer("om/vboost/h/j").schedule(new d(r104, r105, ((float) r115) * 1000.0f), r102);     // Catch: JSONException -> L55
        goto L52
    L51:
        new PthreadTimer("om/vboost/h/j").schedule(new c(r104, r105), r102);     // Catch: JSONException -> L55
        goto L52
    L41:
        if (r108.equals("HapticTransient") == false) goto L47;
        r113 = 0;
        goto L47
    L44:
        if (r108.equals("HapticContinuous") == false) goto L47;
        r113 = 1;
    L52:
        r101 = r101 + 1;     // Catch: JSONException -> L55
        goto L10
    L69:
        return;
    L53:
        LogUtil.error(r100, "read json data null,please check permisson or file path!");     // Catch: JSONException -> L55
        return;
    L55:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean a(Context r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L7;
        String r101 = f4674a;
        String r102 = "device sdk is below BuildVersion, not support vibrator!";
    L5:
        LogUtil.error(r101, r102);
        return false;
    L7:
        Vibrator r103 = (Vibrator) r100.getSystemService("vibrator");
        f4675b = r103;
        if (r103 != null) goto L10;
        r101 = f4674a;
        r102 = "get VIBRATOR_SERVICE fail!";
        goto L5
    L10:
        boolean r104 = r103.hasVibrator();
        if (r104 == true) goto L13;
        LogUtil.error(f4674a, "detect not has vibrator !");
        f4675b = null;
    L13:
        return r104;
    }

    private static String b(String r100) {
        File r101 = new File(r100);     // Catch: IOException -> L8
        FileReader r102 = new FileReader(r101);     // Catch: IOException -> L8
        InputStreamReader r103 = new InputStreamReader(new FileInputStream(r101), XML.CHARSET_UTF8);     // Catch: IOException -> L8
        StringBuffer r104 = new StringBuffer();     // Catch: IOException -> L8
    L3:
        int r105 = r103.read();     // Catch: IOException -> L8
        if (r105 == (-1)) goto L6;
        r104.append((char) r105);     // Catch: IOException -> L8
        goto L3
    L6:
        r102.close();     // Catch: IOException -> L8
        r103.close();     // Catch: IOException -> L8
        return r104.toString();
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static /* synthetic */ boolean b() {
        return f4676c;
    }

    public static void c() {
        if (f4675b == null) goto L6;
        f4675b = null;
        return;
    }

    public static void d() {
        String r100 = f4674a;
        LogUtil.debug(r100, "stop Haptic immediately");
        Vibrator r101 = f4675b;
        if (r101 != null) goto L6;
        LogUtil.error(r100, "Vibrator is null !");
        return;
    L6:
        f4676c = true;
        r101.cancel();
    }
}
