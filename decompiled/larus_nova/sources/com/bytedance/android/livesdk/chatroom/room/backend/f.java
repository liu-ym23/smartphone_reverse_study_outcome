package com.bytedance.android.livesdk.chatroom.room.backend;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements is2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f110825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f110826b;

    @Override // is2.b
    public final /* synthetic */ boolean a() {
        return false;
    }

    @Override // is2.b
    public final /* synthetic */ boolean c() {
        return false;
    }

    @Override // is2.b
    public final void d() {
    }

    @Override // is2.b
    public final boolean enable() {
        return true;
    }

    @Override // is2.b
    public final /* synthetic */ boolean f() {
        return false;
    }

    @Override // is2.b
    public final Class<?> getModelClass() {
        return com.bytedance.android.livesdk.interactivity.api.publicscreen.model.b.class;
    }

    @Override // is2.b
    public final String getPath() {
        return this.f110825a;
    }

    public f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "requestParam");
        this.f110826b = r100;
        this.f110825a = ILiveRoomPlayFragmentConstant.EXTRA_MENTION_CHAT_PARAM;
    }

    @Override // is2.b
    public final JSONObject g(Bundle r100, is2.a r101) {
        if (r100 == null) goto L4;
        long r102 = r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_BACKEND_ROOMID);
    L5:
        JSONObject r103 = new JSONObject();
        BaseMonitor.add(r103, "room_id", r102);
        BaseMonitor.add(r103, "biz_data_type", 2);
        BaseMonitor.add(r103, "open", true);
        BaseMonitor.add(r103, ILiveRoomPlayFragmentConstant.EXTRA_MENTION_CHAT_PARAM, this.f110826b);
        return r103;
    L4:
        r102 = 0;
        goto L5
    }
}
