package com.bytedance.android.livesdkapi.feed.digg;

import android.view.MotionEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/digg/ILiveInnerDiggWidget;", "", "onDiggButtonClick", "", "onDiggTap", "event", "Landroid/view/MotionEvent;", "disableFlowDigg", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveInnerDiggWidget {
    boolean onDiggButtonClick();

    boolean onDiggTap(MotionEvent r100, boolean r101);
}
