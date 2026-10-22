package com.bytedance.android.gamecp.business.gamedetail.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.gamecp.common.utils.m0;
import com.bytedance.android.gamecp.common.utils.n0;
import com.bytedance.android.gamecp.common.utils.p0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/BaseGamePromoteDetailDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseGamePromoteDetailDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f55640e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f55641d;

    public BaseGamePromoteDetailDialogFragment() {
        this.f55641d = new CompositeDisposable();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f55641d.dispose();
        Dialog r100 = getDialog();
        if (r100 == null) goto L6;
        r100.setOnDismissListener(null);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        if (p0.a() == false) goto L11;
        Dialog r101 = getDialog();
        if (r101 == null) goto L12;
        int r102 = n0.f57248a;
        Intrinsics.checkNotNullParameter(r101, "dialog");
        Window r103 = r101.getWindow();
        if (r103 == null) goto L9;
        r103.addFlags(8);
        n0.a(r103);
        r103.setType(1000);
    L9:
        r101.setOnShowListener(new m0(r101));
        return;
    L12:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L6;
        return new a(r101, getTheme());
    L6:
        return super.onCreateDialog(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Disposable r102 = jv.a.a().c(du.a.class).subscribe(new b(this));
        if (r102 == null) goto L6;
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r102, this.f55641d);
        return;
    }
}
