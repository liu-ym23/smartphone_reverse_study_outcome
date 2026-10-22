package com.bytedance.android.shopping.widget.rittag;

import com.alibaba.gaiax.model.GXAnimation;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/widget/rittag/RitTagPart;", "", GXAnimation.STATE_START, EffectConstants.NORMAL, GXAnimation.STATE_END, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RitTagPart extends Enum<RitTagPart> {
    public static final RitTagPart END = null;
    public static final RitTagPart NORMAL = null;
    public static final RitTagPart START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RitTagPart[] f187446a = null;

    static {
        RitTagPart r100 = new RitTagPart(GXAnimation.STATE_START, 0);
        START = r100;
        RitTagPart r101 = new RitTagPart(EffectConstants.NORMAL, 1);
        NORMAL = r101;
        RitTagPart r102 = new RitTagPart(GXAnimation.STATE_END, 2);
        END = r102;
        f187446a = new RitTagPart[]{r100, r101, r102};
    }

    public static RitTagPart valueOf(String r100) {
        return (RitTagPart) r27.a.a(RitTagPart.class, r100);
    }

    public static RitTagPart[] values() {
        return (RitTagPart[]) f187446a.clone();
    }

    public RitTagPart(String r100, int r101) {
        super(r100, r101);
    }
}
