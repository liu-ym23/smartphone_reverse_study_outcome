package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes17.dex */
public abstract class PagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;
    private final DataSetObservable mObservable;
    private DataSetObserver mViewPagerObserver;

    public void finishUpdate(View r100) {
    }

    public abstract int getCount();

    public int getItemPosition(Object r100) {
        return -1;
    }

    public CharSequence getPageTitle(int r100) {
        return null;
    }

    public float getPageWidth(int r100) {
        return 1.0f;
    }

    public abstract boolean isViewFromObject(View r100, Object r101);

    public void notifyDataSetChanged() {
        monitor-enter(this);
        DataSetObserver r100 = this.mViewPagerObserver;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        r100.onChanged();     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);     // Catch: Throwable -> L9
        this.mObservable.notifyChanged();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void restoreState(Parcelable r100, ClassLoader r101) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(View r100, int r101, Object r102) {
    }

    public void startUpdate(View r100) {
    }

    public PagerAdapter() {
        this.mObservable = new DataSetObservable();
    }

    public void finishUpdate(ViewGroup r100) {
        finishUpdate(r100);
    }

    public void registerDataSetObserver(DataSetObserver r100) {
        this.mObservable.registerObserver(r100);
    }

    public void setViewPagerObserver(DataSetObserver r100) {
        monitor-enter(this);
        this.mViewPagerObserver = r100;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void startUpdate(ViewGroup r100) {
        startUpdate(r100);
    }

    public void unregisterDataSetObserver(DataSetObserver r100) {
        this.mObservable.unregisterObserver(r100);
    }

    public Object instantiateItem(View r100, int r101) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public Object instantiateItem(ViewGroup r100, int r101) {
        return instantiateItem(r100, r101);
    }

    public void destroyItem(View r100, int r101, Object r102) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        setPrimaryItem(r100, r101, r102);
    }

    public void destroyItem(ViewGroup r100, int r101, Object r102) {
        destroyItem(r100, r101, r102);
    }
}
