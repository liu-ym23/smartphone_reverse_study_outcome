package com.bytedance.android.livesdk.gift.platform.core.manager;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.gift.GiftType;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.message.model.k6;
import com.bytedance.android.livesdk.message.model.o6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import zg1.x1;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftEffectManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f130729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference<DataCenter> f130730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f130731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f130732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f130733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CompositeDisposable f130734f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f130735g = null;

    static {
        f130729a = true;
        f130734f = new CompositeDisposable();
        f130735g = LazyKt.lazy(GiftEffectManager$giftEffectSwitchObserver$2.INSTANCE);
    }

    public static boolean a(IBaseUser r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        return !Intrinsics.areEqual(r100.getIdString(), ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).b().getIdString());
    }

    @JvmStatic
    public static final boolean b(Object r100, IRoom r101) {
        if (f130729a == false) goto L7;
        if (f130732d == true) goto L7;
    L54:
        return false;
    L7:
        if (f130733e == true) goto L54;
        if (r100 == null) goto L54;
        IBaseUser r102 = null;
        Integer r103 = null;
        if ((r100 instanceof o7) == false) goto L43;
        o7 r104 = (o7) r100;
        if (r104.isBannedInChat() == true) goto L56;
        if (a(r104.getFromUser()) == false) goto L56;
        if (r101 == null) goto L56;
        h1 r105 = r104.getGift();
        if (r105 == null) goto L21;
        r103 = Integer.valueOf(r105.getType());
    L21:
        if (GiftManagerKt.u(r103) != GiftType.NORMAL_GIFT) goto L56;
        if (r104.getRepeatEnd() != 1) goto L56;
        m0 r106 = r104.getCommonData();
        p02.a r107 = new p02.a();
        h1 r108 = r104.getGift();
        if (r108 == null) goto L56;
        NormalGiftMessage r109 = r107.a(r104, r108, r101.getOwner(), true);
        x1 r110 = new x1(r109.f129775e, r109.f129787q, r109.f129772b);
        r110.f571989k = r106;
        r110.f571990l = r104.isBannedInChat();
        r110.f571985g = r104.getGiftTimeStamp();
        r110.f571986h = r104.getReceiveTime();
        r110.f571991m = r104.getPublicAreaCommon();
        r110.f571987i = r104.getUseRoomMessage();
        if (r104.getClientGiftSource() == 1) goto L30;
    L32:
        h1 r111 = GiftManagerKt.l(r104.getGiftId());
    L33:
        if (r111 != null) goto L35;
    L36:
        r110.f571988j = r111;
        WeakReference<DataCenter> r112 = f130730b;
        if (r112 == null) goto L56;
        DataCenter r113 = r112.get();
        if (r113 == null) goto L56;
        r113.put("data_normal_gift_end_event", r110);
        goto L56
    L35:
        if (r111.getType() == 8) goto L56;
    L30:
        if (r104.getGift() == null) goto L32;
        r111 = r104.getGift();
    L56:
        return a(r104.getFromUser());
    L43:
        if ((r100 instanceof o6) == false) goto L49;
        o7 r114 = ((o6) r100).getGiftMessage();
        if (r114 == null) goto L57;
        r102 = r114.getFromUser();
    L57:
        return a(r102);
    L49:
        if ((r100 instanceof k6) == false) goto L52;
        return a(((k6) r100).getFromUser());
    L52:
        if ((r100 instanceof NormalGiftMessage) == false) goto L54;
        return a(((NormalGiftMessage) r100).f129775e);
    }
}
