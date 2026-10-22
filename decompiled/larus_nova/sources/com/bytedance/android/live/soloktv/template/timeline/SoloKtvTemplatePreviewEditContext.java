package com.bytedance.android.live.soloktv.template.timeline;

import android.graphics.Bitmap;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytedance.ies.videoclip.api.player.IPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/soloktv/template/timeline/SoloKtvTemplatePreviewEditContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/n;", "Lcom/ss/bytedance/ies/videoclip/api/player/IPlayer$PlayerStatus;", "playStatus$delegate", "Lcom/bytedance/live/datacontext/p;", "getPlayStatus", "()Lcom/bytedance/live/datacontext/n;", "playStatus", "Lcom/bytedance/live/datacontext/m;", "", "currentTime$delegate", "getCurrentTime", "()Lcom/bytedance/live/datacontext/m;", "currentTime", "Landroid/graphics/Bitmap;", "coverBitmap", "Landroid/graphics/Bitmap;", "getCoverBitmap", "()Landroid/graphics/Bitmap;", "setCoverBitmap", "(Landroid/graphics/Bitmap;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloKtvTemplatePreviewEditContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private Bitmap coverBitmap;
    private final p currentTime$delegate;
    private final p playStatus$delegate;

    public static final class a {
        public static SoloKtvTemplatePreviewEditContext a() {
            DataContext r100 = d.d(SoloKtvTemplatePreviewEditContext.class);
            if ((r100 instanceof SoloKtvTemplatePreviewEditContext) == true) goto L6;
            r100 = null;
        L6:
            return (SoloKtvTemplatePreviewEditContext) r100;
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(SoloKtvTemplatePreviewEditContext.class, "playStatus", "getPlayStatus()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(SoloKtvTemplatePreviewEditContext.class, "currentTime", "getCurrentTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public final m<Long> getCurrentTime() {
        return (m) this.currentTime$delegate.a(this, $$delegatedProperties[1]);
    }

    public final n<IPlayer.PlayerStatus> getPlayStatus() {
        return (n) this.playStatus$delegate.a(this, $$delegatedProperties[0]);
    }

    public SoloKtvTemplatePreviewEditContext() {
        com.bytedance.live.datacontext.b.a(this, SoloKtvTemplatePreviewEditContext.class);
        this.playStatus$delegate = q.c(this);
        this.currentTime$delegate = q.d(this, 0L);
    }

    public final Bitmap getCoverBitmap() {
        return this.coverBitmap;
    }

    public final void setCoverBitmap(Bitmap r100) {
        this.coverBitmap = r100;
    }
}
