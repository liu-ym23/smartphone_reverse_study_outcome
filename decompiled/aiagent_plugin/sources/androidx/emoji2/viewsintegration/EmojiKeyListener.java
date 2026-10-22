package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class EmojiKeyListener implements KeyListener {
    private final a mEmojiCompatHandleKeyDownHelper;
    private final KeyListener mKeyListener;

    public static class a {
        public a() {
        }

        public boolean a(Editable r2, int r3, KeyEvent r4) {
            return d.a((Editable) ZeusTransformUtils.wrapperContextForParams(r2, Editable.class, "com.obric.aiagent.plugin"), r3, r4);
        }
    }

    EmojiKeyListener(KeyListener r3) {
        this((KeyListener) ZeusTransformUtils.wrapperContextForParams(r3, KeyListener.class, "com.obric.aiagent.plugin"), new a());
    }

    EmojiKeyListener(KeyListener r3, a r4) {
        this.mKeyListener = (KeyListener) ZeusTransformUtils.wrapperContextForParams(r3, KeyListener.class, "com.obric.aiagent.plugin");
        this.mEmojiCompatHandleKeyDownHelper = r4;
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.mKeyListener.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View r3, Editable r4, int r5, KeyEvent r6) {
        Editable r7 = (Editable) ZeusTransformUtils.wrapperContextForParams(r4, Editable.class, "com.obric.aiagent.plugin");
        if (this.mEmojiCompatHandleKeyDownHelper.a(r7, r5, r6) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mKeyListener.onKeyDown(r3, r7, r5, r6) == true) goto L8;
        return false;
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View r3, Editable r4, int r5, KeyEvent r6) {
        Editable r7 = (Editable) ZeusTransformUtils.wrapperContextForParams(r4, Editable.class, "com.obric.aiagent.plugin");
        return this.mKeyListener.onKeyUp(r3, r7, r5, r6);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View r3, Editable r4, KeyEvent r5) {
        Editable r6 = (Editable) ZeusTransformUtils.wrapperContextForParams(r4, Editable.class, "com.obric.aiagent.plugin");
        return this.mKeyListener.onKeyOther(r3, r6, r5);
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View r3, Editable r4, int r5) {
        Editable r6 = (Editable) ZeusTransformUtils.wrapperContextForParams(r4, Editable.class, "com.obric.aiagent.plugin");
        this.mKeyListener.clearMetaKeyState(r3, r6, r5);
    }
}
