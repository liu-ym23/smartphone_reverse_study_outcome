package g9;

import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public static final List f4610a;

    /* renamed from: b, reason: collision with root package name */
    public static final List f4611b;

    /* renamed from: c, reason: collision with root package name */
    public static final List f4612c;

    /* renamed from: d, reason: collision with root package name */
    public static final jb.k f4613d;

    /* renamed from: e, reason: collision with root package name */
    public static final jb.k f4614e;

    static {
        z0 z0Var = z0.f4660c;
        z0 z0Var2 = z0.f4662g;
        List listF = ac.a.F(z0Var, z0Var2);
        f4610a = listF;
        z0 z0Var3 = z0.f4661f;
        List listF2 = ac.a.F(z0Var, z0Var3, z0Var2);
        f4611b = listF2;
        s0 s0Var = s0.f4608f;
        w0 w0VarA = a("system_device_control", "system.settings", R.string.perm_row_system_device_control, R.string.perm_desc_system_device_control, R.mipmap.ic_perm_system_device_control, s0Var, listF2, z0Var3, true);
        s0 s0Var2 = s0.f4607c;
        List listF3 = ac.a.F(w0VarA, a("ai_tone_personalization", "assistant.voice", R.string.perm_row_ai_tone_personalization, R.string.perm_desc_ai_tone_personalization, R.mipmap.ic_perm_ai_tone_personalization, s0Var2, listF, z0Var, true), a("screen_understanding_capture", "screen.understanding", R.string.perm_row_screen_understanding_capture, R.string.perm_desc_screen_understanding_capture, R.mipmap.ic_perm_screen_understanding_capture, s0Var2, listF, z0Var2, true), a("location_access", "location", R.string.perm_row_location_access, R.string.perm_desc_location_access, R.mipmap.ic_perm_location_access, s0Var2, listF, z0Var2, true));
        l1 l1Var = new l1();
        l1Var.f4523a = R.string.perm_section_system_control;
        l1Var.f4524b = listF3;
        VarHandle.storeStoreFence();
        List listF4 = ac.a.F(a("contacts_access", "contact", R.string.perm_row_contacts_access, R.string.perm_desc_contacts_access, R.mipmap.ic_perm_contacts_access, s0Var2, listF, z0Var, true), a("calls_records", "phone.calllog", R.string.perm_row_calls_records, R.string.perm_desc_calls_records, R.mipmap.ic_perm_calls_records, s0Var, listF2, z0Var3, true), a("messages_notifications", "message.notification", R.string.perm_row_messages_notifications, R.string.perm_desc_messages_notifications, R.mipmap.ic_perm_messages_notifications, s0Var, listF2, z0Var3, true));
        l1 l1Var2 = new l1();
        l1Var2.f4523a = R.string.perm_section_communication;
        l1Var2.f4524b = listF4;
        VarHandle.storeStoreFence();
        List listF5 = ac.a.F(a("calendar_todos", "calendar.todo", R.string.perm_row_calendar_todos, R.string.perm_desc_calendar_todos, R.mipmap.ic_perm_calendar_todos, s0Var2, listF, z0Var, true), a("gallery_media", "media.gallery", R.string.perm_row_gallery_media, R.string.perm_desc_gallery_media, R.mipmap.ic_perm_gallery_media, s0Var, listF2, z0Var3, true), a("recording_voice_recognition", "audio", R.string.perm_row_recording_voice_recognition, R.string.perm_desc_recording_voice_recognition, R.mipmap.ic_perm_recording_voice_recognition, s0Var, listF2, z0Var3, true), a("notes_documents", "note.document", R.string.perm_row_notes_documents, R.string.perm_desc_notes_documents, R.mipmap.ic_perm_notes_documents, s0Var2, listF, z0Var, true), a("files_workspace", "file.workspace", R.string.perm_row_files_workspace, R.string.perm_desc_files_workspace, R.mipmap.ic_perm_files_workspace, s0Var, listF2, z0Var3, true), a("read_clipboard", "app.clipboard", R.string.perm_row_read_clipboard, R.string.perm_desc_read_clipboard, R.mipmap.ic_perm_read_clipboard, s0Var, listF2, z0Var3, true), a("app_management", "app.manage", R.string.perm_row_app_management, R.string.perm_desc_app_management, R.mipmap.ic_perm_app_management, s0Var, listF2, z0Var3, false), a("third_party_service_info", "thirdparty.service", R.string.perm_row_third_party_service_info, R.string.perm_desc_third_party_service_info, R.mipmap.ic_perm_third_party_service_info, s0Var2, listF, z0Var, false), a("third_party_service_orders", "thirdparty.order", R.string.perm_row_third_party_service_orders, R.string.perm_desc_third_party_service_orders, R.mipmap.ic_perm_third_party_service_orders, s0Var, listF2, z0Var3, false));
        l1 l1Var3 = new l1();
        l1Var3.f4523a = R.string.perm_section_personal_data;
        l1Var3.f4524b = listF5;
        VarHandle.storeStoreFence();
        List listF6 = ac.a.F(a("network_search", "network.web", R.string.perm_row_network_search, R.string.perm_desc_network_search, R.mipmap.ic_perm_network_search, s0Var, listF2, z0Var3, true), a("automation_scheduled", "automation.schedule", R.string.perm_row_automation_scheduled, R.string.perm_desc_automation_scheduled, R.mipmap.ic_perm_automation_scheduled, s0Var2, listF, z0Var, true), a("agents_collaboration", "agent.session", R.string.perm_row_agents_collaboration, R.string.perm_desc_agents_collaboration, R.mipmap.ic_perm_agents_collaboration, s0Var2, listF, z0Var, true), a("shell_execution", "sandbox.shell", R.string.perm_row_shell_execution, R.string.perm_desc_shell_execution, R.mipmap.ic_perm_shell_execution, s0Var, listF2, z0Var3, true), a("cross_device_control", "device.remote", R.string.perm_row_cross_device_control, R.string.perm_desc_cross_device_control, R.mipmap.ic_perm_cross_device_control, s0Var2, listF, z0Var2, true), a("system_gateway_management", "gateway.admin", R.string.perm_row_system_gateway_management, R.string.perm_desc_system_gateway_management, R.mipmap.ic_perm_system_gateway_management, s0Var, listF2, z0Var3, true));
        l1 l1Var4 = new l1();
        l1Var4.f4523a = R.string.perm_section_network_automation;
        l1Var4.f4524b = listF6;
        VarHandle.storeStoreFence();
        f4612c = ac.a.F(l1Var, l1Var2, l1Var3, l1Var4);
        f4613d = new jb.k(new androidx.room.c(7));
        f4614e = new jb.k(new androidx.room.c(8));
    }

    public static w0 a(String str, String str2, int i, int i3, int i10, s0 s0Var, List list, z0 z0Var, boolean z10) {
        w0 w0Var = new w0();
        w0Var.f4637a = str;
        w0Var.f4638b = str2;
        w0Var.f4639c = i;
        w0Var.f4640d = i3;
        w0Var.f4641e = i10;
        w0Var.f4642f = s0Var;
        w0Var.f4643g = list;
        w0Var.f4644h = z0Var;
        w0Var.i = z10;
        VarHandle.storeStoreFence();
        return w0Var;
    }
}
