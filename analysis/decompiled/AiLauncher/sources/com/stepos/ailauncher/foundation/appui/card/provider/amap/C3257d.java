package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.ailauncher.common.imageloader.DiskCache;
import com.stepos.ailauncher.common.imageloader.ImageDataSource;
import com.stepos.ailauncher.common.imageloader.ImageRequest;
import com.stepos.ailauncher.foundation.R$drawable;
import com.stepos.ailauncher.foundation.R$layout;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB%\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\u00020\u0017*\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/d;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/d$a;", "", "", "urls", "", "overrideWidth", "overrideHeight", "<init>", "(Ljava/util/List;II)V", "Landroid/view/ViewGroup;", "parent", "viewType", "f", "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/d$a;", "getItemCount", "()I", "holder", "position", "LY8/t;", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/d$a;I)V", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Ljava/lang/Object;", "Ljava/util/List;", "I", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3257d extends RecyclerView.Adapter<a> {
    private final int overrideHeight;
    private final int overrideWidth;
    private final List<String> urls;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/d$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "image", "<init>", "(Landroid/widget/ImageView;)V", "Landroid/widget/ImageView;", Const.INTENT_KEY_APIKEY, "()Landroid/widget/ImageView;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.d$a */
    public static final class a extends RecyclerView.ViewHolder {
        private final ImageView image;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ImageView image) {
            super(image);
            kotlin.jvm.internal.p.i(image, "image");
            this.image = image;
        }

        /* renamed from: a, reason: from getter */
        public final ImageView getImage() {
            return this.image;
        }
    }

    public C3257d(List<String> urls, int i10, int i11) {
        kotlin.jvm.internal.p.i(urls, "urls");
        this.urls = urls;
        this.overrideWidth = i10;
        this.overrideHeight = i11;
    }

    public static final void e(String str, boolean z10, ImageDataSource source) {
        kotlin.jvm.internal.p.i(source, "source");
        if (z10) {
            R5.b.INSTANCE.c("poi.gallery.ok", Y8.j.a("url", str), Y8.j.a("source", source.name()));
        } else {
            R5.b.INSTANCE.h("poi.gallery.fail", Y8.j.a("url", str));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        final String str = this.urls.get(position);
        Object objG = g(str);
        com.stepos.ailauncher.common.imageloader.g gVar = com.stepos.ailauncher.common.imageloader.g.INSTANCE;
        ImageView image = holder.getImage();
        int i10 = R$drawable.bg_card_map_gallery;
        com.stepos.ailauncher.common.imageloader.g.s(gVar, image, new ImageRequest(objG, i10, i10, null, null, 0, 0, this.overrideWidth, this.overrideHeight, true, 200, false, true, false, false, DiskCache.ALL, 0.15f, false, 157784, null), null, new com.stepos.ailauncher.common.imageloader.b() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.c
            @Override // com.stepos.ailauncher.common.imageloader.b
            public final void a(boolean z10, ImageDataSource imageDataSource) {
                C3257d.e(str, z10, imageDataSource);
            }
        }, holder.getImage().getContext().getApplicationContext(), 4, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_card_map_gallery, parent, false);
        kotlin.jvm.internal.p.g(viewInflate, "null cannot be cast to non-null type android.widget.ImageView");
        return new a((ImageView) viewInflate);
    }

    public final Object g(String str) {
        Integer numW;
        if (La.D.X(str, "android.resource://", false, 2, null) && (numW = La.C.w(La.H.s1(str, JsonPointer.SEPARATOR, null, 2, null))) != null) {
            Integer num = numW.intValue() != 0 ? numW : null;
            if (num != null) {
                return num;
            }
        }
        return str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.urls.size();
    }
}
