package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.m;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenAccessibilityUtil;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.u;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/plugin/messagemodel/PublicScreenCombinedTextViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PSMessageViewHolder;", "Lg52/b;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenCombinedTextViewHolder extends PSMessageViewHolder implements g52.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f139228l = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NoMoreSpaceTextView f139229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NoMoreSpaceTextView f139230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f139231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g52.a f139232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnClickListener f139233f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f139234g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f139235h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<s> f139236i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<s> f139237j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<s, Unit> f139238k;

    public static final class a implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PublicScreenCombinedTextViewHolder f139239a;

        public a(PublicScreenCombinedTextViewHolder r100) {
            this.f139239a = r100;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            s r101 = this.f139239a.f139237j.invoke();
            if (r101 != null) goto L7;
            return false;
        L7:
            return r101.m(r100);
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PublicScreenCombinedTextViewHolder f139240a;

        public b(PublicScreenCombinedTextViewHolder r100) {
            this.f139240a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            s r101 = this.f139240a.f139237j.invoke();
            if (r101 == null) goto L6;
            int r102 = s.f133517k;
            r101.l(r100, null, null);
            return;
        }
    }

    public static final class c implements com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PublicScreenCombinedTextViewHolder f139241a;

        public c(PublicScreenCombinedTextViewHolder r100) {
            this.f139241a = r100;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l
        public final void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            s r101 = this.f139241a.f139237j.invoke();
            if (r101 == null) goto L6;
            int r102 = s.f133517k;
            r101.l(r100, null, null);
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l
        public final boolean b(View r100, tb2.b r101, ClickableSpan r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "action");
            Intrinsics.checkNotNullParameter(r102, "span");
            s r103 = this.f139241a.f139237j.invoke();
            if (r103 == null) goto L5;
            boolean r104 = r103.n(r100, r101);
        L6:
            if (r104 == false) goto L8;
            return r104;
        L8:
            if ((r101 instanceof tb2.e) == false) goto L12;
            int r105 = tb2.f.f545245a;
            return tb2.f.a((tb2.e) r101);
        L12:
            return r104;
        L5:
            r104 = false;
            goto L6
        }
    }

    public PublicScreenCombinedTextViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        NoMoreSpaceTextView r101 = (NoMoreSpaceTextView) r100.findViewById(R.id.supplement_info_tv);
        this.f139229b = r101;
        NoMoreSpaceTextView r102 = (NoMoreSpaceTextView) r100.findViewById(R.id.core_info_tv);
        this.f139230c = r102;
        LinearLayout r103 = (LinearLayout) r100.findViewById(R.id.background);
        this.f139231d = r103;
        KeyEvent.Callback r104 = r100.findViewById(R.id.layout);
        if ((r104 instanceof g52.a) == true) goto L5;
        r104 = null;
    L5:
        this.f139232e = (g52.a) r104;
        this.f139237j = new PublicScreenCombinedTextViewHolder$getTagMessageModel$1(this);
        this.f139238k = new PublicScreenCombinedTextViewHolder$setTagMessageModel$1(this);
        a r105 = new a(this);
        this.f139234g = r105;
        this.f139233f = new b(this);
        this.f139235h = new c(this);
        r103.setOnLongClickListener(r105);
        r103.setOnClickListener(this.f139233f);
        r103.setAlpha(1.0f);
        t.a(r102);
        t.a(r101);
        ViewGroup r106 = (ViewGroup) r100.findViewById(R.id.layout);
        if (r106 == null) goto L8;
        r106.setImportantForAccessibility(2);
    L8:
        r102.setFocusable(true);
        r101.setFocusable(true);
    }

    public final void Y3(com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<s> r100) {
        Intrinsics.checkNotNullParameter(r100, "renderTextProcessor");
        this.f139236i = r100;
        View.OnClickListener r101 = r100.c(this.f139235h);
        this.f139233f = r101;
        this.f139230c.setOnClickListener(r101);
        this.f139230c.setOnLongClickListener(this.f139234g);
        this.f139230c.setMovementMethod(new u());
        this.f139230c.setHighlightColor(0);
        this.f139229b.setOnClickListener(this.f139233f);
        this.f139229b.setOnLongClickListener(this.f139234g);
        this.f139229b.setMovementMethod(new u());
        this.f139229b.setHighlightColor(0);
    }

    public final void Z3(NoMoreSpaceTextView r100) {
        PublicScreenAccessibilityUtil r101 = PublicScreenAccessibilityUtil.f133607a;
        CharSequence r102 = r100.getText();
        if ((r102 instanceof Spanned) == true) goto L5;
        r102 = null;
    L5:
        r101.getClass();
        PublicScreenAccessibilityUtil.a((Spanned) r102, r100, null);
    }

    @Override // g52.b
    public final void c(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        e52.a r101 = null;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r102 = m.a(null);
        if (r102 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r103 = r102.getValue();
        if (r103 == null) goto L7;
        r101 = r103.getTextConfig();
    L7:
        s r104 = this.f139237j.invoke();
        if (r101 == null) goto L19;
        if (r104 == null) goto L20;
        s r105 = r104;
        int r106 = r100.getAction();
        if (r106 == 0) goto L17;
        if (r106 != 1) goto L14;
    L16:
        W3(r101, r105, false);
        return;
    L14:
        if (r106 == 3) goto L16;
        return;
    L17:
        W3(r101, r105, true);
        return;
    L20:
        return;
    }

    public static void X3(NoMoreSpaceTextView r100, Integer r101) {
        if (r101 == null) goto L11;
        int r102 = r101.intValue();
        if (r102 > 0) goto L8;
        r100.setMaxLines(Integer.MAX_VALUE);
        return;
    L8:
        if (r102 != 1) goto L10;
        r100.setSingleLine();
        return;
    L10:
        r100.setMaxLines(r102);
        return;
    L11:
        r100.setMaxLines(Integer.MAX_VALUE);
    }

    public final void W3(e52.a r100, s r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "textMessageConfig");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        int r103 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.a(r102, null, r100);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.e(this.f139231d, r103);
    }
}
