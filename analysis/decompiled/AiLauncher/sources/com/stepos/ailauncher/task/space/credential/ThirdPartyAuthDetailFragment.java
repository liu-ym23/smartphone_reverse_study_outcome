package com.stepos.ailauncher.task.space.credential;

import Ua.C1060i;
import Z8.C1173v;
import Z8.C1174w;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ClickableSpan;
import android.view.C1398p;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.stepos.ailauncher.chat.view.C2851i7;
import com.stepos.ailauncher.task.R$drawable;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.R$string;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p7.AppUI;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import y7.G;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0010\u0018\u0000 V2\u00020\u0001:\u0002WXB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\nJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\nJ\u001d\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u001f\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u000fH\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b'\u0010(J'\u0010+\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020&H\u0002¢\u0006\u0004\b+\u0010,J\u0019\u0010.\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0004H\u0002¢\u0006\u0004\b0\u0010\u0003J\u0017\u00101\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b1\u0010\nJ\u0019\u00103\u001a\u00020&2\b\u00102\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b3\u00104J!\u00109\u001a\u00020\u00042\u0006\u00106\u001a\u0002052\b\u00108\u001a\u0004\u0018\u000107H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0004H\u0016¢\u0006\u0004\b;\u0010\u0003R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010F\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010\u0017R\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00190I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001b\u0010O\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010(R\u0014\u0010R\u001a\u00020<8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0014\u0010U\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010T¨\u0006Y"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/ThirdPartyAuthDetailFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "LY8/t;", "p0", "i0", "Lcom/stepos/ailauncher/task/space/credential/f;", "item", "C0", "(Lcom/stepos/ailauncher/task/space/credential/f;)V", "m0", ExifInterface.LONGITUDE_WEST, "", "text", "", "hasLink", "U", "(Ljava/lang/CharSequence;Z)V", "Y", "", "Lcom/stepos/ailauncher/task/space/credential/e;", "fields", "Z", "(Ljava/util/List;)V", "Lcom/stepos/ailauncher/task/space/credential/ThirdPartyAuthDetailFragment$b;", "row", "d0", "(Lcom/stepos/ailauncher/task/space/credential/ThirdPartyAuthDetailFragment$b;)V", "A0", "k0", "B0", "Landroid/widget/EditText;", "target", "visible", "o0", "(Landroid/widget/EditText;Z)V", "n0", "", "c0", "()Ljava/lang/String;", "credentialType", "result", "l0", "(Lcom/stepos/ailauncher/task/space/credential/f;Ljava/lang/String;Ljava/lang/String;)V", "iconUrl", "X", "(Ljava/lang/String;)V", "w0", "j0", "isoDate", "f0", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "Lr6/j;", "_binding", "Lr6/j;", "Ly7/E;", "backGlassHandle", "Ly7/E;", "topBlurHandle", "Landroid/app/Dialog;", "currentDialog", "Landroid/app/Dialog;", "credentialItem", "Lcom/stepos/ailauncher/task/space/credential/f;", "detailViewReported", "", "keyRows", "Ljava/util/List;", "vendorId$delegate", "LY8/h;", "h0", "vendorId", "g0", "()Lr6/j;", "binding", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "showsSheetDragHandle", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ThirdPartyAuthDetailFragment extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_VENDOR_ID = "vendor_id";
    private static final String AUTH_MODE_BOT_DM_CREDENTIALS = "bot_dm_credentials";
    private static final String AUTH_MODE_USER_APP_CREDENTIALS = "user_app_credentials";
    private static final float DISABLED_ALPHA = 0.4f;
    private static final float FALLBACK_ICON_PADDING_DP = 16.0f;
    private static final float FIRST_ROW_TOP_DP = 8.0f;
    public static final String NAV_TAG = "third_party_auth_detail";
    private static final float ROW_GAP_DP = 12.0f;
    private r6.j _binding;
    private y7.E backGlassHandle;
    private CredentialItem credentialItem;
    private Dialog currentDialog;
    private boolean detailViewReported;
    private final List<b> keyRows;
    private y7.E topBlurHandle;

    /* renamed from: vendorId$delegate, reason: from kotlin metadata */
    private final Y8.h vendorId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String MASK_PLACEHOLDER = La.D.P("*", 26);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/ThirdPartyAuthDetailFragment$a;", "", "<init>", "()V", "", "vendorId", "Lcom/stepos/ailauncher/task/space/credential/ThirdPartyAuthDetailFragment;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/ailauncher/task/space/credential/ThirdPartyAuthDetailFragment;", "NAV_TAG", "Ljava/lang/String;", "ARG_VENDOR_ID", "", "FALLBACK_ICON_PADDING_DP", "F", "MASK_PLACEHOLDER", "ROW_GAP_DP", "FIRST_ROW_TOP_DP", "DISABLED_ALPHA", "AUTH_MODE_USER_APP_CREDENTIALS", "AUTH_MODE_BOT_DM_CREDENTIALS", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.credential.ThirdPartyAuthDetailFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final ThirdPartyAuthDetailFragment a(String vendorId) {
            kotlin.jvm.internal.p.i(vendorId, "vendorId");
            ThirdPartyAuthDetailFragment thirdPartyAuthDetailFragment = new ThirdPartyAuthDetailFragment();
            thirdPartyAuthDetailFragment.setArguments(x0.c.a(Y8.j.a(ThirdPartyAuthDetailFragment.ARG_VENDOR_ID, vendorId)));
            return thirdPartyAuthDetailFragment;
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AuthNoticeProvider.values().length];
            try {
                iArr[AuthNoticeProvider.WECHAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AuthNoticeProvider.ALIPAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/task/space/credential/ThirdPartyAuthDetailFragment$d", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AppUI.TYPE_WIDGET, "LY8/t;", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", Const.SP_KEY_DEVICE_SENSORS, "updateDrawState", "(Landroid/text/TextPaint;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends ClickableSpan {
        final /* synthetic */ AuthNoticeProvider $provider;

        public d(AuthNoticeProvider authNoticeProvider) {
            this.$provider = authNoticeProvider;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            kotlin.jvm.internal.p.i(widget, "widget");
            try {
                ThirdPartyAuthDetailFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.$provider.getAgreementUrl())));
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(ThirdPartyAuthDetailFragment.this.requireContext(), R$string.task_space_operation_failed, 0).show();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            kotlin.jvm.internal.p.i(ds, "ds");
            ds.setColor(ds.linkColor);
            ds.setUnderlineText(false);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0010\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "s", "LY8/t;", "afterTextChanged", "(Landroid/text/Editable;)V", "", "text", "", "start", "count", "after", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            ThirdPartyAuthDetailFragment.this.B0();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence text, int start, int before, int count) {
        }
    }

    public ThirdPartyAuthDetailFragment() {
        super(R$layout.fragment_third_party_auth_detail);
        this.keyRows = new ArrayList();
        this.vendorId = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.credential.E
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ThirdPartyAuthDetailFragment.D0(this.f28947a);
            }
        });
    }

    public static final String D0(ThirdPartyAuthDetailFragment thirdPartyAuthDetailFragment) {
        Bundle arguments = thirdPartyAuthDetailFragment.getArguments();
        String string = arguments != null ? arguments.getString(ARG_VENDOR_ID) : null;
        return string == null ? "" : string;
    }

    public static /* synthetic */ void V(ThirdPartyAuthDetailFragment thirdPartyAuthDetailFragment, CharSequence charSequence, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        thirdPartyAuthDetailFragment.U(charSequence, z10);
    }

    public static final void a0(ThirdPartyAuthDetailFragment thirdPartyAuthDetailFragment, b bVar, View view) {
        thirdPartyAuthDetailFragment.d0(bVar);
    }

    public static final void b0(ThirdPartyAuthDetailFragment thirdPartyAuthDetailFragment, b bVar, View view) {
        thirdPartyAuthDetailFragment.A0(bVar);
    }

    public static final void e0(ThirdPartyAuthDetailFragment thirdPartyAuthDetailFragment, b bVar) {
        EditText etKeyInput = bVar.getBinding().etKeyInput;
        kotlin.jvm.internal.p.h(etKeyInput, "etKeyInput");
        thirdPartyAuthDetailFragment.o0(etKeyInput, true);
    }

    private final String f0(String isoDate) {
        if (isoDate == null || isoDate.length() == 0) {
            return "";
        }
        try {
            String str = ZonedDateTime.parse(isoDate).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            kotlin.jvm.internal.p.f(str);
            return str;
        } catch (Exception unused) {
            return La.K.R1(isoDate, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new ThirdPartyAuthDetailFragment$loadDetail$1(this, null), 3, null);
    }

    public static final void q0(ThirdPartyAuthDetailFragment thirdPartyAuthDetailFragment, View view) {
        thirdPartyAuthDetailFragment.x();
    }

    public static final void r0(ThirdPartyAuthDetailFragment thirdPartyAuthDetailFragment) {
        C2851i7 c2851i7 = C2851i7.INSTANCE;
        ImageView btnBack = thirdPartyAuthDetailFragment.g0().btnBack;
        kotlin.jvm.internal.p.h(btnBack, "btnBack");
        thirdPartyAuthDetailFragment.backGlassHandle = C2851i7.d(c2851i7, btnBack, false, Float.valueOf(22.0f), null, 8, null);
    }

    public static final void s0(ThirdPartyAuthDetailFragment thirdPartyAuthDetailFragment) {
        C2851i7 c2851i7 = C2851i7.INSTANCE;
        View topChromeBlur = thirdPartyAuthDetailFragment.g0().topChromeBlur;
        kotlin.jvm.internal.p.h(topChromeBlur, "topChromeBlur");
        thirdPartyAuthDetailFragment.topBlurHandle = C2851i7.f(c2851i7, topChromeBlur, false, G.a.f43886a.g(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.credential.F
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThirdPartyAuthDetailFragment.t0((A7.B) obj);
            }
        }, 2, null);
    }

    public static final Y8.t t0(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final void u0(ThirdPartyAuthDetailFragment thirdPartyAuthDetailFragment, View view) {
        thirdPartyAuthDetailFragment.w0();
    }

    public static final void v0(ThirdPartyAuthDetailFragment thirdPartyAuthDetailFragment, View view) {
        thirdPartyAuthDetailFragment.n0();
    }

    public static final Y8.t x0(ThirdPartyAuthDetailFragment thirdPartyAuthDetailFragment, CredentialItem credentialItem) {
        thirdPartyAuthDetailFragment.j0(credentialItem);
        return Y8.t.f7040a;
    }

    public static final Y8.t y0(CredentialItem credentialItem, ThirdPartyAuthDetailFragment thirdPartyAuthDetailFragment, String actionType) {
        kotlin.jvm.internal.p.i(actionType, "actionType");
        P p10 = P.INSTANCE;
        String vendorId = credentialItem.getVendorId();
        if (La.H.x0(vendorId)) {
            vendorId = thirdPartyAuthDetailFragment.h0();
        }
        p10.b(vendorId, actionType);
        return Y8.t.f7040a;
    }

    public static final void z0(ThirdPartyAuthDetailFragment thirdPartyAuthDetailFragment, DialogInterface dialogInterface) {
        thirdPartyAuthDetailFragment.currentDialog = null;
    }

    public final void A0(b row) {
        row.h(!row.getIsRevealed());
        k0(row);
    }

    public final void B0() {
        List<b> list = this.keyRows;
        boolean z10 = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((b) it.next()).c()) {
                    z10 = true;
                    break;
                }
            }
        }
        g0().btnSaveKey.setEnabled(z10);
        g0().btnSaveKey.setAlpha(z10 ? 1.0f : 0.4f);
    }

    public final void C0(CredentialItem item) {
        m0(item);
        g0().tvAppName.setText(item.getVendorName());
        X(item.getIconUrl());
        g0().tvAuthTime.setText(f0(item.getAuthorizedAt()));
        Y(item);
        W(item);
    }

    public final void U(CharSequence text, boolean hasLink) {
        LinearLayout layoutAuthNotices = g0().layoutAuthNotices;
        kotlin.jvm.internal.p.h(layoutAuthNotices, "layoutAuthNotices");
        r6.n nVarC = r6.n.c(getLayoutInflater(), layoutAuthNotices, false);
        kotlin.jvm.internal.p.h(nVarC, "inflate(...)");
        if (layoutAuthNotices.getChildCount() > 0) {
            ViewGroup.LayoutParams layoutParams = nVarC.b().getLayoutParams();
            kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) (8 * getResources().getDisplayMetrics().density);
        }
        nVarC.tvNotice.setText(text);
        if (hasLink) {
            nVarC.tvNotice.setMovementMethod(LinkMovementMethod.getInstance());
        }
        layoutAuthNotices.addView(nVarC.b());
    }

    public final void W(CredentialItem item) {
        int i10;
        g0().layoutAuthNotices.removeAllViews();
        String string = getString(R$string.third_party_auth_detail_key_notice);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        V(this, string, false, 2, null);
        AuthNoticeProvider authNoticeProviderA = AuthNoticeProvider.INSTANCE.a(item.getVendorId());
        if (authNoticeProviderA == null) {
            return;
        }
        int i11 = c.$EnumSwitchMapping$0[authNoticeProviderA.ordinal()];
        if (i11 == 1) {
            i10 = R$string.third_party_auth_detail_wechat_settings;
        } else {
            if (i11 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i10 = R$string.third_party_auth_detail_alipay_settings;
        }
        String string2 = getString(i10);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        V(this, string2, false, 2, null);
        String string3 = getString(R$string.third_party_auth_detail_agreement_intro);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        String string4 = getString(R$string.third_party_auth_detail_agreement_label);
        kotlin.jvm.internal.p.h(string4, "getString(...)");
        SpannableString spannableString = new SpannableString(string3 + string4);
        spannableString.setSpan(new d(authNoticeProviderA), string3.length(), spannableString.length(), 33);
        U(spannableString, true);
    }

    public final void X(String iconUrl) {
        ImageView ivAppIcon = g0().ivAppIcon;
        kotlin.jvm.internal.p.h(ivAppIcon, "ivAppIcon");
        if (iconUrl == null || iconUrl.length() == 0) {
            Glide.with(ivAppIcon).clear(ivAppIcon);
            int i10 = (int) (getResources().getDisplayMetrics().density * 16.0f);
            ivAppIcon.setPadding(i10, i10, i10, i10);
            ivAppIcon.setImageResource(R$drawable.ic_repair_third_party_auth);
            return;
        }
        ivAppIcon.setPadding(0, 0, 0, 0);
        RequestBuilder<Drawable> requestBuilderLoad = Glide.with(ivAppIcon).load(iconUrl);
        int i11 = R$drawable.ic_repair_third_party_auth;
        kotlin.jvm.internal.p.f(requestBuilderLoad.placeholder(i11).error(i11).centerCrop().into(ivAppIcon));
    }

    public final void Y(CredentialItem item) {
        List<CredentialField> listM;
        boolean z10 = kotlin.jvm.internal.p.d(item.getAuthMode(), AUTH_MODE_USER_APP_CREDENTIALS) || kotlin.jvm.internal.p.d(item.getAuthMode(), AUTH_MODE_BOT_DM_CREDENTIALS);
        List<CredentialField> listD = item.d();
        if (listD == null || listD.isEmpty()) {
            Map<String, String> mapH = item.h();
            if (mapH == null || mapH.isEmpty()) {
                listM = C1173v.m();
            } else {
                Map<String, String> mapH2 = item.h();
                ArrayList arrayList = new ArrayList(mapH2.size());
                for (Map.Entry<String, String> entry : mapH2.entrySet()) {
                    String key = entry.getKey();
                    arrayList.add(new CredentialField(key, key, entry.getValue()));
                }
                listM = arrayList;
            }
        } else {
            listM = item.d();
        }
        if (!z10 || listM.isEmpty()) {
            g0().layoutKeySection.setVisibility(8);
            g0().btnSaveKey.setVisibility(8);
        } else {
            g0().layoutKeySection.setVisibility(0);
            g0().btnSaveKey.setVisibility(0);
            Z(listM);
            B0();
        }
    }

    public final void Z(List<CredentialField> fields) {
        g0().layoutKeyFields.removeAllViews();
        this.keyRows.clear();
        int i10 = (int) (getResources().getDisplayMetrics().density * 12.0f);
        int i11 = (int) (getResources().getDisplayMetrics().density * 8.0f);
        int i12 = 0;
        for (Object obj : fields) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                C1173v.w();
            }
            CredentialField credentialField = (CredentialField) obj;
            r6.m mVarC = r6.m.c(getLayoutInflater(), g0().layoutKeyFields, false);
            kotlin.jvm.internal.p.h(mVarC, "inflate(...)");
            ViewGroup.LayoutParams layoutParams = mVarC.b().getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = i12 == 0 ? i11 : i10;
            }
            g0().layoutKeyFields.addView(mVarC.b());
            final b bVar = new b(credentialField, mVarC, false, false, 12, null);
            this.keyRows.add(bVar);
            mVarC.tvKeyLabel.setText(credentialField.getLabel());
            TextView tvKeyLabel = mVarC.tvKeyLabel;
            kotlin.jvm.internal.p.h(tvKeyLabel, "tvKeyLabel");
            tvKeyLabel.setVisibility(!La.H.x0(credentialField.getLabel()) ? 0 : 8);
            mVarC.layoutKeyField.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.credential.C
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ThirdPartyAuthDetailFragment.a0(this.f28943a, bVar, view);
                }
            });
            mVarC.btnToggleKey.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.credential.D
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ThirdPartyAuthDetailFragment.b0(this.f28945a, bVar, view);
                }
            });
            EditText etKeyInput = mVarC.etKeyInput;
            kotlin.jvm.internal.p.h(etKeyInput, "etKeyInput");
            etKeyInput.addTextChangedListener(new e());
            k0(bVar);
            i12 = i13;
        }
    }

    public final String c0() {
        List<b> list = this.keyRows;
        ArrayList<b> arrayList = new ArrayList();
        for (Object obj : list) {
            if (((b) obj).c()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        for (b bVar : arrayList) {
            String name = bVar.getField().getName();
            if (La.H.x0(name)) {
                name = bVar.getField().getLabel();
            }
            arrayList2.add(name);
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (!La.H.x0((String) obj2)) {
                arrayList3.add(obj2);
            }
        }
        return Z8.F.A0(arrayList3, Const.STR_MART_COMMA, null, null, 0, null, null, 62, null);
    }

    public final void d0(final b row) {
        if (row.getIsEditing()) {
            return;
        }
        row.g(true);
        row.h(false);
        row.getBinding().tvMaskedKey.setVisibility(8);
        row.getBinding().etKeyInput.setVisibility(0);
        Editable text = row.getBinding().etKeyInput.getText();
        if (text != null) {
            text.clear();
        }
        k0(row);
        row.getBinding().etKeyInput.requestFocus();
        row.getBinding().etKeyInput.post(new Runnable() { // from class: com.stepos.ailauncher.task.space.credential.x
            @Override // java.lang.Runnable
            public final void run() {
                ThirdPartyAuthDetailFragment.e0(this.f29009a, row);
            }
        });
        B0();
    }

    public final r6.j g0() {
        r6.j jVar = this._binding;
        kotlin.jvm.internal.p.f(jVar);
        return jVar;
    }

    public final String h0() {
        return (String) this.vendorId.getValue();
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    public final void j0(CredentialItem item) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new ThirdPartyAuthDetailFragment$performRevoke$1(item, this, null), 3, null);
    }

    public final void k0(b row) {
        String masked;
        String masked2;
        r6.m binding = row.getBinding();
        ImageView btnToggleKey = binding.btnToggleKey;
        kotlin.jvm.internal.p.h(btnToggleKey, "btnToggleKey");
        btnToggleKey.setVisibility(row.getIsEditing() || ((masked2 = row.getField().getMasked()) != null && !La.H.x0(masked2)) ? 0 : 8);
        binding.btnToggleKey.setImageResource(row.getIsRevealed() ? R$drawable.ic_auth_key_visible : R$drawable.ic_auth_key_hidden);
        if (row.getIsEditing()) {
            binding.etKeyInput.setTransformationMethod(row.getIsRevealed() ? null : PasswordTransformationMethod.getInstance());
            EditText editText = binding.etKeyInput;
            Editable text = editText.getText();
            editText.setSelection(text != null ? text.length() : 0);
            return;
        }
        TextView textView = binding.tvMaskedKey;
        if (row.getIsRevealed()) {
            masked = row.getField().getMasked();
            if (masked == null) {
                masked = "";
            }
        } else {
            masked = MASK_PLACEHOLDER;
        }
        textView.setText(masked);
    }

    public final void l0(CredentialItem item, String credentialType, String result) {
        if (La.H.x0(credentialType)) {
            return;
        }
        P p10 = P.INSTANCE;
        String vendorId = item.getVendorId();
        if (La.H.x0(vendorId)) {
            vendorId = h0();
        }
        p10.d(vendorId, credentialType, result);
    }

    public final void m0(CredentialItem item) {
        if (this.detailViewReported) {
            return;
        }
        this.detailViewReported = true;
        P p10 = P.INSTANCE;
        String vendorId = item.getVendorId();
        if (La.H.x0(vendorId)) {
            vendorId = h0();
        }
        p10.e(vendorId, Q.a(item), Q.c(item.getAuthorizedAt(), null, 2, null), Q.c(item.getLastUsedAt(), null, 2, null));
    }

    public final void n0() {
        r6.m binding;
        EditText editText;
        String masked;
        CredentialItem credentialItem = this.credentialItem;
        if (credentialItem == null || this.keyRows.isEmpty()) {
            return;
        }
        String strC0 = c0();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (b bVar : this.keyRows) {
            if (bVar.c()) {
                masked = bVar.f();
            } else {
                masked = bVar.getField().getMasked();
                if (masked == null) {
                    masked = "";
                }
            }
            if (La.H.x0(masked)) {
                Toast.makeText(requireContext(), R$string.third_party_auth_detail_save_incomplete, 0).show();
                l0(credentialItem, strC0, "failed");
                return;
            }
            linkedHashMap.put(bVar.getField().getName(), masked);
        }
        b bVar2 = (b) Z8.F.s0(this.keyRows);
        if (bVar2 != null && (binding = bVar2.getBinding()) != null && (editText = binding.etKeyInput) != null) {
            o0(editText, false);
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new ThirdPartyAuthDetailFragment$saveKeys$2(credentialItem, linkedHashMap, this, strC0, null), 3, null);
    }

    public final void o0(EditText target, boolean visible) {
        InputMethodManager inputMethodManager = (InputMethodManager) requireContext().getSystemService(InputMethodManager.class);
        if (visible) {
            inputMethodManager.showSoftInput(target, 1);
        } else {
            inputMethodManager.hideSoftInputFromWindow(target.getWindowToken(), 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.currentDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.currentDialog = null;
        C2851i7 c2851i7 = C2851i7.INSTANCE;
        c2851i7.h(this.backGlassHandle);
        this.backGlassHandle = null;
        c2851i7.h(this.topBlurHandle);
        this.topBlurHandle = null;
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this._binding = r6.j.a(view);
        p0();
        i0();
    }

    public final void p0() {
        g0().btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.credential.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ThirdPartyAuthDetailFragment.q0(this.f29005a, view);
            }
        });
        g0().btnBack.post(new Runnable() { // from class: com.stepos.ailauncher.task.space.credential.y
            @Override // java.lang.Runnable
            public final void run() {
                ThirdPartyAuthDetailFragment.r0(this.f29011a);
            }
        });
        g0().topChromeBlur.post(new Runnable() { // from class: com.stepos.ailauncher.task.space.credential.z
            @Override // java.lang.Runnable
            public final void run() {
                ThirdPartyAuthDetailFragment.s0(this.f29012a);
            }
        });
        g0().btnRevoke.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.credential.A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ThirdPartyAuthDetailFragment.u0(this.f28941a, view);
            }
        });
        g0().btnSaveKey.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.credential.B
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ThirdPartyAuthDetailFragment.v0(this.f28942a, view);
            }
        });
    }

    public final void w0() {
        final CredentialItem credentialItem = this.credentialItem;
        if (credentialItem == null) {
            return;
        }
        P p10 = P.INSTANCE;
        String vendorId = credentialItem.getVendorId();
        if (La.H.x0(vendorId)) {
            vendorId = h0();
        }
        p10.a(vendorId, Q.a(credentialItem));
        Dialog dialogK = r.k(this, credentialItem.getVendorName(), new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.credential.G
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ThirdPartyAuthDetailFragment.x0(this.f28948a, credentialItem);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.credential.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThirdPartyAuthDetailFragment.y0(credentialItem, this, (String) obj);
            }
        });
        if (dialogK != null) {
            dialogK.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stepos.ailauncher.task.space.credential.w
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    ThirdPartyAuthDetailFragment.z0(this.f29008a, dialogInterface);
                }
            });
        } else {
            dialogK = null;
        }
        this.currentDialog = dialogK;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0019R\"\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/ThirdPartyAuthDetailFragment$b;", "", "Lcom/stepos/ailauncher/task/space/credential/e;", "field", "Lr6/m;", "binding", "", "isEditing", "isRevealed", "<init>", "(Lcom/stepos/ailauncher/task/space/credential/e;Lr6/m;ZZ)V", "", "f", "()Ljava/lang/String;", "c", "()Z", "Lcom/stepos/ailauncher/task/space/credential/e;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/task/space/credential/e;", "Lr6/m;", Const.INTENT_KEY_APIKEY, "()Lr6/m;", "Z", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_COMMAND, "(Z)V", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b {
        private final r6.m binding;
        private final CredentialField field;
        private boolean isEditing;
        private boolean isRevealed;

        public b(CredentialField field, r6.m binding, boolean z10, boolean z11) {
            kotlin.jvm.internal.p.i(field, "field");
            kotlin.jvm.internal.p.i(binding, "binding");
            this.field = field;
            this.binding = binding;
            this.isEditing = z10;
            this.isRevealed = z11;
        }

        /* renamed from: a, reason: from getter */
        public final r6.m getBinding() {
            return this.binding;
        }

        /* renamed from: b, reason: from getter */
        public final CredentialField getField() {
            return this.field;
        }

        public final boolean c() {
            return this.isEditing && f().length() > 0;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsEditing() {
            return this.isEditing;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsRevealed() {
            return this.isRevealed;
        }

        public final String f() {
            String string;
            Editable text = this.binding.etKeyInput.getText();
            String string2 = (text == null || (string = text.toString()) == null) ? null : La.H.D1(string).toString();
            return string2 == null ? "" : string2;
        }

        public final void g(boolean z10) {
            this.isEditing = z10;
        }

        public final void h(boolean z10) {
            this.isRevealed = z10;
        }

        public /* synthetic */ b(CredentialField credentialField, r6.m mVar, boolean z10, boolean z11, int i10, kotlin.jvm.internal.i iVar) {
            this(credentialField, mVar, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? false : z11);
        }
    }
}
