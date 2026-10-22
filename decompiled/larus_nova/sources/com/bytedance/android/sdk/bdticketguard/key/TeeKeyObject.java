package com.bytedance.android.sdk.bdticketguard.key;

import android.util.Base64;
import java.security.KeyPair;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class TeeKeyObject extends f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f163827f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f163828g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f163829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KeyPair f163830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f163831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f163832e;

    public static final class a {
        public a() {
        }
    }

    static {
        f163827f = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TeeKeyObject.class), "pubKeyBase64Cache", "getPubKeyBase64Cache()[B"))};
        f163828g = new a();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.f
    public final boolean b() {
        String r100 = this.f163831d;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L18;
        String r102 = this.f163832e;
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == false) goto L18;
        return false;
    L13:
        if (r102.length() == 0) goto L16;
        r103 = false;
    L18:
        return true;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.f
    public final String a(int r100) {
        Lazy r101 = this.f163829b;
        KProperty r102 = f163827f[0];
        byte[] r103 = (byte[]) r101.getValue();
        if (r103 == null) goto L7;
        String r104 = Base64.encodeToString(r103, r100);
        if (r104 == null) goto L7;
        return r104;
    L7:
        return "";
    }

    public TeeKeyObject(boolean r100, KeyPair r101, String r102, String r103) {
        super(r100);
        this.f163830c = r101;
        this.f163831d = r102;
        this.f163832e = r103;
        this.f163829b = LazyKt.lazy(new TeeKeyObject$pubKeyBase64Cache$2(this));
    }
}
