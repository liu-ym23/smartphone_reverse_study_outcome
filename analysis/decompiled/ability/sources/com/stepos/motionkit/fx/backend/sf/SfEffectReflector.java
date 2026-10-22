package com.stepos.motionkit.fx.backend.sf;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.MKLog;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/motionkit/fx/backend/sf/SfEffectReflector;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "createFromView", "Lcom/stepos/motionkit/fx/backend/sf/SfEffectReflector$CreateResult;", "view", "Landroid/view/View;", "shaderSrc", "CreateResult", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SfEffectReflector {
    public static final SfEffectReflector INSTANCE = new SfEffectReflector();
    private static final String TAG = "SF";

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/stepos/motionkit/fx/backend/sf/SfEffectReflector$CreateResult;", "", "effectId", "", "drawable", "Landroid/graphics/drawable/Drawable;", "viewRootClass", "", "error", AppAgent.CONSTRUCT, "(JLandroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)V", "getEffectId", "()J", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getViewRootClass", "()Ljava/lang/String;", "getError", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class CreateResult {
        private final Drawable drawable;
        private final long effectId;
        private final String error;
        private final String viewRootClass;

        public CreateResult(long j5, Drawable drawable, String str, String str2) {
            this.effectId = j5;
            this.drawable = drawable;
            this.viewRootClass = str;
            this.error = str2;
        }

        public static /* synthetic */ CreateResult copy$default(CreateResult createResult, long j5, Drawable drawable, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                j5 = createResult.effectId;
            }
            long j6 = j5;
            if ((i & 2) != 0) {
                drawable = createResult.drawable;
            }
            Drawable drawable2 = drawable;
            if ((i & 4) != 0) {
                str = createResult.viewRootClass;
            }
            String str3 = str;
            if ((i & 8) != 0) {
                str2 = createResult.error;
            }
            return createResult.copy(j6, drawable2, str3, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getEffectId() {
            return this.effectId;
        }

        /* renamed from: component2, reason: from getter */
        public final Drawable getDrawable() {
            return this.drawable;
        }

        /* renamed from: component3, reason: from getter */
        public final String getViewRootClass() {
            return this.viewRootClass;
        }

        /* renamed from: component4, reason: from getter */
        public final String getError() {
            return this.error;
        }

        public final CreateResult copy(long effectId, Drawable drawable, String viewRootClass, String error) {
            return new CreateResult(effectId, drawable, viewRootClass, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreateResult)) {
                return false;
            }
            CreateResult createResult = (CreateResult) other;
            return this.effectId == createResult.effectId && k.b(this.drawable, createResult.drawable) && k.b(this.viewRootClass, createResult.viewRootClass) && k.b(this.error, createResult.error);
        }

        public final Drawable getDrawable() {
            return this.drawable;
        }

        public final long getEffectId() {
            return this.effectId;
        }

        public final String getError() {
            return this.error;
        }

        public final String getViewRootClass() {
            return this.viewRootClass;
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
            long j5 = this.effectId;
            Drawable drawable = this.drawable;
            String str = this.viewRootClass;
            String str2 = this.error;
            StringBuilder sb = new StringBuilder("CreateResult(effectId=");
            sb.append(j5);
            sb.append(", drawable=");
            sb.append(drawable);
            a.A(sb, ", viewRootClass=", str, ", error=", str2);
            sb.append(")");
            return sb.toString();
        }
    }

    private SfEffectReflector() {
    }

    public final CreateResult createFromView(View view, String shaderSrc) {
        k.f(view, "view");
        k.f(shaderSrc, "shaderSrc");
        try {
            Object objInvoke = View.class.getMethod("getViewRootImpl", null).invoke(view, null);
            if (objInvoke == null) {
                return new CreateResult(0L, null, null, "ViewRootImpl is null (not attached?)");
            }
            Object objInvoke2 = objInvoke.getClass().getMethod("createStepOSEffect", String.class).invoke(objInvoke, shaderSrc);
            k.d(objInvoke2, "null cannot be cast to non-null type kotlin.Long");
            Long l = (Long) objInvoke2;
            long jLongValue = l.longValue();
            MKLog.INSTANCE.i("SF", "createStepOSEffect -> id=" + jLongValue);
            if (jLongValue == 0) {
                return new CreateResult(0L, null, objInvoke.getClass().getName(), "effectId=0 (shader compile failed or effect disabled?)");
            }
            Object objInvoke3 = objInvoke.getClass().getMethod("createStepOSEffectDrawable", Long.TYPE).invoke(objInvoke, l);
            return new CreateResult(jLongValue, objInvoke3 instanceof Drawable ? (Drawable) objInvoke3 : null, objInvoke.getClass().getName(), null);
        } catch (Throwable th) {
            MKLog.INSTANCE.e("SF", "createFromView failed", th);
            return new CreateResult(0L, null, null, B7.a.B(th.getClass().getSimpleName(), ": ", th.getMessage()));
        }
    }
}
