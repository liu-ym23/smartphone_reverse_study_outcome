package Y5;

import X5.b;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEvent;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventType;
import com.stepos.ailauncher.foundation.task.entity.UiTask;
import h8.C4148a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 '2\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010#R\u0016\u0010%\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"LY5/a;", "LX5/a;", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteEvent;", "event", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteEvent;)V", Const.INTENT_KEY_UMID, "e", "c", "", "action", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)Ljava/lang/String;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "", Const.INTENT_KEY_PKGNAME, "()I", "", "Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/List;", "eventName", "isTaskExecuting", "isForeground", "f", "(Ljava/lang/String;ZZ)V", "lastEventName", "Ljava/lang/String;", "lastIsTaskExecuting", "Ljava/lang/Boolean;", "lastIsForeground", "lastWaitTaskCount", "I", "Companion", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a implements X5.a {
    private static final String TAG = "BackSpriteManager";
    private String lastEventName;
    private Boolean lastIsForeground;
    private Boolean lastIsTaskExecuting;
    private int lastWaitTaskCount;

    @Override // X5.a
    public void a(SpriteEvent event) {
        p.i(event, "event");
        String type = event.getType();
        switch (type.hashCode()) {
            case -1549858375:
                if (!type.equals(SpriteEventType.AGENT_WAKE)) {
                    return;
                }
                break;
            case -739591834:
                if (!type.equals(SpriteEventType.AGENT_WORK)) {
                    return;
                }
                break;
            case -548925013:
                if (type.equals(SpriteEventType.TASK_READ)) {
                    e(event);
                    return;
                }
                return;
            case 1299845984:
                if (type.equals(SpriteEventType.TASK)) {
                    d(event);
                    return;
                }
                return;
            default:
                return;
        }
        c(event);
    }

    public final int b() {
        Iterator<UiTask> it = g().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().getStatus() == 7) {
                i10++;
            }
        }
        return i10;
    }

    public final void c(SpriteEvent event) {
        C4148a.k(TAG, "backSprite agentEvent eventName=" + event.getAction(), false, 4, null);
        W5.a.INSTANCE.a(event.getAction());
    }

    public final void d(SpriteEvent event) {
        boolean zBooleanValue;
        String strJ = j(event.getAction());
        if (p.d(strJ, SpriteEventAction.TASK_RUNNING)) {
            zBooleanValue = true;
        } else {
            Boolean boolIsSessionForeground = event.isSessionForeground();
            zBooleanValue = boolIsSessionForeground != null ? boolIsSessionForeground.booleanValue() : false;
        }
        f(strJ, h(), zBooleanValue);
        i();
    }

    public final void e(SpriteEvent event) {
        String action = event.getAction();
        int iHashCode = action.hashCode();
        if (iHashCode != -709103642) {
            if (iHashCode != 641888460) {
                if (iHashCode != 1257582695 || !action.equals(SpriteEventAction.TASK_ERROR_READ)) {
                    return;
                }
            } else if (!action.equals(SpriteEventAction.TASK_SUCCESS_READ)) {
                return;
            }
        } else if (!action.equals(SpriteEventAction.TASK_WAIT_READ)) {
            return;
        }
        C4148a.k(TAG, "backSprite taskRead eventName=" + event.getAction(), false, 4, null);
        W5.a.INSTANCE.c(event.getAction());
    }

    public final void f(String eventName, boolean isTaskExecuting, boolean isForeground) {
        if (p.d(this.lastEventName, eventName) && p.d(this.lastIsTaskExecuting, Boolean.valueOf(isTaskExecuting)) && p.d(this.lastIsForeground, Boolean.valueOf(isForeground))) {
            return;
        }
        this.lastEventName = eventName;
        this.lastIsTaskExecuting = Boolean.valueOf(isTaskExecuting);
        this.lastIsForeground = Boolean.valueOf(isForeground);
        C4148a.k(TAG, "backSprite eventName=" + eventName + " isTaskExecuting=" + isTaskExecuting + " isForeground=" + isForeground, false, 4, null);
        W5.a.INSTANCE.b(eventName, isTaskExecuting, isForeground);
    }

    public final List<UiTask> g() {
        return b.INSTANCE.d();
    }

    public final boolean h() {
        Iterator<UiTask> it = g().iterator();
        while (it.hasNext()) {
            if (it.next().getStatus() == 2) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        int i10;
        int iB = b();
        if (iB == 0 && (i10 = this.lastWaitTaskCount) > 0) {
            C4148a.k(TAG, "backSprite taskRead eventName=task_wait_read waitTasks " + i10 + " -> 0", false, 4, null);
            W5.a.INSTANCE.c(SpriteEventAction.TASK_WAIT_READ);
        }
        this.lastWaitTaskCount = iB;
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
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String j(java.lang.String r3) {
        /*
            r2 = this;
            int r2 = r3.hashCode()
            java.lang.String r0 = "task_wait"
            java.lang.String r1 = "task_error"
            switch(r2) {
                case -1174157495: goto L32;
                case -797531512: goto L27;
                case -709077539: goto L1c;
                case 180994031: goto L15;
                case 1299739342: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L3b
        Le:
            boolean r2 = r3.equals(r1)
            if (r2 != 0) goto L31
            goto L3b
        L15:
            boolean r2 = r3.equals(r0)
            if (r2 != 0) goto L26
            goto L3b
        L1c:
            java.lang.String r2 = "task_wait_safe"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L26
            goto L3b
        L26:
            return r0
        L27:
            java.lang.String r2 = "task_interrupted"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L31
            goto L3b
        L31:
            return r1
        L32:
            java.lang.String r2 = "task_success"
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L3e
        L3b:
            java.lang.String r2 = "task_running"
        L3e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: Y5.a.j(java.lang.String):java.lang.String");
    }
}
