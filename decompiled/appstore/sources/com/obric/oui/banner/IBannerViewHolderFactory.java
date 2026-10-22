package com.obric.oui.banner;

import android.view.ViewGroup;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/banner/IBannerViewHolderFactory;", "", "Landroid/view/ViewGroup;", "parent", "Lcom/obric/oui/banner/d;", "newInstance", "(Landroid/view/ViewGroup;)Lcom/obric/oui/banner/d;", "", "getKey", "()Ljava/lang/String;", "key", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IBannerViewHolderFactory {
    @NotNull
    String getKey();

    @NotNull
    d newInstance(@NotNull ViewGroup r10);
}
