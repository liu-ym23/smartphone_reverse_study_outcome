package com.bytedance.ai.applet.db;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes43.dex */
public final class e extends EntityDeletionOrUpdateAdapter<i> {
    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM `widget_context_info` WHERE `card_id` = ?";
    }

    public e(WidgetContextDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final void bind(SupportSQLiteStatement r100, i r101) {
        String r102 = r101.f34586a;
        if (r102 != null) goto L5;
        r100.bindNull(1);
        return;
    L5:
        r100.bindString(1, r102);
    }
}
