package androidx.room.util;

import e9.InterfaceC4014c;
import f1.C4031a;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@InterfaceC4112d(c = "androidx.room.util.DBUtil__DBUtil_androidKt", f = "DBUtil.android.kt", l = {97, 262, 264, 264}, m = "performInTransactionSuspending")
/* loaded from: classes.dex */
public final class DBUtil__DBUtil_androidKt$performInTransactionSuspending$1<R> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f14907a;

    /* renamed from: b, reason: collision with root package name */
    public Object f14908b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f14909c;

    /* renamed from: d, reason: collision with root package name */
    public int f14910d;

    public DBUtil__DBUtil_androidKt$performInTransactionSuspending$1(InterfaceC4014c<? super DBUtil__DBUtil_androidKt$performInTransactionSuspending$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f14909c = obj;
        this.f14910d |= Integer.MIN_VALUE;
        return C4031a.d(null, null, this);
    }
}
