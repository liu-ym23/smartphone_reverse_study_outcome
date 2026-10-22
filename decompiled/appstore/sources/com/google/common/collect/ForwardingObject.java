package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class ForwardingObject {
    public ForwardingObject() {
    }

    public abstract Object delegate();

    public String toString() {
        return delegate().toString();
    }
}
