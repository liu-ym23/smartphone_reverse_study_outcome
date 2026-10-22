package com.bytedance.android.gamecp.business.comment.edit;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.business.imagechoose.ImageChooseDialog;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.bytedance.android.gamecp.common.utils.y;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.gamecp.host_api.GameCpTargetUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/edit/CommentEditorImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ViewHolder", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentEditorImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f52098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f52099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<com.bytedance.android.gamecp.base.core.service.depend.w> f52100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f52101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CommentEditViewModel f52102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f52103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f52104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final double f52105h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/edit/CommentEditorImageAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HSImageView f52106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f52107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f52108c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ImageView f52109d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public TextView f52110e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ImageView f52111f;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f52100c.size();
    }

    public final void y2() {
        if (this.f52100c.size() < this.f52103f) goto L5;
        return;
    L5:
        if (this.f52100c.size() != 0) goto L7;
    L8:
        com.bytedance.android.gamecp.base.core.service.depend.w r100 = new com.bytedance.android.gamecp.base.core.service.depend.w(-1);
        r100.f51413c = 0;
        this.f52100c.add(r100);
        return;
    L7:
        if (this.f52100c.getLast().f51413c != 0) goto L8;
    }

    public final void A2(Context r110) {
        if (GameCpTargetUtils.i() == false) goto L5;
        com.bytedance.android.gamecp.host_api.a.b().getHostAppService().h0(r110, new CommentEditorImageAdapter$showDialog$1(this, r110));
        return;
    L5:
        int r100 = this.f52103f;
        CommentEditViewModel r101 = this.f52102e;
        if (r101 == null) goto L10;
        ArrayList<com.bytedance.android.gamecp.base.core.service.depend.w> r102 = r101.getSelectImage();
        if (r102 == null) goto L10;
        int r103 = r102.size();
    L11:
        vt.c.a();
        ImageChooseDialog r104 = new ImageChooseDialog(r110, r100 - r103, null, true, this.f52098a, new CommentEditorImageAdapter$showDialog$2(this), null, 128);
        if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L18;
        DialogLancet.handleBlockedDialogShow(r104);
        return;
    L18:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L15:
        DialogLancet.beforeDialogShow(r104);
        r104.show();
        DialogLancet.afterDialogShow(r104);
        return;
    L10:
        r103 = 0;
        goto L11
    }

    public final void z2(View r100) {
        if (r100 == null) goto L12;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L13;
        int r102 = r101.width;
        int r103 = this.f52104g;
        if (r102 == r103) goto L8;
        r101.width = r103;
    L8:
        int r104 = r101.height;
        double r105 = this.f52105h;
        if (r104 == ((int) (((double) r103) * r105))) goto L14;
        r101.height = (int) (((double) r103) * r105);
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        ViewHolder r102 = (ViewHolder) r100;
        z2(r102.f52106a);
        z2(r102.f52111f);
        com.bytedance.android.gamecp.base.core.service.depend.w r103 = this.f52100c.get(r101);
        if (r103.f51413c != 0) goto L28;
        int r104 = this.f52100c.size() - 1;
        if (r104 <= 0) goto L9;
        TextView r105 = r102.f52110e;
        if (r105 == null) goto L12;
        r105.setText(y0.j(R.string.ttlive_game_promote_comment_editor_selected_image, new Object[]{Integer.valueOf(r104), Integer.valueOf(this.f52103f)}));
    L12:
        HSImageView r106 = r102.f52106a;
        if (r106 == null) goto L15;
        r106.setVisibility(8);
    L15:
        View r107 = r102.f52107b;
        if (r107 == null) goto L18;
        r107.setVisibility(8);
    L18:
        ImageView r108 = r102.f52109d;
        if (r108 == null) goto L21;
        r108.setVisibility(0);
    L21:
        TextView r109 = r102.f52110e;
        if (r109 == null) goto L24;
        r109.setVisibility(0);
    L24:
        ImageView r110 = r102.f52111f;
        if (r110 == null) goto L27;
        r110.setVisibility(0);
    L27:
        r102.itemView.setOnClickListener(new r(this));
    L46:
        View r111 = r102.f52107b;
        if (r111 == null) goto L50;
        r111.setOnClickListener(new t(this, r103));
        return;
    L50:
        return;
    L9:
        TextView r112 = r102.f52110e;
        if (r112 == null) goto L12;
        r112.setText(y0.i(R.string.ttlive_game_promote_comment_editor_gallery));
        goto L12
    L28:
        String r113 = r103.f51415e;
        if (TextUtils.equals(r102.f52108c, r113) == true) goto L31;
        r102.f52108c = r113;
        HSImageView r114 = r102.f52106a;
        int r115 = this.f52104g / 2;
        y.c(r114, r113, r115, r115, 8);
    L31:
        r102.itemView.setOnClickListener(new s(this, r102, r101));
        ImageView r116 = r102.f52109d;
        if (r116 == null) goto L34;
        r116.setVisibility(8);
    L34:
        TextView r117 = r102.f52110e;
        if (r117 == null) goto L37;
        r117.setVisibility(8);
    L37:
        View r118 = r102.f52107b;
        if (r118 == null) goto L40;
        r118.setVisibility(0);
    L40:
        HSImageView r119 = r102.f52106a;
        if (r119 == null) goto L43;
        r119.setVisibility(0);
    L43:
        ImageView r120 = r102.f52111f;
        if (r120 == null) goto L46;
        r120.setVisibility(8);
        goto L46
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f52099b = LayoutInflater.from(this.f52101d).inflate(R.layout.gamecp_game_promote_comment_editor_image_item_v2, r100, false);
        View r102 = this.f52099b;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L5:
        ViewHolder r103 = new ViewHolder(r102);
        View r104 = this.f52099b;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L8:
        r103.f52106a = (HSImageView) r104.findViewById(R.id.media_view);
        View r105 = this.f52099b;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L11:
        r103.f52107b = r105.findViewById(R.id.iv_cancel);
        View r106 = this.f52099b;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L14:
        r103.f52109d = (ImageView) r106.findViewById(R.id.iv_camera);
        View r107 = this.f52099b;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L17:
        r103.f52110e = (TextView) r107.findViewById(R.id.tv_selected_num);
        View r108 = this.f52099b;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L20:
        r103.f52111f = (ImageView) r108.findViewById(R.id.iv_background);
        return r103;
    }

    public CommentEditorImageAdapter(Context r100, CommentEditViewModel r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this.f52101d = r100;
        this.f52102e = r101;
        this.f52103f = 6;
        this.f52104g = r102;
        this.f52105h = 1.0d;
        this.f52100c = new LinkedList();
    }
}
