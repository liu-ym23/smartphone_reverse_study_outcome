package com.bytedance.android.live.effect.utils;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.ss.android.ugc.effectmanager.common.listener.IJsonConverter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes45.dex */
public final class l implements IJsonConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Gson f68878a;

    public l() {
    }

    @Override // com.ss.android.ugc.effectmanager.common.listener.IJsonConverter
    public final <T> String convertObjToJson(T r100) throws Exception {
        if (this.f68878a != null) goto L6;
        this.f68878a = new Gson();
    L6:
        return GsonProtectorUtils.toJson(this.f68878a, r100);
    }

    @Override // com.ss.android.ugc.effectmanager.common.listener.IJsonConverter
    public final <T> T convertJsonToObj(InputStream r100, Class<T> r101) {
        if (this.f68878a != null) goto L5;
        this.f68878a = new Gson();
    L5:
        AutoCloseable r102 = (T) null;
        JsonReader r103 = new JsonReader(new InputStreamReader(r100));     // Catch: Throwable -> L14 JsonSyntaxException -> L16
        r102 = (T) this.f68878a.fromJson(r103, r101);
        r103.close();     // Catch: IOException -> L10
    L33:
    L21:
        return (T) r102;
    L12:
        e = e;
    L18:
        e.getMessage();     // Catch: Throwable -> L22
        if (r103 == null) goto L21;
        r103.close();     // Catch: IOException -> L10
    L22:
        th = th;
        r102 = (T) r103;
    L24:
        if (r102 != null) goto L36;
    L29:
        throw th;
    L36:
        r102.close();     // Catch: IOException -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L10:
        e = move-exception;
        e.printStackTrace();
    L16:
        e = e;
        r103 = null;
    L14:
        th = th;
        goto L24
    }
}
