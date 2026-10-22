package b6;

import android.content.Context;
import b7.k;
import com.stepos.aicgroup.AiDispatchersManager;
import com.stepos.aicgroup.memory.PressureLevel;
import com.stepos.aiengine.AIEngineApplication;
import com.stepos.backend.llama.LlamaModelInitializer;
import com.stepos.backend.mnn.MnnModelInitializer;
import com.stepos.backend.onnx.OnnxModelInitializer;
import com.stepos.backend.qnn.QnnASRModel;
import com.stepos.backend.qnn.QnnModelInitializer;
import com.stepos.core.ability.converter.AbilityOutputConverter;
import com.stepos.core.ability.pipeline.TypeAdapter;
import com.stepos.core.common.cloudconfig.CloudConfigStore;
import com.stepos.core.common.log.LogEntry;
import com.stepos.core.common.log.LogStatistics;
import com.stepos.core.common.log.Sanitizer;
import com.stepos.core.common.runtime.EngineRuntimeConfig;
import com.stepos.core.model.concurrency.ThreadPoolManagerImpl;
import com.stepos.core.ota.crypto.attest.DeviceKeyProbe;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import lb.n;
import v6.d;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3063a;

    public /* synthetic */ e(int i10) {
        this.f3063a = i10;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        long pressureUltraLowCooldownMs;
        switch (this.f3063a) {
            case 0:
                PressureLevel level = (PressureLevel) obj;
                int i10 = AIEngineApplication.f5748d;
                kotlin.jvm.internal.g.f(level, "level");
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                int i11 = AIEngineApplication.a.f5752a[level.ordinal()];
                if (i11 == 1) {
                    pressureUltraLowCooldownMs = EngineRuntimeConfig.INSTANCE.getSnapshot().getPressureUltraLowCooldownMs();
                } else if (i11 == 2) {
                    pressureUltraLowCooldownMs = EngineRuntimeConfig.INSTANCE.getSnapshot().getPressureLowCooldownMs();
                } else {
                    if (i11 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    pressureUltraLowCooldownMs = EngineRuntimeConfig.INSTANCE.getSnapshot().getPressureNormalCooldownMs();
                }
                return Long.valueOf(timeUnit.toNanos(pressureUltraLowCooldownMs));
            case 1:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                int i12 = AIEngineApplication.f5748d;
                ThreadPoolManagerImpl threadPoolManagerImplLatestInstanceOrNull = ThreadPoolManagerImpl.Companion.latestInstanceOrNull();
                if (threadPoolManagerImplLatestInstanceOrNull != null) {
                    if (zBooleanValue) {
                        threadPoolManagerImplLatestInstanceOrNull.pauseNormalBgDispatch("pressure");
                    } else {
                        threadPoolManagerImplLatestInstanceOrNull.resumeNormalBgDispatch("pressure");
                    }
                }
                return n.f10413a;
            case 2:
                Context it = (Context) obj;
                kotlin.jvm.internal.g.f(it, "it");
                c6.d.f3293a.getClass();
                c6.d.a();
                return n.f10413a;
            case 3:
                return DeviceKeyProbe.dumpAuthList$lambda$48(((Long) obj).longValue());
            case 4:
                return DeviceKeyProbe.dumpAuthList$lambda$52(((Long) obj).longValue());
            case 5:
                Integer num = (Integer) obj;
                num.intValue();
                AiDispatchersManager.f5622k = num;
                return n.f10413a;
            case 6:
                Integer num2 = (Integer) obj;
                num2.intValue();
                AiDispatchersManager.f5623l = num2;
                return n.f10413a;
            case 7:
                Integer num3 = (Integer) obj;
                num3.intValue();
                AiDispatchersManager.f5621j = num3;
                return n.f10413a;
            case 8:
                return LlamaModelInitializer.initialize$lambda$0((k) obj);
            case 9:
                return LlamaModelInitializer.initialize$lambda$2((k) obj);
            case 10:
                return MnnModelInitializer.initialize$lambda$9((k) obj);
            case 11:
                return MnnModelInitializer.initialize$lambda$1((k) obj);
            case 12:
                return MnnModelInitializer.initialize$lambda$3((k) obj);
            case 13:
                return MnnModelInitializer.initialize$lambda$5((k) obj);
            case 14:
                return MnnModelInitializer.initialize$lambda$7((k) obj);
            case 15:
                return OnnxModelInitializer.initialize$lambda$0((k) obj);
            case 16:
                return QnnASRModel.doInfer$lambda$0((d.a) obj);
            case 17:
                return QnnModelInitializer.initialize$lambda$1((k) obj);
            case 18:
                return QnnModelInitializer.initialize$lambda$3((k) obj);
            case 19:
                return QnnModelInitializer.initialize$lambda$5((k) obj);
            case 20:
                return QnnModelInitializer.initialize$lambda$7((k) obj);
            case 21:
                return QnnModelInitializer.initialize$lambda$9((k) obj);
            case 22:
                return AbilityOutputConverter.convertClassificationOutput$lambda$22((Pair) obj);
            case 23:
                return AbilityOutputConverter.convert$lambda$9((d.j) obj);
            case ErrorCodes.GET_INSTANCE_METHOD_INVOCATION_ERROR /* 24 */:
                return TypeAdapter.rules$lambda$0((v6.d) obj);
            case 25:
                return TypeAdapter.rules$lambda$3((v6.d) obj);
            case 26:
                return CloudConfigStore.sha8$lambda$9(((Byte) obj).byteValue());
            case 27:
                return LogEntry.formatFull$lambda$3$lambda$2((Map.Entry) obj);
            case ErrorCodes.GET_CONTENT_URI_ERROR /* 28 */:
                return LogStatistics.toString$lambda$9((Map.Entry) obj);
            default:
                return Sanitizer.hashHex$lambda$2$lambda$1(((Byte) obj).byteValue());
        }
    }
}
