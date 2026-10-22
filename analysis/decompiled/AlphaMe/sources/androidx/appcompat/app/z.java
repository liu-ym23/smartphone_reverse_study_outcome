package androidx.appcompat.app;

import android.content.Context;
import android.os.PowerManager;

/* loaded from: classes.dex */
public final class z extends B {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2688c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ F f2689d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f2690e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(F f4, android.support.v4.media.session.c cVar) {
        super(f4);
        this.f2689d = f4;
        this.f2690e = cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e9, code lost:
    
        if (r0 != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0102, code lost:
    
        if (r0 < 22) goto L50;
     */
    @Override // androidx.appcompat.app.B
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b() {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.z.b():int");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(F f4, Context context) {
        super(f4);
        this.f2689d = f4;
        this.f2690e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
