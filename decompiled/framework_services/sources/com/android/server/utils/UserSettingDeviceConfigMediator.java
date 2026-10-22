package com.android.server.utils;

import android.provider.DeviceConfig;
import android.util.KeyValueListParser;

/* JADX INFO: loaded from: classes3.dex */
public abstract class UserSettingDeviceConfigMediator {
    private static final String TAG = null;
    protected DeviceConfig.Properties mProperties;
    protected final KeyValueListParser mSettingsParser;

    public static class SettingsOverridesAllMediator extends UserSettingDeviceConfigMediator {
        public SettingsOverridesAllMediator(char keyValueListDelimiter) {
            super(keyValueListDelimiter);
        }

        @Override // com.android.server.utils.UserSettingDeviceConfigMediator
        public boolean getBoolean(String key, boolean defaultValue) {
            if (this.mSettingsParser.size() != 0) goto L10;
            if (this.mProperties != null) goto L8;
            return defaultValue;
        L8:
            return this.mProperties.getBoolean(key, defaultValue);
        L10:
            return this.mSettingsParser.getBoolean(key, defaultValue);
        }

        @Override // com.android.server.utils.UserSettingDeviceConfigMediator
        public float getFloat(String key, float defaultValue) {
            if (this.mSettingsParser.size() != 0) goto L10;
            if (this.mProperties != null) goto L8;
            return defaultValue;
        L8:
            return this.mProperties.getFloat(key, defaultValue);
        L10:
            return this.mSettingsParser.getFloat(key, defaultValue);
        }

        @Override // com.android.server.utils.UserSettingDeviceConfigMediator
        public int getInt(String key, int defaultValue) {
            if (this.mSettingsParser.size() != 0) goto L10;
            if (this.mProperties != null) goto L8;
            return defaultValue;
        L8:
            return this.mProperties.getInt(key, defaultValue);
        L10:
            return this.mSettingsParser.getInt(key, defaultValue);
        }

        @Override // com.android.server.utils.UserSettingDeviceConfigMediator
        public long getLong(String key, long defaultValue) {
            if (this.mSettingsParser.size() != 0) goto L10;
            if (this.mProperties != null) goto L8;
            return defaultValue;
        L8:
            return this.mProperties.getLong(key, defaultValue);
        L10:
            return this.mSettingsParser.getLong(key, defaultValue);
        }

        @Override // com.android.server.utils.UserSettingDeviceConfigMediator
        public String getString(String key, String defaultValue) {
            if (this.mSettingsParser.size() != 0) goto L10;
            if (this.mProperties != null) goto L8;
            return defaultValue;
        L8:
            return this.mProperties.getString(key, defaultValue);
        L10:
            return this.mSettingsParser.getString(key, defaultValue);
        }
    }

    public static class SettingsOverridesIndividualMediator extends UserSettingDeviceConfigMediator {
        public SettingsOverridesIndividualMediator(char keyValueListDelimiter) {
            super(keyValueListDelimiter);
        }

        @Override // com.android.server.utils.UserSettingDeviceConfigMediator
        public boolean getBoolean(String key, boolean defaultValue) {
            KeyValueListParser r0 = this.mSettingsParser;
            if (this.mProperties != null) goto L5;
            boolean r1 = defaultValue;
        L7:
            return r0.getBoolean(key, r1);
        L5:
            r1 = this.mProperties.getBoolean(key, defaultValue);
            goto L7
        }

        @Override // com.android.server.utils.UserSettingDeviceConfigMediator
        public float getFloat(String key, float defaultValue) {
            KeyValueListParser r0 = this.mSettingsParser;
            if (this.mProperties != null) goto L5;
            float r1 = defaultValue;
        L7:
            return r0.getFloat(key, r1);
        L5:
            r1 = this.mProperties.getFloat(key, defaultValue);
            goto L7
        }

        @Override // com.android.server.utils.UserSettingDeviceConfigMediator
        public int getInt(String key, int defaultValue) {
            KeyValueListParser r0 = this.mSettingsParser;
            if (this.mProperties != null) goto L5;
            int r1 = defaultValue;
        L7:
            return r0.getInt(key, r1);
        L5:
            r1 = this.mProperties.getInt(key, defaultValue);
            goto L7
        }

        @Override // com.android.server.utils.UserSettingDeviceConfigMediator
        public long getLong(String key, long defaultValue) {
            KeyValueListParser r0 = this.mSettingsParser;
            if (this.mProperties != null) goto L5;
            long r1 = defaultValue;
        L7:
            return r0.getLong(key, r1);
        L5:
            r1 = this.mProperties.getLong(key, defaultValue);
            goto L7
        }

        @Override // com.android.server.utils.UserSettingDeviceConfigMediator
        public String getString(String key, String defaultValue) {
            KeyValueListParser r0 = this.mSettingsParser;
            if (this.mProperties != null) goto L5;
            String r1 = defaultValue;
        L7:
            return r0.getString(key, r1);
        L5:
            r1 = this.mProperties.getString(key, defaultValue);
            goto L7
        }
    }

    public abstract boolean getBoolean(String r1, boolean r2);

    public abstract float getFloat(String r1, float r2);

    public abstract int getInt(String r1, int r2);

    public abstract long getLong(String r1, long r2);

    public abstract String getString(String r1, String r2);

    static {
        TAG = UserSettingDeviceConfigMediator.class.getSimpleName();
    }

    protected UserSettingDeviceConfigMediator(char keyValueListDelimiter) {
        this.mSettingsParser = new KeyValueListParser(keyValueListDelimiter);
    }

    public void setSettingsString(String settings) {
        this.mSettingsParser.setString(settings);
    }

    public void setDeviceConfigProperties(DeviceConfig.Properties properties) {
        this.mProperties = properties;
    }
}
