package com.bytedance.android.livesdkapi.room.handler;

import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.ILayoutConstraint;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.ViewGroupId;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconModel;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J \u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\n*\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH&J\b\u0010\r\u001a\u00020\tH'J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0010H&J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010 \u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"H&¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomViewHandler;", "", "findViewGroupById", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IExternalViewGroup;", "id", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/constraint/ViewGroupId;", "getToolbarButtonNames", "", "loadIconModel", "", "M", "iconModel", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/sti/IExternalIconModel;", "loadLegacyModel", "provideToolbarButton", "button", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IExternalButton;", "constraint", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/constraint/ILayoutConstraint;", "provideWidget", "widget", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IExternalWidget;", "registerToolbarButtonView", "viewProvider", "registerToolbarLoadFilter", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "loadFilter", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/ToolbarComponentCheckInterface;", "removeToolbarButton", "removeWidget", "requestDismiss", "requestShow", "requestWidgetHeight", "contentHeight", "", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveRoomViewHandler {
    IExternalViewGroup findViewGroupById(ViewGroupId r100);

    String getToolbarButtonNames();

    <M> void loadIconModel(IExternalIconModel<M> r100);

    @Deprecated(message = "历史优惠券, 大概率不会再迭代了")
    void loadLegacyModel();

    void provideToolbarButton(IExternalButton r100, ILayoutConstraint r101);

    void provideWidget(IExternalWidget r100, ILayoutConstraint r101);

    void registerToolbarButtonView(IExternalButton r100);

    void registerToolbarLoadFilter(NewToolbarButtonConstants r100, ToolbarComponentCheckInterface r101);

    void removeToolbarButton(IExternalButton r100, ILayoutConstraint r101);

    void removeWidget(IExternalWidget r100, ILayoutConstraint r101);

    void requestDismiss(IExternalButton r100);

    void requestDismiss(IExternalWidget r100);

    void requestShow(IExternalButton r100);

    void requestShow(IExternalWidget r100);

    void requestWidgetHeight(IExternalWidget r100, int r101);
}
