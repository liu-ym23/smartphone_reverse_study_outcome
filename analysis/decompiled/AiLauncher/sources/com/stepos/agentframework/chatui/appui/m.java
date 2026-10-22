package com.stepos.agentframework.chatui.appui;

import La.D;
import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "widgetAction", "", "structuredContent", "", "c", "(Ljava/lang/String;Ljava/lang/Object;)Z", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Z", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;)Z", "agentcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class m {
    public static final boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj instanceof CharSequence ? !H.x0((CharSequence) obj) : obj instanceof Map ? !((Map) obj).isEmpty() : obj instanceof Collection ? !((Collection) obj).isEmpty() : ((obj instanceof Object[]) && ((Object[]) obj).length == 0) ? false : true;
    }

    public static final boolean b(String str) {
        return D.X(H.s1(H.s1(str, '.', null, 2, null), JsonPointer.SEPARATOR, null, 2, null), "ACTION_TOGGLE_", false, 2, null);
    }

    public static final boolean c(String widgetAction, Object obj) {
        p.i(widgetAction, "widgetAction");
        if (H.x0(widgetAction) || b(widgetAction)) {
            return false;
        }
        return a(obj);
    }
}
