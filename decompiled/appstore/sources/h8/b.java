package h8;

import android.text.TextUtils;
import androidx.appcompat.widget.p;
import com.bytedanceos.common.networkv2.cloudsettings.BaseSettingItemEntity;
import com.bytedanceos.common.networkv2.cloudsettings.BaseSettingsManager;
import com.bytedanceos.common.toolbox.b0;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes2.dex */
public class b extends BaseSettingsManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile b f20376g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f20382f;

    public b() {
        h();
    }

    public static b b() {
        if (f20376g != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f20376g != null) goto L11;
        f20376g = new b();     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f20376g;
    }

    public int a() {
        return this.f20377a;
    }

    public int c() {
        return this.f20379c;
    }

    public int d() {
        return this.f20380d;
    }

    public int e() {
        return this.f20378b;
    }

    public int f() {
        return this.f20382f;
    }

    public int g() {
        return this.f20381e;
    }

    @Override // com.bytedanceos.common.networkv2.cloudsettings.BaseSettingsManager
    public String getSettingConfigUrl() {
        return "";
    }

    @Override // com.bytedanceos.common.networkv2.cloudsettings.BaseSettingsManager
    public String getSharePrefsConfigKey() {
        return "config_dynamic";
    }

    @Override // com.bytedanceos.common.networkv2.cloudsettings.BaseSettingsManager
    public String getSharePrefsSettingKey() {
        return "info_dynamic";
    }

    public final void h() {
        String r10 = b0.n().r("info_dynamic", null);
        if (TextUtils.isEmpty(r10) == true) goto L5;
        p.a(new Gson().fromJson(r10, a.class));
        b0.n().G("info_dynamic", "", null);
        b0.n().G("config_dynamic", "", null);
        j();
        return;
    L5:
        j();
    }

    public void i(a r10) {
    }

    public final void j() {
        this.f20377a = 10;
        this.f20378b = 1;
        this.f20379c = 8;
        this.f20380d = 20;
        this.f20381e = 60;
        this.f20382f = 20;
    }

    @Override // com.bytedanceos.common.networkv2.cloudsettings.BaseSettingsManager
    public /* bridge */ /* synthetic */ void onSettingEntityUpdate(BaseSettingItemEntity r10) {
        p.a(r10);
        i(null);
    }
}
