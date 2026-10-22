package androidx.compose.foundation.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a*\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a\u001c\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a=\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u0001H\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0080\b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\u0011\u001a/\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u0001H\u000fH\u0080\b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\u0012\u001a*\u0010\u0013\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a=\u0010\u0014\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u0001H\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0080\b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\u0011¨\u0006\u0015"}, d2 = {"throwIllegalStateException", "", "message", "", "throwIllegalStateExceptionForNullCheck", "", "throwIllegalArgumentException", "throwIllegalArgumentExceptionForNullCheck", "throwIndexOutOfBoundsException", "checkPrecondition", "value", "", "lazyMessage", "Lkotlin/Function0;", "checkPreconditionNotNull", ExifInterface.GPS_DIRECTION_TRUE, "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Ljava/lang/Object;)Ljava/lang/Object;", "requirePrecondition", "requirePreconditionNotNull", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class InlineClassHelperKt {
    public static final void checkPrecondition(boolean r100) {
        if (r100 == true) goto L5;
        throwIllegalStateException("Check failed.");
        return;
    }

    public static final <T> T checkPreconditionNotNull(T r100) {
        if (r100 == null) goto L4;
        return r100;
    L4:
        throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    public static final void throwIllegalArgumentException(String r100) {
        throw new IllegalArgumentException(r100);
    }

    public static final Void throwIllegalArgumentExceptionForNullCheck(String r100) {
        throw new IllegalArgumentException(r100);
    }

    public static final void throwIllegalStateException(String r100) {
        throw new IllegalStateException(r100);
    }

    public static final Void throwIllegalStateExceptionForNullCheck(String r100) {
        throw new IllegalStateException(r100);
    }

    public static final void throwIndexOutOfBoundsException(String r100) {
        throw new IndexOutOfBoundsException(r100);
    }

    public static final void checkPrecondition(boolean r100, Function0<String> r101) {
        if (r100 == true) goto L5;
        throwIllegalStateException(r101.invoke());
        return;
    }

    public static final <T> T checkPreconditionNotNull(T r100, Function0<String> r101) {
        if (r100 == null) goto L4;
        return r100;
    L4:
        throwIllegalStateExceptionForNullCheck(r101.invoke());
        throw new KotlinNothingValueException();
    }

    public static final void requirePrecondition(boolean r100, Function0<String> r101) {
        if (r100 == true) goto L5;
        throwIllegalArgumentException(r101.invoke());
        return;
    }

    public static final <T> T requirePreconditionNotNull(T r100, Function0<String> r101) {
        if (r100 == null) goto L4;
        return r100;
    L4:
        throwIllegalArgumentExceptionForNullCheck(r101.invoke());
        throw new KotlinNothingValueException();
    }
}
