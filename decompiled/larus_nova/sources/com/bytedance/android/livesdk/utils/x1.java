package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f159205a = 0;

    static {
    }

    @JvmStatic
    public static final Map<String, String> a(DataCenter r100) {
        if (r100 == null) goto L9;
        HashMap r101 = (HashMap) r100.get(ILiveRoomPlayFragmentConstant.DATA_LIVE_EFFECT_AD_LOG_EXTRA_MAP, new HashMap());
        if (r101 == null) goto L8;
        return r101;
    L8:
        return new HashMap();
    L9:
        return new HashMap();
    }
}
