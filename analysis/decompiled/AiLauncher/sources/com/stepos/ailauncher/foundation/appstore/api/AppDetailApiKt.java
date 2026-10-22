package com.stepos.ailauncher.foundation.appstore.api;

import La.C;
import La.D;
import La.H;
import N5.j;
import com.google.gson.JsonPrimitive;
import com.stepos.aiengine.args.SingleFileBundle;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002\u001a\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"toAppDetail", "Lcom/stepos/ailauncher/foundation/appstore/api/AppDetail;", "Lcom/stepos/ailauncher/foundation/appstore/api/AppDetailDto;", "httpsOf", "", "url", "formatSize", "raw", "Lcom/google/gson/JsonPrimitive;", "formatBytes", SingleFileBundle.KEY_BYTES, "", "foundation_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppDetailApiKt {
    private static final String formatBytes(long j10) {
        double d10 = 1024;
        double d11 = d10 * 1024.0d;
        double d12 = d10 * d11;
        double d13 = j10;
        if (d13 >= d12) {
            y yVar = y.f34840a;
            String str = String.format(Locale.US, "%.2fGB", Arrays.copyOf(new Object[]{Double.valueOf(d13 / d12)}, 1));
            p.h(str, "format(...)");
            return str;
        }
        if (d13 >= d11) {
            y yVar2 = y.f34840a;
            String str2 = String.format(Locale.US, "%.2fMB", Arrays.copyOf(new Object[]{Double.valueOf(d13 / d11)}, 1));
            p.h(str2, "format(...)");
            return str2;
        }
        if (d13 >= 1024.0d) {
            y yVar3 = y.f34840a;
            String str3 = String.format(Locale.US, "%.2fKB", Arrays.copyOf(new Object[]{Double.valueOf(d13 / 1024.0d)}, 1));
            p.h(str3, "format(...)");
            return str3;
        }
        return j10 + "B";
    }

    private static final String formatSize(JsonPrimitive jsonPrimitive) {
        String bytes;
        if (jsonPrimitive == null) {
            return null;
        }
        if (jsonPrimitive.isNumber()) {
            Long lValueOf = Long.valueOf(jsonPrimitive.getAsLong());
            if (lValueOf.longValue() <= 0) {
                lValueOf = null;
            }
            if (lValueOf != null) {
                return formatBytes(lValueOf.longValue());
            }
            return null;
        }
        String strD = j.INSTANCE.d(jsonPrimitive.getAsString());
        if (strD == null) {
            return null;
        }
        Long lY = C.y(strD);
        if (lY != null) {
            Long l10 = lY.longValue() > 0 ? lY : null;
            if (l10 != null && (bytes = formatBytes(l10.longValue())) != null) {
                return bytes;
            }
        }
        return strD;
    }

    private static final String httpsOf(String str) {
        String strD = j.INSTANCE.d(str);
        if (strD == null) {
            return null;
        }
        if (!D.X(strD, "http://", false, 2, null)) {
            return strD;
        }
        return "https://" + H.R0(strD, "http://");
    }

    public static final AppDetail toAppDetail(AppDetailDto appDetailDto) {
        p.i(appDetailDto, "<this>");
        j jVar = j.INSTANCE;
        return new AppDetail(jVar.d(appDetailDto.getName()), formatSize(appDetailDto.getSize()), httpsOf(appDetailDto.getIcon()), jVar.d(appDetailDto.getDescription()), jVar.d(appDetailDto.getPublisher()));
    }
}
