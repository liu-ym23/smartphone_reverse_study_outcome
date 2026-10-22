package com.bytedance.android.livesdk.mention;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.expression.MentionSpan;
import com.bytedance.android.livesdk.interactivity.api.expression.TextExtraStruct;
import com.bytedance.android.livesdk.widget.EmojiEditView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class MentionEditText extends EmojiEditView {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f153495m = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f153496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f153497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f153498h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public em2.b f153499i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<em2.b> f153500j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<TextWatcher> f153501k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View.OnKeyListener f153502l;

    public static class MentionSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<MentionSavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f153503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f153504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<TextExtraStruct> f153505c;

        public class a implements Parcelable.Creator<MentionSavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final MentionSavedState createFromParcel(Parcel r100) {
                return new MentionSavedState(r100);
            L4:
                e = move-exception;
                e.printStackTrace();
                return null;
            }

            @Override // android.os.Parcelable.Creator
            public final MentionSavedState[] newArray(int r100) {
                return new MentionSavedState[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public MentionSavedState(Parcel r100) {
            super(r100);
            this.f153503a = r100.readString();
            this.f153504b = r100.readInt();
            Bundle r101 = r100.readBundle(getClass().getClassLoader());
            if (r101 == null) goto L6;
            this.f153505c = r101.getParcelableArrayList("text_extra_struct");
            return;
        }

        public MentionSavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeString(this.f153503a);
            r100.writeInt(this.f153504b);
            Bundle r102 = new Bundle();
            r102.putParcelableArrayList("text_extra_struct", (ArrayList) this.f153505c);
            r100.writeBundle(r102);
        }
    }

    public class a extends InputConnectionWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MentionEditText f153506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MentionEditText f153507b;

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean sendKeyEvent(KeyEvent r100) {
            MentionEditText r101 = this.f153507b;
            View.OnKeyListener r102 = r101.f153502l;
            if (r102 == null) goto L8;
            if (r102.onKey(r101, r100.getKeyCode(), r100) == false) goto L8;
            return true;
        L8:
            if (r100.getAction() != 0) goto L28;
            if (r100.getKeyCode() != 67) goto L28;
            int r103 = this.f153506a.getSelectionStart();
            int r104 = this.f153506a.getSelectionEnd();
            em2.b r105 = this.f153507b.d(r103, r104);
            if (r105 != null) goto L15;
            this.f153507b.f153498h = false;
            return super.sendKeyEvent(r100);
        L15:
            MentionEditText r106 = this.f153507b;
            if (r106.f153498h == true) goto L25;
            int r107 = r105.f473056a;
            if (r103 == r107) goto L25;
            r106.f153498h = true;
            r106.f153499i = r105;
            if (Build.VERSION.SDK_INT < 25) goto L23;
            setSelection(r107, r105.f473057b);
        L24:
            return true;
        L23:
            setSelection(r105.f473057b, r107);
        L25:
            r106.f153498h = false;
            return super.sendKeyEvent(r100);
        L28:
            return super.sendKeyEvent(r100);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean commitText(CharSequence r100, int r101) {
            return super.commitText(r100, r101);
        L4:
            e = move-exception;
            e.printStackTrace();
            return true;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingText(int r110, int r111) {
            if (r110 != 1) goto L40;
            if (r111 != 0) goto L40;
            Editable r100 = this.f153507b.getText();
            if (r100 != null) goto L8;
        L39:
            return false;
        L8:
            if (r100.length() <= 0) goto L39;
            MentionEditText r101 = this.f153507b;
            int r102 = MentionEditText.f153495m;
            r101.getClass();
            int r103 = r100.length();
            int r112 = Math.max(r101.getSelectionStart() - r110, 0);
            int r113 = Math.min(r101.getSelectionEnd() + r111, r103);
            CharacterStyle[] r104 = (CharacterStyle[]) r100.getSpans(0, r103, CharacterStyle.class);
            int r105 = r104.length;
            int r106 = r112;
            int r107 = r113;
            int r108 = 0;
            boolean r109 = false;
            boolean r114 = false;
        L10:
            if (r108 >= r105) goto L24;
            CharacterStyle r115 = r104[r108];
            int r116 = r100.getSpanStart(r115);
            int r117 = r100.getSpanEnd(r115);
            if (r109 == true) goto L16;
            if (r116 > r112) goto L16;
            if (r117 <= r112) goto L16;
            r106 = r116;
            r109 = true;
        L16:
            if (r114 == true) goto L20;
            if (r116 >= r113) goto L20;
            if (r117 < r113) goto L20;
            r107 = r117;
            r114 = true;
        L20:
            if (r109 == false) goto L23;
            if (r114 == true) goto L24;
        L23:
            r108 = r108 + 1;
        L24:
            if (r106 <= r107) goto L26;
            int r118 = r107;
            r107 = r106;
            r106 = r118;
        L26:
            em2.b r119 = this.f153507b.d(r106, r107);
            if (r119 == null) goto L38;
            MentionSpan[] r120 = (MentionSpan[]) r100.getSpans(r119.f473056a, r119.f473057b, MentionSpan.class);
            if (r120 == null) goto L38;
            if (r120.length <= 0) goto L38;
            if (sendKeyEvent(new KeyEvent(0, 67)) == true) goto L35;
            return false;
        L35:
            if (sendKeyEvent(new KeyEvent(1, 67)) == false) goto L54;
            return true;
        L54:
            return false;
        L38:
            r100.delete(r106, r107);
        L40:
            if (r110 >= 0) goto L42;
            int r121 = -r111;
            r111 = -r110;
            r110 = r121;
        L42:
            if (r110 < 0) goto L47;
            if (r111 < 0) goto L47;
            return super.deleteSurroundingText(r110, r111);
        L47:
            ALogger.e("LiveHackInputConnection", "Invalid length passed to deleteSurroundingText: before=" + r110 + ", after=" + r111);
            return false;
        }

        public a(MentionEditText r100, InputConnection r101, MentionEditText r102) {
            this.f153507b = r100;
            super(r101, true);
            this.f153506a = r102;
        }
    }

    public class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MentionEditText f153508a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public b(MentionEditText r100) {
            this.f153508a = r100;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            if (r103 == 1) goto L5;
            return;
        L5:
            if (TextUtils.isEmpty(r100) == false) goto L7;
            return;
        L7:
            if ('@' != r100.toString().charAt(r101)) goto L12;
            MentionEditText r104 = this.f153508a;
            int r105 = MentionEditText.f153495m;
            r104.getClass();
            return;
        }
    }

    public interface c {
    }

    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<MentionEditText> f153509a;

        @Override // java.lang.Runnable
        public final void run() {
            MentionEditText r100 = this.f153509a.get();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.setSelection(r100.getText().length());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public d(MentionEditText r100) {
            this.f153509a = new WeakReference(r100);
        }
    }

    private void setClip(String r100) {
    }

    public void setOnMentionInputListener(c r100) {
    }

    public final void e() {
        this.f153500j = new ArrayList(5);
        addTextChangedListener(new b(this));
        Context r100 = getContext();
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.getResources().getConfiguration().getLayoutDirection() != 1) goto L7;
    L8:
        if (r101 == false) goto L11;
        setTextAlignment(5);
        setGravity(getGravity() | GravityCompat.START);
        return;
    L11:
        return;
    L7:
        r101 = false;
        goto L8
    }

    public List<TextExtraStruct> getCompatTextExtraStructList() {
        return getTextExtraStructList();
    }

    public MentionSpan[] getMentionText() {
        final Editable r100 = getText();
        if (r100 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r100.toString()) == true) goto L11;
        MentionSpan[] r101 = (MentionSpan[]) r100.getSpans(0, r100.length(), MentionSpan.class);
        Arrays.sort(r101, new em2.a(r100));
        return r101;
    L11:
        return null;
    }

    public int getMentionTextCount() {
        MentionSpan[] r100 = getMentionText();
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.length;
    }

    public ArrayList<TextExtraStruct> getTextExtraStructList() {
        Editable r100 = getText();
        if (r100 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r100.toString()) == true) goto L14;
        ArrayList<TextExtraStruct> r101 = new ArrayList();
        MentionSpan[] r102 = getMentionText();
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L10;
        MentionSpan r105 = r102[r104];
        r105.f133187d.setStart(r100.getSpanStart(r105));
        r105.f133187d.setEnd(r100.getSpanEnd(r105));
        r101.add(r105.f133187d);
        r104 = r104 + 1;
        goto L8
    L10:
        return r101;
    L14:
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        MentionSavedState r100 = new MentionSavedState(super.onSaveInstanceState());
        r100.f153503a = getText().toString();
        r100.f153504b = Math.max(getSelectionEnd(), 0);
        r100.f153505c = getCompatTextExtraStructList();
        return r100;
    }

    public int getMentionTextTypeface() {
        return this.f153497g;
    }

    public MentionEditText(Context r100) {
        super(r100);
        this.f153501k = new ArrayList();
        e();
    }

    @Override // android.widget.TextView
    public final void addTextChangedListener(TextWatcher r100) {
        super.addTextChangedListener(r100);
        List<TextWatcher> r101 = this.f153501k;
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.add(r100);
        return;
    L8:
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r100) {
        InputConnection r101 = super.onCreateInputConnection(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return new a(this, r101, this);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof MentionSavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        MentionSavedState r101 = (MentionSavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        setText(r101.f153503a);
        int r102 = Math.min(r101.f153504b, getText().length());
        if (r102 < 0) goto L9;
        setSelection(r102);
    L9:
        setTextExtraList(r101.f153505c);
    }

    @Override // com.bytedance.android.livesdk.widget.EmojiEditView, androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r100) {
        if (r100 == 16908320) goto L7;
        if (r100 == 16908321) goto L7;
        String r101 = "";
    L11:
        boolean r102 = super.onTextContextMenuItem(r100);
        if (r100 == 16908320) goto L14;
        if (r100 == 16908321) goto L14;
    L15:
        return r102;
    L14:
        setClip(r101);
    L7:
        int r103 = getText().length();
        int r104 = 0;
        if (isFocused() == false) goto L10;
        int r105 = getSelectionStart();
        int r106 = getSelectionEnd();
        int r107 = Math.max(0, Math.min(r105, r106));
        r103 = Math.max(0, Math.max(r105, r106));
        r104 = r107;
    L10:
        r101 = getText().subSequence(r104, r103).toString();
        goto L11
    }

    @Override // android.widget.TextView
    public final void removeTextChangedListener(TextWatcher r100) {
        super.removeTextChangedListener(r100);
        List<TextWatcher> r101 = this.f153501k;
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.remove(r100);
        return;
    L8:
        return;
    }

    public void setMentionTextTypeface(int r100) {
        this.f153497g = r100;
    }

    @Override // android.view.View
    public void setOnKeyListener(View.OnKeyListener r100) {
        this.f153502l = r100;
        super.setOnKeyListener(r100);
    }

    public void setTextExtraList(List<TextExtraStruct> r110) {
        this.f153498h = false;
        List<em2.b> r100 = this.f153500j;
        if (r100 == null) goto L5;
        ((ArrayList) r100).clear();
    L5:
        if (r110 != null) goto L7;
        return;
    L7:
        if (r110.isEmpty() == true) goto L40;
        Editable r101 = getText();
        if (r101 != null) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(r101.toString()) == true) goto L41;
        int r102 = r101.length();
        Iterator<TextExtraStruct> r111 = r110.iterator();
    L16:
        if (r111.hasNext() == false) goto L42;
        TextExtraStruct r103 = r111.next();
        if (r103.getStart() > r102) goto L16;
        if (r103.getEnd() > r102) goto L16;
        if (r103.getStart() > r103.getEnd()) goto L16;
        if (r103.getStart() < 0) goto L16;
        r101.setSpan(new MentionSpan(new com.bytedance.android.livesdk.interactivity.api.expression.d(r103.getColor(), r101.subSequence(r103.getStart(), r103.getEnd()).toString(), r103.getUserId(), r103.getWebcastUid(), r103.getUser(), false)), r103.getStart(), r103.getEnd(), 33);
        em2.b r104 = new em2.b(r103.getStart(), r103.getEnd());
        ((ArrayList) this.f153500j).add(r104);
        goto L16
    L42:
        return;
    L41:
        return;
    }

    public void setTextWithoutAutoSelectLast(String r100) {
        super.setText(r100, TextView.BufferType.EDITABLE);     // Catch: Exception -> L4
        return;
    }

    public MentionEditText(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f153501k = new ArrayList();
        e();
    }

    public final em2.b d(int r100, int r101) {
        List<em2.b> r102 = this.f153500j;
        if (r102 != null) goto L5;
        return null;
    L5:
        Iterator r103 = ((ArrayList) r102).iterator();
    L7:
        if (r103.hasNext() == false) goto L16;
        em2.b r104 = (em2.b) r103.next();
        if (r104.f473056a <= r100) goto L11;
    L13:
        boolean r105 = false;
    L14:
        if (r105 == false) goto L7;
        return r104;
    L11:
        if (r104.f473057b < r101) goto L13;
        r105 = true;
        goto L14
    L16:
        return null;
    }

    @Override // android.widget.TextView
    public final void onSelectionChanged(int r100, int r101) {
        super.onSelectionChanged(r100, r101);
        em2.b r102 = this.f153499i;
        if (r102 == null) goto L15;
        int r103 = r102.f473056a;
        if (r103 == r100) goto L7;
    L8:
        if (r103 == r101) goto L10;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == false) goto L15;
        return;
    L10:
        if (r102.f473057b != r100) goto L12;
    L11:
        r104 = true;
        goto L13
    L7:
        if (r102.f473057b == r101) goto L11;
    L15:
        em2.b r105 = d(r100, r101);
        if (r105 != null) goto L18;
    L20:
        List<em2.b> r106 = this.f153500j;
        em2.b r107 = null;
        if (r106 == null) goto L37;
        Iterator r108 = ((ArrayList) r106).iterator();
    L25:
        if (r108.hasNext() == false) goto L37;
        em2.b r109 = (em2.b) r108.next();
        int r110 = r109.f473056a;
        if (r100 > r110) goto L29;
    L30:
        if (r101 > r110) goto L32;
    L34:
        boolean r111 = false;
    L35:
        if (r111 == false) goto L25;
        r107 = r109;
        goto L37
    L32:
        if (r101 >= r109.f473057b) goto L34;
    L33:
        r111 = true;
        goto L35
    L29:
        if (r100 < r109.f473057b) goto L33;
    L37:
        if (r107 != null) goto L54;
        return;
    L54:
        if (r100 != r101) goto L44;
        int r112 = r107.f473056a;     // Catch: IndexOutOfBoundsException -> L51
        int r113 = r107.f473057b;     // Catch: IndexOutOfBoundsException -> L51
        if (((r100 - r112) - (r113 - r100)) < 0) goto L43;
        r112 = r113;
    L43:
        setSelection(r112);     // Catch: IndexOutOfBoundsException -> L51
        return;
    L44:
        int r114 = r107.f473057b;     // Catch: IndexOutOfBoundsException -> L51
        if (r101 >= r114) goto L47;
        setSelection(r100, r114);     // Catch: IndexOutOfBoundsException -> L51
    L47:
        int r115 = r107.f473056a;     // Catch: IndexOutOfBoundsException -> L51
        if (r100 <= r115) goto L61;
        setSelection(r115, r101);     // Catch: IndexOutOfBoundsException -> L51
        return;
    L61:
        return;
    L51:
        e = move-exception;
        e.printStackTrace();
        return;
    L18:
        if (r105.f473057b != r101) goto L20;
        this.f153498h = false;
        goto L20
    }

    @Override // com.bytedance.android.livesdk.widget.EmojiEditView, android.widget.EditText, android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        super.setText(r100, r101);     // Catch: Exception -> L4
    L6:
        if (this.f153496f != null) goto L9;
        this.f153496f = new d(this);
    L9:
        if (getText().length() <= 0) goto L14;
        post(this.f153496f);
        return;
    }

    public MentionEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f153501k = new ArrayList();
        e();
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        int r104 = 0;
        this.f153498h = false;
        List<em2.b> r105 = this.f153500j;
        if (r105 == null) goto L5;
        ((ArrayList) r105).clear();
    L5:
        Editable r106 = getText();
        if (r106 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r106.toString()) == true) goto L21;
        MentionSpan[] r107 = getMentionText();
        int r108 = r107.length;
    L11:
        if (r104 >= r108) goto L22;
        MentionSpan r109 = r107[r104];
        int r110 = r106.getSpanStart(r109);
        int r111 = r106.getSpanEnd(r109);
        em2.b r112 = new em2.b(r110, r111);
        if (TextUtils.equals(r106.subSequence(r110, r111).toString(), r109.f133186c) == true) goto L15;
        r106.removeSpan(r109);
    L16:
        r104 = r104 + 1;
        goto L11
    L15:
        ((ArrayList) this.f153500j).add(r112);
        goto L16
    L22:
        return;
    }
}
