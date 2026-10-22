package com.bytedance.android.livesdk.preview.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/preview/video/BasePreviewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BasePreviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends LinkPlayerInfo> f156618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends LinkPlayerInfo> f156619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f156620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f156621d;

    public static final class a {
    }

    static {
    }

    public abstract int getLayoutId(int r100);

    public abstract List<LinkPlayerInfo> y2();

    public abstract BasePreviewViewHolder z2(View r100, int r101);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f156618a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        String r101 = ((LinkPlayerInfo) ListProtector.get(this.f156618a, r100)).getInteractId();
        if (r101 == null) goto L5;
        int r102 = CastIntegerProtector.parseInt(r101);
    L6:
        if (r102 <= 0) goto L10;
        return 1;
    L10:
        return 0;
    L5:
        r102 = 0;
        goto L6
    }

    public final void setData(List<? extends LinkPlayerInfo> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r100, this.f156619b) == true) goto L33;
        this.f156619b = r100;
        List<LinkPlayerInfo> r101 = y2();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L9:
        boolean r104 = true;
        if (r103.hasNext() == false) goto L19;
        Object r105 = r103.next();
        int r106 = ((LinkPlayerInfo) r105).userPosition;
        if (r106 > 0) goto L14;
    L16:
        r104 = false;
    L17:
        if (r104 == false) goto L9;
        r102.add(r105);
        goto L9
    L14:
        if (r106 >= (r101.size() + 1)) goto L16;
    L19:
        Iterator r107 = r102.iterator();
    L21:
        if (r107.hasNext() == false) goto L23;
        LinkPlayerInfo r108 = (LinkPlayerInfo) r107.next();
        ListProtector.set(r101, r108.userPosition - 1, r108);
        goto L21
    L23:
        this.f156618a = r101;
        notifyDataSetChanged();
        return;
    }

    public BasePreviewAdapter(int r100, int r101) {
        this.f156620c = r100;
        this.f156621d = r101;
        this.f156618a = y2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof BasePreviewViewHolder) == false) goto L6;
        ((BasePreviewViewHolder) r100).T3((LinkPlayerInfo) ListProtector.get(this.f156618a, r101));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(getLayoutId(r101), r100, false);
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        r103.width = this.f156621d;
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
        r104.height = this.f156620c;
        return z2(r102, r101);
    }
}
