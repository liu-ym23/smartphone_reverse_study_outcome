package ca7;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes11.dex */
public final class i extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Pattern> f22964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Collection<String> f22965d;

    public i(Collection<String> r100) {
        this.f22964c = new ArrayList();
        this.f22965d = r100;
        Iterator<String> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        String r102 = r101.next();
        this.f22964c.add(PatternProtector.compile(r102));     // Catch: Exception -> L8
        goto L4
    }

    @Override // ca7.c
    public final boolean b(da7.b r100) {
        da7.c r101 = r100.a(this);
        if (super.b(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (r101.f467706b == false) goto L7;
        return true;
    }

    @Override // ca7.c
    public final void e(da7.b r100, c r101) {
        r100.a(this).f467705a = true;
        da7.c r102 = r100.a(this);
        String r103 = (String) r101.d(r100);     // Catch: Exception -> L10
        Iterator<Pattern> r104 = this.f22964c.iterator();     // Catch: Exception -> L10
    L5:
        if (r104.hasNext() == false) goto L17;
        if (r104.next().matcher(r103).matches() == false) goto L5;
        r102.f467706b = true;     // Catch: Exception -> L10
        return;
    L17:
        return;
    L10:
        r102.f467706b = false;
    }
}
