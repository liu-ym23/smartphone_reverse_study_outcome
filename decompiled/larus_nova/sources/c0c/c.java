package c0c;

import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import f0c.h;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class c implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f21993a;

    @Deprecated(message = "this callback doesn't provide enough information. Passing UserStatePayload instead.", replaceWith = @ReplaceWith(expression = "Use UserScopeRepository.destroy(UserStatePayload)", imports = {}))
    public void c() {
    }

    public void d(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Deprecated(message = "this callback doesn't provide enough information. Passing UserStatePayload instead.", replaceWith = @ReplaceWith(expression = "Use UserScopeRepository.onPrepared(UserStatePayload)", imports = {}))
    public void e() {
    }

    public void i(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Deprecated(message = "this callback doesn't provide enough information. Passing UserStatePayload instead.", replaceWith = @ReplaceWith(expression = "Use UserScopeRepository.preparing(UserStatePayload)", imports = {}))
    public void k() {
    }

    public void l(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.r
    public m getPassport() {
        return this.f21993a;
    }

    public c(m r100) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        this.f21993a = r100;
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        c();
        d(r100);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        e();
        i(r100);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        k();
        l(r100);
    }
}
