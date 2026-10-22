package kotlinx.coroutines.selects;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements SelectClause2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3 f21730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3 f21731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function3 f21732d;

    public e(Object r10, Function3 r11, Function3 r12, Function3 r13) {
        this.f21729a = r10;
        this.f21730b = r11;
        this.f21731c = r12;
        this.f21732d = r13;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Object getClauseObject() {
        return this.f21729a;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 getOnCancellationConstructor() {
        return this.f21732d;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 getProcessResFunc() {
        return this.f21731c;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 getRegFunc() {
        return this.f21730b;
    }

    public /* synthetic */ e(Object r10, Function3 r11, Function3 r12, Function3 r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r13 = null;
    L5:
        this(r10, r11, r12, r13);
    }
}
