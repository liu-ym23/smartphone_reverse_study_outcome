package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleAuxiliaryConfig;", "Lvh7/c;", "", "getOperateType", "()J", "getOperateType$annotations", "()V", "operateType", "getGiftId", "getGiftId$annotations", "giftId", "", "getSuffixNumberMode", "()I", "getSuffixNumberMode$annotations", "suffixNumberMode", "getFixedNumber", "getFixedNumber$annotations", "fixedNumber", "getIndex", "getIndex$annotations", "index", "SuffixNumberMode", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBattleAuxiliaryConfig extends vh7.c<IBattleAuxiliaryConfig> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleAuxiliaryConfig$SuffixNumberMode;", "", "UnknownSuffix", "SingleSuffix", "DoubleSuffix", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum SuffixNumberMode extends Enum<SuffixNumberMode> {
        public static final SuffixNumberMode DoubleSuffix = null;
        public static final SuffixNumberMode SingleSuffix = null;
        public static final SuffixNumberMode UnknownSuffix = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SuffixNumberMode[] f147027a = null;

        static {
            SuffixNumberMode r100 = new SuffixNumberMode("UnknownSuffix", 0);
            UnknownSuffix = r100;
            SuffixNumberMode r101 = new SuffixNumberMode("SingleSuffix", 1);
            SingleSuffix = r101;
            SuffixNumberMode r102 = new SuffixNumberMode("DoubleSuffix", 2);
            DoubleSuffix = r102;
            f147027a = new SuffixNumberMode[]{r100, r101, r102};
        }

        public static SuffixNumberMode valueOf(String r100) {
            return (SuffixNumberMode) r27.a.a(SuffixNumberMode.class, r100);
        }

        public static SuffixNumberMode[] values() {
            return (SuffixNumberMode[]) f147027a.clone();
        }

        public SuffixNumberMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "fixed_number")
    long getFixedNumber();

    @FieldName(name = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    long getGiftId();

    @FieldName(name = "index")
    long getIndex();

    @FieldName(name = "operate_type")
    long getOperateType();

    @FieldName(name = "suffix_number_mode")
    int getSuffixNumberMode();
}
