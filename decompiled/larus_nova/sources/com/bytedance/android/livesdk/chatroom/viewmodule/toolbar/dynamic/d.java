package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.business.stateservice.api.StateServiceApi;
import com.bytedance.android.livesdk.business.stateservice.api.ToolBarComponentSwitchResponse;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.ToolbarComponentData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveOpenFeatureChooseConfig;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f116078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a> f116079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f116080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f116081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f116082e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f116083f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f116084g;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f116085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f116086b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ s f116087c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ i f116088d;

        public a(d r100, s r101, s r102, i r103) {
            this.f116085a = r100;
            this.f116086b = r101;
            this.f116087c = r102;
            this.f116088d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            Logger.i(this.f116085a.f116078a, "change success from " + this.f116086b + " to " + this.f116087c);
            ALogger.i("NewToolbarLog", "change success from " + this.f116086b + " to " + this.f116087c);
            d r102 = this.f116085a;
            s r103 = this.f116086b;
            Iterator<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a> r104 = r102.f116079b.iterator();
        L4:
            if (r104.hasNext() == false) goto L8;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a r105 = r104.next();
            r105.getClass();
            Intrinsics.checkNotNullParameter(r103, "from");
            if (r105.f115961a.contains(Integer.valueOf(r103.f116191a)) == false) goto L4;
            r105.a();
            goto L4
        L8:
            i r106 = this.f116088d;
            if (r106 == null) goto L17;
            s r107 = this.f116086b;
            List<ToolbarComponentData> r108 = ((ToolBarComponentSwitchResponse) r101.data).componentData;
            if (r108 == null) goto L15;
            ToolbarComponentData r109 = (ToolbarComponentData) CollectionsKt.getOrNull(r108, 0);
            if (r109 == null) goto L15;
            Intrinsics.checkNotNullParameter(r109, "$this$toModel");
            int r110 = s.f116190q;
            s r111 = s.a.a(r109);
        L16:
            r106.b(r107, r111, true);
        L15:
            r111 = this.f116087c;
        L17:
            d r112 = this.f116085a;
            List<ToolbarComponentData> r113 = ((ToolBarComponentSwitchResponse) r101.data).componentData;
            if (r113 == null) goto L22;
            ToolbarComponentData r114 = (ToolbarComponentData) CollectionsKt.getOrNull(r113, 0);
            if (r114 == null) goto L22;
            Intrinsics.checkNotNullParameter(r114, "$this$toModel");
            int r115 = s.f116190q;
            s r116 = s.a.a(r114);
        L23:
            r r117 = r112.f116080c;
            if (r117 == null) goto L32;
            s r118 = new s();
            Intrinsics.checkNotNullParameter(r118, "from");
            Intrinsics.checkNotNullParameter(r116, RemoteMessageConst.TO);
            r117.h(r118);
            r117.c(r118);
            r117.a(r116);
            r117.f116182g.a(new r.b(r118, r116, 6, null));
            return;
        L32:
            return;
        L22:
            r116 = this.f116087c;
            goto L23
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f116089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f116090b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ s f116091c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ i f116092d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f116093e;

        public b(d r100, s r101, s r102, i r103, long r104) {
            this.f116089a = r100;
            this.f116090b = r101;
            this.f116091c = r102;
            this.f116092d = r103;
            this.f116093e = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Logger.e(this.f116089a.f116078a, "change error from " + this.f116090b + " to " + this.f116091c);
            i r102 = this.f116092d;
            if (r102 == null) goto L5;
            r102.b(this.f116090b, this.f116091c, false);
        L5:
            StringCompanionObject r103 = StringCompanionObject.INSTANCE;
            ALogger.e("NewToolbarLog", String.format("%d change %s to %s", Arrays.copyOf(new Object[]{Long.valueOf(this.f116093e), this.f116090b.f116192b, this.f116091c.f116192b}, 3)), r101);
            boolean r104 = r101 instanceof CustomApiServerException;
            String r105 = null;
            if (r104 == true) goto L8;
            Throwable r106 = null;
        L9:
            CustomApiServerException r107 = (CustomApiServerException) r106;
            if (r107 == null) goto L12;
            String r108 = r107.getPrompt();
        L14:
            if (TextUtils.isEmpty(r108) == false) goto L16;
            r105 = s1.B(R.string.ttlive_switch_toolbar_function);
        L21:
            f2.c(r105, 1);
            return;
        L16:
            if (r104 == true) goto L18;
            r101 = null;
        L18:
            CustomApiServerException r109 = (CustomApiServerException) r101;
            if (r109 == null) goto L21;
            r105 = r109.getPrompt();
            goto L21
        L12:
            r108 = null;
            goto L14
        L8:
            r106 = r101;
            goto L9
        }
    }

    public static final class c extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f116094b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f116095c;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a
        public final void a() {
            this.f116094b.invoke();
        }

        public c(Function0 r100, List r101, List r102) {
            this.f116094b = r100;
            this.f116095c = r101;
            Intrinsics.checkNotNullParameter(r102, "list");
            this.f115961a.addAll(r102);
        }
    }

    public d(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f116083f = r100;
        this.f116084g = 0;
        this.f116078a = "ReplaceDialog";
        this.f116079b = new ArrayList();
        this.f116081d = ",";
        this.f116082e = LazyKt.lazy(ButtonReplaceDialogManager$gameCommerceReplaceDialogModify$2.INSTANCE);
        Function0<Unit> r101 = new ButtonReplaceDialogManager$1(this);
        Intrinsics.checkNotNullParameter(r101, "action");
        d(CollectionsKt.arrayListOf(new Integer[]{5}), r101);
        d(CollectionsKt.arrayListOf(new Integer[]{3}), ButtonReplaceDialogManager$2.INSTANCE);
        d(CollectionsKt.arrayListOf(new Integer[]{6}), ButtonReplaceDialogManager$3.INSTANCE);
    }

    public static boolean c(s r100) {
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L9;
        int r101 = r100.f116191a;
        if (r101 != 6) goto L7;
    L8:
        return true;
    L7:
        if (r101 == 9) goto L8;
    L9:
        return false;
    }

    public static boolean a(int r100, List r101) {
        Object r102 = null;
        if (r101 == null) goto L14;
        Iterator r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();
        if (((s) r104).f116191a != r100) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L6;
        r102 = r104;
        goto L13
    L10:
        r105 = false;
    L13:
        r102 = (s) r102;
    L14:
        if (r102 == null) goto L22;
        return true;
    L22:
        return false;
    }

    public final void d(List<Integer> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "action");
        c r102 = new c(r101, r100, r100);
        Intrinsics.checkNotNullParameter(r102, "handler");
        this.f116079b.add(r102);
    }

    public final void b(long r110, s r111, s r112, i r113) {
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, this.f116083f, 0, 2);
        if (r100 == null) goto L14;
        com.bytedance.live.datacontext.n<List<s>> r101 = r100.getCurToolbarList();
        if (r101 == null) goto L14;
        List<s> r102 = r101.getValue();
        if (r102 == null) goto L14;
        List<s> r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        r104.add(String.valueOf(((s) r105.next()).f116191a));
        goto L10
    L12:
        String r106 = CollectionsKt.joinToString$default(r104, this.f116081d, null, null, 0, null, null, 62, null);
        if (r106 == null) goto L14;
    L15:
        String r107 = r106;
        Logger.i(this.f116078a, "change from " + r111 + " to " + r112);
        com.bytedance.android.livesdk.service.l.d().getClass();
        ((StateServiceApi) com.bytedance.android.live.network.c.b().e(StateServiceApi.class)).switchFunction(r107, r110, "", String.valueOf(r112.f116191a)).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r111, r112, r113), new b(this, r111, r112, r113, r110));
        return;
    L14:
        r106 = "";
        goto L15
    }
}
