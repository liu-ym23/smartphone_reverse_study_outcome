package coil.fetch;

import A1.k;
import Mb.z;
import android.webkit.MimeTypeMap;
import coil.decode.DataSource;
import coil.fetch.f;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\t¨\u0006\n"}, d2 = {"Lcoil/fetch/g;", "Lcoil/fetch/f;", "Ljava/io/File;", "data", "<init>", "(Ljava/io/File;)V", "Lw1/b;", Const.INTENT_KEY_APIKEY, "(Le9/c;)Ljava/lang/Object;", "Ljava/io/File;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class g implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final File data;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcoil/fetch/g$a;", "Lcoil/fetch/f$a;", "Ljava/io/File;", "<init>", "()V", "data", "LA1/k;", "options", "Lcoil/c;", "imageLoader", "Lcoil/fetch/f;", Const.INTENT_KEY_PKGNAME, "(Ljava/io/File;LA1/k;Lcoil/c;)Lcoil/fetch/f;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements f.a<File> {
        @Override // coil.fetch.f.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f a(File data, k options, coil.c imageLoader) {
            return new g(data);
        }
    }

    public g(File file) {
        this.data = file;
    }

    @Override // coil.fetch.f
    public Object a(InterfaceC4014c<? super w1.b> interfaceC4014c) {
        return new w1.c(coil.decode.f.h(z.Companion.d(z.INSTANCE, this.data, false, 1, null), null, null, null, 14, null), MimeTypeMap.getSingleton().getMimeTypeFromExtension(l9.k.w(this.data)), DataSource.DISK);
    }
}
