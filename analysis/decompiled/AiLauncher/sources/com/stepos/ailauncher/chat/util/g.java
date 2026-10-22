package com.stepos.ailauncher.chat.util;

import Z8.F;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001(B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001b\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R0\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#0\"j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#`$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/stepos/ailauncher/chat/util/g;", "", "", "tag", "Lkotlin/Function0;", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "Landroid/view/Window;", "window", "<init>", "(Ljava/lang/String;Lp9/a;Lp9/a;)V", "reason", "", "timeoutMs", "LY8/t;", "f", "(Ljava/lang/String;J)V", "l", "(Ljava/lang/String;)V", "n", "()V", "", W4.a.ENABLE_ON, "by", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(ZLjava/lang/String;)V", "block", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lp9/a;)V", "Ljava/lang/String;", "Lp9/a;", "Landroid/os/Handler;", "main", "Landroid/os/Handler;", "Ljava/util/LinkedHashMap;", "Ljava/lang/Runnable;", "Lkotlin/collections/LinkedHashMap;", "holders", "Ljava/util/LinkedHashMap;", "Companion", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g {
    public static final String REASON_LOCKSCREEN = "lockscreen";
    public static final String REASON_RECORDING = "recording";
    public static final String REASON_TTS = "tts";
    private static final String TAG = "KeepScreenOn";
    public static final long TTS_TIMEOUT_MS = 300000;
    private final InterfaceC5063a<View> anchor;
    private final LinkedHashMap<String, Runnable> holders;
    private final Handler main;
    private final String tag;
    private final InterfaceC5063a<Window> window;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements InterfaceC5063a {
        public static final a INSTANCE = new a();

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke() {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(String tag, InterfaceC5063a<? extends View> anchor, InterfaceC5063a<? extends Window> window) {
        kotlin.jvm.internal.p.i(tag, "tag");
        kotlin.jvm.internal.p.i(anchor, "anchor");
        kotlin.jvm.internal.p.i(window, "window");
        this.tag = tag;
        this.anchor = anchor;
        this.window = window;
        this.main = new Handler(Looper.getMainLooper());
        this.holders = new LinkedHashMap<>();
    }

    public static final Y8.t g(final g gVar, final String str, final long j10) {
        Runnable runnableRemove = gVar.holders.remove(str);
        if (runnableRemove != null) {
            gVar.main.removeCallbacks(runnableRemove);
        }
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.chat.util.e
            @Override // java.lang.Runnable
            public final void run() {
                g.h(this.f25683a, str, j10);
            }
        };
        gVar.holders.put(str, runnable);
        gVar.main.postDelayed(runnable, j10);
        gVar.i(true, str);
        return Y8.t.f7040a;
    }

    public static final void h(g gVar, String str, long j10) {
        C4148a.u(TAG, gVar.tag + ": '" + str + "' held over " + j10 + "ms, force release (leak guard)", false, 4, null);
        gVar.l(str);
    }

    public static final void k(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    public static final Y8.t m(g gVar, String str) {
        Runnable runnableRemove = gVar.holders.remove(str);
        if (runnableRemove == null) {
            return Y8.t.f7040a;
        }
        gVar.main.removeCallbacks(runnableRemove);
        if (gVar.holders.isEmpty()) {
            gVar.i(false, str);
        } else {
            C4148a.k(TAG, gVar.tag + ": release '" + str + "', still held by " + gVar.holders.keySet(), false, 4, null);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t o(g gVar) {
        if (gVar.holders.isEmpty()) {
            return Y8.t.f7040a;
        }
        Set<String> setKeySet = gVar.holders.keySet();
        kotlin.jvm.internal.p.h(setKeySet, "<get-keys>(...)");
        List listM1 = F.m1(setKeySet);
        Collection<Runnable> collectionValues = gVar.holders.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            gVar.main.removeCallbacks((Runnable) it.next());
        }
        gVar.holders.clear();
        gVar.i(false, "releaseAll" + listM1);
        return Y8.t.f7040a;
    }

    public final void f(final String reason, final long timeoutMs) {
        kotlin.jvm.internal.p.i(reason, "reason");
        j(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.util.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return g.g(this.f25680a, reason, timeoutMs);
            }
        });
    }

    public final void i(boolean on, String by) {
        Window windowInvoke = this.window.invoke();
        if (windowInvoke != null) {
            if (on) {
                windowInvoke.addFlags(128);
            } else {
                windowInvoke.clearFlags(128);
            }
        }
        View viewInvoke = this.anchor.invoke();
        if (viewInvoke == null) {
            C4148a.u(TAG, this.tag + ": anchor==null on=" + on + " by='" + by + "' windowApplied=" + (windowInvoke != null), false, 4, null);
        } else {
            viewInvoke.setKeepScreenOn(on);
        }
        C4148a.k(TAG, this.tag + ": keepScreenOn=" + on + " by='" + by + "' holders=" + this.holders.keySet() + " window=" + (windowInvoke != null), false, 4, null);
    }

    public final void j(final InterfaceC5063a<Y8.t> block) {
        if (kotlin.jvm.internal.p.d(Looper.myLooper(), this.main.getLooper())) {
            block.invoke();
        } else {
            this.main.post(new Runnable() { // from class: com.stepos.ailauncher.chat.util.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.k(block);
                }
            });
        }
    }

    public final void l(final String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        j(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.util.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return g.m(this.f25677a, reason);
            }
        });
    }

    public final void n() {
        j(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.util.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return g.o(this.f25679a);
            }
        });
    }

    public /* synthetic */ g(String str, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, int i10, kotlin.jvm.internal.i iVar) {
        this(str, interfaceC5063a, (i10 & 4) != 0 ? a.INSTANCE : interfaceC5063a2);
    }
}
