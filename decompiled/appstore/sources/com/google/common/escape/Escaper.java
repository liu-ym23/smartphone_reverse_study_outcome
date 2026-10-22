package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class Escaper {
    private final Function<String, String> asFunction;

    public Escaper() {
        this.asFunction = new AnonymousClass1(this);
    }

    public final Function<String, String> asFunction() {
        return this.asFunction;
    }

    public abstract String escape(String r10);
}
