package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.view;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import g80.d;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public class StablePrefixGradientEditText extends GradientEditText implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TokenCert f109143d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f109144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f109145c;

    public class a implements ActionMode.Callback {
        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r100) {
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
            return false;
        }

        public a() {
        }
    }

    static {
        f109143d = TokenCert.with("bpea-vs_replay_emoji_paste");
    }

    public final void c() {
        setImeOptions(268435456);
        setOnFocusChangeListener(this);
        setCustomSelectionActionModeCallback(new a());
    }

    public final boolean d() {
        String r100 = this.f109144b;
        if (r100 == null) goto L5;
        int r101 = r100.length();
    L7:
        if (getSelectionStart() != getSelectionEnd()) goto L13;
        if (getSelectionStart() <= r101) goto L16;
        return true;
    L16:
        return false;
    L13:
        if (getSelectionStart() < r101) goto L17;
        return true;
    L17:
        return false;
    L5:
        r101 = 0;
        goto L7
    }

    public String getPrefixStr() {
        if (TextUtils.isEmpty(this.f109144b) == false) goto L7;
        return "";
    L7:
        return this.f109144b;
    }

    public int getTextEmojiSize() {
        return this.f109145c;
    }

    public StablePrefixGradientEditText(Context r100) {
        super(r100);
        this.f109144b = "";
        this.f109145c = s1.f(16.0f);
        c();
    }

    private void setEdtTxtColor(String r100) {
        SpannableStringBuilder r101 = new SpannableStringBuilder();
        ForegroundColorSpan r102 = new ForegroundColorSpan(0);
        r101.append(r100);
        r101.setSpan(r102, 0, r100.length(), 17);
        setText(r101);
        setSelection(r100.length());
    }

    @Override // android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        if (r100.getAction() != 0) goto L11;
        if (r100.getKeyCode() != 67) goto L11;
        if (d() == true) goto L11;
        return !d();
    L11:
        return super.dispatchKeyEvent(r100);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r100) {
        if (r100 != 16908322) goto L18;
        ClipData r101 = d.b(f109143d);     // Catch: BPEAException -> L6
    L7:
        if (r101 == null) goto L18;
        if (r101.getItemAt(0) == null) goto L18;
        if (r101.getItemAt(0).getText() == null) goto L18;
        String r102 = r101.getItemAt(0).getText().toString();
        int r103 = getSelectionStart();
        Editable r104 = getText();
        if (r104 == null) goto L21;
        r104.insert(r103, r.e().c(r102, this.f109145c));
        return true;
    L21:
        return true;
    L6:
        ALogger.i("EmojiEditView", "getClipData error");
        r101 = null;
    L18:
        return super.onTextContextMenuItem(r100);
    }

    public void setFixText(String r100) {
        if (getText() == null) goto L5;
        String r101 = getText().toString();
    L6:
        String r102 = r101.replaceFirst(this.f109144b, r100);
        this.f109144b = r100;
        setText(r102);
        setSelection(r102.length());     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        r101 = "";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.view.GradientEditText, android.widget.TextView
    public void setTextColor(int r100) {
        super.setTextColor(r100);
        requestLayout();
        invalidate();
    }

    public void setTextEmojiSize(int r100) {
        this.f109145c = r100;
    }

    public StablePrefixGradientEditText(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f109144b = "";
        this.f109145c = s1.f(16.0f);
        c();
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == true) goto L4;
        return;
    L4:
        if (getText().toString().length() > this.f109144b.length()) goto L8;
        setText(this.f109144b);
        return;
    }

    @Override // android.widget.TextView
    public final void onSelectionChanged(int r100, int r101) {
        String r102 = this.f109144b;
        if (r102 == null) goto L5;
        int r103 = r102.length();
    L6:
        if (r100 < r103) goto L8;
    L17:
        super.onSelectionChanged(r100, r101);
        return;
    L8:
        if (r100 >= this.f109144b.length()) goto L11;
        r100 = this.f109144b.length();
    L11:
        if (getText().toString().length() >= r100) goto L19;
    L16:
        r101 = r100;
        goto L17
    L19:
        setSelection(r100, r100);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L5:
        r103 = 0;
        goto L6
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        CharSequence r102 = r.e().c(r100, this.f109145c);
        s1.getContext();
        Pattern r103 = com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.utils.d.f109249a;
        if (r102 != null) goto L6;
        SpannableString r104 = null;
    L15:
        super.setText(r104, r101);
        return;
    L6:
        if ((r102 instanceof Spannable) == false) goto L14;
        Spannable r105 = (Spannable) r102;
        int r106 = 0;
        sl1.a[] r107 = (sl1.a[]) r105.getSpans(0, r102.length(), sl1.a.class);
        if (r107 == null) goto L14;
        if (r107.length <= 0) goto L14;
        int r108 = r107.length;
    L12:
        if (r106 >= r108) goto L14;
        r105.removeSpan(r107[r106]);
        r106 = r106 + 1;
    L14:
        r104 = SpannableString.valueOf(r102);
        goto L15
    }

    public StablePrefixGradientEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f109144b = "";
        this.f109145c = s1.f(16.0f);
        c();
    }
}
