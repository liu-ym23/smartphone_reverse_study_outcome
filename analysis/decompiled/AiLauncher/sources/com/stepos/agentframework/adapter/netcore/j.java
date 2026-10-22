package com.stepos.agentframework.adapter.netcore;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000*\u00028\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;)Ljava/lang/String;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", Const.INTENT_KEY_APIKEY, "()Lcom/google/gson/Gson;", "protocol_netcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class j {
    private static final Gson gson = new Gson();

    public static final Gson a() {
        return gson;
    }

    public static final <T> String b(T t10) {
        String json = gson.toJson(t10);
        kotlin.jvm.internal.p.h(json, "toJson(...)");
        return json;
    }
}
