package au3;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import xu3.e;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends pu3.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f16313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f16314d;

    @Override // pu3.a
    public final JSONObject d() {
        return null;
    }

    @Override // pu3.a
    public final String f() {
        return "fd";
    }

    @Override // nu3.c
    public final boolean isValid() {
        return true;
    }

    @Override // pu3.a
    public final JSONObject b() {
        JSONObject r100 = new JSONObject();
        r100.put("fd_count", this.f16312b);     // Catch: Exception -> L19
        if (e.b(this.f16313c) == true) goto L18;
        List<String> r101 = this.f16313c;     // Catch: Exception -> L19
        if (r101 != null) goto L8;
        String r102 = null;
    L17:
        r100.put("fd_detail", r102);     // Catch: Exception -> L19
        goto L18
    L8:
        StringBuilder r103 = new StringBuilder();     // Catch: Exception -> L19
        Iterator<String> r104 = r101.iterator();     // Catch: Exception -> L19
        boolean r105 = true;
    L10:
        if (r104.hasNext() == false) goto L16;
        String r106 = r104.next();     // Catch: Exception -> L19
        if (r105 == false) goto L14;
        r105 = false;
    L15:
        r103.append(r106.toString());     // Catch: Exception -> L19
        goto L10
    L14:
        r103.append("\n");     // Catch: Exception -> L19
        goto L15
    L16:
        r102 = r103.toString();     // Catch: Exception -> L19
    L18:
        return r100;
    }

    @Override // pu3.a
    public final JSONObject c() {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L4
        r100.put("scene", ou3.a.a().e());     // Catch: Throwable -> L4
        r100.put("process_name", du3.a.e());     // Catch: Throwable -> L4
        r100.put(LocationMonitorConst.IS_MAIN_PROCESS, du3.a.o());     // Catch: Throwable -> L4
    L5:
        if (r100 == null) goto L12;
    L7:
        r100.put("is_front", this.f16314d);     // Catch: Exception -> L9
    L8:
        return r100;
    L12:
        r100 = new JSONObject();     // Catch: Exception -> L9
    L4:
        r100 = null;
        goto L5
    }

    @Override // pu3.a
    public final JSONObject e() {
        return ou3.a.a().b();
    }

    public c(int r100, List<String> r101, boolean r102) {
        this.f16312b = r100;
        this.f16313c = r101;
        this.f16314d = r102;
    }
}
