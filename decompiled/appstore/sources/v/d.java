package v;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class d implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f24948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EmojiCompat.d f24949b;

    public static class a extends EmojiCompat.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference f24950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Reference f24951b;

        public a(TextView r10, d r11) {
            this.f24950a = new WeakReference(r10);
            this.f24951b = new WeakReference(r11);
        }

        @Override // androidx.emoji2.text.EmojiCompat.d
        public void b() {
            super.b();
            TextView r10 = (TextView) this.f24950a.get();
            if (c(r10, (InputFilter) this.f24951b.get()) == true) goto L6;
            return;
        L6:
            if (r10.isAttachedToWindow() == false) goto L14;
            CharSequence r11 = r10.getText();
            CharSequence r12 = EmojiCompat.b().o(r11);
            if (r11 != r12) goto L10;
            return;
        L10:
            int r13 = Selection.getSelectionStart(r12);
            int r14 = Selection.getSelectionEnd(r12);
            r10.setText(r12);
            if ((r12 instanceof Spannable) == false) goto L15;
            d.b((Spannable) r12, r13, r14);
            return;
        L15:
            return;
        }

        public final boolean c(TextView r10, InputFilter r11) {
            if (r11 == null) goto L17;
            if (r10 == null) goto L17;
            InputFilter[] r12 = r10.getFilters();
            if (r12 != null) goto L9;
            return false;
        L9:
            int r13 = 0;
        L11:
            if (r13 >= r12.length) goto L17;
            if (r12[r13] == r11) goto L14;
            r13 = r13 + 1;
            goto L11
        L14:
            return true;
        L17:
            return false;
        }
    }

    public d(TextView r10) {
        this.f24948a = r10;
    }

    public static void b(Spannable r10, int r11, int r12) {
        if (r11 < 0) goto L5;
        if (r12 < 0) goto L5;
        Selection.setSelection(r10, r11, r12);
        return;
    L5:
        if (r11 < 0) goto L7;
        Selection.setSelection(r10, r11);
        return;
    L7:
        if (r12 < 0) goto L12;
        Selection.setSelection(r10, r12);
        return;
    }

    public final EmojiCompat.d a() {
        if (this.f24949b != null) goto L6;
        this.f24949b = new a(this.f24948a, this);
    L6:
        return this.f24949b;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence r10, int r11, int r12, Spanned r13, int r14, int r15) {
        if (this.f24948a.isInEditMode() == false) goto L5;
        return r10;
    L5:
        int r16 = EmojiCompat.b().d();
        if (r16 != 0) goto L8;
    L28:
        EmojiCompat.b().s(a());
        return r10;
    L8:
        if (r16 != 1) goto L10;
        if (r15 != 0) goto L19;
        if (r14 != 0) goto L19;
        if (r13.length() != 0) goto L19;
        if (r10 != this.f24948a.getText()) goto L19;
    L27:
        return r10;
    L19:
        if (r10 == null) goto L27;
        if (r11 == 0) goto L22;
    L24:
        r10 = r10.subSequence(r11, r12);
    L26:
        return EmojiCompat.b().p(r10, 0, r10.length());
    L22:
        if (r12 != r10.length()) goto L24;
    L10:
        if (r16 == 3) goto L28;
        return r10;
    }
}
