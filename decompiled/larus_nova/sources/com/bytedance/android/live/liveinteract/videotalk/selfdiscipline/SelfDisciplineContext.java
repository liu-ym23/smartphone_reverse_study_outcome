package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline;

import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.interact.model.y;
import com.bytedance.android.livesdk.chatroom.model.interact.o1;
import com.bytedance.android.livesdk.chatroom.model.interact.p1;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001'B\u0007¢\u0006\u0004\b$\u0010%R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u000eR!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\u000eR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\u000eR'\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00180\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\u000eR!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010\u000e¨\u0006("}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/SelfDisciplineContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lkj0/a;", "Lcom/bytedance/live/datacontext/j;", "Lkj0/b;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/live/datacontext/m;", "", "currentTarget$delegate", "getCurrentTarget", "()Lcom/bytedance/live/datacontext/m;", "currentTarget", "", "status$delegate", "getStatus", "status", "", "isLeaving$delegate", "isLeaving", "Ljava/util/concurrent/ConcurrentHashMap;", "", "durationHolder$delegate", "Lkotlin/Lazy;", "getDurationHolder", "()Ljava/util/concurrent/ConcurrentHashMap;", "durationHolder", "currentTargetDuration$delegate", "getCurrentTargetDuration", "currentTargetDuration", "lastPunchStatus$delegate", "getLastPunchStatus", "lastPunchStatus", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelfDisciplineContext extends DataContext implements kj0.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final int NEW_VERSION = 1;
    public static final int OLD_VERSION = 2;
    public static final int PUNCH_STATUS_NOT_PUNCH = 0;
    public static final int PUNCH_STATUS_PUNCHED = 2;
    public static final int PUNCH_STATUS_PUNCHING = 1;
    public static final String SELF_DISCIPLINE_V2 = "self_discipline_v2";
    public static final String SELF_DISCIPLINE_V3 = "self_discipline_v3";
    private static boolean isContinue;
    private static String roomIntro;
    private final p currentTarget$delegate;
    private final p currentTargetDuration$delegate;
    private final Lazy durationHolder$delegate;
    private final p isLeaving$delegate;
    private final p lastPunchStatus$delegate;
    private final p service$delegate;
    private final p status$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static int a() {
            int r100 = ((Number) vm2.d.I4.getValue(null, vm2.d.f555776a[292(0x124, float:4.09E-43)])).intValue();
            if (r100 != 0) goto L5;
            m<IRoom> r101 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r101 == null) goto L19;
            IRoom r102 = r101.getValue();
            if (r102 == null) goto L20;
            String r103 = r102.getAnchorAbValue(SelfDisciplineContext.SELF_DISCIPLINE_V2);
            if (r103 != null) goto L16;
            return 2;
        L16:
            return CastIntegerProtector.parseInt(r103);
        L20:
            return 2;
        L19:
            return 2;
        L5:
            if (r100 == 1) goto L17;
            if (r100 != 2) goto L22;
            return 1;
        L22:
            return 2;
        L17:
            return 2;
        }

        @JvmStatic
        public static int b() {
            int r100 = ((Number) vm2.d.J4.getValue(null, vm2.d.f555776a[293(0x125, float:4.1E-43)])).intValue();
            if (r100 != 0) goto L5;
            m<IRoom> r101 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r101 == null) goto L19;
            IRoom r102 = r101.getValue();
            if (r102 == null) goto L20;
            String r103 = r102.getAnchorAbValue(SelfDisciplineContext.SELF_DISCIPLINE_V3);
            if (r103 != null) goto L16;
            return 2;
        L16:
            return CastIntegerProtector.parseInt(r103);
        L20:
            return 2;
        L19:
            return 2;
        L5:
            if (r100 == 1) goto L17;
            if (r100 != 2) goto L22;
            return 1;
        L22:
            return 2;
        L17:
            return 2;
        }

        @JvmStatic
        public static String c() {
            ReadOnlyProperty r100 = vm2.d.K4;
            KProperty<?>[] r101 = vm2.d.f555776a;
            int r102 = ((Number) r100.getValue(null, r101[294(0x126, float:4.12E-43)])).intValue();
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L24;
            if (r102 == 2) goto L23;
            return s1.B(R.string.ttlive_self_discipline_manage_dialog_title);
        L23:
            return (String) vm2.d.L4.getValue(null, r101[295(0x127, float:4.13E-43)]);
        L24:
            return s1.B(R.string.ttlive_self_discipline_manage_dialog_title);
        L10:
            m<IRoom> r103 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r103 == null) goto L16;
            IRoom r104 = r103.getValue();
            if (r104 == null) goto L16;
            String r105 = r104.getAnchorAbValue("self_discipline_name");
            if (r105 == null) goto L16;
        L18:
            if (CastIntegerProtector.parseInt(r105) != 1) goto L21;
            return (String) vm2.d.L4.getValue(null, r101[295(0x127, float:4.13E-43)]);
        L21:
            return s1.B(R.string.ttlive_self_discipline_manage_dialog_title);
        L16:
            r105 = "2";
            goto L18
        }

        @JvmStatic
        public final SelfDisciplineContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(kj0.a.class);
            if ((r100 instanceof SelfDisciplineContext) == true) goto L6;
            r100 = null;
        L6:
            return (SelfDisciplineContext) r100;
        }

        @JvmStatic
        public final kj0.b d() {
            SelfDisciplineContext r100 = getContext();
            if (r100 == null) goto L7;
            j<kj0.b> r101 = r100.m8180getService();
            if (r101 == null) goto L7;
            return r101.getValue();
        L7:
            return null;
        }

        public final boolean e() {
            SelfDisciplineContext r100 = getContext();
            if (r100 == null) goto L8;
            m<Integer> r101 = r100.getStatus();
            if (r101 == null) goto L8;
            if (r101.getValue().intValue() != 1) goto L8;
            return true;
        L8:
            SelfDisciplineContext r102 = getContext();
            if (r102 == null) goto L14;
            m<Integer> r103 = r102.getStatus();
            if (r103 == null) goto L14;
            if (r103.getValue().intValue() != 3) goto L14;
            return true;
        L14:
            SelfDisciplineContext r104 = getContext();
            if (r104 == null) goto L21;
            m<Integer> r105 = r104.getStatus();
            if (r105 == null) goto L21;
            if (r105.getValue().intValue() != 4) goto L21;
            return true;
        L21:
            return false;
        }

        public final boolean f() {
            if (e() == false) goto L11;
            SelfDisciplineContext r100 = getContext();
            if (r100 == null) goto L11;
            m<Boolean> r101 = r100.isLeaving();
            if (r101 == null) goto L11;
            if (r101.getValue().booleanValue() != true) goto L11;
            return true;
        L11:
            return false;
        }

        @JvmStatic
        public static void g(y r100) {
            if (r100 == null) goto L12;
            boolean r101 = tb1.d.f545237a;
            if (r100.getKey() != 76) goto L15;
            com.bytedance.android.livesdk.sharedpref.e<Integer> r102 = b6.Q;
            Integer r103 = Integer.valueOf(r100.getValue());
            r102.getClass();
            f.d(r102, r103);
            p1 r104 = r100.getContent();
            if (r104 == null) goto L13;
            o1 r105 = r104.getSelfDisciplineInfo();
            if (r105 == null) goto L14;
            com.bytedance.android.livesdk.sharedpref.e<o1> r106 = b6.P;
            r106.getClass();
            f.d(r106, r105);
            return;
        L14:
            return;
        L13:
            return;
        L15:
            return;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(SelfDisciplineContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(SelfDisciplineContext.class, "currentTarget", "getCurrentTarget()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(SelfDisciplineContext.class, "status", "getStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(SelfDisciplineContext.class, "isLeaving", "isLeaving()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(SelfDisciplineContext.class, "currentTargetDuration", "getCurrentTargetDuration()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(SelfDisciplineContext.class, "lastPunchStatus", "getLastPunchStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
        roomIntro = "null";
    }

    @JvmStatic
    public static final int getAnchorTest() {
        Companion.getClass();
        return a.a();
    }

    @JvmStatic
    public static final int getAnchorTestV3() {
        Companion.getClass();
        return a.b();
    }

    @JvmStatic
    public static final SelfDisciplineContext getContext() {
        return Companion.getContext();
    }

    @JvmStatic
    public static final String getPlayModeName() {
        Companion.getClass();
        return a.c();
    }

    @JvmStatic
    public static final kj0.b getService() {
        return Companion.d();
    }

    @JvmStatic
    public static final void updateSelfDisciplineSetting(y r100) {
        Companion.getClass();
        a.g(r100);
    }

    public final m<String> getCurrentTarget() {
        return (m) this.currentTarget$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Long> getCurrentTargetDuration() {
        return (m) this.currentTargetDuration$delegate.a(this, $$delegatedProperties[4]);
    }

    public final ConcurrentHashMap<String, Long> getDurationHolder() {
        return (ConcurrentHashMap) this.durationHolder$delegate.getValue();
    }

    public final m<Integer> getLastPunchStatus() {
        return (m) this.lastPunchStatus$delegate.a(this, $$delegatedProperties[5]);
    }

    /* JADX INFO: renamed from: getService, reason: collision with other method in class */
    public final j<kj0.b> m8180getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Integer> getStatus() {
        return (m) this.status$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Boolean> isLeaving() {
        return (m) this.isLeaving$delegate.a(this, $$delegatedProperties[3]);
    }

    public SelfDisciplineContext() {
        this.service$delegate = ConstantKt.c(this);
        this.currentTarget$delegate = q.d(this, "");
        this.status$delegate = q.d(this, 0);
        this.isLeaving$delegate = q.d(this, Boolean.FALSE);
        this.durationHolder$delegate = LazyKt.lazy(SelfDisciplineContext$durationHolder$2.INSTANCE);
        this.currentTargetDuration$delegate = q.d(this, 600L);
        this.lastPunchStatus$delegate = q.d(this, 0);
    }

    public static final /* synthetic */ String access$getRoomIntro$cp() {
        return roomIntro;
    }

    public static final /* synthetic */ boolean access$isContinue$cp() {
        return isContinue;
    }

    public static final /* synthetic */ void access$setContinue$cp(boolean r100) {
        isContinue = r100;
    }

    public static final /* synthetic */ void access$setRoomIntro$cp(String r100) {
        roomIntro = r100;
    }
}
