package ch5;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.department.Department;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements ax4.e<Department> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.search.department.d f23775a;

    public d(com.bytedance.ee.bear.middleground.permission.collaborator.search.department.d r100) {
        this.f23775a = r100;
    }

    @Override // ax4.e
    public final void onFailed(Throwable r100) {
        this.f23775a.f233470c.t7();
    }

    @Override // ax4.e
    public final void onSuccess(Department r100) {
        Department r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        this.f23775a.f233470c.X0(r101);
        this.f23775a.f233470c.d0(r101.getHasMore());
    }
}
