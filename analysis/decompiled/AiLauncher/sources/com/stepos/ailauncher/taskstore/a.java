package com.stepos.ailauncher.taskstore;

import La.D;
import La.H;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/taskstore/a;", "", "<init>", "()V", "", "taskId", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "PREFIX", "Ljava/lang/String;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final String PREFIX = "task_";

    public final String a(String taskId) {
        p.i(taskId, "taskId");
        String string = H.D1(taskId).toString();
        if (string.length() == 0) {
            return null;
        }
        int i10 = 0;
        if (D.X(string, PREFIX, false, 2, null)) {
            String strSubstring = string.substring(5);
            p.h(strSubstring, "substring(...)");
            if (strSubstring.length() > 0) {
                while (i10 < strSubstring.length()) {
                    if (Character.isDigit(strSubstring.charAt(i10))) {
                        i10++;
                    }
                }
                return strSubstring;
            }
            return null;
        }
        while (i10 < string.length()) {
            if (!Character.isDigit(string.charAt(i10))) {
                return null;
            }
            i10++;
        }
        return PREFIX + string;
    }
}
