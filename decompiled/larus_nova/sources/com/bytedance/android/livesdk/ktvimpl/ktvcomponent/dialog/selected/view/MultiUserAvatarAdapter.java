package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.selected.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/selected/view/MultiUserAvatarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", PerfLog.PARAM_KEY_CONTEXT_ID, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiUserAvatarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f144210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<k> f144211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f144212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f144213d;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f144211b.size();
    }

    public final Context getContext() {
        return this.f144213d;
    }

    public MultiUserAvatarAdapter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f144213d = r100;
        this.f144211b = new ArrayList();
        this.f144212c = 4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        int r101 = this.f144212c;
        if (r100 == (r101 - 1)) goto L5;
        return 0;
    L5:
        if (this.f144210a <= r101) goto L10;
        return 1;
    L10:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        k r102 = (k) ListProtector.get(this.f144211b, r101);
        if ((r100 instanceof MultiUserAvatarViewHolder) == false) goto L8;
        MultiUserAvatarViewHolder r103 = (MultiUserAvatarViewHolder) r100;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "avatarThumb");
        ImageView r104 = r103.f144216a;
        if (r104 == null) goto L9;
        ImageUtil.loadRoundImage(r104, r102);
        return;
    L9:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 == 0) goto L5;
        int r102 = R.layout.ttlive_multi_avatar_item_more;
    L7:
        return new MultiUserAvatarViewHolder(LayoutInflater.from(this.f144213d).inflate(r102, r100, false));
    L5:
        r102 = R.layout.ttlive_multi_avatar_item;
        goto L7
    }
}
