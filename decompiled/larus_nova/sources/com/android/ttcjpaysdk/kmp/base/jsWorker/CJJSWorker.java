package com.android.ttcjpaysdk.kmp.base.jsWorker;

import com.android.ttcjpaysdk.kmp.base.jsWorker.code.IJSWorker;
import com.android.ttcjpaysdk.kmp.base.jsWorker.code.IJavaScriptBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/jsWorker/CJJSWorker;", "Lcom/android/ttcjpaysdk/kmp/base/jsWorker/IKmpCJJSWorkerService;", "<init>", "()V", "initJSWorker", "", "createJSWorker", "Lcom/android/ttcjpaysdk/kmp/base/jsWorker/code/IJSWorker;", "id", "", "bridge", "Lcom/android/ttcjpaysdk/kmp/base/jsWorker/code/IJavaScriptBridge;", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJJSWorker implements IKmpCJJSWorkerService {
    public static final int $stable = 0;

    public CJJSWorker() {
    }

    @Override // com.android.ttcjpaysdk.kmp.base.jsWorker.IKmpCJJSWorkerService
    public void initJSWorker() {
        b r100 = c.f528682a;
        IKmpCJJSWorkerService r101 = (IKmpCJJSWorkerService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJJSWorkerService.class));
        if (r101 == null) goto L6;
        r101.initJSWorker();
        return;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.jsWorker.IKmpCJJSWorkerService
    public IJSWorker createJSWorker(int r100, IJavaScriptBridge r101) {
        Intrinsics.checkNotNullParameter(r101, "bridge");
        b r102 = c.f528682a;
        IKmpCJJSWorkerService r103 = (IKmpCJJSWorkerService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJJSWorkerService.class));
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.createJSWorker(r100, r101);
    }
}
