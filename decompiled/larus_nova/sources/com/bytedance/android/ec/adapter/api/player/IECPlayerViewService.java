package com.bytedance.android.ec.adapter.api.player;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d;
import kotlin.Metadata;
import le.b;

/* JADX INFO: loaded from: classes43.dex */
public interface IECPlayerViewService {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/adapter/api/player/IECPlayerViewService$RenderViewType;", "", "TEXTURE_VIEW", "SURFACE_VIEW", "KEEP_TEXTURE_RENDER_VIEW", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum RenderViewType extends Enum<RenderViewType> {
        public static final RenderViewType KEEP_TEXTURE_RENDER_VIEW = null;
        public static final RenderViewType SURFACE_VIEW = null;
        public static final RenderViewType TEXTURE_VIEW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RenderViewType[] f42683a = null;

        static {
            RenderViewType r100 = new RenderViewType("TEXTURE_VIEW", 0);
            TEXTURE_VIEW = r100;
            RenderViewType r101 = new RenderViewType("SURFACE_VIEW", 1);
            SURFACE_VIEW = r101;
            RenderViewType r102 = new RenderViewType("KEEP_TEXTURE_RENDER_VIEW", 2);
            KEEP_TEXTURE_RENDER_VIEW = r102;
            f42683a = new RenderViewType[]{r100, r101, r102};
        }

        public static RenderViewType valueOf(String r100) {
            return (RenderViewType) r27.a.a(RenderViewType.class, r100);
        }

        public static RenderViewType[] values() {
            return (RenderViewType[]) f42683a.clone();
        }

        public RenderViewType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static /* synthetic */ b a(IECPlayerViewService r100, Context r110, AttributeSet r111, int r112, String r113, String r114, boolean r115, boolean r116, int r117) {
            if ((r117 & 2) == 0) goto L5;
            AttributeSet r101 = null;
        L7:
            if ((r117 & 4) == 0) goto L9;
            int r102 = 0;
        L11:
            if ((r117 & 16) == 0) goto L13;
            String r103 = "";
        L15:
            return r100.a(r110, r101, r102, r113, r103, null, null);
        L13:
            r103 = r114;
            goto L15
        L9:
            r102 = r112;
            goto L11
        L5:
            r101 = r111;
            goto L7
        }
    }

    d a(Context r100, AttributeSet r101, int r102, String r103, String r104, RenderViewType r105, Long r106);
}
