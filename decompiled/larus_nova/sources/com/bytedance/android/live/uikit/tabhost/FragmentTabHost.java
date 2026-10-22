package com.bytedance.android.live.uikit.tabhost;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.fragment.app.Fragment;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f102464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f102465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f102466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f102467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TabHost.OnTabChangeListener f102468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f102469f;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f102470a;

        public class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r100) {
                return new SavedState(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r100) {
                return new SavedState[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public final String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f102470a + i.f25855d;
        }

        public SavedState(Parcel r100) {
            super(r100);
            this.f102470a = r100.readString();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeString(this.f102470a);
        }
    }

    public interface a {
    }

    public static final class b {
    }

    public Fragment getCurrentFragment() {
        return null;
    }

    public void setHideWhenTabChanged(boolean r100) {
    }

    public void setOnTabSwitchListener(a r100) {
    }

    @Override // android.widget.TabHost
    public final void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getCurrentTabTag();
        if (this.f102465b.size() > 0) goto L9;
        this.f102469f = true;
        if (this.f102465b.size() > 0) goto L7;
        return;
    L7:
        ((b) ListProtector.get(this.f102465b, 0)).getClass();
        throw null;
    L9:
        ((b) ListProtector.get(this.f102465b, 0)).getClass();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f102469f = false;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        Context r100 = getContext();
        if (r100 != null) goto L6;
        return;
    L6:
        if (findViewById(R.id.tabs) != null) goto L9;
        LinearLayout r101 = new LinearLayout(r100);
        r101.setOrientation(1);
        addView(r101, new FrameLayout.LayoutParams(-1, -1));
        TabWidget r102 = new TabWidget(r100);
        r102.setId(R.id.tabs);
        r102.setOrientation(0);
        r101.addView(r102, new LinearLayout.LayoutParams(-1, -2, 0.0f));
        FrameLayout r103 = new FrameLayout(r100);
        r103.setId(R.id.tabcontent);
        r101.addView(r103, new LinearLayout.LayoutParams(0, 0, 0.0f));
        FrameLayout r104 = new FrameLayout(r100);
        this.f102466c = r104;
        r104.setId(this.f102467d);
        r101.addView(r104, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        return;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f102470a = getCurrentTabTag();
        return r100;
    }

    public boolean getDispatchWindowFocusChangedToAllTab() {
        return this.f102464a;
    }

    public FragmentTabHost(Context r100) {
        super(r100, null);
        this.f102464a = false;
        this.f102465b = new ArrayList();
        TypedArray r101 = r100.obtainStyledAttributes(null, new int[]{R.attr.inflatedId}, 0, 0);
        this.f102467d = r101.getResourceId(0, 0);
        r101.recycle();
        super.setOnTabChangedListener(this);
    }

    @Override // android.widget.TabHost, android.view.ViewGroup, android.view.View
    public final void dispatchWindowFocusChanged(boolean r100) {
        if (this.f102464a == false) goto L7;
        int r101 = getChildCount();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L10;
        getChildAt(r102).dispatchWindowFocusChanged(r100);
        r102 = r102 + 1;
        goto L5
    L10:
        return;
    L7:
        super.dispatchWindowFocusChanged(r100);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        setCurrentTabByTag(r101.f102470a);
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public final void onTabChanged(String r100) {
        if (this.f102469f == true) goto L5;
    L9:
        TabHost.OnTabChangeListener r101 = this.f102468e;
        if (r101 == null) goto L13;
        r101.onTabChanged(r100);
        return;
    L13:
        return;
    L5:
        if (this.f102465b.size() <= 0) goto L9;
        ((b) ListProtector.get(this.f102465b, 0)).getClass();
        throw null;
    }

    public void setDispatchWindowFocusChangedToAllTab(boolean r100) {
        this.f102464a = r100;
    }

    @Override // android.widget.TabHost
    public void setOnTabChangedListener(TabHost.OnTabChangeListener r100) {
        this.f102468e = r100;
    }

    public void setSuperOnTabChangedListener(TabHost.OnTabChangeListener r100) {
        super.setOnTabChangedListener(r100);
    }

    public FragmentTabHost(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f102464a = false;
        this.f102465b = new ArrayList();
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.inflatedId}, 0, 0);
        this.f102467d = r102.getResourceId(0, 0);
        r102.recycle();
        super.setOnTabChangedListener(this);
    }
}
