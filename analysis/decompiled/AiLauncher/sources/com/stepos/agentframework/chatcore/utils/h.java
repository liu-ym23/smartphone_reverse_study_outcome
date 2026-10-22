package com.stepos.agentframework.chatcore.utils;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "", Const.INTENT_KEY_APIKEY, "(J)Ljava/lang/String;", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class h {
    public static final String a(long j10) {
        double d10 = j10;
        if (d10 >= 1.073741824E9d) {
            y yVar = y.f34840a;
            String str = String.format("%.1f GB", Arrays.copyOf(new Object[]{Double.valueOf(d10 / 1.073741824E9d)}, 1));
            p.h(str, "format(...)");
            return str;
        }
        if (d10 >= 1048576.0d) {
            y yVar2 = y.f34840a;
            String str2 = String.format("%.1f MB", Arrays.copyOf(new Object[]{Double.valueOf(d10 / 1048576.0d)}, 1));
            p.h(str2, "format(...)");
            return str2;
        }
        if (d10 >= 1024.0d) {
            y yVar3 = y.f34840a;
            String str3 = String.format("%.1f KB", Arrays.copyOf(new Object[]{Double.valueOf(d10 / 1024.0d)}, 1));
            p.h(str3, "format(...)");
            return str3;
        }
        return j10 + " B";
    }
}
