package com.stepos.agentframework.chatcore.intent;

import Ua.C1060i;
import Ua.M;
import Ua.Y;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.sdk.client.AgentServiceClient;
import com.stepos.ability.sdk.client.GuiTaskConfig;
import com.stepos.agentframework.chatcore.intent.TaskDispatcher;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import eb.InterfaceC4021a;
import h8.C4148a;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4848b;
import kotlin.Function2;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.coroutines.JobKt__JobKt;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\u0018\u0000 >2\u00020\u0001:\u0002?@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\b\u0010\tJF\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u000e2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0015\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u000e2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0016\u0010\u0012J%\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u0012Jm\u0010%\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u001d2\b\b\u0002\u0010\"\u001a\u00020\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b'\u0010\u0012J\u0013\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020)¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u000e¢\u0006\u0004\b.\u0010\u0003R\u0014\u0010/\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020)048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u0001048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00106R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/RobotManager;", "", "<init>", "()V", "", "taskId", "Landroid/graphics/Bitmap;", "bitmap", "z", "(Ljava/lang/String;Landroid/graphics/Bitmap;Le9/c;)Ljava/lang/Object;", "taskName", "action", "bitmapId", "message", "LY8/t;", "s", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "K", "(Ljava/lang/String;)V", "G", "q", "o", "w", "toolCallId", "Landroid/view/Surface;", "surface", "I", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/Surface;)V", "D", "", "startType", "arguments", "modelId", "startMode", DidiCardProvider.KEY_TRACE_ID, "chatSessionId", "requestSessionId", "B", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/Surface;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "F", "LXa/o;", "Lcom/stepos/agentframework/chatcore/intent/x;", "y", "()LXa/o;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/stepos/agentframework/chatcore/intent/x;)V", "u", "TAG", "Ljava/lang/String;", "LUa/M;", "scope", "LUa/M;", "LXa/j;", "robotAction", "LXa/j;", "robotCommand", "Leb/a;", "mutex", "Leb/a;", "", "fullScreenTaskHistory", "Ljava/util/List;", "Companion", Const.INTENT_KEY_APIKEY, "RobotCallback", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RobotManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<RobotManager> instance$delegate = C4848b.a(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.intent.l
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return RobotManager.t();
        }
    });
    private final String TAG = "RobotManager";
    private final M scope = kotlinx.coroutines.d.a(Y.c().plus(JobKt__JobKt.b(null, 1, null)));
    private final Xa.j<TaskRobotAction> robotAction = Xa.p.b(0, 0, null, 7, null);
    private final Xa.j<Object> robotCommand = Xa.p.b(0, 0, null, 7, null);
    private final InterfaceC4021a mutex = eb.f.b(false, 1, null);
    private final List<String> fullScreenTaskHistory = new ArrayList();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/RobotManager$RobotCallback;", "Lcom/stepos/agentframework/chatcore/intent/j;", "<init>", "(Lcom/stepos/agentframework/chatcore/intent/RobotManager;)V", "Lcom/stepos/agentframework/chatcore/intent/g;", "progress", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/intent/g;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class RobotCallback implements j {
        public RobotCallback() {
        }

        @Override // com.stepos.agentframework.chatcore.intent.j
        public void a(GuiTaskProgress progress) {
            kotlin.jvm.internal.p.i(progress, "progress");
            C4148a.k(RobotManager.this.TAG, "RobotCallback: " + progress.getTaskId() + ", " + progress.getTaskName() + ", " + progress.getAction() + " ," + progress.getBitmapId() + ", " + progress.getBitmap() + ", " + progress.getMessage(), false, 4, null);
            Function2.a(new RobotManager$RobotCallback$onProgress$1(RobotManager.this, progress, null));
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\n\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/RobotManager$a;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/intent/RobotManager;", "instance$delegate", "LY8/h;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/chatcore/intent/RobotManager;", "getInstance$annotations", "instance", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.intent.RobotManager$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final RobotManager a() {
            return (RobotManager) RobotManager.instance$delegate.getValue();
        }

        public Companion() {
        }
    }

    public static /* synthetic */ void C(RobotManager robotManager, int i10, String str, String str2, String str3, Surface surface, String str4, int i11, String str5, String str6, String str7, int i12, Object obj) {
        String str8;
        RobotManager robotManager2;
        int i13;
        String str9;
        String str10;
        String str11;
        Surface surface2;
        String str12 = (i12 & 32) != 0 ? "doubao-1.5-ui-tars" : str4;
        int i14 = (i12 & 64) != 0 ? 0 : i11;
        String str13 = (i12 & 128) != 0 ? "" : str5;
        String str14 = (i12 & 256) != 0 ? null : str6;
        if ((i12 & 512) != 0) {
            str8 = null;
            i13 = i10;
            str9 = str;
            str10 = str2;
            str11 = str3;
            surface2 = surface;
            robotManager2 = robotManager;
        } else {
            str8 = str7;
            robotManager2 = robotManager;
            i13 = i10;
            str9 = str;
            str10 = str2;
            str11 = str3;
            surface2 = surface;
        }
        robotManager2.B(i13, str9, str10, str11, surface2, str12, i14, str13, str14, str8);
    }

    public static final Y8.t E(String str) {
        AgentServiceClient.f22085a.G(str);
        return Y8.t.f7040a;
    }

    public static final Y8.t H(String str) {
        AgentServiceClient.f22085a.p0(str);
        return Y8.t.f7040a;
    }

    public static final Y8.t J(String str, GuiTaskConfig guiTaskConfig) {
        AgentServiceClient.f22085a.r0(str, guiTaskConfig);
        return Y8.t.f7040a;
    }

    public static final Y8.t L(String str) {
        AgentServiceClient.f22085a.l0(str);
        return Y8.t.f7040a;
    }

    public static final Y8.t p(String str) {
        AgentServiceClient.f22085a.N(str);
        return Y8.t.f7040a;
    }

    public static final Y8.t r(String str) {
        AgentServiceClient.f22085a.Q(str);
        return Y8.t.f7040a;
    }

    public static final RobotManager t() {
        return new RobotManager();
    }

    public static final boolean v(RobotManager robotManager, String it) {
        kotlin.jvm.internal.p.i(it, "it");
        C4148a.k(robotManager.TAG, "resumeAllGui: " + it, false, 4, null);
        TaskDispatcher.INSTANCE.a().w(it);
        return true;
    }

    public static final Y8.t x(String str) {
        AgentServiceClient.f22085a.d0(str);
        return Y8.t.f7040a;
    }

    public final void A(TaskRobotAction action) {
        kotlin.jvm.internal.p.i(action, "action");
        C4148a.k(this.TAG, "sendActionData action:" + action, false, 4, null);
        C1060i.d(this.scope, null, null, new RobotManager$sendActionData$1(this, action, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B(int r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, android.view.Surface r21, java.lang.String r22, int r23, java.lang.String r24, java.lang.String r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.intent.RobotManager.B(int, java.lang.String, java.lang.String, java.lang.String, android.view.Surface, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final void D(final String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        C4148a.k(this.TAG, "stopTask taskId:" + taskId, false, 4, null);
        d.INSTANCE.n(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.intent.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RobotManager.E(taskId);
            }
        });
        F(taskId);
    }

    public final void F(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        TaskDispatcher.INSTANCE.a().q(taskId);
    }

    public final void G(final String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        C4148a.k(this.TAG, "unTakeOverGui taskId:" + taskId, false, 4, null);
        d.INSTANCE.n(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.intent.s
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RobotManager.H(taskId);
            }
        });
    }

    public final void I(final String taskId, String toolCallId, Surface surface) {
        String str;
        Surface surface2;
        final GuiTaskConfig guiTaskConfig;
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        kotlin.jvm.internal.p.i(surface, "surface");
        C4148a.k(this.TAG, "updateGuiAgent taskId:" + taskId, false, 4, null);
        TaskDispatcher.Companion aVar = TaskDispatcher.INSTANCE;
        GuiTaskConfig guiTaskConfigL = aVar.a().l(taskId);
        if (guiTaskConfigL != null) {
            guiTaskConfig = GuiTaskConfig.b(guiTaskConfigL, toolCallId, surface, null, 0, 0, null, null, null, 252, null);
            str = toolCallId;
            surface2 = surface;
            if (guiTaskConfig == null) {
            }
            aVar.a().v(taskId, guiTaskConfig);
            d.INSTANCE.n(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.intent.p
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return RobotManager.J(taskId, guiTaskConfig);
                }
            });
        }
        str = toolCallId;
        surface2 = surface;
        guiTaskConfig = new GuiTaskConfig(str, surface2, null, 0, 0, null, null, null, 252, null);
        aVar.a().v(taskId, guiTaskConfig);
        d.INSTANCE.n(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.intent.p
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RobotManager.J(taskId, guiTaskConfig);
            }
        });
    }

    public final void K(final String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        C4148a.k(this.TAG, "userTakeOver taskId:" + taskId, false, 4, null);
        d.INSTANCE.n(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.intent.q
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RobotManager.L(taskId);
            }
        });
        this.fullScreenTaskHistory.add(taskId);
    }

    public final void o(final String taskId) {
        C4148a.k(this.TAG, "dismissFullScreenOverlay taskId:" + taskId, false, 4, null);
        d.INSTANCE.n(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.intent.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RobotManager.p(taskId);
            }
        });
    }

    public final void q(final String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        C4148a.k(this.TAG, "fullScreenGui taskId:" + taskId, false, 4, null);
        d.INSTANCE.n(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.intent.r
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RobotManager.r(taskId);
            }
        });
        this.fullScreenTaskHistory.add(taskId);
        Function2.b(new RobotManager$fullScreenGui$2(taskId, this, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01f1 A[Catch: all -> 0x024a, TRY_LEAVE, TryCatch #2 {all -> 0x024a, blocks: (B:81:0x0369, B:103:0x0453, B:71:0x02e3, B:64:0x0292, B:43:0x01ce, B:45:0x01f1, B:36:0x0190, B:39:0x019e, B:58:0x024d, B:60:0x0257, B:65:0x02ad, B:67:0x02b7, B:72:0x02fe, B:74:0x0308, B:75:0x0321, B:77:0x0330, B:82:0x0384, B:84:0x038e, B:85:0x03a5, B:87:0x03af, B:88:0x03c6, B:90:0x03d0, B:91:0x03e7, B:93:0x03f1, B:94:0x0407, B:96:0x0411, B:99:0x041c, B:101:0x0424, B:102:0x043c), top: B:112:0x0190 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /* JADX WARN: Type inference failed for: r18v0, types: [com.stepos.agentframework.chatcore.intent.RobotManager] */
    /* JADX WARN: Type inference failed for: r1v2, types: [eb.a] */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r4v16, types: [eb.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, android.graphics.Bitmap r23, java.lang.String r24, e9.InterfaceC4014c<? super Y8.t> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1138
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.intent.RobotManager.s(java.lang.String, java.lang.String, java.lang.String, java.lang.String, android.graphics.Bitmap, java.lang.String, e9.c):java.lang.Object");
    }

    public final void u() {
        C4148a.k(this.TAG, "resumeAllGui", false, 4, null);
        Z8.A.L(this.fullScreenTaskHistory, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.intent.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(RobotManager.v(this.f22431a, (String) obj));
            }
        });
    }

    public final void w(final String taskId) {
        C4148a.k(this.TAG, "resumeFullScreenOverlay taskId:" + taskId, false, 4, null);
        d.INSTANCE.n(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.intent.t
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RobotManager.x(taskId);
            }
        });
    }

    public final Xa.o<TaskRobotAction> y() {
        return Xa.d.b(this.robotAction);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(java.lang.String r7, android.graphics.Bitmap r8, e9.InterfaceC4014c<? super java.lang.String> r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.stepos.agentframework.chatcore.intent.RobotManager$saveRobotCaptureImageToFile$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.agentframework.chatcore.intent.RobotManager$saveRobotCaptureImageToFile$1 r0 = (com.stepos.agentframework.chatcore.intent.RobotManager$saveRobotCaptureImageToFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.intent.RobotManager$saveRobotCaptureImageToFile$1 r0 = new com.stepos.agentframework.chatcore.intent.RobotManager$saveRobotCaptureImageToFile$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.L$2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$1
            android.graphics.Bitmap r7 = (android.graphics.Bitmap) r7
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.C4849c.b(r9)
            goto L80
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.C4849c.b(r9)
            long r4 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r7)
            java.lang.String r2 = "/"
            r9.append(r2)
            r9.append(r4)
            java.lang.String r2 = ".jpeg"
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            com.stepos.agentframework.chatcore.utils.o r2 = com.stepos.agentframework.chatcore.utils.o.INSTANCE
            com.stepos.agentframework.chatcore.session.ChatCoreSdk r4 = com.stepos.agentframework.chatcore.session.ChatCoreSdk.INSTANCE
            android.content.Context r4 = r4.c()
            java.lang.Object r7 = g9.h.a(r7)
            r0.L$0 = r7
            java.lang.Object r7 = g9.h.a(r8)
            r0.L$1 = r7
            java.lang.Object r7 = g9.h.a(r9)
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r9 = r2.b(r4, r9, r8, r0)
            if (r9 != r1) goto L80
            return r1
        L80:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r6 = r6.TAG
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "saveRobotCaptureToFile: "
            r7.append(r8)
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            r8 = 4
            r0 = 0
            r1 = 0
            h8.C4148a.k(r6, r7, r1, r8, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.intent.RobotManager.z(java.lang.String, android.graphics.Bitmap, e9.c):java.lang.Object");
    }
}
