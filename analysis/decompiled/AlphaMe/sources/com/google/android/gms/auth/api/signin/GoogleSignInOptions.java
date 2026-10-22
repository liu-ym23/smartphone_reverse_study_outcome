package com.google.android.gms.auth.api.signin;

import Z0.b;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import b.C0354a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import t0.J;

@SafeParcelable.Class(creator = "GoogleSignInOptionsCreator")
/* loaded from: classes.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements b, ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* renamed from: a, reason: collision with root package name */
    public final int f9582a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f9583b;

    /* renamed from: c, reason: collision with root package name */
    public final Account f9584c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f9585d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f9586e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f9587f;

    /* renamed from: g, reason: collision with root package name */
    public final String f9588g;

    /* renamed from: h, reason: collision with root package name */
    public final String f9589h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f9590i;

    /* renamed from: j, reason: collision with root package name */
    public final String f9591j;

    /* renamed from: k, reason: collision with root package name */
    public final Map f9592k;

    static {
        Scope scope = new Scope(1, "profile");
        new Scope(1, "email");
        Scope scope2 = new Scope(1, "openid");
        Scope scope3 = new Scope(1, "https://www.googleapis.com/auth/games_lite");
        Scope scope4 = new Scope(1, "https://www.googleapis.com/auth/games");
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        hashSet.add(scope2);
        hashSet.add(scope);
        if (hashSet.contains(scope4) && hashSet.contains(scope3)) {
            hashSet.remove(scope3);
        }
        new GoogleSignInOptions(3, new ArrayList(hashSet), null, false, false, false, null, null, map, null);
        HashSet hashSet2 = new HashSet();
        HashMap map2 = new HashMap();
        hashSet2.add(scope3);
        hashSet2.addAll(Arrays.asList(new Scope[0]));
        if (hashSet2.contains(scope4) && hashSet2.contains(scope3)) {
            hashSet2.remove(scope3);
        }
        new GoogleSignInOptions(3, new ArrayList(hashSet2), null, false, false, false, null, null, map2, null);
        CREATOR = new C0354a(26);
    }

    public GoogleSignInOptions(int i4, ArrayList arrayList, Account account, boolean z4, boolean z5, boolean z6, String str, String str2, HashMap map, String str3) {
        this.f9582a = i4;
        this.f9583b = arrayList;
        this.f9584c = account;
        this.f9585d = z4;
        this.f9586e = z5;
        this.f9587f = z6;
        this.f9588g = str;
        this.f9589h = str2;
        this.f9590i = new ArrayList(map.values());
        this.f9591j = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004f A[Catch: ClassCastException -> 0x007b, TryCatch #0 {ClassCastException -> 0x007b, blocks: (B:5:0x0008, B:7:0x0018, B:10:0x0021, B:12:0x0030, B:15:0x003c, B:21:0x0049, B:23:0x004f, B:29:0x005d, B:31:0x0063, B:33:0x0069, B:35:0x006f, B:26:0x0056, B:19:0x0043), top: B:41:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0056 A[Catch: ClassCastException -> 0x007b, TryCatch #0 {ClassCastException -> 0x007b, blocks: (B:5:0x0008, B:7:0x0018, B:10:0x0021, B:12:0x0030, B:15:0x003c, B:21:0x0049, B:23:0x004f, B:29:0x005d, B:31:0x0063, B:33:0x0069, B:35:0x006f, B:26:0x0056, B:19:0x0043), top: B:41:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0079 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.String r0 = r8.f9588g
            java.util.ArrayList r1 = r8.f9583b
            r2 = 0
            if (r9 != 0) goto L8
            return r2
        L8:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r9 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r9     // Catch: java.lang.ClassCastException -> L7b
            java.util.ArrayList r3 = r9.f9583b     // Catch: java.lang.ClassCastException -> L7b
            java.lang.String r4 = r9.f9588g     // Catch: java.lang.ClassCastException -> L7b
            android.accounts.Account r5 = r9.f9584c     // Catch: java.lang.ClassCastException -> L7b
            java.util.ArrayList r6 = r8.f9590i     // Catch: java.lang.ClassCastException -> L7b
            int r6 = r6.size()     // Catch: java.lang.ClassCastException -> L7b
            if (r6 > 0) goto L7b
            java.util.ArrayList r6 = r9.f9590i     // Catch: java.lang.ClassCastException -> L7b
            int r6 = r6.size()     // Catch: java.lang.ClassCastException -> L7b
            if (r6 <= 0) goto L21
            goto L7b
        L21:
            int r6 = r1.size()     // Catch: java.lang.ClassCastException -> L7b
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.ClassCastException -> L7b
            r7.<init>(r3)     // Catch: java.lang.ClassCastException -> L7b
            int r7 = r7.size()     // Catch: java.lang.ClassCastException -> L7b
            if (r6 != r7) goto L7b
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.ClassCastException -> L7b
            r6.<init>(r3)     // Catch: java.lang.ClassCastException -> L7b
            boolean r1 = r1.containsAll(r6)     // Catch: java.lang.ClassCastException -> L7b
            if (r1 != 0) goto L3c
            goto L7b
        L3c:
            android.accounts.Account r1 = r8.f9584c     // Catch: java.lang.ClassCastException -> L7b
            if (r1 != 0) goto L43
            if (r5 != 0) goto L7b
            goto L49
        L43:
            boolean r1 = r1.equals(r5)     // Catch: java.lang.ClassCastException -> L7b
            if (r1 == 0) goto L7b
        L49:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.ClassCastException -> L7b
            if (r1 == 0) goto L56
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.ClassCastException -> L7b
            if (r0 == 0) goto L7b
            goto L5d
        L56:
            boolean r0 = r0.equals(r4)     // Catch: java.lang.ClassCastException -> L7b
            if (r0 != 0) goto L5d
            goto L7b
        L5d:
            boolean r0 = r8.f9587f     // Catch: java.lang.ClassCastException -> L7b
            boolean r1 = r9.f9587f     // Catch: java.lang.ClassCastException -> L7b
            if (r0 != r1) goto L7b
            boolean r0 = r8.f9585d     // Catch: java.lang.ClassCastException -> L7b
            boolean r1 = r9.f9585d     // Catch: java.lang.ClassCastException -> L7b
            if (r0 != r1) goto L7b
            boolean r0 = r8.f9586e     // Catch: java.lang.ClassCastException -> L7b
            boolean r1 = r9.f9586e     // Catch: java.lang.ClassCastException -> L7b
            if (r0 != r1) goto L7b
            java.lang.String r8 = r8.f9591j     // Catch: java.lang.ClassCastException -> L7b
            java.lang.String r9 = r9.f9591j     // Catch: java.lang.ClassCastException -> L7b
            boolean r8 = android.text.TextUtils.equals(r8, r9)     // Catch: java.lang.ClassCastException -> L7b
            if (r8 == 0) goto L7b
            r8 = 1
            return r8
        L7b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f9583b;
        int size = arrayList2.size();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(((Scope) arrayList2.get(i4)).f9610b);
        }
        Collections.sort(arrayList);
        int iHashCode = arrayList.hashCode() + (31 * 1);
        Account account = this.f9584c;
        int iHashCode2 = (iHashCode * 31) + (account == null ? 0 : account.hashCode());
        String str = this.f9588g;
        int iHashCode3 = (((((((iHashCode2 * 31) + (str == null ? 0 : str.hashCode())) * 31) + (this.f9587f ? 1 : 0)) * 31) + (this.f9585d ? 1 : 0)) * 31) + (this.f9586e ? 1 : 0);
        String str2 = this.f9591j;
        return (31 * iHashCode3) + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9582a);
        J.W(parcel, 2, new ArrayList(this.f9583b));
        J.T(parcel, 3, this.f9584c, i4);
        J.c0(parcel, 4, 4);
        parcel.writeInt(this.f9585d ? 1 : 0);
        J.c0(parcel, 5, 4);
        parcel.writeInt(this.f9586e ? 1 : 0);
        J.c0(parcel, 6, 4);
        parcel.writeInt(this.f9587f ? 1 : 0);
        J.U(parcel, 7, this.f9588g);
        J.U(parcel, 8, this.f9589h);
        J.W(parcel, 9, this.f9590i);
        J.U(parcel, 10, this.f9591j);
        J.b0(parcel, iZ);
    }
}
