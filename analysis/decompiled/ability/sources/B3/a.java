package B3;

import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final Pattern f188a;

    /* JADX WARN: Removed duplicated region for block: B:79:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B3.a.<init>(java.lang.String):void");
    }

    @Override // B3.c
    public final boolean matches(String str) {
        return this.f188a.matcher(str).find();
    }
}
