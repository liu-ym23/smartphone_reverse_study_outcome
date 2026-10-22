package com.tmall.wireless.tangram.support.async;

import com.tmall.wireless.tangram.dataparser.concrete.Card;

/* JADX INFO: loaded from: classes4.dex */
public class CardLoadSupport {
    private static int sInitialPage = 1;
    private AsyncLoader mAsyncLoader;
    private AsyncPageLoader mAsyncPageLoader;

    static {
    }

    public CardLoadSupport() {
    }

    public static /* synthetic */ int access$000() {
        return sInitialPage;
    }

    public static void setInitialPage(int r10) {
        sInitialPage = r10;
    }

    public void doLoad(final Card r10) {
        AsyncLoader r11 = this.mAsyncLoader;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r10.loading == false) goto L8;
        return;
    L8:
        if (r10.loaded == true) goto L12;
        r10.loading = true;
        r11.loadData(r10, new AnonymousClass1(this, r10));
        return;
    }

    public void loadMore(final Card r10) {
        AsyncPageLoader r11 = this.mAsyncPageLoader;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r10.loading == false) goto L8;
        return;
    L8:
        if (r10.loadMore == true) goto L10;
        return;
    L10:
        if (r10.hasMore == false) goto L18;
        r10.loading = true;
        if (r10.loaded == true) goto L14;
        r10.page = sInitialPage;
    L14:
        r11.loadData(r10.page, r10, new AnonymousClass2(this, r10));
        return;
    }

    public void replaceLoader(AsyncLoader r10) {
        this.mAsyncLoader = r10;
    }

    public CardLoadSupport(AsyncLoader r10) {
        this(r10, null);
    }

    public void replaceLoader(AsyncPageLoader r10) {
        this.mAsyncPageLoader = r10;
    }

    public CardLoadSupport(AsyncPageLoader r10) {
        this(null, r10);
    }

    public void replaceLoader(AsyncLoader r10, AsyncPageLoader r11) {
        this.mAsyncLoader = r10;
        this.mAsyncPageLoader = r11;
    }

    public CardLoadSupport(AsyncLoader r10, AsyncPageLoader r11) {
        this.mAsyncLoader = r10;
        this.mAsyncPageLoader = r11;
    }
}
