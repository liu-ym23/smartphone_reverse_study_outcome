package kotlinx.coroutines.selects;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements SelectClause0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3 f21722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3 f21723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function3 f21724d;

    public c(Object r10, Function3 r11, Function3 r12) {
        this.f21721a = r10;
        this.f21722b = r11;
        this.f21723c = r12;
        this.f21724d = SelectKt.c();
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Object getClauseObject() {
        return this.f21721a;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 getOnCancellationConstructor() {
        return this.f21723c;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 getProcessResFunc() {
        return this.f21724d;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 getRegFunc() {
        return this.f21722b;
    }

    public /* synthetic */ c(Object r10, Function3 r11, Function3 r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        this(r10, r11, r12);
    }
}
