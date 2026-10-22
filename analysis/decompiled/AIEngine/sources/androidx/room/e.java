package androidx.room;

import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class e extends SharedSQLiteStatement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(RoomDatabase database, int i10) {
        super(database);
        switch (i10) {
            case 1:
                kotlin.jvm.internal.g.f(database, "database");
                super(database);
                break;
            default:
                kotlin.jvm.internal.g.f(database, "database");
                break;
        }
    }

    public abstract void e(y1.f fVar, Object obj);

    public void f(Object obj) {
        y1.f fVarA = a();
        try {
            e(fVarA, obj);
            fVarA.r();
        } finally {
            d(fVarA);
        }
    }

    public void g(List entities) {
        kotlin.jvm.internal.g.f(entities, "entities");
        y1.f fVarA = a();
        try {
            Iterator it = entities.iterator();
            while (it.hasNext()) {
                e(fVarA, it.next());
                fVarA.r();
            }
        } finally {
            d(fVarA);
        }
    }

    public void h(Object obj) {
        y1.f fVarA = a();
        try {
            e(fVarA, obj);
            fVarA.U();
        } finally {
            d(fVarA);
        }
    }
}
