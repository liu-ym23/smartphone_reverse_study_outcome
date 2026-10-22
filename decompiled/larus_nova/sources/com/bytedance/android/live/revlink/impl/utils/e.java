package com.bytedance.android.live.revlink.impl.utils;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.google.gson.JsonParseException;

/* JADX INFO: loaded from: classes47.dex */
public final class e {
    public static String b(Object r100) throws JsonParseException {
        if (r100 != null) goto L10;
        return "";
    L10:
        return GsonHelper.get().toJson(r100);
    L7:
        th = move-exception;
        throw new JsonParseException(th);
    }

    public static <T> T a(String r100, Class<T> r101) throws JsonParseException {
        if (TextUtils.isEmpty(r100) == false) goto L11;
        return null;
    L11:
        return (T) GsonHelper.get().fromJson(r100, r101);
    L8:
        th = move-exception;
        throw new JsonParseException(th);
    }
}
