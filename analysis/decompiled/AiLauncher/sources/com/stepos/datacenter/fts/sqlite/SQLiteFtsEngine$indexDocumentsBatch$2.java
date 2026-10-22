package com.stepos.datacenter.fts.sqlite;

import La.H;
import Ua.M;
import Y8.t;
import android.util.Log;
import c7.FtsDocument;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import io.requery.android.database.sqlite.SQLiteDatabase;
import io.requery.android.database.sqlite.SQLiteStatement;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)I"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine$indexDocumentsBatch$2", f = "SQLiteFtsEngine.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class SQLiteFtsEngine$indexDocumentsBatch$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Integer>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f30074a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SQLiteFtsEngine f30075b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List<FtsDocument> f30076c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SQLiteFtsEngine$indexDocumentsBatch$2(SQLiteFtsEngine sQLiteFtsEngine, List<FtsDocument> list, InterfaceC4014c<? super SQLiteFtsEngine$indexDocumentsBatch$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f30075b = sQLiteFtsEngine;
        this.f30076c = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SQLiteFtsEngine$indexDocumentsBatch$2(this.f30075b, this.f30076c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return ((SQLiteFtsEngine$indexDocumentsBatch$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f30074a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        int i10 = 0;
        try {
            SQLiteDatabase writableDatabase = this.f30075b.dbHelper.getWritableDatabase();
            kotlin.jvm.internal.p.h(writableDatabase, "<get-writableDatabase>(...)");
            writableDatabase.beginTransactionNonExclusive();
            try {
                SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement("\n                        INSERT OR REPLACE INTO fts_data(doc_id, table_name, content, updated_at) \n                        VALUES (?, ?, ?, ?)\n                    ");
                kotlin.jvm.internal.p.h(sQLiteStatementCompileStatement, "compileStatement(...)");
                long jCurrentTimeMillis = System.currentTimeMillis();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                int i11 = 0;
                for (FtsDocument ftsDocument : this.f30076c) {
                    if (!H.x0(ftsDocument.getContent())) {
                        sQLiteStatementCompileStatement.bindLong(1, ftsDocument.getDocId());
                        sQLiteStatementCompileStatement.bindString(2, ftsDocument.getTableName());
                        sQLiteStatementCompileStatement.bindString(3, ftsDocument.getContent());
                        sQLiteStatementCompileStatement.bindLong(4, jCurrentTimeMillis);
                        sQLiteStatementCompileStatement.executeInsert();
                        sQLiteStatementCompileStatement.clearBindings();
                        linkedHashSet.add(ftsDocument.getTableName());
                        i11++;
                    }
                }
                sQLiteStatementCompileStatement.close();
                writableDatabase.setTransactionSuccessful();
                for (Object obj2 : linkedHashSet) {
                    kotlin.jvm.internal.p.h(obj2, "next(...)");
                    this.f30075b.t((String) obj2);
                }
                Log.d("SQLiteFtsEngine", "Batch indexed " + i11 + " documents in " + (System.currentTimeMillis() - jCurrentTimeMillis) + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
                writableDatabase.endTransaction();
                i10 = i11;
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        } catch (Exception e10) {
            Log.e("SQLiteFtsEngine", "Failed to batch index documents", e10);
        }
        return C4109a.f(i10);
    }
}
