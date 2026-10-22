package com.obric.autoaction.presentation.doubao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: GsonUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f24894a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f24895b = null;

    private j() {
    }

    static {
        f24894a = new j();
        f24895b = new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(CharSequence.class, Type.class, "com.obric.aiagent.plugin"), new g()).registerTypeAdapterFactory((TypeAdapterFactory) ZeusTransformUtils.preCheckCast(new m(), TypeAdapterFactory.class, "com.obric.aiagent.plugin")).create();
    }

    public final Gson a() {
        return f24895b;
    }
}
