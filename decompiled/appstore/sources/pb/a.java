package pb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23416c;

    public a() {
        this.f23416c = "BasicRoundCornerImpl";
    }

    @Override // pb.d
    public Path a(float r10, float r11, float r12, float r13, float r14) {
        return b(r10, r11, r12, r13, r14);
    }

    @Override // pb.d
    public void f(Canvas r10, Paint r11, float r12, float r13, float r14, float r15, float r16) {
        q.g(r10, "canvas");
        q.g(r11, "paint");
        r10.drawRoundRect(r12, r13, r14, r15, r16, r16, r11);
    }
}
