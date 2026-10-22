package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.amap.api.col.s.ce;
import com.bytedance.android.livesdk.config.gr0;
import com.bytedance.android.livesdkapi.depend.model.live.security.CorrectionResult;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00022\u0003B\u001d\b\u0017\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b-\u0010.B#\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\u0006\u00100\u001a\u00020/¢\u0006\u0004\b-\u00101R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010%\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\b¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/widget/TextCorrectionEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "", "b", "Z", "getAutomaticChanged", "()Z", "setAutomaticChanged", "(Z)V", "automaticChanged", "c", "getPopDown", "setPopDown", "popDown", "d", "getAdjustSize", "setAdjustSize", "adjustSize", "Lcom/bytedance/android/livesdk/widget/TextCorrectionEditText$b;", "e", "Lcom/bytedance/android/livesdk/widget/TextCorrectionEditText$b;", "getListener", "()Lcom/bytedance/android/livesdk/widget/TextCorrectionEditText$b;", "setListener", "(Lcom/bytedance/android/livesdk/widget/TextCorrectionEditText$b;)V", "listener", "", "f", "Ljava/lang/String;", "getLiveType", "()Ljava/lang/String;", "setLiveType", "(Ljava/lang/String;)V", "liveType", ce.f26391f, "getCurrentUserId", "setCurrentUserId", "currentUserId", RXScreenCaptureService.KEY_INDEX, "isTouchDisabled", "setTouchDisabled", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextCorrectionEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yo2.e f161336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f161337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f161338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f161339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f161340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f161341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f161342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f161343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f161344i;

    public final class a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BackgroundColorSpan f161345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f161346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f161347c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CorrectionResult f161348d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ TextCorrectionEditText f161349e;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.widget.TextCorrectionEditText$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC2467a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Editable f161350a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f161351b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f161352c;

            public ViewOnClickListenerC2467a(Editable r100, String r101, a r102) {
                this.f161350a = r100;
                this.f161351b = r101;
                this.f161352c = r102;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                this.f161352c.f161349e.setAutomaticChanged(true);
                int r101 = this.f161350a.getSpanStart(this.f161352c);
                this.f161350a.removeSpan(this.f161352c);
                Editable r102 = this.f161350a;
                int r103 = this.f161351b.length() + r101;
                List<String> r104 = this.f161352c.f161348d.replaceWords;
                Intrinsics.checkNotNull(r104);
                r102.replace(r101, r103, (CharSequence) ListProtector.get(r104, 0));
                yo2.e r105 = this.f161352c.f161349e.f161336a;
                if (r105 == null) goto L5;
                r105.d();
            L5:
                a r106 = this.f161352c;
                TextCorrectionEditText r107 = r106.f161349e;
                String r108 = this.f161351b;
                List<String> r109 = r106.f161348d.replaceWords;
                Intrinsics.checkNotNull(r109);
                TextCorrectionEditText.c(r107, "replace", r108, (String) ListProtector.get(r109, 0));
            }
        }

        public static final class b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Editable f161353a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f161354b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f161355c;

            public b(Editable r100, String r101, a r102) {
                this.f161353a = r100;
                this.f161354b = r101;
                this.f161355c = r102;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                this.f161353a.removeSpan(this.f161355c);
                b r101 = this.f161355c.f161349e.getListener();
                if (r101 == null) goto L5;
                r101.ignoreCorrection(this.f161354b);
            L5:
                yo2.e r102 = this.f161355c.f161349e.f161336a;
                if (r102 == null) goto L8;
                r102.d();
            L8:
                a r103 = this.f161355c;
                TextCorrectionEditText r104 = r103.f161349e;
                String r105 = this.f161354b;
                List<String> r106 = r103.f161348d.replaceWords;
                Intrinsics.checkNotNull(r106);
                TextCorrectionEditText.c(r104, "ignore", r105, (String) ListProtector.get(r106, 0));
            }
        }

        public static final class c implements PopupWindow.OnDismissListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Editable f161356a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f161357b;

            public c(Editable r100, a r101) {
                this.f161356a = r100;
                this.f161357b = r101;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                this.f161356a.removeSpan(this.f161357b.f161345a);
            }
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r110) {
            Intrinsics.checkNotNullParameter(r110, "widget");
            Editable r111 = this.f161349e.getText();
            if (r111 == null) goto L43;
            yo2.e r100 = this.f161349e.f161336a;
            if (r100 != null) goto L7;
        L11:
            int r101 = r111.getSpanStart(this);
            String r102 = r111.subSequence(r101, r111.getSpanEnd(this)).toString();
            if (Intrinsics.areEqual(r102, this.f161348d.originalWord) == false) goto L44;
            r111.setSpan(this.f161345a, r101, r102.length() + r101, 33);
            LayoutInflater r103 = LayoutInflater.from(this.f161349e.getContext());
            if (this.f161349e.getPopDown() == false) goto L16;
            int r104 = R.layout.ttlive_text_float_bubble_view;
        L17:
            View r105 = r103.inflate(r104, null);
            TextView r106 = (TextView) r105.findViewById(R.id.bubble_tips_tv);
            List<String> r107 = this.f161348d.replaceWords;
            Intrinsics.checkNotNull(r107);
            r106.setText((CharSequence) ListProtector.get(r107, 0));
            ((TextView) r105.findViewById(R.id.bubble_tips_tv)).setOnClickListener(new ViewOnClickListenerC2467a(r111, r102, this));
            ((TextView) r105.findViewById(R.id.bubble_ignore_tv)).setOnClickListener(new b(r111, r102, this));
            TextCorrectionEditText r108 = this.f161349e;
            yo2.e r109 = new yo2.e(r108.getContext());
            r109.f568642d = r105;
            r109.f568643e = 0;
            r109.f568650l = true;
            r109.f568649k = new c(r111, this);
            r108.f161336a = r109;
            if (this.f161349e.getAdjustSize() == false) goto L22;
            yo2.e r112 = this.f161349e.f161336a;
            if (r112 == null) goto L22;
            r112.f568659u = 16;
        L22:
            yo2.e r113 = this.f161349e.f161336a;
            if (r113 == null) goto L25;
            r113.a();
        L25:
            yo2.e r114 = this.f161349e.f161336a;
            if (r114 == null) goto L45;
            int r115 = r111.getSpanStart(this);
            int r116 = r111.getSpanEnd(this);
            Editable r117 = this.f161349e.getText();
            if (r117 != null) goto L30;
        L41:
            TextCorrectionEditText r118 = this.f161349e;
            List<String> r119 = this.f161348d.replaceWords;
            Intrinsics.checkNotNull(r119);
            TextCorrectionEditText.c(r118, "show", r102, (String) ListProtector.get(r119, 0));
            return;
        L30:
            if (r114.e() == null) goto L41;
            if (r115 > r117.length()) goto L41;
            if (r116 > r117.length()) goto L41;
            Rect r120 = new Rect();
            Layout r121 = this.f161349e.getLayout();
            r121.getLineBounds(r121.getLineForOffset(r115), r120);
            int r122 = r120.top;
            int r123 = r120.bottom;
            float r124 = r121.getPrimaryHorizontal(r115);
            Rect r125 = new Rect();
            this.f161349e.getPaint().getTextBounds(r117.toString(), r115, r116, r125);
            r114.e().measure(0, 0);
            int r126 = (int) ((r124 - (r114.e().getMeasuredWidth() / 2)) + (r125.width() / 2));
            if (this.f161349e.getPopDown() == false) goto L39;
            int r127 = r123;
        L40:
            r114.i(this.f161349e, 3, 3, r126, r127);
            goto L41
        L39:
            r127 = r122 - r114.e().getMeasuredHeight();
            goto L40
        L45:
            return;
        L16:
            r104 = R.layout.ttlive_text_float_up_bubble_view;
            goto L17
        L44:
            return;
        L7:
            if (r100.h() != true) goto L11;
            yo2.e r128 = this.f161349e.f161336a;
            if (r128 == null) goto L11;
            r128.d();
            goto L11
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
            TextPaint.class.getMethod("setUnderlineText", new Class[]{Integer.TYPE, Float.TYPE}).invoke(r100, new Object[]{Integer.valueOf(com.bytedance.android.live.core.utils.s1.h(R.color.ttlive_std_brand)), Float.valueOf(4.0f)});     // Catch: Exception -> L5
            return;
        L5:
            r100.setUnderlineText(true);
        }

        public a(TextCorrectionEditText r100, CorrectionResult r101) {
            Intrinsics.checkNotNullParameter(r101, "res");
            this.f161349e = r100;
            this.f161348d = r101;
            this.f161345a = new BackgroundColorSpan(com.bytedance.android.live.core.utils.s1.h(R.color.ttlive_douyin_BGBrand2));
        }
    }

    public interface b {
        void ignoreCorrection(String r100);
    }

    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Editable f161358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextCorrectionEditText f161359b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f161360c;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public c(Editable r100, TextCorrectionEditText r101, List r102) {
            this.f161358a = r100;
            this.f161359b = r101;
            this.f161360c = r102;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            Editable r104 = this.f161359b.getText();
            if (r104 != null) goto L5;
            return;
        L5:
            if (r102 != 1) goto L27;
            if (r103 == 0) goto L8;
            return;
        L8:
            if (r101 > this.f161358a.length()) goto L29;
            int r105 = 0;
            a[] r106 = (a[]) r104.getSpans(0, r101, a.class);
            if (r106 != null) goto L12;
            return;
        L12:
            if (r106.length != 0) goto L14;
            boolean r107 = true;
        L16:
            if ((true ^ r107) == false) goto L31;
            int r108 = r106.length;
        L18:
            if (r105 >= r108) goto L32;
            a r109 = r106[r105];
            if (r104.getSpanEnd(r109) == r101) goto L21;
            r105 = r105 + 1;
            goto L18
        L21:
            TextCorrectionEditText.c(this.f161359b, "delete", r109.f161346b, r109.f161347c);
            return;
        L32:
            return;
        L31:
            return;
        L14:
            r107 = false;
            goto L16
        L29:
            return;
        }
    }

    public final boolean getAdjustSize() {
        return this.f161339d;
    }

    public final boolean getAutomaticChanged() {
        return this.f161337b;
    }

    public final String getCurrentUserId() {
        return this.f161342g;
    }

    public final b getListener() {
        return this.f161340e;
    }

    public final String getLiveType() {
        return this.f161341f;
    }

    public final boolean getPopDown() {
        return this.f161338c;
    }

    public TextCorrectionEditText(Context r100) {
        this(r100, null);
    }

    public final void d(List<CorrectionResult> r100) {
        Editable r101 = getText();
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f161343h != null) goto L7;
        c r102 = new c(r101, this, r100);
        this.f161343h = r102;
        addTextChangedListener(r102);
    L7:
        Object[] r103 = (a[]) r101.getSpans(0, length(), a.class);
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L10;
        r101.removeSpan(r103[r105]);
        r105 = r105 + 1;
        goto L8
    L10:
        List<CorrectionResult> r106 = r100;
        if (r106 != null) goto L13;
    L16:
        boolean r107 = true;
    L17:
        if (r107 == false) goto L19;
        return;
    L19:
        Iterator<CorrectionResult> r108 = r100.iterator();
    L21:
        if (r108.hasNext() == false) goto L39;
        CorrectionResult r109 = r108.next();
        if (r109 == null) goto L21;
        if (r109.idxOfText > (r101.length() - 1)) goto L21;
        if (r109.originalWord == null) goto L21;
        List<String> r110 = r109.replaceWords;
        if (r110 != null) goto L31;
    L34:
        boolean r111 = true;
    L35:
        if (r111 == true) goto L21;
        int r112 = r109.idxOfText;
        String r113 = r109.originalWord;
        Intrinsics.checkNotNull(r113);
        String r114 = r101.subSequence(r112, r113.length() + r112).toString();
        if (Intrinsics.areEqual(r114, r109.originalWord) == false) goto L21;
        a r115 = new a(this, r109);
        r115.f161346b = r114;
        List<String> r116 = r109.replaceWords;
        Intrinsics.checkNotNull(r116);
        r115.f161347c = (String) ListProtector.get(r116, 0);
        int r117 = r109.idxOfText;
        r101.setSpan(r115, r117, r114.length() + r117, 33);
        goto L21
    L31:
        if (r110.isEmpty() == true) goto L34;
        r111 = false;
        goto L35
    L39:
        LinkedHashMap r118 = new LinkedHashMap();
        String r119 = this.f161341f;
        String r120 = "";
        if (r119 != null) goto L42;
        r119 = "";
    L42:
        r118.put("live_type", r119);
        String r121 = this.f161342g;
        if (r121 == null) goto L46;
        r120 = r121;
    L46:
        r118.put("anchor_id", r120);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_text_error_show", r118, new Object[0]);
        return;
    L13:
        if (r106.isEmpty() == true) goto L16;
        r107 = false;
        goto L17
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f161344i == false) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (gr0.f120309a.getValue().booleanValue() == false) goto L5;
        int r101 = r100.getAction();
        if (r101 == 1) goto L9;
        if (r101 == 0) goto L9;
    L25:
        return super.onTouchEvent(r100);
    L9:
        int r102 = (int) r100.getX();
        int r103 = (int) r100.getY();
        int r104 = r102 - getTotalPaddingLeft();
        int r105 = r103 - getTotalPaddingTop();
        int r106 = r104 + getScrollX();
        int r107 = r105 + getScrollY();
        Layout r108 = getLayout();
        int r109 = r108.getOffsetForHorizontal(r108.getLineForVertical(r107), r106);
        if (getText() == null) goto L12;
        Editable r110 = getText();
        Intrinsics.checkNotNull(r110);
        ClickableSpan[] r111 = (ClickableSpan[]) r110.getSpans(r109, r109, ClickableSpan.class);
        if (r111 == null) goto L25;
        if (r111.length != 0) goto L18;
        boolean r112 = true;
    L20:
        if ((!r112) == false) goto L25;
        if (r101 != 1) goto L23;
        r111[0].onClick(this);
    L23:
        return true;
    L18:
        r112 = false;
        goto L20
    L12:
        return super.onTouchEvent(r100);
    L5:
        return super.onTouchEvent(r100);
    }

    public final void setAdjustSize(boolean r100) {
        this.f161339d = r100;
    }

    public final void setAutomaticChanged(boolean r100) {
        this.f161337b = r100;
    }

    public final void setCurrentUserId(String r100) {
        this.f161342g = r100;
    }

    public final void setListener(b r100) {
        this.f161340e = r100;
    }

    public final void setLiveType(String r100) {
        this.f161341f = r100;
    }

    public final void setPopDown(boolean r100) {
        this.f161338c = r100;
    }

    public final void setTouchDisabled(boolean r100) {
        this.f161344i = r100;
    }

    public TextCorrectionEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f161338c = true;
    }

    public TextCorrectionEditText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f161338c = true;
    }

    public static final void c(TextCorrectionEditText r100, String r101, String r102, String r103) {
        r100.getClass();
        LinkedHashMap r104 = new LinkedHashMap();
        String r105 = r100.f161341f;
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        r104.put("live_type", r105);
        String r106 = r100.f161342g;
        if (r106 != null) goto L8;
        r106 = "";
    L8:
        r104.put("anchor_id", r106);
        r104.put("text_action_type", r101);
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        r104.put("typo_word", r102);
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        r104.put("cue_word", r103);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_text_error_floating_layer_action", r104, new Object[0]);
    }
}
