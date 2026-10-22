package com.bytedance.android.livesdk.chatroom.room.core.task;

import com.bytedance.android.livesdk.chatroom.room.backend.LiveRoomBackendUtils;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.model.BackendGeneratedData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends is2.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoomBaseSession f111012b;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.livesdk.chatroom.detail.a.InterfaceC1585a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f111013a;

        public b(c r100) {
            this.f111013a = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.detail.a.InterfaceC1585a
        public final void a(BackendGeneratedData r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            this.f111013a.f111012b.setBackendRoomContext(r100);
        }
    }

    static {
    }

    public final void b() {
        RoomBaseSession r100 = this.f111012b;
        com.bytedance.android.livesdk.chatroom.detail.b r101 = new com.bytedance.android.livesdk.chatroom.detail.b(r100.getRoomId(), this.f111012b.getEnterInfo());
        r101.f105618a = new b(this);
        Unit r102 = Unit.INSTANCE;
        r100.setBackendRoomController(r101);
        com.bytedance.android.livesdk.chatroom.detail.a r103 = this.f111012b.getBackendRoomController();
        if (r103 == null) goto L6;
        r103.d();
        return;
    }

    public c(RoomBaseSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f111012b = r100;
    }

    @Override // is2.h
    public final void a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        com.bytedance.android.livesdk.chatroom.detail.a r101 = this.f111012b.getBackendRoomController();
        if (r101 == null) goto L5;
        r101.e();
    L5:
        Long r102 = null;
        this.f111012b.setBackendRoomController(null);
        com.bytedance.android.livesdk.chatroom.detail.a r103 = this.f111012b.getPreBackendRoomController();
        if (r103 == null) goto L8;
        r102 = Long.valueOf(r103.b());
    L8:
        long r104 = this.f111012b.getRoomId();
        if (r102 != null) goto L12;
    L33:
        b();
        return;
    L12:
        if (r102.longValue() != r104) goto L33;
        MultiRoomConfig r105 = MultiRoomConfig.INSTANCE;
        if (r105.enableBackendOpt() == false) goto L20;
        long r106 = LiveRoomBackendUtils.f110796d.a(r102.longValue());
        if (r106 > 0) goto L18;
    L19:
        boolean r107 = true;
    L21:
        if (r107 == true) goto L33;
        com.bytedance.android.livesdk.chatroom.detail.a r108 = this.f111012b.getPreBackendRoomController();
        if (r108 == null) goto L38;
        BackendGeneratedData r109 = r108.a();
        this.f111012b.setBackendRoomController(r108);
        if (r108.c() == true) goto L30;
        if (r109 == null) goto L30;
        this.f111012b.setBackendRoomContext(r109);
        return;
    L30:
        if (r108.c() == false) goto L32;
        r108.f105618a = new d(this);
        return;
    L32:
        b();
        return;
    L38:
        return;
    L18:
        if ((System.currentTimeMillis() - r106) > r105.getBackendDataExpiredTime()) goto L19;
    L20:
        r107 = false;
        goto L21
    }
}
