package com.stepos.ailauncher.chat.wake;

import E4.d;
import E4.e;
import E4.n;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00038\u0016X\u0096D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/U;", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardEventHandler;", "Lkotlin/Function1;", "", "LY8/t;", "onItemSelected", "<init>", "(Lp9/l;)V", "LE4/d;", "event", "LE4/e;", "handle", "(LE4/d;Le9/c;)Ljava/lang/Object;", "Lp9/l;", "businessType", "Ljava/lang/String;", "getBusinessType", "()Ljava/lang/String;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class U implements IFloatCardEventHandler {
    public static final String BUSINESS_TYPE = "suggest_card";
    private final String businessType;
    private final InterfaceC5074l<String, Y8.t> onItemSelected;

    /* JADX WARN: Multi-variable type inference failed */
    public U(InterfaceC5074l<? super String, Y8.t> onItemSelected) {
        kotlin.jvm.internal.p.i(onItemSelected, "onItemSelected");
        this.onItemSelected = onItemSelected;
        this.businessType = BUSINESS_TYPE;
    }

    @Override // com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler
    public String getBusinessType() {
        return this.businessType;
    }

    @Override // com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler
    public Object handle(E4.d dVar, InterfaceC4014c<? super E4.e> interfaceC4014c) {
        String value;
        String str = null;
        if (!(dVar instanceof d.Submit)) {
            if (!(dVar instanceof d.ActionClicked)) {
                return ((dVar instanceof d.CardClicked) || (dVar instanceof d.LinkClicked) || (dVar instanceof d.Exposed)) ? e.C0026e.INSTANCE : new e.Error("exception event", false, 2, null);
            }
            String string = ((d.ActionClicked) dVar).getPayload().getString(UxipConstants.f30680s);
            if (string == null) {
                string = "";
            }
            if (string.length() > 0) {
                this.onItemSelected.invoke(string);
            }
            return e.a.INSTANCE;
        }
        Iterator<T> it = ((d.Submit) dVar).a().values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            E4.n nVar = (E4.n) it.next();
            if (nVar instanceof n.Selected) {
                value = (String) Z8.F.s0(((n.Selected) nVar).a());
            } else {
                if (!(nVar instanceof n.Text)) {
                    throw new NoWhenBranchMatchedException();
                }
                value = ((n.Text) nVar).getValue();
                if (value.length() <= 0) {
                    value = null;
                }
            }
            if (value != null) {
                str = value;
                break;
            }
        }
        if (str != null) {
            this.onItemSelected.invoke(str);
        }
        return e.a.INSTANCE;
    }
}
