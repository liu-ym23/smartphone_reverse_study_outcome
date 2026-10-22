package com.bytedance.android.livesdk.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public class EmojiEditView extends GradientEditText {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TokenCert f160844e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f160845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<a> f160846d;

    public interface a {
        void a();
    }

    static {
        f160844e = TokenCert.with("bpea-live_comment_paste");
    }

    public EmojiEditView(Context r100) {
        super(r100);
        this.f160845c = com.bytedance.android.live.core.utils.s1.f(16.0f);
        this.f160846d = new ArrayList();
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int r100) {
        if (r100 != 16908322) goto L21;
        ClipData r101 = g80.d.b(f160844e);     // Catch: BPEAException -> L6
    L7:
        if (r101 == null) goto L21;
        if (r101.getItemAt(0) == null) goto L21;
        if (r101.getItemAt(0).getText() == null) goto L21;
        String r102 = r101.getItemAt(0).getText().toString();
        getText().insert(getSelectionStart(), ab2.b.a().c(r102, this.f160845c));
        if (TextUtils.isEmpty(r102) == true) goto L18;
        Iterator<a> r103 = this.f160846d.iterator();
    L16:
        if (r103.hasNext() == false) goto L25;
        r103.next().a();
        goto L16
    L25:
        return true;
    L18:
        return true;
    L6:
        ALogger.i("EmojiEditView", "getClipData error");
        r101 = null;
    L21:
        return super.onTextContextMenuItem(r100);
    }

    public void setTextEmojiSize(int r100) {
        this.f160845c = r100;
    }

    public EmojiEditView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f160845c = com.bytedance.android.live.core.utils.s1.f(16.0f);
        this.f160846d = new ArrayList();
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence r100, TextView.BufferType r101) {
        super.setText(ab2.b.a().c(r100, this.f160845c), r101);
    }

    public EmojiEditView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f160845c = com.bytedance.android.live.core.utils.s1.f(16.0f);
        this.f160846d = new ArrayList();
    }
}
