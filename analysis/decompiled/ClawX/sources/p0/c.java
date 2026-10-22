package p0;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f4646a;

    /* renamed from: b, reason: collision with root package name */
    public final b f4647b;

    public c(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        b bVar = new b(0);
        super(inputConnection, false);
        this.f4646a = editText;
        this.f4647b = bVar;
        if (androidx.emoji2.text.j.f608k != null) {
            androidx.emoji2.text.j jVarA = androidx.emoji2.text.j.a();
            if (jVarA.b() != 1 || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            androidx.emoji2.text.e eVar = jVarA.f612e;
            eVar.getClass();
            Bundle bundle = editorInfo.extras;
            o0.b bVar2 = (o0.b) eVar.f603c.f75b;
            int iA = bVar2.a(4);
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", iA != 0 ? ((ByteBuffer) bVar2.d).getInt(iA + bVar2.f1830a) : 0);
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i8, int i9) {
        Editable editableText = this.f4646a.getEditableText();
        this.f4647b.getClass();
        return b.b(this, editableText, i8, i9, false) || super.deleteSurroundingText(i8, i9);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i8, int i9) {
        Editable editableText = this.f4646a.getEditableText();
        this.f4647b.getClass();
        return b.b(this, editableText, i8, i9, true) || super.deleteSurroundingTextInCodePoints(i8, i9);
    }
}
