package net.sqlcipher.database;

import j1.InterfaceC4757d;

/* loaded from: classes5.dex */
public class SupportFactory implements InterfaceC4757d.c {
    private final boolean clearPassphrase;
    private final SQLiteDatabaseHook hook;
    private final byte[] passphrase;

    public SupportFactory(byte[] bArr) {
        this(bArr, null);
    }

    @Override // j1.InterfaceC4757d.c
    public InterfaceC4757d create(InterfaceC4757d.b bVar) {
        return new SupportHelper(bVar, this.passphrase, this.hook, this.clearPassphrase);
    }

    public SupportFactory(byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(bArr, sQLiteDatabaseHook, true);
    }

    public SupportFactory(byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z10) {
        this.passphrase = bArr;
        this.hook = sQLiteDatabaseHook;
        this.clearPassphrase = z10;
    }
}
