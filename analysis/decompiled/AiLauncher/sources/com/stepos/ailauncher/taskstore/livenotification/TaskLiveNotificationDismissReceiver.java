package com.stepos.ailauncher.taskstore.livenotification;

import Ua.C1056g;
import Ua.C1060i;
import Ua.L0;
import Ua.Y;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ConversationSessionIds;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Locale;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ \u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/TaskLiveNotificationDismissReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "appContext", "", "sessionId", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Companion", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskLiveNotificationDismissReceiver extends BroadcastReceiver {
    public static final String ACTION_DISMISS = "com.stepos.ailauncher.taskstore.LIVE_NOTIFICATION_DISMISS";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_FROM_CLICK = "fromClick";
    public static final String EXTRA_SESSION_ID = "sessionId";
    public static final String EXTRA_STATUS = "status";
    private static final String TAG = "TaskLiveNotification";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/TaskLiveNotificationDismissReceiver$a;", "", "<init>", "()V", "", "status", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Z", "TAG", "Ljava/lang/String;", "ACTION_DISMISS", "EXTRA_SESSION_ID", "EXTRA_STATUS", "EXTRA_FROM_CLICK", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDismissReceiver$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean b(String status) {
            String upperCase;
            if (status != null) {
                upperCase = status.toUpperCase(Locale.ROOT);
                kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
            } else {
                upperCase = null;
            }
            return kotlin.jvm.internal.p.d(upperCase, "COMPLETED") || kotlin.jvm.internal.p.d(upperCase, "FAILED");
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDismissReceiver$onReceive$1", f = "TaskLiveNotificationDismissReceiver.kt", l = {52, 80, 99, 112}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDismissReceiver$onReceive$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ Context $appContext;
        final /* synthetic */ boolean $fromClick;
        final /* synthetic */ BroadcastReceiver.PendingResult $pendingResult;
        final /* synthetic */ String $sessionId;
        final /* synthetic */ String $status;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        final /* synthetic */ TaskLiveNotificationDismissReceiver this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z10, String str, String str2, TaskLiveNotificationDismissReceiver taskLiveNotificationDismissReceiver, Context context, BroadcastReceiver.PendingResult pendingResult, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$fromClick = z10;
            this.$status = str;
            this.$sessionId = str2;
            this.this$0 = taskLiveNotificationDismissReceiver;
            this.$appContext = context;
            this.$pendingResult = pendingResult;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$fromClick, this.$status, this.$sessionId, this.this$0, this.$appContext, this.$pendingResult, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:11|(3:135|12|13)|131|112|119|(1:121)|122|104|(13:106|133|107|108|109|(2:111|128)|131|112|119|(0)|122|104|(5:123|124|(1:126)|129|130)(0))(0)) */
        /* JADX WARN: Can't wrap try/catch for region: R(9:16|(3:141|17|18)|139|80|87|(1:89)|90|73|(5:75|145|76|(8:79|139|80|87|(0)|90|73|(7:91|92|(6:97|(4:100|(3:148|102|151)(1:150)|149|98)|147|103|104|(0)(0))|124|(0)|129|130)(0))|128)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x0300, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x0365, code lost:
        
            if (r0.b(r4, r5, r19) == r3) goto L128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0209, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Path cross not found for [B:68:0x0197, B:70:0x01a1], limit reached: 148 */
        /* JADX WARN: Removed duplicated region for block: B:100:0x025f  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0286  */
        /* JADX WARN: Removed duplicated region for block: B:121:0x0314  */
        /* JADX WARN: Removed duplicated region for block: B:123:0x0330  */
        /* JADX WARN: Removed duplicated region for block: B:126:0x0336  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x015b  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0177  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x01ac  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x01bd  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x021e  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x023c  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0241  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:110:0x02c3 -> B:131:0x02c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:118:0x0304 -> B:119:0x030e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x01f8 -> B:139:0x01fa). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x020e -> B:87:0x0218). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 880
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDismissReceiver.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object b(Context context, String str, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        String strK = ConversationSessionIds.INSTANCE.k(str);
        Log.d(TAG, "navigateToChat sessionId=" + str + " visible=" + strK);
        Object objJ = C1056g.j(Y.c(), new TaskLiveNotificationDismissReceiver$navigateToChat$2(context, strK, null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : Y8.t.f7040a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(intent, "intent");
        if (kotlin.jvm.internal.p.d(intent.getAction(), ACTION_DISMISS)) {
            String stringExtra = intent.getStringExtra("sessionId");
            if (stringExtra == null) {
                stringExtra = "";
            }
            String str = stringExtra;
            String stringExtra2 = intent.getStringExtra("status");
            boolean booleanExtra = intent.getBooleanExtra(EXTRA_FROM_CLICK, false);
            if (La.H.x0(str)) {
                Log.w(TAG, "onReceive: blank sessionId, ignored");
                return;
            }
            Log.d(TAG, "onReceive sessionId=" + str + " status=" + stringExtra2 + " fromClick=" + booleanExtra);
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            Context applicationContext = context.getApplicationContext();
            C1060i.d(kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b())), null, null, new AnonymousClass1(booleanExtra, stringExtra2, str, this, applicationContext, pendingResultGoAsync, null), 3, null);
            if (booleanExtra && INSTANCE.b(stringExtra2)) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    T t10 = T.INSTANCE;
                    kotlin.jvm.internal.p.f(applicationContext);
                    t10.n(applicationContext, str);
                    objB = Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    Log.w(TAG, "cancel live notification failed sessionId=" + str, thE);
                }
            }
        }
    }
}
