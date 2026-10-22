package com.obric.aiagent.executionengine.scheduler.impl.a;

import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import d.s;
import java.util.Map;

/* JADX INFO: compiled from: ActionPackageNames.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18027a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f18028b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f18029c = null;

    private a() {
    }

    static {
        f18027a = new a();
        String r0 = IAppContext.Companion.getPackageName();
        f18028b = r0;
        f18029c = ao.a(new d.m[]{s.a("navigate_tools", r0), s.a("open_app", r0), s.a("contact_update", r0), s.a("copy_text", r0), s.a("call_phone", r0), s.a("contact_add_with_empty_input", r0), s.a("add_todo_with_empty_input", r0), s.a("set_alarmclock", r0), s.a("read_text", r0), s.a("delete_alarmclock", r0), s.a("turnon_alarmclock", r0), s.a("turnoff_alarmclock", r0), s.a("contact_list", r0), s.a("contact_selector", r0), s.a("send_larkmsg", r0), s.a("share_doc", r0), s.a("contact_search", r0), s.a("send_wechatmsg", r0), s.a("switch_mode", r0), s.a("note_search_background", r0), s.a("open_link", r0), s.a("delete_timer", r0), s.a("note_merge", r0), s.a("note_delete", r0), s.a("address_phone_selector", r0), s.a("set_timer", r0), s.a("note_add", r0), s.a("note_append", r0), s.a(EventNames.SEND_SMS, r0), s.a("note_list", r0), s.a("note_add_with_empty_input", r0), s.a("contact_add", r0), s.a("delete_todo", r0), s.a("finish_todo", r0), s.a("add_todo", r0), s.a("list_todo", r0), s.a("update_todo", r0), s.a("search_todo", r0), s.a("delete_schedule", r0), s.a("update_schedule", r0), s.a("search_schedule", r0), s.a("add_schedule", r0), s.a("switch_timer", r0), s.a("search_alarmclock", r0), s.a("add_call_task", r0), s.a("amend_call_task", r0), s.a("find_call_task", r0), s.a("ClearApplicationStorage", r0), s.a("CloseApplication", r0), s.a("UninstallApplication", r0), s.a("QueryBatteryInfo", r0), s.a("ToggleApplicationNotification", r0), s.a("SwitchModeV2", r0), s.a("SetBrightness", r0), s.a("AdjustBrightness", r0), s.a("ShutdowPhone", r0), s.a("RebootPhoneboo", r0), s.a("AdjustVolume", r0), s.a("ScreenShot", r0), s.a("SetVolume", r0), s.a("WifiTether", r0), s.a("GetStorageInfo", r0), s.a("SwitchVoiceWakeup", "com.android.settings"), s.a("SwitchDoubleTapScreenWakeup", "com.android.settings"), s.a("SwitchFingerprintKeyWakeup", "com.android.settings"), s.a("SwitchSmartCallTakeover", "com.android.settings"), s.a("SwitchSmartSMSAssistant", "com.android.settings"), s.a("getGallerySearchText", "com.obric.gallery3d"), s.a("feed_the_chick", "com.example.myapplication")});
    }

    public final String a(String r2) {
        o.e(r2, "actionName");
        Map<String, String> r1 = f18029c;
        if (r1.containsKey(r2) == false) goto L6;
        String r3 = r1.get(r2);
        o.a(r3);
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    L6:
        return f18028b;
    }
}
