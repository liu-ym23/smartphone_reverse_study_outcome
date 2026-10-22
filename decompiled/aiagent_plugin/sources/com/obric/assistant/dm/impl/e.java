package com.obric.assistant.dm.impl;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.agent.dm.InputParams;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Locale;

/* JADX INFO: compiled from: NlgBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.obric.assistant.dm.api.d {
    private static final String TAG = "[DM] NlgBuilder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22488a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e f22489b = null;

    /* JADX INFO: compiled from: NlgBuilder.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final e a() {
            return e.a();
        }
    }

    public e() {
    }

    public static final /* synthetic */ e a() {
        return f22489b;
    }

    static {
        f22488a = new a(null);
        f22489b = new e();
    }

    @Override // com.obric.assistant.dm.api.d
    public String a(String r2, String r3) {
        o.e(r2, "type");
        o.e(r3, "actionName");
        String r4 = r2.toLowerCase(Locale.ROOT);
        o.c(r4, "toLowerCase(...)");
        if (o.a(r4, d.f22483a.a()) == false) goto L7;
        return b(r3);
    L7:
        if (o.a(r4, d.f22484b.a()) == false) goto L11;
        return c(r3);
    L11:
        if (o.a(r4, d.f22485c.a()) == false) goto L15;
        return d(r3);
    L15:
        if (o.a(r4, d.f22486d.a()) == false) goto L19;
        return e(r3);
    L19:
        if (o.a(r4, d.f22487e.a()) == false) goto L23;
        return f(r3);
    L23:
        if (o.a(r4, d.h.a()) == false) goto L27;
        return h(r3);
    L27:
        if (o.a(r4, d.l.a()) == false) goto L31;
        return g(r3);
    L31:
        if (o.a(r4, d.i.a()) == false) goto L35;
        return a(r3);
    L35:
        if (o.a(r4, d.m.a()) == false) goto L39;
        return i(r3);
    L39:
        if (o.a(r4, d.n.a()) == false) goto L43;
        return j(r3);
    L43:
        if (o.a(r4, d.f.a()) == true) goto L54;
        if (o.a(r4, d.g.a()) == true) goto L54;
        if (o.a(r4, d.j.a()) == true) goto L54;
        if (o.a(r4, d.k.a()) == true) goto L54;
        return l(r3);
    L54:
        return k(r3);
    }

    @Override // com.obric.assistant.dm.api.d
    public String a(InputParams r2) {
        o.e(r2, "inputParams");
        com.obric.agent.dm.d r3 = r2.getType();
        o.a(r3);
        String r4 = r3.a();
        if (r4 == null) goto L5;
        String r5 = r4.toLowerCase(Locale.ROOT);
        o.c(r5, "toLowerCase(...)");
    L7:
        if (o.a(r5, d.f22483a.a()) == false) goto L11;
        return b();
    L11:
        if (o.a(r5, d.f22484b.a()) == false) goto L15;
        return c();
    L15:
        if (o.a(r5, d.f22485c.a()) == false) goto L19;
        return d();
    L19:
        if (o.a(r5, d.f22486d.a()) == false) goto L23;
        return e();
    L23:
        if (o.a(r5, d.f22487e.a()) == false) goto L27;
        return f();
    L27:
        if (o.a(r5, d.h.a()) == false) goto L31;
        return g();
    L31:
        if (o.a(r5, d.l.a()) == false) goto L35;
        return h();
    L35:
        if (o.a(r5, d.i.a()) == false) goto L39;
        return i();
    L39:
        if (o.a(r5, d.f.a()) == true) goto L50;
        if (o.a(r5, d.g.a()) == true) goto L50;
        if (o.a(r5, d.j.a()) == true) goto L50;
        if (o.a(r5, d.k.a()) == true) goto L50;
        return k();
    L50:
        return j();
    L5:
        r5 = null;
        goto L7
    }

    private final String a(String r3) {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_select_alarm_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_select_alarm_default"));
    }

    private final String b(String r3) {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_select_message_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_select_message_default"));
    }

    private final String c(String r3) {
        if (o.a(r3, "System_MultiUserSelect") == false) goto L6;
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_select_contact_multi, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_select_contact_multi"));
    L6:
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_select_contact_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_select_contact_default"));
    }

    private final String d(String r3) {
        if (o.a(r3, "System_MultiUserSelect") == false) goto L6;
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_select_call_history_multi, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_select_call_history_multi"));
    L6:
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_select_call_history_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_select_call_history_default"));
    }

    private final String e(String r3) {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_select_photo_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_select_photo_default"));
    }

    private final String f(String r3) {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_select_album_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_select_album_default"));
    }

    private final String g(String r3) {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_select_text_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_select_text_default"));
    }

    private final String h(String r3) {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_select_note_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_select_note_default"));
    }

    private final String i(String r3) {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_select_telephone_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_select_telephone_default"));
    }

    private final String j(String r3) {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_select_memory_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_select_memory_default"));
    }

    private final String k(String r3) {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_not_supported_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_not_supported_default"));
    }

    private final String l(String r3) {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_unknown_type_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_unknown_type_default"));
    }

    private final String b() {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_error_message_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_error_message_default"));
    }

    private final String c() {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_error_contact_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_error_contact_default"));
    }

    private final String d() {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_error_call_history_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_error_call_history_default"));
    }

    private final String e() {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_error_photo_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_error_photo_default"));
    }

    private final String f() {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_error_album_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_error_album_default"));
    }

    private final String g() {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_error_note_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_error_note_default"));
    }

    private final String h() {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_error_text_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_error_text_default"));
    }

    private final String i() {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_error_alarm_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_error_alarm_default"));
    }

    private final String j() {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_error_unsupported_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_error_unsupported_default"));
    }

    private final String k() {
        return j.f22497a.a(ZeusTransformUtils.mapRes(R.string.obric_error_unknown_default, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_error_unknown_default"));
    }
}
