package q4;

import La.H;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import u4.AgentMessage;
import v9.C5685n;
import w4.ChatMessage;
import w4.TaskResultArtifactEntity;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lw4/c;", "", "Lu4/a;", "partSnapshot", "Lw4/j;", Const.INTENT_KEY_APIKEY, "(Lw4/c;Ljava/util/List;)Ljava/util/List;", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: q4.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5151d {
    public static final List<TaskResultArtifactEntity> a(ChatMessage chatMessage, List<AgentMessage> partSnapshot) {
        p.i(chatMessage, "<this>");
        p.i(partSnapshot, "partSnapshot");
        String sessionId = chatMessage.getSessionId();
        if (sessionId.length() == 0 || chatMessage.getMessageId().length() == 0) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = partSnapshot.iterator();
        while (it.hasNext()) {
            List<AgentTool> listG = ((AgentMessage) it.next()).g();
            if (listG != null) {
                for (AgentTool agentTool : listG) {
                    TaskResultFileAppUiPayload taskResultFileAppUiPayloadQ = i.INSTANCE.q(agentTool.getName(), agentTool.getResult(), agentTool.getParameter());
                    if (taskResultFileAppUiPayloadQ != null) {
                        for (TaskResultFileAppUiItem taskResultFileAppUiItem : taskResultFileAppUiPayloadQ.d()) {
                            if (!H.x0(taskResultFileAppUiItem.getFileId())) {
                                arrayList.add(new TaskResultArtifactEntity(taskResultFileAppUiItem.getFileId(), sessionId, chatMessage.getMessageId(), agentTool.getToolCallId(), taskResultFileAppUiPayloadQ.getTaskId(), taskResultFileAppUiPayloadQ.getVersionId(), taskResultFileAppUiItem.getCloudPath(), taskResultFileAppUiItem.getFileName(), taskResultFileAppUiItem.getTitle(), taskResultFileAppUiItem.getMimeType(), taskResultFileAppUiItem.getSize(), chatMessage.getTime(), 0, 0L, 12288, null));
                            }
                        }
                    }
                }
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(((TaskResultArtifactEntity) obj).getFileId(), obj);
        }
        return F.m1(linkedHashMap.values());
    }
}
