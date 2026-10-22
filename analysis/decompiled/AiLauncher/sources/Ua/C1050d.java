package Ua;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.JobKt__JobKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u000f\u000bB\u001d\u0012\u0014\u0010\u0005\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086@¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0005\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u000b\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¨\u0006\u0010"}, d2 = {"LUa/d;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "LUa/Q;", "deferreds", "<init>", "([LUa/Q;)V", "", "c", "(Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "[LUa/Q;", "LOa/c;", "notCompletedCount", Const.INTENT_KEY_PKGNAME, "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Ua.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1050d<T> {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6360b = AtomicIntegerFieldUpdater.newUpdater(C1050d.class, "notCompletedCount$volatile");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Q<T>[] deferreds;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R<\u0010\u001d\u001a\u000e\u0018\u00010\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00172\u0012\u0010\u0018\u001a\u000e\u0018\u00010\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001d\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0018\u00010\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00170\"8\u0002X\u0082\u0004¨\u0006$"}, d2 = {"LUa/d$a;", "LUa/w0;", "LUa/l;", "", "continuation", "<init>", "(LUa/d;LUa/l;)V", "", "cause", "LY8/t;", "v", "(Ljava/lang/Throwable;)V", "e", "LUa/l;", "LUa/a0;", "f", "LUa/a0;", "y", "()LUa/a0;", "B", "(LUa/a0;)V", "handle", "LUa/d$b;", "LUa/d;", UxipConstants.f30680s, "x", "()LUa/d$b;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(LUa/d$b;)V", "disposer", "", "u", "()Z", "onCancelling", "LOa/e;", "_disposer", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: Ua.d$a */
    public final class a extends AbstractC1088w0 {

        /* renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f6362h = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer$volatile");
        private volatile /* synthetic */ Object _disposer$volatile;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC1066l<List<? extends T>> continuation;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public InterfaceC1045a0 handle;

        /* JADX WARN: Multi-variable type inference failed */
        public a(InterfaceC1066l<? super List<? extends T>> interfaceC1066l) {
            this.continuation = interfaceC1066l;
        }

        public final void A(C1050d<T>.b bVar) {
            f6362h.set(this, bVar);
        }

        public final void B(InterfaceC1045a0 interfaceC1045a0) {
            this.handle = interfaceC1045a0;
        }

        @Override // Ua.AbstractC1088w0
        public boolean u() {
            return false;
        }

        @Override // Ua.AbstractC1088w0
        public void v(Throwable cause) {
            if (cause != null) {
                Object objK = this.continuation.k(cause);
                if (objK != null) {
                    this.continuation.x(objK);
                    C1050d<T>.b bVarX = x();
                    if (bVarX != null) {
                        bVarX.a();
                        return;
                    }
                    return;
                }
                return;
            }
            if (C1050d.d().decrementAndGet(C1050d.this) == 0) {
                InterfaceC1066l<List<? extends T>> interfaceC1066l = this.continuation;
                Q[] qArr = C1050d.this.deferreds;
                ArrayList arrayList = new ArrayList(qArr.length);
                for (Q q10 : qArr) {
                    arrayList.add(q10.m());
                }
                interfaceC1066l.resumeWith(Result.b(arrayList));
            }
        }

        public final C1050d<T>.b x() {
            return (b) f6362h.get(this);
        }

        public final InterfaceC1045a0 y() {
            InterfaceC1045a0 interfaceC1045a0 = this.handle;
            if (interfaceC1045a0 != null) {
                return interfaceC1045a0;
            }
            kotlin.jvm.internal.p.A("handle");
            return null;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f0\u0003R\b\u0012\u0004\u0012\u00028\u00000\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f0\u0003R\b\u0012\u0004\u0012\u00028\u00000\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012¨\u0006\u0013"}, d2 = {"LUa/d$b;", "Lkotlinx/coroutines/b;", "", "LUa/d$a;", "LUa/d;", "nodes", "<init>", "(LUa/d;[LUa/d$a;)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "", "cause", "c", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "[LUa/d$a;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: Ua.d$b */
    public final class b implements kotlinx.coroutines.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final C1050d<T>.a[] nodes;

        public b(C1050d<T>.a[] aVarArr) {
            this.nodes = aVarArr;
        }

        public final void a() {
            for (C1050d<T>.a aVar : this.nodes) {
                aVar.y().dispose();
            }
        }

        @Override // kotlinx.coroutines.b
        public void c(Throwable cause) {
            a();
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.nodes + ']';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1050d(Q<? extends T>[] qArr) {
        this.deferreds = qArr;
        this.notCompletedCount$volatile = qArr.length;
    }

    public static final /* synthetic */ AtomicIntegerFieldUpdater d() {
        return f6360b;
    }

    public final Object c(InterfaceC4014c<? super List<? extends T>> interfaceC4014c) {
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        int length = this.deferreds.length;
        a[] aVarArr = new a[length];
        for (int i10 = 0; i10 < length; i10++) {
            Q q10 = this.deferreds[i10];
            q10.start();
            a aVar = new a(cVar);
            aVar.B(JobKt__JobKt.q(q10, false, aVar, 1, null));
            Y8.t tVar = Y8.t.f7040a;
            aVarArr[i10] = aVar;
        }
        C1050d<T>.b bVar = new b(aVarArr);
        for (int i11 = 0; i11 < length; i11++) {
            aVarArr[i11].A(bVar);
        }
        if (cVar.g()) {
            bVar.a();
        } else {
            C1072o.c(cVar, bVar);
        }
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objC;
    }
}
