package com.stepos.agentframework.screeneffect;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 02\u00020\u0001:\u00021\fJ/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\rJ\u000f\u0010\u0004\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0004\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u001cR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010&\u001a\u00020%8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/stepos/agentframework/screeneffect/b;", "Lcom/stepos/agentframework/screeneffect/f;", "", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "LY8/t;", "onSizeChanged", "(IIII)V", "", "timeValue", Const.INTENT_KEY_PKGNAME, "(F)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "width", "height", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(II)V", "", "randomPosition", "f", "(IIZ)V", "time", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()V", "k", "", "Lcom/stepos/agentframework/screeneffect/b$b;", "particles", "Ljava/util/List;", "Landroid/graphics/Paint;", "particlePaint", "Landroid/graphics/Paint;", "", "currentMixColor", "[F", "getCurrentMixColor", "()[F", "", "lastEmissionTime", "J", "Lkotlin/random/Random;", "random", "Lkotlin/random/Random;", "Companion", Const.INTENT_KEY_APIKEY, "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public class b extends f {
    private static final float MIX_COLOR = 0.25f;
    private static final float MIX_COLOR_R = 0.75f;
    private static final int PARTICLE_COUNT = 80;
    private static final int PARTICLE_EMISSION_RATE = 8;
    private static final float PARTICLE_LIFETIME_MAX = 3.0f;
    private static final float PARTICLE_LIFETIME_MIN = 1.5f;
    private static final float PARTICLE_SIZE_MAX = 4.0f;
    private static final float PARTICLE_SIZE_MIN = 1.5f;
    private static final float PARTICLE_SPEED_MAX = 2.5f;
    private static final float PARTICLE_SPEED_MIN = 0.8f;
    private static final int PARTICLE_SPREAD_ANGLE = 35;
    private static final float VERTICAL_SPEED_RATIO = 0.45f;
    private final float[] currentMixColor;
    private long lastEmissionTime;
    private final Paint particlePaint;
    private final List<C0255b> particles;
    private final Random random;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u001a\b\u0002\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/stepos/agentframework/screeneffect/b$b;", "", "", "x", "y", "velocityX", "velocityY", ContentDisposition.Parameters.Size, "lifetime", "maxLifetime", "", "currentColor", "<init>", "(FFFFFFF[F)V", "F", Const.INTENT_KEY_BACKGROUND_COMMAND, "()F", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(F)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "k", "e", "setVelocityX", "f", "setVelocityY", Const.INTENT_KEY_UMID, "setSize", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "c", "setMaxLifetime", "[F", Const.INTENT_KEY_APIKEY, "()[F", "setCurrentColor", "([F)V", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.screeneffect.b$b, reason: collision with other inner class name */
    public static final class C0255b {
        private float[] currentColor;
        private float lifetime;
        private float maxLifetime;
        private float size;
        private float velocityX;
        private float velocityY;
        private float x;
        private float y;

        public C0255b(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float[] currentColor) {
            p.i(currentColor, "currentColor");
            this.x = f10;
            this.y = f11;
            this.velocityX = f12;
            this.velocityY = f13;
            this.size = f14;
            this.lifetime = f15;
            this.maxLifetime = f16;
            this.currentColor = currentColor;
        }

        /* renamed from: a, reason: from getter */
        public final float[] getCurrentColor() {
            return this.currentColor;
        }

        /* renamed from: b, reason: from getter */
        public final float getLifetime() {
            return this.lifetime;
        }

        /* renamed from: c, reason: from getter */
        public final float getMaxLifetime() {
            return this.maxLifetime;
        }

        /* renamed from: d, reason: from getter */
        public final float getSize() {
            return this.size;
        }

        /* renamed from: e, reason: from getter */
        public final float getVelocityX() {
            return this.velocityX;
        }

        /* renamed from: f, reason: from getter */
        public final float getVelocityY() {
            return this.velocityY;
        }

        /* renamed from: g, reason: from getter */
        public final float getX() {
            return this.x;
        }

        /* renamed from: h, reason: from getter */
        public final float getY() {
            return this.y;
        }

        public final void i(float f10) {
            this.lifetime = f10;
        }

        public final void j(float f10) {
            this.x = f10;
        }

        public final void k(float f10) {
            this.y = f10;
        }
    }

    public static /* synthetic */ void g(b bVar, int i10, int i11, boolean z10, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createParticle");
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        bVar.f(i10, i11, z10);
    }

    @Override // com.stepos.agentframework.screeneffect.f
    public void b(float timeValue) {
        super.b(timeValue);
        j(timeValue);
        h();
        k();
    }

    public final void f(int width, int height, boolean randomPosition) {
        float fE = (randomPosition ? this.random.e() : this.random.e()) * width;
        float fE2 = randomPosition ? this.random.e() * height : height;
        double dE = (-1.5707964f) + ((this.random.e() - 0.5f) * 0.6108652381980153d);
        double dE2 = (this.random.e() * 1.7f) + 0.8f;
        double dCos = Math.cos(dE) * dE2;
        double dSin = Math.sin(dE) * dE2 * VERTICAL_SPEED_RATIO;
        float fE3 = (this.random.e() * 2.5f) + 1.5f;
        float fE4 = (this.random.e() * 1.5f) + 1.5f;
        float[] fArr = this.currentMixColor;
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        p.h(fArrCopyOf, "copyOf(...)");
        this.particles.add(new C0255b(fE, fE2, (float) dCos, (float) dSin, fE3, randomPosition ? this.random.e() * fE4 : fE4, fE4, new float[]{Math.min(1.0f, (fArrCopyOf[0] * 0.25f) + 0.75f), Math.min(1.0f, (fArrCopyOf[1] * 0.25f) + 0.75f), Math.min(1.0f, (fArrCopyOf[2] * 0.25f) + 0.75f), fArrCopyOf[3]}));
    }

    public final float[] getCurrentMixColor() {
        return this.currentMixColor;
    }

    public final void h() {
        b bVar;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastEmissionTime > 16) {
            int i10 = 0;
            while (i10 < 8) {
                if (this.particles.size() < 80) {
                    bVar = this;
                    g(bVar, this.getWidth(), this.getHeight(), false, 4, null);
                } else {
                    bVar = this;
                }
                i10++;
                this = bVar;
            }
            this.lastEmissionTime = jCurrentTimeMillis;
        }
    }

    public final void i(int width, int height) {
        this.particles.clear();
        for (int i10 = 0; i10 < 80; i10++) {
            f(width, height, true);
        }
    }

    public final void j(float time) {
        float fSin = (((float) Math.sin(getColor_change_speed() * time)) + 1.0f) * 0.5f;
        float fSin2 = (((float) Math.sin((getColor_change_speed() * time) + 2.094f)) + 1.0f) * 0.5f;
        float fSin3 = (((float) Math.sin((time * getColor_change_speed()) + 4.188f)) + 1.0f) * 0.5f;
        float f10 = fSin + fSin2 + fSin3;
        float f11 = fSin / f10;
        float f12 = fSin2 / f10;
        float f13 = fSin3 / f10;
        this.currentMixColor[0] = (getColor1()[0] * f11) + (getColor2()[0] * f12) + (getColor3()[0] * f13);
        this.currentMixColor[1] = (getColor1()[1] * f11) + (getColor2()[1] * f12) + (getColor3()[1] * f13);
        this.currentMixColor[2] = (getColor1()[2] * f11) + (getColor2()[2] * f12) + (getColor3()[2] * f13);
        this.currentMixColor[3] = 1.0f;
    }

    public final void k() {
        int i10;
        ArrayList arrayList = new ArrayList();
        Iterator<C0255b> it = this.particles.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C0255b next = it.next();
            next.j(next.getX() + next.getVelocityX());
            next.k(next.getY() + next.getVelocityY());
            next.i(next.getLifetime() - 0.016f);
            boolean z10 = next.getY() <= getRectY() + getRectHeight() && next.getY() >= getRectY() && next.getX() >= getRectX() && next.getX() <= getRectX() + getRectWidth();
            if (next.getLifetime() <= 0.0f || next.getY() < (-next.getSize()) || next.getY() > getHeight() + next.getSize() || next.getX() < (-next.getSize()) || next.getX() > getWidth() + next.getSize() || z10) {
                arrayList.add(next);
            } else {
                next.getCurrentColor()[0] = Math.min(1.0f, (this.currentMixColor[0] * 0.25f) + 0.75f);
                next.getCurrentColor()[1] = Math.min(1.0f, (this.currentMixColor[1] * 0.25f) + 0.75f);
                next.getCurrentColor()[2] = Math.min(1.0f, (this.currentMixColor[2] * 0.25f) + 0.75f);
                next.getCurrentColor()[3] = (next.getLifetime() / next.getMaxLifetime()) * 0.8f;
            }
        }
        this.particles.removeAll(arrayList);
        int size = 80 - this.particles.size();
        if (size > 0) {
            for (i10 = 0; i10 < size; i10++) {
                g(this, getWidth(), getHeight(), false, 4, null);
            }
        }
    }

    @Override // com.stepos.agentframework.screeneffect.f, android.view.View
    public void onDraw(Canvas canvas) {
        p.i(canvas, "canvas");
        super.onDraw(canvas);
        for (C0255b c0255b : this.particles) {
            float f10 = 255;
            this.particlePaint.setColor(Color.argb((int) (c0255b.getCurrentColor()[3] * f10), (int) (c0255b.getCurrentColor()[0] * f10), (int) (c0255b.getCurrentColor()[1] * f10), (int) (c0255b.getCurrentColor()[2] * f10)));
            canvas.drawCircle(c0255b.getX(), c0255b.getY(), c0255b.getSize(), this.particlePaint);
        }
    }

    @Override // com.stepos.agentframework.screeneffect.f, android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        i(w10, h10);
    }
}
