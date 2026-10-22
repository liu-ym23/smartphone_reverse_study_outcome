package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b8 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewPanelAudienceResolutionPickerDialog.ResolutionItemView f112597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l5 f112598b;

    public b8(NewPanelAudienceResolutionPickerDialog.ResolutionItemView r100, l5 r101) {
        this.f112597a = r100;
        this.f112598b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        String r101 = this.f112598b.f113659e;
        if (Intrinsics.areEqual(r101, "disable") == false) goto L6;
        String r102 = rm3.c.f538539a;
        rm3.c.g(this.f112597a.getContext(), this.f112597a.getContext().getString(R.string.ttlive_audience_resolution_disable_tip), 0, false, 28);
        return;
    L6:
        l5 r103 = this.f112598b;
        String r104 = "selected";
        if (Intrinsics.areEqual(r101, "selected") == false) goto L9;
        r104 = "unselected";
    L9:
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f113659e = r104;
        this.f112597a.f112431b.invoke(this.f112598b.f113656b);
    }
}
