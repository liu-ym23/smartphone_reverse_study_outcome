package com.bytedance.android.livesdkapi.feed;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.common.utility.collection.CollectionUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J*\u0010\u000b\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/LiveDrawerUrlHelper;", "", "()V", "getSourceKey", "", "enterFromMerge", "enterMethod", "sourceList", "", "bundle", "Landroid/os/Bundle;", "isParamInList", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDrawerUrlHelper {
    public static final LiveDrawerUrlHelper INSTANCE = null;

    private LiveDrawerUrlHelper() {
    }

    static {
        INSTANCE = new LiveDrawerUrlHelper();
    }

    @JvmStatic
    public static final boolean isParamInList(String r100, String r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r102, "sourceList");
        return !TextUtils.isEmpty(getSourceKey$default(r100, r101, r102, null, 8, null));
    }

    @JvmStatic
    public static final String getSourceKey(String r110, String r111, List<String> r112, Bundle r113) {
        Intrinsics.checkNotNullParameter(r112, "sourceList");
        if (TextUtils.isEmpty(r110) == false) goto L5;
    L38:
        return "";
    L5:
        if (TextUtils.isEmpty(r111) == true) goto L38;
        if (CollectionUtils.isEmpty(r112) == true) goto L38;
        if (r113 == null) goto L12;
        String r114 = r113.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_FEED_SOURCE_KEY, null);
    L14:
        if (TextUtils.isEmpty(r114) == true) goto L19;
        if (r114 != null) goto L18;
        return "";
    L18:
        return r114;
    L19:
        String r115 = r110 + "_" + r111;
        Iterator<String> r116 = r112.iterator();
    L21:
        if (r116.hasNext() == false) goto L38;
        String r117 = r116.next();
        if (Intrinsics.areEqual(r117, "*") == true) goto L24;
        if (Intrinsics.areEqual(r115, r117) == true) goto L27;
        if (StringsKt.startsWith$default(r117, "*", false, 2, null) == false) goto L34;
        if (StringsKt.endsWith$default(r115, StringsKt.replace$default(r117, "*", "", false, 4, null), false, 2, null) == false) goto L34;
        return r117;
    L34:
        if (StringsKt.endsWith$default(r117, "*", false, 2, null) == false) goto L21;
        if (StringsKt.startsWith$default(r115, StringsKt.replace$default(r117, "*", "", false, 4, null), false, 2, null) == false) goto L21;
        return r117;
    L27:
        return r117;
    L24:
        return "*";
    L12:
        r114 = null;
        goto L14
    }

    public static /* synthetic */ String getSourceKey$default(String r100, String r101, List r102, Bundle r103, int r104, Object r105) {
        if ((r104 & 8) == 0) goto L6;
        r103 = null;
    L6:
        return getSourceKey(r100, r101, r102, r103);
    }
}
