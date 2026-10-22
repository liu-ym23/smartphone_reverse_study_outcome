package m4;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi._MoshiKotlinExtensionsKt;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    public final JsonAdapter f6326a;

    public r0() {
        Moshi moshiBuild = new Moshi.Builder().build();
        q7.k.e(moshiBuild, "moshi");
        w7.x xVar = w7.x.f10874c;
        q7.x xVar2 = q7.w.f8821a;
        w7.d dVarB = xVar2.b(String.class);
        List list = Collections.EMPTY_LIST;
        w7.u uVarI = xVar2.i(dVarB, list, false);
        q7.k.e(uVarI, "type");
        w7.y yVar = w7.y.f10877f;
        w7.x xVar3 = new w7.x(yVar, uVarI);
        w7.u uVarI2 = xVar2.i(xVar2.b(Object.class), list, true);
        q7.k.e(uVarI2, "type");
        this.f6326a = _MoshiKotlinExtensionsKt.adapter(moshiBuild, xVar2.i(xVar2.b(Map.class), Arrays.asList(xVar3, new w7.x(yVar, uVarI2)), false));
    }

    public final void a(File file, p7.k kVar) throws IOException {
        q7.k.e(file, "file");
        Map mapB = b(file);
        kVar.invoke(mapB);
        c(file, mapB);
    }

    public final Map b(File file) throws IOException {
        q7.k.e(file, "file");
        if (!file.exists() || file.length() == 0) {
            return new LinkedHashMap();
        }
        String strN = n7.l.N(file);
        if (ga.k.t0(strN)) {
            strN = "{}";
        }
        Object objFromJson = this.f6326a.fromJson(strN);
        Map map = q7.z.f(objFromJson) ? (Map) objFromJson : null;
        return map == null ? new LinkedHashMap() : map;
    }

    public final void c(File file, Map map) throws IOException {
        q7.k.e(file, "file");
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        String json = this.f6326a.toJson(map);
        if (json == null) {
            json = "{}";
        }
        n7.l.Q(file, json);
    }
}
