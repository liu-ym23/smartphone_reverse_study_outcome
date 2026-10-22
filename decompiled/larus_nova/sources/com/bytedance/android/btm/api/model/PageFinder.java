package com.bytedance.android.btm.api.model;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes43.dex */
public class PageFinder {
    public String btmPageId;
    public Fragment fragment;
    public Object page;
    public View view;

    public boolean isEmpty() {
        if (this.page == null) goto L5;
    L11:
        return false;
    L5:
        if (this.view != null) goto L11;
        if (this.fragment != null) goto L11;
        if (TextUtils.isEmpty(this.btmPageId) == false) goto L11;
        return true;
    }

    public PageFinder() {
        this.btmPageId = null;
        this.page = null;
        this.view = null;
        this.fragment = null;
    }

    public static PageFinder via(View r100) {
        PageFinder r101 = new PageFinder();
        r101.view = r100;
        return r101;
    }

    public static PageFinder via(Fragment r100) {
        PageFinder r101 = new PageFinder();
        r101.fragment = r100;
        return r101;
    }

    public static PageFinder via(Object r100) {
        PageFinder r101 = new PageFinder();
        r101.page = r100;
        return r101;
    }

    public static PageFinder via(String r100) {
        PageFinder r101 = new PageFinder();
        r101.btmPageId = r100;
        return r101;
    }
}
