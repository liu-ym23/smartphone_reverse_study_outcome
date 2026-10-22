package com.bytedance.android.gamecp.business.comment;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.y;
import com.bytedance.android.gamecp.host_api.model.ImageModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/CommentImageSummaryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ViewHolder", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentImageSummaryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f51818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<ImageModel> f51819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<String> f51820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<? super Integer, ? extends com.bytedance.android.gamecp.business.gallery.transfer.h> f51821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function2<? super Integer, ? super Boolean, Unit> f51822e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f51823f;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/CommentImageSummaryAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HSImageView f51825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ImageView f51826b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f51827c;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f51819b.size();
    }

    public CommentImageSummaryAdapter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this.f51823f = r100;
        this.f51819b = new LinkedList();
        this.f51820c = new ArrayList();
        this.f51822e = CommentImageSummaryAdapter$imageShowClickListener$1.INSTANCE;
        this.f51821d = new AnonymousClass1(this);
    }

    public final void setData(List<? extends ImageModel> r100) {
        this.f51819b.clear();
        this.f51820c.clear();
        if (r100 == null) goto L35;
        this.f51819b.addAll(r100);
        Iterator<ImageModel> r101 = this.f51819b.iterator();
    L6:
        if (r101.hasNext() == false) goto L35;
        ImageModel r102 = r101.next();
        List<String> r103 = r102.getUrls();
        if (r103 == null) goto L10;
        Integer r104 = Integer.valueOf(r103.size());
    L11:
        if (r104 == null) goto L16;
        if (r104.intValue() != 0) goto L16;
        this.f51820c.add("empty url");
    L16:
        String r105 = "";
        if (r104 == null) goto L28;
        if (r104.intValue() != 1) goto L28;
        ArrayList<String> r106 = this.f51820c;
        List<String> r107 = r102.getUrls();
        if (r107 == null) goto L27;
        String r108 = (String) ListProtector.get(r107, 0);
        if (r108 == null) goto L27;
        r105 = r108;
    L27:
        r106.add(r105);
    L28:
        ArrayList<String> r109 = this.f51820c;
        List<String> r110 = r102.getUrls();
        if (r110 == null) goto L34;
        String r111 = (String) ListProtector.get(r110, 1);
        if (r111 == null) goto L34;
        r105 = r111;
    L34:
        r109.add(r105);
        goto L6
    L10:
        r104 = null;
    L35:
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        final ViewHolder r101 = (ViewHolder) r100;
        final ImageModel r102 = this.f51819b.get(r110);
        if (r102 == null) goto L5;
        List<String> r103 = r102.getUrls();
    L7:
        if (r103 == null) goto L9;
        int r104 = r103.size();
    L10:
        if (r104 <= 0) goto L17;
        if (r102 == null) goto L16;
        List<String> r105 = r102.getUrls();
        if (r105 == null) goto L16;
        String r106 = (String) ListProtector.get(r105, 0);
        if (r106 == null) goto L16;
    L18:
        ImageView r107 = r101.f51826b;
        if (r107 == null) goto L21;
        UtilityKotlinExtentionsKt.h(r107);
    L21:
        final int r108 = r102.getWidth();
        final int r109 = r102.getHeight();
        int r111 = 1;
        if (r108 <= r109) goto L26;
        int r112 = r108;
    L24:
        if (r112 <= 400) goto L29;
        r112 = r112 / 2;
        r111 = r111 * 2;
    L29:
        final int r113 = r111;
        Function1<y.a, Unit> r114 = new CommentImageSummaryAdapter$onBindViewHolder$loadImageAction$1(r101, r102, r108, r113, r109);
        if (TextUtils.equals(r101.f51827c, r106) == true) goto L32;
        r101.f51827c = r106;
        r114.invoke(new d(r101));
    L32:
        r101.itemView.setOnClickListener(new e(this, r110, r101, r114));
        return;
    L26:
        int r115 = r109;
    L27:
        if (r115 <= 400) goto L29;
        r115 = r115 / 2;
        r111 = r111 * 2;
    L16:
        r106 = "";
        goto L18
    L17:
        r106 = "empty url";
        goto L18
    L9:
        r104 = 0;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f51818a = LayoutInflater.from(this.f51823f).inflate(R.layout.gamecp_game_promote_comment_image_summary_item, r100, false);
        View r102 = this.f51818a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L5:
        ViewHolder r103 = new ViewHolder(r102);
        View r104 = this.f51818a;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L8:
        r103.f51825a = (HSImageView) r104.findViewById(R.id.media_view);
        View r105 = this.f51818a;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L11:
        r103.f51826b = (ImageView) r105.findViewById(R.id.iv_load_failed);
        return r103;
    }
}
