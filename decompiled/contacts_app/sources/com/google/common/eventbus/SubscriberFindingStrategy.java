package com.google.common.eventbus;

import com.google.common.collect.Multimap;

/* JADX INFO: loaded from: classes2.dex */
interface SubscriberFindingStrategy {
    Multimap<Class<?>, EventSubscriber> findAllSubscribers(Object r1);
}
