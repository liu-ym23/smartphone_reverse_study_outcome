package com.bytedance.android.shopping.store.home.view;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/ECStoreFragmentPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreFragmentPagerAdapter extends FragmentPagerAdapter {
    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        throw null;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public final Fragment getItem(int r100) {
        return (Fragment) ListProtector.get(null, r100);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public final long getItemId(int r100) {
        return ((Fragment) ListProtector.get(null, r100)).hashCode();
    }
}
