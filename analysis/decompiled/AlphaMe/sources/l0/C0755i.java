package l0;

import android.database.sqlite.SQLiteStatement;
import androidx.room.v;
import k0.j;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: l0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0755i extends v implements j {

    /* renamed from: c, reason: collision with root package name */
    public final SQLiteStatement f13452c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0755i(SQLiteStatement delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f13452c = delegate;
    }

    @Override // k0.j
    public final long executeInsert() {
        return this.f13452c.executeInsert();
    }

    @Override // k0.j
    public final int executeUpdateDelete() {
        return this.f13452c.executeUpdateDelete();
    }
}
