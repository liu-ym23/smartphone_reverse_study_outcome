package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\bg\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\fR\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IPaidLiveData;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IPaidLiveDataEx;", "", "getPaidType", "()I", "getPaidType$annotations", "()V", "paidType", "getViewRight", "getViewRight$annotations", "viewRight", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IPaidLiveData extends c<IPaidLiveData>, IPaidLiveDataEx {
    public static final int CREATE_AND_SELL_PERMISSION = 3;
    public static final int CREATE_PAID_LIVE_PERMISSION = 1;
    public static final Companion Companion = null;
    public static final int DATA_TYPE_PAID_CAMERA = 1;
    public static final int DATA_TYPE_PAID_ROOM = 0;
    public static final int DELIVERY_DONE = 1;
    public static final int DELIVERY_UNDONE = 0;
    public static final int NO_PERMISSION = 0;
    public static final int RIGHT_FRIEND = 3;
    public static final int RIGHT_HELP = 4;
    public static final int RIGHT_NONE = 0;
    public static final int RIGHT_PAID = 1;
    public static final int RIGHT_WHITE = 2;
    public static final int SELL_TICKET_PERMISSION = 2;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IPaidLiveData$Companion;", "", "()V", "CREATE_AND_SELL_PERMISSION", "", "CREATE_PAID_LIVE_PERMISSION", "DATA_TYPE_PAID_CAMERA", "DATA_TYPE_PAID_ROOM", "DELIVERY_DONE", "DELIVERY_UNDONE", "NO_PERMISSION", "RIGHT_FRIEND", "RIGHT_HELP", "RIGHT_NONE", "RIGHT_PAID", "RIGHT_WHITE", "SELL_TICKET_PERMISSION", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int CREATE_AND_SELL_PERMISSION = 3;
        public static final int CREATE_PAID_LIVE_PERMISSION = 1;
        public static final int DATA_TYPE_PAID_CAMERA = 1;
        public static final int DATA_TYPE_PAID_ROOM = 0;
        public static final int DELIVERY_DONE = 1;
        public static final int DELIVERY_UNDONE = 0;
        public static final int NO_PERMISSION = 0;
        public static final int RIGHT_FRIEND = 3;
        public static final int RIGHT_HELP = 4;
        public static final int RIGHT_NONE = 0;
        public static final int RIGHT_PAID = 1;
        public static final int RIGHT_WHITE = 2;
        public static final int SELL_TICKET_PERMISSION = 2;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "paid_type")
        public static /* synthetic */ void getPaidType$annotations() {
        }

        @FieldName(name = "view_right")
        public static /* synthetic */ void getViewRight$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "paid_type")
    int getPaidType();

    @FieldName(name = "view_right")
    int getViewRight();
}
