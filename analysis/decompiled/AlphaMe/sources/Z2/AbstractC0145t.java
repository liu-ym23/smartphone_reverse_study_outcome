package Z2;

import kotlin.Result;
import kotlin.ResultKt;

/* renamed from: Z2.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0145t {
    public static final Object a(Object obj) {
        if (!(obj instanceof r)) {
            return Result.m22constructorimpl(obj);
        }
        Result.Companion companion = Result.INSTANCE;
        return Result.m22constructorimpl(ResultKt.createFailure(((r) obj).f2238a));
    }
}
