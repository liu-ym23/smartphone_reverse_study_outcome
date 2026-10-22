package com.stepos.agentframework.chatui.util;

import La.D;
import La.H;
import La.K;
import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\u00020\f*\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\f*\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0013\u0010\u0010\u001a\u00020\u0004*\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/chatui/util/e;", "", "<init>", "()V", "", "text", "e", "(Ljava/lang/String;)Ljava/lang/String;", "", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/CharSequence;)I", "", "c", "(Ljava/lang/CharSequence;)Z", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "Lkotlin/text/Regex;", "SEPARATOR_LINE", "Lkotlin/text/Regex;", "TABLE_PIPE_THRESHOLD", "I", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class e {
    public static final e INSTANCE = new e();
    private static final Regex SEPARATOR_LINE = new Regex("^[\\s|｜:\\-+]+$");
    private static final int TABLE_PIPE_THRESHOLD = 2;

    public final boolean a(CharSequence charSequence) {
        return H.k0(charSequence, "|", false, 2, null) || H.k0(charSequence, "｜", false, 2, null);
    }

    public final int b(CharSequence charSequence) {
        int i10 = 0;
        for (int i11 = 0; i11 < charSequence.length(); i11++) {
            char cCharAt = charSequence.charAt(i11);
            if (cCharAt == '|' || cCharAt == 65372) {
                i10++;
            }
        }
        return i10;
    }

    public final boolean c(CharSequence charSequence) {
        return H.j1(charSequence, "|", false, 2, null) || H.j1(charSequence, "｜", false, 2, null);
    }

    public final String d(String str) {
        return D.T(D.T(str, "|", "", false, 4, null), "｜", "", false, 4, null);
    }

    public final String e(String text) {
        String string;
        kotlin.jvm.internal.p.i(text, "text");
        if (text.length() == 0) {
            return text;
        }
        StringBuilder sb2 = new StringBuilder();
        List<String> listF0 = H.F0(text);
        int i10 = 0;
        for (Object obj : listF0) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            String str = (String) obj;
            String string2 = H.D1(str).toString();
            e eVar = INSTANCE;
            int iB = eVar.b(string2);
            if (!eVar.c(string2)) {
                Regex regex = SEPARATOR_LINE;
                if (!regex.k(string2) && iB < 2 && (iB < 1 || !eVar.a(string2))) {
                    String str2 = (String) F.t0(listF0, i11);
                    boolean z10 = str2 != null && (string = H.D1(str2).toString()) != null && string.length() > 0 && regex.k(string);
                    if (iB != 1 || !z10) {
                        sb2.append(eVar.d(str));
                        sb2.append('\n');
                    }
                }
            }
            i10 = i11;
        }
        String string3 = sb2.toString();
        kotlin.jvm.internal.p.h(string3, "toString(...)");
        String strG1 = H.G1(string3, ' ', '\t', '\n', '\r');
        if (strG1.length() == 0) {
            return "";
        }
        if (K.P1(text) != '\n' && K.P1(text) != '\r') {
            return strG1;
        }
        return strG1 + "\n";
    }
}
