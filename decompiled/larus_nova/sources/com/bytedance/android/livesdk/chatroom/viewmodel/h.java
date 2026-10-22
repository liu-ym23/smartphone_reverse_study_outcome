package com.bytedance.android.livesdk.chatroom.viewmodel;

import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h extends i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f114788g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f114789h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u1 f114790i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ClientUIInfo f114791j;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.i
    public final ClientUIInfo a() {
        return this.f114791j;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.i
    public final void b(ClientUIInfo r100) {
        this.f114791j = r100;
    }

    public h(int r110, int r111, List<Integer> r112, boolean r113, String r114, String r115, u1 r116, ClientUIInfo r117) {
        Intrinsics.checkNotNullParameter(r114, "rtcExtInfo");
        Intrinsics.checkNotNullParameter(r115, "liveCoreExtInfo");
        super(r110, r111, r112, r113, false, r117, 16);
        this.f114788g = r114;
        this.f114789h = r115;
        this.f114790i = r116;
        this.f114791j = r117;
    }
}
