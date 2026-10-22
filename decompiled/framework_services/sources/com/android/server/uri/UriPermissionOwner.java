package com.android.server.uri;

import android.os.Binder;
import android.os.IBinder;
import android.util.ArraySet;
import android.util.proto.ProtoOutputStream;
import com.google.android.collect.Sets;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class UriPermissionOwner {
    private Binder externalToken;
    private final Object mOwner;
    private ArraySet<UriPermission> mReadPerms;
    private final UriGrantsManagerInternal mService;
    private ArraySet<UriPermission> mWritePerms;

    class ExternalToken extends Binder {
        final /* synthetic */ UriPermissionOwner this$0;

        ExternalToken(UriPermissionOwner this$0) {
            this.this$0 = this$0;
        }

        UriPermissionOwner getOwner() {
            return this.this$0;
        }
    }

    public UriPermissionOwner(UriGrantsManagerInternal service, Object owner) {
        this.mService = service;
        this.mOwner = owner;
    }

    public Binder getExternalToken() {
        if (this.externalToken != null) goto L6;
        this.externalToken = new ExternalToken(this);
    L6:
        return this.externalToken;
    }

    static UriPermissionOwner fromExternalToken(IBinder token) {
        if ((token instanceof ExternalToken) == true) goto L5;
        return null;
    L5:
        return ((ExternalToken) token).getOwner();
    }

    public void removeUriPermissions() {
        removeUriPermissions(3);
    }

    void removeUriPermissions(int mode) {
        removeUriPermission(null, mode);
    }

    void removeUriPermission(GrantUri grantUri, int mode) {
        removeUriPermission(grantUri, mode, null, -1);
    }

    void removeUriPermission(GrantUri grantUri, int mode, String targetPgk, int targetUserId) {
        ArrayList<UriPermission> readPermsToRemove = new ArrayList();
        ArrayList<UriPermission> writePermsToRemove = new ArrayList();
        monitor-enter(this);
        if ((mode & 1) == 0) goto L31;
    L16:
        th = move-exception;
        throw th;
    L7:
        if (this.mReadPerms == null) goto L31;
        Iterator<UriPermission> it = this.mReadPerms.iterator();     // Catch: Throwable -> L16
    L10:
        if (it.hasNext() == false) goto L28;
        UriPermission perm = it.next();     // Catch: Throwable -> L16
        if (grantUri == null) goto L18;
        if (grantUri.equals(perm.uri) == false) goto L10;
    L18:
        if (targetPgk == null) goto L22;
        if (targetPgk.equals(perm.targetPkg) == false) goto L10;
    L22:
        if (targetUserId == (-1)) goto L26;
        if (targetUserId != perm.targetUserId) goto L10;
    L26:
        readPermsToRemove.add(perm);     // Catch: Throwable -> L16
        it.remove();     // Catch: Throwable -> L16
        goto L10
    L28:
        if (this.mReadPerms.isEmpty() == false) goto L31;
        this.mReadPerms = null;     // Catch: Throwable -> L16
    L31:
        if ((mode & 2) != 0) goto L33;
    L54:
        monitor-exit(this);     // Catch: Throwable -> L16
        int i = 0;
        int size = readPermsToRemove.size();
    L56:
        if (i >= size) goto L58;
        UriPermission perm2 = readPermsToRemove.get(i);
        perm2.removeReadOwner(this);
        this.mService.removeUriPermissionIfNeeded(perm2);
        i = i + 1;
        goto L56
    L58:
        int i2 = 0;
        int size2 = writePermsToRemove.size();
    L59:
        if (i2 >= size2) goto L62;
        UriPermission perm3 = writePermsToRemove.get(i2);
        perm3.removeWriteOwner(this);
        this.mService.removeUriPermissionIfNeeded(perm3);
        i2 = i2 + 1;
        goto L59
    L62:
        return;
    L33:
        if (this.mWritePerms == null) goto L54;
        Iterator<UriPermission> it2 = this.mWritePerms.iterator();     // Catch: Throwable -> L16
    L36:
        if (it2.hasNext() == false) goto L52;
        UriPermission perm4 = it2.next();     // Catch: Throwable -> L16
        if (grantUri == null) goto L42;
        if (grantUri.equals(perm4.uri) == false) goto L36;
    L42:
        if (targetPgk == null) goto L46;
        if (targetPgk.equals(perm4.targetPkg) == false) goto L36;
    L46:
        if (targetUserId == (-1)) goto L50;
        if (targetUserId != perm4.targetUserId) goto L36;
    L50:
        writePermsToRemove.add(perm4);     // Catch: Throwable -> L16
        it2.remove();     // Catch: Throwable -> L16
        goto L36
    L52:
        if (this.mWritePerms.isEmpty() == false) goto L54;
        this.mWritePerms = null;     // Catch: Throwable -> L16
        goto L54
    }

    public void addReadPermission(UriPermission perm) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mReadPerms != null) goto L8;
        this.mReadPerms = Sets.newArraySet();     // Catch: Throwable -> L6
    L8:
        this.mReadPerms.add(perm);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
    }

    public void addWritePermission(UriPermission perm) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mWritePerms != null) goto L8;
        this.mWritePerms = Sets.newArraySet();     // Catch: Throwable -> L6
    L8:
        this.mWritePerms.add(perm);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
    }

    public void removeReadPermission(UriPermission perm) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mReadPerms == null) goto L10;
        this.mReadPerms.remove(perm);     // Catch: Throwable -> L8
        if (this.mReadPerms.isEmpty() == false) goto L10;
        this.mReadPerms = null;     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    public void removeWritePermission(UriPermission perm) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mWritePerms == null) goto L10;
        this.mWritePerms.remove(perm);     // Catch: Throwable -> L8
        if (this.mWritePerms.isEmpty() == false) goto L10;
        this.mWritePerms = null;     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    public void dump(PrintWriter pw, String prefix) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mReadPerms == null) goto L9;
        pw.print(prefix);     // Catch: Throwable -> L6
        pw.print("readUriPermissions=");     // Catch: Throwable -> L6
        pw.println(this.mReadPerms);     // Catch: Throwable -> L6
    L9:
        if (this.mWritePerms == null) goto L11;
        pw.print(prefix);     // Catch: Throwable -> L6
        pw.print("writeUriPermissions=");     // Catch: Throwable -> L6
        pw.println(this.mWritePerms);     // Catch: Throwable -> L6
    L11:
        monitor-exit(this);     // Catch: Throwable -> L6
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1138166333441L, this.mOwner.toString());
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mReadPerms == null) goto L13;
        Iterator<UriPermission> r2 = this.mReadPerms.iterator();     // Catch: Throwable -> L10
    L8:
        if (r2.hasNext() == false) goto L13;
        UriPermission p = r2.next();     // Catch: Throwable -> L10
        p.uri.dumpDebug(proto, 2246267895810L);     // Catch: Throwable -> L10
    L13:
        if (this.mWritePerms == null) goto L18;
        Iterator<UriPermission> r3 = this.mWritePerms.iterator();     // Catch: Throwable -> L10
    L16:
        if (r3.hasNext() == false) goto L18;
        UriPermission p2 = r3.next();     // Catch: Throwable -> L10
        p2.uri.dumpDebug(proto, 2246267895811L);     // Catch: Throwable -> L10
    L18:
        monitor-exit(this);     // Catch: Throwable -> L10
        proto.end(token);
    }

    public String toString() {
        return this.mOwner.toString();
    }
}
