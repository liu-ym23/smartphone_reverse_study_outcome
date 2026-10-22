package com.bytedance.android.sdk.bdticketguard;

import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(SensitiveStringTypeAdapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\b\u0087@\u0018\u00002\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/k0;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public final class k0 implements CharSequence {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f163802b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f163803a;

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        String r100 = this.f163803a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f163803a.length();
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return p0.a(this.f163803a);
    }

    public /* synthetic */ k0(String r100) {
        this.f163803a = r100;
    }

    public static final boolean a(String r100) {
        if (r100.length() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int r100) {
        return this.f163803a.charAt(r100);
    }

    public final boolean equals(Object r100) {
        String r101 = this.f163803a;
        if ((r100 instanceof k0) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r101, ((k0) r100).f163803a) == false) goto L7;
        return true;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int r100, int r101) {
        return new k0(this.f163803a.subSequence(r100, r101).toString());
    }
}
