package com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import k62.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sh6.b;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/messagelist/viewholder/PadAdjustViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class PadAdjustViewHolder extends RecyclerView.ViewHolder {
    public PadAdjustViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        if (PadConfigUtils.c() == true) goto L6;
        return;
    L6:
        if (e5.n() == true) goto L8;
        UIUtils.updateLayout(this.itemView, (int) (s1.y() * 0.6f), -3);
    L8:
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L16;
        n<PadOrientation> r102 = r101.getPadOrientation();
        if (r102 == null) goto L17;
        Observable<b<PadOrientation>> r103 = r102.a();
        if (r103 == null) goto L18;
        r103.subscribe(new f(this));
        return;
    L18:
        return;
    L17:
        return;
    }
}
