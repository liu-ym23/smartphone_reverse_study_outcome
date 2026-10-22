package org.greenrobot.eventbus.util;

import android.content.res.Resources;
import android.util.Log;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes4.dex */
public class ErrorDialogConfig {
    int defaultDialogIconId;
    final int defaultErrorMsgId;
    Class<?> defaultEventTypeOnDialogClosed;
    final int defaultTitleId;
    EventBus eventBus;
    boolean logExceptions;
    final ExceptionToResourceMapping mapping;
    final Resources resources;
    String tagForLoggingExceptions;

    public ErrorDialogConfig(Resources r10, int r11, int r12) {
        this.logExceptions = true;
        this.resources = r10;
        this.defaultTitleId = r11;
        this.defaultErrorMsgId = r12;
        this.mapping = new ExceptionToResourceMapping();
    }

    public ErrorDialogConfig addMapping(Class<? extends Throwable> r10, int r11) {
        this.mapping.addMapping(r10, r11);
        return this;
    }

    public void disableExceptionLogging() {
        this.logExceptions = false;
    }

    public EventBus getEventBus() {
        EventBus r10 = this.eventBus;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return EventBus.getDefault();
    }

    public int getMessageIdForThrowable(Throwable r10) {
        Integer r11 = this.mapping.mapThrowable(r10);
        if (r11 != null) goto L5;
        Log.d(EventBus.TAG, "No specific message ressource ID found for " + r10);
        return this.defaultErrorMsgId;
    L5:
        return r11.intValue();
    }

    public void setDefaultDialogIconId(int r10) {
        this.defaultDialogIconId = r10;
    }

    public void setDefaultEventTypeOnDialogClosed(Class<?> r10) {
        this.defaultEventTypeOnDialogClosed = r10;
    }

    public void setEventBus(EventBus r10) {
        this.eventBus = r10;
    }

    public void setTagForLoggingExceptions(String r10) {
        this.tagForLoggingExceptions = r10;
    }
}
