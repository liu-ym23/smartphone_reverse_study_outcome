package com.bytedance.android.livesdkapi.view;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0017J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/view/ILiveVerticalViewPager;", "", "getCurrentItem", "", "getView", "Landroid/view/ViewGroup;", "setAdapter", "", "adapter", "Landroidx/viewpager/widget/PagerAdapter;", "setCurrentItem", "idx", "smoothScroll", "", "setOffscreenPageLimit", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "setOnPageChangeListener", "listener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "setUpOverScroll", "Lcom/bytedance/android/livesdkapi/view/ILiveVerticalViewPager$ILiveOverScrollDecor;", "parent", "Landroid/widget/FrameLayout;", "ILiveOverScrollDecor", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveVerticalViewPager {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/view/ILiveVerticalViewPager$ILiveOverScrollDecor;", "", "getOverScrollDecoratorAdapter", "setDefaultHeaderEnable", "", "enable", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface ILiveOverScrollDecor {
        Object getOverScrollDecoratorAdapter();

        void setDefaultHeaderEnable(boolean r100);
    }

    int getCurrentItem();

    ViewGroup getView();

    void setAdapter(PagerAdapter r100);

    void setCurrentItem(int r100, boolean r101);

    void setOffscreenPageLimit(int r100);

    void setOnPageChangeListener(ViewPager.OnPageChangeListener r100);

    ILiveOverScrollDecor setUpOverScroll(FrameLayout r100);
}
