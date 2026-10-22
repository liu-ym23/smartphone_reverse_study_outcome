package com.obric.matrix.platform.sdk.ones.ws;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Log;
import com.bytedance.apm.constant.ReportProtocal;
import com.bytedance.common.wschannel.WsConstants;
import hc.b;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J?\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\u00072\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012JQ\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\u00072\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ3\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\tH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ=\u0010 \u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\tH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\nH\u0002¢\u0006\u0004\b$\u0010%R\"\u0010,\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsMsgProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "", "onCreate", "()Z", "Landroid/net/Uri;", "uri", "", "", "projection", "Landroid/os/Bundle;", "queryArgs", "Landroid/os/CancellationSignal;", "cancellationSignal", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Landroid/os/Bundle;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "(Landroid/net/Uri;)Ljava/lang/String;", "Landroid/content/ContentValues;", "values", "insert", "(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "msg", "", "a", "(Ljava/lang/String;)V", "Landroid/content/UriMatcher;", "Landroid/content/UriMatcher;", "getMMatcher", "()Landroid/content/UriMatcher;", "setMMatcher", "(Landroid/content/UriMatcher;)V", "mMatcher", "b", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WsMsgProvider extends ContentProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f11968b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UriMatcher f11969a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f11968b = new a(null);
    }

    public WsMsgProvider() {
        this.f11969a = new UriMatcher(-1);
    }

    public final void a(String r10) {
        if (ac.a.f80a.b() == null) goto L5;
        b.b("WsMsgProvider", r10, null, 4, null);
        return;
    L5:
        Log.d("WsMsgProvider", r10);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        q.g(r10, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        q.g(r10, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        q.g(r10, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        a("onCreate() called");
        UriMatcher r10 = this.f11969a;
        StringBuilder r11 = new StringBuilder();
        r11.append("com.obric.matrix.platform.sdk.ones.provider.");
        Context r12 = getContext();
        if (r12 == null) goto L5;
        String r13 = r12.getPackageName();
    L6:
        r11.append(r13);
        r10.addURI(r11.toString(), "ws_msg", 1);
        return true;
    L5:
        r13 = null;
        goto L6
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r17, String[] r18, Bundle r19, CancellationSignal r20) {
        q.g(r17, "uri");
        a("query() called with:  queryArgs = " + r19 + ", uri = " + r17 + ", projection = " + r18 + ", cancellationSignal = " + r20 + ", callingPackage = " + getCallingPackage());
        String r10 = getCallingPackage();
        byte[] r11 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.length() != 0) goto L8;
        return null;
    L8:
        if (q.b(getCallingPackage(), "com.obric.matrix") == true) goto L11;
        return null;
    L11:
        if (this.f11969a.match(r17) == 1) goto L13;
        return null;
    L13:
        if (r19 == null) goto L15;
        Integer r12 = Integer.valueOf(r19.getInt(WsConstants.KEY_CHANNEL_ID, 0));
    L17:
        if (r19 == null) goto L19;
        Long r13 = Long.valueOf(r19.getLong("seq_id", 0));
    L20:
        if (r19 == null) goto L22;
        Long r14 = Long.valueOf(r19.getLong(ReportProtocal.KEY_LOG_ID, 0));
    L23:
        if (r19 == null) goto L25;
        Integer r15 = Integer.valueOf(r19.getInt("service", 0));
    L26:
        if (r19 == null) goto L28;
        Integer r16 = Integer.valueOf(r19.getInt("method", 0));
    L30:
        if (r19 == null) goto L32;
        Serializable r21 = r19.getSerializable("ws_headers");
    L33:
        if (r21 == null) goto L41;
        if (r19 == null) goto L36;
        Serializable r22 = r19.getSerializable("ws_headers");
    L37:
        if (r22 == null) goto L40;
        HashMap r110 = (HashMap) r22;
    L42:
        if (r19 == null) goto L44;
        String r111 = r19.getString("payload_type");
    L45:
        if (r19 == null) goto L47;
        String r112 = r19.getString("payload_encoding");
    L48:
        if (r19 == null) goto L50;
        r11 = r19.getByteArray(WsConstants.KEY_PAYLOAD);
    L50:
        MatrixWsHelper r23 = MatrixWsHelper.f11959a;
        q.d(r12);
        int r24 = r12.intValue();
        q.d(r13);
        long r25 = r13.longValue();
        q.d(r14);
        long r113 = r14.longValue();
        q.d(r15);
        int r26 = r15.intValue();
        q.d(r16);
        r23.f(r24, r25, r113, r26, r16.intValue(), r112, r111, r11, r110);
        MatrixCursor r27 = new MatrixCursor(new String[]{"received"});
        r27.addRow(new String[]{"true"});
        return r27;
    L47:
        r112 = null;
        goto L48
    L44:
        r111 = null;
        goto L45
    L40:
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
    L36:
        r22 = null;
        goto L37
    L41:
        r110 = null;
        goto L42
    L32:
        r21 = null;
        goto L33
    L28:
        r16 = null;
        goto L30
    L25:
        r15 = null;
        goto L26
    L22:
        r14 = null;
        goto L23
    L19:
        r13 = null;
        goto L20
    L15:
        r12 = null;
        goto L17
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        q.g(r10, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        q.g(r10, "uri");
        a("query() called with: uri = " + r10 + ", projection = " + r11 + ", selection = " + r12 + ", selectionArgs = " + r13 + ", sortOrder = " + r14);
        return null;
    }
}
