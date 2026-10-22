package com.bytedance.android.debug;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/debug/DebugGiftPreviewDebugWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DebugGiftPreviewDebugWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RadioGroup f42575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EditText f42576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f42577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f42578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView f42579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DebugAssetsListAdapter f42580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HSImageView f42581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f42582h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f42583i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public l f42584j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Context f42585k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f42586l;

    public static final class a implements IAssetsManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DebugGiftPreviewDebugWidget f42587a;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void a() {
        }

        public a(DebugGiftPreviewDebugWidget r100) {
            this.f42587a = r100;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void b(List<? extends com.bytedance.android.live.core.resources.e> r100) {
            Intrinsics.checkNotNullParameter(r100, "assetsModels");
            DebugAssetsListAdapter r101 = this.f42587a.f42580f;
            if (r101 == null) goto L20;
            Intrinsics.checkNotNullParameter(r100, "assetsList");
            if (r100.isEmpty() == true) goto L21;
            ((ArrayList) r101.f42547a).clear();
            ((ArrayList) r101.f42548b).clear();
            Iterator<T> r102 = r100.iterator();
        L9:
            if (r102.hasNext() == false) goto L13;
            com.bytedance.android.live.core.resources.e r103 = (com.bytedance.android.live.core.resources.e) r102.next();
            if (r103.getResourceType() != 4) goto L9;
            ((ArrayList) r101.f42547a).add(r103);
            ((ArrayList) r101.f42548b).add(r103);
            goto L9
        L13:
            r101.notifyDataSetChanged();
            return;
        L21:
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DebugGiftPreviewDebugWidget f42588a;

        public b(DebugGiftPreviewDebugWidget r100) {
            this.f42588a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            EditText r101 = this.f42588a.f42576b;
            if (r101 == null) goto L6;
            r101.setText("");
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DebugGiftPreviewDebugWidget f42589a;

        public c(DebugGiftPreviewDebugWidget r100) {
            this.f42589a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            EditText r101 = this.f42589a.f42576b;
            Object r102 = null;
            if (r101 == null) goto L7;
            Editable r103 = r101.getText();
            if (r103 == null) goto L7;
            String r104 = r103.toString();
        L9:
            if (r104 != null) goto L11;
        L14:
            boolean r105 = true;
        L16:
            if (r105 == false) goto L65;
            ToastUtil.b("请填写正确的资源ID", 0);
            return;
        L65:
            com.bytedance.android.live.core.resources.e r106 = com.bytedance.android.debug.e.a().G1(CastLongProtector.parseLong(r104));     // Catch: Exception -> L21
        L32:
            if (r106 != null) goto L35;
            ToastUtil.b("请填写正确的资源ID", 0);
            return;
        L35:
            DebugGiftPreviewDebugWidget r107 = this.f42589a;
            EditText r108 = r107.f42576b;
            if (r108 == null) goto L48;
            Context r109 = r107.f42585k;
            if (r109 != null) goto L40;
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        L40:
            if (r109 == null) goto L48;
            Object r110 = r109.getSystemService("input_method");
            if ((r110 instanceof InputMethodManager) == false) goto L45;
            r102 = r110;
        L45:
            InputMethodManager r111 = (InputMethodManager) r102;
            if (r111 == null) goto L48;
            r111.hideSoftInputFromWindow(r108.getWindowToken(), 0);
        L48:
            RadioGroup r112 = this.f42589a.f42575a;
            if (r112 != null) goto L51;
        L53:
            RadioGroup r113 = this.f42589a.f42575a;
            if (r113 != null) goto L56;
        L58:
            RadioGroup r114 = this.f42589a.f42575a;
            if (r114 != null) goto L61;
        L63:
            ToastUtil.b("请选择编码格式", 0);
            return;
        L61:
            if (r114.getCheckedRadioButtonId() != R.id.h265_super_btn) goto L63;
            ia0.a r115 = com.bytedance.android.debug.e.a();
            DebugGiftPreviewDebugWidget r116 = this.f42589a;
            r116.getClass();
            r115.Ne(r106, new com.bytedance.android.debug.f(r116), 30);
            return;
        L56:
            if (r113.getCheckedRadioButtonId() != R.id.h265_btn) goto L58;
            ia0.a r117 = com.bytedance.android.debug.e.a();
            DebugGiftPreviewDebugWidget r118 = this.f42589a;
            r118.getClass();
            r117.Ne(r106, new com.bytedance.android.debug.f(r118), 20);
            return;
        L51:
            if (r112.getCheckedRadioButtonId() != R.id.h264_btn) goto L53;
            ia0.a r119 = com.bytedance.android.debug.e.a();
            DebugGiftPreviewDebugWidget r120 = this.f42589a;
            r120.getClass();
            r119.Ne(r106, new com.bytedance.android.debug.f(r120), 10);
            return;
        L21:
            DebugAssetsListAdapter r121 = this.f42589a.f42580f;
            if (r121 != null) goto L24;
        L31:
            r106 = null;
            goto L32
        L24:
            if (r121.getItemCount() != 1) goto L31;
            DebugAssetsListAdapter r122 = this.f42589a.f42580f;
            if (r122 == null) goto L31;
            if (((ArrayList) r122.f42548b).size() <= 0) goto L31;
            r106 = (com.bytedance.android.live.core.resources.e) ListProtector.get(r122.f42548b, 0);
            goto L32
        L11:
            if (r104.length() == 0) goto L14;
            r105 = false;
        L7:
            r104 = null;
            goto L9
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DebugGiftPreviewDebugWidget f42590a;

        public d(DebugGiftPreviewDebugWidget r100) {
            this.f42590a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f42590a.containerView.setVisibility(8);
            ay1.b.I.setValue(null, ay1.b.f16675a[40], Boolean.FALSE);
        }
    }

    public static final class e implements DebugAssetsListAdapter.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DebugGiftPreviewDebugWidget f42591a;

        public e(DebugGiftPreviewDebugWidget r100) {
            this.f42591a = r100;
        }

        @Override // com.bytedance.android.debug.DebugAssetsListAdapter.a
        public final void a(com.bytedance.android.live.core.resources.e r100) {
            Intrinsics.checkNotNullParameter(r100, "assetsModel");
            EditText r101 = this.f42591a.f42576b;
            if (r101 == null) goto L6;
            r101.setText(String.valueOf(r100.getId()));
            return;
        }
    }

    public static final class f implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DebugGiftPreviewDebugWidget f42592a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public f(DebugGiftPreviewDebugWidget r100) {
            this.f42592a = r100;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            DebugAssetsListAdapter r104 = this.f42592a.f42580f;
            if (r104 == null) goto L6;
            new DebugAssetsListAdapter.b(r104).filter(String.valueOf(r100));
            return;
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_gift_preview_debug_layout;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
    }

    public DebugGiftPreviewDebugWidget() {
        this.f42586l = new a(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.containerView.setVisibility(0);
        this.f42585k = getContext();
        this.f42575a = (RadioGroup) findViewById(R.id.radio_group);
        this.f42583i = (FrameLayout) findViewById(R.id.debug_effect_video_view);
        RadioButton r101 = (RadioButton) findViewById(R.id.h264_btn);
        RadioButton r102 = (RadioButton) findViewById(R.id.h265_btn);
        RadioButton r103 = (RadioButton) findViewById(R.id.h265_super_btn);
        this.f42576b = (EditText) findViewById(R.id.asset_edit);
        this.f42577c = (TextView) findViewById(R.id.gift_preview_btn);
        this.f42578d = (TextView) findViewById(R.id.debug_clear_btn);
        this.f42579e = (RecyclerView) findViewById(R.id.assets_list);
        this.f42581g = (HSImageView) findViewById(R.id.guideline_mask);
        this.f42582h = (LinearLayout) findViewById(R.id.debug_setting_panel);
        this.f42580f = new DebugAssetsListAdapter();
        LinearLayoutManager r104 = new LinearLayoutManager(getContext());
        RecyclerView r105 = this.f42579e;
        if (r105 == null) goto L5;
        r105.setLayoutManager(r104);
    L5:
        RecyclerView r106 = this.f42579e;
        if (r106 == null) goto L8;
        r106.setAdapter(this.f42580f);
    L8:
        DividerItemDecoration r107 = new DividerItemDecoration(getContext(), 1);
        Context r108 = this.f42585k;
        if (r108 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
    L11:
        r107.setDrawable(new ColorDrawable(ContextCompat.getColor(r108, R.color.white)));
        RecyclerView r109 = this.f42579e;
        if (r109 == null) goto L14;
        r109.addItemDecoration(r107);
    L14:
        TextView r110 = this.f42578d;
        if (r110 == null) goto L17;
        r110.setOnClickListener(new b(this));
    L17:
        EditText r111 = this.f42576b;
        if (r111 == null) goto L20;
        Intrinsics.checkNotNullParameter(r111, "editText");
        SpannableString r112 = new SpannableString("请输入资源id");
        r112.setSpan(new AbsoluteSizeSpan(10, true), 0, r112.length(), 33);
        r111.setHint(new SpannableString(r112));
    L20:
        TextView r113 = this.f42577c;
        if (r113 == null) goto L23;
        r113.setOnClickListener(new c(this));
    L23:
        ((TextView) findViewById(R.id.close_gift_preview)).setOnClickListener(new d(this));
        DebugAssetsListAdapter r114 = this.f42580f;
        if (r114 == null) goto L26;
        e r115 = new e(this);
        Intrinsics.checkNotNullParameter(r115, "listener");
        r114.f42549c = r115;
    L26:
        EditText r116 = this.f42576b;
        if (r116 == null) goto L30;
        r116.addTextChangedListener(new f(this));
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        boolean r101 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).registerGiftPreviewDebugWidgetInstance(this);
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.f126532J.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.f126533a[34])).booleanValue() == true) goto L5;
        com.bytedance.android.debug.e.a().T2(3, "debug_onLoad");
        com.bytedance.android.debug.e.a().T(this.f42586l);
    L5:
        this.f42584j = new l();
    }

    public final void wq(final String r100, final Long r110, final String r111) {
        ALogger.i("GiftPreviewAutoTest", "autoPlayMP4 parameter received assetUrl " + r100 + " guidelineRes " + r111);
        UtilityKotlinExtentionsKt.s(0, false, false, new DebugGiftPreviewDebugWidget$autoPlayMP4$1(this, r100, r110, r111), 7);
    }
}
