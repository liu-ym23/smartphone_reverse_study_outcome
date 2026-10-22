package ch5;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.department.Department;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Department f23774a;

    public b(Department r100) {
        this.f23774a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        tt5.a.d("DepartmentModel", "getExistMember error: " + r101);
        return this.f23774a;
    }
}
