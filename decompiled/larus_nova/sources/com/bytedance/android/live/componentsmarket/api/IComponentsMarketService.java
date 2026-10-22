package com.bytedance.android.live.componentsmarket.api;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.utility.ServiceLookup;
import com.ss.android.lark.utils.statistics.PerfLog;
import h70.b;
import j70.h;
import j70.n;
import k40.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ServiceLookup("com.bytedance.android.live.componentsmarket.impl.ComponentsMarketService")
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0012\u0010\u0005\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H&J\u0010\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0006H&J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0010\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0014\u0010\f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nH&J\u0014\u0010\r\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nH&J\u0010\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0006H&J\u0010\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0010\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010H&J\"\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016H&J\u001a\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/componentsmarket/api/IComponentsMarketService;", "Lcom/bytedance/android/live/base/IService;", "Lj70/h;", "Lh70/b;", "getTitleTetrisDesc", "getMediaTopAreaTetrisDesc", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/Tetris;", "getTitleTetris", "getUserListTetrisDesc", "getAnchorInfoTetrisDesc", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getAnchorInfoWidget", "getUserListWidget", "getCloseRoomTetris", "getCloseRoomDescriptor", "Lj70/n;", "getLiveDetailWidgetDescriptor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/view/View;", "cardView", "", "resetPositionOnSizeChange", "Lk40/d;", "createDraggableCard", "", "text", "Landroid/app/Dialog;", "getLoadingDialog", "livecomponentsmarket-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IComponentsMarketService extends IService {
    d createDraggableCard(Context r100, View r101, boolean r102);

    h<? extends b> getAnchorInfoTetrisDesc();

    Class<? extends LiveRecyclableWidget> getAnchorInfoWidget();

    h<? extends b> getCloseRoomDescriptor();

    Tetris<? extends b> getCloseRoomTetris();

    n<? extends b> getLiveDetailWidgetDescriptor();

    Dialog getLoadingDialog(Context r100, String r101);

    h<? extends b> getMediaTopAreaTetrisDesc();

    Tetris<? extends b> getTitleTetris();

    h<? extends b> getTitleTetrisDesc();

    h<? extends b> getUserListTetrisDesc();

    Class<? extends LiveRecyclableWidget> getUserListWidget();
}
