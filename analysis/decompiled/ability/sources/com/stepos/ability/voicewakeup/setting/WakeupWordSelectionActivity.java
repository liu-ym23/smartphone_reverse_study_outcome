package com.stepos.ability.voicewakeup.setting;

import A6.b;
import A6.g;
import B9.Q;
import C4.f;
import C4.h;
import C7.r;
import D6.i;
import H4.o;
import J4.a;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.OnBackPressedDispatcherKt;
import android.view.View;
import android.view.ViewGroup;
import android.view.result.ActivityResultLauncher;
import android.view.result.contract.ActivityResultContracts;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.R;
import com.stepos.ability.voicewakeup.ui.WakeupPagAnimation;
import com.stepos.ability.voicewakeup.ui.d;
import com.stepos.widget.glass.StepOSGlassImageButton;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.k;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ability/voicewakeup/setting/WakeupWordSelectionActivity;", "LJ4/a;", AppAgent.CONSTRUCT, "()V", "voicewakeup_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WakeupWordSelectionActivity extends a {
    public static final /* synthetic */ int f = 0;

    /* renamed from: a, reason: collision with root package name */
    public g f3347a;
    public f b;
    public d c;
    public final C7.f d = kotlin.a.a(new i(this, 3));
    public final ActivityResultLauncher e = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new B5.a(this, 1));

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.voicewakeup.setting.WakeupWordSelectionActivity$onCreate$5, reason: invalid class name */
    final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements S7.a {
        @Override // S7.a
        public final Object invoke() {
            WakeupWordSelectionActivity wakeupWordSelectionActivity = (WakeupWordSelectionActivity) this.receiver;
            int i = WakeupWordSelectionActivity.f;
            if (!wakeupWordSelectionActivity.isFinishing() && !wakeupWordSelectionActivity.isDestroyed()) {
                g gVar = wakeupWordSelectionActivity.f3347a;
                if (gVar != null) {
                    gVar.dismiss();
                }
                wakeupWordSelectionActivity.f3347a = null;
                wakeupWordSelectionActivity.setResult(1);
                wakeupWordSelectionActivity.finish();
            }
            return r.f317a;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        if (q()) {
            getWindow().addFlags(8192);
        }
        setContentView(R.layout.activity_wakeup_word_selection);
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        int i = 0;
        windowInsetsControllerCompat.setAppearanceLightStatusBars(false);
        windowInsetsControllerCompat.setAppearanceLightNavigationBars(false);
        StepOSGlassImageButton stepOSGlassImageButton = (StepOSGlassImageButton) findViewById(R.id.btnBack);
        stepOSGlassImageButton.setSurfaceDrawable(ContextCompat.getDrawable(this, R.drawable.bg_voicewakeup_glass_icon_btn));
        stepOSGlassImageButton.setOnClickListener(new b(this, 3));
        OnBackPressedDispatcherKt.addCallback$default(getOnBackPressedDispatcher(), this, false, new Q(this, 10), 2, null);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.llWordList);
        View viewFindViewById = findViewById(R.id.orb);
        k.e(viewFindViewById, "findViewById(...)");
        d dVar = new d((PAGView) viewFindViewById);
        dVar.k(WakeupPagAnimation.b);
        this.c = dVar;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this);
        C7.f fVar = h.f297a;
        String[] stringArray = getResources().getStringArray(R.array.voice_wake_selectable_words);
        k.e(stringArray, "getStringArray(...)");
        ArrayList arrayList = new ArrayList();
        for (String str : stringArray) {
            C4.g gVarA = h.a(str);
            if (gVarA != null) {
                arrayList.add(gVarA);
            }
        }
        Iterator it = arrayList.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            int i10 = i6 + 1;
            if (i6 < 0) {
                o.X();
                throw null;
            }
            C4.g gVar = (C4.g) next;
            View viewInflate = layoutInflaterFrom.inflate(R.layout.item_wakeup_word_pill, (ViewGroup) linearLayout, false);
            k.d(viewInflate, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) viewInflate;
            textView.setText(getString(gVar.b));
            textView.setOnClickListener(new G4.k(this, gVar, i));
            if (i6 == 0) {
                ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            linearLayout.addView(textView);
            i6 = i10;
        }
        if (q()) {
            com.stepos.statsrpk.d.F("wakeword_select");
        }
        if (k.b((String) this.d.getF4884a(), "settings")) {
            f fVar2 = new f(this, new AnonymousClass5(0, this, WakeupWordSelectionActivity.class, "interruptForCall", "interruptForCall()V", 0));
            fVar2.b();
            this.b = fVar2;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        f fVar = this.b;
        if (fVar != null) {
            fVar.c();
        }
        this.b = null;
        d dVar = this.c;
        if (dVar != null) {
            dVar.n();
        }
        this.c = null;
        g gVar = this.f3347a;
        if (gVar != null) {
            gVar.dismiss();
        }
        this.f3347a = null;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        d dVar = this.c;
        if (dVar != null) {
            dVar.j();
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        d dVar;
        super.onResume();
        if (isFinishing() || isDestroyed()) {
            return;
        }
        f fVar = this.b;
        if ((fVar == null || !fVar.a()) && (dVar = this.c) != null) {
            dVar.o();
        }
    }

    public final boolean q() {
        return k.b((String) this.d.getF4884a(), "oobe");
    }

    public final void r(C4.g gVar) {
        Object objA;
        if (isFinishing() || isDestroyed()) {
            return;
        }
        f fVar = this.b;
        if (fVar == null || !fVar.a()) {
            Intent intent = new Intent("com.stepos.ability.action.VOICE_WAKEUP_TRAINING");
            intent.setPackage(getPackageName());
            intent.putExtra("extra_word_id", gVar.f296a);
            intent.putExtra("extra_entry_source", (String) this.d.getF4884a());
            try {
                this.e.launch(intent);
                objA = r.f317a;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                Log.e("WakeupWordSelection", "start TrainingActivity failed", thA);
            }
        }
    }
}
