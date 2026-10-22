package com.google.crypto.tink;

import java.security.GeneralSecurityException;
import w2.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class KeyTemplates {
    private KeyTemplates() {
    }

    public static KeyTemplate get(String str) {
        KeyTemplate keyTemplate = Registry.keyTemplateMap().get(str);
        if (keyTemplate != null) {
            return keyTemplate;
        }
        throw new GeneralSecurityException(c.b("cannot find key template: ", str));
    }
}
