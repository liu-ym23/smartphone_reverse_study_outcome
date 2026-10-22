package com.bytedance.android.livesdkapi.depend.live;

import android.os.Bundle;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J$\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/IBackRoomStack;", "", "clear", "", "peekRoomInfo", "Landroid/os/Bundle;", "popRoomInfo", "pushRoomInfo", "info", "refInfo", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/livesdkapi/depend/live/StackContext;", "size", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBackRoomStack {
    void clear();

    Bundle peekRoomInfo();

    Bundle popRoomInfo();

    void pushRoomInfo(Bundle r100, Bundle r101, StackContext r102);

    int size();
}
