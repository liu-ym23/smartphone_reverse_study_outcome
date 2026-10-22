package com.bytedance.android.livesdkapi.depend.prefs;

import androidx.camera.video.AudioStats;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes12.dex */
public class Property<T> {
    static final String LIVE_SP_KEY = "tt_live_sdk";
    private T defaultValue;
    private String name;
    private String spName;
    private Type type;

    public T getValue() {
        return (T) PropertyCache.getValue(this);
    }

    public T getDefaultValue() {
        return this.defaultValue;
    }

    public String getName() {
        return this.name;
    }

    public String getSpName() {
        return this.spName;
    }

    public Type getType() {
        return this.type;
    }

    public void setDefaultValue(T r100) {
        this.defaultValue = r100;
    }

    public void setValue(T r100) {
        PropertyCache.setValue(this, r100);
    }

    public Property(String r100, T r101) {
        this(LIVE_SP_KEY, r100, r101.getClass(), r101);
    }

    public Property(String r100, Type r101) {
        this(LIVE_SP_KEY, r100, r101, null);
    }

    public Property(String r100, String r101, T r102) {
        this(r100, r101, r102.getClass(), r102);
    }

    public Property(String r100, Type r101, T r102) {
        this(LIVE_SP_KEY, r100, r101, r102);
    }

    public Property(String r100, String r101, Type r102) {
        this(r100, r101, r102, null);
    }

    private Property(String r100, String r101, Type r102, T r103) {
        this.spName = r100;
        this.name = r101;
        this.defaultValue = r103;
        this.type = r102;
        if (r103 == null) goto L5;
        return;
    L5:
        if (r102 != Integer.class) goto L7;
    L21:
        this.defaultValue = (T) 0;
        return;
    L7:
        if (r102 == Short.class) goto L21;
        if (r102 != Long.class) goto L13;
        this.defaultValue = (T) 0L;
        return;
    L13:
        if (r102 != Double.class) goto L16;
        this.defaultValue = (T) Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        return;
    L16:
        if (r102 != Float.class) goto L19;
        this.defaultValue = (T) Float.valueOf(0.0f);
        return;
    L19:
        if (r102 != Boolean.class) goto L27;
        this.defaultValue = (T) Boolean.FALSE;
        return;
    }
}
