package com.stepos.core.common.notification;

import android.app.Notification;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface ForegroundHost {
    void attachForeground(int i10, Notification notification);

    void detachForeground();

    void removeForeground();
}
