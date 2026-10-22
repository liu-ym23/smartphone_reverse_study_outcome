package E4;

import j9.t;
import java.io.File;
import java.io.FileFilter;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements FileFilter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f473a;

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        switch (this.f473a) {
            case 0:
                if (file.isFile()) {
                    String name = file.getName();
                    k.e(name, "getName(...)");
                    if (t.e0(name, "user_wakeup_", false)) {
                        String name2 = file.getName();
                        k.e(name2, "getName(...)");
                        if (!t.W(name2, ".udm", false) || file.length() <= 0) {
                        }
                    }
                }
                break;
            default:
                if (file.isFile()) {
                    String name3 = file.getName();
                    k.e(name3, "getName(...)");
                    if (t.e0(name3, "user_wakeup_", false)) {
                        String name4 = file.getName();
                        k.e(name4, "getName(...)");
                        if (t.W(name4, ".udm", false)) {
                        }
                    }
                }
                break;
        }
        return false;
    }
}
