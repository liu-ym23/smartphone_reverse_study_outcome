package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils;

import com.bytedance.android.live.base.model.morepanel.AreaPattern;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelDynamicControllerViewModel;
import com.bytedance.android.livesdk.config.da0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<Integer> f116808a = null;

    static {
        f116808a = CollectionsKt.arrayListOf(new Integer[]{1, 2});
    }

    @JvmStatic
    public static final boolean b() {
        Integer r100 = da0.f120016a.getValue();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 2) goto L8;
        return true;
    }

    @JvmStatic
    public static final boolean a(DataCenter r100) {
        MorePanelDynamicControllerViewModel.Companion.getClass();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.d r101 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.d) MorePanelDynamicControllerViewModel.Companion.a(r100);
        if (r100 != null) goto L5;
        return false;
    L5:
        if (z.e(r100, false) == false) goto L7;
        return false;
    L7:
        if (z.m(r100, true) == true) goto L9;
        return false;
    L9:
        if (f116808a.contains(da0.f120016a.getValue()) == false) goto L19;
        if (r101 == null) goto L12;
        AreaPattern r102 = (AreaPattern) r101.getServerPanelPattern();
    L13:
        if (r102 == null) goto L20;
        return true;
    L20:
        return false;
    L12:
        r102 = null;
        goto L13
    L19:
        return false;
    }
}
