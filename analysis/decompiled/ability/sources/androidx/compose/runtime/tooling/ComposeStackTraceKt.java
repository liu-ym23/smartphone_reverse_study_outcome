package androidx.compose.runtime.tooling;

import D7.q;
import S0.b;
import S7.a;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a'\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u0000¢\u0006\u0004\b\b\u0010\t\u001a%\u0010\r\u001a\u00020\f*\u00060\nj\u0002`\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¢\u0006\u0004\b\r\u0010\u000e\"\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0012\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "trace", "", "tryAttachComposeStackTrace", "(Ljava/lang/Throwable;LS7/a;)Z", "attachComposeStackTrace", "(Ljava/lang/Throwable;LS7/a;)Ljava/lang/Throwable;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "LC7/r;", "appendStackTrace", "(Ljava/lang/StringBuilder;Ljava/util/List;)V", "", "RuntimePackageHash", "Ljava/lang/String;", "IncludeDebugInfo", "Z", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposeStackTraceKt {
    private static final boolean IncludeDebugInfo = false;
    private static final String RuntimePackageHash = "9igjgp";

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034 A[PHI: r9
      0x0034: PHI (r9v1 java.lang.String) = (r9v0 java.lang.String), (r9v17 java.lang.String) binds: [B:5:0x0021, B:10:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void appendStackTrace(java.lang.StringBuilder r12, java.util.List<androidx.compose.runtime.tooling.ComposeStackTraceFrame> r13) {
        /*
            kotlin.collections.builders.ListBuilder r0 = H4.o.y()
            D7.K r13 = D7.v.r0(r13)
            int r1 = r13.size()
            r2 = 0
            r3 = 0
            r5 = r2
            r6 = r5
            r4 = r3
        L11:
            if (r4 >= r1) goto Lcb
            java.lang.Object r7 = r13.get(r4)
            androidx.compose.runtime.tooling.ComposeStackTraceFrame r7 = (androidx.compose.runtime.tooling.ComposeStackTraceFrame) r7
            androidx.compose.runtime.tooling.SourceInformation r8 = r7.getSourceInfo()
            java.lang.String r9 = r8.getFunctionName()
            if (r9 != 0) goto L34
            boolean r9 = r8.getIsCall()
            if (r9 == 0) goto L2c
            java.lang.String r9 = "<lambda>"
            goto L2d
        L2c:
            r9 = r2
        L2d:
            if (r9 != 0) goto L34
            if (r5 != 0) goto L35
            java.lang.String r5 = "<unknown function>"
            goto L35
        L34:
            r5 = r9
        L35:
            java.lang.String r9 = r8.getSourceFile()
            if (r9 != 0) goto L40
            if (r6 != 0) goto L41
            java.lang.String r6 = "<unknown file>"
            goto L41
        L40:
            r6 = r9
        L41:
            java.util.List r9 = r8.getLocations()
            java.lang.Integer r10 = r7.getGroupOffset()
            if (r10 == 0) goto L70
            java.lang.Integer r10 = r7.getGroupOffset()
            int r10 = r10.intValue()
            int r11 = r9.size()
            if (r10 >= r11) goto L70
            java.lang.Integer r7 = r7.getGroupOffset()
            int r7 = r7.intValue()
            java.lang.Object r7 = r9.get(r7)
            androidx.compose.runtime.tooling.LocationSourceInformation r7 = (androidx.compose.runtime.tooling.LocationSourceInformation) r7
            int r7 = r7.getLineNumber()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            goto L72
        L70:
            java.lang.String r7 = "<unknown line>"
        L72:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r5)
            r10 = 40
            r9.append(r10)
            r9.append(r6)
            r10 = 58
            r9.append(r10)
            r9.append(r7)
            r7 = 41
            java.lang.String r10 = "toString(...)"
            java.lang.String r7 = androidx.appfunctions.metadata.a.h(r7, r10, r9)
            boolean r9 = r8.getIsCall()
            if (r9 != 0) goto Lab
            boolean r9 = r0.isEmpty()
            if (r9 == 0) goto La1
            r9 = r2
            goto La9
        La1:
            int r9 = H4.o.H(r0)
            java.lang.Object r9 = r0.remove(r9)
        La9:
            java.lang.String r9 = (java.lang.String) r9
        Lab:
            java.lang.String r9 = r8.getFunctionName()
            java.lang.String r10 = "rememberCompositionContext"
            boolean r9 = kotlin.jvm.internal.k.b(r9, r10)
            if (r9 == 0) goto Lc4
            java.lang.String r8 = r8.getPackageHash()
            java.lang.String r9 = "9igjgp"
            boolean r8 = kotlin.jvm.internal.k.b(r8, r9)
            if (r8 == 0) goto Lc4
            goto Lc7
        Lc4:
            r0.add(r7)
        Lc7:
            int r4 = r4 + 1
            goto L11
        Lcb:
            kotlin.collections.builders.ListBuilder r13 = H4.o.q(r0)
            D7.K r13 = D7.v.r0(r13)
            int r0 = r13.size()
        Ld7:
            if (r3 >= r0) goto Lf8
            java.lang.Object r1 = r13.get(r3)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "\tat "
            r2.<init>(r4)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r12.append(r1)
            r1 = 10
            r12.append(r1)
            int r3 = r3 + 1
            goto Ld7
        Lf8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.tooling.ComposeStackTraceKt.appendStackTrace(java.lang.StringBuilder, java.util.List):void");
    }

    public static final Throwable attachComposeStackTrace(Throwable th, a aVar) {
        tryAttachComposeStackTrace(th, aVar);
        return th;
    }

    public static final boolean tryAttachComposeStackTrace(Throwable th, a aVar) {
        Iterable iterableL;
        Object objInvoke;
        k.f(th, "<this>");
        Integer num = M7.a.f972a;
        DiagnosticComposeException diagnosticComposeException = null;
        if (num == null || num.intValue() >= 19) {
            Throwable[] suppressed = th.getSuppressed();
            k.e(suppressed, "getSuppressed(...)");
            iterableL = q.L(suppressed);
        } else {
            Method method = L7.a.b;
            iterableL = (method == null || (objInvoke = method.invoke(th, null)) == null) ? EmptyList.f4893a : q.L((Throwable[]) objInvoke);
        }
        Iterable iterable = iterableL;
        boolean z10 = false;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (((Throwable) it.next()) instanceof DiagnosticComposeException) {
                    return false;
                }
            }
        }
        try {
            List list = (List) aVar.invoke();
            boolean zIsEmpty = list.isEmpty();
            z10 = !zIsEmpty;
            if (!zIsEmpty) {
                diagnosticComposeException = new DiagnosticComposeException(list);
            }
        } catch (Throwable th2) {
            diagnosticComposeException = th2;
        }
        if (diagnosticComposeException != null) {
            b.e0(th, diagnosticComposeException);
        }
        return z10;
    }
}
