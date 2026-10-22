package com.stepos.ailauncher.storage.database.cipher;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/storage/database/cipher/CipherRefusedPlaintextException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "dbName", "", "reason", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CipherRefusedPlaintextException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CipherRefusedPlaintextException(String dbName, String reason) {
        super("database " + dbName + " refused plaintext open: " + reason);
        p.i(dbName, "dbName");
        p.i(reason, "reason");
    }
}
