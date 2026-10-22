package com.bytedance.android.live.livepkaudience.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.d2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import com.bytedance.android.livesdk.rank.model.g;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eB\u001b\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\r\u0010\u0011B#\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\r\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/view/PkWithAudienceFeedbackView;", "Landroid/widget/ScrollView;", "", "content", "", "setTagTitleText", "getSelectedTag", "getSelectedSubTag", "Lcom/bytedance/android/live/livepkaudience/view/PkWithAudienceFeedbackView$a;", "listener", "setListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkWithAudienceFeedbackView extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f82311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f82312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f82313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f82314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f82315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f82316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f82317g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f82318h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f82319i;

    public interface a {
        void a();
    }

    public static final class b extends d2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkWithAudienceFeedbackView f82320a;

        public b(PkWithAudienceFeedbackView r100) {
            this.f82320a = r100;
        }

        @Override // com.bytedance.android.live.core.utils.d2, android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            if (r100 == null) goto L7;
            String r104 = r100.toString();
            if (r104 == null) goto L8;
            this.f82320a.f82315e = r104;
            return;
        L8:
            return;
        }
    }

    public static final class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f82321a = null;

        static {
            f82321a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            int r102 = r101.getAction();
            if (r102 == 0) goto L11;
            if (r102 != 1) goto L6;
        L10:
            r100.getParent().requestDisallowInterceptTouchEvent(false);
        L12:
            return false;
        L6:
            if (r102 == 2) goto L11;
            if (r102 == 3) goto L10;
        L11:
            r100.getParent().requestDisallowInterceptTouchEvent(true);
            goto L12
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkWithAudienceFeedbackView f82322a;

        public d(PkWithAudienceFeedbackView r100) {
            this.f82322a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (r100 == null) goto L22;
            TextView r101 = (TextView) r100;
            if (r101.getTag() == null) goto L15;
            Object r102 = r101.getTag();
            Boolean r103 = Boolean.FALSE;
            if (Intrinsics.areEqual(r102, r103) == true) goto L15;
            r101.setBackgroundResource(R.drawable.ttlive_bg_tag_pk_audience_feedback_unselect);
            r101.setTextColor(s1.h(R.color.ttlive_pk_audience_feedback_tag_unselected));
            r101.setTag(r103);
            CharSequence r104 = r101.getText();
            if (r104 == null) goto L23;
            String r105 = r104.toString();
            if (r105 != null) goto L13;
            return;
        L13:
            if (((ArrayList) this.f82322a.f82314d).contains(r105) == false) goto L25;
            ((ArrayList) this.f82322a.f82314d).remove(r105);
            return;
        L25:
            return;
        L23:
            return;
        L15:
            r101.setBackgroundResource(R.drawable.ttlive_bg_tag_pk_audience_feedback_select);
            r101.setTextColor(s1.h(R.color.ttlive_pk_audience_feedback_tag_selected));
            r101.setTag(Boolean.TRUE);
            CharSequence r106 = r101.getText();
            if (r106 == null) goto L27;
            String r107 = r106.toString();
            if (r107 == null) goto L28;
            ((ArrayList) this.f82322a.f82314d).add(r107);
            return;
        L28:
            return;
        L27:
            return;
        L22:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkWithAudienceFeedbackView f82323a;

        public e(PkWithAudienceFeedbackView r100) {
            this.f82323a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            if (r110 == null) goto L45;
            TextView r111 = (TextView) r110;
            TextView r100 = this.f82323a.f82317g;
            if (r100 == null) goto L6;
            r100.setTag(Boolean.FALSE);
            r100.setBackgroundResource(R.drawable.ttlive_bg_tag_pk_audience_feedback_unselect);
            r100.setTextColor(s1.h(R.color.ttlive_pk_audience_feedback_tag_unselected));
        L6:
            ((ArrayList) this.f82323a.f82314d).clear();
            PkWithAudienceFeedbackView r101 = this.f82323a;
            r101.f82315e = "";
            List<com.bytedance.android.livesdk.rank.model.b> r102 = null;
            if (Intrinsics.areEqual(r101.f82317g, r111) == false) goto L12;
            PkWithAudienceFeedbackView r112 = this.f82323a;
            r112.f82313c = null;
            ((LinearLayout) r112.a(R.id.sub_tag_container)).setVisibility(8);
            ((WrapLineFlowLayout) this.f82323a.a(R.id.sub_tags_random)).removeAllViews();
            PkWithAudienceFeedbackView r113 = this.f82323a;
            r113.f82317g = null;
            a r114 = r113.f82316f;
            if (r114 == null) goto L55;
            r114.a();
            return;
        L55:
            return;
        L12:
            this.f82323a.f82317g = r111;
            if (r111.getTag() != null) goto L15;
        L16:
            r111.setBackgroundResource(R.drawable.ttlive_bg_tag_pk_audience_feedback_select);
            r111.setTextColor(s1.h(R.color.ttlive_pk_audience_feedback_tag_selected));
            r111.setTag(Boolean.TRUE);
            PkWithAudienceFeedbackView r103 = this.f82323a;
            CharSequence r115 = r111.getText();
            if (r115 == null) goto L19;
            String r116 = r115.toString();
        L20:
            r103.f82313c = r116;
            a r117 = this.f82323a.f82316f;
            if (r117 == null) goto L23;
            r117.a();
        L23:
            g r118 = this.f82323a.f82312b;
            if (r118 == null) goto L26;
            r102 = r118.getIssueCategories();
        L26:
            if (r102 == null) goto L56;
            Iterator<T> r119 = r102.iterator();
        L29:
            if (r119.hasNext() == false) goto L57;
            com.bytedance.android.livesdk.rank.model.b r104 = (com.bytedance.android.livesdk.rank.model.b) r119.next();
            if (Intrinsics.areEqual(r104.getCategory(), this.f82323a.f82313c) == false) goto L29;
            PkWithAudienceFeedbackView r105 = this.f82323a;
            ((LinearLayout) r105.a(R.id.sub_tag_container)).setVisibility(0);
            List<String> r106 = r104.getIssues();
            if (r106 != null) goto L36;
            r106 = CollectionsKt.emptyList();
        L36:
            if (Lists.isEmpty(r106) == true) goto L37;
            ((TextView) r105.a(R.id.sub_tag_title_tv)).setText(s1.B(R.string.ttlive_talk_room_feedback_sub_tag_title));
            ((WrapLineFlowLayout) r105.a(R.id.sub_tags_random)).removeAllViews();
            Iterator<String> r107 = r106.iterator();
        L40:
            if (r107.hasNext() == false) goto L42;
            TextView r108 = r105.b(r107.next());
            ((WrapLineFlowLayout) r105.a(R.id.sub_tags_random)).addView(r108);
            r108.setOnClickListener(r105.f82319i);
            goto L40
        L42:
            ((WrapLineFlowLayout) r105.a(R.id.sub_tags_random)).setVisibility(0);
            ((EditText) r105.a(R.id.other_et)).setVisibility(8);
            goto L29
        L37:
            ((TextView) r105.a(R.id.sub_tag_title_tv)).setText(s1.B(R.string.ttlive_talk_room_feedback_sub_tag_title_2));
            ((EditText) r105.a(R.id.other_et)).setVisibility(0);
            ((WrapLineFlowLayout) r105.a(R.id.sub_tags_random)).setVisibility(8);
            goto L29
        L57:
            return;
        L56:
            return;
        L19:
            r116 = null;
            goto L20
        L15:
            if (Intrinsics.areEqual(r111.getTag(), Boolean.FALSE) == true) goto L16;
            return;
        L45:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public final String getSelectedSubTag() {
        if (TextUtils.isEmpty(this.f82315e) == false) goto L5;
        Iterator<String> r100 = this.f82314d.iterator();
        String r101 = "";
    L8:
        if (r100.hasNext() == false) goto L11;
        r101 = r101 + r100.next() + ',';
        goto L8
    L11:
        if (StringsKt.endsWith$default(r101, ",", false, 2, null) == true) goto L13;
        return r101;
    L13:
        return r101.substring(0, r101.length() - 1);
    L5:
        return this.f82315e;
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_pk_with_audience_feedback_issue, this, true);
        ((EditText) a(R.id.other_et)).addTextChangedListener(new b(this));
        ((EditText) a(R.id.other_et)).setOnTouchListener(c.f82321a);
    }

    public final String getSelectedTag() {
        return this.f82313c;
    }

    public PkWithAudienceFeedbackView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f82311a = new LinkedHashMap();
        this.f82314d = new ArrayList();
        this.f82315e = "";
        this.f82318h = new e(this);
        this.f82319i = new d(this);
        c();
    }

    public final View a(int r100) {
        if (this.f82311a != null) goto L5;
        this.f82311a = new LinkedHashMap();
    L5:
        View r101 = this.f82311a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f82311a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final TextView b(String r100) {
        TextView r101 = new TextView(getContext());
        r101.setBackgroundResource(R.drawable.ttlive_bg_tag_pk_audience_feedback_unselect);
        r101.setText(r100);
        r101.setTextColor(s1.h(R.color.ttlive_pk_audience_feedback_tag_unselected));
        r101.setTextSize(1, 12.0f);
        int r102 = (int) UIUtils.dip2Px(getContext(), 18.0f);
        int r103 = (int) UIUtils.dip2Px(getContext(), 6.0f);
        r101.setPadding(r102, r103, r102, r103);
        return r101;
    }

    public final void setListener(a r100) {
        this.f82316f = r100;
    }

    public final void setTagTitleText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        ((TextView) a(R.id.tag_title_tv)).setText(r100);
    }

    public PkWithAudienceFeedbackView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f82311a = new LinkedHashMap();
        this.f82314d = new ArrayList();
        this.f82315e = "";
        this.f82318h = new e(this);
        this.f82319i = new d(this);
        c();
    }

    public PkWithAudienceFeedbackView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f82311a = new LinkedHashMap();
        this.f82314d = new ArrayList();
        this.f82315e = "";
        this.f82318h = new e(this);
        this.f82319i = new d(this);
        c();
    }
}
