package v;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public final class g implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f24959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f24960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EmojiCompat.d f24961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f24962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f24963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f24964f;

    public static class a extends EmojiCompat.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference f24965a;

        public a(EditText r10) {
            this.f24965a = new WeakReference(r10);
        }

        @Override // androidx.emoji2.text.EmojiCompat.d
        public void b() {
            super.b();
            g.c((EditText) this.f24965a.get(), 1);
        }
    }

    public g(EditText r10, boolean r11) {
        this.f24962d = Channel.UNLIMITED;
        this.f24963e = 0;
        this.f24959a = r10;
        this.f24960b = r11;
        this.f24964f = true;
    }

    public static void c(EditText r10, int r11) {
        if (r11 != 1) goto L9;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.isAttachedToWindow() == false) goto L11;
        Editable r12 = r10.getEditableText();
        int r13 = Selection.getSelectionStart(r12);
        int r14 = Selection.getSelectionEnd(r12);
        EmojiCompat.b().o(r12);
        d.b(r12, r13, r14);
        return;
    L11:
        return;
    }

    public final EmojiCompat.d a() {
        if (this.f24961c != null) goto L6;
        this.f24961c = new a(this.f24959a);
    L6:
        return this.f24961c;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r10) {
    }

    public boolean b() {
        return this.f24964f;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
    }

    public void d(boolean r10) {
        if (this.f24964f != r10) goto L5;
        return;
    L5:
        if (this.f24961c == null) goto L7;
        EmojiCompat.b().t(this.f24961c);
    L7:
        this.f24964f = r10;
        if (r10 == false) goto L12;
        c(this.f24959a, EmojiCompat.b().d());
        return;
    }

    public final boolean e() {
        if (this.f24964f == true) goto L5;
    L10:
        return true;
    L5:
        if (this.f24960b == false) goto L7;
    L9:
        return false;
    L7:
        if (EmojiCompat.h() == true) goto L9;
        goto L9
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        if (this.f24959a.isInEditMode() == false) goto L5;
        return;
    L5:
        if (e() == true) goto L24;
        if (r12 <= r13) goto L9;
        return;
    L9:
        if ((r10 instanceof Spannable) == false) goto L22;
        int r14 = EmojiCompat.b().d();
        if (r14 != 0) goto L13;
    L18:
        EmojiCompat.b().s(a());
        return;
    L13:
        if (r14 != 1) goto L15;
        EmojiCompat r15 = EmojiCompat.b();
        r15.r((Spannable) r10, r11, r11 + r13, this.f24962d, this.f24963e);
        return;
    L15:
        if (r14 == 3) goto L18;
        return;
    L22:
        return;
    }
}
