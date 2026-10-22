package com.stepos.alphame.data.local.database.dailyusage;

import Z2.I;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.A;
import androidx.room.E;
import androidx.room.G;
import androidx.room.k;
import com.stepos.alphame.data.model.dailyusage.DailyUsageEntity;
import com.stepos.statsrpk.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import k0.j;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import t0.J;

/* loaded from: classes.dex */
public final class DailyUsageDao_Impl implements DailyUsageDao {
    private final A __db;
    private final k __insertionAdapterOfDailyUsageEntity;
    private final G __preparedStmtOfClearDailyUsage;
    private final G __preparedStmtOfClearData;
    private final G __preparedStmtOfDeleteDailyUsage;

    public DailyUsageDao_Impl(@NonNull A a4) {
        this.__db = a4;
        this.__insertionAdapterOfDailyUsageEntity = new k(a4) { // from class: com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao_Impl.1
            @Override // androidx.room.G
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `daily_usage` (`id`,`date`,`mode`,`user_id`,`time_usage_path`,`screen_usage_path`,`notification_usage_path`) VALUES (?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.k
            public void bind(@NonNull j jVar, @NonNull DailyUsageEntity dailyUsageEntity) {
                jVar.bindString(1, dailyUsageEntity.getId());
                jVar.bindLong(2, dailyUsageEntity.getDate());
                jVar.bindLong(3, dailyUsageEntity.getMode());
                jVar.bindLong(4, dailyUsageEntity.getUserId());
                if (dailyUsageEntity.getTimeUsagePath() == null) {
                    jVar.bindNull(5);
                } else {
                    jVar.bindString(5, dailyUsageEntity.getTimeUsagePath());
                }
                if (dailyUsageEntity.getScreenUsagePath() == null) {
                    jVar.bindNull(6);
                } else {
                    jVar.bindString(6, dailyUsageEntity.getScreenUsagePath());
                }
                if (dailyUsageEntity.getNotificationUsagePath() == null) {
                    jVar.bindNull(7);
                } else {
                    jVar.bindString(7, dailyUsageEntity.getNotificationUsagePath());
                }
            }
        };
        this.__preparedStmtOfDeleteDailyUsage = new G(a4) { // from class: com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao_Impl.2
            @Override // androidx.room.G
            @NonNull
            public String createQuery() {
                return "DELETE FROM daily_usage WHERE user_id = ?";
            }
        };
        this.__preparedStmtOfClearDailyUsage = new G(a4) { // from class: com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao_Impl.3
            @Override // androidx.room.G
            @NonNull
            public String createQuery() {
                return "DELETE FROM daily_usage WHERE mode = ?";
            }
        };
        this.__preparedStmtOfClearData = new G(a4) { // from class: com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao_Impl.4
            @Override // androidx.room.G
            @NonNull
            public String createQuery() {
                return "DELETE FROM daily_usage";
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao
    public Object clearDailyUsage(final int i4, Continuation<? super Integer> continuation) {
        return c.s(this.__db, new Callable<Integer>() { // from class: com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao_Impl.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            @NonNull
            public Integer call() throws Exception {
                j jVarAcquire = DailyUsageDao_Impl.this.__preparedStmtOfClearDailyUsage.acquire();
                jVarAcquire.bindLong(1, i4);
                try {
                    DailyUsageDao_Impl.this.__db.beginTransaction();
                    try {
                        Integer numValueOf = Integer.valueOf(jVarAcquire.executeUpdateDelete());
                        DailyUsageDao_Impl.this.__db.setTransactionSuccessful();
                        return numValueOf;
                    } finally {
                        DailyUsageDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    DailyUsageDao_Impl.this.__preparedStmtOfClearDailyUsage.release(jVarAcquire);
                }
            }
        }, continuation);
    }

    @Override // com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao
    public Object clearData(Continuation<? super Unit> continuation) {
        return c.s(this.__db, new Callable<Unit>() { // from class: com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao_Impl.8
            @Override // java.util.concurrent.Callable
            @NonNull
            public Unit call() throws Exception {
                j jVarAcquire = DailyUsageDao_Impl.this.__preparedStmtOfClearData.acquire();
                try {
                    DailyUsageDao_Impl.this.__db.beginTransaction();
                    try {
                        jVarAcquire.executeUpdateDelete();
                        DailyUsageDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        DailyUsageDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    DailyUsageDao_Impl.this.__preparedStmtOfClearData.release(jVarAcquire);
                }
            }
        }, continuation);
    }

    @Override // com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao
    public Object deleteDailyUsage(final long j4, Continuation<? super Integer> continuation) {
        return c.s(this.__db, new Callable<Integer>() { // from class: com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao_Impl.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            @NonNull
            public Integer call() throws Exception {
                j jVarAcquire = DailyUsageDao_Impl.this.__preparedStmtOfDeleteDailyUsage.acquire();
                jVarAcquire.bindLong(1, j4);
                try {
                    DailyUsageDao_Impl.this.__db.beginTransaction();
                    try {
                        Integer numValueOf = Integer.valueOf(jVarAcquire.executeUpdateDelete());
                        DailyUsageDao_Impl.this.__db.setTransactionSuccessful();
                        return numValueOf;
                    } finally {
                        DailyUsageDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    DailyUsageDao_Impl.this.__preparedStmtOfDeleteDailyUsage.release(jVarAcquire);
                }
            }
        }, continuation);
    }

    @Override // com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao
    public DailyUsageEntity getDailyUsage(long j4, int i4, long j5) {
        E eD = E.d(3, "SELECT * FROM daily_usage WHERE date =? AND mode = ? AND user_id = ?");
        eD.bindLong(1, j4);
        eD.bindLong(2, i4);
        eD.bindLong(3, j5);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(this.__db, eD);
        try {
            int iN = I.n(cursorH, "id");
            int iN2 = I.n(cursorH, "date");
            int iN3 = I.n(cursorH, "mode");
            int iN4 = I.n(cursorH, "user_id");
            int iN5 = I.n(cursorH, "time_usage_path");
            int iN6 = I.n(cursorH, "screen_usage_path");
            int iN7 = I.n(cursorH, "notification_usage_path");
            DailyUsageEntity dailyUsageEntity = null;
            if (cursorH.moveToFirst()) {
                dailyUsageEntity = new DailyUsageEntity(cursorH.getString(iN), cursorH.getLong(iN2), cursorH.getInt(iN3), cursorH.getLong(iN4), cursorH.isNull(iN5) ? null : cursorH.getString(iN5), cursorH.isNull(iN6) ? null : cursorH.getString(iN6), cursorH.isNull(iN7) ? null : cursorH.getString(iN7));
            }
            return dailyUsageEntity;
        } finally {
            cursorH.close();
            eD.e();
        }
    }

    @Override // com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao
    public List<DailyUsageEntity> getDailyUsages(long j4, long j5) {
        E eD = E.d(2, "SELECT * FROM daily_usage WHERE date >= ? AND date < ? ORDER BY date ASC");
        eD.bindLong(1, j4);
        eD.bindLong(2, j5);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(this.__db, eD);
        try {
            int iN = I.n(cursorH, "id");
            int iN2 = I.n(cursorH, "date");
            int iN3 = I.n(cursorH, "mode");
            int iN4 = I.n(cursorH, "user_id");
            int iN5 = I.n(cursorH, "time_usage_path");
            int iN6 = I.n(cursorH, "screen_usage_path");
            int iN7 = I.n(cursorH, "notification_usage_path");
            ArrayList arrayList = new ArrayList(cursorH.getCount());
            while (cursorH.moveToNext()) {
                arrayList.add(new DailyUsageEntity(cursorH.getString(iN), cursorH.getLong(iN2), cursorH.getInt(iN3), cursorH.getLong(iN4), cursorH.isNull(iN5) ? null : cursorH.getString(iN5), cursorH.isNull(iN6) ? null : cursorH.getString(iN6), cursorH.isNull(iN7) ? null : cursorH.getString(iN7)));
            }
            return arrayList;
        } finally {
            cursorH.close();
            eD.e();
        }
    }

    @Override // com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao
    public List<DailyUsageEntity> getDailyUsagesByDate(long j4) {
        E eD = E.d(1, "SELECT * FROM daily_usage WHERE date = ?");
        eD.bindLong(1, j4);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(this.__db, eD);
        try {
            int iN = I.n(cursorH, "id");
            int iN2 = I.n(cursorH, "date");
            int iN3 = I.n(cursorH, "mode");
            int iN4 = I.n(cursorH, "user_id");
            int iN5 = I.n(cursorH, "time_usage_path");
            int iN6 = I.n(cursorH, "screen_usage_path");
            int iN7 = I.n(cursorH, "notification_usage_path");
            ArrayList arrayList = new ArrayList(cursorH.getCount());
            while (cursorH.moveToNext()) {
                arrayList.add(new DailyUsageEntity(cursorH.getString(iN), cursorH.getLong(iN2), cursorH.getInt(iN3), cursorH.getLong(iN4), cursorH.isNull(iN5) ? null : cursorH.getString(iN5), cursorH.isNull(iN6) ? null : cursorH.getString(iN6), cursorH.isNull(iN7) ? null : cursorH.getString(iN7)));
            }
            return arrayList;
        } finally {
            cursorH.close();
            eD.e();
        }
    }

    @Override // com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao
    public List<DailyUsageEntity> getDailyUsagesByMode(int i4, long j4, long j5) {
        E eD = E.d(3, "SELECT * FROM daily_usage WHERE mode =? AND date >= ? AND date < ? ORDER BY date ASC");
        eD.bindLong(1, i4);
        eD.bindLong(2, j4);
        eD.bindLong(3, j5);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(this.__db, eD);
        try {
            int iN = I.n(cursorH, "id");
            int iN2 = I.n(cursorH, "date");
            int iN3 = I.n(cursorH, "mode");
            int iN4 = I.n(cursorH, "user_id");
            int iN5 = I.n(cursorH, "time_usage_path");
            int iN6 = I.n(cursorH, "screen_usage_path");
            int iN7 = I.n(cursorH, "notification_usage_path");
            ArrayList arrayList = new ArrayList(cursorH.getCount());
            while (cursorH.moveToNext()) {
                arrayList.add(new DailyUsageEntity(cursorH.getString(iN), cursorH.getLong(iN2), cursorH.getInt(iN3), cursorH.getLong(iN4), cursorH.isNull(iN5) ? null : cursorH.getString(iN5), cursorH.isNull(iN6) ? null : cursorH.getString(iN6), cursorH.isNull(iN7) ? null : cursorH.getString(iN7)));
            }
            return arrayList;
        } finally {
            cursorH.close();
            eD.e();
        }
    }

    @Override // com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao
    public List<DailyUsageEntity> getUserDailyUsages(int i4, long j4, long j5, long j6) {
        E eD = E.d(4, "SELECT * FROM daily_usage WHERE date >= ? AND date <= ? AND mode = ? AND user_id = ? ORDER BY date ASC");
        eD.bindLong(1, j5);
        eD.bindLong(2, j6);
        eD.bindLong(3, i4);
        eD.bindLong(4, j4);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(this.__db, eD);
        try {
            int iN = I.n(cursorH, "id");
            int iN2 = I.n(cursorH, "date");
            int iN3 = I.n(cursorH, "mode");
            int iN4 = I.n(cursorH, "user_id");
            int iN5 = I.n(cursorH, "time_usage_path");
            int iN6 = I.n(cursorH, "screen_usage_path");
            int iN7 = I.n(cursorH, "notification_usage_path");
            ArrayList arrayList = new ArrayList(cursorH.getCount());
            while (cursorH.moveToNext()) {
                arrayList.add(new DailyUsageEntity(cursorH.getString(iN), cursorH.getLong(iN2), cursorH.getInt(iN3), cursorH.getLong(iN4), cursorH.isNull(iN5) ? null : cursorH.getString(iN5), cursorH.isNull(iN6) ? null : cursorH.getString(iN6), cursorH.isNull(iN7) ? null : cursorH.getString(iN7)));
            }
            return arrayList;
        } finally {
            cursorH.close();
            eD.e();
        }
    }

    @Override // com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao
    public Object insertDailyUsage(final DailyUsageEntity dailyUsageEntity, Continuation<? super Unit> continuation) {
        return c.s(this.__db, new Callable<Unit>() { // from class: com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao_Impl.5
            @Override // java.util.concurrent.Callable
            @NonNull
            public Unit call() throws Exception {
                DailyUsageDao_Impl.this.__db.beginTransaction();
                try {
                    DailyUsageDao_Impl.this.__insertionAdapterOfDailyUsageEntity.insert(dailyUsageEntity);
                    DailyUsageDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    DailyUsageDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao
    public void insertDailyUsages(List<DailyUsageEntity> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfDailyUsageEntity.insert((Iterable<Object>) list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
