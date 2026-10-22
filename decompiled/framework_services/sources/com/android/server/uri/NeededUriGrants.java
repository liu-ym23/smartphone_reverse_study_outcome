package com.android.server.uri;

import android.util.ArraySet;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class NeededUriGrants {
    final int flags;
    final String targetPkg;
    final int targetUid;
    final ArraySet<GrantUri> uris;

    public NeededUriGrants(String targetPkg, int targetUid, int flags) {
        this.targetPkg = targetPkg;
        this.targetUid = targetUid;
        this.flags = flags;
        this.uris = new ArraySet();
    }

    public void merge(NeededUriGrants other) {
        if (other != null) goto L5;
        return;
    L5:
        if (Objects.equals(this.targetPkg, other.targetPkg) == true) goto L7;
    L12:
        Slog.wtf("NeededUriGrants", "The other NeededUriGrants does not share the same targetUid, targetPkg or flags. It cannot be merged into this NeededUriGrants. This NeededUriGrants: " + toStringWithoutUri() + ". Other NeededUriGrants: " + other.toStringWithoutUri());
        return;
    L7:
        if (this.targetUid != other.targetUid) goto L12;
        if (this.flags != other.flags) goto L12;
        this.uris.addAll(other.uris);
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1138166333441L, this.targetPkg);
        proto.write(1120986464258L, this.targetUid);
        proto.write(1120986464259L, this.flags);
        int N = this.uris.size();
        int i = 0;
    L3:
        if (i >= N) goto L5;
        this.uris.valueAt(i).dumpDebug(proto, 2246267895812L);
        i = i + 1;
        goto L3
    L5:
        proto.end(token);
    }

    public String toStringWithoutUri() {
        return "NeededUriGrants{targetPkg='" + this.targetPkg + "', targetUid=" + this.targetUid + ", flags=" + this.flags + '}';
    }
}
