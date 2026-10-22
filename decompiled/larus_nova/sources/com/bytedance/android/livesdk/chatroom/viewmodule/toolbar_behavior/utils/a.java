package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements js0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ToolbarButton f117399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f117400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DataCenter f117401c;

    @Override // js0.b
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
        int r101 = b.f117402a;
        Object r102 = b.b(this.f117399a, this.f117400b);
        if ((r102 instanceof e2) == false) goto L6;
        y3.f(this.f117401c).J((e2) r102);
        return;
    }

    public a(ToolbarButton r100, List r101, DataCenter r102) {
        this.f117399a = r100;
        this.f117400b = r101;
        this.f117401c = r102;
    }
}
