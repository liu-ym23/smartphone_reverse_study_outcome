package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0016\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0014\u0010\u000bR\"\u0010\u0019\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0017\u0010\u0005R\"\u0010\u001c\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001a\u0010\u0005¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/h3;", "Lvh7/c;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getNewIcon", "()Lpy/k;", "getNewIcon$annotations", "()V", "newIcon", "", "getContent", "()Ljava/lang/String;", "getContent$annotations", "content", "getScheme", "getScheme$annotations", "scheme", "getSchemeHotsoon", "getSchemeHotsoon$annotations", "schemeHotsoon", "getSchemeSaas", "getSchemeSaas$annotations", "schemeSaas", "getPreIcon", "getPreIcon$annotations", "preIcon", "getIconBackImg", "getIconBackImg$annotations", "iconBackImg", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h3 extends vh7.c<h3> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "content")
    String getContent();

    @FieldName(name = "icon_back_img")
    py.k getIconBackImg();

    @FieldName(name = "new_icon")
    py.k getNewIcon();

    @FieldName(name = "pre_icon")
    py.k getPreIcon();

    @FieldName(name = "scheme")
    String getScheme();

    @FieldName(name = "hotsoon_scheme")
    String getSchemeHotsoon();

    @FieldName(name = "open_scheme")
    String getSchemeSaas();
}
