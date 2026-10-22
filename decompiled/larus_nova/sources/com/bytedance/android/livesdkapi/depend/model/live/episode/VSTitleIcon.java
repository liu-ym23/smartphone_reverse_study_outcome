package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSTitleIcon;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSTitleIcon;", "", "isAvailable", "", "sizeType", "I", "getSizeType", "()I", "setSizeType", "(I)V", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "<init>", "()V", "Companion", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSTitleIcon extends FlexModelBase<IVSTitleIcon> implements IVSTitleIcon, h {
    public static final Companion Companion = null;
    public static final int LARGE = 2;
    public static final int SMALL = 1;

    @SerializedName("icon")
    protected k icon;

    @SerializedName("size_type")
    protected int sizeType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSTitleIcon$Companion;", "", "()V", "LARGE", "", "SMALL", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public VSTitleIcon() {
        super(IVSTitleIcon.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSTitleIconEx
    public boolean isAvailable() {
        if (getIcon() == null) goto L15;
        k r100 = getIcon();
        if (r100 == null) goto L15;
        List<String> r101 = r100.getUrls();
        if (r101 == null) goto L15;
        if ((!r101.isEmpty()) != true) goto L15;
        if (getSizeType() != 1) goto L13;
        return true;
    L13:
        if (getSizeType() != 2) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSTitleIcon
    public k getIcon() {
        return this.icon;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSTitleIcon
    public int getSizeType() {
        return this.sizeType;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public VSTitleIcon(g r100) {
        super(IVSTitleIcon.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.icon = f.a(r100, k.class);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.sizeType = r100.i();
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setIcon(k r100) {
        this.icon = r100;
    }

    public void setSizeType(int r100) {
        this.sizeType = r100;
    }
}
