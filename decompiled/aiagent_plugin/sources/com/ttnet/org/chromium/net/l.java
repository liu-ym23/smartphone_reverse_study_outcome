package com.ttnet.org.chromium.net;

import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: InlineExecutionProhibitedException.java */
/* JADX INFO: loaded from: classes4.dex */
public final class l extends RejectedExecutionException {
    public l() {
        super("Inline execution is prohibited for this request");
    }
}
