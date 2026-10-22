package coc;

import com.bytedance.apm.ApmAgent;
import com.larksuite.component.universe_design.dialog.UDDialog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f24672a = null;

    public static final class a implements coc.b {
        public a() {
        }

        @Override // coc.b
        public final void a(Map r100, Map r101, Map r102, int r103) {
            Intrinsics.checkNotNullParameter("scs_menu_protect_error", "serviceName");
            JSONObject r104 = null;
            if (r100 != null) goto L5;
            JSONObject r105 = null;
        L6:
            if (r101 != null) goto L8;
            JSONObject r106 = null;
        L9:
            if (r102 == null) goto L12;
            r104 = new JSONObject(r102);
        L12:
            ApmAgent.monitorStatusAndEvent("scs_menu_protect_error", r103, r105, r106, r104);
            return;
        L8:
            r106 = new JSONObject(r101);
            goto L9
        L5:
            r105 = new JSONObject(r100);
            goto L6
        }
    }

    public static final class b implements coc.c {
        public b() {
        }

        @Override // coc.c
        public final /* synthetic */ void a() {
        }

        @Override // coc.c
        public final /* synthetic */ void b() {
        }

        @Override // coc.c
        public final /* synthetic */ void c() {
        }
    }

    public static final class c implements coc.a {
        public c() {
        }

        @Override // coc.a
        public final /* synthetic */ void a() {
        }
    }

    public static final class d implements coc.d {
        public d() {
        }

        @Override // coc.d
        public final void a(UDDialog r100) {
            Intrinsics.checkNotNullParameter(r100, "dialog");
        }
    }

    static {
        f24672a = new e(new a(), new b(), new c(), new d());
    }
}
