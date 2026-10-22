package v;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: loaded from: classes.dex */
public final class c extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f24946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f24947b;

    public static class a {
        public a() {
        }

        public boolean a(InputConnection r10, Editable r11, int r12, int r13, boolean r14) {
            return EmojiCompat.e(r10, r11, r12, r13, r14);
        }

        public void b(EditorInfo r10) {
            if (EmojiCompat.h() == false) goto L6;
            EmojiCompat.b().u(r10);
            return;
        }
    }

    public c(TextView r10, InputConnection r11, EditorInfo r12) {
        this(r10, r11, r12, new a());
    }

    public final Editable a() {
        return this.f24946a.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int r10, int r11) {
        if (this.f24947b.a(this, a(), r10, r11, false) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.deleteSurroundingText(r10, r11) == true) goto L8;
        return false;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int r10, int r11) {
        if (this.f24947b.a(this, a(), r10, r11, true) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.deleteSurroundingTextInCodePoints(r10, r11) == true) goto L8;
        return false;
    }

    public c(TextView r10, InputConnection r11, EditorInfo r12, a r13) {
        super(r11, false);
        this.f24946a = r10;
        this.f24947b = r13;
        r13.b(r12);
    }
}
