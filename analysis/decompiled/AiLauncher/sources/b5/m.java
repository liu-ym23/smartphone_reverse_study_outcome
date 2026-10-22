package b5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\bJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\fJ\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\bJ\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\fJ\u0015\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\fJ\u0015\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\bJ\u0015\u0010\u0015\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\fJ\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\bJ\u0015\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\fJ\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001b¨\u0006\u001e"}, d2 = {"Lb5/m;", "", "<init>", "()V", "Landroid/view/View;", "view", "", "c", "(Landroid/view/View;)I", "Landroid/content/Context;", "ctx", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)I", "e", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_COMMAND, "f", "n", "m", "p", "o", "context", "Landroid/content/res/ColorStateList;", "l", "(Landroid/content/Context;)Landroid/content/res/ColorStateList;", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class m {
    public static final m INSTANCE = new m();

    public final int a(Context ctx) {
        p.i(ctx, "ctx");
        return n.INSTANCE.a().a(ctx);
    }

    public final int b(Context ctx) {
        p.i(ctx, "ctx");
        return n.INSTANCE.b().a(ctx);
    }

    public final int c(View view) {
        p.i(view, "view");
        Context context = view.getContext();
        p.h(context, "getContext(...)");
        return b(context);
    }

    public final int d(Context ctx) {
        p.i(ctx, "ctx");
        return n.INSTANCE.c().a(ctx);
    }

    public final int e(View view) {
        p.i(view, "view");
        Context context = view.getContext();
        p.h(context, "getContext(...)");
        return d(context);
    }

    public final int f(Context ctx) {
        p.i(ctx, "ctx");
        return n.INSTANCE.d().a(ctx);
    }

    public final int g(Context ctx) {
        p.i(ctx, "ctx");
        return n.INSTANCE.e().a(ctx);
    }

    public final int h(View view) {
        p.i(view, "view");
        Context context = view.getContext();
        p.h(context, "getContext(...)");
        return g(context);
    }

    public final int i(Context ctx) {
        p.i(ctx, "ctx");
        return n.INSTANCE.f().a(ctx);
    }

    public final ColorStateList j(Context context) {
        p.i(context, "context");
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.parseColor("#FFFFFF"));
        p.h(colorStateListValueOf, "valueOf(...)");
        return colorStateListValueOf;
    }

    public final ColorStateList k(Context context) {
        p.i(context, "context");
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.parseColor("#FF3A3A3C"));
        p.h(colorStateListValueOf, "valueOf(...)");
        return colorStateListValueOf;
    }

    public final ColorStateList l(Context context) {
        p.i(context, "context");
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.parseColor("#FF1E88FF"));
        p.h(colorStateListValueOf, "valueOf(...)");
        return colorStateListValueOf;
    }

    public final int m(Context ctx) {
        p.i(ctx, "ctx");
        return n.INSTANCE.g().a(ctx);
    }

    public final int n(View view) {
        p.i(view, "view");
        Context context = view.getContext();
        p.h(context, "getContext(...)");
        return m(context);
    }

    public final int o(Context ctx) {
        p.i(ctx, "ctx");
        return n.INSTANCE.h().a(ctx);
    }

    public final int p(View view) {
        p.i(view, "view");
        Context context = view.getContext();
        p.h(context, "getContext(...)");
        return o(context);
    }
}
