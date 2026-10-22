package com.bytedance.android.ec.adapter.impl.converter;

import com.bytedance.android.ec.adapter.api.handler.viewinterface.ECExternalViewGroupAction;
import com.bytedance.android.ec.adapter.impl.adapters.views.IconModelAdapter;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController;
import com.bytedance.android.livesdkapi.room.handler.IExternalMessageListener;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.ExternalViewGroupAction;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconModel;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconTemplate;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashSet<com.bytedance.android.ec.adapter.impl.converter.i<?, ?>> f42770a = null;

    public static final class a extends com.bytedance.android.ec.adapter.impl.converter.a<wd.d, IExternalButton> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f42771b = null;

        static {
            f42771b = new a();
        }

        public a() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final IExternalButton c(wd.d r100) {
            wd.d r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "source");
            return new com.bytedance.android.ec.adapter.impl.adapters.views.a(r101);
        }
    }

    public static final class b extends com.bytedance.android.ec.adapter.impl.converter.a<rd.a, ILiveRoomController> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f42772b = null;

        static {
            f42772b = new b();
        }

        public b() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final ILiveRoomController c(rd.a r100) {
            rd.a r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "source");
            return new com.bytedance.android.ec.adapter.impl.adapters.d(r101);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.adapter.impl.converter.c$c, reason: collision with other inner class name */
    public static final class C0779c extends com.bytedance.android.ec.adapter.impl.converter.a<wd.e, IExternalView> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0779c f42773b = null;

        static {
            f42773b = new C0779c();
        }

        public C0779c() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final IExternalView c(wd.e r100) {
            wd.e r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "source");
            return new com.bytedance.android.ec.adapter.impl.adapters.views.c(r101);
        }
    }

    public static final class d extends com.bytedance.android.ec.adapter.impl.converter.a<Function3<? super wd.f, ? super wd.e, ? super ECExternalViewGroupAction, ? extends Unit>, Function3<? super IExternalViewGroup, ? super IExternalView, ? super ExternalViewGroupAction, ? extends Unit>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f42774b = null;

        static {
            f42774b = new d();
        }

        public d() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final Function3<? super IExternalViewGroup, ? super IExternalView, ? super ExternalViewGroupAction, ? extends Unit> c(Function3<? super wd.f, ? super wd.e, ? super ECExternalViewGroupAction, ? extends Unit> r100) {
            Function3<? super wd.f, ? super wd.e, ? super ECExternalViewGroupAction, ? extends Unit> r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "source");
            return new com.bytedance.android.ec.adapter.impl.converter.e(r101);
        }
    }

    public static final class e<STATE> extends com.bytedance.android.ec.adapter.impl.converter.a<yd.b<STATE>, IExternalIconModel<STATE>> {
        public e() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final Object c(Object r100) {
            yd.b r101 = (yd.b) r100;
            Intrinsics.checkNotNullParameter(r101, "source");
            return new IconModelAdapter(r101);
        }
    }

    public static final class f extends com.bytedance.android.ec.adapter.impl.converter.a<td.a, IExternalMessageListener> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f42775b = null;

        static {
            f42775b = new f();
        }

        public f() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final IExternalMessageListener c(td.a r100) {
            td.a r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "source");
            return new com.bytedance.android.ec.adapter.impl.converter.f(r101);
        }
    }

    public static final class g extends o<rd.b, ISaasLiveRoomControllerProvider> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f42776c = null;

        static {
            f42776c = new g();
        }

        public g() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final Object c(Object r100) {
            rd.b r101 = (rd.b) r100;
            Intrinsics.checkNotNullParameter(r101, "source");
            return new com.bytedance.android.ec.adapter.impl.converter.g(r101);
        }
    }

    public static final class h extends com.bytedance.android.ec.adapter.impl.converter.a<rd.c, IStartLivePreviewController> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final h f42777b = null;

        static {
            f42777b = new h();
        }

        public h() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final IStartLivePreviewController c(rd.c r100) {
            rd.c r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "source");
            return new com.bytedance.android.ec.adapter.impl.adapters.e(r101);
        }
    }

    public static final class i extends com.bytedance.android.ec.adapter.impl.converter.a<yd.c, IExternalIconTemplate> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final i f42778b = null;

        static {
            f42778b = new i();
        }

        public i() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final IExternalIconTemplate c(yd.c r100) {
            yd.c r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "source");
            return new com.bytedance.android.ec.adapter.impl.adapters.views.b(r101);
        }
    }

    public static final class j extends com.bytedance.android.ec.adapter.impl.converter.a<vd.a, ToolbarComponentCheckInterface> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final j f42779b = null;

        static {
            f42779b = new j();
        }

        public j() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final ToolbarComponentCheckInterface c(vd.a r100) {
            vd.a r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "source");
            return new com.bytedance.android.ec.adapter.impl.converter.h(r101);
        }
    }

    public static final class k extends com.bytedance.android.ec.adapter.impl.converter.a<wd.g, IExternalWidget> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final k f42780b = null;

        static {
            f42780b = new k();
        }

        public k() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final IExternalWidget c(wd.g r100) {
            wd.g r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "source");
            return new com.bytedance.android.ec.adapter.impl.adapters.views.d(r101);
        }
    }

    static {
        f42770a = new LinkedHashSet();
    }
}
