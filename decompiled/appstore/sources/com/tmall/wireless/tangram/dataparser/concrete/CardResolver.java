package com.tmall.wireless.tangram.dataparser.concrete;

import com.tmall.wireless.tangram.core.resolver.ClassResolver;

/* JADX INFO: loaded from: classes4.dex */
public class CardResolver extends ClassResolver<Card> {
    public CardResolver() {
    }

    public boolean hasType(int r10) {
        if (this.mSparseArray.get(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
