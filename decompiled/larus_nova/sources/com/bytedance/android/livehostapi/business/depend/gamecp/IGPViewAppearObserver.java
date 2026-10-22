package com.bytedance.android.livehostapi.business.depend.gamecp;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JN\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052:\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\u0007j\u0002`\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\bH&¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGPViewAppearObserver;", "", "attachViewAppearObserver", "", "view", "Landroid/view/View;", "appearObserver", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isAppear", "", "duration", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/OnAppearObserver;", "detachViewAppearObserver", "viewIsWillDetached", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGPViewAppearObserver {
    void attachViewAppearObserver(View r100, Function2<? super Boolean, ? super Float, Unit> r101);

    void detachViewAppearObserver();

    boolean viewIsWillDetached();
}
