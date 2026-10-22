package A1;

import android.graphics.drawable.Drawable;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0012\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a¨\u0006\u001b"}, d2 = {"LA1/e;", "LA1/h;", "Landroid/graphics/drawable/Drawable;", "drawable", "LA1/g;", "request", "", "throwable", "<init>", "(Landroid/graphics/drawable/Drawable;LA1/g;Ljava/lang/Throwable;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", Const.INTENT_KEY_APIKEY, "Landroid/graphics/drawable/Drawable;", Const.INTENT_KEY_PKGNAME, "()Landroid/graphics/drawable/Drawable;", "LA1/g;", "()LA1/g;", "c", "Ljava/lang/Throwable;", "()Ljava/lang/Throwable;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class e extends h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Drawable drawable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final g request;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Throwable throwable;

    public e(Drawable drawable, g gVar, Throwable th) {
        super(null);
        this.drawable = drawable;
        this.request = gVar;
        this.throwable = th;
    }

    @Override // A1.h
    /* renamed from: a, reason: from getter */
    public g getRequest() {
        return this.request;
    }

    /* renamed from: b, reason: from getter */
    public Drawable getDrawable() {
        return this.drawable;
    }

    /* renamed from: c, reason: from getter */
    public final Throwable getThrowable() {
        return this.throwable;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        return kotlin.jvm.internal.p.d(getDrawable(), eVar.getDrawable()) && kotlin.jvm.internal.p.d(getRequest(), eVar.getRequest()) && kotlin.jvm.internal.p.d(this.throwable, eVar.throwable);
    }

    public int hashCode() {
        Drawable drawable = getDrawable();
        return ((((drawable != null ? drawable.hashCode() : 0) * 31) + getRequest().hashCode()) * 31) + this.throwable.hashCode();
    }
}
