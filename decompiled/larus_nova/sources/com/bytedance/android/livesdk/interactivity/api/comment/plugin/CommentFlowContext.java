package com.bytedance.android.livesdk.interactivity.api.comment.plugin;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.event.c0;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;
import y22.c;
import y22.e;
import y22.f;

/* JADX INFO: loaded from: classes9.dex */
public final class CommentFlowContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f133048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f133049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CommentScene f133050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CommentInputConfig f133051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CommentContentType f133052e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommentBusinessType f133053f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f133054g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c0 f133055h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f133056i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Exception f133057j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f133058k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f133059l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<Object, Object> f133060m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/plugin/CommentFlowContext$State;", "", "Init", "Input", "Send", "Success", "Failed", "Canceled", "UnHandled", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State Canceled = null;
        public static final State Failed = null;
        public static final State Init = null;
        public static final State Input = null;
        public static final State Send = null;
        public static final State Success = null;
        public static final State UnHandled = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f133061a = null;

        static {
            State r100 = new State("Init", 0);
            Init = r100;
            State r101 = new State("Input", 1);
            Input = r101;
            State r102 = new State("Send", 2);
            Send = r102;
            State r103 = new State("Success", 3);
            Success = r103;
            State r104 = new State("Failed", 4);
            Failed = r104;
            State r105 = new State("Canceled", 5);
            Canceled = r105;
            State r106 = new State("UnHandled", 6);
            UnHandled = r106;
            f133061a = new State[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f133061a.clone();
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean a() {
        this.f133058k = System.currentTimeMillis();
        e r100 = this.f133049b;
        if (r100 == null) goto L5;
        r100.f(this);
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        this.f133048a = State.UnHandled;
    L8:
        int r102 = c.f565704a;
        Intrinsics.checkNotNullParameter(this, PerfLog.PARAM_KEY_CONTEXT_ID);
        ALogger.i("CommentFlowContext", "[" + hashCode() + "] send, contentType is " + this.f133052e + ", businessType is " + this.f133053f + ", handle state is " + this.f133048a);
        return r101;
    L5:
        r101 = false;
        goto L6
    }

    public CommentFlowContext(e r100, CommentEntry r101, CommentScene r102, long r103, Map<Object, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        Intrinsics.checkNotNullParameter(r101, "entry");
        Intrinsics.checkNotNullParameter(r102, "scene");
        this.f133059l = r103;
        this.f133060m = r104;
        this.f133048a = State.Init;
        this.f133049b = r100;
        this.f133050c = r102;
        int r105 = c.f565704a;
        Intrinsics.checkNotNullParameter(this, PerfLog.PARAM_KEY_CONTEXT_ID);
        StringBuilder r106 = new StringBuilder("[");
        r106.append(hashCode());
        r106.append("] create, plugin is ");
        if (r100 == null) goto L5;
        String r107 = r100.getName();
    L6:
        r106.append(r107);
        r106.append(", entry is ");
        r106.append(r101);
        r106.append(", scene is ");
        r106.append(r102);
        r106.append(", sceneId is ");
        r106.append(r103);
        ALogger.i("CommentFlowContext", r106.toString());
        return;
    L5:
        r107 = null;
        goto L6
    }
}
