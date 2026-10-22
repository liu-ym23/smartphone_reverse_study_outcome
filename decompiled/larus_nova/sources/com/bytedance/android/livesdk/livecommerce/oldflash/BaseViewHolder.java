package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveFlashViewModel f149510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f149511b;

    public abstract void T3(b r100, int r101);

    public BaseViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }

    public final void U3(boolean r100) {
        View r101 = this.f149511b;
        if (r101 == null) goto L13;
        if (r100 == false) goto L10;
        LiveFlashViewModel r102 = this.f149510a;
        if (r102 == null) goto L10;
        if (r102.getShowErrorLine() != true) goto L10;
        int r103 = R.color.ec_color_ff0000;
    L11:
        r101.setBackgroundColor(ContextCompat.getColor(w0.getContext(), r103));
        return;
    L10:
        r103 = R.color.ec_color_12_161823;
        goto L11
    }
}
