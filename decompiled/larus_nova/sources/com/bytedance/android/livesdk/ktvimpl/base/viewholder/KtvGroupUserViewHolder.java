package com.bytedance.android.livesdk.ktvimpl.base.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.ktv.common.model.api.m0;
import com.bytedance.android.live.ktv.common.model.api.r;
import com.bytedance.android.live.ktv.common.view.LiveOnlineAvatarView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/viewholder/KtvGroupUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvGroupUserViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveOnlineAvatarView f143655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f143656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f143657c;

    public KtvGroupUserViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f143655a = (LiveOnlineAvatarView) r100.findViewById(R.id.ktv_group_user_avatar);
        this.f143656b = (TextView) r100.findViewById(R.id.ktv_group_user_name);
        this.f143657c = (TextView) r100.findViewById(R.id.ktv_group_user_descrip);
    }

    public final void T3(r r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        String r101 = r100.b();
        if (r101 == null) goto L5;
        this.f143656b.setText(r101);
    L5:
        String r102 = r100.d();
        if (r102 == null) goto L8;
        this.f143657c.setText(r102);
    L8:
        k r103 = r100.a();
        if (r103 == null) goto L11;
        LiveOnlineAvatarView r104 = this.f143655a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ImageUtil.loadRoundImage(r104.f70750a, r103);
    L11:
        m0 r105 = r100.c();
        if (r105 == null) goto L20;
        List<String> r106 = r105.a();
        if (r106 != null) goto L16;
        return;
    L16:
        if (r106.size() != 0) goto L18;
        return;
    L18:
        final String r107 = (String) ListProtector.get(r106, 0);
        this.f143655a.setRoomId(r107);
        this.f143655a.setOnClickAvatarCb(new KtvGroupUserViewHolder$onBind$4$1(r107));
        return;
    }
}
