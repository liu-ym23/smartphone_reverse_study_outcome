package com.obric.agent.intents.music.netease;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.netease.cloudmusic.third.api.contract.ICMApi;
import com.netease.cloudmusic.third.api.contract.ICMApiCallback;
import com.netease.cloudmusic.third.api.contract.ICMApiEventListener;
import com.obric.aiagent.assistant.idl.IMusicStateListenerIDL;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.capabilitykit.apphost.AppHost;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.h.b.ad;
import d.h.b.z;
import d.o;
import d.x;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Set;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import org.json.JSONObject;

/* JADX INFO: compiled from: CMApiManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CMApiManager implements ServiceConnection {
    private static final long CHECK_TASK_INTERNAL = 120000;
    public static final CMApiManager INSTANCE = null;
    private static final String KEY_LOCAL_MESSAGE = "local_message";
    public static final String KEY_MUSIC_INFO_UPDATE_TIME = "music_info_update_time";
    private static final String PACKAGE_NAME_CLOUD_MUSIC = "com.netease.cloudmusic";
    private static final String TAG = "CMApiManager";
    private static final Runnable checkStateTask = null;
    private static ICMApi cmApi;
    private static final CMApiManager$cmApiEventListener$1 cmApiEventListener = null;
    private static String cmapiAccessToken;
    private static long cmapiAccessTokenExpireTime;
    private static Set<String> currentPlaySongIds;
    private static boolean isBindCMService;
    private static volatile boolean isPlaying;
    private static long lastInfoEventTime;
    private static final Handler mainHandler = null;
    private static Bundle musicStateBundle;
    private static final RemoteCallbackList<IMusicStateListenerIDL> musicStateListeners = null;
    private static String triggerByLocalMsgId;

    /* JADX INFO: compiled from: CMApiManager.kt */
    @d.c.b.a.f(b = "CMApiManager.kt", c = {281}, d = "invokeSuspend", e = "com.obric.agent.intents.music.netease.CMApiManager$checkStateTask$1$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14742a;

        /* JADX INFO: renamed from: com.obric.agent.intents.music.netease.CMApiManager$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: CMApiManager.kt */
        @d.c.b.a.f(b = "CMApiManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.intents.music.netease.CMApiManager$checkStateTask$1$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f14743a;

            AnonymousClass1(d.c.d<? super AnonymousClass1> r3) {
                super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r13) {
                d.c.a.b.a();
                if (this.f14743a != 0) goto L14;
                o.a(r13);
                if (CMApiManager.access$isPlaying$p() == true) goto L8;
                CMApiManager.access$unbindService(CMApiManager.INSTANCE, "playPaused");
                return x.f38692a;
            L8:
                String r12 = String.valueOf(CMApiManager.access$getMusicStateBundle$p().getLong(DbHelper.COL_ID, 0));
                if (CMApiManager.INSTANCE.getCurrentPlaySongIds().contains(r12) == true) goto L12;
                CMApiManager.access$unbindService(CMApiManager.INSTANCE, "play song " + r12 + ", song list: " + p.a((Iterable) ZeusTransformUtils.preCheckCast(CMApiManager.INSTANCE.getCurrentPlaySongIds(), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null));
            L12:
                return x.f38692a;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        a(d.c.d<? super a> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14742a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            d.c.g r7 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin");
            d.h.a.m r2 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14742a = 1;
            if (kotlinx.coroutines.i.a(r7, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CMApiManager.kt */
    @d.c.b.a.f(b = "CMApiManager.kt", c = {115}, d = "getCmapiToken", e = "com.obric.agent.intents.music.netease.CMApiManager")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f14744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CMApiManager f14745b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f14746c;

        b(CMApiManager r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14745b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14744a = r3;
            this.f14746c |= Integer.MIN_VALUE;
            return CMApiManager.access$getCmapiToken(this.f14745b, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CMApiManager.kt */
    @d.c.b.a.f(b = "CMApiManager.kt", c = {IdlErrors.E_RejectInferDeviceOverheat}, d = "invokeSuspend", e = "com.obric.agent.intents.music.netease.CMApiManager$getCmapiToken$2$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CMApiManager f14748b;

        c(CMApiManager r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14748b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f14748b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14747a;
            String r3 = "";
            int r4 = 1;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L14:
            com.obric.agent.intents.music.netease.c r7 = (com.obric.agent.intents.music.netease.c) ZeusTransformUtils.preCheckCast(r8, com.obric.agent.intents.music.netease.c.class, "com.obric.aiagent.plugin");
            int r9 = r7.b();
            if (r9 != 0) goto L32;
            Bundle r10 = r7.a();
            if (r10 == null) goto L22;
            String r11 = r10.getString("encResult");
            if (r11 == null) goto L22;
            r3 = r11;
        L22:
            h r12 = n.f14847a.a(r3);
            CMApiManager.access$setCmapiAccessToken$p(r12.a());
            Long r13 = d.o.o.e(r12.b());
            if (r13 == null) goto L25;
            long r5 = r13.longValue();
        L26:
            CMApiManager.access$setCmapiAccessTokenExpireTime$p(r5);
            ILogDepend.Companion.d(CMApiManager.TAG, "getToken success, expire=" + r12.b());
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r12.a(), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L29;
            boolean r14 = true;
        L30:
            if (r14 == false) goto L34;
            r4 = 0;
        L34:
            return d.c.b.a.b.a(r4);
        L29:
            r14 = false;
            goto L30
        L25:
            r5 = 0;
            goto L26
        L32:
            ILogDepend.Companion.w(CMApiManager.TAG, "getToken failed code=" + r9);
            r4 = r9;
            goto L34
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            String r15 = n.f14847a.a();
            if (r15 != null) goto L11;
            r15 = "";
        L11:
            JSONObject r2 = new JSONObject();
            r2.put("encRequest", r15);
            String r16 = r2.toString();
            d.h.b.o.c(r16, "toString(...)");
            Bundle r6 = new Bundle();
            r6.putString("data", r16);
            CMApiManager r17 = this.f14748b;
            d.c.d<? super com.obric.agent.intents.music.netease.c> r18 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14747a = 1;
            r8 = r17.executeAsync("CMAPI_GET_TOKEN", "", r6, r18);
            if (r8 != r0) goto L14;
            return r0;
        }
    }

    public static /* synthetic */ void lambda$dUJxw4KUpCv7PiLfxtdU15nehwY() {
        checkStateTask$lambda$7();
    }

    private CMApiManager() {
    }

    public static final /* synthetic */ ICMApi access$getCmApi$p() {
        return cmApi;
    }

    public static final /* synthetic */ Object access$getCmapiToken(CMApiManager r2, d.c.d r3) {
        return r2.getCmapiToken((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Integer access$getCurrentTime(CMApiManager r0) {
        return r0.getCurrentTime();
    }

    public static final /* synthetic */ long access$getLastInfoEventTime$p() {
        return lastInfoEventTime;
    }

    public static final /* synthetic */ Bundle access$getMusicStateBundle$p() {
        return musicStateBundle;
    }

    public static final /* synthetic */ boolean access$isPlaying$p() {
        return isPlaying;
    }

    public static final /* synthetic */ void access$setCmapiAccessToken$p(String r0) {
        cmapiAccessToken = r0;
    }

    public static final /* synthetic */ void access$setCmapiAccessTokenExpireTime$p(long r0) {
        cmapiAccessTokenExpireTime = r0;
    }

    public static final /* synthetic */ void access$setLastInfoEventTime$p(long r0) {
        lastInfoEventTime = r0;
    }

    public static final /* synthetic */ void access$setPlaying$p(boolean r0) {
        isPlaying = r0;
    }

    public static final /* synthetic */ void access$tryUnbindService(CMApiManager r0) {
        r0.tryUnbindService();
    }

    public static final /* synthetic */ void access$unbindService(CMApiManager r0, String r1) {
        r0.unbindService(r1);
    }

    public static final /* synthetic */ void access$updatePlayingMusicState(CMApiManager r0, Bundle r1) {
        r0.updatePlayingMusicState(r1);
    }

    private final Context getAppContext() {
        return (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    public final String getTriggerByLocalMsgId() {
        return triggerByLocalMsgId;
    }

    public final void setTriggerByLocalMsgId(String r2) {
        triggerByLocalMsgId = r2;
        if (r2 == null) goto L6;
        musicStateBundle.putString(KEY_LOCAL_MESSAGE, r2);
        return;
    }

    public final boolean isBindCMService() {
        return isBindCMService;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.obric.agent.intents.music.netease.CMApiManager$cmApiEventListener$1] */
    static {
        INSTANCE = new CMApiManager();
        cmapiAccessToken = "";
        currentPlaySongIds = ax.b();
        musicStateBundle = new Bundle();
        musicStateListeners = new RemoteCallbackList();
        cmApiEventListener = new CMApiManager$cmApiEventListener$1();
        mainHandler = new Handler(Looper.getMainLooper());
        checkStateTask = $$Lambda$CMApiManager$dUJxw4KUpCv7PiLfxtdU15nehwY.INSTANCE;
    }

    public final String getCmapiAccessToken() {
        return cmapiAccessToken;
    }

    public final Set<String> getCurrentPlaySongIds() {
        return currentPlaySongIds;
    }

    public final void setCurrentPlaySongIds(Set<String> r2) {
        Set<String> r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "<set-?>");
        currentPlaySongIds = r1;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r3, IBinder r4) {
        IBinder r2 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.d(TAG, "onServiceConnected");
        ICMApi r5 = ICMApi.Stub.asInterface(r2);
        cmApi = r5;
        isBindCMService = true;
        if (r5 != null) goto L11;
    L7:
        ILogDepend.Companion.d(TAG, "registerEventListener");     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "registerEventListener error : " + e.getMessage());
        return;
    L11:
        r5.registerEventListener((ICMApiEventListener) ZeusTransformUtils.preCheckCast(cmApiEventListener, ICMApiEventListener.class, "com.obric.aiagent.plugin"));     // Catch: RemoteException -> L5
        goto L7
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r2) {
        k.f14837a.a("exit");
        onDisconnect();
    }

    private final void onDisconnect() {
        ILogDepend.Companion.d(TAG, "onServiceDisconnected");
        cmApi = null;
        isBindCMService = false;
        cmapiAccessToken = "";
        cmapiAccessTokenExpireTime = 0;
        currentPlaySongIds = ax.b();
        musicStateBundle.clear();
        isPlaying = false;
        setTriggerByLocalMsgId(null);
        notifyMusicStateChanged(musicStateBundle);
    }

    public final Object ensureToken(d.c.d<? super Integer> r7) {
        d.c.d<? super Integer> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(cmapiAccessToken, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
        if (cmapiAccessTokenExpireTime <= System.currentTimeMillis()) goto L12;
        return d.c.b.a.b.a(0);
    L12:
        return getCmapiToken(r8);
    L5:
        r0 = false;
        goto L6
    }

    private final Object getCmapiToken(d.c.d<? super Integer> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
        if ((r0.f14746c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f14746c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f14744a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f14746c;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        o.a(r10);     // Catch: Throwable -> L13
    L24:
        Object r7 = d.n.f(d.c.b.a.b.a(((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).intValue()));     // Catch: Throwable -> L13
    L27:
        Throwable r11 = d.n.c(r7);
        if (r11 == null) goto L34;
        ILogDepend.Companion.e(TAG, "getToken error", r11);
        return d.c.b.a.b.a(1);
    L34:
        return r7;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        o.a(r10);
        if (isBindCMService == true) goto L21;
        ILogDepend.Companion.w(TAG, "getToken: 未 bind");
        return d.c.b.a.b.a(1);
    L21:
        d.n.a r12 = d.n.f38560a;     // Catch: Throwable -> L13
        CMApiManager r13 = (CMApiManager) ZeusTransformUtils.preCheckCast(this, CMApiManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        d.c.g r14 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        d.h.a.m r15 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r13, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        r0.f14746c = 1;     // Catch: Throwable -> L13
        r10 = kotlinx.coroutines.i.a(r14, r15, r0);     // Catch: Throwable -> L13
        if (r10 != r2) goto L24;
        return r2;
    L13:
        th = move-exception;
        d.n.a r16 = d.n.f38560a;
        r7 = d.n.f(o.a(th));
    L7:
        r0 = new b(this, r9);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [T, java.lang.String] */
    public final Object executeAsync(final String r10, String r11, Bundle r12, d.c.d<? super com.obric.agent.intents.music.netease.c> r13) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        final z.f r14 = new z.f();
        if (ILogDepend.Companion.isDebug() == false) goto L5;
        r14.f38504a = "executeAsync " + r10 + ", " + r11 + ", " + com.obric.agent.intents.music.netease.a.a(r12, 0, 1, null) + ' ';
    L5:
        kotlinx.coroutines.o r1 = new kotlinx.coroutines.o(d.c.a.b.a(r9), 1);
        r1.e();
        final kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        CMApiManager r4 = INSTANCE;
        d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L15
        if (r4.isBindCMService() == true) goto L9;
        d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(r2, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        d.n.a r7 = d.n.f38560a;     // Catch: Throwable -> L15
        r6.resumeWith(d.n.f(new com.obric.agent.intents.music.netease.c(null, "please bind service", (String) ZeusTransformUtils.preCheckCast(r14.f38504a, String.class, "com.obric.aiagent.plugin"))));     // Catch: Throwable -> L15
    L9:
        ICMApi r8 = access$getCmApi$p();     // Catch: Throwable -> L15
        if (r8 == null) goto L12;
        r8.executeAsync(r10, r11, r12, (ICMApiCallback) ZeusTransformUtils.preCheckCast(new CMApiManager$executeAsync$2$1$1(r2, r14, r10), ICMApiCallback.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
    L13:
        Object r15 = d.n.f(x.f38692a);     // Catch: Throwable -> L15
    L17:
        Throwable r16 = d.n.c(r15);
        if (r16 == null) goto L26;
        ILogDepend.Companion.e(TAG, "executeAsync[" + r10 + "] error", r16);
        if (r2.a() == false) goto L26;
        d.c.d r17 = (d.c.d) ZeusTransformUtils.preCheckCast(r2, d.c.d.class, "com.obric.aiagent.plugin");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r14.f38504a, String.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L24;
        String r19 = r18 + r16;
    L25:
        com.obric.agent.intents.music.netease.c r110 = new com.obric.agent.intents.music.netease.c(null, "exception", r19);
        d.n.a r111 = d.n.f38560a;
        r17.resumeWith(d.n.f(r110));
        goto L26
    L24:
        r19 = null;
    L26:
        Object r112 = r1.h();
        if (r112 != d.c.a.b.a()) goto L29;
        d.c.b.a.h.c(r9);
    L29:
        return r112;
    L12:
        d.c.d r113 = (d.c.d) ZeusTransformUtils.preCheckCast(r2, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        d.n.a r114 = d.n.f38560a;     // Catch: Throwable -> L15
        r113.resumeWith(d.n.f(new com.obric.agent.intents.music.netease.c(null, "cmApi is null", (String) ZeusTransformUtils.preCheckCast(r14.f38504a, String.class, "com.obric.aiagent.plugin"))));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        d.n.a r115 = d.n.f38560a;
        r15 = d.n.f(o.a(th));
        goto L17
    }

    public final Bundle execute(String r6, Bundle r7) {
        d.h.b.o.e(r6, "cmd");
        d.h.b.o.e(r7, "params");
        if (ILogDepend.Companion.isDebug() == false) goto L5;
        String r5 = "execute " + r6 + ", " + com.obric.agent.intents.music.netease.a.a(r7, 0, 1, null) + ' ';
    L7:
        if (isBindCMService == true) goto L23;
        ILogDepend.Companion.d(TAG, r5 + " not bind service");
        return null;
    L23:
        ICMApi r3 = cmApi;     // Catch: RemoteException -> L20
        if (r3 == null) goto L13;
        Bundle r8 = r3.execute(r6, r7);     // Catch: RemoteException -> L20
    L14:
        ILogDepend.Companion r9 = ILogDepend.Companion;     // Catch: RemoteException -> L20
        StringBuilder r10 = new StringBuilder().append(r5).append(", receive: ");     // Catch: RemoteException -> L20
        if (r8 == null) goto L17;
        String r0 = com.obric.agent.intents.music.netease.a.a(r8, 0, 1, null);     // Catch: RemoteException -> L20
    L18:
        r9.d(TAG, r10.append(r0).toString());     // Catch: RemoteException -> L20
        return r8;
    L17:
        r0 = null;
        goto L18
    L13:
        r8 = null;
    L20:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "execute error : " + e.getMessage());
        return null;
    L5:
        r5 = null;
        goto L7
    }

    private final Integer getCurrentTime() {
        Bundle r2 = execute("CMD_GET_CUR_TIME", new Bundle());
        if (r2 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r2.getInt("current_time"));
    }

    public final void registerMusicStateListener(IMusicStateListenerIDL r3) {
        IMusicStateListenerIDL r2 = (IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        musicStateListeners.register((IInterface) ZeusTransformUtils.preCheckCast(r2, IInterface.class, "com.obric.aiagent.plugin"));
        if (musicStateBundle.getBoolean("isPlaying", false) == false) goto L9;
        r2.onMusicStateChanged(musicStateBundle);
        return;
    }

    public final void unregisterMusicStateListener(IMusicStateListenerIDL r3) {
        IMusicStateListenerIDL r2 = (IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        musicStateListeners.unregister((IInterface) ZeusTransformUtils.preCheckCast(r2, IInterface.class, "com.obric.aiagent.plugin"));
    }

    private static final void checkStateTask$lambda$7() {
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void updatePlayingMusicState(Bundle r8) {
        if (r8 != null) goto L4;
        musicStateBundle.clear();
    L22:
        notifyMusicStateChanged(musicStateBundle);
        return;
    L4:
        Bundle r0 = new Bundle(musicStateBundle);
        String r4 = String.valueOf(r8.getLong(DbHelper.COL_ID, 0));
        if (isPlaying == true) goto L7;
    L11:
        r8.remove(KEY_LOCAL_MESSAGE);
    L12:
        r8.putLong(KEY_MUSIC_INFO_UPDATE_TIME, SystemClock.elapsedRealtime());
        r8.putBoolean("isPlaying", isPlaying);
        musicStateBundle = r8;
        String r9 = String.valueOf(r8.getLong(DbHelper.COL_ID, 0));
        if (isPlaying == false) goto L18;
        if (currentPlaySongIds.contains(r9) == false) goto L18;
        k.f14837a.a(triggerByLocalMsgId, r9.toString(), r0, musicStateBundle);
    L18:
        if (isPlaying == true) goto L20;
    L21:
        k.f14837a.a("others");
        goto L22
    L20:
        if (currentPlaySongIds.contains(r9) == true) goto L22;
    L7:
        if (triggerByLocalMsgId == null) goto L11;
        if (currentPlaySongIds.contains(r4) == false) goto L11;
        r8.putString(KEY_LOCAL_MESSAGE, triggerByLocalMsgId);
        goto L12
    }

    private final void notifyMusicStateChanged(Bundle r10) {
        int r1 = musicStateListeners.beginBroadcast();
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L16;
        d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L7
        CMApiManager r6 = (CMApiManager) ZeusTransformUtils.preCheckCast(this, CMApiManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        ((IMusicStateListenerIDL) ZeusTransformUtils.preCheckCast(musicStateListeners.getBroadcastItem(r3), IMusicStateListenerIDL.class, "com.obric.aiagent.plugin")).onMusicStateChanged(r10);     // Catch: Throwable -> L7
        Object r7 = d.n.f(x.f38692a);     // Catch: Throwable -> L7
    L20:
        Throwable r8 = d.n.c(r7);     // Catch: Throwable -> L13
        if (r8 == null) goto L12;
        ILogDepend.Companion.e(TAG, "notify music state error: " + r8.getMessage());     // Catch: Throwable -> L13
    L12:
        r3 = r3 + 1;
        goto L4
    L7:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L13
        r7 = d.n.f(o.a(th));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        musicStateListeners.finishBroadcast();
        throw th;
    L16:
        musicStateListeners.finishBroadcast();
        if (ILogDepend.Companion.isDebug() == false) goto L27;
        ILogDepend.Companion.i(TAG, "notify bundle: " + com.obric.agent.intents.music.netease.a.a(r10, 0, 1, null));
        return;
    }

    public final boolean bindService() {
        Intent r3 = new Intent("com.netease.cloudmusic.third.api.CMApiService");     // Catch: Exception -> L5
        r3.setPackage(PACKAGE_NAME_CLOUD_MUSIC);     // Catch: Exception -> L5
        boolean r4 = ZeusTransformUtils.bindService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, (ServiceConnection) ZeusTransformUtils.preCheckCast(INSTANCE, ServiceConnection.class, "com.obric.aiagent.plugin"), 1, "com.obric.aiagent.plugin");     // Catch: Exception -> L5
    L7:
        if (r4 == true) goto L9;
        ILogDepend.Companion.d(TAG, "bind 失败，尝试拉起云音乐进程");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        String r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName();
        d.h.b.o.c(r1, "getPackageName(...)");
        startCMProcess(r0, r1, true);
    L9:
        return r4;
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "bindService error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r4 = false;
        goto L7
    }

    private final void unbindService(String r5) {
        if (isBindCMService == true) goto L14;
        return;
    L14:
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L7
        CMApiManager r4 = (CMApiManager) ZeusTransformUtils.preCheckCast(this, CMApiManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        ZeusTransformUtils.unbindService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (ServiceConnection) ZeusTransformUtils.preCheckCast(r4, ServiceConnection.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        r4.onDisconnect();     // Catch: Throwable -> L7
        Object r6 = d.n.f(x.f38692a);     // Catch: Throwable -> L7
    L9:
        Throwable r7 = d.n.c(r6);
        if (r7 == null) goto L12;
        ILogDepend.Companion.e(TAG, "unbindService error reason=" + r5, r7);
    L12:
        ILogDepend.Companion.d(TAG, "unbindService reason=" + r5);
        return;
    L7:
        th = move-exception;
        d.n.a r0 = d.n.f38560a;
        r6 = d.n.f(o.a(th));
        goto L9
    }

    public final void queryPause() {
        k.f14837a.a("query_pause");
    }

    private final void tryUnbindService() {
        Handler r3 = mainHandler;
        Runnable r0 = checkStateTask;
        r3.removeCallbacks(r0);
        r3.postDelayed(r0, CHECK_TASK_INTERNAL);
    }

    static /* synthetic */ int startCMProcess$default(CMApiManager r1, Context r2, String r3, boolean r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L6;
        r4 = false;
    L6:
        return r1.startCMProcess(r7, r3, r4);
    }

    private final int startCMProcess(Context r8, String r9, boolean r10) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r11 = true;
    L7:
        if (r11 == false) goto L9;
        return -1;
    L9:
        ILogDepend.Companion.d(TAG, "startCMProcess: ");
        if (r7.getPackageManager().getLaunchIntentForPackage(PACKAGE_NAME_CLOUD_MUSIC) != null) goto L12;
        return 2;
    L12:
        JSONObject r12 = new JSONObject();
        r12.put("cmd", "start");
        r12.put("action", 0);
        r12.put("packageName", r9);
        String r13 = URLEncoder.encode(r12.toString(), "utf-8");
        ad r14 = ad.f38485a;
        String r15 = String.format("cmapi://music.163.com/aidl?p=%s&skipLoading", Arrays.copyOf(new Object[]{r13, Boolean.valueOf(r10)}, 2));
        d.h.b.o.c(r15, "format(...)");
        Intent r16 = new Intent();
        r16.addFlags(268435456);
        r16.setAction("android.intent.action.VIEW");
        r16.setData(Uri.parse(r15));
        ZeusTransformUtils.startActivity(r7, r16, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
        return 1;
    L15:
        e = move-exception;
        e.printStackTrace();
        if (ZeusTransformUtils.instanceOf(e, ActivityNotFoundException.class) == false) goto L20;
        return 2;
    L20:
        return -1;
    L5:
        r11 = false;
        goto L7
    }
}
