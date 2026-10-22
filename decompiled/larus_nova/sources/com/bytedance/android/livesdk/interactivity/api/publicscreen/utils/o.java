package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f133646a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(DataCenter r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (b(r100) != true) goto L6;
        return true;
    }

    public static boolean b(DataCenter r100) {
        if (r100 == null) goto L17;
        IRoom r101 = a0.f66111a;
        Intrinsics.checkNotNullParameter(r100, "$this$isMiddlewareAudienceMediaOrVsRoom");
        if (a0.d(r100, false) == false) goto L7;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L14;
        return false;
    L14:
        if (a0.d(r100, false) == true) goto L19;
        return true;
    L19:
        return false;
    L7:
        if (a0.k(r100) == false) goto L9;
    L10:
        r102 = true;
        goto L12
    L9:
        if (a0.j(r100) == false) goto L11;
    L17:
        return false;
    }
}
