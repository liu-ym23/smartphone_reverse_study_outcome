package androidx.compose.animation.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a1\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007H\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000b\u0010\u0004\u001a\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a1\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007H\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001¢\u0006\u0004\b\u000f\u0010\n\u001a?\u0010\u0012\u001a\u00028\u0000\"\b\b\u0000\u0010\u0011*\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00018\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007H\u0080\b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"", "message", "LC7/r;", "throwIllegalArgumentException", "(Ljava/lang/String;)V", "", "value", "Lkotlin/Function0;", "lazyMessage", "requirePrecondition", "(ZLS7/a;)V", "throwIllegalStateException", "", "throwIllegalStateExceptionForNullCheck", "(Ljava/lang/String;)Ljava/lang/Void;", "checkPrecondition", "", ExifInterface.GPS_DIRECTION_TRUE, "checkPreconditionNotNull", "(Ljava/lang/Object;LS7/a;)Ljava/lang/Object;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PreconditionsKt {
    public static final void checkPrecondition(boolean z10, S7.a aVar) {
        if (z10) {
            return;
        }
        throwIllegalStateException((String) aVar.invoke());
    }

    public static final <T> T checkPreconditionNotNull(T t9, S7.a aVar) {
        if (t9 != null) {
            return t9;
        }
        throwIllegalStateExceptionForNullCheck((String) aVar.invoke());
        throw new KotlinNothingValueException();
    }

    public static final void requirePrecondition(boolean z10, S7.a aVar) {
        if (z10) {
            return;
        }
        throwIllegalArgumentException((String) aVar.invoke());
    }

    public static final void throwIllegalArgumentException(String str) {
        throw new IllegalArgumentException(str);
    }

    public static final void throwIllegalStateException(String str) {
        throw new IllegalStateException(str);
    }

    public static final Void throwIllegalStateExceptionForNullCheck(String str) {
        throw new IllegalStateException(str);
    }
}
