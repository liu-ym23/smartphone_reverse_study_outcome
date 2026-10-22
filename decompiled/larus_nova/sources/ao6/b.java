package ao6;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.dito.utils.ApplicationUtil;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes21.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FragmentActivity f15797a;

    public void b(Context r100) {
    }

    public void e(Bundle r100) {
    }

    public void f() {
    }

    public void g() {
    }

    public void h(Bundle r100) {
    }

    public void i() {
    }

    public final Intent c() {
        FragmentActivity r100 = this.f15797a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getIntent();
    }

    public final FragmentManager d() {
        FragmentActivity r100 = this.f15797a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSupportFragmentManager();
    }

    @Override // ao6.c
    public Resources getResources() {
        FragmentActivity r100 = this.f15797a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getResources();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, android.app.Application] */
    public b(FragmentActivity r100) {
        this.f15797a = r100;
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        T r102 = 0;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        Context r104 = HostServiceUtilsKt.E().getApplicationContext();     // Catch: Throwable -> L9
        if ((r104 instanceof Application) == false) goto L6;
        Application r105 = (Application) r104;     // Catch: Throwable -> L9
    L7:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r106) == true) goto L15;
        r102 = r106;
    L15:
        r101.element = r102;
        if (r102 != 0) goto L18;
        r101.element = ApplicationUtil.a();
    L18:
        ((Application) r101.element).registerActivityLifecycleCallbacks(new a(this, r101));
        return;
    L6:
        r105 = null;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static final boolean a(b r100, Activity r101) {
        return Intrinsics.areEqual(r101, r100.f15797a);
    }
}
