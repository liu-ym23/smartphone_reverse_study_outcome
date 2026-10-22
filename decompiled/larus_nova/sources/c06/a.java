package c06;

import com.bytedance.helios.api.consumer.PrivacyEvent;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements lz5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f21943a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21944b = null;

    public a() {
    }

    @Override // lz5.a
    public final boolean b(PrivacyEvent r100, Map<String, ? extends Object> r101) {
        return false;
    }

    static {
        f21944b = new a();
        f21943a = CollectionsKt.listOf(100012);
    }

    @Override // lz5.a
    public final List<Integer> a() {
        return f21943a;
    }

    @Override // lz5.a
    public final void c(PrivacyEvent r100) {
        Object[] r101 = r100.f245389z.getParameters();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length != 3) goto L20;
        Set<Map<String, ?>> r102 = r100.L;
        Pair[] r103 = new Pair[3];
        Object r104 = r101[0];
        String r105 = null;
        if (r104 == null) goto L9;
        String r106 = r104.toString();
    L10:
        r103[0] = TuplesKt.to("extra_parameter_origin", r106);
        Object r107 = r101[1];
        if (r107 == null) goto L13;
        String r108 = r107.toString();
    L14:
        r103[1] = TuplesKt.to("extra_parameter_allow", r108);
        Object r109 = r101[2];
        if (r109 == null) goto L17;
        r105 = r109.toString();
    L17:
        r103[2] = TuplesKt.to("extra_parameter_retain", r105);
        r102.add(MapsKt.hashMapOf(r103));
        return;
    L13:
        r108 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    }
}
