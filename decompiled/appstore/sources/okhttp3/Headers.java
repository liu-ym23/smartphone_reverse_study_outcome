package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes4.dex */
public final class Headers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f22697a;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f22698a;

        public Builder() {
            this.f22698a = new ArrayList(20);
        }

        public Builder a(String r10, String r11) {
            e(r10, r11);
            return c(r10, r11);
        }

        public Builder b(String r10) {
            int r11 = r10.indexOf(":", 1);
            if (r11 == (-1)) goto L7;
            return c(r10.substring(0, r11), r10.substring(r11 + 1));
        L7:
            if (r10.startsWith(":") == false) goto L11;
            return c("", r10.substring(1));
        L11:
            return c("", r10);
        }

        public Builder c(String r10, String r11) {
            this.f22698a.add(r10);
            this.f22698a.add(r11.trim());
            return this;
        }

        public Headers d() {
            return new Headers(this);
        }

        public final void e(String r10, String r11) {
            if (r10 == null) goto L31;
            if (r10.isEmpty() == true) goto L29;
            int r12 = r10.length();
            int r13 = 0;
            int r14 = 0;
        L7:
            if (r14 >= r12) goto L14;
            char r15 = r10.charAt(r14);
            if (r15 <= ' ') goto L13;
            if (r15 >= 127) goto L13;
            r14 = r14 + 1;
        L13:
            throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(r15), Integer.valueOf(r14), r10}));
        L14:
            if (r11 == null) goto L27;
            int r16 = r11.length();
        L16:
            if (r13 >= r16) goto L25;
            char r17 = r11.charAt(r13);
            if (r17 <= 31) goto L20;
        L21:
            if (r17 >= 127) goto L24;
            r13 = r13 + 1;
        L24:
            throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", new Object[]{Integer.valueOf(r17), Integer.valueOf(r13), r10, r11}));
        L20:
            if (r17 != '\t') goto L24;
        L25:
            return;
        L27:
            throw new NullPointerException("value for name " + r10 + " == null");
        L29:
            throw new IllegalArgumentException("name is empty");
        L31:
            throw new NullPointerException("name == null");
        }

        public String f(String r10) {
            int r11 = this.f22698a.size() - 2;
        L3:
            if (r11 < 0) goto L9;
            if (r10.equalsIgnoreCase((String) this.f22698a.get(r11)) == true) goto L7;
            r11 = r11 - 2;
            goto L3
        L7:
            return (String) this.f22698a.get(r11 + 1);
        L9:
            return null;
        }

        public Builder g(String r10) {
            int r11 = 0;
        L4:
            if (r11 >= this.f22698a.size()) goto L9;
            if (r10.equalsIgnoreCase((String) this.f22698a.get(r11)) == false) goto L8;
            this.f22698a.remove(r11);
            this.f22698a.remove(r11);
            r11 = r11 - 2;
        L8:
            r11 = r11 + 2;
            goto L4
        L9:
            return this;
        }

        public Builder h(String r10, String r11) {
            e(r10, r11);
            g(r10);
            c(r10, r11);
            return this;
        }
    }

    public Headers(Builder r10) {
        List r11 = r10.f22698a;
        this.f22697a = (String[]) r11.toArray(new String[r11.size()]);
    }

    public static String c(String[] r10, String r11) {
        int r12 = r10.length - 2;
    L3:
        if (r12 < 0) goto L9;
        if (r11.equalsIgnoreCase(r10[r12]) == true) goto L7;
        r12 = r12 - 2;
        goto L3
    L7:
        return r10[r12 + 1];
    L9:
        return null;
    }

    public static Headers g(String... r10) {
        if (r10 == null) goto L30;
        if ((r10.length % 2) != 0) goto L28;
        String[] r11 = (String[]) r10.clone();
        int r12 = 0;
    L7:
        if (r12 >= r11.length) goto L13;
        String r13 = r11[r12];
        if (r13 == null) goto L12;
        r11[r12] = r13.trim();
        r12 = r12 + 1;
        goto L7
    L12:
        throw new IllegalArgumentException("Headers cannot be null");
    L13:
        int r14 = 0;
    L15:
        if (r14 >= r11.length) goto L26;
        String r15 = r11[r14];
        String r16 = r11[r14 + 1];
        if (r15.length() == 0) goto L24;
        if (r15.indexOf(0) != (-1)) goto L24;
        if (r16.indexOf(0) != (-1)) goto L24;
        r14 = r14 + 2;
    L24:
        throw new IllegalArgumentException("Unexpected header: " + r15 + ": " + r16);
    L26:
        return new Headers(r11);
    L28:
        throw new IllegalArgumentException("Expected alternating header names and values");
    L30:
        throw new NullPointerException("namesAndValues == null");
    }

    public long a() {
        String[] r10 = this.f22697a;
        long r11 = r10.length * 2;
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11 = r11 + ((long) this.f22697a[r13].length());
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public String b(String r10) {
        return c(this.f22697a, r10);
    }

    public String d(int r10) {
        return this.f22697a[r10 * 2];
    }

    public Set e() {
        TreeSet r10 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int r11 = h();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        r10.add(d(r12));
        r12 = r12 + 1;
        goto L3
    L6:
        return Collections.unmodifiableSet(r10);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof Headers) == true) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.equals(((Headers) r10).f22697a, this.f22697a) == false) goto L7;
        return true;
    }

    public Builder f() {
        Builder r10 = new Builder();
        Collections.addAll(r10.f22698a, this.f22697a);
        return r10;
    }

    public int h() {
        return this.f22697a.length / 2;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f22697a);
    }

    public Map i() {
        TreeMap r10 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int r11 = h();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        String r13 = d(r12).toLowerCase(Locale.US);
        List r14 = (List) r10.get(r13);
        if (r14 != null) goto L7;
        r14 = new ArrayList(2);
        r10.put(r13, r14);
    L7:
        r14.add(j(r12));
        r12 = r12 + 1;
        goto L3
    L8:
        return r10;
    }

    public String j(int r10) {
        return this.f22697a[(r10 * 2) + 1];
    }

    public List k(String r10) {
        int r11 = h();
        ArrayList r12 = null;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L10;
        if (r10.equalsIgnoreCase(d(r13)) == false) goto L9;
        if (r12 != null) goto L8;
        r12 = new ArrayList(2);
    L8:
        r12.add(j(r13));
    L9:
        r13 = r13 + 1;
        goto L3
    L10:
        if (r12 == null) goto L13;
        return Collections.unmodifiableList(r12);
    L13:
        return Collections.emptyList();
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        int r11 = h();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        r10.append(d(r12));
        r10.append(": ");
        r10.append(j(r12));
        r10.append("\n");
        r12 = r12 + 1;
        goto L3
    L6:
        return r10.toString();
    }

    public Headers(String[] r10) {
        this.f22697a = r10;
    }
}
