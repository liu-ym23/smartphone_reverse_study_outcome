package af3;

import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f3170e;

    public g(Map<String, ? extends Object> r100) {
        this.f3170e = r100;
        String r101 = "";
        if (r100 == null) goto L8;
        Object r102 = r100.get("page_name");
        if (r102 == null) goto L8;
        String r103 = r102.toString();
        if (r103 == null) goto L8;
    L9:
        this.f3166a = r103;
        if (r100 == null) goto L17;
        Object r104 = r100.get("enter_from");
        if (r104 == null) goto L17;
        String r105 = r104.toString();
        if (r105 == null) goto L17;
        r101 = r105;
    L17:
        this.f3167b = r101;
        if (r100 == null) goto L23;
        Object r106 = r100.get("ec_device_score");
        if (r106 == null) goto L23;
        String r107 = r106.toString();
        if (r107 == null) goto L23;
    L24:
        CastFloatProtector.parseFloat(r107);
        Object r108 = null;
        if (r100 == null) goto L27;
        Object r109 = r100.get("real_open_time");
    L29:
        if ((r109 instanceof Long) == true) goto L31;
        r109 = null;
    L31:
        Long r110 = (Long) r109;
        if (r110 == null) goto L34;
        long r111 = r110.longValue();
    L35:
        this.f3168c = r111;
        if (r100 == null) goto L38;
        Object r112 = r100.get("is_guide_to_mall_by_schema");
    L40:
        if ((r112 instanceof Boolean) == false) goto L43;
        r108 = r112;
    L43:
        this.f3169d = Intrinsics.areEqual((Boolean) r108, Boolean.TRUE);
        return;
    L38:
        r112 = null;
        goto L40
    L34:
        r111 = System.currentTimeMillis();
        goto L35
    L27:
        r109 = null;
    L23:
        r107 = "0";
    L8:
        r103 = "";
        goto L9
    }
}
