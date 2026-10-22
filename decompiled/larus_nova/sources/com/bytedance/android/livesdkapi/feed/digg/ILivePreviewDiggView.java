package com.bytedance.android.livesdkapi.feed.digg;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u000f\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/digg/ILivePreviewDiggView;", "", "addOnLayoutChangeListener", "", "listener", "Landroid/view/View$OnLayoutChangeListener;", "getLocationOnScreen", "", "getViewWidth", "", "()Ljava/lang/Integer;", "removeOnLayoutChangeListener", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePreviewDiggView {
    void addOnLayoutChangeListener(View.OnLayoutChangeListener r100);

    int[] getLocationOnScreen();

    Integer getViewWidth();

    void removeOnLayoutChangeListener(View.OnLayoutChangeListener r100);
}
