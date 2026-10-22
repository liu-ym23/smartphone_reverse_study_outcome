package com.bytedance.ai.utils;

import android.content.Context;
import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.news.common.settings.api.SettingsData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f37626a = 0;

    static {
    }

    public static Map a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "settingsList");
        LinkedHashMap r101 = new LinkedHashMap();
        h2.a r102 = f2.b.f475099c;
        if (r102 == null) goto L27;
        Context r103 = r102.f483562a;
        if (r103 == null) goto L27;
        SettingsData r104 = SettingsManager.obtainSettingsFast(r103);
        if (r104 == null) goto L9;
        JSONObject r105 = r104.getAppSettings();
    L11:
        if (r105 != null) goto L13;
        g.f37637a.e("AppSettingsUtils", "appSetting is null");
        goto L27
    L13:
        Iterator r106 = r100.iterator();
    L15:
        if (r106.hasNext() == false) goto L27;
        String r107 = (String) r106.next();
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L19
        Object r109 = Result.m9449constructorimpl(r105.get(r107));     // Catch: Throwable -> L19
    L21:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L25;
        g.f37637a.e("AppSettingsUtils", String.valueOf(r110.getMessage()));
        r109 = null;
    L25:
        if (r109 == null) goto L15;
        r101.put(r107, r109);
    L19:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L9:
        r105 = null;
    L27:
        return r101;
    }
}
