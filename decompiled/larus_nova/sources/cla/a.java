package cla;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.nova.R;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.obric.miniapp.utils.e1;
import com.ss.android.lark.inv.export.router.InvRouter$InviteExternalPage$Param$From;
import com.ss.android.lark.inv.export.router.InvRouter$InviteMemberOrientationPage$Param$From;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24149a = null;

    static {
        f24149a = new a();
    }

    public a() {
    }

    public static Float b(Object r100) {
        if ((r100 instanceof Number) == false) goto L6;
        return Float.valueOf(((Number) r100).floatValue());
    L6:
        if ((r100 instanceof String) == true) goto L11;
        return null;
    L11:
        return StringsKt.toFloatOrNull(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.trim((String) r100).toString(), "dp"), CloudControlInf.SP), GXTemplateKey.GAIAX_PX));
    }

    public static String c(String r110) {
        Intrinsics.checkNotNullParameter(r110, "rawName");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.removePrefix(StringsKt.removePrefix(StringsKt.removePrefix(StringsKt.removePrefix(StringsKt.removePrefix(StringsKt.trim(r110).toString(), "builtin:"), "popover:"), "oui:"), "@drawable/"), "drawable/").toLowerCase(Locale.ROOT), "-", "_", false, 4, null), " ", "_", false, 4, null);
    }

    public static Integer d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rawName");
        String r101 = c(r100);
        switch(r101.hashCode()) {
            case -2079216026: goto L69;
            case -1867169789: goto L65;
            case -1573253640: goto L61;
            case -1419699188: goto L58;
            case -1367724422: goto L54;
            case -697920873: goto L51;
            case 3089282: goto L48;
            case 3322014: goto L45;
            case 93090825: goto L42;
            case 94627080: goto L39;
            case 94756344: goto L36;
            case 94935104: goto L33;
            case 445606381: goto L30;
            case 499742456: goto L27;
            case 696834840: goto L24;
            case 718796017: goto L21;
            case 742886971: goto L18;
            case 951117504: goto L15;
            case 1671672458: goto L12;
            case 1677581638: goto L9;
            case 1962919167: goto L6;
            default: goto L72;
        };
    L72:
        return null;
    L6:
        if (r101.equals("calendar_list") == false) goto L72;
    L75:
        return Integer.valueOf(R.drawable.o_ic_list);
    L9:
        if (r101.equals("schedule_list") == true) goto L75;
    L12:
        if (r101.equals("dismiss") == false) goto L72;
    L74:
        return Integer.valueOf(R.drawable.o_ic_titlebar_close);
    L15:
        if (r101.equals("confirm") == false) goto L72;
    L76:
        return Integer.valueOf(R.drawable.ic_confirm);
    L18:
        if (r101.equals("chevron") == false) goto L72;
    L77:
        return Integer.valueOf(R.drawable.o_ic_popmenu_arrow);
    L21:
        if (r101.equals("agenda_list") == true) goto L75;
    L24:
        if (r101.equals("chevron_right") == true) goto L77;
    L27:
        if (r101.equals("close_black") == true) goto L74;
    L30:
        if (r101.equals("disclosure") == true) goto L77;
    L33:
        if (r101.equals("cross") == true) goto L74;
    L36:
        if (r101.equals("close") == false) goto L72;
    L39:
        if (r101.equals("check") == true) goto L76;
    L42:
        if (r101.equals("arrow") == true) goto L77;
    L45:
        if (r101.equals("list") == true) goto L75;
    L48:
        if (r101.equals("done") == true) goto L76;
    L51:
        if (r101.equals(MonitorConstants.SCHEDULE) == true) goto L75;
    L54:
        if (r101.equals("cancel") == true) goto L74;
    L58:
        if (r101.equals("agenda") == true) goto L75;
    L61:
        if (r101.equals("view_list") == true) goto L75;
    L65:
        if (r101.equals("success") == true) goto L76;
    L69:
        if (r101.equals("arrow_right") == true) goto L77;
        goto L72
    }

    public static String e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rawName");
        String r101 = c(r100);
        switch(r101.hashCode()) {
            case -2024140158: goto L318;
            case -2017212418: goto L314;
            case -1824445809: goto L310;
            case -1573253640: goto L306;
            case -1558685317: goto L302;
            case -1503154213: goto L298;
            case -1502921481: goto L294;
            case -1437264628: goto L290;
            case -1419699188: goto L287;
            case -1354792126: goto L283;
            case -1352294148: goto L279;
            case -1335458389: goto L275;
            case -1314689291: goto L271;
            case -1291065759: goto L267;
            case -1217487446: goto L264;
            case -1206631530: goto L261;
            case -1068795718: goto L257;
            case -1028322118: goto L254;
            case -991851251: goto L251;
            case -934610812: goto L248;
            case -906336856: goto L245;
            case -838832707: goto L241;
            case -804429082: goto L238;
            case -732377866: goto L235;
            case -697920873: goto L232;
            case -624136624: goto L229;
            case -352329957: goto L225;
            case -338497235: goto L222;
            case -321005126: goto L219;
            case -238962746: goto L216;
            case -178324674: goto L213;
            case -88014641: goto L210;
            case 96417: goto L207;
            case 99228: goto L204;
            case 108835: goto L200;
            case 108960: goto L197;
            case 110873: goto L194;
            case 114009: goto L191;
            case 1618569: goto L188;
            case 3045982: goto L185;
            case 3059573: goto L181;
            case 3076014: goto L178;
            case 3108362: goto L175;
            case 3168655: goto L172;
            case 3202370: goto L169;
            case 3237038: goto L165;
            case 3322014: goto L162;
            case 3357525: goto L158;
            case 3444122: goto L155;
            case 3704893: goto L151;
            case 41204738: goto L148;
            case 50359046: goto L145;
            case 69208186: goto L142;
            case 92611469: goto L139;
            case 104080000: goto L135;
            case 106642798: goto L132;
            case 108704329: goto L129;
            case 110621496: goto L126;
            case 184994700: goto L123;
            case 185934015: goto L120;
            case 188702929: goto L117;
            case 485975746: goto L114;
            case 535225839: goto L111;
            case 566447392: goto L108;
            case 678990007: goto L105;
            case 718796017: goto L102;
            case 722049599: goto L99;
            case 728504064: goto L96;
            case 842074177: goto L93;
            case 912514171: goto L90;
            case 931310141: goto L87;
            case 954891333: goto L84;
            case 988711087: goto L81;
            case 1201687819: goto L78;
            case 1247787042: goto L75;
            case 1250407999: goto L72;
            case 1265807887: goto L69;
            case 1277802073: goto L66;
            case 1285169560: goto L63;
            case 1301496073: goto L60;
            case 1434631203: goto L57;
            case 1505434244: goto L54;
            case 1505669047: goto L51;
            case 1557721666: goto L48;
            case 1645600483: goto L45;
            case 1677581638: goto L42;
            case 1798276132: goto L39;
            case 1802489424: goto L36;
            case 1862666772: goto L33;
            case 1888598416: goto L30;
            case 1961215722: goto L27;
            case 1962919167: goto L24;
            case 1963302046: goto L21;
            case 1968600364: goto L18;
            case 1985941072: goto L15;
            case 1989861112: goto L12;
            case 2006930817: goto L9;
            case 2102494577: goto L6;
            default: goto L321;
        };
    L321:
        return null;
    L6:
        if (r101.equals(MusicAppletPage.ROUTE_MODE_NAVIGATION) == false) goto L321;
    L202:
        return "popover/navigation.svg";
    L9:
        if (r101.equals("info_circle") == false) goto L321;
    L167:
        return "popover/about.svg";
    L12:
        if (r101.equals("preferences") == false) goto L321;
    L285:
        return "popover/settings.svg";
    L15:
        if (r101.equals("setting") == true) goto L285;
    L18:
        if (r101.equals("information") == true) goto L167;
    L21:
        if (r101.equals("calendar_year") == false) goto L321;
    L153:
        return "popover/calendar_year.svg";
    L24:
        if (r101.equals("calendar_list") == false) goto L321;
    L308:
        return "popover/agenda_list.svg";
    L27:
        if (r101.equals("calendar_3day") == false) goto L321;
    L304:
        return "popover/calendar_3day.svg";
    L30:
        if (r101.equals("arrow_up_down") == false) goto L321;
    L243:
        return "popover/chevrons_vertical.svg";
    L33:
        if (r101.equals(NotificationCompat.CATEGORY_NAVIGATION) == true) goto L202;
    L36:
        if (r101.equals("oic_plus") == false) goto L321;
    L281:
        return "popover/plus.svg";
    L39:
        if (r101.equals("all_todo") == false) goto L321;
    L296:
        return "popover/all_todos.svg";
    L42:
        if (r101.equals("schedule_list") == true) goto L308;
    L45:
        if (r101.equals("done_todo") == false) goto L321;
    L300:
        return "popover/complete_todo.svg";
    L48:
        if (r101.equals("details") == true) goto L167;
    L51:
        if (r101.equals(ShareChannel.COPY_TEXT) == false) goto L321;
    L183:
        return "popover/copy.svg";
    L54:
        if (r101.equals("copy_link") == true) goto L183;
    L57:
        if (r101.equals("settings") == true) goto L285;
    L60:
        if (r101.equals("magnifier_search") == false) goto L321;
    L316:
        return "popover/search.svg";
    L63:
        if (r101.equals("trashcan") == false) goto L321;
    L277:
        return "popover/delete.svg";
    L66:
        if (r101.equals("contact_plus") == false) goto L321;
    L320:
        return "popover/add_contact.svg";
    L69:
        if (r101.equals("make_call") == false) goto L321;
    L312:
        return "popover/call.svg";
    L72:
        if (r101.equals("date_picker") == false) goto L321;
    L292:
        return "popover/pick_date.svg";
    L75:
        if (r101.equals(EventNames.SEND_SMS) == false) goto L321;
    L273:
        return "popover/send_sms.svg";
    L78:
        if (r101.equals("duplicate") == true) goto L183;
    L81:
        if (r101.equals("calendar_picker") == true) goto L292;
    L84:
        if (r101.equals("ellipsis_3") == false) goto L321;
    L160:
        return "popover/ellipsis_3.svg";
    L87:
        if (r101.equals("chevrons_vertical") == true) goto L243;
    L90:
        if (r101.equals("oic_ellipsis_3") == true) goto L160;
    L93:
        if (r101.equals("vertical_chevrons") == true) goto L243;
    L96:
        if (r101.equals("calendar_today") == false) goto L321;
    L227:
        return "popover/calendar_day.svg";
    L99:
        if (r101.equals("calendar_month") == false) goto L321;
    L137:
        return "popover/calendar_month.svg";
    L102:
        if (r101.equals("agenda_list") == true) goto L308;
    L105:
        if (r101.equals("person_add") == true) goto L320;
    L108:
        if (r101.equals("more_vertical") == true) goto L160;
    L111:
        if (r101.equals("eye_slash") == false) goto L321;
    L269:
        return "popover/visibility_off.svg";
    L114:
        if (r101.equals("visibility_off") == true) goto L269;
    L117:
        if (r101.equals("ellipsis") == true) goto L160;
    L120:
        if (r101.equals("oic_magnifier_search") == true) goto L316;
    L123:
        if (r101.equals("complete_todo") == true) goto L300;
    L126:
        if (r101.equals("trash") == true) goto L277;
    L129:
        if (r101.equals(CloudControlInf.ROUTE) == true) goto L202;
    L132:
        if (r101.equals("phone") == true) goto L312;
    L135:
        if (r101.equals(BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH) == true) goto L137;
    L139:
        if (r101.equals("about") == true) goto L167;
    L142:
        if (r101.equals("checkmark_circle") == true) goto L300;
    L145:
        if (r101.equals("leading") == true) goto L160;
    L148:
        if (r101.equals(InvRouter$InviteMemberOrientationPage$Param$From.CONTACT_ADD) == true) goto L320;
    L151:
        if (r101.equals(BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR) == true) goto L153;
    L155:
        if (r101.equals("plus") == true) goto L281;
    L158:
        if (r101.equals("more") == true) goto L160;
    L162:
        if (r101.equals("list") == true) goto L308;
    L165:
        if (r101.equals("info") == true) goto L167;
    L169:
        if (r101.equals("hide") == true) goto L269;
    L172:
        if (r101.equals("gear") == true) goto L285;
    L175:
        if (r101.equals("edit") == false) goto L321;
    L259:
        return "popover/edit.svg";
    L178:
        if (r101.equals("date") == true) goto L292;
    L181:
        if (r101.equals("copy") == true) goto L183;
    L185:
        if (r101.equals(NotificationCompat.CATEGORY_CALL) == true) goto L312;
    L188:
        if (r101.equals("3day") == true) goto L304;
    L191:
        if (r101.equals("sms") == true) goto L273;
    L194:
        if (r101.equals("pen") == true) goto L259;
    L197:
        if (r101.equals("new") == true) goto L281;
    L200:
        if (r101.equals("nav") == true) goto L202;
    L204:
        if (r101.equals(BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY) == true) goto L227;
    L207:
        if (r101.equals("add") == true) goto L281;
    L210:
        if (r101.equals("all_todos") == true) goto L296;
    L213:
        if (r101.equals("calendar") == true) goto L292;
    L216:
        if (r101.equals("up_down") == true) goto L243;
    L219:
        if (r101.equals("calendar_three_day") == true) goto L304;
    L222:
        if (r101.equals("show_off") == true) goto L269;
    L225:
        if (r101.equals("calendar_day") == true) goto L227;
    L229:
        if (r101.equals("send_message") == true) goto L273;
    L232:
        if (r101.equals(MonitorConstants.SCHEDULE) == true) goto L308;
    L235:
        if (r101.equals("article") == true) goto L296;
    L238:
        if (r101.equals("configure") == true) goto L285;
    L241:
        if (r101.equals("updown") == true) goto L243;
    L245:
        if (r101.equals("search") == true) goto L316;
    L248:
        if (r101.equals("remove") == true) goto L277;
    L251:
        if (r101.equals("pencil") == true) goto L259;
    L254:
        if (r101.equals("add_to_contact") == true) goto L320;
    L257:
        if (r101.equals(PriorityModule.OPERATOR_MODIFY) == true) goto L259;
    L261:
        if (r101.equals("multi_day") == true) goto L304;
    L264:
        if (r101.equals("hidden") == true) goto L269;
    L267:
        if (r101.equals("eye_off") == true) goto L269;
    L271:
        if (r101.equals("text_message") == true) goto L273;
    L275:
        if (r101.equals("delete") == true) goto L277;
    L279:
        if (r101.equals("create") == true) goto L281;
    L283:
        if (r101.equals("config") == true) goto L285;
    L287:
        if (r101.equals("agenda") == true) goto L308;
    L290:
        if (r101.equals("pick_date") == true) goto L292;
    L294:
        if (r101.equals("todo_list") == true) goto L296;
    L298:
        if (r101.equals("todo_done") == true) goto L300;
    L302:
        if (r101.equals("three_day") == true) goto L304;
    L306:
        if (r101.equals("view_list") == true) goto L308;
    L310:
        if (r101.equals("phone_call") == true) goto L312;
    L314:
        if (r101.equals("magnifier") == true) goto L316;
    L318:
        if (r101.equals(InvRouter$InviteExternalPage$Param$From.ADD_CONTACT) == true) goto L320;
        goto L320
    }

    public static int a(Context r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r102 = r100.getResources();
        return (int) (r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density);
    }

    public static Drawable f(Context r100, String r101) {
        boolean r102 = true;
        String r103 = StringsKt.trimStart(StringsKt.trim(r101).toString(), new char[]{65279});
        Object r104 = null;
        if (StringsKt.isBlank(r103) == false) goto L5;
        return null;
    L5:
        e1.f398472a.getClass();
        Drawable r105 = e1.b(r100, r103);
        if (r105 == null) goto L9;
        return r105;
    L9:
        if (StringsKt.endsWith(r103, ".svg", true) == false) goto L13;
        Drawable r106 = e1.a(r100, r103);
        if (r106 == null) goto L13;
        return r106;
    L13:
        String r107 = e(r103);
        if (r107 == null) goto L18;
        Drawable r108 = e1.a(r100, r107);
        if (r108 == null) goto L18;
        return r108;
    L18:
        Integer r109 = d(r103);
        if (r109 == null) goto L31;
        int r110 = r109.intValue();
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L23
        Object r112 = Result.m9449constructorimpl(ContextCompat.getDrawable(r100, r110));     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r112) == true) goto L30;
        r104 = r112;
    L30:
        return (Drawable) r104;
    L23:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L31:
        String r114 = StringsKt.removePrefix(StringsKt.removePrefix(r103, "@drawable/"), "drawable/");
        Integer r115 = Integer.valueOf(r100.getResources().getIdentifier(r114, "drawable", r100.getPackageName()));
        if (r115.intValue() == 0) goto L34;
        boolean r116 = true;
    L35:
        if (r116 == true) goto L38;
        r115 = null;
    L38:
        if (r115 == null) goto L67;
    L55:
        if (r115 == null) goto L73;
        int r117 = r115.intValue();
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L59
        Object r119 = Result.m9449constructorimpl(ContextCompat.getDrawable(r100, r117));     // Catch: Throwable -> L59
    L62:
        if (Result.m9455isFailureimpl(r119) == true) goto L66;
        r104 = r119;
    L66:
        return (Drawable) r104;
    L59:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L62
    L73:
        return null;
    L67:
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L41
        Object r122 = Result.m9449constructorimpl(Integer.valueOf(com.obric.common.oui.R.drawable.class.getField(r114).getInt(null)));     // Catch: Throwable -> L41
    L44:
        if (Result.m9455isFailureimpl(r122) == false) goto L46;
        r122 = null;
    L46:
        r115 = (Integer) r122;
        if (r115 != null) goto L49;
    L54:
        r115 = null;
        goto L55
    L49:
        if (r115.intValue() != 0) goto L52;
        r102 = false;
    L52:
        if (r102 == false) goto L54;
    L41:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L44
    L34:
        r116 = false;
        goto L35
    }
}
