package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0014\u0015R\"\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPreviewIMExtend;", "Lvh7/c;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getIcon", "()Lpy/k;", "getIcon$annotations", "()V", "icon", "", "getMainTitle", "()Ljava/lang/String;", "getMainTitle$annotations", "mainTitle", "getSubTitle", "getSubTitle$annotations", "subTitle", "getExtra", "getExtra$annotations", "extra", "IMFeedPkPlayMode", "IMFeedPkViewState", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IPreviewIMExtend extends vh7.c<IPreviewIMExtend> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPreviewIMExtend$IMFeedPkPlayMode;", "", "PK", "VOTE", "SHELLCONFIG", "CONNECTION", "PVE", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum IMFeedPkPlayMode extends Enum<IMFeedPkPlayMode> {
        public static final IMFeedPkPlayMode CONNECTION = null;
        public static final IMFeedPkPlayMode PK = null;
        public static final IMFeedPkPlayMode PVE = null;
        public static final IMFeedPkPlayMode SHELLCONFIG = null;
        public static final IMFeedPkPlayMode VOTE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ IMFeedPkPlayMode[] f147060a = null;

        static {
            IMFeedPkPlayMode r100 = new IMFeedPkPlayMode("PK", 0);
            PK = r100;
            IMFeedPkPlayMode r101 = new IMFeedPkPlayMode("VOTE", 1);
            VOTE = r101;
            IMFeedPkPlayMode r102 = new IMFeedPkPlayMode("SHELLCONFIG", 2);
            SHELLCONFIG = r102;
            IMFeedPkPlayMode r103 = new IMFeedPkPlayMode("CONNECTION", 3);
            CONNECTION = r103;
            IMFeedPkPlayMode r104 = new IMFeedPkPlayMode("PVE", 4);
            PVE = r104;
            f147060a = new IMFeedPkPlayMode[]{r100, r101, r102, r103, r104};
        }

        public static IMFeedPkPlayMode valueOf(String r100) {
            return (IMFeedPkPlayMode) r27.a.a(IMFeedPkPlayMode.class, r100);
        }

        public static IMFeedPkPlayMode[] values() {
            return (IMFeedPkPlayMode[]) f147060a.clone();
        }

        public IMFeedPkPlayMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPreviewIMExtend$IMFeedPkViewState;", "", "Other", "PK", "PENAL", "LINK", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum IMFeedPkViewState extends Enum<IMFeedPkViewState> {
        public static final IMFeedPkViewState LINK = null;
        public static final IMFeedPkViewState Other = null;
        public static final IMFeedPkViewState PENAL = null;
        public static final IMFeedPkViewState PK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ IMFeedPkViewState[] f147061a = null;

        static {
            IMFeedPkViewState r100 = new IMFeedPkViewState("Other", 0);
            Other = r100;
            IMFeedPkViewState r101 = new IMFeedPkViewState("PK", 1);
            PK = r101;
            IMFeedPkViewState r102 = new IMFeedPkViewState("PENAL", 2);
            PENAL = r102;
            IMFeedPkViewState r103 = new IMFeedPkViewState("LINK", 3);
            LINK = r103;
            f147061a = new IMFeedPkViewState[]{r100, r101, r102, r103};
        }

        public static IMFeedPkViewState valueOf(String r100) {
            return (IMFeedPkViewState) r27.a.a(IMFeedPkViewState.class, r100);
        }

        public static IMFeedPkViewState[] values() {
            return (IMFeedPkViewState[]) f147061a.clone();
        }

        public IMFeedPkViewState(String r100, int r101) {
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

    @FieldName(name = "extra")
    String getExtra();

    @FieldName(name = "icon")
    py.k getIcon();

    @FieldName(name = BdpAppEventConstant.PARAMS_MAIN_TITLE)
    String getMainTitle();

    @FieldName(name = BdpAppEventConstant.PARAMS_SUB_TITLE)
    String getSubTitle();
}
