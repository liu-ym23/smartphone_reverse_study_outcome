package com.android.server.utils.quota;

import android.util.proto.ProtoOutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class Uptc {
    private final int mHash;
    public final String packageName;
    public final String tag;
    public final int userId;

    Uptc(int userId, String packageName, String tag) {
        this.userId = userId;
        this.packageName = packageName;
        this.tag = tag;
        if ((((userId * 31) + (packageName.hashCode() * 31)) + tag) != null) goto L5;
        int r0 = 0;
    L6:
        this.mHash = r0;
        return;
    L5:
        r0 = tag.hashCode() * 31;
        goto L6
    }

    public String toString() {
        return string(this.userId, this.packageName, this.tag);
    }

    void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, this.userId);
        proto.write(1138166333442L, this.packageName);
        proto.write(1138166333443L, this.tag);
        proto.end(token);
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if ((obj instanceof Uptc) == false) goto L16;
        Uptc other = (Uptc) obj;
        if (this.userId != other.userId) goto L15;
        if (Objects.equals(this.packageName, other.packageName) == false) goto L15;
        if (Objects.equals(this.tag, other.tag) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public int hashCode() {
        return this.mHash;
    }

    static String string(int userId, String packageName, String tag) {
        StringBuilder r0 = new StringBuilder();
        r0.append("<");
        r0.append(userId);
        r0.append(">");
        r0.append(packageName);
        if (tag != null) goto L5;
        String r1 = "";
    L6:
        r0.append(r1);
        return r0.toString();
    L5:
        r1 = "::" + tag;
        goto L6
    }
}
