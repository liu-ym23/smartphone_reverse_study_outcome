package com.bytedance.android.livesdk.chatroom.end;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.strategy.api.IStrategyService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, String> f106029a;

    static {
        f106029a = new LinkedHashMap();
    }

    @JvmStatic
    public static final boolean a(boolean r100) {
        IStrategyService r101 = (IStrategyService) jc1.k.f(IStrategyService.class);
        if (r101 == null) goto L8;
        LiveData r102 = IStrategyService.a.a(r101, "end_page_strategy", new LinkedHashMap(), r100, 8);
        if (r102 == null) goto L8;
        Map<String, String> r103 = (Map) r102.getValue();
        if (r103 == null) goto L8;
    L9:
        f106029a = r103;
        if (r103.isEmpty() == true) goto L15;
        String r104 = f106029a.get("enable");
        if (r104 == null) goto L15;
        return Boolean.parseBoolean(r104);
    L15:
        return false;
    L8:
        r103 = new LinkedHashMap();
        goto L9
    }
}
