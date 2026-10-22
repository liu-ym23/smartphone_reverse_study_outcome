package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.SubscriberMethod;

/* JADX INFO: loaded from: classes4.dex */
public class SimpleSubscriberInfo extends AbstractSubscriberInfo {
    private final SubscriberMethodInfo[] methodInfos;

    public SimpleSubscriberInfo(Class r10, boolean r11, SubscriberMethodInfo[] r12) {
        super(r10, null, r11);
        this.methodInfos = r12;
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public synchronized SubscriberMethod[] getSubscriberMethods() {
        monitor-enter(this);
        int r10 = this.methodInfos.length;     // Catch: Throwable -> L7
        SubscriberMethod[] r11 = new SubscriberMethod[r10];     // Catch: Throwable -> L7
        int r12 = 0;
    L4:
        if (r12 >= r10) goto L9;
        SubscriberMethodInfo r13 = this.methodInfos[r12];     // Catch: Throwable -> L7
        r11[r12] = createSubscriberMethod(r13.methodName, r13.eventType, r13.threadMode, r13.priority, r13.sticky);     // Catch: Throwable -> L7
        r12 = r12 + 1;
        goto L4
    L9:
        monitor-exit(this);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }
}
