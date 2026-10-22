package com.obric.autoaction.app.launcherpage.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: GsonUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f24472a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f24473b = null;

    private d() {
    }

    static {
        f24472a = new d();
        f24473b = new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(CharSequence.class, Type.class, "com.obric.aiagent.plugin"), new b()).registerTypeAdapterFactory((TypeAdapterFactory) ZeusTransformUtils.preCheckCast(new r(), TypeAdapterFactory.class, "com.obric.aiagent.plugin")).create();
    }

    public final Gson a() {
        return f24473b;
    }
}
