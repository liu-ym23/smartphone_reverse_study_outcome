package H4;

import android.view.serialization.SavedStateConfiguration;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.saveable.serialization.SerializableSaverKt;
import g1.AbstractC1451a;
import kotlin.jvm.internal.Ref$IntRef;

/* loaded from: classes3.dex */
public final /* synthetic */ class l implements S7.n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f744a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ l(int i, Object obj, Object obj2) {
        this.f744a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        final float fS;
        switch (this.f744a) {
            case 0:
                Long l = (Long) this.b;
                final com.stepos.ability.voicewakeup.training.b bVar = (com.stepos.ability.voicewakeup.training.b) this.c;
                short[] samples = (short[]) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (l != null) {
                    final long jLongValue = l.longValue();
                    bVar.getClass();
                    kotlin.jvm.internal.k.f(samples, "samples");
                    if (iIntValue > 0) {
                        int iU = AbstractC1451a.u(iIntValue, 0, samples.length);
                        if (iU == 0) {
                            fS = 0.0f;
                        } else {
                            double d = 0.0d;
                            for (int i = 0; i < iU; i++) {
                                double d6 = samples[i] / 32767;
                                d += d6 * d6;
                            }
                            double dSqrt = Math.sqrt(d / iU) - 0.006d;
                            fS = (float) AbstractC1451a.s(Math.pow(dSqrt >= 0.0d ? dSqrt : 0.0d, 0.35d) * 3.0d, 0.0d, 1.0d);
                        }
                        bVar.f3395a.post(new Runnable() { // from class: H4.s
                            @Override // java.lang.Runnable
                            public final void run() {
                                bVar.c.c(jLongValue, fS);
                            }
                        });
                    }
                }
                return C7.r.f317a;
            case 1:
                H7.h[] hVarArr = (H7.h[]) this.b;
                Ref$IntRef ref$IntRef = (Ref$IntRef) this.c;
                H7.f element = (H7.f) obj2;
                kotlin.jvm.internal.k.f((C7.r) obj, "<unused var>");
                kotlin.jvm.internal.k.f(element, "element");
                int i6 = ref$IntRef.f4918a;
                ref$IntRef.f4918a = i6 + 1;
                hVarArr[i6] = element;
                return C7.r.f317a;
            case 2:
                return ComposerKt.deactivateCurrentGroup$lambda$3((RememberManager) this.b, (SlotWriter) this.c, ((Integer) obj).intValue(), obj2);
            default:
                return SerializableSaverKt.serializableSaver$lambda$0((x9.b) this.b, (SavedStateConfiguration) this.c, (SaverScope) obj, obj2);
        }
    }
}
