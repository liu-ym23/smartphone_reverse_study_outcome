package com.bytedance.crypto.obfuscated;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class m extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile m f7870a;

    public m(Context r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), "secret_item.db", null, 1);
    }

    public static m a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f7870a != null) goto L15;
        monitor-enter(m.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7870a != null) goto L9;
        f7870a = new m(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L11
    L15:
        return f7870a;
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public final j a(String r11, String r12) {
        INVOKESTATIC_com_bytedance_crypto_obfuscated_m_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("a", "queryData, alias: " + r11 + ", pkgName: " + r12);
        Cursor r10 = getReadableDatabase().query("secret_item", null, "alias =? AND pkg_name =? ", new String[]{r11, r12}, null, null, null);
        if (r10 != null) goto L7;
        INVOKESTATIC_com_bytedance_crypto_obfuscated_m_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("a", "queryData cursor is null");
        return null;
    L7:
        if (r10.getCount() != 0) goto L10;
        INVOKESTATIC_com_bytedance_crypto_obfuscated_m_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("a", "queryData cursor count is 0");
        r10.close();
        return null;
    L10:
        j r13 = new j();
        if (r10.moveToFirst() == false) goto L13;
        r13.f7865c = r10.getString(r10.getColumnIndex("associate"));
        r13.f7864b = r10.getString(r10.getColumnIndex("data_type"));
        r13.f7866d = r10.getString(r10.getColumnIndex("public_data"));
        r13.f7867e = r10.getString(r10.getColumnIndex("private_data"));
        r13.f = r10.getString(r10.getColumnIndex("secret_data"));
        r13.g = r10.getString(r10.getColumnIndex("ext_info"));
        r13.h = r10.getString(r10.getColumnIndex("search_info"));
        r13.l = r10.getString(r10.getColumnIndex("create_time"));
        r13.m = r10.getString(r10.getColumnIndex("latest_time"));
        r13.i = r10.getString(r10.getColumnIndex("access_limit"));
        r13.j = r10.getString(r10.getColumnIndex("auth_limit"));
        r13.k = r10.getInt(r10.getColumnIndex("sync_limit"));
        r13.f7863a = r11;
    L13:
        r10.close();
        return r13;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r1) {
        r1.execSQL("CREATE TABLE key_item (alias TEXT NOT NULL PRIMARY KEY, version INTEGER, cipher TEXT, iv TEXT,extra TEXT)");
        r1.execSQL("CREATE TABLE secret_item (alias TEXT NOT NULL, pkg_name TEXT NOT NULL, public_data TEXT, private_data TEXT, secret_data TEXT, data_type TEXT, associate TEXT, access_limit TEXT, auth_limit TEXT, sync_limit INTEGER, sync_status INTEGER, global_id TEXT, status INTEGER, search_info TEXT, ext_info TEXT, create_time TEXT, latest_time TEXT, PRIMARY KEY (alias, pkg_name))");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_crypto_obfuscated_m_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_crypto_obfuscated_m_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
