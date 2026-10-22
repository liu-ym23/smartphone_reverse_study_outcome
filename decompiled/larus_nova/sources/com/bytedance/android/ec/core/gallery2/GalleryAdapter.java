package com.bytedance.android.ec.core.gallery2;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.model.k;
import com.bytedance.android.ec.model.l;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/core/gallery2/GalleryAdapter;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPagerAdapter;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GalleryAdapter extends TransitionPagerAdapter<TransitionViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends l> f44052a;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<? extends l> r100 = this.f44052a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public GalleryAdapter() {
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        List<? extends l> r101 = this.f44052a;
        if (r101 == null) goto L7;
        l r102 = (l) ListProtector.get(r101, r100);
        if (r102 == null) goto L7;
        Integer r103 = Integer.valueOf(r102.getType());
    L8:
        if (r103 == null) goto L13;
        r103.intValue();
        return 1;
    L13:
        return 1;
    L7:
        r103 = null;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        TransitionViewHolder r102 = (TransitionViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        List<? extends l> r103 = this.f44052a;
        if (r103 == null) goto L13;
        l r104 = (l) ListProtector.get(r103, r101);
        if (r104 != null) goto L8;
        return;
    L8:
        if ((r102 instanceof PhotoVH) == false) goto L14;
        k r105 = (k) r104;
        AbstractDraweeController r106 = Fresco.newDraweeControllerBuilder().setUri(r105.f47873b).build();
        PhotoVH r107 = (PhotoVH) r102;
        r107.getClass();
        r107.f44059a.setController(r106);
        if (r105.f47880i == null) goto L15;
        r107.f44059a.getHierarchy().setImage(r105.f47880i, 1.0f, true);
        r107.f44059a.requestLayout();
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new PhotoVH(LayoutInflater.from(r100.getContext()).inflate(R.layout.ec_commerce_item_gallery_photo, r100, false));
    }
}
