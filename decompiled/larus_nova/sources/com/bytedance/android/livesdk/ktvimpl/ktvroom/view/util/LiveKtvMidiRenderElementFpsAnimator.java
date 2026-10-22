package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.util;

import android.animation.ValueAnimator;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.liveinteract.f;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.r;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import ue2.c;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveKtvMidiRenderElementFpsAnimator extends ValueAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f145337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<ValueAnimator.AnimatorUpdateListener> f145338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f145339c;

    public @interface Method {
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f145340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveKtvMidiRenderElementFpsAnimator f145341b;

        public a(LiveKtvMidiRenderElementFpsAnimator r100) {
            this.f145341b = r100;
            this.f145340a = 0;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            long r101 = this.f145340a;
            LiveKtvMidiRenderElementFpsAnimator r102 = this.f145341b;
            if ((r101 % r102.f145337a) != 0) goto L9;
            ArrayList<ValueAnimator.AnimatorUpdateListener> r103 = r102.f145338b;
            if (r103 == null) goto L9;
            int r104 = r103.size();
            int r105 = 0;
        L7:
            if (r105 >= r104) goto L9;
            ((ValueAnimator.AnimatorUpdateListener) ListProtector.get(this.f145341b.f145338b, r105)).onAnimationUpdate(r100);
            r105 = r105 + 1;
        L9:
            this.f145340a++;
        }
    }

    public LiveKtvMidiRenderElementFpsAnimator() {
        this.f145337a = 1;
        this.f145338b = null;
        this.f145339c = new a(this);
        SettingKey<Integer> r100 = LiveInfraSettingKeys.LIVE_ANIMATOR_DEGRADE_FPS_OPT;
        if (((Integer) f.b(r100)).intValue() <= 0) goto L6;
        this.f145337a = ((Integer) f.b(r100)).intValue();
        return;
    }

    @Override // android.animation.ValueAnimator
    public final void removeAllUpdateListeners() {
        super.removeAllUpdateListeners();
        ArrayList<ValueAnimator.AnimatorUpdateListener> r100 = this.f145338b;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.clear();
        this.f145338b = null;
    }

    @Override // android.animation.ValueAnimator
    public final void addUpdateListener(ValueAnimator.AnimatorUpdateListener r100) {
        if (this.f145338b != null) goto L5;
        this.f145338b = new ArrayList();
        super.addUpdateListener(this.f145339c);
    L5:
        this.f145338b.add(r100);
    }

    @Override // android.animation.ValueAnimator
    public final void removeUpdateListener(ValueAnimator.AnimatorUpdateListener r100) {
        ArrayList<ValueAnimator.AnimatorUpdateListener> r101 = this.f145338b;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.remove(r100);
        if (this.f145338b.size() != 0) goto L9;
        super.removeUpdateListener(this.f145339c);
        this.f145338b = null;
        return;
    }

    public static LiveKtvMidiRenderElementFpsAnimator a(final r r100, final String r101, float... r102) {
        LiveKtvMidiRenderElementFpsAnimator r103 = new LiveKtvMidiRenderElementFpsAnimator();
        r103.setFloatValues(r102);
        r103.addUpdateListener(new c(r100, r101));
        return r103;
    }
}
