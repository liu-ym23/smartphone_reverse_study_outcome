package Z5;

import L4.l;
import W5.e;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.foundation.R$string;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEvent;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventType;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteStateResult;
import com.stepos.ailauncher.foundation.task.entity.UiTask;
import h8.C4148a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0013\u0018\u0000 F2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\bJ\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\bJ\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0004\b!\u0010 J\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\bJ\u0015\u0010#\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b#\u0010\bJ\r\u0010$\u001a\u00020\u000b¢\u0006\u0004\b$\u0010 J\r\u0010%\u001a\u00020\u000b¢\u0006\u0004\b%\u0010 J\u0015\u0010'\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020&¢\u0006\u0004\b'\u0010(R\"\u0010)\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010;\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010 \"\u0004\bD\u0010E¨\u0006G"}, d2 = {"LZ5/b;", "LX5/a;", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteEvent;", "event", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteEvent;)V", "Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteStateResult;", VoiceWakeupReceiver.EXTRA_STATE, "", "taskCount", "l", "(Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteStateResult;I)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_COMMAND, "e", Const.INTENT_KEY_UMID, "t", Const.INTENT_KEY_PKGNAME, "c", "", "m", "()Ljava/lang/String;", "", "Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "p", "()Ljava/util/List;", "q", "()I", "r", Const.INTENT_KEY_APIKEY, "f", "n", "s", "LL4/l;", "o", "(LL4/l;)Ljava/lang/String;", "mCurrentFallbackState", "Ljava/lang/String;", "getMCurrentFallbackState", "setMCurrentFallbackState", "(Ljava/lang/String;)V", "mCurrentState", "LL4/l;", "getMCurrentState", "()LL4/l;", "setMCurrentState", "(LL4/l;)V", "", "lastIdleAgentTime", "J", "getLastIdleAgentTime", "()J", "setLastIdleAgentTime", "(J)V", "lastTaskState", "Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteStateResult;", "getLastTaskState", "()Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteStateResult;", "setLastTaskState", "(Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteStateResult;)V", "lastTaskCount", "I", "getLastTaskCount", "setLastTaskCount", "(I)V", "Companion", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b implements X5.a {
    public static final long BUBBLE_TEXT_PERIOD = 180000;
    public static final String FALLBACK_STATE_IDLE = "idle";
    public static final String FALLBACK_STATE_NETWORK_CONNECTING = "network_connecting";
    public static final String FALLBACK_STATE_NETWORK_LOST = "network_lost";
    public static final String FALLBACK_STATE_RUNNING = "running";
    public static final String FALLBACK_STATE_WAITING = "waiting";
    public static final String FALLBACK_STATE_WAITING_AUTH = "waiting_auth";
    public static final String FALLBACK_STATE_WAITING_DANGER = "waiting_danger";
    public static final long IDLE_AGENT_PERIOD = 1800000;
    private int lastTaskCount;
    private SpriteStateResult lastTaskState;
    private String mCurrentFallbackState = "idle";
    private l mCurrentState = l.C0941o.INSTANCE;
    private long lastIdleAgentTime = System.currentTimeMillis();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void j(com.stepos.ailauncher.foundation.sprite.bean.SpriteEvent r14) {
        /*
            r13 = this;
            java.lang.String r0 = r13.m()
            java.util.List r1 = r13.p()
            int r1 = r1.size()
            java.lang.String r2 = r13.mCurrentFallbackState
            boolean r2 = kotlin.jvm.internal.p.d(r2, r0)
            if (r2 != 0) goto L6b
            int r2 = r0.hashCode()
            switch(r2) {
                case 33242197: goto L4d;
                case 1116313165: goto L3e;
                case 1550783935: goto L2b;
                case 1792141402: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L56
        L1c:
            java.lang.String r2 = "waiting_auth"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L26
            goto L56
        L26:
            L4.l$d r2 = L4.l.C0931d.INSTANCE
            r13.mCurrentState = r2
            goto L69
        L2b:
            java.lang.String r2 = "running"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L35
            goto L56
        L35:
            X5.b r2 = X5.b.INSTANCE
            L4.l r2 = r2.c()
            r13.mCurrentState = r2
            goto L69
        L3e:
            java.lang.String r2 = "waiting"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L48
            goto L56
        L48:
            L4.l$c r2 = L4.l.C0930c.INSTANCE
            r13.mCurrentState = r2
            goto L69
        L4d:
            java.lang.String r2 = "waiting_danger"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L65
        L56:
            X5.b r2 = X5.b.INSTANCE
            L4.l r2 = r2.b()
            r13.mCurrentState = r2
            long r2 = java.lang.System.currentTimeMillis()
            r13.lastIdleAgentTime = r2
            goto L69
        L65:
            L4.l$e r2 = L4.l.C0932e.INSTANCE
            r13.mCurrentState = r2
        L69:
            r13.mCurrentFallbackState = r0
        L6b:
            java.lang.String r0 = r14.getAction()
            java.lang.String r2 = "task_error"
            boolean r0 = kotlin.jvm.internal.p.d(r0, r2)
            if (r0 != 0) goto Lab
            java.lang.String r0 = r14.getAction()
            java.lang.String r2 = "task_success"
            boolean r0 = kotlin.jvm.internal.p.d(r0, r2)
            if (r0 != 0) goto Lab
            java.lang.String r0 = r14.getAction()
            java.lang.String r2 = "task_interrupted"
            boolean r0 = kotlin.jvm.internal.p.d(r0, r2)
            if (r0 == 0) goto L93
            goto Lab
        L93:
            com.stepos.ailauncher.foundation.sprite.bean.SpriteStateResult r2 = new com.stepos.ailauncher.foundation.sprite.bean.SpriteStateResult
            L4.l r3 = r13.mCurrentState
            java.lang.String r4 = r13.o(r3)
            r11 = 124(0x7c, float:1.74E-43)
            r12 = 0
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r2.<init>(r3, r4, r5, r7, r8, r9, r10, r11, r12)
            r13.l(r2, r1)
            return
        Lab:
            Z5.a r0 = Z5.a.INSTANCE
            L4.l r2 = r0.a(r14)
            com.stepos.ailauncher.foundation.sprite.bean.SpriteStateResult r3 = new com.stepos.ailauncher.foundation.sprite.bean.SpriteStateResult
            L4.l r4 = r0.a(r14)
            java.lang.String r5 = r13.o(r2)
            int r8 = r0.b(r14)
            L4.l r9 = r13.mCurrentState
            java.lang.String r10 = r13.o(r9)
            X5.b r14 = X5.b.INSTANCE
            L4.l r0 = r13.mCurrentState
            boolean r11 = r14.g(r0)
            r6 = 5000(0x1388, double:2.4703E-320)
            r3.<init>(r4, r5, r6, r8, r9, r10, r11)
            r13.l(r3, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Z5.b.j(com.stepos.ailauncher.foundation.sprite.bean.SpriteEvent):void");
    }

    private final List<UiTask> p() {
        return X5.b.INSTANCE.d();
    }

    @Override // X5.a
    public void a(SpriteEvent event) {
        p.i(event, "event");
        if (a.INSTANCE.g(event)) {
            if (p.d(event.getType(), SpriteEventType.NIGHT)) {
                h(event);
                return;
            }
            if (p.d(event.getType(), SpriteEventType.TASK)) {
                j(event);
                return;
            }
            if (p.d(event.getType(), SpriteEventType.COUNTING)) {
                f(event);
                return;
            }
            if (p.d(event.getType(), SpriteEventType.USER)) {
                k(event);
                return;
            }
            if (p.d(event.getType(), SpriteEventType.SYSTEM)) {
                i(event);
                return;
            }
            if (p.d(event.getType(), SpriteEventType.NETWORK)) {
                g(event);
            } else if (p.d(event.getType(), SpriteEventType.AGENT_WORK)) {
                e(event);
            } else if (p.d(event.getType(), SpriteEventType.AGENT_WAKE)) {
                d(event);
            }
        }
    }

    public final void b() {
        this.mCurrentState = X5.b.INSTANCE.a(this.mCurrentState);
        this.lastIdleAgentTime = System.currentTimeMillis();
        l lVar = this.mCurrentState;
        e.INSTANCE.b(new SpriteStateResult(lVar, o(lVar), 0L, 1, null, null, true));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            r3 = this;
            java.lang.String r0 = r3.mCurrentFallbackState
            java.lang.String r1 = "running"
            boolean r0 = kotlin.jvm.internal.p.d(r0, r1)
            r1 = 1
            if (r0 == 0) goto L32
            int r0 = r3.n()
            if (r0 <= r1) goto L14
            goto Lbc
        L14:
            L4.l r0 = r3.mCurrentState
            L4.l$T r1 = L4.l.T.INSTANCE
            boolean r0 = kotlin.jvm.internal.p.d(r0, r1)
            if (r0 == 0) goto L23
            java.lang.String r3 = "task_running"
            goto La2
        L23:
            L4.l r3 = r3.mCurrentState
            L4.l$U r0 = L4.l.U.INSTANCE
            boolean r3 = kotlin.jvm.internal.p.d(r3, r0)
            if (r3 == 0) goto La1
            java.lang.String r3 = "task_running_safe"
            goto La2
        L32:
            java.lang.String r0 = r3.mCurrentFallbackState
            java.lang.String r2 = "waiting"
            boolean r0 = kotlin.jvm.internal.p.d(r0, r2)
            if (r0 == 0) goto L49
            int r3 = r3.s()
            if (r3 <= r1) goto L45
            goto Lbc
        L45:
            java.lang.String r3 = "task_waiting"
            goto La2
        L49:
            java.lang.String r0 = r3.mCurrentFallbackState
            java.lang.String r1 = "idle"
            boolean r0 = kotlin.jvm.internal.p.d(r0, r1)
            if (r0 == 0) goto La1
            L4.l r0 = r3.mCurrentState
            L4.l$o r1 = L4.l.C0941o.INSTANCE
            boolean r0 = kotlin.jvm.internal.p.d(r0, r1)
            if (r0 == 0) goto L60
            java.lang.String r3 = "idle_music"
            goto La2
        L60:
            L4.l r0 = r3.mCurrentState
            L4.l$n r1 = L4.l.C0940n.INSTANCE
            boolean r0 = kotlin.jvm.internal.p.d(r0, r1)
            if (r0 == 0) goto L6d
            java.lang.String r3 = "idle_flying"
            goto La2
        L6d:
            L4.l r0 = r3.mCurrentState
            L4.l$p r1 = L4.l.C0942p.INSTANCE
            boolean r0 = kotlin.jvm.internal.p.d(r0, r1)
            if (r0 == 0) goto L7a
            java.lang.String r3 = "idle_loafing"
            goto La2
        L7a:
            L4.l r0 = r3.mCurrentState
            L4.l$m r1 = L4.l.C0939m.INSTANCE
            boolean r0 = kotlin.jvm.internal.p.d(r0, r1)
            if (r0 == 0) goto L87
            java.lang.String r3 = "idle_exercise"
            goto La2
        L87:
            L4.l r0 = r3.mCurrentState
            L4.l$q r1 = L4.l.C0943q.INSTANCE
            boolean r0 = kotlin.jvm.internal.p.d(r0, r1)
            if (r0 == 0) goto L94
            java.lang.String r3 = "idle_night"
            goto La2
        L94:
            L4.l r3 = r3.mCurrentState
            L4.l$r r0 = L4.l.C0944r.INSTANCE
            boolean r3 = kotlin.jvm.internal.p.d(r3, r0)
            if (r3 == 0) goto La1
            java.lang.String r3 = "idle_safe"
            goto La2
        La1:
            r3 = 0
        La2:
            if (r3 != 0) goto La5
            goto Lbc
        La5:
            V5.b r0 = V5.b.INSTANCE
            r1 = 180000(0x2bf20, double:8.8932E-319)
            boolean r1 = r0.d(r3, r1)
            if (r1 == 0) goto Lbc
            java.lang.String r1 = r0.a(r3)
            W5.e r2 = W5.e.INSTANCE
            r2.a(r1)
            r0.f(r3, r1)
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Z5.b.c():void");
    }

    public final void d(SpriteEvent event) {
        String action = event.getAction();
        int iHashCode = action.hashCode();
        if (iHashCode != -1361835305) {
            if (iHashCode != -205267199) {
                if (iHashCode != 1702091532 || !action.equals(SpriteEventAction.AGENT_WAKE_AI_KEY_CLICK)) {
                    return;
                }
            } else if (!action.equals(SpriteEventAction.AGENT_WAKE_AI_KEY_LONG_CLICK)) {
                return;
            }
        } else if (!action.equals(SpriteEventAction.AGENT_WAKE_VOICE)) {
            return;
        }
        l.C0945s c0945s = l.C0945s.INSTANCE;
        String strO = o(c0945s);
        l lVar = this.mCurrentState;
        e.INSTANCE.b(new SpriteStateResult(c0945s, strO, 3000L, 3, lVar, o(lVar), X5.b.INSTANCE.g(this.mCurrentState)));
    }

    public final void e(SpriteEvent event) {
        String action = event.getAction();
        switch (action.hashCode()) {
            case -2134659376:
                if (!action.equals(SpriteEventAction.AGENT_TTS_START)) {
                    return;
                }
                break;
            case -1218715461:
                if (!action.equals("listening")) {
                    return;
                }
                break;
            case -1090974990:
                if (!action.equals(SpriteEventAction.AGENT_EXECUTE_START)) {
                    return;
                }
                break;
            case -726470767:
                if (!action.equals("speaking_done")) {
                    return;
                }
                t();
                return;
            case 731134086:
                if (!action.equals(SpriteEventAction.AGENT_LISTENING_END)) {
                    return;
                }
                t();
                return;
            case 1089885361:
                if (!action.equals(SpriteEventAction.AGENT_THINKING_END)) {
                    return;
                }
                t();
                return;
            case 1224578480:
                if (!action.equals(SpriteEventAction.AGENT_THINKING_START)) {
                    return;
                }
                break;
            case 1736169647:
                if (!action.equals(SpriteEventAction.AGENT_EXECUTE_END)) {
                    return;
                }
                t();
                return;
            default:
                return;
        }
        l.T t10 = l.T.INSTANCE;
        this.mCurrentState = t10;
        e.INSTANCE.b(new SpriteStateResult(t10, o(t10), 0L, 3, null, null, false, 112, null));
    }

    public final void f(SpriteEvent event) {
        p.i(event, "event");
        C4148a.k("initSprite", "dispatchEventCounting", false, 4, null);
        if (!p.d(this.mCurrentFallbackState, "idle") || System.currentTimeMillis() - this.lastIdleAgentTime <= IDLE_AGENT_PERIOD) {
            c();
        } else {
            C4148a.k("initSprite", "change agent avatar", false, 4, null);
            b();
        }
    }

    public final void g(SpriteEvent event) {
        String strM = m();
        if (p.d(event.getAction(), SpriteEventAction.NETWORK_AVAILABLE)) {
            if (p.d(this.mCurrentFallbackState, "network_connecting") || p.d(this.mCurrentFallbackState, "network_lost")) {
                this.mCurrentFallbackState = strM;
                if (p.d(strM, "running")) {
                    l lVarC = X5.b.INSTANCE.c();
                    this.mCurrentState = lVarC;
                    l(new SpriteStateResult(lVarC, o(lVarC), 0L, 0, null, null, false, 124, null), p().size());
                    return;
                } else {
                    this.mCurrentState = X5.b.INSTANCE.b();
                    this.lastIdleAgentTime = System.currentTimeMillis();
                    l lVar = this.mCurrentState;
                    e.INSTANCE.b(new SpriteStateResult(lVar, o(lVar), 0L, 0, null, null, false, 124, null));
                    return;
                }
            }
            return;
        }
        if (p.d(event.getAction(), "network_connecting")) {
            if (p.d(this.mCurrentFallbackState, "network_lost") || p.d(strM, "running")) {
                this.mCurrentFallbackState = "network_connecting";
                l.T t10 = l.T.INSTANCE;
                this.mCurrentState = t10;
                String string = C3197a.INSTANCE.a().getString(R$string.sprite_network_connecting);
                p.h(string, "getString(...)");
                e.INSTANCE.b(new SpriteStateResult(t10, string, 0L, 0, null, null, false, 124, null));
                return;
            }
            return;
        }
        if (p.d(event.getAction(), "network_lost")) {
            if (p.d(this.mCurrentFallbackState, "network_connecting") || p.d(strM, "running")) {
                this.mCurrentFallbackState = "network_lost";
                l.y yVar = l.y.INSTANCE;
                this.mCurrentState = yVar;
                e.INSTANCE.b(new SpriteStateResult(yVar, o(yVar), 0L, 0, null, null, false, 124, null));
            }
        }
    }

    public final void h(SpriteEvent event) {
        if (p.d(this.mCurrentFallbackState, "idle")) {
            this.mCurrentState = X5.b.INSTANCE.b();
            this.lastIdleAgentTime = System.currentTimeMillis();
            l lVar = this.mCurrentState;
            e.INSTANCE.b(new SpriteStateResult(lVar, o(lVar), 0L, 1, null, null, true));
        }
    }

    public final void i(SpriteEvent event) {
        if (p.d(event.getAction(), SpriteEventAction.GUI_OPERATE)) {
            l.C0938k c0938k = l.C0938k.INSTANCE;
            String strO = o(c0938k);
            l lVar = this.mCurrentState;
            e.INSTANCE.b(new SpriteStateResult(c0938k, strO, 3000L, 1, lVar, o(lVar), X5.b.INSTANCE.g(this.mCurrentState)));
        }
    }

    public final void k(SpriteEvent event) {
        String bubble;
        String bubble2;
        if (p.d(event.getAction(), SpriteEventAction.USER_EVENT_CLICK_MAIN)) {
            X5.b bVar = X5.b.INSTANCE;
            if (bVar.j(this.mCurrentState)) {
                l.R r10 = l.R.INSTANCE;
                SpriteStateResult spriteStateResult = this.lastTaskState;
                if (spriteStateResult == null || (bubble = spriteStateResult.getBubble()) == null) {
                    bubble = "";
                }
                l lVar = this.mCurrentState;
                SpriteStateResult spriteStateResult2 = this.lastTaskState;
                e.INSTANCE.b(new SpriteStateResult(r10, bubble, 3000L, 1, lVar, (spriteStateResult2 == null || (bubble2 = spriteStateResult2.getBubble()) == null) ? "" : bubble2, bVar.g(this.mCurrentState)));
                return;
            }
            l lVar2 = this.mCurrentState;
            l.C0943q c0943q = l.C0943q.INSTANCE;
            if (p.d(lVar2, c0943q)) {
                l.C0945s c0945s = l.C0945s.INSTANCE;
                e.INSTANCE.b(new SpriteStateResult(c0945s, o(c0945s), 10000L, 1, c0943q, o(c0943q), bVar.g(this.mCurrentState)));
            } else if (bVar.h(this.mCurrentState)) {
                b();
            }
        }
    }

    public final void l(SpriteStateResult state, int taskCount) {
        SpriteStateResult spriteStateResult = this.lastTaskState;
        if (spriteStateResult != null) {
            if (p.d(spriteStateResult != null ? spriteStateResult.getState() : null, state.getState())) {
                SpriteStateResult spriteStateResult2 = this.lastTaskState;
                if (p.d(spriteStateResult2 != null ? spriteStateResult2.getFallbackState() : null, state.getFallbackState()) && this.lastTaskCount == taskCount) {
                    return;
                }
            }
        }
        e.INSTANCE.b(state);
        this.lastTaskState = state;
        this.lastTaskCount = taskCount;
    }

    public final String m() {
        if (r() > 0) {
            return FALLBACK_STATE_WAITING_DANGER;
        }
        if (q() > 0) {
            return FALLBACK_STATE_WAITING_AUTH;
        }
        List<UiTask> listP = p();
        if (listP.isEmpty()) {
            return "idle";
        }
        Iterator<UiTask> it = listP.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().getStatus() == 7) {
                i10++;
            }
        }
        return i10 > 0 ? FALLBACK_STATE_WAITING : "running";
    }

    public final int n() {
        List<UiTask> listP = p();
        int i10 = 0;
        if (listP.isEmpty()) {
            return 0;
        }
        Iterator<UiTask> it = listP.iterator();
        while (it.hasNext()) {
            if (it.next().getStatus() == 7) {
                i10++;
            }
        }
        return listP.size() - i10;
    }

    public final String o(l state) {
        p.i(state, "state");
        return p.d(state, l.T.INSTANCE) ? a.INSTANCE.c(n()) : p.d(state, l.C0930c.INSTANCE) ? a.INSTANCE.e(s()) : p.d(state, l.C0931d.INSTANCE) ? a.INSTANCE.d(q()) : p.d(state, l.C0932e.INSTANCE) ? a.INSTANCE.f(r()) : V5.b.INSTANCE.b(state);
    }

    public final int q() {
        return X5.b.INSTANCE.e();
    }

    public final int r() {
        return X5.b.INSTANCE.f();
    }

    public final int s() {
        List<UiTask> listP = p();
        int i10 = 0;
        if (listP.isEmpty()) {
            return 0;
        }
        Iterator<UiTask> it = listP.iterator();
        while (it.hasNext()) {
            if (it.next().getStatus() == 7) {
                i10++;
            }
        }
        return i10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t() {
        /*
            r12 = this;
            java.lang.String r0 = r12.m()
            r12.mCurrentFallbackState = r0
            int r1 = r0.hashCode()
            switch(r1) {
                case 33242197: goto L3a;
                case 1116313165: goto L2d;
                case 1550783935: goto L1c;
                case 1792141402: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L43
        Le:
            java.lang.String r1 = "waiting_auth"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L18
            goto L43
        L18:
            L4.l$d r0 = L4.l.C0931d.INSTANCE
        L1a:
            r2 = r0
            goto L53
        L1c:
            java.lang.String r1 = "running"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L26
            goto L43
        L26:
            X5.b r0 = X5.b.INSTANCE
            L4.l r0 = r0.c()
            goto L1a
        L2d:
            java.lang.String r1 = "waiting"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L37
            goto L43
        L37:
            L4.l$c r0 = L4.l.C0930c.INSTANCE
            goto L1a
        L3a:
            java.lang.String r1 = "waiting_danger"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L50
        L43:
            long r0 = java.lang.System.currentTimeMillis()
            r12.lastIdleAgentTime = r0
            X5.b r0 = X5.b.INSTANCE
            L4.l r0 = r0.b()
            goto L1a
        L50:
            L4.l$e r0 = L4.l.C0932e.INSTANCE
            goto L1a
        L53:
            r12.mCurrentState = r2
            W5.e r0 = W5.e.INSTANCE
            com.stepos.ailauncher.foundation.sprite.bean.SpriteStateResult r1 = new com.stepos.ailauncher.foundation.sprite.bean.SpriteStateResult
            java.lang.String r3 = r12.o(r2)
            X5.b r4 = X5.b.INSTANCE
            L4.l r12 = r12.mCurrentState
            boolean r9 = r4.g(r12)
            r10 = 60
            r11 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1.<init>(r2, r3, r4, r6, r7, r8, r9, r10, r11)
            r0.b(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Z5.b.t():void");
    }
}
