package com.bytedanceos.appstore.model.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import com.bytedanceos.common.toolbox.j;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseDBContentProvider extends ContentProvider implements SQLiteTransactionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f9419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadLocal f9420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SQLiteOpenHelper f9421c;

    public BaseDBContentProvider() {
        this.f9420b = new ThreadLocal();
    }

    public final boolean a() {
        if (this.f9420b.get() != null) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) this.f9420b.get()).booleanValue() == false) goto L7;
        return true;
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList r10) {
        if (e() == true) goto L5;
        return null;
    L5:
        SQLiteDatabase r11 = this.f9421c.getWritableDatabase();
        this.f9419a = r11;
        if (r11 != null) goto L8;
    L21:
        return null;
    L8:
        if (r11.isOpen() == false) goto L21;
        this.f9419a.beginTransactionWithListener(this);
        this.f9420b.set(Boolean.TRUE);     // Catch: Throwable -> L14
        int r12 = r10.size();     // Catch: Throwable -> L14
        ContentProviderResult[] r13 = new ContentProviderResult[r12];     // Catch: Throwable -> L14
        int r14 = 0;
    L12:
        if (r14 >= r12) goto L16;
        r13[r14] = ((ContentProviderOperation) r10.get(r14)).apply(this, r13, r14);     // Catch: Throwable -> L14
        r14 = r14 + 1;     // Catch: Throwable -> L14
        goto L12
    L16:
        this.f9419a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.f9420b.set(Boolean.FALSE);
        this.f9419a.endTransaction();
        return r13;
    L14:
        th = move-exception;
        this.f9420b.set(Boolean.FALSE);
        this.f9419a.endTransaction();
        throw th;
    }

    public abstract int b(Uri r10, String r11, String[] r12);

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri r10, ContentValues[] r11) {
        int r12 = 0;
        if (e() == true) goto L5;
        return 0;
    L5:
        int r13 = r11.length;
        SQLiteDatabase r14 = this.f9421c.getWritableDatabase();
        this.f9419a = r14;
        if (r14 != null) goto L8;
    L20:
        return 0;
    L8:
        if (r14.isOpen() == false) goto L20;
        this.f9419a.beginTransactionWithListener(this);
    L11:
        if (r12 >= r13) goto L15;
        d(r10, r11[r12]);     // Catch: Throwable -> L13
        this.f9419a.yieldIfContendedSafely();     // Catch: Throwable -> L13
        r12 = r12 + 1;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        this.f9419a.endTransaction();
        throw th;
    L15:
        this.f9419a.setTransactionSuccessful();     // Catch: Throwable -> L13
        this.f9419a.endTransaction();
        return r13;
    }

    public abstract SQLiteOpenHelper c();

    public abstract Uri d(Uri r10, ContentValues r11);

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        if (e() == true) goto L6;
        return 0;
    L6:
        if (a() == true) goto L20;
        SQLiteDatabase r13 = this.f9421c.getWritableDatabase();
        this.f9419a = r13;
        if (r13 != null) goto L10;
    L18:
        return 0;
    L10:
        if (r13.isOpen() == false) goto L18;
        this.f9419a.beginTransactionWithListener(this);
        int r14 = b(r10, r11, r12);     // Catch: Throwable -> L15
        this.f9419a.setTransactionSuccessful();     // Catch: Throwable -> L15
        this.f9419a.endTransaction();
        return r14;
    L15:
        th = move-exception;
        this.f9419a.endTransaction();
        throw th;
    L20:
        return b(r10, r11, r12);
    }

    public boolean e() {
        SQLiteOpenHelper r10 = c();
        this.f9421c = r10;
        if (r10 != null) goto L6;
        j.m("init database failed.");
        return false;
    L6:
        return true;
    }

    public void f(Uri r10, ContentObserver r11) {
        getContext().getContentResolver().notifyChange(r10, null);
    }

    public abstract int g(Uri r10, ContentValues r11, String r12, String[] r13);

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        if (e() == true) goto L6;
        return null;
    L6:
        if (a() == true) goto L20;
        SQLiteDatabase r12 = this.f9421c.getWritableDatabase();
        this.f9419a = r12;
        if (r12 != null) goto L10;
    L18:
        return null;
    L10:
        if (r12.isOpen() == false) goto L18;
        this.f9419a.beginTransactionWithListener(this);
        Uri r13 = d(r10, r11);     // Catch: Throwable -> L15
        this.f9419a.setTransactionSuccessful();     // Catch: Throwable -> L15
        this.f9419a.endTransaction();
        return r13;
    L15:
        th = move-exception;
        this.f9419a.endTransaction();
        throw th;
    L20:
        return d(r10, r11);
    }

    @Override // android.database.sqlite.SQLiteTransactionListener
    public void onBegin() {
    }

    @Override // android.database.sqlite.SQLiteTransactionListener
    public void onCommit() {
    }

    @Override // android.database.sqlite.SQLiteTransactionListener
    public void onRollback() {
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        if (e() == true) goto L6;
        return 0;
    L6:
        if (a() == true) goto L20;
        SQLiteDatabase r14 = this.f9421c.getWritableDatabase();
        this.f9419a = r14;
        if (r14 != null) goto L10;
    L18:
        return 0;
    L10:
        if (r14.isOpen() == false) goto L18;
        this.f9419a.beginTransactionWithListener(this);
        int r15 = g(r10, r11, r12, r13);     // Catch: Throwable -> L15
        this.f9419a.setTransactionSuccessful();     // Catch: Throwable -> L15
        this.f9419a.endTransaction();
        return r15;
    L15:
        th = move-exception;
        this.f9419a.endTransaction();
        throw th;
    L20:
        return g(r10, r11, r12, r13);
    }
}
