package com.bytedance.privacy.pcc.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.privacy.pcc.network.model.CreateChannelResponse;
import com.bytedance.privacy.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class PccChannelDb {
    private static final String COL_ACCESS_TOKEN = "access_token";
    private static final String COL_APP_ID = "app_id";
    private static final String COL_CHANNEL_EXPIRY_TIME = "channel_expiry_time";
    private static final String COL_CHANNEL_ID = "channel_id";
    private static final String COL_EVIDENCE_INFO = "evidence_info";
    private static final String COL_PAYLOAD_JSON = "payload_json";
    private static final String COL_RESPONSE_ID = "response_id";
    private static final String COL_RPDID = "rpdid";
    private static final String COL_RPUID = "rpuid";
    private static final String COL_SERVICE_INFO = "service_info";
    private static final String COL_SIGNATURE = "signature";
    private static final String COL_SVC_ID = "svc_id";
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS pcc_channel (rpdid TEXT NOT NULL, rpuid TEXT NOT NULL, app_id TEXT NOT NULL, svc_id TEXT NOT NULL, access_token TEXT, channel_id TEXT, channel_expiry_time TEXT, service_info TEXT, evidence_info TEXT, payload_json TEXT, response_id TEXT, signature TEXT, PRIMARY KEY (rpdid, rpuid, app_id, svc_id))";
    private static final String DB_NAME = "pcc_channel.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE = "pcc_channel";
    private static final String TAG = "PccChannelDb";
    private final SQLiteOpenHelper helper;

    static {
    }

    public PccChannelDb(Context r7) {
        final Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        final String r3 = DB_NAME;
        final SQLiteDatabase.CursorFactory r4 = null;
        final int r5 = 1;
        this.helper = new AnonymousClass1(this, r2, r3, r4, r5);
    }

    public boolean save(String r6, String r7, String r8, String r9, CreateChannelResponse r10) {
    L18:
        e = move-exception;
        LogUtils.e(TAG, "save exception: " + e.getMessage());
        return false;
    L4:
        String r2 = "";
        if (r10.getServiceInfo() == null) goto L7;
        String r1 = r10.getServiceInfo().toJsonString();     // Catch: Exception -> L18
    L9:
        if (r10.getEvidenceInfo() == null) goto L11;
        r2 = r10.getEvidenceInfo().toJsonString();     // Catch: Exception -> L18
    L11:
        ContentValues r3 = new ContentValues();     // Catch: Exception -> L18
        r3.put(COL_RPDID, r6);     // Catch: Exception -> L18
        r3.put(COL_RPUID, r7);     // Catch: Exception -> L18
        r3.put("app_id", r8);     // Catch: Exception -> L18
        r3.put(COL_SVC_ID, r9);     // Catch: Exception -> L18
        r3.put(COL_ACCESS_TOKEN, r10.getAccessToken());     // Catch: Exception -> L18
        r3.put("channel_id", r10.getChannelId());     // Catch: Exception -> L18
        r3.put(COL_CHANNEL_EXPIRY_TIME, r10.getChannelExpiryTime());     // Catch: Exception -> L18
        r3.put(COL_SERVICE_INFO, r1);     // Catch: Exception -> L18
        r3.put(COL_EVIDENCE_INFO, r2);     // Catch: Exception -> L18
        r3.put(COL_PAYLOAD_JSON, r10.getPayloadJson());     // Catch: Exception -> L18
        r3.put(COL_RESPONSE_ID, r10.getResponseId());     // Catch: Exception -> L18
        r3.put(COL_SIGNATURE, r10.getSignature());     // Catch: Exception -> L18
        if (this.helper.getWritableDatabase().insertWithOnConflict(TABLE, null, r3, 5) != (-1)) goto L15;
        LogUtils.e(TAG, "save: insertWithOnConflict returned -1");     // Catch: Exception -> L18
        return false;
    L15:
        LogUtils.d(TAG, "save success: rpdid=" + r6 + " appId=" + r8 + " svcId=" + r9);     // Catch: Exception -> L18
        return true;
    L7:
        r1 = "";
        goto L9
    }

    public CreateChannelResponse query(String r9, String r10, String r11, String r12) {
        Cursor r8 = this.helper.getReadableDatabase().query(TABLE, null, "rpdid=? AND rpuid=? AND app_id=? AND svc_id=?", new String[]{r9, r10, r11, r12}, null, null, null);     // Catch: Exception -> L23
        if (r8 != null) goto L27;
    L20:
        if (r8 == null) goto L34;
        r8.close();     // Catch: Exception -> L23
        return null;
    L34:
        return null;
    L27:
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (r8 != null) goto L32;
    L19:
        throw th;     // Catch: Exception -> L23
    L32:
        r8.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L23
        goto L19
    L6:
        if (r8.moveToFirst() == false) goto L20;
        CreateChannelResponse r13 = CreateChannelResponse.fromDb(r8.getString(r8.getColumnIndexOrThrow(COL_SERVICE_INFO)), r8.getString(r8.getColumnIndexOrThrow(COL_EVIDENCE_INFO)), r8.getString(r8.getColumnIndexOrThrow(COL_ACCESS_TOKEN)), r8.getString(r8.getColumnIndexOrThrow("channel_id")), r8.getString(r8.getColumnIndexOrThrow(COL_CHANNEL_EXPIRY_TIME)), r8.getString(r8.getColumnIndexOrThrow(COL_PAYLOAD_JSON)), r8.getString(r8.getColumnIndexOrThrow(COL_RESPONSE_ID)), r8.getString(r8.getColumnIndexOrThrow(COL_SIGNATURE)));     // Catch: Throwable -> L11
        if (r8 == null) goto L10;
        r8.close();     // Catch: Exception -> L23
    L10:
        return r13;
    L23:
        e = move-exception;
        LogUtils.e(TAG, "query exception: " + e.getMessage());
        return null;
    }
}
