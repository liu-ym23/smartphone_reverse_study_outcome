package ch5;

import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.ExistMemberResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.Member;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.department.Department;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Department f23773a;

    public a(Department r100) {
        this.f23773a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ExistMemberResult r101 = (ExistMemberResult) r100;
        Intrinsics.checkNotNullParameter(r101, "existMemberResult");
        tt5.a.h("DepartmentModel", "getExistMember(): " + r101.getExistMembers());
        ArrayList<Member> r102 = new ArrayList();
        r102.addAll(r101.getExistMembers());
        this.f23773a.setExistsMembers(r102);
        return this.f23773a;
    }
}
