package y6;

import La.H;
import La.K;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.netcore.BusPart;
import com.stepos.agentframework.adapter.netcore.BusQuestion;
import com.stepos.agentframework.adapter.netcore.BusTask;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import u4.AgentTaskEvent;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ly6/a;", "", "<init>", "()V", "Lu4/h;", "", Const.INTENT_KEY_PKGNAME, "(Lu4/h;)Ljava/lang/String;", "", "maxChars", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;I)Ljava/lang/String;", "DEFAULT_SNIPPET_CHARS", "I", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: y6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5943a {
    private static final int DEFAULT_SNIPPET_CHARS = 256;
    public static final C5943a INSTANCE = new C5943a();

    public final String a(String str, int i10) {
        p.i(str, "<this>");
        if (str.length() <= i10) {
            return str;
        }
        return K.R1(str, i10) + "...(len=" + str.length() + ")";
    }

    public final String b(AgentTaskEvent agentTaskEvent) {
        p.i(agentTaskEvent, "<this>");
        Map<String, Object> mapG = agentTaskEvent.g();
        int size = mapG != null ? mapG.size() : 0;
        List<BusPart> listO = agentTaskEvent.o();
        int size2 = listO != null ? listO.size() : 0;
        List<BusTask> listU = agentTaskEvent.u();
        int size3 = listU != null ? listU.size() : 0;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("taskId=");
        sb2.append(agentTaskEvent.y());
        sb2.append(" eventType=");
        sb2.append(agentTaskEvent.getEventType());
        sb2.append(" status=");
        sb2.append(agentTaskEvent.s());
        sb2.append(" type=");
        sb2.append(agentTaskEvent.C());
        sb2.append(" seq=");
        sb2.append(agentTaskEvent.getSeq());
        sb2.append(" subTaskIds=");
        sb2.append(agentTaskEvent.t().size());
        sb2.append(" subTasks=");
        sb2.append(size3);
        sb2.append(" resultParts=");
        sb2.append(size2);
        sb2.append(" pendingQuestions=");
        List<BusQuestion> listL = agentTaskEvent.l();
        sb2.append(listL != null ? listL.size() : 0);
        sb2.append(" hasAnswer=");
        sb2.append(agentTaskEvent.getAnswer() != null);
        sb2.append(" extensionsKeys=");
        sb2.append(size);
        String strA = agentTaskEvent.A();
        if (strA != null) {
            if (H.x0(strA)) {
                strA = null;
            }
            if (strA != null) {
                sb2.append(" title=");
                sb2.append(INSTANCE.a(strA, 80));
            }
        }
        return sb2.toString();
    }
}
