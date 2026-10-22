package com.bytedance.android.live.liveinteract.spatial;

import aj6.c;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.spatial.SpatialAudioStrategyManager;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.model.f0;
import com.bytedance.android.livesdk.model.t0;
import com.bytedance.android.livesdk.model.u0;
import com.bytedance.android.livesdk.model.v0;
import com.bytedance.android.livesdk.model.w0;
import com.bytedance.android.livesdk.model.x0;
import com.bytedance.android.livesdk.model.y0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import rj0.k;
import ti6.f;
import vm2.d;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f78621a = 0;

    static {
    }

    @JvmStatic
    public static final aj6.b a(int r100) {
        HashMap<Integer, v0> r101 = ((u0) d.F4.getValue(null, d.f555776a[289(0x121, float:4.05E-43)])).b();
        if (r101 == null) goto L8;
        v0 r102 = r101.get(Integer.valueOf(r100));
        if (r102 == null) goto L8;
        t0 r103 = r102.a();
        if (r103 == null) goto L8;
    L9:
        x0 r104 = r103.a();
        float r105 = 1.0f;
        if (r104 == null) goto L12;
        float r106 = r104.a();
    L13:
        x0 r107 = r103.a();
        float r108 = 0.0f;
        if (r107 == null) goto L16;
        float r109 = r107.b();
    L17:
        x0 r110 = r103.a();
        if (r110 == null) goto L20;
        float r111 = r110.c();
    L21:
        c r112 = new c(r106, r109, r111);
        x0 r113 = r103.b();
        if (r113 == null) goto L24;
        float r114 = r113.a();
    L25:
        x0 r115 = r103.b();
        if (r115 == null) goto L28;
        float r116 = r115.b();
    L29:
        x0 r117 = r103.b();
        if (r117 == null) goto L32;
        float r118 = r117.c();
    L33:
        c r119 = new c(r114, r116, r118);
        x0 r120 = r103.c();
        if (r120 == null) goto L36;
        float r121 = r120.a();
    L37:
        x0 r122 = r103.c();
        if (r122 == null) goto L40;
        r108 = r122.b();
    L40:
        x0 r123 = r103.c();
        if (r123 == null) goto L44;
        r105 = r123.c();
    L44:
        return new aj6.b(r112, r119, new c(r121, r108, r105));
    L36:
        r121 = 0.0f;
        goto L37
    L32:
        r118 = 0.0f;
        goto L33
    L28:
        r116 = 1.0f;
        goto L29
    L24:
        r114 = 0.0f;
        goto L25
    L20:
        r111 = 0.0f;
        goto L21
    L16:
        r109 = 0.0f;
        goto L17
    L12:
        r106 = 1.0f;
    L8:
        r103 = new t0(0);
        goto L9
    }

    @JvmStatic
    public static final y0 b(int r100) {
        HashMap<Integer, v0> r101 = ((u0) d.F4.getValue(null, d.f555776a[289(0x121, float:4.05E-43)])).b();
        if (r101 == null) goto L8;
        v0 r102 = r101.get(Integer.valueOf(r100));
        if (r102 == null) goto L8;
        y0 r103 = r102.b();
        if (r103 == null) goto L8;
    L10:
        return new y0(r103.a(), r103.b(), r103.c());
    L8:
        r103 = new y0(0, 0, 2000);
        goto L10
    }

    @JvmStatic
    public static final Object c(int r100) {
        ReadOnlyProperty r101 = d.C4;
        KProperty<?>[] r102 = d.f555776a;
        w0 r103 = (w0) r101.getValue(null, r102[286(0x11e, float:4.01E-43)]);
        if (r100 != 2) goto L5;
        com.bytedance.android.livesdk.model.d r104 = r103.b();
        if (r104 != null) goto L20;
        return null;
    L20:
        return r104.a();
    L5:
        if (r100 == 6) goto L13;
        f0 r105 = ((w0) r101.getValue(null, r102[286(0x11e, float:4.01E-43)])).a();
        if (r105 == null) goto L9;
        HashMap<Integer, HashMap<Integer, y0>> r106 = r105.a();
    L10:
        if (r106 != null) goto L12;
        return null;
    L12:
        return r106.get(Integer.valueOf(r100));
    L9:
        r106 = null;
        goto L10
    L13:
        com.bytedance.android.livesdk.model.d r107 = r103.c();
        if (r107 != null) goto L16;
        return null;
    L16:
        return r107.a();
    }

    @JvmStatic
    public static final String d(String r100) {
        k.f537953m2.getClass();
        k r101 = k.a.a();
        IBaseUser r102 = null;
        if (r101 == null) goto L8;
        i<ILinkPlayerInfoBridge> r103 = r101.getLinkUserInfoCenter();
        if (r103 == null) goto L8;
        IBaseUser r104 = r103.U4(r100);
        if (r104 == null) goto L8;
    L14:
        if (r104 != null) goto L18;
        i<ILinkPlayerInfoBridge> r105 = ((IKtvService) jc1.k.n(IKtvService.class)).getLinkUserInfoCenter();
        if (r105 == null) goto L19;
        r102 = r105.U4(r100);
    L19:
        if (r102 != null) goto L21;
        return "";
    L21:
        return r102.getIdString();
    L18:
        r102 = r104;
    L8:
        com.bytedance.android.live.liveinteract.voicechat.d.f80030s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r106 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r106 == null) goto L13;
        i<ILinkPlayerInfoBridge> r107 = r106.getLinkUserInfoCenter();
        if (r107 == null) goto L13;
        r104 = r107.U4(r100);
    L13:
        r104 = null;
        goto L14
    }

    @JvmStatic
    public static final boolean e(int r100) {
        String r101 = null;
        Double r102 = (Double) ((Map) d.E4.getValue(null, d.f555776a[288(0x120, float:4.04E-43)])).get(String.valueOf(r100));
        if (r102 == null) goto L5;
        Integer r103 = Integer.valueOf((int) r102.doubleValue());
    L7:
        if (r103 != null) goto L10;
    L27:
        if (r103 != null) goto L30;
    L32:
        if (r103 != null) goto L35;
    L37:
        return false;
    L35:
        if (r103.intValue() != 2) goto L37;
        return true;
    L30:
        if (r103.intValue() != 1) goto L32;
        return false;
    L10:
        if (r103.intValue() != 0) goto L27;
        m<IRoom> r104 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r104 == null) goto L16;
        IRoom r105 = r104.getValue();
        if (r105 == null) goto L16;
        Map<String, String> r106 = r105.getAnchorABMap();
    L17:
        com.bytedance.android.live.liveinteract.plantform.spatial.a r107 = SpatialAudioStrategyManager.f77420c.a().f77421a.get(Integer.valueOf(r100));
        if (r107 == null) goto L20;
        r101 = r107.c();
    L20:
        if (r106 == null) goto L38;
        String r108 = r106.get(r101);
        if (r108 != null) goto L24;
        return false;
    L24:
        if (CastIntegerProtector.parseInt(r108) != 1) goto L40;
        return true;
    L40:
        return false;
    L38:
        return false;
    L16:
        r106 = null;
        goto L17
    L5:
        r103 = null;
        goto L7
    }

    @JvmStatic
    public static final void f(f r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, EffectConfiguration.KEY_REGION);
        Intrinsics.checkNotNullParameter("BaseMultiLinkWindowManager", "tag");
        boolean r104 = false;
        if (e(r102) == true) goto L6;
        r100.f546178t = false;
        return;
    L6:
        String r105 = ((IKtvService) jc1.k.n(IKtvService.class)).getKtvRoomCurrentSingerIdStr();
        InteractiveSongContext r106 = InteractiveSongContext.Companion.getContext();
        if (r106 == null) goto L12;
        m<String> r107 = r106.getSingingGuestId();
        if (r107 == null) goto L12;
        String r108 = r107.getValue();
        if (r108 == null) goto L12;
    L13:
        b.a("BaseMultiLinkWindowManager", "setSpatialAudioInfoToRegionForMixStream singerId " + r105.toString() + " orderSingerId : " + r108);
        if ((!Intrinsics.areEqual(r105, d(r100.f546160b))) == true) goto L16;
    L18:
        r100.f546178t = r104;
        y0 r109 = SpatialAudioStrategyManager.f77420c.a().b(r102, r103, r101, null);
        b.a("BaseMultiLinkWindowManager", "mixStream position: " + r103 + " enable " + r104 + " posX == " + r109.a() + " posY == " + r109.b() + " posZ == " + r109.c());
        int r110 = r109.a();
        int r111 = r109.b();
        int r112 = r109.c();
        r100.f546174p = r110;
        r100.f546175q = r111;
        r100.f546176r = r112;
        return;
    L16:
        if ((!Intrinsics.areEqual(r108, d(r100.f546160b))) == false) goto L18;
        r104 = true;
    L12:
        r108 = "";
        goto L13
    }
}
