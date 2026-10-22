package io.ktor.util.pipeline;

import Y8.t;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.pipeline.PipelinePhaseRelation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.z;
import p9.q;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u000b\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u001b\u0012\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB]\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012J\u0010\u0010\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\n¢\u0006\u0004\b\u0007\u0010\u0011J#\u0010\u0013\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f2\u0006\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001b2\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020!2\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010#JS\u0010$\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\nH\u0002¢\u0006\u0004\b$\u0010%J#\u0010&\u001a\u00020!2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002¢\u0006\u0004\b&\u0010'JS\u0010(\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\nH\u0002¢\u0006\u0004\b(\u0010%J\u000f\u0010)\u001a\u00020\u000eH\u0002¢\u0006\u0004\b)\u0010*J[\u0010,\u001a\u00020\u000e2J\u0010+\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\nH\u0002¢\u0006\u0004\b,\u0010-J#\u0010/\u001a\u00020\u000e2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001bH\u0002¢\u0006\u0004\b/\u00100J#\u00102\u001a\u00020\u000e2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002¢\u0006\u0004\b2\u0010\u0014J]\u00104\u001a\u00020!2\u0006\u0010\t\u001a\u00020\u00052D\u00103\u001a@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000fH\u0002¢\u0006\u0004\b4\u00105J\u001f\u00108\u001a\u00020!2\u0006\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u00020\u0005H\u0002¢\u0006\u0004\b8\u00109J \u0010:\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0016\u001a\u00028\u0000H\u0086@¢\u0006\u0004\b:\u0010;J\u0015\u0010<\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b<\u0010=J\u001d\u0010?\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b?\u0010@J\u001d\u0010A\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\bA\u0010@J[\u0010B\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00052D\u00103\u001a@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u000eH\u0016¢\u0006\u0004\bD\u0010*JY\u0010E\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\n2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\bE\u0010FJ!\u0010G\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\bG\u0010\u0014J!\u0010H\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\bH\u0010\u0014J!\u0010I\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\bI\u0010\u0014J\u000f\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bK\u0010LJ[\u0010N\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\n2\u0006\u0010\t\u001a\u00020\u0005H\u0000¢\u0006\u0004\bM\u0010FJS\u0010P\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\nH\u0000¢\u0006\u0004\bO\u0010%R\u0017\u0010R\u001a\u00020Q8\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u001a\u0010V\u001a\u00020!8\u0016X\u0096D¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00010Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010WR\u0018\u0010`\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0017\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00050\n8F¢\u0006\u0006\u001a\u0004\bb\u0010%R\u0011\u0010d\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\bd\u0010Y¨\u0006e"}, d2 = {"Lio/ktor/util/pipeline/Pipeline;", "", "TSubject", "TContext", "", "Lio/ktor/util/pipeline/PipelinePhase;", "phases", "<init>", "([Lio/ktor/util/pipeline/PipelinePhase;)V", "phase", "", "Lkotlin/Function3;", "Lio/ktor/util/pipeline/PipelineContext;", "Le9/c;", "LY8/t;", "Lio/ktor/util/pipeline/PipelineInterceptor;", "interceptors", "(Lio/ktor/util/pipeline/PipelinePhase;Ljava/util/List;)V", "from", "mergeInterceptors", "(Lio/ktor/util/pipeline/Pipeline;)V", "context", "subject", "Lkotlin/coroutines/d;", "coroutineContext", "createContext", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/d;)Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/util/pipeline/PhaseContent;", "findPhase", "(Lio/ktor/util/pipeline/PipelinePhase;)Lio/ktor/util/pipeline/PhaseContent;", "", "findPhaseIndex", "(Lio/ktor/util/pipeline/PipelinePhase;)I", "", "hasPhase", "(Lio/ktor/util/pipeline/PipelinePhase;)Z", "cacheInterceptors", "()Ljava/util/List;", "fastPathMerge", "(Lio/ktor/util/pipeline/Pipeline;)Z", "sharedInterceptorsList", "resetInterceptorsList", "()V", "list", "notSharedInterceptorsList", "(Ljava/util/List;)V", "phaseContent", "setInterceptorsListFromPhase", "(Lio/ktor/util/pipeline/PhaseContent;)V", "pipeline", "setInterceptorsListFromAnotherPipeline", "block", "tryAddToPhaseFastPath", "(Lio/ktor/util/pipeline/PipelinePhase;Lp9/q;)Z", "fromPhaseOrContent", "fromPhase", "insertRelativePhase", "(Ljava/lang/Object;Lio/ktor/util/pipeline/PipelinePhase;)Z", "execute", "(Ljava/lang/Object;Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "addPhase", "(Lio/ktor/util/pipeline/PipelinePhase;)V", SkillStoreKt.SKILL_DOC_TYPE_REFERENCE, "insertPhaseAfter", "(Lio/ktor/util/pipeline/PipelinePhase;Lio/ktor/util/pipeline/PipelinePhase;)V", "insertPhaseBefore", "intercept", "(Lio/ktor/util/pipeline/PipelinePhase;Lp9/q;)V", "afterIntercepted", "interceptorsForPhase", "(Lio/ktor/util/pipeline/PipelinePhase;)Ljava/util/List;", "mergePhases", "merge", "resetFrom", "", "toString", "()Ljava/lang/String;", "phaseInterceptors$ktor_utils", "phaseInterceptors", "interceptorsForTests$ktor_utils", "interceptorsForTests", "Lio/ktor/util/Attributes;", "attributes", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "developmentMode", "Z", "getDevelopmentMode", "()Z", "", "phasesRaw", "Ljava/util/List;", "interceptorsQuantity", "I", "interceptorsListShared", "interceptorsListSharedPhase", "Lio/ktor/util/pipeline/PipelinePhase;", "getItems", DidiCardProvider.KEY_ITEMS, "isEmpty", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public class Pipeline<TSubject, TContext> {
    private final Attributes attributes;
    private final boolean developmentMode;
    private volatile /* synthetic */ Object interceptors$delegate;
    private boolean interceptorsListShared;
    private Phase interceptorsListSharedPhase;
    private int interceptorsQuantity;
    private final List<Object> phasesRaw;

    public Pipeline(Phase... phases) {
        p.i(phases, "phases");
        this.attributes = AttributesJvmKt.Attributes(true);
        this.phasesRaw = C1173v.s(Arrays.copyOf(phases, phases.length));
        this.interceptors$delegate = null;
    }

    private final List<q<PipelineContext<TSubject, TContext>, TSubject, InterfaceC4014c<? super t>, Object>> cacheInterceptors() {
        int iO;
        int i10 = this.interceptorsQuantity;
        if (i10 == 0) {
            notSharedInterceptorsList(C1173v.m());
            return C1173v.m();
        }
        List<Object> list = this.phasesRaw;
        int i11 = 0;
        if (i10 == 1 && (iO = C1173v.o(list)) >= 0) {
            int i12 = 0;
            while (true) {
                Object obj = list.get(i12);
                PhaseContent<TSubject, TContext> phaseContent = obj instanceof PhaseContent ? (PhaseContent) obj : null;
                if (phaseContent != null && !phaseContent.isEmpty()) {
                    List<q<PipelineContext<TSubject, TContext>, TSubject, InterfaceC4014c<? super t>, Object>> listSharedInterceptors = phaseContent.sharedInterceptors();
                    setInterceptorsListFromPhase(phaseContent);
                    return listSharedInterceptors;
                }
                if (i12 == iO) {
                    break;
                }
                i12++;
            }
        }
        ArrayList arrayList = new ArrayList();
        int iO2 = C1173v.o(list);
        if (iO2 >= 0) {
            while (true) {
                Object obj2 = list.get(i11);
                PhaseContent phaseContent2 = obj2 instanceof PhaseContent ? (PhaseContent) obj2 : null;
                if (phaseContent2 != null) {
                    phaseContent2.addTo(arrayList);
                }
                if (i11 == iO2) {
                    break;
                }
                i11++;
            }
        }
        notSharedInterceptorsList(arrayList);
        return arrayList;
    }

    private final PipelineContext<TSubject, TContext> createContext(TContext context, TSubject subject, d coroutineContext) {
        return PipelineContextKt.pipelineContextFor(context, sharedInterceptorsList(), subject, coroutineContext, getDevelopmentMode());
    }

    private final boolean fastPathMerge(Pipeline<TSubject, TContext> from) {
        if (from.phasesRaw.isEmpty()) {
            return true;
        }
        int i10 = 0;
        if (!this.phasesRaw.isEmpty()) {
            return false;
        }
        List<Object> list = from.phasesRaw;
        int iO = C1173v.o(list);
        if (iO >= 0) {
            while (true) {
                Object obj = list.get(i10);
                if (obj instanceof Phase) {
                    this.phasesRaw.add(obj);
                } else if (obj instanceof PhaseContent) {
                    PhaseContent phaseContent = (PhaseContent) obj;
                    this.phasesRaw.add(new PhaseContent(phaseContent.getPhase(), phaseContent.getRelation(), phaseContent.sharedInterceptors()));
                }
                if (i10 == iO) {
                    break;
                }
                i10++;
            }
        }
        this.interceptorsQuantity += from.interceptorsQuantity;
        setInterceptorsListFromAnotherPipeline(from);
        return true;
    }

    private final PhaseContent<TSubject, TContext> findPhase(Phase phase) {
        List<Object> list = this.phasesRaw;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = list.get(i10);
            if (obj == phase) {
                PhaseContent<TSubject, TContext> phaseContent = new PhaseContent<>(phase, PipelinePhaseRelation.Last.INSTANCE);
                list.set(i10, phaseContent);
                return phaseContent;
            }
            if (obj instanceof PhaseContent) {
                PhaseContent<TSubject, TContext> phaseContent2 = (PhaseContent) obj;
                if (phaseContent2.getPhase() == phase) {
                    return phaseContent2;
                }
            }
        }
        return null;
    }

    private final int findPhaseIndex(Phase phase) {
        List<Object> list = this.phasesRaw;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = list.get(i10);
            if (obj == phase || ((obj instanceof PhaseContent) && ((PhaseContent) obj).getPhase() == phase)) {
                return i10;
            }
        }
        return -1;
    }

    private final List<q<PipelineContext<TSubject, TContext>, TSubject, InterfaceC4014c<? super t>, Object>> getInterceptors() {
        return (List) this.interceptors$delegate;
    }

    private final boolean hasPhase(Phase phase) {
        List<Object> list = this.phasesRaw;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = list.get(i10);
            if (obj == phase) {
                return true;
            }
            if ((obj instanceof PhaseContent) && ((PhaseContent) obj).getPhase() == phase) {
                return true;
            }
        }
        return false;
    }

    private final boolean insertRelativePhase(Object fromPhaseOrContent, Phase fromPhase) throws InvalidPhaseException {
        PipelinePhaseRelation relation;
        if (fromPhaseOrContent == fromPhase) {
            relation = PipelinePhaseRelation.Last.INSTANCE;
        } else {
            p.g(fromPhaseOrContent, "null cannot be cast to non-null type io.ktor.util.pipeline.PhaseContent<*, *>");
            relation = ((PhaseContent) fromPhaseOrContent).getRelation();
        }
        if (relation instanceof PipelinePhaseRelation.Last) {
            addPhase(fromPhase);
            return true;
        }
        if (relation instanceof PipelinePhaseRelation.Before) {
            PipelinePhaseRelation.Before before = (PipelinePhaseRelation.Before) relation;
            if (hasPhase(before.getRelativeTo())) {
                insertPhaseBefore(before.getRelativeTo(), fromPhase);
                return true;
            }
        }
        if (!(relation instanceof PipelinePhaseRelation.After)) {
            return false;
        }
        insertPhaseAfter(((PipelinePhaseRelation.After) relation).getRelativeTo(), fromPhase);
        return true;
    }

    private final void mergeInterceptors(Pipeline<TSubject, TContext> from) {
        if (this.interceptorsQuantity == 0) {
            setInterceptorsListFromAnotherPipeline(from);
        } else {
            resetInterceptorsList();
        }
        for (Object obj : from.phasesRaw) {
            Phase phase = obj instanceof Phase ? (Phase) obj : null;
            if (phase == null) {
                p.g(obj, "null cannot be cast to non-null type io.ktor.util.pipeline.PhaseContent<*, *>");
                phase = ((PhaseContent) obj).getPhase();
            }
            if (obj instanceof PhaseContent) {
                PhaseContent phaseContent = (PhaseContent) obj;
                if (!phaseContent.isEmpty()) {
                    PhaseContent<TSubject, TContext> phaseContentFindPhase = findPhase(phase);
                    p.f(phaseContentFindPhase);
                    phaseContent.addTo(phaseContentFindPhase);
                    this.interceptorsQuantity += phaseContent.getSize();
                }
            }
        }
    }

    private final void notSharedInterceptorsList(List<? extends q<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super InterfaceC4014c<? super t>, ? extends Object>> list) {
        setInterceptors(list);
        this.interceptorsListShared = false;
        this.interceptorsListSharedPhase = null;
    }

    private final void resetInterceptorsList() {
        setInterceptors(null);
        this.interceptorsListShared = false;
        this.interceptorsListSharedPhase = null;
    }

    private final void setInterceptors(List<? extends q<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super InterfaceC4014c<? super t>, ? extends Object>> list) {
        this.interceptors$delegate = list;
    }

    private final void setInterceptorsListFromAnotherPipeline(Pipeline<TSubject, TContext> pipeline) {
        setInterceptors(pipeline.sharedInterceptorsList());
        this.interceptorsListShared = true;
        this.interceptorsListSharedPhase = null;
    }

    private final void setInterceptorsListFromPhase(PhaseContent<TSubject, TContext> phaseContent) {
        setInterceptors(phaseContent.sharedInterceptors());
        this.interceptorsListShared = false;
        this.interceptorsListSharedPhase = phaseContent.getPhase();
    }

    private final List<q<PipelineContext<TSubject, TContext>, TSubject, InterfaceC4014c<? super t>, Object>> sharedInterceptorsList() {
        if (getInterceptors() == null) {
            cacheInterceptors();
        }
        this.interceptorsListShared = true;
        List<q<PipelineContext<TSubject, TContext>, TSubject, InterfaceC4014c<? super t>, Object>> interceptors = getInterceptors();
        p.f(interceptors);
        return interceptors;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean tryAddToPhaseFastPath(Phase phase, q<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        List<q<PipelineContext<TSubject, TContext>, TSubject, InterfaceC4014c<? super t>, Object>> interceptors = getInterceptors();
        if (this.phasesRaw.isEmpty() || interceptors == null || this.interceptorsListShared || !z.p(interceptors)) {
            return false;
        }
        if (p.d(this.interceptorsListSharedPhase, phase)) {
            interceptors.add(block);
            return true;
        }
        if (!p.d(phase, F.C0(this.phasesRaw)) && findPhaseIndex(phase) != C1173v.o(this.phasesRaw)) {
            return false;
        }
        PhaseContent<TSubject, TContext> phaseContentFindPhase = findPhase(phase);
        p.f(phaseContentFindPhase);
        phaseContentFindPhase.addInterceptor(block);
        interceptors.add(block);
        return true;
    }

    public final void addPhase(Phase phase) {
        p.i(phase, "phase");
        if (hasPhase(phase)) {
            return;
        }
        this.phasesRaw.add(phase);
    }

    public void afterIntercepted() {
    }

    public final Object execute(TContext tcontext, TSubject tsubject, InterfaceC4014c<? super TSubject> interfaceC4014c) {
        return createContext(tcontext, tsubject, interfaceC4014c.getContext()).execute$ktor_utils(tsubject, interfaceC4014c);
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    public boolean getDevelopmentMode() {
        return this.developmentMode;
    }

    public final List<Phase> getItems() {
        List<Object> list = this.phasesRaw;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (Object obj : list) {
            Phase phase = obj instanceof Phase ? (Phase) obj : null;
            if (phase == null) {
                PhaseContent phaseContent = obj instanceof PhaseContent ? (PhaseContent) obj : null;
                Phase phase2 = phaseContent != null ? phaseContent.getPhase() : null;
                p.f(phase2);
                phase = phase2;
            }
            arrayList.add(phase);
        }
        return arrayList;
    }

    public final void insertPhaseAfter(Phase reference, Phase phase) throws InvalidPhaseException {
        PipelinePhaseRelation relation;
        Phase relativeTo;
        p.i(reference, "reference");
        p.i(phase, "phase");
        if (hasPhase(phase)) {
            return;
        }
        int iFindPhaseIndex = findPhaseIndex(reference);
        if (iFindPhaseIndex == -1) {
            throw new InvalidPhaseException("Phase " + reference + " was not registered for this pipeline");
        }
        int i10 = iFindPhaseIndex + 1;
        int iO = C1173v.o(this.phasesRaw);
        if (i10 <= iO) {
            while (true) {
                Object obj = this.phasesRaw.get(i10);
                PhaseContent phaseContent = obj instanceof PhaseContent ? (PhaseContent) obj : null;
                if (phaseContent != null && (relation = phaseContent.getRelation()) != null) {
                    PipelinePhaseRelation.After after = relation instanceof PipelinePhaseRelation.After ? (PipelinePhaseRelation.After) relation : null;
                    if (after != null && (relativeTo = after.getRelativeTo()) != null && p.d(relativeTo, reference)) {
                        iFindPhaseIndex = i10;
                    }
                    if (i10 == iO) {
                        break;
                    } else {
                        i10++;
                    }
                } else {
                    break;
                }
            }
        }
        this.phasesRaw.add(iFindPhaseIndex + 1, new PhaseContent(phase, new PipelinePhaseRelation.After(reference)));
    }

    public final void insertPhaseBefore(Phase reference, Phase phase) throws InvalidPhaseException {
        p.i(reference, "reference");
        p.i(phase, "phase");
        if (hasPhase(phase)) {
            return;
        }
        int iFindPhaseIndex = findPhaseIndex(reference);
        if (iFindPhaseIndex != -1) {
            this.phasesRaw.add(iFindPhaseIndex, new PhaseContent(phase, new PipelinePhaseRelation.Before(reference)));
            return;
        }
        throw new InvalidPhaseException("Phase " + reference + " was not registered for this pipeline");
    }

    public final void intercept(Phase phase, q<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        p.i(phase, "phase");
        p.i(block, "block");
        PhaseContent<TSubject, TContext> phaseContentFindPhase = findPhase(phase);
        if (phaseContentFindPhase == null) {
            throw new InvalidPhaseException("Phase " + phase + " was not registered for this pipeline");
        }
        if (tryAddToPhaseFastPath(phase, block)) {
            this.interceptorsQuantity++;
            return;
        }
        phaseContentFindPhase.addInterceptor(block);
        this.interceptorsQuantity++;
        resetInterceptorsList();
        afterIntercepted();
    }

    public final List<q<PipelineContext<TSubject, TContext>, TSubject, InterfaceC4014c<? super t>, Object>> interceptorsForPhase(Phase phase) {
        Object next;
        p.i(phase, "phase");
        List<Object> list = this.phasesRaw;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof PhaseContent) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (p.d(((PhaseContent) next).getPhase(), phase)) {
                break;
            }
        }
        PhaseContent phaseContent = (PhaseContent) next;
        List<q<PipelineContext<TSubject, TContext>, TSubject, InterfaceC4014c<? super t>, Object>> listSharedInterceptors = phaseContent != null ? phaseContent.sharedInterceptors() : null;
        return listSharedInterceptors == null ? C1173v.m() : listSharedInterceptors;
    }

    public final List<q<PipelineContext<TSubject, TContext>, TSubject, InterfaceC4014c<? super t>, Object>> interceptorsForTests$ktor_utils() {
        List<q<PipelineContext<TSubject, TContext>, TSubject, InterfaceC4014c<? super t>, Object>> interceptors = getInterceptors();
        return interceptors == null ? cacheInterceptors() : interceptors;
    }

    public final boolean isEmpty() {
        return this.interceptorsQuantity == 0;
    }

    public final void merge(Pipeline<TSubject, TContext> from) {
        p.i(from, "from");
        if (fastPathMerge(from)) {
            return;
        }
        mergePhases(from);
        mergeInterceptors(from);
    }

    public final void mergePhases(Pipeline<TSubject, TContext> from) {
        p.i(from, "from");
        List listP1 = F.p1(from.phasesRaw);
        while (!listP1.isEmpty()) {
            Iterator it = listP1.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                Phase phase = next instanceof Phase ? (Phase) next : null;
                if (phase == null) {
                    p.g(next, "null cannot be cast to non-null type io.ktor.util.pipeline.PhaseContent<*, *>");
                    phase = ((PhaseContent) next).getPhase();
                }
                if (hasPhase(phase)) {
                    it.remove();
                } else if (insertRelativePhase(next, phase)) {
                    it.remove();
                }
            }
        }
    }

    public final List<q<PipelineContext<TSubject, TContext>, TSubject, InterfaceC4014c<? super t>, Object>> phaseInterceptors$ktor_utils(Phase phase) {
        List<q<PipelineContext<TSubject, TContext>, TSubject, InterfaceC4014c<? super t>, Object>> listSharedInterceptors;
        p.i(phase, "phase");
        PhaseContent<TSubject, TContext> phaseContentFindPhase = findPhase(phase);
        return (phaseContentFindPhase == null || (listSharedInterceptors = phaseContentFindPhase.sharedInterceptors()) == null) ? C1173v.m() : listSharedInterceptors;
    }

    public final void resetFrom(Pipeline<TSubject, TContext> from) {
        p.i(from, "from");
        this.phasesRaw.clear();
        if (this.interceptorsQuantity != 0) {
            throw new IllegalStateException("Check failed.");
        }
        fastPathMerge(from);
    }

    public String toString() {
        return super.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Pipeline(Phase phase, List<? extends q<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super InterfaceC4014c<? super t>, ? extends Object>> interceptors) {
        this(phase);
        p.i(phase, "phase");
        p.i(interceptors, "interceptors");
        Iterator<T> it = interceptors.iterator();
        while (it.hasNext()) {
            intercept(phase, (q) it.next());
        }
    }
}
