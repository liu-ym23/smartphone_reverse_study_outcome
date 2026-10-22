package bz6;

import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f21877a = null;

    static {
        f21877a = new LinkedHashMap();
    }

    public static String a(PoiBundle r100) {
        Intrinsics.checkNotNullParameter(r100, "poiBundle");
        return r100.poiId + r100.enterMethod + r100.previousEnterFrom;
    }
}
