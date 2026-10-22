package ch5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.department.Department;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.department.VisibleDepartment;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.department.VisibleTopUserInDep;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements NetService.c<Department> {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r110) {
        Department r100 = new Department(null, null, false, null, 15, null);
        JSONObject r111 = new JSONObject(r110).optJSONObject("data");     // Catch: Throwable -> L13
        JSONArray r101 = r111.optJSONArray("visible_departments");     // Catch: Throwable -> L13
        ArrayList<VisibleDepartment> r102 = new ArrayList();     // Catch: Throwable -> L13
        int r103 = r101.length();     // Catch: Throwable -> L13
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L8;
        JSONObject r105 = r101.optJSONObject(r104);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L13
        String r106 = r105.optString("department_id");     // Catch: Throwable -> L13
        String r107 = r105.optString("name");     // Catch: Throwable -> L13
        String r108 = r105.optString("avatar");     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L13
        r102.add(new VisibleDepartment(r106, r107, r108));     // Catch: Throwable -> L13
        r104 = r104 + 1;     // Catch: Throwable -> L13
        goto L6
    L8:
        r100.setVisibleDepartments(r102);     // Catch: Throwable -> L13
        JSONArray r109 = r111.optJSONArray("visible_top_users_of_dep");     // Catch: Throwable -> L13
        ArrayList<VisibleTopUserInDep> r112 = new ArrayList();     // Catch: Throwable -> L13
        int r113 = r109.length();     // Catch: Throwable -> L13
        int r114 = 0;
    L9:
        if (r114 >= r113) goto L11;
        JSONObject r115 = r109.optJSONObject(r114);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r115);     // Catch: Throwable -> L13
        String r116 = r115.optString("user_id");     // Catch: Throwable -> L13
        String r117 = r115.optString(ITwitterService.ResponseConstants.USER_NAME);     // Catch: Throwable -> L13
        String r118 = r115.optString("avatar");     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r116);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r117);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r118);     // Catch: Throwable -> L13
        r112.add(new VisibleTopUserInDep(r116, r117, r118));     // Catch: Throwable -> L13
        r114 = r114 + 1;     // Catch: Throwable -> L13
        goto L9
    L11:
        r100.setVisibleTopUserInDep(r112);     // Catch: Throwable -> L13
        r100.setHasMore(r111.optBoolean("has_more"));     // Catch: Throwable -> L13
    L15:
        return r100;
    L13:
        th = move-exception;
        tt5.a.e("DepartmentParser", "parse error", th, false);
        goto L15
    }
}
