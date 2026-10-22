package stepai.aios.guiagent.pipeline;

import C7.r;
import J7.c;
import S7.n;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import stepai.aios.guiagent.config.LlmConfig;
import stepai.aios.guiagent.llm.LlmChatRequest;
import stepai.aios.guiagent.llm.parser.IModelCell;
import za.e;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$awaitNextAction$llmDeferred$1", f = "ExecutionPipeline.kt", l = {1089, 1097, 1136}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LAa/a;", "<anonymous>", "(Lm9/z;)LAa/a;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class ExecutionPipeline$awaitNextAction$llmDeferred$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public Map f6042a;
    public String b;
    public LlmChatRequest c;
    public LlmChatRequest d;
    public String e;
    public long f;
    public int g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ IModelCell i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ e f6043j;
    public final /* synthetic */ String k;
    public final /* synthetic */ LlmConfig l;
    public final /* synthetic */ String m;
    public final /* synthetic */ String n;
    public final /* synthetic */ AtomicReference o;
    public final /* synthetic */ b p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ String f6044q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ String f6045r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f6046s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$awaitNextAction$llmDeferred$1(boolean z10, IModelCell iModelCell, e eVar, String str, LlmConfig llmConfig, String str2, String str3, AtomicReference atomicReference, b bVar, String str4, String str5, AtomicReference atomicReference2, H7.c cVar) {
        super(2, cVar);
        this.h = z10;
        this.i = iModelCell;
        this.f6043j = eVar;
        this.k = str;
        this.l = llmConfig;
        this.m = str2;
        this.n = str3;
        this.o = atomicReference;
        this.p = bVar;
        this.f6044q = str4;
        this.f6045r = str5;
        this.f6046s = atomicReference2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new ExecutionPipeline$awaitNextAction$llmDeferred$1(this.h, this.i, this.f6043j, this.k, this.l, this.m, this.n, this.o, this.p, this.f6044q, this.f6045r, this.f6046s, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((ExecutionPipeline$awaitNextAction$llmDeferred$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0356 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x01e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015d A[Catch: Exception -> 0x0328, CancellationException -> 0x0393, TRY_ENTER, TryCatch #6 {CancellationException -> 0x0393, blocks: (B:9:0x0037, B:88:0x01db, B:90:0x01e9, B:100:0x01ff, B:102:0x020a, B:107:0x021c, B:109:0x0222, B:111:0x0229, B:113:0x022f, B:114:0x0232, B:116:0x0238, B:118:0x024a, B:120:0x0267, B:129:0x0279, B:131:0x0290, B:133:0x029a, B:135:0x02c9, B:134:0x02b8, B:106:0x0217, B:17:0x006e, B:54:0x0133, B:56:0x0137, B:57:0x013b, B:62:0x0148, B:65:0x014f, B:70:0x0161, B:72:0x0165, B:74:0x016b, B:75:0x017b, B:76:0x018b, B:78:0x019e, B:80:0x01a3, B:82:0x01b6, B:83:0x01be, B:84:0x01c3, B:69:0x015d, B:22:0x0090, B:38:0x00ed, B:30:0x00b9, B:32:0x00c0, B:34:0x00e2, B:50:0x0115), top: B:184:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0165 A[Catch: Exception -> 0x015a, CancellationException -> 0x0393, TRY_ENTER, TRY_LEAVE, TryCatch #6 {CancellationException -> 0x0393, blocks: (B:9:0x0037, B:88:0x01db, B:90:0x01e9, B:100:0x01ff, B:102:0x020a, B:107:0x021c, B:109:0x0222, B:111:0x0229, B:113:0x022f, B:114:0x0232, B:116:0x0238, B:118:0x024a, B:120:0x0267, B:129:0x0279, B:131:0x0290, B:133:0x029a, B:135:0x02c9, B:134:0x02b8, B:106:0x0217, B:17:0x006e, B:54:0x0133, B:56:0x0137, B:57:0x013b, B:62:0x0148, B:65:0x014f, B:70:0x0161, B:72:0x0165, B:74:0x016b, B:75:0x017b, B:76:0x018b, B:78:0x019e, B:80:0x01a3, B:82:0x01b6, B:83:0x01be, B:84:0x01c3, B:69:0x015d, B:22:0x0090, B:38:0x00ed, B:30:0x00b9, B:32:0x00c0, B:34:0x00e2, B:50:0x0115), top: B:184:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01fe  */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v35 */
    /* JADX WARN: Type inference failed for: r8v38, types: [java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r45) {
        /*
            Method dump skipped, instructions count: 917
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.ExecutionPipeline$awaitNextAction$llmDeferred$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
