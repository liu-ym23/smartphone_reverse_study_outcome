package com.bytedance.android.shopping.commentv3.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/ReportType;", "", "", "type", "I", "getType", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, EffectConstants.NORMAL, "SHOW", "CLICK", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReportType extends Enum<ReportType> {
    public static final ReportType CLICK = null;
    public static final a Companion = null;
    public static final ReportType NORMAL = null;
    public static final ReportType SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReportType[] f172729a = null;
    private final int type;

    public static final class a {
        public a() {
        }
    }

    static {
        ReportType r100 = new ReportType(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        ReportType r101 = new ReportType("SHOW", 1, 1);
        SHOW = r101;
        ReportType r102 = new ReportType("CLICK", 2, 2);
        CLICK = r102;
        f172729a = new ReportType[]{r100, r101, r102};
        Companion = new a();
    }

    public static ReportType valueOf(String r100) {
        return (ReportType) r27.a.a(ReportType.class, r100);
    }

    public static ReportType[] values() {
        return (ReportType[]) f172729a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ReportType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
