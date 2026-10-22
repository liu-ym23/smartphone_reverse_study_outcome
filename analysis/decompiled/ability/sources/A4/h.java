package A4;

import com.stepos.ability.bean.ExplainSnapshot;
import com.stepos.aiengine.adapter.SpeechRecognitionAbilityAdapter;
import com.stepos.aiengine.algorithm.voice.SpeechRecognitionCallback;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.core.callback.a;
import com.stepos.core.callback.b;
import com.stepos.core.callback.c;
import com.stepos.core.data.MixedContent;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;
import xa.InterfaceC2124a;

/* loaded from: classes3.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f103a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ h(j jVar, String str, ExplainSnapshot explainSnapshot, String str2) {
        this.f103a = 0;
        this.b = jVar;
        this.c = str;
        this.e = explainSnapshot;
        this.d = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f103a) {
            case 0:
                j jVar = (j) this.b;
                String str = (String) this.c;
                ExplainSnapshot explainSnapshot = (ExplainSnapshot) this.e;
                String str2 = (String) this.d;
                try {
                    jVar.f105a.onExplainUpdated(str, explainSnapshot);
                    break;
                } catch (Throwable th) {
                    k.b(str2, "publishExplainUpdated", th);
                    return;
                }
            case 1:
                final SpeechRecognitionAbilityAdapter speechRecognitionAbilityAdapter = (SpeechRecognitionAbilityAdapter) this.b;
                AlgorithmToken algorithmToken = (AlgorithmToken) this.c;
                MixedContent mixedContent = (MixedContent) this.d;
                final SpeechRecognitionCallback speechRecognitionCallback = (SpeechRecognitionCallback) this.e;
                speechRecognitionAbilityAdapter.f3474a.g(String.valueOf(algorithmToken.getIdentity()), mixedContent, new com.stepos.core.d(speechRecognitionAbilityAdapter, speechRecognitionCallback) { // from class: com.stepos.aiengine.adapter.SpeechRecognitionAbilityAdapter$recognizeMultiFiles$2$1

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ SpeechRecognitionCallback f3477a;

                    {
                        this.f3477a = speechRecognitionCallback;
                    }

                    @Override // com.stepos.core.d
                    public void onNext(String inferId, c result) {
                        k.f(inferId, "inferId");
                        k.f(result, "result");
                        if (!(result instanceof b)) {
                            if (!result.equals(a.f3826a)) {
                                throw new NoWhenBranchMatchedException();
                            }
                        } else {
                            b bVar = (b) result;
                            this.f3477a.onError(bVar.f3827a, bVar.b);
                        }
                    }
                });
                break;
            default:
                wa.e eVar = (wa.e) this.b;
                za.i iVar = (za.i) this.c;
                za.g gVar = (za.g) this.d;
                Throwable th2 = (Throwable) this.e;
                eVar.getClass();
                try {
                    Iterator it = eVar.f6861a.iterator();
                    while (it.hasNext()) {
                        ((InterfaceC2124a) it.next()).onStepFailed(iVar, gVar, th2);
                    }
                    break;
                } catch (Exception e) {
                    com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepFailed", ": ", e.getMessage(), "TaskEventDispatcher");
                }
        }
    }

    public /* synthetic */ h(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.f103a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = obj4;
    }
}
