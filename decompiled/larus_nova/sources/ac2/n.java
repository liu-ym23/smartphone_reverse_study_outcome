package ac2;

import java.io.IOException;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes9.dex */
public final class n extends p<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f2588a;

    public n(p r100) {
        this.f2588a = r100;
    }

    @Override // ac2.p
    public final void a(w r100, Object r101) throws IOException {
        if (r101 != null) goto L4;
        return;
    L4:
        int r102 = Array.getLength(r101);
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L7;
        this.f2588a.a(r100, Array.get(r101, r103));
        r103 = r103 + 1;
        goto L5
    }
}
