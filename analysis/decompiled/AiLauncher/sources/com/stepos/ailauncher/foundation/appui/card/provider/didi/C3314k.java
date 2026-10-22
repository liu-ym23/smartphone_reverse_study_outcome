package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u0004\u0018\u00010\u00072\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\fJ!\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/k;", "", "<init>", "()V", "", "", "links", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/k$a;", "c", "([Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/k$a;", "raw", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/lang/String;", "s", Const.INTENT_KEY_APIKEY, "flat", "key", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "KEY_THIRD_UID", "Ljava/lang/String;", "KEY_DEVICE_ID", "", "MAX_DECODE_ROUNDS", "I", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3314k {
    public static final C3314k INSTANCE = new C3314k();
    private static final String KEY_DEVICE_ID = "deviceId";
    private static final String KEY_THIRD_UID = "thirdUid";
    private static final int MAX_DECODE_ROUNDS = 4;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/k$a;", "", "", C3314k.KEY_THIRD_UID, C3314k.KEY_DEVICE_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.k$a, reason: from toString */
    public static final /* data */ class AuthIds {
        private final String deviceId;
        private final String thirdUid;

        public AuthIds(String thirdUid, String deviceId) {
            kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
            kotlin.jvm.internal.p.i(deviceId, "deviceId");
            this.thirdUid = thirdUid;
            this.deviceId = deviceId;
        }

        /* renamed from: a, reason: from getter */
        public final String getDeviceId() {
            return this.deviceId;
        }

        /* renamed from: b, reason: from getter */
        public final String getThirdUid() {
            return this.thirdUid;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AuthIds)) {
                return false;
            }
            AuthIds authIds = (AuthIds) other;
            return kotlin.jvm.internal.p.d(this.thirdUid, authIds.thirdUid) && kotlin.jvm.internal.p.d(this.deviceId, authIds.deviceId);
        }

        public int hashCode() {
            return (this.thirdUid.hashCode() * 31) + this.deviceId.hashCode();
        }

        public String toString() {
            return "AuthIds(thirdUid=" + this.thirdUid + ", deviceId=" + this.deviceId + ")";
        }
    }

    public final String a(String s10) {
        int i10 = 0;
        if (!La.H.f0(s10, '%', false, 2, null)) {
            return s10;
        }
        StringBuilder sb2 = new StringBuilder(s10.length());
        while (i10 < s10.length()) {
            char cCharAt = s10.charAt(i10);
            if (cCharAt == '%' && i10 + 2 < s10.length()) {
                int i11 = i10 + 3;
                String strSubstring = s10.substring(i10 + 1, i11);
                kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                Integer numX = La.C.x(strSubstring, 16);
                if (numX != null) {
                    sb2.append((char) numX.intValue());
                    i10 = i11;
                }
            }
            sb2.append(cCharAt);
            i10++;
        }
        String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return string;
    }

    public final String b(String raw) {
        int i10 = 0;
        while (i10 < 4) {
            String strA = INSTANCE.a(raw);
            if (kotlin.jvm.internal.p.d(strA, raw)) {
                break;
            }
            i10++;
            raw = strA;
        }
        return raw;
    }

    public final AuthIds c(String... links) {
        kotlin.jvm.internal.p.i(links, "links");
        for (String str : links) {
            if (str != null && !La.H.x0(str)) {
                String strB = b(str);
                String strD = d(strB, KEY_THIRD_UID);
                String strD2 = d(strB, KEY_DEVICE_ID);
                if (strD != null && strD2 != null) {
                    return new AuthIds(strD, strD2);
                }
            }
        }
        return null;
    }

    public final String d(String flat, String key) {
        List<String> listC;
        String str;
        La.m mVarD = Regex.d(new Regex("(?<![A-Za-z0-9_])" + key + "=([^&#?\\s]+)"), flat, 0, 2, null);
        if (mVarD == null || (listC = mVarD.c()) == null || (str = (String) Z8.F.t0(listC, 1)) == null || La.H.x0(str)) {
            return null;
        }
        return str;
    }
}
