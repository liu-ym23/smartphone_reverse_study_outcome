package e9;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import nc.t0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3650c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f3651f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ boolean f3652g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(h hVar, boolean z10, nb.c cVar, int i) {
        super(2, cVar);
        this.f3650c = i;
        this.f3651f = hVar;
        this.f3652g = z10;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f3650c) {
            case 0:
                return new g((h) this.f3651f, this.f3652g, cVar, 0);
            case 1:
                return new g((h) this.f3651f, this.f3652g, cVar, 1);
            default:
                g gVar = new g((Context) this.f3651f, cVar);
                gVar.f3652g = ((Boolean) obj).booleanValue();
                return gVar;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) throws IOException {
        switch (this.f3650c) {
            case 0:
                g gVar = (g) create((kc.t) obj, (nb.c) obj2);
                jb.v vVar = jb.v.f6774a;
                gVar.invokeSuspend(vVar);
                return vVar;
            case 1:
                g gVar2 = (g) create((kc.t) obj, (nb.c) obj2);
                jb.v vVar2 = jb.v.f6774a;
                gVar2.invokeSuspend(vVar2);
                return vVar2;
            default:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                g gVar3 = (g) create(bool, (nb.c) obj2);
                jb.v vVar3 = jb.v.f6774a;
                gVar3.invokeSuspend(vVar3);
                return vVar3;
        }
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws IOException {
        int i = this.f3650c;
        jb.v vVar = jb.v.f6774a;
        Object obj2 = this.f3651f;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                id.c.I(obj);
                h hVar = (h) obj2;
                j0 j0Var = hVar.f3658b;
                boolean z10 = this.f3652g;
                j0Var.getClass();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("enabled", String.valueOf(z10));
                    Log.d("TaskRobotSettingsClient", "setLocalRun: enabled=" + z10 + ", updatedRows=" + j0Var.f3671a.update(j0Var.f3675e, contentValues, null, null));
                } catch (Exception e10) {
                    Log.e("TaskRobotSettingsClient", "setLocalRun failed", e10);
                }
                t0 t0Var = hVar.f3660d;
                t0Var.g(null, z.a((z) t0Var.getValue(), j0Var.a(), 13));
                break;
            case 1:
                ob.a aVar2 = ob.a.f9351c;
                id.c.I(obj);
                h hVar2 = (h) obj2;
                j0 j0Var2 = hVar2.f3658b;
                boolean z11 = this.f3652g;
                j0Var2.getClass();
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("enabled", String.valueOf(z11));
                    int iUpdate = j0Var2.f3671a.update(j0Var2.f3673c, contentValues2, null, null);
                    Log.d("TaskRobotSettingsClient", "setMasterSwitch: enabled=" + z11 + ", updatedRows=" + iUpdate);
                    if (iUpdate > 0) {
                        Map mapSingletonMap = Collections.singletonMap("switch_status", z11 ? "on" : "off");
                        mapSingletonMap.getClass();
                        td.h.P("toggle_gui_switch", "gui_manage", mapSingletonMap);
                    }
                } catch (Exception e11) {
                    Log.e("TaskRobotSettingsClient", "setMasterSwitch failed", e11);
                }
                if (!z11) {
                    t0 t0Var2 = hVar2.f3660d;
                    z zVar = new z(kb.s.f7404c, false, j0Var2.a(), false);
                    t0Var2.getClass();
                    t0Var2.g(null, zVar);
                    break;
                } else {
                    h.a(hVar2);
                    break;
                }
            default:
                ob.a aVar3 = ob.a.f9351c;
                id.c.I(obj);
                q5.e.a((Context) obj2, RescheduleReceiver.class, this.f3652g);
                break;
        }
        return vVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, nb.c cVar) {
        super(2, cVar);
        this.f3650c = 2;
        this.f3651f = context;
    }
}
