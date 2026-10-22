package com.bytedance.android.sdk.bdticketguard.key.tee;

import java.security.KeyPair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyPair f163931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f163932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f163933c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L20:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L19;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f163931a, r101.f163931a) == false) goto L19;
        if (this.f163932b != r101.f163932b) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L19;
        if (this.f163933c != r101.f163933c) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == false) goto L19;
    L16:
        r103 = false;
        goto L17
    L11:
        r102 = false;
    L19:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        KeyPair r100 = this.f163931a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f163932b;
        ?? r104 = 1;
        ?? r105 = r103;
        if (r103 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r102 + r105) * 31;
        boolean r107 = this.f163933c;
        if (r107 == true) goto L14;
        r104 = r107;
    L14:
        return r106 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "BackupKeyPair(keyPair=" + this.f163931a + ", isNewKey=" + this.f163932b + ", aliasNotMatch=" + this.f163933c + ")";
    }

    public a(KeyPair r100, boolean r101, boolean r102) {
        this.f163931a = r100;
        this.f163932b = r101;
        this.f163933c = r102;
    }
}
