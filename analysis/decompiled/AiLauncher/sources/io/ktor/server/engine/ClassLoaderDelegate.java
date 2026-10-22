package io.ktor.server.engine;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/server/engine/ClassLoaderDelegate;", "Ljava/lang/ClassLoader;", "delegate", "<init>", "(Ljava/lang/ClassLoader;)V", "", "", "packagesList", "()Ljava/util/List;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ClassLoaderDelegate extends ClassLoader {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassLoaderDelegate(ClassLoader delegate) {
        super(delegate);
        kotlin.jvm.internal.p.i(delegate, "delegate");
    }

    public final List<String> packagesList() {
        Package[] packages = getPackages();
        kotlin.jvm.internal.p.h(packages, "getPackages(...)");
        ArrayList arrayList = new ArrayList(packages.length);
        for (Package r02 : packages) {
            arrayList.add(r02.getName());
        }
        return arrayList;
    }
}
