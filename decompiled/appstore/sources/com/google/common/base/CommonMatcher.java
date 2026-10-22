package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
abstract class CommonMatcher {
    public CommonMatcher() {
    }

    public abstract int end();

    public abstract boolean find();

    public abstract boolean find(int r10);

    public abstract boolean matches();

    public abstract String replaceAll(String r10);

    public abstract int start();
}
