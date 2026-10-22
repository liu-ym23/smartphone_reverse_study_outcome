package androidx.work.impl.utils;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.model.WorkTypeConverters;
import com.alipay.sdk.m.u.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes28.dex */
public final class RawQueries {
    private RawQueries() {
    }

    public static SupportSQLiteQuery workQueryToRawQuery(WorkQuery r100) {
        ArrayList r101 = new ArrayList();
        StringBuilder r102 = new StringBuilder("SELECT * FROM workspec");
        List<WorkInfo.State> r103 = r100.getStates();
        String r104 = " AND";
        if (r103.isEmpty() == true) goto L9;
        ArrayList r105 = new ArrayList(r103.size());
        Iterator<WorkInfo.State> r106 = r103.iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        r105.add(Integer.valueOf(WorkTypeConverters.stateToInt(r106.next())));
        goto L6
    L8:
        r102.append(" WHERE state IN (");
        bindings(r102, r105.size());
        r102.append(")");
        r101.addAll(r105);
        String r107 = " AND";
    L10:
        List<UUID> r108 = r100.getIds();
        if (r108.isEmpty() == true) goto L17;
        ArrayList r109 = new ArrayList(r108.size());
        Iterator<UUID> r110 = r108.iterator();
    L14:
        if (r110.hasNext() == false) goto L16;
        r109.add(r110.next().toString());
        goto L14
    L16:
        r102.append(r107);
        r102.append(" id IN (");
        bindings(r102, r108.size());
        r102.append(")");
        r101.addAll(r109);
        r107 = " AND";
    L17:
        List<String> r111 = r100.getTags();
        if (r111.isEmpty() == true) goto L20;
        r102.append(r107);
        r102.append(" id IN (SELECT work_spec_id FROM worktag WHERE tag IN (");
        bindings(r102, r111.size());
        r102.append("))");
        r101.addAll(r111);
    L21:
        List<String> r112 = r100.getUniqueWorkNames();
        if (r112.isEmpty() == true) goto L24;
        r102.append(r104);
        r102.append(" id IN (SELECT work_spec_id FROM workname WHERE name IN (");
        bindings(r102, r112.size());
        r102.append("))");
        r101.addAll(r112);
    L24:
        r102.append(i.f25853b);
        return new SimpleSQLiteQuery(r102.toString(), r101.toArray());
    L20:
        r104 = r107;
        goto L21
    L9:
        r107 = " WHERE";
        goto L10
    }

    private static void bindings(StringBuilder r100, int r101) {
        if (r101 > 0) goto L4;
        return;
    L4:
        r100.append("?");
        int r102 = 1;
    L5:
        if (r102 >= r101) goto L7;
        r100.append(",");
        r100.append("?");
        r102 = r102 + 1;
        goto L5
    }
}
