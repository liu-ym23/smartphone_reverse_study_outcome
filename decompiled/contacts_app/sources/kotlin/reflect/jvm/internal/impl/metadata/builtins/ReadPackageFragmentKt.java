package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.io.InputStream;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;

/* JADX INFO: compiled from: readPackageFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ReadPackageFragmentKt {
    public static final Pair<ProtoBuf.PackageFragment, BuiltInsBinaryVersion> readBuiltinsPackageFragment(InputStream r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        InputStream r5 = r4;
        InputStream r0 = r5;     // Catch: Throwable -> L10
        BuiltInsBinaryVersion r1 = BuiltInsBinaryVersion.Companion.readFrom(r0);     // Catch: Throwable -> L10
        if (r1.isCompatible() == false) goto L6;
        ExtensionRegistryLite r2 = ExtensionRegistryLite.newInstance();     // Catch: Throwable -> L10
        BuiltInsProtoBuf.registerAllExtensions(r2);     // Catch: Throwable -> L10
        ProtoBuf.PackageFragment r3 = ProtoBuf.PackageFragment.parseFrom(r0, r2);     // Catch: Throwable -> L10
    L7:
        Pair<ProtoBuf.PackageFragment, BuiltInsBinaryVersion> r6 = TuplesKt.to(r3, r1);     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r5, null);
        return r6;
    L6:
        r3 = null;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    }
}
