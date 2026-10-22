package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerInvitePrepareContentDef;", "", "count", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getCount$annotations", "()V", "getCount", "()J", "fromRoomId", "getFromRoomId$annotations", "getFromRoomId", "secFromUserId", "", "getSecFromUserId$annotations", "getSecFromUserId", "()Ljava/lang/String;", Constants.OperatorKey.KEY_VENDOR, "getVendor$annotations", "getVendor", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerInvitePrepareContentDef {

    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "count")
        public static /* synthetic */ void getCount$annotations() {
        }

        @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID)
        public static /* synthetic */ void getFromRoomId$annotations() {
        }

        @FieldName(name = "sec_from_user_id")
        public static /* synthetic */ void getSecFromUserId$annotations() {
        }

        @FieldName(name = Constants.OperatorKey.KEY_VENDOR)
        public static /* synthetic */ void getVendor$annotations() {
        }
    }

    long getCount();

    long getFromRoomId();

    String getSecFromUserId();

    long getVendor();
}
