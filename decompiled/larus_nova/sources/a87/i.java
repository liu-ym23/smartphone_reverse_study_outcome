package a87;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.push.settings.storage.MainProcessSettingsProvider;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements j77.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, k> f2183a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, k> f2184b = null;

    static {
        f2183a = new ConcurrentHashMap();
        f2184b = new ConcurrentHashMap();
    }

    public i() {
    }

    public final k a(Context r100, boolean r101, String r102, String r110) {
        if (r101 == false) goto L76;
        ConcurrentHashMap<String, k> r103 = f2184b;
        k r104 = r103.get(r102);
        if (r104 != null) goto L6;
    L11:
        int r105 = q77.a.f531973a;
        p77.b r106 = p77.b.a();
        boolean r107 = true;
        if (r106.f528047e.a(r100) == false) goto L18;
        boolean r108 = r100.getSharedPreferences("local_settings_sp", 0).getBoolean("allow", true);
        d87.a.b(r100);
        p77.a r109 = r106.f528047e;
        r109.getClass();
        r109.f528041d.release();     // Catch: IOException -> L16
    L20:
        if (r108 == false) goto L37;
        if (TextUtils.equals(r110, PullConfiguration.PROCESS_NAME_SMP) == false) goto L24;
    L35:
        k r111 = new c(r100, r102);
    L75:
        r103.put(r102, r111);
        return r111;
    L24:
        if (TextUtils.equals(r110, PullConfiguration.PROCESS_NAME_MAIN) == true) goto L35;
        if (MainProcessSettingsProvider.f267022d == false) goto L29;
    L32:
        if (r107 == false) goto L34;
        r111 = new c(r100, r102);
        goto L75
    L34:
        r111 = new e(r100, r102);
        goto L75
    L29:
        if (d87.a.c(r100) == true) goto L32;
        r107 = false;
        goto L32
    L37:
        if (TextUtils.equals(r110, PullConfiguration.PROCESS_NAME_SMP) == false) goto L39;
    L74:
        r111 = new c(r100, r102);
        goto L75
    L39:
        if (TextUtils.equals(r110, PullConfiguration.PROCESS_NAME_MAIN) == true) goto L74;
        p77.b.a().b(r100);
        p77.b r112 = p77.b.a();
        if (TextUtils.isEmpty(r112.f528045c) == true) goto L45;
        String r113 = r112.f528045c;
    L54:
        if (TextUtils.equals(d87.a.b(r100), r113) == false) goto L57;
        r111 = new c(r100, r102);
        goto L75
    L57:
        if (TextUtils.isEmpty(r113) == true) goto L62;
        if (r113.endsWith(":smp") == false) goto L62;
        r111 = new e(r100, r102, 0);
    L62:
        if (TextUtils.isEmpty(r113) == true) goto L66;
    L66:
        if (MainProcessSettingsProvider.f267022d == false) goto L68;
    L71:
        if (r107 == false) goto L73;
        r111 = new c(r100, r102);
        goto L75
    L73:
        r111 = new e(r100, r102);
        goto L75
    L68:
        if (d87.a.c(r100) == true) goto L71;
        r107 = false;
        goto L71
    L45:
        if (r112.f528047e.a(r100) == false) goto L52;
        r112.f528045c = r100.getSharedPreferences("local_settings_sp", 0).getString("first_process", "");
        p77.a r114 = r112.f528047e;
        r114.getClass();
        r114.f528041d.release();     // Catch: IOException -> L49
    L51:
        d87.a.b(r100);
        r113 = r112.f528045c;
    L49:
        e = move-exception;
        e.printStackTrace();
        goto L51
    L52:
        r113 = "";
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L18:
        r108 = true;
        goto L20
    L6:
        if (TextUtils.isEmpty(r110) == false) goto L8;
    L10:
        return r104;
    L8:
        if ((r104 instanceof e) == false) goto L10;
        int r115 = q77.a.f531973a;
        goto L11
    L76:
        ConcurrentHashMap<String, k> r116 = f2183a;
        k r117 = r116.get(r102);
        if (r117 == null) goto L79;
        return r117;
    L79:
        h r118 = new h(r100, r102);
        r116.put(r102, r118);
        return r118;
    }
}
