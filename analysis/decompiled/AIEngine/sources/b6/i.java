package b6;

import android.content.Context;
import b7.k;
import com.stepos.aicgroup.AiDispatchersManager;
import com.stepos.aiengine.AIEngineApplication;
import com.stepos.backend.llama.LlamaModelInitializer;
import com.stepos.backend.mnn.MnnModelInitializer;
import com.stepos.backend.onnx.TenVadOnnxModelInitializer;
import com.stepos.backend.qnn.QnnASRModel;
import com.stepos.backend.qnn.QnnModelInitializer;
import com.stepos.core.ability.AbilityManager;
import com.stepos.core.ability.converter.AbilityOutputConverter;
import com.stepos.core.ability.pipeline.TypeAdapter;
import com.stepos.core.common.cloud.CloudConnectionWarmer;
import com.stepos.core.model.concurrency.ThreadPoolManagerImpl;
import com.stepos.core.ota.crypto.attest.DeviceKeyProbe;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import gc.o;
import java.io.File;
import lb.n;
import v6.d;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3069a;

    public /* synthetic */ i(int i10) {
        this.f3069a = i10;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        switch (this.f3069a) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                int i10 = AIEngineApplication.f5748d;
                ThreadPoolManagerImpl threadPoolManagerImplLatestInstanceOrNull = ThreadPoolManagerImpl.Companion.latestInstanceOrNull();
                if (threadPoolManagerImplLatestInstanceOrNull != null) {
                    if (zBooleanValue) {
                        threadPoolManagerImplLatestInstanceOrNull.pauseNormalBgDispatch("camera");
                    } else {
                        threadPoolManagerImplLatestInstanceOrNull.resumeNormalBgDispatch("camera");
                    }
                }
                return n.f10413a;
            case 1:
                File it = (File) obj;
                kotlin.jvm.internal.g.f(it, "it");
                String name = it.getName();
                kotlin.jvm.internal.g.e(name, "getName(...)");
                boolean z = false;
                if (!o.k0(name, ".", false) && !mb.l.s0(new String[]{"META-INF", "lib", "libs"}).contains(it.getName())) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 2:
                File it2 = (File) obj;
                kotlin.jvm.internal.g.f(it2, "it");
                String name2 = it2.getName();
                kotlin.jvm.internal.g.e(name2, "getName(...)");
                return name2;
            case 3:
                kotlin.jvm.internal.g.f((Context) obj, "it");
                c6.d.f3293a.getClass();
                c6.d.a();
                return n.f10413a;
            case 4:
                return DeviceKeyProbe.dumpAuthList$lambda$51(((Long) obj).longValue());
            case 5:
                boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
                v5.a aVar = v5.b.f13381a;
                if (zBooleanValue2) {
                    aVar.a(3, "Ability_".concat("Ability_AgentServiceClient"), "Bind service success !", null);
                } else {
                    aVar.a(6, "Ability_".concat("Ability_AgentServiceClient"), "Bind service failed !", null);
                }
                return n.f10413a;
            case 6:
                Integer num = (Integer) obj;
                num.intValue();
                AiDispatchersManager.f5619g = num;
                return n.f10413a;
            case 7:
                Integer num2 = (Integer) obj;
                num2.intValue();
                AiDispatchersManager.f5620i = num2;
                return n.f10413a;
            case 8:
                Integer num3 = (Integer) obj;
                num3.intValue();
                AiDispatchersManager.h = num3;
                return n.f10413a;
            case 9:
                return LlamaModelInitializer.initialize$lambda$1((k) obj);
            case 10:
                return MnnModelInitializer.initialize$lambda$0((k) obj);
            case 11:
                return MnnModelInitializer.initialize$lambda$10((k) obj);
            case 12:
                return MnnModelInitializer.initialize$lambda$2((k) obj);
            case 13:
                return MnnModelInitializer.initialize$lambda$4((k) obj);
            case 14:
                return MnnModelInitializer.initialize$lambda$6((k) obj);
            case 15:
                return MnnModelInitializer.initialize$lambda$8((k) obj);
            case 16:
                return TenVadOnnxModelInitializer.initialize$lambda$0((k) obj);
            case 17:
                return QnnASRModel.doInfer$lambda$1((d.q) obj);
            case 18:
                return QnnModelInitializer.initialize$lambda$0((k) obj);
            case 19:
                return QnnModelInitializer.initialize$lambda$2((k) obj);
            case 20:
                return QnnModelInitializer.initialize$lambda$4((k) obj);
            case 21:
                return QnnModelInitializer.initialize$lambda$6((k) obj);
            case 22:
                return QnnModelInitializer.initialize$lambda$8((k) obj);
            case 23:
                return AbilityManager.initialize$lambda$22((String) obj);
            case ErrorCodes.GET_INSTANCE_METHOD_INVOCATION_ERROR /* 24 */:
                return AbilityManager.setAbilityProperty$lambda$48((String) obj);
            case 25:
                return AbilityOutputConverter.convert$lambda$6((d.g) obj);
            case 26:
                return AbilityOutputConverter.convertDetectionOutput$lambda$21((v6.a) obj);
            case 27:
                return TypeAdapter.rules$lambda$2((v6.d) obj);
            case ErrorCodes.GET_CONTENT_URI_ERROR /* 28 */:
                return TypeAdapter.rules$lambda$4((v6.d) obj);
            default:
                return CloudConnectionWarmer.warm$lambda$2((String) obj);
        }
    }
}
