package com.obric.assistant.dm.impl;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.agent.dm.InputParams;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.assistant.dm.api.IDialogManagement;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.sdk.entity.search.SearchResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.a.q;
import d.h.a.s;
import d.h.b.o;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: DialogManagement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DialogManagement implements IDialogManagement {
    public static final a Companion = null;
    private static final String TAG = "[DM]  NativeDialogManagement";
    private static final DialogManagement instance = null;
    private boolean active;
    private final b dmEventListener;
    private c ecaDataService;

    /* JADX INFO: compiled from: DialogManagement.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: DialogManagement.kt */
    public static final class b extends com.obric.assistant.dm.api.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogManagement f22474a;

        b(DialogManagement r1) {
            this.f22474a = r1;
        }
    }

    public static /* synthetic */ x lambda$g6MXT9MJp26rTf06texPF4O0B24(q r0, DialogManagement r1, int r2, List r3) {
        return userSelectWithAsr$lambda$6$lambda$5(r0, r1, r2, r3);
    }

    public DialogManagement() {
        b r0 = new b(this);
        this.dmEventListener = r0;
        com.obric.assistant.dm.impl.a.f22475a.b().a((com.obric.assistant.dm.api.a) ZeusTransformUtils.preCheckCast(r0, com.obric.assistant.dm.api.a.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ DialogManagement access$getInstance$cp() {
        return instance;
    }

    static {
        Companion = new a(null);
        instance = new DialogManagement();
    }

    @Override // com.obric.assistant.dm.api.IDialogManagement
    public boolean isActive() {
        monitor-enter(this);
        boolean r0 = this.active;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.dm.api.IDialogManagement
    public Object startDialog(com.obric.agent.dm.e r7, s<? super Integer, ? super String, ? super Integer, ? super List<? extends AppEntity>, ? super String, x> r8, d.c.d<? super x> r9) {
        s r0 = (s) ZeusTransformUtils.wrapperContextForParams(r8, s.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        monitor-enter(this);
        ILogDepend.Companion.i(TAG, "startDialog " + r7);     // Catch: Throwable -> L16
        c r11 = new c(r7);     // Catch: Throwable -> L16
        this.ecaDataService = r11;     // Catch: Throwable -> L16
        o.a(r11);     // Catch: Throwable -> L16
        if (r11.b() == true) goto L9;
        endDialog();     // Catch: Throwable -> L16
        r0.a(d.c.b.a.b.a(-1), "", d.c.b.a.b.a(0), null, "");     // Catch: Throwable -> L16
        x r12 = x.f38692a;     // Catch: Throwable -> L16
        monitor-exit(this);
        return r12;
    L9:
        c r13 = this.ecaDataService;     // Catch: Throwable -> L16
        o.a(r13);     // Catch: Throwable -> L16
        InputParams r14 = r13.d();     // Catch: Throwable -> L16
        o.a(r14);     // Catch: Throwable -> L16
        com.obric.agent.dm.d r15 = r14.getType();     // Catch: Throwable -> L16
        o.a(r15);     // Catch: Throwable -> L16
        String r16 = r15.a();     // Catch: Throwable -> L16
        if (r16 != null) goto L12;
        r16 = "";
    L12:
        String r2 = r16;
        String r5 = com.obric.assistant.dm.impl.a.f22475a.a().a(r2, "");     // Catch: Throwable -> L16
        Integer r1 = d.c.b.a.b.a(0);     // Catch: Throwable -> L16
        c r17 = this.ecaDataService;     // Catch: Throwable -> L16
        o.a(r17);     // Catch: Throwable -> L16
        Integer r3 = d.c.b.a.b.a(r17.c());     // Catch: Throwable -> L16
        j r18 = j.f22497a;     // Catch: Throwable -> L16
        c r19 = this.ecaDataService;     // Catch: Throwable -> L16
        o.a(r19);     // Catch: Throwable -> L16
        List<String> r20 = r19.e().a();     // Catch: Throwable -> L16
        o.a(r20);     // Catch: Throwable -> L16
        r0.a(r1, r2, r3, r18.a(r20, r2), r5);     // Catch: Throwable -> L16
        doActive();     // Catch: Throwable -> L16
        x r21 = x.f38692a;     // Catch: Throwable -> L16
        monitor-exit(this);
        return x.f38692a;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.dm.api.IDialogManagement
    public void endDialog() {
        monitor-enter(this);
        ILogDepend.Companion.i(TAG, "endDialog");     // Catch: Throwable -> L9
        if (this.active == false) goto L6;
        this.active = false;     // Catch: Throwable -> L9
    L6:
        x r0 = x.f38692a;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private final void doActive() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.active == true) goto L6;
        this.active = true;     // Catch: Throwable -> L9
    L6:
        x r0 = x.f38692a;     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    @Override // com.obric.assistant.dm.api.IDialogManagement
    public Object userSelectByHand(int r4, m<? super Integer, ? super com.obric.agent.dm.e, x> r5, d.c.d<? super x> r6) {
        m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        monitor-enter(this);
        ILogDepend.Companion.i(TAG, "userSelectByHand " + r4);     // Catch: Throwable -> L22
        com.obric.assistant.dm.impl.a.f22475a.c().a();     // Catch: Throwable -> L22
        if (isActive() == true) goto L9;
        r7.invoke(d.c.b.a.b.a(-2), null);     // Catch: Throwable -> L22
        x r9 = x.f38692a;     // Catch: Throwable -> L22
        monitor-exit(this);
        return r9;
    L9:
        c r10 = this.ecaDataService;     // Catch: Throwable -> L22
        o.a(r10);     // Catch: Throwable -> L22
        if (r10.a().b() == false) goto L14;
        r7.invoke(d.c.b.a.b.a(-3), null);     // Catch: Throwable -> L22
        x r11 = x.f38692a;     // Catch: Throwable -> L22
        monitor-exit(this);
        return r11;
    L14:
        c r12 = this.ecaDataService;     // Catch: Throwable -> L22
        o.a(r12);     // Catch: Throwable -> L22
        if (r12.a(r4) == false) goto L17;
        endDialog();     // Catch: Throwable -> L22
        Integer r13 = d.c.b.a.b.a(0);     // Catch: Throwable -> L22
        c r14 = this.ecaDataService;     // Catch: Throwable -> L22
        o.a(r14);     // Catch: Throwable -> L22
        r7.invoke(r13, r14.a());     // Catch: Throwable -> L22
    L18:
        x r15 = x.f38692a;     // Catch: Throwable -> L22
        monitor-exit(this);
        return x.f38692a;
    L17:
        r7.invoke(d.c.b.a.b.a(-1), null);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.dm.api.IDialogManagement
    public void userSelectWithAsr(String r5, q<? super Integer, ? super com.obric.agent.dm.e, ? super String, x> r6) {
        final q r7 = (q) ZeusTransformUtils.wrapperContextForParams(r6, q.class, "com.obric.aiagent.plugin");
        o.e(r5, "asr");
        o.e(r7, "callback");
        monitor-enter(this);
        ILogDepend.Companion.i(TAG, "userSelectWithAsr " + r5);     // Catch: Throwable -> L17
        com.obric.assistant.dm.impl.a.f22475a.c().a();     // Catch: Throwable -> L17
        if (isActive() == true) goto L9;
        r7.invoke(-2, null, "");     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L9:
        c r0 = this.ecaDataService;     // Catch: Throwable -> L17
        o.a(r0);     // Catch: Throwable -> L17
        if (r0.a().b() == false) goto L14;
        r7.invoke(-3, null, "");     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L14:
        endDialog();     // Catch: Throwable -> L17
        g.f22491a.a(r5, new $$Lambda$DialogManagement$g6MXT9MJp26rTf06texPF4O0B24(r7, this));     // Catch: Throwable -> L17
        x r8 = x.f38692a;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private static final x userSelectWithAsr$lambda$6$lambda$5(q r5, DialogManagement r6, int r7, List r8) {
        q r9 = (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin");
        List<Integer> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        o.e(r10, "indexes");
        if (r7 >= 0) goto L6;
        r9.invoke(1, null, "");
    L17:
        return x.f38692a;
    L6:
        if (r10.size() <= 1) goto L11;
        c r11 = r6.ecaDataService;
        o.a(r11);
        if (r11.a(r10) == false) goto L11;
        c r12 = r6.ecaDataService;
        o.a(r12);
        r9.invoke(0, r12.a(), "");
    L11:
        if (r10.size() != 1) goto L15;
        c r13 = r6.ecaDataService;
        o.a(r13);
        if (r13.a(((Number) ZeusTransformUtils.preCheckCast(r10.get(0), Number.class, "com.obric.aiagent.plugin")).intValue()) == false) goto L15;
        c r14 = r6.ecaDataService;
        o.a(r14);
        r9.invoke(0, r14.a(), "");
    L15:
        com.obric.assistant.dm.api.d r15 = com.obric.assistant.dm.impl.a.f22475a.a();
        c r16 = r6.ecaDataService;
        o.a(r16);
        InputParams r17 = r16.d();
        o.a(r17);
        r9.invoke(-1, null, r15.a(r17));
        goto L17
    }

    @Override // com.obric.assistant.dm.api.IDialogManagement
    public void getPopupContent(List<String> r3, String r4, String r5, q<? super Integer, ? super List<? extends AppEntity>, ? super String, x> r6) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        q r7 = (q) ZeusTransformUtils.wrapperContextForParams(r6, q.class, "com.obric.aiagent.plugin");
        o.e(r2, "candidates");
        o.e(r4, "type");
        o.e(r5, "actionName");
        o.e(r7, "callback");
        ISecureLogDepend.Companion.i(TAG, "getPopupContent type:" + r4 + " candidates:" + r2);
        r7.invoke(0, j.f22497a.a(r2, r4), com.obric.assistant.dm.impl.a.f22475a.a().a(r4, r5));
    }

    @Override // com.obric.assistant.dm.api.IDialogManagement
    public com.obric.assistant.dm.api.b handlePersonalContext(SearchResponse r3) {
        ISecureLogDepend.Companion.i(TAG, "handlePersonalContext response: " + r3);
        return f.f22490a.a(r3);
    }

    @Override // com.obric.assistant.dm.api.IDialogManagement
    public void getConfirmationPhraseForSecondTime(String r7, List<String> r8, s<? super Integer, ? super List<? extends AppEntity>, ? super String, ? super String, ? super String, x> r9) {
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        s r0 = (s) ZeusTransformUtils.wrapperContextForParams(r9, s.class, "com.obric.aiagent.plugin");
        o.e(r7, "intentType");
        o.e(r10, "entityIds");
        o.e(r0, "callback");
        r0.a(0, j.f22497a.a(r10, r7), getTtsPhraseForSecondTime(r7), getMockPhraseForSecondTime(r7, true), getMockPhraseForSecondTime(r7, false));
    }

    private final String getTtsPhraseForSecondTime(String r3) {
        switch(r3.hashCode()) {
            case -1665258020: goto L26;
            case -1245751298: goto L22;
            case 243518540: goto L18;
            case 1138119447: goto L14;
            case 1390046889: goto L10;
            case 1570186989: goto L6;
            default: goto L30;
        };
    L6:
        if (r3.equals("Contacts_AddToBlacklist") == false) goto L30;
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_confirm_add_blacklist, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_confirm_add_blacklist"));
    L10:
        if (r3.equals("Memory_Delete") == false) goto L30;
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_confirm_delete_memory, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_confirm_delete_memory"));
    L14:
        if (r3.equals("Contacts_Delete") == false) goto L30;
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_confirm_delete_content, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_confirm_delete_content"));
    L18:
        if (r3.equals("Recorder_Delete") == false) goto L30;
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_confirm_delete_recording, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_confirm_delete_recording"));
    L22:
        if (r3.equals("Messages_Delete") == false) goto L30;
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_confirm_delete_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_confirm_delete_message"));
    L26:
        if (r3.equals("Phone_Delete") == false) goto L30;
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_confirm_delete_call_history, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_confirm_delete_call_history"));
    L30:
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_error_unknown_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_error_unknown_default"));
    }

    private final String getMockPhraseForSecondTime(String r4, boolean r5) {
        switch(r4.hashCode()) {
            case -1665258020: goto L36;
            case -1245751298: goto L30;
            case 243518540: goto L24;
            case 1138119447: goto L18;
            case 1390046889: goto L12;
            case 1570186989: goto L6;
            default: goto L42;
        };
    L6:
        if (r4.equals("Contacts_AddToBlacklist") == false) goto L42;
        if (r5 == false) goto L44;
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_confirm_confirm_add_blacklist, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_confirm_confirm_add_blacklist"));
    L44:
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_confirm_cancel_add_blacklist, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_confirm_cancel_add_blacklist"));
    L12:
        if (r4.equals("Memory_Delete") == false) goto L42;
        if (r5 == false) goto L46;
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_confirm_confirm_delete_memory, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_confirm_confirm_delete_memory"));
    L46:
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_confirm_cancel_delete_memory, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_confirm_cancel_delete_memory"));
    L18:
        if (r4.equals("Contacts_Delete") == false) goto L42;
        if (r5 == false) goto L48;
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_confirm_confirm_delete_content, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_confirm_confirm_delete_content"));
    L48:
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_confirm_cancel_delete_content, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_confirm_cancel_delete_content"));
    L24:
        if (r4.equals("Recorder_Delete") == false) goto L42;
        if (r5 == false) goto L50;
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_confirm_confirm_delete_recording, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_confirm_confirm_delete_recording"));
    L50:
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_confirm_cancel_delete_recording, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_confirm_cancel_delete_recording"));
    L30:
        if (r4.equals("Messages_Delete") == false) goto L42;
        if (r5 == false) goto L52;
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_confirm_confirm_delete_call_history, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_confirm_confirm_delete_call_history"));
    L52:
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_confirm_cancel_delete_call_history, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_confirm_cancel_delete_call_history"));
    L36:
        if (r4.equals("Phone_Delete") == false) goto L42;
        if (r5 == false) goto L54;
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_confirm_confirm_delete_call_history, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_confirm_confirm_delete_call_history"));
    L54:
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_confirm_cancel_delete_call_history, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_confirm_cancel_delete_call_history"));
    L42:
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_error_unknown_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_error_unknown_default"));
    }
}
