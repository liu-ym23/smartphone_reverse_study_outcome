package com.bytedance.android.live.core.setting;

/* JADX INFO: loaded from: classes45.dex */
public class TTAppSettingKey<T> extends SettingKey<T> {
    @Override // com.bytedance.android.live.core.setting.SettingKey
    public T getValue() {
        return (T) SettingUtil.getValue(SettingUtil.KEY_TT_APP_SETTING, getName(), getType(), getDefaultValue());
    }

    public TTAppSettingKey(String r100, Class r101) {
        super(r100, r101);
    }

    public TTAppSettingKey(String r100, T r101) {
        super(r100, r101);
    }

    public TTAppSettingKey(String r100, Class r101, String r102) {
        super(r100, r101, r102);
    }

    public TTAppSettingKey(String r100, T r101, String r102) {
        super(r100, r101, r102);
    }

    public TTAppSettingKey(String r100, T r101, String r102, String... r103) {
        super(r100, r101, r102, r103);
    }
}
