package P5;

import La.D;
import La.H;
import N5.n;
import T5.C1017a;
import T5.w;
import T5.x;
import Y8.j;
import Y8.t;
import Z8.C1173v;
import Z8.F;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiLiveClickReceiver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 62\u00020\u0001:\u00017B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b!\u0010\"J%\u0010&\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002¢\u0006\u0004\b&\u0010'J)\u0010)\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010(\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b)\u0010*J!\u0010,\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010+\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R0\u00104\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020201j\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u000202`38\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u00068"}, d2 = {"LP5/e;", "LN5/d;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/FrameLayout;", "container", "LY8/t;", ExifInterface.LONGITUDE_EAST, "(Landroid/widget/FrameLayout;)V", "LN5/n;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "C", "(LN5/n;)V", "LT5/x;", "row", "LP5/f;", "item", "LP5/b;", "a0", "(LT5/x;LP5/f;LP5/b;)V", "LP5/g;", "amount", "Y", "(LT5/x;LP5/g;)V", "", "text", "", "c0", "(Ljava/lang/String;)Ljava/lang/CharSequence;", "", "LP5/h;", "fields", "Z", "(LT5/x;Ljava/util/List;)V", D6.a.KEY_TASK_STATUS, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(LT5/x;LP5/f;Ljava/lang/Integer;)V", "itemId", "b0", "(Ljava/lang/String;Ljava/lang/String;)V", "LT5/w;", "containerBinding", "LT5/w;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "lastConfirmSendAt", "Ljava/util/HashMap;", "Companion", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e extends N5.d {
    private static final String ACTION_SHARE_WAKE = "com.stepos.ailauncher.action.SHARE_WAKE";
    private static final float AMOUNT_DECIMAL_SIZE_SP = 14.0f;
    private static final float AMOUNT_INTEGER_SIZE_SP = 22.0f;
    private static final long CONFIRM_DEBOUNCE_MS = 1500;
    private static final String EXTRA_AUTO_SEND = "extra_auto_send";
    private w containerBinding;
    private final HashMap<String, Long> lastConfirmSendAt;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
        this.lastConfirmSendAt = new HashMap<>();
    }

    public static final void W(e eVar, String str, OrderActionItem orderActionItem, View view) {
        eVar.R("confirm");
        eVar.b0(str, orderActionItem.getItemId());
    }

    public static final void X(e eVar, OrderActionItem orderActionItem, String str, String str2, View view) {
        eVar.R(M5.e.ACTION_JUMP_APP);
        R5.b bVar = R5.b.INSTANCE;
        String itemId = orderActionItem.getItemId();
        if (itemId == null) {
            itemId = "null";
        }
        bVar.c("view.orderAction.click", j.a("taskId", itemId), j.a(AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, str == null ? "null" : str), j.a("webLink", str2 != null ? str2 : "null"));
        N5.d.G(eVar, str, str2, null, false, false, false, 60, null);
    }

    @Override // N5.d
    public void C(n model) {
        p.i(model, "model");
        if (model instanceof b) {
            w wVar = this.containerBinding;
            if (wVar == null) {
                p.A("containerBinding");
                wVar = null;
            }
            LinearLayout llOrderActionContainer = wVar.llOrderActionContainer;
            p.h(llOrderActionContainer, "llOrderActionContainer");
            llOrderActionContainer.removeAllViews();
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
            b bVar = (b) model;
            int i10 = 0;
            for (Object obj : bVar.b()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                OrderActionItem orderActionItem = (OrderActionItem) obj;
                x xVarC = x.c(layoutInflaterFrom, llOrderActionContainer, false);
                p.h(xVarC, "inflate(...)");
                if (i10 == 0) {
                    ViewGroup.LayoutParams layoutParams = xVarC.b().getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                    if (marginLayoutParams != null) {
                        marginLayoutParams.topMargin = 0;
                        xVarC.b().setLayoutParams(marginLayoutParams);
                    }
                }
                a0(xVarC, orderActionItem, bVar);
                llOrderActionContainer.addView(xVarC.b());
                i10 = i11;
            }
        }
    }

    @Override // N5.d
    public void E(FrameLayout container) {
        p.i(container, "container");
        w wVarB = w.b(LayoutInflater.from(getContext()), container, true);
        p.h(wVarB, "inflate(...)");
        this.containerBinding = wVarB;
    }

    public final void V(x row, final OrderActionItem item, Integer taskStatus) {
        final String appLink;
        final String webLink;
        OrderActionButton orderActionButton = (OrderActionButton) F.s0(item.a());
        if (taskStatus != null && taskStatus.intValue() == 10) {
            final String strD = N5.j.INSTANCE.d(orderActionButton != null ? orderActionButton.getLabel() : null);
            if (strD == null) {
                strD = "确认下单";
            }
            row.btnOrderAction.setVisibility(0);
            row.btnOrderAction.setText(strD);
            row.btnOrderAction.setOnClickListener(new View.OnClickListener() { // from class: P5.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.W(this.f5374a, strD, item, view);
                }
            });
            return;
        }
        if (orderActionButton == null || (appLink = orderActionButton.getAppLink()) == null || H.x0(appLink)) {
            appLink = null;
        }
        if (orderActionButton == null || (webLink = orderActionButton.getWebLink()) == null || H.x0(webLink)) {
            webLink = null;
        }
        if (appLink == null && webLink == null) {
            row.btnOrderAction.setVisibility(8);
            row.btnOrderAction.setOnClickListener(null);
            return;
        }
        row.btnOrderAction.setVisibility(0);
        TextView textView = row.btnOrderAction;
        String strD2 = N5.j.INSTANCE.d(orderActionButton != null ? orderActionButton.getLabel() : null);
        if (strD2 == null) {
            strD2 = "去支付";
        }
        textView.setText(strD2);
        row.btnOrderAction.setOnClickListener(new View.OnClickListener() { // from class: P5.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.X(this.f5377a, item, appLink, webLink, view);
            }
        });
    }

    public final void Y(x row, OrderAmount amount) {
        String strD = N5.j.INSTANCE.d(amount != null ? amount.getAmount() : null);
        if (strD == null) {
            row.llOrderPriceGroup.setVisibility(8);
        } else {
            row.tvOrderAmount.setText(c0(strD));
            row.llOrderPriceGroup.setVisibility(0);
        }
    }

    public final void Z(x row, List<OrderField> fields) {
        LinearLayout llOrderFields = row.llOrderFields;
        p.h(llOrderFields, "llOrderFields");
        llOrderFields.removeAllViews();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int i10 = 0;
        for (OrderField orderField : fields) {
            N5.j jVar = N5.j.INSTANCE;
            String strD = jVar.d(orderField.getLabel());
            String strD2 = jVar.d(orderField.getValue());
            String strD3 = jVar.d(orderField.getSubValue());
            if (strD != null || strD2 != null || strD3 != null) {
                C1017a c1017aC = C1017a.c(layoutInflaterFrom, llOrderFields, false);
                p.h(c1017aC, "inflate(...)");
                TextView textView = c1017aC.tvFieldLabel;
                if (strD == null) {
                    strD = "";
                }
                textView.setText(strD);
                TextView textView2 = c1017aC.tvFieldValue;
                if (strD2 == null) {
                    strD2 = "";
                }
                textView2.setText(strD2);
                if (strD3 != null) {
                    c1017aC.tvFieldSubValue.setText(strD3);
                    c1017aC.tvFieldSubValue.setVisibility(0);
                } else {
                    c1017aC.tvFieldSubValue.setVisibility(8);
                }
                if (i10 > 0) {
                    ViewGroup.LayoutParams layoutParams = c1017aC.b().getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                    if (marginLayoutParams != null) {
                        marginLayoutParams.topMargin = (int) (14 * getResources().getDisplayMetrics().density);
                        c1017aC.b().setLayoutParams(marginLayoutParams);
                    }
                }
                llOrderFields.addView(c1017aC.b());
                i10++;
            }
        }
        llOrderFields.setVisibility(i10 <= 0 ? 8 : 0);
    }

    public final void a0(x row, OrderActionItem item, b model) {
        Object next;
        TextView tvOrderTitle = row.tvOrderTitle;
        p.h(tvOrderTitle, "tvOrderTitle");
        n(tvOrderTitle, item.getTitle());
        TextView tvOrderSubtitle = row.tvOrderSubtitle;
        p.h(tvOrderSubtitle, "tvOrderSubtitle");
        n(tvOrderSubtitle, item.getSubtitle());
        Iterator<T> it = item.e().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (D.L(((OrderNote) next).getType(), "hint", true)) {
                    break;
                }
            }
        }
        OrderNote orderNote = (OrderNote) next;
        String text = orderNote != null ? orderNote.getText() : null;
        TextView tvOrderHint = row.tvOrderHint;
        p.h(tvOrderHint, "tvOrderHint");
        n(tvOrderHint, text);
        Z(row, item.c());
        Y(row, item.getAmount());
        V(row, item, model.getTaskStatus());
        row.llOrderActionRow.setVisibility((row.btnOrderAction.getVisibility() == 0 || row.llOrderPriceGroup.getVisibility() == 0) ? 0 : 8);
        row.divOrderAction.setVisibility(row.llOrderActionRow.getVisibility() != 0 ? 8 : 0);
    }

    public final void b0(String text, String itemId) {
        Object objB;
        String str = itemId == null ? text : itemId;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Long l10 = this.lastConfirmSendAt.get(str);
        long jLongValue = jElapsedRealtime - (l10 != null ? l10.longValue() : 0L);
        if (jLongValue < 1500) {
            R5.b bVar = R5.b.INSTANCE;
            if (itemId == null) {
                itemId = "null";
            }
            bVar.c("view.orderAction.confirmClick.debounced", j.a("taskId", itemId), j.a("sinceLastMs", Long.valueOf(jLongValue)));
            return;
        }
        this.lastConfirmSendAt.put(str, Long.valueOf(jElapsedRealtime));
        try {
            Result.Companion companion = Result.INSTANCE;
            getContext().sendBroadcast(new Intent("com.stepos.ailauncher.action.SHARE_WAKE").setPackage(getContext().getPackageName()).putExtra("android.intent.extra.TEXT", text).putExtra("extra_auto_send", true));
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("view.orderAction.confirmSend.fail", j.a("taskId", itemId == null ? "null" : itemId), j.a("exception", thE.getClass().getSimpleName()), j.a("message", thE.getMessage()));
        }
        R5.b bVar2 = R5.b.INSTANCE;
        if (itemId == null) {
            itemId = "null";
        }
        bVar2.c("view.orderAction.confirmClick", j.a("taskId", itemId), j.a("sendText", text), j.a("channel", "shareWakeBroadcast"));
    }

    public final CharSequence c0(String text) {
        int iT0 = H.t0(text, '.', 0, false, 6, null);
        if (iT0 < 0) {
            return text;
        }
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new RelativeSizeSpan(0.6363636f), iT0, spannableString.length(), 33);
        return spannableString;
    }

    public /* synthetic */ e(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
