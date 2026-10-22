package androidx.compose.ui.internal;

import S7.a;
import androidx.compose.foundation.b;
import androidx.exifinterface.media.ExifInterface;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\u0004\u001a\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\t\u0010\u0007\u001a\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\n\u0010\u0004\u001a\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000b\u0010\u0004\u001a1\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eH\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001¢\u0006\u0004\b\u0010\u0010\u0012\u001a?\u0010\u0015\u001a\u00028\u0000\"\b\b\u0000\u0010\u0014*\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00018\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eH\u0080\b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a1\u0010\u0015\u001a\u00028\u0000\"\b\b\u0000\u0010\u0014*\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00018\u0000H\u0080\b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0004\b\u0015\u0010\u0017\u001a1\u0010\u0018\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eH\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001¢\u0006\u0004\b\u0018\u0010\u0011\u001a?\u0010\u0019\u001a\u00028\u0000\"\b\b\u0000\u0010\u0014*\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00018\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eH\u0080\b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, d2 = {"", "message", "LC7/r;", "throwIllegalStateException", "(Ljava/lang/String;)V", "", "throwIllegalStateExceptionForNullCheck", "(Ljava/lang/String;)Ljava/lang/Void;", "throwIllegalArgumentException", "throwIllegalArgumentExceptionForNullCheck", "throwUnsupportedOperationException", "throwIndexOutOfBoundsException", "", "value", "Lkotlin/Function0;", "lazyMessage", "checkPrecondition", "(ZLS7/a;)V", "(Z)V", "", ExifInterface.GPS_DIRECTION_TRUE, "checkPreconditionNotNull", "(Ljava/lang/Object;LS7/a;)Ljava/lang/Object;", "(Ljava/lang/Object;)Ljava/lang/Object;", "requirePrecondition", "requirePreconditionNotNull", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InlineClassHelperKt {
    public static final void checkPrecondition(boolean z10, a aVar) {
        if (z10) {
            return;
        }
        throwIllegalStateException((String) aVar.invoke());
    }

    public static final <T> T checkPreconditionNotNull(T t9, a aVar) {
        if (t9 != null) {
            return t9;
        }
        throw b.x((String) aVar.invoke());
    }

    public static final void requirePrecondition(boolean z10, a aVar) {
        if (z10) {
            return;
        }
        throwIllegalArgumentException((String) aVar.invoke());
    }

    public static final <T> T requirePreconditionNotNull(T t9, a aVar) {
        if (t9 != null) {
            return t9;
        }
        throwIllegalArgumentExceptionForNullCheck((String) aVar.invoke());
        throw new KotlinNothingValueException();
    }

    public static final void throwIllegalArgumentException(String str) {
        throw new IllegalArgumentException(str);
    }

    public static final Void throwIllegalArgumentExceptionForNullCheck(String str) {
        throw new IllegalArgumentException(str);
    }

    public static final void throwIllegalStateException(String str) {
        throw new IllegalStateException(str);
    }

    public static final Void throwIllegalStateExceptionForNullCheck(String str) {
        throw new IllegalStateException(str);
    }

    public static final void throwIndexOutOfBoundsException(String str) {
        throw new IndexOutOfBoundsException(str);
    }

    public static final void throwUnsupportedOperationException(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static final void checkPrecondition(boolean z10) {
        if (z10) {
            return;
        }
        throwIllegalStateException("Check failed.");
    }

    public static final <T> T checkPreconditionNotNull(T t9) {
        if (t9 != null) {
            return t9;
        }
        throw b.x("Required value was null.");
    }
}
