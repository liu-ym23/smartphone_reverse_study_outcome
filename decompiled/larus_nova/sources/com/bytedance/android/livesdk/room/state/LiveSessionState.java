package com.bytedance.android.livesdk.room.state;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ts2.b;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/room/state/LiveSessionState;", "", "Lts2/b;", "", "toString", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "Lcom/bytedance/android/livesdk/room/state/ContainerLifecycle;", "containerLifecycle", "Lcom/bytedance/android/livesdk/room/state/ContainerLifecycle;", "getContainerLifecycle", "()Lcom/bytedance/android/livesdk/room/state/ContainerLifecycle;", "setContainerLifecycle", "(Lcom/bytedance/android/livesdk/room/state/ContainerLifecycle;)V", "Lcom/bytedance/android/livesdk/room/state/ContainerScrollLifecycle;", "containerScrollStateChanged", "Lcom/bytedance/android/livesdk/room/state/ContainerScrollLifecycle;", "getContainerScrollStateChanged", "()Lcom/bytedance/android/livesdk/room/state/ContainerScrollLifecycle;", "setContainerScrollStateChanged", "(Lcom/bytedance/android/livesdk/room/state/ContainerScrollLifecycle;)V", "Lts2/a;", "extraContainerData", "Lts2/a;", "getExtraContainerData", "()Lts2/a;", "setExtraContainerData", "(Lts2/a;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SESSION_PRE_START_CREATE", "SESSION_PRE_SESSION_INIT", "SESSION_CREATE_FINISHING", "SESSION_CONTAINER_STATE_CHANGED", "SESSION_CONTAINER_SCROLL_CHANGED", "SESSION_EXIT_CONTAINER", "room-flow_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveSessionState extends Enum<LiveSessionState> implements b {
    public static final a Companion = null;
    public static final LiveSessionState SESSION_CONTAINER_SCROLL_CHANGED = null;
    public static final LiveSessionState SESSION_CONTAINER_STATE_CHANGED = null;
    public static final LiveSessionState SESSION_CREATE_FINISHING = null;
    public static final LiveSessionState SESSION_EXIT_CONTAINER = null;
    public static final LiveSessionState SESSION_PRE_SESSION_INIT = null;
    public static final LiveSessionState SESSION_PRE_START_CREATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveSessionState[] f157819a = null;
    private ContainerLifecycle containerLifecycle;
    private ContainerScrollLifecycle containerScrollStateChanged;
    private final String des;
    private ts2.a extraContainerData;

    public static final class a {
        public a() {
        }

        public static LiveSessionState a(ContainerLifecycle r100) {
            Intrinsics.checkNotNullParameter(r100, "containerLifecycle");
            LiveSessionState r101 = LiveSessionState.SESSION_CONTAINER_STATE_CHANGED;
            r101.setContainerLifecycle(r100);
            return r101;
        }
    }

    static {
        LiveSessionState r110 = new LiveSessionState("SESSION_PRE_START_CREATE", 0, "pre_start_create", null, null, null, 14, null);
        SESSION_PRE_START_CREATE = r110;
        LiveSessionState r100 = new LiveSessionState("SESSION_PRE_SESSION_INIT", 1, "container_init", null, null, null, 14, null);
        SESSION_PRE_SESSION_INIT = r100;
        LiveSessionState r101 = new LiveSessionState("SESSION_CREATE_FINISHING", 2, "container_finish", null, null, null, 14, null);
        SESSION_CREATE_FINISHING = r101;
        LiveSessionState r102 = new LiveSessionState("SESSION_CONTAINER_STATE_CHANGED", 3, "container_changed", null, null, null, 14, null);
        SESSION_CONTAINER_STATE_CHANGED = r102;
        LiveSessionState r103 = new LiveSessionState("SESSION_CONTAINER_SCROLL_CHANGED", 4, "container_scroll", null, null, null, 14, null);
        SESSION_CONTAINER_SCROLL_CHANGED = r103;
        LiveSessionState r104 = new LiveSessionState("SESSION_EXIT_CONTAINER", 5, "exit_container", null, null, null, 14, null);
        SESSION_EXIT_CONTAINER = r104;
        f157819a = new LiveSessionState[]{r110, r100, r101, r102, r103, r104};
        Companion = new a();
    }

    public LiveSessionState() {
        throw null;
    }

    public static LiveSessionState valueOf(String r100) {
        return (LiveSessionState) r27.a.a(LiveSessionState.class, r100);
    }

    public static LiveSessionState[] values() {
        return (LiveSessionState[]) f157819a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(name());
        r100.append(" ->> ");
        Object r101 = this.containerLifecycle;
        Object r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.append(r101);
        r100.append(", ");
        Object r103 = this.extraContainerData;
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r100.append(r103);
        r100.append(", ");
        ContainerScrollLifecycle r104 = this.containerScrollStateChanged;
        if (r104 == null) goto L12;
        r102 = r104;
    L12:
        r100.append(r102);
        return r100.toString();
    }

    public final ContainerLifecycle getContainerLifecycle() {
        return this.containerLifecycle;
    }

    public final ContainerScrollLifecycle getContainerScrollStateChanged() {
        return this.containerScrollStateChanged;
    }

    public final String getDes() {
        return this.des;
    }

    public final ts2.a getExtraContainerData() {
        return this.extraContainerData;
    }

    public final void setContainerLifecycle(ContainerLifecycle r100) {
        this.containerLifecycle = r100;
    }

    public final void setContainerScrollStateChanged(ContainerScrollLifecycle r100) {
        this.containerScrollStateChanged = r100;
    }

    public final void setExtraContainerData(ts2.a r100) {
        this.extraContainerData = r100;
    }

    public LiveSessionState(String r100, int r101, String r102, ContainerLifecycle r103, ContainerScrollLifecycle r104, ts2.a r105, int r106, DefaultConstructorMarker r107) {
        if ((r106 & 1) == 0) goto L6;
        r102 = "";
    L6:
        if ((r106 & 2) == 0) goto L9;
        r103 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r104 = null;
    L12:
        if ((r106 & 8) == 0) goto L14;
        r105 = null;
    L14:
        super(r100, r101);
        this.des = r102;
        this.containerLifecycle = r103;
        this.containerScrollStateChanged = r104;
        this.extraContainerData = r105;
    }
}
