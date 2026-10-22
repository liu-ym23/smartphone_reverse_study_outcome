package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import android.text.TextUtils;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class g<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f138426a = null;

    static {
        f138426a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        JSONObject r101 = (JSONObject) r100;
        Intrinsics.checkNotNullParameter(r101, "jsonObject");
        if (TextUtils.equals(r101.optString("source"), "TTLiveSDK_Android") == false) goto L5;
    L12:
        return true;
    L5:
        if (TextUtils.equals(r101.optString("source"), "TTLiveSDK_IOS") == true) goto L12;
        LiveSeiUtil r102 = LiveSeiUtil.f71508i;
        String r103 = r101.optString("source");
        r102.getClass();
        if (LiveSeiUtil.d(r103) == true) goto L12;
        if (TextUtils.equals(r101.optString("source"), "TTLiveSDK_Windows") == true) goto L12;
        return false;
    }
}
