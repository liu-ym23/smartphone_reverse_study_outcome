package com.stepos.ailauncher.chat.activity;

import E4.FloatCardAction;
import E4.FloatCardBadgeBorder;
import E4.FloatCardContent;
import E4.FloatCardOption;
import E4.FloatCardPage;
import E4.FloatCardRequest;
import E4.FloatCardRiskBadge;
import E4.d;
import E4.e;
import E4.g;
import E4.m;
import E4.n;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import androidx.core.view.a0;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.services.core.AMapException;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.floatcard.api.FloatCardActionStyle;
import com.stepos.agentframework.floatcard.api.FloatCardOptionStyle;
import com.stepos.agentframework.floatcard.api.FloatCardRiskLevel;
import com.stepos.agentframework.floatcard.api.FloatCardScene;
import com.stepos.agentframework.floatcard.api.FloatCardSkipMode;
import com.stepos.agentframework.floatcard.api.SelectionMode;
import com.stepos.agentframework.floatcard.view.FloatCardContainerView;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler;
import com.stepos.ailauncher.floatcard.api.IFloatCardService;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AbstractC3297l;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.core.ability.AbilityType;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5680i;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 M2\u00020\u0001:\u0001NB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\u0003J#\u0010\u0011\u001a\u00020\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010\u0003J#\u0010\"\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\nH\u0002¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\nH\u0002¢\u0006\u0004\b%\u0010\u0003J\u0017\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u001aH\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u000eH\u0002¢\u0006\u0004\b*\u0010+J)\u00100\u001a\u00020\n*\u00020,2\u0006\u0010-\u001a\u00020\u000e2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\n0.H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u0002022\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b4\u00105J\u0019\u00108\u001a\u00020\n2\b\u00107\u001a\u0004\u0018\u000106H\u0014¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\nH\u0014¢\u0006\u0004\b:\u0010\u0003R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u0004\u0018\u00010I8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010K¨\u0006O"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/FloatCardDemoActivity;", "Lz5/a;", "<init>", "()V", "Landroid/view/ViewGroup;", ExifInterface.GPS_DIRECTION_TRUE, "()Landroid/view/ViewGroup;", "Landroid/view/View;", "Q", "()Landroid/view/View;", "LY8/t;", "l0", "k0", "", "", "LE4/n;", "values", "x0", "(Ljava/util/Map;)Ljava/lang/String;", "t0", "", "showInput", "s0", "(Z)V", "q0", "n0", "LE4/c;", "P", "()LE4/c;", "u0", "v0", "r0", "skip", "border", "o0", "(ZZ)V", "w0", "A0", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "m0", "(LE4/c;)V", "msg", "z0", "(Ljava/lang/String;)V", "Landroid/widget/LinearLayout;", "text", "Lkotlin/Function0;", "onClick", "N", "(Landroid/widget/LinearLayout;Ljava/lang/String;Lp9/a;)V", "", UxipConstants.f30680s, "i0", "(I)I", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "floatCardContainer", "Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "LG4/h;", "floatCardHost", "LG4/h;", "Landroid/widget/EditText;", "etBusinessText", "Landroid/widget/EditText;", "LE4/s;", "bottomInputView", "LE4/s;", "playingAudioId", "Ljava/lang/String;", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardService;", "j0", "()Lcom/stepos/ailauncher/floatcard/api/IFloatCardService;", "service", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FloatCardDemoActivity extends ActivityC6361a {

    @Deprecated
    public static final String BUSINESS_TYPE = "demo";

    @Deprecated
    public static final String CARD_ID = "demo:card";
    private static final a Companion = new a(null);

    @Deprecated
    public static final String TAG = "FloatCardDemo";
    private E4.s bottomInputView;
    private EditText etBusinessText;
    private FloatCardContainerView floatCardContainer;
    private G4.h floatCardHost;
    private String playingAudioId;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/FloatCardDemoActivity$a;", "", "<init>", "()V", "", "CARD_ID", "Ljava/lang/String;", "BUSINESS_TYPE", "TAG", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/chat/activity/FloatCardDemoActivity$b", "LE4/s;", "LY8/t;", "show", "()V", "hide", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements E4.s {
        final /* synthetic */ LinearLayout $bar;

        public b(LinearLayout linearLayout) {
            this.$bar = linearLayout;
        }

        @Override // E4.s
        public void hide() {
            this.$bar.setVisibility(8);
        }

        @Override // E4.s
        public void show() {
            this.$bar.setVisibility(0);
            androidx.core.view.N.e0(this.$bar);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ailauncher/chat/activity/FloatCardDemoActivity$c", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardEventHandler;", "LE4/d;", "event", "LE4/e;", "handle", "(LE4/d;Le9/c;)Ljava/lang/Object;", "", "businessType", "Ljava/lang/String;", "getBusinessType", "()Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements IFloatCardEventHandler {
        private final String businessType = FloatCardDemoActivity.BUSINESS_TYPE;

        public c() {
        }

        @Override // com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler
        public String getBusinessType() {
            return this.businessType;
        }

        @Override // com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler
        public Object handle(E4.d dVar, InterfaceC4014c<? super E4.e> interfaceC4014c) {
            if (!(dVar instanceof d.ActionClicked)) {
                if (dVar instanceof d.Submit) {
                    C4148a.d(FloatCardDemoActivity.TAG, "提交回调：" + FloatCardDemoActivity.this.x0(((d.Submit) dVar).a()), false, 4, null);
                    return e.a.INSTANCE;
                }
                if (dVar instanceof d.CardClicked) {
                    C4148a.d(FloatCardDemoActivity.TAG, "卡片被点击 cardId=" + ((d.CardClicked) dVar).getCardId(), false, 4, null);
                    return e.C0026e.INSTANCE;
                }
                if (!(dVar instanceof d.LinkClicked)) {
                    return dVar instanceof d.Exposed ? e.C0026e.INSTANCE : new e.Error("exception event", false, 2, null);
                }
                C4148a.d(FloatCardDemoActivity.TAG, "链接被点击 url=" + ((d.LinkClicked) dVar).getUrl(), false, 4, null);
                return e.C0026e.INSTANCE;
            }
            d.ActionClicked actionClicked = (d.ActionClicked) dVar;
            String string = actionClicked.getPayload().getString(UxipConstants.f30680s);
            if (string == null) {
                string = "";
            }
            C4148a.d(FloatCardDemoActivity.TAG, "点击回调 action=" + actionClicked.getActionId() + " value=" + string, false, 4, null);
            String actionId = actionClicked.getActionId();
            int iHashCode = actionId.hashCode();
            if (iHashCode != -358564674) {
                if (iHashCode != 100620374) {
                    if (iHashCode == 1769088428 && actionId.equals("option_pause")) {
                        FloatCardDemoActivity.this.playingAudioId = null;
                        return new e.Update(FloatCardDemoActivity.this.P());
                    }
                } else if (actionId.equals("demo_cancel")) {
                    return e.a.INSTANCE;
                }
            } else if (actionId.equals("option_play")) {
                FloatCardDemoActivity.this.playingAudioId = string;
                return new e.Update(FloatCardDemoActivity.this.P());
            }
            return e.C0026e.INSTANCE;
        }
    }

    public static final void O(InterfaceC5063a interfaceC5063a, View view) {
        interfaceC5063a.invoke();
    }

    public static final void R(EditText editText, FloatCardDemoActivity floatCardDemoActivity, View view) {
        String string;
        Editable text = editText.getText();
        String string2 = (text == null || (string = text.toString()) == null) ? null : La.H.D1(string).toString();
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() == 0) {
            floatCardDemoActivity.z0("请输入文字");
            return;
        }
        IFloatCardService iFloatCardServiceJ0 = floatCardDemoActivity.j0();
        if (iFloatCardServiceJ0 != null) {
            iFloatCardServiceJ0.pushVoiceText(CARD_ID, string2, true);
        }
        editText.setText("");
    }

    public static final androidx.core.view.a0 S(int i10, View v10, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(v10, "v");
        kotlin.jvm.internal.p.i(insets, "insets");
        v10.setPadding(v10.getPaddingLeft(), v10.getPaddingTop(), v10.getPaddingRight(), i10 + insets.f(a0.o.g() | a0.o.b()).f41980d);
        return insets;
    }

    public static final Y8.t U(FloatCardDemoActivity floatCardDemoActivity) {
        p0(floatCardDemoActivity, false, false, 3, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t V(FloatCardDemoActivity floatCardDemoActivity) {
        p0(floatCardDemoActivity, true, false, 2, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t W(FloatCardDemoActivity floatCardDemoActivity) {
        p0(floatCardDemoActivity, false, true, 1, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t X(FloatCardDemoActivity floatCardDemoActivity) {
        floatCardDemoActivity.w0();
        return Y8.t.f7040a;
    }

    public static final Y8.t Y(FloatCardDemoActivity floatCardDemoActivity) {
        floatCardDemoActivity.A0();
        return Y8.t.f7040a;
    }

    public static final Y8.t Z(FloatCardDemoActivity floatCardDemoActivity) {
        IFloatCardService iFloatCardServiceJ0 = floatCardDemoActivity.j0();
        if (iFloatCardServiceJ0 != null) {
            iFloatCardServiceJ0.dismissAll();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t a0(FloatCardDemoActivity floatCardDemoActivity) {
        floatCardDemoActivity.t0();
        return Y8.t.f7040a;
    }

    public static final Y8.t b0(FloatCardDemoActivity floatCardDemoActivity) {
        floatCardDemoActivity.s0(true);
        return Y8.t.f7040a;
    }

    public static final Y8.t c0(FloatCardDemoActivity floatCardDemoActivity) {
        floatCardDemoActivity.s0(false);
        return Y8.t.f7040a;
    }

    public static final Y8.t d0(FloatCardDemoActivity floatCardDemoActivity) {
        floatCardDemoActivity.q0();
        return Y8.t.f7040a;
    }

    public static final Y8.t e0(FloatCardDemoActivity floatCardDemoActivity) {
        floatCardDemoActivity.n0();
        return Y8.t.f7040a;
    }

    public static final Y8.t f0(FloatCardDemoActivity floatCardDemoActivity) {
        floatCardDemoActivity.u0();
        return Y8.t.f7040a;
    }

    public static final Y8.t g0(FloatCardDemoActivity floatCardDemoActivity) {
        floatCardDemoActivity.v0();
        return Y8.t.f7040a;
    }

    public static final Y8.t h0(FloatCardDemoActivity floatCardDemoActivity) {
        floatCardDemoActivity.r0();
        return Y8.t.f7040a;
    }

    private final int i0(int value) {
        return (int) ((value * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static /* synthetic */ void p0(FloatCardDemoActivity floatCardDemoActivity, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        floatCardDemoActivity.o0(z10, z11);
    }

    public static final CharSequence y0(Map.Entry entry) {
        kotlin.jvm.internal.p.i(entry, "<destruct>");
        String str = (String) entry.getKey();
        E4.n nVar = (E4.n) entry.getValue();
        if (nVar instanceof n.Text) {
            return str + "=" + ((n.Text) nVar).getValue();
        }
        if (!(nVar instanceof n.Selected)) {
            throw new NoWhenBranchMatchedException();
        }
        return str + "=" + Z8.F.A0(((n.Selected) nVar).a(), Const.STR_MART_COMMA, null, null, 0, null, null, 62, null);
    }

    private final void z0(String msg) {
        Toast.makeText(this, msg, 0).show();
    }

    public final void A0() {
        String string;
        EditText editText = this.etBusinessText;
        String string2 = null;
        if (editText == null) {
            kotlin.jvm.internal.p.A("etBusinessText");
            editText = null;
        }
        Editable text = editText.getText();
        if (text != null && (string = text.toString()) != null) {
            string2 = La.H.D1(string).toString();
        }
        if (string2 == null) {
            string2 = "";
        }
        String str = string2;
        if (str.length() == 0) {
            z0("请先输入业务文字");
            return;
        }
        IFloatCardService iFloatCardServiceJ0 = j0();
        if (iFloatCardServiceJ0 != null) {
            iFloatCardServiceJ0.update(CARD_ID, new FloatCardContent(C1172u.e(new FloatCardPage(str, "已通过 update 刷新", null, C1172u.e(new m.Text(str)), null, null, null, null, null, null, AMapException.CODE_AMAP_INSUFFICIENT_PRIVILEGES, null)), null, null, null, null, 30, null));
        }
    }

    public final void N(LinearLayout linearLayout, String str, final InterfaceC5063a<Y8.t> interfaceC5063a) {
        Button button = new Button(this);
        button.setText(str);
        button.setGravity(17);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.T0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatCardDemoActivity.O(interfaceC5063a, view);
            }
        });
        ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        }
        layoutParams2.topMargin = i0(8);
        button.setLayoutParams(layoutParams2);
        linearLayout.addView(button);
    }

    public final FloatCardContent P() {
        List<Pair> listP = C1173v.p(Y8.j.a("bgm_calm", "舒缓"), Y8.j.a("bgm_energetic", "动感"), Y8.j.a("bgm_epic", "史诗感"));
        ArrayList arrayList = new ArrayList(C1174w.x(listP, 10));
        for (Pair pair : listP) {
            String str = (String) pair.a();
            arrayList.add(new FloatCardOption(str, (String) pair.b(), kotlin.jvm.internal.p.d(str, this.playingAudioId), false, kotlin.jvm.internal.p.d(str, this.playingAudioId), 8, null));
        }
        return new FloatCardContent(C1172u.e(new FloatCardPage("选择你想要的配乐", null, null, null, C1172u.e(new g.Selection("bgm", null, arrayList, SelectionMode.Single, FloatCardOptionStyle.Audio, false, 34, null)), FloatCardSkipMode.Enabled, new FloatCardAction("skip", "跳过", null, null, 12, null), null, null, null, 910, null)), null, null, null, null, 30, null);
    }

    public final View Q() {
        final EditText editText = new EditText(this);
        editText.setHint("输入文字，确认后作为选项注入卡片");
        editText.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        Button button = new Button(this);
        button.setText(AbstractC3297l.LABEL_DIALOG_CONFIRM);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.Q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatCardDemoActivity.R(editText, this, view);
            }
        });
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundColor(-1052689);
        final int iI0 = i0(8);
        linearLayout.setPadding(iI0, iI0, iI0, iI0);
        linearLayout.setVisibility(8);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(editText);
        linearLayout.addView(button);
        androidx.core.view.N.u0(linearLayout, new androidx.core.view.A() { // from class: com.stepos.ailauncher.chat.activity.R0
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return FloatCardDemoActivity.S(iI0, view, a0Var);
            }
        });
        this.bottomInputView = new b(linearLayout);
        return linearLayout;
    }

    public final ViewGroup T() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        int iI0 = i0(16);
        linearLayout.setPadding(iI0, iI0, iI0, iI0);
        EditText editText = new EditText(this);
        editText.setHint("输入业务文字，下方按钮会把它带进卡片");
        editText.setText("帮我把这段会议纪要整理成待办");
        this.etBusinessText = editText;
        linearLayout.addView(editText);
        N(linearLayout, "单选样式（即时回调）", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.L0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatCardDemoActivity.a0(this.f24743a);
            }
        });
        N(linearLayout, "多选样式（显示输入）", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.Y0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatCardDemoActivity.b0(this.f24787a);
            }
        });
        N(linearLayout, "多选样式（不显示输入）", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.Z0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatCardDemoActivity.c0(this.f24790a);
            }
        });
        N(linearLayout, "多选样式（选项较多·滚动）", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.a1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatCardDemoActivity.d0(this.f24794a);
            }
        });
        N(linearLayout, "播放样式（Audio 试听）", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.b1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatCardDemoActivity.e0(this.f24798a);
            }
        });
        N(linearLayout, "文本输入样式", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.c1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatCardDemoActivity.f0(this.f24802a);
            }
        });
        N(linearLayout, "警告 + 操作按钮样式", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.M0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatCardDemoActivity.g0(this.f24746a);
            }
        });
        N(linearLayout, "多页样式（跨页累积）", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.N0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatCardDemoActivity.h0(this.f24751a);
            }
        });
        N(linearLayout, "授权场景（标题右侧风险标签）", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.O0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatCardDemoActivity.U(this.f24755a);
            }
        });
        N(linearLayout, "授权场景（风险标签 + 跳过）", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.P0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatCardDemoActivity.V(this.f24760a);
            }
        });
        N(linearLayout, "授权场景（风险标签带边框）", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.U0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatCardDemoActivity.W(this.f24774a);
            }
        });
        N(linearLayout, "业务文字 → 显示新卡片", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.V0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatCardDemoActivity.X(this.f24777a);
            }
        });
        N(linearLayout, "业务文字 → 更新当前卡片", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.W0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatCardDemoActivity.Y(this.f24780a);
            }
        });
        N(linearLayout, "关闭全部卡片", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.X0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FloatCardDemoActivity.Z(this.f24783a);
            }
        });
        ScrollView scrollView = new ScrollView(this);
        scrollView.addView(linearLayout);
        FloatCardContainerView floatCardContainerView = new FloatCardContainerView(this, null, 0, 6, null);
        floatCardContainerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.floatCardContainer = floatCardContainerView;
        View viewQ = Q();
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        frameLayout.addView(scrollView);
        FloatCardContainerView floatCardContainerView2 = this.floatCardContainer;
        if (floatCardContainerView2 == null) {
            kotlin.jvm.internal.p.A("floatCardContainer");
            floatCardContainerView2 = null;
        }
        frameLayout.addView(floatCardContainerView2);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout2.addView(frameLayout);
        linearLayout2.addView(viewQ);
        return linearLayout2;
    }

    public final IFloatCardService j0() {
        return (IFloatCardService) D5.a.INSTANCE.a(IFloatCardService.class);
    }

    public final void k0() {
        IFloatCardService iFloatCardServiceJ0 = j0();
        if (iFloatCardServiceJ0 != null) {
            iFloatCardServiceJ0.registerEventHandler(new c());
        }
    }

    public final void l0() {
        if (this.floatCardHost != null) {
            return;
        }
        FloatCardContainerView floatCardContainerView = this.floatCardContainer;
        if (floatCardContainerView == null) {
            kotlin.jvm.internal.p.A("floatCardContainer");
            floatCardContainerView = null;
        }
        G4.h hVar = new G4.h("float_card_demo_activity", 80, this, floatCardContainerView, Z8.X.d(FloatCardScene.Any), null, null, null, 224, null);
        this.floatCardHost = hVar;
        IFloatCardService iFloatCardServiceJ0 = j0();
        if (iFloatCardServiceJ0 != null) {
            iFloatCardServiceJ0.registerHost(hVar);
        }
    }

    public final void m0(FloatCardContent content) {
        IFloatCardService iFloatCardServiceJ0 = j0();
        if (iFloatCardServiceJ0 != null) {
            iFloatCardServiceJ0.show(new FloatCardRequest(CARD_ID, null, BUSINESS_TYPE, FloatCardScene.Any, content, null, null, 98, null));
        } else {
            z0("IFloatCardService 未注册");
        }
    }

    public final void n0() {
        this.playingAudioId = null;
        m0(P());
    }

    public final void o0(boolean skip, boolean border) {
        m0(new FloatCardContent(C1172u.e(new FloatCardPage("允许AmooAI编辑、播放和整理照片/视频/音频等多媒体文件", null, null, null, C1172u.e(new g.Selection("media_permission", null, C1173v.p(new FloatCardOption("deny", "拒绝", false, false, false, 28, null), new FloatCardOption("always", "始终允许", false, false, false, 28, null), new FloatCardOption("once", "仅本次允许", false, false, false, 28, null)), SelectionMode.Single, FloatCardOptionStyle.Plain, false, 34, null)), skip ? FloatCardSkipMode.Enabled : FloatCardSkipMode.Hidden, skip ? new FloatCardAction("skip", "跳过", null, null, 12, null) : null, null, null, new FloatCardRiskBadge(FloatCardRiskLevel.High, "高风险", null, border ? new FloatCardBadgeBorder(-38037, 1.0f, 0.0f, 4, null) : null, 4, null), 398, null)), null, null, null, null, 30, null));
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(T());
        l0();
        k0();
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        IFloatCardService iFloatCardServiceJ0;
        G4.h hVar = this.floatCardHost;
        if (hVar != null && (iFloatCardServiceJ0 = j0()) != null) {
            iFloatCardServiceJ0.unregisterHost(hVar);
        }
        this.floatCardHost = null;
        IFloatCardService iFloatCardServiceJ02 = j0();
        if (iFloatCardServiceJ02 != null) {
            iFloatCardServiceJ02.unregisterEventHandler(BUSINESS_TYPE);
        }
        super.onDestroy();
    }

    public final void q0() {
        C5680i c5680i = new C5680i(1, 8);
        ArrayList arrayList = new ArrayList(C1174w.x(c5680i, 10));
        Iterator<Integer> it = c5680i.iterator();
        while (it.hasNext()) {
            int iNextInt = ((Z8.M) it).nextInt();
            arrayList.add(new FloatCardOption("opt_" + iNextInt, "选项" + iNextInt, false, false, false, 28, null));
        }
        m0(new FloatCardContent(C1172u.e(new FloatCardPage("选择视频风格", "选项较多：列表超高时内部滚动，「确定」悬浮在底部", null, null, C1172u.e(new g.Selection("many_style", null, arrayList, SelectionMode.Multiple, FloatCardOptionStyle.Checkmark, false, 34, null)), FloatCardSkipMode.Enabled, new FloatCardAction("skip", "跳过", null, null, 12, null), null, null, null, 908, null)), null, null, new FloatCardAction("submit_many", "确定", FloatCardActionStyle.Primary, null, 8, null), null, 22, null));
    }

    public final void r0() {
        E4.s sVar;
        E4.s sVar2;
        List listE = C1172u.e(new g.Selection("source", null, C1173v.p(new FloatCardOption(ChatTracker.CONTENT_DOC, "文档", false, false, false, 28, null), new FloatCardOption(AbilityType.CHAT, "聊天记录", false, false, false, 28, null)), SelectionMode.Single, null, false, 50, null));
        E4.s sVar3 = this.bottomInputView;
        if (sVar3 == null) {
            kotlin.jvm.internal.p.A("bottomInputView");
            sVar = null;
        } else {
            sVar = sVar3;
        }
        FloatCardSkipMode floatCardSkipMode = FloatCardSkipMode.Enabled;
        Boolean bool = Boolean.TRUE;
        FloatCardPage floatCardPage = new FloatCardPage("第一步：选择来源（单选）", "点中即进入下一步；也可底部输入注入", null, null, listE, floatCardSkipMode, null, bool, sVar, null, 588, null);
        List listE2 = C1172u.e(new g.Selection("output", null, C1173v.p(new FloatCardOption("todo", "待办清单", false, false, false, 28, null), new FloatCardOption("summar1", "摘要", false, false, false, 28, null), new FloatCardOption("summar2", "摘要", false, false, false, 28, null), new FloatCardOption("summar3", "摘要", false, false, false, 28, null), new FloatCardOption("summar4", "摘要", false, false, false, 28, null), new FloatCardOption("summar5", "摘要", false, false, false, 28, null), new FloatCardOption("summar6", "摘要", false, false, false, 28, null), new FloatCardOption("summar7", "摘要", false, false, false, 28, null), new FloatCardOption("summar8", "摘要", false, false, false, 28, null), new FloatCardOption("summar9", "摘要", false, false, false, 28, null), new FloatCardOption("summary11", "摘要", false, false, false, 28, null), new FloatCardOption("summary12", "摘要", false, false, false, 28, null), new FloatCardOption("summary13", "摘要q00", false, false, false, 28, null)), SelectionMode.Multiple, null, false, 50, null));
        E4.s sVar4 = this.bottomInputView;
        if (sVar4 == null) {
            kotlin.jvm.internal.p.A("bottomInputView");
            sVar2 = null;
        } else {
            sVar2 = sVar4;
        }
        m0(new FloatCardContent(C1173v.p(floatCardPage, new FloatCardPage("第二步：选择输出（多选）", "勾选或底部输入注入后，点「完成」提交", null, null, listE2, null, null, bool, sVar2, null, 620, null)), null, null, new FloatCardAction("submit_flow", "完成", FloatCardActionStyle.Primary, null, 8, null), null, 22, null));
    }

    public final void s0(boolean showInput) {
        String str = showInput ? "多选：勾选或在底部输入框注入后，点「确定」统一提交；跳过则本页结果为 null" : "多选：勾选后点「确定」统一提交；跳过则本页结果为 null";
        List listE = C1172u.e(new g.Selection("video_style", null, C1173v.p(new FloatCardOption("clean", "简洁", false, false, false, 28, null), new FloatCardOption("energetic", "活力", false, false, false, 28, null), new FloatCardOption("cinematic", "电影感", false, false, false, 28, null)), SelectionMode.Multiple, FloatCardOptionStyle.Checkmark, false, 34, null));
        FloatCardSkipMode floatCardSkipMode = FloatCardSkipMode.Enabled;
        FloatCardAction floatCardAction = new FloatCardAction("skip", "跳过", null, null, 12, null);
        Boolean boolValueOf = Boolean.valueOf(showInput);
        E4.s sVar = this.bottomInputView;
        if (sVar == null) {
            kotlin.jvm.internal.p.A("bottomInputView");
            sVar = null;
        }
        m0(new FloatCardContent(C1172u.e(new FloatCardPage("选择视频风格", str, null, null, listE, floatCardSkipMode, floatCardAction, boolValueOf, sVar, null, 524, null)), null, null, new FloatCardAction("submit_style", "确定", FloatCardActionStyle.Primary, null, 8, null), null, 22, null));
    }

    public final void t0() {
        List listE = C1172u.e(new g.Selection("target_app", null, C1173v.p(new FloatCardOption(W4.b.TOOL_FEISHU, "飞书", false, false, false, 28, null), new FloatCardOption("browser", "浏览器", false, false, false, 28, null), new FloatCardOption("note", "备忘录", false, false, false, 28, null)), SelectionMode.Single, FloatCardOptionStyle.Plain, false, 34, null));
        FloatCardSkipMode floatCardSkipMode = FloatCardSkipMode.Hidden;
        Boolean bool = Boolean.TRUE;
        E4.s sVar = this.bottomInputView;
        if (sVar == null) {
            kotlin.jvm.internal.p.A("bottomInputView");
            sVar = null;
        }
        m0(new FloatCardContent(C1172u.e(new FloatCardPage("请选择目标应用", "单选：点中即回调；也可在底部输入框输入后点确认注入", null, null, listE, floatCardSkipMode, null, bool, sVar, null, 588, null)), null, null, null, null, 30, null));
    }

    public final void u0() {
        m0(new FloatCardContent(C1172u.e(new FloatCardPage("补充说明", null, "可输入文字或使用语音输入", null, C1172u.e(new g.TextInput("remark", null, "请输入备注…", null, 200, true, false, false, 202, null)), null, null, null, null, null, 1002, null)), null, null, new FloatCardAction("submit_remark", "提交", FloatCardActionStyle.Primary, null, 8, null), null, 22, null));
    }

    public final void v0() {
        m0(new FloatCardContent(C1172u.e(new FloatCardPage("确认取消任务？", null, null, C1173v.p(new m.Warning("取消后无法恢复，请谨慎操作"), new m.KeyValueList(C1173v.p(Y8.j.a("任务", "整理会议纪要"), Y8.j.a("进度", "30%")))), C1173v.p(new g.ActionButton("demo_confirm", "继续执行", FloatCardActionStyle.Secondary, false, false, null, 56, null), new g.ActionButton("demo_cancel", "取消任务", FloatCardActionStyle.Danger, false, false, null, 56, null)), null, null, null, null, null, 998, null)), null, null, null, null, 30, null));
    }

    public final void w0() {
        String string;
        EditText editText = this.etBusinessText;
        String string2 = null;
        if (editText == null) {
            kotlin.jvm.internal.p.A("etBusinessText");
            editText = null;
        }
        Editable text = editText.getText();
        if (text != null && (string = text.toString()) != null) {
            string2 = La.H.D1(string).toString();
        }
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() == 0) {
            string2 = "（未输入文字）";
        }
        String str = string2;
        m0(new FloatCardContent(C1172u.e(new FloatCardPage(str, "标题与下方内容均来自业务传入", null, C1172u.e(new m.Text(str)), C1172u.e(new g.TextInput("business_input", null, "可继续编辑", str, null, false, false, false, 242, null)), null, null, null, null, null, 996, null)), null, null, new FloatCardAction("submit_business", AbstractC3297l.LABEL_DIALOG_CONFIRM, FloatCardActionStyle.Primary, null, 8, null), null, 22, null));
    }

    public final String x0(Map<String, ? extends E4.n> values) {
        String strA0 = Z8.F.A0(values.entrySet(), "; ", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.activity.S0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return FloatCardDemoActivity.y0((Map.Entry) obj);
            }
        }, 30, null);
        return strA0.length() == 0 ? "（无内容）" : strA0;
    }
}
