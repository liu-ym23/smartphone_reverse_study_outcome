package org.greenrobot.eventbus;

/* JADX INFO: loaded from: classes4.dex */
final class Subscription {
    volatile boolean active;
    final Object subscriber;
    final SubscriberMethod subscriberMethod;

    public Subscription(Object r10, SubscriberMethod r11) {
        this.subscriber = r10;
        this.subscriberMethod = r11;
        this.active = true;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof Subscription) == false) goto L10;
        Subscription r11 = (Subscription) r10;
        if (this.subscriber == r11.subscriber) goto L7;
        return false;
    L7:
        if (this.subscriberMethod.equals(r11.subscriberMethod) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        return this.subscriber.hashCode() + this.subscriberMethod.methodString.hashCode();
    }
}
