package com.bytedance.android.shopping.anchorv4.helper.shot;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f166984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f166985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<Long, String, Unit> f166986c;

    public b() {
        throw null;
    }

    public final void a() {
        String[] r100 = {"_data", "date_added"};
        ContentResolver r110 = this.f166984a.getApplicationContext().getContentResolver();
        Uri r101 = this.f166985b;
        f06.c r111 = new f06.c();
        Object[] r102 = {r101, r100, null, null, "date_modified desc"};
        f06.b r112 = new f06.b();
        f06.d r113 = r111.b(240004, "android/content/ContentResolver", "query", r110, r102, "android.database.Cursor", r112);
        if (r113.f474982a == false) goto L5;
        r111.a(240004, "android/content/ContentResolver", "query", r110, r102, null, r112, false);
        Cursor r103 = (Cursor) r113.f474983b;
    L6:
        if (r103 == null) goto L19;
        Cursor r104 = r103;
        Cursor r105 = r104;     // Catch: Throwable -> L13
        if (r105.moveToFirst() == false) goto L11;
        this.f166986c.invoke(Long.valueOf(r105.getLong(r105.getColumnIndex("date_added"))), r105.getString(r105.getColumnIndex("_data")));     // Catch: Throwable -> L13
    L11:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r104, null);
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);
        throw th;
    L19:
        return;
    L5:
        r103 = r110.query(r101, r100, null, null, "date_modified desc");
        r111.a(240004, "android/content/ContentResolver", "query", r110, r102, r103, r112, true);
        goto L6
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r100) {
        super.onChange(r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        a();     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public b(Activity r100, Uri r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "callback");
        super(null);
        this.f166984a = r100;
        this.f166985b = r101;
        this.f166986c = r102;
    }
}
