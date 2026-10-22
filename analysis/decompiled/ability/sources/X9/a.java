package X9;

import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class a implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1539a;
    public final Serializable b;

    public a() {
        this.f1539a = 2;
        this.b = Pattern.compile("^cpu[\\d]+$");
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.f1539a) {
            case 0:
                return str.startsWith((String) this.b);
            case 1:
                return str.endsWith((String) this.b);
            default:
                return ((Pattern) this.b).matcher(str).matches();
        }
    }

    public /* synthetic */ a(String str, int i) {
        this.f1539a = i;
        this.b = str;
    }
}
