package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.Regex;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class Checks {
    private final Function1<FunctionDescriptor, String> additionalCheck;
    private final Check[] checks;
    private final Name name;
    private final Collection<Name> nameList;
    private final Regex regex;

    /* JADX WARN: Multi-variable type inference failed */
    private Checks(Name r1, Regex r2, Collection<Name> r3, Function1<? super FunctionDescriptor, String> r4, Check... r5) {
        this.name = r1;
        this.regex = r2;
        this.nameList = r3;
        this.additionalCheck = r4;
        this.checks = r5;
    }

    public final boolean isApplicable(FunctionDescriptor r4) {
        Intrinsics.checkNotNullParameter(r4, "functionDescriptor");
        if (this.name == null) goto L8;
        if (Intrinsics.areEqual(r4.getName(), this.name) == true) goto L8;
        return false;
    L8:
        if (this.regex == null) goto L12;
        String r0 = r4.getName().asString();
        Intrinsics.checkNotNullExpressionValue(r0, "functionDescriptor.name.asString()");
        Regex r2 = this.regex;
        if (r2.matches(r0) == true) goto L12;
        return false;
    L12:
        Collection<Name> r3 = this.nameList;
        if (r3 != null) goto L15;
        return true;
    L15:
        if (r3.contains(r4.getName()) == true) goto L19;
        return false;
    L19:
        return true;
    }

    public final CheckResult checkAll(FunctionDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "functionDescriptor");
        Check[] r0 = this.checks;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        String r3 = r0[r2].invoke(r5);
        if (r3 != null) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        return new CheckResult.IllegalSignature(r3);
    L9:
        String r4 = this.additionalCheck.invoke(r5);
        if (r4 == null) goto L14;
        return new CheckResult.IllegalSignature(r4);
    L14:
        return CheckResult.SuccessCheck.INSTANCE;
    }

    public /* synthetic */ Checks(Name r1, Check[] r2, AnonymousClass2 r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = AnonymousClass2.INSTANCE;
    L5:
        this(r1, r2, r3);
    }

    public Checks(Name r8, Check[] r9, Function1<? super FunctionDescriptor, String> r10) {
        Intrinsics.checkNotNullParameter(r8, "name");
        Intrinsics.checkNotNullParameter(r9, "checks");
        Intrinsics.checkNotNullParameter(r10, "additionalChecks");
        this(r8, null, null, r10, (Check[]) Arrays.copyOf(r9, r9.length));
    }

    public /* synthetic */ Checks(Regex r1, Check[] r2, AnonymousClass3 r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = AnonymousClass3.INSTANCE;
    L5:
        this(r1, r2, r3);
    }

    public Checks(Regex r8, Check[] r9, Function1<? super FunctionDescriptor, String> r10) {
        Intrinsics.checkNotNullParameter(r8, "regex");
        Intrinsics.checkNotNullParameter(r9, "checks");
        Intrinsics.checkNotNullParameter(r10, "additionalChecks");
        this(null, r8, null, r10, (Check[]) Arrays.copyOf(r9, r9.length));
    }

    public /* synthetic */ Checks(Collection r1, Check[] r2, AnonymousClass4 r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = AnonymousClass4.INSTANCE;
    L5:
        this(r1, r2, r3);
    }

    public Checks(Collection<Name> r8, Check[] r9, Function1<? super FunctionDescriptor, String> r10) {
        Intrinsics.checkNotNullParameter(r8, "nameList");
        Intrinsics.checkNotNullParameter(r9, "checks");
        Intrinsics.checkNotNullParameter(r10, "additionalChecks");
        this(null, null, r8, r10, (Check[]) Arrays.copyOf(r9, r9.length));
    }
}
