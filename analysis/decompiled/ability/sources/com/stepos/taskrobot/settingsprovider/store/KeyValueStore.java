package com.stepos.taskrobot.settingsprovider.store;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\nH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/settingsprovider/store/KeyValueStore;", "", "", "key", "getString", "(Ljava/lang/String;)Ljava/lang/String;", "value", "LC7/r;", "putString", "(Ljava/lang/String;Ljava/lang/String;)V", "", "defaultValue", "getBoolean", "(Ljava/lang/String;Z)Z", "putBoolean", "(Ljava/lang/String;Z)V", "contains", "(Ljava/lang/String;)Z", "settingsprovider_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface KeyValueStore {
    boolean contains(String key);

    boolean getBoolean(String key, boolean defaultValue);

    String getString(String key);

    void putBoolean(String key, boolean value);

    void putString(String key, String value);
}
