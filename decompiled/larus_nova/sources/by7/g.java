package by7;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f21470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<cy7.b> f21471b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap<String, String> f21472c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f21473d = null;

    public g() {
    }

    static {
        f21473d = new g();
        f21471b = CollectionsKt.mutableListOf(new cy7.b[]{new cy7.a()});
        f21472c = new LinkedHashMap();
    }

    @JvmStatic
    public static final void a(cy7.b r100) {
        f21471b.add(r100);
    }

    @Override // by7.b
    public final void onEvent(String r100, JSONObject r101) {
        Iterator<T> r102 = f21471b.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((cy7.b) r102.next()).intercept(r100, r101);
        goto L4
    L6:
        b r103 = f21470a;
        if (r103 == null) goto L11;
        r103.onEvent(r100, r101);
        return;
    }
}
