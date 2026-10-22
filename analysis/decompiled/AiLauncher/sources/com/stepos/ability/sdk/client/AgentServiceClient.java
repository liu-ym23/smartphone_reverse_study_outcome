package com.stepos.ability.sdk.client;

import Ua.C1056g;
import Ua.Y;
import Z8.F;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.IAgentServiceManager;
import com.stepos.ability.ITaskListener;
import com.stepos.ability.bean.OriginalTaskConfig;
import com.stepos.ability.bean.SlaPermissionResult;
import com.stepos.ability.bean.TaskConfig;
import com.stepos.ability.common.TaskStatus;
import com.stepos.ailauncher.chat.activity.ChatMainActivity;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0002\u0081\u0001\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0085\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J+\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J!\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\"\u0010#J'\u0010%\u001a\u00020\u00042\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010\u0003J-\u0010/\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\u0004¢\u0006\u0004\b1\u0010\u0003J\r\u00102\u001a\u00020\u0016¢\u0006\u0004\b2\u00103J\u0015\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b:\u00109J\u0015\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0006¢\u0006\u0004\b<\u0010=J\u0015\u0010>\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0006¢\u0006\u0004\b>\u0010=J\u0015\u0010?\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0006¢\u0006\u0004\b?\u0010=J\u0015\u0010@\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0006¢\u0006\u0004\b@\u0010=J\u001d\u0010C\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u00062\u0006\u0010B\u001a\u00020A¢\u0006\u0004\bC\u0010DJ%\u0010G\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u0006¢\u0006\u0004\bG\u0010HJ\u001d\u0010I\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u0006¢\u0006\u0004\bI\u0010JJ\u0019\u0010K\u001a\u00020\u00042\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bK\u0010=J\u0019\u0010L\u001a\u00020\u00042\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bL\u0010=J\u001e\u0010P\u001a\u00020O2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00060MH\u0086@¢\u0006\u0004\bP\u0010QR\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\u0012R\u0016\u0010^\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010\u0012R\u0016\u0010`\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010\u0012R\u0014\u0010c\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR@\u0010h\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b0dj\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b`e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR \u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010o\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010s\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010\u0012R\u001a\u0010z\u001a\b\u0012\u0004\u0012\u00020w0v8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR$\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0015\u0010\u0080\u0001\u001a\u00020}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0084\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001¨\u0006\u0086\u0001"}, d2 = {"Lcom/stepos/ability/sdk/client/AgentServiceClient;", "", "<init>", "()V", "LY8/t;", "K", "", "actionName", "Lkotlin/Function1;", "Lcom/stepos/ability/IAgentServiceManager;", "block", "t0", "(Ljava/lang/String;Lp9/l;)V", "Lcom/stepos/ability/ITaskListener;", "listener", "X", "(Lcom/stepos/ability/ITaskListener;)Ljava/lang/String;", "sm", "Z", "(Lcom/stepos/ability/IAgentServiceManager;)V", "F", ExifInterface.LONGITUDE_EAST, "", "success", "Ljava/util/concurrent/atomic/AtomicBoolean;", "invoked", "M", "(ZLjava/util/concurrent/atomic/AtomicBoolean;)V", "callbackInvoked", "f0", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "Landroid/content/Intent;", "B", "()Landroid/content/Intent;", "P", "(Z)V", "callback", "C", "(Lp9/l;)V", "Lcom/stepos/ability/bean/TaskConfig;", "taskConfig", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Lcom/stepos/ability/bean/TaskConfig;)V", "Y", "Landroid/content/Context;", "context", "stateCallback", ExifInterface.LATITUDE_SOUTH, "(Landroid/content/Context;Lp9/l;)V", "c0", ExifInterface.LONGITUDE_WEST, "()Z", "Lcom/stepos/ability/sdk/client/t;", "toolTaskConfig", "h0", "(Lcom/stepos/ability/sdk/client/t;)V", "a0", "(Lcom/stepos/ability/ITaskListener;)V", "n0", "taskId", "l0", "(Ljava/lang/String;)V", "p0", "Q", "G", "Lcom/stepos/ability/sdk/client/r;", "config", "r0", "(Ljava/lang/String;Lcom/stepos/ability/sdk/client/r;)V", "requestId", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "j0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "I", "(Ljava/lang/String;Ljava/lang/String;)V", "N", "d0", "", "functions", "Lcom/stepos/ability/bean/SlaPermissionResult;", "L", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "Landroid/content/Context;", "c", "Lcom/stepos/ability/IAgentServiceManager;", "serviceManager", "Landroid/content/ServiceConnection;", Const.INTENT_KEY_UMID, "Landroid/content/ServiceConnection;", "serviceConnection", "e", "bindingInProgress", "f", "serviceStarted", Const.INTENT_KEY_BACKGROUND_COMMAND, "serviceBound", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/lang/Object;", "bindLock", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/util/ArrayList;", "pendingBindCallbacks", "Ljava/util/concurrent/ConcurrentHashMap;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Ljava/util/concurrent/ConcurrentHashMap;", "registeredTaskListeners", "k", "Ljava/util/concurrent/atomic/AtomicBoolean;", "currentBindCallbackInvoked", "Ljava/lang/Runnable;", "l", "Ljava/lang/Runnable;", "currentBindTimeoutRunnable", "m", "initialized", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/stepos/ability/sdk/client/AgentServiceClient$a;", "n", "Ljava/util/concurrent/CopyOnWriteArrayList;", "connectionCallbacks", "o", "Lp9/l;", "Landroid/os/IBinder$DeathRecipient;", "p", "Landroid/os/IBinder$DeathRecipient;", "binderDeathRecipient", "com/stepos/ability/sdk/client/AgentServiceClient$b", "q", "Lcom/stepos/ability/sdk/client/AgentServiceClient$b;", "agentServiceConnection", Const.INTENT_KEY_APIKEY, "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes2.dex */
public final class AgentServiceClient {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static volatile IAgentServiceManager serviceManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static volatile ServiceConnection serviceConnection;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static volatile boolean bindingInProgress;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static volatile boolean serviceStarted;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static volatile boolean serviceBound;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static volatile AtomicBoolean currentBindCallbackInvoked;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public static volatile Runnable currentBindTimeoutRunnable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public static volatile boolean initialized;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public static InterfaceC5074l<? super Boolean, Y8.t> stateCallback;

    /* renamed from: a, reason: collision with root package name */
    public static final AgentServiceClient f22085a = new AgentServiceClient();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Object bindLock = new Object();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final ArrayList<InterfaceC5074l<Boolean, Y8.t>> pendingBindCallbacks = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final ConcurrentHashMap<String, ITaskListener> registeredTaskListeners = new ConcurrentHashMap<>();

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public static final CopyOnWriteArrayList<a> connectionCallbacks = new CopyOnWriteArrayList<>();

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public static final IBinder.DeathRecipient binderDeathRecipient = new IBinder.DeathRecipient() { // from class: com.stepos.ability.sdk.client.a
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            AgentServiceClient.D();
        }
    };

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public static final b agentServiceConnection = new b();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/stepos/ability/sdk/client/AgentServiceClient$a;", "", "LY8/t;", "onConnected", "()V", "onDisconnected", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        default void onConnected() {
        }

        default void onDisconnected() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ability/sdk/client/AgentServiceClient$b", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "LY8/t;", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            Object objB;
            Y8.t tVar;
            IAgentServiceManager iAgentServiceManagerAsInterface = IAgentServiceManager.Stub.asInterface(service);
            AgentServiceClient.serviceManager = iAgentServiceManagerAsInterface;
            try {
                Result.Companion companion = Result.INSTANCE;
                if (service != null) {
                    service.linkToDeath(AgentServiceClient.binderDeathRecipient, 0);
                    tVar = Y8.t.f7040a;
                } else {
                    tVar = null;
                }
                Result.b(tVar);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
            AtomicBoolean atomicBoolean = AgentServiceClient.currentBindCallbackInvoked;
            AgentServiceClient agentServiceClient = AgentServiceClient.f22085a;
            agentServiceClient.F();
            AgentServiceClient.currentBindCallbackInvoked = null;
            kotlin.jvm.internal.p.f(iAgentServiceManagerAsInterface);
            agentServiceClient.Z(iAgentServiceManagerAsInterface);
            agentServiceClient.M(true, atomicBoolean);
            InterfaceC5074l interfaceC5074l = AgentServiceClient.stateCallback;
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(Boolean.TRUE);
            }
            for (a aVar : AgentServiceClient.connectionCallbacks) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    aVar.onConnected();
                    objB = Result.b(Y8.t.f7040a);
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th2));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    V3.b.f6474a.i("Ability_AgentServiceClient", "onConnected callback threw", thE);
                }
            }
            V3.b.c(V3.b.f6474a, "Ability_AgentServiceClient", "onServiceConnected", null, 4, null);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Object objB;
            AgentServiceClient.serviceManager = null;
            AgentServiceClient.serviceBound = false;
            AtomicBoolean atomicBoolean = AgentServiceClient.currentBindCallbackInvoked;
            AgentServiceClient agentServiceClient = AgentServiceClient.f22085a;
            agentServiceClient.F();
            AgentServiceClient.currentBindCallbackInvoked = null;
            agentServiceClient.M(false, atomicBoolean);
            InterfaceC5074l interfaceC5074l = AgentServiceClient.stateCallback;
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(Boolean.FALSE);
            }
            for (a aVar : AgentServiceClient.connectionCallbacks) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    aVar.onDisconnected();
                    objB = Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    V3.b.f6474a.i("Ability_AgentServiceClient", "onDisconnected callback threw", thE);
                }
            }
            V3.b.c(V3.b.f6474a, "Ability_AgentServiceClient", "onServiceDisconnected", null, 4, null);
        }
    }

    public static final void D() {
        V3.b.j(V3.b.f6474a, "Ability_AgentServiceClient", "binder died — clearing state", null, 4, null);
        serviceManager = null;
        serviceBound = false;
    }

    public static final Y8.t H(String str, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.p.i(it, "it");
        it.updateTaskStatusAndControl(str, TaskStatus.CANCELLED.getCode());
        return Y8.t.f7040a;
    }

    public static final Y8.t J(String str, String str2, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.p.i(it, "it");
        it.cancelUserInput(str, str2);
        return Y8.t.f7040a;
    }

    public static final Y8.t O(String str, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.p.i(it, "it");
        it.dismissFullScreenOverlay(str);
        return Y8.t.f7040a;
    }

    public static final Y8.t R(String str, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.p.i(it, "it");
        it.fullScreenGui(str);
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void T(AgentServiceClient agentServiceClient, Context context2, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = null;
        }
        agentServiceClient.S(context2, interfaceC5074l);
    }

    public static final Y8.t U(boolean z10) {
        if (z10) {
            V3.b.c(V3.b.f6474a, "Ability_AgentServiceClient", "Bind service success !", null, 4, null);
        } else {
            V3.b.e(V3.b.f6474a, "Ability_AgentServiceClient", "Bind service failed !", null, 4, null);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t b0(ITaskListener iTaskListener, String str, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.p.i(it, "it");
        it.registerTaskListener(iTaskListener, str);
        V3.b.c(V3.b.f6474a, "Ability_AgentServiceClient", "registerTaskListener done: key=" + str, null, 4, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t e0(String str, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.p.i(it, "it");
        it.resumeFullScreenOverlay(str);
        return Y8.t.f7040a;
    }

    public static final void g0(AtomicBoolean atomicBoolean) {
        if (atomicBoolean.compareAndSet(false, true)) {
            V3.b.j(V3.b.f6474a, "Ability_AgentServiceClient", "bind timeout", null, 4, null);
            f22085a.P(false);
        }
    }

    public static final Y8.t i0(t tVar, boolean z10) {
        Bundle bundle;
        if (serviceManager != null) {
            try {
                Context context2 = null;
                if (kotlin.jvm.internal.p.d(tVar.getName(), "add_task") || kotlin.jvm.internal.p.d(tVar.getName(), "update_task")) {
                    String params = tVar.getParams();
                    OriginalTaskConfig originalTaskConfigA = params != null ? T3.b.a(params) : null;
                    V3.b bVar = V3.b.f6474a;
                    V3.b.c(bVar, "Ability_AgentServiceClient", "submitToolTask OriginalTaskConfig: " + originalTaskConfigA, null, 4, null);
                    if (originalTaskConfigA == null) {
                        V3.b.e(bVar, "Ability_AgentServiceClient", "submitToolTask failed: originalTaskConfig is null", null, 4, null);
                        return Y8.t.f7040a;
                    }
                    V3.b.g(bVar, "Ability_AgentServiceClient", "originalTaskConfig.toolName:" + originalTaskConfigA.getToolName(), null, 4, null);
                    String toolName = originalTaskConfigA.getToolName();
                    if (toolName == null || toolName.length() == 0 || kotlin.jvm.internal.p.d(originalTaskConfigA.getToolName(), "null")) {
                        IAgentServiceManager iAgentServiceManager = serviceManager;
                        if (iAgentServiceManager != null) {
                            iAgentServiceManager.toolUpdateTask(T3.b.b(originalTaskConfigA));
                            Y8.t tVar2 = Y8.t.f7040a;
                        }
                    } else {
                        CommonConfig commonConfig = tVar.getCommonConfig();
                        if (commonConfig == null || (bundle = commonConfig.getExtra()) == null) {
                            bundle = new Bundle();
                        }
                        String string = bundle.getString("session_id");
                        if (string == null || string.length() == 0) {
                            Log.w("Ability_AgentServiceClient", "SDK Client sessionId is NULL! conversionId=" + tVar.getConversionId());
                        } else {
                            Log.i("Ability_AgentServiceClient", "SDK Client sessionId found: " + string);
                        }
                        Context context3 = context;
                        if (context3 == null) {
                            kotlin.jvm.internal.p.A("context");
                        } else {
                            context2 = context3;
                        }
                        String conversionId = tVar.getConversionId();
                        if (conversionId != null && conversionId.length() != 0) {
                            bundle.putString("conversationId", tVar.getConversionId());
                        }
                        Y8.t tVar3 = Y8.t.f7040a;
                        TaskConfig taskConfigC = T3.b.c(originalTaskConfigA, context2, bundle);
                        V3.b.c(bVar, "Ability_AgentServiceClient", "branch1 normal tool call " + taskConfigC, null, 4, null);
                        f22085a.V(taskConfigC);
                    }
                } else {
                    V3.b.c(V3.b.f6474a, "Ability_AgentServiceClient", "branch2 normal tool", null, 4, null);
                    AgentServiceClient agentServiceClient = f22085a;
                    Context context4 = context;
                    if (context4 == null) {
                        kotlin.jvm.internal.p.A("context");
                    } else {
                        context2 = context4;
                    }
                    agentServiceClient.V(u.a(tVar, context2));
                    Y8.t tVar4 = Y8.t.f7040a;
                }
            } catch (Exception e10) {
                V3.b.f6474a.d("Ability_AgentServiceClient", "submitTask failed", e10);
                Y8.t tVar5 = Y8.t.f7040a;
            }
        } else {
            V3.b.e(V3.b.f6474a, "Ability_AgentServiceClient", "submitTask failed: service not connected", null, 4, null);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t k0(String str, String str2, String str3, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.p.i(it, "it");
        it.submitUserInput(str, str2, str3);
        return Y8.t.f7040a;
    }

    public static final Y8.t m0(String str, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.p.i(it, "it");
        it.updateTaskStatusAndControl(str, TaskStatus.TAKE_OVER.getCode());
        return Y8.t.f7040a;
    }

    public static final Y8.t o0(String str, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.p.i(it, "it");
        it.unRegisterTaskListener(str);
        return Y8.t.f7040a;
    }

    public static final Y8.t q0(String str, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.p.i(it, "it");
        it.updateTaskStatusAndControl(str, TaskStatus.RUNNING.getCode());
        return Y8.t.f7040a;
    }

    public static final Y8.t s0(String str, GuiTaskConfig guiTaskConfig, IAgentServiceManager it) throws RemoteException {
        Bundle extra;
        String string;
        kotlin.jvm.internal.p.i(it, "it");
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_gui_agent_config", s.a(guiTaskConfig));
        CommonConfig commonConfig = guiTaskConfig.getCommonConfig();
        if (commonConfig != null && (extra = commonConfig.getExtra()) != null && (string = extra.getString(ChatMainActivity.EXTRA_CHAT_SESSION_ID)) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                bundle.putString(ChatMainActivity.EXTRA_CHAT_SESSION_ID, string);
            }
        }
        Y8.t tVar = Y8.t.f7040a;
        it.updateTask(str, bundle);
        return Y8.t.f7040a;
    }

    public static final Y8.t u0(String str, InterfaceC5074l interfaceC5074l, boolean z10) {
        V3.b bVar;
        IAgentServiceManager iAgentServiceManager;
        try {
            bVar = V3.b.f6474a;
        } catch (Exception e10) {
            e = e10;
        }
        try {
            V3.b.c(bVar, "Ability_AgentServiceClient", str, null, 4, null);
            iAgentServiceManager = serviceManager;
        } catch (Exception e11) {
            e = e11;
            str = str;
            Exception exc = e;
            V3.b.f6474a.b("Ability_AgentServiceClient", str + " failed", exc);
            return Y8.t.f7040a;
        }
        if (iAgentServiceManager != null) {
            interfaceC5074l.invoke(iAgentServiceManager);
            return Y8.t.f7040a;
        }
        V3.b.j(bVar, "Ability_AgentServiceClient", str + " skipped: not bound yet", null, 4, null);
        return Y8.t.f7040a;
    }

    public final Intent B() {
        Intent component = new Intent("com.stepos.ability.BIND_AGENT_SERVICE").setComponent(new ComponentName("com.stepos.ability", "com.stepos.ability.service.AgentService"));
        kotlin.jvm.internal.p.h(component, "setComponent(...)");
        return component;
    }

    public final void C(InterfaceC5074l<? super Boolean, Y8.t> callback) {
        if (serviceManager != null) {
            if (callback != null) {
                callback.invoke(Boolean.TRUE);
            }
            V3.b.c(V3.b.f6474a, "Ability_AgentServiceClient", "bind: reuse existing", null, 4, null);
            return;
        }
        synchronized (bindLock) {
            if (callback != null) {
                try {
                    pendingBindCallbacks.add(callback);
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (bindingInProgress) {
                V3.b.c(V3.b.f6474a, "Ability_AgentServiceClient", "bind: in progress, callback queued (queueSize=" + pendingBindCallbacks.size() + ")", null, 4, null);
                return;
            }
            bindingInProgress = true;
            Y8.t tVar = Y8.t.f7040a;
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            f0(atomicBoolean);
            if (serviceBound) {
                V3.b.c(V3.b.f6474a, "Ability_AgentServiceClient", "bind: waiting for BIND_AUTO_CREATE reconnect", null, 4, null);
                return;
            }
            V3.b.c(V3.b.f6474a, "Ability_AgentServiceClient", "bind: start+bind (serviceStarted=" + serviceStarted + ")", null, 4, null);
            Intent intentB = B();
            Context context2 = null;
            if (!serviceStarted) {
                try {
                    Context context3 = context;
                    if (context3 == null) {
                        kotlin.jvm.internal.p.A("context");
                        context3 = null;
                    }
                    context3.startService(intentB);
                    serviceStarted = true;
                } catch (Exception e10) {
                    V3.b.j(V3.b.f6474a, "Ability_AgentServiceClient", "startService failed: " + e10.getMessage(), null, 4, null);
                }
            }
            try {
                Context context4 = context;
                if (context4 == null) {
                    kotlin.jvm.internal.p.A("context");
                    context4 = null;
                }
                b bVar = agentServiceConnection;
                if (context4.bindService(intentB, bVar, 1)) {
                    serviceConnection = bVar;
                    serviceBound = true;
                    return;
                }
                V3.b.j(V3.b.f6474a, "Ability_AgentServiceClient", "bindService returned false — releasing", null, 4, null);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Context context5 = context;
                    if (context5 == null) {
                        kotlin.jvm.internal.p.A("context");
                    } else {
                        context2 = context5;
                    }
                    context2.unbindService(bVar);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th2));
                }
                E();
                if (atomicBoolean.compareAndSet(false, true)) {
                    P(false);
                }
            } catch (Exception e11) {
                V3.b.j(V3.b.f6474a, "Ability_AgentServiceClient", "bindService failed: " + e11.getMessage(), null, 4, null);
                E();
                if (atomicBoolean.compareAndSet(false, true)) {
                    P(false);
                }
            }
        }
    }

    public final void E() {
        F();
        currentBindCallbackInvoked = null;
    }

    public final void F() {
        Runnable runnable = currentBindTimeoutRunnable;
        if (runnable != null) {
            V3.d.f6476a.b().removeCallbacks(runnable);
        }
        currentBindTimeoutRunnable = null;
    }

    public final void G(final String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        t0("cancelTask " + taskId, new InterfaceC5074l() { // from class: com.stepos.ability.sdk.client.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentServiceClient.H(taskId, (IAgentServiceManager) obj);
            }
        });
    }

    public final void I(final String taskId, final String requestId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(requestId, "requestId");
        t0("cancelUserInput " + taskId + " " + requestId, new InterfaceC5074l() { // from class: com.stepos.ability.sdk.client.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentServiceClient.J(taskId, requestId, (IAgentServiceManager) obj);
            }
        });
    }

    public final void K() {
        if (initialized) {
            return;
        }
        V3.b.e(V3.b.f6474a, "Ability_AgentServiceClient", "AgentServiceClient not initialized. Call AgentServiceClient.init(context) first !", null, 4, null);
        throw new IllegalStateException("AgentServiceClient not initialized. Call AgentServiceClient.init(context) first !");
    }

    public final Object L(List<String> list, InterfaceC4014c<? super SlaPermissionResult> interfaceC4014c) {
        return C1056g.j(Y.b(), new AgentServiceClient$checkSlaPermission$2(list, null), interfaceC4014c);
    }

    public final void M(boolean success, AtomicBoolean invoked) {
        if (invoked != null && invoked.compareAndSet(false, true)) {
            P(success);
            return;
        }
        synchronized (bindLock) {
            try {
                if (bindingInProgress) {
                    bindingInProgress = false;
                    ArrayList<InterfaceC5074l<Boolean, Y8.t>> arrayList = pendingBindCallbacks;
                    List<InterfaceC5074l> listM1 = F.m1(arrayList);
                    arrayList.clear();
                    for (InterfaceC5074l interfaceC5074l : listM1) {
                        if (interfaceC5074l != null) {
                            interfaceC5074l.invoke(Boolean.valueOf(success));
                        }
                    }
                    Y8.t tVar = Y8.t.f7040a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void N(final String taskId) {
        t0("dismissFullScreenOverlay " + taskId, new InterfaceC5074l() { // from class: com.stepos.ability.sdk.client.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentServiceClient.O(taskId, (IAgentServiceManager) obj);
            }
        });
    }

    public final void P(boolean success) {
        List<InterfaceC5074l> listM1;
        synchronized (bindLock) {
            bindingInProgress = false;
            ArrayList<InterfaceC5074l<Boolean, Y8.t>> arrayList = pendingBindCallbacks;
            listM1 = F.m1(arrayList);
            arrayList.clear();
            Y8.t tVar = Y8.t.f7040a;
        }
        for (InterfaceC5074l interfaceC5074l : listM1) {
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(Boolean.valueOf(success));
            }
        }
    }

    public final void Q(final String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        t0("fullScreenGui " + taskId, new InterfaceC5074l() { // from class: com.stepos.ability.sdk.client.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentServiceClient.R(taskId, (IAgentServiceManager) obj);
            }
        });
    }

    public final void S(Context context2, InterfaceC5074l<? super Boolean, Y8.t> stateCallback2) {
        kotlin.jvm.internal.p.i(context2, "context");
        stateCallback = stateCallback2;
        if (initialized) {
            V3.b.g(V3.b.f6474a, "Ability_AgentServiceClient", "Init ignore. Cause already init.", null, 4, null);
            return;
        }
        V3.b.g(V3.b.f6474a, "Ability_AgentServiceClient", "Init start.", null, 4, null);
        initialized = true;
        Context applicationContext = context2.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        context = applicationContext;
        C(new InterfaceC5074l() { // from class: com.stepos.ability.sdk.client.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentServiceClient.U(((Boolean) obj).booleanValue());
            }
        });
    }

    public final void V(TaskConfig taskConfig) throws Exception {
        V3.b.c(V3.b.f6474a, "Ability_AgentServiceClient", "internalSubmitTask taskConfig" + taskConfig, null, 4, null);
        IAgentServiceManager iAgentServiceManager = serviceManager;
        if (iAgentServiceManager != null) {
            iAgentServiceManager.submitTask(taskConfig);
        }
    }

    public final boolean W() {
        return initialized;
    }

    public final String X(ITaskListener listener) {
        Context context2 = context;
        if (context2 == null) {
            kotlin.jvm.internal.p.A("context");
            context2 = null;
        }
        return context2.getPackageName() + Const.STR_MART_WELL + System.identityHashCode(listener);
    }

    public final void Y() {
        V3.b.g(V3.b.f6474a, "Ability_AgentServiceClient", "SDK version=1.9", null, 4, null);
    }

    public final void Z(IAgentServiceManager sm) {
        ConcurrentHashMap<String, ITaskListener> concurrentHashMap = registeredTaskListeners;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, ITaskListener> entry : concurrentHashMap.entrySet()) {
            String key = entry.getKey();
            try {
                sm.registerTaskListener(entry.getValue(), key);
                V3.b.c(V3.b.f6474a, "Ability_AgentServiceClient", "reRegisterTaskListener done: key=" + key, null, 4, null);
            } catch (Exception e10) {
                V3.b.f6474a.i("Ability_AgentServiceClient", "reRegisterTaskListener failed: key=" + key, e10);
            }
        }
    }

    public final void a0(final ITaskListener listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        K();
        final String strX = X(listener);
        registeredTaskListeners.put(strX, listener);
        Context context2 = context;
        if (context2 == null) {
            kotlin.jvm.internal.p.A("context");
            context2 = null;
        }
        t0("registerTaskListener " + context2.getPackageName() + " listener:" + listener, new InterfaceC5074l() { // from class: com.stepos.ability.sdk.client.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentServiceClient.b0(listener, strX, (IAgentServiceManager) obj);
            }
        });
    }

    public final void c0() {
        ServiceConnection serviceConnection2;
        List<InterfaceC5074l> listM1;
        Object objB;
        if (!initialized) {
            V3.b.g(V3.b.f6474a, "Ability_AgentServiceClient", "release ignore: not initialized", null, 4, null);
            return;
        }
        V3.b.g(V3.b.f6474a, "Ability_AgentServiceClient", "release start", null, 4, null);
        E();
        synchronized (bindLock) {
            serviceConnection2 = serviceConnection;
            ArrayList<InterfaceC5074l<Boolean, Y8.t>> arrayList = pendingBindCallbacks;
            listM1 = F.m1(arrayList);
            arrayList.clear();
            bindingInProgress = false;
            serviceManager = null;
            serviceConnection = null;
            serviceStarted = false;
            serviceBound = false;
            initialized = false;
            registeredTaskListeners.clear();
            Y8.t tVar = Y8.t.f7040a;
        }
        if (serviceConnection2 != null) {
            try {
                Context context2 = context;
                if (context2 == null) {
                    kotlin.jvm.internal.p.A("context");
                    context2 = null;
                }
                context2.unbindService(serviceConnection2);
            } catch (Exception e10) {
                V3.b.j(V3.b.f6474a, "Ability_AgentServiceClient", "release unbindService: " + e10.getMessage(), null, 4, null);
            }
        }
        for (InterfaceC5074l interfaceC5074l : listM1) {
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(Boolean.FALSE);
            }
        }
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l2 = stateCallback;
        if (interfaceC5074l2 != null) {
            interfaceC5074l2.invoke(Boolean.FALSE);
        }
        for (a aVar : connectionCallbacks) {
            try {
                Result.Companion companion = Result.INSTANCE;
                aVar.onDisconnected();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                V3.b.f6474a.i("Ability_AgentServiceClient", "release: onDisconnected callback threw", thE);
            }
        }
        connectionCallbacks.clear();
        stateCallback = null;
        V3.b.c(V3.b.f6474a, "Ability_AgentServiceClient", "release done", null, 4, null);
    }

    public final void d0(final String taskId) {
        t0("resumeFullScreenOverlay " + taskId, new InterfaceC5074l() { // from class: com.stepos.ability.sdk.client.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentServiceClient.e0(taskId, (IAgentServiceManager) obj);
            }
        });
    }

    public final void f0(final AtomicBoolean callbackInvoked) {
        E();
        Runnable runnable = new Runnable() { // from class: com.stepos.ability.sdk.client.d
            @Override // java.lang.Runnable
            public final void run() {
                AgentServiceClient.g0(callbackInvoked);
            }
        };
        currentBindTimeoutRunnable = runnable;
        currentBindCallbackInvoked = callbackInvoked;
        V3.d.f6476a.b().postDelayed(runnable, 4000L);
    }

    public final void h0(final t toolTaskConfig) {
        kotlin.jvm.internal.p.i(toolTaskConfig, "toolTaskConfig");
        K();
        Y();
        V3.b.c(V3.b.f6474a, "Ability_AgentServiceClient", "submitToolTask " + toolTaskConfig, null, 4, null);
        C(new InterfaceC5074l() { // from class: com.stepos.ability.sdk.client.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentServiceClient.i0(toolTaskConfig, ((Boolean) obj).booleanValue());
            }
        });
    }

    public final void j0(final String taskId, final String requestId, final String content) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(content, "content");
        t0("submitUserInput " + taskId + " " + requestId, new InterfaceC5074l() { // from class: com.stepos.ability.sdk.client.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentServiceClient.k0(taskId, requestId, content, (IAgentServiceManager) obj);
            }
        });
    }

    public final void l0(final String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        t0("takeOverGui " + taskId, new InterfaceC5074l() { // from class: com.stepos.ability.sdk.client.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentServiceClient.m0(taskId, (IAgentServiceManager) obj);
            }
        });
    }

    public final void n0(ITaskListener listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        K();
        final String strX = X(listener);
        registeredTaskListeners.remove(strX);
        Context context2 = context;
        if (context2 == null) {
            kotlin.jvm.internal.p.A("context");
            context2 = null;
        }
        t0("unRegisterTaskListener " + context2.getPackageName() + " listener:" + listener, new InterfaceC5074l() { // from class: com.stepos.ability.sdk.client.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentServiceClient.o0(strX, (IAgentServiceManager) obj);
            }
        });
    }

    public final void p0(final String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        t0("unTakeOverGui " + taskId, new InterfaceC5074l() { // from class: com.stepos.ability.sdk.client.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentServiceClient.q0(taskId, (IAgentServiceManager) obj);
            }
        });
    }

    public final void r0(final String taskId, final GuiTaskConfig config) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(config, "config");
        t0("updateGuiAgent " + taskId, new InterfaceC5074l() { // from class: com.stepos.ability.sdk.client.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentServiceClient.s0(taskId, config, (IAgentServiceManager) obj);
            }
        });
    }

    public final void t0(final String actionName, final InterfaceC5074l<? super IAgentServiceManager, Y8.t> block) {
        K();
        C(new InterfaceC5074l() { // from class: com.stepos.ability.sdk.client.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentServiceClient.u0(actionName, block, ((Boolean) obj).booleanValue());
            }
        });
    }
}
