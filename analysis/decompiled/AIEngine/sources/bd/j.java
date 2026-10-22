package bd;

import ad.i;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentManager;
import com.stepos.aiengine.R;
import com.stepos.aiengine.modelmanager.settings.AiEngineSettingsActivity;
import com.stepos.aiengine.modelmanager.settings.AiEngineSettingsFragment;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.core.ota.confirmui.ModelConfirmFlow;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements i.c, ConfirmDecisionBus.DecisionListener, d.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f3234g;

    public /* synthetic */ j(Object obj) {
        this.f3234g = obj;
    }

    @Override // d.a
    public void a(Object obj) {
        AiEngineSettingsActivity aiEngineSettingsActivity = (AiEngineSettingsActivity) this.f3234g;
        ActivityResult result = (ActivityResult) obj;
        int i10 = AiEngineSettingsActivity.f5904d;
        kotlin.jvm.internal.g.f(result, "result");
        if (result.getResultCode() != -1) {
            aiEngineSettingsActivity.finish();
            return;
        }
        FragmentManager supportFragmentManager = aiEngineSettingsActivity.getSupportFragmentManager();
        supportFragmentManager.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(supportFragmentManager);
        aVar.e(new AiEngineSettingsFragment(), R.id.settings_container);
        aVar.g(false);
    }

    @Override // ad.i.c
    public ad.i b(okhttp3.internal.connection.d dVar) {
        ad.i this_asFactory = (ad.i) this.f3234g;
        kotlin.jvm.internal.g.f(this_asFactory, "$this_asFactory");
        return this_asFactory;
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.DecisionListener
    public void onDecision(ConfirmDecisionBus.Decision decision) {
        ModelConfirmFlow.showConfirm$lambda$33((ModelConfirmFlow) this.f3234g, decision);
    }
}
