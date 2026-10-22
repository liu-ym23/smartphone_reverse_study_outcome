package a0c;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.internal.p;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yzb.b f1355a;

    @Inject
    public a(yzb.b r100) {
        Intrinsics.checkNotNullParameter(r100, "userListApi");
        this.f1355a = r100;
    }

    @Override // com.ss.android.lark.passportc.internal.p
    public final User a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        return this.f1355a.a(r100);
    }
}
