package com.tt.skin.sdk.api;

import android.webkit.WebView;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.article.night.webview.IWebViewNightModeHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J&\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/tt/skin/sdk/api/ISkinWebViewInterceptor;", "", "getNightModeHelper", "Lcom/ss/android/article/night/webview/IWebViewNightModeHelper;", "webView", "Landroid/webkit/WebView;", "judgeWebViewNightMode", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "isDetailPage", "", "api_release"}, k = 1, mv = {1, 1, 15})
public interface ISkinWebViewInterceptor {
    @Nullable
    IWebViewNightModeHelper getNightModeHelper(@Nullable WebView r10);

    @Nullable
    IWebViewNightModeHelper judgeWebViewNightMode(@Nullable LifecycleOwner r10, @Nullable WebView r11);

    @Nullable
    IWebViewNightModeHelper judgeWebViewNightMode(@Nullable LifecycleOwner r10, @Nullable WebView r11, boolean r12);
}
