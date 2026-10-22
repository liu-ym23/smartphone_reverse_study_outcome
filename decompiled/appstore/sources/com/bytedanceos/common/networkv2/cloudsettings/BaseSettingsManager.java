package com.bytedanceos.common.networkv2.cloudsettings;

import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.networkv2.cloudsettings.BaseSettingItemEntity;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.j;
import com.google.gson.Gson;
import java.lang.reflect.ParameterizedType;
import mg.a;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseSettingsManager<T extends BaseSettingItemEntity> {
    public static final long DAY = 86400000;
    public static final long HOUR = 3600000;
    private static final String KEY_CONFIG_UPDATE_APPS_SYNC_SUCCESS_TIME = "config_update_apps_sync_success_time";
    public static final long MINUTE = 60000;
    private BaseSettingsManager<T>.ConfigSubscribe mConfigSubscribe;
    private BaseSettingsManager<T>.SettingsSubscribe mSettingsSubscribe;

    public class ConfigSubscribe extends Subscriber {
        final /* synthetic */ BaseSettingsManager this$0;

        private ConfigSubscribe(BaseSettingsManager r10) {
            this.this$0 = r10;
        }

        @Override // rx.Observer
        public void onCompleted() {
            j.e("ConfigSubscribe onCompleted");
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            j.b("ConfigSubscribe onError " + r10);
        }

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object r10) {
            onNext((SettingConfigEntity) r10);
        }

        public /* synthetic */ ConfigSubscribe(BaseSettingsManager r10, AnonymousClass1 r11) {
            this(r10);
        }

        public void onNext(SettingConfigEntity r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            j.e("ConfigSubscribe onNext");
            String r11 = b0.n().r(this.this$0.getSharePrefsConfigKey(), null);
            SettingConfigEntity r12 = new SettingConfigEntity();
            if (TextUtils.isEmpty(r11) == true) goto L7;
            r12 = (SettingConfigEntity) new Gson().fromJson(r11, SettingConfigEntity.class);
        L7:
            String r13 = r10.getMd5();
            if (r13 != null) goto L10;
            return;
        L10:
            if (r13.equals(r12.getMd5()) == true) goto L14;
            BaseSettingsManager.access$100(this.this$0, r10, r10.getUri());
            return;
        }
    }

    public class SettingsSubscribe extends Subscriber {
        private SettingConfigEntity mSettingConfigEntity;
        final /* synthetic */ BaseSettingsManager this$0;

        public SettingsSubscribe(BaseSettingsManager r10, SettingConfigEntity r11) {
            this.this$0 = r10;
            this.mSettingConfigEntity = r11;
        }

        @Override // rx.Observer
        public void onCompleted() {
            j.e("SettingsSubscribe onCompleted");
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            j.b("SettingsSubscribe onError " + r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object r10) {
            onNext((BaseSettingItemEntity) r10);
        }

        public void onNext(T r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            j.e("SettingsSubscribe onNext");
            BaseSettingsManager.access$200(this.this$0, this.mSettingConfigEntity, r10);
        }
    }

    public BaseSettingsManager() {
        this.mConfigSubscribe = new ConfigSubscribe(this, null);
        this.mSettingsSubscribe = new SettingsSubscribe(this, null);
    }

    public static /* synthetic */ void access$100(BaseSettingsManager r10, SettingConfigEntity r11, String r12) {
        r10.requestUpdate(r11, r12);
    }

    public static /* synthetic */ void access$200(BaseSettingsManager r10, SettingConfigEntity r11, BaseSettingItemEntity r12) {
        r10.saveToSharePreference(r11, r12);
    }

    private void requestUpdate(SettingConfigEntity r10, String r11) {
        this.mSettingsSubscribe.unsubscribe();
        this.mSettingsSubscribe = new SettingsSubscribe(this, r10);
        Class<T> r12 = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        CloudSettingConfigRest.instance().getSettingEntity(this.mSettingsSubscribe, r11, r12);
    }

    private void requestUpdateConfig() {
    }

    private void saveToSharePreference(SettingConfigEntity r10, T r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        Gson r12 = new Gson();
        b0 r13 = b0.n();
        r13.G(getSharePrefsConfigKey(), r12.toJson(r10), null);
        r13.G(getSharePrefsSettingKey(), r12.toJson(r11), null);
        r13.F(KEY_CONFIG_UPDATE_APPS_SYNC_SUCCESS_TIME, System.currentTimeMillis(), null, BaseApplication.c());
        Observable.d("").g(a.b()).p(new AnonymousClass1(this));
    }

    public abstract String getSettingConfigUrl();

    public abstract String getSharePrefsConfigKey();

    public abstract String getSharePrefsSettingKey();

    public abstract void onSettingEntityUpdate(T r10);

    public void syncSettingData() {
        requestUpdateConfig();
    }
}
