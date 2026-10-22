package com.bytedance.android.livesdk.livecommerce.oldflash.select;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseViewModel;
import com.bytedance.android.livesdk.livecommerce.event.y;
import com.bytedance.android.livesdk.livecommerce.event.z;
import com.bytedance.android.livesdk.livecommerce.oldflash.q;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.ui.ec.widget.titlebar.ECTitleBar;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/select/LiveFlashSelectDialogFragment;", "Lcom/bytedance/android/livesdk/livecommerce/base/ECBaseDialogFragment;", "Lcom/bytedance/android/livesdk/livecommerce/base/ECBaseViewModel;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFlashSelectDialogFragment extends ECBaseDialogFragment<ECBaseViewModel> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<Integer, View> f149715i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<? super String, Unit> f149716j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<com.bytedance.android.livesdk.livecommerce.oldflash.select.b> f149717k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f149718l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public q f149719m;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveFlashSelectDialogFragment f149720a;

        public b(LiveFlashSelectDialogFragment r100) {
            this.f149720a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f149720a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f149721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveFlashSelectDialogFragment f149722b;

        public c(RecyclerView r100, LiveFlashSelectDialogFragment r101) {
            this.f149721a = r100;
            this.f149722b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Iterator r101 = ((ArrayList) this.f149722b.f149717k).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((com.bytedance.android.livesdk.livecommerce.oldflash.select.b) r101.next()).f149724b = false;
            goto L4
        L6:
            int r102 = this.f149721a.getChildAdapterPosition(r100);
            if (r102 < 0) goto L28;
            ((com.bytedance.android.livesdk.livecommerce.oldflash.select.b) ListProtector.get(this.f149722b.f149717k, r102)).f149724b = true;
            RecyclerView.Adapter r103 = this.f149721a.getAdapter();
            if (r103 == null) goto L11;
            r103.notifyDataSetChanged();
        L11:
            LiveFlashSelectDialogFragment r104 = this.f149722b;
            Function1<? super String, Unit> r105 = r104.f149716j;
            if (r105 == null) goto L14;
            Unit r106 = r105.invoke(((com.bytedance.android.livesdk.livecommerce.oldflash.select.b) ListProtector.get(r104.f149717k, r102)).f149723a);
        L14:
            LiveFlashSelectDialogFragment r107 = this.f149722b;
            q r108 = r107.f149719m;
            if (r108 == null) goto L28;
            String r109 = r107.f149718l;
            z r110 = new z(r108.f149642a, r108.f149643b, r108.f149644c);
            if (r109 != null) goto L19;
            r109 = "";
        L19:
            r110.f("attribute_name", r109);
            r110.k();
        L28:
            this.f149722b.dismiss();     // Catch: Exception -> L23
            return;
        L23:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r111 = DialogFragmentLancet.sLastShowStack;
            if (r111 == null) goto L31;
            com.bytedance.crash.d.d(r111, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int Y90() {
        return 3;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int getLayoutId() {
        return R.layout.ec_fragment_live_flash_select_dialog;
    }

    public LiveFlashSelectDialogFragment() {
        this.f149715i = new LinkedHashMap();
        this.f149717k = new ArrayList();
        this.f149718l = "";
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
        ((LinkedHashMap) this.f149715i).clear();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (this.f149715i != null) goto L5;
        this.f149715i = new LinkedHashMap();
    L5:
        View r102 = (View) ((LinkedHashMap) this.f149715i).get(Integer.valueOf(R.id.title_bar));
        if (r102 != null) goto L13;
        View r103 = getView();
        if (r103 == null) goto L12;
        r102 = r103.findViewById(R.id.title_bar);
        if (r102 == null) goto L12;
        this.f149715i.put(Integer.valueOf(R.id.title_bar), r102);
    L12:
        r102 = null;
    L13:
        ECTitleBar r104 = (ECTitleBar) r102;
        if (r104 == null) goto L16;
        r104.setTitleText(getString(R.string.ec_live_flash_select_property, new Object[]{this.f149718l}));
        r104.setLeftIconClickListener(new b(this));
    L16:
        View r105 = this.f147647d;
        if (r105 == null) goto L21;
        RecyclerView r106 = (RecyclerView) r105.findViewById(R.id.rv_list);
        if (r106 == null) goto L21;
        r106.setLayoutManager(new LinearLayoutManager(getContext()));
        r106.setAdapter(new com.bytedance.android.livesdk.livecommerce.oldflash.select.c(this.f149717k, new c(r106, this)));
    L21:
        q r107 = this.f149719m;
        if (r107 == null) goto L28;
        String r108 = this.f149718l;
        y r109 = new y(r107.f149642a, r107.f149643b, r107.f149644c);
        if (r108 != null) goto L26;
        r108 = "";
    L26:
        r109.f("attribute_name", r108);
        r109.k();
        return;
    }
}
