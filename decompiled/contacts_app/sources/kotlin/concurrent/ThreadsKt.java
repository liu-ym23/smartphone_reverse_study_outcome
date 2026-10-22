package kotlin.concurrent;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Thread.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u001a3\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u000f0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\fH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {"thread", "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", "priority", "", "block", "Lkotlin/Function0;", "", "getOrSet", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/lang/ThreadLocal;", "default", "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ThreadsKt {
    public static /* synthetic */ Thread thread$default(boolean r6, boolean r7, ClassLoader r8, String r9, int r10, Function0 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r6 = true;
    L5:
        boolean r0 = r6;
        if ((r12 & 2) == 0) goto L8;
        r7 = false;
    L8:
        boolean r1 = r7;
        if ((r12 & 4) == 0) goto L11;
        ClassLoader r2 = null;
    L13:
        if ((r12 & 8) == 0) goto L15;
        String r3 = null;
    L17:
        if ((r12 & 16) == 0) goto L20;
        r10 = -1;
    L20:
        return thread(r0, r1, r2, r3, r10, r11);
    L15:
        r3 = r9;
        goto L17
    L11:
        r2 = r8;
        goto L13
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.concurrent.ThreadsKt$thread$thread$1] */
    public static final Thread thread(boolean r1, boolean r2, ClassLoader r3, String r4, int r5, final Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "block");
        ?? r0 = new ThreadsKt$thread$thread$1(r6);
        if (r2 == false) goto L5;
        r0.setDaemon(true);
    L5:
        if (r5 <= 0) goto L7;
        r0.setPriority(r5);
    L7:
        if (r4 == null) goto L9;
        r0.setName(r4);
    L9:
        if (r3 == null) goto L11;
        r0.setContextClassLoader(r3);
    L11:
        if (r1 == false) goto L14;
        r0.start();
    L14:
        return (Thread) r0;
    }

    private static final <T> T getOrSet(ThreadLocal<T> r1, Function0<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "default");
        T r0 = r1.get();
        if (r0 != null) goto L6;
        T r3 = r2.invoke();
        r1.set(r3);
        return r3;
    L6:
        return r0;
    }
}
