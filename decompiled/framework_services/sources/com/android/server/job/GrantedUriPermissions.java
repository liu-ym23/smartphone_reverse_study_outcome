package com.android.server.job;

import android.app.UriGrantsManager;
import android.content.ClipData;
import android.content.ContentProvider;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.server.LocalServices;
import com.android.server.uri.UriGrantsManagerInternal;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class GrantedUriPermissions {
    private final int mGrantFlags;
    private final IBinder mPermissionOwner;
    private final int mSourceUserId;
    private final String mTag;
    private final UriGrantsManagerInternal mUriGrantsManagerInternal;
    private final ArrayList<Uri> mUris;

    private GrantedUriPermissions(int grantFlags, int uid, String tag) throws RemoteException {
        this.mUris = new ArrayList();
        this.mGrantFlags = grantFlags;
        this.mSourceUserId = UserHandle.getUserId(uid);
        this.mTag = tag;
        this.mUriGrantsManagerInternal = (UriGrantsManagerInternal) LocalServices.getService(UriGrantsManagerInternal.class);
        this.mPermissionOwner = this.mUriGrantsManagerInternal.newUriPermissionOwner("job: " + tag);
    }

    public void revoke() {
        int i = this.mUris.size() - 1;
    L3:
        if (i < 0) goto L5;
        this.mUriGrantsManagerInternal.revokeUriPermissionFromOwner(this.mPermissionOwner, this.mUris.get(i), this.mGrantFlags, this.mSourceUserId);
        i = i - 1;
        goto L3
    L5:
        this.mUris.clear();
    }

    public static boolean checkGrantFlags(int grantFlags) {
        if ((grantFlags & 3) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static GrantedUriPermissions createFromIntent(Intent intent, int sourceUid, String targetPackage, int targetUserId, String tag) {
        int grantFlags = intent.getFlags();
        if (checkGrantFlags(grantFlags) == true) goto L6;
        return null;
    L6:
        GrantedUriPermissions perms = null;
        Uri data = intent.getData();
        if (data == null) goto L9;
        int sourceUid2 = sourceUid;
        String targetPackage2 = targetPackage;
        int targetUserId2 = targetUserId;
        String tag2 = tag;
        perms = grantUri(data, sourceUid2, targetPackage2, targetUserId2, grantFlags, tag2, null);
    L10:
        ClipData clip = intent.getClipData();
        if (clip != null) goto L13;
        return perms;
    L13:
        return grantClip(clip, sourceUid2, targetPackage2, targetUserId2, grantFlags, tag2, perms);
    L9:
        sourceUid2 = sourceUid;
        targetPackage2 = targetPackage;
        targetUserId2 = targetUserId;
        tag2 = tag;
        goto L10
    }

    public static GrantedUriPermissions createFromClip(ClipData clip, int sourceUid, String targetPackage, int targetUserId, int grantFlags, String tag) {
        if (checkGrantFlags(grantFlags) == true) goto L7;
        return null;
    L7:
        if (clip == null) goto L10;
        GrantedUriPermissions perms = grantClip(clip, sourceUid, targetPackage, targetUserId, grantFlags, tag, null);
        return perms;
    L10:
        return null;
    }

    private static GrantedUriPermissions grantClip(ClipData clip, int sourceUid, String targetPackage, int targetUserId, int grantFlags, String tag, GrantedUriPermissions curPerms) {
        int N = clip.getItemCount();
        int i = 0;
        GrantedUriPermissions curPerms2 = curPerms;
    L3:
        if (i >= N) goto L6;
        curPerms2 = grantItem(clip.getItemAt(i), sourceUid, targetPackage, targetUserId, grantFlags, tag, curPerms2);
        i = i + 1;
        goto L3
    L6:
        return curPerms2;
    }

    private static GrantedUriPermissions grantUri(Uri uri, int sourceUid, String targetPackage, int targetUserId, int grantFlags, String tag, GrantedUriPermissions curPerms) {
        int sourceUserId = ContentProvider.getUserIdFromUri(uri, UserHandle.getUserId(sourceUid));     // Catch: RemoteException -> L16
        Uri uri2 = ContentProvider.getUriWithoutUserId(uri);     // Catch: RemoteException -> L16
        if (curPerms == null) goto L26;
    L24:
        UriGrantsManager.getService().grantUriPermissionFromOwner(curPerms.mPermissionOwner, sourceUid, targetPackage, uri2, grantFlags, sourceUserId, targetUserId);     // Catch: RemoteException -> L12
        curPerms.mUris.add(uri2);     // Catch: RemoteException -> L12
    L19:
        return curPerms;
    L26:
        curPerms = new GrantedUriPermissions(grantFlags, sourceUid, tag);     // Catch: RemoteException -> L6
    L18:
        Slog.e("JobScheduler", "AM dead");
        goto L19
    }

    private static GrantedUriPermissions grantItem(ClipData.Item item, int sourceUid, String targetPackage, int targetUserId, int grantFlags, String tag, GrantedUriPermissions curPerms) {
        if (item.getUri() == null) goto L5;
        GrantedUriPermissions curPerms2 = grantUri(item.getUri(), sourceUid, targetPackage, targetUserId, grantFlags, tag, curPerms);
        int sourceUid2 = sourceUid;
        String targetPackage2 = targetPackage;
        int targetUserId2 = targetUserId;
        int targetUserId3 = grantFlags;
        String tag2 = tag;
        GrantedUriPermissions curPerms3 = curPerms2;
    L6:
        Intent intent = item.getIntent();
        if (intent != null) goto L9;
        return curPerms3;
    L9:
        if (intent.getData() != null) goto L11;
        return curPerms3;
    L11:
        return grantUri(intent.getData(), sourceUid2, targetPackage2, targetUserId2, targetUserId3, tag2, curPerms3);
    L5:
        sourceUid2 = sourceUid;
        targetPackage2 = targetPackage;
        targetUserId2 = targetUserId;
        targetUserId3 = grantFlags;
        tag2 = tag;
        curPerms3 = curPerms;
        goto L6
    }

    public void dump(PrintWriter pw) {
        pw.print("mGrantFlags=0x");
        pw.print(Integer.toHexString(this.mGrantFlags));
        pw.print(" mSourceUserId=");
        pw.println(this.mSourceUserId);
        pw.print("mTag=");
        pw.println(this.mTag);
        pw.print("mPermissionOwner=");
        pw.println(this.mPermissionOwner);
        int i = 0;
    L4:
        if (i >= this.mUris.size()) goto L7;
        pw.print("#");
        pw.print(i);
        pw.print(": ");
        pw.println(this.mUris.get(i));
        i = i + 1;
        goto L4
    }

    public void dump(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, this.mGrantFlags);
        proto.write(1120986464258L, this.mSourceUserId);
        proto.write(1138166333443L, this.mTag);
        proto.write(1138166333444L, this.mPermissionOwner.toString());
        int i = 0;
    L4:
        if (i >= this.mUris.size()) goto L9;
        Uri u = this.mUris.get(i);
        if (u == null) goto L8;
        proto.write(2237677961221L, u.toString());
    L8:
        i = i + 1;
        goto L4
    L9:
        proto.end(token);
    }
}
