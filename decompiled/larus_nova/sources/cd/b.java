package cd;

import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.BtmPage;
import com.bytedance.android.btm.api.PageProp;
import com.bytedance.android.btm.api.e;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<?>, BtmPage> f23357a = null;

    static {
        f23357a = new ConcurrentHashMap();
    }

    public static PageProp a(Object r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        BtmHostDependManager.F.getClass();
        Iterator<com.bytedance.android.btm.api.d> r100 = BtmHostDependManager.f41957y.iterator();
    L7:
        if (r100.hasNext() == false) goto L14;
        com.bytedance.android.btm.api.d r101 = r100.next();
        if (Intrinsics.areEqual(r101.f41967a, r110.getClass()) == true) goto L13;
        if (r110.getClass().getName().equals(r101.f41968b) == false) goto L7;
    L13:
        return new PageProp(r101.f41969c, r101.f41970d, r101.f41971e, r101.f41972f, null, 16, null);
    L14:
        BtmHostDependManager.F.getClass();
        Iterator<e> r102 = BtmHostDependManager.f41958z.iterator();
    L16:
        if (r102.hasNext() == false) goto L21;
        e r103 = r102.next();
        if (Intrinsics.areEqual(r103.f41973a.get(), r110) == false) goto L16;
        return new PageProp(r103.f41974b, r103.f41975c, r103.f41976d, r103.f41977e, null, 16, null);
    L21:
        BtmHostDependManager r104 = BtmHostDependManager.F;
        r104.getClass();
        if (((Boolean) BtmHostDependManager.f41952t.getValue(r104, BtmHostDependManager.f41933a[18])).booleanValue() == true) goto L34;
    L33:
        return null;
    L34:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L31
        ConcurrentHashMap<Class<?>, BtmPage> r106 = f23357a;     // Catch: Throwable -> L31
        BtmPage r107 = r106.get(r110.getClass());     // Catch: Throwable -> L31
        if (r107 != null) goto L26;
        r107 = (BtmPage) r110.getClass().getAnnotation(BtmPage.class);     // Catch: Throwable -> L31
    L26:
        if (r107 == null) goto L29;
        r106.put(r110.getClass(), r107);     // Catch: Throwable -> L31
        return new PageProp(r107.value(), r107.auto(), r107.singleton(), false, null, 24, null);
    L29:
        Result.m9449constructorimpl(null);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L33
    }
}
