package w7;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import s7.m;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lw7/h;", "", "<init>", "()V", "Landroid/view/View;", "view", "", "shaderSrc", "Lw7/h$a;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;Ljava/lang/String;)Lw7/h$a;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f43122a = new h();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0018\u001a\u0004\b\u0014\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001a\u0010\f¨\u0006\u001e"}, d2 = {"Lw7/h$a;", "", "", "effectId", "Landroid/graphics/drawable/Drawable;", "drawable", "", "viewRootClass", "error", "<init>", "(JLandroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "J", Const.INTENT_KEY_PKGNAME, "()J", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "c", "Ljava/lang/String;", "getViewRootClass", Const.INTENT_KEY_UMID, "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: w7.h$a, reason: from toString */
    public static final /* data */ class CreateResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final long effectId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final Drawable drawable;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String viewRootClass;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final String error;

        public CreateResult(long j10, Drawable drawable, String str, String str2) {
            this.effectId = j10;
            this.drawable = drawable;
            this.viewRootClass = str;
            this.error = str2;
        }

        /* renamed from: a, reason: from getter */
        public final Drawable getDrawable() {
            return this.drawable;
        }

        /* renamed from: b, reason: from getter */
        public final long getEffectId() {
            return this.effectId;
        }

        /* renamed from: c, reason: from getter */
        public final String getError() {
            return this.error;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreateResult)) {
                return false;
            }
            CreateResult createResult = (CreateResult) other;
            return this.effectId == createResult.effectId && p.d(this.drawable, createResult.drawable) && p.d(this.viewRootClass, createResult.viewRootClass) && p.d(this.error, createResult.error);
        }

        public int hashCode() {
            int iHashCode = Long.hashCode(this.effectId) * 31;
            Drawable drawable = this.drawable;
            int iHashCode2 = (iHashCode + (drawable == null ? 0 : drawable.hashCode())) * 31;
            String str = this.viewRootClass;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.error;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "CreateResult(effectId=" + this.effectId + ", drawable=" + this.drawable + ", viewRootClass=" + this.viewRootClass + ", error=" + this.error + ")";
        }
    }

    public final CreateResult a(View view, String shaderSrc) {
        p.i(view, "view");
        p.i(shaderSrc, "shaderSrc");
        try {
            Object objInvoke = View.class.getMethod("getViewRootImpl", null).invoke(view, null);
            if (objInvoke == null) {
                return new CreateResult(0L, null, null, "ViewRootImpl is null (not attached?)");
            }
            Object objInvoke2 = objInvoke.getClass().getMethod("createStepOSEffect", String.class).invoke(objInvoke, shaderSrc);
            p.g(objInvoke2, "null cannot be cast to non-null type kotlin.Long");
            Long l10 = (Long) objInvoke2;
            long jLongValue = l10.longValue();
            m.f40102a.d("SF", "createStepOSEffect -> id=" + jLongValue);
            if (jLongValue == 0) {
                return new CreateResult(0L, null, objInvoke.getClass().getName(), "effectId=0 (shader compile failed or effect disabled?)");
            }
            Object objInvoke3 = objInvoke.getClass().getMethod("createStepOSEffectDrawable", Long.TYPE).invoke(objInvoke, l10);
            return new CreateResult(jLongValue, objInvoke3 instanceof Drawable ? (Drawable) objInvoke3 : null, objInvoke.getClass().getName(), null);
        } catch (Throwable th) {
            m.f40102a.b("SF", "createFromView failed", th);
            return new CreateResult(0L, null, null, th.getClass().getSimpleName() + ": " + th.getMessage());
        }
    }
}
