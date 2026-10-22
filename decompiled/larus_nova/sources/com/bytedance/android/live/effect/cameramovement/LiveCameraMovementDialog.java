package com.bytedance.android.live.effect.cameramovement;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import com.bytedance.android.live.effect.common.LiveCommonStickerAdjustBarView;
import com.bytedance.android.live.effect.common.LiveCommonStickerDataViewModel;
import com.bytedance.android.live.effect.common.LiveCommonStickerListView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.live.datacontext.d;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/effect/cameramovement/LiveCameraMovementDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCameraMovementDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f67799d = 0;

    public static final class a {
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Intrinsics.throwUninitializedPropertyAccessException("stickerUIViewModel");
        throw null;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L7;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        r102.setLayout(-1, -1);
    L7:
        Dialog r103 = getDialog();
        if (r103 == null) goto L12;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L12;
        com.bytedance.android.live.core.utils.statusbar.a.f66401b.a();
        r104.addFlags(Integer.MIN_VALUE);
    L12:
        Dialog r105 = getDialog();
        if (r105 == null) goto L17;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L17;
        r106.setStatusBarColor(0);
    L17:
        Dialog r107 = getDialog();
        if (r107 == null) goto L23;
        Window r108 = r107.getWindow();
        if (r108 == null) goto L24;
        r108.setNavigationBarColor(-16777216);
        return;
    L24:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_effect_live_sticker_dialog);
        setCancelable(true);
        LiveCommonStickerDataViewModel r101 = (LiveCommonStickerDataViewModel) d.b(this, new LiveCameraMovementDialog$initViewModel$1(this)).a(LiveCommonStickerDataViewModel.class);
        throw null;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setCanceledOnTouchOutside(true);
        r101.requestWindowFeature(1);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L5;
        r102.setGravity(80);
        r102.setLayout(-1, -1);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setSoftInputMode(3);
    L5:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Context r102 = getContext();
        if (r102 == null) goto L14;
        View r103 = getView();
        if (r103 == null) goto L9;
        FrameLayout r104 = (FrameLayout) r103.findViewById(R.id.adjust_bar_container);
        if (r104 == null) goto L9;
        r104.addView(new LiveCommonStickerAdjustBarView(r102, new WeakReference(this)));
    L9:
        View r105 = getView();
        if (r105 == null) goto L14;
        FrameLayout r106 = (FrameLayout) r105.findViewById(R.id.content_layout);
        if (r106 == null) goto L14;
        r106.addView(new LiveCommonStickerListView(r102, new WeakReference(this)));
    L14:
        View r107 = getView();
        if (r107 == null) goto L19;
        Button r108 = (Button) r107.findViewById(R.id.bt_clear);
        if (r108 == null) goto L19;
        r108.setOnClickListener(new b(this));
    L19:
        Intrinsics.throwUninitializedPropertyAccessException("stickerUIViewModel");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_effect_camera_movement, r101, false);
    }
}
