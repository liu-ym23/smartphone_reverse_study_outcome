package com.stepos.agentframework.chatui.appui.taskrobot;

import La.H;
import Ua.C1060i;
import Ua.M;
import Ua.Y;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.chatcore.intent.RobotManager;
import com.stepos.agentframework.chatcore.intent.TaskRobotAction;
import com.stepos.agentframework.chatcore.session.RobotArguments;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.agentframework.chatui.appui.BaseAppUIHostView;
import com.stepos.agentframework.chatui.appui.taskrobot.b;
import com.stepos.agentframework.chatui.appui.taskrobot.f;
import com.stepos.agentframework.chatui.view.N;
import com.stepos.agentframework.chatui.view.TaskRobotExecuteLayout;
import com.stepos.agentframework.util.G;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlinx.coroutines.JobKt__JobKt;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\b\t\n\u0002\b\u0003\n\u0002\b\u0005*\u0005w\u0080\u0001\u0083\u0001\u0018\u0000 \u0086\u00012\u00020\u0001:\u0001'B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0082@¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0012J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001d\u0010\u0012J#\u0010 \u001a\u00020\u000e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u001eH\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010%\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u000eH\u0016¢\u0006\u0004\b'\u0010\u0012J\u0017\u0010*\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u0015\u0010.\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\u000e¢\u0006\u0004\b0\u0010\u0012J\u0015\u00102\u001a\u00020,2\u0006\u00101\u001a\u00020,¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u000eH\u0014¢\u0006\u0004\b4\u0010\u0012J\u000f\u00105\u001a\u00020\u000eH\u0014¢\u0006\u0004\b5\u0010\u0012J\u0017\u00108\u001a\u00020\u000e2\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010;\u001a\u00020\u000e2\u0006\u0010:\u001a\u000206H\u0016¢\u0006\u0004\b;\u00109J\r\u0010<\u001a\u00020\u000e¢\u0006\u0004\b<\u0010\u0012J\u0015\u0010>\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\t¢\u0006\u0004\b>\u0010\u001cJ\u0015\u0010?\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\t¢\u0006\u0004\b?\u0010\u001cJ\r\u0010@\u001a\u000206¢\u0006\u0004\b@\u0010AJ\u0015\u0010D\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020B¢\u0006\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR$\u0010N\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010\u0010R$\u0010T\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010[\u001a\u0004\u0018\u00010Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0018\u0010b\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\"\u0010d\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010\u000f\u001a\u0004\be\u0010f\"\u0004\bg\u0010/R\u0016\u0010h\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010\u0018R\u0016\u0010i\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010\u0018R\"\u0010j\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010G\u001a\u0004\bk\u0010l\"\u0004\bm\u0010\u001cR\"\u0010n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010G\u001a\u0004\bo\u0010l\"\u0004\bp\u0010\u001cR.\u0010r\u001a\u0004\u0018\u00010B2\b\u0010q\u001a\u0004\u0018\u00010B8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010ER\u0014\u0010x\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR*\u0010z\u001a\u0002062\u0006\u0010q\u001a\u0002068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010\u0018\u001a\u0004\b{\u0010A\"\u0004\b|\u00109R*\u0010}\u001a\u0002062\u0006\u0010q\u001a\u0002068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b}\u0010\u0018\u001a\u0004\b~\u0010A\"\u0004\b\u007f\u00109R\u0018\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u0010\u0084\u0001\u001a\u00030\u0083\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001¨\u0006\u0087\u0001"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/taskrobot/RobotAppUIHostView;", "Lcom/stepos/agentframework/chatui/appui/k;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "", "J", "(Le9/c;)Ljava/lang/Object;", "Lw4/h;", "info", "LY8/t;", "I", "(Lw4/h;)V", "G", "()V", "K", "H", "F", "Lcom/stepos/agentframework/chatcore/intent/x;", "action", "Z", "(Lcom/stepos/agentframework/chatcore/intent/x;)V", "source", "N", "(Ljava/lang/String;)V", "R", "Lkotlin/Function1;", com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, "M", "(Lp9/l;)V", "flag", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "appUIData", "e", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)V", Const.INTENT_KEY_APIKEY, "Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView$TerminateReason;", "reason", "L", "(Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView$TerminateReason;)V", "", "width", "X", "(I)V", "O", "llmType", "Y", "(I)I", "onAttachedToWindow", "onDetachedFromWindow", "", "isVisible", "onVisibilityAggregated", "(Z)V", "hasWindowFocus", "onWindowFocusChanged", "U", C3081a.ERROR_MSG, "setBeenTakenStatus", "setToErrorStatus", ExifInterface.LONGITUDE_WEST, "()Z", "Lcom/stepos/agentframework/chatui/view/N;", "listener", "setOnTaskRobotErrorListener", "(Lcom/stepos/agentframework/chatui/view/N;)V", "TAG", "Ljava/lang/String;", "LUa/M;", "viewCoroutineScope", "LUa/M;", "Lkotlinx/coroutines/g;", "dataCollectJob", "Lkotlinx/coroutines/g;", "robotInfo", "Lw4/h;", "getRobotInfo", "()Lw4/h;", "setRobotInfo", "Lcom/stepos/agentframework/chatui/view/TaskRobotExecuteLayout;", "taskRobotLayout", "Lcom/stepos/agentframework/chatui/view/TaskRobotExecuteLayout;", "getTaskRobotLayout", "()Lcom/stepos/agentframework/chatui/view/TaskRobotExecuteLayout;", "setTaskRobotLayout", "(Lcom/stepos/agentframework/chatui/view/TaskRobotExecuteLayout;)V", "Lcom/stepos/agentframework/chatcore/session/I0;", "arguments", "Lcom/stepos/agentframework/chatcore/session/I0;", "getArguments", "()Lcom/stepos/agentframework/chatcore/session/I0;", "setArguments", "(Lcom/stepos/agentframework/chatcore/session/I0;)V", "Lcom/stepos/agentframework/chatui/appui/taskrobot/f;", "textureView", "Lcom/stepos/agentframework/chatui/appui/taskrobot/f;", "type", "getType", "()I", "setType", "loaded", "lastAggregatedVisible", DidiCardProvider.KEY_TRACE_ID, "getTraceId", "()Ljava/lang/String;", "setTraceId", "toolCallId", "getToolCallId", "setToolCallId", UxipConstants.f30680s, "errorListener", "Lcom/stepos/agentframework/chatui/view/N;", "getErrorListener", "()Lcom/stepos/agentframework/chatui/view/N;", "setErrorListener", "com/stepos/agentframework/chatui/appui/taskrobot/RobotAppUIHostView$b", "defaultErrorListener", "Lcom/stepos/agentframework/chatui/appui/taskrobot/RobotAppUIHostView$b;", "hideExecuteStatusStep", "getHideExecuteStatusStep", "setHideExecuteStatusStep", "pureVirtualScreen", "getPureVirtualScreen", "setPureVirtualScreen", "com/stepos/agentframework/chatui/appui/taskrobot/RobotAppUIHostView$c", "defaultSurfaceCallBack", "Lcom/stepos/agentframework/chatui/appui/taskrobot/RobotAppUIHostView$c;", "com/stepos/agentframework/chatui/appui/taskrobot/RobotAppUIHostView$d", "defaultTextureCallBack", "Lcom/stepos/agentframework/chatui/appui/taskrobot/RobotAppUIHostView$d;", "Companion", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RobotAppUIHostView extends com.stepos.agentframework.chatui.appui.k {
    public static final int LOAD_STATUS_LOADED = 2;
    public static final int LOAD_STATUS_LOADING = 1;
    public static final int LOAD_STATUS_NONE = 0;
    private final String TAG;
    private RobotArguments arguments;
    private kotlinx.coroutines.g dataCollectJob;
    private final b defaultErrorListener;
    private final c defaultSurfaceCallBack;
    private final d defaultTextureCallBack;
    private N errorListener;
    private boolean hideExecuteStatusStep;
    private boolean lastAggregatedVisible;
    private boolean loaded;
    private boolean pureVirtualScreen;
    private RobotInfo robotInfo;
    private TaskRobotExecuteLayout taskRobotLayout;
    private f textureView;
    private String toolCallId;
    private String traceId;
    private int type;
    private final M viewCoroutineScope;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/stepos/agentframework/chatui/appui/taskrobot/RobotAppUIHostView$b", "Lcom/stepos/agentframework/chatui/view/N;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements N {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/agentframework/chatui/appui/taskrobot/RobotAppUIHostView$c", "Lcom/stepos/agentframework/chatui/appui/taskrobot/b$b;", "Landroid/view/Surface;", "surface", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/Surface;)V", Const.INTENT_KEY_APIKEY, "()V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements b.InterfaceC0251b {
        public c() {
        }

        @Override // com.stepos.agentframework.chatui.appui.taskrobot.b.InterfaceC0251b
        public void a() {
            C4148a.k(RobotAppUIHostView.this.TAG, "onSurfaceDestroyed flag" + RobotAppUIHostView.this.getFlag(), false, 4, null);
            String flag = RobotAppUIHostView.this.getFlag();
            if (flag != null) {
                try {
                    t.INSTANCE.a(flag, 1);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }

        @Override // com.stepos.agentframework.chatui.appui.taskrobot.b.InterfaceC0251b
        public void b(Surface surface) {
            kotlin.jvm.internal.p.i(surface, "surface");
            RobotAppUIHostView.this.O();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/agentframework/chatui/appui/taskrobot/RobotAppUIHostView$d", "Lcom/stepos/agentframework/chatui/appui/taskrobot/f$b;", "Landroid/view/Surface;", "surface", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/Surface;)V", Const.INTENT_KEY_APIKEY, "()V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements f.b {
        public d() {
        }

        @Override // com.stepos.agentframework.chatui.appui.taskrobot.f.b
        public void a() {
            C4148a.k(RobotAppUIHostView.this.TAG, "onSurfaceDestroyed flag" + RobotAppUIHostView.this.getFlag(), false, 4, null);
            String flag = RobotAppUIHostView.this.getFlag();
            if (flag != null) {
                try {
                    t.INSTANCE.a(flag, 1);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }

        @Override // com.stepos.agentframework.chatui.appui.taskrobot.f.b
        public void b(Surface surface) {
            kotlin.jvm.internal.p.i(surface, "surface");
            RobotAppUIHostView.this.O();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/agentframework/chatui/appui/taskrobot/RobotAppUIHostView$e", "Lcom/stepos/agentframework/chatui/appui/taskrobot/f$b;", "Landroid/view/Surface;", "surface", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/Surface;)V", Const.INTENT_KEY_APIKEY, "()V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements f.b {
        public e() {
        }

        @Override // com.stepos.agentframework.chatui.appui.taskrobot.f.b
        public void a() {
            C4148a.k(RobotAppUIHostView.this.TAG, "onSurfaceDestroyed flag:" + RobotAppUIHostView.this.getFlag(), false, 4, null);
            String flag = RobotAppUIHostView.this.getFlag();
            if (flag != null) {
                try {
                    t.INSTANCE.a(flag, 1);
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.stepos.agentframework.chatui.appui.taskrobot.f.b
        public void b(Surface surface) {
            kotlin.jvm.internal.p.i(surface, "surface");
            RobotAppUIHostView.this.N("surface_callback");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RobotAppUIHostView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.TAG = "RobotAppUIHostView";
        this.viewCoroutineScope = kotlinx.coroutines.d.a(Y.c().plus(JobKt__JobKt.b(null, 1, null)));
        this.traceId = "";
        this.toolCallId = "";
        b bVar = new b();
        this.defaultErrorListener = bVar;
        TaskRobotExecuteLayout taskRobotExecuteLayout = new TaskRobotExecuteLayout(context, null, 2, 0 == true ? 1 : 0);
        this.taskRobotLayout = taskRobotExecuteLayout;
        taskRobotExecuteLayout.setErrorListener(bVar);
        TaskRobotExecuteLayout taskRobotExecuteLayout2 = this.taskRobotLayout;
        if (taskRobotExecuteLayout2 != null) {
            taskRobotExecuteLayout2.setOnStopTaskClick(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.appui.taskrobot.l
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return RobotAppUIHostView.v(this.f22852a);
                }
            });
        }
        TaskRobotExecuteLayout taskRobotExecuteLayout3 = this.taskRobotLayout;
        if (taskRobotExecuteLayout3 != null) {
            taskRobotExecuteLayout3.setOnTakeoverTaskClick(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.appui.taskrobot.m
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return RobotAppUIHostView.w(this.f22853a, ((Boolean) obj).booleanValue());
                }
            });
        }
        TaskRobotExecuteLayout taskRobotExecuteLayout4 = this.taskRobotLayout;
        if (taskRobotExecuteLayout4 != null) {
            taskRobotExecuteLayout4.setOnRobotContainerClick(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.appui.taskrobot.n
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return RobotAppUIHostView.x(this.f22854a);
                }
            });
        }
        TaskRobotExecuteLayout taskRobotExecuteLayout5 = this.taskRobotLayout;
        if (taskRobotExecuteLayout5 != null) {
            taskRobotExecuteLayout5.setOnCanceledStateApplied(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.appui.taskrobot.o
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return RobotAppUIHostView.y(this.f22855a, (String) obj);
                }
            });
        }
        ConstraintLayout appUIContainer = getAppUIContainer();
        View view = this.taskRobotLayout;
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-1, -2);
        int i10 = R$id.app_ui_container;
        bVar2.f12664t = i10;
        bVar2.f12668v = i10;
        Y8.t tVar = Y8.t.f7040a;
        appUIContainer.addView(view, bVar2);
        this.defaultSurfaceCallBack = new c();
        this.defaultTextureCallBack = new d();
    }

    public static final Y8.t P(RobotInfo persistRobotInfo) {
        kotlin.jvm.internal.p.i(persistRobotInfo, "$this$persistRobotInfo");
        persistRobotInfo.o(RobotInfo.STATUS_STARTED);
        return Y8.t.f7040a;
    }

    public static final Y8.t Q(String str, RobotInfo persistRobotInfo) {
        kotlin.jvm.internal.p.i(persistRobotInfo, "$this$persistRobotInfo");
        persistRobotInfo.o("fail");
        persistRobotInfo.k(str);
        persistRobotInfo.p(str);
        return Y8.t.f7040a;
    }

    public static final Y8.t S(RobotAppUIHostView robotAppUIHostView, RobotInfo persistRobotInfo) {
        String latestScreenshotPath;
        kotlin.jvm.internal.p.i(persistRobotInfo, "$this$persistRobotInfo");
        persistRobotInfo.o("canceled");
        TaskRobotExecuteLayout taskRobotExecuteLayout = robotAppUIHostView.taskRobotLayout;
        if (taskRobotExecuteLayout == null || (latestScreenshotPath = taskRobotExecuteLayout.getLatestScreenshotPath()) == null) {
            latestScreenshotPath = persistRobotInfo.getLatestScreenshotPath();
        }
        persistRobotInfo.n(latestScreenshotPath);
        return Y8.t.f7040a;
    }

    public static final Y8.t T(String str, RobotInfo persistRobotInfo) {
        kotlin.jvm.internal.p.i(persistRobotInfo, "$this$persistRobotInfo");
        persistRobotInfo.o("fail");
        persistRobotInfo.k(str);
        persistRobotInfo.p(str);
        return Y8.t.f7040a;
    }

    public static final Y8.t V(RobotInfo persistRobotInfo) {
        kotlin.jvm.internal.p.i(persistRobotInfo, "$this$persistRobotInfo");
        persistRobotInfo.p("");
        persistRobotInfo.o("complete");
        return Y8.t.f7040a;
    }

    public static final Y8.t a0(TaskRobotAction taskRobotAction, RobotInfo persistRobotInfo) {
        kotlin.jvm.internal.p.i(persistRobotInfo, "$this$persistRobotInfo");
        if (!H.x0(taskRobotAction.getTaskName())) {
            persistRobotInfo.q(taskRobotAction.getTaskName());
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t b0(TaskRobotAction taskRobotAction, RobotInfo persistRobotInfo) {
        kotlin.jvm.internal.p.i(persistRobotInfo, "$this$persistRobotInfo");
        persistRobotInfo.o("running");
        persistRobotInfo.n(taskRobotAction.getFilePath());
        return Y8.t.f7040a;
    }

    public static final Y8.t c0(TaskRobotAction taskRobotAction, RobotInfo persistRobotInfo) {
        kotlin.jvm.internal.p.i(persistRobotInfo, "$this$persistRobotInfo");
        persistRobotInfo.p(taskRobotAction.getMessage());
        return Y8.t.f7040a;
    }

    public static Y8.t u(String str, RobotInfo persistRobotInfo) {
        kotlin.jvm.internal.p.i(persistRobotInfo, "$this$persistRobotInfo");
        persistRobotInfo.o("canceled");
        persistRobotInfo.p(str);
        return Y8.t.f7040a;
    }

    public static final Y8.t v(RobotAppUIHostView robotAppUIHostView) {
        String flag = robotAppUIHostView.getFlag();
        if (flag != null) {
            RobotManager.INSTANCE.a().D(flag);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t w(RobotAppUIHostView robotAppUIHostView, boolean z10) {
        String flag = robotAppUIHostView.getFlag();
        if (flag != null) {
            if (z10) {
                RobotManager.INSTANCE.a().G(flag);
            } else {
                RobotManager.INSTANCE.a().K(flag);
            }
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t x(RobotAppUIHostView robotAppUIHostView) {
        String flag = robotAppUIHostView.getFlag();
        if (flag != null) {
            RobotManager.INSTANCE.a().q(flag);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t y(RobotAppUIHostView robotAppUIHostView, final String cancelMessage) {
        kotlin.jvm.internal.p.i(cancelMessage, "cancelMessage");
        robotAppUIHostView.M(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.appui.taskrobot.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RobotAppUIHostView.u(cancelMessage, (RobotInfo) obj);
            }
        });
        return Y8.t.f7040a;
    }

    public final void F() {
        C4148a.k(this.TAG, "cancelDataCollect", false, 4, null);
        kotlinx.coroutines.g gVar = this.dataCollectJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.dataCollectJob = null;
    }

    public final void G() {
        RobotInfo robotInfo = this.robotInfo;
        if (robotInfo == null || System.currentTimeMillis() - robotInfo.getFirstRunTime() <= 600000) {
            return;
        }
        if (kotlin.jvm.internal.p.d(robotInfo.getStatus(), "none") || kotlin.jvm.internal.p.d(robotInfo.getStatus(), RobotInfo.STATUS_STARTED) || kotlin.jvm.internal.p.d(robotInfo.getStatus(), "running")) {
            robotInfo.o("fail");
            robotInfo.k("任务超时");
            robotInfo.r(System.currentTimeMillis());
            Function2.a(new RobotAppUIHostView$checkOverTime$1$1(robotInfo, null));
        }
    }

    public final void H() {
        if (getFlag() == null || this.dataCollectJob != null) {
            return;
        }
        C4148a.k(this.TAG, "collectTaskData flag:" + getFlag(), false, 4, null);
        this.dataCollectJob = C1060i.d(this.viewCoroutineScope, null, null, new RobotAppUIHostView$collectTaskData$1(this, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I(w4.RobotInfo r12) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.appui.taskrobot.RobotAppUIHostView.I(w4.h):void");
    }

    public final Object J(InterfaceC4014c<? super List<String>> interfaceC4014c) {
        com.stepos.agentframework.chatcore.utils.o oVar = com.stepos.agentframework.chatcore.utils.o.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        String flag = getFlag();
        kotlin.jvm.internal.p.f(flag);
        return oVar.a(context, flag, interfaceC4014c);
    }

    public final void K() {
        Function2.a(new RobotAppUIHostView$loadRobotInfo$1(this, null));
    }

    public void L(BaseAppUIHostView.TerminateReason reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        R();
        String flag = getFlag();
        if (flag != null) {
            RobotManager.INSTANCE.a().D(flag);
        }
    }

    public final void M(InterfaceC5074l<? super RobotInfo, Y8.t> update) {
        String flag = getFlag();
        if (flag == null) {
            return;
        }
        RobotInfo robotInfo = this.robotInfo;
        if (robotInfo == null) {
            robotInfo = new RobotInfo(flag, null, "task_robot", null, 0L, 0L, null, null, null, 506, null);
        }
        update.invoke(robotInfo);
        robotInfo.r(System.currentTimeMillis());
        this.robotInfo = robotInfo;
        Function2.a(new RobotAppUIHostView$persistRobotInfo$1(robotInfo, null));
    }

    public final void N(String source) {
        String flag;
        f fVar;
        Surface surface;
        if (this.type != 1 || (flag = getFlag()) == null || (fVar = this.textureView) == null || (surface = fVar.getSurface()) == null) {
            return;
        }
        C4148a.k(this.TAG, "refreshSurfaceForGuiAgent source:" + source + " taskId:" + flag, false, 4, null);
        RobotManager.INSTANCE.a().I(flag, this.toolCallId, surface);
    }

    public final void O() {
        f fVar;
        String str = this.TAG;
        String flag = getFlag();
        RobotInfo robotInfo = this.robotInfo;
        AppUIData appUIData = getAppUIData();
        int i10 = this.type;
        f fVar2 = this.textureView;
        String json = null;
        surface = null;
        Surface surface = null;
        C4148a.k(str, "run flag:" + flag + " robotInfo:" + robotInfo + " appUIData:" + appUIData + " type:" + i10 + "  surface:" + (fVar2 != null ? fVar2.getSurface() : null), false, 4, null);
        if (getFlag() == null || getAppUIData() == null) {
            return;
        }
        if (this.arguments == null) {
            String str2 = this.TAG;
            AppUIData appUIData2 = getAppUIData();
            if (appUIData2 != null) {
                json = ExtKt.l().toJson(appUIData2);
                kotlin.jvm.internal.p.h(json, "toJson(...)");
            }
            C4148a.f(str2, "启动任务机器人失败:" + json, true);
            return;
        }
        M(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.appui.taskrobot.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RobotAppUIHostView.P((RobotInfo) obj);
            }
        });
        RobotManager robotManagerA = RobotManager.INSTANCE.a();
        int i11 = this.type;
        String flag2 = getFlag();
        kotlin.jvm.internal.p.f(flag2);
        String str3 = this.toolCallId;
        RobotArguments robotArguments = this.arguments;
        kotlin.jvm.internal.p.f(robotArguments);
        String data = robotArguments.getData();
        if (this.type == 1 && (fVar = this.textureView) != null) {
            surface = fVar.getSurface();
        }
        AppUIData appUIData3 = getAppUIData();
        kotlin.jvm.internal.p.f(appUIData3);
        RobotManager.C(robotManagerA, i11, flag2, str3, data, surface, appUIData3.getGuiAgentModelName(), 0, this.traceId, getChatSessionId(), getRequestSessionId(), 64, null);
        H();
    }

    public final void R() {
        TaskRobotExecuteLayout taskRobotExecuteLayout = this.taskRobotLayout;
        if (taskRobotExecuteLayout != null) {
            taskRobotExecuteLayout.setExecuteStatus(5);
        }
        M(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.appui.taskrobot.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RobotAppUIHostView.S(this.f22850a, (RobotInfo) obj);
            }
        });
        F();
    }

    public final void U() {
        TaskRobotExecuteLayout taskRobotExecuteLayout = this.taskRobotLayout;
        if (taskRobotExecuteLayout != null) {
            taskRobotExecuteLayout.setExecuteStatus(2);
        }
        M(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.appui.taskrobot.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RobotAppUIHostView.V((RobotInfo) obj);
            }
        });
        F();
    }

    public final boolean W() {
        TaskRobotExecuteLayout taskRobotExecuteLayout = this.taskRobotLayout;
        return taskRobotExecuteLayout != null && taskRobotExecuteLayout.getExecuteStatus() == 5;
    }

    public final void X(int width) {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        Pair<Integer, Integer> pairB = G.b(context);
        int iIntValue = (pairB.f().intValue() * width) / pairB.e().intValue();
        f fVar = this.textureView;
        if (fVar != null) {
            fVar.setLayoutParams(new FrameLayout.LayoutParams(width, iIntValue));
        }
        f fVar2 = this.textureView;
        if (fVar2 != null) {
            fVar2.requestLayout();
        }
        TaskRobotExecuteLayout taskRobotExecuteLayout = this.taskRobotLayout;
        if (taskRobotExecuteLayout != null) {
            taskRobotExecuteLayout.H(width, iIntValue);
        }
    }

    public final int Y(int llmType) {
        if (llmType == 0) {
            return 1;
        }
        if (llmType != 1) {
            return llmType != 2 ? 1 : 2;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Z(final com.stepos.agentframework.chatcore.intent.TaskRobotAction r9) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.appui.taskrobot.RobotAppUIHostView.Z(com.stepos.agentframework.chatcore.intent.x):void");
    }

    @Override // com.stepos.agentframework.chatui.appui.BaseAppUIHostView
    public void a() {
        C4148a.k(this.TAG, "destroy", false, 4, null);
        setHostDestroyed(true);
        String flag = getFlag();
        if (flag != null) {
            RobotManager.INSTANCE.a().D(flag);
        }
        F();
    }

    @Override // com.stepos.agentframework.chatui.appui.k, com.stepos.agentframework.chatui.appui.BaseAppUIHostView
    public void e(String flag, AppUIData appUIData) {
        kotlin.jvm.internal.p.i(flag, "flag");
        kotlin.jvm.internal.p.i(appUIData, "appUIData");
        f();
        super.e(flag, appUIData);
        C4148a.k(this.TAG, "load flag:" + flag + " loaded:" + this.loaded, false, 4, null);
        if (!this.loaded) {
            try {
                Result.Companion companion = Result.INSTANCE;
                C4148a.k(this.TAG, "load arguments:" + this.arguments + ",appUIData.structuredContent:" + appUIData.getStructuredContent(), false, 4, null);
                try {
                    Gson gson = new Gson();
                    Object structuredContent = appUIData.getStructuredContent();
                    kotlin.jvm.internal.p.g(structuredContent, "null cannot be cast to non-null type kotlin.String");
                    this.arguments = (RobotArguments) gson.fromJson((String) structuredContent, RobotArguments.class);
                } catch (Exception e10) {
                    C4148a.h(this.TAG, "error:" + e10, false, 4, null);
                }
                C4148a.k(this.TAG, "load arguments:" + this.arguments, false, 4, null);
                RobotArguments robotArguments = this.arguments;
                if (robotArguments != null) {
                    kotlin.jvm.internal.p.f(robotArguments);
                    this.type = Y(robotArguments.getType());
                }
                K();
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        this.loaded = true;
    }

    public final RobotArguments getArguments() {
        return this.arguments;
    }

    public final N getErrorListener() {
        return this.errorListener;
    }

    public final boolean getHideExecuteStatusStep() {
        return this.hideExecuteStatusStep;
    }

    public final boolean getPureVirtualScreen() {
        return this.pureVirtualScreen;
    }

    public final RobotInfo getRobotInfo() {
        return this.robotInfo;
    }

    public final TaskRobotExecuteLayout getTaskRobotLayout() {
        return this.taskRobotLayout;
    }

    public final String getToolCallId() {
        return this.toolCallId;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final int getType() {
        return this.type;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C4148a.k(this.TAG, "onAttachedToWindow flag:" + getFlag(), false, 4, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C4148a.k(this.TAG, "onDetachedFromWindow flag:" + getFlag(), false, 4, null);
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean isVisible) {
        super.onVisibilityAggregated(isVisible);
        if (isVisible && !this.lastAggregatedVisible) {
            N("visibility_restored");
        }
        this.lastAggregatedVisible = isVisible;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus) {
            N("window_focus_gained");
        }
    }

    public final void setArguments(RobotArguments robotArguments) {
        this.arguments = robotArguments;
    }

    public final void setBeenTakenStatus(final String errorMsg) {
        TaskRobotExecuteLayout taskRobotExecuteLayout;
        kotlin.jvm.internal.p.i(errorMsg, "errorMsg");
        TaskRobotExecuteLayout taskRobotExecuteLayout2 = this.taskRobotLayout;
        if (taskRobotExecuteLayout2 != null) {
            taskRobotExecuteLayout2.setExecuteStatus(-1);
        }
        String flag = getFlag();
        if (flag != null && (taskRobotExecuteLayout = this.taskRobotLayout) != null) {
            taskRobotExecuteLayout.I(flag, errorMsg);
        }
        M(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.appui.taskrobot.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RobotAppUIHostView.Q(errorMsg, (RobotInfo) obj);
            }
        });
    }

    public final void setErrorListener(N n10) {
        this.errorListener = n10;
        TaskRobotExecuteLayout taskRobotExecuteLayout = this.taskRobotLayout;
        if (taskRobotExecuteLayout != null) {
            taskRobotExecuteLayout.setErrorListener(this.defaultErrorListener);
        }
    }

    public final void setHideExecuteStatusStep(boolean z10) {
        this.hideExecuteStatusStep = z10;
        TaskRobotExecuteLayout taskRobotExecuteLayout = this.taskRobotLayout;
        if (taskRobotExecuteLayout != null) {
            taskRobotExecuteLayout.setHideExecuteStatusStep(z10);
        }
    }

    public final void setOnTaskRobotErrorListener(N listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        setErrorListener(listener);
    }

    public final void setPureVirtualScreen(boolean z10) {
        this.pureVirtualScreen = z10;
        TaskRobotExecuteLayout taskRobotExecuteLayout = this.taskRobotLayout;
        if (taskRobotExecuteLayout != null) {
            taskRobotExecuteLayout.setPureVirtualScreen(z10);
        }
    }

    public final void setRobotInfo(RobotInfo robotInfo) {
        this.robotInfo = robotInfo;
    }

    public final void setTaskRobotLayout(TaskRobotExecuteLayout taskRobotExecuteLayout) {
        this.taskRobotLayout = taskRobotExecuteLayout;
    }

    public final void setToErrorStatus(final String errorMsg) {
        TaskRobotExecuteLayout taskRobotExecuteLayout;
        kotlin.jvm.internal.p.i(errorMsg, "errorMsg");
        TaskRobotExecuteLayout taskRobotExecuteLayout2 = this.taskRobotLayout;
        if (taskRobotExecuteLayout2 != null) {
            taskRobotExecuteLayout2.setExecuteStatus(-1);
        }
        String flag = getFlag();
        if (flag != null && (taskRobotExecuteLayout = this.taskRobotLayout) != null) {
            taskRobotExecuteLayout.I(flag, errorMsg);
        }
        M(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.appui.taskrobot.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RobotAppUIHostView.T(errorMsg, (RobotInfo) obj);
            }
        });
        F();
    }

    public final void setToolCallId(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.toolCallId = str;
    }

    public final void setTraceId(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.traceId = str;
    }

    public final void setType(int i10) {
        this.type = i10;
    }
}
