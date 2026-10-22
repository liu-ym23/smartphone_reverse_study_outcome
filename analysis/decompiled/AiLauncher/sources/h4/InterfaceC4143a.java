package h4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b;
import g4.ChatEventData;
import g4.ErrorResult;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import tb.C5530C;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\b\u0010\tJI\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lh4/a;", "", "LKb/a;", b.f30739f, "Ltb/C;", UxipConstants.f30685x, "tag", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(LKb/a;Ltb/C;Ljava/lang/Object;)V", "Lg4/b;", b.f30740g, "", "type", "data", "conversationId", "c", "(LKb/a;Lg4/b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(LKb/a;Ljava/lang/Object;)V", "Lg4/f;", "errorResult", Const.INTENT_KEY_UMID, "(LKb/a;Lg4/f;Ltb/C;Ljava/lang/Object;)V", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: h4.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC4143a {
    static /* synthetic */ void e(InterfaceC4143a interfaceC4143a, Kb.a aVar, ChatEventData chatEventData, String str, String str2, Object obj, String str3, int i10, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEvent");
        }
        if ((i10 & 32) != 0) {
            str3 = "";
        }
        interfaceC4143a.c(aVar, chatEventData, str, str2, obj, str3);
    }

    default void a(Kb.a eventSource, Object tag) {
        p.i(eventSource, "eventSource");
    }

    default void b(Kb.a eventSource, C5530C response, Object tag) {
        p.i(eventSource, "eventSource");
        p.i(response, "response");
    }

    default void c(Kb.a eventSource, ChatEventData eventData, String type, String data, Object tag, String conversationId) {
        p.i(eventSource, "eventSource");
        p.i(data, "data");
    }

    default void d(Kb.a eventSource, ErrorResult errorResult, C5530C response, Object tag) {
        p.i(eventSource, "eventSource");
        p.i(errorResult, "errorResult");
    }
}
