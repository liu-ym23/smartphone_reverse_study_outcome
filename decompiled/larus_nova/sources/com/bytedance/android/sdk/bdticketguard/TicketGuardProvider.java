package com.bytedance.android.sdk.bdticketguard;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.util.Base64;
import com.bytedance.android.sdk.bdticketguard.attestation.AttestSignResult;
import com.bytedance.android.sdk.bdticketguard.data.TeeStaticSignResult;
import com.bytedance.android.sdk.bdticketguard.init.InitTask;
import com.bytedance.android.sdk.bdticketguard.key.ReeKeyHelper;
import com.bytedance.android.sdk.bdticketguard.key.tee.TeeStaticSignResultAdapter;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.bytedance.zdplib.Delta;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017JQ\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J3\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J=\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/TicketGuardProvider;", "Landroid/content/ContentProvider;", "Landroid/net/Uri;", "uri", "", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "Landroid/content/ContentValues;", "values", "insert", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "<init>", "()V", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 4, 0})
public final class TicketGuardProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f163531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UriMatcher f163532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MainTicketGuardManager f163533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f163534d;

    public final void a() {
        if (this.f163533c != null) goto L9;
        TicketGuardManager r100 = c1.f163567a;
        TicketGuardManager r101 = c1.f163567a;
        if ((r101 instanceof MainTicketGuardManager) == true) goto L7;
        r101 = null;
    L7:
        this.f163533c = (MainTicketGuardManager) r101;
    L9:
        if (this.f163534d == false) goto L11;
        return;
    L11:
        this.f163534d = true;
        this.f163531a = i1.a(getContext());
        UriMatcher r102 = new UriMatcher(-1);
        String r103 = this.f163531a;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L14:
        r102.addURI(r103, "query_csr", 101);
        String r104 = this.f163531a;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L17:
        r102.addURI(r104, "query_client_cert", 102);
        String r105 = this.f163531a;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L20:
        r102.addURI(r105, "query_server_cert", 103);
        String r106 = this.f163531a;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L23:
        r102.addURI(r106, "ticket_data", 104);
        String r107 = this.f163531a;
        if (r107 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L26:
        r102.addURI(r107, "sign", 105);
        String r108 = this.f163531a;
        if (r108 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L29:
        r102.addURI(r108, LBSLightLocationTraceLogger.ENCRYPT, 106);
        String r109 = this.f163531a;
        if (r109 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L32:
        r102.addURI(r109, "decrypt", 107);
        String r110 = this.f163531a;
        if (r110 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L35:
        r102.addURI(r110, "delta_public_key", 108);
        String r111 = this.f163531a;
        if (r111 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L38:
        r102.addURI(r111, "query_ree_public_key", 109);
        String r112 = this.f163531a;
        if (r112 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L41:
        r102.addURI(r112, "query_tee_create_log", 111);
        String r113 = this.f163531a;
        if (r113 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L44:
        r102.addURI(r113, "query_ree_create_log", 112);
        String r114 = this.f163531a;
        if (r114 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L47:
        r102.addURI(r114, "QUERY_TEE_EVER_FAIL", 113);
        String r115 = this.f163531a;
        if (r115 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L50:
        r102.addURI(r115, "QUERY_TEE_PUB", 114);
        String r116 = this.f163531a;
        if (r116 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L53:
        r102.addURI(r116, "query_load", 115);
        String r117 = this.f163531a;
        if (r117 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L56:
        r102.addURI(r117, "update_ticket_data", 200);
        String r118 = this.f163531a;
        if (r118 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L59:
        r102.addURI(r118, "update_cert", 201);
        String r119 = this.f163531a;
        if (r119 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L62:
        r102.addURI(r119, "clear_server_cert", 202);
        String r120 = this.f163531a;
        if (r120 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L65:
        r102.addURI(r120, "update_tee_ever_fail", 203);
        String r121 = this.f163531a;
        if (r121 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L68:
        r102.addURI(r121, "ree_hmac", 204);
        String r122 = this.f163531a;
        if (r122 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L71:
        r102.addURI(r122, "get_attest_sign_cache", 117);
        String r123 = this.f163531a;
        if (r123 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L74:
        r102.addURI(r123, "attest_pub_key", 116);
        String r124 = this.f163531a;
        if (r124 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L77:
        r102.addURI(r124, "update_sec_ts", 205);
        String r125 = this.f163531a;
        if (r125 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L80:
        r102.addURI(r125, "get_tee_static_sign_result", 206);
        this.f163532b = r102;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        if (com.bytedance.android.sdk.bdticketguard.init.j.a(com.bytedance.android.sdk.bdticketguard.init.i.f163785a.f163787b) == true) goto L7;
        com.bytedance.android.sdk.bdticketguard.init.i.f163785a = com.bytedance.android.sdk.bdticketguard.init.i.a.a(com.bytedance.android.sdk.bdticketguard.init.i.f163785a, System.currentTimeMillis(), 0, 0, 0, 0, 125);
        return true;
    L7:
        return true;
    }

    public TicketGuardProvider() {
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        a();
        StringBuilder r101 = new StringBuilder("vnd.android.cursor.item/vnd.");
        String r102 = this.f163531a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("authority");
    L5:
        r101.append(r102);
        r101.append(".item");
        return r101.toString();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public int update(Uri r110, ContentValues r111, String r112, String[] r113) {
        a();
        UriMatcher r114 = this.f163532b;
        if (r114 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("uriMatcher");
    L5:
        boolean r115 = true;
        switch(r114.match(r110)) {
            case 200: goto L45;
            case 201: goto L42;
            case 202: goto L39;
            case 203: goto L32;
            case 204: goto L76;
            case 205: goto L8;
            default: goto L76;
        };
    L8:
        String r100 = UriProtector.getQueryParameter(r110, "sec_ts");
        String r116 = UriProtector.getQueryParameter(r110, "server_time");
        if (r116 == null) goto L11;
        Long r117 = StringsKt.toLongOrNull(r116);
    L12:
        String r101 = UriProtector.getQueryParameter(r110, "system_time");
        if (r101 == null) goto L15;
        Long r102 = StringsKt.toLongOrNull(r101);
    L16:
        String r103 = UriProtector.getQueryParameter(r110, "path");
        String r104 = UriProtector.getQueryParameter(r110, "log_id");
        String r105 = UriProtector.getQueryParameter(r110, "last_server_time");
        if (r105 == null) goto L19;
        Long r118 = StringsKt.toLongOrNull(r105);
    L20:
        int r106 = r0.f163979a;
        r0.a("TicketGuardProvider", "query, uri=" + r110 + ", update sec ts: " + r100);
        if (r100 != null) goto L23;
    L26:
        if (r115 == true) goto L76;
        if (r117 == null) goto L76;
        if (r102 == null) goto L76;
        MainTicketGuardManager r119 = this.f163533c;
        if (r119 == null) goto L76;
        r119.f(new com.bytedance.android.sdk.bdticketguard.data.c(r100, r117.longValue(), r102.longValue(), r103, r104, r118), null);
        goto L76
    L23:
        if (r100.length() == 0) goto L26;
        r115 = false;
        goto L26
    L19:
        r118 = null;
        goto L20
    L15:
        r102 = null;
        goto L16
    L11:
        r117 = null;
        goto L12
    L32:
        r0.a("TicketGuardProvider", "update tee ever fail");
        String r120 = UriProtector.getQueryParameter(r110, "tee_fail_reason");
        if (r120 != null) goto L36;
        r120 = "";
    L36:
        MainTicketGuardManager r121 = this.f163533c;
        if (r121 == null) goto L76;
        r121.Q(r120);
        goto L76
    L39:
        r0.a("TicketGuardProvider", "clear server cert");
        MainTicketGuardManager r122 = this.f163533c;
        if (r122 == null) goto L76;
        ReeKeyHelper r123 = r122.V();
        r123.f163806j = null;
        r123.o().edit().putString("sp_key_server_cert", null).apply();
        r123.f163805i = null;
        TicketGuardEventHelper.f163517g.getClass();
        r0.a("TicketGuardEventHelper", "invalidate server cert");
        TicketGuardEventHelper.B("bd_ticket_guard_invalidate_server_cert", new JSONObject());
        r0.a("TicketGuardEventHelper", "invalidate server cert");
        TicketGuardEventHelper.B("bd_ticket_guard_invalidate_server_cert", new JSONObject());
        goto L76
    L42:
        r0.a("TicketGuardProvider", "update cert");
        String r124 = UriProtector.getQueryParameter(r110, "client_cert");
        String r125 = UriProtector.getQueryParameter(r110, "server_cert");
        MainTicketGuardManager r126 = this.f163533c;
        if (r126 == null) goto L76;
        r126.o(r124, r125);
        goto L76
    L45:
        r0.a("TicketGuardProvider", "update, ticket data");
        String r107 = UriProtector.getQueryParameter(r110, "type");
        String r108 = UriProtector.getQueryParameter(r110, "ticket");
        String r109 = UriProtector.getQueryParameter(r110, "ts_sign");
        String r127 = UriProtector.getQueryParameter(r110, "ts_sign_ree");
        String r128 = UriProtector.getQueryParameter(r110, TextureRenderKeys.KEY_IS_CERT);
        if (r107 != null) goto L48;
    L51:
        boolean r129 = true;
    L52:
        if (r129 == true) goto L76;
        if (r108 != null) goto L55;
    L58:
        boolean r130 = true;
    L59:
        if (r130 == true) goto L76;
        if (r109 != null) goto L62;
    L65:
        boolean r131 = true;
    L66:
        if (r131 == false) goto L73;
        if (r127 != null) goto L69;
    L72:
        if (r115 == true) goto L76;
    L69:
        if (r127.length() == 0) goto L72;
        r115 = false;
    L73:
        MainTicketGuardManager r132 = this.f163533c;
        if (r132 == null) goto L76;
        r132.S(new v0(r107, r108, r109, r127, r128));
        goto L76
    L62:
        if (r109.length() == 0) goto L65;
        r131 = false;
        goto L66
    L55:
        if (r108.length() == 0) goto L58;
        r130 = false;
        goto L59
    L48:
        if (r107.length() == 0) goto L51;
        r129 = false;
    L76:
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r110, String[] r111, String r210, String[] r211, String r212) {
        a();
        UriMatcher r100 = this.f163532b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("uriMatcher");
    L5:
        int r101 = r100.match(r110);
        Object r102 = null;
        String r103 = "";
        if (r101 == 204) goto L252;
        int r112 = 0;
        if (r101 != 206) goto L10;
        int r104 = r0.f163979a;     // Catch: Exception -> L249
        r0.a("TicketGuardProvider", "query, uri=" + r110 + ", tee static sign result");     // Catch: Exception -> L249
        MatrixCursor r105 = new MatrixCursor(new String[]{"tee_static_sign_result", "exception_message"});     // Catch: Exception -> L249
        MainTicketGuardManager r106 = this.f163533c;     // Catch: Exception -> L249
        if (r106 == null) goto L246;
        TeeStaticSignResult r107 = r106.E();     // Catch: Exception -> L249
        TeeStaticSignResultAdapter.f163929c.getClass();     // Catch: Exception -> L249
        Lazy r108 = TeeStaticSignResultAdapter.f163928b;     // Catch: Exception -> L249
        KProperty r109 = TeeStaticSignResultAdapter.a.f163930a[0];     // Catch: Exception -> L249
        String r113 = ((Gson) r108.getValue()).toJson(r107);     // Catch: Exception -> L249
        Unit r114 = Unit.INSTANCE;     // Catch: Exception -> L249
    L247:
        r105.newRow().add(r113);     // Catch: Exception -> L249
        return r105;
    L246:
        r113 = null;
    L249:
        e = move-exception;
        r0.d(6, "TicketGuardProvider", "query tee static sign result failed", e);
    L251:
        return null;
    L10:
        switch(r101) {
            case 101: goto L132;
            case 102: goto L123;
            case 103: goto L114;
            case 104: goto L102;
            case 105: goto L57;
            case 106: goto L43;
            case 107: goto L33;
            case 108: goto L22;
            case 109: goto L13;
            default: goto L11;
        };
    L11:
        switch(r101) {
            case 111: goto L234;
            case 112: goto L225;
            case 113: goto L216;
            case 114: goto L207;
            case 115: goto L177;
            case 116: goto L172;
            case 117: goto L141;
            default: goto L251;
        };
    L141:
        MatrixCursor r115 = new MatrixCursor(new String[]{"attest_sign_result", "exception_message"});
        MatrixCursor.RowBuilder r116 = r115.newRow();
        MainTicketGuardManager r117 = this.f163533c;
        if (r117 == null) goto L170;
        AttestSignResult r118 = r117.u();
        boolean r119 = r118 instanceof AttestSignResult.c;
        Pair[] r120 = new Pair[9];
        r120[0] = TuplesKt.to("isSuccess", Boolean.valueOf(r119));
        r120[1] = TuplesKt.to("adapterName", r118.a());
        if (r119 == false) goto L146;
        String r121 = ((AttestSignResult.c) r118).f163548c;
    L147:
        r120[2] = TuplesKt.to("attestSign", r121);
        boolean r122 = r118 instanceof AttestSignResult.b;
        if (r122 == false) goto L150;
        String r123 = ((AttestSignResult.b) r118).f163545c.getMessage();
    L151:
        r120[3] = TuplesKt.to("error", r123);
        if (r122 == false) goto L154;
        r112 = ((AttestSignResult.b) r118).f163546d;
    L154:
        r120[4] = TuplesKt.to("errorCode", Integer.valueOf(r112));
        if (r119 == false) goto L157;
        Boolean r124 = Boolean.valueOf(((AttestSignResult.c) r118).f163549d);
    L158:
        r120[5] = TuplesKt.to("isCached", r124);
        if (r119 == false) goto L161;
        String r125 = ((AttestSignResult.c) r118).f163550e.b();
    L162:
        r120[6] = TuplesKt.to("signContent", r125);
        if (r119 == false) goto L165;
        Long r126 = Long.valueOf(((AttestSignResult.c) r118).f163551f);
    L166:
        r120[7] = TuplesKt.to("durationNs", r126);
        if (r119 == false) goto L169;
        r102 = ((AttestSignResult.c) r118).f163552g;
    L169:
        r120[8] = TuplesKt.to("attestPubKey", r102);
        r102 = new JSONObject(MapsKt.mapOf(r120)).toString();
        goto L170
    L165:
        r126 = null;
        goto L166
    L161:
        r125 = null;
        goto L162
    L157:
        r124 = null;
        goto L158
    L150:
        r123 = null;
        goto L151
    L146:
        r121 = null;
    L170:
        r116.add(r102);
        return r115;
    L172:
        int r127 = r0.f163979a;
        r0.a("TicketGuardProvider", "query, uri=" + r110 + ", attest pub key");
        MatrixCursor r128 = new MatrixCursor(new String[]{"attest_pub_key"});
        MatrixCursor.RowBuilder r129 = r128.newRow();
        MainTicketGuardManager r130 = this.f163533c;
        if (r130 == null) goto L175;
        r102 = r130.t();
    L175:
        r129.add(r102);
        return r128;
    L177:
        int r131 = r0.f163979a;
        r0.a("TicketGuardProvider", "query, uri=" + r110 + ", load");
        final String r132 = UriProtector.getQueryParameter(r110, "id");
        if (r132 == null) goto L206;
        final String r133 = UriProtector.getQueryParameter(r110, "type");
        if (r133 == null) goto L206;
        String r134 = UriProtector.getQueryParameter(r110, "scene");
        if (r134 == null) goto L184;
        r103 = r134;
    L184:
        Function2<InitTask, com.bytedance.android.sdk.bdticketguard.init.c.f, Unit> r135 = new TicketGuardProvider$query$callback$1(this, r132, r133);
        int r136 = r133.hashCode();
        if (r136 == (-1512632445)) goto L202;
        if (r136 == 112786) goto L197;
        if (r136 != 114708) goto L251;
        if (r133.equals("tee") == false) goto L251;
        MainTicketGuardManager r137 = this.f163533c;
        if (r137 == null) goto L251;
        r137.N(r103, r135);
        Unit r138 = Unit.INSTANCE;
        goto L251
    L197:
        if (r133.equals("ree") == false) goto L251;
        MainTicketGuardManager r139 = this.f163533c;
        if (r139 == null) goto L251;
        r139.M(r103, r135);
        Unit r140 = Unit.INSTANCE;
        goto L251
    L202:
        if (r133.equals("encryption") == false) goto L251;
        MainTicketGuardManager r141 = this.f163533c;
        if (r141 == null) goto L251;
        r141.L(r103, r135);
        Unit r142 = Unit.INSTANCE;
    L206:
        return null;
    L207:
        int r143 = r0.f163979a;
        r0.a("TicketGuardProvider", "query, uri=" + r110 + ", query tee 04 public key");
        MatrixCursor r144 = new MatrixCursor(new String[]{"TEE_PUB"});     // Catch: Exception -> L214
        MatrixCursor.RowBuilder r145 = r144.newRow();     // Catch: Exception -> L214
        MainTicketGuardManager r146 = this.f163533c;     // Catch: Exception -> L214
        if (r146 == null) goto L211;
        String r147 = r146.D();     // Catch: Exception -> L214
    L212:
        r145.add(r147);     // Catch: Exception -> L214
        return r144;
    L211:
        r147 = null;
    L214:
        e = move-exception;
        r0.d(6, "TicketGuardProvider", "query tee 04 public key failed", e);
        goto L251
    L216:
        int r148 = r0.f163979a;
        r0.a("TicketGuardProvider", "query, uri=" + r110 + ", query tee ever fail");
        MatrixCursor r149 = new MatrixCursor(new String[]{"TEE_EVER_FAIL"});     // Catch: Exception -> L223
        MatrixCursor.RowBuilder r150 = r149.newRow();     // Catch: Exception -> L223
        MainTicketGuardManager r151 = this.f163533c;     // Catch: Exception -> L223
        if (r151 == null) goto L220;
        Boolean r152 = Boolean.valueOf(r151.C());     // Catch: Exception -> L223
    L221:
        r150.add(r152);     // Catch: Exception -> L223
        return r149;
    L220:
        r152 = null;
    L223:
        e = move-exception;
        r0.d(6, "TicketGuardProvider", "query tee ever fail failed", e);
        goto L251
    L225:
        int r153 = r0.f163979a;
        r0.a("TicketGuardProvider", "query, uri=" + r110 + ", query ree create log");
        MatrixCursor r154 = new MatrixCursor(new String[]{"ree_create_log"});     // Catch: Exception -> L232
        MatrixCursor.RowBuilder r155 = r154.newRow();     // Catch: Exception -> L232
        MainTicketGuardManager r156 = this.f163533c;     // Catch: Exception -> L232
        if (r156 == null) goto L229;
        String r157 = r156.A();     // Catch: Exception -> L232
    L230:
        r155.add(r157);     // Catch: Exception -> L232
        return r154;
    L229:
        r157 = null;
    L232:
        e = move-exception;
        r0.d(6, "TicketGuardProvider", "query ree create log failed", e);
        goto L251
    L234:
        int r158 = r0.f163979a;
        r0.a("TicketGuardProvider", "query, uri=" + r110 + ", query tee create log");
        MatrixCursor r159 = new MatrixCursor(new String[]{"tee_create_log"});     // Catch: Exception -> L241
        MatrixCursor.RowBuilder r160 = r159.newRow();     // Catch: Exception -> L241
        MainTicketGuardManager r161 = this.f163533c;     // Catch: Exception -> L241
        if (r161 == null) goto L238;
        String r162 = r161.B();     // Catch: Exception -> L241
    L239:
        r160.add(r162);     // Catch: Exception -> L241
        return r159;
    L238:
        r162 = null;
    L241:
        e = move-exception;
        r0.d(6, "TicketGuardProvider", "query tee create log failed", e);
        goto L251
    L13:
        int r163 = r0.f163979a;
        r0.a("TicketGuardProvider", "query, uri=" + r110 + ", ree public key");
        MatrixCursor r164 = new MatrixCursor(new String[]{"ree_public_key"});     // Catch: Exception -> L20
        MatrixCursor.RowBuilder r165 = r164.newRow();     // Catch: Exception -> L20
        MainTicketGuardManager r166 = this.f163533c;     // Catch: Exception -> L20
        if (r166 == null) goto L17;
        String r167 = r166.v();     // Catch: Exception -> L20
    L18:
        r165.add(r167);     // Catch: Exception -> L20
        return r164;
    L17:
        r167 = null;
    L20:
        e = move-exception;
        r0.d(6, "TicketGuardProvider", "query ree public key failed", e);
        goto L251
    L22:
        int r168 = r0.f163979a;
        r0.a("TicketGuardProvider", "query, uri=" + r110 + ", delta public key");
        MatrixCursor r169 = new MatrixCursor(new String[]{"delta_public_key"});     // Catch: Exception -> L31
        MatrixCursor.RowBuilder r170 = r169.newRow();     // Catch: Exception -> L31
        MainTicketGuardManager r171 = this.f163533c;     // Catch: Exception -> L31
        if (r171 == null) goto L28;
        Delta r172 = r171.V().f163805i;     // Catch: Exception -> L31
        if (r172 == null) goto L28;
        String r173 = r172.c();     // Catch: Exception -> L31
    L29:
        r170.add(r173);     // Catch: Exception -> L31
        return r169;
    L28:
        r173 = null;
    L31:
        e = move-exception;
        r0.d(6, "TicketGuardProvider", "query delta public key failed", e);
        goto L251
    L33:
        int r174 = r0.f163979a;
        r0.a("TicketGuardProvider", "query, uri=" + r110 + ", decrypt");
        MatrixCursor r175 = new MatrixCursor(new String[]{"decrypted", "exception_message"});
        String r176 = UriProtector.getQueryParameter(r110, "content");     // Catch: Exception -> L39
        MainTicketGuardManager r177 = this.f163533c;     // Catch: Exception -> L39
        if (r177 != null) goto L37;
        Intrinsics.throwNpe();     // Catch: Exception -> L39
    L37:
        r102 = r177.U(Base64.decode(r176, 0));     // Catch: Exception -> L39
        String r178 = null;
    L41:
        r175.newRow().add(r102).add(r178);
        return r175;
    L39:
        e = move-exception;
        r0.d(6, "TicketGuardProvider", "query decrypt failed", e);
        r178 = e.getMessage();
        goto L41
    L43:
        int r179 = r0.f163979a;
        r0.a("TicketGuardProvider", "query, uri=" + r110 + ", encrypt");
        MatrixCursor r180 = new MatrixCursor(new String[]{"encrypted", "exception_message"});
        String r181 = UriProtector.getQueryParameter(r110, "content");     // Catch: Exception -> L53
        MainTicketGuardManager r182 = this.f163533c;     // Catch: Exception -> L53
        if (r182 != null) goto L47;
        Intrinsics.throwNpe();     // Catch: Exception -> L53
    L47:
        byte[] r183 = Base64.decode(r181, 0);     // Catch: Exception -> L53
        Delta r184 = r182.V().f163805i;     // Catch: Exception -> L53
        if (r184 == null) goto L51;
        byte[] r185 = r184.b(r183);     // Catch: Exception -> L53
    L52:
        r102 = r185;
        String r186 = null;
    L55:
        r180.newRow().add(r102).add(r186);
        return r180;
    L51:
        r185 = null;
    L53:
        e = move-exception;
        r0.d(6, "TicketGuardProvider", "query encrypt failed", e);
        r186 = e.getMessage();
        goto L55
    L57:
        int r187 = r0.f163979a;
        r0.a("TicketGuardProvider", "query, uri=" + r110 + ", sign");
        MatrixCursor r188 = new MatrixCursor(new String[]{"encoded_signed"});     // Catch: Exception -> L100
        String r189 = UriProtector.getQueryParameter(r110, "unsigned");     // Catch: Exception -> L100
        String r190 = UriProtector.getQueryParameter(r110, "path");     // Catch: Exception -> L100
        String r191 = UriProtector.getQueryParameter(r110, "sign_type");     // Catch: Exception -> L100
        boolean r192 = Intrinsics.areEqual(UriProtector.getQueryParameter(r110, "content_encode_base64"), "1");     // Catch: Exception -> L100
        if (r189 != null) goto L61;
    L62:
        r112 = 1;
    L63:
        if (r112 != 0) goto L251;
        if (r191 == null) goto L97;
        int r193 = r191.hashCode();     // Catch: Exception -> L100
        if (r193 == 157663823) goto L85;
        if (r193 != 157665745) goto L97;
        if (r191.equals("sign_type_tee") == false) goto L97;
        if (r192 == false) goto L79;
        byte[] r194 = Base64.decode(r189, 2);     // Catch: Exception -> L100
        MainTicketGuardManager r195 = this.f163533c;     // Catch: Exception -> L100
        if (r195 == null) goto L97;
        if (r190 == null) goto L78;
        r103 = r190;
    L78:
        String r196 = r195.c0(r194, r103, null);     // Catch: Exception -> L100
    L98:
        r188.newRow().add(r196);     // Catch: Exception -> L100
        return r188;
    L79:
        MainTicketGuardManager r197 = this.f163533c;     // Catch: Exception -> L100
        if (r197 == null) goto L97;
        if (r190 == null) goto L83;
        r103 = r190;
    L83:
        r196 = r197.d(r189, r103, null);     // Catch: Exception -> L100
        goto L98
    L85:
        if (r191.equals("sign_type_ree") == false) goto L97;
        if (r192 == false) goto L92;
        byte[] r198 = Base64.decode(r189, 2);     // Catch: Exception -> L100
        MainTicketGuardManager r199 = this.f163533c;     // Catch: Exception -> L100
        if (r199 == null) goto L97;
        if (r190 == null) goto L91;
        r103 = r190;
    L91:
        r196 = r199.a0(r198, r103, null);     // Catch: Exception -> L100
        goto L98
    L92:
        MainTicketGuardManager r200 = this.f163533c;     // Catch: Exception -> L100
        if (r200 == null) goto L97;
        if (r190 == null) goto L96;
        r103 = r190;
    L96:
        r196 = r200.e(r189, r103, null);     // Catch: Exception -> L100
    L97:
        r196 = null;
        goto L98
    L61:
        if (r189.length() != 0) goto L63;
    L100:
        e = move-exception;
        r0.d(6, "TicketGuardProvider", "query sign failed", e);
        goto L251
    L102:
        int r201 = r0.f163979a;
        r0.a("TicketGuardProvider", "query, uri=" + r110 + ", ticket data");
        MatrixCursor r202 = new MatrixCursor(new String[]{"ts_sign", "ts_sign_ree", "type", TextureRenderKeys.KEY_IS_CERT});     // Catch: Exception -> L112
        String r203 = UriProtector.getQueryParameter(r110, "ticket");     // Catch: Exception -> L112
        MainTicketGuardManager r204 = this.f163533c;     // Catch: Exception -> L112
        if (r204 == null) goto L108;
        if (r203 != null) goto L107;
        Intrinsics.throwNpe();     // Catch: Exception -> L112
    L107:
        v0 r205 = r204.F(r203);     // Catch: Exception -> L112
    L109:
        if (r205 == null) goto L251;
        r202.newRow().add(r205.c()).add(r205.d()).add(r205.getType()).add(r205.a());     // Catch: Exception -> L112
        return r202;
    L108:
        r205 = null;
    L112:
        e = move-exception;
        r0.d(6, "TicketGuardProvider", "query ticket data failed", e);
        goto L251
    L114:
        int r206 = r0.f163979a;
        r0.a("TicketGuardProvider", "query, uri=" + r110 + ", server cert");
        MatrixCursor r207 = new MatrixCursor(new String[]{"server_cert_string", "serial_number", "public_key"});     // Catch: Exception -> L121
        MainTicketGuardManager r208 = this.f163533c;     // Catch: Exception -> L121
        if (r208 == null) goto L251;
        l0 r209 = r208.k();     // Catch: Exception -> L121
        if (r209 == null) goto L251;
        r207.newRow().add(r209.a()).add(r209.c()).add(r209.b());     // Catch: Exception -> L121
        return r207;
    L121:
        e = move-exception;
        r0.d(6, "TicketGuardProvider", "query server cert failed", e);
        goto L251
    L123:
        int r213 = r0.f163979a;
        r0.a("TicketGuardProvider", "query, uri=" + r110 + ", client cert");
        MatrixCursor r214 = new MatrixCursor(new String[]{"client_cert"});     // Catch: Exception -> L130
        MatrixCursor.RowBuilder r215 = r214.newRow();     // Catch: Exception -> L130
        MainTicketGuardManager r216 = this.f163533c;     // Catch: Exception -> L130
        if (r216 == null) goto L127;
        String r217 = r216.m();     // Catch: Exception -> L130
    L128:
        r215.add(r217);     // Catch: Exception -> L130
        return r214;
    L127:
        r217 = null;
    L130:
        e = move-exception;
        r0.d(6, "TicketGuardProvider", "query client cert failed", e);
        goto L251
    L132:
        int r218 = r0.f163979a;
        r0.a("TicketGuardProvider", "query, uri=" + r110 + ", csr");
        MatrixCursor r219 = new MatrixCursor(new String[]{"csr"});     // Catch: Exception -> L139
        MatrixCursor.RowBuilder r220 = r219.newRow();     // Catch: Exception -> L139
        MainTicketGuardManager r221 = this.f163533c;     // Catch: Exception -> L139
        if (r221 == null) goto L136;
        String r222 = r221.x();     // Catch: Exception -> L139
    L137:
        r220.add(r222);     // Catch: Exception -> L139
        return r219;
    L136:
        r222 = null;
    L139:
        e = move-exception;
        r0.d(6, "TicketGuardProvider", "query csr failed", e);
        goto L251
    L252:
        int r223 = r0.f163979a;
        r0.a("TicketGuardProvider", "query, uri=" + r110 + ", ree_hmac");
        MatrixCursor r224 = new MatrixCursor(new String[]{"ree_hmac_result", "exception_message"});
        String r225 = UriProtector.getQueryParameter(r110, "content");     // Catch: Exception -> L264
        String r226 = UriProtector.getQueryParameter(r110, "path");     // Catch: Exception -> L264
        if (r225 == null) goto L262;
        MainTicketGuardManager r227 = this.f163533c;     // Catch: Exception -> L264
        if (r227 != null) goto L258;
        Intrinsics.throwNpe();     // Catch: Exception -> L264
    L258:
        if (r226 == null) goto L260;
        r103 = r226;
    L260:
        String r228 = r227.j(r225, r103, null);     // Catch: Exception -> L264
    L263:
        r102 = r228;
        String r229 = null;
    L266:
        r224.newRow().add(r102).add(r229);
        return r224;
    L262:
        r228 = null;
    L264:
        e = move-exception;
        r0.d(6, "TicketGuardProvider", "query encrypt failed", e);
        r229 = e.getMessage();
        goto L266
    }
}
