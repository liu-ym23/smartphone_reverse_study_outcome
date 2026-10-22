package com.android.ttcjpaysdk.kmp.base.settings;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\"\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\b¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/settings/CJSettings;", "", "<init>", "()V", "getConfig", "", "key", "getConfigEnhanced", "", "defaultValue", "useCache", "getABStringValue", "isExposure", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJSettings {
    public static final int $stable = 0;
    public static final CJSettings INSTANCE = null;

    static {
        INSTANCE = new CJSettings();
    }

    private CJSettings() {
    }

    public final String getConfig(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        b r101 = c.f528682a;
        IKmpCJSettingService r102 = (IKmpCJSettingService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJSettingService.class));
        if (r102 == null) goto L6;
        String r103 = r102.getConfig(r100);
        if (r103 == null) goto L6;
        return r103;
    L6:
        return "";
    }

    public final String getABStringValue(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        b r103 = c.f528682a;
        IKmpCJSettingService r104 = (IKmpCJSettingService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJSettingService.class));
        if (r104 == null) goto L9;
        String r105 = r104.getABStringValue(r100, r101, r102);
        if (r105 != null) goto L8;
        return r101;
    L8:
        return r105;
    L9:
        return r101;
    }

    public final boolean getConfigEnhanced(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        b r103 = c.f528682a;
        IKmpCJSettingService r104 = (IKmpCJSettingService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJSettingService.class));
        if (r104 != null) goto L5;
        return r101;
    L5:
        return r104.getConfigEnhanced(r100, r101, r102);
    }

    public static /* synthetic */ String getABStringValue$default(CJSettings r100, String r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = true;
    L9:
        return r100.getABStringValue(r101, r102, r103);
    }
}
