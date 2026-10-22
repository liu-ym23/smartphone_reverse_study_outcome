package com.stepos.ailauncher.chat.activity;

import Z8.C1173v;
import android.R;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import com.stepos.agentframework.chatcore.session.C1939k0;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.chat.R$color;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.manager.ClawVMManager;
import com.stepos.ailauncher.chat.view.C2940q8;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import p7.AppUI;
import p9.InterfaceC5063a;
import t5.C5511d;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J'\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u001d\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J-\u0010\u001f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/stepos/ailauncher/chat/activity/PrivacyDetailActivity;", "Lz5/a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "C", "", "viewId", "titleRes", "", QueryAlgorithmBundle.KEY_CATEGORY, ExifInterface.LONGITUDE_EAST, "(IILjava/lang/String;)V", "G", "P", "Landroid/widget/TextView;", "tv", "N", "(Landroid/widget/TextView;)V", "L", "Lkotlin/Function0;", "onClick", "Landroid/text/style/ClickableSpan;", "I", "(Lp9/a;)Landroid/text/style/ClickableSpan;", "K", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(IILp9/a;)V", "Landroid/view/View;", "item", "Landroid/widget/ImageView;", "J", "(Landroid/view/View;)Landroid/widget/ImageView;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PrivacyDetailActivity extends ActivityC6361a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EVENT_WITHDRAW_CONSENT = "amoo_settings_withdraw_consent";
    private static final String TRACKER_PAGE_NAME = "amoo_settings";

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/PrivacyDetailActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Landroid/content/Intent;", "", "TRACKER_PAGE_NAME", "Ljava/lang/String;", "EVENT_WITHDRAW_CONSENT", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.activity.PrivacyDetailActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Intent a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            return new Intent(context, (Class<?>) PrivacyDetailActivity.class);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/chat/activity/PrivacyDetailActivity$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AppUI.TYPE_WIDGET, "LY8/t;", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", Const.SP_KEY_DEVICE_SENSORS, "updateDrawState", "(Landroid/text/TextPaint;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends ClickableSpan {
        final /* synthetic */ InterfaceC5063a<Y8.t> $onClick;

        public b(InterfaceC5063a<Y8.t> interfaceC5063a) {
            this.$onClick = interfaceC5063a;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            kotlin.jvm.internal.p.i(widget, "widget");
            this.$onClick.invoke();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            kotlin.jvm.internal.p.i(ds, "ds");
            super.updateDrawState(ds);
            ds.setColor(-15304705);
            ds.setUnderlineText(false);
        }
    }

    public static final void B(InterfaceC5063a interfaceC5063a, View view) {
        interfaceC5063a.invoke();
    }

    public static final Y8.t D(PrivacyDetailActivity privacyDetailActivity) {
        privacyDetailActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://static.stepaos.com/model/model-about.html")));
        return Y8.t.f7040a;
    }

    public static final void F(PrivacyDetailActivity privacyDetailActivity, String str, int i10, View view) {
        com.stepos.ailauncher.chat.util.j jVar = com.stepos.ailauncher.chat.util.j.INSTANCE;
        String string = privacyDetailActivity.getString(i10);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        jVar.c(privacyDetailActivity, str, string);
    }

    public static final void H(PrivacyDetailActivity privacyDetailActivity, View view) {
        privacyDetailActivity.P();
    }

    public static final Y8.t M(PrivacyDetailActivity privacyDetailActivity, String str) {
        com.stepos.ailauncher.chat.util.j.INSTANCE.c(privacyDetailActivity, "ls", str);
        return Y8.t.f7040a;
    }

    public static final Y8.t O(PrivacyDetailActivity privacyDetailActivity, String str, String str2) {
        com.stepos.ailauncher.chat.util.j.INSTANCE.c(privacyDetailActivity, str, str2);
        return Y8.t.f7040a;
    }

    public static final void Q(Dialog dialog, PrivacyDetailActivity privacyDetailActivity, View view) {
        dialog.dismiss();
        privacyDetailActivity.K();
    }

    public static final void R(Dialog dialog, View view) {
        dialog.dismiss();
    }

    public final void A(int viewId, int titleRes, final InterfaceC5063a<Y8.t> onClick) {
        View viewFindViewById = findViewById(viewId);
        ((TextView) viewFindViewById.findViewById(R$id.tvSettingTitle)).setText(titleRes);
        ((TextView) viewFindViewById.findViewById(R$id.tvSettingSummary)).setVisibility(8);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.z1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrivacyDetailActivity.B(onClick, view);
            }
        });
    }

    public final void C() {
        E(R$id.itemServiceAgreement, R$string.privacy_detail_service_agreement, "up");
        E(R$id.itemPrivacyPolicy, R$string.privacy_detail_privacy_policy, "pp");
        G();
        E(R$id.itemChildProtection, R$string.privacy_detail_child_protection, "pcpi");
        A(R$id.itemModelFiling, R$string.privacy_detail_model_filing, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.y1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return PrivacyDetailActivity.D(this.f24902a);
            }
        });
    }

    public final void E(int viewId, final int titleRes, final String category) {
        View viewFindViewById = findViewById(viewId);
        ((TextView) viewFindViewById.findViewById(R$id.tvSettingTitle)).setText(titleRes);
        ((TextView) viewFindViewById.findViewById(R$id.tvSettingSummary)).setVisibility(8);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.A1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrivacyDetailActivity.F(this.f24700a, category, titleRes, view);
            }
        });
    }

    public final void G() {
        View viewFindViewById = findViewById(R$id.itemRevokeConsent);
        ((TextView) viewFindViewById.findViewById(R$id.tvSettingTitle)).setText(R$string.privacy_detail_revoke_consent);
        ((TextView) viewFindViewById.findViewById(R$id.tvSettingSummary)).setVisibility(8);
        kotlin.jvm.internal.p.f(viewFindViewById);
        ImageView imageViewJ = J(viewFindViewById);
        if (imageViewJ != null) {
            imageViewJ.setVisibility(8);
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.B1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrivacyDetailActivity.H(this.f24705a, view);
            }
        });
    }

    public final ClickableSpan I(InterfaceC5063a<Y8.t> onClick) {
        return new b(onClick);
    }

    public final ImageView J(View item) {
        View childAt;
        if (!(item instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) item;
        int childCount = viewGroup.getChildCount();
        do {
            childCount--;
            if (-1 >= childCount) {
                return null;
            }
            childAt = viewGroup.getChildAt(childCount);
        } while (!(childAt instanceof ImageView));
        return (ImageView) childAt;
    }

    public final void K() {
        Object objB;
        kotlin.N.a(EVENT_WITHDRAW_CONSENT, TRACKER_PAGE_NAME, Z8.Q.f(Y8.j.a("action", "撤回同意")));
        Toast.makeText(this, R$string.privacy_detail_revoke_success, 0).show();
        AuthManager authManager = AuthManager.INSTANCE;
        authManager.N0(false);
        authManager.P0(false);
        authManager.R0(false);
        try {
            Result.Companion companion = Result.INSTANCE;
            Uri uri = Uri.parse("content://com.stepos.ability.voicewakeup.permission/consent");
            ContentValues contentValues = new ContentValues();
            com.stepos.ailauncher.foundation.account.f fVar = com.stepos.ailauncher.foundation.account.f.INSTANCE;
            contentValues.put("user_id", fVar.v() ? fVar.k() : "");
            contentValues.put("granted", (Integer) 0);
            Result.b(Integer.valueOf(getContentResolver().update(uri, contentValues, null, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        AuthManager.INSTANCE.T0(false);
        try {
            getContentResolver().notifyChange(C5511d.INSTANCE.a(), null);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.b(C4849c.a(th2));
        }
        ClawVMManager.INSTANCE.a().s(this);
        C1939k0.c();
        Function2.a(new PrivacyDetailActivity$performRevoke$3(null));
        try {
            objB = Result.b(Boolean.valueOf(AgentCacheSdk.INSTANCE.clearCache()));
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th3));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w("PrivacyRevoke", "AgentCacheSdk.clearCache failed", thE);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        Log.d("PrivacyRevoke", "AgentCacheSdk.clearCache delivered=" + ((Boolean) objB).booleanValue());
        Log.d("PrivacyRevoke", "[PERM-DIAG] before resetAllPermissionState");
        com.stepos.ailauncher.common.permission.G.INSTANCE.n0(this);
    }

    public final void L(TextView tv) {
        final String string = getString(R$string.privacy_detail_revoke_link_delete);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = getString(R$string.privacy_detail_revoke_consent_line, string);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        SpannableString spannableString = new SpannableString(string2);
        int iU0 = La.H.u0(string2, string, 0, false, 6, null);
        if (iU0 >= 0) {
            spannableString.setSpan(I(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.F1
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return PrivacyDetailActivity.M(this.f24727a, string);
                }
            }), iU0, string.length() + iU0, 33);
        }
        tv.setText(spannableString);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void N(TextView tv) {
        String string = tv.getText().toString();
        SpannableString spannableString = new SpannableString(string);
        String string2 = getString(R$string.privacy_detil_privacy_link_policy);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        String string3 = getString(R$string.privacy_detail_revoke_link_delete);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        for (Pair pair : C1173v.p(Y8.j.a(string2, "pp"), Y8.j.a(string3, "ls"))) {
            final String str = (String) pair.a();
            final String str2 = (String) pair.b();
            int iU0 = La.H.u0(string, str, 0, false, 6, null);
            if (iU0 >= 0) {
                spannableString.setSpan(I(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.E1
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return PrivacyDetailActivity.O(this.f24720a, str2, str);
                    }
                }), iU0, str.length() + iU0, 33);
            }
        }
        tv.setText(spannableString);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        tv.setHighlightColor(0);
    }

    public final void P() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R$layout.dialog_revoke_confirm);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -2);
            window.setGravity(80);
            float f10 = 16;
            window.getDecorView().setPadding((int) (getResources().getDisplayMetrics().density * f10), 0, (int) (f10 * getResources().getDisplayMetrics().density), (int) (24 * getResources().getDisplayMetrics().density));
        }
        int iC = androidx.core.content.a.c(this, R$color.chat_color_surface_container);
        int iC2 = androidx.core.content.a.c(this, R$color.chat_color_on_surface);
        int iC3 = androidx.core.content.a.c(this, R$color.chat_color_on_surface_variant);
        float f11 = getResources().getDisplayMetrics().density;
        View viewFindViewById = dialog.findViewById(R.id.content);
        if (viewFindViewById != null) {
            ViewGroup viewGroup = viewFindViewById instanceof ViewGroup ? (ViewGroup) viewFindViewById : null;
            View childAt = viewGroup != null ? viewGroup.getChildAt(0) : null;
            if (childAt != null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(iC);
                gradientDrawable.setCornerRadius(f11 * 16.0f);
                childAt.setBackground(gradientDrawable);
            }
        }
        TextView textView = (TextView) dialog.findViewById(R$id.tv_revoke_title);
        if (textView != null) {
            textView.setTextColor(iC2);
        }
        TextView textView2 = (TextView) dialog.findViewById(R$id.tv_revoke_message);
        if (textView2 != null) {
            textView2.setTextColor(iC3);
            N(textView2);
        }
        int i10 = R$id.tv_revoke_consent;
        TextView textView3 = (TextView) dialog.findViewById(i10);
        if (textView3 != null) {
            textView3.setTextColor(iC3);
        }
        View viewFindViewById2 = dialog.findViewById(i10);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        L((TextView) viewFindViewById2);
        ((TextView) dialog.findViewById(R$id.btn_revoke_confirm)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.C1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrivacyDetailActivity.Q(dialog, this, view);
            }
        });
        ((TextView) dialog.findViewById(R$id.btn_revoke_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.D1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrivacyDetailActivity.R(dialog, view);
            }
        });
        dialog.show();
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R$layout.activity_privacy_detail);
        C2940q8.d(C2940q8.INSTANCE, this, R$string.privacy_detail_title, null, 4, null);
        C();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
