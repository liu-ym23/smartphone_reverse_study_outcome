package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.room.AbstractC0351g;
import b.C0354a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import t0.J;

@SafeParcelable.Class(creator = "GoogleSignInAccountCreator")
/* loaded from: classes.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new C0354a(25);

    /* renamed from: a, reason: collision with root package name */
    public final int f9569a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9570b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9571c;

    /* renamed from: d, reason: collision with root package name */
    public final String f9572d;

    /* renamed from: e, reason: collision with root package name */
    public final String f9573e;

    /* renamed from: f, reason: collision with root package name */
    public final Uri f9574f;

    /* renamed from: g, reason: collision with root package name */
    public String f9575g;

    /* renamed from: h, reason: collision with root package name */
    public final long f9576h;

    /* renamed from: i, reason: collision with root package name */
    public final String f9577i;

    /* renamed from: j, reason: collision with root package name */
    public final List f9578j;

    /* renamed from: k, reason: collision with root package name */
    public final String f9579k;

    /* renamed from: l, reason: collision with root package name */
    public final String f9580l;

    /* renamed from: m, reason: collision with root package name */
    public final HashSet f9581m = new HashSet();

    public GoogleSignInAccount(int i4, String str, String str2, String str3, String str4, Uri uri, String str5, long j4, String str6, ArrayList arrayList, String str7, String str8) {
        this.f9569a = i4;
        this.f9570b = str;
        this.f9571c = str2;
        this.f9572d = str3;
        this.f9573e = str4;
        this.f9574f = uri;
        this.f9575g = str5;
        this.f9576h = j4;
        this.f9577i = str6;
        this.f9578j = arrayList;
        this.f9579k = str7;
        this.f9580l = str8;
    }

    public static GoogleSignInAccount N(String str) throws JSONException, NumberFormatException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j4 = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            hashSet.add(new Scope(1, jSONArray.getString(i4)));
        }
        String strOptString2 = jSONObject.optString("id");
        String strOptString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String strOptString4 = jSONObject.has("email") ? jSONObject.optString("email") : null;
        String strOptString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String strOptString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String strOptString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        String string = jSONObject.getString("obfuscatedIdentifier");
        if (TextUtils.isEmpty(string)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, strOptString2, strOptString3, strOptString4, strOptString5, uri, null, j4, string, new ArrayList(hashSet), strOptString6, strOptString7);
        googleSignInAccount.f9575g = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (googleSignInAccount.f9577i.equals(this.f9577i)) {
            HashSet hashSet = new HashSet(googleSignInAccount.f9578j);
            hashSet.addAll(googleSignInAccount.f9581m);
            HashSet hashSet2 = new HashSet(this.f9578j);
            hashSet2.addAll(this.f9581m);
            if (hashSet.equals(hashSet2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iD = AbstractC0351g.d(this.f9577i, 527, 31);
        HashSet hashSet = new HashSet(this.f9578j);
        hashSet.addAll(this.f9581m);
        return hashSet.hashCode() + iD;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9569a);
        J.U(parcel, 2, this.f9570b);
        J.U(parcel, 3, this.f9571c);
        J.U(parcel, 4, this.f9572d);
        J.U(parcel, 5, this.f9573e);
        J.T(parcel, 6, this.f9574f, i4);
        J.U(parcel, 7, this.f9575g);
        J.c0(parcel, 8, 8);
        parcel.writeLong(this.f9576h);
        J.U(parcel, 9, this.f9577i);
        J.W(parcel, 10, this.f9578j);
        J.U(parcel, 11, this.f9579k);
        J.U(parcel, 12, this.f9580l);
        J.b0(parcel, iZ);
    }
}
