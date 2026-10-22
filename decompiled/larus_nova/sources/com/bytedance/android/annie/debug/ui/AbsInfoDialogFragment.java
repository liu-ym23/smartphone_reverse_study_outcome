package com.bytedance.android.annie.debug.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.android.ClipboardCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/AbsInfoDialogFragment;", "Lcom/bytedance/android/annie/debug/ui/BaseCommonDialogFragment;", "<init>", "()V", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
public abstract class AbsInfoDialogFragment extends BaseCommonDialogFragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f39394f = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends DialogItem> f39395e;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsInfoDialogFragment f39396a;

        public a(AbsInfoDialogFragment r100) {
            this.f39396a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f39396a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class b implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsInfoDialogFragment f39397a;

        public b(AbsInfoDialogFragment r100) {
            this.f39397a = r100;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            AbsInfoDialogFragment r101 = this.f39397a;
            int r102 = AbsInfoDialogFragment.f39394f;
            r101.getClass();
            StringBuilder r103 = new StringBuilder();
            List<? extends DialogItem> r104 = r101.f39395e;
            if (r104 == null) goto L16;
            Iterator<T> r105 = r104.iterator();
        L6:
            if (r105.hasNext() == false) goto L16;
            DialogItem r106 = (DialogItem) r105.next();
            if (r106.f39428b == null) goto L6;
            StringBuilder r107 = new StringBuilder();
            String r108 = r106.f39427a;
            if (r108 != null) goto L12;
            r108 = "";
        L12:
            r107.append(r108);
            r107.append(": ");
            String r109 = r106.f39428b;
            if (r109 != null) goto L15;
            r109 = "";
        L15:
            r107.append(r109);
            r107.append(" \n");
            r103.append(r107.toString());
        L16:
            String r110 = r103.toString();
            AbsInfoDialogFragment r111 = this.f39397a;
            if ((!StringsKt.isBlank(r110)) == false) goto L20;
            ClipboardCompat.setText(r111.requireContext(), "", r110);
            int r112 = a8.d.f2137a;
            a8.d.a(r111.requireContext(), "复制成功");
            return true;
        L20:
            return false;
        }
    }

    public abstract List<DialogItem> S90();

    public abstract String T90();

    public boolean U90() {
        return this instanceof JsbWhiteListFragment;
    }

    @Override // com.bytedance.android.annie.debug.ui.BaseCommonDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L12;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L13;
        r101.setLayout(-1, -1);
        if (U90() == false) goto L9;
        int r102 = R.style.annie_dialog_bottom_popup_anim_horizontal;
    L10:
        r101.setWindowAnimations(r102);
        return;
    L9:
        r102 = R.style.annie_dialog_bottom_popup_anim_vertical;
        goto L10
    L13:
        return;
    }

    public AbsInfoDialogFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.annie_debug_dialog, r101, false);
        RecyclerView r104 = (RecyclerView) r103.findViewById(R.id.recyclerView);
        if (r104 == null) goto L6;
        r104.setLayoutManager(new LinearLayoutManager(getContext()));
        List<DialogItem> r105 = S90();
        this.f39395e = r105;
        r104.setAdapter(new DialogAdapter(r105, getContext()));
    L6:
        if (U90() == false) goto L11;
        View r106 = r103.findViewById(R.id.back);
        if (r106 == null) goto L11;
        r106.setVisibility(0);
        r106.setOnClickListener(new a(this));
    L11:
        if (T90().length() <= 0) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == false) goto L18;
        TextView r108 = (TextView) r103.findViewById(R.id.main_title);
        if (r108 == null) goto L18;
        r108.setVisibility(0);
        r108.setText(T90());
        r108.setOnLongClickListener(new b(this));
    L18:
        return r103;
    L13:
        r107 = false;
        goto L14
    }
}
