package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.setting.SettingUtil;

/* JADX INFO: loaded from: classes8.dex */
public class PerformanceTestSettingKey<T> extends SettingKey<T> {
    private T mDefaultValue;

    private T getDisableValue() {
        Class<?> r100 = this.mDefaultValue.getClass();     // Catch: Exception -> L42
        if (r100 == Boolean.class) goto L41;
        if (r100 == Boolean.TYPE) goto L41;
        if (r100 == Integer.class) goto L39;
        if (r100 == Integer.TYPE) goto L39;
        if (r100 == Long.class) goto L37;
        if (r100 == Long.TYPE) goto L37;
        if (r100 == Double.class) goto L35;
        if (r100 == Double.TYPE) goto L35;
        if (r100 == Float.class) goto L33;
        if (r100 == Float.TYPE) goto L33;
        if (r100 != String.class) goto L46;
        return "";
    L46:
        return null;
    L33:
        return (T) Float.valueOf(-1.0f);
    L35:
        return (T) Double.valueOf(-1.0d);
    L37:
        return (T) (-1L);
    L39:
        return (T) (-1);
    L41:
        return (T) Boolean.FALSE;
    L42:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.bytedance.android.live.core.setting.SettingKey
    public T getValue() {
        if (SettingUtil.isLocalTest() == true) goto L7;
        return getDisableValue();
    L7:
        return (T) super.getValue();
    }

    public PerformanceTestSettingKey(String r100, String r101, T r102, T r103) {
        super(r100, r101, r102, r103);
        this.mDefaultValue = r102;
    }
}
