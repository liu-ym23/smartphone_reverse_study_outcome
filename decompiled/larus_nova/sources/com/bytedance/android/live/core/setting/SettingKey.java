package com.bytedance.android.live.core.setting;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes45.dex */
public class SettingKey<T> {
    private final T debugValue;
    private final T defaultValue;
    private final String description;
    private boolean isOnlyRemote;
    private boolean isPreloadCache;
    private final String name;
    private final String[] option;
    private final boolean sticky;
    private final Type type;
    private T value;

    public T getSpValue() {
        String r100 = SettingUtil.KEY_SERVER_SETTING_VALUES;
        T r101 = (T) SettingUtil.getValue("key_ttlive_sdk_setting", this.name, this.type, this.defaultValue, this.value, this.sticky, this.isOnlyRemote, this.isPreloadCache);
        this.value = r101;
        return r101;
    }

    private T getWarlockSpValue() {
        if (SettingUtil.isDebugMode() == true) goto L5;
        long r100 = System.nanoTime();
        this.value = (T) SettingUtil.getValue("key_ttlive_sdk_setting", this.name, this.type, this.defaultValue, this.value, this.sticky, this.isOnlyRemote, this.isPreloadCache);
        TimeUnit.MICROSECONDS.convert(System.nanoTime() - r100, TimeUnit.NANOSECONDS);
        int r101 = d6.f65283a;
        if (wa1.d.f558804b == true) goto L11;
        return this.value;
    L11:
        throw null;
    L5:
        return this.debugValue;
    }

    public T getValue() {
        return getSpValue();
    }

    public T getDebugValue() {
        return this.debugValue;
    }

    public T getDefaultValue() {
        return this.defaultValue;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public String[] getOption() {
        return this.option;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isOnlyRemote() {
        return this.isOnlyRemote;
    }

    public boolean isSticky() {
        return this.sticky;
    }

    public SettingKey<T> setPreloadCache(boolean r100) {
        this.isPreloadCache = r100;
        return this;
    }

    public SettingKey(String r100, Class<T> r101) {
        this(r100, r101, "");
    }

    public SettingKey(String r100, T r101) {
        this(r100, r101, "");
    }

    public SettingKey(String r100, Type r101, T r102) {
        this.isOnlyRemote = false;
        this.isPreloadCache = false;
        this.name = r100;
        this.defaultValue = r102;
        this.debugValue = r102;
        this.type = r101;
        this.description = null;
        this.option = null;
        this.sticky = false;
    }

    public SettingKey(String r100, Class<T> r101, String r102) {
        this(r100, r101, r102, null, null);
    }

    public SettingKey(String r100, T r101, String r102) {
        this(r100, r102, r101, r101);
    }

    public SettingKey(String r100, Class<T> r101, String r102, boolean r103) {
        this.name = r100;
        this.description = r102;
        this.isOnlyRemote = r103;
        this.type = r101;
        this.defaultValue = null;
        this.debugValue = null;
        this.option = null;
        this.sticky = false;
        this.isPreloadCache = false;
    }

    public SettingKey(String r100, String r110, T r111, T r112) {
        this(r100, r111.getClass(), r110, r111, r112, false, null);
    }

    public SettingKey(String r100, T r101, String r102, String... r110) {
        this(r100, r102, r101, r101, r110);
    }

    public SettingKey(String r100, String r110, T r111, T r112, boolean r113) {
        this(r100, r111.getClass(), r110, r111, r112, r113, null);
    }

    public SettingKey(String r100, String r110, T r111, T r112, String... r113) {
        this(r100, r111.getClass(), r110, r111, r112, false, r113);
    }

    public SettingKey(String r100, Class<T> r110, String r111, T r112, T r113) {
        this(r100, r110, r111, r112, r113, false, null);
    }

    public SettingKey(String r100, String r101, T r102, Type r103, boolean r104, boolean r105) {
        this.name = r100;
        this.description = r101;
        this.isOnlyRemote = r104;
        this.type = r103;
        this.defaultValue = r102;
        this.debugValue = null;
        this.option = null;
        this.sticky = r105;
        this.isPreloadCache = false;
    }

    public SettingKey(String r100, String r110, T r111, T r112, boolean r113, String... r114) {
        this(r100, r111.getClass(), r110, r111, r112, r113, r114);
    }

    public SettingKey(String r100, Class<T> r110, String r111, T r112, T r113, boolean r114) {
        this(r100, r110, r111, r112, r113, r114, null);
    }

    private SettingKey(String r100, Class<T> r101, String r102, T r103, T r104, boolean r105, String[] r106) {
        this.isOnlyRemote = false;
        this.isPreloadCache = false;
        this.name = r100;
        this.description = r102;
        this.defaultValue = r103;
        this.debugValue = r104;
        this.type = r101;
        this.option = r106;
        this.sticky = r105;
    }

    public SettingKey(String r100, String r101, T r102, Type r103, boolean r104, boolean r105, boolean r106) {
        this.name = r100;
        this.description = r101;
        this.isOnlyRemote = r104;
        this.type = r103;
        this.defaultValue = r102;
        this.debugValue = null;
        this.option = null;
        this.sticky = r105;
        this.isPreloadCache = r106;
    }
}
