package i8;

import android.text.TextUtils;
import androidx.appcompat.widget.p;
import com.bytedanceos.common.networkv2.cloudsettings.BaseSettingItemEntity;
import com.bytedanceos.common.networkv2.cloudsettings.BaseSettingsManager;
import com.bytedanceos.common.toolbox.b0;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes2.dex */
public class b extends BaseSettingsManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f20531b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20532a;

    public b() {
        this.f20532a = false;
        b();
    }

    public static b a() {
        if (f20531b != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f20531b != null) goto L11;
        f20531b = new b();     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f20531b;
    }

    private void b() {
        String r10 = b0.n().r("info_md5", null);
        if (TextUtils.isEmpty(r10) == true) goto L5;
        p.a(new Gson().fromJson(r10, a.class));
        b0.n().G("info_md5", "", null);
        b0.n().G("config_md5", "", null);
        this.f20532a = false;
        return;
    L5:
        this.f20532a = false;
    }

    public void c(a r10) {
    }

    @Override // com.bytedanceos.common.networkv2.cloudsettings.BaseSettingsManager
    public String getSettingConfigUrl() {
        return "";
    }

    @Override // com.bytedanceos.common.networkv2.cloudsettings.BaseSettingsManager
    public String getSharePrefsConfigKey() {
        return "config_md5";
    }

    @Override // com.bytedanceos.common.networkv2.cloudsettings.BaseSettingsManager
    public String getSharePrefsSettingKey() {
        return "info_md5";
    }

    @Override // com.bytedanceos.common.networkv2.cloudsettings.BaseSettingsManager
    public /* bridge */ /* synthetic */ void onSettingEntityUpdate(BaseSettingItemEntity r10) {
        p.a(r10);
        c(null);
    }
}
