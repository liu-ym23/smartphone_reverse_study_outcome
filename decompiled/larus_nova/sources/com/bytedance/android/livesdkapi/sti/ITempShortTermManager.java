package com.bytedance.android.livesdkapi.sti;

import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.live.ShortTermIndicatorConfig;
import com.bytedance.android.livesdkapi.sti.framework.IIconModel;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u000b\u001a\u00020\fH&J$\u0010\r\u001a\u00020\f2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH&J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0014\u0010\u0016\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&J\b\u0010\u0017\u001a\u00020\u0003H&J\u0014\u0010\u0018\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/ITempShortTermManager;", "", "addTempIconModel", "", "iconModel", "Lcom/bytedance/android/livesdkapi/sti/framework/IIconModel;", "changeTempWidth", "view", "Landroid/view/View;", "getTempShortTouchShowTime", "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "", "handleTempShortTerm", "showTime", "hasStrategyType", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$TempStateStrategy$TempStateStrategyInfo;", "strategyKey", "", "typeId", "initTempState", "interruptCurrentTempState", "onIconDestroy", "onIconRefresh", "showNormalState", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ITempShortTermManager {
    void addTempIconModel(IIconModel<?> r100);

    void changeTempWidth(IIconModel<?> r100, View r101);

    long getTempShortTouchShowTime(IIconModel<?> r100, int r101);

    int handleTempShortTerm(IIconModel<?> r100, int r101, long r102);

    ShortTermIndicatorConfig.TempStateStrategy.TempStateStrategyInfo hasStrategyType(String r100, int r101);

    void initTempState();

    void interruptCurrentTempState();

    void onIconDestroy(IIconModel<?> r100);

    void onIconRefresh();

    void showNormalState(IIconModel<?> r100);
}
