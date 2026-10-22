package com.bytedance.android.livesdk.livecommerce.utils;

import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class h implements com.bytedance.android.ec.opt.asynctask.w {
    public h() {
    }

    @Override // com.bytedance.android.ec.opt.asynctask.w
    public final com.bytedance.android.ec.opt.asynctask.k r() {
        com.bytedance.android.ec.opt.asynctask.r r100 = new com.bytedance.android.ec.opt.asynctask.r();
        r100.f48047b = true;
        return r100.f48051f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((LinkedHashMap) ECCartMonitor.f153030c).clear();
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L24
        Integer r101 = (Integer) EComABUtils.getLiveSettingValue(EComABUtils.SETTING_EC_LIVE_CART_LOG_REPORT, 0);     // Catch: Throwable -> L24
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L22;
        List r103 = com.bytedance.android.ec.core.utils.u0.e((String) EComABUtils.getLiveSettingValue(EComABUtils.SETTING_EC_LIVE_CART_LOG_RULE, ""), JsonObject[].class);     // Catch: Throwable -> L24
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));     // Catch: Throwable -> L24
        Iterator r105 = r103.iterator();     // Catch: Throwable -> L24
    L13:
        if (r105.hasNext() == false) goto L22;
        JsonObject r106 = (JsonObject) r105.next();     // Catch: Throwable -> L24
        LogRule.Companion.getClass();     // Catch: Throwable -> L24
        LogRule r107 = LogRule.a.a(r106);     // Catch: Throwable -> L24
        if (r107 == null) goto L20;
        Map<String, List<LogRule>> r108 = ECCartMonitor.f153030c;     // Catch: Throwable -> L24
        List r109 = (List) ((LinkedHashMap) r108).get(r107.getIntrinsicOn());     // Catch: Throwable -> L24
        if (r109 == null) goto L19;
        Object r110 = Boolean.valueOf(r109.add(r107));     // Catch: Throwable -> L24
    L21:
        r104.add(r110);     // Catch: Throwable -> L24
        goto L13
    L19:
        r108.put(r107.getIntrinsicOn(), CollectionsKt.mutableListOf(new LogRule[]{r107}));     // Catch: Throwable -> L24
        r110 = Unit.INSTANCE;     // Catch: Throwable -> L24
        goto L21
    L20:
        r110 = null;
    L22:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        ECCartMonitor.f153028a = true ^ ECCartMonitor.f153030c.isEmpty();
        return;
    L7:
        if (r101.intValue() != 1) goto L9;
        r102 = true;
    L24:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }
}
