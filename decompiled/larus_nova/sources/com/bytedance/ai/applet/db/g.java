package com.bytedance.ai.applet.db;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes43.dex */
public final class g extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM widget_context_info WHERE card_id = ?";
    }

    public g(WidgetContextDatabase r100) {
        super(r100);
    }
}
