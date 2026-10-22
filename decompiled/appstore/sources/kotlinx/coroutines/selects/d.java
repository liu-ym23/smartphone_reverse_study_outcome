package kotlinx.coroutines.selects;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements SelectClause1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3 f21726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3 f21727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function3 f21728d;

    public d(Object r10, Function3 r11, Function3 r12, Function3 r13) {
        this.f21725a = r10;
        this.f21726b = r11;
        this.f21727c = r12;
        this.f21728d = r13;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Object getClauseObject() {
        return this.f21725a;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 getOnCancellationConstructor() {
        return this.f21728d;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 getProcessResFunc() {
        return this.f21727c;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 getRegFunc() {
        return this.f21726b;
    }

    public /* synthetic */ d(Object r10, Function3 r11, Function3 r12, Function3 r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r13 = null;
    L5:
        this(r10, r11, r12, r13);
    }
}
