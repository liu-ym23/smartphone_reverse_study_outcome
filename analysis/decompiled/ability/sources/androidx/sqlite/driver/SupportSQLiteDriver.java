package androidx.sqlite.driver;

import B7.a;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.core.JsonPointer;
import j9.m;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078WX\u0096\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\n¨\u0006\u000f"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteDriver;", "Landroidx/sqlite/SQLiteDriver;", "openHelper", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", AppAgent.CONSTRUCT, "(Landroidx/sqlite/db/SupportSQLiteOpenHelper;)V", "hasConnectionPool", "", "hasConnectionPool$annotations", "()V", "()Z", "open", "Landroidx/sqlite/driver/SupportSQLiteConnection;", "fileName", "", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SupportSQLiteDriver implements SQLiteDriver {
    private final SupportSQLiteOpenHelper openHelper;

    public SupportSQLiteDriver(SupportSQLiteOpenHelper openHelper) {
        k.f(openHelper, "openHelper");
        this.openHelper = openHelper;
    }

    public static /* synthetic */ void hasConnectionPool$annotations() {
    }

    @Override // androidx.sqlite.SQLiteDriver
    public boolean hasConnectionPool() {
        return true;
    }

    @Override // androidx.sqlite.SQLiteDriver
    public SupportSQLiteConnection open(String fileName) {
        k.f(fileName, "fileName");
        String name = this.openHelper.getName();
        if (name == null) {
            if (!fileName.equals(":memory:")) {
                throw new IllegalArgumentException(a.m("This driver is configured to open an in-memory database but a file-based named '", fileName, "' was requested.").toString());
            }
        } else if (!name.equals(fileName) && !m.I0(JsonPointer.SEPARATOR, name, name).equals(m.I0(JsonPointer.SEPARATOR, fileName, fileName))) {
            throw new IllegalArgumentException(("This driver is configured to open a database named '" + this.openHelper.getName() + "' but '" + fileName + "' was requested.").toString());
        }
        return new SupportSQLiteConnection(this.openHelper.getWritableDatabase());
    }
}
