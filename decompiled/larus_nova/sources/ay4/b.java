package ay4;

import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ss.android.lark.storage.a f16748a = null;

    static {
        f16748a = new com.ss.android.lark.storage.a(ChameleonResConstants.CCM_ROOT_DIR);
    }

    public static n6c.b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return new n6c.b(LarkContext.getApplication().getSharedPreferences(r100, 0));
    }

    public static /* synthetic */ com.ss.android.lark.storage.kv.repo.a c(String r100) {
        return b(r100, true, null);
    }

    public static com.ss.android.lark.storage.kv.repo.a d(String r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = null;
    L6:
        return LarkKVStorage.p(f16748a, r100, false);
    }

    @JvmStatic
    public static final com.ss.android.lark.storage.kv.repo.a b(String r100, boolean r101, KVRepo r102) {
        if (r101 == false) goto L7;
        if (r102 == null) goto L7;
        return LarkKVStorage.f(f16748a, r100, r102);
    L7:
        return LarkKVStorage.g(f16748a, r100, r101);
    }
}
