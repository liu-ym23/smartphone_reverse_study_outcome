package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u0003J\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0003J\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0003J\r\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0003J!\u0010\u0016\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001c\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R \u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/j;", "", "<init>", "()V", "Lkotlin/Function0;", "LY8/t;", "observer", Const.INTENT_KEY_APIKEY, "(Lp9/a;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "f", "", "percent", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(I)V", "e", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_PKGNAME, "Landroid/content/Context;", "context", "", "backendState", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "installState", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Ljava/lang/String;", VoiceWakeupReceiver.EXTRA_STATE, "c", "progress", "Ljava/lang/Integer;", "", "pendingFromClick", "Z", "Ljava/util/concurrent/CopyOnWriteArrayList;", "observers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.alipay.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3245j {
    public static final C3245j INSTANCE = new C3245j();
    private static final CopyOnWriteArrayList<InterfaceC5063a<Y8.t>> observers = new CopyOnWriteArrayList<>();
    private static volatile boolean pendingFromClick;
    private static volatile Integer progress;

    public final void a(InterfaceC5063a<Y8.t> observer) {
        kotlin.jvm.internal.p.i(observer, "observer");
        observers.add(observer);
    }

    public final void b() {
        progress = null;
        pendingFromClick = false;
    }

    public final String c(String state) {
        return kotlin.jvm.internal.p.d(state, "installed") ? "打开" : kotlin.jvm.internal.p.d(state, "installing") ? "安装中" : "安装";
    }

    public final String d(String installState) {
        if (kotlin.jvm.internal.p.d(installState, "installed")) {
            return C3236a.PKG_ALIPAY;
        }
        return null;
    }

    public final void e() {
        pendingFromClick = true;
        f();
    }

    public final void f() {
        Iterator<T> it = observers.iterator();
        while (it.hasNext()) {
            InterfaceC5063a interfaceC5063a = (InterfaceC5063a) it.next();
            try {
                Result.Companion companion = Result.INSTANCE;
                interfaceC5063a.invoke();
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final void g() {
        progress = null;
    }

    public final void h(int percent) {
        if (1 > percent || percent >= 101) {
            return;
        }
        progress = Integer.valueOf(percent);
    }

    public final void i(InterfaceC5063a<Y8.t> observer) {
        kotlin.jvm.internal.p.i(observer, "observer");
        observers.remove(observer);
    }

    public final String j(Context context, String backendState) {
        Object objB;
        Boolean bool;
        String lowerCase = null;
        if (context == null) {
            bool = null;
        } else {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(Boolean.valueOf(C3236a.INSTANCE.a(context)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            bool = (Boolean) objB;
        }
        if (kotlin.jvm.internal.p.d(bool, Boolean.TRUE)) {
            progress = null;
            pendingFromClick = false;
            return "installed";
        }
        if (progress != null || pendingFromClick) {
            return "installing";
        }
        String strD = N5.j.INSTANCE.d(backendState);
        if (strD != null) {
            lowerCase = strD.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        }
        if (lowerCase != null) {
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != 3227604) {
                if (iHashCode != 29046650) {
                    if (iHashCode == 900450407 && lowerCase.equals("installing")) {
                        return lowerCase;
                    }
                } else if (lowerCase.equals("installed") && !kotlin.jvm.internal.p.d(bool, Boolean.FALSE)) {
                    return lowerCase;
                }
            } else if (lowerCase.equals("idle")) {
                return lowerCase;
            }
        }
        return "idle";
    }
}
