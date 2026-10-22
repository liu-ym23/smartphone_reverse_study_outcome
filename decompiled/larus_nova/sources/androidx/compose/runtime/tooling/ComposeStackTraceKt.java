package androidx.compose.runtime.tooling;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0000\u001a \u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0000\u001a\u001e\u0010\b\u001a\u00020\t*\u00060\nj\u0002`\u000b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\"\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"tryAttachComposeStackTrace", "", "", "trace", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "attachComposeStackTrace", "appendStackTrace", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "RuntimePackageHash", "", "IncludeDebugInfo", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ComposeStackTraceKt {
    private static final boolean IncludeDebugInfo = false;
    private static final String RuntimePackageHash = "9igjgp";

    public static final void appendStackTrace(StringBuilder r110, List<ComposeStackTraceFrame> r111) {
        List r100 = CollectionsKt.createListBuilder();
        List r112 = CollectionsKt.asReversed(r111);
        int r101 = r112.size();
        int r102 = 0;
        String r103 = null;
        String r104 = null;
        int r105 = 0;
    L3:
        if (r105 >= r101) goto L35;
        ComposeStackTraceFrame r106 = (ComposeStackTraceFrame) ListProtector.get(r112, r105);
        SourceInformation r107 = r106.getSourceInfo();
        String r108 = r107.getFunctionName();
        if (r108 == null) goto L7;
    L13:
        r103 = r108;
    L14:
        String r109 = r107.getSourceFile();
        if (r109 != null) goto L18;
        if (r104 != null) goto L19;
        r104 = "<unknown file>";
    L19:
        List<LocationSourceInformation> r113 = r107.getLocations();
        if (r106.getGroupOffset() != null) goto L22;
    L24:
        String r114 = "<unknown line>";
    L25:
        String r115 = r103 + '(' + r104 + ':' + r114 + ')';
        if (r107.isCall() == true) goto L29;
        String r116 = (String) CollectionsKt.removeLastOrNull(r100);
    L29:
        if (Intrinsics.areEqual(r107.getFunctionName(), "rememberCompositionContext") == true) goto L31;
    L33:
        r100.add(r115);
    L34:
        r105 = r105 + 1;
        goto L3
    L31:
        if (Intrinsics.areEqual(r107.getPackageHash(), RuntimePackageHash) == false) goto L33;
    L22:
        if (r106.getGroupOffset().intValue() >= r113.size()) goto L24;
        r114 = String.valueOf(((LocationSourceInformation) ListProtector.get(r113, r106.getGroupOffset().intValue())).getLineNumber());
        goto L25
    L18:
        r104 = r109;
        goto L19
    L7:
        if (r107.isCall() == false) goto L9;
        r108 = "<lambda>";
    L10:
        if (r108 != null) goto L13;
        if (r103 != null) goto L14;
        r103 = "<unknown function>";
        goto L14
    L9:
        r108 = null;
        goto L10
    L35:
        List r117 = CollectionsKt.asReversed(CollectionsKt.build(r100));
        int r118 = r117.size();
    L36:
        if (r102 >= r118) goto L38;
        r110.append("\tat " + ((String) ListProtector.get(r117, r102)));
        r110.append('\n');
        r102 = r102 + 1;
        goto L36
    }

    public static final Throwable attachComposeStackTrace(Throwable r100, Function0<? extends List<ComposeStackTraceFrame>> r101) {
        tryAttachComposeStackTrace(r100, r101);
        return r100;
    }

    public static final boolean tryAttachComposeStackTrace(Throwable r100, Function0<? extends List<ComposeStackTraceFrame>> r101) {
        List<Throwable> r102 = ExceptionsKt.getSuppressedExceptions(r100);
        boolean r103 = false;
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L6;
        if ((((Throwable) r104.next()) instanceof DiagnosticComposeException) == false) goto L9;
        boolean r105 = false;
    L13:
        if (r105 == true) goto L24;
    L23:
        return r103;
    L24:
        List<ComposeStackTraceFrame> r106 = r101.invoke();     // Catch: Throwable -> L19
        r103 = !r106.isEmpty();     // Catch: Throwable -> L19
        if (r103 == false) goto L18;
        DiagnosticComposeException r107 = new DiagnosticComposeException(r106);     // Catch: Throwable -> L19
    L21:
        if (r107 == null) goto L23;
        ExceptionsKt.addSuppressed(r100, r107);
        goto L23
    L18:
        r107 = null;
    L19:
        th = move-exception;
        r107 = th;
    L6:
        r105 = true;
        goto L13
    L5:
        if (r102.isEmpty() == false) goto L7;
        goto L6
    }
}
