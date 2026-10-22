package d5;

import La.H;
import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$color;
import java.lang.Character;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Ld5/m;", "", "<init>", "()V", "", "displayName", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "slug", "", "paletteSize", "e", "(Ljava/lang/String;I)I", "", "PALETTE_BG_RES_IDS", "[I", Const.INTENT_KEY_PKGNAME, "()[I", "PALETTE_FG_RES_IDS", "c", Const.INTENT_KEY_UMID, "()I", "PALETTE_SIZE", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class m {
    public static final m INSTANCE = new m();
    private static final int[] PALETTE_BG_RES_IDS = {R$color.skill_icon_palette_01_bg, R$color.skill_icon_palette_02_bg, R$color.skill_icon_palette_03_bg, R$color.skill_icon_palette_04_bg, R$color.skill_icon_palette_05_bg, R$color.skill_icon_palette_06_bg, R$color.skill_icon_palette_07_bg};
    private static final int[] PALETTE_FG_RES_IDS = {R$color.skill_icon_palette_01_fg, R$color.skill_icon_palette_02_fg, R$color.skill_icon_palette_03_fg, R$color.skill_icon_palette_04_fg, R$color.skill_icon_palette_05_fg, R$color.skill_icon_palette_06_fg, R$color.skill_icon_palette_07_fg};

    public final String a(String displayName) {
        int i10;
        String string = displayName != null ? H.D1(displayName).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            return Const.STR_MART_WELL;
        }
        int length = string.length();
        while (i10 < length) {
            char cCharAt = string.charAt(i10);
            if ('0' <= cCharAt && cCharAt < ':') {
                return String.valueOf(cCharAt);
            }
            if (('A' > cCharAt || cCharAt >= '[') && ('a' > cCharAt || cCharAt >= '{')) {
                i10 = (Y.j(Character.UnicodeScript.HAN, Character.UnicodeScript.HIRAGANA, Character.UnicodeScript.KATAKANA, Character.UnicodeScript.HANGUL).contains(Character.UnicodeScript.of(cCharAt)) || Character.isSupplementaryCodePoint(cCharAt)) ? 0 : i10 + 1;
                return String.valueOf(cCharAt);
            }
            String strValueOf = String.valueOf(cCharAt);
            p.g(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            p.h(upperCase, "toUpperCase(...)");
            return upperCase;
        }
        return Const.STR_MART_WELL;
    }

    public final int[] b() {
        return PALETTE_BG_RES_IDS;
    }

    public final int[] c() {
        return PALETTE_FG_RES_IDS;
    }

    public final int d() {
        return PALETTE_BG_RES_IDS.length;
    }

    public final int e(String slug, int paletteSize) {
        if (slug == null || slug.length() == 0 || paletteSize <= 0) {
            return 0;
        }
        int iCharAt = 0;
        for (int i10 = 0; i10 < slug.length(); i10++) {
            iCharAt = (iCharAt * 31) + slug.charAt(i10);
        }
        return (Integer.MAX_VALUE & iCharAt) % paletteSize;
    }
}
