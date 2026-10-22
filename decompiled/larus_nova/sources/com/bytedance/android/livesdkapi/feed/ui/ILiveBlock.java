package com.bytedance.android.livesdkapi.feed.ui;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/ui/ILiveBlock;", "", "isEmpty", "Landroidx/lifecycle/LiveData;", "", "isError", "refresh", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveBlock {
    LiveData<Boolean> isEmpty();

    LiveData<Boolean> isError();

    void refresh();
}
