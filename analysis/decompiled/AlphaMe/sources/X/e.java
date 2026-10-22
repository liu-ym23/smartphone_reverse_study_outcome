package X;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.inputmethod.EditorInfo;
import d.C0527a;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class e extends C0527a {

    /* renamed from: c, reason: collision with root package name */
    public volatile t f2048c;

    /* renamed from: d, reason: collision with root package name */
    public volatile t.d f2049d;

    public final void H() {
        try {
            ((j) this.f12410b).f2060f.a(new C0113d(this));
        } catch (Throwable th) {
            ((j) this.f12410b).d(th);
        }
    }

    public final CharSequence I(CharSequence charSequence, int i4, int i5, boolean z4) {
        D d4;
        C[] cArr;
        t tVar = this.f2048c;
        tVar.getClass();
        boolean z5 = charSequence instanceof A;
        if (z5) {
            ((A) charSequence).a();
        }
        if (z5) {
            d4 = new D((Spannable) charSequence);
        } else {
            try {
                if (charSequence instanceof Spannable) {
                    d4 = new D((Spannable) charSequence);
                } else if (!(charSequence instanceof Spanned) || ((Spanned) charSequence).nextSpanTransition(i4 - 1, i5 + 1, C.class) > i5) {
                    d4 = null;
                } else {
                    d4 = new D();
                    d4.f2042a = false;
                    d4.f2043b = new SpannableString(charSequence);
                }
            } finally {
                if (z5) {
                    ((A) charSequence).b();
                }
            }
        }
        if (d4 != null && (cArr = (C[]) d4.f2043b.getSpans(i4, i5, C.class)) != null && cArr.length > 0) {
            for (C c4 : cArr) {
                int spanStart = d4.f2043b.getSpanStart(c4);
                int spanEnd = d4.f2043b.getSpanEnd(c4);
                if (spanStart != i5) {
                    d4.removeSpan(c4);
                }
                i4 = Math.min(spanStart, i4);
                i5 = Math.max(spanEnd, i5);
            }
        }
        int i6 = i4;
        if (i6 != i5 && i6 < charSequence.length()) {
            D d5 = (D) tVar.c(charSequence, i6, i5, Integer.MAX_VALUE, z4, new p(d4, tVar.f2086a));
            if (d5 != null) {
                Spannable spannable = d5.f2043b;
                if (z5) {
                    ((A) charSequence).b();
                }
                return spannable;
            }
            if (!z5) {
                return charSequence;
            }
        } else if (!z5) {
            return charSequence;
        }
        return charSequence;
    }

    public final void J(EditorInfo editorInfo) {
        Bundle bundle = editorInfo.extras;
        Y.b bVar = (Y.b) this.f2049d.f15273a;
        int iA = bVar.a(4);
        bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", iA != 0 ? ((ByteBuffer) bVar.f2114d).getInt(iA + bVar.f2111a) : 0);
        Bundle bundle2 = editorInfo.extras;
        ((j) this.f12410b).getClass();
        bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
    }
}
