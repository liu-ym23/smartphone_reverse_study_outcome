package com.android.server.wm.utils;

import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public class AlwaysTruePredicate implements Predicate<Object> {
    public static final AlwaysTruePredicate INSTANCE = null;

    static {
        INSTANCE = new AlwaysTruePredicate();
    }

    private AlwaysTruePredicate() {
    }

    @Override // java.util.function.Predicate
    public boolean test(Object o) {
        return true;
    }
}
