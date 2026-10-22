package coil.fetch;

import A1.k;
import F1.j;
import F1.m;
import La.C;
import La.H;
import Mb.u;
import Z8.F;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.TypedValue;
import android.webkit.MimeTypeMap;
import coil.decode.DataSource;
import coil.fetch.f;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import e9.InterfaceC4014c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w1.C5716a;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0002\f\tB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcoil/fetch/h;", "Lcoil/fetch/f;", "Landroid/net/Uri;", "data", "LA1/k;", "options", "<init>", "(Landroid/net/Uri;LA1/k;)V", "Lw1/b;", Const.INTENT_KEY_APIKEY, "(Le9/c;)Ljava/lang/Object;", "", Const.INTENT_KEY_PKGNAME, "(Landroid/net/Uri;)Ljava/lang/Void;", "Landroid/net/Uri;", "LA1/k;", "c", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class h implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Uri data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final k options;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcoil/fetch/h$b;", "Lcoil/fetch/f$a;", "Landroid/net/Uri;", "<init>", "()V", "data", "", "c", "(Landroid/net/Uri;)Z", "LA1/k;", "options", "Lcoil/c;", "imageLoader", "Lcoil/fetch/f;", Const.INTENT_KEY_PKGNAME, "(Landroid/net/Uri;LA1/k;Lcoil/c;)Lcoil/fetch/f;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements f.a<Uri> {
        private final boolean c(Uri data) {
            return p.d(data.getScheme(), "android.resource");
        }

        @Override // coil.fetch.f.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f a(Uri data, k options, coil.c imageLoader) {
            if (c(data)) {
                return new h(data, options);
            }
            return null;
        }
    }

    public h(Uri uri, k kVar) {
        this.data = uri;
        this.options = kVar;
    }

    @Override // coil.fetch.f
    public Object a(InterfaceC4014c<? super w1.b> interfaceC4014c) throws Resources.NotFoundException {
        Integer numW;
        String authority = this.data.getAuthority();
        if (authority != null) {
            if (H.x0(authority)) {
                authority = null;
            }
            if (authority != null) {
                String str = (String) F.E0(this.data.getPathSegments());
                if (str == null || (numW = C.w(str)) == null) {
                    b(this.data);
                    throw new KotlinNothingValueException();
                }
                int iIntValue = numW.intValue();
                Context context = this.options.getContext();
                Resources resources = p.d(authority, context.getPackageName()) ? context.getResources() : context.getPackageManager().getResourcesForApplication(authority);
                TypedValue typedValue = new TypedValue();
                resources.getValue(iIntValue, typedValue, true);
                CharSequence charSequence = typedValue.string;
                String strJ = j.j(MimeTypeMap.getSingleton(), charSequence.subSequence(H.A0(charSequence, JsonPointer.SEPARATOR, 0, false, 6, null), charSequence.length()).toString());
                if (!p.d(strJ, "text/xml")) {
                    TypedValue typedValue2 = new TypedValue();
                    return new w1.c(coil.decode.f.f(u.c(u.l(resources.openRawResource(iIntValue, typedValue2))), context, new coil.decode.g(authority, iIntValue, typedValue2.density)), strJ, DataSource.DISK);
                }
                Drawable drawableA = p.d(authority, context.getPackageName()) ? F1.d.a(context, iIntValue) : F1.d.d(context, resources, iIntValue);
                boolean zU = j.u(drawableA);
                if (zU) {
                    drawableA = new BitmapDrawable(context.getResources(), m.f2558a.a(drawableA, this.options.getConfig(), this.options.getSize(), this.options.getCom.stepos.launcher.assistant.slidepanel.ConstConfig.KEY_VIEW_SCALE_PROPERTY java.lang.String(), this.options.getAllowInexactSize()));
                }
                return new C5716a(drawableA, zU, DataSource.DISK);
            }
        }
        b(this.data);
        throw new KotlinNothingValueException();
    }

    public final Void b(Uri data) {
        throw new IllegalStateException("Invalid android.resource URI: " + data);
    }
}
