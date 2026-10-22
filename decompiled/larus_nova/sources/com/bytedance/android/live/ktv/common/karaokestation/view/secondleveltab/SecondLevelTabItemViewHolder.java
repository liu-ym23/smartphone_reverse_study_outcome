package com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.commonui.CustomViewTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/SecondLevelTabItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SecondLevelTabItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CustomViewTab f69702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f69703b;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SecondLevelTabItemViewHolder f69704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f69705b;

        public a(SecondLevelTabItemViewHolder r100, Function1 r101) {
            this.f69704a = r100;
            this.f69705b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function1 r101 = this.f69705b;
            if (r101 == null) goto L6;
            Unit r102 = (Unit) r101.invoke(this.f69704a.f69703b);
            return;
        }
    }

    public SecondLevelTabItemViewHolder(View r100, Function1<? super y, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        if ((r100 instanceof CustomViewTab) == true) goto L5;
        View r102 = null;
    L6:
        this.f69702a = (CustomViewTab) r102;
        y r103 = this.f69703b;
        if (r103 != null) goto L9;
    L12:
        r100.setOnClickListener(new a(this, r101));
        return;
    L9:
        if (r103.f69585j != true) goto L12;
        if (r101 == null) goto L12;
        Unit r104 = r101.invoke(r103);
        goto L12
    L5:
        r102 = r100;
        goto L6
    }
}
