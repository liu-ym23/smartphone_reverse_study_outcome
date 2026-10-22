package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.utils.LiveEmptyObserverKt;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes9.dex */
public final class y implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f128510h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f128511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBaseUser f128512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.scope.j f128513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final yz0.g f128514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GiftReceiverRepoService f128515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a f128516f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.kmp.livesdk.gift.platform.service.d f128517g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public final IBaseUser f() {
        IBaseUser r100 = this.f128514d.getRoom().getOwnerKt();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return (IBaseUser) vh7.f.c(IBaseUser.class);
    }

    public final boolean g() {
        return x12.a.b(this.f128514d.getRoom());
    }

    public final IBaseUser i() {
        String r100 = this.f128511a;
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(r100, f().getIdString()) == true) goto L7;
        IBaseUser r102 = this.f128512b;
        if (r102 == null) goto L11;
        String r103 = r102.getIdString();
    L13:
        if (Intrinsics.areEqual(r100, r103) == true) goto L15;
        Iterator<T> r104 = this.f128515e.k().f128476a.iterator();
    L18:
        if (r104.hasNext() == false) goto L23;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((IBaseUser) r105).getIdString(), r100) == false) goto L18;
        r101 = r105;
    L23:
        return (IBaseUser) r101;
    L15:
        return this.f128512b;
    L11:
        r103 = null;
        goto L13
    L7:
        return f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (g() == false) goto L8;
        String r100 = f().getIdString();
        ay1.d.f16737k.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = (String) ((LruCache) cd6.b.f23407h.getValue(null, cd6.b.f23400a[3])).get(r100);
        if (r101 == null) goto L7;
        this.f128511a = r101;
    L7:
        jy0.b.d("GiftReceiver", "GiftSelectReceiverService initFromDiskCache isGroupLive = true, " + r100 + ' ' + this.f128511a);
        return;
    L8:
        String r102 = this.f128514d.getRoom().getIdStr();
        ay1.d.f16736j.getClass();
        Intrinsics.checkNotNullParameter(r102, "key");
        String r103 = (String) ((LruCache) cd6.b.f23405f.getValue(null, cd6.b.f23400a[2])).get(r102);
        if (r103 != null) goto L11;
    L14:
        jy0.b.d("GiftReceiver", "GiftSelectReceiverService initFromDiskCache isGroupLive = false, " + r102 + ' ' + this.f128511a);
        return;
    L11:
        if (Intrinsics.areEqual(f().getIdString(), r103) == false) goto L13;
        this.f128511a = f().getIdString();
    L13:
        this.f128511a = r103;
        goto L14
    }

    public final ReceiverType h(IBaseUser r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        if (this.f128515e.h(8) == false) goto L9;
        if (Intrinsics.areEqual(r100.getIdString(), f().getIdString()) == false) goto L7;
        ReceiverType r101 = ReceiverType.Anchor;
    L27:
        jy0.b.d("GiftReceiver", "GiftSelectReceiverService judgeReceiverType " + r100.getIdString() + ", " + r101);
        return r101;
    L7:
        r101 = ReceiverType.GroupLive;
        goto L27
    L9:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.x.e() == false) goto L12;
        r101 = ReceiverType.Anchor;
        goto L27
    L12:
        if (this.f128516f.j() == false) goto L15;
        r101 = ReceiverType.AllMic;
        goto L27
    L15:
        if (Intrinsics.areEqual(r100.getIdString(), f().getIdString()) == false) goto L18;
        r101 = ReceiverType.Anchor;
        goto L27
    L18:
        if (this.f128515e.K(r100, 4) == false) goto L21;
        r101 = ReceiverType.OtherAnchor;
        goto L27
    L21:
        if (this.f128515e.K(r100, 2) == false) goto L24;
        r101 = ReceiverType.Guest;
        goto L27
    L24:
        if (this.f128515e.K(r100, 1024) == false) goto L26;
        r101 = ReceiverType.Audience;
        goto L27
    L26:
        r101 = ReceiverType.Audience;
        goto L27
    }

    public static /* synthetic */ void d(y r100, IBaseUser r101) {
        r100.c(r101, ChangeReceiverSource.Other);
    }

    public final void a(String r110, ChangeReceiverSource r111) {
        Intrinsics.checkNotNullParameter(r110, "userId");
        Intrinsics.checkNotNullParameter(r111, "source");
        jy0.b.d("GiftReceiver", "GiftSelectReceiverService changeReceiverWithSyncList " + r110);
        if (this.f128515e.L(r110) == false) goto L5;
    L6:
        GiftReceiverRepoService r100 = this.f128515e;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "userId");
        Iterator<IBaseUser> r101 = r100.k().f128476a.iterator();
    L7:
        com.bytedance.android.scope.o r102 = null;
        if (r101.hasNext() == false) goto L13;
        IBaseUser r103 = r101.next();
        if (r103.getIdString().equals(r110) == false) goto L7;
    L16:
        if (r103 == null) goto L37;
        i12.d r104 = i12.m.f487958e2.a();
        if (r104 == null) goto L20;
        com.bytedance.android.scope.m.f163449e.getClass();
        r102 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r104).a(Reflection.getOrCreateKotlinClass(f.class));
    L20:
        f r105 = (f) r102;
        if (r105 == null) goto L26;
        IBaseUser r106 = r105.f128462a;
        if (r106 == null) goto L26;
        String r107 = r106.getIdString();
        if (r107 == null) goto L26;
    L27:
        String r108 = r107;
        boolean r109 = this.f128516f.j();
        c(r103, r111);
        GiftReceiverRepoService r112 = this.f128515e;
        r112.X(r103, r112.R(r103));
        zc6.a r113 = zc6.a.f571272a;
        com.bytedance.android.scope.j r114 = this.f128513c;
        int r115 = x12.c.a(r114);
        Intrinsics.checkNotNullParameter(zc6.a.f571272a, "$this$changeMode2String");
        Intrinsics.checkNotNullParameter(r114, "scope");
        String r116 = ((com.bytedance.android.livesdk.revenue.service.interact.d) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class)).changeMode2String(r115);
        com.bytedance.kmp.livesdk.gift.platform.service.d r117 = this.f128517g;
        String r118 = r103.getIdString();
        int r119 = this.f128515e.k().f128476a.size();
        IRoom r120 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        List<IBaseUser> r121 = this.f128515e.k().f128476a;
        ReceiverType r122 = this.f128515e.R(r103);
        boolean r123 = true;
        if (r109 == true) goto L31;
        r123 = !Intrinsics.areEqual(r108, r103.getIdString());
    L31:
        r117.a(r108, r118, r109, r119, r120, r116, r121, r122, r123, r111, null);
        return;
    L26:
        r107 = "";
        goto L27
    L37:
        return;
    L13:
        if (r110.equals(r100.j().getIdString()) == false) goto L15;
        r103 = r100.j();
        goto L16
    L15:
        r103 = null;
        goto L16
    L5:
        if (r110.equals(f().getIdString()) == true) goto L6;
    }

    public final void c(IBaseUser r100, ChangeReceiverSource r101) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r101, "changeSource");
        jy0.b.d("GiftReceiver", "GiftSelectReceiverService changeSelectReceiver " + r100.getIdString());
        this.f128511a = r100.getIdString();
        this.f128516f.f();
        com.bytedance.android.scope.o r102 = null;
        if (this.f128515e.R(r100) != ReceiverType.Audience) goto L5;
    L8:
        this.f128512b = r100;
    L9:
        i12.d r103 = i12.m.f487958e2.a();
        if (r103 == null) goto L12;
        com.bytedance.android.scope.m.f163449e.getClass();
        r102 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r103).a(Reflection.getOrCreateKotlinClass(f.class));
    L12:
        f r104 = (f) r102;
        if (r104 == null) goto L15;
        r104.c(r100, r101);
    L15:
        final String r105 = this.f128514d.getRoom().getIdStr();
        IRoom r106 = (IRoom) this.f128514d.getRoom();
        if (r106 == null) goto L19;
        final String r107 = IRoomKt_androidKt.getAnchorId(r106);
        if (r107 == null) goto L19;
    L20:
        final String r108 = this.f128511a;
        if (r108 == null) goto L24;
        int r109 = com.bytedance.revenue.platform.api.core.rx.q.f267523a;
        final Function0<Unit> r110 = new GiftSelectReceiverService$writeToCache$$inlined$let$lambda$1(r108, this, r105, r107);
        Single r111 = Single.fromCallable(new z(r110));
        int r112 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        r111.subscribeOn(Schedulers.io()).subscribe(new LiveEmptyObserverKt());
        return;
    L24:
        return;
    L19:
        r107 = "";
        goto L20
    L5:
        if (this.f128515e.J(r100.getIdString()) == true) goto L8;
        this.f128512b = null;
        goto L9
    }

    public y(com.bytedance.android.scope.j r100, yz0.g r101, GiftReceiverRepoService r102, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r103, com.bytedance.kmp.livesdk.gift.platform.service.d r104) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        Intrinsics.checkNotNullParameter(r102, "giftReceiverRepoService");
        Intrinsics.checkNotNullParameter(r103, "allMicService");
        Intrinsics.checkNotNullParameter(r104, "logService");
        this.f128513c = r100;
        this.f128514d = r101;
        this.f128515e = r102;
        this.f128516f = r103;
        this.f128517g = r104;
    }
}
