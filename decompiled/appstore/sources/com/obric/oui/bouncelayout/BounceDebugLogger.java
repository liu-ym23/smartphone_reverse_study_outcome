package com.obric.oui.bouncelayout;

import android.util.Log;
import android.view.View;
import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u0004H\u0007J2\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u0019\u001a\u00020\u0004H\u0007J\u001a\u0010\u001e\u001a\u00020\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0 H\u0086\bø\u0001\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR2\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceDebugLogger;", "", "()V", "TAG", "", "enabled", "", "getEnabled$annotations", "getEnabled", "()Z", "setEnabled", "(Z)V", "listener", "Lkotlin/Function1;", "Lcom/obric/oui/bouncelayout/BounceDebugEvent;", "", "getListener$annotations", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "log", "view", "Landroid/view/View;", "operation", "message", "logContentFrame", FixCard.FixStyle.KEY_X, "", FixCard.FixStyle.KEY_Y, "runIfEnabled", "block", "Lkotlin/Function0;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BounceDebugLogger {

    @NotNull
    public static final BounceDebugLogger INSTANCE = null;

    @NotNull
    private static final String TAG = "OUIBounce";
    private static volatile boolean enabled;

    @Nullable
    private static volatile Function1<? super BounceDebugEvent, Unit> listener;

    static {
        INSTANCE = new BounceDebugLogger();
    }

    private BounceDebugLogger() {
    }

    public static final boolean getEnabled() {
        return enabled;
    }

    @JvmStatic
    public static /* synthetic */ void getEnabled$annotations() {
    }

    @Nullable
    public static final Function1<BounceDebugEvent, Unit> getListener() {
        return listener;
    }

    @JvmStatic
    public static /* synthetic */ void getListener$annotations() {
    }

    @JvmStatic
    public static final void log(@NotNull View r11, @NotNull String r12, @NotNull String r13) {
        q.g(r11, "view");
        q.g(r12, "operation");
        q.g(r13, "message");
        if (enabled == true) goto L5;
        return;
    L5:
        String r10 = r11.getClass().getSimpleName();
        q.f(r10, "view.javaClass.simpleName");
        BounceDebugEvent r14 = new BounceDebugEvent(r10, r12, r11.getScrollX(), r11.getScrollY(), r13, 0, 32, null);
        Log.d(TAG, r14.toLogMessage());
        Function1<? super BounceDebugEvent, Unit> r15 = listener;
        if (r15 == null) goto L10;
        r15.invoke(r14);
        return;
    }

    public static /* synthetic */ void log$default(View r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = "";
    L5:
        log(r10, r11, r12);
    }

    @JvmStatic
    public static final void logContentFrame(@NotNull View r11, @NotNull String r12, float r13, float r14, @NotNull String r15) {
        q.g(r11, "view");
        q.g(r12, "operation");
        q.g(r15, "message");
        if (enabled == true) goto L5;
        return;
    L5:
        String r10 = r11.getClass().getSimpleName();
        q.f(r10, "view.javaClass.simpleName");
        BounceDebugEvent r16 = new BounceDebugEvent(r10, r12, r13, r14, r15, 0, 32, null);
        Log.d(TAG, r16.toLogMessage());
        Function1<? super BounceDebugEvent, Unit> r17 = listener;
        if (r17 == null) goto L10;
        r17.invoke(r16);
        return;
    }

    public static /* synthetic */ void logContentFrame$default(View r10, String r11, float r12, float r13, String r14, int r15, Object r16) {
        if ((r15 & 16) == 0) goto L5;
        r14 = "";
    L5:
        logContentFrame(r10, r11, r12, r13, r14);
    }

    public static final void setEnabled(boolean r10) {
        enabled = r10;
    }

    public static final void setListener(@Nullable Function1<? super BounceDebugEvent, Unit> r10) {
        listener = r10;
    }

    public final void runIfEnabled(@NotNull Function0<Unit> r10) {
        q.g(r10, "block");
        if (getEnabled() == false) goto L6;
        r10.invoke();
        return;
    }
}
