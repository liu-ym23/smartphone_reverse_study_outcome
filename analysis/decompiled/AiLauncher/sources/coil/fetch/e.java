package coil.fetch;

import A1.k;
import F1.j;
import F1.m;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.decode.DataSource;
import coil.fetch.f;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import w1.C5716a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcoil/fetch/e;", "Lcoil/fetch/f;", "Landroid/graphics/drawable/Drawable;", "data", "LA1/k;", "options", "<init>", "(Landroid/graphics/drawable/Drawable;LA1/k;)V", "Lw1/b;", Const.INTENT_KEY_APIKEY, "(Le9/c;)Ljava/lang/Object;", "Landroid/graphics/drawable/Drawable;", Const.INTENT_KEY_PKGNAME, "LA1/k;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class e implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Drawable data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final k options;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcoil/fetch/e$a;", "Lcoil/fetch/f$a;", "Landroid/graphics/drawable/Drawable;", "<init>", "()V", "data", "LA1/k;", "options", "Lcoil/c;", "imageLoader", "Lcoil/fetch/f;", Const.INTENT_KEY_PKGNAME, "(Landroid/graphics/drawable/Drawable;LA1/k;Lcoil/c;)Lcoil/fetch/f;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements f.a<Drawable> {
        @Override // coil.fetch.f.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f a(Drawable data, k options, coil.c imageLoader) {
            return new e(data, options);
        }
    }

    public e(Drawable drawable, k kVar) {
        this.data = drawable;
        this.options = kVar;
    }

    @Override // coil.fetch.f
    public Object a(InterfaceC4014c<? super w1.b> interfaceC4014c) {
        Drawable bitmapDrawable;
        boolean zU = j.u(this.data);
        if (zU) {
            bitmapDrawable = new BitmapDrawable(this.options.getContext().getResources(), m.f2558a.a(this.data, this.options.getConfig(), this.options.getSize(), this.options.getCom.stepos.launcher.assistant.slidepanel.ConstConfig.KEY_VIEW_SCALE_PROPERTY java.lang.String(), this.options.getAllowInexactSize()));
        } else {
            bitmapDrawable = this.data;
        }
        return new C5716a(bitmapDrawable, zU, DataSource.MEMORY);
    }
}
