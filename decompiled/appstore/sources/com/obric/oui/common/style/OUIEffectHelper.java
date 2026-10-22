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
import com.obric.common.oui.R$attr;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class OUIEffectHelper {
    public static boolean A = false;
    public static int B = 0;
    public static boolean C = false;
    public static int D = 0;
    public static HashMap E = null;
    public static boolean F = false;
    public static TypedValue G = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f12987f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f12988g = 177;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f12989h = 33;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f12990i = 5;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f12991j = 127;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f12992k = 204;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f12993l = 15;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f12994m = 355;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f12995n = 38;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f12996o = 6;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f12997p = 255;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f12998q = 102;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f12999r = 18;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static int f13000s = 88;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int f13001t = 76;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static int f13002u = 5;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f13003v = 63;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f13004w = 204;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static int f13005x = 8;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static String f13006y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f13007z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f13008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13012e;

    static {
        String r10 = g("ro.pvr.product.name", "Phoenix");
        f13006y = r10;
        f13007z = "Phoenix".equals(r10);
        A = "Phoenix".equals(f13006y);
        B = 0;
        C = true;
        D = -1;
        E = new HashMap();
        F = false;
    }

    public OUIEffectHelper(View r10) {
        this.f13009b = true;
        this.f13010c = true;
        this.f13011d = true;
        this.f13008a = new WeakReference(r10);
        this.f13012e = c(r10.getContext(), R$attr.oui_effect_enabled);
    }

    public static /* synthetic */ void a(OUIEffectHelper r10) {
        r10.j();
    }

    public static boolean c(Context r10, int r11) {
        if (G != null) goto L5;
        G = new TypedValue();
    L5:
        r10.getTheme().resolveAttribute(r11, G, true);
        if (G.data != 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean d(JSONObject r10, String r11) {
        return r10.getBoolean(r11);
    L4:
        return false;
    }

    public static int e(JSONObject r10, String r11) {
        return r10.getInt(r11);
    L4:
        return -1;
    }

    public static String f(JSONObject r10, String r11) {
        return r10.getString(r11);
    L4:
        return "";
    }

    public static String g(String r10, String r11) {
        String r12 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r10, r11});     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r12) == false) goto L7;
        return r11;
    L7:
        return r12;
    L12:
        return r11;
    }

    public static void h(Context r10, int r11, int[] r12) {
        int r13 = B;
        if (r13 != 2) goto L8;
        if (r11 != 0) goto L6;
        r12[0] = f13001t;
        r12[1] = f13000s;
        r12[2] = f13002u;
        return;
    L6:
        if (r11 != 1) goto L19;
        r12[0] = f13004w;
        r12[1] = f13003v;
        r12[2] = f13005x;
        return;
    L19:
        return;
    L8:
        if (r13 != 1) goto L13;
        if (r11 != 0) goto L11;
        r12[0] = f12995n;
        r12[1] = f12994m;
        r12[2] = f12996o;
        return;
    L11:
        if (r11 != 1) goto L22;
        r12[0] = f12998q;
        r12[1] = f12997p;
        r12[2] = f12999r;
        return;
    L22:
        return;
    L13:
        if (r11 != 0) goto L15;
        r12[0] = f12989h;
        r12[1] = f12988g;
        r12[2] = f12990i;
        return;
    L15:
        if (r11 != 1) goto L25;
        r12[0] = f12992k;
        r12[1] = f12991j;
        r12[2] = f12993l;
        return;
    }

    public static boolean i(String r10) {
        String[] r11 = r10.split(",");
        if (r11.length <= 0) goto L11;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L11;
        if (f13006y.equals(r11[r13]) == true) goto L8;
        r13 = r13 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    public static void n(Context r10, int r11, int r12) {
        if (f13007z == true) goto L5;
        return;
    L5:
        if (r12 >= 100000) goto L8;
        return;
    L8:
        if (F == false) goto L11;
        Log.i("OUIEffectHelper", "onVibrate: effectType=" + r11 + ", deviceId=" + r12);
    L11:
        if (r12 != 100001) goto L14;
    L15:
        h(r10, r11, new int[3]);
        return;
    L14:
        if (r12 == 100002) goto L15;
    }

    public static void r(Context r10, int r11, int r12) {
        if (A == true) goto L5;
        return;
    L5:
        if (r12 < 100000) goto L26;
        Pair r13 = (Pair) E.get(Integer.valueOf(r12));
        AudioManager r14 = (AudioManager) r10.getSystemService("audio");
        if (r13 != null) goto L14;
        if (F == false) goto L24;
        Log.i("OUIEffectHelper", "playSoundEffect: pair is empty");
        return;
    L24:
        return;
    L14:
        if (F == false) goto L16;
        Log.i("OUIEffectHelper", "playSoundEffect: effectType=" + r11 + ", deviceId=" + r12);
    L16:
        if (r11 != 0) goto L19;
        int r15 = ((Integer) r13.first).intValue();
    L22:
        r14.playSoundEffect(r15, 1.0f);
        return;
    L19:
        if (r11 != 1) goto L21;
        r15 = ((Integer) r13.second).intValue();
        goto L22
    L21:
        r15 = 10;
        goto L22
    }

    private void updateDeviceId(MotionEvent r10) {
        if (this.f13012e == true) goto L5;
        return;
    L5:
        D = r10.getDeviceId();
    }

    public static void v(Context r12) {
        E.clear();
        B = Settings.Global.getInt(r12.getContentResolver(), "controller_vibration_level", 0);
        if (Settings.Global.getInt(r12.getContentResolver(), "system_vibration_enabled", 1) != 1) goto L5;
        boolean r10 = true;
    L6:
        C = r10;
        String r13 = Settings.Global.getString(r12.getContentResolver(), "pvr_ui_config");
        if (TextUtils.isEmpty(r13) == true) goto L49;
        JSONObject r11 = new JSONObject(r13);     // Catch: JSONException -> L18
        JSONObject r14 = r11.getJSONObject("vibration");     // Catch: JSONException -> L13
        f12988g = e(r14, "def_hover_fre");     // Catch: JSONException -> L13
        f12989h = e(r14, "def_hover_level");     // Catch: JSONException -> L13
        f12990i = e(r14, "def_hover_dur");     // Catch: JSONException -> L13
        f12991j = e(r14, "def_press_fre");     // Catch: JSONException -> L13
        f12992k = e(r14, "def_press_level");     // Catch: JSONException -> L13
        f12993l = e(r14, "def_press_dur");     // Catch: JSONException -> L13
        f12994m = e(r14, "weak_hover_fre");     // Catch: JSONException -> L13
        f12995n = e(r14, "weak_hover_level");     // Catch: JSONException -> L13
        f12996o = e(r14, "weak_hover_dur");     // Catch: JSONException -> L13
        f12997p = e(r14, "weak_press_fre");     // Catch: JSONException -> L13
        f12998q = e(r14, "weak_press_level");     // Catch: JSONException -> L13
        f12999r = e(r14, "weak_press_dur");     // Catch: JSONException -> L13
        f13000s = e(r14, "strong_hover_fre");     // Catch: JSONException -> L13
        f13001t = e(r14, "strong_hover_level");     // Catch: JSONException -> L13
        f13002u = e(r14, "strong_hover_dur");     // Catch: JSONException -> L13
        f13003v = e(r14, "strong_press_fre");     // Catch: JSONException -> L13
        f13004w = e(r14, "strong_press_level");     // Catch: JSONException -> L13
        f13005x = e(r14, "strong_press_dur");     // Catch: JSONException -> L13
        String r15 = f(r14, "device_allowed");     // Catch: JSONException -> L13
        F = d(r14, "debug");     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r15) == true) goto L57;
        f13007z = i(r15);     // Catch: JSONException -> L13
    L57:
        JSONObject r16 = r11.getJSONObject("sound");     // Catch: JSONException -> L23
        String r17 = f(r16, "device_allowed");     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(r17) == true) goto L25;
        A = i(r17);     // Catch: JSONException -> L23
    L25:
        String r18 = f(r16, "device_id_effect_type");     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(r18) == true) goto L49;
        String[] r19 = r18.split(";");     // Catch: JSONException -> L23
        if (r19.length <= 0) goto L49;
        int r20 = r19.length;     // Catch: JSONException -> L23
        int r21 = 0;
    L30:
        if (r21 >= r20) goto L49;
        String[] r22 = r19[r21].split(",");     // Catch: JSONException -> L23
    L33:
        if (r22.length != 3) goto L40;
        E.put(Integer.valueOf(Integer.parseInt(r22[0])), new Pair(Integer.valueOf(Integer.parseInt(r22[1])), Integer.valueOf(Integer.parseInt(r22[2]))));     // Catch: Exception -> L36
    L36:
        e = move-exception;
        if (F == false) goto L40;
        Log.e("OUIEffectHelper", "onWindowShow: parse vibration device_id_effect_type error=" + e);     // Catch: JSONException -> L23
    L40:
        r21 = r21 + 1;
    L23:
        e = move-exception;
        if (F == false) goto L49;
        Log.e("OUIEffectHelper", "onWindowShow: parse sound error=" + e);     // Catch: JSONException -> L18
    L13:
        e = move-exception;
        if (F == false) goto L57;
        Log.e("OUIEffectHelper", "onWindowShow: parse vibration error=" + e);     // Catch: JSONException -> L18
    L18:
        e = move-exception;
        if (F == false) goto L49;
        Log.e("OUIEffectHelper", "onWindowShow: parse uiConfig error=" + e);
    L49:
        if (F == false) goto L64;
        Log.i("OUIEffectHelper", "updateConfig: " + r13 + ", sIsDeviceVibrateAllowed=" + f13007z + ", sIsDeviceSoundAllowed=" + A + ", sDeviceType=" + f13006y);
        return;
    L64:
        return;
    L5:
        r10 = false;
        goto L6
    }

    public final void b(boolean r10) {
        if (this.f13008a.get() == null) goto L13;
        int r11 = !r10 ? 1 : 0;
        if (C == false) goto L10;
        if (this.f13010c == false) goto L10;
        n(((View) this.f13008a.get()).getContext(), r11, D);
    L10:
        if (this.f13011d == false) goto L14;
        r(((View) this.f13008a.get()).getContext(), r11, D);
        return;
    L14:
        return;
    }

    public void dispatchGenericMotionEvent(MotionEvent r10) {
        updateDeviceId(r10);
    }

    public void dispatchTouchEvent(MotionEvent r10) {
        updateDeviceId(r10);
    }

    public final /* synthetic */ void j() {
        this.f13009b = true;
    }

    public void k() {
    }

    public void l() {
    }

    public void m(boolean r10) {
        if (this.f13012e == true) goto L5;
        return;
    L5:
        if (r10 == true) goto L7;
        return;
    L7:
        if (this.f13009b == false) goto L11;
        b(true);
        return;
    }

    public void o() {
        if (this.f13012e == true) goto L6;
        return;
    L6:
        if (F == false) goto L8;
        Log.i("OUIEffectHelper", "onWindowHide: ");
    L8:
        f12987f = false;
    }

    public void p() {
        if (this.f13012e == true) goto L5;
        return;
    L5:
        View r10 = (View) this.f13008a.get();
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.getContext() != null) goto L10;
        return;
    L10:
        if (f12987f == true) goto L19;
        f12987f = true;
        v(r10.getContext());
        if (F == false) goto L18;
        Log.i("OUIEffectHelper", "onWindowShow: mAppEffectEnabled=" + this.f13012e);
        return;
    L18:
        return;
    }

    public void q(int r10) {
        if (r10 != 0) goto L4;
        p();
        return;
    L4:
        o();
    }

    public void s(boolean r10) {
        if (this.f13012e == true) goto L5;
        return;
    L5:
        View r11 = (View) this.f13008a.get();
        if (r11 != null) goto L9;
        return;
    L9:
        if ((r11.isPressed() ^ r10) == false) goto L14;
        if (r10 == false) goto L12;
        b(false);
        this.f13009b = false;
        return;
    L12:
        r11.postDelayed(new h(this), 20);
        return;
    }

    public void t(boolean r10) {
        this.f13011d = r10;
    }

    public void u(boolean r10) {
        this.f13010c = r10;
    }
}
