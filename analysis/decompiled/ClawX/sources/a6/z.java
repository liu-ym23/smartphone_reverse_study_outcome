package a6;

import android.content.Context;
import com.stepos.stepclaw.GatewayRuntime;
import com.stepos.stepclaw.StepClawManager;
import com.stepos.stepclaw.UserSetupCompletionGate;
import com.stepos.stepclaw.base.net.StepOSProxyServer;
import com.stepos.stepclaw.base.track.ClawEventReporter;
import com.stepos.stepclaw.chroot.AssetManifest;
import com.stepos.stepclaw.chroot.ChrootRootfsInitializer;
import com.stepos.stepclaw.chroot.InstalledVersions;
import com.stepos.stepclaw.chroot.OpenClawPackageInstaller;
import com.stepos.stepclaw.config.ConfigGuardObserver;
import com.stepos.stepclaw.config.GatewayTokenDeriver;
import com.stepos.stepclaw.gateway.DeviceIdentityStore;
import com.stepos.stepclaw.gateway.GatewayAutoStart;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.JsonBuilder;
import org.bouncycastle.asn1.BERTags;
import org.json.JSONObject;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class z implements p5.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f229a;

    public /* synthetic */ z(int i8) {
        this.f229a = i8;
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        switch (this.f229a) {
            case 0:
                f5.f fVar = (f5.f) obj;
                if (fVar instanceof b0) {
                    return (b0) fVar;
                }
                return null;
            case 1:
                a4.c createClientPlugin = (a4.c) obj;
                kotlin.jvm.internal.p.e(createClientPlugin, "$this$createClientPlugin");
                b4.c cVar = (b4.c) createClientPlugin.f93b;
                ArrayList arrayList = cVar.f854b;
                Set set = cVar.f853a;
                createClientPlugin.a(a4.i.d, new b4.e(createClientPlugin, null, arrayList, set));
                createClientPlugin.a(a4.i.f112e, new b4.f(createClientPlugin, null, arrayList, set));
                return b5.a0.f883a;
            case 2:
                b4.b it = (b4.b) obj;
                kotlin.jvm.internal.p.e(it, "it");
                return it.f850a.toString();
            case 3:
                return GatewayRuntime.triggerChrootOtaSelfHeal$lambda$1((String) obj);
            case 4:
                return GatewayRuntime.maybeAutoStartGateway$lambda$0$1((String) obj);
            case 5:
                return GatewayRuntime.gatewaySession$lambda$3$1((String) obj);
            case 6:
                return GatewayRuntime.json$lambda$0((JsonBuilder) obj);
            case 7:
                return StepClawManager.init$lambda$0((String) obj);
            case 8:
                return UserSetupCompletionGate.resetForTest$lambda$0((Context) obj);
            case 9:
                return UserSetupCompletionGate.gatewayStarter$lambda$0((Context) obj);
            case 10:
                return StepOSProxyServer.httpClient$lambda$0$1$0((HttpURLConnection) obj);
            case BERTags.EMBEDDED_PDV /* 11 */:
                return StepOSProxyServer.httpClient$lambda$0$0((z3.r0) obj);
            case 12:
                return StepOSProxyServer.httpClient$lambda$0$1((x3.g) obj);
            case BERTags.RELATIVE_OID /* 13 */:
                return StepOSProxyServer.httpClient$lambda$0((t3.d) obj);
            case BERTags.TIME /* 14 */:
                return ClawEventReporter.extractTemperature$lambda$1((JSONObject) obj);
            case 15:
                return ClawEventReporter.extractTemperature$lambda$2((JSONObject) obj);
            case 16:
                return ClawEventReporter.subagentConfigAsInputText$lambda$0((Map.Entry) obj);
            case 17:
                return AssetManifest.json$lambda$0((JsonBuilder) obj);
            case BERTags.NUMERIC_STRING /* 18 */:
                return ChrootRootfsInitializer.sha256OfFile$lambda$1(((Byte) obj).byteValue());
            case 19:
                return ChrootRootfsInitializer.sha256OfAsset$lambda$1(((Byte) obj).byteValue());
            case 20:
                return ChrootRootfsInitializer.Companion.defaultUserDataManager$lambda$0((List) obj);
            case BERTags.VIDEOTEX_STRING /* 21 */:
                return InstalledVersions.json$lambda$0((JsonBuilder) obj);
            case BERTags.IA5_STRING /* 22 */:
                return OpenClawPackageInstaller.verifyInstalled$lambda$0((File) obj);
            case BERTags.UTC_TIME /* 23 */:
                return OpenClawPackageInstaller._init_$lambda$0((List) obj);
            case 24:
                return ConfigGuardObserver._init_$lambda$0((String) obj);
            case BERTags.GRAPHIC_STRING /* 25 */:
                return GatewayTokenDeriver.derive$lambda$0(((Byte) obj).byteValue());
            case BERTags.VISIBLE_STRING /* 26 */:
                return DeviceIdentityStore.json$lambda$0((JsonBuilder) obj);
            case BERTags.GENERAL_STRING /* 27 */:
                return GatewayAutoStart.restartGateway$lambda$1((String) obj);
            case BERTags.UNIVERSAL_STRING /* 28 */:
                return GatewayAutoStart.startGateway$lambda$1((String) obj);
            default:
                return GatewayAutoStart.handlePersistentConnectFailure$lambda$1((String) obj);
        }
    }
}
