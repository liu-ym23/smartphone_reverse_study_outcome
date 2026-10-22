package by4;

import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@UserScope
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.storage.kv.storage.a f21393a;

    @Inject
    public b(com.ss.android.lark.storage.kv.storage.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userKvStorage");
        this.f21393a = r100;
    }

    @Override // by4.d
    public final com.ss.android.lark.storage.kv.repo.a b(String r100) {
        return com.ss.android.lark.storage.kv.storage.a.b(this.f21393a, ay4.b.f16748a, r100, null, 4);
    }
}
