package com.obric.oui.window.permission;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.widget.LinearLayout;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.oui.text.OTextView;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PrivacyStatementDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "Use PrivacyStatementActivity instead")
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001'B\u0087\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0010j\b\u0012\u0004\u0012\u00020\u0005`\u0011\u0012\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J(\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0002J\u001a\u0010!\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u0010#\u001a\u00020\rJ\u0006\u0010$\u001a\u00020\u0019J\u0018\u0010%\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010&\u001a\u00020\rR\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0010j\b\u0012\u0004\u0012\u00020\u0005`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementDialog;", "", "context", "Landroid/content/Context;", "title", "", "message", "iconResId", "", "positiveButtonText", "negativeButtonText", "positiveButtonListener", "Lkotlin/Function0;", "", "negativeButtonListener", "urls", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "customClickHandler", "Lkotlin/Function1;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/Integer;", "mBuilder", "Lcom/obric/oui/dialog/alert/OAlertDialogBuilder;", "oAlertDialog", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "applyClickableSpan", "Landroid/text/SpannableString;", "text", "span", "Landroid/text/style/ClickableSpan;", "start", TraceStatsConsts.STATS_KEY_END, "createClickableSpan", "url", "dismiss", "getDialog", "processMessage", "show", "Builder", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrivacyStatementDialog {
    private final Function1<String, Unit> customClickHandler;
    private final Integer iconResId;
    private final OAlertDialogBuilder mBuilder;
    private final String message;
    private final Function0<Unit> negativeButtonListener;
    private final String negativeButtonText;
    private final OAlertDialog oAlertDialog;
    private final Function0<Unit> positiveButtonListener;
    private final String positiveButtonText;
    private final String title;
    private final ArrayList<String> urls;

    /* JADX INFO: compiled from: PrivacyStatementDialog.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\u001a\u001a\u00020\u00002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\tJ\u0014\u0010\u001e\u001a\u00020\u00002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\tJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\tJ\u001a\u0010!\u001a\u00020\u00002\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u0012J\u001e\u0010#\u001a\u00020\u00002\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0014j\b\u0012\u0004\u0012\u00020\t`\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0014j\b\u0012\u0004\u0012\u00020\t`\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementDialog$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "iconResId", "", "Ljava/lang/Integer;", "message", "", "negativeButtonListener", "Lkotlin/Function0;", "", "negativeButtonText", "positiveButtonListener", "positiveButtonText", "title", "urlCustomClickHandler", "Lkotlin/Function1;", "urls", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "build", "Lcom/obric/oui/window/permission/PrivacyStatementDialog;", "setIcon", "setMessage", "setNegativeButtonListener", "listener", "setNegativeButtonText", "text", "setPositiveButtonListener", "setPositiveButtonText", "setTitle", "setUrlCustomClickHandler", "handler", "setUrls", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private final Context context;
        private Integer iconResId;
        private String message;
        private Function0<Unit> negativeButtonListener;
        private String negativeButtonText;
        private Function0<Unit> positiveButtonListener;
        private String positiveButtonText;
        private String title;
        private Function1<? super String, Unit> urlCustomClickHandler;
        private ArrayList<String> urls;

        public Builder(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.context = r2;
            this.title = "";
            this.message = "";
            this.positiveButtonText = "";
            this.negativeButtonText = "";
            this.urls = new ArrayList();
        }

        public final Builder setTitle(String r2) {
            Intrinsics.checkNotNullParameter(r2, "title");
            this.title = r2;
            return this;
        }

        public final Builder setMessage(String r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            this.message = r2;
            return this;
        }

        public final Builder setIcon(int r2) {
            this.iconResId = Integer.valueOf(r2);
            return this;
        }

        public final Builder setPositiveButtonText(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.positiveButtonText = r2;
            return this;
        }

        public final Builder setNegativeButtonText(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.negativeButtonText = r2;
            return this;
        }

        public final Builder setPositiveButtonListener(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.positiveButtonListener = r2;
            return this;
        }

        public final Builder setNegativeButtonListener(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.negativeButtonListener = r2;
            return this;
        }

        public final Builder setUrls(ArrayList<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "urls");
            this.urls = r2;
            return this;
        }

        public final Builder setUrlCustomClickHandler(Function1<? super String, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "handler");
            this.urlCustomClickHandler = r2;
            return this;
        }

        public final PrivacyStatementDialog build() {
            return new PrivacyStatementDialog(this.context, this.title, this.message, this.iconResId, this.positiveButtonText, this.negativeButtonText, this.positiveButtonListener, this.negativeButtonListener, this.urls, this.urlCustomClickHandler, null);
        }
    }

    public /* synthetic */ PrivacyStatementDialog(Context r1, String r2, String r3, Integer r4, String r5, String r6, Function0 r7, Function0 r8, ArrayList r9, Function1 r10, DefaultConstructorMarker r11) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [T, android.widget.LinearLayout] */
    private PrivacyStatementDialog(Context r4, String r5, String r6, Integer r7, String r8, String r9, Function0<Unit> r10, Function0<Unit> r11, ArrayList<String> r12, Function1<? super String, Unit> r13) {
        this.title = r5;
        this.message = r6;
        this.iconResId = r7;
        this.positiveButtonText = r8;
        this.negativeButtonText = r9;
        this.positiveButtonListener = r10;
        this.negativeButtonListener = r11;
        this.urls = r12;
        this.customClickHandler = r13;
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        ?? r15 = new LinearLayout(r4);
        r15.setOrientation(1);
        PrivacyDialogMultiTextView r16 = new PrivacyDialogMultiTextView(r4, null, 2, null);
        OTextView r2 = r16.getContentTextView();
        if (r2 == null) goto L6;
        r2.setText(processMessage(r6, r4));
    L6:
        OTextView r17 = r16.getContentTextView();
        if (r17 == null) goto L10;
        r17.setMovementMethod(LinkMovementMethod.getInstance());
    L10:
        r15.addView(r16);
        r14.element = r15;
        OAlertDialogBuilder r18 = OAlertDialogBuilder.title$default(new OAlertDialogBuilder(r4).autoDismiss(false), r5, false, 2, null);
        if (r7 != null) goto L13;
        int r19 = R.drawable.ic_default_icon;
    L14:
        OAlertDialogBuilder r20 = OAlertDialogBuilder.horizontalButton$default(r18.icon(r19).imageSize(OUnitExtensionKt.cdp(r4, 56), OUnitExtensionKt.cdp(r4, 56)).body(new PrivacyStatementDialog$builder$1(r14)), false, 1, null).positiveButton(r8, new PrivacyStatementDialog$builder$2(this)).negativeButton(r9, new PrivacyStatementDialog$builder$3(this));
        this.mBuilder = r20;
        this.oAlertDialog = r20.build();
        return;
    L13:
        r19 = r7.intValue();
        goto L14
    }

    public static final /* synthetic */ Function1 access$getCustomClickHandler$p(PrivacyStatementDialog r0) {
        return r0.customClickHandler;
    }

    public static final /* synthetic */ Function0 access$getNegativeButtonListener$p(PrivacyStatementDialog r0) {
        return r0.negativeButtonListener;
    }

    public static final /* synthetic */ Function0 access$getPositiveButtonListener$p(PrivacyStatementDialog r0) {
        return r0.positiveButtonListener;
    }

    public final void show() {
        this.oAlertDialog.show();
    }

    public final void dismiss() {
        this.oAlertDialog.dismiss();
    }

    public final OAlertDialog getDialog() {
        return this.oAlertDialog;
    }

    private final SpannableString processMessage(String r22, Context r23) {
        String r8 = r22;
        int r9 = StringsKt.indexOf$default(r8, "{", 0, false, 6, null);
        int r10 = StringsKt.indexOf$default(r8, "}", 0, false, 6, null);
        int r11 = StringsKt.lastIndexOf$default(r8, "{", 0, false, 6, null);
        int r7 = StringsKt.lastIndexOf$default(r8, "}", 0, false, 6, null);
        ClickableSpan r12 = createClickableSpan(r23, (String) CollectionsKt.getOrNull(this.urls, 0));
        ClickableSpan r14 = createClickableSpan(r23, (String) CollectionsKt.getOrNull(this.urls, 1));
        if (r9 == (-1)) goto L13;
        if (r10 == (-1)) goto L13;
        if (r11 == (-1)) goto L13;
        if (r7 == (-1)) goto L13;
        String r1 = StringsKt.replace$default(StringsKt.replace$default(r22, "{", "", false, 4, null), "}", "", false, 4, null);
        if (r9 != r11) goto L11;
        if (r10 != r7) goto L11;
        return applyClickableSpan(r1, r12, r9, r10 - 1);
    L11:
        SpannableString r0 = new SpannableString(r1);
        r0.setSpan(r12, r9, r10 - 1, 33);
        r0.setSpan(r14, r11 - 2, r7 - 3, 33);
        return r0;
    L13:
        return new SpannableString(r8);
    }

    private final ClickableSpan createClickableSpan(final Context r2, final String r3) {
        return new AnonymousClass1(r3, this, r2);
    }

    private final SpannableString applyClickableSpan(String r1, ClickableSpan r2, int r3, int r4) {
        SpannableString r0 = new SpannableString(r1);
        r0.setSpan(r2, r3, r4, 33);
        return r0;
    }
}
