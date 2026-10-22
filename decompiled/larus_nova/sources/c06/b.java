package c06;

import com.bytedance.helios.api.consumer.PrivacyEvent;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements lz5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f21945a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f21946b = null;

    public b() {
    }

    @Override // lz5.a
    public final boolean b(PrivacyEvent r100, Map<String, ? extends Object> r101) {
        return false;
    }

    static {
        f21946b = new b();
        f21945a = CollectionsKt.listOf(100003);
    }

    @Override // lz5.a
    public final List<Integer> a() {
        return f21945a;
    }

    @Override // lz5.a
    public final void c(PrivacyEvent r100) {
        Object[] r101 = r100.f245389z.getParameters();
        if (r101 != null) goto L5;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L19;
        Object r103 = r101[0];
        if (r103 == null) goto L16;
        String r104 = r103.toString();
    L17:
        r100.L.add(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("extra_parameter_origin", r104)}));
        return;
    L16:
        r104 = null;
        goto L17
    L19:
        return;
    L5:
        if (r101.length != 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L11;
        r102 = false;
        goto L12
    L7:
        r105 = false;
        goto L8
    }
}
