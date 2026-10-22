package com.obric.oui.common.style;

import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: OUIEffectHelper.java */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class e {
    private static boolean A = false;
    private static int D = 0;
    private static HashMap<Integer, Pair<Integer, Integer>> E = null;
    private static TypedValue F = null;
    private static final String TAG = "OUIEffectHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f34517a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f34518b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f34519c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f34520d = 177;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f34521e = 33;
    private static int f = 5;
    private static int g = 127;
    private static int h = 204;
    private static int i = 15;
    private static int j = 355;
    private static int k = 38;
    private static int l = 6;
    private static int m = 255;
    private static int n = 102;
    private static int o = 18;
    private static int p = 88;
    private static int q = 76;
    private static int r = 5;
    private static int s = 63;
    private static int t = 204;
    private static int u = 8;
    private static boolean v;
    private static boolean w;
    private static int z;
    private boolean B;
    private boolean C;
    private boolean G;
    private final WeakReference<View> x;
    private boolean y;

    public static /* synthetic */ void lambda$An1u45Ti0jZ3DEFpGgR0hbq7u4o(e r0) {
        r0.e();
    }

    public void c() {
    }

    public void d() {
    }

    static {
        String r0 = c("ro.pvr.product.name", "Phoenix");
        f34517a = r0;
        v = "Phoenix".equals(r0);
        w = "Phoenix".equals(f34517a);
        z = 0;
        A = true;
        D = -1;
        E = new HashMap();
        f34518b = false;
    }

    public e(View r4) {
        this.y = true;
        this.B = true;
        this.C = true;
        this.x = new WeakReference(r4);
        this.G = a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.oui_effect_enabled, "attr", "oui_effect_enabled"));
    }

    public static void a(Context r2, int r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (v == true) goto L5;
        return;
    L5:
        if (r4 >= 100000) goto L8;
        return;
    L8:
        if (f34518b == false) goto L11;
        a(TAG, "onVibrate: effectType=" + r3 + ", deviceId=" + r4);
    L11:
        if (r4 != 100001) goto L14;
    L15:
        a(r5, r3, new int[3]);
        return;
    L14:
        if (r4 == 100002) goto L15;
    }

    public static void b(Context r5, int r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (w == true) goto L5;
        return;
    L5:
        if (r7 < 100000) goto L26;
        Pair r0 = (Pair) ZeusTransformUtils.preCheckCast(E.get(Integer.valueOf(r7)), Pair.class, "com.obric.aiagent.plugin");
        AudioManager r9 = (AudioManager) ZeusTransformUtils.preCheckCast(r8.getSystemService("audio"), AudioManager.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L14;
        if (f34518b == false) goto L24;
        a(TAG, "playSoundEffect: pair is empty");
        return;
    L24:
        return;
    L14:
        if (f34518b == false) goto L16;
        a(TAG, "playSoundEffect: effectType=" + r6 + ", deviceId=" + r7);
    L16:
        int r10 = 10;
        if (r6 != 0) goto L20;
        r10 = ((Integer) ZeusTransformUtils.preCheckCast(r0.first, Integer.class, "com.obric.aiagent.plugin")).intValue();
    L22:
        r9.playSoundEffect(r10, 1.0f);
        return;
    L20:
        if (r6 != 1) goto L22;
        r10 = ((Integer) ZeusTransformUtils.preCheckCast(r0.second, Integer.class, "com.obric.aiagent.plugin")).intValue();
        goto L22
    }

    private void e(boolean r4) {
        if (this.x.get() == null) goto L13;
        int r5 = !r4 ? 1 : 0;
        if (A == false) goto L10;
        if (this.B == false) goto L10;
        a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((View) ZeusTransformUtils.preCheckCast(this.x.get(), View.class, "com.obric.aiagent.plugin")).getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5, D);
    L10:
        if (this.C == false) goto L14;
        b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((View) ZeusTransformUtils.preCheckCast(this.x.get(), View.class, "com.obric.aiagent.plugin")).getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5, D);
        return;
    L14:
        return;
    }

    private static void a(Context r3, int r4, int[] r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        int r7 = z;
        if (r7 != 2) goto L8;
        if (r4 != 0) goto L6;
        r5[0] = q;
        r5[1] = p;
        r5[2] = r;
        return;
    L6:
        if (r4 != 1) goto L19;
        r5[0] = t;
        r5[1] = s;
        r5[2] = u;
        return;
    L19:
        return;
    L8:
        if (r7 != 1) goto L13;
        if (r4 != 0) goto L11;
        r5[0] = k;
        r5[1] = j;
        r5[2] = l;
        return;
    L11:
        if (r4 != 1) goto L22;
        r5[0] = n;
        r5[1] = m;
        r5[2] = o;
        return;
    L22:
        return;
    L13:
        if (r4 != 0) goto L15;
        r5[0] = f34521e;
        r5[1] = f34520d;
        r5[2] = f;
        return;
    L15:
        if (r4 != 1) goto L25;
        r5[0] = h;
        r5[1] = g;
        r5[2] = i;
        return;
    }

    public void a(boolean r2) {
        if (this.G == true) goto L5;
        return;
    L5:
        if (r2 == true) goto L7;
        return;
    L7:
        if (this.y == false) goto L11;
        e(true);
        return;
    }

    public void b(boolean r4) {
        if (this.G == true) goto L5;
        return;
    L5:
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.x.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L9;
        return;
    L9:
        if ((r0.isPressed() ^ r4) == false) goto L14;
        if (r4 == false) goto L12;
        e(false);
        this.y = false;
        return;
    L12:
        r0.postDelayed(new $$Lambda$e$An1u45Ti0jZ3DEFpGgR0hbq7u4o(this), 20);
        return;
    }

    private /* synthetic */ void e() {
        this.y = true;
    }

    public void c(boolean r1) {
        this.B = r1;
    }

    public void d(boolean r1) {
        this.C = r1;
    }

    public void a(MotionEvent r1) {
        c(r1);
    }

    public void b(MotionEvent r1) {
        c(r1);
    }

    private void c(MotionEvent r1) {
        if (this.G == true) goto L5;
        return;
    L5:
        D = r1.getDeviceId();
    }

    public void a() {
        if (this.G == true) goto L5;
        return;
    L5:
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.x.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
        return;
    L8:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) != null) goto L10;
        return;
    L10:
        if (f34519c == true) goto L19;
        f34519c = true;
        a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (f34518b == false) goto L18;
        a(TAG, "onWindowShow: mAppEffectEnabled=" + this.G);
        return;
    L18:
        return;
    }

    public static void a(Context r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        E.clear();
        z = Settings.Global.getInt(r13.getContentResolver(), "controller_vibration_level", 0);
        if (Settings.Global.getInt(r13.getContentResolver(), "system_vibration_enabled", 1) != 1) goto L5;
        boolean r1 = true;
    L6:
        A = r1;
        String r14 = Settings.Global.getString(r13.getContentResolver(), "pvr_ui_config");
        if (TextUtils.isEmpty(r14) == true) goto L46;
        JSONObject r2 = new JSONObject(r14);     // Catch: JSONException -> L41
        JSONObject r5 = r2.getJSONObject("vibration");     // Catch: JSONException -> L13
        f34520d = a(r5, "def_hover_fre");     // Catch: JSONException -> L13
        f34521e = a(r5, "def_hover_level");     // Catch: JSONException -> L13
        f = a(r5, "def_hover_dur");     // Catch: JSONException -> L13
        g = a(r5, "def_press_fre");     // Catch: JSONException -> L13
        h = a(r5, "def_press_level");     // Catch: JSONException -> L13
        i = a(r5, "def_press_dur");     // Catch: JSONException -> L13
        j = a(r5, "weak_hover_fre");     // Catch: JSONException -> L13
        k = a(r5, "weak_hover_level");     // Catch: JSONException -> L13
        l = a(r5, "weak_hover_dur");     // Catch: JSONException -> L13
        m = a(r5, "weak_press_fre");     // Catch: JSONException -> L13
        n = a(r5, "weak_press_level");     // Catch: JSONException -> L13
        o = a(r5, "weak_press_dur");     // Catch: JSONException -> L13
        p = a(r5, "strong_hover_fre");     // Catch: JSONException -> L13
        q = a(r5, "strong_hover_level");     // Catch: JSONException -> L13
        r = a(r5, "strong_hover_dur");     // Catch: JSONException -> L13
        s = a(r5, "strong_press_fre");     // Catch: JSONException -> L13
        t = a(r5, "strong_press_level");     // Catch: JSONException -> L13
        u = a(r5, "strong_press_dur");     // Catch: JSONException -> L13
        String r6 = c(r5, "device_allowed");     // Catch: JSONException -> L13
        f34518b = b(r5, "debug");     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r6) == true) goto L49;
        v = a(r6);     // Catch: JSONException -> L13
    L49:
        JSONObject r3 = r2.getJSONObject("sound");     // Catch: JSONException -> L36
        String r0 = c(r3, "device_allowed");     // Catch: JSONException -> L36
        if (TextUtils.isEmpty(r0) == true) goto L20;
        w = a(r0);     // Catch: JSONException -> L36
    L20:
        String r4 = c(r3, "device_id_effect_type");     // Catch: JSONException -> L36
        if (TextUtils.isEmpty(r4) == true) goto L46;
        String[] r7 = r4.split(";");     // Catch: JSONException -> L36
        if (r7.length <= 0) goto L46;
        int r8 = r7.length;     // Catch: JSONException -> L36
        int r9 = 0;
    L25:
        if (r9 >= r8) goto L46;
        String[] r10 = r7[r9].split(",");     // Catch: JSONException -> L36
    L28:
        if (r10.length != 3) goto L35;
        E.put(Integer.valueOf(Integer.parseInt(r10[0])), new Pair(Integer.valueOf(Integer.parseInt(r10[1])), Integer.valueOf(Integer.parseInt(r10[2]))));     // Catch: Exception -> L31 JSONException -> L36
    L31:
        e = move-exception;
        if (f34518b == false) goto L35;
        b(TAG, "onWindowShow: parse vibration device_id_effect_type error=" + e);     // Catch: JSONException -> L36
    L35:
        r9 = r9 + 1;
    L36:
        e = move-exception;
        if (f34518b == false) goto L46;
        b(TAG, "onWindowShow: parse sound error=" + e);     // Catch: JSONException -> L41
    L13:
        e = move-exception;
        if (f34518b == false) goto L49;
        b(TAG, "onWindowShow: parse vibration error=" + e);     // Catch: JSONException -> L41
    L41:
        e = move-exception;
        if (f34518b == false) goto L46;
        b(TAG, "onWindowShow: parse uiConfig error=" + e);
    L46:
        if (f34518b == false) goto L62;
        a(TAG, "updateConfig: " + r14 + ", sIsDeviceVibrateAllowed=" + v + ", sIsDeviceSoundAllowed=" + w + ", sDeviceType=" + f34517a);
        return;
    L62:
        return;
    L5:
        r1 = false;
        goto L6
    }

    private static int a(JSONObject r0, String r1) {
        return r0.getInt(r1);
    L4:
        return -1;
    }

    private static boolean b(JSONObject r0, String r1) {
        return r0.getBoolean(r1);
    L4:
        return false;
    }

    private static String c(JSONObject r0, String r1) {
        return r0.getString(r1);
    L4:
        return "";
    }

    private static boolean a(String r5) {
        String[] r6 = r5.split(",");
        if (r6.length <= 0) goto L11;
        int r0 = r6.length;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L11;
        if (f34517a.equals(r6[r2]) == true) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    public void b() {
        if (this.G == true) goto L6;
        return;
    L6:
        if (f34518b == false) goto L8;
        a(TAG, "onWindowHide: ");
    L8:
        f34519c = false;
    }

    public static String c(String r8, String r9) {
        String r10 = (String) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(null, new Object[]{r8, r9}), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return r9;
    L7:
        return r10;
    L12:
        return r9;
    }

    public void a(int r1) {
        if (r1 != 0) goto L4;
        a();
        return;
    L4:
        b();
    }

    private static boolean a(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (F != null) goto L5;
        F = new TypedValue();
    L5:
        r4.getTheme().resolveAttribute(r3, F, true);
        if (F.data != 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
