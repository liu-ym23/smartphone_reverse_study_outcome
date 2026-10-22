package com.stepos.datacenter.fts.sqlite;

import Ua.M;
import Y8.t;
import android.util.Log;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import io.requery.android.database.sqlite.SQLiteDatabase;
import io.requery.android.database.sqlite.SQLiteStatement;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine$indexDocument$2", f = "SQLiteFtsEngine.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class SQLiteFtsEngine$indexDocument$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Boolean>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f30069a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SQLiteFtsEngine f30070b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f30071c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f30072d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f30073e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SQLiteFtsEngine$indexDocument$2(SQLiteFtsEngine sQLiteFtsEngine, String str, long j10, String str2, InterfaceC4014c<? super SQLiteFtsEngine$indexDocument$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f30070b = sQLiteFtsEngine;
        this.f30071c = str;
        this.f30072d = j10;
        this.f30073e = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SQLiteFtsEngine$indexDocument$2(this.f30070b, this.f30071c, this.f30072d, this.f30073e, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((SQLiteFtsEngine$indexDocument$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        boolean z10;
        C4063a.g();
        if (this.f30069a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        try {
            SQLiteDatabase writableDatabase = this.f30070b.dbHelper.getWritableDatabase();
            kotlin.jvm.internal.p.h(writableDatabase, "<get-writableDatabase>(...)");
            writableDatabase.beginTransactionNonExclusive();
            try {
                SQLiteStatement sQLiteStatementL = this.f30070b.dbHelper.l();
                long j10 = this.f30072d;
                String str = this.f30071c;
                String str2 = this.f30073e;
                synchronized (sQLiteStatementL) {
                    z10 = true;
                    sQLiteStatementL.bindLong(1, j10);
                    sQLiteStatementL.bindString(2, str);
                    sQLiteStatementL.bindString(3, str2);
                    sQLiteStatementL.bindLong(4, System.currentTimeMillis());
                    sQLiteStatementL.executeInsert();
                    sQLiteStatementL.clearBindings();
                    t tVar = t.f7040a;
                }
                writableDatabase.setTransactionSuccessful();
                this.f30070b.t(this.f30071c);
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (Exception e10) {
            Log.e("SQLiteFtsEngine", "Failed to index document: docId=" + this.f30072d + ", table=" + this.f30071c, e10);
            z10 = false;
        }
        return C4109a.a(z10);
    }
}
