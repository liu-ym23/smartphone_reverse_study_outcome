package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.IGroupLiveService;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes9.dex */
public final class x implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f128505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f128506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GiftReceiverRepoService f128507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.kmp.livesdk.gift.platform.service.d f128508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final yz0.g f128509e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    public final IBaseUser a() {
        cy0.e.f465759a.getClass();
        cy0.j r100 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r101 = com.bytedance.android.scope.m.b(r100).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r101);
        String r102 = ((com.bytedance.android.livesdk.revenue.service.user.a) ((com.bytedance.live.kmp.core.c) r101)).getCurrentUserId();
        String r103 = this.f128505a;
        if (r103.length() <= 0) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == true) goto L10;
        r103 = null;
    L10:
        if (r103 != null) goto L15;
        IGroupLiveService r105 = (IGroupLiveService) jc1.k.f(IGroupLiveService.class);
        if (r105 == null) goto L14;
        r103 = r105.getAnchorIdBeforeJump();
        goto L15
    L14:
        r103 = null;
    L15:
        if (r103 != null) goto L17;
        r103 = "";
    L17:
        Iterator<T> r106 = this.f128507c.k().f128476a.iterator();
    L19:
        if (r106.hasNext() == false) goto L28;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((IBaseUser) r107).getIdString(), r103) == true) goto L23;
    L25:
        boolean r108 = false;
    L26:
        if (r108 == false) goto L19;
    L29:
        IBaseUser r109 = (IBaseUser) r107;
        IGroupLiveService r110 = (IGroupLiveService) jc1.k.f(IGroupLiveService.class);
        if (r110 == null) goto L32;
        String r111 = r110.getAnchorIdBeforeJump();
    L34:
        if (Intrinsics.areEqual(r103, r111) == false) goto L36;
        this.f128506b.put("group_live_to_user_st", "throw");
    L36:
        if (r109 != null) goto L50;
        StringBuilder r112 = new StringBuilder("use default receiver anchor ");
        IBaseUser r113 = this.f128509e.getRoom().getOwnerKt();
        if (r113 != null) goto L40;
        r113 = (IBaseUser) vh7.f.c(IBaseUser.class);
    L40:
        r112.append(r113.getIdString());
        jy0.b.c("GiftRecommendReceiverService", r112.toString(), null, 4);
        this.f128506b.put("to_user_st", "to_anchor");
        IBaseUser r114 = this.f128509e.getRoom().getOwnerKt();
        if (r114 != null) goto L44;
        r114 = (IBaseUser) vh7.f.c(IBaseUser.class);
    L44:
        return r114;
    L50:
        return r109;
    L32:
        r111 = null;
        goto L34
    L23:
        if ((!Intrinsics.areEqual(r103, r102)) == false) goto L25;
        r108 = true;
        goto L26
    L28:
        r107 = null;
        goto L29
    L5:
        r104 = false;
        goto L7
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f128505a = "";
    }

    public x(GiftReceiverRepoService r100, com.bytedance.kmp.livesdk.gift.platform.service.d r101, yz0.g r102) {
        Intrinsics.checkNotNullParameter(r100, "giftReceiverRepoService");
        Intrinsics.checkNotNullParameter(r101, "giftLogService");
        Intrinsics.checkNotNullParameter(r102, "roomDataService");
        this.f128507c = r100;
        this.f128508d = r101;
        this.f128509e = r102;
        this.f128505a = "";
        this.f128506b = new LinkedHashMap();
    }

    public final void c(String r100, String r101, Map<String, String> r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "targetUid");
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.f128505a = r100;
        jy0.b.c("GiftRecommendReceiverService", "receiver add success, newReceiver: " + r100 + ", reason: " + r101, null, 4);
        this.f128508d.getClass();
        Intrinsics.checkNotNullParameter(r100, "toUserId");
        LinkedHashMap r104 = new LinkedHashMap();
        if (r102 == null) goto L5;
        r104.putAll(r102);
    L5:
        r104.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        IRoom r105 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        String r106 = "anchor";
        if (r105 == null) goto L13;
        String r107 = IRoomKtKt.getAnchorIdStr(r105);
        if (r107 == null) goto L13;
        if (Intrinsics.areEqual(r107, r100) == true) goto L13;
        r106 = "guest";
    L13:
        r104.put("to_user_type", r106);
        mz0.n r108 = new mz0.n();
        Map<String, String> r109 = r108.f516447a;
        Intrinsics.checkNotNullParameter(r109, "map");
        Intrinsics.checkNotNullParameter(r104, "map");
        r109.putAll(r104);
        mz0.m r110 = new mz0.m();
        r110.b(LogCommon.PAGE_SOURCE_LOG);
        r110.b(LogCommon.ROOM);
        ((ArrayList) r108.f516448b).addAll(r110.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r111 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r112 = com.bytedance.android.scope.m.b(r111).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r112);
        ((mz0.i) ((f80.a) r112)).w3("livesdk_gift_show_send_recommend", r108.f516447a, r108.f516448b);
        if (r103 == null) goto L17;
        this.f128506b.putAll(r103);
        return;
    }
}
