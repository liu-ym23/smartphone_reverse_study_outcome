package androidx.emoji2.viewsintegration;

import android.os.Build;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.core.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EmojiEditTextHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0052a f1665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1667c;

    /* JADX INFO: renamed from: androidx.emoji2.viewsintegration.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EmojiEditTextHelper.java */
    static class C0052a {
        KeyListener a(KeyListener r2) {
            return (KeyListener) ZeusTransformUtils.wrapperContextForParams(r2, KeyListener.class, "com.obric.aiagent.plugin");
        }

        InputConnection a(InputConnection r1, EditorInfo r2) {
            return (InputConnection) ZeusTransformUtils.wrapperContextForParams(r1, InputConnection.class, "com.obric.aiagent.plugin");
        }

        void a(boolean r1) {
        }

        boolean a() {
            return false;
        }

        C0052a() {
        }
    }

    /* JADX INFO: compiled from: EmojiEditTextHelper.java */
    private static class b extends C0052a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EditText f1668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final EmojiTextWatcher f1669b;

        b(EditText r2, boolean r3) {
            this.f1668a = r2;
            EmojiTextWatcher r0 = new EmojiTextWatcher(r2, r3);
            this.f1669b = r0;
            r2.addTextChangedListener(r0);
            r2.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        @Override // androidx.emoji2.viewsintegration.a.C0052a
        KeyListener a(KeyListener r2) {
            KeyListener r1 = (KeyListener) ZeusTransformUtils.wrapperContextForParams(r2, KeyListener.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r1, EmojiKeyListener.class) == false) goto L5;
            return r1;
        L5:
            if (r1 != null) goto L9;
            return null;
        L9:
            if (ZeusTransformUtils.instanceOf(r1, NumberKeyListener.class) == false) goto L12;
            return r1;
        L12:
            return new EmojiKeyListener(r1);
        }

        @Override // androidx.emoji2.viewsintegration.a.C0052a
        InputConnection a(InputConnection r3, EditorInfo r4) {
            InputConnection r5 = (InputConnection) ZeusTransformUtils.wrapperContextForParams(r3, InputConnection.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r5, EmojiInputConnection.class) == false) goto L6;
            return r5;
        L6:
            return new EmojiInputConnection(this.f1668a, r5, r4);
        }

        @Override // androidx.emoji2.viewsintegration.a.C0052a
        void a(boolean r1) {
            this.f1669b.setEnabled(r1);
        }

        @Override // androidx.emoji2.viewsintegration.a.C0052a
        boolean a() {
            return this.f1669b.isEnabled();
        }
    }

    public a(EditText r3, boolean r4) {
        this.f1666b = Integer.MAX_VALUE;
        this.f1667c = 0;
        g.a(r3, "editText cannot be null");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        this.f1665a = new C0052a();
        return;
    L5:
        this.f1665a = new b(r3, r4);
    }

    public KeyListener a(KeyListener r3) {
        KeyListener r4 = (KeyListener) ZeusTransformUtils.wrapperContextForParams(r3, KeyListener.class, "com.obric.aiagent.plugin");
        return this.f1665a.a(r4);
    }

    public InputConnection a(InputConnection r3, EditorInfo r4) {
        InputConnection r5 = (InputConnection) ZeusTransformUtils.wrapperContextForParams(r3, InputConnection.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L7;
        return null;
    L7:
        return this.f1665a.a(r5, r4);
    }

    public boolean a() {
        return this.f1665a.a();
    }

    public void a(boolean r1) {
        this.f1665a.a(r1);
    }
}
