package aca;

import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.obric.assistant.settings.ToggleName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: aca.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0051a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2820a = null;

        static {
            int[] r100 = new int[ToggleName.values().length];
            r100[ToggleName.CONTACTS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L31:
            r100[ToggleName.CALL_LOGS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L47:
            r100[ToggleName.MESSAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[ToggleName.ALBUM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[ToggleName.NOTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L27:
            r100[ToggleName.CLOCK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L41:
            r100[ToggleName.GLOBAL_MEMORY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L43:
            r100[ToggleName.FILE_MANAGEMENT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[ToggleName.CALENDAR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[ToggleName.RECORD.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L29:
            r100[ToggleName.AI_DIARY.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L14:
            f2820a = r100;
        }
    }

    public static final String a(ToggleName r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        switch(C0051a.f2820a[r100.ordinal()]) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L11;
            case 10: goto L9;
            case 11: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L18:
        String r101 = tga.b.a();
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_notes_context, new Object[]{r101});
    L7:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_open_ai_diary_permission);
    L9:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_open_record_permission);
    L11:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_read_calendar_permission);
    L13:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_open_file_manage_permission);
    L15:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_memory_global_context);
    L17:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_clock_context);
    L21:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_album_context);
    L23:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_message_context);
    L25:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_call_context);
    L27:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_contacts_context);
    }

    public static final String b(ToggleName r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        switch(C0051a.f2820a[r100.ordinal()]) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L11;
            case 10: goto L9;
            case 11: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_ai_diary);
    L9:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_record);
    L11:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_calendar);
    L13:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_file_management);
    L15:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_memory_global);
    L17:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_clock);
    L19:
        return tga.b.a();
    L21:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_album);
    L23:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_message);
    L25:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_call);
    L27:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_contacts);
    }
}
