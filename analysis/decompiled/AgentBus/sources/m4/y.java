package m4;

import java.io.File;
import java.io.FileFilter;

/* loaded from: classes.dex */
public final /* synthetic */ class y implements FileFilter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6369a;

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        switch (this.f6369a) {
            case 0:
                q7.k.b(file);
                String name = file.getName();
                q7.k.d(name, "getName(...)");
                break;
        }
        return file.isDirectory();
    }
}
