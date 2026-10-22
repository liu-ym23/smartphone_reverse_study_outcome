package com.bytedance.android.live.core.utils;

import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IRoomType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IRoom f66111a = null;

    static {
        f66111a = (IRoom) vh7.f.c(IRoom.class);
    }

    public static final IAbilityCenter a(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$currentAbility");
        return (IAbilityCenter) r100.get("data_room_ablity_center", null);
    }

    public static final IAbilityCenter b(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$currentSessionAbility");
        return (IAbilityCenter) r100.get("data_session_ablity_center", null);
    }

    public static final boolean c(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isInPreview");
        return ((Boolean) r100.get("data_current_is_preview", Boolean.FALSE)).booleanValue();
    }

    public static /* synthetic */ boolean e(DataCenter r100) {
        return d(r100, false);
    }

    public static final boolean f(DataCenter r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = ((Boolean) r100.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r102 = (LiveMode) r100.get("data_live_mode", LiveMode.VIDEO);
        if (r101 == true) goto L8;
        return false;
    L8:
        if (r102 != LiveMode.AUDIO) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean g(DataCenter r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = ((Boolean) r100.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r102 = (LiveMode) r100.get("data_live_mode", LiveMode.VIDEO);
        if (r101 == true) goto L8;
        return false;
    L8:
        if (r102 != LiveMode.MEDIA) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean h(DataCenter r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = ((Boolean) r100.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r102 = (LiveMode) r100.get("data_live_mode", LiveMode.VIDEO);
        if (r101 == true) goto L8;
        return false;
    L8:
        if (r102 != LiveMode.SCREEN_RECORD) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean i(DataCenter r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = ((Boolean) r100.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r102 = LiveMode.VIDEO;
        LiveMode r103 = (LiveMode) r100.get("data_live_mode", r102);
        if (r101 == false) goto L10;
        if (r103 != r102) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public static final boolean j(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMiddlewareMediaRoom");
        Intrinsics.checkNotNullParameter(r100, "$this$roomType");
        IRoomType r101 = (IRoomType) r100.get("data_room", null);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isMediaRoom();
    }

    public static final boolean k(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMiddlewareMergeVSRoom");
        Intrinsics.checkNotNullParameter(r100, "$this$roomType");
        IRoomType r101 = (IRoomType) r100.get("data_room", null);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isMergeVSRoom();
    }

    public static final y m(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$middlewareCommon");
        IRoom r101 = (IRoom) r100.get("data_room");
        Object r102 = r100.get("data_is_portrait");
        if (r102 != null) goto L5;
        r102 = Boolean.TRUE;
    L5:
        boolean r103 = ((Boolean) r102).booleanValue();
        Object r104 = r100.get("data_is_anchor");
        if (r104 != null) goto L9;
        r104 = Boolean.FALSE;
    L9:
        return new y(r101, r103, ((Boolean) r104).booleanValue());
    }

    public static final IRoom n(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$middlewareRoom");
        return (IRoom) r100.get("data_room", f66111a);
    }

    public static final IRoom o(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$safeRoom");
        return (IRoom) r100.get("data_room", null);
    }

    public static final String p(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$uniqueId");
        return (String) r100.get("data_room_unique_id", null);
    }

    public static final boolean d(DataCenter r100, boolean r101) {
        if (r100 == null) goto L6;
        Boolean r102 = (Boolean) r100.get("data_is_anchor", Boolean.valueOf(r101));
        if (r102 == null) goto L6;
        return r102.booleanValue();
    L6:
        return false;
    }

    public static final boolean l(DataCenter r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMiddlewarePortrait");
        return ((Boolean) r100.get("data_is_portrait", Boolean.valueOf(r101))).booleanValue();
    }
}
