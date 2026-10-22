package com.bytedance.android.live.effect;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.soundeffect.LiveSoundAdapter;
import com.bytedance.android.live.effect.soundeffect.LiveSoundEffectHelper;
import com.bytedance.android.live.effect.soundeffect.SoundItemDecoration;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/LiveSoundEffectDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSoundEffectDialogFragment extends LiveDialogFragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f66700g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f66701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f66702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f66703f;

    public static final class a {
    }

    static {
    }

    public LiveSoundEffectDialogFragment() {
        this.f66701d = new LinkedHashMap();
        this.f66702e = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.f66703f = LazyKt.lazy(new LiveSoundEffectDialogFragment$soundAdapter$2(this));
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f66701d.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        LiveSoundAdapter r100 = (LiveSoundAdapter) this.f66703f.getValue();
        LiveSoundEffectHelper r101 = r100.f68093b;
        if (r101 == null) goto L7;
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (r101.f68112b.contains(r100) == false) goto L7;
        r101.f68112b.remove(r100);
    L7:
        r100.f68096e.removeCallbacksAndMessages(null);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        LiveSoundAdapter r100 = (LiveSoundAdapter) this.f66703f.getValue();
        LiveSoundEffectHelper r101 = r100.f68093b;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (r101.f68112b.contains(r100) == true) goto L9;
        r101.f68112b.add(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L8;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L9;
        r101.setGravity(80);
        r101.setBackgroundDrawable(new ColorDrawable(0));
        r101.setSoftInputMode(3);
        return;
    L9:
        return;
    }

    public final View S90(int r100) {
        if (this.f66701d != null) goto L5;
        this.f66701d = new LinkedHashMap();
    L5:
        View r101 = this.f66701d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f66701d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
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
        if (r105 == null) goto L18;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L19;
        r106.setStatusBarColor(0);
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_effect_live_sticker_dialog);
        setCancelable(true);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.requestWindowFeature(1);
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = LayoutInflater.from(getContext()).inflate(R.layout.liveuikit_layout_loading_error, null);
        r102.setOnClickListener(new o(this));
        ((LoadingStatusView) S90(R.id.sound_effect_loading_view)).setBuilder(LoadingStatusView.Builder.createDefaultBuilder(getContext()).setErrorView(r102).setUseProgressBar(getResources().getDimensionPixelSize(R.dimen.ttlive_effect_default_list_progressbar_size)));
        ((LoadingStatusView) S90(R.id.sound_effect_loading_view)).showLoading();
        S90(R.id.view_outside).setOnClickListener(new p(this));
        ((RecyclerView) S90(R.id.rv_sound_item)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ((RecyclerView) S90(R.id.rv_sound_item)).addItemDecoration(new SoundItemDecoration());
        ((RecyclerView) S90(R.id.rv_sound_item)).setAdapter((LiveSoundAdapter) this.f66703f.getValue());
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_effect_dialog_sound_effect, r101, false);
    }
}
