package com.obric.smssdk;

import android.database.Cursor;
import com.android.contacts.obricsync.SyncContractKt;
import com.bytedance.tracing.internal.TracingConstants;
import com.obric.callandsms.common.Logger;
import kotlin.Metadata;

/* JADX INFO: compiled from: SmsMmsColumnsMap.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010!\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\"\u001a\u0004\u0018\u00010#J\"\u0010!\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u0006R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0011\u0010\u001b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\bR\u0011\u0010\u001d\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\bR\u0011\u0010\u001f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\b¨\u0006%"}, d2 = {"Lcom/obric/smssdk/SmsMmsColumnsMap;", "", "cursor", "Landroid/database/Cursor;", "(Landroid/database/Cursor;)V", "columnMmsContentType", "", "getColumnMmsContentType", "()I", "columnMmsDate", "getColumnMmsDate", "columnMmsMessageBox", "getColumnMmsMessageBox", "columnMmsMessageType", "getColumnMmsMessageType", "columnMmsTextOnly", "getColumnMmsTextOnly", "columnMsgId", "getColumnMsgId", "columnMsgType", "getColumnMsgType", "columnSmsAddress", "getColumnSmsAddress", "columnSmsBody", "getColumnSmsBody", "columnSmsDate", "getColumnSmsDate", "columnSmsDateSent", "getColumnSmsDateSent", "columnSmsType", "getColumnSmsType", "columnThreadId", "getColumnThreadId", "getColumnIndex", "columnName", "", "defaultIndex", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SmsMmsColumnsMap {
    private final int columnMmsContentType;
    private final int columnMmsDate;
    private final int columnMmsMessageBox;
    private final int columnMmsMessageType;
    private final int columnMmsTextOnly;
    private final int columnMsgId;
    private final int columnMsgType;
    private final int columnSmsAddress;
    private final int columnSmsBody;
    private final int columnSmsDate;
    private final int columnSmsDateSent;
    private final int columnSmsType;
    private final int columnThreadId;

    public SmsMmsColumnsMap(Cursor r4) {
        this.columnMsgType = getColumnIndex(r4, "transport_type", -1);
        this.columnThreadId = getColumnIndex(r4, TracingConstants.KEY_THREAD_NAME, -1);
        this.columnMsgId = getColumnIndex(r4, "_id", -1);
        this.columnSmsAddress = getColumnIndex(r4, SyncContractKt.COLUMN_ADDRESS, -1);
        this.columnSmsBody = getColumnIndex(r4, "body", -1);
        this.columnSmsDate = getColumnIndex(r4, "date", -1);
        this.columnSmsDateSent = getColumnIndex(r4, "date_sent", -1);
        this.columnSmsType = getColumnIndex(r4, "type", -1);
        this.columnMmsDate = getColumnIndex(r4, "date", -1);
        this.columnMmsMessageType = getColumnIndex(r4, "m_type", -1);
        this.columnMmsMessageBox = getColumnIndex(r4, "msg_box", -1);
        this.columnMmsTextOnly = getColumnIndex(r4, "text_only", -1);
        this.columnMmsContentType = getColumnIndex(r4, "ct_t", -1);
    }

    public final int getColumnMsgType() {
        return this.columnMsgType;
    }

    public final int getColumnThreadId() {
        return this.columnThreadId;
    }

    public final int getColumnMsgId() {
        return this.columnMsgId;
    }

    public final int getColumnSmsAddress() {
        return this.columnSmsAddress;
    }

    public final int getColumnSmsBody() {
        return this.columnSmsBody;
    }

    public final int getColumnSmsDate() {
        return this.columnSmsDate;
    }

    public final int getColumnSmsDateSent() {
        return this.columnSmsDateSent;
    }

    public final int getColumnSmsType() {
        return this.columnSmsType;
    }

    public final int getColumnMmsDate() {
        return this.columnMmsDate;
    }

    public final int getColumnMmsMessageType() {
        return this.columnMmsMessageType;
    }

    public final int getColumnMmsMessageBox() {
        return this.columnMmsMessageBox;
    }

    public final int getColumnMmsTextOnly() {
        return this.columnMmsTextOnly;
    }

    public final int getColumnMmsContentType() {
        return this.columnMmsContentType;
    }

    public final int getColumnIndex(Cursor r2, String r3) {
        return getColumnIndex(r2, r3, 0);
    }

    public final int getColumnIndex(Cursor r7, String r8, int r9) {
        if (r7 == null) goto L12;
        return r7.getColumnIndexOrThrow(r8);
    L5:
        e = move-exception;
        String r2 = e.getMessage();
        if (r2 == null) goto L13;
        Logger.e$default(Logger.INSTANCE, "colsMap", r2, null, 4, null);
        return r9;
    L13:
        return r9;
    L12:
        return r9;
    }
}
