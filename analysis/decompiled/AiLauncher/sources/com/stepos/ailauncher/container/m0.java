package com.stepos.ailauncher.container;

import com.autonavi.aps.amapapi.config.Const;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H\u0000¢\u0006\u0004\b\u0016\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0003J\u001f\u0010\u0019\u001a\u00020\u00072\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H\u0000¢\u0006\u0004\b\u0019\u0010\u0015J\r\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u0003J!\u0010\u001d\u001a\u00020\u00072\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0004H\u0000¢\u0006\u0004\b \u0010\u000bJ\r\u0010!\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\u0003R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000e0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010$R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0%8\u0006¢\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b,\u0010)R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010$R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0006¢\u0006\f\n\u0004\b.\u0010'\u001a\u0004\b/\u0010)R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010$R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0006¢\u0006\f\n\u0004\b1\u0010'\u001a\u0004\b2\u0010)R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00104R\u001e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00104R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u00040\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010$R<\u0010:\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u001b08j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u001b`98\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0011\u0010>\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0011\u0010\u000f\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0011\u0010B\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bA\u0010=¨\u0006C"}, d2 = {"Lcom/stepos/ailauncher/container/m0;", "", "<init>", "()V", "", "open", "returningHome", "LY8/t;", "o", "(ZZ)V", "r", "(Z)V", com.stepos.ailauncher.chat.trace.h.APP_FOREGROUND, "q", "", "progress", "s", "(F)V", "Lkotlin/Function0;", "requester", "m", "(Lp9/a;)V", "n", "k", "hider", "l", "f", "Lkotlin/Function1;", "listener", Const.INTENT_KEY_APIKEY, "(Lp9/l;)V", "suspended", "t", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "LXa/k;", "_isOpen", "LXa/k;", "LXa/t;", "isOpenFlow", "LXa/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()LXa/t;", "_progress", "progressFlow", "e", "_hostForeground", "hostForegroundFlow", Const.INTENT_KEY_PKGNAME, "_panelFullyOpen", "panelFullyOpenFlow", "c", "inputFocusRequester", "Lp9/a;", "peekRestoreRequester", "homeConsumeImeHider", "_recentsInputSuspended", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "recentsInputSuspendedListeners", "Ljava/util/LinkedHashSet;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Z", "isOpen", Const.INTENT_KEY_UMID, "()F", Const.INTENT_KEY_BACKGROUND_COMMAND, "isHostForeground", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class m0 {
    public static final m0 INSTANCE = new m0();
    private static final Xa.k<Boolean> _hostForeground;
    private static final Xa.k<Boolean> _isOpen;
    private static final Xa.k<Boolean> _panelFullyOpen;
    private static final Xa.k<Float> _progress;
    private static final Xa.k<Boolean> _recentsInputSuspended;
    private static volatile InterfaceC5063a<Y8.t> homeConsumeImeHider;
    private static final Xa.t<Boolean> hostForegroundFlow;
    private static volatile InterfaceC5063a<Y8.t> inputFocusRequester;
    private static final Xa.t<Boolean> isOpenFlow;
    private static final Xa.t<Boolean> panelFullyOpenFlow;
    private static volatile InterfaceC5063a<Y8.t> peekRestoreRequester;
    private static final Xa.t<Float> progressFlow;
    private static final LinkedHashSet<InterfaceC5074l<Boolean, Y8.t>> recentsInputSuspendedListeners;

    static {
        Boolean bool = Boolean.FALSE;
        Xa.k<Boolean> kVarA = Xa.u.a(bool);
        _isOpen = kVarA;
        isOpenFlow = Xa.d.c(kVarA);
        Xa.k<Float> kVarA2 = Xa.u.a(Float.valueOf(0.0f));
        _progress = kVarA2;
        progressFlow = Xa.d.c(kVarA2);
        Xa.k<Boolean> kVarA3 = Xa.u.a(bool);
        _hostForeground = kVarA3;
        hostForegroundFlow = Xa.d.c(kVarA3);
        Xa.k<Boolean> kVarA4 = Xa.u.a(bool);
        _panelFullyOpen = kVarA4;
        panelFullyOpenFlow = Xa.d.c(kVarA4);
        _recentsInputSuspended = Xa.u.a(bool);
        recentsInputSuspendedListeners = new LinkedHashSet<>();
    }

    public static /* synthetic */ void p(m0 m0Var, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        m0Var.o(z10, z11);
    }

    public final void a(InterfaceC5074l<? super Boolean, Y8.t> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        LinkedHashSet<InterfaceC5074l<Boolean, Y8.t>> linkedHashSet = recentsInputSuspendedListeners;
        synchronized (linkedHashSet) {
            linkedHashSet.add(listener);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            listener.invoke(_recentsInputSuspended.getValue());
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final Xa.t<Boolean> b() {
        return hostForegroundFlow;
    }

    public final Xa.t<Boolean> c() {
        return panelFullyOpenFlow;
    }

    public final float d() {
        return _progress.getValue().floatValue();
    }

    public final Xa.t<Float> e() {
        return progressFlow;
    }

    public final void f() {
        InterfaceC5063a<Y8.t> interfaceC5063a = homeConsumeImeHider;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public final boolean g() {
        return _hostForeground.getValue().booleanValue();
    }

    public final boolean h() {
        return _isOpen.getValue().booleanValue();
    }

    public final Xa.t<Boolean> i() {
        return isOpenFlow;
    }

    public final void j() {
        InterfaceC5063a<Y8.t> interfaceC5063a = inputFocusRequester;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public final void k() {
        InterfaceC5063a<Y8.t> interfaceC5063a = peekRestoreRequester;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public final void l(InterfaceC5063a<Y8.t> hider) {
        homeConsumeImeHider = hider;
    }

    public final void m(InterfaceC5063a<Y8.t> requester) {
        inputFocusRequester = requester;
    }

    public final void n(InterfaceC5063a<Y8.t> requester) {
        peekRestoreRequester = requester;
    }

    public final void o(boolean open, boolean returningHome) {
        _isOpen.setValue(Boolean.valueOf(open));
        com.stepos.ailauncher.common.utils.r.INSTANCE.D(g(), open, returningHome);
        _progress.setValue(Float.valueOf(open ? 1.0f : 0.0f));
    }

    public final void q(boolean foreground) {
        _hostForeground.setValue(Boolean.valueOf(foreground));
        com.stepos.ailauncher.common.utils.r.E(com.stepos.ailauncher.common.utils.r.INSTANCE, foreground, h(), false, 4, null);
    }

    public final void r(boolean open) {
        _panelFullyOpen.setValue(Boolean.valueOf(open));
    }

    public final void s(float progress) {
        _progress.setValue(Float.valueOf(progress));
    }

    public final void t(boolean suspended) {
        List<InterfaceC5074l> listM1;
        Xa.k<Boolean> kVar = _recentsInputSuspended;
        if (kVar.getValue().booleanValue() == suspended) {
            return;
        }
        kVar.setValue(Boolean.valueOf(suspended));
        LinkedHashSet<InterfaceC5074l<Boolean, Y8.t>> linkedHashSet = recentsInputSuspendedListeners;
        synchronized (linkedHashSet) {
            listM1 = Z8.F.m1(linkedHashSet);
        }
        for (InterfaceC5074l interfaceC5074l : listM1) {
            try {
                Result.Companion companion = Result.INSTANCE;
                interfaceC5074l.invoke(Boolean.valueOf(suspended));
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }
}
