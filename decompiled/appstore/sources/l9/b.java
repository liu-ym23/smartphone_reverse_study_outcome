package l9;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Joiner f21925a = null;

    static {
        f21925a = Joiner.on("");
    }

    public static int a(List r10, CharSequence r11, int r12, ImmutableMap.Builder r13) {
        int r14 = r11.length();
        int r15 = r12;
        char r16 = 0;
    L4:
        if (r15 >= r14) goto L13;
        r16 = r11.charAt(r15);
        if (r16 == '&') goto L13;
        if (r16 == '?') goto L13;
        if (r16 == '!') goto L13;
        if (r16 == ':') goto L13;
        if (r16 == ',') goto L13;
        r15 = r15 + 1;
    L13:
        r10.add(0, c(r11.subSequence(r12, r15)));
        if (r16 == '!') goto L18;
        if (r16 == '?') goto L18;
        if (r16 == ':') goto L18;
        if (r16 == ',') goto L18;
    L21:
        int r17 = r15 + 1;
        if (r16 == '?') goto L30;
        if (r16 == ',') goto L30;
    L24:
        if (r17 >= r14) goto L30;
        r17 = r17 + a(r10, r11, r17, r13);
        if (r11.charAt(r17) == '?') goto L29;
        if (r11.charAt(r17) != ',') goto L24;
    L29:
        r17 = r17 + 1;
    L30:
        r10.remove(0);
        return r17 - r12;
    L18:
        String r18 = f21925a.join(r10);
        if (r18.length() <= 0) goto L21;
        r13.put(r18, PublicSuffixType.fromCode(r16));
        goto L21
    }

    public static ImmutableMap b(CharSequence r10) {
        ImmutableMap.Builder r11 = ImmutableMap.builder();
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        r13 = r13 + a(Lists.newLinkedList(), r10, r13, r11);
        goto L3
    L6:
        return r11.build();
    }

    public static CharSequence c(CharSequence r10) {
        return new StringBuilder(r10).reverse();
    }
}
