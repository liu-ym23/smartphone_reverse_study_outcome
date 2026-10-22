package com.bytedance.android.window.shop.home;

import com.bytedance.android.window.shop.prefetch.HeaderPrefetchJobKey;
import com.bytedance.android.window.shop.prefetch.TabBffPrefetchJobKey;
import com.bytedance.android.window.shop.prefetch.TabPrefetchJobKey;
import com.bytedance.android.window.shop.prefetch.WindowComponentPrefetchJobKey;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/window/shop/home/ECWindowJobKeys;", "Ljava/io/Serializable;", "()V", "componentJobKey", "Lcom/bytedance/android/window/shop/prefetch/WindowComponentPrefetchJobKey;", "getComponentJobKey", "()Lcom/bytedance/android/window/shop/prefetch/WindowComponentPrefetchJobKey;", "setComponentJobKey", "(Lcom/bytedance/android/window/shop/prefetch/WindowComponentPrefetchJobKey;)V", "headJobKey", "Lcom/bytedance/android/window/shop/prefetch/HeaderPrefetchJobKey;", "getHeadJobKey", "()Lcom/bytedance/android/window/shop/prefetch/HeaderPrefetchJobKey;", "setHeadJobKey", "(Lcom/bytedance/android/window/shop/prefetch/HeaderPrefetchJobKey;)V", "tabBffJobKey", "Lcom/bytedance/android/window/shop/prefetch/TabBffPrefetchJobKey;", "getTabBffJobKey", "()Lcom/bytedance/android/window/shop/prefetch/TabBffPrefetchJobKey;", "setTabBffJobKey", "(Lcom/bytedance/android/window/shop/prefetch/TabBffPrefetchJobKey;)V", "tabJobKey", "Lcom/bytedance/android/window/shop/prefetch/TabPrefetchJobKey;", "getTabJobKey", "()Lcom/bytedance/android/window/shop/prefetch/TabPrefetchJobKey;", "setTabJobKey", "(Lcom/bytedance/android/window/shop/prefetch/TabPrefetchJobKey;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowJobKeys implements Serializable {
    private WindowComponentPrefetchJobKey componentJobKey;
    private HeaderPrefetchJobKey headJobKey;
    private TabBffPrefetchJobKey tabBffJobKey;
    private TabPrefetchJobKey tabJobKey;

    public ECWindowJobKeys() {
    }

    public final WindowComponentPrefetchJobKey getComponentJobKey() {
        return this.componentJobKey;
    }

    public final HeaderPrefetchJobKey getHeadJobKey() {
        return this.headJobKey;
    }

    public final TabBffPrefetchJobKey getTabBffJobKey() {
        return this.tabBffJobKey;
    }

    public final TabPrefetchJobKey getTabJobKey() {
        return this.tabJobKey;
    }

    public final void setComponentJobKey(WindowComponentPrefetchJobKey r100) {
        this.componentJobKey = r100;
    }

    public final void setHeadJobKey(HeaderPrefetchJobKey r100) {
        this.headJobKey = r100;
    }

    public final void setTabBffJobKey(TabBffPrefetchJobKey r100) {
        this.tabBffJobKey = r100;
    }

    public final void setTabJobKey(TabPrefetchJobKey r100) {
        this.tabJobKey = r100;
    }
}
