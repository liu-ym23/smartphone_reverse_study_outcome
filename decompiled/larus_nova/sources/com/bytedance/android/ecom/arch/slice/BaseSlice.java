package com.bytedance.android.ecom.arch.slice;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.style.SlcStyle;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMetaMappedMap;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0001YB£\u0001\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107\u0012\u0016\b\u0002\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000207\u0018\u00010\u0003\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u0012\u0016\b\u0002\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010H\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M¢\u0006\u0004\bV\u0010WJ(\u0010\n\u001a\u00020\t2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003H\u0016J.\u0010\u0013\u001a\u00020\t2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\b\b\u0001\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\u0010\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0014J\u0010\u0010\u001c\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001d\u001a\u00020\u0000H\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b*\u0010&\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u001e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u001c\u0010/\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u00010\u00048\u0016X\u0097\u0004¢\u0006\f\n\u0004\b3\u00100\u001a\u0004\b4\u00102R\u001c\u00105\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u00100\u001a\u0004\b6\u00102R\u001c\u00108\u001a\u0004\u0018\u0001078\u0016X\u0097\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R(\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000207\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001c\u0010A\u001a\u0004\u0018\u00010@8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR(\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\f\n\u0004\bE\u0010=\u001a\u0004\bF\u0010?R(\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010=\u001a\u0004\b\f\u0010?R\u001c\u0010I\u001a\u0004\u0018\u00010H8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u001c\u0010N\u001a\u0004\u0018\u00010M8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u00102R\u0014\u0010U\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u00102¨\u0006Z"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/BaseSlice;", "Lcom/bytedance/android/ecom/arch/slice/adapter/a;", "Lcom/bytedance/android/ecom/arch/slice/g;", "", "", "", "patchData", "", "mode", "", "onUpdateData", "key", "getConfig", "Lcom/bytedance/android/ecom/arch/slice/adapter/b;", "newItem", "", "areItemsTheSame", "getData", "fullSpan", "updateData", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/android/ecom/arch/slice/slices/a;", "getSlcViewHolder", "vh", "setSlcViewHolder", "Lcom/bytedance/android/ecom/arch/slice/h;", "getSliceRebindTarget", PickerReporterConstants.KEY.TARGET, "setSliceRebindTarget", "clone", "Lcom/bytedance/android/ecom/arch/slice/p;", "parent", "Lcom/bytedance/android/ecom/arch/slice/p;", "getParent", "()Lcom/bytedance/android/ecom/arch/slice/p;", "setParent", "(Lcom/bytedance/android/ecom/arch/slice/p;)V", "isHeader", "Z", "()Z", "setHeader", "(Z)V", "isFooter", "setFooter", "viewHolderWr", "Ljava/lang/ref/WeakReference;", "rebindTargetWr", "_sliceType", "Ljava/lang/String;", "get_sliceType", "()Ljava/lang/String;", "sliceId", "getSliceId", "_viewType", "get_viewType", "Lcom/bytedance/android/ecom/arch/slice/style/SlcStyle;", "style", "Lcom/bytedance/android/ecom/arch/slice/style/SlcStyle;", "getStyle", "()Lcom/bytedance/android/ecom/arch/slice/style/SlcStyle;", "specialStyle", "Ljava/util/Map;", "getSpecialStyle", "()Ljava/util/Map;", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "showAction", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "getShowAction", "()Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "trackMeta", "getTrackMeta", "config", "Lcom/bytedance/android/ecom/arch/slice/r;", "verify", "Lcom/bytedance/android/ecom/arch/slice/r;", "getVerify", "()Lcom/bytedance/android/ecom/arch/slice/r;", "Lcom/bytedance/android/ecom/arch/slice/b;", "exposure", "Lcom/bytedance/android/ecom/arch/slice/b;", "getExposure", "()Lcom/bytedance/android/ecom/arch/slice/b;", "getSliceType", "sliceType", "getViewType", "viewType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ecom/arch/slice/style/SlcStyle;Ljava/util/Map;Lcom/bytedance/android/ecom/arch/slice/action/IAction;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/android/ecom/arch/slice/r;Lcom/bytedance/android/ecom/arch/slice/b;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseSlice extends com.bytedance.android.ecom.arch.slice.adapter.a implements g {
    public static final a Companion = null;
    public static final String KEY_SLICE_ID = "slice_id";

    @SerializedName("slice_type")
    private final String _sliceType;

    @SerializedName(BytedCertConstant.IntentKey.VIEW_TYPE)
    private final String _viewType;

    @SerializedName("config")
    private final Map<String, Object> config;

    @SerializedName("exposure")
    private final b exposure;
    private boolean isFooter;
    private boolean isHeader;
    private p parent;
    private WeakReference<h> rebindTargetWr;

    @SerializedName("show_action")
    private final IAction showAction;

    @SerializedName(KEY_SLICE_ID)
    private final String sliceId;

    @SerializedName("special_style")
    private final Map<String, SlcStyle> specialStyle;

    @SerializedName("style")
    private final SlcStyle style;

    @SerializedName(PageMetaMappedMap.TRACK_META_KEY)
    private final Map<String, String> trackMeta;

    @SerializedName("verify")
    private final r verify;
    private WeakReference<com.bytedance.android.ecom.arch.slice.slices.a> viewHolderWr;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BaseSlice() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    @Override // com.bytedance.android.ecom.arch.slice.g
    public Map<String, Object> getData() {
        return null;
    }

    public void onUpdateData(Map<String, ? extends Object> r100, @SliceUpdateMode int r101) {
        Intrinsics.checkNotNullParameter(r100, "patchData");
    }

    @Override // com.bytedance.android.ecom.arch.slice.g
    public String getSliceType() {
        String r100 = this._sliceType;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.g
    public String getViewType() {
        String r100 = this._viewType;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.adapter.a, com.bytedance.android.ecom.arch.slice.g
    public BaseSlice clone() {
        com.bytedance.android.ecom.arch.slice.adapter.a r100 = super.clone();
        if (r100 == null) goto L7;
        return (BaseSlice) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ecom.arch.slice.BaseSlice");
    }

    public final Map<String, Object> getConfig() {
        return this.config;
    }

    @Override // com.bytedance.android.ecom.arch.slice.g
    public b getExposure() {
        return this.exposure;
    }

    @Override // com.bytedance.android.ecom.arch.slice.g
    public p getParent() {
        return this.parent;
    }

    @Override // com.bytedance.android.ecom.arch.slice.g
    public IAction getShowAction() {
        return this.showAction;
    }

    public final WeakReference<com.bytedance.android.ecom.arch.slice.slices.a> getSlcViewHolder() {
        return this.viewHolderWr;
    }

    @Override // com.bytedance.android.ecom.arch.slice.g
    public String getSliceId() {
        return this.sliceId;
    }

    public final WeakReference<h> getSliceRebindTarget() {
        return this.rebindTargetWr;
    }

    @Override // com.bytedance.android.ecom.arch.slice.g
    public Map<String, SlcStyle> getSpecialStyle() {
        return this.specialStyle;
    }

    @Override // com.bytedance.android.ecom.arch.slice.g
    public SlcStyle getStyle() {
        return this.style;
    }

    @Override // com.bytedance.android.ecom.arch.slice.g
    public Map<String, String> getTrackMeta() {
        return this.trackMeta;
    }

    public r getVerify() {
        return this.verify;
    }

    public final String get_sliceType() {
        return this._sliceType;
    }

    public final String get_viewType() {
        return this._viewType;
    }

    @Override // com.bytedance.android.ecom.arch.slice.g
    public boolean isFooter() {
        return this.isFooter;
    }

    @Override // com.bytedance.android.ecom.arch.slice.g
    public boolean isHeader() {
        return this.isHeader;
    }

    @Override // com.bytedance.android.ecom.arch.slice.adapter.a, com.bytedance.android.ecom.arch.slice.g
    public /* bridge */ /* synthetic */ com.bytedance.android.ecom.arch.slice.adapter.a clone() {
        return clone();
    }

    @Override // com.bytedance.android.ecom.arch.slice.adapter.a, com.bytedance.android.ecom.arch.slice.g
    public /* bridge */ /* synthetic */ g clone() {
        return clone();
    }

    @Override // com.bytedance.android.ecom.arch.slice.adapter.a, com.bytedance.android.ecom.arch.slice.g
    public /* bridge */ /* synthetic */ Object clone() {
        return clone();
    }

    @Override // com.bytedance.android.ecom.arch.slice.adapter.a, com.bytedance.android.ecom.arch.slice.adapter.b
    public boolean areItemsTheSame(com.bytedance.android.ecom.arch.slice.adapter.b r100) {
        Intrinsics.checkNotNullParameter(r100, "newItem");
        if (getItemKey() != r100.getItemKey()) goto L5;
        return true;
    L5:
        if ((r100 instanceof g) == false) goto L25;
        String r101 = getSliceId();
        if (r101 != null) goto L9;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == true) goto L25;
        g r103 = (g) r100;
        String r104 = r103.getSliceId();
        if (r104 != null) goto L17;
    L20:
        boolean r105 = true;
    L21:
        if (r105 == true) goto L25;
        if (Intrinsics.areEqual(getSliceId(), r103.getSliceId()) == false) goto L25;
        return true;
    L17:
        if (r104.length() == 0) goto L20;
        r105 = false;
        goto L21
    L9:
        if (r101.length() == 0) goto L12;
        r102 = false;
    L25:
        return false;
    }

    @Override // com.bytedance.android.ecom.arch.slice.g
    public final Object getConfig(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Map<String, Object> r101 = this.config;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.g
    public void setFooter(boolean r100) {
        this.isFooter = r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.g
    public void setHeader(boolean r100) {
        this.isHeader = r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.g
    public void setParent(p r100) {
        this.parent = r100;
    }

    public final void setSlcViewHolder(com.bytedance.android.ecom.arch.slice.slices.a r100) {
        if (r100 != null) goto L4;
        WeakReference<com.bytedance.android.ecom.arch.slice.slices.a> r101 = null;
    L5:
        this.viewHolderWr = r101;
        return;
    L4:
        r101 = new WeakReference(r100);
        goto L5
    }

    @Override // com.bytedance.android.ecom.arch.slice.g
    public final void setSliceRebindTarget(h r100) {
        if (r100 != null) goto L4;
        WeakReference<h> r101 = null;
    L5:
        this.rebindTargetWr = r101;
        return;
    L4:
        r101 = new WeakReference(r100);
        goto L5
    }

    @Override // com.bytedance.android.ecom.arch.slice.g
    public final void updateData(final Map<String, ? extends Object> r100, @SliceUpdateMode final int r101, final boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "patchData");
        com.bytedance.android.ecom.arch.slice.render.util.h.a(new AnonymousClass1(this, r100, r101, r102));
    }

    public BaseSlice(String r100, String r101, String r102, SlcStyle r103, Map<String, SlcStyle> r104, IAction r110, Map<String, String> r111, Map<String, ? extends Object> r112, r r113, b r114) {
        super(0, 1, null);
        this._sliceType = r100;
        this.sliceId = r101;
        this._viewType = r102;
        this.style = r103;
        this.specialStyle = r104;
        this.showAction = r110;
        this.trackMeta = r111;
        this.config = r112;
        this.verify = r113;
        this.exposure = r114;
    }

    public /* synthetic */ BaseSlice(String r110, String r111, String r112, SlcStyle r113, Map r114, IAction r115, Map r116, Map r117, r r210, b r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = "";
    L6:
        b r101 = null;
        if ((r212 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        SlcStyle r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Map r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        IAction r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        Map r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Map r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        r r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r101 = r211;
    L42:
        this(r100, r102, r103, r104, r105, r106, r107, r108, r118, r101);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
