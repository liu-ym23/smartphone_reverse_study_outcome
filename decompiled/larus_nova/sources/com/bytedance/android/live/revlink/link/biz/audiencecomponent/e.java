package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import com.bytedance.android.live.revenue.common.player.utils.LiveSeiUtil;
import io.reactivex.functions.Predicate;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f97762a = null;

    static {
        f97762a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        JSONObject r101 = (JSONObject) r100;
        Intrinsics.checkNotNullParameter(r101, "jsonObject");
        if (Intrinsics.areEqual(r101.optString("source"), "TTLiveSDK_Android") == false) goto L5;
    L12:
        return true;
    L5:
        if (Intrinsics.areEqual(r101.optString("source"), "TTLiveSDK_IOS") == true) goto L12;
        Lazy r102 = LiveSeiUtil.f90915a;
        if (LiveSeiUtil.b(r101.optString("source")) == true) goto L12;
        if (Intrinsics.areEqual(r101.optString("source"), "TTLiveSDK_Windows") == true) goto L12;
        return false;
    }
}
