package c06;

import android.webkit.PermissionRequest;
import com.bytedance.helios.api.consumer.PrivacyEvent;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements lz5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f21947a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f21948b = null;

    public c() {
    }

    @Override // lz5.a
    public final boolean b(PrivacyEvent r100, Map<String, ? extends Object> r101) {
        return false;
    }

    static {
        f21948b = new c();
        f21947a = CollectionsKt.listOf(102604);
    }

    @Override // lz5.a
    public final List<Integer> a() {
        return f21947a;
    }

    @Override // lz5.a
    public final void c(PrivacyEvent r100) {
        Object[] r101 = r100.f245389z.getParameters();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length != 1) goto L13;
        Object r102 = r101[0];
        if ((r102 instanceof PermissionRequest) == false) goto L14;
        if (r102 == null) goto L11;
        PermissionRequest r103 = (PermissionRequest) r102;
        r100.L.add(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("extra_parameter_origin", r103.getOrigin().toString()), TuplesKt.to("extra_parameter_resources", r103.getResources())}));
        return;
    L11:
        throw new TypeCastException("null cannot be cast to non-null type android.webkit.PermissionRequest");
    L14:
        return;
    }
}
