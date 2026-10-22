package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    private boolean mAttached;
    private int mContainerId;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private a mLastTab;
    private TabHost.OnTabChangeListener mOnTabChangeListener;
    private FrameLayout mRealTabContent;
    private final ArrayList<a> mTabs;

    static class DummyTabFactory implements TabHost.TabContentFactory {
        private final Context mContext;

        public DummyTabFactory(Context r3) {
            this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String r1) {
            View r2 = new View(this.mContext);
            r2.setMinimumWidth(0);
            r2.setMinimumHeight(0);
            return r2;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        String curTab;

        SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"));
        }

        SavedState(Parcel r1) {
            super(r1);
            this.curTab = r1.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeString(this.curTab);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f1761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class<?> f1762b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Bundle f1763c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Fragment f1764d;

        a(String r1, Class<?> r2, Bundle r3) {
            this.f1761a = r1;
            this.f1762b = r2;
            this.f1763c = r3;
        }
    }

    @Deprecated
    public FragmentTabHost(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super(r4, null);
        this.mTabs = new ArrayList();
        initFragmentTabHost(r4, null);
    }

    @Deprecated
    public FragmentTabHost(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r5, r6);
        this.mTabs = new ArrayList();
        initFragmentTabHost(r5, r6);
    }

    private void initFragmentTabHost(Context r4, AttributeSet r5) {
        TypedArray r6 = ((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), new int[]{R.attr.inflatedId}, 0, 0);
        this.mContainerId = r6.getResourceId(0, 0);
        r6.recycle();
        super.setOnTabChangedListener(this);
    }

    private void ensureHierarchy(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        if (findViewById(R.id.tabs) != null) goto L6;
        LinearLayout r1 = new LinearLayout(r9);
        r1.setOrientation(1);
        addView(r1, new FrameLayout.LayoutParams(-1, -1));
        TabWidget r2 = new TabWidget(r9);
        r2.setId(R.id.tabs);
        r2.setOrientation(0);
        r1.addView(r2, new LinearLayout.LayoutParams(-1, -2, 0.0f));
        FrameLayout r3 = new FrameLayout(r9);
        r3.setId(R.id.tabcontent);
        r1.addView(r3, new LinearLayout.LayoutParams(0, 0, 0.0f));
        FrameLayout r4 = new FrameLayout(r9);
        this.mRealTabContent = r4;
        r4.setId(this.mContainerId);
        r1.addView(r4, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        return;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(Context r3, FragmentManager r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        ensureHierarchy(r5);
        super.setup();
        this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.mFragmentManager = r4;
        ensureContent();
    }

    @Deprecated
    public void setup(Context r3, FragmentManager r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        ensureHierarchy(r6);
        super.setup();
        this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        this.mFragmentManager = r4;
        this.mContainerId = r5;
        ensureContent();
        this.mRealTabContent.setId(r5);
        if (getId() != (-1)) goto L6;
        setId(R.id.tabhost);
        return;
    }

    private void ensureContent() {
        if (this.mRealTabContent != null) goto L9;
        FrameLayout r0 = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(this.mContainerId), FrameLayout.class, "com.obric.aiagent.plugin");
        this.mRealTabContent = r0;
        if (r0 == null) goto L8;
        return;
    L8:
        throw new IllegalStateException("No tab content FrameLayout found for id " + this.mContainerId);
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener r3) {
        this.mOnTabChangeListener = (TabHost.OnTabChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, TabHost.OnTabChangeListener.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public void addTab(TabHost.TabSpec r3, Class<?> r4, Bundle r5) {
        r3.setContent(new DummyTabFactory(this.mContext));
        String r0 = r3.getTag();
        a r1 = new a(r0, r4, r5);
        if (this.mAttached == false) goto L9;
        r1.f1764d = this.mFragmentManager.b(r0);
        if (r1.f1764d == null) goto L9;
        if (r1.f1764d.isDetached() == true) goto L9;
        m r6 = this.mFragmentManager.a();
        r6.d(r1.f1764d);
        r6.b();
    L9:
        this.mTabs.add(r1);
        addTab(r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r0 = getCurrentTabTag();
        int r1 = this.mTabs.size();
        m r2 = null;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L15;
        a r4 = (a) ZeusTransformUtils.preCheckCast(this.mTabs.get(r3), a.class, "com.obric.aiagent.plugin");
        r4.f1764d = this.mFragmentManager.b(r4.f1761a);
        if (r4.f1764d == null) goto L14;
        if (r4.f1764d.isDetached() == true) goto L14;
        if (r4.f1761a.equals(r0) == false) goto L11;
        this.mLastTab = r4;
        goto L14
    L11:
        if (r2 != null) goto L13;
        r2 = this.mFragmentManager.a();
    L13:
        r2.d(r4.f1764d);
    L14:
        r3 = r3 + 1;
        goto L3
    L15:
        this.mAttached = true;
        m r5 = doTabChanged(r0, r2);
        if (r5 == null) goto L24;
        r5.b();
        this.mFragmentManager.b();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttached = false;
    }

    @Override // android.view.View
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.curTab = getCurrentTabTag();
        return r1;
    }

    @Override // android.view.View
    @Deprecated
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.aiagent.plugin");
        super.onRestoreInstanceState(r5.getSuperState());
        setCurrentTabByTag(r5.curTab);
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(String r2) {
        if (this.mAttached == false) goto L7;
        m r0 = doTabChanged(r2, null);
        if (r0 == null) goto L7;
        r0.b();
    L7:
        TabHost.OnTabChangeListener r1 = this.mOnTabChangeListener;
        if (r1 == null) goto L11;
        r1.onTabChanged(r2);
        return;
    }

    private m doTabChanged(String r4, m r5) {
        a r6 = getTabInfoForTag(r4);
        if (this.mLastTab == r6) goto L17;
        if (r5 != null) goto L6;
        r5 = this.mFragmentManager.a();
    L6:
        a r0 = this.mLastTab;
        if (r0 != null) goto L9;
    L11:
        if (r6 != null) goto L13;
    L16:
        this.mLastTab = r6;
        goto L17
    L13:
        if (r6.f1764d != null) goto L15;
        r6.f1764d = this.mFragmentManager.D().c(this.mContext.getClassLoader(), r6.f1762b.getName());
        r6.f1764d.setArguments(r6.f1763c);
        r5.a(this.mContainerId, r6.f1764d, r6.f1761a);
        goto L16
    L15:
        r5.e(r6.f1764d);
        goto L16
    L9:
        if (r0.f1764d == null) goto L11;
        r5.d(this.mLastTab.f1764d);
    L17:
        return r5;
    }

    private a getTabInfoForTag(String r6) {
        int r0 = this.mTabs.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.mTabs.get(r1), a.class, "com.obric.aiagent.plugin");
        if (r2.f1761a.equals(r6) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }
}
