package V5;

import L4.l;
import Z8.r;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.foundation.R$string;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\n\u001a\u00020\t2.\u0010\b\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0006`\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bRJ\u0010\u001c\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0006`\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\u000bR>\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!0\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!`\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010\u000b¨\u0006%"}, d2 = {"LV5/b;", "", "<init>", "()V", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "arrayList", "LY8/t;", "e", "(Ljava/util/HashMap;)V", "key", "", "keepTime", "", Const.INTENT_KEY_UMID, "(Ljava/lang/String;J)Z", "LL4/l;", VoiceWakeupReceiver.EXTRA_STATE, Const.INTENT_KEY_PKGNAME, "(LL4/l;)Ljava/lang/String;", "c", "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "bubbleTxt", "f", "(Ljava/lang/String;Ljava/lang/String;)V", "bubbleTxtArr", "Ljava/util/HashMap;", "getBubbleTxtArr", "()Ljava/util/HashMap;", "setBubbleTxtArr", "LV5/a;", "bubbleLogList", "getBubbleLogList", "setBubbleLogList", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final b INSTANCE = new b();
    private static HashMap<String, String[]> bubbleTxtArr = new HashMap<>();
    private static HashMap<String, BubbleLog> bubbleLogList = new HashMap<>();

    public final String a(String key) {
        p.i(key, "key");
        String[] strArr = bubbleTxtArr.get(key);
        if (strArr == null) {
            return "";
        }
        BubbleLog bubbleLog = bubbleLogList.get(key);
        if (bubbleLog != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (!p.d(str, bubbleLog.getContent())) {
                    arrayList.add(str);
                }
            }
            strArr = (String[]) arrayList.toArray(new String[0]);
            if (strArr.length == 0) {
                return bubbleLog.getContent();
            }
        }
        return strArr.length == 0 ? "" : (String) r.C0(strArr, Random.INSTANCE);
    }

    public final String b(l state) {
        p.i(state, "state");
        if (p.d(state, l.U.INSTANCE)) {
            return c("task_running_safe");
        }
        if (p.d(state, l.S.INSTANCE)) {
            return c(SpriteEventAction.TASK_SUCCESS);
        }
        if (p.d(state, l.C0948v.INSTANCE)) {
            return c(SpriteEventAction.TASK_INTERRUPTED);
        }
        if (p.d(state, l.C0937j.INSTANCE)) {
            return c("task_fail");
        }
        if (p.d(state, l.C0943q.INSTANCE)) {
            return c("idle_night");
        }
        if (p.d(state, l.C0942p.INSTANCE)) {
            return c("idle_loafing");
        }
        if (p.d(state, l.C0940n.INSTANCE)) {
            return c("idle_flying");
        }
        if (p.d(state, l.C0941o.INSTANCE)) {
            return c("idle_music");
        }
        if (p.d(state, l.C0939m.INSTANCE)) {
            return c("idle_exercise");
        }
        if (p.d(state, l.C0944r.INSTANCE)) {
            return c("idle_safe");
        }
        if (p.d(state, l.C0945s.INSTANCE)) {
            return c("idle_night_wakeup");
        }
        if (p.d(state, l.C0938k.INSTANCE)) {
            return c("gui_safe");
        }
        if (!p.d(state, l.y.INSTANCE)) {
            return "";
        }
        String string = C3197a.INSTANCE.a().getString(R$string.sprite_network_lost);
        p.h(string, "getString(...)");
        return string;
    }

    public final String c(String key) {
        p.i(key, "key");
        String[] strArr = bubbleTxtArr.get(key);
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        String str = (String) r.C0(strArr, Random.INSTANCE);
        f(key, str);
        return str;
    }

    public final boolean d(String key, long keepTime) {
        p.i(key, "key");
        BubbleLog bubbleLog = bubbleLogList.get(key);
        return bubbleLog == null || System.currentTimeMillis() - bubbleLog.getTime() >= keepTime;
    }

    public final void e(HashMap<String, String[]> arrayList) {
        p.i(arrayList, "arrayList");
        bubbleTxtArr.clear();
        bubbleTxtArr.putAll(arrayList);
    }

    public final void f(String key, String bubbleTxt) {
        p.i(key, "key");
        p.i(bubbleTxt, "bubbleTxt");
        bubbleLogList.put(key, new BubbleLog(key, bubbleTxt, 0L, 4, null));
    }
}
