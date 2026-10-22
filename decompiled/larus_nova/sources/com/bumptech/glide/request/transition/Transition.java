package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes39.dex */
public interface Transition<R> {

    public interface ViewAdapter {
        Drawable getCurrentDrawable();

        View getView();

        void setDrawable(Drawable r100);
    }

    boolean transition(R r100, ViewAdapter r101);
}
