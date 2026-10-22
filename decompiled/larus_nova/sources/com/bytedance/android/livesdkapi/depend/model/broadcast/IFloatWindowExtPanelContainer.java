package com.bytedance.android.livesdkapi.depend.model.broadcast;

import android.content.Context;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/IFloatWindowExtPanelContainer;", "", "genFloatWindowContainerView", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "handleFloatWindowControl", "", "controlCmd", "", "controlExtra", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IFloatWindowExtPanelContainer {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void handleFloatWindowControl$default(IFloatWindowExtPanelContainer r100, int r101, Object r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.handleFloatWindowControl(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleFloatWindowControl");
        }
    }

    ViewGroup genFloatWindowContainerView(Context r100);

    void handleFloatWindowControl(int r100, Object r101);
}
