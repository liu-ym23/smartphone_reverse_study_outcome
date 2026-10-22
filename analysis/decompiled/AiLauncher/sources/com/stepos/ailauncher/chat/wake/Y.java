package com.stepos.ailauncher.chat.wake;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/Y;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "tag", "", "userPresentAlreadyReceived", "Lkotlin/Function0;", "LY8/t;", "onSettled", "onFailed", "e", "(Landroid/content/Context;Ljava/lang/String;ZLp9/a;Lp9/a;)V", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "", "UNLOCK_UI_READY_FALLBACK_MS", "J", "UNLOCK_UI_POLL_MS", "UNLOCK_UI_HOLD_AFTER_READY_MS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Y {
    private static final long UNLOCK_UI_HOLD_AFTER_READY_MS = 250;
    private static final long UNLOCK_UI_POLL_MS = 50;
    private static final long UNLOCK_UI_READY_FALLBACK_MS = 1200;
    public static final Y INSTANCE = new Y();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UnlockUiSettleDecision.values().length];
            try {
                iArr[UnlockUiSettleDecision.CONTINUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UnlockUiSettleDecision.FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UnlockUiSettleDecision.WAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/wake/Y$b", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "receiveContext", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends BroadcastReceiver {
        final /* synthetic */ Context $appContext;
        final /* synthetic */ Ref$BooleanRef $completed;
        final /* synthetic */ Object $holdToken;
        final /* synthetic */ InterfaceC5063a<Y8.t> $onFailed;
        final /* synthetic */ InterfaceC5063a<Y8.t> $onSettled;
        final /* synthetic */ Ref$ObjectRef<BroadcastReceiver> $receiver;
        final /* synthetic */ Ref$BooleanRef $registered;
        final /* synthetic */ String $tag;
        final /* synthetic */ Ref$BooleanRef $userPresentReceived;
        final /* synthetic */ Object $watchToken;

        public b(Ref$BooleanRef ref$BooleanRef, Ref$BooleanRef ref$BooleanRef2, Context context, String str, Object obj, InterfaceC5063a<Y8.t> interfaceC5063a, Object obj2, Ref$BooleanRef ref$BooleanRef3, Ref$ObjectRef<BroadcastReceiver> ref$ObjectRef, InterfaceC5063a<Y8.t> interfaceC5063a2) {
            this.$userPresentReceived = ref$BooleanRef;
            this.$completed = ref$BooleanRef2;
            this.$appContext = context;
            this.$tag = str;
            this.$holdToken = obj;
            this.$onFailed = interfaceC5063a;
            this.$watchToken = obj2;
            this.$registered = ref$BooleanRef3;
            this.$receiver = ref$ObjectRef;
            this.$onSettled = interfaceC5063a2;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context receiveContext, Intent intent) {
            if (kotlin.jvm.internal.p.d(intent != null ? intent.getAction() : null, "android.intent.action.USER_PRESENT")) {
                Ref$BooleanRef ref$BooleanRef = this.$userPresentReceived;
                ref$BooleanRef.f34815a = true;
                Y.h(this.$completed, this.$appContext, ref$BooleanRef, this.$tag, this.$holdToken, this.$onFailed, this.$watchToken, this.$registered, this.$receiver, this.$onSettled, false);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/wake/Y$c", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements Runnable {
        final /* synthetic */ Context $appContext;
        final /* synthetic */ Ref$BooleanRef $completed;
        final /* synthetic */ Object $holdToken;
        final /* synthetic */ InterfaceC5063a<Y8.t> $onFailed;
        final /* synthetic */ InterfaceC5063a<Y8.t> $onSettled;
        final /* synthetic */ Ref$ObjectRef<BroadcastReceiver> $receiver;
        final /* synthetic */ Ref$BooleanRef $registered;
        final /* synthetic */ String $tag;
        final /* synthetic */ Ref$BooleanRef $userPresentReceived;
        final /* synthetic */ Object $watchToken;

        public c(Ref$BooleanRef ref$BooleanRef, Object obj, Context context, Ref$BooleanRef ref$BooleanRef2, String str, Object obj2, InterfaceC5063a<Y8.t> interfaceC5063a, Ref$BooleanRef ref$BooleanRef3, Ref$ObjectRef<BroadcastReceiver> ref$ObjectRef, InterfaceC5063a<Y8.t> interfaceC5063a2) {
            this.$completed = ref$BooleanRef;
            this.$watchToken = obj;
            this.$appContext = context;
            this.$userPresentReceived = ref$BooleanRef2;
            this.$tag = str;
            this.$holdToken = obj2;
            this.$onFailed = interfaceC5063a;
            this.$registered = ref$BooleanRef3;
            this.$receiver = ref$ObjectRef;
            this.$onSettled = interfaceC5063a2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Y.h(this.$completed, this.$appContext, this.$userPresentReceived, this.$tag, this.$holdToken, this.$onFailed, this.$watchToken, this.$registered, this.$receiver, this.$onSettled, false);
            if (this.$completed.f34815a) {
                return;
            }
            Y.mainHandler.postDelayed(this, this.$watchToken, 50L);
        }
    }

    public static final void f(Object obj, Ref$BooleanRef ref$BooleanRef, Context context, Ref$ObjectRef<BroadcastReceiver> ref$ObjectRef) {
        mainHandler.removeCallbacksAndMessages(obj);
        if (ref$BooleanRef.f34815a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                context.unregisterReceiver(ref$ObjectRef.f34820a);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
            ref$BooleanRef.f34815a = false;
        }
    }

    public static final void g(Ref$BooleanRef ref$BooleanRef, Context context, Ref$BooleanRef ref$BooleanRef2, String str, Object obj, InterfaceC5063a interfaceC5063a, Object obj2, Ref$BooleanRef ref$BooleanRef3, Ref$ObjectRef ref$ObjectRef, InterfaceC5063a interfaceC5063a2) {
        h(ref$BooleanRef, context, ref$BooleanRef2, str, obj, interfaceC5063a, obj2, ref$BooleanRef3, ref$ObjectRef, interfaceC5063a2, true);
    }

    public static final void h(Ref$BooleanRef ref$BooleanRef, Context context, Ref$BooleanRef ref$BooleanRef2, String str, Object obj, InterfaceC5063a<Y8.t> interfaceC5063a, Object obj2, Ref$BooleanRef ref$BooleanRef3, Ref$ObjectRef<BroadcastReceiver> ref$ObjectRef, final InterfaceC5063a<Y8.t> interfaceC5063a2, boolean z10) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        com.stepos.ailauncher.chat.lockscreen.C c10 = com.stepos.ailauncher.chat.lockscreen.C.INSTANCE;
        kotlin.jvm.internal.p.f(context);
        boolean zC = c10.c(context);
        int i10 = a.$EnumSwitchMapping$0[Q1.h(ref$BooleanRef2.f34815a, zC, z10).ordinal()];
        if (i10 == 1) {
            ref$BooleanRef.f34815a = true;
            f(obj2, ref$BooleanRef3, context, ref$ObjectRef);
            C4148a.k("WakeGuard", str + ": unlock UI settled, hold 250ms", false, 4, null);
            mainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.X
                @Override // java.lang.Runnable
                public final void run() {
                    Y.i(interfaceC5063a2);
                }
            }, obj, 250L);
            return;
        }
        if (i10 == 2) {
            ref$BooleanRef.f34815a = true;
            f(obj2, ref$BooleanRef3, context, ref$ObjectRef);
            mainHandler.removeCallbacksAndMessages(obj);
            C4148a.u("WakeGuard", str + ": unlock UI did not settle, fallback", false, 4, null);
            interfaceC5063a.invoke();
            return;
        }
        if (i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        C4148a.d("WakeGuard", str + ": unlock UI not settled yet present=" + ref$BooleanRef2.f34815a + " keyguard=" + zC, false, 4, null);
    }

    public static final void i(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, com.stepos.ailauncher.chat.wake.Y$b] */
    public final void e(Context context, final String tag, boolean userPresentAlreadyReceived, final InterfaceC5063a<Y8.t> onSettled, final InterfaceC5063a<Y8.t> onFailed) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(tag, "tag");
        kotlin.jvm.internal.p.i(onSettled, "onSettled");
        kotlin.jvm.internal.p.i(onFailed, "onFailed");
        final Context applicationContext = context.getApplicationContext();
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
        final Ref$BooleanRef ref$BooleanRef3 = new Ref$BooleanRef();
        ref$BooleanRef3.f34815a = userPresentAlreadyReceived;
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Object obj = new Object();
        final Object obj2 = new Object();
        ?? bVar = new b(ref$BooleanRef3, ref$BooleanRef, applicationContext, tag, obj2, onFailed, obj, ref$BooleanRef2, ref$ObjectRef, onSettled);
        ref$ObjectRef.f34820a = bVar;
        if (!userPresentAlreadyReceived) {
            try {
                Result.Companion companion = Result.INSTANCE;
                applicationContext.registerReceiver((BroadcastReceiver) bVar, new IntentFilter("android.intent.action.USER_PRESENT"), 2);
                ref$BooleanRef2.f34815a = true;
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t("WakeGuard", tag + ": register USER_PRESENT failed, use fallback", thE, false, 8, null);
            }
        }
        c cVar = new c(ref$BooleanRef, obj, applicationContext, ref$BooleanRef3, tag, obj2, onFailed, ref$BooleanRef2, ref$ObjectRef, onSettled);
        Handler handler = mainHandler;
        handler.postDelayed(cVar, obj, 0L);
        handler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.W
            @Override // java.lang.Runnable
            public final void run() {
                Y.g(ref$BooleanRef, applicationContext, ref$BooleanRef3, tag, obj2, onFailed, obj, ref$BooleanRef2, ref$ObjectRef, onSettled);
            }
        }, obj, 1200L);
    }
}
