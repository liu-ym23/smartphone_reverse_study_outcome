package b57;

import android.net.Uri;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements i47.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Uri f17775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map<String, String> f17776b;

    @Override // i47.d
    public final /* synthetic */ Map getOptions() {
        return null;
    }

    @Override // i47.d
    public final /* synthetic */ boolean isForMainFrame() {
        return false;
    }

    @Override // i47.d
    public final Map<String, String> getRequestHeaders() {
        HashMap r100 = new HashMap();
        Map<String, String> r101 = this.f17776b;
        if (r101 == null) goto L8;
        Iterator<Map.Entry<String, String>> r102 = r101.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        Map.Entry<String, String> r103 = r102.next();
        r100.put(r103.getKey(), r103.getValue());
    L8:
        return r100;
    }

    @Override // i47.d
    public final Uri getUrl() {
        return this.f17775a;
    }

    public c(Uri r100, Map<String, String> r101) {
        this.f17775a = r100;
        this.f17776b = r101;
    }
}
