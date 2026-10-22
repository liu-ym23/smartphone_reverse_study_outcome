package o5;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Set<Character> f10766a;

    static {
        HashSet hashSet = new HashSet();
        char[] cArr = {' ', '\t', '\r', '\n', '\f', 127, 160, 8203, 8204, 8205, 65279};
        for (int i10 = 0; i10 < 11; i10++) {
            hashSet.add(Character.valueOf(cArr[i10]));
        }
        for (char c9 : "@#$%^*_=+|\\/~`-".toCharArray()) {
            hashSet.add(Character.valueOf(c9));
        }
        hashSet.add((char) 12288);
        f10766a = Collections.unmodifiableSet(hashSet);
        new HashSet(Arrays.asList('&', '{', '}'));
    }

    public static String a(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (!f10766a.contains(Character.valueOf(cCharAt))) {
                sb2.append(cCharAt);
            }
        }
        return sb2.toString().toLowerCase(Locale.ROOT);
    }
}
