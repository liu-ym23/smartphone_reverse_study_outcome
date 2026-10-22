package com.android.server.textservices;

import android.view.textservice.SpellCheckerInfo;
import com.android.server.LocalServices;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TextServicesManagerInternal {
    private static final TextServicesManagerInternal NOP = null;

    public abstract SpellCheckerInfo getCurrentSpellCheckerForUser(int r1);

    public TextServicesManagerInternal() {
    }

    static {
        NOP = new AnonymousClass1();
    }

    public static TextServicesManagerInternal get() {
        TextServicesManagerInternal instance = (TextServicesManagerInternal) LocalServices.getService(TextServicesManagerInternal.class);
        if (instance == null) goto L6;
        return instance;
    L6:
        return NOP;
    }
}
