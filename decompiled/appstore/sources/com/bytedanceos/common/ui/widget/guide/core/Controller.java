package com.bytedanceos.common.ui.widget.guide.core;

import android.R;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedanceos.common.ui.widget.guide.NewbieGuide;
import com.bytedanceos.common.ui.widget.guide.lifecycle.ListenerFragment;
import com.bytedanceos.common.ui.widget.guide.lifecycle.V4ListenerFragment;
import com.bytedanceos.common.ui.widget.guide.listener.OnGuideChangedListener;
import com.bytedanceos.common.ui.widget.guide.listener.OnPageChangedListener;
import com.bytedanceos.common.ui.widget.guide.model.GuidePage;
import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Controller {
    private static final String LISTENER_FRAGMENT = "listener_fragment";
    private Activity activity;
    private boolean alwaysShow;
    private int current;
    private GuideLayout currentLayout;
    private Fragment fragment;
    private List<GuidePage> guidePages;
    private int indexOfChild;
    private boolean isShowing;
    private String label;
    private FrameLayout mParentView;
    private OnGuideChangedListener onGuideChangedListener;
    private OnPageChangedListener onPageChangedListener;
    private int showCounts;
    private SharedPreferences sp;
    private androidx.fragment.app.Fragment v4Fragment;

    public Controller(Builder r10) {
        this.indexOfChild = -1;
        Activity r11 = r10.activity;
        this.activity = r11;
        this.fragment = r10.fragment;
        this.v4Fragment = r10.v4Fragment;
        this.onGuideChangedListener = r10.onGuideChangedListener;
        this.onPageChangedListener = r10.onPageChangedListener;
        this.label = r10.label;
        this.alwaysShow = r10.alwaysShow;
        this.guidePages = r10.guidePages;
        this.showCounts = r10.showCounts;
        View r12 = r10.anchor;
        if (r12 != null) goto L6;
        r12 = r11.findViewById(R.id.content);
    L6:
        if ((r12 instanceof FrameLayout) == false) goto L8;
        this.mParentView = (FrameLayout) r12;
    L13:
        this.sp = this.activity.getSharedPreferences(NewbieGuide.TAG, 0);
        return;
    L8:
        FrameLayout r13 = new FrameLayout(this.activity);
        ViewGroup r14 = (ViewGroup) r12.getParent();
        this.indexOfChild = r14.indexOfChild(r12);
        r14.removeView(r12);
        int r15 = this.indexOfChild;
        if (r15 < 0) goto L11;
        r14.addView(r13, r15, r12.getLayoutParams());
    L12:
        r13.addView(r12, new ViewGroup.LayoutParams(-1, -1));
        this.mParentView = r13;
        goto L13
    L11:
        r14.addView(r13, r12.getLayoutParams());
        goto L12
    }

    public static /* synthetic */ List access$000(Controller r10) {
        return r10.guidePages;
    }

    public static /* synthetic */ int access$102(Controller r10, int r11) {
        r10.current = r11;
        return r11;
    }

    public static /* synthetic */ void access$200(Controller r10) {
        r10.showGuidePage();
    }

    public static /* synthetic */ OnGuideChangedListener access$300(Controller r10) {
        return r10.onGuideChangedListener;
    }

    public static /* synthetic */ void access$400(Controller r10) {
        r10.addListenerFragment();
    }

    public static /* synthetic */ String access$500(Controller r10) {
        return r10.label;
    }

    public static /* synthetic */ SharedPreferences access$600(Controller r10) {
        return r10.sp;
    }

    public static /* synthetic */ void access$700(Controller r10) {
        r10.showNextOrRemove();
    }

    private void addListenerFragment() {
        Fragment r10 = this.fragment;
        if (r10 == null) goto L8;
        compatibleFragment(r10);
        FragmentManager r11 = this.fragment.getChildFragmentManager();
        ListenerFragment r12 = (ListenerFragment) r11.findFragmentByTag(LISTENER_FRAGMENT);
        if (r12 != null) goto L7;
        r12 = new ListenerFragment();
        r11.beginTransaction().add(r12, LISTENER_FRAGMENT).commitAllowingStateLoss();
    L7:
        r12.setFragmentLifecycle(new AnonymousClass4(this));
    L8:
        androidx.fragment.app.Fragment r13 = this.v4Fragment;
        if (r13 == null) goto L15;
        androidx.fragment.app.FragmentManager r14 = r13.getChildFragmentManager();
        V4ListenerFragment r15 = (V4ListenerFragment) r14.i0(LISTENER_FRAGMENT);
        if (r15 != null) goto L13;
        r15 = new V4ListenerFragment();
        r14.o().e(r15, LISTENER_FRAGMENT).k();
    L13:
        r15.setFragmentLifecycle(new AnonymousClass5(this));
        return;
    }

    private void compatibleFragment(Fragment r10) {
        Field r11 = Fragment.class.getDeclaredField("mChildFragmentManager");     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        r11.setAccessible(true);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        r11.set(r10, null);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private void removeListenerFragment() {
        Fragment r10 = this.fragment;
        if (r10 == null) goto L7;
        FragmentManager r11 = r10.getChildFragmentManager();
        ListenerFragment r12 = (ListenerFragment) r11.findFragmentByTag(LISTENER_FRAGMENT);
        if (r12 == null) goto L7;
        r11.beginTransaction().remove(r12).commitAllowingStateLoss();
    L7:
        androidx.fragment.app.Fragment r13 = this.v4Fragment;
        if (r13 == null) goto L13;
        androidx.fragment.app.FragmentManager r14 = r13.getChildFragmentManager();
        V4ListenerFragment r15 = (V4ListenerFragment) r14.i0(LISTENER_FRAGMENT);
        if (r15 == null) goto L14;
        r14.o().t(r15).k();
        return;
    L14:
        return;
    }

    private void showGuidePage() {
        GuidePage r10 = this.guidePages.get(this.current);
        GuideLayout r11 = new GuideLayout(this.activity, r10, this);
        r11.setOnGuideLayoutDismissListener(new AnonymousClass3(this));
        this.mParentView.addView(r11, new FrameLayout.LayoutParams(-1, -1));
        this.currentLayout = r11;
        OnPageChangedListener r12 = this.onPageChangedListener;
        if (r12 == null) goto L5;
        r12.onPageChanged(this.current);
    L5:
        this.isShowing = true;
    }

    private void showNextOrRemove() {
        if (this.current >= (this.guidePages.size() - 1)) goto L5;
        this.current++;
        showGuidePage();
        return;
    L5:
        OnGuideChangedListener r10 = this.onGuideChangedListener;
        if (r10 == null) goto L8;
        r10.onRemoved(this);
    L8:
        removeListenerFragment();
        this.isShowing = false;
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void remove() {
        GuideLayout r10 = this.currentLayout;
        if (r10 != null) goto L5;
    L18:
        this.isShowing = false;
        return;
    L5:
        if (r10.getParent() == null) goto L18;
        ViewGroup r11 = (ViewGroup) this.currentLayout.getParent();
        r11.removeView(this.currentLayout);
        if ((r11 instanceof FrameLayout) == true) goto L14;
        ViewGroup r12 = (ViewGroup) r11.getParent();
        View r13 = r11.getChildAt(0);
        r11.removeAllViews();
        if (r13 == null) goto L14;
        int r14 = this.indexOfChild;
        if (r14 <= 0) goto L13;
        r12.addView(r13, r14, r11.getLayoutParams());
        goto L14
    L13:
        r12.addView(r13, r11.getLayoutParams());
    L14:
        OnGuideChangedListener r15 = this.onGuideChangedListener;
        if (r15 == null) goto L17;
        r15.onRemoved(this);
    L17:
        this.currentLayout = null;
        goto L18
    }

    public void resetLabel() {
        resetLabel(this.label);
    }

    public void show() {
        final int r10 = this.sp.getInt(this.label, 0);
        if (this.alwaysShow == true) goto L8;
        if (r10 < this.showCounts) goto L8;
        return;
    L8:
        if (this.isShowing == false) goto L10;
        return;
    L10:
        this.isShowing = true;
        this.mParentView.post(new AnonymousClass1(this, r10));
    }

    public void showPage(int r10) {
        if (r10 < 0) goto L14;
        if (r10 > (this.guidePages.size() - 1)) goto L14;
        if (this.current != r10) goto L8;
        return;
    L8:
        this.current = r10;
        GuideLayout r11 = this.currentLayout;
        if (r11 == null) goto L11;
        r11.setOnGuideLayoutDismissListener(new AnonymousClass2(this));
        this.currentLayout.remove();
        return;
    L11:
        showGuidePage();
        return;
    L14:
        throw new InvalidParameterException("The Guide page position is out of range. current:" + r10 + ", range: [ 0, " + this.guidePages.size() + " )");
    }

    public void showPreviewPage() {
        int r10 = this.current - 1;
        this.current = r10;
        showPage(r10);
    }

    public void resetLabel(String r10) {
        this.sp.edit().putInt(r10, 0).apply();
    }
}
