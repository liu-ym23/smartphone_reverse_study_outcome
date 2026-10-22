package com.obric.matrix.platform.sdk.ones.ws;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: WsMsgProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class WsMsgProvider extends PluginContentProvider {
    private static final String AUTHORITY_PRE = "com.obric.matrix.platform.sdk.ones.provider";
    public static final a Companion = null;
    private static final String DOT = ".";
    private static final String TAG = "WsMsgProvider";
    private static final String WS_MSG = "ws_msg";
    private static final String WS_MSG_KEY_CHANNEL_ID = "channel_id";
    private static final String WS_MSG_KEY_HEADERS = "ws_headers";
    private static final String WS_MSG_KEY_LOG_ID = "log_id";
    private static final String WS_MSG_KEY_METHOD = "method";
    private static final String WS_MSG_KEY_PAYLOAD = "payload";
    private static final String WS_MSG_KEY_PAYLOAD_ENCODING = "payload_encoding";
    private static final String WS_MSG_KEY_PAYLOAD_TYPE = "payload_type";
    private static final String WS_MSG_KEY_SEQ_ID = "seq_id";
    private static final String WS_MSG_KEY_SERVICE = "service";
    private UriMatcher mMatcher;

    /* JADX INFO: compiled from: WsMsgProvider.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public int delete(Uri r1, String r2, String[] r3) {
        o.e(r1, "uri");
        return 0;
    }

    public String getType(Uri r1) {
        o.e(r1, "uri");
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        o.e(r1, "uri");
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        o.e(r1, "uri");
        return 0;
    }

    public WsMsgProvider() {
        this.mMatcher = new UriMatcher(-1);
    }

    public final UriMatcher getMMatcher() {
        return this.mMatcher;
    }

    public final void setMMatcher(UriMatcher r2) {
        o.e(r2, "<set-?>");
        this.mMatcher = r2;
    }

    public boolean onCreate() {
        logProxy("onCreate() called");
        UriMatcher r0 = this.mMatcher;
        StringBuilder r1 = new StringBuilder().append("com.obric.matrix.platform.sdk.ones.provider.");
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        String r5 = r4.getPackageName();
    L6:
        r0.addURI(r1.append(r5).toString(), WS_MSG, 1);
        return true;
    L5:
        r5 = null;
        goto L6
    }

    public Cursor query(Uri r22, String[] r23, Bundle r24, CancellationSignal r25) {
        o.e(r22, "uri");
        logProxy("query() called with:  queryArgs = " + r24 + ", uri = " + r22 + ", projection = " + r23 + ", cancellationSignal = " + r25 + ", callingPackage = " + getCallingPackage());
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(getCallingPackage(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        byte[] r7 = null;
        if (r4 == false) goto L12;
        return null;
    L12:
        if (o.a(getCallingPackage(), "com.obric.matrix") == true) goto L15;
        return null;
    L15:
        if (this.mMatcher.match(r22) != 1) goto L54;
        if (r24 == null) goto L18;
        Integer r0 = Integer.valueOf(r24.getInt("channel_id", 0));
    L20:
        if (r24 == null) goto L22;
        Long r1 = Long.valueOf(r24.getLong(WS_MSG_KEY_SEQ_ID, 0));
    L23:
        if (r24 == null) goto L25;
        Long r5 = Long.valueOf(r24.getLong(WS_MSG_KEY_LOG_ID, 0));
    L26:
        if (r24 == null) goto L28;
        Integer r6 = Integer.valueOf(r24.getInt("service", 0));
    L29:
        if (r24 == null) goto L31;
        Integer r8 = Integer.valueOf(r24.getInt("method", 0));
    L33:
        if (r24 == null) goto L35;
        Serializable r9 = r24.getSerializable(WS_MSG_KEY_HEADERS);
    L36:
        if (r9 == null) goto L41;
        if (r24 == null) goto L39;
        Serializable r10 = r24.getSerializable(WS_MSG_KEY_HEADERS);
    L40:
        Objects.requireNonNull(r10, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
        HashMap<String, String> r11 = (HashMap) ZeusTransformUtils.preCheckCast(r10, HashMap.class, "com.obric.aiagent.plugin");
    L42:
        HashMap<String, String> r20 = r11;
        if (r24 == null) goto L45;
        String r18 = r24.getString(WS_MSG_KEY_PAYLOAD_TYPE);
    L46:
        if (r24 == null) goto L48;
        String r17 = r24.getString(WS_MSG_KEY_PAYLOAD_ENCODING);
    L49:
        if (r24 == null) goto L51;
        r7 = r24.getByteArray("payload");
    L51:
        b r12 = b.f33744a;
        o.a(r0);
        int r13 = r0.intValue();
        o.a(r1);
        long r14 = r1.longValue();
        o.a(r5);
        long r15 = r5.longValue();
        o.a(r6);
        int r16 = r6.intValue();
        o.a(r8);
        r12.a(r13, r14, r15, r16, r8.intValue(), r17, r18, r7, r20);
        Cursor r19 = (Cursor) ZeusTransformUtils.preCheckCast(new MatrixCursor(new String[]{"received"}), Cursor.class, "com.obric.aiagent.plugin");
        ((MatrixCursor) ZeusTransformUtils.preCheckCast(r19, MatrixCursor.class, "com.obric.aiagent.plugin")).addRow(new String[]{"true"});
        return r19;
    L48:
        r17 = null;
        goto L49
    L45:
        r18 = null;
        goto L46
    L39:
        r10 = null;
        goto L40
    L41:
        r11 = (HashMap) ZeusTransformUtils.preCheckCast(null, HashMap.class, "com.obric.aiagent.plugin");
        goto L42
    L35:
        r9 = null;
        goto L36
    L31:
        r8 = null;
        goto L33
    L28:
        r6 = null;
        goto L29
    L25:
        r5 = null;
        goto L26
    L22:
        r1 = null;
        goto L23
    L18:
        r0 = null;
        goto L20
    L54:
        return null;
    L5:
        if (r3.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    private final void logProxy(String r3) {
        if (com.obric.matrix.platform.sdk.ones.b.f33630a.b() == null) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L9;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, r3, null, 4, null);
        return;
    L9:
        INVOKESTATIC_com_obric_matrix_platform_sdk_ones_ws_WsMsgProvider_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, r3);
        return;
    L5:
        r2 = false;
        goto L7
    }

    public Cursor query(Uri r3, String[] r4, String r5, String[] r6, String r7) {
        o.e(r3, "uri");
        logProxy("query() called with: uri = " + r3 + ", projection = " + r4 + ", selection = " + r5 + ", selectionArgs = " + r6 + ", sortOrder = " + r7);
        return null;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_matrix_platform_sdk_ones_ws_WsMsgProvider_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
