package aj5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.middleground.unbundle.cache.db.BenefitDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends EntityInsertionAdapter<a> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `BenefitData` (`cache_key`,`owner_id`,`source_benefit`,`update_time`) VALUES (?,?,?,?)";
    }

    public c(BenefitDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, a r101) {
        a r102 = r101;
        String r103 = r102.f3925a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f3926b;
        if (r104 != null) goto L9;
        r100.bindNull(2);
    L10:
        String r105 = r102.f3927c;
        if (r105 != null) goto L13;
        r100.bindNull(3);
    L14:
        Long r106 = r102.f3928d;
        if (r106 != null) goto L17;
        r100.bindNull(4);
        return;
    L17:
        r100.bindLong(4, r106.longValue());
        return;
    L13:
        r100.bindString(3, r105);
        goto L14
    L9:
        r100.bindString(2, r104);
        goto L10
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
