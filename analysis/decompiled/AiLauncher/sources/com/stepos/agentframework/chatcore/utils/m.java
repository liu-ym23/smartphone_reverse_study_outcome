package com.stepos.agentframework.chatcore.utils;

import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/stepos/agentframework/chatcore/utils/m;", "", "<init>", "()V", "", "tag", "msg", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "", "logLevel", "c", "(ILjava/lang/String;Ljava/lang/String;)V", "level", Const.INTENT_KEY_PKGNAME, "MAX_LOG_LENGTH", "I", "DEFAULT_TAG", "Ljava/lang/String;", "LOG_LEVEL_DEBUG", "LOG_LEVEL_INFO", "LOG_LEVEL_ERROR", "LOG_LEVEL_WARN", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class m {
    private static final String DEFAULT_TAG = "LongLog";
    public static final m INSTANCE = new m();
    private static final int LOG_LEVEL_DEBUG = 0;
    private static final int LOG_LEVEL_ERROR = 2;
    private static final int LOG_LEVEL_INFO = 1;
    private static final int LOG_LEVEL_WARN = 3;
    private static final int MAX_LOG_LENGTH = 3000;

    public final void a(String tag, String msg) {
        c(0, tag, msg);
    }

    public final void b(int level, String tag, String msg) {
        if (level == 0) {
            C4148a.d(tag, msg, false, 4, null);
            return;
        }
        if (level == 1) {
            C4148a.k(tag, msg, false, 4, null);
            return;
        }
        if (level == 2) {
            C4148a.h(tag, msg, false, 4, null);
        } else if (level != 3) {
            C4148a.d(tag, msg, false, 4, null);
        } else {
            C4148a.u(tag, msg, false, 4, null);
        }
    }

    public final void c(int logLevel, String tag, String msg) {
        if (tag == null || tag.length() == 0) {
            tag = DEFAULT_TAG;
        }
        if (msg == null) {
            msg = "null";
        }
        if (msg.length() <= 3000) {
            b(logLevel, tag, msg);
            return;
        }
        int length = msg.length();
        int i10 = 1;
        int i11 = 0;
        while (i11 < length) {
            int iJ = C5685n.j(i11 + 3000, length);
            try {
                String strSubstring = msg.substring(i11, iJ);
                p.h(strSubstring, "substring(...)");
                b(logLevel, tag + "[part:" + i10 + "/" + ((length + 2999) / 3000) + "]", strSubstring);
                i10++;
                i11 = iJ;
            } catch (Exception e10) {
                C4148a.h(tag, "Error while splitting log at part " + i10 + ": " + e10.getMessage(), false, 4, null);
                return;
            }
        }
    }
}
