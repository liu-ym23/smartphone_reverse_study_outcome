package com.bytedance.android.live.room.api.messagewindow.monitor;

import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.List;
import jc1.k;

/* JADX INFO: loaded from: classes47.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IRoom f99018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f99019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f99020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f99021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<e> f99022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f99023f;

    public h() {
        IRoomContextService r100 = (IRoomContextService) k.f(IRoomContextService.class);
        String r101 = null;
        if (r100 == null) goto L9;
        o r102 = IRoomContextService.a.a(r100, null, 0, 3);
        if (r102 == null) goto L9;
        m<IRoom> r103 = r102.getRoom();
        if (r103 == null) goto L9;
        IRoom r104 = r103.getValue();
    L10:
        this.f99018a = r104;
        String r105 = "0L";
        if (r104 == null) goto L14;
        String r106 = String.valueOf(r104.getRoomId());
        if (r106 == null) goto L14;
    L15:
        this.f99019b = r106;
        if (r104 == null) goto L21;
        String r107 = r104.getOwnerUserIdString();
        if (r107 == null) goto L21;
        r105 = r107;
    L21:
        this.f99020c = r105;
        IMiddlewareUserService r108 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r108 == null) goto L26;
        com.bytedance.android.livesdk.user.e r109 = r108.user();
        if (r109 == null) goto L26;
        r101 = r109.n();
    L26:
        this.f99021d = r101;
        this.f99022e = new ArrayList();
        this.f99023f = 100;
        return;
    L14:
        r106 = "0L";
    L9:
        r104 = null;
        goto L10
    }
}
