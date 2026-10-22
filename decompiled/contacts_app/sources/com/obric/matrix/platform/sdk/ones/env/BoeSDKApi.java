package com.obric.matrix.platform.sdk.ones.env;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoeSDKApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/env/BoeSDKApi;", "", "()V", "AUTHORITY", "", "BOE_URI", "FIELD_IS_BOE", "FIELD_IS_PPE", "PPE_URI", "TAG", "getBoe", "", "context", "Landroid/content/Context;", "getPpe", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BoeSDKApi {
    private static final String AUTHORITY = "com.obric.matrix.boe";
    private static final String BOE_URI = "content://com.obric.matrix.boe/get_boe";
    private static final String FIELD_IS_BOE = "is_boe";
    private static final String FIELD_IS_PPE = "is_ppe";
    public static final BoeSDKApi INSTANCE = null;
    private static final String PPE_URI = "content://com.obric.matrix.boe/get_ppe";
    private static final String TAG = "BoeSDKApi";

    static {
        INSTANCE = new BoeSDKApi();
    }

    private BoeSDKApi() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int getBoe(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        ?? r1 = 0;
        Cursor r11 = r10.getContentResolver().query(Uri.parse(BOE_URI), null, null, null, null);     // Catch: Throwable -> L19 Exception -> L21
    L33:
        if (r11 != null) goto L8;
        MLog.e$default(TAG, "getBoe() is null", null, 4, null);     // Catch: Exception -> L17 Throwable -> L27
        return 0;
    L8:
        int r3 = 0;
    L10:
        if (r11.moveToNext() == false) goto L14;
        int r4 = r11.getColumnIndex(FIELD_IS_BOE);     // Catch: Exception -> L17 Throwable -> L27
        if (r4 < 0) goto L10;
        r3 = r11.getInt(r4);     // Catch: Exception -> L17 Throwable -> L27
        goto L10
    L14:
        MLog.d$default(TAG, "getBoe() isBoe: " + r3, null, 4, null);     // Catch: Exception -> L17 Throwable -> L27
        r11.close();
        return r3;
    L17:
        Exception e = e;
    L23:
        MLog.e(TAG, "getBoe Exception ", e);     // Catch: Throwable -> L27
        if (r11 == null) goto L26;
        r11.close();
    L26:
        return 0;
    L27:
        th = th;
        r1 = r10;
    L29:
        if (r1 == 0) goto L31;
        r1.close();
    L31:
        throw th;
    L21:
        e = move-exception;
        e = e;
        r11 = null;
    L19:
        th = th;
        goto L29
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int getPpe(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        ?? r1 = 0;
        Cursor r11 = r10.getContentResolver().query(Uri.parse(PPE_URI), null, null, null, null);     // Catch: Throwable -> L19 Exception -> L21
    L33:
        if (r11 != null) goto L8;
        MLog.e$default(TAG, "getPpe() is null", null, 4, null);     // Catch: Exception -> L17 Throwable -> L27
        return 0;
    L8:
        int r3 = 0;
    L10:
        if (r11.moveToNext() == false) goto L14;
        int r4 = r11.getColumnIndex(FIELD_IS_PPE);     // Catch: Exception -> L17 Throwable -> L27
        if (r4 < 0) goto L10;
        r3 = r11.getInt(r4);     // Catch: Exception -> L17 Throwable -> L27
        goto L10
    L14:
        MLog.d$default(TAG, "getPpe() isPpe: " + r3, null, 4, null);     // Catch: Exception -> L17 Throwable -> L27
        r11.close();
        return r3;
    L17:
        Exception e = e;
    L23:
        MLog.e(TAG, "getPpe Exception ", e);     // Catch: Throwable -> L27
        if (r11 == null) goto L26;
        r11.close();
    L26:
        return 0;
    L27:
        th = th;
        r1 = r10;
    L29:
        if (r1 == 0) goto L31;
        r1.close();
    L31:
        throw th;
    L21:
        e = move-exception;
        e = e;
        r11 = null;
    L19:
        th = th;
        goto L29
    }
}
