package coil.fetch;

import A1.k;
import B1.c;
import Mb.u;
import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import coil.decode.DataSource;
import coil.fetch.f;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u000e\u0010\rJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcoil/fetch/d;", "Lcoil/fetch/f;", "Landroid/net/Uri;", "data", "LA1/k;", "options", "<init>", "(Landroid/net/Uri;LA1/k;)V", "Lw1/b;", Const.INTENT_KEY_APIKEY, "(Le9/c;)Ljava/lang/Object;", "", Const.INTENT_KEY_PKGNAME, "(Landroid/net/Uri;)Z", "c", "Landroid/os/Bundle;", Const.INTENT_KEY_UMID, "()Landroid/os/Bundle;", "Landroid/net/Uri;", "LA1/k;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Uri data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final k options;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcoil/fetch/d$a;", "Lcoil/fetch/f$a;", "Landroid/net/Uri;", "<init>", "()V", "data", "LA1/k;", "options", "Lcoil/c;", "imageLoader", "Lcoil/fetch/f;", Const.INTENT_KEY_PKGNAME, "(Landroid/net/Uri;LA1/k;Lcoil/c;)Lcoil/fetch/f;", "", "c", "(Landroid/net/Uri;)Z", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements f.a<Uri> {
        @Override // coil.fetch.f.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f a(Uri data, k options, coil.c imageLoader) {
            if (c(data)) {
                return new d(data, options);
            }
            return null;
        }

        public final boolean c(Uri data) {
            return p.d(data.getScheme(), SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
        }
    }

    public d(Uri uri, k kVar) {
        this.data = uri;
        this.options = kVar;
    }

    @Override // coil.fetch.f
    public Object a(InterfaceC4014c<? super w1.b> interfaceC4014c) throws FileNotFoundException {
        InputStream inputStreamOpenInputStream;
        ContentResolver contentResolver = this.options.getContext().getContentResolver();
        if (b(this.data)) {
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.data, "r");
            inputStreamOpenInputStream = assetFileDescriptorOpenAssetFileDescriptor != null ? assetFileDescriptorOpenAssetFileDescriptor.createInputStream() : null;
            if (inputStreamOpenInputStream == null) {
                throw new IllegalStateException(("Unable to find a contact photo associated with '" + this.data + "'.").toString());
            }
        } else if (c(this.data)) {
            AssetFileDescriptor assetFileDescriptorOpenTypedAssetFile = contentResolver.openTypedAssetFile(this.data, "image/*", d(), null);
            inputStreamOpenInputStream = assetFileDescriptorOpenTypedAssetFile != null ? assetFileDescriptorOpenTypedAssetFile.createInputStream() : null;
            if (inputStreamOpenInputStream == null) {
                throw new IllegalStateException(("Unable to find a music thumbnail associated with '" + this.data + "'.").toString());
            }
        } else {
            inputStreamOpenInputStream = contentResolver.openInputStream(this.data);
            if (inputStreamOpenInputStream == null) {
                throw new IllegalStateException(("Unable to open '" + this.data + "'.").toString());
            }
        }
        return new w1.c(coil.decode.f.f(u.c(u.l(inputStreamOpenInputStream)), this.options.getContext(), new coil.decode.b(this.data)), contentResolver.getType(this.data), DataSource.DISK);
    }

    public final boolean b(Uri data) {
        return p.d(data.getAuthority(), "com.android.contacts") && p.d(data.getLastPathSegment(), "display_photo");
    }

    public final boolean c(Uri data) {
        List<String> pathSegments;
        int size;
        return p.d(data.getAuthority(), "media") && (size = (pathSegments = data.getPathSegments()).size()) >= 3 && p.d(pathSegments.get(size + (-3)), "audio") && p.d(pathSegments.get(size + (-2)), "albums");
    }

    public final Bundle d() {
        B1.c cVarD = this.options.getSize().d();
        c.a aVar = cVarD instanceof c.a ? (c.a) cVarD : null;
        if (aVar != null) {
            int i10 = aVar.px;
            B1.c cVarC = this.options.getSize().c();
            c.a aVar2 = cVarC instanceof c.a ? (c.a) cVarC : null;
            if (aVar2 != null) {
                int i11 = aVar2.px;
                Bundle bundle = new Bundle(1);
                bundle.putParcelable("android.content.extra.SIZE", new Point(i10, i11));
                return bundle;
            }
        }
        return null;
    }
}
