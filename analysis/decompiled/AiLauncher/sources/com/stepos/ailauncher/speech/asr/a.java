package com.stepos.ailauncher.speech.asr;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a#\u0010\u0006\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "", "text", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "priorFinal", "lateTail", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "speech_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final void a(StringBuilder builder, String text) {
        p.i(builder, "builder");
        p.i(text, "text");
        if (text.length() == 0) {
            return;
        }
        String string = builder.toString();
        p.h(string, "toString(...)");
        int iMin = Math.min(string.length(), text.length());
        loop0: while (true) {
            if (iMin <= 0) {
                iMin = 0;
                break;
            }
            int length = string.length() - iMin;
            for (int i10 = 0; i10 < iMin; i10++) {
                if (text.charAt(i10) != string.charAt(length + i10)) {
                    break;
                }
            }
            break loop0;
            iMin--;
        }
        builder.append((CharSequence) text, iMin, text.length());
    }

    public static final String b(String priorFinal, String lateTail) {
        p.i(priorFinal, "priorFinal");
        p.i(lateTail, "lateTail");
        if (lateTail.length() == 0) {
            return priorFinal;
        }
        StringBuilder sb2 = new StringBuilder(priorFinal);
        a(sb2, lateTail);
        String string = sb2.toString();
        p.h(string, "toString(...)");
        return p.d(string, priorFinal) ? priorFinal : string;
    }
}
