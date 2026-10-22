package av8;

import android.text.TextUtils;
import com.larus.bmhome.auth.BgImageAbParam;
import com.larus.bmhome.auth.BgImageConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {
    public static final int a(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "sequence");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return 0;
    L5:
        int r101 = 0;
        int r102 = 0;
    L7:
        if (r101 >= r100.length()) goto L28;
        Character.UnicodeBlock r103 = Character.UnicodeBlock.of(r100.charAt(r101));
        if (Intrinsics.areEqual(r103, Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) == false) goto L11;
    L24:
        boolean r104 = true;
    L25:
        if (r104 == false) goto L27;
        r102 = r102 + 1;
    L27:
        r101 = r101 + 1;
        goto L7
    L11:
        if (Intrinsics.areEqual(r103, Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) == true) goto L24;
        if (Intrinsics.areEqual(r103, Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) == true) goto L24;
        if (Intrinsics.areEqual(r103, Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) == true) goto L24;
        if (Intrinsics.areEqual(r103, Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) == true) goto L24;
        if (Intrinsics.areEqual(r103, Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) == true) goto L24;
        if (Intrinsics.areEqual(r103, Character.UnicodeBlock.GENERAL_PUNCTUATION) == true) goto L24;
        r104 = false;
        goto L25
    L28:
        return r102;
    }

    public static final boolean b(Boolean r100, Boolean r101) {
        LaunchInfo r102 = AuthModelDelegate.f297134b.x().getValue();
        if (r102 == null) goto L9;
        BgImageConfig r103 = r102.h();
        if (r103 == null) goto L9;
        BgImageAbParam r104 = r103.a();
        if (r104 == null) goto L9;
        Integer r105 = r104.a();
    L10:
        if (r105 != null) goto L13;
    L15:
        if (r105 != null) goto L18;
    L20:
        if (r105 == null) goto L23;
        r105.intValue();
    L23:
        return false;
    L18:
        if (r105.intValue() != 2) goto L20;
    L13:
        if (r105.intValue() != 1) goto L15;
        return true;
    L9:
        r105 = null;
        goto L10
    }
}
