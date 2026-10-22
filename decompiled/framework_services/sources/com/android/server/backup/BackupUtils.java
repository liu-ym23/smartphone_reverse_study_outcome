package com.android.server.backup;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManagerInternal;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BackupUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "BackupUtils";

    public BackupUtils() {
    }

    public static boolean signaturesMatch(ArrayList<byte[]> storedSigHashes, PackageInfo target, PackageManagerInternal pmi) {
        if (target != null) goto L5;
    L34:
        return false;
    L5:
        if (target.packageName == null) goto L34;
        if ((target.applicationInfo.flags & 1) == 0) goto L11;
        return true;
    L11:
        if (ArrayUtils.isEmpty(storedSigHashes) == false) goto L13;
        return false;
    L13:
        SigningInfo signingInfo = target.signingInfo;
        if (signingInfo != null) goto L17;
        Slog.w(TAG, "signingInfo is empty, app was either unsigned or the flag PackageManager#GET_SIGNING_CERTIFICATES was not specified");
        return false;
    L17:
        int nStored = storedSigHashes.size();
        if (nStored == 1) goto L20;
        ArrayList<byte[]> deviceHashes = hashSignatureArray(signingInfo.getApkContentsSigners());
        int nDevice = deviceHashes.size();
        int i = 0;
    L22:
        if (i >= nStored) goto L33;
        boolean match = false;
        int j = 0;
    L24:
        if (j >= nDevice) goto L29;
        if (Arrays.equals(storedSigHashes.get(i), deviceHashes.get(j)) == true) goto L27;
        j = j + 1;
        goto L24
    L27:
        match = true;
    L29:
        if (match == false) goto L30;
        i = i + 1;
        goto L22
    L30:
        return false;
    L33:
        return true;
    L20:
        return pmi.isDataRestoreSafe(storedSigHashes.get(0), target.packageName);
    }

    public static byte[] hashSignature(byte[] signature) {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L4
        digest.update(signature);     // Catch: NoSuchAlgorithmException -> L4
        return digest.digest();
    L5:
        Slog.w(TAG, "No SHA-256 algorithm found!");
        return null;
    }

    public static byte[] hashSignature(Signature signature) {
        return hashSignature(signature.toByteArray());
    }

    public static ArrayList<byte[]> hashSignatureArray(Signature[] sigs) {
        if (sigs != null) goto L5;
        return null;
    L5:
        ArrayList<byte[]> hashes = new ArrayList(sigs.length);
        int r1 = sigs.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        Signature s = sigs[r2];
        hashes.add(hashSignature(s));
        r2 = r2 + 1;
        goto L6
    L8:
        return hashes;
    }

    public static ArrayList<byte[]> hashSignatureArray(List<byte[]> sigs) {
        if (sigs != null) goto L5;
        return null;
    L5:
        ArrayList<byte[]> hashes = new ArrayList(sigs.size());
        Iterator<byte[]> r1 = sigs.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        byte[] s = r1.next();
        hashes.add(hashSignature(s));
        goto L7
    L9:
        return hashes;
    }
}
