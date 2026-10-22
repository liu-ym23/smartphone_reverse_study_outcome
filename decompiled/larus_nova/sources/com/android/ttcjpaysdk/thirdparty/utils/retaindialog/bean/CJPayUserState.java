package com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\u0006\u0010\r\u001a\u00020\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayUserState;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "state", "", "(Ljava/lang/String;)V", "getState", "()Ljava/lang/String;", "stateMap", "", "equals", "", "other", "", "formatString", "hashCode", "", "toString", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayUserState implements CJPayObject {
    private final String state;
    private final Map<String, String> stateMap;

    public final String formatString() {
        if (this.stateMap.entrySet().isEmpty() == false) goto L15;
        String r100 = this.state;
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L17;
        return "Default";
    L17:
        return this.state;
    L7:
        if (r100.length() == 0) goto L10;
        r101 = false;
        goto L11
    L15:
        return CollectionsKt.joinToString$default(this.stateMap.entrySet(), "-", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null);
    }

    public int hashCode() {
        return formatString().hashCode();
    }

    public String toString() {
        return formatString();
    }

    public final String getState() {
        return this.state;
    }

    public CJPayUserState(String r110) {
        this.state = r110;
        this.stateMap = new LinkedHashMap();
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L21;
        Iterator r111 = StringsKt.split$default(r110, new String[]{"-"}, false, 0, 6, null).iterator();
    L12:
        if (r111.hasNext() == false) goto L29;
        String r101 = (String) r111.next();
        if (r101.length() <= 0) goto L16;
        boolean r102 = true;
    L17:
        if (r102 == false) goto L12;
        List r103 = StringsKt.split$default(r101, new String[]{"#"}, false, 0, 6, null);
        if (r103.size() != 2) goto L12;
        Map<String, String> r104 = this.stateMap;
        Object r105 = ListProtector.get(r103, 0);
        r104.put((String) r105, (String) ListProtector.get(r103, 1));
        goto L12
    L16:
        r102 = false;
        goto L17
    L29:
        return;
    L21:
        return;
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L9
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(CJPayUserState.class, r101) == true) goto L13;
        return false;
    L13:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean.CJPayUserState");
        return Intrinsics.areEqual(formatString(), ((CJPayUserState) r100).formatString());
    L8:
        r101 = null;
        goto L10
    }
}
