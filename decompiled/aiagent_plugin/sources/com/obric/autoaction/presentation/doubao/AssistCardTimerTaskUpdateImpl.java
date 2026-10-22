package com.obric.autoaction.presentation.doubao;

import android.net.Uri;
import com.google.gson.Gson;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.AssistRemoteCardUIParams;
import com.obric.autogui.common.api.presentation.ITimerTaskListener;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import d.s;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: AssistCardTimerTaskUpdateImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AssistCardTimerTaskUpdateImpl implements ITimerTaskListener {
    public AssistCardTimerTaskUpdateImpl() {
    }

    @Override // com.obric.autogui.common.api.presentation.ITimerTaskListener
    public void onTimerTaskRemoved(List<ITimerTaskListener.TimerTask> r4, boolean r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r6, "timerTasks");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        notifyTimerTaskDeleted((ITimerTaskListener.TimerTask) ZeusTransformUtils.preCheckCast(r7.next(), ITimerTaskListener.TimerTask.class, "com.obric.aiagent.plugin"), r5);
        goto L4
    }

    private final void notifyTimerTaskDeleted(ITimerTaskListener.TimerTask r14, boolean r15) {
        Map<String, String> r13 = r14.getExt();
        String r1 = null;
        if (r13 == null) goto L5;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r13.get("sessionKey"), String.class, "com.obric.aiagent.plugin");
    L6:
        Map<String, String> r16 = r14.getExt();
        if (r16 == null) goto L9;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r16.get(ObricMemoryConstants.KEY_SESSION_ID), String.class, "com.obric.aiagent.plugin");
    L10:
        Map<String, String> r17 = r14.getExt();
        if (r17 == null) goto L15;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17.get("doubaoMessageId"), String.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L15;
        Long r19 = d.o.o.e(r18);
    L16:
        Map<String, String> r2 = r14.getExt();
        if (r2 == null) goto L19;
        r1 = (String) ZeusTransformUtils.preCheckCast(r2.get(DownloadConstants.QUERY_KEY), String.class, "com.obric.aiagent.plugin");
    L19:
        String r6 = r1;
        if (r5 == null) goto L31;
        if (r4 == null) goto L31;
        if (r19 == null) goto L31;
        if (r6 == null) goto L31;
        Uri r110 = f.f24886a.a(r5);
        JSONObject r3 = new JSONObject();
        Gson r10 = j.f24894a.a();
        long r7 = r19.longValue();
        d.m[] r8 = new d.m[1];
        if (r15 == false) goto L28;
        String r111 = "1";
    L29:
        r8[0] = s.a("taskMigrate", r111);
        JSONObject r112 = r3.put("extra_ui_model", r10.toJson(new AssistRemoteCardUIParams(2, r4, r5, r6, r7, ao.c(r8)))).put("doubao_message_id", r19.longValue());
        ILogDepend.Companion.d("AssistRemoteCard", "update card on timerTask Deleted:" + r110);
        com.obric.aiagent.assistant_card.provider_core.b.f16338a.a(r110, r112);
        return;
    L28:
        r111 = "0";
    L31:
        Loog.INSTANCE.e("AssistRemoteCard", "notifyTimerTaskDeleted, invalid timerTask: " + r14);
        return;
    L15:
        r19 = null;
        goto L16
    L9:
        r4 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }
}
