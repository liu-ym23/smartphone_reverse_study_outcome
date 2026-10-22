package com.bytedance.android.gamecp.business.comment;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0010\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J+\u0010\f\u001a\u00020\u00032#\u0010\u0004\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00030\tR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/ReplyInputView;", "Landroid/widget/LinearLayout;", "Lkotlin/Function0;", "", "action", "setOnInputClickListener", "", "content", "setHintText", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "setOnSendClickListener", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "getMPublish", "()Landroid/widget/ImageView;", "setMPublish", "(Landroid/widget/ImageView;)V", "mPublish", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplyInputView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f51875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f51876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f51877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f51878d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f51879a;

        public a(Function0 r100) {
            this.f51879a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f51879a.invoke();
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplyInputView f51880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f51881b;

        public b(ReplyInputView r100, Function1 r101) {
            this.f51880a = r100;
            this.f51881b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            EditText r101 = this.f51880a.f51875a;
            if (r101 == null) goto L17;
            Editable r102 = r101.getText();
            if (r102 != null) goto L7;
            return;
        L7:
            if (r102.length() <= 0) goto L9;
            boolean r103 = true;
        L10:
            if (r103 != true) goto L19;
            Function1 r104 = this.f51881b;
            EditText r105 = this.f51880a.f51875a;
            if (r105 == null) goto L14;
            Editable r106 = r105.getText();
        L15:
            r104.invoke(StringsKt.trim(String.valueOf(r106)).toString());
            return;
        L14:
            r106 = null;
            goto L15
        L19:
            return;
        L9:
            r103 = false;
            goto L10
        }
    }

    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplyInputView f51882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f51883b;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            if (StringsKt.trim(String.valueOf(r100)).toString().length() <= 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L10;
            ImageView r102 = this.f51882a.getMPublish();
            if (r102 == null) goto L14;
            r102.setImageResource(R.drawable.gamecp_ic_new_comment_send);
            return;
        L14:
            return;
        L10:
            ImageView r103 = this.f51882a.getMPublish();
            if (r103 == null) goto L16;
            r103.setImageResource(R.drawable.gamecp_ic_new_comment_send_gray);
            return;
        L16:
            return;
        L5:
            r101 = false;
            goto L6
        }

        public c(ReplyInputView r100, Context r101) {
            this.f51882a = r100;
            this.f51883b = r101;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            if (r100 != null) goto L5;
        L8:
            boolean r104 = true;
        L9:
            if (r104 == false) goto L12;
            return;
        L12:
            if (r100.length() <= 150) goto L17;
            ((Editable) r100).delete(150, r100.length());
            Resources r105 = this.f51883b.getResources();
            if (r105 == null) goto L18;
            ToastUtil.b(r105.getString(R.string.ttlive_game_promote_recommend_max_limit, new Object[]{String.valueOf(150)}), 0);
            return;
        L18:
            return;
        L17:
            return;
        L5:
            if (r100.length() == 0) goto L8;
            r104 = false;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.comment.ReplyInputView$setOnInputClickListener$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    public ReplyInputView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ReplyInputView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final ImageView getMPublish() {
        return this.f51877c;
    }

    public final void setHintText(String r100) {
        EditText r101 = this.f51875a;
        if (r101 == null) goto L6;
        r101.setHint(r100);
        return;
    }

    public final void setMPublish(ImageView r100) {
        this.f51877c = r100;
    }

    public final void setOnInputClickListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        TextView r101 = this.f51876b;
        if (r101 == null) goto L6;
        r101.setOnClickListener(new a(r100));
        return;
    }

    public final void setOnSendClickListener(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ImageView r101 = this.f51877c;
        if (r101 == null) goto L6;
        r101.setOnClickListener(new b(this, r100));
        return;
    }

    public ReplyInputView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        c r103 = new c(this, r100);
        this.f51878d = r103;
        setOrientation(0);
        setPadding(y0.b(16.0f), y0.b(9.0f), y0.b(16.0f), y0.b(9.0f));
        setBackground(y0.e(R.drawable.gamecp_shape_game_promote_comment_detail_bottom_bg));
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-1, -2, 1.0f);
        EditText r105 = new EditText(r100);
        this.f51875a = r105;
        r105.setLayoutParams(r104);
        r105.setMinLines(1);
        r105.setBackground(y0.e(R.drawable.gamecp_bg_game_comment_reply_input_v2));
        r105.setPadding(y0.b(10.0f), y0.b(10.0f), y0.b(10.0f), y0.b(10.0f));
        r105.setHint(y0.i(R.string.ttlive_game_promote_comment_reply_input_hint));
        r105.setHintTextColor(y0.c(R.color.gamecp_game_80161823));
        r105.setTextColor(y0.c(R.color.gamecp_game_161823));
        r105.setTextSize(13.0f);
        r105.setImeOptions(268435456);
        r105.addTextChangedListener(r103);
        TextView r106 = new TextView(r100);
        this.f51876b = r106;
        r106.setTextSize(13.0f);
        r106.setTextColor(y0.c(R.color.gamecp_game_57161823));
        r106.setText(y0.i(R.string.ttlive_game_promote_comment_reply_input_hint));
        r106.setBackground(y0.e(R.drawable.gamecp_bg_game_comment_reply_input));
        r106.setPadding(y0.b(10.0f), y0.b(10.0f), y0.b(10.0f), y0.b(10.0f));
        r106.setLayoutParams(r104);
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(y0.b(22.0f), y0.b(22.0f));
        r107.leftMargin = y0.b(12.0f);
        r107.bottomMargin = y0.b(7.0f);
        r107.gravity = 80;
        ImageView r108 = new ImageView(r100);
        this.f51877c = r108;
        r108.setLayoutParams(r107);
        ImageView r109 = this.f51877c;
        if (r109 == null) goto L5;
        r109.setImageResource(R.drawable.gamecp_ic_new_comment_send_gray);
    L5:
        UtilityKotlinExtentionsKt.h(r105);
        ImageView r110 = this.f51877c;
        if (r110 == null) goto L8;
        UtilityKotlinExtentionsKt.h(r110);
    L8:
        UtilityKotlinExtentionsKt.j(r106);
        addView(r105);
        addView(r106);
        addView(this.f51877c);
    }

    public /* synthetic */ ReplyInputView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
