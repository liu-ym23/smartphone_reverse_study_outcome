package com.obric.agent.dm;

import android.content.Context;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.Gson;
import com.obric.agent.IAgentService;
import com.obric.agent.ObricService;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.aiagent.assistant.idl.bean.DataSource;
import com.obric.aiagent.assistant.idl.bean.OAppIntentBizContentType;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.intent.BaseSystemUserRemindIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.Options;
import com.obric.capabilitykit.common.intent.SystemUserRemindParams;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: UserRemindIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserRemindIntent extends BaseSystemUserRemindIntent {
    public UserRemindIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemUserRemindIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((SystemUserRemindParams) ZeusTransformUtils.preCheckCast(r6, SystemUserRemindParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemUserRemindIntent
    public Object doAction(SystemUserRemindParams r26, DispatchContext r27, d.c.d<? super IntentResult<Empty>> r28) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        Gson r1 = EntityExtKt.a();
        DataSource r8 = new DataSource("System", getName(), null, 4, null);
        List r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        ConcurrentHashMap r2 = new ConcurrentHashMap();
        String r3 = r26.getTitle();
        if (r3 == null) goto L5;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.put("KEY_TITLE", r3), String.class, "com.obric.aiagent.plugin");
    L5:
        String r5 = r26.getContent();
        if (r5 == null) goto L8;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r2.put("KEY_CONTENT", r5), String.class, "com.obric.aiagent.plugin");
    L8:
        Options[] r7 = r26.getOptions();
        if (r7 == null) goto L14;
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r7.length), Collection.class, "com.obric.aiagent.plugin");
        int r10 = r7.length;
        int r12 = 0;
    L11:
        if (r12 >= r10) goto L13;
        r9.add(r7[r12].getText());
        r12 = r12 + 1;
        goto L11
    L13:
        String r13 = (String) ZeusTransformUtils.preCheckCast(r2.put("KEY_OPTIONS", ObricService.INSTANCE.getGson().toJson((String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"))), String.class, "com.obric.aiagent.plugin");
    L14:
        String[] r14 = r26.getCandidate();
        if (r14 == null) goto L17;
        r2.put("KEY_CANDIDATE", ObricService.INSTANCE.getGson().toJson(r14));
    L17:
        x r15 = x.f38692a;
        String r18 = r1.toJson(new AppIntentMessage(r8, true, true, null, null, false, false, null, r11, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin"), 248, null));
        IAgentService r17 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L20;
        o.a(r18);
        IAgentService.a.a(r17, r18, OAppIntentBizContentType.USER_REMIND_CARD, String.valueOf(r27.getQuestionId()), 0, null, 24, null);
    L20:
        IntentResult r16 = new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
        r16.setDetails(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r27.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_user_remind_msg, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_user_remind_msg")));
        JSONObject r19 = new JSONObject();
        r19.put("o_is_user_remind", "1");
        IMAppActionExt r20 = new IMAppActionExt();
        r20.put("client_meta", r19.toString());
        r16.setExt((ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r20, ConcurrentHashMap.class, "com.obric.aiagent.plugin"));
        return r16;
    }
}
