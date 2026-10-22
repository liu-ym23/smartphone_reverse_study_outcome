package com.stepos.agentframework.chatui.view;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "durationMs", "", Const.INTENT_KEY_APIKEY, "(J)Ljava/lang/String;", "agentcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.view.l, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2082l {
    public static final String a(long j10) {
        StringBuilder sb2;
        long jG = C5685n.g(j10, 0L) / 1000;
        if (jG < 60) {
            sb2 = new StringBuilder();
        } else {
            long j11 = jG / 60;
            jG %= 60;
            sb2 = new StringBuilder();
            sb2.append(j11);
            sb2.append("min");
        }
        sb2.append(jG);
        sb2.append("s");
        return sb2.toString();
    }
}
