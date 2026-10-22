package com.tmall.wireless.tangram.core.protocol;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public interface ViewCreator<V extends View> {
    @NonNull
    V createView(Context r10, ViewGroup r11);
}
