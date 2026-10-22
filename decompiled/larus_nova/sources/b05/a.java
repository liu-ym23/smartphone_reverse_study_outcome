package b05;

import com.bytedance.ee.bear.contract.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f16881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, Object> f16882b;

    /* JADX INFO: renamed from: b05.a$a, reason: collision with other inner class name */
    public static final class C0248a {
    }

    static {
    }

    public a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "analyticService");
        this.f16881a = r100;
        this.f16882b = new HashMap();
        HashMap<String, Object> r101 = r100.m("docCommonParams");
        if ((!r101.isEmpty()) == false) goto L8;
        Iterator<Map.Entry<String, Object>> r102 = r101.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, Object> r103 = r102.next();
        this.f16882b.put(r103.getKey(), r103.getValue());
        goto L6
    L10:
        return;
    }
}
