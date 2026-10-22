package com.byted.cast.linkcommon.cybergarage.upnp.event;

import java.util.Vector;

/* JADX INFO: loaded from: classes28.dex */
public class SubscriberList extends Vector {
    public SubscriberList() {
    }

    public Subscriber getSubscriber(int r100) {
        Object r101 = get(r100);     // Catch: Exception -> L4
    L6:
        return (Subscriber) r101;
    L4:
        r101 = null;
        goto L6
    }
}
