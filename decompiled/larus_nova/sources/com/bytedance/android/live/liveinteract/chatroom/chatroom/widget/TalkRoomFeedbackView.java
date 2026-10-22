package com.bytedance.android.live.liveinteract.chatroom.chatroom.widget;

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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u001b\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0010\u0010\u0014B#\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0010\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/widget/TalkRoomFeedbackView;", "Landroid/widget/ScrollView;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/widget/TalkRoomFeedbackView$b;", "callback", "", "setSubitemSelectCountListener", "", "content", "setTagTitleText", "getSelectedTag", "getSelectedSubTag", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/widget/TalkRoomFeedbackView$a;", "listener", "setListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TalkRoomFeedbackView extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f72474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f72475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f72476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f72477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f72478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f72479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f72480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f72481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f72482i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f72483j;

    public interface a {
        void a();
    }

    public interface b {
        void a(String r100, List r101);
    }

    public static final class c extends d2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TalkRoomFeedbackView f72484a;

        public c(TalkRoomFeedbackView r100) {
            this.f72484a = r100;
        }

        @Override // com.bytedance.android.live.core.utils.d2, android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            if (r100 == null) goto L9;
            String r104 = r100.toString();
            if (r104 == null) goto L10;
            TalkRoomFeedbackView r105 = this.f72484a;
            r105.f72478e = r104;
            b r106 = r105.f72479f;
            if (r106 == null) goto L11;
            r106.a(r105.f72476c, r105.f72477d);
            return;
        L11:
            return;
        L10:
            return;
        }
    }

    public static final class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f72485a = null;

        static {
            f72485a = new d();
        }

        public d() {
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

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TalkRoomFeedbackView f72486a;

        public e(TalkRoomFeedbackView r100) {
            this.f72486a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (r100 == null) goto L25;
            TextView r101 = (TextView) r100;
            if (r101.getTag() == null) goto L15;
            Object r102 = r101.getTag();
            Boolean r103 = Boolean.FALSE;
            if (Intrinsics.areEqual(r102, r103) == true) goto L15;
            r101.setBackgroundResource(R.drawable.ttlive_bg_tag_chat_feedback_unselect);
            r101.setTextColor(s1.h(R.color.ttlive_pk_feedback_tag_unselected));
            r101.setTag(r103);
            CharSequence r104 = r101.getText();
            if (r104 == null) goto L20;
            String r105 = r104.toString();
            if (r105 == null) goto L20;
            if (((ArrayList) this.f72486a.f72477d).contains(r105) == false) goto L20;
            ((ArrayList) this.f72486a.f72477d).remove(r105);
        L20:
            TalkRoomFeedbackView r106 = this.f72486a;
            b r107 = r106.f72479f;
            if (r107 == null) goto L26;
            r107.a(r106.f72476c, r106.f72477d);
            return;
        L26:
            return;
        L15:
            r101.setBackgroundResource(R.drawable.ttlive_bg_tag_chat_feedback_select);
            r101.setTextColor(s1.h(R.color.ttlive_pk_feedback_tag_selected));
            r101.setTag(Boolean.TRUE);
            CharSequence r108 = r101.getText();
            if (r108 == null) goto L20;
            String r109 = r108.toString();
            if (r109 == null) goto L20;
            ((ArrayList) this.f72486a.f72477d).add(r109);
            goto L20
        L25:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TalkRoomFeedbackView f72487a;

        public f(TalkRoomFeedbackView r100) {
            this.f72487a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            if (r110 == null) goto L48;
            TextView r111 = (TextView) r110;
            TextView r100 = this.f72487a.f72481h;
            if (r100 == null) goto L6;
            r100.setTag(Boolean.FALSE);
            r100.setBackgroundResource(R.drawable.ttlive_bg_tag_chat_feedback_unselect);
            r100.setTextColor(s1.h(R.color.ttlive_pk_feedback_tag_unselected));
        L6:
            ((ArrayList) this.f72487a.f72477d).clear();
            TalkRoomFeedbackView r101 = this.f72487a;
            r101.f72478e = "";
            List<com.bytedance.android.livesdk.rank.model.b> r102 = null;
            if (Intrinsics.areEqual(r101.f72481h, r111) == false) goto L15;
            TalkRoomFeedbackView r112 = this.f72487a;
            r112.f72476c = null;
            ((LinearLayout) r112.a(R.id.sub_tag_container)).setVisibility(8);
            ((WrapLineFlowLayout) this.f72487a.a(R.id.sub_tags_random)).removeAllViews();
            TalkRoomFeedbackView r113 = this.f72487a;
            r113.f72481h = null;
            a r114 = r113.f72480g;
            if (r114 == null) goto L11;
            r114.a();
        L11:
            TalkRoomFeedbackView r115 = this.f72487a;
            b r103 = r115.f72479f;
            if (r103 == null) goto L58;
            r103.a(null, r115.f72477d);
            return;
        L58:
            return;
        L15:
            this.f72487a.f72481h = r111;
            if (r111.getTag() != null) goto L18;
        L19:
            r111.setBackgroundResource(R.drawable.ttlive_bg_tag_chat_feedback_select);
            r111.setTextColor(s1.h(R.color.ttlive_pk_feedback_tag_selected));
            r111.setTag(Boolean.TRUE);
            TalkRoomFeedbackView r104 = this.f72487a;
            CharSequence r116 = r111.getText();
            if (r116 == null) goto L22;
            String r117 = r116.toString();
        L23:
            r104.f72476c = r117;
            a r118 = this.f72487a.f72480g;
            if (r118 == null) goto L26;
            r118.a();
        L26:
            g r119 = this.f72487a.f72475b;
            if (r119 == null) goto L29;
            r102 = r119.getIssueCategories();
        L29:
            if (r102 == null) goto L43;
            Iterator<T> r120 = r102.iterator();
        L32:
            if (r120.hasNext() == false) goto L43;
            com.bytedance.android.livesdk.rank.model.b r105 = (com.bytedance.android.livesdk.rank.model.b) r120.next();
            if (Intrinsics.areEqual(r105.getCategory(), this.f72487a.f72476c) == false) goto L32;
            TalkRoomFeedbackView r106 = this.f72487a;
            ((LinearLayout) r106.a(R.id.sub_tag_container)).setVisibility(0);
            if (Lists.isEmpty(r105.getIssues()) == true) goto L37;
            ((TextView) r106.a(R.id.sub_tag_title_tv)).setText(s1.B(R.string.ttlive_talk_room_feedback_sub_tag_title));
            ((WrapLineFlowLayout) r106.a(R.id.sub_tags_random)).removeAllViews();
            List<String> r107 = r105.getIssues();
            Intrinsics.checkNotNull(r107);
            Iterator<String> r108 = r107.iterator();
        L40:
            if (r108.hasNext() == false) goto L42;
            TextView r109 = r106.b(r108.next());
            ((WrapLineFlowLayout) r106.a(R.id.sub_tags_random)).addView(r109);
            r109.setOnClickListener(r106.f72483j);
            goto L40
        L42:
            ((WrapLineFlowLayout) r106.a(R.id.sub_tags_random)).setVisibility(0);
            ((EditText) r106.a(R.id.other_et)).setVisibility(8);
            goto L32
        L37:
            ((TextView) r106.a(R.id.sub_tag_title_tv)).setText(s1.B(R.string.ttlive_talk_room_feedback_sub_tag_title_2));
            ((EditText) r106.a(R.id.other_et)).setVisibility(0);
            ((WrapLineFlowLayout) r106.a(R.id.sub_tags_random)).setVisibility(8);
        L43:
            TalkRoomFeedbackView r121 = this.f72487a;
            b r122 = r121.f72479f;
            if (r122 == null) goto L59;
            r122.a(r121.f72476c, r121.f72477d);
            return;
        L59:
            return;
        L22:
            r117 = null;
            goto L23
        L18:
            if (Intrinsics.areEqual(r111.getTag(), Boolean.FALSE) == false) goto L43;
        L48:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public final String getSelectedSubTag() {
        if (TextUtils.isEmpty(this.f72478e) == false) goto L5;
        Iterator<String> r100 = this.f72477d.iterator();
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
        return this.f72478e;
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_talk_room_feedback_issue, this, true);
        ((EditText) a(R.id.other_et)).addTextChangedListener(new c(this));
        ((EditText) a(R.id.other_et)).setOnTouchListener(d.f72485a);
    }

    public final String getSelectedTag() {
        return this.f72476c;
    }

    public TalkRoomFeedbackView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f72474a = new LinkedHashMap();
        this.f72477d = new ArrayList();
        this.f72478e = "";
        this.f72482i = new f(this);
        this.f72483j = new e(this);
        c();
    }

    public final View a(int r100) {
        if (this.f72474a != null) goto L5;
        this.f72474a = new LinkedHashMap();
    L5:
        View r101 = this.f72474a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f72474a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final TextView b(String r100) {
        TextView r101 = new TextView(getContext());
        r101.setBackgroundResource(R.drawable.ttlive_bg_tag_chat_feedback_unselect);
        r101.setText(r100);
        r101.setTextColor(s1.h(R.color.ttlive_pk_feedback_tag_unselected));
        r101.setTextSize(1, 12.0f);
        int r102 = (int) UIUtils.dip2Px(getContext(), 18.0f);
        int r103 = (int) UIUtils.dip2Px(getContext(), 6.0f);
        r101.setPadding(r102, r103, r102, r103);
        return r101;
    }

    public final void setListener(a r100) {
        this.f72480g = r100;
    }

    public final void setSubitemSelectCountListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f72479f = r100;
    }

    public final void setTagTitleText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        ((TextView) a(R.id.tag_title_tv)).setText(r100);
    }

    public TalkRoomFeedbackView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f72474a = new LinkedHashMap();
        this.f72477d = new ArrayList();
        this.f72478e = "";
        this.f72482i = new f(this);
        this.f72483j = new e(this);
        c();
    }

    public TalkRoomFeedbackView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f72474a = new LinkedHashMap();
        this.f72477d = new ArrayList();
        this.f72478e = "";
        this.f72482i = new f(this);
        this.f72483j = new e(this);
        c();
    }
}
