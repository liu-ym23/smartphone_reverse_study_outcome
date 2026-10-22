package com.android.ttcjpaysdk.base.utils.html.utils;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.ui.data.UIComponent;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/html/utils/UIComponentParser;", "", "()V", "parseJsonToComponents", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/UIComponent;", "Lkotlin/collections/ArrayList;", "jsonString", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIComponentParser {
    public static final UIComponentParser INSTANCE = null;

    static {
        INSTANCE = new UIComponentParser();
    }

    private UIComponentParser() {
    }

    public final ArrayList<UIComponent> parseJsonToComponents(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return null;
    L11:
        final ArrayList<UIComponent> r102 = new ArrayList();
        KtSafeMethodExtensionKt.forEach(KtSafeMethodExtensionKt.safeCreateJsonArray(r100), new AnonymousClass1(r102));
        if (r102.isEmpty() == false) goto L14;
        return null;
    L14:
        return r102;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L9
    }
}
