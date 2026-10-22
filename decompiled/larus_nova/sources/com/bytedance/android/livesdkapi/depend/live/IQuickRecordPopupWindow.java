package com.bytedance.android.livesdkapi.depend.live;

import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J+\u0010\f\u001a\u00020\t2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\t0\u000eH&J*\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/IQuickRecordPopupWindow;", "", "recordTimes", "", "getRecordTimes", "()J", "setRecordTimes", "(J)V", "dismiss", "", "isShowing", "", "setDismissListener", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "showAtLocation", "parent", "Landroid/view/View;", GXTemplateKey.GAIAX_LAYER_GRAVITY, "", "x", "y", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IQuickRecordPopupWindow {
    void dismiss();

    long getRecordTimes();

    boolean isShowing();

    void setDismissListener(Function1<? super Long, Unit> r100);

    void setRecordTimes(long r100);

    void showAtLocation(View r100, int r101, int r102, int r103);
}
