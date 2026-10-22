package com.android.server.utils.quota;

import android.util.proto.ProtoOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class Category {
    public static final Category SINGLE_CATEGORY = null;
    private final int mHash;
    private final String mName;

    static {
        SINGLE_CATEGORY = new Category("SINGLE");
    }

    public Category(String name) {
        this.mName = name;
        this.mHash = name.hashCode();
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if ((other instanceof Category) == true) goto L8;
        return false;
    L8:
        return this.mName.equals(((Category) other).mName);
    }

    public int hashCode() {
        return this.mHash;
    }

    public String toString() {
        return "Category{" + this.mName + "}";
    }

    void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1138166333441L, this.mName);
        proto.end(token);
    }
}
