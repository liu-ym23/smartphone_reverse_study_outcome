package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class ECFloatPanelExpandedUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f152158a = null;

    static {
        f152158a = new MutableLiveData();
    }

    public static boolean a() {
        Boolean r100 = f152158a.getValue();
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.booleanValue();
    }

    public static void b(final boolean r100) {
        f152158a.setValue(Boolean.valueOf(r100));
        UtilityKotlinExtentionsKt.i(new ECFloatPanelExpandedUtils$updatePanelExpanded$1(r100));
    }
}
