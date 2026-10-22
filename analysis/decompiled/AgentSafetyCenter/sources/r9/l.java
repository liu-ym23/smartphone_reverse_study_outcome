package r9;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import com.stepos.agentsafetycenter.R;
import f7.w;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public boolean f10513a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10514b;

    public l() {
        new ArrayList();
        this.f10514b = 0.95f;
    }

    public final void a(View view) {
        int color;
        if (view == null) {
            return;
        }
        try {
            color = view.getContext().getColor(R.color.fd_sys_color_state_pressed_default);
        } catch (Exception unused) {
            Log.d("StepOSSPressAnimationHelper", " res not fond , sourceContext is null");
            color = (view.getResources().getConfiguration().uiMode & 48) == 32 ? 611743360 : 443971200;
        }
        int iArgb = Color.argb(255, Color.red(color), Color.green(color), Color.blue(color));
        float fAlpha = Color.alpha(color) / 255.0f;
        z3.h hVar = new z3.h();
        hVar.a(0.9f);
        hVar.b(250.0f);
        z3.g gVar = new z3.g(new w.d());
        gVar.f16369k = hVar;
        gVar.f16361b = 100.0f;
        gVar.f16362c = true;
        this.f10513a = true ^ (view instanceof w);
        j jVar = new j();
        jVar.f10509g = this;
        jVar.f10507c = view;
        jVar.f10508f = gVar;
        VarHandle.storeStoreFence();
        view.setOnTouchListener(jVar);
        i iVar = new i();
        iVar.f10505a = this;
        iVar.f10506b = view;
        VarHandle.storeStoreFence();
        ArrayList arrayList = gVar.i;
        if (!arrayList.contains(iVar)) {
            arrayList.add(iVar);
        }
        k kVar = new k();
        kVar.f10510a = view;
        kVar.f10511b = fAlpha;
        kVar.f10512c = iArgb;
        VarHandle.storeStoreFence();
        gVar.a(kVar);
    }

    public final void b(int i, View view) {
        view.setTag(R.id.press_anim_tag, Integer.valueOf(i));
        a(view);
    }
}
