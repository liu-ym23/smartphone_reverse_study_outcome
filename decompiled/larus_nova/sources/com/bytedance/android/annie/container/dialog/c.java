package com.bytedance.android.annie.container.dialog;

import com.bytedance.android.livesdk.pannel.CloseType;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements com.bytedance.android.livesdk.pannel.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseDialogFragment f39259a;

    @Override // com.bytedance.android.livesdk.pannel.d
    public final void a() {
    }

    public c(BaseDialogFragment r100) {
        this.f39259a = r100;
    }

    @Override // com.bytedance.android.livesdk.pannel.d
    public final void b(boolean r100, CloseType r101) {
        Intrinsics.checkNotNullParameter(r101, "closeType");
        if (r100 == true) goto L6;
        this.f39259a.sendJsEvent("H5_tapWebMaskView", new JSONObject());
        BaseDialogFragment r102 = this.f39259a;
        r102.getClass();
        JSONObject r103 = new JSONObject();
        r103.put("type", r101.getTag());
        Unit r104 = Unit.INSTANCE;
        r102.sendJsEvent("containerShouldClose", r103);
        return;
    }
}
