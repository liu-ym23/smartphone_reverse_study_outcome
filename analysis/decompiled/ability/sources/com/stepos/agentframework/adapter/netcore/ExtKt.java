package com.stepos.agentframework.adapter.netcore;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0015\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\u0002H\u0006¢\u0006\u0002\u0010\u0007\u001a\u001a\u0010\b\u001a\u0002H\u0006\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\t\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\n"}, d2 = {"gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "toJson", "", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Object;)Ljava/lang/String;", "toAny", "(Ljava/lang/String;)Ljava/lang/Object;", "netcore_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExtKt {
    private static final Gson gson = new Gson();

    public static final Gson getGson() {
        return gson;
    }

    public static final <T> T toAny(String str) {
        k.f(str, "<this>");
        getGson();
        k.m();
        throw null;
    }

    public static final <T> String toJson(T t9) {
        String json = gson.toJson(t9);
        k.e(json, "toJson(...)");
        return json;
    }
}
