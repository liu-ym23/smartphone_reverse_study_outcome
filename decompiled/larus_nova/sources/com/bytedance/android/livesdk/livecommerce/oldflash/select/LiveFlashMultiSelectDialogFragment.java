package com.bytedance.android.livesdk.livecommerce.oldflash.select;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.ui.ec.widget.titlebar.ECTitleBar;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/select/LiveFlashMultiSelectDialogFragment;", "Lcom/bytedance/android/livesdk/livecommerce/base/ECBaseDialogFragment;", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/select/LiveFlashMultiSelectViewModel;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFlashMultiSelectDialogFragment extends ECBaseDialogFragment<LiveFlashMultiSelectViewModel> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f149703n = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<Integer, View> f149704i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.oldflash.select.a f149705j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super List<String>, Unit> f149706k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f149707l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LiveFlashMultiSelectListAdapter f149708m;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int Y90() {
        return 3;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int getLayoutId() {
        return R.layout.ec_fragment_live_flash_multi_select_dialog;
    }

    public LiveFlashMultiSelectDialogFragment() {
        this.f149704i = new LinkedHashMap();
        this.f149707l = "";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final ViewGroup.MarginLayoutParams ba0() {
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-1, (int) (ECDisplayUtils.a(getContext()) * 0.73f));
        r100.gravity = 80;
        return r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.f149704i).clear();
    }

    public final View ia0(int r100) {
        if (this.f149704i != null) goto L5;
        this.f149704i = new LinkedHashMap();
    L5:
        View r101 = this.f149704i.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f149704i.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L6;
        String r102 = r101.getString("title_bar_title");
        if (r102 == null) goto L6;
    L7:
        this.f149707l = r102;
        this.f149708m = new LiveFlashMultiSelectListAdapter(new AnonymousClass1(this));
        RecyclerView r103 = (RecyclerView) ia0(R.id.rv_list);
        if (r103 == null) goto L10;
        r103.setAdapter(this.f149708m);
        r103.setLayoutManager(new LinearLayoutManager(getContext()));
    L10:
        ECTitleBar r104 = (ECTitleBar) ia0(R.id.title_bar);
        if (r104 == null) goto L13;
        r104.setTitleText(this.f149707l);
    L13:
        ECTitleBar r105 = (ECTitleBar) ia0(R.id.title_bar);
        if (r105 == null) goto L16;
        r105.setLeftIconClickListener(new e(this));
    L16:
        LiveFlashMultiSelectViewModel r106 = (LiveFlashMultiSelectViewModel) this.f147650g;
        if (r106 == null) goto L19;
        r106.setSelectRepository(this.f149705j);
        r106.initOriginData();
    L19:
        LiveFlashMultiSelectViewModel r107 = (LiveFlashMultiSelectViewModel) this.f147650g;
        if (r107 == null) goto L24;
        LiveData<List<k>> r108 = r107.getDataListLiveData();
        if (r108 == null) goto L24;
        r108.observe(getViewLifecycleOwner(), new f(this));
    L24:
        LiveFlashMultiSelectViewModel r109 = (LiveFlashMultiSelectViewModel) this.f147650g;
        if (r109 == null) goto L29;
        LiveData<Boolean> r110 = r109.getDismissLiveData();
        if (r110 == null) goto L29;
        r110.observe(getViewLifecycleOwner(), new g(this));
    L29:
        LiveFlashMultiSelectViewModel r111 = (LiveFlashMultiSelectViewModel) this.f147650g;
        if (r111 == null) goto L35;
        LiveData<List<k>> r112 = r111.getCurrentStringListLiveData();
        if (r112 == null) goto L36;
        r112.observe(getViewLifecycleOwner(), new i(this));
        return;
    L36:
        return;
    L35:
        return;
    L6:
        r102 = "";
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }
}
