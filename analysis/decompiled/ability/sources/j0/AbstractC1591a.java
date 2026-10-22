package j0;

import Z6.k;
import com.apm.insight.runtime.ConfigManager;
import java.util.ArrayList;

/* renamed from: j0.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1591a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4751a;
    public static final ArrayList b;
    public static final ArrayList c;
    public static final ArrayList d;
    public static final String e;
    public static final ArrayList f;

    static {
        String strConcat = k.f.concat("apmplus.volces.com");
        f4751a = strConcat;
        ArrayList arrayList = new ArrayList();
        b = arrayList;
        arrayList.add(strConcat + ConfigManager.CONFIG_URL_SUFFIX);
        ArrayList arrayList2 = new ArrayList();
        c = arrayList2;
        arrayList2.add(strConcat + "/monitor/collect/batch/");
        d = new ArrayList();
        e = androidx.appfunctions.metadata.a.l(strConcat, ConfigManager.EXCEPTION_URL_SUFFIX);
        ArrayList arrayList3 = new ArrayList();
        f = arrayList3;
        arrayList3.add(strConcat + ConfigManager.EXCEPTION_URL_SUFFIX);
        StringBuilder sb = new StringBuilder();
        sb.append(strConcat);
        sb.append(ConfigManager.FILE_UPLOAD_URL_SUFFIX);
    }
}
