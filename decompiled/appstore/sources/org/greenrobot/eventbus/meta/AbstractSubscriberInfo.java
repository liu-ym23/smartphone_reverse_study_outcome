package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractSubscriberInfo implements SubscriberInfo {
    private final boolean shouldCheckSuperclass;
    private final Class subscriberClass;
    private final Class<? extends SubscriberInfo> superSubscriberInfoClass;

    public AbstractSubscriberInfo(Class r10, Class<? extends SubscriberInfo> r11, boolean r12) {
        this.subscriberClass = r10;
        this.superSubscriberInfoClass = r11;
        this.shouldCheckSuperclass = r12;
    }

    public SubscriberMethod createSubscriberMethod(String r10, Class<?> r11) {
        return createSubscriberMethod(r10, r11, ThreadMode.POSTING, 0, false);
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public Class getSubscriberClass() {
        return this.subscriberClass;
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public SubscriberInfo getSuperSubscriberInfo() {
        Class<? extends SubscriberInfo> r10 = this.superSubscriberInfoClass;
        if (r10 != null) goto L16;
        return null;
    L16:
        return r10.newInstance();
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public boolean shouldCheckSuperclass() {
        return this.shouldCheckSuperclass;
    }

    public SubscriberMethod createSubscriberMethod(String r10, Class<?> r11, ThreadMode r12) {
        return createSubscriberMethod(r10, r11, r12, 0, false);
    }

    public SubscriberMethod createSubscriberMethod(String r10, Class<?> r11, ThreadMode r12, int r13, boolean r14) {
        return new SubscriberMethod(this.subscriberClass.getDeclaredMethod(r10, new Class[]{r11}), r11, r12, r13, r14);
    L4:
        e = move-exception;
        throw new EventBusException("Could not find subscriber method in " + this.subscriberClass + ". Maybe a missing ProGuard rule?", e);
    }
}
