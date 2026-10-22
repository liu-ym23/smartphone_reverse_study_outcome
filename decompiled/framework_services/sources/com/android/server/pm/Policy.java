package com.android.server.pm;

import android.content.pm.Signature;
import android.content.pm.SigningDetails;
import com.android.server.pm.pkg.AndroidPackage;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SELinuxMMAC.java */
/* JADX INFO: loaded from: classes2.dex */
final class Policy {
    private final Set<Signature> mCerts;
    private final Map<String, String> mPkgMap;
    private final String mSeinfo;

    /* JADX INFO: compiled from: SELinuxMMAC.java */
    public static final class PolicyBuilder {
        private final Set<Signature> mCerts;
        private final Map<String, String> mPkgMap;
        private String mSeinfo;

        /* JADX INFO: renamed from: -$$Nest$fgetmCerts, reason: not valid java name */
        static /* bridge */ /* synthetic */ Set m6882$$Nest$fgetmCerts(PolicyBuilder r0) {
            return r0.mCerts;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPkgMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m6883$$Nest$fgetmPkgMap(PolicyBuilder r0) {
            return r0.mPkgMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSeinfo, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m6884$$Nest$fgetmSeinfo(PolicyBuilder r0) {
            return r0.mSeinfo;
        }

        public PolicyBuilder() {
            this.mCerts = new HashSet(2);
            this.mPkgMap = new HashMap(2);
        }

        public PolicyBuilder addSignature(String cert) {
            if (cert == null) goto L5;
            this.mCerts.add(new Signature(cert));
            return this;
        L5:
            String err = "Invalid signature value " + cert;
            throw new IllegalArgumentException(err);
        }

        public PolicyBuilder setGlobalSeinfoOrThrow(String seinfo) {
            if (validateValue(seinfo) == true) goto L5;
            String err = "Invalid seinfo value " + seinfo;
            throw new IllegalArgumentException(err);
        L5:
            if (this.mSeinfo != null) goto L7;
        L11:
            this.mSeinfo = seinfo;
            return this;
        L7:
            if (this.mSeinfo.equals(seinfo) == true) goto L11;
            throw new IllegalStateException("Duplicate seinfo tag found");
        }

        public PolicyBuilder addInnerPackageMapOrThrow(String pkgName, String seinfo) {
            if (validateValue(pkgName) == true) goto L5;
            String err = "Invalid package name " + pkgName;
            throw new IllegalArgumentException(err);
        L5:
            if (validateValue(seinfo) == false) goto L15;
            String pkgValue = this.mPkgMap.get(pkgName);
            if (pkgValue != null) goto L9;
        L13:
            this.mPkgMap.put(pkgName, seinfo);
            return this;
        L9:
            if (pkgValue.equals(seinfo) == true) goto L13;
            throw new IllegalStateException("Conflicting seinfo value found");
        L15:
            String err2 = "Invalid seinfo value " + seinfo;
            throw new IllegalArgumentException(err2);
        }

        private boolean validateValue(String name) {
            if (name != null) goto L6;
            return false;
        L6:
            if (name.matches("\\A[\\.\\w]+\\z") == true) goto L8;
            return false;
        L8:
            return true;
        }

        public Policy build() {
            Policy p = new Policy(this, null);
            if (Policy.m6879$$Nest$fgetmCerts(p).isEmpty() == true) goto L14;
            if (Policy.m6881$$Nest$fgetmSeinfo(p) != null) goto L7;
            boolean r1 = true;
        L9:
            if ((r1 ^ Policy.m6880$$Nest$fgetmPkgMap(p).isEmpty()) == false) goto L12;
            return p;
        L12:
            throw new IllegalStateException("Only seinfo tag XOR package tags are allowed within a signer stanza.");
        L7:
            r1 = false;
            goto L9
        L14:
            throw new IllegalStateException("Missing certs with signer tag. Expecting at least one.");
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCerts, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m6879$$Nest$fgetmCerts(Policy r0) {
        return r0.mCerts;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPkgMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m6880$$Nest$fgetmPkgMap(Policy r0) {
        return r0.mPkgMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSeinfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6881$$Nest$fgetmSeinfo(Policy r0) {
        return r0.mSeinfo;
    }

    /* synthetic */ Policy(PolicyBuilder r1, PolicyIA r2) {
        this(r1);
    }

    private Policy(PolicyBuilder builder) {
        this.mSeinfo = PolicyBuilder.m6884$$Nest$fgetmSeinfo(builder);
        this.mCerts = Collections.unmodifiableSet(PolicyBuilder.m6882$$Nest$fgetmCerts(builder));
        this.mPkgMap = Collections.unmodifiableMap(PolicyBuilder.m6883$$Nest$fgetmPkgMap(builder));
    }

    public Set<Signature> getSignatures() {
        return this.mCerts;
    }

    public boolean hasInnerPackages() {
        return !this.mPkgMap.isEmpty();
    }

    public Map<String, String> getInnerPackages() {
        return this.mPkgMap;
    }

    public boolean hasGlobalSeinfo() {
        if (this.mSeinfo == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Signature> r1 = this.mCerts.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        Signature cert = r1.next();
        sb.append("cert=" + cert.toCharsString().substring(0, 11) + "... ");
        goto L4
    L7:
        if (this.mSeinfo == null) goto L9;
        sb.append("seinfo=" + this.mSeinfo);
    L9:
        Iterator<String> r2 = this.mPkgMap.keySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L14;
        String name = r2.next();
        sb.append(" " + name + "=" + this.mPkgMap.get(name));
        goto L11
    L14:
        return sb.toString();
    }

    public String getMatchedSeInfo(AndroidPackage pkg) {
        Signature[] certs = (Signature[]) this.mCerts.toArray(new Signature[0]);
        if (pkg.getSigningDetails() != SigningDetails.UNKNOWN) goto L5;
    L12:
        String seinfoValue = this.mPkgMap.get(pkg.getPackageName());
        if (seinfoValue == null) goto L16;
        return seinfoValue;
    L16:
        return this.mSeinfo;
    L5:
        if (Signature.areExactMatch(pkg.getSigningDetails(), certs) == true) goto L12;
        if (certs.length <= 1) goto L9;
        return null;
    L9:
        if (pkg.getSigningDetails().hasCertificate(certs[0]) == true) goto L12;
        return null;
    }
}
