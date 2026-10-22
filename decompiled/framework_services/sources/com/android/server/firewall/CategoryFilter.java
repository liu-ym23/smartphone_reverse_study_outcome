package com.android.server.firewall;

import android.content.ComponentName;
import android.content.Intent;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class CategoryFilter implements Filter {
    private static final String ATTR_NAME = "name";
    public static final FilterFactory FACTORY = null;
    private final String mCategoryName;

    /* synthetic */ CategoryFilter(String r1, CategoryFilterIA r2) {
        this(r1);
    }

    private CategoryFilter(String categoryName) {
        this.mCategoryName = categoryName;
    }

    @Override // com.android.server.firewall.Filter
    public boolean matches(IntentFirewall ifw, ComponentName resolvedComponent, Intent intent, int callerUid, int callerPid, String resolvedType, int receivingUid) {
        Set<String> categories = intent.getCategories();
        if (categories != null) goto L7;
        return false;
    L7:
        return categories.contains(this.mCategoryName);
    }

    static {
        final String r1 = "category";
        FACTORY = new AnonymousClass1(r1);
    }
}
