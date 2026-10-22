package b9a;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends a9a.a implements h9a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PolarisFileWrapper f18354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f18355c;

    @Override // a9a.a
    public final String f() {
        return "db";
    }

    @Override // h9a.a
    public final List<String> a() {
        ArrayList r100 = new ArrayList(1);
        PolarisFileWrapper r101 = this.f18354b;
        if (r101 == null) goto L5;
        r100.add(r101.getAbsolutePath());
    L5:
        return r100;
    }

    public d() {
        this.f18354b = null;
        this.f18355c = false;
    }

    @Override // a9a.a
    public final boolean g(z8a.a r100) throws Exception {
        JSONObject r101 = new JSONObject(r100.f570965a);
        if (a9a.a.e(r101, r100) == false) goto L6;
        return true;
    L6:
        if (this.f18355c == false) goto L9;
        i9a.b r102 = new i9a.b(r100.f570967c, null);
        r102.f488823d = 0;
        r102.f488824e = "数据库文件正在处理中";
        g9a.a.c(r102);
        return true;
    L9:
        this.f18355c = true;
        PolarisFileWrapper r103 = d9a.a.a(x8a.c.b().getContext(), r101.optString("db_name", ""));     // Catch: Throwable -> L12
        this.f18355c = false;
    L13:
        if (r103 != null) goto L16;
        a9a.a.h("Sqlite文件拷贝失败", r100);
        return true;
    L16:
        this.f18354b = r103;
        i9a.a r104 = new i9a.a(r101.optString("fileContentType", "default_db_file_type"), r100.f570967c, this, null);
        r104.f488815k = false;
        r104.f488817m = true;
        g9a.a.b(r104);
        return true;
    L12:
        this.f18355c = false;
        r103 = null;
        goto L13
    }
}
