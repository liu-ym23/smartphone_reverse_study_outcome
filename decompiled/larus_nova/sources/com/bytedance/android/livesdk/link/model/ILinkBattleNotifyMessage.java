package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkBattleNotifyMessage;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/j0;", "", "getContent", "()Ljava/lang/String;", "getContent$annotations", "()V", "content", "", "getNotifyType", "()I", "getNotifyType$annotations", "notifyType", "", "getContinueSeconds", "()J", "getContinueSeconds$annotations", "continueSeconds", "BattleNotifyType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkBattleNotifyMessage extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.j0>, com.bytedance.android.livesdk.link.model.bridge.j0 {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkBattleNotifyMessage$BattleNotifyType;", "", "TypeUndefined", "TypeStarActivity", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BattleNotifyType extends Enum<BattleNotifyType> {
        public static final BattleNotifyType TypeStarActivity = null;
        public static final BattleNotifyType TypeUndefined = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BattleNotifyType[] f147041a = null;

        static {
            BattleNotifyType r100 = new BattleNotifyType("TypeUndefined", 0);
            TypeUndefined = r100;
            BattleNotifyType r101 = new BattleNotifyType("TypeStarActivity", 1);
            TypeStarActivity = r101;
            f147041a = new BattleNotifyType[]{r100, r101};
        }

        public static BattleNotifyType valueOf(String r100) {
            return (BattleNotifyType) r27.a.a(BattleNotifyType.class, r100);
        }

        public static BattleNotifyType[] values() {
            return (BattleNotifyType[]) f147041a.clone();
        }

        public BattleNotifyType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.j0, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.j0, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.j0, yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @FieldName(name = "content")
    String getContent();

    @FieldName(name = "continue_seconds")
    long getContinueSeconds();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "notify_type")
    int getNotifyType();

    @Override // com.bytedance.android.livesdk.link.model.bridge.j0
    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
