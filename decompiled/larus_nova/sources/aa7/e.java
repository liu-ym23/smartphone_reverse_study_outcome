package aa7;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f2352a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, a> f2353b = null;

    static {
        HashMap r100 = new HashMap();
        f2352a = r100;
        HashMap r101 = new HashMap();
        f2353b = r101;
        r100.put("in", new f());
        r100.put("isIntersect", new g());
        r100.put(Argument.OUT, new k());
        r100.put("==", new d());
        r100.put("!=", new h());
        r100.put("&&", new b());
        r100.put("||", new j());
        r100.put("matches", new l.c());
        r100.put("endwith", new l.b());
        r100.put("startwith", new l.d());
        r100.put("contains", new l.a());
        r100.put("!", new i());
        r101.put("array", new c());
    }
}
