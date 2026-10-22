package com.obric.agent.intents;

import android.content.Context;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemInAppSearchIntent;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemInAppSearchParams;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.h;
import d.o;

/* JADX INFO: compiled from: InAppSearchIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InAppSearchIntent extends BaseSystemInAppSearchIntent {
    public static final a Companion = null;
    private static final String INTENT_ALARM_SEARCH = "Clock_SearchAlarm";
    private static final String INTENT_CONTACTS_SEARCH = "Contacts_Search";
    private static final String INTENT_COUNTDOWN_SEARCH = "Clock_SearchCountdown";
    private static final String INTENT_MESSAGES_SEARCH = "Messages_Search";
    private static final String INTENT_NOTES_SEARCH = "Notes_Search";
    private static final String INTENT_PHONE_SEARCH = "Phone_Search";
    private static final String INTENT_RECORDER_SEARCH = "Recorder_Search";
    private static final String TAG = "InAppSearchIntent";

    /* JADX INFO: compiled from: InAppSearchIntent.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: InAppSearchIntent.kt */
    @f(b = "InAppSearchIntent.kt", c = {34}, d = "doAction", e = "com.obric.agent.intents.InAppSearchIntent")
    static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f14631c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ InAppSearchIntent f14632d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f14633e;

        b(InAppSearchIntent r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14632d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14631c = r3;
            this.f14633e |= Integer.MIN_VALUE;
            return this.f14632d.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new a(null);
    }

    public InAppSearchIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemInAppSearchIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<AppEntity[]>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<AppEntity[]>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((SystemInAppSearchParams) ZeusTransformUtils.preCheckCast(r6, SystemInAppSearchParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemInAppSearchIntent
    public Object doAction(SystemInAppSearchParams r28, DispatchContext r29, d.c.d<? super IntentResult<AppEntity[]>> r30) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r30, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L7;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin");
        if ((r2.f14633e & Integer.MIN_VALUE) == 0) goto L7;
        r2.f14633e -= Integer.MIN_VALUE;
    L8:
        b r9 = r2;
        Object r1 = r9.f14631c;
        Object r3 = d.c.a.b.a();
        int r4 = r9.f14633e;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r9.f14630b, String.class, "com.obric.aiagent.plugin");
        DispatchContext r6 = (DispatchContext) ZeusTransformUtils.preCheckCast(r9.f14629a, DispatchContext.class, "com.obric.aiagent.plugin");
        o.a(r1);     // Catch: Exception -> L14
        DispatchContext r13 = r6;
    L26:
        com.obric.memorydata.sdk.intent.a.b r7 = (com.obric.memorydata.sdk.intent.a.b) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.sdk.intent.a.b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
        if (r7.a().length != 0) goto L29;
        boolean r8 = true;
    L31:
        if ((!r8) == false) goto L70;
        if (r5 != null) goto L34;
    L64:
        String r10 = null;
    L65:
        String r18 = r10;
        if (r18 == null) goto L69;
        return new IntentResult(0, r7.a(), null, r18, false, false, 0, null, null, null, DownloadErrorCode.ERROR_CANCELED, null);
    L69:
        return new IntentResult(1, r7.a(), null, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.in_app_search_unknown_type, WsChannelMultiProcessSharedProvider.STRING_TYPE, "in_app_search_unknown_type")), false, false, 0, null, null, null, DownloadErrorCode.ERROR_CANCELED, null);
    L34:
        switch(r5.hashCode()) {
            case -1236136487: goto L61;
            case -816629765: goto L57;
            case -158897882: goto L53;
            case 672640073: goto L49;
            case 1198672632: goto L45;
            case 1567240980: goto L41;
            case 1647438488: goto L37;
            default: goto L64;
        };     // Catch: Exception -> L14
    L37:
        if (r5.equals(INTENT_ALARM_SEARCH) == false) goto L64;
        r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.in_app_search_alarm_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "in_app_search_alarm_success"));     // Catch: Exception -> L14
        goto L65
    L41:
        if (r5.equals(INTENT_CONTACTS_SEARCH) == false) goto L64;
        r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.in_app_search_contact_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "in_app_search_contact_success"));     // Catch: Exception -> L14
        goto L65
    L45:
        if (r5.equals(INTENT_COUNTDOWN_SEARCH) == false) goto L64;
        r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.in_app_search_countdown_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "in_app_search_countdown_success"));     // Catch: Exception -> L14
        goto L65
    L49:
        if (r5.equals(INTENT_RECORDER_SEARCH) == false) goto L64;
        r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.in_app_search_recorder_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "in_app_search_recorder_success"));     // Catch: Exception -> L14
        goto L65
    L53:
        if (r5.equals(INTENT_NOTES_SEARCH) == false) goto L64;
        r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.in_app_search_note_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "in_app_search_note_success"));     // Catch: Exception -> L14
        goto L65
    L57:
        if (r5.equals(INTENT_MESSAGES_SEARCH) == false) goto L64;
        r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.in_app_search_message_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "in_app_search_message_success"));     // Catch: Exception -> L14
        goto L65
    L61:
        if (r5.equals(INTENT_PHONE_SEARCH) == false) goto L64;
        r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.in_app_search_call_history_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "in_app_search_call_history_success"));     // Catch: Exception -> L14
        goto L65
    L70:
        if (r5 != null) goto L72;
    L102:
        String r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.in_app_search_unknown_type, WsChannelMultiProcessSharedProvider.STRING_TYPE, "in_app_search_unknown_type"));     // Catch: Exception -> L14
    L103:
        String r12 = r11;
        d.h.b.o.a(r12);     // Catch: Exception -> L14
        return new IntentResult(1, r7.a(), null, r12, false, false, 0, null, null, null, DownloadErrorCode.ERROR_CANCELED, null);
    L72:
        switch(r5.hashCode()) {
            case -1236136487: goto L99;
            case -816629765: goto L95;
            case -158897882: goto L91;
            case 672640073: goto L87;
            case 1198672632: goto L83;
            case 1567240980: goto L79;
            case 1647438488: goto L75;
            default: goto L102;
        };     // Catch: Exception -> L14
    L75:
        if (r5.equals(INTENT_ALARM_SEARCH) == false) goto L102;
        r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.in_app_search_alarm_not_found, WsChannelMultiProcessSharedProvider.STRING_TYPE, "in_app_search_alarm_not_found"));     // Catch: Exception -> L14
        goto L103
    L79:
        if (r5.equals(INTENT_CONTACTS_SEARCH) == false) goto L102;
        r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.in_app_search_contact_not_found, WsChannelMultiProcessSharedProvider.STRING_TYPE, "in_app_search_contact_not_found"));     // Catch: Exception -> L14
        goto L103
    L83:
        if (r5.equals(INTENT_COUNTDOWN_SEARCH) == false) goto L102;
        r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.in_app_search_countdown_not_found, WsChannelMultiProcessSharedProvider.STRING_TYPE, "in_app_search_countdown_not_found"));     // Catch: Exception -> L14
        goto L103
    L87:
        if (r5.equals(INTENT_RECORDER_SEARCH) == false) goto L102;
        r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.in_app_search_recorder_not_found, WsChannelMultiProcessSharedProvider.STRING_TYPE, "in_app_search_recorder_not_found"));     // Catch: Exception -> L14
        goto L103
    L91:
        if (r5.equals(INTENT_NOTES_SEARCH) == false) goto L102;
        r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.in_app_search_note_not_found, WsChannelMultiProcessSharedProvider.STRING_TYPE, "in_app_search_note_not_found"));     // Catch: Exception -> L14
        goto L103
    L95:
        if (r5.equals(INTENT_MESSAGES_SEARCH) == false) goto L102;
        r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.in_app_search_message_not_found, WsChannelMultiProcessSharedProvider.STRING_TYPE, "in_app_search_message_not_found"));     // Catch: Exception -> L14
        goto L103
    L99:
        if (r5.equals(INTENT_PHONE_SEARCH) == false) goto L102;
        r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.in_app_search_call_history_not_found, WsChannelMultiProcessSharedProvider.STRING_TYPE, "in_app_search_call_history_not_found"));     // Catch: Exception -> L14
        goto L103
    L29:
        r8 = false;
        goto L31
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        o.a(r1);
        String r14 = r28.getSearchIntent();
        String r15 = r28.getQuery();
        String r16 = r28.getQuResult();
        if (r14 == null) goto L107;
        if (r15 == null) goto L107;
        if (r16 == null) goto L107;
        com.obric.memorydata.sdk.intent.a r17 = com.obric.memorydata.sdk.intent.a.f33834a;     // Catch: Exception -> L14
        r13 = r29;
        r9.f14629a = r13;     // Catch: Exception -> L14
        r9.f14630b = r14;     // Catch: Exception -> L14
        r9.f14633e = 1;     // Catch: Exception -> L14
        Object r19 = com.obric.memorydata.sdk.intent.a.a(r17, r15, r16, 0, null, r9, 12, null);     // Catch: Exception -> L14
        if (r19 != r3) goto L25;
        return r3;
    L25:
        r5 = r14;
        r1 = r19;
    L107:
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_IO, null);
    L14:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "InAppSearch execute failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L7:
        r2 = new b(this, r0);
        goto L8
    }
}
