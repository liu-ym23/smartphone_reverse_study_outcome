package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.livesdk.chatroom.utils.v2;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarBizSkin;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentSkin;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ResKeyEnum;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import j40.o4;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes8.dex */
public final class s implements ToolbarMatchInterface {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f116190q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f116191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f116192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public py.k f116193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f116194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f116195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f116196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f116197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IToolbarComponentSkin f116198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, v2> f116199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<e0> f116200j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<e0> f116201k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f0 f116202l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f116203m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f116204n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f116205o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f116206p;

    public static final class a {
        public static s a(IToolbarComponentData r100) {
            Intrinsics.checkNotNullParameter(r100, "button");
            s r101 = new s();
            r101.f116191a = r100.getId();
            String r102 = r100.getName();
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r101.f116192b = r102;
            String r104 = r100.getScheme();
            if (r104 != null) goto L8;
            r104 = "";
        L8:
            Intrinsics.checkNotNullParameter(r104, "<set-?>");
            r101.f116195e = r104;
            r101.f116193c = r100.getIcon();
            String r105 = r100.getExtraData();
            if (r105 == null) goto L12;
            r103 = r105;
        L12:
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r101.f116194d = r103;
            r101.f116202l.f116104b = false;
            r101.f116196f = r100.getGroupId();
            r101.f116197g = RangesKt.coerceAtLeast(r100.getShowType(), 1);
            return r101;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface
    public final int getSource() {
        return this.f116202l.f116104b ? 1 : 0;
    }

    public final int hashCode() {
        return (this.f116191a * 31) + this.f116192b.hashCode();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface
    public final boolean isFromMsg() {
        return this.f116202l.f116104b;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface
    public final boolean isInMore() {
        return Intrinsics.areEqual(this.f116202l.f116103a, Boolean.TRUE);
    }

    public final String toString() {
        if (this.f116202l.f116104b == false) goto L7;
        return this.f116192b + '(' + this.f116191a + "-msg)";
    L7:
        return this.f116192b + '(' + this.f116191a + ')';
    }

    public s() {
        this.f116191a = -1;
        this.f116192b = "";
        this.f116194d = "";
        this.f116195e = "";
        this.f116197g = 3;
        this.f116202l = new f0();
        this.f116206p = true;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface
    public final String compInfo() {
        return ToolbarMatchInterface.DefaultImpls.compInfo(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface
    public final String getComponentExtra() {
        return this.f116194d;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface
    public final int getComponentGroupId() {
        return this.f116196f;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface
    public final int getComponentId() {
        return this.f116191a;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface
    public final String getComponentName() {
        return this.f116192b;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface
    public final boolean isBizCheckFinish() {
        return this.f116206p;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface
    public final boolean isPreloadScene() {
        return this.f116204n;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface
    public final boolean isQuickPreload() {
        return this.f116203m;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface
    public final void changeBizCheckFinish(boolean r100) {
        this.f116206p = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(s.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L23;
        s r102 = (s) r100;
        if (this.f116191a == r102.f116191a) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(o4.f497277a.getValue(), Boolean.FALSE) == true) goto L19;
    L21:
        return true;
    L19:
        if ((!Intrinsics.areEqual(this.f116192b, r102.f116192b)) == false) goto L21;
        return false;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.NewToolbarModel");
    L8:
        r101 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface
    public final void setExtraDataAfterCheck(Object r100) {
        this.f116202l.f116105c = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface
    public final void updateExtraData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        this.f116194d = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface
    public final py.e findResource(ResKeyEnum r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        IToolbarBizSkin r102 = null;
        if (r101 == false) goto L9;
        IToolbarComponentSkin r103 = this.f116198h;
        if (r103 == null) goto L14;
        Map<String, IToolbarBizSkin> r104 = r103.getVertical();
        if (r104 == null) goto L14;
        IToolbarBizSkin r105 = r104.get(r100.getKey());
    L15:
        if (r105 != null) goto L23;
        IToolbarComponentSkin r106 = this.f116198h;
        if (r106 == null) goto L22;
        Map<String, IToolbarBizSkin> r107 = r106.getGeneral();
        if (r107 == null) goto L22;
        r102 = r107.get(r100.getKey());
    L22:
        return r102;
    L23:
        return r105;
    L14:
        r105 = null;
        goto L15
    L9:
        IToolbarComponentSkin r108 = this.f116198h;
        if (r108 == null) goto L14;
        Map<String, IToolbarBizSkin> r109 = r108.getLandscape();
        if (r109 == null) goto L14;
        r105 = r109.get(r100.getKey());
        goto L15
    }
}
