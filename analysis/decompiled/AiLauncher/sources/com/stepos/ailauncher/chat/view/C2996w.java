package com.stepos.ailauncher.chat.view;

import O6.ExternalDeviceInfo;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.view.C2996w;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import p7.AppUI;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a1\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a!\u0010\u000b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\f\u001a+\u0010\r\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u0011\u0010\u000f\u001a\u00020\u0007*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0011\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Landroid/view/View;", "", "deviceId", "agentType", "deviceName", "", com.stepos.ailauncher.sla.G.NETWORK_ONLINE, "LY8/t;", "c", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "agentName", Const.INTENT_KEY_UMID, "(Landroid/view/View;Ljava/lang/String;Z)V", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/view/View;)V", "e", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.w, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2996w {

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/chat/view/w$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AppUI.TYPE_WIDGET, "LY8/t;", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", Const.SP_KEY_DEVICE_SENSORS, "updateDrawState", "(Landroid/text/TextPaint;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.w$a */
    public static final class a extends ClickableSpan {
        final /* synthetic */ String $agentType;
        final /* synthetic */ String $deviceId;
        final /* synthetic */ String $deviceName;
        final /* synthetic */ View $this_applyCrossDeviceAuthGuide;
        final /* synthetic */ IExternalAgentUiService $ui;

        public a(View view, IExternalAgentUiService iExternalAgentUiService, String str, String str2, String str3) {
            this.$this_applyCrossDeviceAuthGuide = view;
            this.$ui = iExternalAgentUiService;
            this.$agentType = str;
            this.$deviceId = str2;
            this.$deviceName = str3;
        }

        public static final Y8.t b(View view, String str, String str2, String str3) {
            C2996w.e(view, str, str2, str3);
            return Y8.t.f7040a;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            kotlin.jvm.internal.p.i(widget, "widget");
            View rootView = this.$this_applyCrossDeviceAuthGuide.getRootView();
            ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
            if (viewGroup == null) {
                return;
            }
            IExternalAgentUiService iExternalAgentUiService = this.$ui;
            final String str = this.$agentType;
            final View view = this.$this_applyCrossDeviceAuthGuide;
            final String str2 = this.$deviceId;
            final String str3 = this.$deviceName;
            iExternalAgentUiService.showCrossDeviceAuthDialog(viewGroup, str, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.v
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return C2996w.a.b(view, str2, str, str3);
                }
            });
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            kotlin.jvm.internal.p.i(ds, "ds");
            ds.setColor(-14652161);
            ds.setUnderlineText(true);
        }
    }

    public static final void b(View view, String str, String str2, String str3) {
        TextView textView;
        IExternalAgentUiService iExternalAgentUiService = (IExternalAgentUiService) D5.a.INSTANCE.a(IExternalAgentUiService.class);
        if (iExternalAgentUiService == null || iExternalAgentUiService.isCrossDeviceAuthorized(str2) || (textView = (TextView) view.findViewById(R$id.tv_subtitle)) == null) {
            return;
        }
        String string = view.getContext().getString(R$string.chat_external_agent_unauthorized);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = view.getContext().getString(R$string.chat_external_agent_unauthorized_action);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        SpannableString spannableString = new SpannableString(string);
        int iU0 = La.H.u0(string, string2, 0, false, 6, null);
        if (iU0 >= 0) {
            spannableString.setSpan(new a(view, iExternalAgentUiService, str2, str, str3), iU0, string2.length() + iU0, 33);
        }
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
    }

    public static final void c(View view, String deviceId, String agentType, String deviceName, boolean z10) {
        View viewFindViewById;
        kotlin.jvm.internal.p.i(view, "<this>");
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agentType, "agentType");
        kotlin.jvm.internal.p.i(deviceName, "deviceName");
        if (La.H.x0(deviceId) || La.H.x0(deviceName) || (viewFindViewById = view.findViewById(R$id.title_dropdown_area)) == null) {
            return;
        }
        boolean z11 = false;
        viewFindViewById.setVisibility(0);
        viewFindViewById.setOnClickListener(null);
        viewFindViewById.setClickable(false);
        View viewFindViewById2 = view.findViewById(R$id.iv_title_dropdown);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        View viewFindViewById3 = view.findViewById(R$id.tv_title);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setVisibility(8);
        }
        TextView textView = (TextView) view.findViewById(R$id.tv_title_all);
        if (textView != null) {
            textView.setText(textView.getContext().getString(R$string.chat_external_agent_title_prefix, deviceName));
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextSize(2, 15.0f);
            textView.setTypeface(Typeface.create(textView.getTypeface(), 500, false), 0);
            textView.setLineHeight((int) (16 * textView.getResources().getDisplayMetrics().scaledDensity));
            textView.setGravity(17);
        }
        TextView textView2 = (TextView) view.findViewById(R$id.tv_subtitle);
        if (textView2 != null) {
            textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(z10 ? R$drawable.dot_status_online_chat : R$drawable.dot_status_offline_chat, 0, 0, 0);
            textView2.setCompoundDrawablePadding((int) (4 * textView2.getResources().getDisplayMetrics().density));
            textView2.setText(z10 ? textView2.getContext().getString(R$string.chat_external_agent_subtitle_online) : textView2.getContext().getString(R$string.chat_external_agent_subtitle_offline));
        }
        TextView textView3 = (TextView) view.findViewById(R$id.tv_greeting);
        if (textView3 != null) {
            textView3.setText(deviceName);
        }
        b(view, deviceId, agentType, deviceName);
        IExternalAgentUiService iExternalAgentUiService = (IExternalAgentUiService) D5.a.INSTANCE.a(IExternalAgentUiService.class);
        boolean z12 = (iExternalAgentUiService == null || iExternalAgentUiService.isCrossDeviceAuthorized(agentType)) ? false : true;
        ChatView chatView = (ChatView) view.findViewById(R$id.agentChatView);
        if (chatView != null) {
            if (!z10 && !z12) {
                z11 = true;
            }
            chatView.P3(z11);
        }
    }

    public static final void d(View view, String agentName, boolean z10) {
        View viewFindViewById;
        kotlin.jvm.internal.p.i(view, "<this>");
        kotlin.jvm.internal.p.i(agentName, "agentName");
        if (La.H.x0(agentName) || (viewFindViewById = view.findViewById(R$id.title_dropdown_area)) == null) {
            return;
        }
        viewFindViewById.setVisibility(0);
        viewFindViewById.setOnClickListener(null);
        viewFindViewById.setClickable(false);
        View viewFindViewById2 = view.findViewById(R$id.iv_title_dropdown);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        View viewFindViewById3 = view.findViewById(R$id.tv_title);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setVisibility(8);
        }
        TextView textView = (TextView) view.findViewById(R$id.tv_title_all);
        if (textView != null) {
            textView.setText(textView.getContext().getString(R$string.chat_external_agent_title_prefix, agentName));
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextSize(2, 15.0f);
            textView.setTypeface(Typeface.create(textView.getTypeface(), 500, false), 0);
            textView.setLineHeight((int) (16 * textView.getResources().getDisplayMetrics().scaledDensity));
            textView.setGravity(17);
        }
        TextView textView2 = (TextView) view.findViewById(R$id.tv_subtitle);
        if (textView2 != null) {
            textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(z10 ? R$drawable.dot_status_online_chat : R$drawable.dot_status_offline_chat, 0, 0, 0);
            textView2.setCompoundDrawablePadding((int) (4 * textView2.getResources().getDisplayMetrics().density));
            textView2.setText(z10 ? textView2.getContext().getString(R$string.chat_external_agent_subtitle_online) : textView2.getContext().getString(R$string.chat_external_agent_subtitle_offline));
        }
        TextView textView3 = (TextView) view.findViewById(R$id.tv_greeting);
        if (textView3 != null) {
            textView3.setText(agentName);
        }
    }

    public static final void e(final View view, final String deviceId, final String agentType, final String deviceName) {
        List<ExternalDeviceInfo> listA;
        Object next;
        kotlin.jvm.internal.p.i(view, "<this>");
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agentType, "agentType");
        kotlin.jvm.internal.p.i(deviceName, "deviceName");
        if (La.H.x0(deviceId)) {
            return;
        }
        String deviceName2 = null;
        if (La.H.x0(deviceName)) {
            deviceName = null;
        }
        if (deviceName == null) {
            O6.i iVarC = O6.a.INSTANCE.c();
            if (iVarC != null && (listA = iVarC.a()) != null) {
                Iterator<T> it = listA.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    ExternalDeviceInfo externalDeviceInfo = (ExternalDeviceInfo) next;
                    if (kotlin.jvm.internal.p.d(externalDeviceInfo.getDeviceId(), deviceId) && kotlin.jvm.internal.p.d(externalDeviceInfo.getAgent(), agentType)) {
                        break;
                    }
                }
                ExternalDeviceInfo externalDeviceInfo2 = (ExternalDeviceInfo) next;
                if (externalDeviceInfo2 != null) {
                    deviceName2 = externalDeviceInfo2.getDeviceName();
                }
            }
            deviceName = deviceName2 == null ? "" : deviceName2;
        }
        if (La.H.x0(deviceName)) {
            return;
        }
        IExternalAgentBindService iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class);
        if (iExternalAgentBindService == null) {
            c(view, deviceId, agentType, deviceName, false);
        } else {
            iExternalAgentBindService.queryDeviceAgentOnline(deviceId, agentType, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.u
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return C2996w.g(view, deviceId, agentType, deviceName, (Result) obj);
                }
            });
        }
    }

    public static /* synthetic */ void f(View view, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = "";
        }
        e(view, str, str2, str3);
    }

    public static final Y8.t g(View view, String str, String str2, String str3, Result result) {
        Object value = result.getValue();
        Boolean bool = Boolean.FALSE;
        if (Result.g(value)) {
            value = bool;
        }
        c(view, str, str2, str3, ((Boolean) value).booleanValue());
        return Y8.t.f7040a;
    }

    public static final void h(View view) {
        kotlin.jvm.internal.p.i(view, "<this>");
        View viewFindViewById = view.findViewById(R$id.title_dropdown_area);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        View viewFindViewById2 = view.findViewById(R$id.tv_title);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(4);
        }
        TextView textView = (TextView) view.findViewById(R$id.tv_subtitle);
        if (textView != null) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
            textView.setText("");
        }
        TextView textView2 = (TextView) view.findViewById(R$id.tv_greeting);
        if (textView2 != null) {
            textView2.setText(view.getContext().getString(R$string.agent_task_home_greet_text));
        }
        ChatView chatView = (ChatView) view.findViewById(R$id.agentChatView);
        if (chatView != null) {
            chatView.P3(false);
        }
    }
}
