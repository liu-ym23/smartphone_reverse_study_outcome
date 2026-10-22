package com.google.crypto.tink;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.CopyOnWriteArrayList;
import w2.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class KmsClients {
    private static List<KmsClient> autoClients;
    private static final CopyOnWriteArrayList<KmsClient> clients = new CopyOnWriteArrayList<>();

    private KmsClients() {
    }

    public static void add(KmsClient kmsClient) {
        clients.add(kmsClient);
    }

    public static KmsClient get(String str) throws GeneralSecurityException {
        Iterator<KmsClient> it = clients.iterator();
        while (it.hasNext()) {
            KmsClient next = it.next();
            if (next.doesSupport(str)) {
                return next;
            }
        }
        throw new GeneralSecurityException(c.b("No KMS client does support: ", str));
    }

    public static synchronized KmsClient getAutoLoaded(String str) {
        KmsClient next;
        try {
            if (autoClients == null) {
                autoClients = loadAutoKmsClients();
            }
            Iterator<KmsClient> it = autoClients.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (next.doesSupport(str)) {
                }
            }
            throw new GeneralSecurityException("No KMS client does support: " + str);
        } catch (Throwable th) {
            throw th;
        }
        return next;
    }

    private static List<KmsClient> loadAutoKmsClients() {
        ArrayList arrayList = new ArrayList();
        Iterator it = ServiceLoader.load(KmsClient.class).iterator();
        while (it.hasNext()) {
            arrayList.add((KmsClient) it.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static void reset() {
        clients.clear();
    }
}
