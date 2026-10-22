package bf;

import android.content.Context;
import android.net.Uri;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Boolean> f18801a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, c> f18802b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<e> f18803c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<d> f18804d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Boolean> f18805e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CopyOnWriteArrayList<C0296a> f18806f = null;

    /* JADX INFO: renamed from: bf.a$a, reason: collision with other inner class name */
    public static class C0296a {
        public C0296a() {
        }
    }

    static {
        Boolean r100 = Boolean.TRUE;
        Map<String, Boolean> r101 = MapsKt.mapOf(new Pair[]{TuplesKt.to("ec_goods_detail", r100), TuplesKt.to("goods/detail/", r100), TuplesKt.to("goods/seeding/", r100), TuplesKt.to("ec_shop/goods/list", r100), TuplesKt.to("goods/shop", r100), TuplesKt.to("goods/store", r100), TuplesKt.to("ec_good_comment", r100), TuplesKt.to("product_inner_feed", r100), TuplesKt.to("ecom_order_list", r100), TuplesKt.to("ec_goods_pdp", r100), TuplesKt.to("ecom_tabkit", r100)});
        f18801a = r101;
        f18802b = new LinkedHashMap();
        f18803c = new ArrayList();
        f18804d = new ArrayList();
        f18805e = new LinkedHashMap();
        f18806f = new CopyOnWriteArrayList();
        Iterator<Map.Entry<String, Boolean>> r102 = r101.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L21;
        Map.Entry<String, Boolean> r103 = r102.next();
        int r104 = b.f18807a;
        String r105 = r103.getKey();
        String r106 = null;
        if (r105 == null) goto L10;
        Uri r107 = UriProtector.parse(r105);
        if (r107 == null) goto L10;
        String r108 = b.a(r107.getHost(), r107.getPath());
    L12:
        if (r108 == null) goto L4;
        if (r108.length() <= 0) goto L16;
        boolean r109 = true;
    L17:
        if (r109 == false) goto L19;
        r106 = r108;
    L19:
        if (r106 == null) goto L4;
        f18805e.put(r106, r103.getValue());
        goto L4
    L16:
        r109 = false;
    L10:
        r108 = null;
        goto L12
    }

    public static void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, PrefetchTiming.ROUTER);
        int r101 = b.f18807a;
        String r102 = r100.b();
        String r103 = null;
        if (r102 == null) goto L9;
        Uri r104 = UriProtector.parse(r102);
        if (r104 == null) goto L9;
        r103 = b.a(r104.getHost(), r104.getPath());
    L9:
        if (r103 != null) goto L12;
        int r105 = ye.a.f567357a;
        ye.a.a(r100.getClass().getName().concat("has wrong schema"));
        return;
    L12:
        f18802b.put(r103, r100);
    }

    public static c b(Uri r100, boolean r101) {
        int r102 = b.f18807a;
        String r103 = b.a(r100.getHost(), r100.getPath());
        if (r103 != null) goto L5;
        return null;
    L5:
        c r104 = (c) ((LinkedHashMap) f18802b).get(r103);
        if (r104 != null) goto L8;
        return null;
    L8:
        if (r101 == false) goto L10;
        r104.a();
    L10:
        return r104;
    }

    public static boolean c(Context r100, Uri r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (r101 != null) goto L5;
        return false;
    L5:
        Iterator r104 = ((ArrayList) f18804d).iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        ((d) r104.next()).a(r100, r101);
        goto L7
    L9:
        Iterator r105 = ((ArrayList) f18803c).iterator();
    L11:
        if (r105.hasNext() == false) goto L21;
        e r106 = (e) r105.next();
        if (r106.a(r101) == false) goto L11;
        boolean r107 = r106.open(r100, r101, r102, r103);
        if (r107 == false) goto L20;
        Iterator<C0296a> r108 = f18806f.iterator();
    L18:
        if (r108.hasNext() == false) goto L20;
        r108.next().getClass();
        Intrinsics.checkNotNullParameter(r101, "uri");
    L20:
        return r107;
    L21:
        c r109 = b(r101, r102);
        if (r109 != null) goto L24;
        return false;
    L24:
        boolean r110 = r109.c(r100, r101, r103);
        if (r110 == false) goto L30;
        Iterator<C0296a> r111 = f18806f.iterator();
    L28:
        if (r111.hasNext() == false) goto L30;
        r111.next().getClass();
        Intrinsics.checkNotNullParameter(r101, "uri");
    L30:
        return r110;
    }
}
