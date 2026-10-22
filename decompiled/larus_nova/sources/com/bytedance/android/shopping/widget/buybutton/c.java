package com.bytedance.android.shopping.widget.buybutton;

import android.view.View;
import com.bytedance.android.ec.model.ClickButtonParam;
import com.bytedance.android.ec.model.SingleClickParam;
import com.bytedance.android.ec.model.promotion.ECResultDialogContentVO;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void a(c r100, String r101, Integer r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 2) == 0) goto L8;
            r102 = null;
        L8:
            r100.h(r101, r102);
        }
    }

    void a(SingleClickParam r100, ClickButtonParam r101, com.bytedance.android.btm.api.model.d r102);

    void b(String r100, Map<String, String> r101, Map<String, String> r102);

    void c(com.bytedance.android.shopping.widget.buybutton.a r100);

    void d(ECResultDialogContentVO r100);

    void e(int r100, long r101);

    void f(String r100);

    void g(String r100);

    void h(String r100, Integer r101);

    boolean openMiniApp(String r100);

    void setBuyButtonClickListener(List<? extends View.OnClickListener> r100);

    void setProductAreaVisible(boolean r100);

    void setProductTitleClickListener(View.OnClickListener r100);
}
