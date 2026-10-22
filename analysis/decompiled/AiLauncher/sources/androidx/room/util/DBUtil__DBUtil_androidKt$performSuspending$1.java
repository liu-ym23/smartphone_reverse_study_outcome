package androidx.room.util;

import e9.InterfaceC4014c;
import f1.C4031a;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@InterfaceC4112d(c = "androidx.room.util.DBUtil__DBUtil_androidKt", f = "DBUtil.android.kt", l = {262, 264, 264}, m = "performSuspending")
/* loaded from: classes.dex */
public final class DBUtil__DBUtil_androidKt$performSuspending$1<R> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f14914a;

    /* renamed from: b, reason: collision with root package name */
    public Object f14915b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14916c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14917d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f14918e;

    /* renamed from: f, reason: collision with root package name */
    public int f14919f;

    public DBUtil__DBUtil_androidKt$performSuspending$1(InterfaceC4014c<? super DBUtil__DBUtil_androidKt$performSuspending$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f14918e = obj;
        this.f14919f |= Integer.MIN_VALUE;
        return C4031a.e(null, false, false, null, this);
    }
}
