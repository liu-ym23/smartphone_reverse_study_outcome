package afa;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.obric_action.handler.auth.DismissKeyguardActionHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;

/* JADX INFO: loaded from: classes33.dex */
public final class b implements oga.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f3227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<com.obric.assistant.obric_action.h<Unit>> f3228b;

    @Override // oga.a
    public final void onDismissFailed() {
        FLogger.f375446a.i("DismissKeyguardActionHandler", "onDismissFailed");
        DismissKeyguardActionHandler.e(this.f3227a, this.f3228b, com.obric.assistant.obric_action.h.a.a(com.obric.assistant.obric_action.h.f390443d, "dismissKeyguard failed", 2), "onDismissFailed");
    }

    @Override // oga.a
    public final void onDismissSucceeded() {
        FLogger.f375446a.i("DismissKeyguardActionHandler", "onDismissSucceeded");
        DismissKeyguardActionHandler.e(this.f3227a, this.f3228b, com.obric.assistant.obric_action.h.a.c(com.obric.assistant.obric_action.h.f390443d, null, null, 3), "onDismissSucceeded");
    }

    public b(AtomicBoolean r100, kotlinx.coroutines.j r101) {
        this.f3227a = r100;
        this.f3228b = r101;
    }
}
