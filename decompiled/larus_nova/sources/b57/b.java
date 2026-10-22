package b57;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f17774a = null;

    static {
        f17774a = new b();
    }

    public b() {
    }

    public static void a() {
        com.bytedance.pia.snapshot.storage.a r100 = com.bytedance.pia.snapshot.storage.a.f266521a;
        Iterator<Map.Entry<String, ?>> r101 = com.bytedance.pia.snapshot.storage.a.f266522b.getAll().entrySet().iterator();
        long r102 = System.currentTimeMillis();
    L4:
        if (r101.hasNext() == false) goto L31;
        Map.Entry<String, ?> r103 = r101.next();
        Unit r104 = null;
        if (StringsKt.endsWith$default(r103.getKey(), "_detail_id", false, 2, null) == true) goto L4;
        String r105 = r103.getKey();
        Keva r106 = com.bytedance.pia.snapshot.storage.a.c(r105);
        if (r106 == null) goto L29;
        Iterator<Map.Entry<String, ?>> r107 = r106.getAll().entrySet().iterator();
    L11:
        if (r107.hasNext() == false) goto L26;
        Map.Entry<String, ?> r108 = r107.next();
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L15
        Object r110 = r108.getValue();     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L15
        Object r111 = Result.m9449constructorimpl(new JSONObject((String) r110));     // Catch: Throwable -> L15
    L18:
        if (Result.m9452exceptionOrNullimpl(r111) == null) goto L21;
        r106.erase(r108.getKey());
    L21:
        if (Result.m9456isSuccessimpl(r111) == false) goto L11;
        JSONObject r112 = (JSONObject) r111;
        if (JSONObjectProtectorUtils.getLong(r112, "expire_time") > r102) goto L11;
        String r113 = JSONObjectProtectorUtils.getString(r112, "content_UUID");
        com.bytedance.pia.snapshot.storage.a.f266523c.erase(r113);
        r106.erase(r108.getKey());
    L15:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    L26:
        if (r106.count() != 0) goto L28;
        com.bytedance.pia.snapshot.storage.a r115 = com.bytedance.pia.snapshot.storage.a.f266521a;
        com.bytedance.pia.snapshot.storage.a.b(r105);
    L28:
        r104 = Unit.INSTANCE;
    L29:
        if (r104 != null) goto L4;
        com.bytedance.pia.snapshot.storage.a.b(r105);
        goto L4
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
