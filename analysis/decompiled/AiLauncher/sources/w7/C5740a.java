package w7;

import Z8.F;
import android.animation.Animator;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import s7.m;
import v7.s;
import w7.h;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0014\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0014\u001a\u00020\u00062\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0003R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010!R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010,R\u0016\u0010.\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010$R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u00100¨\u00062"}, d2 = {"Lw7/a;", "Lv7/s;", "<init>", "()V", "Landroid/view/View;", "view", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroid/view/View;)V", "", "agsl", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "", x5.d.EXTRA_ENABLED, "e", "(Z)V", "", "", "uniforms", Const.INTENT_KEY_APIKEY, "(Ljava/util/Map;)V", "start", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Landroid/view/View;", "targetView", "Ljava/lang/String;", "shaderSrc", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "effectDrawable", "", "J", "effectId", "previousBackground", "", "f", "F", "fadeAlpha", "Landroid/animation/Animator;", "Landroid/animation/Animator;", "stopAnimator", "startTimeMs", "", "I", "debugFrameCount", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: w7.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5740a implements s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public View targetView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Drawable effectDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public long effectId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public Drawable previousBackground;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public Animator stopAnimator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public long startTimeMs;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public int debugFrameCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public String shaderSrc = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public float fadeAlpha = 1.0f;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"w7/a$b", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: w7.a$b */
    public static final class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            p.i(v10, "v");
            v10.removeOnAttachStateChangeListener(this);
            C5740a.this.g();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            p.i(v10, "v");
        }
    }

    @Override // v7.s
    public void a(Map<String, float[]> uniforms) {
        p.i(uniforms, "uniforms");
        Drawable drawable = this.effectDrawable;
        if (drawable == null) {
            return;
        }
        View view = this.targetView;
        if (view != null && view.getWidth() > 0 && view.getHeight() > 0) {
            float width = view.getWidth();
            float height = view.getHeight();
            g gVar = g.f43114a;
            gVar.s(drawable, "resolution", width, height);
            gVar.s(drawable, "iResolution", width, height);
            gVar.s(drawable, "textureSize", width, height);
            gVar.r(drawable, "aspect", width / height);
        }
        float fCurrentTimeMillis = (System.currentTimeMillis() - this.startTimeMs) / 1000.0f;
        g gVar2 = g.f43114a;
        gVar2.r(drawable, "iTime", fCurrentTimeMillis);
        gVar2.w(drawable, "enable", 1);
        for (Map.Entry<String, float[]> entry : uniforms.entrySet()) {
            String key = entry.getKey();
            float[] value = entry.getValue();
            int length = value.length;
            if (length == 1) {
                g.f43114a.v(drawable, key, value[0]);
            } else if (length == 2) {
                g.f43114a.s(drawable, key, value[0], value[1]);
            } else if (length == 3) {
                g.f43114a.t(drawable, key, value[0], value[1], value[2]);
            } else if (length == 4) {
                g.f43114a.u(drawable, key, value[0], value[1], value[2], value[3]);
            }
        }
        g.f43114a.r(drawable, "fadeAlpha", this.fadeAlpha);
        drawable.invalidateSelf();
        int i10 = this.debugFrameCount + 1;
        this.debugFrameCount = i10;
        if (i10 <= 3 || i10 % 60 == 0) {
            String strA0 = F.A0(uniforms.keySet(), null, null, null, 0, null, null, 63, null);
            String str = (view != null ? Integer.valueOf(view.getWidth()) : null) + "x" + (view != null ? Integer.valueOf(view.getHeight()) : null);
            m mVar = m.f40102a;
            String str2 = String.format("submitUniforms frame=" + this.debugFrameCount + " res=" + str + " t=%.2f keys=[" + strA0 + "]", Arrays.copyOf(new Object[]{Float.valueOf(fCurrentTimeMillis)}, 1));
            p.h(str2, "format(...)");
            mVar.a("SF", str2);
        }
    }

    @Override // v7.s
    public void b(String agsl) {
        p.i(agsl, "agsl");
        if (agsl.length() > 0) {
            this.shaderSrc = agsl;
        }
    }

    @Override // v7.s
    public void c() {
        Animator animator = this.stopAnimator;
        if (animator != null) {
            animator.cancel();
        }
        j();
    }

    @Override // v7.s
    public void d(View view) {
        p.i(view, "view");
        this.targetView = view;
    }

    @Override // v7.s
    public void e(boolean enabled) {
        m.f40102a.a("SF", "setBackgroundSampling=" + enabled);
    }

    public final void g() {
        View view = this.targetView;
        if (view == null) {
            return;
        }
        h.CreateResult createResultA = h.f43122a.a(view, this.shaderSrc);
        this.effectId = createResultA.getEffectId();
        this.effectDrawable = createResultA.getDrawable();
        if (createResultA.getError() != null || this.effectDrawable == null || this.effectId == 0) {
            m.c(m.f40102a, "SF", "createEffect failed: " + createResultA.getError() + " effectId=" + this.effectId, null, 4, null);
            j();
            return;
        }
        this.previousBackground = view.getBackground();
        view.setBackground(this.effectDrawable);
        Drawable drawable = this.effectDrawable;
        if (drawable != null) {
            drawable.setVisible(true, true);
        }
        i();
        m.f40102a.d("SF", "createEffect OK effectId=" + this.effectId + " bounds=" + view.getWidth() + "x" + view.getHeight());
    }

    public final void h() {
        View view = this.targetView;
        if (view == null) {
            return;
        }
        if (!g.f43114a.l()) {
            m.c(m.f40102a, "SF", "SF effect drawable class not found on classpath", null, 4, null);
            return;
        }
        if (this.shaderSrc.length() == 0) {
            m.c(m.f40102a, "SF", "no shader source submitted", null, 4, null);
            return;
        }
        Animator animator = this.stopAnimator;
        if (animator != null) {
            animator.cancel();
        }
        if (this.effectDrawable != null) {
            j();
        }
        this.fadeAlpha = 1.0f;
        this.startTimeMs = System.currentTimeMillis();
        this.debugFrameCount = 0;
        if (view.isAttachedToWindow()) {
            g();
        } else {
            view.addOnAttachStateChangeListener(new b());
        }
    }

    public final void i() {
        Drawable drawable;
        View view = this.targetView;
        if (view != null && (drawable = this.effectDrawable) != null && view.getWidth() > 0 && view.getHeight() > 0) {
            drawable.setBounds(0, 0, view.getWidth(), view.getHeight());
        }
    }

    public final void j() {
        Drawable drawable = this.effectDrawable;
        if (drawable != null) {
            drawable.setVisible(false, true);
            drawable.setCallback(null);
        }
        View view = this.targetView;
        if (view != null && view.getBackground() == this.effectDrawable) {
            view.setBackground(this.previousBackground);
        }
        this.effectDrawable = null;
        this.previousBackground = null;
        this.effectId = 0L;
    }

    @Override // v7.s
    public void start() {
        h();
    }
}
