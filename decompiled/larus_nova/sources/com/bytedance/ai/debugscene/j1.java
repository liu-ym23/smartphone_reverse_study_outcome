package com.bytedance.ai.debugscene;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f36419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f36420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f36421c;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Applet> f36422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Widget> f36423b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f36422a, r101.f36422a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f36423b, r101.f36423b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f36422a.hashCode() * 31) + this.f36423b.hashCode();
        }

        public final String toString() {
            return "DebugPackageWrapper(applets=" + this.f36422a + ", widgets=" + this.f36423b + ')';
        }

        public b() {
            this(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<Applet> r100, List<? extends Widget> r101) {
            Intrinsics.checkNotNullParameter(r100, "applets");
            Intrinsics.checkNotNullParameter(r101, "widgets");
            this.f36422a = r100;
            this.f36423b = r101;
        }
    }

    static {
    }

    public final void a() {
        SharedPreferences.Editor r100 = this.f36419a.edit();
        r100.remove("debug_packages");
        r100.remove("previous_debug_packages");
        r100.remove("remote_debug_modern_tag_package");
        r100.commit();
        com.bytedance.ai.utils.g.f37637a.i("AISDKDebugSettings", "Cleared all debug packages from storage");
    }

    public j1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        SharedPreferences r101 = r100.getSharedPreferences("ai_sdk_sp_debug_settings_external", 0);
        this.f36419a = r101;
        this.f36420b = new ConcurrentHashMap();
        this.f36421c = r101.getBoolean("applet_cache_debug_host", false);
    }

    public final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appletName");
        String r101 = "host_" + r100;
        String r102 = this.f36420b.get(r101);
        if (r102 == null) goto L5;
    L15:
        return r102;
    L5:
        if (this.f36421c == false) goto L15;
        r102 = this.f36419a.getString(r101, null);
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L15;
        this.f36420b.put(r101, r102);
        goto L15
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L13
    }

    public final String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appletName");
        String r101 = "sign_version_" + r100;
        String r102 = this.f36420b.get(r101);
        if (r102 == null) goto L5;
    L15:
        return r102;
    L5:
        if (this.f36421c == false) goto L15;
        r102 = this.f36419a.getString(r101, null);
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L15;
        this.f36420b.put(r101, r102);
        goto L15
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L13
    }

    public final boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appletName");
        String r101 = "encrypted_" + r100;
        String r102 = this.f36420b.get(r101);
        if (r102 == null) goto L5;
        Boolean r103 = Boolean.valueOf(Boolean.parseBoolean(r102));
    L6:
        if (r103 != null) goto L12;
        if (this.f36421c == false) goto L12;
        boolean r104 = this.f36419a.getBoolean(r101, false);
        this.f36420b.put(r101, String.valueOf(r104));
        return r104;
    L12:
        return Intrinsics.areEqual(r103, Boolean.TRUE);
    L5:
        r103 = null;
        goto L6
    }

    public final boolean e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appletName");
        String r101 = "verify_" + r100;
        String r102 = this.f36420b.get(r101);
        if (r102 == null) goto L5;
        Boolean r103 = Boolean.valueOf(Boolean.parseBoolean(r102));
    L6:
        if (r103 != null) goto L12;
        if (this.f36421c == false) goto L12;
        boolean r104 = this.f36419a.getBoolean(r101, false);
        this.f36420b.put(r101, String.valueOf(r104));
        return r104;
    L12:
        return Intrinsics.areEqual(r103, Boolean.TRUE);
    L5:
        r103 = null;
        goto L6
    }

    public final List<AIPackage> f(String r100) {
        ArrayList r101 = new ArrayList();
        String r102 = this.f36419a.getString(r100, "");     // Catch: Exception -> L7
        if (com.bytedance.ai.utils.f.g(r102) == false) goto L9;
        Lazy r103 = com.bytedance.ai.applet.base.gson.e.f34515a;     // Catch: Exception -> L7
        b r104 = (b) com.bytedance.ai.applet.base.gson.e.a(r102, b.class);     // Catch: Exception -> L7
        r101.addAll(r104.f36422a);     // Catch: Exception -> L7
        r101.addAll(r104.f36423b);     // Catch: Exception -> L7
        com.bytedance.ai.utils.g.f37637a.d("AISDKDebugSettings", "Loaded " + r101.size() + " debug packages (" + r104.f36422a.size() + " applets, " + r104.f36423b.size() + " widgets) from storage--" + r100);     // Catch: Exception -> L7
    L9:
        return r101;
    L7:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("AISDKDebugSettings", "Failed to load debug packages-" + r100 + ": " + e.getMessage());
        goto L9
    }

    public final void g(String r100, Map<String, com.bytedance.ai.resource.d0> r110) {
        ArrayList r101 = new ArrayList();     // Catch: Exception -> L18
        ArrayList r102 = new ArrayList();     // Catch: Exception -> L18
        ConcurrentHashMap r111 = (ConcurrentHashMap) r110;     // Catch: Exception -> L18
        Iterator r103 = r111.entrySet().iterator();     // Catch: Exception -> L18
    L5:
        if (r103.hasNext() == false) goto L10;
        com.bytedance.ai.resource.d0 r104 = (com.bytedance.ai.resource.d0) ((Map.Entry) r103.next()).getValue();     // Catch: Exception -> L18
        Applet r105 = r104.g(r104.f37481a);     // Catch: Exception -> L18
        if (r105 == null) goto L9;
        r101.add(r105);     // Catch: Exception -> L18
    L9:
        r102.addAll(r104.f());     // Catch: Exception -> L18
        goto L5
    L10:
        String r106 = com.bytedance.ai.applet.base.gson.e.c(new b(r101, r102));     // Catch: Exception -> L18
        com.bytedance.ai.utils.g.f37637a.d("AISDKDebugSettings", "save debug packages: " + r106);     // Catch: Exception -> L18
        if (com.bytedance.ai.utils.f.g(r106) == true) goto L21;
    L16:
        SharedPreferences.Editor r107 = this.f36419a.edit();     // Catch: Exception -> L18
        r107.putString(r100, r106);     // Catch: Exception -> L18
        r107.commit();     // Catch: Exception -> L18
        com.bytedance.ai.utils.g.f37637a.d("AISDKDebugSettings", "Saved " + r111.size() + " debug packages (" + r101.size() + " applets, " + r102.size() + " widgets) to storage--" + r100);     // Catch: Exception -> L18
        return;
    L21:
        b r108 = (b) com.bytedance.ai.applet.base.gson.e.a(r106, b.class);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("AISDKDebugSettings", "反序列化失败：" + e);     // Catch: Exception -> L18
    L18:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("AISDKDebugSettings", "Failed to save debug packages-" + r100 + ": " + e.getMessage());
    }

    public final void h(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "appletName");
        String r102 = "show_debug_tag_" + r100;
        this.f36420b.put(r102, String.valueOf(r101));
        if (this.f36421c == false) goto L6;
        SharedPreferences.Editor r103 = this.f36419a.edit();
        r103.putBoolean(r102, r101);
        r103.commit();
        return;
    }
}
