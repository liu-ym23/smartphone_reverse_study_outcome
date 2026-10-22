package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import com.bytedance.android.livesdk.utils.x0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\r¢\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002Ri\u0010\u0015\u001aI\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/ktv/common/ordersong/feedback/KtvFeedbackComponentView;", "Landroid/widget/FrameLayout;", "", "", "issues", "", "setData", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "select", "issue", "", "index", "c", "Lkotlin/jvm/functions/Function3;", "getOnIssueSelectListener", "()Lkotlin/jvm/functions/Function3;", "setOnIssueSelectListener", "(Lkotlin/jvm/functions/Function3;)V", "onIssueSelectListener", "", "getSelectedSet", "()Ljava/util/List;", "selectedSet", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvFeedbackComponentView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f70129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f70130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function3<? super Boolean, ? super String, ? super Integer, Unit> f70131c;

    public KtvFeedbackComponentView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvFeedbackComponentView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final List<String> getSelectedSet() {
        ArrayList r100 = new ArrayList();
        Iterator<View> r101 = UtilityKotlinExtentionsKt.g((ViewGroup) a(R.id.feedback_component_content)).iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        View r102 = r101.next();
        if (r102.isSelected() == false) goto L4;
        CharSequence r103 = null;
        if ((r102 instanceof TextView) == true) goto L10;
        r102 = null;
    L10:
        TextView r104 = (TextView) r102;
        if (r104 == null) goto L13;
        r103 = r104.getText();
    L13:
        r100.add(String.valueOf(r103));
        goto L4
    L14:
        return r100;
    }

    public final Function3<Boolean, String, Integer, Unit> getOnIssueSelectListener() {
        return this.f70131c;
    }

    public final View a(int r100) {
        if (this.f70129a != null) goto L5;
        this.f70129a = new LinkedHashMap();
    L5:
        View r101 = this.f70129a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f70129a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setData(List<String> r110) {
        Intrinsics.checkNotNullParameter(r110, "issues");
        ((WrapLineFlowLayout) a(R.id.feedback_component_content)).removeAllViews();
        Iterator<T> r111 = r110.iterator();
        int r100 = 0;
        final int r101 = 0;
    L4:
        if (r111.hasNext() == false) goto L9;
        Object r102 = r111.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        final String r104 = (String) r102;
        WrapLineFlowLayout r105 = (WrapLineFlowLayout) a(R.id.feedback_component_content);
        KtvFeedbackTextView r106 = new KtvFeedbackTextView(getContext(), null, 6, r100);
        r106.setText(r104);
        r106.setOnClickListener(x0.a(new KtvFeedbackComponentView$setData$$inlined$forEachIndexed$lambda$1(r104, r101, this)));
        Unit r107 = Unit.INSTANCE;
        r105.addView(r106);
        r101 = r103;
        goto L4
    }

    public final void setOnIssueSelectListener(Function3<? super Boolean, ? super String, ? super Integer, Unit> r100) {
        this.f70131c = r100;
    }

    public KtvFeedbackComponentView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f70129a = new LinkedHashMap();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_view_ktv_feedback_component, this, true);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.support_multi_select, R.attr.title});
        String r104 = "";
        if (((Boolean) vm2.h.N1.getValue(null, vm2.h.f556082a[142(0x8e, float:1.99E-43)])).booleanValue() == false) goto L8;
        this.f70130b = false;
        TextView r105 = (TextView) a(R.id.feedback_component_title);
        String r106 = s1.B(R.string.ttlive_ktv_music_feedback_dialog_issue_single_select_title);
        if (r106 == null) goto L7;
        r104 = r106;
    L7:
        r105.setText(r104);
    L12:
        r103.recycle();
        int r107 = KtvOrderSongThemeManager.f70192a;
        KtvOrderSongThemeManager.d((TextView) a(R.id.feedback_component_title), 10);
        return;
    L8:
        this.f70130b = r103.getBoolean(0, true);
        TextView r108 = (TextView) a(R.id.feedback_component_title);
        String r109 = r103.getString(1);
        if (r109 == null) goto L11;
        r104 = r109;
    L11:
        r108.setText(r104);
        goto L12
    }

    public /* synthetic */ KtvFeedbackComponentView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
