package kotlin.reflect.jvm.internal.impl.incremental;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UtilsKt {
    public static final void record(LookupTracker r7, LookupLocation r8, ClassDescriptor r9, Name r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "from");
        Intrinsics.checkNotNullParameter(r9, "scopeOwner");
        Intrinsics.checkNotNullParameter(r10, "name");
        if (r7 != LookupTracker.DO_NOTHING.INSTANCE) goto L5;
        return;
    L5:
        LocationInfo r11 = r8.getLocation();
        if (r11 != null) goto L9;
        return;
    L9:
        if (r7.getRequiresPosition() == false) goto L11;
        Position r0 = r11.getPosition();
    L12:
        String r2 = r11.getFilePath();
        String r4 = DescriptorUtils.getFqName(r9).asString();
        Intrinsics.checkNotNullExpressionValue(r4, "getFqName(scopeOwner).asString()");
        ScopeKind r5 = ScopeKind.CLASSIFIER;
        String r6 = r10.asString();
        Intrinsics.checkNotNullExpressionValue(r6, "name.asString()");
        r7.record(r2, r0, r4, r5, r6);
        return;
    L11:
        r0 = Position.Companion.getNO_POSITION();
        goto L12
    }

    public static final void record(LookupTracker r1, LookupLocation r2, PackageFragmentDescriptor r3, Name r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "scopeOwner");
        Intrinsics.checkNotNullParameter(r4, "name");
        String r5 = r3.getFqName().asString();
        Intrinsics.checkNotNullExpressionValue(r5, "scopeOwner.fqName.asString()");
        String r6 = r4.asString();
        Intrinsics.checkNotNullExpressionValue(r6, "name.asString()");
        recordPackageLookup(r1, r2, r5, r6);
    }

    public static final void recordPackageLookup(LookupTracker r7, LookupLocation r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "from");
        Intrinsics.checkNotNullParameter(r9, "packageFqName");
        Intrinsics.checkNotNullParameter(r10, "name");
        if (r7 != LookupTracker.DO_NOTHING.INSTANCE) goto L5;
        return;
    L5:
        LocationInfo r11 = r8.getLocation();
        if (r11 != null) goto L9;
        return;
    L9:
        if (r7.getRequiresPosition() == false) goto L11;
        Position r0 = r11.getPosition();
    L12:
        String r2 = r11.getFilePath();
        r7.record(r2, r0, r9, ScopeKind.PACKAGE, r10);
        return;
    L11:
        r0 = Position.Companion.getNO_POSITION();
        goto L12
    }
}
