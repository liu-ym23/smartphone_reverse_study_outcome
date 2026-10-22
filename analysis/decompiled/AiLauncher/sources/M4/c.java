package M4;

import L4.AgentEmotion;
import L4.AgentPlace;
import L4.AgentSkin;
import L4.AgentWeather;
import L4.l;
import L4.r;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Xa.t;
import Xa.u;
import Z8.F;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentsprite.internal.OverlayChannel;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J\r\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010*R$\u00101\u001a\u00020,2\u0006\u0010-\u001a\u00020,8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001c\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020:8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020\u0007068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u00108R \u0010C\u001a\b\u0012\u0004\u0012\u00020\u00070:8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bA\u0010<\u001a\u0004\bB\u0010>R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020 068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u00108R \u0010H\u001a\b\u0012\u0004\u0012\u00020 0:8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bF\u0010<\u001a\u0004\bG\u0010>R\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\u0015068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u00108R\u001d\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00150:8\u0006¢\u0006\f\n\u0004\bG\u0010<\u001a\u0004\bK\u0010>R\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00110M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010NR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u001c068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u00108R\u001d\u0010S\u001a\b\u0012\u0004\u0012\u00020\u001c0:8\u0006¢\u0006\f\n\u0004\bQ\u0010<\u001a\u0004\bR\u0010>R\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020T0M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010NR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020V068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u00108R \u0010Y\u001a\b\u0012\u0004\u0012\u00020V0:8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010<\u001a\u0004\bX\u0010>R\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020\t068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u00108R \u0010\\\u001a\b\u0012\u0004\u0012\u00020\t0:8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b[\u0010<\u001a\u0004\bI\u0010>R\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020\u000b068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u00108R \u0010`\u001a\b\u0012\u0004\u0012\u00020\u000b0:8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b_\u0010<\u001a\u0004\bD\u0010>R\u001c\u0010b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u00108R\"\u0010d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020:8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bc\u0010<\u001a\u0004\bA\u0010>R\u0014\u0010h\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\"\u0010k\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010:8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bi\u0010<\u001a\u0004\bj\u0010>R \u0010q\u001a\b\u0012\u0004\u0012\u00020\u00010l8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00110:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010>R\u001a\u0010s\u001a\b\u0012\u0004\u0012\u00020T0:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010>¨\u0006t"}, d2 = {"LM4/c;", "", "", "agentId", "Landroid/content/Context;", "context", "initialAssetsPackage", "LL4/h;", "initialSkin", "LL4/e;", "initialNightMode", "LL4/a;", "initialBackgroundRatio", "LL4/r;", "priorityPolicy", "<init>", "(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;LL4/h;LL4/e;LL4/a;LL4/r;)V", "LL4/l;", VoiceWakeupReceiver.EXTRA_STATE, "r", "(LL4/l;)Ljava/lang/String;", "", "holdMillis", "", "priority", "LL4/b;", "c", "(LL4/l;JI)LL4/b;", "", "freeze", Const.INTENT_KEY_PKGNAME, "(LL4/l;Z)LL4/b;", "LL4/f;", "place", Const.INTENT_KEY_APIKEY, "(LL4/f;)LL4/b;", "LY8/t;", "s", "()V", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/String;", "Landroid/content/Context;", "appContext", "LM4/g;", UxipConstants.f30680s, "LM4/g;", "m", "()LM4/g;", "resolver", "LUa/M;", Const.INTENT_KEY_UMID, "LUa/M;", "scope", "LXa/k;", "e", "LXa/k;", "lineFlowMut", "LXa/t;", "f", "LXa/t;", "getLineFlow", "()LXa/t;", "lineFlow", "skinFlowMut", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "n", "skinFlow", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "placeFlowMut", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "l", "placeFlow", "k", "stateReplayTickMut", "q", "stateReplayTick", "Lcom/stepos/agentsprite/internal/OverlayChannel;", "Lcom/stepos/agentsprite/internal/OverlayChannel;", "stateChannel", "stateFrozenMut", "o", "p", "stateFrozenFlow", "LL4/c;", "emotionChannel", "LL4/m;", "weatherFlowMut", "getWeatherFlow", "weatherFlow", "nightModeFlowMut", "t", "nightModeFlow", "u", "backgroundRatioFlowMut", "v", "backgroundRatioFlow", "w", "assetsPackageFlowMut", "x", "assetsPackageFlow", "LM4/i;", "y", "LM4/i;", "bubbleScheduler", "z", "getBubbleEventFlow", "bubbleEventFlow", "LXa/o;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "LXa/o;", "getBubbleEventStream", "()LXa/o;", "bubbleEventStream", "stateFlow", "emotionFlow", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class c implements L4.b {

    /* renamed from: A, reason: collision with root package name and from kotlin metadata */
    public final Xa.o<Object> bubbleEventStream;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String agentId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Context appContext;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public volatile g resolver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final M scope;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Xa.k<String> lineFlowMut;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final t<String> lineFlow;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Xa.k<AgentSkin> skinFlowMut;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final t<AgentSkin> skinFlow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final Xa.k<AgentPlace> placeFlowMut;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final t<AgentPlace> placeFlow;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final Xa.k<Long> stateReplayTickMut;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final t<Long> stateReplayTick;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final OverlayChannel<L4.l> stateChannel;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final Xa.k<Boolean> stateFrozenMut;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public final t<Boolean> stateFrozenFlow;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final OverlayChannel<AgentEmotion> emotionChannel;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final Xa.k<AgentWeather> weatherFlowMut;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final t<AgentWeather> weatherFlow;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final Xa.k<L4.e> nightModeFlowMut;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public final t<L4.e> nightModeFlow;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public final Xa.k<L4.a> backgroundRatioFlowMut;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public final t<L4.a> backgroundRatioFlow;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public final Xa.k<String> assetsPackageFlowMut;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public final t<String> assetsPackageFlow;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public final i bubbleScheduler;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public final t<Object> bubbleEventFlow;

    public c(String agentId, Context context, String str, AgentSkin initialSkin, L4.e initialNightMode, L4.a initialBackgroundRatio, r priorityPolicy) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(initialSkin, "initialSkin");
        kotlin.jvm.internal.p.i(initialNightMode, "initialNightMode");
        kotlin.jvm.internal.p.i(initialBackgroundRatio, "initialBackgroundRatio");
        kotlin.jvm.internal.p.i(priorityPolicy, "priorityPolicy");
        this.agentId = agentId;
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        this.appContext = applicationContext;
        this.resolver = g.INSTANCE.c(applicationContext, str, initialNightMode);
        M mA = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.a()));
        this.scope = mA;
        Xa.k<String> kVarA = u.a(null);
        this.lineFlowMut = kVarA;
        this.lineFlow = Xa.d.c(kVarA);
        Xa.k<AgentSkin> kVarA2 = u.a(initialSkin);
        this.skinFlowMut = kVarA2;
        this.skinFlow = Xa.d.c(kVarA2);
        Xa.k<AgentPlace> kVarA3 = u.a(AgentPlace.d.INSTANCE);
        this.placeFlowMut = kVarA3;
        this.placeFlow = Xa.d.c(kVarA3);
        Xa.k<Long> kVarA4 = u.a(0L);
        this.stateReplayTickMut = kVarA4;
        this.stateReplayTick = Xa.d.c(kVarA4);
        this.stateChannel = new OverlayChannel<>(mA, l.C0072l.INSTANCE, new p9.p() { // from class: M4.a
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return c.t(this.f4516a, (L4.l) obj, ((Boolean) obj2).booleanValue());
            }
        });
        Xa.k<Boolean> kVarA5 = u.a(Boolean.FALSE);
        this.stateFrozenMut = kVarA5;
        this.stateFrozenFlow = Xa.d.c(kVarA5);
        this.emotionChannel = new OverlayChannel<>(mA, AgentEmotion.a.INSTANCE, new p9.p() { // from class: M4.b
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return c.f((AgentEmotion) obj, ((Boolean) obj2).booleanValue());
            }
        });
        Xa.k<AgentWeather> kVarA6 = u.a(AgentWeather.a.INSTANCE);
        this.weatherFlowMut = kVarA6;
        this.weatherFlow = Xa.d.c(kVarA6);
        Xa.k<L4.e> kVarA7 = u.a(initialNightMode);
        this.nightModeFlowMut = kVarA7;
        this.nightModeFlow = Xa.d.c(kVarA7);
        Xa.k<L4.a> kVarA8 = u.a(initialBackgroundRatio);
        this.backgroundRatioFlowMut = kVarA8;
        this.backgroundRatioFlow = Xa.d.c(kVarA8);
        Xa.k<String> kVarA9 = u.a(str);
        this.assetsPackageFlowMut = kVarA9;
        this.assetsPackageFlow = Xa.d.c(kVarA9);
        i iVar = new i(mA, priorityPolicy);
        this.bubbleScheduler = iVar;
        this.bubbleEventFlow = iVar.a();
        this.bubbleEventStream = iVar.b();
    }

    public static final Y8.t f(AgentEmotion agentEmotion, boolean z10) {
        kotlin.jvm.internal.p.i(agentEmotion, "<unused var>");
        return Y8.t.f7040a;
    }

    public static final Y8.t t(c cVar, L4.l state, boolean z10) {
        kotlin.jvm.internal.p.i(state, "state");
        cVar.lineFlowMut.setValue(cVar.r(state));
        if (z10) {
            Xa.k<Long> kVar = cVar.stateReplayTickMut;
            kVar.setValue(Long.valueOf(kVar.getValue().longValue() + 1));
        }
        return Y8.t.f7040a;
    }

    @Override // L4.b
    public L4.b a(AgentPlace place) {
        if (place == null) {
            place = AgentPlace.d.INSTANCE;
        }
        boolean zD = kotlin.jvm.internal.p.d(this.placeFlowMut.getValue(), place);
        this.placeFlowMut.setValue(place);
        if (!zD) {
            this.lineFlowMut.setValue(r(this.stateChannel.h().getValue()));
        }
        return this;
    }

    @Override // L4.b
    public L4.b b(L4.l state, boolean freeze) {
        kotlin.jvm.internal.p.i(state, "state");
        d.f4544a.a("ctrl[" + getAgentId() + "] setState key=" + state.getKey() + " code=" + state.getCode() + " freeze=" + freeze);
        this.stateFrozenMut.setValue(Boolean.valueOf(freeze));
        this.stateChannel.j(state, 0L, state.getDefaultPriority());
        return this;
    }

    @Override // L4.b
    public L4.b c(L4.l state, long holdMillis, int priority) {
        kotlin.jvm.internal.p.i(state, "state");
        d.f4544a.a("ctrl[" + getAgentId() + "] setState key=" + state.getKey() + " code=" + state.getCode() + " hold=" + holdMillis + " prio=" + priority);
        this.stateFrozenMut.setValue(Boolean.FALSE);
        this.stateChannel.j(state, holdMillis, priority);
        return this;
    }

    /* renamed from: g, reason: from getter */
    public String getAgentId() {
        return this.agentId;
    }

    public t<String> h() {
        return this.assetsPackageFlow;
    }

    public t<L4.a> i() {
        return this.backgroundRatioFlow;
    }

    public t<AgentEmotion> j() {
        return this.emotionChannel.h();
    }

    public t<L4.e> k() {
        return this.nightModeFlow;
    }

    public t<AgentPlace> l() {
        return this.placeFlow;
    }

    /* renamed from: m, reason: from getter */
    public final g getResolver() {
        return this.resolver;
    }

    public t<AgentSkin> n() {
        return this.skinFlow;
    }

    public t<L4.l> o() {
        return this.stateChannel.h();
    }

    public final t<Boolean> p() {
        return this.stateFrozenFlow;
    }

    public final t<Long> q() {
        return this.stateReplayTick;
    }

    public final String r(L4.l state) {
        List<String> listI = this.resolver.i(getAgentId(), state, this.skinFlowMut.getValue(), this.placeFlowMut.getValue());
        if (listI.isEmpty()) {
            return null;
        }
        return (String) F.U0(listI, Random.INSTANCE);
    }

    public final void s() {
        this.stateChannel.g();
        this.emotionChannel.g();
        this.bubbleScheduler.c();
        kotlinx.coroutines.d.e(this.scope, null, 1, null);
    }
}
