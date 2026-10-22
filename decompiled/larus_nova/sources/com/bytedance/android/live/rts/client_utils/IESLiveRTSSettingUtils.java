package com.bytedance.android.live.rts.client_utils;

import com.bytedance.android.live.core.setting.SettingUtil;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class IESLiveRTSSettingUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f100460a = 0;

    static {
    }

    public static void a(a r110, Function1 r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "completion");
        String r100 = r110.f100461a;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L20;
        String r103 = r110.f100463c;
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == false) goto L20;
        r111.invoke(new LinkedHashMap());
        return;
    L13:
        if (r103.length() == 0) goto L16;
        r104 = false;
    L20:
        IESLiveRTSSettingUtils$getClientSetting$1 r105 = IESLiveRTSSettingUtils$getClientSetting$1.INSTANCE;
        IESLiveRTSSettingUtils$getClientSetting$2 r106 = IESLiveRTSSettingUtils$getClientSetting$2.INSTANCE;
        String r107 = r110.f100461a;
        String r112 = r110.f100463c;
        Object r113 = SettingUtil.getRawValue("key_ttlive_sdk_setting", r107);
        if (r112 != null) goto L23;
    L26:
        boolean r108 = true;
    L28:
        if (r108 == true) goto L30;
        r113 = r105.invoke(r113, CollectionsKt.toList(StringsKt.split$default(r112, new char[]{'.'}, false, 0, 6, null)), 0);
    L30:
        if (r112 != null) goto L32;
    L35:
        if (r101 == false) goto L38;
        if (r107 != null) goto L39;
        r107 = "";
    L39:
        r111.invoke(MapsKt.toMutableMap(r106.invoke2(r107, r113)));
        return;
    L38:
        r107 = r107 + '.' + r112;
        goto L39
    L32:
        if (r112.length() == 0) goto L35;
        r101 = false;
        goto L35
    L23:
        if (r112.length() == 0) goto L26;
        r108 = false;
        goto L28
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
