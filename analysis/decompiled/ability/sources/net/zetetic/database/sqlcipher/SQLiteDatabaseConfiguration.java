package net.zetetic.database.sqlcipher;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class SQLiteDatabaseConfiguration {

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f5399j = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");

    /* renamed from: a, reason: collision with root package name */
    public final String f5400a;
    public final String b;
    public int c;
    public int d;
    public Locale e;
    public boolean f;
    public byte[] g;
    public SQLiteDatabaseHook h;
    public final ArrayList i;

    public SQLiteDatabaseConfiguration(String str, int i) {
        this(str, i, null, null);
    }

    public final void a(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        if (sQLiteDatabaseConfiguration == null) {
            throw new IllegalArgumentException("other must not be null.");
        }
        if (!this.f5400a.equals(sQLiteDatabaseConfiguration.f5400a)) {
            throw new IllegalArgumentException("other configuration must refer to the same database.");
        }
        this.c = sQLiteDatabaseConfiguration.c;
        this.d = sQLiteDatabaseConfiguration.d;
        this.e = sQLiteDatabaseConfiguration.e;
        this.f = sQLiteDatabaseConfiguration.f;
        this.g = sQLiteDatabaseConfiguration.g;
        this.h = sQLiteDatabaseConfiguration.h;
        ArrayList arrayList = this.i;
        arrayList.clear();
        arrayList.addAll(sQLiteDatabaseConfiguration.i);
    }

    public SQLiteDatabaseConfiguration(String str, int i, byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this.i = new ArrayList();
        if (str == null) {
            throw new IllegalArgumentException("path must not be null.");
        }
        this.f5400a = str;
        int iIndexOf = str.indexOf(63);
        str = iIndexOf >= 0 ? (String) str.subSequence(0, iIndexOf) : str;
        this.b = str.indexOf(64) != -1 ? f5399j.matcher(str).replaceAll("XX@YY") : str;
        this.c = i;
        this.g = bArr;
        this.h = sQLiteDatabaseHook;
        this.d = 25;
        this.e = Locale.getDefault();
    }

    public SQLiteDatabaseConfiguration(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        this.i = new ArrayList();
        if (sQLiteDatabaseConfiguration != null) {
            this.f5400a = sQLiteDatabaseConfiguration.f5400a;
            this.b = sQLiteDatabaseConfiguration.b;
            a(sQLiteDatabaseConfiguration);
            return;
        }
        throw new IllegalArgumentException("other must not be null.");
    }
}
