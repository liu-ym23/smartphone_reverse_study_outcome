package j1;

import java.text.BreakIterator;

/* loaded from: classes.dex */
public final class d extends c {

    /* renamed from: e, reason: collision with root package name */
    public static d f5115e;

    /* renamed from: f, reason: collision with root package name */
    public static d f5116f;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5117c;

    /* renamed from: d, reason: collision with root package name */
    public BreakIterator f5118d;

    @Override // j1.c
    public final int[] c(int i2) {
        switch (this.f5117c) {
            case 0:
                int length = e().length();
                if (length <= 0 || i2 >= length) {
                    return null;
                }
                if (i2 < 0) {
                    i2 = 0;
                }
                do {
                    BreakIterator breakIterator = this.f5118d;
                    if (breakIterator == null) {
                        q7.k.j("impl");
                        throw null;
                    }
                    if (breakIterator.isBoundary(i2)) {
                        BreakIterator breakIterator2 = this.f5118d;
                        if (breakIterator2 == null) {
                            q7.k.j("impl");
                            throw null;
                        }
                        int iFollowing = breakIterator2.following(i2);
                        if (iFollowing == -1) {
                            return null;
                        }
                        return d(i2, iFollowing);
                    }
                    BreakIterator breakIterator3 = this.f5118d;
                    if (breakIterator3 == null) {
                        q7.k.j("impl");
                        throw null;
                    }
                    i2 = breakIterator3.following(i2);
                } while (i2 != -1);
                return null;
            default:
                if (e().length() <= 0 || i2 >= e().length()) {
                    return null;
                }
                if (i2 < 0) {
                    i2 = 0;
                }
                while (!k(i2) && (!k(i2) || (i2 != 0 && k(i2 - 1)))) {
                    BreakIterator breakIterator4 = this.f5118d;
                    if (breakIterator4 == null) {
                        q7.k.j("impl");
                        throw null;
                    }
                    i2 = breakIterator4.following(i2);
                    if (i2 == -1) {
                        return null;
                    }
                }
                BreakIterator breakIterator5 = this.f5118d;
                if (breakIterator5 == null) {
                    q7.k.j("impl");
                    throw null;
                }
                int iFollowing2 = breakIterator5.following(i2);
                if (iFollowing2 == -1 || !j(iFollowing2)) {
                    return null;
                }
                return d(i2, iFollowing2);
        }
    }

    @Override // j1.c
    public final int[] h(int i2) {
        switch (this.f5117c) {
            case 0:
                int length = e().length();
                if (length <= 0 || i2 <= 0) {
                    return null;
                }
                if (i2 > length) {
                    i2 = length;
                }
                do {
                    BreakIterator breakIterator = this.f5118d;
                    if (breakIterator == null) {
                        q7.k.j("impl");
                        throw null;
                    }
                    if (breakIterator.isBoundary(i2)) {
                        BreakIterator breakIterator2 = this.f5118d;
                        if (breakIterator2 == null) {
                            q7.k.j("impl");
                            throw null;
                        }
                        int iPreceding = breakIterator2.preceding(i2);
                        if (iPreceding == -1) {
                            return null;
                        }
                        return d(iPreceding, i2);
                    }
                    BreakIterator breakIterator3 = this.f5118d;
                    if (breakIterator3 == null) {
                        q7.k.j("impl");
                        throw null;
                    }
                    i2 = breakIterator3.preceding(i2);
                } while (i2 != -1);
                return null;
            default:
                int length2 = e().length();
                if (length2 <= 0 || i2 <= 0) {
                    return null;
                }
                if (i2 > length2) {
                    i2 = length2;
                }
                while (i2 > 0 && !k(i2 - 1) && !j(i2)) {
                    BreakIterator breakIterator4 = this.f5118d;
                    if (breakIterator4 == null) {
                        q7.k.j("impl");
                        throw null;
                    }
                    i2 = breakIterator4.preceding(i2);
                    if (i2 == -1) {
                        return null;
                    }
                }
                BreakIterator breakIterator5 = this.f5118d;
                if (breakIterator5 == null) {
                    q7.k.j("impl");
                    throw null;
                }
                int iPreceding2 = breakIterator5.preceding(i2);
                if (iPreceding2 == -1 || !k(iPreceding2)) {
                    return null;
                }
                if (iPreceding2 == 0 || !k(iPreceding2 - 1)) {
                    return d(iPreceding2, i2);
                }
                return null;
        }
    }

    public final void i(String str) {
        switch (this.f5117c) {
            case 0:
                this.f5106a = str;
                BreakIterator breakIterator = this.f5118d;
                if (breakIterator != null) {
                    breakIterator.setText(str);
                    return;
                } else {
                    q7.k.j("impl");
                    throw null;
                }
            default:
                this.f5106a = str;
                BreakIterator breakIterator2 = this.f5118d;
                if (breakIterator2 != null) {
                    breakIterator2.setText(str);
                    return;
                } else {
                    q7.k.j("impl");
                    throw null;
                }
        }
    }

    public boolean j(int i2) {
        if (i2 <= 0 || !k(i2 - 1)) {
            return false;
        }
        return i2 == e().length() || !k(i2);
    }

    public boolean k(int i2) {
        if (i2 < 0 || i2 >= e().length()) {
            return false;
        }
        return Character.isLetterOrDigit(e().codePointAt(i2));
    }
}
