package com.bytedance.android.live.network.gson;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;

/* JADX INFO: loaded from: classes46.dex */
public abstract class AbsJsonDeserializer<T> implements JsonDeserializer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f83809a;

    public AbsJsonDeserializer(Gson r100) {
        this.f83809a = r100;
    }
}
