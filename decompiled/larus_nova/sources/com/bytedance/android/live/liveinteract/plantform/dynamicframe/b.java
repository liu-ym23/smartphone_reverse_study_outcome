package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public interface b {

    public static final class a {
        public static void a(String r100, JsonObject r101, com.bytedance.android.live.liveinteract.jsbridge.method.l0 r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "data");
            Intrinsics.checkNotNullParameter(r102, "updateCallback");
        }
    }

    Integer a();

    boolean c();

    JsonObject getLinkmicAreaFrameInfo();

    JsonObject getLinkmicSeatListInfo();

    int i();

    boolean k();

    void l();

    MessageHub p();

    IRoom r();

    void updateViewInLiveBg(String r100, JsonObject r101, ih0.h r102);
}
