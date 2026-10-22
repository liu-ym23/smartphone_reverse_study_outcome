package com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.Switch;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningbutton/view/TuningButtonListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TuningButtonListViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ac0.a f70494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f70495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f70496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f70497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f70498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final bc0.a f70499f;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuningButtonListViewHolder f70500a;

        public a(TuningButtonListViewHolder r100) {
            this.f70500a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            TuningButtonListViewHolder r101 = this.f70500a;
            bc0.a r102 = r101.f70499f;
            ac0.a r103 = r101.f70494a;
            Switch r104 = (Switch) r101.f70497d.getValue();
            if (r104 == null) goto L5;
            boolean r105 = r104.isChecked();
        L6:
            r102.b(r103, !r105);
            return;
        L5:
            r105 = false;
            goto L6
        }
    }

    public TuningButtonListViewHolder(final View r100, bc0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "tuningButtonCallback");
        super(r100);
        this.f70499f = r101;
        this.f70495b = LazyKt.lazy(new TuningButtonListViewHolder$btnListItemTitle$2(r100));
        Lazy r102 = LazyKt.lazy(new TuningButtonListViewHolder$btnListItemSwitchContainer$2(r100));
        this.f70496c = r102;
        this.f70497d = LazyKt.lazy(new TuningButtonListViewHolder$btnListItemSwitch$2(r100));
        this.f70498e = LazyKt.lazy(new TuningButtonListViewHolder$btnListItemDivider$2(r100));
        FrameLayout r103 = (FrameLayout) r102.getValue();
        if (r103 == null) goto L6;
        r103.setOnClickListener(new a(this));
        return;
    }
}
