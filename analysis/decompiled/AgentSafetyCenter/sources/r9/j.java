package r9;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j implements View.OnTouchListener {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ View f10507c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ z3.g f10508f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ l f10509g;

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        l lVar = this.f10509g;
        View view2 = this.f10507c;
        z3.g gVar = this.f10508f;
        int action = motionEvent.getAction();
        int i = 1;
        if (action == 0) {
            gVar.f16369k.i = lVar.f10514b * 100.0f;
            if (view2.getLayerType() != 2 && lVar.f10513a) {
                view2.setLayerType(2, null);
            }
            Handler handler = new Handler(Looper.getMainLooper());
            e eVar = new e(i);
            eVar.f10501f = gVar;
            VarHandle.storeStoreFence();
            handler.post(eVar);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        gVar.f16369k.i = 100.0f;
        if (view2.getLayerType() != 2 && lVar.f10513a) {
            view2.setLayerType(2, null);
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        e eVar2 = new e(i);
        eVar2.f10501f = gVar;
        VarHandle.storeStoreFence();
        handler2.post(eVar2);
        return false;
    }
}
