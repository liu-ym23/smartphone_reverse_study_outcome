package com.bytedance.android.livesdk.dispatch.utils;

import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements IBaseCallbackSchemaHandler.SchemaCallback<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBaseCallbackSchemaHandler.SchemaCallback f122280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f122281b;

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler.SchemaCallback
    public final void onComplete() {
        IBaseCallbackSchemaHandler.SchemaCallback r100 = this.f122280a;
        if (r100 == null) goto L6;
        r100.onComplete();
        return;
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler.SchemaCallback
    public final void onFailure(Throwable r100) {
        IBaseCallbackSchemaHandler.SchemaCallback r101 = this.f122280a;
        if (r101 == null) goto L5;
        r101.onFailure(r100);
    L5:
        Lazy r102 = DispatchLogUtil.f122274a;
        DispatchLogUtil.e(9, this.f122281b, null);
    }

    public e(IBaseCallbackSchemaHandler.SchemaCallback r100, String r101) {
        this.f122280a = r100;
        this.f122281b = r101;
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler.SchemaCallback
    public final void onSuccess(Integer r100, String r101) {
        String r102 = r101;
        Intrinsics.checkNotNullParameter(r102, "response");
        IBaseCallbackSchemaHandler.SchemaCallback r103 = this.f122280a;
        if (r103 == null) goto L5;
        r103.onSuccess(r100, r102);
    L5:
        Lazy r104 = DispatchLogUtil.f122274a;
        DispatchLogUtil.e(7, this.f122281b, null);
    }
}
