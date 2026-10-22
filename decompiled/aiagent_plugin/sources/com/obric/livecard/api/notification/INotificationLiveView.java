package com.obric.livecard.api.notification;

import android.view.View;
import com.obric.livecard.api.LiveCardType;
import com.obric.livecard.api.entity.IslandWidget;

/* JADX INFO: compiled from: INotificationLiveView.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface INotificationLiveView {
    LiveCardType getLiveCardType();

    View getView();

    IslandWidget getWidget();

    long getWidgetId();
}
