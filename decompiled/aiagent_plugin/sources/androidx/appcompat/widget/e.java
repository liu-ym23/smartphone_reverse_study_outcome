package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppCompatEmojiEditTextHelper.java */
/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EditText f431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.emoji2.viewsintegration.a f432b;

    e(EditText r3) {
        this.f431a = r3;
        this.f432b = new androidx.emoji2.viewsintegration.a(r3, false);
    }

    void a(AttributeSet r6, int r7) {
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        TypedArray r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f431a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r8, R.styleable.AppCompatTextView, r7, 0);
        boolean r2 = true;
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_emojiCompatEnabled, "styleable", "AppCompatTextView_emojiCompatEnabled")) == false) goto L6;
        r2 = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_emojiCompatEnabled, "styleable", "AppCompatTextView_emojiCompatEnabled"), true);     // Catch: Throwable -> L8
    L6:
        r9.recycle();
        a(r2);
        return;
    L8:
        th = move-exception;
        r9.recycle();
        throw th;
    }

    boolean a(KeyListener r2) {
        return !ZeusTransformUtils.instanceOf((KeyListener) ZeusTransformUtils.wrapperContextForParams(r2, KeyListener.class, "com.obric.aiagent.plugin"), NumberKeyListener.class);
    }

    void a(boolean r1) {
        this.f432b.a(r1);
    }

    boolean a() {
        return this.f432b.a();
    }

    KeyListener b(KeyListener r3) {
        KeyListener r4 = (KeyListener) ZeusTransformUtils.wrapperContextForParams(r3, KeyListener.class, "com.obric.aiagent.plugin");
        if (a(r4) == true) goto L5;
        return r4;
    L5:
        return this.f432b.a(r4);
    }

    InputConnection a(InputConnection r3, EditorInfo r4) {
        InputConnection r5 = (InputConnection) ZeusTransformUtils.wrapperContextForParams(r3, InputConnection.class, "com.obric.aiagent.plugin");
        return this.f432b.a(r5, r4);
    }
}
