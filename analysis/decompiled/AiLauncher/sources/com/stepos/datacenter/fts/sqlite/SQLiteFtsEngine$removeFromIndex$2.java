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
@InterfaceC4112d(c = "com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine$removeFromIndex$2", f = "SQLiteFtsEngine.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class SQLiteFtsEngine$removeFromIndex$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Boolean>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f30077a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SQLiteFtsEngine f30078b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f30079c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f30080d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SQLiteFtsEngine$removeFromIndex$2(SQLiteFtsEngine sQLiteFtsEngine, String str, long j10, InterfaceC4014c<? super SQLiteFtsEngine$removeFromIndex$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f30078b = sQLiteFtsEngine;
        this.f30079c = str;
        this.f30080d = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SQLiteFtsEngine$removeFromIndex$2(this.f30078b, this.f30079c, this.f30080d, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((SQLiteFtsEngine$removeFromIndex$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        boolean z10;
        C4063a.g();
        if (this.f30077a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        try {
            SQLiteDatabase writableDatabase = this.f30078b.dbHelper.getWritableDatabase();
            kotlin.jvm.internal.p.h(writableDatabase, "<get-writableDatabase>(...)");
            writableDatabase.beginTransactionNonExclusive();
            try {
                SQLiteStatement sQLiteStatementI = this.f30078b.dbHelper.i();
                long j10 = this.f30080d;
                String str = this.f30079c;
                synchronized (sQLiteStatementI) {
                    z10 = true;
                    sQLiteStatementI.bindLong(1, j10);
                    sQLiteStatementI.bindString(2, str);
                    sQLiteStatementI.executeUpdateDelete();
                    sQLiteStatementI.clearBindings();
                    t tVar = t.f7040a;
                }
                writableDatabase.setTransactionSuccessful();
                this.f30078b.t(this.f30079c);
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (Exception e10) {
            Log.e("SQLiteFtsEngine", "Failed to remove from index", e10);
            z10 = false;
        }
        return C4109a.a(z10);
    }
}
