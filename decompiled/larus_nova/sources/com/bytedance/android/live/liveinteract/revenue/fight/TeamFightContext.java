package com.bytedance.android.live.liveinteract.revenue.fight;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.chatroom.model.interact.y2;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import vh7.f;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0016\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001IB\u0007¢\u0006\u0004\bF\u0010GR\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u0014R3\u0010\u001e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00170\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u001dR!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\f\u001a\u0004\b \u0010\u0014R!\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\f\u001a\u0004\b$\u0010\u0014R!\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\f\u001a\u0004\b(\u0010\u0014R!\u0010/\u001a\b\u0012\u0004\u0012\u00020+0*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\f\u001a\u0004\b-\u0010.R!\u00103\u001a\b\u0012\u0004\u0012\u0002000\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\f\u001a\u0004\b2\u0010\u0014R#\u00105\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0011048\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\"\u00109\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0005\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR!\u0010=\u001a\b\u0012\u0004\u0012\u0002000\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\f\u001a\u0004\b<\u0010\u0014R\u0014\u0010>\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0006R\u0014\u0010?\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0006R\u0014\u0010B\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0016\u0010E\u001a\u0004\u0018\u00010&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006J"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/fight/TeamFightContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/liveinteract/revenue/fight/a;", "", "isDynamic", "Z", "()Z", "setDynamic", "(Z)V", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/liveinteract/revenue/fight/c;", "widget$delegate", "Lcom/bytedance/live/datacontext/p;", "getWidget", "()Lcom/bytedance/live/datacontext/j;", "widget", "Lcom/bytedance/live/datacontext/m;", "", "fightStatus$delegate", "getFightStatus", "()Lcom/bytedance/live/datacontext/m;", "fightStatus", "Lcom/bytedance/live/datacontext/k;", "Lcom/bytedance/android/live/core/utils/StateMachine$c$b;", "Lcom/bytedance/android/live/liveinteract/revenue/fight/e$b;", "Lcom/bytedance/android/live/liveinteract/revenue/fight/e$a;", "", "stateChangeEffect$delegate", "getStateChangeEffect", "()Lcom/bytedance/live/datacontext/k;", "stateChangeEffect", "currentApplyTeam$delegate", "getCurrentApplyTeam", "currentApplyTeam", "", "fightStartTime$delegate", "getFightStartTime", "fightStartTime", "Lcom/bytedance/android/live/liveinteract/multiscene/a;", "teamFightInfo$delegate", "getTeamFightInfo", "teamFightInfo", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/y2;", "serverConfig$delegate", "getServerConfig", "()Lcom/bytedance/live/datacontext/n;", "serverConfig", "", "requestPage$delegate", "getRequestPage", "requestPage", "", "dressLevelList", "Ljava/util/Map;", "getDressLevelList", "()Ljava/util/Map;", "isDressOn", "setDressOn", "dressId$delegate", "getDressId", "dressId", "isFightOnGoing", "isFightShowing", "getCurrentFightStatus", "()I", "currentFightStatus", "getCurrentFightInfo", "()Lcom/bytedance/android/live/liveinteract/multiscene/a;", "currentFightInfo", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TeamFightContext extends DataContext implements com.bytedance.android.live.liveinteract.revenue.fight.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p currentApplyTeam$delegate;
    private final p dressId$delegate;
    private final Map<String, Integer> dressLevelList;
    private final p fightStartTime$delegate;
    private final p fightStatus$delegate;
    private boolean isDressOn;
    private boolean isDynamic;
    private final p requestPage$delegate;
    private final p serverConfig$delegate;
    private final p stateChangeEffect$delegate;
    private final p teamFightInfo$delegate;
    private final p widget$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final TeamFightContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(com.bytedance.android.live.liveinteract.revenue.fight.a.class);
            if ((r100 instanceof TeamFightContext) == true) goto L6;
            r100 = null;
        L6:
            return (TeamFightContext) r100;
        }

        @JvmStatic
        public final boolean a() {
            TeamFightContext r100 = getContext();
            if (r100 == null) goto L12;
            m<Integer> r101 = r100.getCurrentApplyTeam();
            if (r101 == null) goto L12;
            Integer r102 = r101.getValue();
            if (r102 == null) goto L12;
            int r103 = r102.intValue();
            if (h() == false) goto L12;
            if (r103 <= 0) goto L12;
            return true;
        L12:
            return false;
        }

        @JvmStatic
        public final com.bytedance.android.live.liveinteract.multiscene.a b() {
            TeamFightContext r100 = getContext();
            if (r100 != null) goto L5;
        L9:
            TeamFightContext r101 = getContext();
            if (r101 != null) goto L12;
            return null;
        L12:
            return r101.getCurrentFightInfo();
        L5:
            if (r100.isDynamic() != true) goto L9;
            c r102 = c();
            if (r102 != null) goto L14;
            return null;
        L14:
            return r102.X2();
        }

        public final c c() {
            TeamFightContext r100 = getContext();
            if (r100 == null) goto L7;
            j<c> r101 = r100.getWidget();
            if (r101 == null) goto L7;
            return r101.getValue();
        L7:
            return null;
        }

        public final boolean d() {
            TeamFightContext r100 = getContext();
            if (r100 != null) goto L5;
        L11:
            TeamFightContext r101 = getContext();
            if (r101 == null) goto L21;
            m<Integer> r102 = r101.getFightStatus();
            if (r102 != null) goto L16;
            return false;
        L16:
            if (r102.getValue().intValue() != 1) goto L23;
        L17:
            return true;
        L23:
            return false;
        L21:
            return false;
        L5:
            if (r100.isDynamic() != true) goto L11;
            c r103 = c();
            if (r103 != null) goto L9;
            return false;
        L9:
            if (r103.zh() == true) goto L17;
            return false;
        }

        public final boolean e() {
            TeamFightContext r100 = getContext();
            if (r100 != null) goto L5;
        L11:
            TeamFightContext r101 = getContext();
            if (r101 == null) goto L21;
            m<Integer> r102 = r101.getFightStatus();
            if (r102 != null) goto L16;
            return false;
        L16:
            if (r102.getValue().intValue() != 3) goto L23;
        L17:
            return true;
        L23:
            return false;
        L21:
            return false;
        L5:
            if (r100.isDynamic() != true) goto L11;
            c r103 = c();
            if (r103 != null) goto L9;
            return false;
        L9:
            if (r103.Rh() == true) goto L17;
            return false;
        }

        @JvmStatic
        public final boolean f() {
            TeamFightContext r100 = getContext();
            if (r100 != null) goto L5;
        L11:
            TeamFightContext r101 = getContext();
            if (r101 == null) goto L21;
            m<Integer> r102 = r101.getFightStatus();
            if (r102 != null) goto L16;
            return false;
        L16:
            if (r102.getValue().intValue() != 2) goto L23;
        L17:
            return true;
        L23:
            return false;
        L21:
            return false;
        L5:
            if (r100.isDynamic() != true) goto L11;
            c r103 = c();
            if (r103 != null) goto L9;
            return false;
        L9:
            if (r103.ck() == true) goto L17;
            return false;
        }

        public final boolean g() {
            TeamFightContext r100 = getContext();
            if (r100 != null) goto L5;
        L7:
            TeamFightContext r101 = getContext();
            if (r101 == null) goto L15;
            m<Integer> r102 = r101.getFightStatus();
            if (r102 != null) goto L12;
            return false;
        L12:
            if (r102.getValue().intValue() != 5) goto L17;
            return true;
        L17:
            return false;
        L15:
            return false;
        L5:
            if (r100.isDynamic() != true) goto L7;
            return false;
        }

        @JvmStatic
        public final boolean h() {
            TeamFightContext r100 = getContext();
            if (r100 != null) goto L5;
        L12:
            TeamFightContext r101 = getContext();
            if (r101 == null) goto L17;
            m<Integer> r102 = r101.getFightStatus();
            if (r102 == null) goto L17;
            Integer r103 = r102.getValue();
        L18:
            if (r103 != null) goto L21;
        L22:
            if (r103 != null) goto L25;
        L26:
            if (r103 != null) goto L29;
            return false;
        L29:
            if (r103.intValue() != 3) goto L34;
        L30:
            return true;
        L34:
            return false;
        L25:
            if (r103.intValue() == 2) goto L30;
        L21:
            if (r103.intValue() == 1) goto L30;
        L17:
            r103 = null;
            goto L18
        L5:
            if (r100.isDynamic() != true) goto L12;
            c r104 = c();
            if (r104 != null) goto L9;
            return false;
        L9:
            if (r104.isTeamFightShowing() != true) goto L33;
            return true;
        L33:
            return false;
        }

        @JvmStatic
        public final void i(int r100, int r101) {
            if (h() == false) goto L11;
            if (r100 > 0) goto L12;
            if (r101 <= 0) goto L11;
            if (li0.d.g(null) == false) goto L10;
            r100 = li0.d.b(r101);
            goto L12
        L10:
            r100 = li0.d.d(r101);
        L12:
            TeamFightContext r102 = getContext();
            if (r102 == null) goto L18;
            m<Integer> r103 = r102.getCurrentApplyTeam();
            if (r103 == null) goto L19;
            r103.setValue(Integer.valueOf(r100));
            return;
        L19:
            return;
        L18:
            return;
        L11:
            r100 = 0;
            goto L12
        }
    }

    @JvmStatic
    public static final boolean canShowWaitingDialog() {
        return Companion.a();
    }

    @JvmStatic
    public static final com.bytedance.android.live.liveinteract.multiscene.a currentTeamFightInfo() {
        return Companion.b();
    }

    @JvmStatic
    public static final TeamFightContext getContext() {
        return Companion.getContext();
    }

    @JvmStatic
    public static final boolean isFighting() {
        return Companion.f();
    }

    @JvmStatic
    public static final boolean isTeamFightShowing() {
        return Companion.h();
    }

    @JvmStatic
    public static final void setCurrentApplyTeamId(int r100, int r101) {
        Companion.i(r100, r101);
    }

    public final m<Integer> getCurrentApplyTeam() {
        return (m) this.currentApplyTeam$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<String> getDressId() {
        return (m) this.dressId$delegate.a(this, $$delegatedProperties[8]);
    }

    public final m<Long> getFightStartTime() {
        return (m) this.fightStartTime$delegate.a(this, $$delegatedProperties[4]);
    }

    public final m<Integer> getFightStatus() {
        return (m) this.fightStatus$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<String> getRequestPage() {
        return (m) this.requestPage$delegate.a(this, $$delegatedProperties[7]);
    }

    public final n<y2> getServerConfig() {
        return (n) this.serverConfig$delegate.a(this, $$delegatedProperties[6]);
    }

    public final k<StateMachine.c.b<e.b, e.a, Object>> getStateChangeEffect() {
        return (k) this.stateChangeEffect$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<com.bytedance.android.live.liveinteract.multiscene.a> getTeamFightInfo() {
        return (m) this.teamFightInfo$delegate.a(this, $$delegatedProperties[5]);
    }

    public final j<c> getWidget() {
        return (j) this.widget$delegate.a(this, $$delegatedProperties[0]);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(TeamFightContext.class, "widget", "getWidget()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(TeamFightContext.class, "fightStatus", "getFightStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(TeamFightContext.class, "stateChangeEffect", "getStateChangeEffect()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(TeamFightContext.class, "currentApplyTeam", "getCurrentApplyTeam()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(TeamFightContext.class, "fightStartTime", "getFightStartTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(TeamFightContext.class, "teamFightInfo", "getTeamFightInfo()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(TeamFightContext.class, "serverConfig", "getServerConfig()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(TeamFightContext.class, "requestPage", "getRequestPage()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(TeamFightContext.class, "dressId", "getDressId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final void clearCurrentApplyTeamId() {
        TeamFightContext r100 = Companion.getContext();
        if (r100 == null) goto L8;
        m<Integer> r101 = r100.getCurrentApplyTeam();
        if (r101 == null) goto L9;
        r101.setValue(0);
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final c getTeamFightWidget() {
        TeamFightContext r100 = Companion.getContext();
        if (r100 == null) goto L7;
        j<c> r101 = r100.getWidget();
        if (r101 == null) goto L7;
        return r101.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.a
    public boolean isFightOnGoing() {
        return Companion.f();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.a
    public boolean isFightShowing() {
        return Companion.h();
    }

    public TeamFightContext() {
        this.widget$delegate = ConstantKt.c(this);
        this.fightStatus$delegate = q.d(this, 0);
        this.stateChangeEffect$delegate = com.bytedance.live.datacontext.e.a(this, TeamFightContext$stateChangeEffect$2.INSTANCE);
        this.currentApplyTeam$delegate = q.d(this, 0);
        this.fightStartTime$delegate = q.d(this, 0L);
        this.teamFightInfo$delegate = q.d(this, f.c(com.bytedance.android.live.liveinteract.multiscene.a.class));
        this.serverConfig$delegate = q.c(this);
        this.requestPage$delegate = q.d(this, "");
        this.dressLevelList = new LinkedHashMap();
        this.dressId$delegate = q.d(this, "");
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.a
    public com.bytedance.android.live.liveinteract.multiscene.a getCurrentFightInfo() {
        return getTeamFightInfo().getValue();
    }

    public int getCurrentFightStatus() {
        return getFightStatus().getValue().intValue();
    }

    public final Map<String, Integer> getDressLevelList() {
        return this.dressLevelList;
    }

    public final boolean isDressOn() {
        return this.isDressOn;
    }

    public final boolean isDynamic() {
        return this.isDynamic;
    }

    @JvmStatic
    public static final Disposable observeFightStatus(Consumer<Integer> r100) {
        a r101 = Companion;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "fightStatusObserver");
        TeamFightContext r102 = r101.getContext();
        if (r102 == null) goto L9;
        m<Integer> r103 = r102.getFightStatus();
        if (r103 == null) goto L9;
        Observable<Integer> r104 = r103.a();
        if (r104 == null) goto L9;
        return r104.subscribe(r100);
    L9:
        return null;
    }

    public final void setDressOn(boolean r100) {
        this.isDressOn = r100;
    }

    public final void setDynamic(boolean r100) {
        this.isDynamic = r100;
    }
}
