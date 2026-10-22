package com.stepos.ailauncher.chat.wake;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.lockscreen.LockScreenUnlockActivity;
import h8.C4148a;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006JE\u0010\u000f\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/F;", "", "<init>", "()V", "", Const.INTENT_KEY_UMID, "()Z", "Landroid/content/Context;", "context", "", "tag", "Lkotlin/Function1;", "LY8/t;", "onUnlocked", "onNotUnlocked", "e", "(Landroid/content/Context;Ljava/lang/String;Lp9/l;Lp9/l;)V", "Ljava/util/concurrent/atomic/AtomicLong;", "counter", "Ljava/util/concurrent/atomic/AtomicLong;", "inFlight", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class F {
    public static final F INSTANCE = new F();
    private static final AtomicLong counter = new AtomicLong(0);
    private static boolean inFlight;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LockScreenUnlockActivity.UnlockResult.values().length];
            try {
                iArr[LockScreenUnlockActivity.UnlockResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LockScreenUnlockActivity.UnlockResult.ALREADY_UNLOCKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Y8.t f(String str, final Context context, final InterfaceC5074l interfaceC5074l, final InterfaceC5074l interfaceC5074l2, LockScreenUnlockActivity.UnlockResult result) {
        kotlin.jvm.internal.p.i(result, "result");
        int i10 = a.$EnumSwitchMapping$0[result.ordinal()];
        if (i10 == 1 || i10 == 2) {
            C4148a.k("WakeGuard", str + ": unlocked (" + result + "), wait for unlock UI to settle", false, 4, null);
            Y y10 = Y.INSTANCE;
            kotlin.jvm.internal.p.f(context);
            y10.e(context, str, false, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.D
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return F.g(interfaceC5074l2, context);
                }
            }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.E
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return F.h(interfaceC5074l, context);
                }
            });
        } else {
            inFlight = false;
            C4148a.u("WakeGuard", str + ": unlock not completed (" + result + "), fallback to notice", false, 4, null);
            kotlin.jvm.internal.p.f(context);
            interfaceC5074l.invoke(context);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t g(InterfaceC5074l interfaceC5074l, Context context) {
        try {
            kotlin.jvm.internal.p.f(context);
            interfaceC5074l.invoke(context);
            inFlight = false;
            return Y8.t.f7040a;
        } catch (Throwable th) {
            inFlight = false;
            throw th;
        }
    }

    public static final Y8.t h(InterfaceC5074l interfaceC5074l, Context context) {
        inFlight = false;
        kotlin.jvm.internal.p.f(context);
        interfaceC5074l.invoke(context);
        return Y8.t.f7040a;
    }

    public final boolean d() {
        return inFlight;
    }

    public final void e(Context context, final String tag, final InterfaceC5074l<? super Context, Y8.t> onUnlocked, final InterfaceC5074l<? super Context, Y8.t> onNotUnlocked) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(tag, "tag");
        kotlin.jvm.internal.p.i(onUnlocked, "onUnlocked");
        kotlin.jvm.internal.p.i(onNotUnlocked, "onNotUnlocked");
        if (inFlight) {
            C4148a.d("WakeGuard", tag + ": unlock already in flight, skip", false, 4, null);
            return;
        }
        inFlight = true;
        final Context applicationContext = context.getApplicationContext();
        LockScreenUnlockActivity.Companion companion = LockScreenUnlockActivity.INSTANCE;
        kotlin.jvm.internal.p.f(applicationContext);
        companion.c(applicationContext, tag + "_" + counter.incrementAndGet(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.C
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return F.f(tag, applicationContext, onNotUnlocked, onUnlocked, (LockScreenUnlockActivity.UnlockResult) obj);
            }
        });
    }
}
