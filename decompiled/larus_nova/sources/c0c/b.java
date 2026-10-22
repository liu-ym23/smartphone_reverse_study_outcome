package c0c;

import com.ss.android.lark.passportc.api.g;
import com.ss.android.lark.passportc.api.j;
import f0c.e;
import f0c.f;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f21992a;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserChanged(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
    }

    public void lf(f0c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toState");
    }

    @Deprecated(message = "UserPayload doesn't provide enough information. Use GlobalState instead.", replaceWith = @ReplaceWith(expression = "Use GlobalScopeRepository.destroy(GlobalState)", imports = {}))
    public void mf(f0c.g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
    }

    public void nf(f0c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toState");
    }

    @Deprecated(message = "UserPayload doesn't provide enough information. Use GlobalState instead.", replaceWith = @ReplaceWith(expression = "Use GlobalScopeRepository.onPrepared(GlobalState)", imports = {}))
    public void of(f0c.g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOffline(e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOnline(f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    public void pf(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "toState");
    }

    @Deprecated(message = "UserPayload doesn't provide enough information. Use GlobalState instead.", replaceWith = @ReplaceWith(expression = "Use GlobalScopeRepository.preparing(UserPayload?, GlobalState)", imports = {}))
    public void qf(f0c.g r100, f0c.g r101) {
    }

    @Override // com.ss.android.lark.passportc.api.g
    public final j getPassport() {
        return this.f21992a;
    }

    public b(j r100) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        this.f21992a = r100;
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOffline(e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        lf(r100);
        mf(r100.f475031c);
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOnline(f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        nf(r100);
        of(r100.f475032c);
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserChanged(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
        pf(r100, r101);
        qf(r100, r101.a());
    }
}
