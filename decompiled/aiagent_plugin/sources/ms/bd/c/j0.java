package ms.bd.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
final class j0 extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ k0 f39525a;

    j0(k0 r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.f39525a = r3;
        super(r5);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        super.onTouchEvent(r8);
        long r0 = r8.getEventTime();
        m0 r2 = k0.a(this.f39525a);
        long r5 = 0;
        if (k0.a(this.f39525a).f39555d == 0) goto L6;
        r5 = r0 - k0.a(this.f39525a).f39555d;
    L6:
        r2.f39554c = r5;
        k0.a(this.f39525a).f39555d = r0;
        k0.a(this.f39525a).f39556e.f39557a = r8.getX();
        k0.a(this.f39525a).f39556e.f39558b = r8.getY();
        k0.a(this.f39525a).f39553b++;
        String r7 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b6224a", new byte[]{87, 59, 84, 127, 2, 120, 77, 30, 117, 103}), String.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "4f2623", new byte[]{96, 96, 27, 2, 32, 43, 35, 78, 108, 104, 0, 114, 68, 76, 25, 126, 119, 2, 112}), String.class, "com.obric.aiagent.plugin");
        return true;
    }
}
