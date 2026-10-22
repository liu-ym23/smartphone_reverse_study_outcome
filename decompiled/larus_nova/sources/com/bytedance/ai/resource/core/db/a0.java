package com.bytedance.ai.resource.core.db;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes43.dex */
public final class a0 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM ai_widget_info WHERE package_name = ?";
    }

    public a0(AIPackageDatabase r100) {
        super(r100);
    }
}
