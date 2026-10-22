package com.android.ttcjpaysdk.kmp.common.view.lynx;

import com.tencent.open.SocialConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ouc.i;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012(\b\u0002\u0010\u0002\u001a\"\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\u0012\"\b\u0002\u0010\b\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\t\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0010\u001a\"\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003HÆ\u0003J#\u0010\u0011\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\t\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0003JW\u0010\u0012\u001a\u00020\u00002(\b\u0002\u0010\u0002\u001a\"\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00032\"\b\u0002\u0010\b\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\t\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R1\u0010\u0002\u001a\"\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR+\u0010\b\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\t\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/lynx/CJLynxCardViewEventHandler;", "", SocialConstants.PARAM_RECEIVER, "Lkotlin/Function2;", "", "", "Lkotlinx/serialization/json/JsonElement;", "", "sender", "Lkotlin/Function1;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "getReceiver", "()Lkotlin/jvm/functions/Function2;", "getSender", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJLynxCardViewEventHandler {
    public static final int $stable = 0;
    private final Function2<Map<String, ? extends i>, String, Unit> receiver;
    private final Function1<Function1<? super String, Unit>, Unit> sender;

    /* JADX WARN: Multi-variable type inference failed */
    public CJLynxCardViewEventHandler() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CJLynxCardViewEventHandler copy$default(CJLynxCardViewEventHandler r100, Function2 r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.receiver;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.sender;
    L9:
        return r100.copy(r101, r102);
    }

    public final Function2<Map<String, ? extends i>, String, Unit> component1() {
        return this.receiver;
    }

    public final Function1<Function1<? super String, Unit>, Unit> component2() {
        return this.sender;
    }

    public final CJLynxCardViewEventHandler copy(Function2<? super Map<String, ? extends i>, ? super String, Unit> r100, Function1<? super Function1<? super String, Unit>, Unit> r101) {
        return new CJLynxCardViewEventHandler(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJLynxCardViewEventHandler) == true) goto L8;
        return false;
    L8:
        CJLynxCardViewEventHandler r101 = (CJLynxCardViewEventHandler) r100;
        if (Intrinsics.areEqual(this.receiver, r101.receiver) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sender, r101.sender) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Function2<Map<String, ? extends i>, String, Unit> r100 = this.receiver;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function1<Function1<? super String, Unit>, Unit> r104 = this.sender;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CJLynxCardViewEventHandler(receiver=" + this.receiver + ", sender=" + this.sender + ')';
    }

    public final Function2<Map<String, ? extends i>, String, Unit> getReceiver() {
        return this.receiver;
    }

    public final Function1<Function1<? super String, Unit>, Unit> getSender() {
        return this.sender;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CJLynxCardViewEventHandler(Function2<? super Map<String, ? extends i>, ? super String, Unit> r100, Function1<? super Function1<? super String, Unit>, Unit> r101) {
        this.receiver = r100;
        this.sender = r101;
    }

    public /* synthetic */ CJLynxCardViewEventHandler(Function2 r100, Function1 r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
