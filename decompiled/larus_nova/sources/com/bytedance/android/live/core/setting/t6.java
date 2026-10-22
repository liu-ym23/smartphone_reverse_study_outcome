package com.bytedance.android.live.core.setting;

import com.bytedance.android.live.core.setting.v2.helper.SettingBooleanTypeAdapter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/* JADX INFO: loaded from: classes45.dex */
public final class t6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f65418a = null;

    static {
        f65418a = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapter(Boolean.class, new SettingBooleanTypeAdapter()).registerTypeAdapter(Boolean.TYPE, new SettingBooleanTypeAdapter()).create();
    }
}
