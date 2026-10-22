package y3;

import java.io.File;
import kb.t;
import y.l0;
import yb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15889c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f15890f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(Object obj, int i) {
        super(0);
        this.f15889c = i;
        this.f15890f = obj;
    }

    @Override // xb.a
    public final Object invoke() {
        switch (this.f15889c) {
            case 0:
                File file = (File) ((a1.b) this.f15890f).invoke();
                if (!ub.h.m(file).equals("preferences_pb")) {
                    od.f.r("File extension for file: ", file, " does not match required extension for Preferences file: preferences_pb");
                    return null;
                }
                File absoluteFile = file.getAbsoluteFile();
                absoluteFile.getClass();
                return absoluteFile;
            default:
                return new l0((t0.g) this.f15890f, t.f7405c);
        }
    }
}
