package com.bytedance.android.ec.hybrid.list.holder;

import android.graphics.Rect;
import android.view.View;
import androidx.camera.video.AudioStats;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.ECHybridSettings;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ability.DataResolver;
import com.bytedance.android.ec.hybrid.list.ability.q0;
import com.bytedance.android.ec.hybrid.list.ability.t;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.entity.dto.ImageConfig;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.util.ECHybridGsonUtil;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/IHybridListViewHolder;", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseViewHolder extends RecyclerView.ViewHolder implements IHybridListViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IHybridListViewHolder.ECCardPlayState f47150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.ec.hybrid.list.ability.a f47151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECHybridListItemVO f47152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ECHybridListItemVO f47153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k.a f47154e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f47155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ECHybridListAdapter f47156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f47157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f47158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f47159j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f47160k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f47161l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f47162m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e f47163n;

    public abstract boolean C3();

    public void X3() {
    }

    public void Y3() {
    }

    public void Z3() {
    }

    public void a4() {
    }

    public void c4() {
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public void g1(int r100, int r101, double r102) {
    }

    public void h4(boolean r100) {
    }

    public void i4(Map r100) {
        Intrinsics.checkNotNullParameter("ec.switchTabFromNative", "eventName");
    }

    public void l4() {
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public void m1(int r100, double r101) {
    }

    public void m4(com.bytedance.android.ec.hybrid.list.entity.a r100) {
        Intrinsics.checkNotNullParameter(r100, ControlRule.KEY_EXTRA_DATA);
    }

    public boolean n4() {
        return false;
    }

    public void onCreate() {
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public void onHide() {
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public void onShow() {
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public void D() {
        this.f47150a = IHybridListViewHolder.ECCardPlayState.IDLE;
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public void K() {
        this.f47150a = IHybridListViewHolder.ECCardPlayState.IDLE;
        com.bytedance.android.ec.hybrid.list.ability.a r100 = this.f47151b;
        if (r100 == null) goto L8;
        q0 r101 = (q0) r100.getAbility(q0.class);
        if (r101 == null) goto L9;
        r101.vE(getAdapterPosition(), this);
        return;
    L9:
        return;
    }

    public final int T3() {
        ECHybridListItemVO r100 = this.f47152c;
        if (r100 == null) goto L5;
        String r101 = r100.f47044r;
    L7:
        if (r101 == null) goto L28;
        if (r100 == null) goto L29;
        ECHybridListAdapter r102 = this.f47156g;
        if (r102 == null) goto L30;
        Intrinsics.checkNotNullParameter(r101, "sectionId");
        Intrinsics.checkNotNullParameter(r100, "data");
        DataResolver r103 = r102.f46840a;
        if (r103 == null) goto L31;
        Intrinsics.checkNotNullParameter(r101, "sectionId");
        Intrinsics.checkNotNullParameter(r100, "data");
        ArrayList<ECHybridListItemVO> r104 = r103.f46943i;
        if (r104 == null) goto L32;
        Iterator<ECHybridListItemVO> r105 = r104.iterator();
        int r106 = -1;
    L17:
        if (r105.hasNext() == false) goto L33;
        ECHybridListItemVO r107 = r105.next();
        if (Intrinsics.areEqual(r107.f47044r, r101) == false) goto L22;
        r106 = r106 + 1;
    L22:
        if (Intrinsics.areEqual(r107, r100) == false) goto L17;
        return r106;
    L33:
        return -1;
    L32:
        return -1;
    L31:
        return -1;
    L30:
        return -1;
    L29:
        return -1;
    L28:
        return -1;
    L5:
        r101 = null;
        goto L7
    }

    public final double V3() {
        Rect r100 = new Rect();
        if (this.itemView.getLocalVisibleRect(r100) == false) goto L19;
        double r101 = this.itemView.getHeight();
        double r102 = this.itemView.getWidth();
        double r103 = r100.left;
        double r110 = r100.top;
        double r111 = r100.right;
        double r104 = r100.bottom;
        if (r103 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        return (r102 - r103) / r102;
    L8:
        if (r111 == r102) goto L11;
        return r111 / r102;
    L11:
        if (r110 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
        r104 = r101 - r110;
    L22:
        return r104 / r101;
    L15:
        if (r104 != r101) goto L22;
        return 1.0d;
    L19:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public final Pair<String, String> W3() {
        ECHybridListItemVO r100 = this.f47152c;
        String r101 = null;
        if (r100 == null) goto L13;
        ECNAMallCardExtra r102 = r100.c();
        if (r102 == null) goto L13;
        ImageConfig r103 = r102.getImageConfig();
        if (r103 == null) goto L13;
        String r104 = r103.getBizTag();
        if (r104 == null) goto L13;
        if ((!StringsKt.isBlank(r104)) == false) goto L13;
    L14:
        ECHybridListItemVO r105 = this.f47152c;
        if (r105 == null) goto L26;
        ECNAMallCardExtra r106 = r105.c();
        if (r106 == null) goto L26;
        ImageConfig r107 = r106.getImageConfig();
        if (r107 == null) goto L26;
        String r108 = r107.getSceneTag();
        if (r108 == null) goto L26;
        if ((!StringsKt.isBlank(r108)) == false) goto L26;
        r101 = r108;
    L26:
        return TuplesKt.to(r104, r101);
    L13:
        r104 = null;
        goto L14
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public void o() {
        this.f47153d = this.f47152c;
        this.f47150a = IHybridListViewHolder.ECCardPlayState.IDLE;
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public void onRelease() {
        if (ECHybridSettings.a() == false) goto L15;
        ECHybridListItemVO r100 = this.f47152c;
        if (r100 == null) goto L7;
        Object r101 = r100.T;
    L9:
        if (Intrinsics.areEqual(r101, this) == false) goto L13;
        ECHybridListItemVO r102 = this.f47152c;
        if (r102 == null) goto L13;
        r102.T = null;
    L13:
        this.f47152c = null;
        this.f47154e = null;
        return;
    L7:
        r101 = null;
        goto L9
    }

    public BaseViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f47150a = IHybridListViewHolder.ECCardPlayState.IDLE;
        this.f47160k = -1;
        this.f47161l = true;
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public void D1(Long r100) {
        this.f47150a = IHybridListViewHolder.ECCardPlayState.PLAYING;
    }

    public final void j4(IHybridListViewHolder.ECCardPlayState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f47150a = r100;
    }

    public View k4(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r100, "name");
        return null;
    }

    public void e4(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r100, "eventName");
    }

    public void f4(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r100, "eventName");
    }

    public void b4(Object r100, String r101, k.a r102) {
        Intrinsics.checkNotNullParameter(r101, "itemId");
        Intrinsics.checkNotNullParameter(r101, "itemId");
        this.f47161l = false;
        this.itemView.setTranslationX(0.0f);
    }

    public void d4(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "pageSource");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "pageSource");
    }

    public void g4(String r100, Integer r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter("", "scheme");
        Intrinsics.checkNotNullParameter("", "scheme");
    }

    public final Object U3(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        String r104 = null;
        com.bytedance.android.ec.hybrid.list.ability.a r105 = this.f47151b;     // Catch: Exception -> L29
        if (r105 == null) goto L36;
        t r106 = (t) r105.getAbility(t.class);     // Catch: Exception -> L29
        if (r106 == null) goto L37;
        String r107 = r106.TS(r100);     // Catch: Exception -> L29
        if (r107 == null) goto L38;
        JsonObject r108 = (JsonObject) ECHybridGsonUtil.a().fromJson(r107, JsonObject.class);     // Catch: Exception -> L27
        Object r109 = r107;
        if (r108 == null) goto L39;
        JsonElement r110 = r108.get(r101);     // Catch: Exception -> L27
        r109 = r107;
        if (r110 == null) goto L39;
        if (r102 == null) goto L25;
        r109 = r107;
        if (r110.isJsonObject() == false) goto L39;
        JsonObject r111 = r110.getAsJsonObject();     // Catch: Exception -> L27
        r109 = r107;
        if (r111 == null) goto L39;
        JsonElement r112 = r111.get(r102);     // Catch: Exception -> L27
        r109 = r107;
        if (r112 == null) goto L39;
        if (r103 == null) goto L24;
        r109 = r107;
        if (r112.isJsonObject() == false) goto L39;
        r109 = r112.getAsJsonObject().get(r103);     // Catch: Exception -> L27
        goto L39
    L24:
        r109 = r112.toString();     // Catch: Exception -> L27
        goto L39
    L25:
        r109 = r110.toString();     // Catch: Exception -> L27
    L39:
        return r109;
    L27:
        Exception e100 = e;
        r104 = r107;
    L31:
        EnsureManager.ensureNotReachHere(e100, "ECHybridList: getCachedApiResponse");
        return r104;
    L38:
        return null;
    L37:
        return null;
    L36:
        return null;
    L29:
        e = move-exception;
        e100 = e;
        goto L31
    }
}
