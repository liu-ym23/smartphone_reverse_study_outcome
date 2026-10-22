package bm8;

import com.larus.bmhome.chat.api.r;
import com.larus.bmhome.chat.layout.widget.AppletWidget;
import com.larus.bmhome.chat.standarduikit.markdown.view.MarkdownAppletContainer;
import ic8.y;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h implements ue8.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f19644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f19645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MarkdownAppletContainer f19646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f19647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f19648e;

    public static final class a extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MarkdownAppletContainer f19649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f19650b;

        @Override // ic8.y, ic8.x
        public final void c() {
            AppletWidget r100 = this.f19649a.f309509a;
            if (r100 == null) goto L5;
            Intrinsics.checkNotNullParameter(this, "observer");
            r100.f304756r.remove(this);
        L5:
            this.f19650b.f19644a.invoke();
        }

        public a(MarkdownAppletContainer r100, h r101) {
            this.f19649a = r100;
            this.f19650b = r101;
        }
    }

    @Override // ue8.d
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f19645b.invoke();
    }

    @Override // ue8.d
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        final MarkdownAppletContainer r101 = this.f19646c;
        final String r102 = this.f19647d;
        final String r103 = this.f19648e;
        this.f19644a = new f(r101, r102, r103);
        AppletWidget r104 = r101.f309509a;
        if (r104 == null) goto L5;
        r r105 = r104.getWidgetContainer();
    L6:
        if (r105 == null) goto L8;
        this.f19644a.invoke();
        return;
    L8:
        MarkdownAppletContainer r106 = this.f19646c;
        AppletWidget r107 = r106.f309509a;
        if (r107 == null) goto L15;
        a r108 = new a(r106, this);
        Intrinsics.checkNotNullParameter(r108, "observer");
        if (r107.f304756r.contains(r108) == true) goto L16;
        r107.f304756r.add(r108);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r105 = null;
        goto L6
    }

    public h(MarkdownAppletContainer r100, String r101, String r102) {
        this.f19646c = r100;
        this.f19647d = r101;
        this.f19648e = r102;
        this.f19644a = new d();
        this.f19645b = new e(this, r100, r101, r102);
    }
}
