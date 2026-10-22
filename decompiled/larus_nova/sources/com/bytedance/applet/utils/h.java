package com.bytedance.applet.utils;

import com.larus.platform.api.g1;
import com.larus.platform.model.LocateScene;
import com.larus.platform.service.l1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements g1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f192288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocateScene f192289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f192290c;

    @Override // com.larus.platform.api.g1.b
    public final void onGoSettingsDialogDismiss(boolean r100) {
    }

    @Override // com.larus.platform.api.g1.b
    public final void onGoSettingsDialogShow() {
    }

    @Override // com.larus.platform.api.g1.b
    public final void onSettingPageReturn() {
    }

    public h(f r100, LocateScene r101, JSONObject r102) {
        this.f192288a = r100;
        this.f192289b = r101;
        this.f192290c = r102;
    }

    @Override // com.larus.platform.api.g1.c
    public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "grantedList");
        Intrinsics.checkNotNullParameter(r102, "deniedList");
        if (r100 == true) goto L6;
        d.a.a(this.f192288a, false, true, false, 4);
        return;
    L6:
        int r104 = i.f192291a;
        LocateScene r105 = this.f192289b;
        d r106 = this.f192288a;
        JSONObject r107 = this.f192290c;
        l1.f365760a.f(r105, new g(r106), r107);
    }
}
