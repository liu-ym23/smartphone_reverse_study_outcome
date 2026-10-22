package com.stepos.ailauncher.storage.database.cipher;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/storage/database/cipher/CipherKeyUnavailableException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "dbName", "", "<init>", "(Ljava/lang/String;)V", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CipherKeyUnavailableException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CipherKeyUnavailableException(String dbName) {
        super("database " + dbName + " is encrypted but the passphrase is unavailable");
        p.i(dbName, "dbName");
    }
}
