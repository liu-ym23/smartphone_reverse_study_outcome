package com.bytedanceos.common.ui.widget.guide.core;

import android.app.Activity;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import com.bytedanceos.common.ui.widget.guide.listener.OnGuideChangedListener;
import com.bytedanceos.common.ui.widget.guide.listener.OnPageChangedListener;
import com.bytedanceos.common.ui.widget.guide.model.GuidePage;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Builder {
    Activity activity;
    boolean alwaysShow;
    View anchor;
    Fragment fragment;
    List<GuidePage> guidePages;
    String label;
    OnGuideChangedListener onGuideChangedListener;
    OnPageChangedListener onPageChangedListener;
    int showCounts;
    androidx.fragment.app.Fragment v4Fragment;

    public Builder(Activity r10) {
        this.showCounts = 1;
        this.guidePages = new ArrayList();
        this.activity = r10;
    }

    private void check() {
        if (TextUtils.isEmpty(this.label) == true) goto L15;
        if (this.activity == null) goto L7;
        return;
    L7:
        if (this.fragment != null) goto L12;
        if (this.v4Fragment != null) goto L12;
        return;
    L12:
        throw new IllegalStateException("activity is null, please make sure that fragment is showing when call NewbieGuide");
    L15:
        throw new IllegalArgumentException("the param 'label' is missing, please call setLabel()");
    }

    public Builder addGuidePage(GuidePage r10) {
        this.guidePages.add(r10);
        return this;
    }

    public Builder alwaysShow(boolean r10) {
        this.alwaysShow = r10;
        return this;
    }

    public Builder anchor(View r10) {
        this.anchor = r10;
        return this;
    }

    public Controller build() {
        check();
        return new Controller(this);
    }

    public Builder setLabel(String r10) {
        this.label = r10;
        return this;
    }

    public Builder setOnGuideChangedListener(OnGuideChangedListener r10) {
        this.onGuideChangedListener = r10;
        return this;
    }

    public Builder setOnPageChangedListener(OnPageChangedListener r10) {
        this.onPageChangedListener = r10;
        return this;
    }

    public Builder setShowCounts(int r10) {
        this.showCounts = r10;
        return this;
    }

    public Controller show() {
        check();
        Controller r10 = new Controller(this);
        r10.show();
        return r10;
    }

    public Builder(Fragment r10) {
        this.showCounts = 1;
        this.guidePages = new ArrayList();
        this.fragment = r10;
        this.activity = r10.getActivity();
    }

    public Builder(androidx.fragment.app.Fragment r10) {
        this.showCounts = 1;
        this.guidePages = new ArrayList();
        this.v4Fragment = r10;
        this.activity = r10.getActivity();
    }
}
