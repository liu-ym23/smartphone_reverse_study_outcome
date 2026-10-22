package com.bytedance.android.live.core.setting.v2.update;

import a70.c;
import b70.a;
import com.bytedance.android.live.core.setting.d6;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w60.b;
import z60.d;

/* JADX INFO: loaded from: classes45.dex */
public final class SettingIncStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f65434a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<a> f65435b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f65436c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/update/SettingIncStrategy$IncScene;", "", "COLD_LAUNCH", "FRONTIER", "STICK", "OBJECT", "live-setting_release"}, k = 1, mv = {1, 4, 3})
    public static final enum IncScene extends Enum<IncScene> {
        public static final IncScene COLD_LAUNCH = null;
        public static final IncScene FRONTIER = null;
        public static final IncScene OBJECT = null;
        public static final IncScene STICK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ IncScene[] f65437a = null;

        static {
            IncScene r100 = new IncScene("COLD_LAUNCH", 0);
            COLD_LAUNCH = r100;
            IncScene r101 = new IncScene("FRONTIER", 1);
            FRONTIER = r101;
            IncScene r102 = new IncScene("STICK", 2);
            STICK = r102;
            IncScene r103 = new IncScene("OBJECT", 3);
            OBJECT = r103;
            f65437a = new IncScene[]{r100, r101, r102, r103};
        }

        public static IncScene valueOf(String r100) {
            return (IncScene) r27.a.a(IncScene.class, r100);
        }

        public static IncScene[] values() {
            return (IncScene[]) f65437a.clone();
        }

        public IncScene(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f65434a = new b();
        f65435b = new ArrayList();
    }

    public static void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "updateListener");
        ArrayList r101 = (ArrayList) f65435b;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }

    public static boolean b(IncScene r110, JsonObject r111, JsonObject r112) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        String r100 = null;
        a70.b.e("_MAIN", "///...............................开始更新数据, scene = " + r110.name() + ": ......................///");     // Catch: Exception -> L16
        a70.b.f("incUpdate");     // Catch: Exception -> L16
        int r101 = b70.b.f17897a[r110.ordinal()];     // Catch: Exception -> L16
        if (r101 != 1) goto L6;
        boolean r113 = new z60.b(new z60.a()).update(r111, r112, null);     // Catch: Exception -> L16
    L10:
        f65436c = true;     // Catch: Exception -> L16
        b r102 = f65434a;     // Catch: Exception -> L16
        r102.d(r102.b());     // Catch: Exception -> L16
        Iterator r103 = ((ArrayList) f65435b).iterator();     // Catch: Exception -> L16
    L12:
        if (r103.hasNext() == false) goto L14;
        a r104 = (a) r103.next();     // Catch: Exception -> L16
        IncScene r105 = IncScene.COLD_LAUNCH;     // Catch: Exception -> L16
        r104.onSuccess();     // Catch: Exception -> L16
        goto L12
    L14:
        a70.b.a("incUpdate");     // Catch: Exception -> L16
        a70.b.e("_MAIN", "///...............................更新数据结束, 结果为: " + r113 + ".............................................///");     // Catch: Exception -> L16
        return r113;
    L6:
        if (r101 == 2) goto L8;
        r113 = false;
        goto L10
    L8:
        r113 = new z60.b(new d()).update(r111, r112, null);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        Map<String, Long> r106 = a70.b.f1985a;
        Intrinsics.checkNotNullParameter(e, "e");
        d6.a("SettingReportMonitor_MAIN", e);
        if (r112 == null) goto L22;
        JsonElement r114 = r112.get("setting_update_mode");
        if (r114 == null) goto L22;
        r100 = r114.getAsString();
    L22:
        String r115 = "full";
        if (Intrinsics.areEqual(r100, "full") == true) goto L26;
        r115 = "incr";
    L26:
        String r107 = r115;
        if (r110 != IncScene.COLD_LAUNCH) goto L29;
        String r116 = "clod";
    L30:
        c.a(1, r107, r116, null, -1, -1, e.getMessage());
        return false;
    L29:
        r116 = "frontier";
        goto L30
    }
}
