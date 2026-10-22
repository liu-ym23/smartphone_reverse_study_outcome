package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0005R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/BindCardConfig;", "Ljava/io/Serializable;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "lynx_bind_card_biz", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "enable_native_bind_card", "", "(Ljava/util/ArrayList;Z)V", "enableNativeBindCardProcess", "isLynxBindCard", "bizType", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BindCardConfig implements Serializable, CJPayObject {
    public boolean enable_native_bind_card;
    public ArrayList<Integer> lynx_bind_card_biz;

    /* JADX WARN: Multi-variable type inference failed */
    public BindCardConfig() {
        ArrayList r100 = null;
        this(r100, false, 3, 0 == true ? 1 : 0);
    }

    public final boolean enableNativeBindCardProcess() {
        return this.enable_native_bind_card;
    }

    public final boolean isLynxBindCard(int r100) {
        return this.lynx_bind_card_biz.contains(Integer.valueOf(r100));
    }

    public BindCardConfig(ArrayList<Integer> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "lynx_bind_card_biz");
        this.lynx_bind_card_biz = r100;
        this.enable_native_bind_card = r101;
    }

    public /* synthetic */ BindCardConfig(ArrayList r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = true;
    L8:
        this(r100, r101);
    }
}
