package com.bytedanceos.common.ui.utils;

import android.view.ViewTreeObserver;
import b9.b;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.bytedanceos.common.ui.adapter.TopicListAdapter;
import com.bytedanceos.common.view.RecyclerviewCompat;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class RecyclerViewUtil {
    private ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private RecyclerViewEngine mEngine;
    private HeaderFooterUtil mHeaderFooterUtil;
    private LoadCallback mLoadCallback;
    private final AtomicBoolean mPreLoading;
    private RecyclerviewCompat mSource;

    public interface LoadCallback {
        void load(boolean r10);
    }

    public RecyclerViewUtil(RecyclerviewCompat r10) {
        this.mPreLoading = new AtomicBoolean();
        this.globalLayoutListener = new AnonymousClass1(this);
        this.mSource = r10;
        RecyclerViewEngine r11 = new RecyclerViewEngine((TopicListAdapter) r10.getAdapter(), (VirtualLayoutManager) r10.getLayoutManager(), r10.getContext());
        this.mEngine = r11;
        r11.bindView(this.mSource);
        HeaderFooterUtil r12 = HeaderFooterUtil.newHeaderFooterUtil(this.mEngine);
        this.mHeaderFooterUtil = r12;
        BouncyEngine.configBouncy(this.mSource, r12);
        this.mHeaderFooterUtil.setLoadListener(new AnonymousClass2(this));
        this.mSource.addOnScrollListener(new AnonymousClass3(this));
        this.mSource.getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
    }

    public static /* synthetic */ HeaderFooterUtil access$000(RecyclerViewUtil r10) {
        return r10.mHeaderFooterUtil;
    }

    public static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$100(RecyclerViewUtil r10) {
        return r10.globalLayoutListener;
    }

    public static /* synthetic */ RecyclerviewCompat access$200(RecyclerViewUtil r10) {
        return r10.mSource;
    }

    public static /* synthetic */ LoadCallback access$300(RecyclerViewUtil r10) {
        return r10.mLoadCallback;
    }

    public void endLoad() {
        setPreload(false);
        this.mHeaderFooterUtil.endLoad();
    }

    public void loadFailed() {
        this.mHeaderFooterUtil.loadFailed();
        if (b.e(this.mSource) == false) goto L8;
        RecyclerviewCompat r10 = this.mSource;
        if (r10 == null) goto L9;
        r10.setVisibility(8);
        return;
    L9:
        return;
    }

    public void loadSuccess() {
        this.mHeaderFooterUtil.loadSuccess();
        RecyclerviewCompat r10 = this.mSource;
        if (r10 == null) goto L6;
        r10.setVisibility(0);
        return;
    }

    public void prepareLoad() {
        this.mHeaderFooterUtil.prepare();
        if (this.mLoadCallback != null) goto L5;
    L7:
        setPreload(false);
        return;
    L5:
        if (this.mPreLoading.get() == false) goto L7;
        this.mLoadCallback.load(false);
        goto L7
    }

    public void registerLoadCallback(LoadCallback r10) {
        this.mLoadCallback = r10;
    }

    public void setPreload(boolean r10) {
        this.mPreLoading.set(r10);
    }
}
