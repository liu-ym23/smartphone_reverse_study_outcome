package G4;

import A6.n;
import D7.v;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.stepos.ability.R;
import com.stepos.ability.voicewakeup.setting.WakeupWordSelectionActivity;
import com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.EmptySet;

/* loaded from: classes3.dex */
public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f674a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ Object c;

    public /* synthetic */ k(FragmentActivity fragmentActivity, Object obj, int i) {
        this.f674a = i;
        this.b = fragmentActivity;
        this.c = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Window window;
        int i = this.f674a;
        Object obj = this.c;
        FragmentActivity fragmentActivity = this.b;
        switch (i) {
            case 0:
                final WakeupWordSelectionActivity wakeupWordSelectionActivity = (WakeupWordSelectionActivity) fragmentActivity;
                final C4.g gVar = (C4.g) obj;
                String wordId = gVar.f296a;
                int i6 = WakeupWordSelectionActivity.f;
                if (!wakeupWordSelectionActivity.isFinishing() && !wakeupWordSelectionActivity.isDestroyed()) {
                    C4.f fVar = wakeupWordSelectionActivity.b;
                    if (fVar == null || !fVar.a()) {
                        Log.i("WakeupWordSelection", "onWordSelected id=" + wordId);
                        if (wakeupWordSelectionActivity.q()) {
                            String wakeword = gVar.c;
                            kotlin.jvm.internal.k.f(wakeword, "wakeword");
                            com.stepos.statsrpk.d.G("oobe_wakeword_select", "oobe", kotlin.collections.a.R(new Pair("page_name", "oobe"), new Pair("wakeword", wakeword)));
                        }
                        kotlin.jvm.internal.k.f(wordId, "wordId");
                        if (wordId.length() > 0) {
                            SharedPreferences sharedPreferences = wakeupWordSelectionActivity.getApplicationContext().getSharedPreferences("voice_wakeup_active_word", 0);
                            Set<String> set = EmptySet.f4895a;
                            Set<String> stringSet = sharedPreferences.getStringSet("trained_ids", set);
                            if (stringSet != null) {
                                set = stringSet;
                            }
                            if (v.j1(set).contains(wordId)) {
                                A6.g gVar2 = wakeupWordSelectionActivity.f3347a;
                                if (gVar2 == null || !gVar2.isShowing()) {
                                    Q.a aVarR = z2.l.r(wakeupWordSelectionActivity, true);
                                    n nVar = (n) aVarR.b;
                                    nVar.b = nVar.f153a.getText(R.string.voice_wake_word_overwrite_title);
                                    nVar.d = nVar.f153a.getText(R.string.voice_wake_word_overwrite_message);
                                    c cVar = new c(2);
                                    nVar.h = nVar.f153a.getText(R.string.voice_wake_word_overwrite_cancel);
                                    nVar.i = cVar;
                                    DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: G4.l
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i10) {
                                            int i11 = WakeupWordSelectionActivity.f;
                                            dialogInterface.dismiss();
                                            wakeupWordSelectionActivity.r(gVar);
                                        }
                                    };
                                    nVar.f = nVar.f153a.getText(R.string.voice_wake_word_overwrite_confirm);
                                    nVar.g = onClickListener;
                                    A6.g gVarC = aVarR.c();
                                    wakeupWordSelectionActivity.f3347a = gVarC;
                                    if (wakeupWordSelectionActivity.q() && (window = gVarC.getWindow()) != null) {
                                        window.addFlags(8192);
                                    }
                                    gVarC.show();
                                    break;
                                }
                            }
                        }
                        wakeupWordSelectionActivity.r(gVar);
                        break;
                    }
                }
                break;
            default:
                PolicyHtmlViewerActivity.showNotNetWorkView$lambda$8$lambda$7((PolicyHtmlViewerActivity) fragmentActivity, (S7.k) obj, view);
                break;
        }
    }
}
