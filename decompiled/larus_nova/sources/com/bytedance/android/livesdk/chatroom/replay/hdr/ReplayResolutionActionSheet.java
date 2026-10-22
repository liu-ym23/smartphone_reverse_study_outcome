package com.bytedance.android.livesdk.chatroom.replay.hdr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.vs_base.view.actionsheet.ReplayActionSheet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/hdr/ReplayResolutionActionSheet;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/view/actionsheet/ReplayActionSheet;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayResolutionActionSheet extends ReplayActionSheet {
    public ReplayResolutionActionSheet() {
        super(1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.view.actionsheet.ReplayActionSheet
    public final ReplayActionSheet.ActionSheetAdapter T90() {
        return new ReplayResolutionActionSheetAdapter(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.view.actionsheet.ReplayActionSheet, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return super.onCreateView(r100, r101, r102);
    }
}
