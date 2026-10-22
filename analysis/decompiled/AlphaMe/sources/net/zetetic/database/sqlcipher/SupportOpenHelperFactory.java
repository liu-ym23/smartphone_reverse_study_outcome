package net.zetetic.database.sqlcipher;

import androidx.annotation.NonNull;
import k0.e;
import k0.f;
import k0.g;

/* loaded from: classes2.dex */
public class SupportOpenHelperFactory implements f {
    private static final int UNCHANGED = -1;
    private final boolean enableWriteAheadLogging;
    private final SQLiteDatabaseHook hook;
    private final int minimumSupportedVersion;
    private final byte[] password;

    public SupportOpenHelperFactory(byte[] bArr) {
        this(bArr, null, false);
    }

    @Override // k0.f
    @NonNull
    public g create(@NonNull e eVar) {
        int i4 = this.minimumSupportedVersion;
        return i4 == -1 ? new SupportHelper(eVar, this.password, this.hook, this.enableWriteAheadLogging) : new SupportHelper(eVar, this.password, this.hook, this.enableWriteAheadLogging, i4);
    }

    public SupportOpenHelperFactory(byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z4) {
        this(bArr, sQLiteDatabaseHook, z4, -1);
    }

    public SupportOpenHelperFactory(byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z4, int i4) {
        this.password = bArr;
        this.hook = sQLiteDatabaseHook;
        this.enableWriteAheadLogging = z4;
        this.minimumSupportedVersion = i4;
    }
}
