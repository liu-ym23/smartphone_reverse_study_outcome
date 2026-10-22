package b29;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common_ui.widget.input.audiowave.AudioWaveGroup;
import com.larus.common_ui.widget.input.audiowave.AudioWaveView;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioWaveView f17092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimatorSet f17093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f17094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17095d;

    /* JADX INFO: renamed from: b29.a$a, reason: collision with other inner class name */
    public static final class C0253a {
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f17096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f17097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Float> f17098c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f17097b.f17093b = null;
            FLogger.f375446a.i("WaveAnim", "[Round#" + this.f17096a.element + "]: " + r100.hashCode() + "#onAnimationCancel");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            a r101 = this.f17097b;
            r101.f17093b = null;
            if (r101.f17095d != 1) goto L5;
            boolean r102 = true;
        L6:
            FLogger.f375446a.i("WaveAnim", "[Round#" + this.f17096a.element + "]: " + r100.hashCode() + "#onAnimationEnd[stop:" + r102 + ']');
            if (r102 == false) goto L9;
            return;
        L9:
            a r103 = this.f17097b;
            r103.b(r103.f17092a, this.f17098c.invoke().floatValue(), this);
            this.f17096a.element++;
            return;
        L5:
            r102 = false;
            goto L6
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            FLogger.f375446a.i("WaveAnim", "[Round#" + this.f17096a.element + "]: " + r100.hashCode() + "#onAnimationRepeat");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            FLogger.f375446a.i("WaveAnim", "[Round#" + this.f17096a.element + "]:onAnimationStart#" + r100.hashCode());
        }

        public b(Ref.IntRef r100, a r101, Function0<Float> r102) {
            this.f17096a = r100;
            this.f17097b = r101;
            this.f17098c = r102;
        }
    }

    static {
    }

    public a(AudioWaveView r100) {
        Intrinsics.checkNotNullParameter(r100, "waveView");
        this.f17092a = r100;
        this.f17094c = new c(0);
        this.f17095d = 1;
    }

    public final void a(Function0<Float> r100) {
        Intrinsics.checkNotNullParameter(r100, "getAmplitude");
        if (this.f17095d != 0) goto L6;
        FLogger.f375446a.i("WaveAnim", "startAnim, already started");
        return;
    L6:
        this.f17095d = 0;
        b r101 = new b(new Ref.IntRef(), this, r100);
        b(this.f17092a, r100.invoke().floatValue(), r101);
    }

    public final AnimatorSet b(AudioWaveView r210, float r211, Animator.AnimatorListener r212) {
        c r100 = this.f17094c;
        List<AudioWaveGroup> r101 = r210.getAudioWaveGroupList();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "audioWaveGroups");
        r100.f17099a = CollectionsKt.toList(r101);
        r100.f17101c = r101.size() / 2;
        c r102 = this.f17094c;
        int r103 = r102.f17102d;
        int r104 = -1;
        if (r103 != (-1)) goto L5;
        int r105 = r102.f17101c;
        int r106 = r105 - 1;
    L6:
        int r107 = 1;
        int r108 = r105 + 1;
        int r109 = ((Random) r102.f17100b.getValue()).nextInt(r106, r108 + 1);
        r102.f17102d = r109;
        FLogger.f375446a.i("WaveCalc", "NextTopGroup: " + r109 + ", [" + r106 + ", " + r108 + ']');
        List<AudioWaveGroup> r110 = r102.f17099a;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator<T> r112 = r110.iterator();
        int r113 = 0;
    L8:
        if (r112.hasNext() == false) goto L51;
        Object r114 = r112.next();
        int r115 = r113 + 1;
        if (r113 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        AudioWaveGroup r116 = (AudioWaveGroup) r114;
        if (r113 != r102.f17102d) goto L15;
        long r117 = 0;
    L27:
        if (r113 != r102.f17102d) goto L29;
        float r118 = 1.0f;
    L36:
        int r119 = ((AudioWaveGroup) ListProtector.get(r102.f17099a, r113)).f328683b;
        int r120 = r119 / 2;
        int r121 = ((Random) r102.f17100b.getValue()).nextInt(r120 - 1, r120 + r107);
        float[] r122 = new float[r119];
        int r123 = 0;
    L37:
        if (r123 >= r119) goto L47;
        if (r123 != r121) goto L41;
        float r124 = 1.0f;
    L46:
        r122[r123] = r124;
        r123 = r123 + 1;
        goto L37
    L41:
        if (r123 >= (r121 - 1)) goto L43;
    L45:
        r124 = 0.49f;
        goto L46
    L43:
        if (r123 > (r121 + 1)) goto L45;
        r124 = 0.7f;
        goto L46
    L47:
        float r125 = r116.f328687f * r118;
        int r126 = r116.f328688g;
        int[] r127 = new int[r119];
        int r128 = 0;
    L48:
        if (r128 >= r119) goto L50;
        float r129 = r126;
        r127[r128] = (int) (r129 + (((r125 - r129) * r211) * r122[r128]));
        r128 = r128 + 1;
        goto L48
    L50:
        r111.add(new c.a.C0254a(r117, r127));
        r113 = r115;
        r104 = -1;
        r107 = 1;
        goto L8
    L29:
        if (r113 != 0) goto L31;
    L34:
        float r130 = ((Random) r102.f17100b.getValue()).nextFloat() * 0.1f;
        float r131 = 0.4f;
    L35:
        r118 = r130 + r131;
        goto L36
    L31:
        if (r113 == (r102.f17099a.size() + r104)) goto L34;
        r130 = ((Random) r102.f17100b.getValue()).nextFloat() * 0.2f;
        r131 = 0.6f;
        goto L35
    L15:
        int r132 = r102.f17101c;
        if (r113 >= (r132 - 1)) goto L18;
    L20:
        if (r113 != 0) goto L22;
    L25:
        r117 = 150;
        goto L27
    L22:
        if (r113 == (r102.f17099a.size() + r104)) goto L25;
        r117 = 100;
        goto L27
    L18:
        if (r113 > (r132 + 1)) goto L20;
        r117 = 50;
        goto L27
    L51:
        AnimatorSet r133 = this.f17093b;
        if (r133 == null) goto L54;
        r133.cancel();
    L54:
        List<AudioWaveGroup> r134 = r210.getAudioWaveGroupList();
        ArrayList r135 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r134, 10));
        Iterator<T> r136 = r134.iterator();
        int r137 = 0;
    L56:
        if (r136.hasNext() == false) goto L61;
        Object r138 = r136.next();
        int r139 = r137 + 1;
        if (r137 >= 0) goto L60;
        CollectionsKt.throwIndexOverflow();
    L60:
        AudioWaveGroup r140 = (AudioWaveGroup) r138;
        int r141 = Integer.valueOf(r137).intValue();
        Intrinsics.checkNotNullParameter(r140, "<unused var>");
        c.a.C0254a r142 = (c.a.C0254a) ListProtector.get(r111, r141);
        ObjectAnimator r143 = ObjectAnimator.ofObject(r140, "waveBarHeights", new d(), new Object[]{r140.a(), r142.f17105c, r140.f328689h});
        r143.setDuration(r142.f17104b);
        r143.setStartDelay(r142.f17103a);
        r135.add(r143);
        r137 = r139;
        goto L56
    L61:
        AnimatorSet r144 = new AnimatorSet();
        r144.playTogether(r135);
        r144.addListener(r212);
        r144.start();
        this.f17093b = r144;
        return r144;
    L5:
        r106 = Math.max(r102.f17101c, r103) - 1;
        r105 = Math.min(r102.f17101c, r102.f17102d);
        goto L6
    }
}
