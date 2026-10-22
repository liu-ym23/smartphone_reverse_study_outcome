package com.obric.assistant.dm.impl;

import android.app.Application;
import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.plugin.R;
import com.obric.memorydata.sdk.entity.search.AssistantQuResult;
import com.obric.memorydata.sdk.entity.search.ParamItem;
import com.obric.memorydata.sdk.entity.search.QuAction;
import com.obric.memorydata.sdk.entity.search.SearchResponse;
import com.obric.memorydata.sdk.entity.search.SearchResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PersonalContextService.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f22490a = null;

    static {
        f22490a = new f();
    }

    private f() {
    }

    public final com.obric.assistant.dm.api.b a(SearchResponse r11) {
        if (r11 == null) goto L48;
        SearchResult r12 = r11.getData();
        if (r12 == null) goto L48;
        AssistantQuResult r13 = r12.getQuResult();
        if (r13 == null) goto L48;
        List<QuAction> r14 = r13.getActions();
        if (r14 == null) goto L48;
        HashMap r1 = new HashMap();
        Iterator<QuAction> r15 = r14.iterator();
    L11:
        boolean r3 = false;
        if (r15.hasNext() == false) goto L34;
        QuAction r2 = (QuAction) ZeusTransformUtils.preCheckCast(r15.next(), QuAction.class, "com.obric.aiagent.plugin");
        h[] r5 = h.values();
        int r6 = r5.length;
        int r7 = 0;
    L14:
        if (r7 >= r6) goto L19;
        if (o.a(r5[r7].a(), r2.getActionName()) == true) goto L17;
        r7 = r7 + 1;
        goto L14
    L17:
        r3 = true;
    L19:
        if (r3 == false) goto L11;
        if (r2.getSearchResultCount() != 0) goto L11;
        Map<String, ParamItem> r4 = r2.getInputParams();
        if (r4 == null) goto L11;
        Collection<ParamItem> r8 = r4.values();
        if (r8 == null) goto L11;
        ParamItem r9 = (ParamItem) ZeusTransformUtils.preCheckCast(p.f((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")), ParamItem.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L11;
        if (r1.containsKey(r2.getActionName()) == true) goto L30;
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin");
        String r16 = r2.getActionName();
        ArrayList r17 = new ArrayList();
        r17.add(r9.getValue().toString());
        r10.put(r16, r17);
        goto L11
    L30:
        ArrayList r18 = (ArrayList) ZeusTransformUtils.preCheckCast(r1.get(r2.getActionName()), ArrayList.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L11;
        r18.add(r9.getValue().toString());
        goto L11
    L34:
        Iterator r19 = ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
        String r20 = "";
    L36:
        if (r19.hasNext() == false) goto L39;
        Map.Entry r21 = (Map.Entry) ZeusTransformUtils.preCheckCast(r19.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r22 = (String) ZeusTransformUtils.preCheckCast(r21.getKey(), String.class, "com.obric.aiagent.plugin");
        r20 = r20 + f22490a.a((ArrayList) ZeusTransformUtils.preCheckCast(r21.getValue(), ArrayList.class, "com.obric.aiagent.plugin"), r22);
        goto L36
    L39:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L41;
        boolean r110 = true;
    L42:
        if (r110 == false) goto L46;
        return new com.obric.assistant.dm.api.b(1, "");
    L46:
        return new com.obric.assistant.dm.api.b(0, r20);
    L41:
        r110 = false;
    L48:
        return new com.obric.assistant.dm.api.b(1, "");
    }

    private final String a(ArrayList<String> r14, String r15) {
        if (r14.isEmpty() == true) goto L13;
        if (r14.size() != 1) goto L9;
        String r16 = (String) ZeusTransformUtils.preCheckCast(p.k((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin")), String.class, "com.obric.aiagent.plugin");
        goto L13
    L9:
        if (r14.size() <= 3) goto L11;
        String r0 = p.a((Iterable) ZeusTransformUtils.preCheckCast(p.c((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin"), 3), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null) + ' ' + f22490a.a(ZeusTransformUtils.mapRes(R.string.obric_missing_more, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_missing_more"));
        goto L13
    L11:
        p.a((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    L13:
        if (o.a(r15, h.f22493b.a()) == false) goto L17;
        return a(ZeusTransformUtils.mapRes(R.string.obric_missing_contact_parameters, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_missing_contact_parameters"));
    L17:
        if (o.a(r15, h.f22494c.a()) == false) goto L21;
        return a(ZeusTransformUtils.mapRes(R.string.obric_missing_call_history_parameters, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_missing_call_history_parameters"));
    L21:
        if (o.a(r15, h.f22492a.a()) == false) goto L25;
        return a(ZeusTransformUtils.mapRes(R.string.obric_missing_sms_parameters, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_missing_sms_parameters"));
    L25:
        if (o.a(r15, h.f22496e.a()) == false) goto L29;
        return a(ZeusTransformUtils.mapRes(R.string.obric_missing_album_parameters, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_missing_album_parameters"));
    L29:
        if (o.a(r15, h.f22495d.a()) == false) goto L33;
        return a(ZeusTransformUtils.mapRes(R.string.obric_missing_photo_parameters, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_missing_photo_parameters"));
    L33:
        if (o.a(r15, h.f.a()) == false) goto L37;
        return a(ZeusTransformUtils.mapRes(R.string.obric_missing_note_parameters, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_missing_note_parameters"));
    L37:
        if (o.a(r15, h.g.a()) == false) goto L41;
        return a(ZeusTransformUtils.mapRes(R.string.obric_missing_alarm_parameters, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_missing_alarm_parameters"));
    L41:
        return a(ZeusTransformUtils.mapRes(R.string.obric_error_unknown_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_error_unknown_default"));
    }

    private final String a(int r3) {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        String r4 = r2.getString(r3);
    L6:
        if (r4 != null) goto L9;
        return "";
    L9:
        return r4;
    L5:
        r4 = null;
        goto L6
    }
}
