package u8;

import android.content.Context;
import android.text.Spanned;
import android.widget.TextView;

/* loaded from: classes4.dex */
public abstract class e {

    public interface a {
        a a(i iVar);

        e build();
    }

    public interface b {
    }

    public static a a(Context context) {
        return new f(context).a(io.noties.markwon.core.a.s());
    }

    public abstract g b();

    public abstract <P extends i> P c(Class<P> cls);

    public abstract Yb.u d(String str);

    public abstract Spanned e(Yb.u uVar);

    public abstract void f(TextView textView, String str);

    public abstract void g(TextView textView, Spanned spanned);

    public abstract Spanned h(String str);
}
