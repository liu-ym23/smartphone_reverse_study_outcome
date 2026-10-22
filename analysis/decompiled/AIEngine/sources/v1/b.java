package v1;

import android.database.Cursor;
import androidx.datastore.preferences.protobuf.b1;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import gc.o;
import java.util.ListIterator;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {
    public static final void a(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        ListBuilder listBuilderY = b1.y();
        Cursor cursorO0 = frameworkSQLiteDatabase.o0("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cursorO0.moveToNext()) {
            try {
                listBuilderY.add(cursorO0.getString(0));
            } finally {
            }
        }
        n nVar = n.f10413a;
        cursorO0.close();
        ListIterator listIterator = b1.i(listBuilderY).listIterator(0);
        while (true) {
            ListBuilder.a aVar = (ListBuilder.a) listIterator;
            if (!aVar.hasNext()) {
                return;
            }
            String triggerName = (String) aVar.next();
            g.e(triggerName, "triggerName");
            if (o.k0(triggerName, "room_fts_content_sync_", false)) {
                frameworkSQLiteDatabase.n("DROP TRIGGER IF EXISTS ".concat(triggerName));
            }
        }
    }
}
