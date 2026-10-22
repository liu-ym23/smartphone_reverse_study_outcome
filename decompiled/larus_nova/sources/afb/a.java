package afb;

import com.larus.nova.R;
import com.ss.android.lark.feed.app.entity.IBadgeable;
import com.ss.android.lark.feed.shared.fg.c;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<tdb.a> f3240a = null;

    static {
        f3240a = new ThreadLocal();
    }

    public static tdb.a a(IBadgeable r110, boolean r111) {
        boolean r100 = b.f3241a;
        ThreadLocal<tdb.a> r101 = f3240a;
        tdb.a r102 = r101.get();
        if (r102 != null) goto L5;
        r102 = new tdb.a();
        r101.set(r102);
    L5:
        int r103 = 0;
        r102.f545537b = 0;
        r102.f545536a = 0;
        r102.f545538c = 8;
        r102.f545539d = null;
        if (r110.getBadgeCount() != 0) goto L8;
        r102.f545538c = 8;
    L68:
        return r102;
    L8:
        r102.f545538c = 0;
        boolean r104 = r110.isRemind();
        boolean r105 = r110.isRedBadge();
        int r106 = Math.abs(r110.getBadgeCount());
        if (c.f421187a.isEnable("lark.im.group_auto_mute_gray_config") == false) goto L15;
        if (r105 == false) goto L13;
        if (r104 == false) goto L13;
        r104 = true;
    L13:
        r104 = false;
    L15:
        if (r104 == true) goto L20;
        if (r111 == true) goto L18;
        if (r100 == false) goto L18;
    L19:
        int r107 = 0;
    L26:
        if (r111 == false) goto L29;
        if (r104 == false) goto L33;
        r103 = 1;
    L33:
        int r108 = (r107 + (r103 * 10)) + 100;
        String r112 = String.valueOf(Math.abs(r110.getBadgeCount()));
        if (r108 != 0) goto L36;
        r102.f545536a = R.drawable.badge_gray_bg_no_count_stroke;
        goto L68
    L36:
        if (r108 == 1) goto L66;
        if (r108 == 2) goto L65;
        if (r108 != 3) goto L40;
        r102.f545536a = R.drawable.badge_gray_bg_etc_count_stroke;
        goto L68
    L40:
        switch(r108) {
            case 11: goto L48;
            case 12: goto L47;
            case 13: goto L46;
            default: goto L41;
        };
    L41:
        switch(r108) {
            case 20: goto L52;
            case 21: goto L51;
            case 22: goto L50;
            case 23: goto L49;
            default: goto L42;
        };
    L42:
        switch(r108) {
            case 100: goto L56;
            case 101: goto L55;
            case 102: goto L54;
            case 103: goto L53;
            default: goto L43;
        };
    L43:
        switch(r108) {
            case 111: goto L59;
            case 112: goto L58;
            case 113: goto L57;
            default: goto L44;
        };
    L44:
        switch(r108) {
            case 120: goto L63;
            case 121: goto L62;
            case 122: goto L61;
            case 123: goto L60;
            default: goto L68;
        };
    L60:
        r102.f545536a = R.drawable.badge_orange_bg_etc_count;
        goto L68
    L61:
        r102.f545539d = r112;
        r102.f545536a = R.drawable.badge_orange_multi_count_bg_no_stroke;
        r102.f545537b = -1;
        goto L68
    L62:
        r102.f545539d = r112;
        r102.f545536a = R.drawable.badge_orange_single_count_bg_no_stroke;
        r102.f545537b = -1;
        goto L68
    L63:
        r102.f545536a = R.drawable.badge_orange_bg_no_count_no_stroke;
        goto L68
    L57:
        r102.f545536a = R.drawable.badge_pink_bg_etc_count;
        goto L68
    L58:
        r102.f545539d = r112;
        r102.f545536a = R.drawable.badge_pink_multi_count_bg_no_stroke;
        r102.f545537b = UIHelper.getColor(R.color.lkui_R500);
        goto L68
    L59:
        r102.f545539d = r112;
        r102.f545536a = R.drawable.badge_pink_single_count_bg_no_stroke;
        r102.f545537b = UIHelper.getColor(R.color.lkui_R500);
        goto L68
    L53:
        r102.f545536a = R.drawable.badge_gray_bg_etc_count;
        goto L68
    L54:
        r102.f545539d = r112;
        r102.f545536a = R.drawable.badge_gray_multi_count_bg_no_stroke;
        r102.f545537b = -1;
        goto L68
    L55:
        r102.f545539d = r112;
        r102.f545536a = R.drawable.badge_gray_single_count_bg_no_stroke;
        r102.f545537b = -1;
        goto L68
    L56:
        r102.f545536a = R.drawable.badge_gray_bg_no_count_no_stroke;
        goto L68
    L49:
        r102.f545536a = R.drawable.badge_orange_bg_etc_count_stroke;
        goto L68
    L50:
        r102.f545539d = r112;
        r102.f545536a = R.drawable.badge_orange_multi_count_bg_stroke;
        r102.f545537b = -1;
        goto L68
    L51:
        r102.f545539d = r112;
        r102.f545536a = R.drawable.badge_orange_single_count_bg_stroke;
        r102.f545537b = -1;
        goto L68
    L52:
        r102.f545536a = R.drawable.badge_orange_bg_no_count_stroke;
        goto L68
    L46:
        r102.f545536a = R.drawable.badge_pink_bg_etc_count_stroke;
        goto L68
    L47:
        r102.f545539d = r112;
        r102.f545536a = R.drawable.badge_pink_multi_count_bg_stroke;
        r102.f545537b = UIHelper.getColor(R.color.lkui_R500);
        goto L68
    L48:
        r102.f545539d = r112;
        r102.f545536a = R.drawable.badge_pink_single_count_bg_stroke;
        r102.f545537b = UIHelper.getColor(R.color.lkui_R500);
        goto L68
    L65:
        r102.f545539d = r112;
        r102.f545536a = R.drawable.badge_gray_multi_count_bg_stroke;
        r102.f545537b = -1;
        goto L68
    L66:
        r102.f545539d = r112;
        r102.f545536a = R.drawable.badge_gray_single_count_bg_stroke;
        r102.f545537b = -1;
        goto L68
    L29:
        if (r104 == true) goto L32;
        if (r100 == false) goto L33;
    L32:
        r103 = 2;
    L18:
        if (r111 == true) goto L19;
    L20:
        if (r106 >= 10) goto L23;
        r107 = 1;
        goto L26
    L23:
        if (r106 >= 1000) goto L25;
        r107 = 2;
        goto L26
    L25:
        r107 = 3;
        goto L26
    }
}
