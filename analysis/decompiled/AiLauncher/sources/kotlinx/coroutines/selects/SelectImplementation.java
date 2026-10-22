package kotlinx.coroutines.selects;

import Ua.InterfaceC1045a0;
import Ua.InterfaceC1066l;
import Ua.U0;
import Y8.t;
import Z8.C1172u;
import Z8.F;
import Za.z;
import cb.c;
import cb.f;
import cb.j;
import cb.k;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import e9.InterfaceC4014c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.b;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004:\u0001!B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00028\u0000H\u0082@¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u000f\u0010\nJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0016\u001a\u000e\u0018\u00010\u0015R\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00028\u0000H\u0082@¢\u0006\u0004\b\u0018\u0010\nJ!\u0010\u001a\u001a\u00020\f2\u0010\u0010\u0019\u001a\f0\u0015R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00028\u0000H\u0091@¢\u0006\u0004\b\u001c\u0010\nJ2\u0010!\u001a\u00020\f*\u00020\u001d2\u001c\u0010 \u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001eH\u0096\u0002¢\u0006\u0004\b!\u0010\"JD\u0010&\u001a\u00020\f\"\u0004\b\u0001\u0010#*\b\u0012\u0004\u0012\u00028\u00010$2\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u00040%H\u0096\u0002¢\u0006\u0004\b&\u0010'J'\u0010*\u001a\u00020\f*\f0\u0015R\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010)\u001a\u00020(H\u0001¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\f2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J#\u00103\u001a\u00020\f2\n\u00101\u001a\u0006\u0012\u0002\b\u0003002\u0006\u00102\u001a\u00020\u0012H\u0016¢\u0006\u0004\b3\u00104J\u0019\u00105\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b5\u0010\u000eJ!\u00107\u001a\u00020(2\u0006\u0010\u000b\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b7\u00108J\u001f\u0010:\u001a\u0002092\u0006\u0010\u000b\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b:\u0010;J\u0019\u0010>\u001a\u00020\f2\b\u0010=\u001a\u0004\u0018\u00010<H\u0016¢\u0006\u0004\b>\u0010?R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010@\u001a\u0004\bA\u0010BR(\u0010E\u001a\u0014\u0012\u000e\u0012\f0\u0015R\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010FR\u0016\u0010I\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010HR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010FR\u0014\u0010L\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0011\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00040M8\u0002X\u0082\u0004¨\u0006O"}, d2 = {"Lkotlinx/coroutines/selects/SelectImplementation;", "R", "Lkotlinx/coroutines/b;", "Lcb/c;", "", "Lkotlin/coroutines/d;", "context", "<init>", "(Lkotlin/coroutines/d;)V", "q", "(Le9/c;)Ljava/lang/Object;", "clauseObject", "LY8/t;", "l", "(Ljava/lang/Object;)V", "z", "w", "internalResult", "", "y", "(Ljava/lang/Object;Ljava/lang/Object;)I", "Lkotlinx/coroutines/selects/SelectImplementation$a;", "r", "(Ljava/lang/Object;)Lkotlinx/coroutines/selects/SelectImplementation$a;", "n", "selectedClause", "m", "(Lkotlinx/coroutines/selects/SelectImplementation$a;)V", "o", "Lcb/d;", "Lkotlin/Function1;", "Le9/c;", "block", Const.INTENT_KEY_APIKEY, "(Lcb/d;Lp9/l;)V", "Q", "Lcb/f;", "Lkotlin/Function2;", Const.INTENT_KEY_PKGNAME, "(Lcb/f;Lp9/p;)V", "", "reregister", "u", "(Lkotlinx/coroutines/selects/SelectImplementation$a;Z)V", "LUa/a0;", "disposableHandle", "e", "(LUa/a0;)V", "LZa/z;", "segment", "index", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LZa/z;I)V", Const.INTENT_KEY_UMID, "result", "f", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "x", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "", "cause", "c", "(Ljava/lang/Throwable;)V", "Lkotlin/coroutines/d;", "getContext", "()Lkotlin/coroutines/d;", "", "Ljava/util/List;", "clauses", "Ljava/lang/Object;", "disposableHandleOrSegment", "I", "indexInSegment", "t", "()Z", "isSelected", "LOa/e;", VoiceWakeupReceiver.EXTRA_STATE, "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SelectImplementation<R> implements b, c<R>, j, U0 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f36800f = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state$volatile");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final d context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Object disposableHandleOrSegment;
    private volatile /* synthetic */ Object state$volatile = k.f15507b;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public List<SelectImplementation<R>.a> clauses = new ArrayList(2);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int indexInSegment = -1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public Object internalResult = k.f15510e;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B¿\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012(\u0010\u0007\u001a$\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006\u0012(\u0010\t\u001a$\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003j\u0002`\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012H\u0010\u000f\u001aD\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u0003j\u0004\u0018\u0001`\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0015\u001a\u00020\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00028\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0086@¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ?\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b \u0010!R\u0014\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b \u0010\"R6\u0010\u0007\u001a$\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010#R6\u0010\t\u001a$\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003j\u0002`\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010#R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\"R\u0014\u0010\u000b\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\"RV\u0010\u000f\u001aD\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u0003j\u0004\u0018\u0001`\u000e8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b$\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010\"R\u0016\u0010*\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lkotlinx/coroutines/selects/SelectImplementation$a;", "", "clauseObject", "Lkotlin/Function3;", "Lcb/j;", "LY8/t;", "Lkotlinx/coroutines/selects/RegistrationFunction;", "regFunc", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "processResFunc", "param", "block", "", "Lkotlin/coroutines/d;", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "onCancellationConstructor", "<init>", "(Lkotlinx/coroutines/selects/SelectImplementation;Ljava/lang/Object;Lp9/q;Lp9/q;Ljava/lang/Object;Ljava/lang/Object;Lp9/q;)V", "Lkotlinx/coroutines/selects/SelectImplementation;", M5.c.ACTION_SELECT, "", "e", "(Lkotlinx/coroutines/selects/SelectImplementation;)Z", "result", Const.INTENT_KEY_UMID, "(Ljava/lang/Object;)Ljava/lang/Object;", "argument", "c", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "()V", "internalResult", Const.INTENT_KEY_APIKEY, "(Lcb/j;Ljava/lang/Object;)Lp9/q;", "Ljava/lang/Object;", "Lp9/q;", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "disposableHandleOrSegment", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "I", "indexInSegment", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Object clauseObject;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final q<Object, j<?>, Object, t> regFunc;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final q<Object, Object, Object, Object> processResFunc;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final Object param;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final Object block;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final q<j<?>, Object, Object, q<Throwable, Object, d, t>> onCancellationConstructor;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public Object disposableHandleOrSegment;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public int indexInSegment = -1;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Object obj, q<Object, ? super j<?>, Object, t> qVar, q<Object, Object, Object, ? extends Object> qVar2, Object obj2, Object obj3, q<? super j<?>, Object, Object, ? extends q<? super Throwable, Object, ? super d, t>> qVar3) {
            this.clauseObject = obj;
            this.regFunc = qVar;
            this.processResFunc = qVar2;
            this.param = obj2;
            this.block = obj3;
            this.onCancellationConstructor = qVar3;
        }

        public final q<Throwable, Object, d, t> a(j<?> select, Object internalResult) {
            q<j<?>, Object, Object, q<Throwable, Object, d, t>> qVar = this.onCancellationConstructor;
            if (qVar != null) {
                return qVar.invoke(select, this.param, internalResult);
            }
            return null;
        }

        public final void b() {
            Object obj = this.disposableHandleOrSegment;
            SelectImplementation<R> selectImplementation = SelectImplementation.this;
            if (obj instanceof z) {
                ((z) obj).s(this.indexInSegment, null, selectImplementation.getContext());
                return;
            }
            InterfaceC1045a0 interfaceC1045a0 = obj instanceof InterfaceC1045a0 ? (InterfaceC1045a0) obj : null;
            if (interfaceC1045a0 != null) {
                interfaceC1045a0.dispose();
            }
        }

        public final Object c(Object obj, InterfaceC4014c<? super R> interfaceC4014c) {
            Object obj2 = this.block;
            if (this.param == k.i()) {
                p.g(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                return ((InterfaceC5074l) obj2).invoke(interfaceC4014c);
            }
            p.g(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((p9.p) obj2).invoke(obj, interfaceC4014c);
        }

        public final Object d(Object result) {
            return this.processResFunc.invoke(this.clauseObject, this.param, result);
        }

        public final boolean e(SelectImplementation<R> select) {
            this.regFunc.invoke(this.clauseObject, select, this.param);
            return select.internalResult == k.f15510e;
        }
    }

    public SelectImplementation(d dVar) {
        this.context = dVar;
    }

    public static /* synthetic */ <R> Object p(SelectImplementation<R> selectImplementation, InterfaceC4014c<? super R> interfaceC4014c) {
        return selectImplementation.t() ? selectImplementation.n(interfaceC4014c) : selectImplementation.q(interfaceC4014c);
    }

    private final boolean t() {
        return f36800f.get(this) instanceof a;
    }

    public static /* synthetic */ void v(SelectImplementation selectImplementation, a aVar, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        selectImplementation.u(aVar, z10);
    }

    @Override // cb.c
    public void a(cb.d dVar, InterfaceC5074l<? super InterfaceC4014c<? super R>, ? extends Object> interfaceC5074l) {
        v(this, new a(dVar.getClauseObject(), dVar.a(), dVar.c(), k.i(), interfaceC5074l, dVar.b()), false, 1, null);
    }

    @Override // cb.c
    public <Q> void b(f<? extends Q> fVar, p9.p<? super Q, ? super InterfaceC4014c<? super R>, ? extends Object> pVar) {
        v(this, new a(fVar.getClauseObject(), fVar.a(), fVar.c(), null, pVar, fVar.b()), false, 1, null);
    }

    @Override // kotlinx.coroutines.b
    public void c(Throwable cause) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36800f;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == k.f15508c) {
                return;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, k.f15509d));
        List<SelectImplementation<R>.a> list = this.clauses;
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b();
        }
        this.internalResult = k.f15510e;
        this.clauses = null;
    }

    @Override // cb.j
    public void d(Object internalResult) {
        this.internalResult = internalResult;
    }

    @Override // cb.j
    public void e(InterfaceC1045a0 disposableHandle) {
        this.disposableHandleOrSegment = disposableHandle;
    }

    @Override // cb.j
    public boolean f(Object clauseObject, Object result) {
        return y(clauseObject, result) == 0;
    }

    @Override // cb.j
    public d getContext() {
        return this.context;
    }

    @Override // Ua.U0
    public void h(z<?> segment, int index) {
        this.disposableHandleOrSegment = segment;
        this.indexInSegment = index;
    }

    public final void l(Object clauseObject) {
        List<SelectImplementation<R>.a> list = this.clauses;
        p.f(list);
        List<SelectImplementation<R>.a> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).clauseObject == clauseObject) {
                throw new IllegalStateException(("Cannot use select clauses on the same object: " + clauseObject).toString());
            }
        }
    }

    public final void m(SelectImplementation<R>.a selectedClause) {
        List<SelectImplementation<R>.a> list = this.clauses;
        if (list == null) {
            return;
        }
        for (SelectImplementation<R>.a aVar : list) {
            if (aVar != selectedClause) {
                aVar.b();
            }
        }
        f36800f.set(this, k.f15508c);
        this.internalResult = k.f15510e;
        this.clauses = null;
    }

    public final Object n(InterfaceC4014c<? super R> interfaceC4014c) {
        Object obj = f36800f.get(this);
        p.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        SelectImplementation<R>.a aVar = (a) obj;
        Object obj2 = this.internalResult;
        m(aVar);
        return aVar.c(aVar.d(obj2), interfaceC4014c);
    }

    public Object o(InterfaceC4014c<? super R> interfaceC4014c) {
        return p(this, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(e9.InterfaceC4014c<? super R> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = (kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1) r0
            int r1 = r0.f36817c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36817c = r1
            goto L18
        L13:
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = new kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f36815a
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36817c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.C4849c.b(r6)
            return r6
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.C4849c.b(r6)
            goto L44
        L38:
            kotlin.C4849c.b(r6)
            r0.f36817c = r4
            java.lang.Object r6 = r5.z(r0)
            if (r6 != r1) goto L44
            goto L4c
        L44:
            r0.f36817c = r3
            java.lang.Object r5 = r5.n(r0)
            if (r5 != r1) goto L4d
        L4c:
            return r1
        L4d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.q(e9.c):java.lang.Object");
    }

    public final SelectImplementation<R>.a r(Object clauseObject) {
        List<SelectImplementation<R>.a> list = this.clauses;
        Object obj = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((a) next).clauseObject == clauseObject) {
                obj = next;
                break;
            }
        }
        SelectImplementation<R>.a aVar = (a) obj;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException(("Clause with object " + clauseObject + " is not found").toString());
    }

    public final void u(SelectImplementation<R>.a aVar, boolean z10) {
        if (f36800f.get(this) instanceof a) {
            return;
        }
        if (!z10) {
            l(aVar.clauseObject);
        }
        if (!aVar.e(this)) {
            f36800f.set(this, aVar);
            return;
        }
        if (!z10) {
            List<SelectImplementation<R>.a> list = this.clauses;
            p.f(list);
            list.add(aVar);
        }
        aVar.disposableHandleOrSegment = this.disposableHandleOrSegment;
        aVar.indexInSegment = this.indexInSegment;
        this.disposableHandleOrSegment = null;
        this.indexInSegment = -1;
    }

    public final void w(Object clauseObject) {
        SelectImplementation<R>.a aVarR = r(clauseObject);
        p.f(aVarR);
        aVarR.disposableHandleOrSegment = null;
        aVarR.indexInSegment = -1;
        u(aVarR, true);
    }

    public final TrySelectDetailedResult x(Object clauseObject, Object result) {
        return k.a(y(clauseObject, result));
    }

    public final int y(Object clauseObject, Object internalResult) {
        while (true) {
            Object obj = f36800f.get(this);
            if (obj instanceof InterfaceC1066l) {
                SelectImplementation<R>.a aVarR = r(clauseObject);
                if (aVarR == null) {
                    continue;
                } else {
                    q<Throwable, Object, d, t> qVarA = aVarR.a(this, internalResult);
                    if (f36800f.compareAndSet(this, obj, aVarR)) {
                        this.internalResult = internalResult;
                        if (k.j((InterfaceC1066l) obj, qVarA)) {
                            return 0;
                        }
                        this.internalResult = k.f15510e;
                        return 2;
                    }
                }
            } else {
                if (p.d(obj, k.f15508c) || (obj instanceof a)) {
                    return 3;
                }
                if (p.d(obj, k.f15509d)) {
                    return 2;
                }
                if (p.d(obj, k.f15507b)) {
                    if (f36800f.compareAndSet(this, obj, C1172u.e(clauseObject))) {
                        return 1;
                    }
                } else {
                    if (!(obj instanceof List)) {
                        throw new IllegalStateException(("Unexpected state: " + obj).toString());
                    }
                    if (f36800f.compareAndSet(this, obj, F.T0((Collection) obj, clauseObject))) {
                        return 1;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0062, code lost:
    
        r5 = r0.C();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
    
        if (r5 != f9.C4063a.g()) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
    
        g9.f.c(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
    
        if (r5 != f9.C4063a.g()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
    
        return Y8.t.f7040a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(e9.InterfaceC4014c<? super Y8.t> r6) {
        /*
            r5 = this;
            kotlinx.coroutines.c r0 = new kotlinx.coroutines.c
            e9.c r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.d(r6)
            r2 = 1
            r0.<init>(r1, r2)
            r0.I()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = j()
        L11:
            java.lang.Object r2 = r1.get(r5)
            Za.C r3 = cb.k.g()
            if (r2 != r3) goto L29
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = j()
            boolean r2 = r3.compareAndSet(r5, r2, r0)
            if (r2 == 0) goto L11
            Ua.C1072o.c(r0, r5)
            goto L62
        L29:
            boolean r3 = r2 instanceof java.util.List
            if (r3 == 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = j()
            Za.C r4 = cb.k.g()
            boolean r3 = r3.compareAndSet(r5, r2, r4)
            if (r3 == 0) goto L11
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L41:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L11
            java.lang.Object r3 = r2.next()
            k(r5, r3)
            goto L41
        L4f:
            boolean r1 = r2 instanceof kotlinx.coroutines.selects.SelectImplementation.a
            if (r1 == 0) goto L79
            Y8.t r1 = Y8.t.f7040a
            kotlinx.coroutines.selects.SelectImplementation$a r2 = (kotlinx.coroutines.selects.SelectImplementation.a) r2
            java.lang.Object r3 = i(r5)
            p9.q r5 = r2.a(r5, r3)
            r0.w(r1, r5)
        L62:
            java.lang.Object r5 = r0.C()
            java.lang.Object r0 = f9.C4063a.g()
            if (r5 != r0) goto L6f
            g9.f.c(r6)
        L6f:
            java.lang.Object r6 = f9.C4063a.g()
            if (r5 != r6) goto L76
            return r5
        L76:
            Y8.t r5 = Y8.t.f7040a
            return r5
        L79:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "unexpected state: "
            r6.append(r0)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.z(e9.c):java.lang.Object");
    }
}
