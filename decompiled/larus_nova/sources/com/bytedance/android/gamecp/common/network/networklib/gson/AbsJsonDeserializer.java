package com.bytedance.android.gamecp.common.network.networklib.gson;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;

/* JADX INFO: loaded from: classes44.dex */
public abstract class AbsJsonDeserializer<T> implements JsonDeserializer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f56700a;

    public AbsJsonDeserializer(Gson r100) {
        this.f56700a = r100;
    }
}
