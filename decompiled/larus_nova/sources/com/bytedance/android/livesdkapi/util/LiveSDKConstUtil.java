package com.bytedance.android.livesdkapi.util;

import com.bytedance.android.livesdk.paas.c;
import com.heytap.mcssdk.constant.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/util/LiveSDKConstUtil;", "", "()V", b.C, "", "getSdkVersion$annotations", "getSdkVersion", "()Ljava/lang/String;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSDKConstUtil {
    public static final LiveSDKConstUtil INSTANCE = null;

    private LiveSDKConstUtil() {
    }

    @JvmStatic
    public static /* synthetic */ void getSdkVersion$annotations() {
    }

    static {
        INSTANCE = new LiveSDKConstUtil();
    }

    public static final String getSdkVersion() {
        return String.valueOf(c.b() + 9);
    }
}
