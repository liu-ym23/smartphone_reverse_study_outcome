package com.jeffmony.async.http;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class b implements NameValuePair, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10424b;

    public b(String r10, String r11) {
        if (r10 == null) goto L7;
        this.f10423a = r10;
        this.f10424b = r11;
        return;
    L7:
        throw new IllegalArgumentException("Name may not be null");
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (this != r10) goto L9;
        return true;
    L9:
        if ((r10 instanceof NameValuePair) == false) goto L16;
        b r11 = (b) r10;
        if (this.f10423a.equals(r11.f10423a) == true) goto L13;
        return false;
    L13:
        if (TextUtils.equals(this.f10424b, r11.f10424b) == true) goto L15;
        return false;
    L15:
        return true;
    L16:
        return false;
    }

    @Override // com.jeffmony.async.http.NameValuePair
    public String getName() {
        return this.f10423a;
    }

    @Override // com.jeffmony.async.http.NameValuePair
    public String getValue() {
        return this.f10424b;
    }

    public int hashCode() {
        int r10 = this.f10423a.hashCode();
        return this.f10424b.hashCode() ^ r10;
    }

    public String toString() {
        return this.f10423a + "=" + this.f10424b;
    }
}
