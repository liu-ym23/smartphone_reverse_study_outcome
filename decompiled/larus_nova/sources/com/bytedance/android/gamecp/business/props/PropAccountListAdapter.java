package com.bytedance.android.gamecp.business.props;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/props/PropAccountListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/gamecp/business/props/PropAccountListAdapter$PropAccountListViewHolder;", "PropAccountListViewHolder", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PropAccountListAdapter extends RecyclerView.Adapter<PropAccountListViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<wt.c> f56295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super Integer, ? super wt.c, Unit> f56296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f56297c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/props/PropAccountListAdapter$PropAccountListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PropAccountListViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f56298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f56299b;

        public PropAccountListViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f56298a = (TextView) r100.findViewById(R.id.tv_account_list_item_info);
            this.f56299b = (ImageView) r100.findViewById(R.id.iv_account_list_item_checked);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f56295a.size();
    }

    public PropAccountListAdapter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this.f56297c = r100;
        this.f56295a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        PropAccountListViewHolder r102 = (PropAccountListViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        ViewGroup.LayoutParams r103 = r102.itemView.getLayoutParams();
        if (r103 == null) goto L21;
        RecyclerView.LayoutParams r104 = (RecyclerView.LayoutParams) r103;
        if (r101 != (this.f56295a.size() - 1)) goto L7;
        ((ViewGroup.MarginLayoutParams) r104).bottomMargin = UtilityKotlinExtentionsKt.c(8);
    L8:
        r102.itemView.setLayoutParams(r104);
        wt.c r105 = (wt.c) ListProtector.get(this.f56295a, r101);
        if (TextUtils.isEmpty(r105.nickName) == true) goto L15;
        if (TextUtils.isEmpty(r105.serviceName) == true) goto L13;
        r102.f56298a.setText(r105.serviceName + '/' + r105.nickName);
        goto L15
    L13:
        r102.f56298a.setText(String.valueOf(r105.nickName));
    L15:
        if (r105.isDefault == false) goto L17;
        UtilityKotlinExtentionsKt.j(r102.f56299b);
    L18:
        HashMap<String, String> r106 = GamecpTracker.f56755a;
        GamecpTracker.r(r102.itemView, "role_choose", MapsKt.emptyMap(), new d(), true, 96);
        return;
    L17:
        UtilityKotlinExtentionsKt.h(r102.f56299b);
        goto L18
    L7:
        ((ViewGroup.MarginLayoutParams) r104).bottomMargin = 0;
        goto L8
    L21:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        PropAccountListViewHolder r102 = new PropAccountListViewHolder(LayoutInflater.from(this.f56297c).inflate(R.layout.gamecp_layout_prop_account_list_item, r100, false));
        r102.itemView.setOnClickListener(new e(this, r102));
        return r102;
    }
}
