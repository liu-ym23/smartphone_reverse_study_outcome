package pa;

import android.content.Context;
import android.text.TextUtils;
import com.stepos.core.ota.d;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import qa.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final b f11472a;

    /* renamed from: b, reason: collision with root package name */
    public final pa.a f11473b;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f11474c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f11475d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Context f11476a = null;

        /* renamed from: b, reason: collision with root package name */
        public String f11477b;

        /* renamed from: c, reason: collision with root package name */
        public String f11478c;

        /* renamed from: d, reason: collision with root package name */
        public String f11479d;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x022c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0229  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(pa.c.a r19) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 997
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pa.c.<init>(pa.c$a):void");
    }

    public static HashMap a(Context context) {
        String strI;
        HashMap map = new HashMap();
        Double dValueOf = Double.valueOf(0.0d);
        map.put("longitude", dValueOf);
        map.put("latitude", dValueOf);
        map.put("loc_time", 0L);
        map.put("operator", "");
        map.put("stepos_uid", "");
        if (TextUtils.isEmpty(g.f11641e)) {
            Locale locale = context.getResources().getConfiguration().locale;
            String language = locale.getLanguage();
            String country = locale.getCountry();
            if (language == null) {
                language = "";
            }
            strI = d.i(language, "_", country != null ? country : "");
            g.f11641e = strI;
        } else {
            strI = g.f11641e;
        }
        map.put("lla", strI);
        ta.c.a("c", "getVolatileProperty ..." + map);
        return map;
    }

    public static c b(Context context, String str, String str2) {
        ta.c.d("c", "buildSubject start， replacePackage: ");
        if (TextUtils.isEmpty("")) {
            a aVar = new a();
            aVar.f11476a = context;
            aVar.f11477b = str;
            aVar.f11478c = str2;
            return new c(aVar);
        }
        a aVar2 = new a();
        aVar2.f11476a = context;
        aVar2.f11477b = str;
        aVar2.f11478c = str2;
        aVar2.f11479d = "";
        return new c(aVar2);
    }

    public final void c(int i10, String str) {
        if (str.isEmpty()) {
            return;
        }
        this.f11475d.put(str, Integer.valueOf(i10));
    }

    public final void d(String str, String str2) {
        if (str.isEmpty() || str2 == null) {
            return;
        }
        this.f11475d.put(str, str2);
    }
}
