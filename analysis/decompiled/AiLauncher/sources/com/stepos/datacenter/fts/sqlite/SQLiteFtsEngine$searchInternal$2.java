package com.stepos.datacenter.fts.sqlite;

import La.H;
import Ua.M;
import Y8.t;
import Z8.C1173v;
import android.database.Cursor;
import android.util.Log;
import b7.C1454b;
import b7.d;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import l9.b;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lb7/d;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine$searchInternal$2", f = "SQLiteFtsEngine.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class SQLiteFtsEngine$searchInternal$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super List<? extends d>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f30086a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C1454b f30087b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SQLiteFtsEngine f30088c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SQLiteFtsEngine$searchInternal$2(C1454b c1454b, SQLiteFtsEngine sQLiteFtsEngine, InterfaceC4014c<? super SQLiteFtsEngine$searchInternal$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f30087b = c1454b;
        this.f30088c = sQLiteFtsEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SQLiteFtsEngine$searchInternal$2(this.f30087b, this.f30088c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super List<? extends d>> interfaceC4014c) {
        return ((SQLiteFtsEngine$searchInternal$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f30086a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        try {
            String strF = this.f30087b.f();
            kotlin.jvm.internal.p.h(strF, "getQuery(...)");
            String string = H.D1(strF).toString();
            SQLiteDatabase readableDatabase = this.f30088c.dbHelper.getReadableDatabase();
            kotlin.jvm.internal.p.h(readableDatabase, "<get-readableDatabase>(...)");
            ArrayList arrayList = new ArrayList();
            Cursor cursorRawQuery = readableDatabase.rawQuery(this.f30087b.h() ? this.f30088c.n(this.f30087b) : this.f30088c.m(this.f30087b), this.f30088c.l(this.f30088c.j(string), this.f30087b));
            C1454b c1454b = this.f30087b;
            SQLiteFtsEngine sQLiteFtsEngine = this.f30088c;
            try {
                Cursor cursor = cursorRawQuery;
                while (cursor.moveToNext()) {
                    cursor.getLong(0);
                    C1454b c1454b2 = c1454b;
                    arrayList.add(new d(cursor.getLong(1), cursor.getString(2), cursor.getString(3), (!c1454b.h() || cursor.getColumnCount() <= 5) ? null : cursor.getString(5), -cursor.getDouble(4), sQLiteFtsEngine.q(string).size(), 0L, cursor.getColumnCount() > 6 ? cursor.getLong(6) : 0L));
                    c1454b = c1454b2;
                }
                t tVar = t.f7040a;
                b.a(cursorRawQuery, null);
                Log.d("SQLiteFtsEngine", "Search '" + string + "' returned " + arrayList.size() + " results");
                return arrayList;
            } finally {
            }
        } catch (Exception e10) {
            Log.e("SQLiteFtsEngine", "Search failed: " + this.f30087b.f(), e10);
            return C1173v.m();
        }
    }
}
