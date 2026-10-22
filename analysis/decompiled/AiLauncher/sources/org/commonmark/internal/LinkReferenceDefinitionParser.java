package org.commonmark.internal;

import Xb.c;
import Xb.d;
import Yb.r;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class LinkReferenceDefinitionParser {

    /* renamed from: d, reason: collision with root package name */
    public StringBuilder f37772d;

    /* renamed from: e, reason: collision with root package name */
    public String f37773e;

    /* renamed from: f, reason: collision with root package name */
    public String f37774f;

    /* renamed from: g, reason: collision with root package name */
    public char f37775g;

    /* renamed from: h, reason: collision with root package name */
    public StringBuilder f37776h;

    /* renamed from: a, reason: collision with root package name */
    public State f37769a = State.START_DEFINITION;

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f37770b = new StringBuilder();

    /* renamed from: c, reason: collision with root package name */
    public final List<r> f37771c = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public boolean f37777i = false;

    public enum State {
        START_DEFINITION,
        LABEL,
        DESTINATION,
        START_TITLE,
        TITLE,
        PARAGRAPH
    }

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37778a;

        static {
            int[] iArr = new int[State.values().length];
            f37778a = iArr;
            try {
                iArr[State.PARAGRAPH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37778a[State.START_DEFINITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37778a[State.LABEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37778a[State.DESTINATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37778a[State.START_TITLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f37778a[State.TITLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public final int a(CharSequence charSequence, int i10) {
        int iM = d.m(charSequence, i10, charSequence.length());
        int iA = c.a(charSequence, iM);
        if (iA == -1) {
            return -1;
        }
        this.f37774f = charSequence.charAt(iM) == '<' ? charSequence.subSequence(iM + 1, iA - 1).toString() : charSequence.subSequence(iM, iA).toString();
        int iM2 = d.m(charSequence, iA, charSequence.length());
        if (iM2 >= charSequence.length()) {
            this.f37777i = true;
            this.f37770b.setLength(0);
        } else if (iM2 == iA) {
            return -1;
        }
        this.f37769a = State.START_TITLE;
        return iM2;
    }

    public final void b() {
        if (this.f37777i) {
            String strE = Xb.a.e(this.f37774f);
            StringBuilder sb2 = this.f37776h;
            this.f37771c.add(new r(this.f37773e, strE, sb2 != null ? Xb.a.e(sb2.toString()) : null));
            this.f37772d = null;
            this.f37777i = false;
            this.f37773e = null;
            this.f37774f = null;
            this.f37776h = null;
        }
    }

    public List<r> c() {
        b();
        return this.f37771c;
    }

    public CharSequence d() {
        return this.f37770b;
    }

    public final int e(CharSequence charSequence, int i10) {
        int i11;
        int iC = c.c(charSequence, i10);
        if (iC == -1) {
            return -1;
        }
        this.f37772d.append(charSequence, i10, iC);
        if (iC >= charSequence.length()) {
            this.f37772d.append('\n');
            return iC;
        }
        if (charSequence.charAt(iC) != ']' || (i11 = iC + 1) >= charSequence.length() || charSequence.charAt(i11) != ':' || this.f37772d.length() > 999) {
            return -1;
        }
        String strB = Xb.a.b(this.f37772d.toString());
        if (strB.isEmpty()) {
            return -1;
        }
        this.f37773e = strB;
        this.f37769a = State.DESTINATION;
        return d.m(charSequence, iC + 2, charSequence.length());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[LOOP:0: B:6:0x0015->B:23:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(java.lang.CharSequence r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = r3.f37770b
            int r0 = r0.length()
            if (r0 == 0) goto Lf
            java.lang.StringBuilder r0 = r3.f37770b
            r1 = 10
            r0.append(r1)
        Lf:
            java.lang.StringBuilder r0 = r3.f37770b
            r0.append(r4)
            r0 = 0
        L15:
            int r1 = r4.length()
            if (r0 >= r1) goto L48
            int[] r1 = org.commonmark.internal.LinkReferenceDefinitionParser.a.f37778a
            org.commonmark.internal.LinkReferenceDefinitionParser$State r2 = r3.f37769a
            int r2 = r2.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L48;
                case 2: goto L3d;
                case 3: goto L38;
                case 4: goto L33;
                case 5: goto L2e;
                case 6: goto L29;
                default: goto L28;
            }
        L28:
            goto L41
        L29:
            int r0 = r3.i(r4, r0)
            goto L41
        L2e:
            int r0 = r3.h(r4, r0)
            goto L41
        L33:
            int r0 = r3.a(r4, r0)
            goto L41
        L38:
            int r0 = r3.e(r4, r0)
            goto L41
        L3d:
            int r0 = r3.g(r4, r0)
        L41:
            r1 = -1
            if (r0 != r1) goto L15
            org.commonmark.internal.LinkReferenceDefinitionParser$State r4 = org.commonmark.internal.LinkReferenceDefinitionParser.State.PARAGRAPH
            r3.f37769a = r4
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.LinkReferenceDefinitionParser.f(java.lang.CharSequence):void");
    }

    public final int g(CharSequence charSequence, int i10) {
        int iM = d.m(charSequence, i10, charSequence.length());
        if (iM >= charSequence.length() || charSequence.charAt(iM) != '[') {
            return -1;
        }
        this.f37769a = State.LABEL;
        this.f37772d = new StringBuilder();
        int i11 = iM + 1;
        if (i11 >= charSequence.length()) {
            this.f37772d.append('\n');
        }
        return i11;
    }

    public final int h(CharSequence charSequence, int i10) {
        int iM = d.m(charSequence, i10, charSequence.length());
        if (iM >= charSequence.length()) {
            this.f37769a = State.START_DEFINITION;
            return iM;
        }
        this.f37775g = (char) 0;
        char cCharAt = charSequence.charAt(iM);
        if (cCharAt == '\"' || cCharAt == '\'') {
            this.f37775g = cCharAt;
        } else if (cCharAt == '(') {
            this.f37775g = ')';
        }
        if (this.f37775g == 0) {
            b();
            this.f37769a = State.START_DEFINITION;
            return iM;
        }
        this.f37769a = State.TITLE;
        this.f37776h = new StringBuilder();
        int i11 = iM + 1;
        if (i11 == charSequence.length()) {
            this.f37776h.append('\n');
        }
        return i11;
    }

    public final int i(CharSequence charSequence, int i10) {
        int iE = c.e(charSequence, i10, this.f37775g);
        if (iE == -1) {
            return -1;
        }
        this.f37776h.append(charSequence.subSequence(i10, iE));
        if (iE >= charSequence.length()) {
            this.f37776h.append('\n');
            return iE;
        }
        int iM = d.m(charSequence, iE + 1, charSequence.length());
        if (iM != charSequence.length()) {
            return -1;
        }
        this.f37777i = true;
        b();
        this.f37770b.setLength(0);
        this.f37769a = State.START_DEFINITION;
        return iM;
    }
}
