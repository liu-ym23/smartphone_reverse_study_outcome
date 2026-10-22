package com.bytedance.ai.resource.core.db;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ai.model.objects.Widget;

/* JADX INFO: loaded from: classes43.dex */
public final class t extends EntityDeletionOrUpdateAdapter<Widget> {
    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM `ai_widget_info` WHERE `id` = ?";
    }

    public t(AIPackageDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final void bind(SupportSQLiteStatement r100, Widget r101) {
        r100.bindLong(1, r101.f36906m);
    }
}
