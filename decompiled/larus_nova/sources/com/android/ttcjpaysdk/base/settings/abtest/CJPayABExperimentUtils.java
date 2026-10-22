package com.android.ttcjpaysdk.base.settings.abtest;

import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.bytedance.caijing.sdk.infra.base.api.abtest.ABTestService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import ve4.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J/\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f2\u0006\u0010\r\u001a\u0002H\n¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/abtest/CJPayABExperimentUtils;", "", "()V", "checkABSDKInstalled", "", "exposureWithKey", "", "key", "", "getABValueFromSettings", ExifInterface.GPS_DIRECTION_TRUE, "type", "Ljava/lang/Class;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayABExperimentUtils {
    public static final CJPayABExperimentUtils INSTANCE = null;

    static {
        INSTANCE = new CJPayABExperimentUtils();
    }

    private CJPayABExperimentUtils() {
    }

    public final boolean checkABSDKInstalled() {
        a.f554342a.getClass();
        ABTestService r100 = (ABTestService) a.a(ABTestService.class);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.checkABSDKInstalled();
    }

    @JvmStatic
    public static final void exposureWithKey(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        CJPayABExperimentKt.tryGetWithNoClassDefCatch(new AnonymousClass1(r100));
    }

    public final <T> T getABValueFromSettings(String r100, Class<T> r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        if (CJPaySettingsManager.getInstance().getLibraConfigFromSettings().has(r100) == true) goto L5;
        return r102;
    L5:
        if (Intrinsics.areEqual(r101, String.class) == false) goto L8;
        return (T) CJPaySettingsManager.getInstance().getLibraConfigFromSettings().optString(r100);
    L8:
        if (Intrinsics.areEqual(r101, Integer.TYPE) == false) goto L11;
        return (T) Integer.valueOf(CJPaySettingsManager.getInstance().getLibraConfigFromSettings().optInt(r100));
    L11:
        if (Intrinsics.areEqual(r101, Boolean.TYPE) == false) goto L14;
        return (T) Boolean.valueOf(CJPaySettingsManager.getInstance().getLibraConfigFromSettings().optBoolean(r100));
    L14:
        if (Intrinsics.areEqual(r101, CJPayObject.class) == true) goto L16;
        return r102;
    L16:
        return (T) CJPayJsonParser.fromJson(CJPaySettingsManager.getInstance().getLibraConfigFromSettings().optJSONObject(r100), r101);
    }
}
