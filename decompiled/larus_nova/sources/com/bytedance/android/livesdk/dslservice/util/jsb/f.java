package com.bytedance.android.livesdk.dslservice.util.jsb;

import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.n0;
import com.bytedance.android.livesdk.dslservice.slice.SliceViewUtilsKt;
import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import kotlin.jvm.internal.Intrinsics;
import yt1.j;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements IBaseCallbackSchemaHandler.SchemaCallback<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f122989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f122990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f122991c;

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler.SchemaCallback
    public final void onComplete() {
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler.SchemaCallback
    public final void onFailure(Throwable r100) {
        String r101 = this.f122991c;
        if (r101 != null) goto L5;
        return;
    L5:
        if (n0.f65363a.getValue().booleanValue() == false) goto L9;
        j r102 = this.f122990b;
        if (r102 == null) goto L16;
        r102.b(r101, null);
        return;
    L16:
        return;
    L9:
        j r103 = this.f122990b;
        if (r103 == null) goto L18;
        r r104 = r103.a();
        if (r104 == null) goto L19;
        SliceViewUtilsKt.b(r104, r101, null);
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler.SchemaCallback
    public final void onSuccess(Integer r100, String r101) {
        String r102 = r101;
        Intrinsics.checkNotNullParameter(r102, "response");
        String r103 = this.f122989a;
        if (r103 == null) goto L15;
        ALogger.i("DSLAction-SubscribeAnchorPlay", "onSuccess" + r102);
        if (n0.f65363a.getValue().booleanValue() == false) goto L9;
        j r104 = this.f122990b;
        if (r104 == null) goto L16;
        r104.b(r103, null);
        return;
    L16:
        return;
    L9:
        j r105 = this.f122990b;
        if (r105 == null) goto L18;
        r r106 = r105.a();
        if (r106 == null) goto L19;
        SliceViewUtilsKt.b(r106, r103, null);
        return;
    L19:
        return;
    L18:
        return;
    }

    public f(String r100, j r101, String r102) {
        this.f122989a = r100;
        this.f122990b = r101;
        this.f122991c = r102;
    }
}
