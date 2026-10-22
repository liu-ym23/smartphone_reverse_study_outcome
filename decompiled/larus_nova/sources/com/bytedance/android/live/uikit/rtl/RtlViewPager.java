package com.bytedance.android.live.uikit.rtl;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class RtlViewPager extends ViewPager {
    private int mLayoutDirection;
    private HashMap<ViewPager.OnPageChangeListener, b> mPageChangeListeners;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Parcelable f102408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f102409b;

        public class a implements ParcelableCompatCreatorCallbacks<SavedState> {
            public a() {
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            public final SavedState[] newArray(int r100) {
                return new SavedState[r100];
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            public final SavedState createFromParcel(Parcel r100, ClassLoader r101) {
                return new SavedState(r100, r101);
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = ParcelableCompat.newCreator(new a());
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            if (r101 != null) goto L5;
            r101 = getClass().getClassLoader();
        L5:
            this.f102408a = r100.readParcelable(r101);
            this.f102409b = r100.readInt();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeParcelable(this.f102408a, r101);
            r100.writeInt(this.f102409b);
        }

        public SavedState(Parcelable r100, int r101) {
            this.f102408a = r100;
            this.f102409b = r101;
        }
    }

    public class a extends DelegatingPagerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RtlViewPager f102410b;

        @Override // com.bytedance.android.live.uikit.rtl.DelegatingPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final int getItemPosition(Object r100) {
            int r101 = super.getItemPosition(r100);
            if (RtlViewPager.access$500(this.f102410b) == true) goto L5;
            return r101;
        L5:
            if (r101 == (-1)) goto L9;
            if (r101 == (-2)) goto L9;
            return (getCount() - r101) - 1;
        L9:
            return -2;
        }

        @Override // com.bytedance.android.live.uikit.rtl.DelegatingPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final CharSequence getPageTitle(int r100) {
            if (RtlViewPager.access$500(this.f102410b) == false) goto L6;
            r100 = (getCount() - r100) - 1;
        L6:
            return super.getPageTitle(r100);
        }

        @Override // com.bytedance.android.live.uikit.rtl.DelegatingPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final float getPageWidth(int r100) {
            if (RtlViewPager.access$500(this.f102410b) == false) goto L6;
            r100 = (getCount() - r100) - 1;
        L6:
            return super.getPageWidth(r100);
        }

        public a(RtlViewPager r100, PagerAdapter r101) {
            this.f102410b = r100;
            super(r101);
        }

        @Override // com.bytedance.android.live.uikit.rtl.DelegatingPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(View r100, int r101) {
            if (RtlViewPager.access$500(this.f102410b) == false) goto L6;
            r101 = (getCount() - r101) - 1;
        L6:
            return super.instantiateItem(r100, r101);
        }

        @Override // com.bytedance.android.live.uikit.rtl.DelegatingPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup r100, int r101) {
            if (RtlViewPager.access$500(this.f102410b) == false) goto L6;
            r101 = (getCount() - r101) - 1;
        L6:
            return super.instantiateItem(r100, r101);
        }

        @Override // com.bytedance.android.live.uikit.rtl.DelegatingPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(View r100, int r101, Object r102) {
            if (RtlViewPager.access$500(this.f102410b) == false) goto L5;
            r101 = (getCount() - r101) - 1;
        L5:
            super.destroyItem(r100, r101, r102);
        }

        @Override // com.bytedance.android.live.uikit.rtl.DelegatingPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final void setPrimaryItem(View r100, int r101, Object r102) {
            if (RtlViewPager.access$500(this.f102410b) == false) goto L5;
            r101 = (getCount() - r101) - 1;
        L5:
            super.setPrimaryItem(r100, r101, r102);
        }

        @Override // com.bytedance.android.live.uikit.rtl.DelegatingPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(ViewGroup r100, int r101, Object r102) {
            if (RtlViewPager.access$500(this.f102410b) == false) goto L5;
            r101 = (getCount() - r101) - 1;
        L5:
            super.destroyItem(r100, r101, r102);
        }

        @Override // com.bytedance.android.live.uikit.rtl.DelegatingPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
            if (RtlViewPager.access$500(this.f102410b) == false) goto L5;
            r101 = (getCount() - r101) - 1;
        L5:
            super.setPrimaryItem(r100, r101, r102);
        }
    }

    public class b implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager.OnPageChangeListener f102411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RtlViewPager f102412b;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            this.f102411a.onPageScrollStateChanged(r100);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            PagerAdapter r101 = RtlViewPager.access$601(this.f102412b);
            if (RtlViewPager.access$500(this.f102412b) == false) goto L6;
            if (r101 == null) goto L6;
            r100 = (r101.getCount() - r100) - 1;
        L6:
            this.f102411a.onPageSelected(r100);
        }

        public b(RtlViewPager r100, ViewPager.OnPageChangeListener r101) {
            this.f102412b = r100;
            this.f102411a = r101;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
            int r103 = this.f102412b.getWidth();
            PagerAdapter r104 = RtlViewPager.access$401(this.f102412b);
            if (RtlViewPager.access$500(this.f102412b) == false) goto L10;
            if (r104 == null) goto L10;
            int r105 = r104.getCount();
            float r106 = r103;
            int r107 = ((int) ((1.0f - r104.getPageWidth(r100)) * r106)) + r102;
        L6:
            if (r100 >= r105) goto L9;
            if (r107 <= 0) goto L9;
            r100 = r100 + 1;
            r107 = r107 - ((int) (r104.getPageWidth(r100) * r106));
        L9:
            r100 = (r105 - r100) - 1;
            r102 = -r107;
            r101 = r102 / (r106 * r104.getPageWidth(r100));
        L10:
            this.f102411a.onPageScrolled(r100, r101, r102);
        }
    }

    private boolean isRtl() {
        if (this.mLayoutDirection == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void clearOnPageChangeListeners() {
        super.clearOnPageChangeListeners();
        this.mPageChangeListeners.clear();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public PagerAdapter getAdapter() {
        a r100 = (a) super.getAdapter();
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.f102406a;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        int r100 = super.getCurrentItem();
        PagerAdapter r101 = super.getAdapter();
        if (r101 != null) goto L5;
        return r100;
    L5:
        if (isRtl() == true) goto L7;
        return r100;
    L7:
        return (r101.getCount() - r100) - 1;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mLayoutDirection);
    }

    public RtlViewPager(Context r100) {
        super(r100);
        this.mLayoutDirection = 0;
        this.mPageChangeListeners = new HashMap();
    }

    public static /* synthetic */ PagerAdapter access$401(RtlViewPager r100) {
        return super.getAdapter();
    }

    public static /* synthetic */ boolean access$500(RtlViewPager r100) {
        return r100.isRtl();
    }

    public static /* synthetic */ PagerAdapter access$601(RtlViewPager r100) {
        return super.getAdapter();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void addOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        b r101 = new b(this, r100);
        this.mPageChangeListeners.put(r100, r101);
        super.addOnPageChangeListener(r101);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        this.mLayoutDirection = r101.f102409b;
        super.onRestoreInstanceState(r101.f102408a);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r100) {
        super.onRtlPropertiesChanged(r100);
        int r101 = 0;
        int r102 = 1;
        if (r100 == 1) goto L7;
        r102 = 0;
    L7:
        if (r102 == this.mLayoutDirection) goto L15;
        PagerAdapter r103 = super.getAdapter();
        if (r103 == null) goto L11;
        r101 = getCurrentItem();
    L11:
        this.mLayoutDirection = r102;
        if (r103 == null) goto L16;
        r103.notifyDataSetChanged();
        setCurrentItem(r101);
        return;
    L16:
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void removeOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        b r101 = this.mPageChangeListeners.remove(r100);
        if (r101 == null) goto L6;
        super.removeOnPageChangeListener(r101);
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter r100) {
        if (r100 == null) goto L4;
        r100 = new a(this, r100);
    L4:
        super.setAdapter(r100);
        setCurrentItem(0);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int r100) {
        PagerAdapter r101 = super.getAdapter();
        if (r101 != null) goto L5;
    L7:
        super.setCurrentItem(r100);
        return;
    L5:
        if (isRtl() == false) goto L7;
        r100 = (r101.getCount() - r100) - 1;
        goto L7
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        super.setOnPageChangeListener(new b(this, r100));
    }

    public RtlViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mLayoutDirection = 0;
        this.mPageChangeListeners = new HashMap();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int r100, int r101) {
        if (View.MeasureSpec.getMode(r101) != 0) goto L12;
        int r102 = 0;
        int r103 = 0;
    L6:
        if (r102 >= getChildCount()) goto L11;
        View r104 = getChildAt(r102);
        r104.measure(r100, View.MeasureSpec.makeMeasureSpec(0, 0));
        int r105 = r104.getMeasuredHeight();
        if (r105 <= r103) goto L10;
        r103 = r105;
    L10:
        r102 = r102 + 1;
        goto L6
    L11:
        r101 = View.MeasureSpec.makeMeasureSpec(r103, 1073741824);
    L12:
        super.onMeasure(r100, r101);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int r100, boolean r101) {
        PagerAdapter r102 = super.getAdapter();
        if (r102 != null) goto L5;
    L7:
        super.setCurrentItem(r100, r101);
        return;
    L5:
        if (isRtl() == false) goto L7;
        r100 = (r102.getCount() - r100) - 1;
        goto L7
    }
}
