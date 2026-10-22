package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View;
import com.bytedance.android.livesdk.r3;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;

/* JADX INFO: loaded from: classes9.dex */
public class MediaAnchorInteractContainerFragment extends MediaInteractDialogFragmentBaseContract$View<t82.e> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f138007h = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f138008g;

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final float T90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final String V90() {
        return "";
    }

    public MediaAnchorInteractContainerFragment() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final ViewGroup X90() {
        return this.f138008g;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = r100.inflate(R.layout.ttlive_media_dialog_interact_anchor_container, r101, false);
        FragmentTransaction r104 = getFragmentManager().beginTransaction();
        t82.f r105 = this.f138106d;
        MediaAnchorLinkUserListFragment r106 = new MediaAnchorLinkUserListFragment();
        r106.f138108f = new u82.h(r106);
        r106.f138106d = r105;
        r106.f138042n = 4;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r104, r106, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.list_container) == true) goto L6;
        r104.add(R.id.list_container, r106);
    L6:
        r104.commitAllowingStateLoss();
        this.f138008g = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.ttlive_media_dialog_interact_anchor_container_top, null);
        com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
        if (com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a().Np().d().isEmpty() == true) goto L9;
        ImageView r107 = (ImageView) this.f138008g.findViewById(R.id.back);
        r107.setOnClickListener(new a(this));
        this.f138008g.findViewById(R.id.tab).setVisibility(8);
        this.f138008g.findViewById(R.id.set).setVisibility(8);
        r107.setVisibility(0);
        this.f138008g.findViewById(R.id.title_center).setVisibility(0);
    L10:
        return r103;
    L9:
        this.f138008g.findViewById(R.id.set).setOnClickListener(new b(this));
        r3.a(this.f138008g.findViewById(R.id.set), s1.B(R.string.ttlive_setting));
        goto L10
    }
}
