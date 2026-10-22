package y7;

import android.graphics.drawable.Drawable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.view.GlassAttachment;
import java.util.Arrays;
import kotlin.Metadata;
import z7.C6370e;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\nJI\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u00122\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0012\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0019R\u0018\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u001a\u0010 \u001a\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b\u0018\u0010\u001e¨\u0006!"}, d2 = {"Ly7/a;", "", "<init>", "()V", "Landroid/graphics/drawable/Drawable;", GlassAttachment.GPU_KIND, "", "px", "LY8/t;", "c", "(Landroid/graphics/drawable/Drawable;I)V", "", "e", "(Landroid/graphics/drawable/Drawable;F)V", "argb", Const.INTENT_KEY_UMID, "", "name", "", "Ljava/lang/Class;", "types", "args", Const.INTENT_KEY_APIKEY, "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)V", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Class;", "I", "F", "B", "", "()Z", "isAvailable$annotations", "isAvailable", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: y7.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5945a {

    /* renamed from: a, reason: collision with root package name */
    public static final C5945a f43892a = new C5945a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Class<?> I;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Class<?> F;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Class<?> B;

    static {
        C6370e c6370e = C6370e.f45191a;
        I = c6370e.l();
        F = c6370e.k();
        B = c6370e.j();
    }

    public static final void a(Drawable glass, String name, Class<?>[] types, Object... args) {
        kotlin.jvm.internal.p.i(glass, "glass");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(types, "types");
        kotlin.jvm.internal.p.i(args, "args");
        C6370e.f45191a.g(glass, name, types, Arrays.copyOf(args, args.length));
    }

    public static final boolean b() {
        return C6370e.f45191a.n();
    }

    public static final void c(Drawable glass, int px) {
        kotlin.jvm.internal.p.i(glass, "glass");
        a(glass, "setBlurRadius", new Class[]{I}, Integer.valueOf(px));
    }

    public static final void d(Drawable glass, int argb) {
        kotlin.jvm.internal.p.i(glass, "glass");
        a(glass, "setColor", new Class[]{I}, Integer.valueOf(argb));
    }

    public static final void e(Drawable glass, float px) {
        kotlin.jvm.internal.p.i(glass, "glass");
        a(glass, "setCornerRadius", new Class[]{F}, Float.valueOf(px));
    }
}
