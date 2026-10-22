package com.bytedance.android.live.uikit.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class LoadingStatusView extends FrameLayout {
    private static final int STATUS_EMPTY = 1;
    private static final int STATUS_ERROR = 2;
    private static final int STATUS_LOADING = 0;
    private static final int STATUS_NONE = -1;
    private final String TAG;
    private int mStatus;
    List<View> mStatusViews;

    public static class Builder {
        Context mContext;
        View mEmptyView;
        View mErrorView;
        View mLoadingView;

        private CircularProgressView createProgressView() {
            return (CircularProgressView) LayoutInflater.from(this.mContext).inflate(R.layout.liveuikit_uikit_load_status_item_progressbar, null);
        }

        public Builder(Context r100) {
            if (r100 == null) goto L7;
            this.mContext = r100;
            return;
        L7:
            throw new IllegalArgumentException("LoadingStatusView.Builder:Context can not be null");
        }

        public static Builder createDefaultBuilder(Context r100) {
            return new Builder(r100).setEmptyText(R.string.load_status_empty).setLoadingText(R.string.load_status_loading).setErrorText(R.string.load_status_error, null);
        }

        private View createDefaultView(int r100) {
            TextView r101 = (TextView) LayoutInflater.from(this.mContext).inflate(R.layout.liveuikit_load_status_item_view, null);
            r101.setText(r100);
            return r101;
        }

        public Builder setEmptyText(int r100) {
            TextView r101 = (TextView) LayoutInflater.from(this.mContext).inflate(R.layout.liveuikit_view_default_empty_list, null);
            r101.setText(r100);
            return setEmptyView(r101);
        }

        public Builder setEmptyView(View r100) {
            this.mEmptyView = r100;
            return this;
        }

        public Builder setErrorView(View r100) {
            this.mErrorView = r100;
            return this;
        }

        public Builder setLoadingText(int r100) {
            return setLoadingView(createDefaultView(r100));
        }

        public Builder setLoadingView(View r100) {
            this.mLoadingView = r100;
            return this;
        }

        public Builder setUseProgressBar(int r100) {
            CircularProgressView r101 = createProgressView();
            FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-2, -2);
            r102.height = r100;
            r102.width = r100;
            r102.gravity = 17;
            r101.setLayoutParams(r102);
            return setLoadingView(r101);
        }

        public Builder setErrorText(int r100, View.OnClickListener r101) {
            View r102 = createDefaultView(r100);
            r102.setOnClickListener(r101);
            return setErrorView(r102);
        }
    }

    public void showEmpty() {
        setStatus(1);
    }

    public void showError() {
        setStatus(2);
    }

    public void showLoading() {
        setStatus(0);
    }

    public boolean isReset() {
        if (this.mStatus != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void reset() {
        int r100 = this.mStatus;
        if (r100 != (-1)) goto L5;
        return;
    L5:
        ((View) ListProtector.get(this.mStatusViews, r100)).setVisibility(4);
        this.mStatus = -1;
    }

    public LoadingStatusView(Context r100) {
        this(r100, null);
    }

    private void setStatus(int r100) {
        int r101 = this.mStatus;
        if (r101 != r100) goto L5;
        return;
    L5:
        if (r101 < 0) goto L8;
        ((View) ListProtector.get(this.mStatusViews, r101)).setVisibility(4);
    L8:
        if (((View) ListProtector.get(this.mStatusViews, r100)) != null) goto L10;
        return;
    L10:
        ((View) ListProtector.get(this.mStatusViews, r100)).setVisibility(0);
        this.mStatus = r100;
        Logger.d(this.TAG, "setStatus    " + r100);
    }

    public void setBuilder(Builder r100) {
        if (r100 != null) goto L4;
        r100 = Builder.createDefaultBuilder(getContext());
    L4:
        this.mStatusViews.clear();
        this.mStatusViews.add(r100.mLoadingView);
        this.mStatusViews.add(r100.mEmptyView);
        this.mStatusViews.add(r100.mErrorView);
        removeAllViews();
        int r101 = 0;
    L6:
        if (r101 >= this.mStatusViews.size()) goto L15;
        View r102 = (View) ListProtector.get(this.mStatusViews, r101);
        if (r102 == null) goto L14;
        r102.setVisibility(4);
        if (r102.getParent() == null) goto L13;
        ((ViewGroup) r102.getParent()).removeView(r102);
    L13:
        addView(r102);
    L14:
        r101 = r101 + 1;
        goto L6
    }

    public LoadingStatusView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LoadingStatusView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.TAG = "LoadingStatusView";
        this.mStatusViews = new ArrayList(3);
        this.mStatus = -1;
        setBuilder(null);
    }
}
