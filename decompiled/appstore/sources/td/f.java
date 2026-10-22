package td;

import android.graphics.Typeface;
import android.widget.TextView;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f24799a = null;

    static {
        f24799a = new f();
    }

    public f() {
    }

    public static final void a(TextView r10, int r11) {
        q.g(r10, "textView");
        Typeface r12 = r10.getTypeface();
        if (r12 != null) goto L5;
        r12 = Typeface.DEFAULT;
    L5:
        boolean r13 = false;
        if (r12 != null) goto L9;
    L11:
        r10.setTypeface(Typeface.create(r12, r11, r13));
        return;
    L9:
        if (r12.isItalic() != true) goto L11;
        r13 = true;
        goto L11
    }
}
