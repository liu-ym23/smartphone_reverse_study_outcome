package an9;

import com.larus.office.permission.DocPermissionFullData;
import com.larus.utils.logger.FLogger;
import fo9.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fo9.b f4562a;

    /* JADX INFO: renamed from: an9.a$a, reason: collision with other inner class name */
    public static final class C0090a {
    }

    static {
    }

    @Override // fo9.g
    public final void Wf() {
        FLogger.f375446a.i("DocPermissionAdaptHostAbilityImpl", "notifyPermissionApplyRegister");
        fo9.b r100 = this.f4562a;
        if (r100 == null) goto L6;
        r100.d2();
        return;
    }

    public a(fo9.b r100) {
        this.f4562a = r100;
    }

    @Override // fo9.g
    public final void Ic(DocPermissionFullData r100, Function2<? super Boolean, ? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "permission");
        Intrinsics.checkNotNullParameter(r101, "callback");
        FLogger.f375446a.i("DocPermissionAdaptHostAbilityImpl", "notifyPermissionChange: permission=" + r100 + '}');
        fo9.b r102 = this.f4562a;
        if (r102 == null) goto L6;
        r102.V0(r100, r101);
        return;
    }
}
