package com.stepos.core.ota.dump;

import ai.onnxruntime.a;
import android.content.Context;
import com.stepos.core.common.log.BaseDumpProvider;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.d;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.domain.TriggerSource;
import com.stepos.core.ota.process.OtaRuntime;
import com.stepos.core.ota.push.AutoUpdatePushLogic;
import com.stepos.core.ota.push.ModelAutoUpdateManager;
import com.stepos.core.ota.push.PrdAutoUpdateGate;
import com.stepos.core.ota.push.PrdForceUpdateGate;
import com.stepos.core.ota.remote.RemoteModelsRepository;
import com.stepos.core.ota.storage.ModelsVersionStore;
import gc.f;
import gc.o;
import h0.e;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.i;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaDumpProvider extends BaseDumpProvider {
    public OtaDumpProvider() {
        super("OTA", LogModule.OTA);
    }

    private final void dumpGate(PrintWriter printWriter) {
        Context contextRequireAppContext = OtaRuntime.INSTANCE.requireAppContext();
        printWriter.println("Model auto-update state:");
        String strDumpState = ModelAutoUpdateManager.INSTANCE.dumpState();
        g.f(strDumpState, "<this>");
        f fVar = new f(strDumpState);
        while (fVar.hasNext()) {
            d.r("  ", (String) fVar.next(), printWriter);
        }
        printWriter.println();
        printWriter.println("Silent update gate (PRD 3.3.2 + 2GB), candidate=0:");
        Iterator it = PrdAutoUpdateGate.diagnose$default(PrdAutoUpdateGate.INSTANCE, contextRequireAppContext, ModelAutoUpdateManager.INSTANCE.currentSilentSession(), false, 4, null).iterator();
        while (true) {
            String str = "FAIL";
            if (!it.hasNext()) {
                break;
            }
            AutoUpdatePushLogic.Check check = (AutoUpdatePushLogic.Check) it.next();
            if (check.getPass()) {
                str = "PASS";
            }
            String name = check.getName();
            String detail = check.getDetail();
            StringBuilder sbS = a.s("  [", str, "] ", name, " — ");
            sbS.append(detail);
            printWriter.println(sbS.toString());
        }
        printWriter.println();
        printWriter.println("Force update gate (PRD 3.3.3):");
        for (AutoUpdatePushLogic.Check check2 : PrdForceUpdateGate.INSTANCE.diagnose(contextRequireAppContext)) {
            String str2 = check2.getPass() ? "PASS" : "FAIL";
            String name2 = check2.getName();
            String detail2 = check2.getDetail();
            StringBuilder sbS2 = a.s("  [", str2, "] ", name2, " — ");
            sbS2.append(detail2);
            printWriter.println(sbS2.toString());
        }
    }

    @Override // com.stepos.core.common.log.BaseDumpProvider
    public void dumpContent(PrintWriter writer, String[] args) {
        g.f(writer, "writer");
        g.f(args, "args");
        for (String str : args) {
            if (o.f0(str, "gate")) {
                dumpGate(writer);
                return;
            }
        }
        writer.println("Installed model versions:");
        List<String> allRegisteredModels = ModelsVersionStore.INSTANCE.getAllRegisteredModels();
        if (allRegisteredModels.isEmpty()) {
            writer.println("  (none)");
        } else {
            for (String str2 : allRegisteredModels) {
                writer.println("  " + str2 + ": v" + ModelsVersionStore.INSTANCE.getVersionCode(str2));
            }
        }
        writer.println();
        writer.println("Remote update cache:");
        List<String> listDump = RemoteModelsRepository.INSTANCE.dump();
        if (listDump.isEmpty()) {
            writer.println("  (empty)");
        } else {
            Iterator<T> it = listDump.iterator();
            while (it.hasNext()) {
                d.r("  ", (String) it.next(), writer);
            }
        }
        writer.println();
        writer.println("OTA tasks (coordinator SSOT):");
        Map<String, OtaStateSnapshot> mapSnapshot = OtaRuntime.INSTANCE.snapshot();
        if (mapSnapshot.isEmpty()) {
            writer.println("  (none)");
        } else {
            for (OtaStateSnapshot otaStateSnapshot : mapSnapshot.values()) {
                String otaId = otaStateSnapshot.getOtaId();
                String strC = i.a(otaStateSnapshot.getState().getClass()).c();
                int progress = otaStateSnapshot.getProgress();
                int installedVersion = otaStateSnapshot.getInstalledVersion();
                TriggerSource primarySource = otaStateSnapshot.getPrimarySource();
                Set<TriggerSource> sources = otaStateSnapshot.getSources();
                StringBuilder sbS = a.s("  ", otaId, ": state=", strC, "  progress=");
                e.l(sbS, progress, "%  installedVer=", installedVersion, "  primary=");
                sbS.append(primarySource);
                sbS.append("  sources=");
                sbS.append(sources);
                writer.println(sbS.toString());
            }
        }
        writer.println();
        writer.println("Model auto-update pipeline:");
        String strDumpState = ModelAutoUpdateManager.INSTANCE.dumpState();
        g.f(strDumpState, "<this>");
        f fVar = new f(strDumpState);
        while (fVar.hasNext()) {
            d.r("  ", (String) fVar.next(), writer);
        }
        writer.println("  (use 'gate' arg for per-condition pass/fail)");
    }

    @Override // com.stepos.core.common.log.BaseDumpProvider, com.stepos.core.common.log.IDumpProvider
    public void dumpStats(PrintWriter writer) {
        g.f(writer, "writer");
        int size = ModelsVersionStore.INSTANCE.getAllRegisteredModels().size();
        Collection<OtaStateSnapshot> collectionValues = OtaRuntime.INSTANCE.snapshot().values();
        int i10 = 0;
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                if (((OtaStateSnapshot) it.next()).getState().isActive() && (i10 = i10 + 1) < 0) {
                    m.e0();
                    throw null;
                }
            }
        }
        writer.println(d.e(size, "OTA: ", i10, " models installed, ", " active tasks"));
    }

    @Override // com.stepos.core.common.log.BaseDumpProvider, com.stepos.core.common.log.IDumpProvider
    public String getHelp() {
        return "OTA: installed model versions, remote update cache, active downloads, push pending queue; arg 'gate' → per-condition silent/force update gate pass/fail";
    }
}
