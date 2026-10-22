package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.e6;
import com.bytedance.android.livesdk.f6;
import com.bytedance.android.livesdk.g6;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealTimeChorusBusinessContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "Lfd2/s;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusBusinessContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final int NEW_VERSION = 1;
    public static final int OLD_VERSION = 0;
    public static final String REAL_TIME_CHORUS_ENABLE_KEY = "linkmic_real_time_chorus";
    public static final String TAG = "RealTimeChorusBusinessContext";
    private final com.bytedance.live.datacontext.p service$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean h() {
            if (g6.f125383a.getValue().getChorusSpatialEnable() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @JvmStatic
        public static boolean i() {
            Integer r100 = f6.f123404a.getValue();
            if (r100 != null) goto L6;
        L21:
            if (r100 != null) goto L24;
        L26:
            if (r100 != null) goto L29;
            return false;
        L29:
            if (r100.intValue() != 2) goto L33;
        L30:
            return true;
        L33:
            return false;
        L24:
            if (r100.intValue() != 1) goto L26;
            return false;
        L6:
            if (r100.intValue() != 0) goto L21;
            com.bytedance.android.livesdk.chatroom.o r101 = o3.f();
            if (r101 == null) goto L18;
            com.bytedance.live.datacontext.m<IRoom> r102 = r101.getRoom();
            if (r102 == null) goto L18;
            IRoom r103 = r102.getValue();
            if (r103 == null) goto L18;
            Map<String, String> r104 = r103.getAnchorABMap();
            if (r104 == null) goto L18;
            String r105 = r104.get("lead_real_time_chorus");
            if (r105 == null) goto L18;
            int r106 = CastIntegerProtector.parseInt(r105);
        L19:
            if (r106 > 1) goto L30;
            return false;
        L18:
            r106 = 0;
            goto L19
        }

        @JvmStatic
        public final RealTimeChorusBusinessContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(RealTimeChorusBusinessContext.class);
            if ((r100 instanceof RealTimeChorusBusinessContext) == true) goto L6;
            r100 = null;
        L6:
            return (RealTimeChorusBusinessContext) r100;
        }

        @JvmStatic
        public static boolean g() {
            com.bytedance.android.livesdk.chatroom.u r100 = o3.d();
            Integer r101 = null;
            if (r100 == null) goto L11;
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r102 = r100.s();
            if (r102 == null) goto L11;
            com.bytedance.android.livesdk.chatroom.viewmodel.f r103 = r102.getValue();
            if (r103 == null) goto L11;
            com.bytedance.android.livesdk.chatroom.viewmodel.i r104 = r103.t();
            if (r104 == null) goto L11;
            Integer r105 = Integer.valueOf(r104.f114792a);
        L12:
            com.bytedance.android.livesdk.chatroom.u r106 = o3.d();
            if (r106 == null) goto L21;
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r107 = r106.s();
            if (r107 == null) goto L21;
            com.bytedance.android.livesdk.chatroom.viewmodel.f r108 = r107.getValue();
            if (r108 == null) goto L21;
            com.bytedance.android.livesdk.chatroom.viewmodel.i r109 = r108.t();
            if (r109 == null) goto L21;
            r101 = Integer.valueOf(r109.f114793b);
        L21:
            if (r105 != null) goto L24;
        L30:
            return false;
        L24:
            if (r105.intValue() != 9) goto L30;
            if (r101 == null) goto L30;
            if (r101.intValue() != 61) goto L30;
            return true;
        L11:
            r105 = null;
            goto L12
        }

        @JvmStatic
        public final int a() {
            RealTimeChorusBusinessContext r100 = getContext();
            if (r100 == null) goto L9;
            com.bytedance.live.datacontext.j<fd2.s> r101 = r100.m8262getService();
            if (r101 == null) goto L9;
            fd2.s r102 = r101.getValue();
            if (r102 == null) goto L9;
            return r102.sb();
        L9:
            return 0;
        }

        @JvmStatic
        public final int b() {
            RealTimeChorusBusinessContext r100 = getContext();
            if (r100 == null) goto L9;
            com.bytedance.live.datacontext.j<fd2.s> r101 = r100.m8262getService();
            if (r101 == null) goto L9;
            fd2.s r102 = r101.getValue();
            if (r102 == null) goto L9;
            return r102.i0();
        L9:
            return 0;
        }

        @JvmStatic
        public final fd2.s c() {
            RealTimeChorusBusinessContext r100 = getContext();
            if (r100 == null) goto L7;
            com.bytedance.live.datacontext.j<fd2.s> r101 = r100.m8262getService();
            if (r101 == null) goto L7;
            return r101.getValue();
        L7:
            return null;
        }

        @JvmStatic
        public final int d() {
            fd2.s r100 = c();
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.f8();
        }

        @JvmStatic
        public final boolean e() {
            RealTimeChorusBusinessContext r100 = getContext();
            if (r100 == null) goto L9;
            com.bytedance.live.datacontext.j<fd2.s> r101 = r100.m8262getService();
            if (r101 == null) goto L9;
            fd2.s r102 = r101.getValue();
            if (r102 == null) goto L9;
            return r102.ko();
        L9:
            return false;
        }

        @JvmStatic
        public final boolean f() {
            if (j() == true) goto L5;
        L9:
            return false;
        L5:
            if (d() != 3) goto L7;
        L8:
            return true;
        L7:
            if (d() != 4) goto L9;
            goto L8
        }

        @JvmStatic
        public final boolean j() {
            if (b() != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @JvmStatic
        public final void m(LifecycleOwner r100, Observer<Integer> r101) {
            Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r101, "observer");
            RealTimeChorusBusinessContext r102 = getContext();
            if (r102 == null) goto L10;
            com.bytedance.live.datacontext.j<fd2.s> r103 = r102.m8262getService();
            if (r103 == null) goto L11;
            fd2.s r104 = r103.getValue();
            if (r104 == null) goto L12;
            r104.pn(r100, r101);
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public final void n(LifecycleOwner r100, Observer<Boolean> r101) {
            Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r101, "observer");
            RealTimeChorusBusinessContext r102 = getContext();
            if (r102 == null) goto L10;
            com.bytedance.live.datacontext.j<fd2.s> r103 = r102.m8262getService();
            if (r103 == null) goto L11;
            fd2.s r104 = r103.getValue();
            if (r104 == null) goto L12;
            r104.kj(r100, r101);
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public final void o(LifecycleOwner r100, Observer<Integer> r101) {
            Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r101, "observer");
            RealTimeChorusBusinessContext r102 = getContext();
            if (r102 == null) goto L10;
            com.bytedance.live.datacontext.j<fd2.s> r103 = r102.m8262getService();
            if (r103 == null) goto L11;
            fd2.s r104 = r103.getValue();
            if (r104 == null) goto L12;
            r104.cp(r100, r101);
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public final void k(MusicPanel r100, Function1<Object, Unit> r101, Function1<? super Throwable, Unit> r102) {
            Intrinsics.checkNotNullParameter(r100, "music");
            Intrinsics.checkNotNullParameter(r101, "successCallback");
            Intrinsics.checkNotNullParameter(r102, "failCallback");
            RealTimeChorusBusinessContext r103 = getContext();
            if (r103 == null) goto L10;
            com.bytedance.live.datacontext.j<fd2.s> r104 = r103.m8262getService();
            if (r104 == null) goto L11;
            fd2.s r105 = r104.getValue();
            if (r105 == null) goto L12;
            r105.Fi(r100, r101, r102);
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public final void l(double r100, int r101, Function1<? super Boolean, Unit> r102) {
            RealTimeChorusBusinessContext r103 = getContext();
            if (r103 == null) goto L10;
            com.bytedance.live.datacontext.j<fd2.s> r104 = r103.m8262getService();
            if (r104 == null) goto L11;
            fd2.s r105 = r104.getValue();
            if (r105 == null) goto L12;
            r105.km(r100, r101, r102);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(RealTimeChorusBusinessContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final RealTimeChorusBusinessContext getContext() {
        return Companion.getContext();
    }

    @JvmStatic
    public static final int getCurrentChorusMode() {
        return Companion.a();
    }

    @JvmStatic
    public static final int getRealTimeChorusRole() {
        return Companion.b();
    }

    @JvmStatic
    public static final fd2.s getService() {
        return Companion.c();
    }

    @JvmStatic
    public static final int getUserType() {
        return Companion.d();
    }

    @JvmStatic
    public static final boolean isAssignLead() {
        return Companion.e();
    }

    @JvmStatic
    public static final boolean isCDNViceSinger() {
        return Companion.f();
    }

    @JvmStatic
    public static final boolean isInRealTimeChorus() {
        Companion.getClass();
        return a.g();
    }

    @JvmStatic
    public static final boolean isRTChorusSpatialAudioEnable() {
        Companion.getClass();
        return a.h();
    }

    @JvmStatic
    public static final boolean isRealTimeLeadChorusEnable() {
        Companion.getClass();
        return a.i();
    }

    @JvmStatic
    public static final boolean isViceSinger() {
        return Companion.j();
    }

    @JvmStatic
    public static final void joinRealTimeChorus(MusicPanel r100, Function1<Object, Unit> r101, Function1<? super Throwable, Unit> r102) {
        Companion.k(r100, r101, r102);
    }

    @JvmStatic
    public static final void leaveRealTimeChorus(double r100, int r101, Function1<? super Boolean, Unit> r102) {
        Companion.l(r100, r101, r102);
    }

    @JvmStatic
    public static final void observerCurUserRealTimeChorusUserType(LifecycleOwner r100, Observer<Integer> r101) {
        Companion.m(r100, r101);
    }

    @JvmStatic
    public static final void observerIsChorusAssignLeader(LifecycleOwner r100, Observer<Boolean> r101) {
        Companion.n(r100, r101);
    }

    @JvmStatic
    public static final void observerRealTimeChorusRole(LifecycleOwner r100, Observer<Integer> r101) {
        Companion.o(r100, r101);
    }

    /* JADX INFO: renamed from: getService, reason: collision with other method in class */
    public final com.bytedance.live.datacontext.j<fd2.s> m8262getService() {
        return (com.bytedance.live.datacontext.j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    @JvmStatic
    public static final boolean curUserIsLead() {
        RealTimeChorusBusinessContext r100 = Companion.getContext();
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.j<fd2.s> r101 = r100.m8262getService();
        if (r101 == null) goto L9;
        fd2.s r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102.Y5();
    L9:
        return false;
    }

    @JvmStatic
    public static final fd2.e0 getLocalNetworkQualityStats() {
        RealTimeChorusBusinessContext r100 = Companion.getContext();
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.j<fd2.s> r101 = r100.m8262getService();
        if (r101 == null) goto L9;
        fd2.s r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102.D7();
    L9:
        return null;
    }

    @JvmStatic
    public static final int getSpatialAudioDistance() {
        Companion.getClass();
        return g6.f125383a.getValue().getDistanceParams();
    }

    @JvmStatic
    public static final zi6.c getSpatialAudioLayout() {
        Companion.getClass();
        if (g6.f125383a.getValue().getSpatialLayout() != 0) goto L6;
        return zi6.c.b.f572262a;
    L6:
        return zi6.c.C8463c.f572263a;
    }

    @JvmStatic
    public static final boolean isLeadSinger() {
        if (Companion.b() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @JvmStatic
    public static final boolean isRealTimeChorusEnable() {
        Companion.getClass();
        Integer r100 = e6.f123289a.getValue();
        if (r100 != null) goto L6;
    L21:
        if (r100 != null) goto L24;
    L26:
        if (r100 != null) goto L29;
        return false;
    L29:
        if (r100.intValue() != 2) goto L33;
    L30:
        return true;
    L33:
        return false;
    L24:
        if (r100.intValue() != 1) goto L26;
        return false;
    L6:
        if (r100.intValue() != 0) goto L21;
        com.bytedance.android.livesdk.chatroom.o r101 = o3.f();
        if (r101 == null) goto L18;
        com.bytedance.live.datacontext.m<IRoom> r102 = r101.getRoom();
        if (r102 == null) goto L18;
        IRoom r103 = r102.getValue();
        if (r103 == null) goto L18;
        Map<String, String> r104 = r103.getAnchorABMap();
        if (r104 == null) goto L18;
        String r105 = r104.get("real_time_chorus");
        if (r105 == null) goto L18;
        int r106 = CastIntegerProtector.parseInt(r105);
    L19:
        if (r106 > 0) goto L30;
        return false;
    L18:
        r106 = 0;
        goto L19
    }

    public RealTimeChorusBusinessContext() {
        this.service$delegate = ConstantKt.c(this);
    }

    @JvmStatic
    public static final void updateSubToken(String r100) {
        a r101 = Companion;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "token");
        fd2.s r102 = r101.c();
        if (r102 == null) goto L6;
        r102.W8(r100);
        return;
    }
}
