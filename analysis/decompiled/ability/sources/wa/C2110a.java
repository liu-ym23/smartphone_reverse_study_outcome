package wa;

import D7.A;
import N9.j;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.model.SessionState;
import t6.i;
import xa.InterfaceC2124a;

/* renamed from: wa.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2110a {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f6857a = new ConcurrentHashMap();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final e c = new e();

    public final void a(String sessionId) {
        k.f(sessionId, "sessionId");
        this.f6857a.remove(sessionId);
        Set setKeySet = this.b.keySet();
        k.e(setKeySet, "<get-keys>(...)");
        A.j0(setKeySet, new i(sessionId, 2));
        j.H("Cleaned up states for task: ".concat(sessionId), "ExecutionEventManager");
    }

    public final void b(za.i iVar, String reason) {
        k.f(reason, "reason");
        za.i iVarB = iVar.b(SessionState.f);
        String str = iVar.f7018a;
        this.f6857a.put(str, iVarB);
        e eVar = this.c;
        eVar.getClass();
        eVar.a(iVarB.f7018a).execute(new A4.e(eVar, iVarB, reason, 14));
        j.H("Task taken over: " + str + ", reason: " + reason, "ExecutionEventManager");
    }

    public final void c(final za.i taskInfo) {
        k.f(taskInfo, "taskInfo");
        boolean z10 = taskInfo.m;
        za.c progress = taskInfo.h;
        SessionState sessionState = taskInfo.c;
        String str = taskInfo.f7018a;
        ConcurrentHashMap concurrentHashMap = this.f6857a;
        za.i iVar = (za.i) concurrentHashMap.get(str);
        concurrentHashMap.put(str, taskInfo);
        boolean z11 = false;
        boolean z12 = (iVar != null ? iVar.c : null) != sessionState;
        boolean zB = k.b(iVar != null ? iVar.h : null, progress);
        boolean z13 = z10 && (iVar == null || !iVar.m);
        if (!z10 && iVar != null && iVar.m) {
            z11 = true;
        }
        final e eVar = this.c;
        if (z12) {
            switch (sessionState.ordinal()) {
                case 0:
                    eVar.getClass();
                    final int i = 4;
                    eVar.a(str).execute(new Runnable() { // from class: wa.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i) {
                                case 0:
                                    za.i iVar2 = taskInfo;
                                    e eVar2 = eVar;
                                    eVar2.getClass();
                                    try {
                                        Iterator it = eVar2.f6861a.iterator();
                                        while (it.hasNext()) {
                                            ((InterfaceC2124a) it.next()).onTaskRecoveryStarted(iVar2);
                                        }
                                        break;
                                    } catch (Exception e) {
                                        com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskRecoveryStarted", ": ", e.getMessage(), "TaskEventDispatcher");
                                        return;
                                    }
                                case 1:
                                    za.i iVar3 = taskInfo;
                                    e eVar3 = eVar;
                                    eVar3.getClass();
                                    try {
                                        Iterator it2 = eVar3.f6861a.iterator();
                                        while (it2.hasNext()) {
                                            ((InterfaceC2124a) it2.next()).onTaskStarted(iVar3);
                                        }
                                        break;
                                    } catch (Exception e6) {
                                        com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskStarted", ": ", e6.getMessage(), "TaskEventDispatcher");
                                        return;
                                    }
                                case 2:
                                    za.i iVar4 = taskInfo;
                                    e eVar4 = eVar;
                                    eVar4.getClass();
                                    try {
                                        Iterator it3 = eVar4.f6861a.iterator();
                                        while (it3.hasNext()) {
                                            ((InterfaceC2124a) it3.next()).onTaskRecoveredFromTakeover(iVar4);
                                        }
                                        break;
                                    } catch (Exception e9) {
                                        com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskRecoveredFromTakeover", ": ", e9.getMessage(), "TaskEventDispatcher");
                                        return;
                                    }
                                case 3:
                                    za.i iVar5 = taskInfo;
                                    e eVar5 = eVar;
                                    eVar5.getClass();
                                    try {
                                        Iterator it4 = eVar5.f6861a.iterator();
                                        while (it4.hasNext()) {
                                            ((InterfaceC2124a) it4.next()).onTaskResumed(iVar5);
                                        }
                                        break;
                                    } catch (Exception e10) {
                                        com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskResumed", ": ", e10.getMessage(), "TaskEventDispatcher");
                                        return;
                                    }
                                case 4:
                                    za.i iVar6 = taskInfo;
                                    e eVar6 = eVar;
                                    eVar6.getClass();
                                    try {
                                        Iterator it5 = eVar6.f6861a.iterator();
                                        while (it5.hasNext()) {
                                            ((InterfaceC2124a) it5.next()).onTaskCreated(iVar6);
                                        }
                                        break;
                                    } catch (Exception e11) {
                                        com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskCreated", ": ", e11.getMessage(), "TaskEventDispatcher");
                                        return;
                                    }
                                default:
                                    za.i iVar7 = taskInfo;
                                    e eVar7 = eVar;
                                    eVar7.getClass();
                                    try {
                                        Iterator it6 = eVar7.f6861a.iterator();
                                        while (it6.hasNext()) {
                                            ((InterfaceC2124a) it6.next()).onTaskPaused(iVar7);
                                        }
                                        break;
                                    } catch (Exception e12) {
                                        com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskPaused", ": ", e12.getMessage(), "TaskEventDispatcher");
                                    }
                            }
                        }
                    });
                    break;
                case 1:
                    eVar.getClass();
                    final int i6 = 1;
                    eVar.a(str).execute(new Runnable() { // from class: wa.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i6) {
                                case 0:
                                    za.i iVar2 = taskInfo;
                                    e eVar2 = eVar;
                                    eVar2.getClass();
                                    try {
                                        Iterator it = eVar2.f6861a.iterator();
                                        while (it.hasNext()) {
                                            ((InterfaceC2124a) it.next()).onTaskRecoveryStarted(iVar2);
                                        }
                                        break;
                                    } catch (Exception e) {
                                        com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskRecoveryStarted", ": ", e.getMessage(), "TaskEventDispatcher");
                                        return;
                                    }
                                case 1:
                                    za.i iVar3 = taskInfo;
                                    e eVar3 = eVar;
                                    eVar3.getClass();
                                    try {
                                        Iterator it2 = eVar3.f6861a.iterator();
                                        while (it2.hasNext()) {
                                            ((InterfaceC2124a) it2.next()).onTaskStarted(iVar3);
                                        }
                                        break;
                                    } catch (Exception e6) {
                                        com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskStarted", ": ", e6.getMessage(), "TaskEventDispatcher");
                                        return;
                                    }
                                case 2:
                                    za.i iVar4 = taskInfo;
                                    e eVar4 = eVar;
                                    eVar4.getClass();
                                    try {
                                        Iterator it3 = eVar4.f6861a.iterator();
                                        while (it3.hasNext()) {
                                            ((InterfaceC2124a) it3.next()).onTaskRecoveredFromTakeover(iVar4);
                                        }
                                        break;
                                    } catch (Exception e9) {
                                        com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskRecoveredFromTakeover", ": ", e9.getMessage(), "TaskEventDispatcher");
                                        return;
                                    }
                                case 3:
                                    za.i iVar5 = taskInfo;
                                    e eVar5 = eVar;
                                    eVar5.getClass();
                                    try {
                                        Iterator it4 = eVar5.f6861a.iterator();
                                        while (it4.hasNext()) {
                                            ((InterfaceC2124a) it4.next()).onTaskResumed(iVar5);
                                        }
                                        break;
                                    } catch (Exception e10) {
                                        com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskResumed", ": ", e10.getMessage(), "TaskEventDispatcher");
                                        return;
                                    }
                                case 4:
                                    za.i iVar6 = taskInfo;
                                    e eVar6 = eVar;
                                    eVar6.getClass();
                                    try {
                                        Iterator it5 = eVar6.f6861a.iterator();
                                        while (it5.hasNext()) {
                                            ((InterfaceC2124a) it5.next()).onTaskCreated(iVar6);
                                        }
                                        break;
                                    } catch (Exception e11) {
                                        com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskCreated", ": ", e11.getMessage(), "TaskEventDispatcher");
                                        return;
                                    }
                                default:
                                    za.i iVar7 = taskInfo;
                                    e eVar7 = eVar;
                                    eVar7.getClass();
                                    try {
                                        Iterator it6 = eVar7.f6861a.iterator();
                                        while (it6.hasNext()) {
                                            ((InterfaceC2124a) it6.next()).onTaskPaused(iVar7);
                                        }
                                        break;
                                    } catch (Exception e12) {
                                        com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskPaused", ": ", e12.getMessage(), "TaskEventDispatcher");
                                    }
                            }
                        }
                    });
                    break;
                case 2:
                    if ((iVar != null ? iVar.c : null) == SessionState.e) {
                        eVar.getClass();
                        final int i10 = 3;
                        eVar.a(str).execute(new Runnable() { // from class: wa.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i10) {
                                    case 0:
                                        za.i iVar2 = taskInfo;
                                        e eVar2 = eVar;
                                        eVar2.getClass();
                                        try {
                                            Iterator it = eVar2.f6861a.iterator();
                                            while (it.hasNext()) {
                                                ((InterfaceC2124a) it.next()).onTaskRecoveryStarted(iVar2);
                                            }
                                            break;
                                        } catch (Exception e) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskRecoveryStarted", ": ", e.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 1:
                                        za.i iVar3 = taskInfo;
                                        e eVar3 = eVar;
                                        eVar3.getClass();
                                        try {
                                            Iterator it2 = eVar3.f6861a.iterator();
                                            while (it2.hasNext()) {
                                                ((InterfaceC2124a) it2.next()).onTaskStarted(iVar3);
                                            }
                                            break;
                                        } catch (Exception e6) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskStarted", ": ", e6.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 2:
                                        za.i iVar4 = taskInfo;
                                        e eVar4 = eVar;
                                        eVar4.getClass();
                                        try {
                                            Iterator it3 = eVar4.f6861a.iterator();
                                            while (it3.hasNext()) {
                                                ((InterfaceC2124a) it3.next()).onTaskRecoveredFromTakeover(iVar4);
                                            }
                                            break;
                                        } catch (Exception e9) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskRecoveredFromTakeover", ": ", e9.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 3:
                                        za.i iVar5 = taskInfo;
                                        e eVar5 = eVar;
                                        eVar5.getClass();
                                        try {
                                            Iterator it4 = eVar5.f6861a.iterator();
                                            while (it4.hasNext()) {
                                                ((InterfaceC2124a) it4.next()).onTaskResumed(iVar5);
                                            }
                                            break;
                                        } catch (Exception e10) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskResumed", ": ", e10.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 4:
                                        za.i iVar6 = taskInfo;
                                        e eVar6 = eVar;
                                        eVar6.getClass();
                                        try {
                                            Iterator it5 = eVar6.f6861a.iterator();
                                            while (it5.hasNext()) {
                                                ((InterfaceC2124a) it5.next()).onTaskCreated(iVar6);
                                            }
                                            break;
                                        } catch (Exception e11) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskCreated", ": ", e11.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    default:
                                        za.i iVar7 = taskInfo;
                                        e eVar7 = eVar;
                                        eVar7.getClass();
                                        try {
                                            Iterator it6 = eVar7.f6861a.iterator();
                                            while (it6.hasNext()) {
                                                ((InterfaceC2124a) it6.next()).onTaskPaused(iVar7);
                                            }
                                            break;
                                        } catch (Exception e12) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskPaused", ": ", e12.getMessage(), "TaskEventDispatcher");
                                        }
                                }
                            }
                        });
                        break;
                    }
                    break;
                case 3:
                case 5:
                case 6:
                case 7:
                case 8:
                    break;
                case 4:
                    eVar.getClass();
                    final int i11 = 5;
                    eVar.a(str).execute(new Runnable() { // from class: wa.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i11) {
                                case 0:
                                    za.i iVar2 = taskInfo;
                                    e eVar2 = eVar;
                                    eVar2.getClass();
                                    try {
                                        Iterator it = eVar2.f6861a.iterator();
                                        while (it.hasNext()) {
                                            ((InterfaceC2124a) it.next()).onTaskRecoveryStarted(iVar2);
                                        }
                                        break;
                                    } catch (Exception e) {
                                        com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskRecoveryStarted", ": ", e.getMessage(), "TaskEventDispatcher");
                                        return;
                                    }
                                case 1:
                                    za.i iVar3 = taskInfo;
                                    e eVar3 = eVar;
                                    eVar3.getClass();
                                    try {
                                        Iterator it2 = eVar3.f6861a.iterator();
                                        while (it2.hasNext()) {
                                            ((InterfaceC2124a) it2.next()).onTaskStarted(iVar3);
                                        }
                                        break;
                                    } catch (Exception e6) {
                                        com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskStarted", ": ", e6.getMessage(), "TaskEventDispatcher");
                                        return;
                                    }
                                case 2:
                                    za.i iVar4 = taskInfo;
                                    e eVar4 = eVar;
                                    eVar4.getClass();
                                    try {
                                        Iterator it3 = eVar4.f6861a.iterator();
                                        while (it3.hasNext()) {
                                            ((InterfaceC2124a) it3.next()).onTaskRecoveredFromTakeover(iVar4);
                                        }
                                        break;
                                    } catch (Exception e9) {
                                        com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskRecoveredFromTakeover", ": ", e9.getMessage(), "TaskEventDispatcher");
                                        return;
                                    }
                                case 3:
                                    za.i iVar5 = taskInfo;
                                    e eVar5 = eVar;
                                    eVar5.getClass();
                                    try {
                                        Iterator it4 = eVar5.f6861a.iterator();
                                        while (it4.hasNext()) {
                                            ((InterfaceC2124a) it4.next()).onTaskResumed(iVar5);
                                        }
                                        break;
                                    } catch (Exception e10) {
                                        com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskResumed", ": ", e10.getMessage(), "TaskEventDispatcher");
                                        return;
                                    }
                                case 4:
                                    za.i iVar6 = taskInfo;
                                    e eVar6 = eVar;
                                    eVar6.getClass();
                                    try {
                                        Iterator it5 = eVar6.f6861a.iterator();
                                        while (it5.hasNext()) {
                                            ((InterfaceC2124a) it5.next()).onTaskCreated(iVar6);
                                        }
                                        break;
                                    } catch (Exception e11) {
                                        com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskCreated", ": ", e11.getMessage(), "TaskEventDispatcher");
                                        return;
                                    }
                                default:
                                    za.i iVar7 = taskInfo;
                                    e eVar7 = eVar;
                                    eVar7.getClass();
                                    try {
                                        Iterator it6 = eVar7.f6861a.iterator();
                                        while (it6.hasNext()) {
                                            ((InterfaceC2124a) it6.next()).onTaskPaused(iVar7);
                                        }
                                        break;
                                    } catch (Exception e12) {
                                        com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskPaused", ": ", e12.getMessage(), "TaskEventDispatcher");
                                    }
                            }
                        }
                    });
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        if (z13) {
            eVar.getClass();
            final int i12 = 0;
            eVar.a(str).execute(new Runnable() { // from class: wa.d
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i12) {
                        case 0:
                            za.i iVar2 = taskInfo;
                            e eVar2 = eVar;
                            eVar2.getClass();
                            try {
                                Iterator it = eVar2.f6861a.iterator();
                                while (it.hasNext()) {
                                    ((InterfaceC2124a) it.next()).onTaskRecoveryStarted(iVar2);
                                }
                                break;
                            } catch (Exception e) {
                                com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskRecoveryStarted", ": ", e.getMessage(), "TaskEventDispatcher");
                                return;
                            }
                        case 1:
                            za.i iVar3 = taskInfo;
                            e eVar3 = eVar;
                            eVar3.getClass();
                            try {
                                Iterator it2 = eVar3.f6861a.iterator();
                                while (it2.hasNext()) {
                                    ((InterfaceC2124a) it2.next()).onTaskStarted(iVar3);
                                }
                                break;
                            } catch (Exception e6) {
                                com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskStarted", ": ", e6.getMessage(), "TaskEventDispatcher");
                                return;
                            }
                        case 2:
                            za.i iVar4 = taskInfo;
                            e eVar4 = eVar;
                            eVar4.getClass();
                            try {
                                Iterator it3 = eVar4.f6861a.iterator();
                                while (it3.hasNext()) {
                                    ((InterfaceC2124a) it3.next()).onTaskRecoveredFromTakeover(iVar4);
                                }
                                break;
                            } catch (Exception e9) {
                                com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskRecoveredFromTakeover", ": ", e9.getMessage(), "TaskEventDispatcher");
                                return;
                            }
                        case 3:
                            za.i iVar5 = taskInfo;
                            e eVar5 = eVar;
                            eVar5.getClass();
                            try {
                                Iterator it4 = eVar5.f6861a.iterator();
                                while (it4.hasNext()) {
                                    ((InterfaceC2124a) it4.next()).onTaskResumed(iVar5);
                                }
                                break;
                            } catch (Exception e10) {
                                com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskResumed", ": ", e10.getMessage(), "TaskEventDispatcher");
                                return;
                            }
                        case 4:
                            za.i iVar6 = taskInfo;
                            e eVar6 = eVar;
                            eVar6.getClass();
                            try {
                                Iterator it5 = eVar6.f6861a.iterator();
                                while (it5.hasNext()) {
                                    ((InterfaceC2124a) it5.next()).onTaskCreated(iVar6);
                                }
                                break;
                            } catch (Exception e11) {
                                com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskCreated", ": ", e11.getMessage(), "TaskEventDispatcher");
                                return;
                            }
                        default:
                            za.i iVar7 = taskInfo;
                            e eVar7 = eVar;
                            eVar7.getClass();
                            try {
                                Iterator it6 = eVar7.f6861a.iterator();
                                while (it6.hasNext()) {
                                    ((InterfaceC2124a) it6.next()).onTaskPaused(iVar7);
                                }
                                break;
                            } catch (Exception e12) {
                                com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskPaused", ": ", e12.getMessage(), "TaskEventDispatcher");
                            }
                    }
                }
            });
        }
        if (z11 && !sessionState.a() && sessionState != SessionState.f) {
            eVar.getClass();
            final int i13 = 2;
            eVar.a(str).execute(new Runnable() { // from class: wa.d
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i13) {
                        case 0:
                            za.i iVar2 = taskInfo;
                            e eVar2 = eVar;
                            eVar2.getClass();
                            try {
                                Iterator it = eVar2.f6861a.iterator();
                                while (it.hasNext()) {
                                    ((InterfaceC2124a) it.next()).onTaskRecoveryStarted(iVar2);
                                }
                                break;
                            } catch (Exception e) {
                                com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskRecoveryStarted", ": ", e.getMessage(), "TaskEventDispatcher");
                                return;
                            }
                        case 1:
                            za.i iVar3 = taskInfo;
                            e eVar3 = eVar;
                            eVar3.getClass();
                            try {
                                Iterator it2 = eVar3.f6861a.iterator();
                                while (it2.hasNext()) {
                                    ((InterfaceC2124a) it2.next()).onTaskStarted(iVar3);
                                }
                                break;
                            } catch (Exception e6) {
                                com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskStarted", ": ", e6.getMessage(), "TaskEventDispatcher");
                                return;
                            }
                        case 2:
                            za.i iVar4 = taskInfo;
                            e eVar4 = eVar;
                            eVar4.getClass();
                            try {
                                Iterator it3 = eVar4.f6861a.iterator();
                                while (it3.hasNext()) {
                                    ((InterfaceC2124a) it3.next()).onTaskRecoveredFromTakeover(iVar4);
                                }
                                break;
                            } catch (Exception e9) {
                                com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskRecoveredFromTakeover", ": ", e9.getMessage(), "TaskEventDispatcher");
                                return;
                            }
                        case 3:
                            za.i iVar5 = taskInfo;
                            e eVar5 = eVar;
                            eVar5.getClass();
                            try {
                                Iterator it4 = eVar5.f6861a.iterator();
                                while (it4.hasNext()) {
                                    ((InterfaceC2124a) it4.next()).onTaskResumed(iVar5);
                                }
                                break;
                            } catch (Exception e10) {
                                com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskResumed", ": ", e10.getMessage(), "TaskEventDispatcher");
                                return;
                            }
                        case 4:
                            za.i iVar6 = taskInfo;
                            e eVar6 = eVar;
                            eVar6.getClass();
                            try {
                                Iterator it5 = eVar6.f6861a.iterator();
                                while (it5.hasNext()) {
                                    ((InterfaceC2124a) it5.next()).onTaskCreated(iVar6);
                                }
                                break;
                            } catch (Exception e11) {
                                com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskCreated", ": ", e11.getMessage(), "TaskEventDispatcher");
                                return;
                            }
                        default:
                            za.i iVar7 = taskInfo;
                            e eVar7 = eVar;
                            eVar7.getClass();
                            try {
                                Iterator it6 = eVar7.f6861a.iterator();
                                while (it6.hasNext()) {
                                    ((InterfaceC2124a) it6.next()).onTaskPaused(iVar7);
                                }
                                break;
                            } catch (Exception e12) {
                                com.stepos.statsrpk.service.c.o("Error dispatching event ", "onTaskPaused", ": ", e12.getMessage(), "TaskEventDispatcher");
                            }
                    }
                }
            });
        }
        if ((sessionState == SessionState.c || z10) && (z12 || !zB || z13)) {
            eVar.getClass();
            k.f(progress, "progress");
            eVar.a(str).execute(new A4.e(eVar, taskInfo, progress, 15));
        }
        j.H("[🚗] Task " + sessionState + ", sessionId: " + str, "ExecutionEventManager");
    }
}
