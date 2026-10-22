package com.bytedance.android.livesdk.clearscreen;

import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/clearscreen/ZoomType;", "", "", "type", "I", "getType", "()I", EffectConstants.NORMAL, OpenNetMethod.LOCK, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ZoomType extends Enum<ZoomType> {
    public static final ZoomType LOCK = null;
    public static final ZoomType NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ZoomType[] f119360a = null;
    private final int type;

    static {
        ZoomType r100 = new ZoomType(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        ZoomType r101 = new ZoomType(OpenNetMethod.LOCK, 1, 1);
        LOCK = r101;
        f119360a = new ZoomType[]{r100, r101};
    }

    public static ZoomType valueOf(String r100) {
        return (ZoomType) r27.a.a(ZoomType.class, r100);
    }

    public static ZoomType[] values() {
        return (ZoomType[]) f119360a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ZoomType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
