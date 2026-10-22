package com.android.ttcjpaysdk.base.framework.container.view.base.abs;

import android.graphics.Color;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", "", "getBaseUiInfo", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;", "parseColor", "", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IViewUiInfo {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int parseColor(IViewUiInfo r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "$receiver");
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
            return Color.parseColor(r101);
        L5:
            th = move-exception;
            Result.Companion r103 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            return ColorProtector.parseColor(CustomHeaderConfig.COLOR_DARK);
        }
    }

    BaseViewUiInfo getBaseUiInfo();

    int parseColor(String r100);
}
