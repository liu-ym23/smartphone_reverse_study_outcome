package com.stepos.stepclaw.gateway;

import c5.m;
import com.stepos.stepclaw.SecurePrefs;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/gateway/BonjourEscapes;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "decode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "input", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BonjourEscapes {
    public static final BonjourEscapes INSTANCE = new BonjourEscapes();

    private BonjourEscapes() {
    }

    public final String decode(String input) {
        int i8;
        p.e(input, "input");
        if (input.length() == 0) {
            return input;
        }
        ArrayList arrayList = new ArrayList();
        int iCharCount = 0;
        while (iCharCount < input.length()) {
            if (input.charAt(iCharCount) == '\\' && (i8 = iCharCount + 3) < input.length()) {
                char cCharAt = input.charAt(iCharCount + 1);
                char cCharAt2 = input.charAt(iCharCount + 2);
                char cCharAt3 = input.charAt(i8);
                if (Character.isDigit(cCharAt) && Character.isDigit(cCharAt2) && Character.isDigit(cCharAt3)) {
                    int i9 = (cCharAt3 - '0') + ((cCharAt2 - '0') * 10) + ((cCharAt - '0') * 100);
                    if (i9 >= 0 && i9 < 256) {
                        arrayList.add(Byte.valueOf((byte) i9));
                        iCharCount += 4;
                    }
                }
            }
            int iCodePointAt = Character.codePointAt(input, iCharCount);
            char[] chars = Character.toChars(iCodePointAt);
            p.d(chars, "toChars(...)");
            byte[] bytes = new String(chars).getBytes(x5.a.f6276a);
            p.d(bytes, "getBytes(...)");
            for (byte b9 : bytes) {
                arrayList.add(Byte.valueOf(b9));
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return new String(m.L0(arrayList), x5.a.f6276a);
    }
}
