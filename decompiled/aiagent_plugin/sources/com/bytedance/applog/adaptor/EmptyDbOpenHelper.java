package com.bytedance.applog.adaptor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class EmptyDbOpenHelper extends SQLiteOpenHelper {
    private volatile int oldVersion;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r1) {
    }

    EmptyDbOpenHelper(Context r3, String r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, null, Integer.MAX_VALUE);
        this.oldVersion = Integer.MAX_VALUE;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
        this.oldVersion = r2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase r1, int r2, int r3) {
        this.oldVersion = r2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase r1) {
        super.onOpen(r1);
        r1.setVersion(this.oldVersion);
    }
}
