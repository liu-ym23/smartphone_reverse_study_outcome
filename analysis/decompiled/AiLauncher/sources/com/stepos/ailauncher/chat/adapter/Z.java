package com.stepos.ailauncher.chat.adapter;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import v9.C5680i;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u001a%\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "query", "", "color", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/CharSequence;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Z {
    public static final CharSequence b(String str, String str2, int i10) {
        List<C5680i> listA = M.a(str, str2);
        if (listA.isEmpty()) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        for (C5680i c5680i : listA) {
            spannableString.setSpan(new ForegroundColorSpan(i10), c5680i.getFirst(), c5680i.getLast() + 1, 33);
        }
        return spannableString;
    }
}
