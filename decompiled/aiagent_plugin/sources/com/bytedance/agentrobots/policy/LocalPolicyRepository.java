package com.bytedance.agentrobots.policy;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class LocalPolicyRepository extends SQLiteOpenHelper {
    private static final String COL_APP_ID = "app_id";
    private static final String COL_POLICY_CONTENT = "content";
    private static final String COL_VERSION = "version";
    private static final String DATABASE_NAME = "policy.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "policies";
    private static final String TAG = "LocalPolicyRepository";

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    LocalPolicyRepository(Context r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), DATABASE_NAME, null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r1) {
        r1.execSQL("CREATE TABLE policies (app_id TEXT PRIMARY KEY, content TEXT, version INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
        r1.execSQL("DROP TABLE IF EXISTS policies");
        onCreate(r1);
    }

    JSONObject find(String r10) {
        Cursor r0 = getReadableDatabase().query(TABLE_NAME, new String[]{"content"}, "app_id=?", new String[]{r10}, null, null, null);     // Catch: Throwable -> L15 JSONException -> L17
        if (r0 != null) goto L27;
    L13:
        if (r0 == null) goto L22;
    L14:
        r0.close();
    L22:
        return null;
    L27:
    L11:
        e = e;
    L19:
        INVOKESTATIC_com_bytedance_agentrobots_policy_LocalPolicyRepository_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Error parsing policy JSON for " + r10, e);     // Catch: Throwable -> L23
        if (r0 == null) goto L22;
    L23:
        Throwable th = th;
    L24:
        if (r0 == null) goto L26;
        r0.close();
    L26:
        throw th;
    L6:
        if (r0.moveToFirst() == false) goto L13;
        JSONObject r2 = new JSONObject(r0.getString(0));     // Catch: JSONException -> L11 Throwable -> L23
        if (r0 == null) goto L10;
        r0.close();
    L10:
        return r2;
    L17:
        e = e;
        r0 = null;
    L15:
        th = move-exception;
        r0 = null;
        th = th;
        goto L24
    }

    void delete(String r5) {
        getWritableDatabase().delete(TABLE_NAME, "app_id=?", new String[]{r5});     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        INVOKESTATIC_com_bytedance_agentrobots_policy_LocalPolicyRepository_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Error deleting policy for " + r5, e);
    }

    void save(String r6, JSONObject r7) {
        getWritableDatabase().execSQL("INSERT OR REPLACE INTO policies (app_id, content, version) VALUES (?, ?, ?)", new Object[]{r6, r7.toString(), Long.valueOf(r7.optLong(COL_VERSION, System.currentTimeMillis()))});     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        INVOKESTATIC_com_bytedance_agentrobots_policy_LocalPolicyRepository_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Error saving policy for " + r6, e);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_agentrobots_policy_LocalPolicyRepository_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
