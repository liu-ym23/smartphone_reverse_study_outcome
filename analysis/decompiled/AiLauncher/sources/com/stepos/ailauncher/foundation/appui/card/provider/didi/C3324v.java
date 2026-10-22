package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import La.C0953c;
import android.app.Application;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthStatusApiKt;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthStatusDto;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import o6.C5009a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u00010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u0006*\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010\"J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010\u0018R\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010&R\u0014\u0010(\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010*\u001a\u00020)8\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010&R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/v;", "", "<init>", "()V", "", "thirdUid", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;", "dto", "", "nowWallMs", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;J)V", "reason", "e", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/v$a;", "q", "(Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;J)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/v$a;", "r", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/v$a;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;", "l", "(Ljava/lang/String;)Ljava/lang/String;", "o", "c", "", "f", "()Z", "secureKey", "k", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "n", "(Ljava/lang/String;)V", "m", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "SECURE_RECORD_PREFIX", "Ljava/lang/String;", "LEGACY_MMKV_ID", "LEGACY_RECORD_PREFIX", "", "SCHEMA_VERSION", "I", "STATUS_ACTIVE", "", "logScopeSalt", "[B", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.v, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3324v {
    public static final C3324v INSTANCE = new C3324v();
    private static final String LEGACY_MMKV_ID = "didi_auth_status_v1";
    private static final String LEGACY_RECORD_PREFIX = "authorized_v1_";
    private static final int SCHEMA_VERSION = 1;
    private static final String SECURE_RECORD_PREFIX = "didi_auth_status_v2.authorized.";
    private static final String STATUS_ACTIVE = "ACTIVE";
    private static final byte[] logScopeSalt;

    static {
        byte[] bArr = new byte[32];
        new SecureRandom().nextBytes(bArr);
        logScopeSalt = bArr;
    }

    public static final CharSequence d(byte b10) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(b10 & 255)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        return str;
    }

    public static /* synthetic */ void j(C3324v c3324v, String str, DidiAuthStatusDto didiAuthStatusDto, long j10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = System.currentTimeMillis();
        }
        c3324v.i(str, didiAuthStatusDto, j10);
    }

    public static final CharSequence p(byte b10) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(b10 & 255)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        return str;
    }

    public final String c(String thirdUid) {
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(logScopeSalt);
        byte[] bytes = ("didi|" + thirdUid).getBytes(C0953c.UTF_8);
        kotlin.jvm.internal.p.h(bytes, "getBytes(...)");
        messageDigest.update(bytes);
        byte[] bArrDigest = messageDigest.digest();
        kotlin.jvm.internal.p.h(bArrDigest, "digest(...)");
        return La.K.R1(Z8.r.v0(bArrDigest, "", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.u
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C3324v.d(((Byte) obj).byteValue());
            }
        }, 30, null), 12);
    }

    public final void e(String thirdUid, String reason) throws NoSuchAlgorithmException {
        Object objB;
        Object objB2;
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (La.H.x0(thirdUid) || !f()) {
            return;
        }
        String strL = l(thirdUid);
        boolean z10 = true;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(C5009a.INSTANCE.a(strL, true)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        if (!((Boolean) objB).booleanValue()) {
            try {
                objB2 = Result.b(Boolean.valueOf(C5009a.INSTANCE.c(LEGACY_MMKV_ID, h(thirdUid))));
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            Boolean bool2 = Boolean.FALSE;
            if (Result.g(objB2)) {
                objB2 = bool2;
            }
            if (!((Boolean) objB2).booleanValue()) {
                z10 = false;
            }
        }
        n(thirdUid);
        if (z10) {
            R5.b.INSTANCE.c("didi.auth.snapshot.cleared", Y8.j.a("accountScope", c(thirdUid)), Y8.j.a("reason", reason));
        }
    }

    public final boolean f() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            Application applicationA = C3197a.INSTANCE.a();
            C5009a.INSTANCE.d(applicationA);
            q6.c.INSTANCE.d(applicationA);
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("didi.auth.snapshot.load.fail", Y8.j.a("reason", "storage_init"), Y8.j.a("exception", thE.getClass().getSimpleName()));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final DidiAuthStatusDto g(String thirdUid) throws NoSuchAlgorithmException {
        String strK;
        Object objB;
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        if (La.H.x0(thirdUid) || !f() || (strK = k(thirdUid, l(thirdUid))) == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((Snapshot) N5.k.INSTANCE.b().fromJson(strK, Snapshot.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C3324v c3324v = INSTANCE;
            c3324v.n(thirdUid);
            R5.b.INSTANCE.h("didi.auth.snapshot.invalid", Y8.j.a("accountScope", c3324v.c(thirdUid)), Y8.j.a("reason", "record_json"), Y8.j.a("exception", thE.getClass().getSimpleName()));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Snapshot snapshot = (Snapshot) objB;
        if (snapshot == null) {
            return null;
        }
        String strO = o(thirdUid);
        if (snapshot.getSchemaVersion() != 1 || !kotlin.jvm.internal.p.d(snapshot.getAccountScope(), strO) || !La.D.L(snapshot.getStatus(), STATUS_ACTIVE, true) || !snapshot.getRideEnable()) {
            n(thirdUid);
            R5.b.INSTANCE.h("didi.auth.snapshot.invalid", Y8.j.a("accountScope", c(thirdUid)), Y8.j.a("reason", "shape_or_schema"), Y8.j.a("schemaVersion", Integer.valueOf(snapshot.getSchemaVersion())));
            return null;
        }
        DidiAuthStatusDto didiAuthStatusDtoR = r(snapshot, thirdUid);
        if (!DidiAuthStatusApiKt.getAuthorized(didiAuthStatusDtoR)) {
            n(thirdUid);
            return null;
        }
        R5.b.INSTANCE.e("didi.auth.snapshot.restored:" + c(thirdUid), "didi.auth.snapshot.restored", Y8.j.a("accountScope", c(thirdUid)), Y8.j.a("ageMs", Long.valueOf(C5685n.g(System.currentTimeMillis() - snapshot.getVerifiedAtWallMs(), 0L))));
        return didiAuthStatusDtoR;
    }

    public final String h(String thirdUid) throws NoSuchAlgorithmException {
        return LEGACY_RECORD_PREFIX + o(thirdUid);
    }

    public final void i(String thirdUid, DidiAuthStatusDto dto, long nowWallMs) {
        Snapshot snapshotQ;
        Object objB;
        Object objB2;
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        kotlin.jvm.internal.p.i(dto, "dto");
        if (La.H.x0(thirdUid) || !DidiAuthStatusApiKt.getAuthorized(dto) || !f() || (snapshotQ = q(thirdUid, dto, nowWallMs)) == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(N5.k.INSTANCE.b().toJson(snapshotQ));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null) {
            return;
        }
        try {
            objB2 = Result.b(Boolean.valueOf(C5009a.INSTANCE.F(l(thirdUid), str, true)));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB2)) {
            objB2 = bool;
        }
        if (!((Boolean) objB2).booleanValue()) {
            R5.b.INSTANCE.h("didi.auth.snapshot.persist.fail", Y8.j.a("accountScope", c(thirdUid)));
        } else {
            m(thirdUid);
            R5.b.INSTANCE.c("didi.auth.snapshot.saved", Y8.j.a("accountScope", c(thirdUid)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String k(java.lang.String r10, java.lang.String r11) throws java.security.NoSuchAlgorithmException {
        /*
            r9 = this;
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L15
            o6.a r1 = o6.C5009a.INSTANCE     // Catch: java.lang.Throwable -> L15
            r5 = 2
            r6 = 0
            r3 = 0
            r4 = 1
            r2 = r11
            java.lang.String r11 = o6.C5009a.t(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L12
            java.lang.Object r11 = kotlin.Result.b(r11)     // Catch: java.lang.Throwable -> L12
            goto L22
        L12:
            r0 = move-exception
        L13:
            r11 = r0
            goto L18
        L15:
            r0 = move-exception
            r2 = r11
            goto L13
        L18:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r11 = kotlin.C4849c.a(r11)
            java.lang.Object r11 = kotlin.Result.b(r11)
        L22:
            boolean r0 = kotlin.Result.g(r11)
            r1 = 0
            if (r0 == 0) goto L2a
            r11 = r1
        L2a:
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L35
            boolean r0 = La.H.x0(r11)
            if (r0 != 0) goto L35
            goto L36
        L35:
            r11 = r1
        L36:
            if (r11 == 0) goto L3c
            r9.m(r10)
            return r11
        L3c:
            java.lang.String r5 = r9.h(r10)
            o6.a r3 = o6.C5009a.INSTANCE     // Catch: java.lang.Throwable -> L50
            java.lang.String r4 = "didi_auth_status_v1"
            r7 = 4
            r8 = 0
            r6 = 0
            java.lang.String r11 = o6.C5009a.v(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L50
            java.lang.Object r11 = kotlin.Result.b(r11)     // Catch: java.lang.Throwable -> L50
            goto L5c
        L50:
            r0 = move-exception
            r11 = r0
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r11 = kotlin.C4849c.a(r11)
            java.lang.Object r11 = kotlin.Result.b(r11)
        L5c:
            boolean r0 = kotlin.Result.g(r11)
            if (r0 == 0) goto L63
            r11 = r1
        L63:
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto Lca
            boolean r0 = La.H.x0(r11)
            if (r0 != 0) goto L6e
            goto L6f
        L6e:
            r11 = r1
        L6f:
            if (r11 == 0) goto Lca
            o6.a r0 = o6.C5009a.INSTANCE     // Catch: java.lang.Throwable -> L81
            r1 = 1
            boolean r0 = r0.F(r2, r11, r1)     // Catch: java.lang.Throwable -> L81
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> L81
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L81
            goto L8c
        L81:
            r0 = move-exception
            kotlin.Result$a r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.C4849c.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L8c:
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            boolean r2 = kotlin.Result.g(r0)
            if (r2 == 0) goto L95
            r0 = r1
        L95:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            java.lang.String r1 = "accountScope"
            if (r0 == 0) goto Lb6
            r9.m(r10)
            R5.b r0 = R5.b.INSTANCE
            java.lang.String r9 = r9.c(r10)
            kotlin.Pair r9 = Y8.j.a(r1, r9)
            kotlin.Pair[] r9 = new kotlin.Pair[]{r9}
            java.lang.String r10 = "didi.auth.snapshot.migrated"
            r0.c(r10, r9)
            goto Lc9
        Lb6:
            R5.b r0 = R5.b.INSTANCE
            java.lang.String r9 = r9.c(r10)
            kotlin.Pair r9 = Y8.j.a(r1, r9)
            kotlin.Pair[] r9 = new kotlin.Pair[]{r9}
            java.lang.String r10 = "didi.auth.snapshot.migrate.fail"
            r0.h(r10, r9)
        Lc9:
            return r11
        Lca:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.C3324v.k(java.lang.String, java.lang.String):java.lang.String");
    }

    public final String l(String thirdUid) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        return SECURE_RECORD_PREFIX + o(thirdUid);
    }

    public final void m(String thirdUid) {
        try {
            Result.Companion companion = Result.INSTANCE;
            C5009a.INSTANCE.J(LEGACY_MMKV_ID, h(thirdUid));
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final void n(String thirdUid) {
        try {
            Result.Companion companion = Result.INSTANCE;
            C5009a.INSTANCE.I(l(thirdUid), true);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        m(thirdUid);
    }

    public final String o(String thirdUid) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = ("didi|" + thirdUid).getBytes(C0953c.UTF_8);
        kotlin.jvm.internal.p.h(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        kotlin.jvm.internal.p.h(bArrDigest, "digest(...)");
        return Z8.r.v0(bArrDigest, "", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.t
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C3324v.p(((Byte) obj).byteValue());
            }
        }, 30, null);
    }

    public final Snapshot q(String thirdUid, DidiAuthStatusDto dto, long nowWallMs) {
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        kotlin.jvm.internal.p.i(dto, "dto");
        if (La.H.x0(thirdUid) || !DidiAuthStatusApiKt.getAuthorized(dto)) {
            return null;
        }
        return new Snapshot(0, o(thirdUid), STATUS_ACTIVE, true, nowWallMs, 1, null);
    }

    public final DidiAuthStatusDto r(Snapshot snapshot, String thirdUid) {
        kotlin.jvm.internal.p.i(snapshot, "<this>");
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        return new DidiAuthStatusDto(snapshot.getStatus(), Boolean.valueOf(snapshot.getRideEnable()), thirdUid, thirdUid);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0018\u0010\u000eR\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/v$a;", "", "", "schemaVersion", "", "accountScope", "status", "", "rideEnable", "", "verifiedAtWallMs", "<init>", "(ILjava/lang/String;Ljava/lang/String;ZJ)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "I", "c", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "Z", Const.INTENT_KEY_PKGNAME, "()Z", "J", "e", "()J", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.v$a, reason: from toString */
    public static final /* data */ class Snapshot {

        @SerializedName("account_scope")
        private final String accountScope;

        @SerializedName("ride_enable")
        private final boolean rideEnable;

        @SerializedName("schema_version")
        private final int schemaVersion;
        private final String status;

        @SerializedName("verified_at_wall_ms")
        private final long verifiedAtWallMs;

        public Snapshot(int i10, String accountScope, String status, boolean z10, long j10) {
            kotlin.jvm.internal.p.i(accountScope, "accountScope");
            kotlin.jvm.internal.p.i(status, "status");
            this.schemaVersion = i10;
            this.accountScope = accountScope;
            this.status = status;
            this.rideEnable = z10;
            this.verifiedAtWallMs = j10;
        }

        /* renamed from: a, reason: from getter */
        public final String getAccountScope() {
            return this.accountScope;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getRideEnable() {
            return this.rideEnable;
        }

        /* renamed from: c, reason: from getter */
        public final int getSchemaVersion() {
            return this.schemaVersion;
        }

        /* renamed from: d, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        /* renamed from: e, reason: from getter */
        public final long getVerifiedAtWallMs() {
            return this.verifiedAtWallMs;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Snapshot)) {
                return false;
            }
            Snapshot snapshot = (Snapshot) other;
            return this.schemaVersion == snapshot.schemaVersion && kotlin.jvm.internal.p.d(this.accountScope, snapshot.accountScope) && kotlin.jvm.internal.p.d(this.status, snapshot.status) && this.rideEnable == snapshot.rideEnable && this.verifiedAtWallMs == snapshot.verifiedAtWallMs;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.schemaVersion) * 31) + this.accountScope.hashCode()) * 31) + this.status.hashCode()) * 31) + Boolean.hashCode(this.rideEnable)) * 31) + Long.hashCode(this.verifiedAtWallMs);
        }

        public String toString() {
            return "Snapshot(schemaVersion=" + this.schemaVersion + ", accountScope=" + this.accountScope + ", status=" + this.status + ", rideEnable=" + this.rideEnable + ", verifiedAtWallMs=" + this.verifiedAtWallMs + ")";
        }

        public /* synthetic */ Snapshot(int i10, String str, String str2, boolean z10, long j10, int i11, kotlin.jvm.internal.i iVar) {
            this((i11 & 1) != 0 ? 1 : i10, str, (i11 & 4) != 0 ? C3324v.STATUS_ACTIVE : str2, (i11 & 8) != 0 ? true : z10, j10);
        }
    }
}
