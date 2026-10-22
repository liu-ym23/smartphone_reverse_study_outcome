package b6;

import com.stepos.aiengine.AIEngineApplication;
import com.stepos.core.common.telemetry.scene.AiStageSceneDonator;
import kotlin.coroutines.d;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.ThreadContextElement;
import kotlinx.coroutines.internal.ThreadContextKt;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3064a;

    public /* synthetic */ f(int i10) {
        this.f3064a = i10;
    }

    @Override // zb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f3064a) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                String modelId = (String) obj2;
                int i10 = AIEngineApplication.f5748d;
                kotlin.jvm.internal.g.f(modelId, "modelId");
                AiStageSceneDonator.INSTANCE.onDecrypt(true, zBooleanValue, modelId);
                return n.f10413a;
            case 1:
                Long a10 = (Long) obj;
                Long b10 = (Long) obj2;
                kotlin.jvm.internal.g.f(a10, "a");
                kotlin.jvm.internal.g.f(b10, "b");
                return Long.valueOf(b10.longValue() + a10.longValue());
            case 2:
                return Boolean.valueOf(CoroutineContextKt.hasCopyableElements$lambda$0(((Boolean) obj).booleanValue(), (d.a) obj2));
            case 3:
                return CoroutineContextKt.foldCopies$lambda$2((kotlin.coroutines.d) obj, (d.a) obj2);
            case 4:
                return ThreadContextKt.findOne$lambda$1((ThreadContextElement) obj, (d.a) obj2);
            default:
                String acc = (String) obj;
                d.a element = (d.a) obj2;
                kotlin.jvm.internal.g.f(acc, "acc");
                kotlin.jvm.internal.g.f(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + ", " + element;
        }
    }
}
