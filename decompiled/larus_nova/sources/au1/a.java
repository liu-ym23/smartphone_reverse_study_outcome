package au1;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;

/* JADX INFO: loaded from: classes8.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16298a;

    /* JADX INFO: renamed from: au1.a$a, reason: collision with other inner class name */
    public static final class C0232a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0232a f16299b = null;

        static {
            f16299b = new C0232a();
        }

        public C0232a() {
            super("onHide");
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f16300b = null;

        static {
            f16300b = new b();
        }

        public b() {
            super(WidgetCostModule.TYPE_ON_LOAD);
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f16301b = null;

        static {
            f16301b = new c();
        }

        public c() {
            super(SendEventContainerMethodParamModel.EventKinds.onShow);
        }
    }

    public a(String r100) {
        this.f16298a = r100;
    }
}
