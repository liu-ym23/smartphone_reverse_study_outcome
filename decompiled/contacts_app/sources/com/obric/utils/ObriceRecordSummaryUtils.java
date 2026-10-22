package com.obric.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.GlobalProxyLancet;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.callsummary.bean.CallSummary;
import com.obric.contactprovider.ObricCallLogProviderHelper;
import com.obric.database.entity.RecordASRMessageEntity;
import com.obric.database.entity.RecordInfoEntity;
import com.obric.model.CallFeatureModel;
import com.obric.model.bean.CallFeatureBean;
import com.obric.oui.common.util.ToolsExtKt;
import java.io.FileNotFoundException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ObriceRecordSummaryUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\bJ0\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\n0\u000fJ+\u0010\u0011\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0013J+\u0010\u0014\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/obric/utils/ObriceRecordSummaryUtils;", "", "()V", "getCallLogSummaryText", "", "date", "", "number", "(Ljava/lang/Long;Ljava/lang/String;)Ljava/lang/String;", "getRecordFile", "", "context", "Landroid/content/Context;", Params.FILE_PATH, "callback", "Lkotlin/Function1;", "Landroid/os/ParcelFileDescriptor;", "hasASRMessage", "", "(Landroid/content/Context;Ljava/lang/Long;Ljava/lang/String;)Z", "recordFileNotExists", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ObriceRecordSummaryUtils {
    public static final ObriceRecordSummaryUtils INSTANCE = null;

    static {
        INSTANCE = new ObriceRecordSummaryUtils();
    }

    private ObriceRecordSummaryUtils() {
    }

    @JvmStatic
    public static final boolean recordFileNotExists(Context r7, Long r8, String r9) {
        if (r7 != null) goto L5;
        return true;
    L5:
        ObricCallLogProviderHelper r4 = ObricCallLogProviderHelper.INSTANCE;
        if (r8 == null) goto L8;
        long r5 = r8.longValue();
    L9:
        if (r9 != null) goto L11;
        r9 = "";
    L11:
        List<RecordInfoEntity> r10 = r4.getRecordInfoEntity(r7, r5, r9);
        boolean r6 = false;
        if ((!r10.isEmpty()) == false) goto L14;
        String r11 = r10.get(0).getPath();
    L54:
        Uri r12 = Uri.parse(r11);     // Catch: Exception -> L41 SecurityException -> L44 FileNotFoundException -> L47
        StringBuilder r13 = new StringBuilder("recordFilePath is null: ");     // Catch: Exception -> L41 SecurityException -> L44 FileNotFoundException -> L47
        String r14 = r11;     // Catch: Exception -> L41 SecurityException -> L44 FileNotFoundException -> L47
        if (r14 != null) goto L18;
    L21:
        boolean r15 = true;
    L22:
        StringBuilder r16 = r13.append(r15).append(" , uri is null: ");     // Catch: Exception -> L41 SecurityException -> L44 FileNotFoundException -> L47
        if (r12 != null) goto L25;
        boolean r2 = true;
    L26:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("ObriceRecordSummaryUtils", r16.append(r2).toString());     // Catch: Exception -> L41 SecurityException -> L44 FileNotFoundException -> L47
        ParcelFileDescriptor r17 = r7.getContentResolver().openFileDescriptor(r12, "r");     // Catch: Exception -> L41 SecurityException -> L44 FileNotFoundException -> L47
        if (r17 == null) goto L40;
        ParcelFileDescriptor r18 = r17;     // Catch: Exception -> L41 SecurityException -> L44 FileNotFoundException -> L47
        ParcelFileDescriptor r19 = r18;     // Catch: Throwable -> L35
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("ObriceRecordSummaryUtils", "file size: " + r19.getStatSize());     // Catch: Throwable -> L35
        if (r19.getStatSize() > 0) goto L33;
        r6 = true;
    L33:
        CloseableKt.closeFinally(r18, null);     // Catch: Exception -> L41 SecurityException -> L44 FileNotFoundException -> L47
        return r6;
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);     // Catch: Exception -> L41 SecurityException -> L44 FileNotFoundException -> L47
        throw th;     // Catch: Exception -> L41 SecurityException -> L44 FileNotFoundException -> L47
    L40:
        return true;
    L25:
        r2 = false;
        goto L26
    L18:
        if (r14.length() == 0) goto L21;
        r15 = false;
    L47:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("ObriceRecordSummaryUtils", "File not found", e);
        return true;
    L44:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("ObriceRecordSummaryUtils", "Security exception when checking file", e);
        return true;
    L41:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("ObriceRecordSummaryUtils", "Error checking file existence", e);
        return true;
    L14:
        r11 = null;
        goto L54
    L8:
        r5 = -1;
        goto L9
    }

    @JvmStatic
    public static final boolean hasASRMessage(Context r8, Long r9, String r10) {
        boolean r0 = false;
        if (r8 != null) goto L5;
        return false;
    L5:
        CallFeatureModel r1 = CallFeatureModel.INSTANCE;
        long r2 = -1;
        if (r9 == null) goto L8;
        long r4 = r9.longValue();
    L10:
        if (r10 != null) goto L12;
        String r7 = "";
    L13:
        CallFeatureBean r3 = r1.getCallFeature(r4, r7);
        if (r3 != null) goto L16;
    L18:
        if (r0 == true) goto L20;
    L27:
        List<RecordASRMessageEntity> r11 = CollectionsKt.emptyList();
    L29:
        return !r11.isEmpty();
    L20:
        if (r3.isRecordASRAvailable() == false) goto L27;
        ObricCallLogProviderHelper r5 = ObricCallLogProviderHelper.INSTANCE;
        if (r9 == null) goto L24;
        r2 = r9.longValue();
    L24:
        if (r10 != null) goto L26;
        r10 = "";
    L26:
        r11 = r5.getRecordASRMessageEntity(r8, r2, r10);
        goto L29
    L16:
        if (r3.isFeatureCallRecordEnabled() != true) goto L18;
        r0 = true;
        goto L18
    L12:
        r7 = r10;
        goto L13
    L8:
        r4 = -1;
        goto L10
    }

    @JvmStatic
    public static final String getCallLogSummaryText(Long r4, String r5) {
        if (r4 == null) goto L27;
        r4.longValue();
        if (r5 != null) goto L7;
        return "";
    L7:
        CallFeatureBean r6 = CallFeatureModel.INSTANCE.getCallFeature(r4.longValue(), r5);
        if (r6 == null) goto L27;
        CallSummary r7 = r6.getSummary();
        if (r7 == null) goto L27;
        String r8 = StringsKt.trim(r7.getTitle()).toString();
        boolean r1 = true;
        int r2 = 0;
        if (r8.length() <= 0) goto L14;
        boolean r0 = true;
    L15:
        if (r0 == false) goto L17;
        return r8;
    L17:
        StringBuilder r9 = new StringBuilder(r7.getSummary());
        String r3 = r9.toString();
        Intrinsics.checkNotNullExpressionValue(r3, "summaryStr.toString()");
        if (r3.length() == 0) goto L21;
        r1 = false;
    L21:
        if (r1 == false) goto L25;
        List<String> r10 = r7.getItems();
        int r11 = r10.size();
    L23:
        if (r2 >= r11) goto L25;
        r9.append(r10.get(r2));
        r2 = r2 + 1;
    L25:
        String r12 = r9.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "summaryStr.toString()");
        return r12;
    L14:
        r0 = false;
    L27:
        return "";
    }

    public final void getRecordFile(Context r2, String r3, final Function1<? super ParcelFileDescriptor, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (r3 != null) goto L6;
        r4.invoke(null);
        return;
    L6:
        Uri r1 = Uri.parse(r3);
        if (r2 == null) goto L20;
        ContentResolver r5 = r2.getContentResolver();
        if (r5 == null) goto L25;
        ParcelFileDescriptor r6 = r5.openFileDescriptor(r1, "r");
        if (r6 == null) goto L26;
        ParcelFileDescriptor r7 = r6;
        final ParcelFileDescriptor r8 = r7;     // Catch: Throwable -> L15
        ToolsExtKt.runInUIThread(new ObriceRecordSummaryUtils$getRecordFile$2$1(r4, r8));     // Catch: Throwable -> L15
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r7, null);
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L26:
        return;
    L25:
        return;
    }
}
