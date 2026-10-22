package ad1;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f2936c;

    public a(String r100, String r101, Map<String, Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "merchantId");
        Intrinsics.checkNotNullParameter(r101, "cjAppId");
        Intrinsics.checkNotNullParameter(r102, "eventParams");
        this.f2934a = r100;
        this.f2935b = r101;
        this.f2936c = r102;
    }
}
