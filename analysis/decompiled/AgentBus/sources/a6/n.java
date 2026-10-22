package a6;

import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class n {
    public static /* synthetic */ Object addCronJob$default(o oVar, d dVar, w wVar, g7.d dVar2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addCronJob");
        }
        if ((i2 & 2) != 0) {
            wVar = w.AUTO;
        }
        return oVar.b(dVar, wVar, dVar2);
    }

    public static /* synthetic */ Object configureChannel$default(o oVar, String str, Map map, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: configureChannel");
        }
        if ((i2 & 4) != 0) {
            v vVar = w.Companion;
        }
        return oVar.D(str, map, dVar);
    }

    public static /* synthetic */ Object exportBackup$default(o oVar, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exportBackup");
        }
        if ((i2 & 1) != 0) {
            v vVar = w.Companion;
        }
        return oVar.l(dVar);
    }

    public static /* synthetic */ Object getGatewayStatus$default(o oVar, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGatewayStatus");
        }
        if ((i2 & 1) != 0) {
            wVar = w.AUTO;
        }
        return oVar.w(wVar, dVar);
    }

    public static /* synthetic */ Object getModelConfig$default(o oVar, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getModelConfig");
        }
        if ((i2 & 1) != 0) {
            wVar = w.AUTO;
        }
        return oVar.q(wVar, dVar);
    }

    public static Set<String> getSupportedNamespaces(o oVar) {
        return d7.n.x0(new String[]{"skills", "tools", "config", "files", "cronjobs", "channels", "gateway"});
    }

    public static /* synthetic */ Object importBackup$default(o oVar, String str, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: importBackup");
        }
        if ((i2 & 2) != 0) {
            v vVar = w.Companion;
        }
        return oVar.A(str, dVar);
    }

    public static /* synthetic */ Object installChannel$default(o oVar, h hVar, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: installChannel");
        }
        if ((i2 & 2) != 0) {
            v vVar = w.Companion;
        }
        return oVar.h(hVar, dVar);
    }

    public static /* synthetic */ Object installSkill$default(o oVar, h hVar, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: installSkill");
        }
        if ((i2 & 2) != 0) {
            wVar = w.AUTO;
        }
        return oVar.z(hVar, wVar, dVar);
    }

    public static /* synthetic */ Object installTool$default(o oVar, h hVar, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: installTool");
        }
        if ((i2 & 2) != 0) {
            v vVar = w.Companion;
        }
        return oVar.C(hVar, dVar);
    }

    public static /* synthetic */ Object listChannels$default(o oVar, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listChannels");
        }
        if ((i2 & 1) != 0) {
            wVar = w.AUTO;
        }
        return oVar.x(wVar, dVar);
    }

    public static /* synthetic */ Object listCronJobs$default(o oVar, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listCronJobs");
        }
        if ((i2 & 1) != 0) {
            wVar = w.AUTO;
        }
        return oVar.g(wVar, dVar);
    }

    public static /* synthetic */ Object listSkills$default(o oVar, y yVar, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listSkills");
        }
        if ((i2 & 1) != 0) {
            yVar = null;
        }
        if ((i2 & 2) != 0) {
            wVar = w.AUTO;
        }
        return oVar.G(yVar, wVar, dVar);
    }

    public static /* synthetic */ Object listTools$default(o oVar, a0 a0Var, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listTools");
        }
        if ((i2 & 1) != 0) {
            a0Var = null;
        }
        if ((i2 & 2) != 0) {
            wVar = w.AUTO;
        }
        return oVar.u(a0Var, wVar, dVar);
    }

    public static /* synthetic */ Object readCoreFile$default(o oVar, c cVar, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readCoreFile");
        }
        if ((i2 & 2) != 0) {
            wVar = w.AUTO;
        }
        return oVar.f(cVar, wVar, dVar);
    }

    public static /* synthetic */ Object readCronRunLogs$default(o oVar, int i2, String str, w wVar, g7.d dVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readCronRunLogs");
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            wVar = w.AUTO;
        }
        return oVar.F(i2, str, wVar, dVar);
    }

    public static /* synthetic */ Object readFile$default(o oVar, String str, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readFile");
        }
        if ((i2 & 2) != 0) {
            v vVar = w.Companion;
        }
        return oVar.r(str, dVar);
    }

    public static /* synthetic */ Object readSkillMd$default(o oVar, String str, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readSkillMd");
        }
        if ((i2 & 2) != 0) {
            wVar = w.AUTO;
        }
        return oVar.E(str, wVar, dVar);
    }

    public static /* synthetic */ Object removeCronJob$default(o oVar, String str, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeCronJob");
        }
        if ((i2 & 2) != 0) {
            wVar = w.AUTO;
        }
        return oVar.B(str, wVar, dVar);
    }

    public static /* synthetic */ Object restartGateway$default(o oVar, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: restartGateway");
        }
        if ((i2 & 1) != 0) {
            wVar = w.AUTO;
        }
        return oVar.j(wVar, dVar);
    }

    public static /* synthetic */ Object restoreDefaults$default(o oVar, Set set, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: restoreDefaults");
        }
        if ((i2 & 2) != 0) {
            v vVar = w.Companion;
        }
        return oVar.t(set, dVar);
    }

    public static /* synthetic */ Object setChannelEnabled$default(o oVar, String str, boolean z4, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setChannelEnabled");
        }
        if ((i2 & 4) != 0) {
            wVar = w.AUTO;
        }
        return oVar.e(str, z4, wVar, dVar);
    }

    public static /* synthetic */ Object setCronJobEnabled$default(o oVar, String str, boolean z4, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCronJobEnabled");
        }
        if ((i2 & 4) != 0) {
            wVar = w.AUTO;
        }
        return oVar.a(str, z4, wVar, dVar);
    }

    public static /* synthetic */ Object setModelConfig$default(o oVar, l lVar, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setModelConfig");
        }
        if ((i2 & 2) != 0) {
            wVar = w.AUTO;
        }
        return oVar.p(lVar, wVar, dVar);
    }

    public static /* synthetic */ Object setSkillEnabled$default(o oVar, String str, boolean z4, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSkillEnabled");
        }
        if ((i2 & 4) != 0) {
            wVar = w.AUTO;
        }
        return oVar.d(str, z4, wVar, dVar);
    }

    public static /* synthetic */ Object setToolEnabled$default(o oVar, String str, boolean z4, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setToolEnabled");
        }
        if ((i2 & 4) != 0) {
            wVar = w.AUTO;
        }
        return oVar.k(str, z4, wVar, dVar);
    }

    public static /* synthetic */ Object uninstallChannel$default(o oVar, String str, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uninstallChannel");
        }
        if ((i2 & 2) != 0) {
            wVar = w.AUTO;
        }
        return oVar.n(str, wVar, dVar);
    }

    public static /* synthetic */ Object uninstallSkill$default(o oVar, String str, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uninstallSkill");
        }
        if ((i2 & 2) != 0) {
            wVar = w.AUTO;
        }
        return oVar.y(str, wVar, dVar);
    }

    public static /* synthetic */ Object uninstallTool$default(o oVar, String str, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uninstallTool");
        }
        if ((i2 & 2) != 0) {
            v vVar = w.Companion;
        }
        return oVar.o(str, dVar);
    }

    public static /* synthetic */ Object updateSkill$default(o oVar, d0 d0Var, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSkill");
        }
        if ((i2 & 2) != 0) {
            wVar = w.AUTO;
        }
        return oVar.c(d0Var, wVar, dVar);
    }

    public static /* synthetic */ Object updateTool$default(o oVar, d0 d0Var, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateTool");
        }
        if ((i2 & 2) != 0) {
            v vVar = w.Companion;
        }
        return oVar.s(d0Var, dVar);
    }

    public static /* synthetic */ Object writeCoreFile$default(o oVar, c cVar, String str, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeCoreFile");
        }
        if ((i2 & 4) != 0) {
            wVar = w.AUTO;
        }
        return oVar.H(cVar, str, wVar, dVar);
    }

    public static /* synthetic */ Object writeFile$default(o oVar, String str, String str2, w wVar, g7.d dVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeFile");
        }
        if ((i2 & 4) != 0) {
            v vVar = w.Companion;
        }
        return oVar.i(str, str2, dVar);
    }
}
