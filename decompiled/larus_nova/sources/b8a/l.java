package b8a;

import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Object> f18217d;

    public l(HashMap<String, Object> r100) {
        this.f18214a = m.d(r100, "name");
        this.f18215b = m.d(r100, "entryType");
        this.f18216c = m.a(r100, "typeResolved", Boolean.TRUE).booleanValue();
        this.f18217d = r100;
    }
}
