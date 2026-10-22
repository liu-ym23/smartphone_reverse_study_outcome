package com.bytedance.android.livesdk.share.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.business.depend.share.ConversationCoreInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\t\n\u000b\fR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/share/adapter/FansGroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/share/adapter/FansGroupAdapter$FansGroupViewHolder;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "FansGroupViewHolder", "b", "SpaceItemDecoration", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FansGroupAdapter extends RecyclerView.Adapter<FansGroupViewHolder> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f158075e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f158076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f158077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f158078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ConversationCoreInfo> f158079d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/share/adapter/FansGroupAdapter$FansGroupViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FansGroupViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HSImageView f158080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f158081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f158082c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f158083d;

        public FansGroupViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f158080a = (HSImageView) r100.findViewById(R.id.iv_icon);
            this.f158081b = (TextView) r100.findViewById(R.id.tv_name);
            this.f158082c = r100;
            this.f158083d = (ImageView) r100.findViewById(R.id.iv_chosen);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/share/adapter/FansGroupAdapter$SpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SpaceItemDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f158084a;

        public SpaceItemDecoration(int r100) {
            this.f158084a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
            Intrinsics.checkNotNullParameter(r100, "outRect");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "parent");
            Intrinsics.checkNotNullParameter(r103, "state");
            r100.left = this.f158084a;
            RecyclerView.Adapter r104 = r102.getAdapter();
            if (r104 != null) goto L6;
            return;
        L6:
            if (r102.getChildAdapterPosition(r101) != (r104.getItemCount() - 1)) goto L9;
            r100.right = this.f158084a * 2;
            return;
        }
    }

    public static final class a {
    }

    public interface b {
        void a(Set<String> r100);
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f158079d.size();
    }

    public final Context getContext() {
        return this.f158078c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FansGroupAdapter(Context r100, List<? extends ConversationCoreInfo> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f158078c = r100;
        this.f158079d = r101;
        this.f158077b = new LinkedHashSet();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        FansGroupViewHolder r102 = (FansGroupViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        int r103 = this.f158079d.size();
        if (r101 < 0) goto L24;
        if (r103 > r101) goto L7;
        return;
    L7:
        if (r102.f158080a == null) goto L23;
        ConversationCoreInfo r104 = (ConversationCoreInfo) ListProtector.get(this.f158079d, r101);
        if (TextUtils.isEmpty(r104.avatarUrl) == false) goto L12;
        ImageUtil.loadRoundResource(r102.f158080a, R.drawable.ttlive_img_avatar_empty, -1, -1);
    L16:
        TextView r105 = r102.f158081b;
        r105.setText(r104.name + '(' + r104.memberCount + ')');
        r105.post(new gt2.a(r105, this, r104));
        boolean r106 = r104.isChosen;
        Intrinsics.checkNotNullParameter(r102, "holder");
        ImageView r107 = r102.f158083d;
        if (r106 == false) goto L19;
        int r108 = 0;
    L20:
        r107.setVisibility(r108);
        r102.f158082c.setOnClickListener(new gt2.b(this, r104, r102));
        return;
    L19:
        r108 = 8;
        goto L20
    L12:
        if (r102.f158080a.getTag(R.id.ttlive_tag_image_request) != null) goto L14;
    L15:
        r102.f158080a.setTag(R.id.ttlive_tag_image_request, r104.avatarUrl);
        HSImageView r109 = r102.f158080a;
        ImageModel r110 = new ImageModel();
        ArrayList r111 = new ArrayList();
        r111.add(r104.avatarUrl);
        Unit r112 = Unit.INSTANCE;
        r110.mUrls = r111;
        r110.setUri(r104.avatarUrl);
        ImageLoader.bindImage(r109, r110);
        goto L16
    L14:
        if ((!Intrinsics.areEqual(r102.f158080a.getTag(R.id.ttlive_tag_image_request), r104.avatarUrl)) == false) goto L16;
    L23:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new FansGroupViewHolder(LayoutInflater.from(this.f158078c.getApplicationContext()).inflate(R.layout.ttlive_item_fans_group, r100, false));
    }
}
