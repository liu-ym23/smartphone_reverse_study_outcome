package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionEnum;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.viewholder.InputSubButtonViewBinder;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes9.dex */
public final class c1 implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<a, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputSectionType f135786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g f135787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f135788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f135789d;

    public final class a extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f135790c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f135791d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f135792e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final RecyclerView f135793f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f135794g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final MultiTypeAdapter f135795h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final GridLayoutManager f135796i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final MoreSectionProvider$MorePanelController$itemDecoration$1 f135797j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b f135798k;

        /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.android.livesdk.interactivity.comment.newinput.provider.MoreSectionProvider$MorePanelController$itemDecoration$1] */
        public a(View r100, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r101, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "panelBridges");
            Intrinsics.checkNotNullParameter(r102, "manager");
            super(r100, r101);
            this.f135798k = r102;
            this.f135790c = 4;
            this.f135791d = UtilityKotlinExtentionsKt.i(12);
            int r103 = UtilityKotlinExtentionsKt.i(72);
            int r104 = UtilityKotlinExtentionsKt.i(16);
            this.f135792e = (((com.bytedance.android.live.core.utils.s1.y() - (r104 * 2)) - (r103 * 4)) / 3) / 4;
            this.f135793f = (RecyclerView) r100.findViewById(R.id.function_list);
            this.f135794g = "";
            MultiTypeAdapter r105 = new MultiTypeAdapter();
            r105.z2(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a.class, new InputSubButtonViewBinder(new MoreSectionProvider$MorePanelController$buttonAdapter$1$1(this)));
            Unit r106 = Unit.INSTANCE;
            this.f135795h = r105;
            this.f135796i = new GridLayoutManager(r100.getContext(), 4, 1, false);
            this.f135797j = new MoreSectionProvider$MorePanelController$itemDecoration$1(this);
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
        View r100 = this.f135789d;
        if (r100 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r101 = this.f135787b;
        if (r101 != null) goto L7;
    L9:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r102 = this.f135787b;
        if (r102 == null) goto L12;
        int r103 = r102.W();
    L13:
        com.bytedance.android.live.core.utils.a1.k(r100, r103);
        goto L14
    L12:
        r103 = 0;
        goto L13
    L7:
        if (r101.W() != 0) goto L9;
        int r104 = InputPanelSectionContainer.f135430m;
        r103 = InputPanelSectionContainer.f135430m;
    L14:
        a r105 = this.f135788c;
        if (r105 == null) goto L21;
        MultiTypeAdapter r106 = r105.f135795h;
        Map<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r107 = r105.f135798k.f135476c;
        ArrayList r108 = new ArrayList(r107.size());
        Iterator r109 = ((LinkedHashMap) r107).entrySet().iterator();
    L18:
        if (r109.hasNext() == false) goto L20;
        r108.add((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) ((Map.Entry) r109.next()).getValue());
        goto L18
    L20:
        r106.f513437a = r108;
        r105.f135795h.notifyDataSetChanged();
    L21:
        a r110 = this.f135788c;
        if (r110 == null) goto L29;
        HashMap r111 = new HashMap();
        r111.put("show_icon", r110.f135794g.toString());
        r111.put("screen_type", "portrait");
        IInteractivityInjectService r112 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r112 == null) goto L26;
        r112.buildVsRoomLog(null, r111);
    L26:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_expansion_module_show", r111, new Object[]{IRoom.class, am2.x.class});
        return;
    }

    public c1() {
        this.f135786a = InputSectionType.MORE;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.f135786a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.f135788c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r100) {
        Intrinsics.checkNotNullParameter(r100, "panelBridge");
        Activity r101 = r100.getActivity();
        if (r101 != null) goto L5;
        return null;
    L5:
        this.f135787b = r100;
        View r102 = LayoutInflater.from(r101).inflate(R.layout.ttlive_fragment_more_panel, null);
        this.f135789d = r102;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b r103 = r100.z();
        if (r103 == null) goto L22;
        a r104 = new a(r102, r100, r103);
        r104.f135793f.addItemDecoration(r104.f135797j);
        r104.f135793f.setLayoutManager(r104.f135796i);
        r104.f135793f.setAdapter(r104.f135795h);
        Context r105 = r104.f135513b.getContext();
        if (r105 == null) goto L21;
        fc2.d r106 = com.bytedance.android.livesdk.interactivity.comment.newinput.b.f135391a;
        if (r106.a() == false) goto L16;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b r107 = r104.f135513b.z();
        if (r107 == null) goto L14;
        a72.a r108 = new a72.a(InputFunctionEnum.ChatInputCarrier_Interest, r105, InputSectionType.INTEREST);
        r108.a(new com.bytedance.android.livesdk.interactivity.comment.newinput.framework.h(4150));
        Unit r109 = Unit.INSTANCE;
        r107.d(r108);
    L14:
        r104.f135794g = r104.f135794g + InputFunctionEnum.ChatInputCarrier_Interest.getLogValue();
    L16:
        if (r106.b() == false) goto L21;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b r110 = r104.f135513b.z();
        if (r110 == null) goto L20;
        a72.b r111 = new a72.b(InputFunctionEnum.ChatInputCarrier_Truth, r105, InputSectionType.TRUTH);
        r111.a(new com.bytedance.android.livesdk.interactivity.comment.newinput.framework.h(4150));
        Unit r112 = Unit.INSTANCE;
        r110.d(r111);
    L20:
        r104.f135794g = r104.f135794g + '|' + InputFunctionEnum.ChatInputCarrier_Truth.getLogValue();
    L21:
        Unit r113 = Unit.INSTANCE;
        this.f135788c = r104;
    L22:
        return r102;
    }
}
