package com.bytedance.android.livesdk.livecommerce.oldflash.search;

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
import com.bytedance.android.ui.ec.widget.searchbar.ECSearchBar;
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
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/search/LiveFlashSearchDialogFragment;", "Lcom/bytedance/android/livesdk/livecommerce/base/ECBaseDialogFragment;", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/search/LiveFlashSearchViewModel;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFlashSearchDialogFragment extends ECBaseDialogFragment<LiveFlashSearchViewModel> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f149675o = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<Integer, View> f149676i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.oldflash.search.a f149677j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super String, Unit> f149678k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f149679l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f149680m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SearchListAdapter f149681n;

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
        return R.layout.ec_fragment_live_flash_search_dialog;
    }

    public LiveFlashSearchDialogFragment() {
        this.f149676i = new LinkedHashMap();
        this.f149679l = "";
        this.f149680m = "";
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
        ((LinkedHashMap) this.f149676i).clear();
    }

    public static final void ja0(LiveFlashSearchDialogFragment r100) {
        ECSearchBar r101 = (ECSearchBar) r100.ia0(R.id.search_bar);
        if (r101 == null) goto L10;
        String r102 = r101.getText();
        if (r102 == null) goto L11;
        LiveFlashSearchViewModel r103 = (LiveFlashSearchViewModel) r100.f147650g;
        if (r103 == null) goto L12;
        r103.startSearch(StringsKt.trim(r102).toString());
        return;
    L12:
        return;
    L11:
        return;
    }

    public final View ia0(int r100) {
        if (this.f149676i != null) goto L5;
        this.f149676i = new LinkedHashMap();
    L5:
        View r101 = this.f149676i.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f149676i.put(Integer.valueOf(r100), r103);
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
        String r102 = "";
        if (r101 == null) goto L6;
        String r103 = r101.getString("title_bar_title");
        if (r103 == null) goto L6;
    L7:
        this.f149679l = r103;
        Bundle r104 = getArguments();
        if (r104 == null) goto L13;
        String r105 = r104.getString("search_hint");
        if (r105 == null) goto L13;
        r102 = r105;
    L13:
        this.f149680m = r102;
        this.f149681n = new SearchListAdapter(new AnonymousClass1(this));
        RecyclerView r106 = (RecyclerView) ia0(R.id.rv_list);
        if (r106 == null) goto L16;
        r106.setAdapter(this.f149681n);
        r106.setLayoutManager(new LinearLayoutManager(getContext()));
        r106.addOnScrollListener(new LiveFlashSearchDialogFragment$onActivityCreated$$inlined$also$lambda$1(this));
    L16:
        ECTitleBar r107 = (ECTitleBar) ia0(R.id.title_bar);
        if (r107 == null) goto L19;
        r107.setTitleText(this.f149679l);
    L19:
        ECTitleBar r108 = (ECTitleBar) ia0(R.id.title_bar);
        if (r108 == null) goto L22;
        r108.setLeftIconClickListener(new e(this));
    L22:
        ECSearchBar r109 = (ECSearchBar) ia0(R.id.search_bar);
        if (r109 == null) goto L25;
        r109.setOnEditorActionListener(new b(r109, this));
        r109.hideTextAction();
        r109.setHint(this.f149680m);
        r109.addTextChangedListener(new c(r109, this));
        r109.setTextActionClickListener(new d(r109));
    L25:
        LiveFlashSearchViewModel r110 = (LiveFlashSearchViewModel) this.f147650g;
        if (r110 == null) goto L28;
        r110.setSearchRepository(this.f149677j);
    L28:
        LiveFlashSearchViewModel r111 = (LiveFlashSearchViewModel) this.f147650g;
        if (r111 == null) goto L31;
        r111.initOriginData();
    L31:
        LiveFlashSearchViewModel r112 = (LiveFlashSearchViewModel) this.f147650g;
        if (r112 == null) goto L36;
        LiveData<List<k>> r113 = r112.getDataListLiveData();
        if (r113 == null) goto L36;
        r113.observe(getViewLifecycleOwner(), new f(this));
    L36:
        LiveFlashSearchViewModel r114 = (LiveFlashSearchViewModel) this.f147650g;
        if (r114 == null) goto L41;
        LiveData<Boolean> r115 = r114.getShowSearchBarLiveData();
        if (r115 == null) goto L41;
        r115.observe(getViewLifecycleOwner(), new g(this));
    L41:
        LiveFlashSearchViewModel r116 = (LiveFlashSearchViewModel) this.f147650g;
        if (r116 == null) goto L47;
        LiveData<Boolean> r117 = r116.getDismissLiveData();
        if (r117 == null) goto L48;
        r117.observe(getViewLifecycleOwner(), new h(this));
        return;
    L48:
        return;
    L47:
        return;
    L6:
        r103 = "";
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L14
        super.onDismiss(r100);     // Catch: Throwable -> L14
        Function1<? super String, Unit> r101 = this.f149678k;     // Catch: Throwable -> L14
        if (r101 == null) goto L12;
        LiveFlashSearchViewModel r102 = (LiveFlashSearchViewModel) this.f147650g;     // Catch: Throwable -> L14
        if (r102 == null) goto L10;
        LiveData<String> r103 = r102.getCurrentStringLiveData();     // Catch: Throwable -> L14
        if (r103 == null) goto L10;
        String r104 = r103.getValue();     // Catch: Throwable -> L14
        if (r104 == null) goto L10;
    L11:
        Unit r105 = r101.invoke(r104);     // Catch: Throwable -> L14
    L10:
        r104 = "";
    L12:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L14:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }
}
