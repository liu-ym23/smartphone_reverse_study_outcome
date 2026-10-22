package c5;

import a6.h1;
import a6.j1;
import a6.p1;
import a6.s0;
import a6.v1;
import android.net.ConnectivityManager;
import android.net.Network;
import b5.a0;
import com.stepos.stepclaw.GatewayRuntime;
import com.stepos.stepclaw.base.net.StepOSProxyServer;
import com.stepos.stepclaw.gateway.GatewayDiscovery;
import com.stepos.stepclaw.provider.handlers.ToolsHandler;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.f0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptorKt;
import kotlinx.serialization.internal.TripleSerializer;
import kotlinx.serialization.modules.SerializersModuleCollector;
import org.bouncycastle.asn1.BERTags;
import z3.k0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements p5.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1077a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1078b;

    public /* synthetic */ a(int i8, Object obj) {
        this.f1077a = i8;
        this.f1078b = obj;
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        String strA;
        int i8 = this.f1077a;
        Object obj2 = this.f1078b;
        switch (i8) {
            case 0:
                return obj == ((b) obj2) ? "(this Collection)" : String.valueOf(obj);
            case 1:
                return GatewayRuntime.gatewaySession$lambda$1((GatewayRuntime) obj2, (String) obj);
            case 2:
                return StepOSProxyServer.handleClient$lambda$2((h4.c) obj2, (String) obj);
            case 3:
                return GatewayDiscovery.createDirectResolver$lambda$1((ConnectivityManager) obj2, (Network) obj);
            case 4:
                return Boolean.valueOf(ToolsHandler.setEnable$lambda$0$3((String) obj2, (String) obj));
            case 5:
                ((i6.c) obj2).e(null);
                return a0.f883a;
            case 6:
                io.ktor.utils.io.m mVar = (io.ktor.utils.io.m) obj2;
                Throwable th = (Throwable) obj;
                if (th != null && !mVar.k()) {
                    mVar.c(th);
                }
                return a0.f883a;
            case 7:
                ((b7.c) obj2).invoke();
                return a0.f883a;
            case 8:
                StringBuilder sb = (StringBuilder) obj2;
                Byte b9 = (Byte) obj;
                byte bByteValue = b9.byteValue();
                if (bByteValue == 32) {
                    sb.append("%20");
                } else if (k4.b.f3588a.contains(b9) || k4.b.f3590c.contains(b9)) {
                    sb.append((char) bByteValue);
                } else {
                    sb.append(k4.b.g(bByteValue));
                }
                return a0.f883a;
            case 9:
                v5.k it = (v5.k) obj;
                kotlin.jvm.internal.p.e(it, "it");
                ((f0) obj2).getClass();
                v5.l lVar = it.f5987a;
                v5.i iVar = it.f5988b;
                if (lVar == null) {
                    return "*";
                }
                f0 f0Var = iVar instanceof f0 ? (f0) iVar : null;
                String strValueOf = (f0Var == null || (strA = f0Var.a(true)) == null) ? String.valueOf(iVar) : strA;
                int iOrdinal = lVar.ordinal();
                if (iOrdinal == 0) {
                    return strValueOf;
                }
                if (iOrdinal == 1) {
                    return "in ".concat(strValueOf);
                }
                if (iOrdinal == 2) {
                    return "out ".concat(strValueOf);
                }
                throw new a6.w();
            case 10:
                return ObjectSerializer.descriptor_delegate$lambda$0$0((ObjectSerializer) obj2, (ClassSerialDescriptorBuilder) obj);
            case BERTags.EMBEDDED_PDV /* 11 */:
                return PluginGeneratedSerialDescriptorKt.toStringImpl$lambda$0((SerialDescriptor) obj2, ((Integer) obj).intValue());
            case 12:
                return TripleSerializer.descriptor$lambda$0((TripleSerializer) obj2, (ClassSerialDescriptorBuilder) obj);
            case BERTags.RELATIVE_OID /* 13 */:
                return SerializersModuleCollector.contextual$lambda$0((KSerializer) obj2, (List) obj);
            case BERTags.TIME /* 14 */:
                z3.y yVar = (z3.y) obj2;
                t3.c scope = (t3.c) obj;
                kotlin.jvm.internal.p.e(scope, "scope");
                r4.d dVar = (r4.d) scope.f5574j.a(z3.z.f6527a, new q3.a(4));
                Object obj3 = scope.f5576l.f5578b.get(yVar.getKey());
                kotlin.jvm.internal.p.b(obj3);
                Object objA = yVar.a((p5.l) obj3);
                yVar.b(objA, scope);
                dVar.e(yVar.getKey(), objA);
                return a0.f883a;
            case 15:
                ((x3.d) obj2).close();
                return a0.f883a;
            case 16:
                return ((x5.i) obj2).g(((Integer) obj).intValue());
            case 17:
                h1 h1Var = (a6.t) obj2;
                Throwable th2 = (Throwable) obj;
                z7.b bVar = k0.f6470a;
                if (th2 != null) {
                    bVar.h("Cancelling request because engine Job failed with error: " + th2);
                    CancellationException cancellationException = new CancellationException("Engine failed");
                    cancellationException.initCause(th2);
                    ((p1) h1Var).e(cancellationException);
                } else {
                    bVar.h("Cancelling request because engine Job completed");
                    ((j1) h1Var).f0();
                }
                return a0.f883a;
            case BERTags.NUMERIC_STRING /* 18 */:
                ((s0) obj2).b();
                return a0.f883a;
            default:
                ((v1) obj2).e(null);
                return a0.f883a;
        }
    }

    public /* synthetic */ a(i6.c cVar, i6.b bVar) {
        this.f1077a = 5;
        this.f1078b = cVar;
    }
}
