package com.bytedance.android.sdk.bdticketguard.key.tee;

import android.content.Context;
import com.bytedance.android.sdk.bdticketguard.MainTicketGuardManager;
import com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper;
import com.bytedance.android.sdk.bdticketguard.data.TeeStaticSignResult;
import com.bytedance.android.sdk.bdticketguard.j1;
import com.bytedance.android.sdk.bdticketguard.r0;
import com.bytedance.android.sdk.bdticketguard.util.i;
import com.bytedance.android.sdk.bdticketguard.w0;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements com.bytedance.android.sdk.bdticketguard.util.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long[] f163936e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f163937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.sdk.bdticketguard.data.c f163938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f163939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<TeeStaticSignResult, Unit> f163940d;

    public static final class a {
    }

    static {
        f163936e = new long[]{1, 10, 30};
    }

    @Override // com.bytedance.android.sdk.bdticketguard.util.b
    public final long b(int r100) {
        Long r101 = ArraysKt.getOrNull(f163936e, r100);
        if (r101 != null) goto L5;
        return -1;
    L5:
        return r101.longValue() * ((long) 1000);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.util.b
    public final void a(final int r100, final i r101) {
        final long r102 = System.currentTimeMillis();
        final Function1<TeeStaticSignResult, Unit> r103 = new TeeStaticSignTask$execute$1(this, r101, r102, r100);
        if (com.bytedance.android.sdk.bdticketguard.util.a.f164047c.c(this.f163937a) == true) goto L5;
        r103.invoke(new TeeStaticSignResult.b(-3000, "is not main process", null));
        return;
    L5:
        j1 r104 = w0.f164095a;
        final MainTicketGuardManager r105 = (MainTicketGuardManager) w0.f164095a;
        if (r105 != null) goto L8;
        r0.b("TeeStaticSignTask", "createStaticSignSync: manager is null");
        r103.invoke(new TeeStaticSignResult.b(-3000, "manager is null", null));
        return;
    L8:
        r105.N("tee_static_sign", new TeeStaticSignTask$createStaticTeeSign$1(this, r103, r105));
    }

    public static final void d(d r100, String r101, Function1 r102) {
        r100.getClass();
        JSONObject r103 = new JSONObject();
        String r104 = r100.f163938b.f163605d;
        String r105 = "";
        if (r104 != null) goto L6;
        r104 = "";
    L6:
        r103.putOpt("path", r104);
        String r106 = r100.f163938b.f163606e;
        if (r106 == null) goto L9;
        r105 = r106;
    L9:
        r103.putOpt(CronetDataStorageAccess.LOGID, r105);
        r103.putOpt("is_refresh", Boolean.valueOf(r100.f163939c));
        r102.invoke(r103);
        TicketGuardEventHelper.B(r101, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Context r100, com.bytedance.android.sdk.bdticketguard.data.c r101, boolean r102, Function1<? super TeeStaticSignResult, Unit> r103) {
        this.f163937a = r100;
        this.f163938b = r101;
        this.f163939c = r102;
        this.f163940d = r103;
    }

    public static final String c(d r100, MainTicketGuardManager r101, String r102, String r103) {
        r100.getClass();
        String r104 = "sec_ts=" + r102;
        Charset r105 = Charsets.UTF_8;
        if (r104 == null) goto L14;
        byte[] r106 = MessageDigest.getInstance("SHA-256").digest(r104.getBytes(r105));
        if (r106 == null) goto L12;
        String r107 = r101.c0(r106, r103, null);
        if (r107 == null) goto L10;
        return r107;
    L10:
        throw new IllegalStateException("tee static sign result is null");
    L12:
        throw new IllegalStateException("signContent is null");
    L14:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
