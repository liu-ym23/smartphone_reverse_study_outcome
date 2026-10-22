package w1;

import android.graphics.drawable.Drawable;
import coil.decode.DataSource;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0018\u001a\u0004\b\u0011\u0010\u0019¨\u0006\u001a"}, d2 = {"Lw1/a;", "Lw1/b;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "isSampled", "Lcoil/decode/DataSource;", "dataSource", "<init>", "(Landroid/graphics/drawable/Drawable;ZLcoil/decode/DataSource;)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", Const.INTENT_KEY_APIKEY, "Landroid/graphics/drawable/Drawable;", Const.INTENT_KEY_PKGNAME, "()Landroid/graphics/drawable/Drawable;", "Z", "c", "()Z", "Lcoil/decode/DataSource;", "()Lcoil/decode/DataSource;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: w1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5716a extends b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Drawable drawable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean isSampled;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final DataSource dataSource;

    public C5716a(Drawable drawable, boolean z10, DataSource dataSource) {
        super(null);
        this.drawable = drawable;
        this.isSampled = z10;
        this.dataSource = dataSource;
    }

    /* renamed from: a, reason: from getter */
    public final DataSource getDataSource() {
        return this.dataSource;
    }

    /* renamed from: b, reason: from getter */
    public final Drawable getDrawable() {
        return this.drawable;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsSampled() {
        return this.isSampled;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof C5716a)) {
            return false;
        }
        C5716a c5716a = (C5716a) other;
        return p.d(this.drawable, c5716a.drawable) && this.isSampled == c5716a.isSampled && this.dataSource == c5716a.dataSource;
    }

    public int hashCode() {
        return (((this.drawable.hashCode() * 31) + Boolean.hashCode(this.isSampled)) * 31) + this.dataSource.hashCode();
    }
}
