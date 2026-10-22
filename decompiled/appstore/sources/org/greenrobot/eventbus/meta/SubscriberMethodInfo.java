package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes4.dex */
public class SubscriberMethodInfo {
    final Class<?> eventType;
    final String methodName;
    final int priority;
    final boolean sticky;
    final ThreadMode threadMode;

    public SubscriberMethodInfo(String r10, Class<?> r11, ThreadMode r12, int r13, boolean r14) {
        this.methodName = r10;
        this.threadMode = r12;
        this.eventType = r11;
        this.priority = r13;
        this.sticky = r14;
    }

    public SubscriberMethodInfo(String r10, Class<?> r11) {
        this(r10, r11, ThreadMode.POSTING, 0, false);
    }

    public SubscriberMethodInfo(String r10, Class<?> r11, ThreadMode r12) {
        this(r10, r11, r12, 0, false);
    }
}
