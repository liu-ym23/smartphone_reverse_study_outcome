package com.stepos.stepclaw.gateway;

import c5.l;
import c5.m;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import x5.n;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0002\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u0002H\u0002\u001a\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0002\u0010\u0007\u001a\u0015\u0010\b\u001a\u0004\u0018\u00010\t*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0002\u0010\n\u001a\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0002\u001a\u001a\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0000\u001a\u0017\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"asObjectOrNull", "Lkotlinx/serialization/json/JsonObject;", "Lkotlinx/serialization/json/JsonElement;", "asStringOrNull", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "asBooleanOrNull", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "(Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Boolean;", "asLongOrNull", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "(Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Long;", "parseJsonOrNull", "payload", "replaceCanvasCapabilityInScopedHostUrl", "scopedUrl", "capability", "resolveInvokeResultAckTimeoutMs", "invokeTimeoutMs", "(Ljava/lang/Long;)J", "step-runtime_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GatewaySessionKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean asBooleanOrNull(JsonElement jsonElement) {
        if (!(jsonElement instanceof JsonPrimitive)) {
            return null;
        }
        String string = n.T1(((JsonPrimitive) jsonElement).getContent()).toString();
        if (u.W0(string, "true")) {
            return Boolean.TRUE;
        }
        if (u.W0(string, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long asLongOrNull(JsonElement jsonElement) {
        if (jsonElement instanceof JsonPrimitive) {
            return u.f1(((JsonPrimitive) jsonElement).getContent());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonObject asObjectOrNull(JsonElement jsonElement) {
        if (jsonElement instanceof JsonObject) {
            return (JsonObject) jsonElement;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String asStringOrNull(JsonElement jsonElement) {
        if (!(jsonElement instanceof JsonNull) && (jsonElement instanceof JsonPrimitive)) {
            return ((JsonPrimitive) jsonElement).getContent();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonElement parseJsonOrNull(String str) {
        String string = n.T1(str).toString();
        if (string.length() == 0) {
            return null;
        }
        try {
            return Json.INSTANCE.parseToJsonElement(string);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final String replaceCanvasCapabilityInScopedHostUrl(String scopedUrl, String capability) {
        p.e(scopedUrl, "scopedUrl");
        p.e(capability, "capability");
        int iR1 = n.r1(scopedUrl, "/__openclaw__/cap/", 0, false, 6);
        if (iR1 >= 0) {
            int i8 = iR1 + 18;
            int iR12 = n.r1(scopedUrl, "/", i8, false, 4);
            Integer numValueOf = Integer.valueOf(iR12);
            if (iR12 < 0) {
                numValueOf = null;
            }
            int iR13 = n.r1(scopedUrl, "?", i8, false, 4);
            Integer numValueOf2 = Integer.valueOf(iR13);
            if (iR13 < 0) {
                numValueOf2 = null;
            }
            int iR14 = n.r1(scopedUrl, "#", i8, false, 4);
            Integer numValueOf3 = Integer.valueOf(iR14);
            if (iR14 < 0) {
                numValueOf3 = null;
            }
            Integer num = (Integer) m.D0(l.d0(new Integer[]{numValueOf, numValueOf2, numValueOf3}));
            int iIntValue = num != null ? num.intValue() : scopedUrl.length();
            if (iIntValue > i8) {
                String strSubstring = scopedUrl.substring(0, i8);
                p.d(strSubstring, "substring(...)");
                String strSubstring2 = scopedUrl.substring(iIntValue);
                p.d(strSubstring2, "substring(...)");
                return a8.b.o(strSubstring, capability, strSubstring2);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long resolveInvokeResultAckTimeoutMs(java.lang.Long r8) {
        /*
            if (r8 == 0) goto L16
            long r0 = r8.longValue()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto Ld
            goto Le
        Ld:
            r8 = 0
        Le:
            if (r8 == 0) goto L16
            long r0 = r8.longValue()
        L14:
            r2 = r0
            goto L1a
        L16:
            r0 = 600000(0x927c0, double:2.964394E-318)
            goto L14
        L1a:
            r4 = 15000(0x3a98, double:7.411E-320)
            r6 = 600000(0x927c0, double:2.964394E-318)
            long r0 = k4.v.o(r2, r4, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewaySessionKt.resolveInvokeResultAckTimeoutMs(java.lang.Long):long");
    }
}
