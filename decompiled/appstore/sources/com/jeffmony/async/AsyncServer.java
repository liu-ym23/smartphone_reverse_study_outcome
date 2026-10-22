package com.jeffmony.async;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AsyncServer {

    public static class AsyncSelectorException extends IOException {
        public AsyncSelectorException(Exception r10) {
            super(r10);
        }
    }
}
