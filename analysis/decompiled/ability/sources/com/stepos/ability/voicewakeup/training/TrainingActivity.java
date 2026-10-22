package com.stepos.ability.voicewakeup.training;

import A6.g;
import A6.n;
import C4.f;
import C4.h;
import H4.j;
import H4.m;
import H4.o;
import H4.t;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LifecycleOwnerKt;
import android.view.OnBackPressedDispatcherKt;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.R;
import com.stepos.ability.voicewakeup.training.TrainingActivity;
import com.stepos.ability.voicewakeup.ui.TrainingPhraseCarousel;
import com.stepos.ability.voicewakeup.ui.WakeupPagAnimation;
import com.stepos.ability.voicewakeup.ui.d;
import com.stepos.aiengine.algorithm.highlight.HighlightCallback;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import com.stepos.widget.glass.StepOSGlassImageButton;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.q0;
import org.libpag.PAGView;
import z2.l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/stepos/ability/voicewakeup/training/TrainingActivity;", "LJ4/a;", AppAgent.CONSTRUCT, "()V", "RoundFeedback", "voicewakeup_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TrainingActivity extends J4.a {

    /* renamed from: M, reason: collision with root package name */
    public static final /* synthetic */ int f3357M = 0;

    /* renamed from: A, reason: collision with root package name */
    public Long f3358A;

    /* renamed from: B, reason: collision with root package name */
    public q0 f3359B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f3360C;

    /* renamed from: D, reason: collision with root package name */
    public g f3361D;
    public MediaPlayer E;

    /* renamed from: F, reason: collision with root package name */
    public volatile boolean f3362F;

    /* renamed from: G, reason: collision with root package name */
    public volatile boolean f3363G;

    /* renamed from: a, reason: collision with root package name */
    public TextView f3365a;
    public TextView b;
    public d c;
    public View d;
    public TextView e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public TrainingPhraseCarousel i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f3366j;
    public View k;
    public b l;
    public f m;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3368r;
    public C4.g u;

    /* renamed from: v, reason: collision with root package name */
    public ByteBuffer f3371v;

    /* renamed from: x, reason: collision with root package name */
    public int f3373x;

    /* renamed from: z, reason: collision with root package name */
    public boolean f3374z;
    public final C7.f n = kotlin.a.a(new H4.f(this, 1));
    public final C7.f o = kotlin.a.a(new H4.f(this, 2));
    public final C7.f p = kotlin.a.a(new Ba.a(25));

    /* renamed from: q, reason: collision with root package name */
    public final C7.f f3367q = kotlin.a.a(new H4.f(this, 3));

    /* renamed from: s, reason: collision with root package name */
    public final t f3369s = new t();

    /* renamed from: t, reason: collision with root package name */
    public final kotlinx.coroutines.sync.a f3370t = new kotlinx.coroutines.sync.a();

    /* renamed from: w, reason: collision with root package name */
    public String f3372w = "";
    public RoundFeedback y = RoundFeedback.f3375a;

    /* renamed from: L, reason: collision with root package name */
    public final C7.f f3364L = kotlin.a.a(new H4.f(this, 4));

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/ability/voicewakeup/training/TrainingActivity$RoundFeedback;", "", "voicewakeup_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class RoundFeedback {

        /* renamed from: a, reason: collision with root package name */
        public static final RoundFeedback f3375a;
        public static final RoundFeedback b;
        public static final RoundFeedback c;
        public static final /* synthetic */ RoundFeedback[] d;

        static {
            RoundFeedback roundFeedback = new RoundFeedback("NONE", 0);
            f3375a = roundFeedback;
            RoundFeedback roundFeedback2 = new RoundFeedback("SUCCESS", 1);
            b = roundFeedback2;
            RoundFeedback roundFeedback3 = new RoundFeedback("FAILURE", 2);
            c = roundFeedback3;
            RoundFeedback[] roundFeedbackArr = {roundFeedback, roundFeedback2, roundFeedback3};
            d = roundFeedbackArr;
            kotlin.enums.a.a(roundFeedbackArr);
        }

        public static RoundFeedback valueOf(String str) {
            return (RoundFeedback) Enum.valueOf(RoundFeedback.class, str);
        }

        public static RoundFeedback[] values() {
            return (RoundFeedback[]) d.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.voicewakeup.training.TrainingActivity$onCreate$5, reason: invalid class name */
    final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements S7.a {
        /* JADX WARN: Removed duplicated region for block: B:32:0x0072  */
        @Override // S7.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invoke() {
            /*
                r5 = this;
                java.lang.Object r5 = r5.receiver
                com.stepos.ability.voicewakeup.training.TrainingActivity r5 = (com.stepos.ability.voicewakeup.training.TrainingActivity) r5
                int r0 = com.stepos.ability.voicewakeup.training.TrainingActivity.f3357M
                boolean r0 = r5.isFinishing()
                if (r0 != 0) goto L7d
                boolean r0 = r5.isDestroyed()
                if (r0 == 0) goto L13
                goto L7d
            L13:
                java.lang.String r0 = "training interrupted by call"
                java.lang.String r1 = "TrainingActivity"
                android.util.Log.i(r1, r0)
                r0 = 1
                r5.f3363G = r0
                r2 = 0
                r5.f3360C = r2
                com.stepos.ability.voicewakeup.training.b r3 = r5.l
                if (r3 == 0) goto L29
                com.stepos.ability.voicewakeup.training.c r3 = r3.c
                r3.f()
            L29:
                r5.C(r2)
                com.stepos.ability.voicewakeup.training.a r3 = r5.t()
                r3.a()
                m9.q0 r3 = r5.f3359B
                r4 = 0
                if (r3 == 0) goto L3b
                r3.cancel(r4)
            L3b:
                A6.g r3 = r5.f3361D
                if (r3 == 0) goto L42
                r3.dismiss()
            L42:
                r5.f3361D = r4
                boolean r3 = r5.f3368r
                if (r3 == 0) goto L77
                C7.f r3 = r5.f3367q     // Catch: java.lang.Throwable -> L67
                java.lang.Object r3 = r3.getF4884a()     // Catch: java.lang.Throwable -> L67
                H4.m r3 = (H4.m) r3     // Catch: java.lang.Throwable -> L67
                boolean r4 = r3.b     // Catch: java.lang.Throwable -> L67
                if (r4 != 0) goto L55
                goto L61
            L55:
                M0.k r4 = r3.f745a     // Catch: java.lang.Throwable -> L67
                int r4 = r4.abandonFocus()     // Catch: java.lang.Throwable -> L67
                if (r4 != r0) goto L5f
                r3.b = r2     // Catch: java.lang.Throwable -> L67
            L5f:
                if (r4 != r0) goto L62
            L61:
                r2 = r0
            L62:
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L67
                goto L6c
            L67:
                r2 = move-exception
                kotlin.Result$Failure r2 = kotlin.b.a(r2)
            L6c:
                java.lang.Throwable r2 = kotlin.Result.a(r2)
                if (r2 == 0) goto L77
                java.lang.String r3 = "abandon session audio focus failed"
                android.util.Log.w(r1, r3, r2)
            L77:
                r5.setResult(r0)
                r5.finish()
            L7d:
                C7.r r5 = C7.r.f317a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.TrainingActivity.AnonymousClass5.invoke():java.lang.Object");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ae, code lost:
    
        if (r11 != r1) goto L54;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.stepos.ability.voicewakeup.training.TrainingActivity] */
    /* JADX WARN: Type inference failed for: r3v3, types: [w9.a] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00ae -> B:54:0x00b1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object q(com.stepos.ability.voicewakeup.training.TrainingActivity r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof com.stepos.ability.voicewakeup.training.TrainingActivity$loopRounds$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.ability.voicewakeup.training.TrainingActivity$loopRounds$1 r0 = (com.stepos.ability.voicewakeup.training.TrainingActivity$loopRounds$1) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            com.stepos.ability.voicewakeup.training.TrainingActivity$loopRounds$1 r0 = new com.stepos.ability.voicewakeup.training.TrainingActivity$loopRounds$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.f
            r3 = 3
            r4 = 2
            r5 = 1
            C7.r r6 = C7.r.f317a
            r7 = 5
            r8 = 0
            if (r2 == 0) goto L4f
            if (r2 == r5) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            kotlin.b.b(r11)
            goto Lb1
        L32:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3a:
            w9.a r10 = r0.b
            kotlin.b.b(r11)     // Catch: java.lang.Throwable -> L40
            goto L8c
        L40:
            r11 = move-exception
            goto L92
        L42:
            int r2 = r0.c
            w9.a r3 = r0.b
            java.nio.ByteBuffer r5 = r0.f3381a
            kotlin.b.b(r11)
            r9 = r3
            r3 = r2
            r2 = r9
            goto L7c
        L4f:
            kotlin.b.b(r11)
            boolean r11 = r10.f3374z
            if (r11 != 0) goto L96
            int r11 = r10.f3373x
            if (r11 < r7) goto L96
            H4.t r11 = r10.f3369s
            java.util.ArrayList r11 = r11.f752a
            int r11 = r11.size()
            if (r11 < r7) goto L96
            java.nio.ByteBuffer r11 = r10.f3371v
            if (r11 != 0) goto L69
            goto Lb9
        L69:
            kotlinx.coroutines.sync.a r2 = r10.f3370t
            r0.f3381a = r11
            r0.b = r2
            r3 = 0
            r0.c = r3
            r0.f = r5
            java.lang.Object r5 = r2.lock(r8, r0)
            if (r5 != r1) goto L7b
            goto Lb0
        L7b:
            r5 = r11
        L7c:
            r0.f3381a = r8     // Catch: java.lang.Throwable -> L90
            r0.b = r2     // Catch: java.lang.Throwable -> L90
            r0.c = r3     // Catch: java.lang.Throwable -> L90
            r0.f = r4     // Catch: java.lang.Throwable -> L90
            java.lang.Object r10 = r10.s(r5, r0)     // Catch: java.lang.Throwable -> L90
            if (r10 != r1) goto L8b
            goto Lb0
        L8b:
            r10 = r2
        L8c:
            r10.unlock(r8)
            return r6
        L90:
            r11 = move-exception
            r10 = r2
        L92:
            r10.unlock(r8)
            throw r11
        L96:
            H7.h r11 = r0.getContext()
            boolean r11 = kotlinx.coroutines.a.k(r11)
            if (r11 == 0) goto Lb9
            boolean r11 = r10.f3374z
            if (r11 != 0) goto Lb9
            int r11 = r10.f3373x
            if (r11 >= r7) goto Lb9
            r0.f = r3
            java.lang.Object r11 = r10.z(r0)
            if (r11 != r1) goto Lb1
        Lb0:
            return r1
        Lb1:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L96
        Lb9:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.TrainingActivity.q(com.stepos.ability.voicewakeup.training.TrainingActivity, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void A() {
        TextView textView = this.f3365a;
        if (textView == null) {
            k.n("tvTitle");
            throw null;
        }
        C4.g gVar = this.u;
        if (gVar == null) {
            k.n("wakeupWord");
            throw null;
        }
        String string = getString(R.string.voice_wake_train_title_normal, getString(gVar.b));
        k.e(string, "getString(...)");
        textView.setText(o.b0(string));
        TextView textView2 = this.f3365a;
        if (textView2 == null) {
            k.n("tvTitle");
            throw null;
        }
        textView2.setTextColor(getColor(R.color.voicewakeup_title));
        G();
    }

    public final void B() {
        if (this.f3374z || isFinishing() || isDestroyed()) {
            return;
        }
        f fVar = this.m;
        if ((fVar == null || !fVar.a()) && this.f3359B == null) {
            this.f3360C = false;
            TextView textView = this.f3366j;
            if (textView == null) {
                k.n("tvListening");
                throw null;
            }
            textView.setVisibility(0);
            this.f3359B = AbstractC1683A.n(LifecycleOwnerKt.getLifecycleScope(this), null, new TrainingActivity$startTrainingFlow$1(this, null), 3);
        }
    }

    public final void C(boolean z10) {
        boolean z11 = this.f3362F;
        this.f3362F = false;
        MediaPlayer mediaPlayer = this.E;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Throwable th) {
                kotlin.b.a(th);
            }
        }
        this.E = null;
        ImageView imageView = this.f;
        if (imageView == null) {
            k.n("btnPlayPhonetic");
            throw null;
        }
        imageView.setImageResource(R.drawable.ic_voicewakeup_play_sm);
        if (!z11 || !z10 || this.f3363G || this.f3374z || isFinishing() || isDestroyed() || !w()) {
            return;
        }
        q0 q0Var = this.f3359B;
        if (q0Var == null) {
            B();
        } else {
            q0Var.w(new j(this, 1));
        }
    }

    public final void D(int i) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        Toast.makeText(this, i, 0).show();
    }

    public final void E(String str) {
        if (x()) {
            com.stepos.statsrpk.d.K("fail", str);
        }
    }

    public final void F() {
        if (x()) {
            com.stepos.statsrpk.d.K("success", null);
            com.stepos.statsrpk.d.G("oobe_success_expose", "oobe", kotlin.collections.a.R(new Pair("page_name", "oobe"), new Pair("success_from", "voiceprint_success")));
            return;
        }
        C4.g gVar = this.u;
        if (gVar == null) {
            k.n("wakeupWord");
            throw null;
        }
        String wakeWordType = gVar.f296a;
        k.f(wakeWordType, "wakeWordType");
        com.stepos.statsrpk.d.G("amoo_settings_wake_up_word", "amoo_settings", kotlin.collections.a.R(new Pair("page_name", "amoo_settings"), new Pair("wake_word_type", wakeWordType)));
    }

    public final void G() {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(getString(R.string.voice_wake_train_progress, Integer.valueOf(this.f3373x + 1), 5));
        } else {
            k.n("tvProgress");
            throw null;
        }
    }

    @Override // android.app.Activity
    public final void finish() {
        f fVar = this.m;
        if (fVar != null) {
            fVar.c();
        }
        b bVar = this.l;
        if (bVar != null) {
            bVar.c.f();
        }
        super.finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        if (x()) {
            getWindow().addFlags(8192);
        }
        setContentView(R.layout.activity_voice_wakeup_training);
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        windowInsetsControllerCompat.setAppearanceLightStatusBars(false);
        windowInsetsControllerCompat.setAppearanceLightNavigationBars(false);
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra("extra_word_id") : null;
        C4.g gVarA = h.a(stringExtra);
        if (gVarA == null) {
            Log.e("TrainingActivity", "onCreate: unknown wordId=" + stringExtra + ", finishing");
            Toast.makeText(this, R.string.voice_wake_train_unsupported, 0).show();
            finish();
            return;
        }
        this.u = gVarA;
        Log.i("TrainingActivity", "onCreate: wordId=" + gVarA.f296a + " totalTimes=5");
        if (x()) {
            com.stepos.statsrpk.d.F("voice_record_page");
        }
        View viewFindViewById = findViewById(R.id.tvTitle);
        k.e(viewFindViewById, "findViewById(...)");
        this.f3365a = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.tvProgress);
        k.e(viewFindViewById2, "findViewById(...)");
        this.b = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.orb);
        k.e(viewFindViewById3, "findViewById(...)");
        d dVar = new d((PAGView) viewFindViewById3);
        dVar.k(WakeupPagAnimation.c);
        this.c = dVar;
        View viewFindViewById4 = findViewById(R.id.phoneticPill);
        k.e(viewFindViewById4, "findViewById(...)");
        this.d = viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.tvPhonetic);
        k.e(viewFindViewById5, "findViewById(...)");
        this.e = (TextView) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.btnPlayPhonetic);
        k.e(viewFindViewById6, "findViewById(...)");
        this.f = (ImageView) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.phraseCarousel);
        k.e(viewFindViewById7, "findViewById(...)");
        this.i = (TrainingPhraseCarousel) viewFindViewById7;
        View viewFindViewById8 = findViewById(R.id.tvListening);
        k.e(viewFindViewById8, "findViewById(...)");
        this.f3366j = (TextView) viewFindViewById8;
        View viewFindViewById9 = findViewById(R.id.flBottomGlowSlot);
        k.e(viewFindViewById9, "findViewById(...)");
        this.k = viewFindViewById9;
        View decorView = getWindow().getDecorView();
        k.e(decorView, "getDecorView(...)");
        View viewFindViewById10 = findViewById(R.id.ivBottomGlow);
        k.e(viewFindViewById10, "findViewById(...)");
        C7.f fVar = this.f3364L;
        this.l = new b(decorView, viewFindViewById10, (String) fVar.getF4884a());
        View viewFindViewById11 = findViewById(R.id.tvDoneTitle);
        k.e(viewFindViewById11, "findViewById(...)");
        this.g = (TextView) viewFindViewById11;
        View viewFindViewById12 = findViewById(R.id.btnDone);
        k.e(viewFindViewById12, "findViewById(...)");
        this.h = (TextView) viewFindViewById12;
        C4.g gVar = this.u;
        if (gVar == null) {
            k.n("wakeupWord");
            throw null;
        }
        String str = gVar.h;
        if (str == null || str.length() == 0) {
            View view = this.d;
            if (view == null) {
                k.n("phoneticPill");
                throw null;
            }
            view.setVisibility(8);
        } else {
            View view2 = this.d;
            if (view2 == null) {
                k.n("phoneticPill");
                throw null;
            }
            view2.setVisibility(0);
            TextView textView = this.e;
            if (textView == null) {
                k.n("tvPhonetic");
                throw null;
            }
            textView.setText(str);
            View view3 = this.d;
            if (view3 == null) {
                k.n("phoneticPill");
                throw null;
            }
            final int i = 2;
            view3.setOnClickListener(new View.OnClickListener(this) { // from class: H4.e
                public final /* synthetic */ TrainingActivity b;

                {
                    this.b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    Object objA;
                    com.stepos.ability.voicewakeup.training.c cVar;
                    boolean z10;
                    int i6 = i;
                    final TrainingActivity trainingActivity = this.b;
                    switch (i6) {
                        case 0:
                            Log.d("TrainingActivity", "btnBack clicked, isFinished=" + trainingActivity.f3374z);
                            if (trainingActivity.x()) {
                                com.stepos.statsrpk.d.n("voice_record_page", "back");
                            }
                            trainingActivity.y();
                            return;
                        case 1:
                            int i10 = TrainingActivity.f3357M;
                            Log.d("TrainingActivity", "btnDone clicked");
                            if (trainingActivity.x()) {
                                com.stepos.statsrpk.d.n("voice_record_page", HighlightCallback.KEY_DONE);
                            }
                            trainingActivity.setResult(-1);
                            trainingActivity.finish();
                            return;
                        default:
                            if (trainingActivity.f3362F) {
                                trainingActivity.C(true);
                                return;
                            }
                            C4.g gVar2 = trainingActivity.u;
                            if (gVar2 == null) {
                                kotlin.jvm.internal.k.n("wakeupWord");
                                throw null;
                            }
                            Integer num = gVar2.i;
                            if (num == null) {
                                Log.i("TrainingActivity", "phonetic audio not provided for " + gVar2.f296a + ", no-op");
                                return;
                            }
                            int iIntValue = num.intValue();
                            if (trainingActivity.isFinishing() || trainingActivity.isDestroyed()) {
                                return;
                            }
                            C4.f fVar2 = trainingActivity.m;
                            if (fVar2 == null || !fVar2.a()) {
                                trainingActivity.f3362F = true;
                                com.stepos.ability.voicewakeup.training.b bVar = trainingActivity.l;
                                if (bVar != null && !(z10 = (cVar = bVar.c).f3397j)) {
                                    cVar.o = false;
                                    cVar.m = !z10;
                                    long j5 = cVar.l + 1;
                                    cVar.l = j5;
                                    cVar.c(j5, 0.0f);
                                    cVar.m = false;
                                    cVar.l++;
                                    cVar.o = true;
                                }
                                TextView textView2 = trainingActivity.f3366j;
                                if (textView2 == null) {
                                    kotlin.jvm.internal.k.n("tvListening");
                                    throw null;
                                }
                                textView2.setVisibility(0);
                                trainingActivity.t().a();
                                q0 q0Var = trainingActivity.f3359B;
                                if (q0Var != null) {
                                    q0Var.cancel(null);
                                }
                                com.stepos.ability.voicewakeup.ui.d dVar2 = trainingActivity.c;
                                if (dVar2 == null) {
                                    kotlin.jvm.internal.k.n("orb");
                                    throw null;
                                }
                                dVar2.k(WakeupPagAnimation.c);
                                ImageView imageView = trainingActivity.f;
                                if (imageView == null) {
                                    kotlin.jvm.internal.k.n("btnPlayPhonetic");
                                    throw null;
                                }
                                imageView.setImageResource(R.drawable.ic_voicewakeup_pause_sm);
                                try {
                                    MediaPlayer mediaPlayer = trainingActivity.E;
                                    if (mediaPlayer != null) {
                                        mediaPlayer.release();
                                    }
                                    MediaPlayer mediaPlayer2 = new MediaPlayer();
                                    AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = trainingActivity.getResources().openRawResourceFd(iIntValue);
                                    try {
                                        mediaPlayer2.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                                        assetFileDescriptorOpenRawResourceFd.close();
                                        mediaPlayer2.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(1).build());
                                        mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: H4.g
                                            @Override // android.media.MediaPlayer.OnCompletionListener
                                            public final void onCompletion(MediaPlayer mediaPlayer3) {
                                                int i11 = TrainingActivity.f3357M;
                                                trainingActivity.C(true);
                                            }
                                        });
                                        mediaPlayer2.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: H4.h
                                            @Override // android.media.MediaPlayer.OnErrorListener
                                            public final boolean onError(MediaPlayer mediaPlayer3, int i11, int i12) {
                                                int i13 = TrainingActivity.f3357M;
                                                Log.w("TrainingActivity", "phonetic MediaPlayer error what=" + i11 + " extra=" + i12);
                                                trainingActivity.C(true);
                                                return true;
                                            }
                                        });
                                        mediaPlayer2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: H4.i
                                            @Override // android.media.MediaPlayer.OnPreparedListener
                                            public final void onPrepared(MediaPlayer mediaPlayer3) throws IllegalStateException {
                                                TrainingActivity trainingActivity2 = trainingActivity;
                                                if (trainingActivity2.E == mediaPlayer3 && trainingActivity2.f3362F) {
                                                    mediaPlayer3.start();
                                                } else {
                                                    mediaPlayer3.release();
                                                }
                                            }
                                        });
                                        trainingActivity.E = mediaPlayer2;
                                        mediaPlayer2.prepareAsync();
                                        objA = Boolean.TRUE;
                                    } finally {
                                    }
                                } catch (Throwable th) {
                                    objA = kotlin.b.a(th);
                                }
                                Throwable thA = Result.a(objA);
                                if (thA != null) {
                                    Log.w("TrainingActivity", "play phonetic failed", thA);
                                    objA = Boolean.FALSE;
                                }
                                if (((Boolean) objA).booleanValue()) {
                                    return;
                                }
                                trainingActivity.C(true);
                                return;
                            }
                            return;
                    }
                }
            });
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.voicewakeupRoot), new B5.a(this, 2));
        G();
        TrainingPhraseCarousel trainingPhraseCarousel = this.i;
        if (trainingPhraseCarousel == null) {
            k.n("phraseCarousel");
            throw null;
        }
        C4.g gVar2 = this.u;
        if (gVar2 == null) {
            k.n("wakeupWord");
            throw null;
        }
        String string = getString(R.string.voice_wake_train_word_plain, getString(gVar2.b));
        k.e(string, "getString(...)");
        trainingPhraseCarousel.f3430j = o.b0(string);
        trainingPhraseCarousel.k = 5;
        trainingPhraseCarousel.setContentDescription(string);
        trainingPhraseCarousel.d();
        StepOSGlassImageButton stepOSGlassImageButton = (StepOSGlassImageButton) findViewById(R.id.btnBack);
        stepOSGlassImageButton.setSurfaceDrawable(ContextCompat.getDrawable(this, R.drawable.bg_voicewakeup_glass_icon_btn));
        final int i6 = 0;
        stepOSGlassImageButton.setOnClickListener(new View.OnClickListener(this) { // from class: H4.e
            public final /* synthetic */ TrainingActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                Object objA;
                com.stepos.ability.voicewakeup.training.c cVar;
                boolean z10;
                int i62 = i6;
                final TrainingActivity trainingActivity = this.b;
                switch (i62) {
                    case 0:
                        Log.d("TrainingActivity", "btnBack clicked, isFinished=" + trainingActivity.f3374z);
                        if (trainingActivity.x()) {
                            com.stepos.statsrpk.d.n("voice_record_page", "back");
                        }
                        trainingActivity.y();
                        return;
                    case 1:
                        int i10 = TrainingActivity.f3357M;
                        Log.d("TrainingActivity", "btnDone clicked");
                        if (trainingActivity.x()) {
                            com.stepos.statsrpk.d.n("voice_record_page", HighlightCallback.KEY_DONE);
                        }
                        trainingActivity.setResult(-1);
                        trainingActivity.finish();
                        return;
                    default:
                        if (trainingActivity.f3362F) {
                            trainingActivity.C(true);
                            return;
                        }
                        C4.g gVar22 = trainingActivity.u;
                        if (gVar22 == null) {
                            kotlin.jvm.internal.k.n("wakeupWord");
                            throw null;
                        }
                        Integer num = gVar22.i;
                        if (num == null) {
                            Log.i("TrainingActivity", "phonetic audio not provided for " + gVar22.f296a + ", no-op");
                            return;
                        }
                        int iIntValue = num.intValue();
                        if (trainingActivity.isFinishing() || trainingActivity.isDestroyed()) {
                            return;
                        }
                        C4.f fVar2 = trainingActivity.m;
                        if (fVar2 == null || !fVar2.a()) {
                            trainingActivity.f3362F = true;
                            com.stepos.ability.voicewakeup.training.b bVar = trainingActivity.l;
                            if (bVar != null && !(z10 = (cVar = bVar.c).f3397j)) {
                                cVar.o = false;
                                cVar.m = !z10;
                                long j5 = cVar.l + 1;
                                cVar.l = j5;
                                cVar.c(j5, 0.0f);
                                cVar.m = false;
                                cVar.l++;
                                cVar.o = true;
                            }
                            TextView textView2 = trainingActivity.f3366j;
                            if (textView2 == null) {
                                kotlin.jvm.internal.k.n("tvListening");
                                throw null;
                            }
                            textView2.setVisibility(0);
                            trainingActivity.t().a();
                            q0 q0Var = trainingActivity.f3359B;
                            if (q0Var != null) {
                                q0Var.cancel(null);
                            }
                            com.stepos.ability.voicewakeup.ui.d dVar2 = trainingActivity.c;
                            if (dVar2 == null) {
                                kotlin.jvm.internal.k.n("orb");
                                throw null;
                            }
                            dVar2.k(WakeupPagAnimation.c);
                            ImageView imageView = trainingActivity.f;
                            if (imageView == null) {
                                kotlin.jvm.internal.k.n("btnPlayPhonetic");
                                throw null;
                            }
                            imageView.setImageResource(R.drawable.ic_voicewakeup_pause_sm);
                            try {
                                MediaPlayer mediaPlayer = trainingActivity.E;
                                if (mediaPlayer != null) {
                                    mediaPlayer.release();
                                }
                                MediaPlayer mediaPlayer2 = new MediaPlayer();
                                AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = trainingActivity.getResources().openRawResourceFd(iIntValue);
                                try {
                                    mediaPlayer2.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                                    assetFileDescriptorOpenRawResourceFd.close();
                                    mediaPlayer2.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(1).build());
                                    mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: H4.g
                                        @Override // android.media.MediaPlayer.OnCompletionListener
                                        public final void onCompletion(MediaPlayer mediaPlayer3) {
                                            int i11 = TrainingActivity.f3357M;
                                            trainingActivity.C(true);
                                        }
                                    });
                                    mediaPlayer2.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: H4.h
                                        @Override // android.media.MediaPlayer.OnErrorListener
                                        public final boolean onError(MediaPlayer mediaPlayer3, int i11, int i12) {
                                            int i13 = TrainingActivity.f3357M;
                                            Log.w("TrainingActivity", "phonetic MediaPlayer error what=" + i11 + " extra=" + i12);
                                            trainingActivity.C(true);
                                            return true;
                                        }
                                    });
                                    mediaPlayer2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: H4.i
                                        @Override // android.media.MediaPlayer.OnPreparedListener
                                        public final void onPrepared(MediaPlayer mediaPlayer3) throws IllegalStateException {
                                            TrainingActivity trainingActivity2 = trainingActivity;
                                            if (trainingActivity2.E == mediaPlayer3 && trainingActivity2.f3362F) {
                                                mediaPlayer3.start();
                                            } else {
                                                mediaPlayer3.release();
                                            }
                                        }
                                    });
                                    trainingActivity.E = mediaPlayer2;
                                    mediaPlayer2.prepareAsync();
                                    objA = Boolean.TRUE;
                                } finally {
                                }
                            } catch (Throwable th) {
                                objA = kotlin.b.a(th);
                            }
                            Throwable thA = Result.a(objA);
                            if (thA != null) {
                                Log.w("TrainingActivity", "play phonetic failed", thA);
                                objA = Boolean.FALSE;
                            }
                            if (((Boolean) objA).booleanValue()) {
                                return;
                            }
                            trainingActivity.C(true);
                            return;
                        }
                        return;
                }
            }
        });
        TextView textView2 = this.h;
        if (textView2 == null) {
            k.n("btnDone");
            throw null;
        }
        final int i10 = 1;
        textView2.setOnClickListener(new View.OnClickListener(this) { // from class: H4.e
            public final /* synthetic */ TrainingActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                Object objA;
                com.stepos.ability.voicewakeup.training.c cVar;
                boolean z10;
                int i62 = i10;
                final TrainingActivity trainingActivity = this.b;
                switch (i62) {
                    case 0:
                        Log.d("TrainingActivity", "btnBack clicked, isFinished=" + trainingActivity.f3374z);
                        if (trainingActivity.x()) {
                            com.stepos.statsrpk.d.n("voice_record_page", "back");
                        }
                        trainingActivity.y();
                        return;
                    case 1:
                        int i102 = TrainingActivity.f3357M;
                        Log.d("TrainingActivity", "btnDone clicked");
                        if (trainingActivity.x()) {
                            com.stepos.statsrpk.d.n("voice_record_page", HighlightCallback.KEY_DONE);
                        }
                        trainingActivity.setResult(-1);
                        trainingActivity.finish();
                        return;
                    default:
                        if (trainingActivity.f3362F) {
                            trainingActivity.C(true);
                            return;
                        }
                        C4.g gVar22 = trainingActivity.u;
                        if (gVar22 == null) {
                            kotlin.jvm.internal.k.n("wakeupWord");
                            throw null;
                        }
                        Integer num = gVar22.i;
                        if (num == null) {
                            Log.i("TrainingActivity", "phonetic audio not provided for " + gVar22.f296a + ", no-op");
                            return;
                        }
                        int iIntValue = num.intValue();
                        if (trainingActivity.isFinishing() || trainingActivity.isDestroyed()) {
                            return;
                        }
                        C4.f fVar2 = trainingActivity.m;
                        if (fVar2 == null || !fVar2.a()) {
                            trainingActivity.f3362F = true;
                            com.stepos.ability.voicewakeup.training.b bVar = trainingActivity.l;
                            if (bVar != null && !(z10 = (cVar = bVar.c).f3397j)) {
                                cVar.o = false;
                                cVar.m = !z10;
                                long j5 = cVar.l + 1;
                                cVar.l = j5;
                                cVar.c(j5, 0.0f);
                                cVar.m = false;
                                cVar.l++;
                                cVar.o = true;
                            }
                            TextView textView22 = trainingActivity.f3366j;
                            if (textView22 == null) {
                                kotlin.jvm.internal.k.n("tvListening");
                                throw null;
                            }
                            textView22.setVisibility(0);
                            trainingActivity.t().a();
                            q0 q0Var = trainingActivity.f3359B;
                            if (q0Var != null) {
                                q0Var.cancel(null);
                            }
                            com.stepos.ability.voicewakeup.ui.d dVar2 = trainingActivity.c;
                            if (dVar2 == null) {
                                kotlin.jvm.internal.k.n("orb");
                                throw null;
                            }
                            dVar2.k(WakeupPagAnimation.c);
                            ImageView imageView = trainingActivity.f;
                            if (imageView == null) {
                                kotlin.jvm.internal.k.n("btnPlayPhonetic");
                                throw null;
                            }
                            imageView.setImageResource(R.drawable.ic_voicewakeup_pause_sm);
                            try {
                                MediaPlayer mediaPlayer = trainingActivity.E;
                                if (mediaPlayer != null) {
                                    mediaPlayer.release();
                                }
                                MediaPlayer mediaPlayer2 = new MediaPlayer();
                                AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = trainingActivity.getResources().openRawResourceFd(iIntValue);
                                try {
                                    mediaPlayer2.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                                    assetFileDescriptorOpenRawResourceFd.close();
                                    mediaPlayer2.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(1).build());
                                    mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: H4.g
                                        @Override // android.media.MediaPlayer.OnCompletionListener
                                        public final void onCompletion(MediaPlayer mediaPlayer3) {
                                            int i11 = TrainingActivity.f3357M;
                                            trainingActivity.C(true);
                                        }
                                    });
                                    mediaPlayer2.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: H4.h
                                        @Override // android.media.MediaPlayer.OnErrorListener
                                        public final boolean onError(MediaPlayer mediaPlayer3, int i11, int i12) {
                                            int i13 = TrainingActivity.f3357M;
                                            Log.w("TrainingActivity", "phonetic MediaPlayer error what=" + i11 + " extra=" + i12);
                                            trainingActivity.C(true);
                                            return true;
                                        }
                                    });
                                    mediaPlayer2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: H4.i
                                        @Override // android.media.MediaPlayer.OnPreparedListener
                                        public final void onPrepared(MediaPlayer mediaPlayer3) throws IllegalStateException {
                                            TrainingActivity trainingActivity2 = trainingActivity;
                                            if (trainingActivity2.E == mediaPlayer3 && trainingActivity2.f3362F) {
                                                mediaPlayer3.start();
                                            } else {
                                                mediaPlayer3.release();
                                            }
                                        }
                                    });
                                    trainingActivity.E = mediaPlayer2;
                                    mediaPlayer2.prepareAsync();
                                    objA = Boolean.TRUE;
                                } finally {
                                }
                            } catch (Throwable th) {
                                objA = kotlin.b.a(th);
                            }
                            Throwable thA = Result.a(objA);
                            if (thA != null) {
                                Log.w("TrainingActivity", "play phonetic failed", thA);
                                objA = Boolean.FALSE;
                            }
                            if (((Boolean) objA).booleanValue()) {
                                return;
                            }
                            trainingActivity.C(true);
                            return;
                        }
                        return;
                }
            }
        });
        OnBackPressedDispatcherKt.addCallback$default(getOnBackPressedDispatcher(), this, false, new j(this, 0), 2, null);
        TrainingPhraseCarousel trainingPhraseCarousel2 = this.i;
        if (trainingPhraseCarousel2 == null) {
            k.n("phraseCarousel");
            throw null;
        }
        trainingPhraseCarousel2.d();
        A();
        if (k.b((String) fVar.getF4884a(), "settings")) {
            f fVar2 = new f(this, new AnonymousClass5(0, this, TrainingActivity.class, "interruptForCall", "interruptForCall()V", 0));
            fVar2.b();
            this.m = fVar2;
            if (isFinishing()) {
                return;
            }
        }
        if (w()) {
            B();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{PolicySdkPermissionManifestUtils.RECORD_AUDIO}, 2701);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        f fVar = this.m;
        if (fVar != null) {
            fVar.c();
        }
        this.m = null;
        Log.i("TrainingActivity", "onDestroy: recorded=" + this.f3369s.f752a.size() + " isFinished=" + this.f3374z);
        this.f3363G = true;
        b bVar = this.l;
        if (bVar != null) {
            bVar.c.f();
        }
        this.f3360C = false;
        t().a();
        q0 q0Var = this.f3359B;
        if (q0Var != null) {
            q0Var.cancel(null);
        }
        t tVar = this.f3369s;
        tVar.f752a.clear();
        tVar.b = 0;
        d dVar = this.c;
        if (dVar != null) {
            dVar.n();
        }
        b bVar2 = this.l;
        if (bVar2 != null) {
            bVar2.f3395a.removeOnAttachStateChangeListener(bVar2.d);
            c cVar = bVar2.c;
            cVar.f3397j = true;
            cVar.f();
        }
        this.l = null;
        g gVar = this.f3361D;
        if (gVar != null) {
            gVar.dismiss();
        }
        this.f3361D = null;
        MediaPlayer mediaPlayer = this.E;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.E = null;
        this.f3362F = false;
        t().c(true ^ this.f3374z);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        this.f3363G = true;
        b bVar = this.l;
        if (bVar != null) {
            bVar.c.f();
        }
        this.f3360C = true ^ isFinishing();
        C(false);
        t().a();
        q0 q0Var = this.f3359B;
        if (q0Var != null) {
            q0Var.cancel(null);
        }
        d dVar = this.c;
        if (dVar != null) {
            dVar.j();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        k.f(permissions, "permissions");
        k.f(grantResults, "grantResults");
        super.onRequestPermissionsResult(i, permissions, grantResults);
        if (i != 2701 || isFinishing() || isDestroyed()) {
            return;
        }
        f fVar = this.m;
        if (fVar == null || !fVar.a()) {
            if (!(grantResults.length == 0) && grantResults[0] == 0) {
                B();
                return;
            }
            E("permission_denied");
            D(R.string.voice_wake_train_perm_denied);
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (isFinishing() || isDestroyed()) {
            return;
        }
        f fVar = this.m;
        if (fVar == null || !fVar.a()) {
            this.f3363G = false;
            d dVar = this.c;
            if (dVar != null) {
                dVar.o();
            }
            if (!this.f3374z && this.f3359B == null && w()) {
                B();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        Object objA;
        super.onStart();
        if (isFinishing() || isDestroyed()) {
            return;
        }
        f fVar = this.m;
        boolean z10 = true;
        if ((fVar == null || !fVar.a()) && !this.f3374z) {
            this.f3368r = true;
            try {
                m mVar = (m) this.f3367q.getF4884a();
                if (!mVar.b) {
                    if (mVar.f745a.requestFocus() != 1) {
                        z10 = false;
                    }
                    mVar.b = z10;
                }
                objA = Boolean.valueOf(z10);
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                Log.w("TrainingActivity", "request session audio focus failed", thA);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        Object objA;
        if (this.f3368r) {
            try {
                m mVar = (m) this.f3367q.getF4884a();
                boolean z10 = true;
                if (mVar.b) {
                    int iAbandonFocus = mVar.f745a.abandonFocus();
                    if (iAbandonFocus == 1) {
                        mVar.b = false;
                    }
                    if (iAbandonFocus != 1) {
                        z10 = false;
                    }
                }
                objA = Boolean.valueOf(z10);
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                Log.w("TrainingActivity", "abandon session audio focus failed", thA);
            }
        }
        super.onStop();
    }

    public final void r() {
        TrainingActivity trainingActivity;
        if (this.f3358A == null) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            this.f3358A = Long.valueOf(jUptimeMillis);
            d dVar = this.c;
            if (dVar == null) {
                k.n("orb");
                throw null;
            }
            int iIdentityHashCode = System.identityHashCode(dVar);
            StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(iIdentityHashCode, "event=done_enter player=", " source=", (String) this.f3364L.getF4884a(), " uptimeMs=");
            sbK.append(jUptimeMillis);
            Log.i("TrainingActivity", sbK.toString());
            TextView textView = this.g;
            if (textView == null) {
                k.n("tvDoneTitle");
                throw null;
            }
            trainingActivity = this;
            OneShotPreDrawListener.add(textView, new H4.k(textView, iIdentityHashCode, jUptimeMillis, trainingActivity));
        } else {
            trainingActivity = this;
        }
        TextView textView2 = trainingActivity.f3365a;
        if (textView2 == null) {
            k.n("tvTitle");
            throw null;
        }
        textView2.setVisibility(8);
        View view = trainingActivity.d;
        if (view == null) {
            k.n("phoneticPill");
            throw null;
        }
        view.setVisibility(8);
        TrainingPhraseCarousel trainingPhraseCarousel = trainingActivity.i;
        if (trainingPhraseCarousel == null) {
            k.n("phraseCarousel");
            throw null;
        }
        trainingPhraseCarousel.setVisibility(8);
        TextView textView3 = trainingActivity.f3366j;
        if (textView3 == null) {
            k.n("tvListening");
            throw null;
        }
        textView3.setVisibility(8);
        View view2 = trainingActivity.k;
        if (view2 == null) {
            k.n("flBottomGlowSlot");
            throw null;
        }
        view2.setVisibility(8);
        TextView textView4 = trainingActivity.g;
        if (textView4 == null) {
            k.n("tvDoneTitle");
            throw null;
        }
        textView4.setVisibility(0);
        TextView textView5 = trainingActivity.h;
        if (textView5 == null) {
            k.n("btnDone");
            throw null;
        }
        textView5.setVisibility(0);
        d dVar2 = trainingActivity.c;
        if (dVar2 == null) {
            k.n("orb");
            throw null;
        }
        WakeupPagAnimation wakeupPagAnimation = WakeupPagAnimation.b;
        dVar2.l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0109 A[Catch: all -> 0x0054, CancellationException -> 0x0057, TRY_LEAVE, TryCatch #6 {CancellationException -> 0x0057, all -> 0x0054, blocks: (B:20:0x004f, B:59:0x00e6, B:61:0x00f3, B:63:0x00f9, B:65:0x00fd, B:68:0x0105, B:70:0x0109, B:86:0x0175, B:87:0x017c, B:56:0x00d0), top: B:113:0x0026, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0175 A[Catch: all -> 0x0054, CancellationException -> 0x0057, TRY_ENTER, TryCatch #6 {CancellationException -> 0x0057, all -> 0x0054, blocks: (B:20:0x004f, B:59:0x00e6, B:61:0x00f3, B:63:0x00f9, B:65:0x00fd, B:68:0x0105, B:70:0x0109, B:86:0x0175, B:87:0x017c, B:56:0x00d0), top: B:113:0x0026, outer: #4 }] */
    /* JADX WARN: Type inference failed for: r11v11, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.nio.ByteBuffer r11, kotlin.coroutines.jvm.internal.ContinuationImpl r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.TrainingActivity.s(java.nio.ByteBuffer, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final a t() {
        return (a) this.p.getF4884a();
    }

    public final Boolean u() {
        t tVar = this.f3369s;
        tVar.b++;
        if (tVar.f752a.size() == 0 && tVar.b >= 6) {
            E("too_noisy");
            D(R.string.voice_wake_train_too_noisy);
            finish();
            return Boolean.FALSE;
        }
        TextView textView = this.f3365a;
        if (textView == null) {
            k.n("tvTitle");
            throw null;
        }
        textView.setText(getString(R.string.voice_wake_train_title_error));
        TextView textView2 = this.f3365a;
        if (textView2 == null) {
            k.n("tvTitle");
            throw null;
        }
        textView2.setTextColor(getColor(R.color.voicewakeup_title));
        this.y = RoundFeedback.c;
        return Boolean.TRUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(int r5, java.nio.ShortBuffer r6, java.nio.ByteBuffer r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.stepos.ability.voicewakeup.training.TrainingActivity$handleRoundPass$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ability.voicewakeup.training.TrainingActivity$handleRoundPass$1 r0 = (com.stepos.ability.voicewakeup.training.TrainingActivity$handleRoundPass$1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.stepos.ability.voicewakeup.training.TrainingActivity$handleRoundPass$1 r0 = new com.stepos.ability.voicewakeup.training.TrainingActivity$handleRoundPass$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.f3380a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.b.b(r8)
            goto L50
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r8)
            H4.t r8 = r4.f3369s
            r8.getClass()
            java.lang.String r2 = "recording"
            kotlin.jvm.internal.k.f(r6, r2)
            java.util.ArrayList r8 = r8.f752a
            r8.add(r6)
            int r5 = r5 + r3
            r4.f3373x = r5
            r6 = 5
            if (r5 < r6) goto L53
            r0.c = r3
            java.lang.Object r4 = r4.s(r7, r0)
            if (r4 != r1) goto L50
            return r1
        L50:
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        L53:
            com.stepos.ability.voicewakeup.training.TrainingActivity$RoundFeedback r5 = com.stepos.ability.voicewakeup.training.TrainingActivity.RoundFeedback.b
            r4.y = r5
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.TrainingActivity.v(int, java.nio.ShortBuffer, java.nio.ByteBuffer, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final boolean w() {
        return ContextCompat.checkSelfPermission(this, PolicySdkPermissionManifestUtils.RECORD_AUDIO) == 0;
    }

    public final boolean x() {
        return k.b((String) this.f3364L.getF4884a(), "oobe");
    }

    public final void y() {
        Window window;
        if (this.f3374z) {
            setResult(x() ? 0 : -1);
            finish();
            return;
        }
        if (this.f3369s.f752a.size() <= 0) {
            finish();
            return;
        }
        g gVar = this.f3361D;
        if (gVar == null || !gVar.isShowing()) {
            Q.a aVarR = l.r(this, true);
            n nVar = (n) aVarR.b;
            nVar.b = nVar.f153a.getText(R.string.voice_wake_train_cancel_title);
            nVar.d = nVar.f153a.getText(R.string.voice_wake_train_cancel_message);
            G4.c cVar = new G4.c(3);
            nVar.h = nVar.f153a.getText(R.string.voice_wake_train_cancel_back);
            nVar.i = cVar;
            G4.f fVar = new G4.f(this, 1);
            nVar.f = nVar.f153a.getText(R.string.voice_wake_train_cancel_confirm);
            nVar.g = fVar;
            g gVarC = aVarR.c();
            this.f3361D = gVarC;
            if (x() && (window = gVarC.getWindow()) != null) {
                window.addFlags(8192);
            }
            gVarC.show();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|2|(2:4|(1:6)(1:7))(0)|8|(1:117)|(3:(1:(1:(1:(2:121|(1:(7:15|16|103|95|104|105|106)(2:20|21))(7:22|23|94|95|104|105|106))(7:25|26|75|(2:80|(3:82|83|84)(3:88|(2:90|(6:93|94|95|104|105|106))(2:99|(6:102|103|95|104|105|106))|101))|107|108|109))(5:30|31|120|54|(5:56|(3:65|66|67)|68|69|70)(2:71|(2:73|101)(6:74|75|(3:77|80|(0)(0))|107|108|109))))(1:33))(3:34|(1:37)|101)|119|(3:40|41|42)(2:45|(3:47|48|49)(3:50|(4:53|120|54|(0)(0))|101)))|115|38|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01df, code lost:
    
        r2 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01e1, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0064: MOVE (r2 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]), block:B:29:0x0063 */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00dc A[Catch: all -> 0x0062, TRY_ENTER, TryCatch #1 {all -> 0x0062, blocks: (B:26:0x005d, B:31:0x0071, B:56:0x00dc, B:58:0x00e0, B:60:0x00e4, B:62:0x00ea, B:65:0x00f1, B:68:0x0105), top: B:117:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010b A[Catch: all -> 0x017d, TRY_ENTER, TryCatch #4 {all -> 0x017d, blocks: (B:75:0x0130, B:82:0x0168, B:88:0x0181, B:90:0x0185, B:99:0x01a6, B:107:0x01ca, B:54:0x00d8, B:71:0x010b), top: B:120:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0168 A[Catch: all -> 0x017d, TRY_LEAVE, TryCatch #4 {all -> 0x017d, blocks: (B:75:0x0130, B:82:0x0168, B:88:0x0181, B:90:0x0185, B:99:0x01a6, B:107:0x01ca, B:54:0x00d8, B:71:0x010b), top: B:120:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0181 A[Catch: all -> 0x017d, TRY_ENTER, TryCatch #4 {all -> 0x017d, blocks: (B:75:0x0130, B:82:0x0168, B:88:0x0181, B:90:0x0185, B:99:0x01a6, B:107:0x01ca, B:54:0x00d8, B:71:0x010b), top: B:120:0x00d8 }] */
    /* JADX WARN: Type inference failed for: r11v5, types: [w9.a] */
    /* JADX WARN: Type inference failed for: r17v0, types: [android.app.Activity, com.stepos.ability.voicewakeup.training.TrainingActivity] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [w9.a] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(kotlin.coroutines.jvm.internal.ContinuationImpl r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.TrainingActivity.z(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
