package com.obric.capabilitykit.common.intent;

import d.h.b.o;

/* JADX INFO: loaded from: classes3.dex */
public final class MatchException {

    public static final class NoDefineIntentException extends Exception {
        public NoDefineIntentException(String r2) {
            o.e(r2, "message");
            super(r2);
        }
    }

    public static final class NoImplException extends Exception {
        public NoImplException(String r2) {
            o.e(r2, "message");
            super(r2);
        }
    }

    public static final class UnKnownException extends Exception {
        public UnKnownException(String r2) {
            o.e(r2, "message");
            super(r2);
        }
    }

    public MatchException() {
    }
}
