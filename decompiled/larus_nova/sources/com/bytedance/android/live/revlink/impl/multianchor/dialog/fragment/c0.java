package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c0 implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnchorUILayoutManager f93478a;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.w
    public final UILayout B5() {
        AnchorUILayoutManager r100 = this.f93478a;
        if (r100 == null) goto L9;
        o51.e r101 = r100.f98327e;
        if (r101 == null) goto L9;
        UILayout r102 = o51.g.c(r101);
        if (r102 == null) goto L9;
        return r102;
    L9:
        return UILayout.Normal;
    }

    public c0(AnchorUILayoutManager r100) {
        this.f93478a = r100;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.w
    public final boolean t4(String r100) {
        AnchorUILayoutManager r101 = this.f93478a;
        if (r101 == null) goto L7;
        o51.e r102 = r101.f98327e;
        if (r102 == null) goto L7;
        String r103 = o51.g.b(r102);
    L9:
        return Intrinsics.areEqual(r103, r100);
    L7:
        r103 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.w
    public final boolean x5(String r100) {
        if (t4(r100) == false) goto L15;
        AnchorUILayoutManager r101 = this.f93478a;
        if (r101 == null) goto L16;
        o51.e r102 = r101.f98327e;
        if (r102 == null) goto L17;
        Intrinsics.checkNotNullParameter(r102, "$this$isAllRoom");
        if (r102.f522039c != IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom) goto L11;
        boolean r103 = true;
    L12:
        if (r103 != true) goto L18;
        return true;
    L18:
        return false;
    L11:
        r103 = false;
        goto L12
    L17:
        return false;
    L16:
        return false;
    L15:
        return false;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.w
    public final void A5(String r100, boolean r101) {
        AnchorUILayoutManager r102 = this.f93478a;
        if (r102 == null) goto L6;
        r102.c(r100, r101, false);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.w
    public final void P4(String r100, boolean r101) {
        AnchorUILayoutManager r102 = this.f93478a;
        if (r102 == null) goto L6;
        r102.c(r100, r101, true);
        return;
    }
}
