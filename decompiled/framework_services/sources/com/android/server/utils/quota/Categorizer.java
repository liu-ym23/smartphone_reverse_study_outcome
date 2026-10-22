package com.android.server.utils.quota;

/* JADX INFO: loaded from: classes3.dex */
public interface Categorizer {
    public static final Categorizer SINGLE_CATEGORIZER = null;

    static /* synthetic */ Category $r8$lambda$qiD_Ajv5StXAZdHWcdGVrk65ONA(int r0, String r1, String r2) {
        return lambda$static$0(r0, r1, r2);
    }

    Category getCategory(int r1, String r2, String r3);

    static {
        SINGLE_CATEGORIZER = new Categorizer$$ExternalSyntheticLambda0();
    }

    private static /* synthetic */ Category lambda$static$0(int userId, String packageName, String tag) {
        return Category.SINGLE_CATEGORY;
    }
}
