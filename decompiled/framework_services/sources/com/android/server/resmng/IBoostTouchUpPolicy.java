package com.android.server.resmng;

/* JADX INFO: loaded from: classes3.dex */
public interface IBoostTouchUpPolicy {
    default boolean shouldSkipTouchUpBoost() {
        return false;
    }
}
