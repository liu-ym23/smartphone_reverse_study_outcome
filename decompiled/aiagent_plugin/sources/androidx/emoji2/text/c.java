package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DefaultGlyphChecker.java */
/* JADX INFO: loaded from: classes.dex */
class c implements d.InterfaceC0051d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f1615a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextPaint f1616b;

    static {
        f1615a = new ThreadLocal();
    }

    c() {
        TextPaint r0 = new TextPaint();
        this.f1616b = r0;
        r0.setTextSize(10.0f);
    }

    @Override // androidx.emoji2.text.d.InterfaceC0051d
    public boolean a(CharSequence r4, int r5, int r6, int r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L5;
    L7:
        StringBuilder r9 = a();
        r9.setLength(0);
    L8:
        if (r5 >= r6) goto L11;
        r9.append(r8.charAt(r5));
        r5 = r5 + 1;
        goto L8
    L11:
        return androidx.core.graphics.h.a(this.f1616b, r9.toString());
    L5:
        if (r7 <= Build.VERSION.SDK_INT) goto L7;
        return false;
    }

    private static StringBuilder a() {
        ThreadLocal<StringBuilder> r0 = f1615a;
        if (r0.get() != null) goto L6;
        r0.set(new StringBuilder());
    L6:
        return (StringBuilder) ZeusTransformUtils.preCheckCast(r0.get(), StringBuilder.class, "com.obric.aiagent.plugin");
    }
}
