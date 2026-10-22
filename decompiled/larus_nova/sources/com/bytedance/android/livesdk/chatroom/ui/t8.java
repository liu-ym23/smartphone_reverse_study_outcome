package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class t8 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ResolutionItemView f114215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l5 f114216b;

    public t8(ResolutionItemView r100, l5 r101) {
        this.f114215a = r100;
        this.f114216b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        String r101 = this.f114216b.f113659e;
        if (Intrinsics.areEqual(r101, "disable") == true) goto L5;
        l5 r102 = this.f114216b;
        String r103 = "selected";
        if (Intrinsics.areEqual(r101, "selected") == false) goto L14;
        r103 = "unselected";
    L14:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f113659e = r103;
        this.f114215a.getSelectedCallback().invoke(this.f114216b.f113656b);
        return;
    L5:
        if (this.f114215a.getToastAction() == null) goto L9;
        Function1<String, Unit> r104 = this.f114215a.getToastAction();
        if (r104 == null) goto L16;
        Unit r105 = r104.invoke("设备不支持当前清晰度播放");
        return;
    L16:
        return;
    L9:
        String r106 = rm3.c.f538539a;
        rm3.c.g(this.f114215a.getContext(), "设备不支持当前清晰度播放", 0, false, 28);
    }
}
