package l2;

import android.database.sqlite.SQLiteDatabase;
import l2.B;

/* loaded from: classes2.dex */
public final /* synthetic */ class y implements B.b {

    /* renamed from: a, reason: collision with root package name */
    public final String f36941a;

    public y(String str) {
        this.f36941a = str;
    }

    public static B.b a(String str) {
        return new y(str);
    }

    @Override // l2.B.b
    public Object apply(Object obj) {
        return B.b1(this.f36941a, (SQLiteDatabase) obj);
    }
}
