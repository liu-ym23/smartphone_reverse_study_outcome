package com.bytedance.android.sdk.bdticketguard.attestation;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/attestation/AttestSignContent;", "", "", "secTs", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public final class AttestSignContent {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f163540b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f163541c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Lazy f163542a;

    @SerializedName("sec_ts")
    private final String secTs;

    public static final class a {
        public a() {
        }

        public static AttestSignContent a(String r100) {
            if (StringsKt.contains$default(r100, "{", false, 2, null) == false) goto L9;
            if (StringsKt.contains$default(r100, "\"sec_ts\"", false, 2, null) == false) goto L9;
            return new AttestSignContent(new JSONObject(r100).optString("sec_ts"));
        L9:
            return new AttestSignContent(r100);
        }
    }

    static {
        f163540b = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AttestSignContent.class), "encoded", "getEncoded()[B"))};
        f163541c = new a();
    }

    public AttestSignContent() {
        this(0);
    }

    public final String toString() {
        return "AttestSignContent(secTs=" + this.secTs + ")";
    }

    public final int hashCode() {
        return this.secTs.hashCode();
    }

    public final String a() {
        return this.secTs;
    }

    public final String b() {
        return this.secTs;
    }

    public AttestSignContent(String r100) {
        this.secTs = r100;
        this.f163542a = LazyKt.lazy(new AttestSignContent$encoded$2(this));
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AttestSignContent) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.secTs, ((AttestSignContent) r100).secTs);
    }

    public /* synthetic */ AttestSignContent(int r100) {
        this("");
    }
}
