package androidx.room;

import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import h9.InterfaceC4149a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000fJH\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032(\u0010\t\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H¦@¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH¦@¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Landroidx/room/Transactor;", "Landroidx/room/l;", "R", "Landroidx/room/Transactor$SQLiteTransactionType;", "type", "Lkotlin/Function2;", "Landroidx/room/B;", "Le9/c;", "", "block", Const.INTENT_KEY_APIKEY, "(Landroidx/room/Transactor$SQLiteTransactionType;Lp9/p;Le9/c;)Ljava/lang/Object;", "", Const.INTENT_KEY_PKGNAME, "(Le9/c;)Ljava/lang/Object;", "SQLiteTransactionType", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Transactor extends l {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/Transactor$SQLiteTransactionType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFERRED", "IMMEDIATE", "EXCLUSIVE", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SQLiteTransactionType {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ SQLiteTransactionType[] $VALUES;
        public static final SQLiteTransactionType DEFERRED = new SQLiteTransactionType("DEFERRED", 0);
        public static final SQLiteTransactionType IMMEDIATE = new SQLiteTransactionType("IMMEDIATE", 1);
        public static final SQLiteTransactionType EXCLUSIVE = new SQLiteTransactionType("EXCLUSIVE", 2);

        private static final /* synthetic */ SQLiteTransactionType[] $values() {
            return new SQLiteTransactionType[]{DEFERRED, IMMEDIATE, EXCLUSIVE};
        }

        static {
            SQLiteTransactionType[] sQLiteTransactionTypeArr$values = $values();
            $VALUES = sQLiteTransactionTypeArr$values;
            $ENTRIES = kotlin.enums.a.a(sQLiteTransactionTypeArr$values);
        }

        private SQLiteTransactionType(String str, int i10) {
        }

        public static InterfaceC4149a<SQLiteTransactionType> getEntries() {
            return $ENTRIES;
        }

        public static SQLiteTransactionType valueOf(String str) {
            return (SQLiteTransactionType) Enum.valueOf(SQLiteTransactionType.class, str);
        }

        public static SQLiteTransactionType[] values() {
            return (SQLiteTransactionType[]) $VALUES.clone();
        }
    }

    <R> Object a(SQLiteTransactionType sQLiteTransactionType, p9.p<? super B<R>, ? super InterfaceC4014c<? super R>, ? extends Object> pVar, InterfaceC4014c<? super R> interfaceC4014c);

    Object b(InterfaceC4014c<? super Boolean> interfaceC4014c);
}
