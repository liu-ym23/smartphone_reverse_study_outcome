package j8;

import androidx.appcompat.widget.p;
import com.bytedanceos.common.networkv2.cloudsettings.BaseSettingItemEntity;
import com.bytedanceos.common.networkv2.cloudsettings.BaseSettingsManager;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class a extends BaseSettingsManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f20945b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f20946a;

    public a() {
        this.f20946a = new ArrayList();
        b();
    }

    public static a a() {
        if (f20945b != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f20945b != null) goto L11;
        f20945b = new a();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f20945b;
    }

    private void b() {
    }

    public boolean c(String r10) {
        return false;
    }

    public void d(b r10) {
    }

    @Override // com.bytedanceos.common.networkv2.cloudsettings.BaseSettingsManager
    public String getSettingConfigUrl() {
        return "";
    }

    @Override // com.bytedanceos.common.networkv2.cloudsettings.BaseSettingsManager
    public String getSharePrefsConfigKey() {
        return "config_overwrite";
    }

    @Override // com.bytedanceos.common.networkv2.cloudsettings.BaseSettingsManager
    public String getSharePrefsSettingKey() {
        return "info_overwrite";
    }

    @Override // com.bytedanceos.common.networkv2.cloudsettings.BaseSettingsManager
    public /* bridge */ /* synthetic */ void onSettingEntityUpdate(BaseSettingItemEntity r10) {
        p.a(r10);
        d(null);
    }
}
