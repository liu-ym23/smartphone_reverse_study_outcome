package b7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f3112a = new o();

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList f3113b = new ArrayList();

    public static List a(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return EmptyList.f10001a;
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                String name = file2.getName();
                kotlin.jvm.internal.g.e(name, "getName(...)");
                if (!gc.o.k0(name, ".", false)) {
                    String name2 = file2.getName();
                    kotlin.jvm.internal.g.e(name2, "getName(...)");
                    if (!gc.o.e0(name2, ".tmp", false)) {
                        arrayList.add(file2);
                    }
                }
            }
        }
        return arrayList;
    }
}
