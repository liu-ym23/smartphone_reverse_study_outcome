package io.requery.android.database.sqlite;

import android.content.Context;
import io.requery.android.database.DatabaseErrorHandler;
import j1.InterfaceC4757d;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class RequerySQLiteOpenHelperFactory implements InterfaceC4757d.c {
    private final Iterable<ConfigurationOptions> configurationOptions;

    public static final class CallbackDatabaseErrorHandler implements DatabaseErrorHandler {
        private final InterfaceC4757d.a callback;

        public CallbackDatabaseErrorHandler(InterfaceC4757d.a aVar) {
            this.callback = aVar;
        }

        @Override // io.requery.android.database.DatabaseErrorHandler
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            this.callback.c(sQLiteDatabase);
        }
    }

    public static final class CallbackSQLiteOpenHelper extends SQLiteOpenHelper {
        private final InterfaceC4757d.a callback;
        private final Iterable<ConfigurationOptions> configurationOptions;

        public CallbackSQLiteOpenHelper(Context context, String str, InterfaceC4757d.a aVar, Iterable<ConfigurationOptions> iterable) {
            super(context, str, null, aVar.version, new CallbackDatabaseErrorHandler(aVar));
            this.callback = aVar;
            this.configurationOptions = iterable;
        }

        @Override // io.requery.android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabaseConfiguration createConfiguration(String str, int i10) {
            SQLiteDatabaseConfiguration sQLiteDatabaseConfigurationCreateConfiguration = super.createConfiguration(str, i10);
            Iterator<ConfigurationOptions> it = this.configurationOptions.iterator();
            while (it.hasNext()) {
                sQLiteDatabaseConfigurationCreateConfiguration = it.next().apply(sQLiteDatabaseConfigurationCreateConfiguration);
            }
            return sQLiteDatabaseConfigurationCreateConfiguration;
        }

        @Override // io.requery.android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.callback.b(sQLiteDatabase);
        }

        @Override // io.requery.android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.callback.d(sQLiteDatabase);
        }

        @Override // io.requery.android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.callback.e(sQLiteDatabase, i10, i11);
        }

        @Override // io.requery.android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            this.callback.f(sQLiteDatabase);
        }

        @Override // io.requery.android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.callback.g(sQLiteDatabase, i10, i11);
        }
    }

    public interface ConfigurationOptions {
        SQLiteDatabaseConfiguration apply(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration);
    }

    public RequerySQLiteOpenHelperFactory(Iterable<ConfigurationOptions> iterable) {
        this.configurationOptions = iterable;
    }

    @Override // j1.InterfaceC4757d.c
    public InterfaceC4757d create(InterfaceC4757d.b bVar) {
        return new CallbackSQLiteOpenHelper(bVar.context, bVar.name, bVar.callback, this.configurationOptions);
    }

    public RequerySQLiteOpenHelperFactory() {
        this(Collections.EMPTY_LIST);
    }
}
