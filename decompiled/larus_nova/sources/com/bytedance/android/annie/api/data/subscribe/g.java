package com.bytedance.android.annie.api.data.subscribe;

import com.google.gson.JsonElement;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public interface g<T> {
    JsonElement a(String r100);

    g<T> c();

    char d();

    JsonElement e(String r100, String r101);

    JsonElement f(String r100, JsonElement r101);

    T g();

    JsonElement h(List<String> r100, JsonElement r101);

    String key();
}
