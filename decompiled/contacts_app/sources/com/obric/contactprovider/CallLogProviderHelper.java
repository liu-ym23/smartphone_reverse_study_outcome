package com.obric.contactprovider;

import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallLogProviderHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/contactprovider/CallLogProviderHelper;", "", "()V", "TAG", "", "getCallDuration", "", "context", "Landroid/content/Context;", "callCreateTime", "phoneNumber", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogProviderHelper {
    public static final CallLogProviderHelper INSTANCE = null;
    private static final String TAG = "CallLogProviderHelper";

    static {
        INSTANCE = new CallLogProviderHelper();
    }

    private CallLogProviderHelper() {
    }

    public final long getCallDuration(Context r7, long r8, String r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r10, "phoneNumber");
        Cursor r9 = r7.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"duration"}, "date=? AND number=?", new String[]{String.valueOf(r8), r10}, null);
        if (r9 == null) goto L19;
        Cursor r11 = r9;
        Cursor r12 = r11;     // Catch: Throwable -> L14
        if (r12.moveToFirst() == false) goto L12;
        int r6 = r12.getColumnIndex("duration");     // Catch: Throwable -> L14
        if (r6 == (-1)) goto L12;
        long r13 = r12.getLong(r6);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r11, null);
        return r13;
    L12:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r11, null);
        return 0;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L19:
        return 0;
    }
}
