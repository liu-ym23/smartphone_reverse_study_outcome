package l2;

import android.database.sqlite.SQLiteDatabase;
import l2.B;

/* loaded from: classes2.dex */
public final /* synthetic */ class m implements B.b {

    /* renamed from: a, reason: collision with root package name */
    public final long f36925a;

    public m(long j10) {
        this.f36925a = j10;
    }

    public static B.b a(long j10) {
        return new m(j10);
    }

    @Override // l2.B.b
    public Object apply(Object obj) {
        return Integer.valueOf(((SQLiteDatabase) obj).delete("events", "timestamp_ms < ?", new String[]{String.valueOf(this.f36925a)}));
    }
}
