package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class VSMediaUIConfigHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f114380a = null;

    static {
        f114380a = LazyKt.lazy(VSMediaUIConfigHelper$setting$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a(MiddlewareRoomContext r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.isVSRoom() != true) goto L9;
        return true;
    L9:
        if (r100.isMediaRoom() == true) goto L11;
        return false;
    L11:
        if (r100.isAnchor().getValue().booleanValue() == true) goto L23;
        com.bytedance.live.datacontext.n<z70.b> r101 = r100.getTemplateContext();
        if (r101 == null) goto L24;
        z70.b r102 = r101.getValue();
        if (r102 != null) goto L17;
        return false;
    L17:
        if (r102.k() == true) goto L19;
        return false;
    L19:
        if (((Boolean) f114380a.getValue()).booleanValue() == false) goto L27;
        return true;
    L27:
        return false;
    L24:
        return false;
    L23:
        return false;
    }

    @JvmStatic
    public static final boolean b(DataCenter r100) {
        MiddlewareRoomContext r101 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r100, 0, 2);
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.isVSRoom() == false) goto L9;
        return true;
    L9:
        if (r101.isMediaRoom() == true) goto L11;
        return false;
    L11:
        if (r101.isAnchor().getValue().booleanValue() == true) goto L23;
        com.bytedance.live.datacontext.n<z70.b> r102 = r101.getTemplateContext();
        if (r102 == null) goto L24;
        z70.b r103 = r102.getValue();
        if (r103 != null) goto L17;
        return false;
    L17:
        if (r103.k() == true) goto L19;
        return false;
    L19:
        if (((Boolean) f114380a.getValue()).booleanValue() == false) goto L27;
        return true;
    L27:
        return false;
    L24:
        return false;
    L23:
        return false;
    }

    @JvmStatic
    public static final boolean c(d90.d r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (d90.e.i(r100) == false) goto L9;
        return true;
    L9:
        if (d90.e.d(r100) == false) goto L18;
        z70.b r101 = r100.f483964a;
        if (r101 != null) goto L13;
        return false;
    L13:
        if (r101.k() == true) goto L15;
        return false;
    L15:
        if (((Boolean) f114380a.getValue()).booleanValue() == false) goto L21;
        return true;
    L21:
        return false;
    L18:
        return false;
    }
}
