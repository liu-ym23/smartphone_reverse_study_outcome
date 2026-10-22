package com.bytedance.android.livesdk.wgamex.gameinvite;

import android.content.DialogInterface;
import android.widget.TextView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorInviteDialogFragment f160730a;

    public b(AnchorInviteDialogFragment r100) {
        this.f160730a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        AnchorInviteViewModel r102 = this.f160730a.f160667e;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r102.inviteAll();
        ((TextView) this.f160730a.T90(R.id.tv_invite)).setEnabled(false);
        r100.dismiss();
    }
}
