package com.google.common.escape;

import com.google.common.base.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Escaper {
    private final Function<String, String> asFunction;

    public abstract String escape(String r1);

    protected Escaper() {
        this.asFunction = new AnonymousClass1(this);
    }

    public final Function<String, String> asFunction() {
        return this.asFunction;
    }
}
