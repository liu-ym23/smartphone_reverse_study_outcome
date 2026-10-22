package com.bytedance.android.livesdkapi.feedback;

import android.view.View;
import com.bytedance.map.api.monitor.MapMonitorConst;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001e\u0010\u0006\u001a\u00020\u00032\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/feedback/ILiveFeedbackView;", "", MapMonitorConst.EVENT_DESTROY, "", "getView", "Landroid/view/View;", "loadView", "info", "", "", "updateLayputParams", "width", "", "height", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveFeedbackView {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void updateLayputParams(ILiveFeedbackView r100, int r101, int r102) {
        }
    }

    void destroy();

    View getView();

    void loadView(Map<String, ? extends Object> r100);

    void updateLayputParams(int r100, int r101);
}
