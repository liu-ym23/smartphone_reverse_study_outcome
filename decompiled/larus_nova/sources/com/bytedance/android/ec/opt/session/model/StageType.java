package com.bytedance.android.ec.opt.session.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/opt/session/model/StageType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, EffectConstants.NORMAL, "VIRTUAL", "ec-opt_release"}, k = 1, mv = {1, 4, 3})
public final enum StageType extends Enum<StageType> {
    public static final a Companion = null;
    public static final StageType NORMAL = null;
    public static final StageType VIRTUAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StageType[] f48102a = null;

    public static final class a {
        public a() {
        }

        public static StageType a(String r100) {
            if (r100 == null) goto L5;
            String r101 = r100.toLowerCase(Locale.getDefault());
        L6:
            if (r101 == null) goto L23;
            int r102 = r101.hashCode();
            if (r102 == (-1039745817)) goto L17;
            if (r102 == 466165515) goto L14;
            return null;
        L14:
            if (r101.equals("virtual") == true) goto L21;
            return null;
        L21:
            return StageType.VIRTUAL;
        L17:
            if (r101.equals("normal") == true) goto L19;
            return null;
        L19:
            return StageType.NORMAL;
        L23:
            return null;
        L5:
            r101 = null;
            goto L6
        }
    }

    static {
        StageType r100 = new StageType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        StageType r101 = new StageType("VIRTUAL", 1);
        VIRTUAL = r101;
        f48102a = new StageType[]{r100, r101};
        Companion = new a();
    }

    public static StageType valueOf(String r100) {
        return (StageType) r27.a.a(StageType.class, r100);
    }

    public static StageType[] values() {
        return (StageType[]) f48102a.clone();
    }

    public StageType(String r100, int r101) {
        super(r100, r101);
    }
}
