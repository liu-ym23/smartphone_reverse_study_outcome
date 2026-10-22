package com.bytedance.android.live.ktv.common.ordersong.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R?\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R?\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/ktv/common/ordersong/view/SongTextSwitcher;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/widget/LinearLayout;", "getBubbleContentView", "", "", "datas", "", "setSwitcherTextList", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "text", "e", "Lkotlin/jvm/functions/Function1;", "getOnTextSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnTextSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "onTextSelectedListener", "", "isDismiss", "f", "getOnWindowStateListener", "setOnWindowStateListener", "onWindowStateListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SongTextSwitcher extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f70234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f70235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f70236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c90.a f70237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super String, Unit> f70238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f70239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f70240g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f70241h;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f70242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SongTextSwitcher f70243b;

        public a(String r100, SongTextSwitcher r101) {
            this.f70242a = r100;
            this.f70243b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f70243b.y(this.f70242a);
        }
    }

    private final LinearLayout getBubbleContentView() {
        LinearLayout r100 = new LinearLayout(getContext());
        r100.setOrientation(1);
        KtvOrderSongThemeManager.b(r100, 1);
        r100.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r100.setGravity(17);
        List<String> r101 = this.f70234a;
        if (r101 == null) goto L14;
        Intrinsics.checkNotNull(r101);
        int r102 = r101.size();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L14;
        List<String> r104 = this.f70234a;
        Intrinsics.checkNotNull(r104);
        String r105 = (String) ListProtector.get(r104, r103);
        TextView r106 = new TextView(r100.getContext());
        r106.setGravity(19);
        r106.setLayoutParams(new LinearLayout.LayoutParams(-2, s1.f(37.0f)));
        r106.setText(r105);
        r106.setMinWidth(s1.f(107.0f));
        r106.setLines(1);
        r106.setTextSize(this.f70236c);
        r106.setTextColor(this.f70235b);
        if (Intrinsics.areEqual(getText(), r105) == false) goto L9;
        Drawable r107 = s1.m(R.drawable.ttlive_icon_song_type_selected);
        r107.setBounds(0, 0, s1.f(13.0f), s1.f(12.0f));
        r106.setCompoundDrawables(null, null, r107, null);
        r106.setCompoundDrawablePadding(s1.f(8.0f));
    L10:
        r106.setOnClickListener(new a(r105, this));
        r106.setPadding(s1.f(12.0f), 0, s1.f(12.0f), 0);
        r100.addView(r106);
        List<String> r108 = this.f70234a;
        Intrinsics.checkNotNull(r108);
        if (r103 >= (r108.size() - 1)) goto L13;
        View r109 = new View(r100.getContext());
        r109.setLayoutParams(new LinearLayout.LayoutParams(-1, s1.f(0.5f)));
        r109.setBackgroundColor(ColorProtector.parseColor("#1f161823"));
        r100.addView(r109);
    L13:
        r103 = r103 + 1;
        goto L5
    L9:
        r106.setCompoundDrawables(null, null, null, null);
    L14:
        a1.l(r100, s1.f(10.0f));
        return r100;
    }

    public final Function1<String, Unit> getOnTextSelectedListener() {
        return this.f70238e;
    }

    public final Function1<Boolean, Unit> getOnWindowStateListener() {
        return this.f70239f;
    }

    public static final void x(SongTextSwitcher r100) {
        if (r100.f70240g == true) goto L19;
        Activity r101 = ContextUtil.contextToActivity(r100.getContext());
        if (r101 == null) goto L20;
        c90.a.C0416a r102 = new c90.a.C0416a(r101);
        LinearLayout r103 = r100.getBubbleContentView();
        Intrinsics.checkNotNullParameter(r103, "view");
        r102.f22798g = r103;
        r102.f22797f = false;
        r102.f22809r = true;
        r102.f22796e = -1;
        r102.f22799h = s1.f(112.0f) + ((int) UIUtils.dip2Px(r102.f22815x, 14.0f));
        r102.f22800i = s1.f(89.0f) + ((int) UIUtils.dip2Px(r102.f22815x, 14.0f));
        r102.f22792a = -1;
        r102.f22793b = false;
        r102.f22810s = true;
        b r104 = new b(r100);
        Intrinsics.checkNotNullParameter(r104, "listener");
        r102.f22805n = r104;
        c r105 = new c(r100);
        Intrinsics.checkNotNullParameter(r105, "listener");
        r102.f22806o = r105;
        c90.a r106 = new c90.a(r102);
        Lazy r107 = KtvSettingHelper.f70678z;
        if (((Boolean) r107.getValue()).booleanValue() == false) goto L11;
        r106.f156287b = 10;
    L11:
        r106.setTouchable(true);
        r106.setFocusable(true);
        r106.setOutsideTouchable(true);
        Unit r108 = Unit.INSTANCE;
        r100.f70237d = r106;
        r106.i(r100, 80, true);
        Function1<? super Boolean, Unit> r109 = r100.f70239f;
        if (r109 == null) goto L14;
        Unit r110 = r109.invoke(Boolean.FALSE);
    L14:
        r100.f70240g = true;
        if (((Boolean) r107.getValue()).booleanValue() == false) goto L18;
        r100.postDelayed(new com.bytedance.android.live.ktv.common.ordersong.view.a(r100), 2000);
        return;
    L18:
        return;
    L20:
        return;
    }

    public final void setOnTextSelectedListener(Function1<? super String, Unit> r100) {
        this.f70238e = r100;
    }

    public final void setOnWindowStateListener(Function1<? super Boolean, Unit> r100) {
        this.f70239f = r100;
    }

    public final void setSwitcherTextList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "datas");
        this.f70234a = r100;
    }

    public final void y(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        setText(r100);
        Function1<? super String, Unit> r101 = this.f70238e;
        if (r101 == null) goto L5;
        Unit r102 = r101.invoke(r100);
    L5:
        c90.a r103 = this.f70237d;
        if (r103 == null) goto L8;
        PopupWindowLancet.handleDismissBeforeOrigin(r103);
        r103.dismiss();
    L8:
        this.f70240g = false;
    }

    public SongTextSwitcher(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        int r102 = KtvOrderSongThemeManager.a(10);
        this.f70235b = r102;
        float r103 = s1.e(4.5f);
        this.f70236c = r103;
        setOnClickListener(x0.a(new AnonymousClass1(this)));
        setGravity(17);
        setTextColor(r102);
        setTextSize(r103);
        Drawable r104 = s1.m(R.drawable.ttlive_icon_song_type_change);
        r104.setBounds(0, 0, s1.f(12.0f), s1.f(11.0f));
        setCompoundDrawables(null, null, r104, null);
        setCompoundDrawablePadding(s1.f(6.0f));
    }
}
