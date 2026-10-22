package k1;

import android.database.sqlite.SQLiteStatement;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lk1/j;", "Lk1/i;", "Lj1/h;", "Landroid/database/sqlite/SQLiteStatement;", "delegate", "<init>", "(Landroid/database/sqlite/SQLiteStatement;)V", "LY8/t;", "execute", "()V", Const.INTENT_KEY_PKGNAME, "Landroid/database/sqlite/SQLiteStatement;", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: k1.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4808j extends C4807i implements j1.h {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final SQLiteStatement delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4808j(SQLiteStatement delegate) {
        super(delegate);
        p.i(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // j1.h
    public void execute() {
        this.delegate.execute();
    }
}
