package aj5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.middleground.unbundle.cache.db.BenefitDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM BenefitData WHERE owner_id NOT IN (  SELECT owner_id   FROM BenefitData   ORDER BY update_time DESC   LIMIT 100)";
    }

    public d(BenefitDatabase r100) {
        super(r100);
    }
}
