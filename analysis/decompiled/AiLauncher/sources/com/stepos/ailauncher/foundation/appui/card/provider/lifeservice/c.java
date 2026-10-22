package com.stepos.ailauncher.foundation.appui.card.provider.lifeservice;

import N5.n;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0003\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/c;", "LN5/n;", "", "cardId", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/g;", DidiCardProvider.KEY_ITEMS, "bizChannel", "", "vendorIconRes", "vendorIconUrl", "subtitle", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "getBizChannel", "I", "getVendorIconRes", "()I", "getVendorIconUrl", "c", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c extends n {
    private final String bizChannel;
    private final String cardId;
    private final List<LifeServiceItem> items;
    private final String subtitle;
    private final int vendorIconRes;
    private final String vendorIconUrl;

    public c() {
        this(null, null, null, 0, null, null, 63, null);
    }

    @Override // N5.n
    /* renamed from: a, reason: from getter */
    public String getCardId() {
        return this.cardId;
    }

    public final List<LifeServiceItem> b() {
        return this.items;
    }

    /* renamed from: c, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String cardId, List<LifeServiceItem> items, String str, int i10, String str2, String str3) {
        super(cardId);
        p.i(cardId, "cardId");
        p.i(items, "items");
        this.cardId = cardId;
        this.items = items;
        this.bizChannel = str;
        this.vendorIconRes = i10;
        this.vendorIconUrl = str2;
        this.subtitle = str3;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ c(java.lang.String r2, java.util.List r3, java.lang.String r4, int r5, java.lang.String r6, java.lang.String r7, int r8, kotlin.jvm.internal.i r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r9 = r8 & 2
            if (r9 == 0) goto Le
            java.util.List r3 = Z8.C1173v.m()
        Le:
            r9 = r8 & 4
            r0 = 0
            if (r9 == 0) goto L14
            r4 = r0
        L14:
            r9 = r8 & 8
            if (r9 == 0) goto L19
            r5 = 0
        L19:
            r9 = r8 & 16
            if (r9 == 0) goto L1e
            r6 = r0
        L1e:
            r8 = r8 & 32
            if (r8 == 0) goto L2a
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L31
        L2a:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L31:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.lifeservice.c.<init>(java.lang.String, java.util.List, java.lang.String, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.i):void");
    }
}
