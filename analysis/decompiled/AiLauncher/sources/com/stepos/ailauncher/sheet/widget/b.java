package com.stepos.ailauncher.sheet.widget;

import android.view.View;
import androidx.dynamicanimation.animation.e;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u0003J\r\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0011\u0010!\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/stepos/ailauncher/sheet/widget/b;", "", "<init>", "()V", "Landroid/view/View;", "target", "", "dy", "", "e", "(Landroid/view/View;F)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(F)F", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "view", Const.INTENT_KEY_UMID, "(Landroid/view/View;)F", "raw", "limit", Const.INTENT_KEY_PKGNAME, "(FF)F", "offset", "f", "Landroid/view/View;", "rawOffset", "F", "Landroidx/dynamicanimation/animation/i;", "springBack", "Landroidx/dynamicanimation/animation/i;", "c", "()Z", "isActive", "Companion", Const.INTENT_KEY_APIKEY, "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    private static final a Companion = new a(null);

    @Deprecated
    public static final float MAX_OFFSET_RATIO = 0.35f;

    @Deprecated
    public static final float REVERSE_GUARD = 0.99f;

    @Deprecated
    public static final float SPRING_BACK_STIFFNESS = 600.0f;

    @Deprecated
    public static final float TENSION = 1.0f;
    private float rawOffset;
    private androidx.dynamicanimation.animation.i springBack;
    private View target;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/sheet/widget/b$a;", "", "<init>", "()V", "", "MAX_OFFSET_RATIO", "F", "TENSION", "REVERSE_GUARD", "SPRING_BACK_STIFFNESS", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    public static final void h(View view, b bVar, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        if (z10) {
            return;
        }
        view.setTranslationY(0.0f);
        bVar.springBack = null;
        bVar.target = null;
    }

    public final float b(float raw, float limit) {
        float fAbs = (1.0f - (1.0f / (((Math.abs(raw) * 1.0f) / limit) + 1.0f))) * limit;
        return raw < 0.0f ? -fAbs : fAbs;
    }

    public final boolean c() {
        View view = this.target;
        return !((view != null ? view.getTranslationY() : 0.0f) == 0.0f);
    }

    public final float d(View view) {
        return view.getHeight() * 0.35f;
    }

    public final boolean e(View target, float dy) {
        kotlin.jvm.internal.p.i(target, "target");
        if (dy == 0.0f) {
            return false;
        }
        float fD = d(target);
        if (fD <= 0.0f) {
            return false;
        }
        if (this.target != target) {
            j();
            this.target = target;
        } else {
            androidx.dynamicanimation.animation.i iVar = this.springBack;
            if (iVar != null) {
                iVar.d();
                this.springBack = null;
                this.rawOffset = f(target.getTranslationY(), fD);
            }
        }
        float f10 = this.rawOffset + dy;
        this.rawOffset = f10;
        target.setTranslationY(b(f10, fD));
        return true;
    }

    public final float f(float offset, float limit) {
        float fI = C5685n.i(Math.abs(offset), 0.99f * limit);
        float f10 = ((fI / (limit - fI)) * limit) / 1.0f;
        return offset < 0.0f ? -f10 : f10;
    }

    public final void g() {
        final View view = this.target;
        if (view == null) {
            return;
        }
        this.rawOffset = 0.0f;
        if (view.getTranslationY() == 0.0f) {
            this.target = null;
            return;
        }
        androidx.dynamicanimation.animation.i iVar = this.springBack;
        if (iVar != null) {
            iVar.d();
        }
        androidx.dynamicanimation.animation.i iVar2 = new androidx.dynamicanimation.animation.i(view, androidx.dynamicanimation.animation.e.f13691o);
        iVar2.B(new androidx.dynamicanimation.animation.j(0.0f).f(1.0f).h(600.0f));
        iVar2.b(new e.q() { // from class: com.stepos.ailauncher.sheet.widget.a
            @Override // androidx.dynamicanimation.animation.e.q
            public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                b.h(view, this, eVar, z10, f10, f11);
            }
        });
        iVar2.t();
        this.springBack = iVar2;
    }

    public final float i(float dy) {
        View view;
        if (dy == 0.0f || (view = this.target) == null) {
            return 0.0f;
        }
        float translationY = view.getTranslationY();
        if (translationY != 0.0f) {
            if ((translationY > 0.0f) != (dy > 0.0f)) {
                float fD = d(view);
                if (fD <= 0.0f) {
                    return 0.0f;
                }
                androidx.dynamicanimation.animation.i iVar = this.springBack;
                if (iVar != null) {
                    iVar.d();
                    this.springBack = null;
                }
                float fE = translationY > 0.0f ? C5685n.e(dy + translationY, 0.0f) : C5685n.i(dy + translationY, 0.0f);
                view.setTranslationY(fE);
                if (fE == 0.0f) {
                    this.rawOffset = 0.0f;
                    this.target = null;
                } else {
                    this.rawOffset = f(fE, fD);
                }
                return fE - translationY;
            }
        }
        return 0.0f;
    }

    public final void j() {
        androidx.dynamicanimation.animation.i iVar = this.springBack;
        if (iVar != null) {
            iVar.d();
        }
        this.springBack = null;
        View view = this.target;
        if (view != null) {
            view.setTranslationY(0.0f);
        }
        this.target = null;
        this.rawOffset = 0.0f;
    }
}
