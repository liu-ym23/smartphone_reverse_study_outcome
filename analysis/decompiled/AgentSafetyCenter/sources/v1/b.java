package v1;

import java.text.BreakIterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends h.b0 {

    /* renamed from: e, reason: collision with root package name */
    public static b f14379e;

    /* renamed from: f, reason: collision with root package name */
    public static b f14380f;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14381c;

    /* renamed from: d, reason: collision with root package name */
    public BreakIterator f14382d;

    @Override // h.b0
    public final int[] e(int i) {
        switch (this.f14381c) {
            case 0:
                int length = i().length();
                if (length <= 0 || i >= length) {
                    return null;
                }
                if (i < 0) {
                    i = 0;
                }
                do {
                    BreakIterator breakIterator = this.f14382d;
                    if (breakIterator == null) {
                        yb.k.f("impl");
                        throw null;
                    }
                    boolean zIsBoundary = breakIterator.isBoundary(i);
                    BreakIterator breakIterator2 = this.f14382d;
                    if (zIsBoundary) {
                        if (breakIterator2 == null) {
                            yb.k.f("impl");
                            throw null;
                        }
                        int iFollowing = breakIterator2.following(i);
                        if (iFollowing == -1) {
                            return null;
                        }
                        return h(i, iFollowing);
                    }
                    if (breakIterator2 == null) {
                        yb.k.f("impl");
                        throw null;
                    }
                    i = breakIterator2.following(i);
                } while (i != -1);
                return null;
            default:
                if (i().length() <= 0 || i >= i().length()) {
                    return null;
                }
                if (i < 0) {
                    i = 0;
                }
                while (!o(i) && (!o(i) || (i != 0 && o(i - 1)))) {
                    BreakIterator breakIterator3 = this.f14382d;
                    if (breakIterator3 == null) {
                        yb.k.f("impl");
                        throw null;
                    }
                    i = breakIterator3.following(i);
                    if (i == -1) {
                        return null;
                    }
                }
                BreakIterator breakIterator4 = this.f14382d;
                if (breakIterator4 == null) {
                    yb.k.f("impl");
                    throw null;
                }
                int iFollowing2 = breakIterator4.following(i);
                if (iFollowing2 == -1 || !n(iFollowing2)) {
                    return null;
                }
                return h(i, iFollowing2);
        }
    }

    @Override // h.b0
    public final int[] k(int i) {
        switch (this.f14381c) {
            case 0:
                int length = i().length();
                if (length <= 0 || i <= 0) {
                    return null;
                }
                if (i > length) {
                    i = length;
                }
                do {
                    BreakIterator breakIterator = this.f14382d;
                    if (breakIterator == null) {
                        yb.k.f("impl");
                        throw null;
                    }
                    boolean zIsBoundary = breakIterator.isBoundary(i);
                    BreakIterator breakIterator2 = this.f14382d;
                    if (zIsBoundary) {
                        if (breakIterator2 == null) {
                            yb.k.f("impl");
                            throw null;
                        }
                        int iPreceding = breakIterator2.preceding(i);
                        if (iPreceding == -1) {
                            return null;
                        }
                        return h(iPreceding, i);
                    }
                    if (breakIterator2 == null) {
                        yb.k.f("impl");
                        throw null;
                    }
                    i = breakIterator2.preceding(i);
                } while (i != -1);
                return null;
            default:
                int length2 = i().length();
                if (length2 <= 0 || i <= 0) {
                    return null;
                }
                if (i > length2) {
                    i = length2;
                }
                while (i > 0 && !o(i - 1) && !n(i)) {
                    BreakIterator breakIterator3 = this.f14382d;
                    if (breakIterator3 == null) {
                        yb.k.f("impl");
                        throw null;
                    }
                    i = breakIterator3.preceding(i);
                    if (i == -1) {
                        return null;
                    }
                }
                BreakIterator breakIterator4 = this.f14382d;
                if (breakIterator4 == null) {
                    yb.k.f("impl");
                    throw null;
                }
                int iPreceding2 = breakIterator4.preceding(i);
                if (iPreceding2 == -1 || !o(iPreceding2)) {
                    return null;
                }
                if (iPreceding2 == 0 || !o(iPreceding2 - 1)) {
                    return h(iPreceding2, i);
                }
                return null;
        }
    }

    public final void m(String str) {
        switch (this.f14381c) {
            case 0:
                this.f4750a = str;
                BreakIterator breakIterator = this.f14382d;
                if (breakIterator != null) {
                    breakIterator.setText(str);
                    return;
                } else {
                    yb.k.f("impl");
                    throw null;
                }
            default:
                this.f4750a = str;
                BreakIterator breakIterator2 = this.f14382d;
                if (breakIterator2 != null) {
                    breakIterator2.setText(str);
                    return;
                } else {
                    yb.k.f("impl");
                    throw null;
                }
        }
    }

    public boolean n(int i) {
        if (i <= 0 || !o(i - 1)) {
            return false;
        }
        return i == i().length() || !o(i);
    }

    public boolean o(int i) {
        if (i < 0 || i >= i().length()) {
            return false;
        }
        return Character.isLetterOrDigit(i().codePointAt(i));
    }
}
