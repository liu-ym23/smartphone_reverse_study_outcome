package com.bytedance.agentrobots.policy;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import d2.c;
import d2.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class RobotPolicyManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile RobotPolicyManager f33947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Uri f33948d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f33949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f33950b;

    public static final enum DisableLevel extends Enum<DisableLevel> {
        public static final DisableLevel Activity = null;
        public static final DisableLevel App = null;
        public static final DisableLevel None = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DisableLevel[] f33951a = null;
        private final int value;

        static {
            DisableLevel r100 = new DisableLevel("None", 0, 0);
            None = r100;
            DisableLevel r101 = new DisableLevel("App", 1, 1);
            App = r101;
            DisableLevel r102 = new DisableLevel("Activity", 2, 2);
            Activity = r102;
            f33951a = new DisableLevel[]{r100, r101, r102};
        }

        public static DisableLevel[] values() {
            return (DisableLevel[]) f33951a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static DisableLevel valueOf(String r100) {
            return (DisableLevel) r27.a.a(DisableLevel.class, r100);
        }

        public DisableLevel(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public class a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RobotPolicyManager f33952a;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100) {
            RobotPolicyManager.a(this.f33952a);
        }

        public a(RobotPolicyManager r100, Handler r101) {
            this.f33952a = r100;
            super(r101);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100, Uri r101) {
            Cursor r102 = null;
            if (r101 == null) goto L5;
            String r103 = UriProtector.getQueryParameter(r101, "package_name");
        L6:
            Objects.toString(r101);
            if (TextUtils.isEmpty(r103) == true) goto L32;
            RobotPolicyManager r104 = this.f33952a;
            r102 = RobotPolicyManager.b(r104.f33949a.getContentResolver(), RobotPolicyManager.f33948d, null, "package_name=?", new String[]{r103});     // Catch: Throwable -> L24 Exception -> L26
            if (r102 != null) goto L12;
        L18:
            d r105 = r104.f33950b;     // Catch: Throwable -> L24 Exception -> L26
            if (r103 != null) goto L21;
            r105.getClass();     // Catch: Throwable -> L24 Exception -> L26
        L22:
            if (r102 == null) goto L35;
        L28:
            r102.close();
            return;
        L35:
            return;
        L21:
            r105.f466498a.remove(r103);     // Catch: Throwable -> L24 Exception -> L26
            r105.f466499b.remove(r103);     // Catch: Throwable -> L24 Exception -> L26
            r105.f466500c.delete(r103);     // Catch: Throwable -> L24 Exception -> L26
            goto L22
        L12:
            if (r102.moveToFirst() == false) goto L18;
            int r106 = r102.getColumnIndex("policy");     // Catch: Throwable -> L24 Exception -> L26
            if (r106 == (-1)) goto L22;
            String r107 = r102.getString(r106);     // Catch: Throwable -> L24 Exception -> L26
            if (TextUtils.isEmpty(r107) == true) goto L22;
            r104.f33950b.a(r103, new JSONObject(r107));     // Catch: Throwable -> L24 Exception -> L26
        L24:
            th = move-exception;
            if (0 == 0) goto L31;
            r102.close();
        L31:
            throw th;
        L27:
            if (0 != 0) goto L28;
            return;
        L32:
            RobotPolicyManager.a(this.f33952a);
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f33953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f33954b;

        public b(List<String> r100, List<String> r101) {
            this.f33953a = r100;
            this.f33954b = r101;
        }
    }

    static {
        f33948d = UriProtector.parse("content://com.obric.agentrobots.provider/policy");
    }

    public final Map<String, List<String>> d() {
        Context r100 = this.f33949a;     // Catch: Exception -> L58
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L59;
        TreeSet r102 = new TreeSet();     // Catch: Exception -> L58
        TreeSet r103 = new TreeSet();     // Catch: Exception -> L58
        c r104 = new c(Build.BRAND, Build.MANUFACTURER);     // Catch: Exception -> L58
        Cursor r105 = b(this.f33949a.getContentResolver(), f33948d, new String[]{"package_name", "policy"}, null, null);     // Catch: Exception -> L58
        if (r105 != null) goto L67;
        if (r105 == null) goto L59;
    L50:
        r105.close();     // Catch: Exception -> L58
        goto L59
    L67:
        int r106 = r105.getColumnIndex("package_name");     // Catch: Throwable -> L52
        int r107 = r105.getColumnIndex("policy");     // Catch: Throwable -> L52
        if (r106 < 0) goto L50;
        if (r107 < 0) goto L50;
    L21:
        if (r105.moveToNext() == false) goto L49;
        String r108 = r105.getString(r106);     // Catch: Throwable -> L52
        String r110 = r105.getString(r107);     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r108) == true) goto L50;
        if (TextUtils.isEmpty(r110) == true) goto L50;
        d2.a r111 = e(new JSONObject(r110), r104);     // Catch: Throwable -> L52
        if (r111.f466495b == true) goto L41;
        JSONObject r112 = r111.f466494a;     // Catch: Throwable -> L52
        if (r112 == null) goto L34;
        JSONObject r113 = r112.optJSONObject("app");     // Catch: Throwable -> L52
    L35:
        if (r113 == null) goto L41;
        if (r113.optBoolean("global_disable", false) == false) goto L39;
    L40:
        boolean r114 = true;
    L42:
        if (r114 == true) goto L43;
        if (r102.contains(r108) == true) goto L21;
        r103.add(r108);     // Catch: Throwable -> L52
        goto L21
    L43:
        r102.add(r108);     // Catch: Throwable -> L52
        r103.remove(r108);     // Catch: Throwable -> L52
        goto L21
    L39:
        if (r113.optBoolean("screenshot_disable", false) == false) goto L41;
    L34:
        r113 = null;
    L41:
        r114 = false;
        goto L42
    L47:
        goto L59
    L49:
        r105.close();     // Catch: Exception -> L58
        b r109 = new b(Collections.unmodifiableList(new ArrayList(r102)), Collections.unmodifiableList(new ArrayList(r103)));     // Catch: Exception -> L58
    L60:
        if (r109 != null) goto L62;
        return null;
    L62:
        LinkedHashMap r115 = new LinkedHashMap(2);
        r115.put("restricted_packages", r109.f33953a);
        r115.put("saep_declared_packages", r109.f33954b);
        return Collections.unmodifiableMap(r115);
    L52:
        th = move-exception;
        r105.close();     // Catch: Throwable -> L55
    L57:
        throw th;     // Catch: Exception -> L58
    L55:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L58
        goto L57
    L7:
        if (Settings.Secure.getInt(r100.getContentResolver(), "robots_protocol_enabled", 1) != 1) goto L9;
        r101 = true;
    L59:
        r109 = null;
        goto L60
    }

    public RobotPolicyManager(Context r100) {
        Context r101 = r100.getApplicationContext();
        this.f33949a = r101;
        int r102 = com.bytedance.agentrobots.audit.a.f33911a;
        if (r101 == null) goto L5;
        r101.getApplicationContext();
    L5:
        this.f33950b = new d(r101);
        new a(this, new Handler(Looper.getMainLooper()));
    }

    public static void a(RobotPolicyManager r100) {
        ContentResolver r101 = r100.f33949a.getContentResolver();
        Cursor r102 = null;
        Uri r103 = f33948d;     // Catch: Throwable -> L22 Exception -> L26
        Objects.toString(r103);     // Catch: Throwable -> L22 Exception -> L26
        r102 = b(r101, r103, null, null, null);     // Catch: Throwable -> L22 Exception -> L26
        Objects.toString(r102);     // Catch: Throwable -> L22 Exception -> L26
        if (r102 == null) goto L6;
        r102.getCount();     // Catch: Throwable -> L22 Exception -> L26
    L6:
        if (r102 != null) goto L8;
    L20:
        if (r102 == null) goto L44;
    L27:
        r102.close();
        return;
    L44:
        return;
    L8:
        if (r102.moveToNext() == false) goto L19;
        int r104 = r102.getColumnIndex("package_name");     // Catch: Throwable -> L22 Exception -> L26
        int r105 = r102.getColumnIndex("policy");     // Catch: Throwable -> L22 Exception -> L26
        if (r104 == (-1)) goto L8;
        if (r105 == (-1)) goto L8;
        String r106 = r102.getString(r104);     // Catch: Throwable -> L22 Exception -> L26
        String r107 = r102.getString(r105);     // Catch: Throwable -> L22 Exception -> L26
        if (TextUtils.isEmpty(r106) == true) goto L8;
        if (TextUtils.isEmpty(r107) == true) goto L8;
        JSONObject r108 = new JSONObject(r107);     // Catch: JSONException -> L18 Throwable -> L22 Exception -> L26
        r100.f33950b.a(r106, r108);     // Catch: JSONException -> L18 Throwable -> L22 Exception -> L26
        goto L8
    L19:
    L26:
        if (r102 != null) goto L27;
        return;
    L22:
        th = move-exception;
        if (r102 == null) goto L25;
        r102.close();
    L25:
        throw th;
    }

    public static RobotPolicyManager c(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (f33947c != null) goto L18;
        monitor-enter(RobotPolicyManager.class);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (f33947c != null) goto L12;
        f33947c = new RobotPolicyManager(r100);     // Catch: Throwable -> L14
    L12:
        monitor-exit(RobotPolicyManager.class);     // Catch: Throwable -> L14
    L18:
        return f33947c;
    }

    public static d2.a e(JSONObject r100, c r110) {
        JSONArray r101 = r100.optJSONArray("oem_groups");
        if (r101 != null) goto L5;
    L30:
        JSONObject r102 = null;
    L31:
        boolean r111 = true;
        if (r102 != null) goto L34;
    L39:
        JSONObject r103 = r100.optJSONObject("scope");
        if (r103 != null) goto L42;
    L49:
        if (r111 == false) goto L52;
        r103 = r100.optJSONObject("default_policy");
    L52:
        return new d2.a(r103, false);
    L42:
        if (r103.optJSONObject("app") == null) goto L44;
    L48:
        r111 = false;
        goto L49
    L44:
        if (r103.optJSONObject("activities") != null) goto L48;
        if (r103.optJSONObject("agent_intents") != null) goto L48;
    L34:
        if (r102.optBoolean("bypass_policy", false) == true) goto L62;
        JSONObject r104 = r102.optJSONObject("policy");
        if (r104 == null) goto L39;
        return new d2.a(r104, false);
    L62:
        return new d2.a(null, true);
    L5:
        if (r101.length() == 0) goto L30;
        int r105 = 0;
    L8:
        if (r105 >= r101.length()) goto L30;
        r102 = r101.optJSONObject(r105);
        if (r102 == null) goto L29;
        JSONArray r106 = r102.optJSONArray("brands");
        if (r106 == null) goto L29;
        if (r106.length() == 0) goto L29;
        int r107 = 0;
    L19:
        if (r107 >= r106.length()) goto L29;
        String r108 = r106.optString(r107, "").toLowerCase();
        if (TextUtils.isEmpty(r108) == true) goto L28;
        if (r108.equals(r110.f466496a) == true) goto L31;
        if (r108.equals(r110.f466497b) == true) goto L31;
    L28:
        r107 = r107 + 1;
    L29:
        r105 = r105 + 1;
        goto L8
    }

    public static Cursor b(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, null};
        f06.b r115 = new f06.b();
        f06.d r116 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r115, false);
        return (Cursor) r116.f474983b;
    L6:
        Cursor r117 = r110.query(r111, r112, r113, r114, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r117, r115, true);
        return r117;
    }
}
