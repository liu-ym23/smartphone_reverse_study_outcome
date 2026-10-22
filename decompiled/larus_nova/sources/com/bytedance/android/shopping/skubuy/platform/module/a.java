package com.bytedance.android.shopping.skubuy.platform.module;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.WidgetName;
import kotlin.jvm.internal.Intrinsics;
import n43.c;
import s33.b;
import w33.g;

/* JADX INFO: loaded from: classes13.dex */
public final class a<STATE extends g> extends b<STATE, yh3.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f183167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f183168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C2723a f183169d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.skubuy.platform.module.a$a, reason: collision with other inner class name */
    public static final class C2723a implements SlcKeyboardMonitor.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f183170a;

        @Override // com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor.c
        public final void a() {
            c r100 = this.f183170a.f540457a.f507251e.f527570g.get(WidgetName.BODY.getValue());
            if (r100 == null) goto L8;
            View r101 = r100.getView();
            if (r101 == null) goto L9;
            r101.setPadding(0, 0, 0, 0);
            return;
        L9:
            return;
        }

        public C2723a(a r100) {
            this.f183170a = r100;
        }

        @Override // com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor.c
        public final void b(int r100) {
            c r101 = this.f183170a.f540457a.f507251e.f527570g.get(WidgetName.FOOTER.getValue());
            if (r101 == null) goto L7;
            View r102 = r101.getView();
            if (r102 == null) goto L7;
            int r103 = r102.getHeight();
        L8:
            c r104 = this.f183170a.f540457a.f507251e.f527570g.get(WidgetName.BODY.getValue());
            if (r104 == null) goto L14;
            View r105 = r104.getView();
            if (r105 == null) goto L15;
            r105.setPadding(0, 0, 0, r100 - r103);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r103 = 0;
            goto L8
        }
    }

    @Override // s33.b
    public final void A() {
        C2723a r100 = this.f183169d;
        if (r100 == null) goto L6;
        this.f540457a.f507250d.r().a(r100);
        this.f183169d = null;
        return;
    }

    @Override // s33.b
    public final void x() {
        Window r100 = this.f540457a.f507252f.f7();     // Catch: Exception -> L6
        if (r100 == null) goto L11;
        r100.setSoftInputMode(48);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // s33.b
    public final void y() {
        Window r100 = this.f540457a.f507252f.f7();
        if (r100 == null) goto L7;
        WindowManager.LayoutParams r101 = r100.getAttributes();
        if (r101 == null) goto L7;
        int r102 = r101.softInputMode;
    L8:
        this.f183168c = r102;
        if (r100 == null) goto L11;
        r100.setSoftInputMode(48);
    L11:
        C2723a r103 = new C2723a(this);
        this.f183169d = r103;
        this.f540457a.f507250d.r().c(r103);
        return;
    L7:
        r102 = 0;
        goto L8
    }

    @Override // s33.b
    public final void z() {
        Window r100 = this.f540457a.f507252f.f7();     // Catch: Exception -> L6
        if (r100 == null) goto L11;
        r100.setSoftInputMode(this.f183168c);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // s33.b
    public final String j() {
        return this.f183167b;
    }

    public a(l33.b<STATE, yh3.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f183167b = "KeyboardControlModule";
    }
}
