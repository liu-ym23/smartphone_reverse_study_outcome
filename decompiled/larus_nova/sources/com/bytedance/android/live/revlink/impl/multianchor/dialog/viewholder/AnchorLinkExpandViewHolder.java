package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/viewholder/AnchorLinkExpandViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLinkExpandViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f93723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f93724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f93725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f93726d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorLinkExpandViewHolder f93727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f93728b;

        public a(AnchorLinkExpandViewHolder r100, boolean r101) {
            this.f93727a = r100;
            this.f93728b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f93728b == false) goto L5;
            AnchorLinkExpandViewHolder r101 = this.f93727a;
            r101.f93725c = !r101.f93725c;
        L5:
            AnchorLinkExpandViewHolder r102 = this.f93727a;
            r102.f93726d.P40(r102.f93725c);
        }
    }

    public interface b {
        void P40(boolean r100);
    }

    public AnchorLinkExpandViewHolder(View r100, b r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "listener");
        super(r100);
        this.f93726d = r101;
        this.f93723a = (TextView) r100.findViewById(R.id.tv_expand);
        this.f93724b = (ImageView) r100.findViewById(R.id.iv_expand);
        r100.setOnClickListener(new a(this, r102));
    }
}
