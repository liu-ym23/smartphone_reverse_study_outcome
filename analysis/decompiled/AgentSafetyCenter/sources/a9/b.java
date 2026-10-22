package a9;

import android.util.Log;
import com.stepos.agentsafetycenter.mcp.service.AbilityService;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f244a;

    /* renamed from: b, reason: collision with root package name */
    public AbilityService f245b;

    public /* synthetic */ b(int i) {
        this.f244a = i;
    }

    public static void a(j jVar) {
        if (!(jVar instanceof i)) {
            if (!(jVar instanceof h)) {
                g5.f.a();
                return;
            }
            h hVar = (h) jVar;
            Log.w("FileRestore", "handle fail code=" + hVar.f264a.f254c + " msg=" + hVar.f265b);
            return;
        }
        i iVar = (i) jVar;
        String str = iVar.f273a;
        int i = iVar.f276d;
        int i3 = iVar.f277e;
        Set set = p9.a.f9925a;
        Log.i("FileRestore", "handle ok method=" + str + " count=" + i + " errors=" + i3 + " path=" + p9.a.d(iVar.f274b));
    }

    public static void b(j jVar) {
        if (!(jVar instanceof i)) {
            if (!(jVar instanceof h)) {
                g5.f.a();
                return;
            }
            h hVar = (h) jVar;
            Log.w("FileSafeDelete", "handle fail code=" + hVar.f264a.f254c + " msg=" + hVar.f265b);
            return;
        }
        i iVar = (i) jVar;
        String str = iVar.f273a;
        int i = iVar.f276d;
        int i3 = iVar.f277e;
        Set set = p9.a.f9925a;
        Log.i("FileSafeDelete", "handle ok method=" + str + " count=" + i + " errors=" + i3 + " path=" + p9.a.d(iVar.f274b));
    }
}
