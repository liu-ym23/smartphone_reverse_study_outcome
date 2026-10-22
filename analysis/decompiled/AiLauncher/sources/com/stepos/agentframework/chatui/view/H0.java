package com.stepos.agentframework.chatui.view;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/chatui/view/H0;", "", "<init>", "()V", "", "rawName", "c", "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "", "finished", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Z)Ljava/lang/String;", "CALLING_PREFIX", "Ljava/lang/String;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class H0 {
    private static final String CALLING_PREFIX = "正在";
    public static final H0 INSTANCE = new H0();

    public final String a(String rawName) {
        kotlin.jvm.internal.p.i(rawName, "rawName");
        return rawName;
    }

    public final String b(String rawName, boolean finished) {
        kotlin.jvm.internal.p.i(rawName, "rawName");
        return finished ? a(rawName) : c(rawName);
    }

    public final String c(String rawName) {
        kotlin.jvm.internal.p.i(rawName, "rawName");
        return CALLING_PREFIX + La.H.R0(rawName, CALLING_PREFIX);
    }
}
