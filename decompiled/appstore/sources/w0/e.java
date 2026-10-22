package w0;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.bytedance.services.apm.api.IActivityLifeObserver;
import com.bytedance.services.apm.api.IWidget;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements IWidget, IConfigListener, IActivityLifeObserver, AsyncEventManager.IMonitorTimeTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f25267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile JSONObject f25268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile JSONObject f25269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile JSONObject f25270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f25271f;

    public e() {
    }

    public final void a() {
        d();
        e();
        f();
    }

    public boolean b(String r10) {
        if (this.f25270e != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return false;
    L8:
        if (this.f25270e.optInt(r10) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public final boolean c() {
        IConfigManager r10 = (IConfigManager) n5.b.a(IConfigManager.class);
        if (r10 == null) goto L6;
        r10.registerConfigListener(this);
        return true;
    L6:
        return false;
    }

    public final boolean d() {
        IActivityLifeManager r10 = (IActivityLifeManager) n5.b.a(IActivityLifeManager.class);
        if (r10 == null) goto L6;
        r10.unregister(this);
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.services.apm.api.IWidget
    public void destroy() {
        a();
    }

    public final boolean e() {
        IConfigManager r10 = (IConfigManager) n5.b.a(IConfigManager.class);
        if (r10 == null) goto L6;
        r10.unregisterConfigListener(this);
        return true;
    L6:
        return false;
    }

    public final void f() {
        AsyncEventManager.e().removeTimeTask(this);
    }

    @Override // com.bytedance.services.apm.api.IWidget
    public void init(Context r10) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityCreated(Activity r10, Bundle r11) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityPause(Activity r10) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityResume(Activity r10) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityStarted(Activity r10) {
    }

    public void onBackground(Activity r10) {
        this.f25271f = false;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onChange(Activity r10, Fragment r11) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r10) {
        this.f25271f = true;
    }

    public void onReady() {
        this.f25266a = true;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r10, boolean r11) {
        this.f25267b = r10;
        JSONObject r12 = r10.optJSONObject("custom_event_settings");
        if (r12 == null) goto L6;
        this.f25268c = r12.optJSONObject("allow_log_type");
        this.f25269d = r12.optJSONObject(SlardarSettingsConsts.BASE_KEY_ALLOW_METRIC_TYPE);
        this.f25270e = r12.optJSONObject(SlardarSettingsConsts.BASE_KEY_ALLOW_SERVICE_NAME);
        return;
    }

    @Override // com.bytedance.apm.thread.AsyncEventManager.IMonitorTimeTask
    public void onTimeEvent(long r10) {
    }

    @Override // com.bytedance.services.apm.api.IWidget
    public void start() {
    }

    @Override // com.bytedance.services.apm.api.IWidget
    public void stop() {
    }
}
