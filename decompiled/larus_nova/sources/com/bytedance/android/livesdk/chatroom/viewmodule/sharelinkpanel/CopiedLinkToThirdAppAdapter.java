package com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.utils.x0;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/sharelinkpanel/CopiedLinkToThirdAppAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/sharelinkpanel/CopiedLinkToThirdAppHolder;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CopiedLinkToThirdAppAdapter extends RecyclerView.Adapter<CopiedLinkToThirdAppHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<l> f115456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super l, Unit> f115457b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f115456a.size();
    }

    public CopiedLinkToThirdAppAdapter() {
        this.f115456a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        CopiedLinkToThirdAppHolder r102 = (CopiedLinkToThirdAppHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        final l r103 = (l) CollectionsKt.getOrNull(this.f115456a, r101);
        if (r103 == null) goto L12;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        ImageView r104 = r102.f115458a;
        if (r104 == null) goto L7;
        r104.setImageResource(r103.c());
    L7:
        TextView r105 = r102.f115459b;
        if (r105 == null) goto L10;
        r105.setText(r103.e());
    L10:
        r102.f115460c.setOnClickListener(x0.a(new AnonymousClass1(this, r103)));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new CopiedLinkToThirdAppHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_share_link_panel_item, r100, false));
    }
}
